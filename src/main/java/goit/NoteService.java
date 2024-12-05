package goit;

import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class NoteService {
    private final Map<Long, Note> notes = new HashMap<>();
    private final Random random = new Random();
    private static final long MAX_ID_VALUE = 999999;
    public List<Note> listAll(){
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note){
        note.setId(generateId());
        notes.put(note.getId(), note);
        return note;
    }

    void deleteById(long id){
        if(!notes.containsKey(id)){
            throw new RuntimeException("note does not exist");
        }
        notes.remove(id);
    }


    void update(Note note){
        if(!notes.containsKey(note.getId())){
            throw new RuntimeException("note does not exist");
        }
        Note oldNote = notes.get(note.getId());
        oldNote.setTitle(note.getTitle());
        oldNote.setContent(note.getContent());
    }

    public Note getById(long id){
        if(!notes.containsKey(id)){
            throw new RuntimeException("note does not exist");
        }
        return notes.get(id);
    }


    private long generateId(){
        long id;

       do{
           id=random.nextLong(1, MAX_ID_VALUE);
       } while (notes.containsKey(id));

        return id;
    }

}
