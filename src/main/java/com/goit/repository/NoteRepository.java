package com.goit.repository;

import com.goit.entity.Note;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public final class NoteRepository {
    private static final Map<Long, Note> notes = new HashMap<>();
    private static final Random random = new Random();

    public Map<Long, Note> getNotes() {
        return notes;
    }

    public List<Note> getAllNote() {
        List<Note> allNotes = new ArrayList<>();
        notes.forEach((key, value) -> allNotes.add(notes.get(key)));
        return allNotes;
    }

    public long getNewRandomKey() {
        long key = random.nextLong();
        while (notes.containsKey(key)) {
            key = random.nextLong();
        }
        return key;
    }
}
