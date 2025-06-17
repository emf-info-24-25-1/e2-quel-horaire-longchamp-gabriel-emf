package models;

public class Professeur {
    private String nom;
    private String prenom;
    private ModuleInfo[] modulesEnseignes;

    public Professeur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.modulesEnseignes = null;
    }

    public boolean enseigneCeModule(String nomDuModule) {
        boolean enseigneCeModule = false;
        for (int i = 0; i < modulesEnseignes.length; i++) {
            if (modulesEnseignes[i] != null && modulesEnseignes[i].getModulesEnseignes().equals(nomDuModule)) {
                enseigneCeModule = true;
            }
        }
        return enseigneCeModule;
    }

    public void ajouterModuleEnseignes(ModuleInfo module) {
        ModuleInfo[] modulesEnseignes2 = new ModuleInfo[modulesEnseignes.length + 1];
        for (int i = 0; i < modulesEnseignes.length; i++) {
            modulesEnseignes[i] = modulesEnseignes2[i];
        }
    }

    public void viderModules() {
        for (int i = 0; i < modulesEnseignes.length; i++) {
            modulesEnseignes[i] = null;
        }
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ModuleInfo[] getModulesEnseignes() {
        return modulesEnseignes;
    }

    @Override
    public String toString() {
        return "Professeur [nom=" + nom + ", prenom=" + prenom + ", modulesEnseignes=" + modulesEnseignes + "]";
    }

}
