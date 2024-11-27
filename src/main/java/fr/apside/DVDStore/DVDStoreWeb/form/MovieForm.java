package fr.apside.DVDStore.DVDStoreWeb.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MovieForm {

	private Long id;
	@NotBlank(message = "Le titre est obligatoire.")
	@Size(max = 20, message = "Le titre doit faire max 20 caractères.")
	private String title;
	@NotBlank(message = "Le genre est obligatoire.")
	private String genre;
	@Size(max = 255, message = "La description doit faire max 255 charactères")
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
