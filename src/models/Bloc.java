package models;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class Bloc {
    public static final int NBRE_DEMI_JOURS_SEMAINE = 10;
    private final String nom;
    private final ModuleInfo[] modules;

    public Bloc(String nom) {
        this.nom = nom;
        this.modules = new ModuleInfo[NBRE_DEMI_JOURS_SEMAINE];
    }

    public boolean planifierModule(ModuleInfo module) {
        for (int i = 0; i < modules.length; i++) {
            if (modules[i] == null) {
                modules[i] = module;
                return true;
            }
        }
        return false;
    }

    public void afficherHoraire() {
        for (int i = 0; i < modules.length; i++) {
            String moment = (i % 2 == 0) ? "AM" : "PM";
            String jour = DayOfWeek.of((i / 2 + 1) % 7 == 0 ? 7 : (i / 2 + 1))
                    .getDisplayName(TextStyle.FULL, Locale.FRANCE);
            System.out.println(jour + " " + moment + " : " +
                    (modules[i] != null ? modules[i].getNom() : "Aucun module"));
        }
    }

    public boolean estTotalementPlanifie() {
        for (ModuleInfo m : modules) {
            if (m == null) return false;
        }
        return true;
    }

    public boolean contientModule(ModuleInfo module) {
        for (ModuleInfo m : modules) {
            if (m == module) {
                return true;
            }
        }
        return false;
    }

    public ModuleInfo[] getModules() {
        return modules;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Bloc [nom=" + nom + "]";
    }
}
