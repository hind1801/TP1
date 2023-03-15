package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Groupe {
    private Integer id_grp;
    private List<Student> students;
    private Double noteGroup ;

    @Override
    public String toString()
    {
        String message ="";
        message += "====================================================================\n";
        message += "=> Groupe n°"+getId_grp();
        message += "\n------------------------------------------------------------------\n";
        message+= " ==> **************** L I S T E   D E S   E T U D I A N T S **************** <==\n";
        message += "====================================================================\n";
      for (Student s :students){
          message+= s.toString();
      }
        message += "====================================================================\n";

        return message;
    }
}
