package Sys_Gestion.Models;

import java.util.ArrayList;

public class Enseignant {

    public int length;
    private int id;
    private String nom;
    private String prénom;
    private String email;
    private String grade;
    private Departement département;

    ArrayList<Module> module = new ArrayList<Module>();

    public Enseignant() {
    }

    public Enseignant(String nom, String prénom, String email, String grade, Departement département) {
        this.nom = nom;
        this.prénom = prénom;
        this.email = email;
        this.grade = grade;
        this.département = département;
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

    public String getGrade() {
        return grade;
    }

    public Departement getDépartement() {
        return département;
    }

    public void setDépartement(Departement département) {
        this.département = département;
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

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public ArrayList<Module> getModule() {
        return module;
    }

    public void setModules(ArrayList<Module> module) {
        this.module = module;
    }

    public boolean equals(Enseignant obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getId() != this.id) {
            return false;
        }

        return true;
    }



}
