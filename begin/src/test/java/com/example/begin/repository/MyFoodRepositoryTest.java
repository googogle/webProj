package com.example.begin.repository;

import ch.qos.logback.core.CoreConstants;
import com.example.begin.entity.MyFood;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyFoodRepositoryTest {

    @Autowired
    MyFoodRepository myFoodRepository;

    @Autowired UserRepository userRepository;

    @Rollback(value = false)
    @Transactional
    @Test
    void addFoodTest(){
        var findUser = userRepository.findById(1L).orElseThrow();
        var myfood = MyFood.builder().title("비빔국수").category("한식>국수").roadAddress("대구").user(findUser).build();

        System.out.println(myFoodRepository.save(myfood));
    }

    @Test
    @Transactional
    void findMyFoodTest(){
        var findUser = userRepository.findById(1L).orElseThrow();
        findUser.getFoods().forEach(System.out::println);
    }
}