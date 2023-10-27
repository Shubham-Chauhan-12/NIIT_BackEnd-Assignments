package org.moviesdata;

import org.moviesdata.config.movieConfig;
import org.moviesdata.domain.Movie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(movieConfig.class);
        Movie mov1 = (Movie)context.getBean("movie1");
        System.out.println("Movie details : "+mov1);

        Movie mov2 = (Movie)context.getBean("movie2");
        System.out.println("Movie details : "+mov2);

        Movie mov3 = (Movie)context.getBean("movie3");
        System.out.println("Movie details : "+mov3);

        Movie mov4 = (Movie)context.getBean("movie4");
        System.out.println("Movie details : "+mov4);
    }
}
