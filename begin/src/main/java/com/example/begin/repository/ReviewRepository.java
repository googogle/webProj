package com.example.begin.repository;

import com.example.begin.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "select r.books.title from Review r where r.user.userId = :userId")
    Optional<List<String>> findBookTitieByEmail(@Param("userId") String userId);
    @Query(value = "select r from Review r where r.user.userId= :userid")
    Optional<List<Review>> findReviewsByuserId(@Param("userid") String userId);

}
