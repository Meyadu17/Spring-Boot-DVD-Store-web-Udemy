package fr.apside.DVDStore.DVDStoreWeb.api;

import fr.apside.DVDStore.core.entity.Movie;
import fr.apside.DVDStore.core.service.MovieServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieResource {

	private final MovieServiceInterface movieServiceInterface;

	public MovieResource (MovieServiceInterface movieServiceInterface) {
		this.movieServiceInterface = movieServiceInterface;
	}

	@GetMapping
	public List<Movie> list(){
		return movieServiceInterface.getMovieList();
	}

	@GetMapping("/{id}")
	public Movie get(@PathVariable("id") long id){
		return movieServiceInterface.getMovieById(id);
	}

	@PostMapping
	public Movie add(@RequestBody Movie movie){
		return movieServiceInterface.addMovie(movie);
	}

}
