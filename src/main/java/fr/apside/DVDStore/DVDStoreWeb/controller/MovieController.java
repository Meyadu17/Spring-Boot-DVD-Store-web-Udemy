package fr.apside.DVDStore.DVDStoreWeb.controller;

import fr.apside.DVDStore.DVDStoreWeb.form.MovieForm;
import fr.apside.DVDStore.core.entity.Movie;
import fr.apside.DVDStore.core.service.MovieServiceInterface;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {

	private final MovieServiceInterface movieServiceInterface;

	public MovieController(MovieServiceInterface movieService){
		this.movieServiceInterface = movieService;
	}

	@PostMapping("/create")
	public String createMovie(@Valid @ModelAttribute MovieForm movieForm, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "add-movie-form";
		}
		Movie movie = new Movie();
		movie.setTitle(movieForm.getTitle());
		movie.setGenre(movieForm.getGenre());
		movie.setDescription(movieForm.getDescription());

		movieServiceInterface.addMovie(movie);

		return "movie-added";
	}
}
