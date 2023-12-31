package com.bourasi.moviedataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourasi.moviedataservice.models.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResources {
    
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,4);
    }

}
