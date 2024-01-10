package Sys_Gestion.Services;

import Sys_Gestion.Models.Enseignant;
import Sys_Gestion.Models.Departement;

import java.util.ArrayList;

public class DepartementService {

    public static Departement addDept(String intitulé,Enseignant responsable) {
        Departement département = new Departement();

        département.setIntitulé(intitulé);

        département.setId(DB.getDeptId());

       if (responsable.length > 0){
            département.setResponsable(responsable);
    }
        DB.departements.add(département);
        return département;
    }

   public static Departement updatedept(int id,String intitulé,Enseignant responsable)
    {for(Departement département:DB.departements)
    {
        if(département.getId()==id){
            département.setIntitulé(intitulé);
            if(responsable.length > 0)
                département.setResponsable(responsable) ;}
            return département;
        }

    return new Departement();
    }

    public static ArrayList<Departement>deleteDeptbyId(int id){
        DB.departements.remove(getDeptById(id));

        return DB.departements;
    }
    public static Departement getDeptById(int id){
        for(Departement département:DB.departements){
            if(département.getId()==id)
                return département;
        }
        return new Departement();
    }
    public static ArrayList<Departement> getAllDept(){
        return DB.departements;
    }
}
