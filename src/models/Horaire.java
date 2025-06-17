package models;

public class Horaire {
    public static final int NBRE_DE_BLOCS = 6;
    private Bloc[] blocs;

    public Horaire(Bloc[] blocs) {
        this.blocs = new Bloc[NBRE_DE_BLOCS];
        blocs[0] = new Bloc("B1s1");
        blocs[1] = new Bloc("B2S1");
        blocs[2] = new Bloc("B3S1");
        blocs[3] = new Bloc("B4S2");
        blocs[4] = new Bloc("B5S2");
        blocs[5] = new Bloc("B6S2");
    }

    public boolean planifier(ModuleInfo[] modules, Professeur[] profs) {
        boolean planifie;
        for (int i = 0; i < modules.length; i++) {
            if (profs.enseigneCeModule) {
                modules.ajouterModuleEnseignes();
                planifie = true;
            } else {
                planifie = false;
            }
        }
        return planifie;
    }

    public void afficherHoraire() {
    for (int i = 0; i < blocs.length; i++) {
        blocs.afficherHoraire();
    }
    }

    public Bloc moduleDansQuelBloc(ModuleInfo module) {
        for (int i = 0; i < blocs.length; i++) {
            Bloc bloc = blocs[i].getModulesEnseignes().equals(module);
            return bloc;
        }
    }
}