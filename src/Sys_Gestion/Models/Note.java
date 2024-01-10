package Sys_Gestion.Models;

public class Note {
    private float note;
    private Etudiant etudiant;
    private Filière filière;

    public Note() {
    }
    public Note(float note, Etudiant etudiant, Filière filiere) {
        this.note = note;
        this.etudiant = etudiant;
        this.filière = filière;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Filière getFilière() {
        return filière;
    }

    public void setFilière(Filière filiere) {
        this.filière = filière;
    }
}
