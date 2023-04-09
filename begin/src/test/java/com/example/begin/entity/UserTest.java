package com.example.begin.entity;

import com.example.begin.repository.UserRepository;
import net.bytebuddy.implementation.bytecode.StackSize;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void userAddTest() {
        var user = User.builder().userId("coolmax2")
                .userPw("1234")
//                .createdAt(LocalDateTime.now())
//                .updatedAt(LocalDateTime.now())
                .addr("newyork street 13st")
                .nick("developer")
                .build();

        user = userRepository.save(user);
        System.out.println(user);


    }

    @Test
    void findUserTest() {
        var optionalUser = userRepository.findById(2L);

        optionalUser.ifPresent(System.out::println);

    }

    @Test
    void showMyFoods(){
        var user = userRepository.findById(2L);
        //List<MyFood> myFoodList = user.get().getFoods();
        System.out.println(user.get().toString());
        /*for(MyFood mf : myFoodList){
            System.out.println(mf.toString());
        }*/
    }

}