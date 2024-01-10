package Sys_Gestion.Controller;

import Sys_Gestion.Models.Enseignant;
import Sys_Gestion.Services.DB;
import Sys_Gestion.Services.DepartementService;
import Sys_Gestion.Services.EnseignantService;
import Sys_Gestion.Models.Departement;
import com.sun.tools.javac.Main;

import javax.imageio.stream.ImageInputStream;

import static Sys_Gestion.Main.*;
import static java.util.Objects.isNull;

public class EnseignantController {

    public static void showMenu(){
        System.out.println("--[Enseignant]--");
        System.out.println("1: pour ajouter un enseignant");
        System.out.println("2: pour afficher les enseignants");
        System.out.println("3: pour modifier un enseignant");
        System.out.println("4: pour supprimer un enseignant");
        System.out.println("0: pour retourner au menu principal");
//"Veuillez sélectionner une option:"

        int option= getIntInput("Veuillez sélectionner une option:");
        switch(option){
            case 1:createEnseignant();
            break;
            case 2:showEnseignant();
            break;
            case 3:editEnseignant();
            break;
            case 4:destroyEnseignant();
            break;
            default:
            showPrincipalMenu();}
        }

    public static void showEnseignant(){
        for (Enseignant enseignant : DB.enseignants) {
            System.out.print("Id : " + enseignant.getId());
            System.out.print("Nom : " + enseignant.getNom() + "Prénom:  " + enseignant.getPrénom());
            System.out.println("Grade: "+enseignant.getGrade());
            System.out.print("Email : " + enseignant.getEmail() );

           if (! isNull(enseignant.getDépartement())) {
                System.out.print("département: " + enseignant.getDépartement().getIntitulé() + " " + enseignant.getDépartement().getId());         }
            System.out.println("");
        }
    }
    public static void createEnseignant(){
        String nom= getStringInput("entrez le nom :");
        String prénom=getStringInput("entrez lr prénom :");
        String grade=getStringInput("entrez la grade :");
        String email=getStringInput("entrez l'email :");

        DepartementController.showDepartements();
        int id=getIntInput("selectionnez un département par id :");
        EnseignantService.addEns(nom,prénom,grade,email,DepartementService.getDeptById(id));
        EnseignantController.showEnseignant();

        showMenu();
    }

    public static void editEnseignant(){
        EnseignantController.showEnseignant();
        int id=getIntInput("selectionnez un enseignant par id :");
        String nom=getStringInput("entrez le nom :");
        String prénom=getStringInput("entrez le prénom :");
        String grade=getStringInput("entrez la grade :");
        String email=getStringInput("entrez l'email :");
        DepartementController.showDepartements();

        int idDpt=getIntInput("selectionnez un département par id :");
        EnseignantService.updateEns(id,nom,prénom,grade,email,DepartementService.getDeptById(idDpt));
        EnseignantController.showEnseignant();
        showMenu();

    }

    public static void destroyEnseignant(){
        EnseignantController.showEnseignant();
        int id=getIntInput("sélectionnez un enseignant par id :");
        EnseignantService.deleteEnsById(id);
        EnseignantController.showEnseignant();

    }
}


