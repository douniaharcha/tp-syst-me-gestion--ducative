package Sys_Gestion.Models;

import java.util.ArrayList;

public class Etudiant {

    private int id;
    private String nom;
    private String prénom;
    private String email;
    private int apogée;
    private Filière filière;

    ArrayList<Note> note = new ArrayList<Note>();

    public Etudiant(){}

    public Etudiant(String nom,String prénom,String email,int apogée,Filière filière){
        this.nom=nom;
        this.prénom=prénom;
        this.email=email;
        this.apogée=apogée;
        this.filière=filière;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public String getEmail() {
        return email;
    }

    public int getApogée() {
        return apogée;
    }

    public Filière getFilière() {
        return filière;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setApogée(int apogée) {
        this.apogée = apogée;
    }

    public void setFilière(Filière filière) {
        this.filière = filière;
    }

    public ArrayList<Note> getNote() {
        return note;
    }

    public void setNote(ArrayList<Note> note) {
        this.note = note;
    }

}
