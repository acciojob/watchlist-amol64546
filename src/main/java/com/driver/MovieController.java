package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String response = movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity addMovie(@RequestBody Director dir){
        String response = movieService.addDirector(dir);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/add-movie-director-pair")
    public ResponseEntity addMovie(@RequestParam("movieName") String movie, @RequestParam("director") String dir){
        String response = movieService.addMovieDirectorPair(movie,dir);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String movie){
        Movie response = movieService.getMovieByName(movie);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String dir){
        Director response = movieService.getDirectorByName(dir);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String dir){
        List<String> response = movieService.getMovieByDirectorName(dir);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        List<String> response = movieService.findAllMovies();
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("directorName") String dir){
        String response = movieService.deleteDirectorByName(dir);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        String response = movieService.deleteAllDirectors();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

}
