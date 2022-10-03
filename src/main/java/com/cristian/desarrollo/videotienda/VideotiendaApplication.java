package com.cristian.desarrollo.videotienda;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.cristian.desarrollo.videotienda.model.entity.Category;
import com.cristian.desarrollo.videotienda.model.entity.Movie;
import com.cristian.desarrollo.videotienda.model.repository.CategoryRepository;
import com.cristian.desarrollo.videotienda.model.repository.MovieRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@SpringBootApplication
public class VideotiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideotiendaApplication.class, args);
	}

	@Component
	@Data
	@AllArgsConstructor
	private class DataLoader implements CommandLineRunner {
		
		private final CategoryRepository categoryRepository;
		private final MovieRepository movieRepository;

		@Override
		public void run(String... args) throws Exception {
			loadData();
		}

		private void loadData() {
			var scifi = categoryRepository.save(new Category("Sci-fi"));
			var comedy = categoryRepository.save(new Category("Comedy"));

			var categories = Arrays.asList(
				new Category("Action"),
				new Category("Romance")
			);

			categoryRepository.saveAll(categories);
			var movies = Arrays.asList(
				
				new Movie(100111L, "Matrix",
					 "The best of the best",
					 120,
					 "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/950/public/media/image/2016/11/matrix.jpg?itok=y_D1-7f-",
					 scifi),
				new Movie(100112L, "Hang Over",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum non erat sed tortor tristique blandit in vitae nisl. Integer eros nibh, semper vitae dui quis.",
					120,
					"https://www.scrolldroll.com/wp-content/uploads/2022/04/The-Hangover-Best-Hindi-Dubbed-Comedy-Movies-scaled.jpeg",
					comedy),
				new Movie(100113L, "Hitch",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum non erat sed tortor tristique blandit in vitae nisl. Integer eros nibh, semper vitae dui quis.",
					120,
					"https://m.media-amazon.com/images/M/MV5BNzYyNzM2NzM2NF5BMl5BanBnXkFtZTcwNjg5NTQzMw@@._V1_.jpg",
					comedy),
		
				new Movie(100114L, "Grown Ups",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum non erat sed tortor tristique blandit in vitae nisl. Integer eros nibh, semper vitae dui quis.",
					120,
					"https://images-na.ssl-images-amazon.com/images/S/pv-target-images/8cc65b37e1c6a637d213a6e784f6400e1e991aa3cf3564322050ceaba2aafa2a._RI_V_TTW_.jpg",
					comedy),
				
				new Movie(100115L, "Dumb and Dumber",
					 "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum non erat sed tortor tristique blandit in vitae nisl. Integer eros nibh, semper vitae dui quis.",
					 90,
					 "https://m.media-amazon.com/images/I/71SId+DDZOL._SY445_.jpg",
					 comedy)
			); 
			movieRepository.saveAll(movies);
		}
	}


}
