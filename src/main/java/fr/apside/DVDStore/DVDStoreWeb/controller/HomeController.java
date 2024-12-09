package fr.apside.DVDStore.DVDStoreWeb.controller;

import fr.apside.DVDStore.DVDStoreWeb.form.MovieForm;
import fr.apside.DVDStore.core.service.MovieServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class HomeController {

	private final MovieServiceInterface movieServiceInterface;

	public HomeController(MovieServiceInterface movieService) {
		this.movieServiceInterface = movieService;
	}

	@GetMapping("/home")
	public String displayHome(Model model){
		model.addAttribute("movies", movieServiceInterface.getMovieList());
		return "dvdstore-home";
	}

	@GetMapping("/create-form")
	public String displayMovieForm(@ModelAttribute MovieForm movie){
		return "add-movie-form";
	}

}
