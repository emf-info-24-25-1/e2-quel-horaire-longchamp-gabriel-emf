package models;

public class Professeur {
    //MR Manque les finals sur les deux premiers attributs
    private String nom;
    private String prenom;
    private ModuleInfo[] modulesEnseignes;

    public Professeur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        //MR Il faut créer un tableau de taille de 0 sinon on pourra jamais rajouter des modules à l'interieur
        this.modulesEnseignes = null;
    }

    public boolean enseigneCeModule(String nomDuModule) {
        boolean enseigneCeModule = false;
        for (int i = 0; i < modulesEnseignes.length; i++) {
            //MR C'est modulesEnseignes[i].getNom()
            if (modulesEnseignes[i] != null && modulesEnseignes[i].getModulesEnseignes().equals(nomDuModule)) {
                enseigneCeModule = true;
                //MR Un petit break ici
            }
        }
        return enseigneCeModule;
    }

    public void ajouterModuleEnseignes(ModuleInfo module) {
        //MR Regarde à nouveau comment rajouter dasn un tableau dynamique
        ModuleInfo[] modulesEnseignes2 = new ModuleInfo[modulesEnseignes.length + 1];
        for (int i = 0; i < modulesEnseignes.length; i++) {
            modulesEnseignes[i] = modulesEnseignes2[i];
        }
    }

    public void viderModules() {
        //MR Le tableau doit être de taille 0
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
        //MR toString non conforme qui est celui de base autogénéré
        return "Professeur [nom=" + nom + ", prenom=" + prenom + ", modulesEnseignes=" + modulesEnseignes + "]";
    }

}
