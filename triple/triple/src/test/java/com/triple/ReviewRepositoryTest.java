package com.triple;


import com.triple.Repository.ReviewRepository;
import com.triple.domain.Member;
import com.triple.domain.Place;
import com.triple.domain.Review;
import com.triple.domain.Type;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void save(){

        Review review = new Review("good","1234", Type.REVIEW, new Member("qq","1234"), new Place("안중"));

        Review savedReview = reviewRepository.save(review);

        Optional<Review> findReview = reviewRepository.findById(review.getId());

        Review review1 = findReview.get();

        Assertions.assertThat(review1.getId()).isEqualTo(savedReview.getId());
    }

}
