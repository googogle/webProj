package com.example.begin.controller;

import com.example.begin.dto.FoodResDto;
import com.example.begin.dto.MyFoodDto;
import com.example.begin.dto.UserDto;
import com.example.begin.naverAPI.dto.LocalSearchReqDTO;
import com.example.begin.service.MyfoodService;
import com.example.begin.service.NaverService;
import com.example.begin.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value = "/engine")
public class ViewsController {
    private final UserService userService;
    private final NaverService naverService;
    private final MyfoodService myfoodService;

    @GetMapping(value = "/ex1")
    public void ex1(){

    }

    @GetMapping(value = "/ref")
    public void ref(@RequestParam String uid, Model model){
        log.info("a tag uid : {}", uid);
        model.addAttribute("result",uid);
    }

    @GetMapping(value = "/ref2/{param1}/{param2}")
    public String ref2(@PathVariable String param1, @PathVariable String param2, Model model){
        log.info("param1 : {}   param2 : {}", param1, param2);
        model.addAttribute("userid", param1);
        model.addAttribute("passwd", param2);
        return "/engine/ref2";
    }

    @GetMapping(value = "/ex2")
    public void ex2(Model model){
        var usersDto = userService.findAllUser();
        model.addAttribute("list", usersDto);
    }

    @GetMapping(value = "/redirect")
    public String redirect(RedirectAttributes redirectAttributes){
        UserDto dto = UserDto.builder()
                .idx(4L)
                .nick("redirectUser")
                .userId("id")
                .userPw("112233")
                .build();

        redirectAttributes.addFlashAttribute("result","OK");
        redirectAttributes.addFlashAttribute("user",dto);
        redirectAttributes.addAttribute("key","keyValue");
        return "redirect:/engine/ex3";
    }

    @GetMapping(value = "/ex3")
    public void ex3(@RequestParam String key, Model model){
        log.info("---ex3---");
        model.addAttribute("key", key);
    }



    @GetMapping(value = "/ex-layout")
    public void exLayout(){

    }

    @GetMapping(value = "/home")
    public void home(HttpSession session, Model model, RedirectAttributes red) {
        UserDto user = (UserDto) session.getAttribute("user");
        var foodResDto = (FoodResDto)red.getAttribute("foodData");
        if(foodResDto != null) model.addAttribute("foodData" ,foodResDto);
        if (user != null) {
            model.addAttribute("user", user);
            var list = myfoodService.findMyFood(user.getIdx());
            if (list != null) {
                model.addAttribute("myfoods", list);
                session.setAttribute("myfoods", list);
            }
        }
    }


    @GetMapping(value = "/localsearch")
    public String localSearch(@RequestParam String searchKeyword , Model model, HttpSession session, RedirectAttributes red){
        var foodResDto = naverService.search(searchKeyword);
        var user = (UserDto)session.getAttribute("user");

        red.addFlashAttribute("foodData", foodResDto);

        return "redirect:/engine/home";
    }

    @GetMapping(value = "/error")
    public void err(){

    }


}
