package Sys_Gestion.Models;

import java.util.ArrayList;

public class Departement {

    private int id;
    private String intitulé;
    private Enseignant responsable;

    ArrayList<Filière> filière = new ArrayList<Filière>();

    public Departement(){ }

    public Departement(String intitulé,Enseignant responsable){
        this.intitulé=intitulé;
        this.responsable=responsable;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getIntitulé() {
        return intitulé;
    }

    public Enseignant getResponsable() {
        return responsable;
    }

    public void setIntitulé(String intitulé) {
        this.intitulé = intitulé;
    }

    public void setResponsable(Enseignant responsable) {
        this.responsable = responsable;
    }

    public ArrayList<Filière> getFilière() {
        return filière;
    }

    public void setFilière(ArrayList<Filière> filière) {
        this.filière = filière;}
}
