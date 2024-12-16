package goit;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/note")
public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", noteService.listAll());
        return "note_list";
    }



    @PostMapping("/delete")
    public String deleteNote(@RequestParam long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }


    @GetMapping("/edit")
    public String editNote(@RequestParam long id,Model model) {
        model.addAttribute("note", noteService.getById(id));
        return "note_edit";
    }

    @PostMapping("/edit")
    public String saveEditedNote(@ModelAttribute Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }
}
