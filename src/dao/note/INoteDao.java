package dao.note;

import dao.IDao;
import models.Note;
import models.Student;

import java.util.List;

public interface INoteDao extends IDao<Note,Integer> {
    List<Student> findStudentByGrade(Double note);
    List<Note> findAll();
}
