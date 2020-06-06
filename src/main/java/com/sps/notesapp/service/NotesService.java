package com.sps.notesapp.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Notes service.
 */
@Service
public class NotesService {

    /**
     * The constant NOTES_DB_FILE_NAME.
     */
    public static final String NOTES_FILE_NAME = "notes-db.txt";

    private static Integer NOTES_COUNTER = 0;

    /**
     * Static block the initialize the notes db.
     */
    static {
        final PrintWriter writer;
        try {
            writer = new PrintWriter(NOTES_FILE_NAME, "UTF-8");
            writer.println("Welcome to Notes App");
            writer.close();
            writer.flush();
        } catch (final FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets notes.
     *
     * @return the notes
     * @throws IOException the io exception
     */
    public List<String> getNotes() throws IOException {

        final BufferedReader br = Files.newBufferedReader(Paths.get(NOTES_FILE_NAME));

        return br.lines().collect(Collectors.toList());
    }

    /**
     * Adds notes.
     *
     * @return the notes
     * @throws IOException the io exception
     */
    public String addNote(final String note) throws IOException {

        final BufferedWriter writer = Files.newBufferedWriter(Paths.get(NOTES_FILE_NAME), StandardOpenOption.APPEND);

        NOTES_COUNTER = NOTES_COUNTER + 1;

        writer.newLine();
        writer.write("Note No:- " + NOTES_COUNTER + " = " + note);
        writer.flush();

        return "Note No:- " + NOTES_COUNTER + " added";
    }
}
