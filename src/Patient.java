//Le patient est caractérisé par un code (code patient), son nom, son numéro de téléphone et son
//courriel.

import java.util.ArrayList;

public class Patient {
    private String codePatient;
    private String nom;
    private String numTel;
    private String courriel;
    private ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
    private ArrayList<Examen> examens = new ArrayList<Examen>();

    public Patient(String codePatient, String nom, String numTel, String courriel) {
        this.codePatient = codePatient;
        this.nom = nom;
        this.numTel = numTel;
        this.courriel = courriel;
        prescriptions = new ArrayList<Prescription>();
        examens = new ArrayList<Examen>();
    }

    public void addPrescription(Prescription prescription){
        prescriptions.add(prescription);
    }

    public ArrayList<Examen> getExamens() {
        return examens;
    }

    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
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