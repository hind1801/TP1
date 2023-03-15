package presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.var;
import metier.ClassNotFoundException;
import metier.IGroupeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller("gcontroller")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class GroupeController implements IGroupeController{
    @Autowired
            @Qualifier("gmetier")
    IGroupeMetier metier;


    @Override
    public void afficherNoteGenerale(Integer id) throws ClassNotFoundException {
        var groupe = metier.calculerMoClass(id);
        System.out.println(groupe.toString());
    }
}
