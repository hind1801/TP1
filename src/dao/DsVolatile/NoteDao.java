package dao.DsVolatile;

import dao.IDao;
import dao.note.INoteDao;
import models.Groupe;
import models.Note;
import models.Student;

import java.util.*;

public class NoteDao implements IDao<Note, Integer> {
    @Override
    public Note findById(Integer integer) {
        return DBNote().stream()
                .filter(n-> n.getId_note() == integer)
                .findFirst()
                .get();
    }



    static List<Note> DBNote() {
        return new ArrayList<>(
                Arrays.asList(
                        new Note(1 , 18.0 , "ASP.NET"),
                        new Note(2 , 14.0 , "JAVA" ),
                        new Note(3 , 15.0 , "PHP" ),
                        new Note(4 , 16.0 , "PYTHON" )
                )
            );
    }


}
