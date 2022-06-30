package com.triple.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "place")
public class Place {

    @Id @GeneratedValue
    @Column(name = "place_id")
    private Long id;
    private String placename;

    //@JsonBackReference
    //@OneToMany(mappedBy = "place",
    //fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //private List<Review> review;

    @Builder
    public Place(String placename){this.placename = placename;}

    public Place(){}

}
