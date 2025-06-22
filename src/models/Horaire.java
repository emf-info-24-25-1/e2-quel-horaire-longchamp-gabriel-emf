package models;

public class Horaire {
    public static final int NBRE_DE_BLOCS = 6;
    private final Bloc[] blocs;

    public Horaire() {
        this.blocs = new Bloc[NBRE_DE_BLOCS];
        blocs[0] = new Bloc("B1S1");
        blocs[1] = new Bloc("B2S1");
        blocs[2] = new Bloc("B3S1");
        blocs[3] = new Bloc("B4S2");
        blocs[4] = new Bloc("B5S2");
        blocs[5] = new Bloc("B6S2");
    }

    public boolean planifier(ModuleInfo[] modules, Professeur[] profs) {
        boolean auMoinsUnPlanifie = false;
        for (ModuleInfo module : modules) {
            for (Professeur prof : profs) {
                if (prof.enseigneCeModule(module.getNom())) {
                    for (Bloc bloc : blocs) {
                        if (bloc.planifierModule(module)) {
                            prof.ajouterModuleEnseigne(module);
                            auMoinsUnPlanifie = true;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return auMoinsUnPlanifie;
    }

    public void afficherHoraire() {
        for (Bloc bloc : blocs) {
            System.out.println("Bloc : " + bloc.getNom());
            bloc.afficherHoraire();
        }
    }

    public Bloc moduleDansQuelBloc(ModuleInfo module) {
        for (Bloc bloc : blocs) {
            if (bloc.contientModule(module)) {
                return bloc;
            }
        }
        return null;
    }
}
