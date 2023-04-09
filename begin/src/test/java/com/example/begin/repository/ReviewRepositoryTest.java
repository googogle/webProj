package com.example.begin.repository;

import com.example.begin.entity.Books;
import com.example.begin.entity.Review;
import com.example.begin.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRepositoryTest {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    BookRepository bookRepository;

    @Test
    void jpqlTest() {
        var titles  = reviewRepository.findBookTitieByEmail("kavin");
        titles.ifPresent(System.out::println);
    }



}