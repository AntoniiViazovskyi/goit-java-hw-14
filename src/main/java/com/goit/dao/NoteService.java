package com.goit.dao;

import com.goit.entity.Note;
import com.goit.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class NoteService implements NoteDao {

    private static final String MISSING_ERROR_MESSAGE = "There is no Note with id:";

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> listAll() {
        return noteRepository.getAllNote();
    }

    @Override
    public Note add(Note note) {
        long key = noteRepository.getNewRandomKey();
        note.setId(key);
        noteRepository.getNotes().put(key, note);
        return noteRepository.getNotes().get(key);
    }

    @Override
    public void deleteById(long id) {
        if (!(noteRepository.getNotes().containsKey(id))) {
            throw new IllegalArgumentException(MISSING_ERROR_MESSAGE + id);
        }
        noteRepository.getNotes().remove(id);
    }

    @Override
    public void update(Note note) {
        long noteId = note.getId();
        if (!(noteRepository.getNotes().containsKey(noteId))) {
            throw new IllegalArgumentException(MISSING_ERROR_MESSAGE + noteId);
        }
        noteRepository.getNotes().put(noteId, note);
    }

    @Override
    public Note getById(long id) {
        if (!(noteRepository.getNotes().containsKey(id))) {
            throw new IllegalArgumentException(MISSING_ERROR_MESSAGE + id);
        }
        return noteRepository.getNotes().get(id);
    }

}
