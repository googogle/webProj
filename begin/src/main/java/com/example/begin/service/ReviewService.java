package com.example.begin.service;

import com.example.begin.dto.ReviewDto;
import com.example.begin.dto.UserDto;
import com.example.begin.entity.Review;
import com.example.begin.entity.User;
import com.example.begin.repository.BookRepository;
import com.example.begin.repository.ReviewRepository;
import com.example.begin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Transactional
    public List<ReviewDto> findReviews(String userId){
        ArrayList<ReviewDto> reviewsDTO = new ArrayList<>();
        var reviews = reviewRepository.findReviewsByuserId(userId);
    if(reviews.isPresent() && reviews.get().size()>0){
        reviews.get().forEach(r->{
            var dto = entityToDto(r);
            reviewsDTO.add(dto);
        });
    }
    return reviewsDTO;
    }

    private ReviewDto entityToDto(Review review) {
        var dto = ReviewDto.builder().idx(review.getIdx())
                .title(review.getTitle())
                .contents(review.getContents())
                .userId(review.getUser().getUserId())
                .useridx(review.getUser().getIdx())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .bookIdx(review.getBooks().getIdx())
                .build();
        return dto;
    }

    private Review dtoToEntity(ReviewDto reviewDto) {
        var optUser = userRepository.findByUserId(reviewDto.getUserId()).get();
        var optBook = bookRepository.findById(reviewDto.getBookIdx()).get();

        var entity = Review.builder().idx(reviewDto.getIdx())
                .title(reviewDto.getTitle())
                .contents(reviewDto.getContents())
                .books(optBook)
                .user(optUser)
                .build();
        return entity;
    }

}
