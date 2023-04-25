package com.market.proj.marketProj.controller;


import com.google.gson.JsonObject;
import com.market.proj.marketProj.Entity.*;
import com.market.proj.marketProj.Service.*;
import com.market.proj.marketProj.dto.BiddingDTO;
import com.market.proj.marketProj.dto.ProductDTO;
import com.market.proj.marketProj.dto.UserDTO;
import com.market.proj.marketProj.repository.UserRepository;
import com.market.proj.marketProj.task.TransactionTask;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

@Transactional
@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value = "/")
public class PageController {
    private final KakaoService kakaoService;
    private final UserService userService;
    private final ProductService productService;
    private final UserRepository userRepository;
    private final BiddingService biddingService;
    private final TransactionService transactionService;
    private final ChatService chatService;

    @GetMapping(value = "/home" )
    public String home(Model model, HttpSession session){
        model.addAttribute("user", session.getAttribute("user"));
        List<Product> productEntityList = productService.findFirst12ByIsEndFalseOrderByCreatedAtDesc();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product p : productEntityList){
            List<String> productCategories = new ArrayList<>();
            for(Category cat : p.getProductCategories()){
                productCategories.add(cat.getCategoryName());
            }
            int topPrice = productService.getProductTopPrice(p.getIdx());
            ProductDTO dto = ProductDTO.EntityTODto(p);
            dto.setTopPrice(topPrice);
            dto.setProductCategories_s(productCategories);
            productDTOList.add(dto);
        }
        model.addAttribute("productList", productDTOList);
        return "/pages/home";
    }

    @GetMapping(value = "/kakao_loginForm")
    public String kakaoLoginForm(){
        return "/pages/kakao_loginForm";
    }

    @GetMapping(value = "/kakao_login")
    public String login(@RequestParam(value = "code") String code, HttpSession session) {
        Map<String, Object> tokens = kakaoService.getAccessTokenAndRefreshToken(code);
        JsonObject kakao_account = kakaoService.getUserKakaoAccount(tokens.get("access_token").toString());
        String email = kakaoService.getUserKakaoEmail(kakao_account);
        UserDTO userDto = userService.findUserByEmail(email);
        if (userDto == null) {
            String userNickname = kakaoService.getUserKakaoNickname(kakao_account);
            Long userId = kakaoService.getUserKakaoId(tokens.get("access_token").toString());
            User userEntity = User.builder().userEmail(email)
                    .userId(userId)
                    .userNickname(userNickname)
                    .accessToken(tokens.get("access_token").toString())
                    .refreshToken(tokens.get("refresh_token").toString())
                    .build();
            userDto = UserDTO.EntityTODto(userEntity);
            session.setAttribute("user", userDto);
            session.setAttribute("userEntity", userEntity);
            userService.saveUser(userEntity);
        }
        else {
            User userEntity = userRepository.findByUserEmail(userDto.getUserEmail());
            userService.updateTokensByUserId(userDto.getUserId(), tokens.get("access_token").toString(), tokens.get("refresh_token").toString());
            session.setAttribute("userEntity", userEntity);
            session.setAttribute("user", userDto);
        }
        return "redirect:/home";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session){
        UserDTO userDto = (UserDTO)session.getAttribute("user");
        Long userId = userDto.getUserId();
        String accessToken = userService.getAccessTokenByUserId(userId);
        kakaoService.logout(accessToken);
        userService.deleteTokensByUserId(userId);
        session.invalidate();
        return "redirect:/home";
    }

    @GetMapping(value = "/product_registration")
    public String productRegistrationForm(HttpSession session){
        UserDTO userDto = (UserDTO)session.getAttribute("user");
        if(userDto == null) return "redirect:/kakao_loginForm";
        else return "/pages/product_reg";
    }
    @PostMapping(value = "/product_registration")
    public String register(@RequestParam Map<String, Object> map, @RequestParam(value="categoryList") List<String> categories, @RequestParam(value="item_image") MultipartFile image, HttpSession session , Model model) throws SchedulerException, InterruptedException{
        log.info("PageController: Map : {}", map.toString());
        log.info("PageController: categories : {}", categories);
        log.info("PageController: image : {}", image);
        UserDTO userDto = (UserDTO)session.getAttribute("user");
        map.put("tick_price", (Integer.parseInt(map.get("start_price").toString()))/10);
        Product savedProduct = productService.saveProduct(categories, map, image, userDto);
        Long savedProductIdx = savedProduct.getIdx();
        LocalDateTime productEndTime = savedProduct.getEndTime();

        //JobDataMap은 Quartz에서 실행되는 Job에 Key-value 형식으로 값을 전달할수 있다.
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("productIdx", savedProduct.getIdx());
        jobDataMap.put("productService", productService);
        jobDataMap.put("biddingService", biddingService);
        jobDataMap.put("transactionService", transactionService);
        jobDataMap.put("chatService", chatService);

        JobDetail jobDetail = newJob(TransactionTask.class)
                //job Data 주입
                .usingJobData(jobDataMap)
                .build();
        Date date = Date.from(productEndTime.atZone(ZoneId.systemDefault()).toInstant());
        Trigger trigger = newTrigger()
                .startAt(date)
                .build();

        // 스케줄러 실행 및 JobDetail과 Trigger 정보로 스케줄링
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);

        String url = "redirect:/product_detail"+"?idx="+savedProductIdx;
        return url;
    }

    public void addTransactionTask(Product product) {
        log.info("TransactionScheduledTask: addTransactionTask()");
        log.info("TransactionScheduledTask: addTransactionTask.product : {}",product);

    }
    @GetMapping("/product_detail")
    public String detail(Model model, @RequestParam("idx") Long idx, HttpSession session){
        ProductDTO productDto = productService.findProductDTOById(idx);
        List<Category> list = productDto.getProductCategories();
        List<String> productCategories = new ArrayList<>();
        for(Category cat : list){
            productCategories.add(cat.getCategoryName());
            log.info("PageController: productCategory : {}", cat.getCategoryName());
        }
        log.info("PageController: productCategories : {}", productCategories);
        if(LocalDateTime.now().isAfter(productDto.getEndTime())){ model.addAttribute("isEnd", true); }
        else { model.addAttribute("isEnd", false); }
        model.addAttribute("user", session.getAttribute("user"));
        productDto.setTopPrice(productService.getProductTopPrice(productDto.getIdx()));
        model.addAttribute("product", productDto);
        session.setAttribute("productIdx", productDto.getIdx());
        model.addAttribute("productCategories", productCategories);
        return "/pages/product_detail";
    }

    @PostMapping(value = "/bidding")
    public String bidding(@RequestParam(name = "biddingPrice") int biddingPrice, HttpSession session , Model model){
        UserDTO userDto = (UserDTO)session.getAttribute("user");
        Long biddedUserIdx = userDto.getIdx();
        Product product = productService.findProductEntityById((Long)session.getAttribute("productIdx"));
        User biddedUser = userService.findUserEntityByIdx(biddedUserIdx);
        //log.info("PageController: bidding: productIdx = {}", (Long)session.getAttribute("productIdx"));
        //log.info("PageController: bidding: biddedUser = {}", biddedUser);
        //log.info("PageController: bidding: product = {}", product);
        //log.info("PageController: bidding: biddingPrice = {}", biddingPrice);
        if(product.getIsEnd()){ return "/pages/error_alreadyOver"; }
        Bidding userBiddedThisProduct = biddingService.findByProductIdxAndUserIdx(product.getIdx() ,biddedUserIdx);
        if(userBiddedThisProduct == null ) {
            Bidding bidding = Bidding.builder()
                    .biddingPrice(biddingPrice)
                    .user(biddedUser)
                    .product(product)
                    .endTime(product.getEndTime())
                    .build();
            biddingService.saveBidding(bidding);
            return "redirect:/myBidding";
        }
        if(userBiddedThisProduct.getBiddingPrice() < biddingPrice){
            userBiddedThisProduct.setBiddingPrice(biddingPrice);
            userBiddedThisProduct.setTime(LocalDateTime.now());
            biddingService.saveBidding(userBiddedThisProduct);
            return "redirect:/myBidding";
        }
        else { return "/pages/error_duplicatedBid"; }
    }


    @GetMapping(value = "/myBidding")
    public String myBidding(Model model, HttpSession session){
        if(session.getAttribute("user") == null) return "redirect:/kakao_loginForm";
        UserDTO userDto = (UserDTO)session.getAttribute("user");
        Long userIdx = userDto.getIdx();
        User userEntity = userRepository.findByIdx(userIdx);
        List<BiddingDTO> biddingDTOList = new ArrayList<>();
        for(Bidding bid: userEntity.getUserBidded()){
            boolean isSuccess = false;
            Product product = bid.getProduct();
            Transaction transaction = transactionService.findByTransactionBuyerIdxAndTransactionProductIdx(userEntity.getIdx(), product.getIdx());
            if(transaction!= null) {if(transaction.getTransactionBuyerIdx() == userEntity.getIdx()) isSuccess = true;}
            int topPrice = productService.getProductTopPrice(product.getIdx());
            BiddingDTO biddingDTO = BiddingDTO.builder().biddingPrice(bid.getBiddingPrice())
                    .idx(bid.getIdx())
                    .isEnd(product.getIsEnd())
                    .productIdx(product.getIdx())
                    .productName(product.getProductName())
                    .startPrice(product.getProductStartingPrice())
                    .biddedTime(bid.getTime())
                    .endTime(product.getEndTime())
                    .isSuccess(isSuccess)
                    .topPriceThisProduct(topPrice)
                    .build();
            biddingDTOList.add(biddingDTO);
        }
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("biddingList",biddingDTOList );
        return "/pages/myBidding";
    }

    @PostMapping(value = "/removeBid")
    public String removeBid(@RequestParam(value = "idx") Long bidIdx ,HttpSession session ){
        biddingService.removeByIdx(bidIdx);
        return "redirect:/myBidding";
    }

    @GetMapping(value = "/myProduct")
    public String myProduct(Model model, HttpSession session){
        if(session.getAttribute("user") == null) return "redirect:/kakao_loginForm";
        UserDTO tmp = (UserDTO)session.getAttribute("user");
        User user = userService.findUserEntityByIdx(tmp.getIdx());
        List<Product> productList = user.getUserProducts();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product p : productList) {
            ProductDTO pdto = ProductDTO.EntityTODto(p);
            List<Bidding> biddingList = p.getProductBidded();
            Transaction t = transactionService.findByProductIdx(p.getIdx());
            if(t != null){
                pdto.setBuyerIdx(t.getTransactionBuyerIdx());
            }
            int topPrice = 0;
            if(biddingList != null) {
                for (Bidding b : biddingList) {
                    if (topPrice < b.getBiddingPrice()) topPrice = b.getBiddingPrice();
                }
            }
            pdto.setTopPrice(topPrice);
            productDTOList.add(pdto);
        }

        model.addAttribute("productList", productDTOList);
        model.addAttribute("user", session.getAttribute("user"));

        return "/pages/myProduct";
    }

    @GetMapping(value = "/chatPage")
    public String chat(Model model, HttpSession session, @RequestParam(value = "productIdx") Long idx, @RequestParam(value = "userNickname") String userNickname){
        Transaction transaction = transactionService.findByProductIdx(idx);
        UserDTO user = (UserDTO) session.getAttribute("user");
        if(transaction == null) return "redirect:/home";
        if(user == null) return "redirect:/home";
        if(user.getIdx() == transaction.getTransactionBuyerIdx() || user.getIdx() == transaction.getTransactionSellerIdx()){
            model.addAttribute("chatRoomId", transaction.getChatRoomId());
            model.addAttribute("userNickname", userNickname);
            model.addAttribute("user", user);
            return "/pages/chatPage";
        }
        else return "redirect:/home";

    }

}
