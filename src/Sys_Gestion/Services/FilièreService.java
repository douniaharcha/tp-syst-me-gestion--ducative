package Sys_Gestion.Services;

import Sys_Gestion.Models.*;
import Sys_Gestion.Models.Module;

import java.util.ArrayList;

public class FilièreService {
    public static Filière addFilière(String intitulé,Enseignant responsable,Departement département,Module module)
    {

        Filière filiere=new Filière();
        filiere.setIntitulé(intitulé);
        filiere.setResponsable(responsable);
        filiere.setDépartement(département);
        filiere.setId(DB.getModId());

        DB.filières.add(filiere);

        return new Filière();
    }
    public static Filière updateFilière(int id,String intitulé,Enseignant responsable,Departement département)
    {

        for (Filière filiere :DB.filières){
            if(filiere.getId()==id){
                filiere.setIntitulé(intitulé);
                filiere.setIntitulé(intitulé);
                filiere.setResponsable(responsable);
                filiere.setDépartement(département);

                return filiere;
            }
        }

        return new Filière();
    }
    public static ArrayList<Filière> deleteFilièreById(int id){

        DB.filières.remove(getFilièreById(id));

        return DB.filières;
    }
    public static Filière getFilièreById(int id){

        for(Filière filière:DB.filières){
            if(filière.getId()==id)
                return filière;
        }


        return new Filière();
    }
    public static ArrayList<Filière> getAllFilière(){
        return DB.filières;
    }

}
