package metier;

import dao.IDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.var;
import models.Note;
import models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("smetier")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentMetier implements IStudentMetier{
    @Autowired
    @Qualifier("sdao")
    IDao<Student,String> dao;
    @Override
    public Student calculerNoteGenerale(String matricule) throws ClassNotFoundException {
        Double note =0.0;
        int c =0;
        var student = dao.findById(matricule);
        if(student==null)
            throw new ClassNotFoundException("Student not found");
        for(Note t : student.getNotes()) {
            if(t!=null)
            {
                note+=t.getValeur();
                c++;
            }
        }
            student.setMoy(note/c);
        return student;
    }
}
