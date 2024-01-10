package Sys_Gestion.Controller;

import Sys_Gestion.Services.*;
import Sys_Gestion.Models.Module;
import com.sun.tools.javac.Main;
import Sys_Gestion.Models.Departement;

import static Sys_Gestion.Main.*;
import static Sys_Gestion.Controller.DepartementController.showDepartements;

public class ModuleController {
        public static void showMenu(){
            System.out.println("[  Modules ]");
            System.out.println("1: Pour ajouter un  module");
            System.out.println("2: Pour afficher les  modules");
            System.out.println("3: Pour modifier un  module");
            System.out.println("4: Pour supprimer un  module");
            System.out.println("0: Pour retourner au menu principal");

            //"Veuillez sélectionner une option : ")
            int option = getIntInput("Veuillez sélectionner une option : ");
            switch(option) {
                case 1:
                    createModule();
                    break;
                case 2:
                    showModule();
                    break;
                case 3:
                    editModule();
                    break;
                case 4:
                    destroyModule();
                    break;
                default:
                    showPrincipalMenu();
            }}
        public static void showModule(){
            for(Module module : DB.modules){
                System.out.println("Id :" +module.getId());
                System.out.println("Intitule :"+module.getIntitulé());
                if(!isNull(module.getProfesseur())){
                    System.out.println(" professeur :"+module.getProfesseur().getNom()+" "
                            +module.getProfesseur().getPrénom());
                }
                if(!isNull(module.getFilière())){
                    System.out.println(" filiere :"+module.getFilière().getId()+" "
                            +module.getFilière().getIntitulé()+" "
                            +module.getFilière().getResponsable()+" "
                            +module.getFilière().getDépartement());
                }
                System.out.println(" ");
            }

        }
        public static void createModule(){
            String intitule =getStringInput("entrez l'intitule :");
            EnseignantController.showEnseignant();
            FilièreController.showFilière();
            int id=getIntInput("selectionnez un enseignant par id:");
            int idf=getIntInput("selectionnez une filiere par id:");
            ModuleService.addModule(intitule, EnseignantService.getEnsById(id), FilièreService.getFilièreById(idf));
            showModule();
            showMenu();
        }
        public static void editModule(){
            showModule();
            int id=getIntInput("selectionnez un module par id :");
            String intitule=getStringInput("entrez l'intitule :");
            EnseignantController.showEnseignant();
            FilièreController.showFilière();
            int idEns=getIntInput("selectionnez un enseignant par id:");
            int idFil=getIntInput("selectionnez une filiere par id:");
            ModuleService.updateModule(id,intitule,EnseignantService.getEnsById(idEns)
                    ,FilièreService.getFilièreById(idFil));

            showModule();
            showMenu();
        }
        public static void destroyModule(){
            showModule();
            int id=getIntInput("Sélecionnez un module par id :");
            ModuleService.deleteModuleById(id);
            showModule();
        }
    }

