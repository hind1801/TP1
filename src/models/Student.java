package models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private String matricule;
    private String nom;
    private List<Note> notes;
    private Double moy;
    private String num_tel;
    private String adresse;
    private LocalDate date_naissance;

    @Override
    public String toString()
    {
        String message ="";
        message += "====================================================================\n";
        message += "=> Etudiant n°"+getMatricule();
        message += "\n=> Numéro de téléphone          : "+num_tel;
        message += "\n--------------------------------------------------------------------\n";
        message += "=> Nom                            : "+nom;
        message += "\n--------------------------------------------------------------------\n";
        message += "=> Moyenne                        : "+moy;
        message += "\n--------------------------------------------------------------------\n";
        message += "=> Adresse                        : "+adresse;
        message += "\n--------------------------------------------------------------------\n";
        message += "=> Date_naissance                 : "+date_naissance;

        message += "\n====================================================================\n";
        return message;
    }
}
