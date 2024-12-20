package goit;

import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final Map<Long, Note> notes = new HashMap<>();
    private final Random random = new Random();
    private static final long MAX_ID_VALUE = 999999;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
        if (!noteRepository.existsById(id)) {
            throw new RuntimeException("note does not exist");
        }
        noteRepository.deleteById(id);
    }


    public void update(Note note) {
        if (!noteRepository.existsById(note.getId())) {
            throw new RuntimeException("note does not exist");
        }
        noteRepository.save(note);
    }

    public Note getById(long id) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        if (!noteOptional.isPresent()) {
            throw new RuntimeException("note does not exist");
        }
        return noteOptional.get();
    }


    private long generateId(){
        long id;

       do{
           id=random.nextLong(1, MAX_ID_VALUE);
       } while (notes.containsKey(id));

        return id;
    }

}
