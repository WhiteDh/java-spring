package goit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
		// add new note
		Note note1 = new Note();
		note1.setTitle("first note");
		note1.setContent("this is the first note");
		noteService.add(note1);

		Note note2 = new Note();
		note2.setTitle("second note");
		note2.setContent("this is the second note");
		noteService.add(note2);

		// print all notes
		System.out.println("all notes: " + noteService.listAll().toString());

		// get byid
		System.out.println("note by id 1: " + noteService.getById(note1.getId()));

		// update note
		note1.setTitle("updated first note");
		note1.setContent("this is the updated content");
		noteService.update(note1);
		System.out.println("updated note: " + noteService.getById(note1.getId()));

		// deleting note
		noteService.deleteById(note2.getId());
		System.out.println("all notes after deletion: " + noteService.listAll());

		// to throw exception
		try {
			noteService.getById(99999L);

		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}
	}

}
