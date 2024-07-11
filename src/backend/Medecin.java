import java.sql.Date;
import java.util.ArrayList;

public class Medecin {
    private Service service;
    private String matricule;
    private String nom;
    private String numTel;
    private String courriel;

    public Medecin(Service service, String matricule, String nom, String numTel, String courriel) {
        this.service = service;
        this.matricule = matricule;
        this.nom = nom;
        this.numTel = numTel;
        this.courriel = courriel;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }


    
}
