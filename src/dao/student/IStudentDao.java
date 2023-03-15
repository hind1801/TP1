package dao.student;

import dao.IDao;
import models.Note;
import models.Student;

import java.util.List;

public interface IStudentDao extends IDao<Student,String> {

    List<Student> findByName(String nom);
    List<Student> findAll();


}
