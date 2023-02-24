package com.driver;

import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class MovieRepository {

    Map<String,Movie> movieMap;
    Map<String,Director> directorMap;
    Map<String, List<String>> pairMap;

    public MovieRepository() {
        this.movieMap = new HashMap<>();
        this.directorMap = new HashMap<>();
        this.pairMap = new HashMap<>();
    }

    public String addMovie(Movie movie){
        String name = movie.getName();
        if(!movieMap.containsKey(name)){
            movieMap.put(name,movie);
        }
        return "Movie added successfully";
    }

    public String addDirector(Director dir){
        String name = dir.getName();
        if(!directorMap.containsKey(name)){
            directorMap.put(name,dir);
        }
        return "Director added successfully";
    }

    public String addMovieDirectorPair(String movieName,String directorName){
        if(!movieMap.containsKey(movieName) || !directorMap.containsKey(directorName)){
            return "Movie or Director not found in data base";
        }

        if(pairMap.containsKey(directorName)){
            pairMap.get(directorName).add(movieName);
        }else{
            List<String> list = new ArrayList<>();
            list.add(movieName);
            pairMap.put(directorName,list);
        }
        return "Movie-Director Pair added successfully";
    }

    public Movie getMovieByName(String name){
        if(!movieMap.containsKey(name))
            return null;
        return movieMap.get(name);
    }

    public Director getDirectorByName(String name){
        if(!directorMap.containsKey(name))
            return null;
        return directorMap.get(name);
    }

    public List<String> getMoviesByDirectorName(String dir){
        return pairMap.get(dir);
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public String deleteDirectorByName(String dir){
        List<String> movies = pairMap.get(dir);
        pairMap.remove(dir);
        for(String s: movies){
            if(movieMap.containsKey(s))
                movieMap.remove(s);
        }
        if(directorMap.containsKey(dir))
            directorMap.remove(dir);
        return "Director and its movies removed successfully";
    }

    public String deleteAllDirectors(){
        for(String dir: pairMap.keySet()){
            for(String movie: pairMap.get(dir)){
                if(movieMap.containsKey(movie))
                    movieMap.remove(movie);
            }
        }
        pairMap.clear();
        directorMap.clear();

        return "All directors and all of their movies removed successfully";
    }
}
