package fr.apside.DVDStore.DVDStoreWeb.controller;

import fr.apside.DVDStore.DVDStoreWeb.form.MovieForm;
import fr.apside.DVDStore.core.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dvdstore")
public class HomeController {
	@Autowired
	private MovieServiceInterface movieServiceInterface;

	public MovieServiceInterface getMovieService() {
		return movieServiceInterface;
	}

	public void setMovieService(MovieServiceInterface movieService) {
		this.movieServiceInterface = movieService;
	}

	@GetMapping("/home")
	public String displayHome(Model model){
		model.addAttribute("movies", getMovieService().getMovieList());
		return "dvdstore-home";
	}

	@GetMapping("/add-movie-form")
	public String displayMovieForm(@ModelAttribute MovieForm movie){
		return "add-movie-form"; // Changement ici pour retourner le nom du template
	}

}
