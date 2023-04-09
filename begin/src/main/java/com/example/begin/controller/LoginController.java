package com.example.begin.controller;

import com.example.begin.dto.FoodResDto;
import com.example.begin.dto.UserDto;
import com.example.begin.entity.MyFood;
import com.example.begin.entity.User;
import com.example.begin.repository.UserRepository;
import com.example.begin.service.MyfoodService;
import com.example.begin.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Transactional
@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value = "/")
public class LoginController {
    public final UserService userService;
    public final MyfoodService myfoodService;
    public final UserRepository userRepository;
    @PostMapping(value = "/login")
    public String signIn(UserDto userDto, HttpSession session){
        var loggedInUser = userService.login(userDto);
        if(loggedInUser != null) {
            log.info("login success : {}", loggedInUser.toString());
            session.setAttribute("user", loggedInUser);
            return "redirect:/engine/home";
        }
        else return "redirect:/engine/error";
    }

    @GetMapping(value = "/login")
    public String loginProc(){
        return "/engine/loginForm";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/engine/home";
    }

    @GetMapping(value = "/removemyfood")
    public String removeMyFood(@RequestParam("idx") Long idx){
        log.info("*************idx : {}", idx.toString());
        myfoodService.deleteMyFood(idx);


        return "redirect:/engine/home";
    }

    @PostMapping(value = "/addmylist")
    public String addmylist(@RequestParam("title") String title,@RequestParam("category") String category , @RequestParam("roadAddr") String roadAddr, HttpSession session){
        log.info("*************addmylist called");
        log.info("title : {} category : {} roadAddr : {}", title, category, roadAddr);
        var userEntity = userService.DtoToEntity((UserDto) session.getAttribute("user"));
        userEntity = userService.saveUser(userEntity);
        var myfood = MyFood.builder().title(title).category(category).roadAddress(roadAddr).user(userEntity).build();
        log.info("created myFood : {}", myfood);
        myfoodService.addmyfood(myfood);
        return "redirect:/engine/home";
    }

    @GetMapping(value = "/tttest/{userId}")
    public String tttest(@PathVariable Long userId){
        var user = userRepository.findById(userId);
        var foods = user.get().getFoods();
        for(MyFood mf : foods){
            log.info(mf.toString());
        }
        return "/engine/home";
    }

}

