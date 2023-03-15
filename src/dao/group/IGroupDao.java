package dao.group;

import dao.IDao;
import models.Groupe;
import models.Student;

import java.util.List;

public interface IGroupDao extends IDao<Groupe,Integer> {
    List<Groupe> findAll();
}
