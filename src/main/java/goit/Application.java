package goit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "goit")
@EntityScan(basePackages = "goit")

public class Application implements CommandLineRunner {

	private final NoteService noteService;

	public Application(NoteService noteService) {
		this.noteService = noteService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		Note note1 = new Note();
		note1.setTitle("First Note");
		note1.setContent("This is the first note.");

		Note note2 = new Note();
		note2.setTitle("Second Note");
		note2.setContent("This is the second note.");

		// Сохраняем нотатки в БД
		noteService.add(note1);
		noteService.add(note2);
	}

}
