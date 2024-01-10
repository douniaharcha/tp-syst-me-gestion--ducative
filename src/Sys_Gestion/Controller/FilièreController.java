package Sys_Gestion.Controller;

import Sys_Gestion.Services.*;
import Sys_Gestion.Models.Filière;
import Sys_Gestion.Models.Module;
import com.sun.tools.javac.Main;
import Sys_Gestion.Models.Departement;

import static Sys_Gestion.Main.*;
import static java.util.Objects.isNull;

import static Sys_Gestion.Controller.DepartementController.showDepartements;

public class FilièreController {
    public static void showMenu(){
        System.out.println("--[Filières]--");
        System.out.println("1: pour ajouter une filière");
        System.out.println("2: pour afficher les filières");
        System.out.println("3: pour modifier une filière");
        System.out.println("4: pour supprimer une filière");
        System.out.println("0: pour retourner au menu principal");

// veuillez sélectionner une option:

        int option=getIntInput("veuillez sélectionner une option : ");
        switch(option){
            case 1:createFilière();
                break;
            case 2:showFilière();
            break;
           case 3:editFilière();
            break;
            case 4:destroyFilière();
            break;
            default:
                showPrincipalMenu();
        }
    }

    public static void showFilière(){
        for(Filière filière : DB.filières){
            System.out.println("Id :"+filière.getId());
            System.out.printf("Intitulé : "+ Filière.getIntitulé());
            if (isNull(Filière.getResponsable())) {
    System.out.println("responsable : "+Filière.getResponsable().getNom()+" "+
            Filière.getResponsable().getPrénom());
            }

            if(!isNull(Filière.getDépartement())){
                System.out.println("département : "+Filière.getDépartement().getIntitulé()+" "+
                        Filière.getDépartement().getId());
            }
            System.out.println(" ");
        }
    }
    public static void createFilière(){
        String intitulé=getStringInput("entrez l'intitulé: ");
        EnseignantController.showEnseignant();
        DepartementController.showDepartements();
        int id=getIntInput("sélectionner un département par id :");
         int idp=getIntInput("sélectionner un département par id:");
         int idm=getIntInput("sélectionner un module par id :");
    FilièreService.addFilière(intitulé,EnseignantService.getEnsById(id),DepartementService.getDeptById(id),
        ModuleService.getModuleById(idm));

        showFilière();
        showMenu();
    }

   public static void editFilière(){
        showFilière();
        int id=getIntInput("sélectionner une filière par id :");
        String intitulé=getStringInput("entrez l'intitulé :");
        EnseignantController.showEnseignant();
        DepartementController.showDepartements();
        int idEns=getIntInput("sélectionner un enseignant par id :");
        int idDpt=getIntInput("sélectionner un département par id :");
        FilièreService.updateFilière(id,intitulé,EnseignantService.getEnsById(idEns),
                DepartementService.getDeptById(idDpt));
        showFilière();
        showMenu();
    }
    public static void destroyFilière(){
        showFilière();
        int id=getIntInput("sélectionner une filière par id : ");
        FilièreService.deleteFilièreById(id);
        showFilière();
    }
}
