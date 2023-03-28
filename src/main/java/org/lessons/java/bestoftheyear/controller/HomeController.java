package org.lessons.java.bestoftheyear.controller;

import org.lessons.java.bestoftheyear.model.Movie;
import org.lessons.java.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        movieList.add(new Movie(1,"Interstellar",147, "Nolan"));
        movieList.add(new Movie(2,"Memento",123, "Nolan"));
        movieList.add(new Movie(3,"Inception",169, "Nolan"));
        movieList.add(new Movie(4,"Batman Returns",133, "Tim Burton"));
        return movieList;
    }
    private List<Song> getBestSongs(){
        List<Song> songList = new ArrayList<>();
        songList.add(new Song(1,"Cenere", "Lazza"));
        songList.add(new Song(2,"Made in Italy", "Rosa Chemical"));
        songList.add(new Song(3,"Due Vite", "Cesare Cremonini"));
        songList.add(new Song(4,"La guerra di Piero", "De Andrè"));
        songList.add(new Song(5,"Bocca di Rosa", "De Andrè"));
        return  songList;
    }

    @GetMapping("/movies")
    public String getMovieList(Model model){
        model.addAttribute("movies",getBestMovies());
        return "movies";
    }
    @GetMapping("/songs")
    public String getSongList(Model model){
        model.addAttribute("songs",getBestSongs());
        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String getMovie(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes){
        Movie singleMovie = getBestMovies().stream().filter((movie -> movie.getId() == id)).findFirst().orElse(null);
        if (singleMovie != null){
                model.addAttribute("movie", singleMovie);
        } else{
                redirectAttributes.addFlashAttribute("message", "You was serching for a not listed movie pls retry");
                return "redirect:/movies";
        }


        return "singleMovie";
    }
    @GetMapping("/songs/{id}")
    public String getSong(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes){
        Song singleSong = getBestSongs().stream().filter((song -> song.getId() == id)).findFirst().orElse(null);
        if (singleSong != null){
                model.addAttribute("song", singleSong);
        } else{
                redirectAttributes.addFlashAttribute("message", "You was serching for a not listed song pls retry");
                return "redirect:/songs";
        }


        return "singleSong";
    }
}
