package Sys_Gestion.Services;

import Sys_Gestion.Models.Enseignant;
import Sys_Gestion.Models.Etudiant;
import Sys_Gestion.Models.Filière;
import Sys_Gestion.Models.Module;

import java.util.ArrayList;
import java.util.List;

import static Sys_Gestion.Services.DB.modules;

public class ModuleService {

    public static Module addModule(String intitulé, Enseignant professeur, Filière filière)
    {
        Module module =new Module();
        module.setIntitulé(intitulé);
        module.setProfesseur(professeur);
        module.setFilière(filière);
        module.setId(DB.getModId());
        DB.modules.add(module);

        return new Module();
    }
    public static Module updateModule(int id,String intitulé,Enseignant professeur,Filière filière)
    {

        for (Module module :DB.modules){
            if(module.getId()==id){
                module.setIntitulé(intitulé);

                return module;
            }
        }

        return new Module();
    }
    public static ArrayList<Module> deleteModuleById(int id){

        DB.modules.remove(getModuleById(id));

        return modules;
    }
    public static Module getModuleById(int id){

        for(Module module:DB.modules){
            if(module.getId()==id)
                return module;
        }

        return new Module();
    }
    public static ArrayList<Module> getAllModula(){
        return modules;
    }
}
