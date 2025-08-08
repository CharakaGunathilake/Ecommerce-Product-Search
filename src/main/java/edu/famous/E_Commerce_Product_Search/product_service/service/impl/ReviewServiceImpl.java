package edu.famous.E_Commerce_Product_Search.product_service.service.impl;

import edu.famous.E_Commerce_Product_Search.product_service.dto.request.ReviewRequestDto;
import edu.famous.E_Commerce_Product_Search.product_service.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    @Override
    public void addReview(ReviewRequestDto reviewRequestDto) {

    }

    @Override
    public void updateReview(ReviewRequestDto reviewRequestDto) {

    }

    @Override
    public void deleteReview(Long reviewId) {

    }

    @Override
    public String getReviewById(Long reviewId) {
        return "";
    }

    @Override
    public List<String> getReviewsByProductId(Long productId) {
        return List.of();
    }

    @Override
    public List<String> getAllReviews() {
        return List.of();
    }
}
