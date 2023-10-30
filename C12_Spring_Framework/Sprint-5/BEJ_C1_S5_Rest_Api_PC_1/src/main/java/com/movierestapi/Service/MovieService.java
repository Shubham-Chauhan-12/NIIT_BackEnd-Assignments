package com.movierestapi.Service;

import com.movierestapi.Domain.Movie;
import com.movierestapi.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService implements IMovieService{

    @Autowired
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public Movie saveMovieDetails(Movie movie) {
        return movieRepository.save(movie);
    }
}
