package com.triple.api;

import com.triple.Service.MemberService;
import com.triple.Service.ReviewService;
import com.triple.domain.Member;
import com.triple.domain.Review;
import com.triple.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class ReviewApiController {


    private final MemberService memberService;
    private final ReviewService reviewService;

    //멤버 조회(point 조회)
    @GetMapping("/points/{memberId}")
    public Optional<Member> memberInfo(@PathVariable Long memberId){
        Optional<Member> findMember= memberService.findById(memberId);
        return findMember;
    }

    //리뷰 작성 이벤트
    @PostMapping(value = "/events")
    public ResponseEntity<Review> ReviewEvent(@RequestBody ReviewDto reviewdto){
        return ResponseEntity.ok(reviewService.createReview(reviewdto));
    }

    //리뷰 조회
    @GetMapping("/events/{reviewId}")
    public Optional<Review> ReadReview(@PathVariable Long reviewId){
        return reviewService.findById(reviewId);
    }


    //리뷰 삭제
    @DeleteMapping(("/events/{reviewId}"))
    public void DeleteReview(@RequestBody Review review,@PathVariable Long reviewId){
        reviewService.deleteReview(review, reviewId);
    }


    //리뷰 수정
    @PatchMapping("/events/{reviewId}")
    public Review updateReview(@RequestBody Review review, @PathVariable Long reviewId){
        return reviewService.updateReview(review,reviewId);
    }

}
