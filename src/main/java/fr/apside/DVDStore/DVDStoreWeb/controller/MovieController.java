package fr.apside.DVDStore.DVDStoreWeb.controller;

import fr.apside.DVDStore.DVDStoreWeb.form.MovieForm;
import fr.apside.DVDStore.core.entity.Movie;
import fr.apside.DVDStore.core.service.MovieServiceInterface;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {

	private final MovieServiceInterface movieServiceInterface;

	public MovieController(MovieServiceInterface movieServiceInterface) {
		this.movieServiceInterface = movieServiceInterface;
	}

	@RequestMapping("/{id}")
	public String displayMovieCard(@PathVariable("id") int id, Model model){
		model.addAttribute("movie", movieServiceInterface.getMovieById(id));
		return "movie-details";
	}

	@PostMapping
	public String addMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			System.out.println(bindingResult.getAllErrors());
			return "add-movie-form";
		}

		Movie movie = new Movie();

		movie.setTitle(movieForm.getTitle());
		movie.setGenre(movieForm.getGenre());
		movie.setDescription(movieForm.getDescription());

		movieServiceInterface.registerMovie(movie);
		return "movie-added";
	}
}
