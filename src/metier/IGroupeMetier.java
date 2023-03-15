package metier;

import models.Groupe;

public interface IGroupeMetier {

    Groupe calculerMoClass(Integer idGroupe) throws ClassNotFoundException;
}
