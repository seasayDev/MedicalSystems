//Le patient est caractérisé par un code (code patient), son nom, son numéro de téléphone et son
//courriel.
package backend;
import java.util.ArrayList;

public class Patient {
    private String codePatient;
    private String nom;
    private String numTel;
    private String courriel;
   

    public Patient(String codePatient, String nom, String numTel, String courriel) {
        this.codePatient = codePatient;
        this.nom = nom;
        this.numTel = numTel;
        this.courriel = courriel;
    }

    public String getCodePatient() {
        return codePatient;
    }

    public void setCodePatient(String codePatient) {
        this.codePatient = codePatient;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}