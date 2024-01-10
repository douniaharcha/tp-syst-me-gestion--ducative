package Sys_Gestion.Controller;

import Sys_Gestion.Services.*;
import Sys_Gestion.Models.Etudiant;

import Sys_Gestion.Models.Filière;
import com.sun.tools.javac.Main;

import static Sys_Gestion.Main.*;

import Sys_Gestion.Services.EtudiantService;
import Sys_Gestion.Services.FilièreService;



import static Sys_Gestion.Controller.DepartementController.showDepartements;



public class EtudiantController {

    public static void showMenu(){
        System.out.println("--[Etudiant]--");
        System.out.println("1: pour ajouter un etudiant");
        System.out.println("2: pour afficher les etudiants");
        System.out.println("3: pour modifier les etudiants");
        System.out.println("4: pour supprimer un etudiant");
        System.out.println("0: pour retourner au menu principal");

// veuillez sélectionner une option :

        int option= getIntInput("veuillez sélectionner une option :");
        switch(option){
            case 1:
                createEtudiant();
            break;
            case 2:
                showEtudiant();
            break;
            case 3:
                editEtudiant();
            break;
            case 4:
                destroyEtudiant();
            break;
            default:
                showPrincipalMenu();

        }
    }

    private static void createEtudiant() {

        String nom=getStringInput("entrez le nom :");
        String prénom=getStringInput("entrez le prénom :");
        int apogée=getIntInput("entrez le code apogée :");
        String email=getStringInput("entrez l'email :");
        FilièreController.showFilière();
        int id=getIntInput("sélectionner une filière pa id:");

        EtudiantService.addEtd(nom,prénom,email,apogée, FilièreService.getFilièreById(id));
        showEtudiant();
        showMenu();
    }

    public static void showEtudiant(){
        for(Etudiant etudiant : DB.etudiants){
            System.out.println("Id :"+etudiant.getId());
            System.out.println("Nom :"+etudiant.getNom());
            System.out.println("Prénom :"+etudiant.getPrénom());
            System.out.println("Email :"+etudiant.getEmail());
            System.out.println("Apogée :"+etudiant.getApogée());
            if(!isNull(etudiant.getFilière())){
                System.out.println("filière : "+etudiant.getFilière().getIntitulé()+" "+etudiant.getFilière().getResponsable()+
                        " "+etudiant.getFilière().getDépartement()+" "+etudiant.getFilière().getId()+
                        " "+etudiant.getFilière().getModule());
            }
        }




    }

    private static void editEtudiant() {

        showEtudiant();
        int id=getIntInput("sélectionner un etudiant par id : ");
        String nom=getStringInput("entrez le nom : ");
        String prénom=getStringInput("entrez le prénom :");
        int apogée=getIntInput("entrez le code apogée :");
        String email=getStringInput("entrez l'email :");
        FilièreController.showFilière();

        int idFil=getIntInput("sélectionner une filière par id :");
        EtudiantService.updateEtd(id,nom,prénom,email,apogée,FilièreService.getFilièreById(idFil));

        showEtudiant();
        showMenu();
    }

    private static void destroyEtudiant() {

        showEtudiant();
        int id=getIntInput("sélectionner un etudiant par id : ");

        EtudiantService.deleteEtdbyId(id);
        showEtudiant();
    }


}
