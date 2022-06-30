package com.triple.dto;

import com.triple.domain.Member;
import com.triple.domain.Place;
import com.triple.domain.Review;
import com.triple.domain.Type;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
public class ReviewDto {

    private Long id;
    private String content;
    private String photoids;
    private Type type;

    private Member member;
    private Place place;

    @Builder
    public ReviewDto(String content, String photoids, Type type, Member member, Place place){
        this.content = content;
        this.photoids = photoids;
        this.type = type;
        this.member = member;
        this.place = place;
    }

    public Review toEntity(){
        return Review.builder()
                .content(content)
                .photoids(photoids)
                .type(type)
                .member(member)
                .place(place)
                .build();
    }
}
