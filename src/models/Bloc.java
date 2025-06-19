package models;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;

public class Bloc {
    public static final int NBRE_DEMI_JOURS_SEMAINE = 10;
    //MR Les deux attributs peuvent être final
    private String nom;
    private ModuleInfo[] modules;

    public Bloc(String nom) {
        this.nom = nom;
        this.modules = new ModuleInfo[NBRE_DEMI_JOURS_SEMAINE];
        modules[0] = new Module("Lundi AM", "Matu");
        modules[1] = new Module("Lundi PM", "Matu");
        modules[2] = new Module("Matu AM", "Matu");
        modules[3] = new Module("Matu PM", "Matu");
        modules[4] = new Module("null AM", null);
        modules[5] = new Module("null PM", null);
        modules[6] = new Module("null AM", null);
        modules[7] = new Module("null PM", null);
        modules[8] = new Module("null AM", null);
        modules[9] = new Module("null PM", null);

    }

    public boolean planifierModule(ModuleInfo module) {
        for (int i = 0; i < modules.length; i++) {
            if (modules[i] == null) {
                 return true;
            } else {
                return false;
            } 
        } 
        return true;
    }

    public void afficherHoraire() {
        for (int i = 0; i < modules.length; i++) {
            modules[i] = DayOfWeek.values()[1 + i / 2].getDisplayName(TextStyle.FULL, Locale.FRANCE);
    }
}

    //MR Il faut parcourir tout le tableau et si un module est null alors on peut retourner false
    public boolean estTotalementPlanifie() {
        for (int i = 0; i < modules.length; i++) {
            if (modules[i] == null) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean contientModule(ModuleInfo module) {
        boolean contientModule;
        for (int i = 0; i < modules.length; i++) {
            //MR Ici c'est modules[i] l'élément courant et attention c'est un == et non un equals pour vérifier si c'est le même objet
            if (modules.getNom().equals(module)) {
                contientModule = true;
            } else {
                contientModule = false;
            }
        }
        return contientModule;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        //MR Format par défaut
        return "Bloc [nom=" + nom + "]";
    }

}

