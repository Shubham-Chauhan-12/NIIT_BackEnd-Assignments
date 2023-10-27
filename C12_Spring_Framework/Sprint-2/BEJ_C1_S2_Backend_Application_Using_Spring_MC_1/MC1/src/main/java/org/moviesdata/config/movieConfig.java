package org.moviesdata.config;

import org.moviesdata.domain.Movie;
import org.springframework.context.annotation.Bean;

public class movieConfig {

    @Bean("movie1")
    public Movie getMovieDetail1(){
        return new Movie("The Godfather","Action","English,Hindi",9.5f,"10/5/1972","175 min",399);
    }

    @Bean("movie2")
    public Movie getMovieDetail2(){
        return new Movie("The Dark Knight","Thrill","English",9.0f,"9/3/2008","140 min",499);
    }

    @Bean("movie3")
    public Movie getMovieDetail3(){
        return new Movie("Star Wars: Episode IV - A New Hope","Action","English",9.2f,"4/3/1997","178 min",449);
    }

    @Bean("movie4")
    public Movie getMovieDetail4(){
        return new Movie("Interstellar","Adventure","English,Hindi",9.4f,"7/10/2014","148 min",399);
    }
}

