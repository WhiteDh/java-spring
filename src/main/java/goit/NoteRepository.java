package goit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByTitle(String title);

    List<Note> findByContent(String content);

    List<Note> findByContentContaining(String keyword);
}