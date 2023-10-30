package com.movierestapi.Controller;

import com.movierestapi.Domain.Movie;
import com.movierestapi.Service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    private IMovieService iMovieService;

    @Autowired
    public MovieController(IMovieService iMovieService) {
        this.iMovieService = iMovieService;
    }

    @PostMapping("/saveMovie-details")
    public ResponseEntity<?> saveMovieData(@RequestBody Movie movie){
        return new ResponseEntity<>(iMovieService.saveMovieDetails(movie), HttpStatus.CREATED);
    }
}
