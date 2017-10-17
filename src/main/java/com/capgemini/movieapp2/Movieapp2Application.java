package com.capgemini.movieapp2;

import com.capgemini.movieapp2.model.Movie;
import com.capgemini.movieapp2.repository.RepositoryMovie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Movieapp2Application {

	private static final Logger log = LoggerFactory.getLogger(Movieapp2Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Movieapp2Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(RepositoryMovie repository) {
		return (args) -> {

			// save a couple of movies
			repository.save(new Movie("Terminator", "8", true));
			repository.save(new Movie("Terminator2", "8", true));
			repository.save(new Movie("American Pie", "10", true));


			// fetch all movies
			log.info("Movies found with findAll():");
			log.info("-------------------------------");
			for (Movie movie : repository.findAll()) {
				log.info(movie.toString());
			}
			log.info("");

		};
	}
}