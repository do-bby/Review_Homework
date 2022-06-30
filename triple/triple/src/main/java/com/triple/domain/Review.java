package com.triple.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter

@Table(name="review")
public class Review {
    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    private String content;

    private String photoids;

    @Enumerated(EnumType.STRING)
    private Type type;

    //@JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_m")
    private Member member;

    //@JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_p")
    private Place place;


    @Builder
    public Review(String content, String photoids, Type type, Member member, Place place){
        this.content = content;
        this.photoids = photoids;
        this.type = type;
        this.member = member;
        this.place = place;
    }


    public Review(){}
}
