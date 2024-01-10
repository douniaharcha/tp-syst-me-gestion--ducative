package Sys_Gestion.Services;

import Sys_Gestion.Models.Enseignant;
import Sys_Gestion.Models.Etudiant;
import Sys_Gestion.Models.Filière;

import java.util.ArrayList;

public class EtudiantService {
    public static Etudiant addEtd(String nom,String prénom,String email,int apogée,Filière filière)
    {

        Etudiant etudiant=new Etudiant();
        etudiant.setEmail(email);
        etudiant.setNom(nom);
        etudiant.setPrénom(prénom);
        etudiant.setApogée(apogée);
        etudiant.setFilière(filière);
        etudiant.setId(DB.getEtdId());


        return new Etudiant();
    }

    public static Etudiant updateEtd(int id,String nom,String prénom,String email,int apogée,Filière filière)
    {

        for (Etudiant etudiant :DB.etudiants){
            if(etudiant.getId()==id){
                etudiant.setEmail(email);
                etudiant.setNom(nom);
                etudiant.setPrénom(prénom);
                etudiant.setApogée(apogée);
                etudiant.setFilière(filière);

                return etudiant;
            }
        }

        return new Etudiant();
    }
    public static ArrayList<Etudiant>deleteEtdbyId(int id){

        DB.etudiants.remove(getEtdById(id));

        return DB.etudiants;
    }
    public static Etudiant getEtdById(int id){

        for(Etudiant etudiant:DB.etudiants){
            if(etudiant.getId()==id)
                return etudiant;
        }

        return new Etudiant();
    }
    public static ArrayList<Etudiant>getAllEtd(){
        return DB.etudiants;
    }
}
