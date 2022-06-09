package com.cloudnative.OTT.controller;

import com.cloudnative.OTT.domain.WishListRequest;
import com.cloudnative.OTT.jpa.entity.MovieDetails;
import com.cloudnative.OTT.jpa.entity.WishList;
import com.cloudnative.OTT.jpa.repository.MovieDetailRepository;
import com.cloudnative.OTT.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WishlistController {

  @Autowired
  private WishlistService wishlistService;


  @Autowired
  private MovieDetailRepository movieDetailRepository;


  @ResponseBody
  @RequestMapping(value = "/userId", method = RequestMethod.GET,
      headers = "Accept=application/json", produces = "application/json")
  public ResponseEntity<List<MovieDetails>> getWishList(@PathVariable("userId") String userId) {

    List<WishList> wishList = wishlistService.readWishList(userId);

    //create productDTO from productId in wishlist
    List<MovieDetails> movieDetails = new ArrayList<>();
    for (WishList wishLst : wishList) {
      movieDetails.add(wishlistService.createMovieListResponse(wishLst));
    }

    return new ResponseEntity<List<MovieDetails>>(movieDetails, HttpStatus.OK);
  }


  @ResponseBody
  @RequestMapping(value = "/addWishlist", method = RequestMethod.POST,
      headers = "Accept=application/json", produces = "application/json")
  public ResponseEntity<List<MovieDetails>> addWishList(@RequestBody WishListRequest wishListRequest) {

    WishList wishLst = new WishList();
    MovieDetails movie = movieDetailRepository.findById(wishListRequest.getId());
    wishLst.setUserId(wishListRequest.getUserId());
    wishLst.setMovieDetails(movie);
    wishlistService.createWishlist(wishLst);
    List<MovieDetails> movieDetails = movieDetailRepository.getAllMovies();
    return  new ResponseEntity<List<MovieDetails>>(movieDetails, HttpStatus.OK);

  }
}
