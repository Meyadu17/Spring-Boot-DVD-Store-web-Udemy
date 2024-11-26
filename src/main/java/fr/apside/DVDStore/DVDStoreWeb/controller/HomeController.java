package fr.apside.DVDStore.DVDStoreWeb.controller;

import fr.apside.DVDStore.core.entity.Movie;
import fr.apside.DVDStore.core.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
	@Autowired
	private MovieServiceInterface movieServiceInterface;

	public MovieServiceInterface getMovieService() {
		return movieServiceInterface;
	}

	public void setMovieService(MovieServiceInterface movieService) {
		this.movieServiceInterface = movieService;
	}

	@RequestMapping("/dvdstore-home")
	public @ModelAttribute("movies") List<Movie> displayHome(){
		return movieServiceInterface.getMovieList();
	}

}
