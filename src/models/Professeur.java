package models;

import java.util.Arrays;

public class Professeur {
    private final String nom;
    private final String prenom;
    private ModuleInfo[] modulesEnseignes;

    public Professeur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.modulesEnseignes = new ModuleInfo[0]; 
    }

    public boolean enseigneCeModule(String nomDuModule) {
        for (int i = 0; i < modulesEnseignes.length; i++) {
            if (modulesEnseignes[i] != null &&
                modulesEnseignes[i].getNom().equals(nomDuModule)) {
                return true;
            }
        }
        return false;
    }

    public void ajouterModuleEnseigne(ModuleInfo module) {
        ModuleInfo[] nouveauxModules = new ModuleInfo[modulesEnseignes.length + 1];
        for (int i = 0; i < modulesEnseignes.length; i++) {
            nouveauxModules[i] = modulesEnseignes[i];
        }
        nouveauxModules[nouveauxModules.length - 1] = module;
        modulesEnseignes = nouveauxModules;
    }

    public void viderModules() {
        modulesEnseignes = new ModuleInfo[0]; 
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
        return "Professeur [nom=" + nom + ", prenom=" + prenom + ", modulesEnseignes="
                + Arrays.toString(modulesEnseignes) + "]";
    }

  
    }

