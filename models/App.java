package models;

public class App {

    public static final String[] NOMS_MODULES = {
        "G300", "187", "162", "123", "293", "117",
        "164", "216", "106", "231", "122", "431"
    };

    public static void main(String[] args) {
        // Création des modules
        ModuleInfo[] modules1ere = new ModuleInfo[12];
        for (int i = 0; i < NOMS_MODULES.length; i++) {
            modules1ere[i] = new ModuleInfo(NOMS_MODULES[i]);
        }

        // Création des professeurs
        Professeur[] profs = new Professeur[5];
        profs[0] = new Professeur("Mario", "Ramalho");
        profs[1] = new Professeur("Quentin", "Badoud");
        profs[2] = new Professeur("Nicolas", "Rouiller");
        profs[3] = new Professeur("Lionel", "Messi");
        profs[4] = new Professeur("Neymar", "Jr");

        // Création du service et attribution des modules
        ServiceFomationMaitres service = new ServiceFomationMaitres();

        while (!service.tousModulesCouverts(profs, modules1ere)) {
            service.attribuerModules(profs, modules1ere);
        }

        // Affichage des professeurs et des modules qu'ils enseignent
        System.out.println("L'école a engagé les professeurs suivants :");
        for (int i = 0; i < profs.length; i++) {
            System.out.println("- " + profs[i].getNom() + " " + profs[i].getPrenom() + " peut enseigner les modules :");
            ModuleInfo[] modules = profs[i].getModulesEnseignes();
            for (ModuleInfo m : modules) {
                System.out.println("   • " + m.getNom());
            }
        }

        // Planification de l'horaire
        System.out.println("\nIl est temps de préparer l'horaire.\n");

        Horaire horaire = new Horaire();
        boolean success = horaire.planifier(modules1ere, profs);

        horaire.afficherHoraire();

        if (success) {
            System.out.println("Modules planifiés avec succès !");
        } else {
            System.out.println("Problème de planification.");
        }
    }
}
