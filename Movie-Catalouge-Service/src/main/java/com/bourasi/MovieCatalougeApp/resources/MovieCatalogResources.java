package com.bourasi.MovieCatalougeApp.resources;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bourasi.MovieCatalougeApp.models.CatalogItem;
import com.bourasi.MovieCatalougeApp.models.Movie;
import com.bourasi.MovieCatalougeApp.models.Rating;

/*
    RequestMapping is used for req on server 
    if anyone hit this path /catalog spring just load the MovieCatalogResources class
*/
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {
    /*
     * autowired just search a bean in spring holds of type RestTemplate for example
     * here and inject it.
     * Autowired is Consumer U are telling Spring annotors give me something of type
     * this. and Bean is Consumer it tell spring execute me and somewhere need me
     * give it to them,
     * if two bean are same type we should tag the bean because spring confused and throw error at time of autowired
     * 
     */
    @Autowired
    private RestTemplate restTemplate;

    // here catalogItem is model can be instances, it is for each user
    /*
     * Now someone call /catalog/{userId},
     * spring boot loads this method and return this method as response
     * then Spring boot dont know the input comes what it is TheRequestParam,
     * so for understanding and us the userId as params in getCatalog method use
     * PathVariable("userId")
     */
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        /*
         * So, here is the Question how we call the Rest api from the code?
         * 
         * Here in spring boot comes with client already,
         * in your class Path --- RestTemplate
         */
        // RestTemplate restTemplate = new RestTemplate();
        // instead of using this syntax use Bean cuz this will execute each time
        // whenever a user call this method

        // get all rated movie IDs
        // we just use dummy rating data for call another microservice
        // we apply this dummy data as client to our another microservice, apply random
        // rating to random movies on their IDs
        List<Rating> dummyRatingData = Arrays.asList(
                new Rating("1234", 4),
                new Rating("2345", 5),
                new Rating("3456", 2));

        // for each movie ID, call Movie Info service and get details
        return dummyRatingData.stream().map(rating -> {
            // get the movie with the ID
            /*
             * IMPORTANT: whengetForObject extract the data and create an instance of object
             * its needed a empty constructor
             * 
             * Note: why we are extract it and convert it to an object cuz res comes into
             * json or text or some sort of string but java needs object to be worked one
             * thats why this method is very helpful getForObject
             */
            Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
            // return catalog with apply rating
            return new CatalogItem(movie.getName(), "Test Desc", rating.getMovieRating());
        }).collect(Collectors.toList());

        // put them all together

        // Hardcoded code
        // return Collections.singletonList(
        // new CatalogItem("3 Idiots", "Great Movie", 4));
    }
}