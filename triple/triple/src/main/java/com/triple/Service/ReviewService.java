package com.triple.Service;

import com.triple.Repository.MemberRepository;
import com.triple.Repository.ReviewRepository;
import com.triple.domain.Member;
import com.triple.domain.Review;
import com.triple.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private static Long point = 0L;

    public List<Review> findAll(){return reviewRepository.findAll();}

    public Optional<Review> findById(Long reviewId){return reviewRepository.findById(reviewId);}

    public Review createReview(ReviewDto reviewdto){
        Review review = new Review();
        BeanUtils.copyProperties(reviewdto,review);
        List<Review> reviewList = reviewRepository.findAll();
        Member member = review.getMember();
        if(reviewList.isEmpty()){
            member.setPoint(point+=2); // 리뷰 작성 시 +1, 리뷰 리스트가 비어있다면, 즉 첫 리뷰라면 추가로 +1
        }
        else {
            member.setPoint(++point); //리뷰 작성 시 +1
        }
        //리뷰를 비교했을 때 리뷰의 멤버아이디가 같지 않고, 리뷰의 장소아이디가 같지 않아야한다.중복제거? review list -> set 사용?

        return reviewRepository.save(review);
    }

    public Review updateReview(Review updateReview, Long reviewId){
        Optional<Review> findReview = reviewRepository.findById(reviewId);
        if(!findReview.isPresent()){
            throw new EntityNotFoundException("not present"); //업데이트 할 리뷰가 없을 때 예외처리
        }
        Review review = findReview.get();
        review.setContent(updateReview.getContent());
        review.setPhotoids(updateReview.getPhotoids());
        return reviewRepository.save(review);
    }

    public void deleteReview(Review review, Long reviewId){
        Member member = review.getMember();
        member.setPoint(--point);   //리뷰 삭제시 포인트 감소
        reviewRepository.deleteById(reviewId);
    }

}
