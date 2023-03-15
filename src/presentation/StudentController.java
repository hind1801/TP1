package presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.var;
import metier.ClassNotFoundException;
import metier.IStudentMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller("scontroller")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class StudentController implements IStudentController{
    @Autowired
    @Qualifier("smetier")
    IStudentMetier metier;

    @Override
    public void afficherNoteGeneral(String matricule) throws ClassNotFoundException {
        var student  = metier.calculerNoteGenerale(matricule);
        System.out.println(student.toString());
    }
}
