package Sys_Gestion.Models;

public class Module {

    private int id;
    private String intitulé;
    private Filière filière;
    private Enseignant professeur;

    public Module(){}

    public Module(String intitulé,Filière filière,Enseignant professeur){
        this.intitulé=intitulé;
        this.filière=filière;
        this.professeur=professeur;
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

    public Filière getFilière() {
        return filière;
    }

    public Enseignant getProfesseur() {
        return professeur;
    }

    public void setIntitulé(String intitulé) {
        this.intitulé = intitulé;
    }

    public void setFilière(Filière filière) {
        this.filière = filière;
    }

    public void setProfesseur(Enseignant professeur) {
        this.professeur = professeur;
    }
}
