package Sys_Gestion.Models;

import java.util.ArrayList;

public class Filière {

    private int id;
    private static String intitulé;
    private static Enseignant responsable;
    private static Departement département;

    ArrayList<Module> module = new ArrayList<Module>();

    public Filière(){}

    public Filière(String intitulé,Enseignant responsable,Departement département){
        this.intitulé=intitulé;
        this.responsable=responsable;
        this.département=département;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getIntitulé() {
        return intitulé;
    }

    public static Enseignant getResponsable() {
        return responsable;
    }

    public static Departement getDépartement() {
        return département;
    }

    public void setIntitulé(String intitulé) {
        this.intitulé = intitulé;
    }

    public void setResponsable(Enseignant responsable) {
        this.responsable = responsable;
    }

    public void setDépartement(Departement département) {
        this.département = département;
    }

    public ArrayList<Module> getModule() {
        return module;
    }

    public void setModule(ArrayList<Module> module) {
        this.module = module;
    }
}

