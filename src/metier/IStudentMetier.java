package metier;

import models.Student;

public interface IStudentMetier {
    Student calculerNoteGenerale(String matricule) throws ClassNotFoundException;
}
