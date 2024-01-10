package Sys_Gestion.Controller;

import Sys_Gestion.Models.Departement;
import Sys_Gestion.Services.DB;
import Sys_Gestion.Services.DepartementService;
import Sys_Gestion.Services.EnseignantService;
import com.sun.tools.javac.Main;

import static Sys_Gestion.Main.*;
import java.util.Scanner;

import static java.util.Objects.isNull;


public class DepartementController {
    public static void showMenu(){
        System.out.println("--[ Départements ]--");


        System.out.println("1: Pour ajouter un département");
        System.out.println("2: Pour afficher les départements");
        System.out.println("3: Pour modifier un département");
        System.out.println("4: Pour supprimer un département");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option =getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createDepartement();
                break;
            case 2:
                showDepartements();
                break;
            case 3:
                editDepartement();
                break;
            case 4:
                destroyDepartement();
                break;
            default:
                showPrincipalMenu();
        }
    }
    public static void showDepartements(){
        for (Departement département : DB.departements) {
            System.out.print("Id : " + département.getId());
            System.out.print(" | Intitulé : " + département.getIntitulé());
            if (! isNull(département.getResponsable())) {
                System.out.print(" | Chef : " + département.getResponsable().getNom() + " " + département.getResponsable().getPrénom());
            }
            System.out.println("");
        }

    }
    public static void createDepartement(){
        String intitule =getStringInput("Entrez l'intitulé :");
        EnseignantController.showEnseignant();
        int id =getIntInput("Sélecionnez un enseignant par id :");
        DepartementService.addDept(intitule, EnseignantService.getEnsById(id));

        showDepartements();
        showMenu();


    }
    public static void editDepartement(){
        showDepartements();
        int id = getIntInput("Sélecionnez un departement par id :");
        String intitule =getStringInput("Entrez l'intitulé :");
        EnseignantController.showEnseignant();
        int idEns = getIntInput("Sélecionnez un enseignant par id :");

        DepartementService.updatedept(id, intitule, EnseignantService.getEnsById(idEns));

        showDepartements();
        showMenu();
    }
    public static void destroyDepartement(){
        showDepartements();
        int id = getIntInput("Sélecionnez un departement par id :");
        DepartementService.deleteDeptbyId(id);
        showDepartements();

    }
}


