package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
        return movieRepository.addMovie(movie);
    }
    public String addDirector(Director dir){
        return movieRepository.addDirector(dir);
    }

    public String addMovieDirectorPair(String movie,String dir){
        return movieRepository.addMovieDirectorPair(movie,dir);
    }

    public Movie getMovieByName(String movie){
        return movieRepository.getMovieByName(movie);
    }
    public Director getDirectorByName(String dir){
        return movieRepository.getDirectorByName(dir);
    }
    public List<String> getMovieByDirectorName(String dir){
        return movieRepository.getMoviesByDirectorName(dir);
    }
    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public String deleteDirectorByName(String dir){
        return movieRepository.deleteDirectorByName(dir);
    }

    public String deleteAllDirectors(){
        return movieRepository.deleteAllDirectors();
    }
}
