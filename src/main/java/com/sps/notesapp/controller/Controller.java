package com.sps.notesapp.controller;

import com.sps.notesapp.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


/**
 * The type Controller.
 */
@RestController
public class Controller {

    @Autowired
    private NotesService notesService;

    /**
     * Gets notes.
     *
     * @return the notes
     * @throws IOException the io exception
     */
    @GetMapping(path = "/getNotes")
    public List<String> getNotes() throws IOException {
        return notesService.getNotes();
    }

    /**
     * Add notes string.
     *
     * @param note the note
     * @return the string
     * @throws IOException the io exception
     */
    @GetMapping(path = "/addNotes")
    public String addNote(@RequestParam final String note) throws IOException {
        return notesService.addNote(note);
    }
}