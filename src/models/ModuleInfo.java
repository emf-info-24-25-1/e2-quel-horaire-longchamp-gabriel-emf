package models;

public class ModuleInfo {
    //MR Manque le final
    private String nom;
    private Professeur professeur;

    public ModuleInfo(String nom) {
        this.nom = nom;
        this.professeur = null;
    }

    public String getNom() {
        return nom;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    @Override
    public String toString() {
        //MR si le professeur est null qu'est-ce qui se passe ?
        return nom + "avec" + professeur;
    }

}
