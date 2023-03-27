package org.lessons.java.bestoftheyear.controller;

import org.lessons.java.bestoftheyear.model.Movie;
import org.lessons.java.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home(Model model){
        model.addAttribute("name", "Gianfranco Ghiani");
        return "home";
    }

    private List<Movie> getBestMovies(){
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie(1,"Interstellar"));
        movieList.add(new Movie(2,"Memento"));
        movieList.add(new Movie(3,"Inception"));
        movieList.add(new Movie(4,"Batman Returns"));
        return movieList;
    }
    private List<Song> getBestSongs(){
        List<Song> songList = new ArrayList<>();
        songList.add(new Song(1,"Cenere"));
        songList.add(new Song(2,"Made in Italy"));
        songList.add(new Song(3,"Due Vite"));
        songList.add(new Song(4,"La guerra di Piero"));
        songList.add(new Song(5,"Bocca di Rosa"));
        return  songList;
    }

    @GetMapping("/movies")
    public String getMovieList(Model model){
        String movieString = "";
        for (Movie m: getBestMovies()) {
            movieString += m.toString() + " / ";
        }
        movieString = movieString.substring(0,movieString.length() - 2);
        model.addAttribute("movies",movieString);
        return "movies";
    }
    @GetMapping("/songs")
    public String getSongList(Model model){
        String songString = "";
        for (Song s: getBestSongs()) {
            songString += s.toString() + " / ";

        }
        songString = songString.substring(0, songString.length() - 2);
        model.addAttribute("songs",songString);
        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String getMovie(@PathVariable("id") int id, Model model){
        for (Movie m: getBestMovies()) {
            if (m.getId() == id){
                model.addAttribute("mediaId", m.getId());
                model.addAttribute("mediaTitle", m.getTitle());
            }
        }

        return "singleMedia";
    }
    @GetMapping("/songs/{id}")
    public String getSong(@PathVariable("id") int id, Model model){
        for (Song s: getBestSongs()) {
            if (s.getId() == id){
                model.addAttribute("mediaId", s.getId());
                model.addAttribute("mediaTitle", s.getTitle());
            }
        }

        return "singleMedia";
    }
}
