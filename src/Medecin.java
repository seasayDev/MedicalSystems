import java.io.Serializable;

public class Medecin implements Serializable {
    private String matricule;
    private String nom;
    private String prenom;
    private String telephone;
    private String courriel;

    public Medecin(String matricule, String nom, String prenom, String telephone, String courriel) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.courriel = courriel;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCourriel() {
        return courriel;
    }
}