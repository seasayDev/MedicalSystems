import java.io.Serializable;

public class Patient implements Serializable {
    private String code;
    private String nom;
    private String prenom;
    private String telephone;
    private String courriel;

    public Patient(String code, String nom, String prenom, String telephone, String courriel) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.courriel = courriel;
    }

    public String getCode() {
        return code;
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