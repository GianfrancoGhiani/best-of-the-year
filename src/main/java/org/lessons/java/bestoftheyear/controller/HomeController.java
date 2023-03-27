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
    public String getMovie(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes){
        for (Movie m: getBestMovies()) {
            if (m.getId() == id){
                model.addAttribute("mediaId", m.getId());
                model.addAttribute("mediaTitle", m.getTitle());
                model.addAttribute("movieDirector", m.getDirector());
                model.addAttribute("movieDuration", m.getMinDuration());
            } else{
                redirectAttributes.addFlashAttribute("message", "You was serching for a not listed movie pls retry");
                return "redirect:/movies";
            }
        }

        return "singleMedia";
    }
    @GetMapping("/songs/{id}")
    public String getSong(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes){
        for (Song s: getBestSongs()) {
            if (s.getId() == id){
                model.addAttribute("mediaId", s.getId());
                model.addAttribute("mediaTitle", s.getTitle());
                model.addAttribute("songArtist", s.getArtist());
            } else{
                redirectAttributes.addFlashAttribute("message", "You was serching for a not listed song pls retry");
                return "redirect:/songs";
            }
        }

        return "singleMedia";
    }
}
