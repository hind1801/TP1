package metier;

import dao.IDao;
import lombok.*;
import models.Groupe;
import models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("gmetier")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class GroupeMetier implements IGroupeMetier{
    @Autowired
    @Qualifier("gdao")
    IDao<Groupe,Integer> dao;


    @Override
    public Groupe calculerMoClass(Integer idGroupe) throws ClassNotFoundException {
        var groupe = dao.findById(idGroupe);
        if(groupe==null)
            throw new ClassNotFoundException("Groupe not found");
        Double n =0.0;
        for (Student s : groupe.getStudents()) {
            if(s!=null)
                n+=s.getMoy();
        }
        groupe.setNoteGroup(n);
        return groupe;
    }
}
