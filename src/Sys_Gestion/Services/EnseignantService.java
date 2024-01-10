package Sys_Gestion.Services;

import Sys_Gestion.Models.Enseignant;
import Sys_Gestion.Models.Departement;

import java.util.ArrayList;

public class EnseignantService {
    public static Enseignant addEns(String nom,String prénom,String grade,String email,Departement département)
    {

        Enseignant enseignant=new Enseignant();
        enseignant.setNom(nom);
        enseignant.setEmail(email);
        enseignant.setGrade(grade);
        enseignant.setId(DB.getEnsId());
        enseignant.setPrénom(prénom);
        enseignant.setDépartement(département);
        DB.enseignants.add(enseignant);


        return new Enseignant();}
    public static Enseignant updateEns(int id,String nom,String prénom,String grade,String email,Departement département)
    {

        for (Enseignant enseignant :DB.enseignants){
            if(enseignant.getId()==id){
                enseignant.setNom(nom);
                enseignant.setPrénom(prénom);
                enseignant.setEmail(email);
                enseignant.setGrade(grade);
                enseignant.setDépartement(département);
            }
            return enseignant;
        }

        return new Enseignant();
    }
    public static ArrayList<Enseignant>deleteEnsById(int id){

        DB.enseignants.remove(getEnsById(id));

        return DB.enseignants;
    }
    public static Enseignant getEnsById(int id){
        for(Enseignant enseignant:DB.enseignants){
            if(enseignant.getId()==id)
                return enseignant;
        }
        return new Enseignant();
    }
    public static ArrayList<Enseignant> getAllEns(){
        return DB.enseignants;
    }
}
