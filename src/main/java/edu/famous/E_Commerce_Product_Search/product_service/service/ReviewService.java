package edu.famous.E_Commerce_Product_Search.product_service.service;

import edu.famous.E_Commerce_Product_Search.product_service.dto.request.ReviewRequestDto;

import java.util.List;

public interface ReviewService {
    // Define methods for review operations
    void addReview(ReviewRequestDto reviewRequestDto);
    void updateReview(ReviewRequestDto reviewRequestDto);
    void deleteReview(Long reviewId);
    String getReviewById(Long reviewId);
    List<String> getReviewsByProductId(Long productId);
    List<String> getAllReviews();
}
