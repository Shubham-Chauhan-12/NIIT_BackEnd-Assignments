package org.moviesdata.domain;

public class Movie {
    private String movieTitle;
    private String genre;
    private String language;
    private float rating;
    private String releaseDate;
    private String duration;
    private int price;

    public Movie(String movieTitle, String genre, String language, float rating, String releaseDate, String duration, int price) {
        this.movieTitle = movieTitle;
        this.genre = genre;
        this.language = language;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.price = price;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieTitle='" + movieTitle + '\'' +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                ", rating=" + rating +
                ", releaseDate='" + releaseDate + '\'' +
                ", duration='" + duration + '\'' +
                ", price=" + price +
                '}';
    }
}
