package com.triple.Service;

import com.triple.Repository.PlaceRepository;
import com.triple.domain.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;


    public List<Place> findPlaces(){
        return placeRepository.findAll();
    }

    public Optional<Place> findById(Long placeId){return placeRepository.findById(placeId);}
}
