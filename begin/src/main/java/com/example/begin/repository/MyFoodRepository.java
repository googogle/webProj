package com.example.begin.repository;

import com.example.begin.entity.MyFood;
import com.example.begin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyFoodRepository extends JpaRepository<MyFood, Long> {
    Optional<List<MyFood>> findByUserIdx(Long idx);
    void deleteByIdx(Long idx);


}
