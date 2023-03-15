package dao.DsVolatile;

import dao.IDao;
import dao.student.IStudentDao;
import models.Groupe;
import models.Student;
import org.springframework.stereotype.Component;

import java.security.acl.Group;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Component("sdao")

public class StudentDao implements IDao<Student , String> {
    @Override
    public Student findById(String matricule) {
        return DBStudents().stream()
                .filter(s -> s.getMatricule().equals(matricule))
                .findFirst()
                .get();
    }



    static List<Student> DBStudents()
    {
        return new ArrayList<>(
                Arrays.asList(
                   new Student("A01" , "Hind Nadir" , new ArrayList<>(Arrays.asList(NoteDao.DBNote().get(0) ,NoteDao.DBNote().get(1 ))) ,0.0 ,"0666768798" ,"Sale", LocalDate.now()),
                   new Student("A02" , "Khadija Nadir" , new ArrayList<>(Arrays.asList(NoteDao.DBNote().get(2) ,NoteDao.DBNote().get(3 ))) ,0.0 ,"0666768798" ,"Sale", LocalDate.now()),
                   new Student("A03" , "Sophia Nadir" , null ,0.0 ,"0666768798" ,"Sale", LocalDate.now()),
                   new Student("A04" , "Salma Nadir" , null ,0.0 ,"0666768798" ,"Sale", LocalDate.now())
                )
        ) ;
    }

}
