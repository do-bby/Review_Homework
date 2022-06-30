package com.triple;

import com.triple.Service.ReviewService;
import com.triple.domain.Member;
import com.triple.domain.Place;
import com.triple.domain.Review;
import com.triple.dto.ReviewDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.StreamingHttpOutputMessage;

import java.util.Optional;

import static com.triple.domain.Type.REVIEW;

@SpringBootTest

public class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;

    @Test
    void save(){
        ReviewDto reviewDto1 = new ReviewDto("good","1234",REVIEW,new Member("abc","1234"),new Place("제주"));

        Review savedReview = reviewService.createReview(reviewDto1);

        Optional<Review> findReview = reviewService.findById(savedReview.getId());

        Review review = findReview.get();

        Assertions.assertThat(review.getId()).isEqualTo(savedReview.getId());

    }

    @Test
    void point(){
        Member member1 = new Member("aaa","1234");
        Member member2 = new Member("abc","12345");

        ReviewDto reviewDto1 = new ReviewDto("good","1234",REVIEW,new Member("aaa","1234"),new Place("제주"));
        Review savedReview = reviewService.createReview(reviewDto1);
        Long memberA = savedReview.getMember().getPoint();

        reviewService.deleteReview(savedReview, savedReview.getId());

        Long memberB = savedReview.getMember().getPoint();

        Assertions.assertThat(memberB).isEqualTo(memberA);
    }


    @Test
    void update(){

        ReviewDto reviewDto1 = new ReviewDto("good","1234",REVIEW,new Member("abc","1234"),new Place("제주"));

        Review savedReview = reviewService.createReview(reviewDto1);

        savedReview.setContent("bad");
        savedReview.setPhotoids("1111");

        Review updatedReview = reviewService.updateReview(savedReview, savedReview.getId());

        Assertions.assertThat(updatedReview.getContent()).isEqualTo("bad");

    }


}
