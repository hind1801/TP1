package dao.DsVolatile;

import dao.IDao;
import dao.group.IGroupDao;
import models.Groupe;
import models.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component("gdao")

public class GroupDao implements IDao<Groupe , Integer> {
    @Override
    public Groupe findById(Integer id) {
            return  DBGroupe().stream().filter(s->s.getId_grp().equals(id)).findFirst().orElse(null);
    }



  static List<Groupe> DBGroupe() {
      return new ArrayList<>(
              Arrays.asList(
                      new Groupe(1, new ArrayList<Student>(Arrays.asList(StudentDao.DBStudents().get(0) , StudentDao.DBStudents().get(1))) ,0.0),
                      new Groupe(2, new ArrayList<Student>(Arrays.asList(StudentDao.DBStudents().get(2) , StudentDao.DBStudents().get(3))) , 0.0)
                      ));
  }

}
