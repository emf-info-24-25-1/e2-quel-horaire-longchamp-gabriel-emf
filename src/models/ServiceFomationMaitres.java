package models;

public class ServiceFomationMaitres {
    public void attribuerModules(Professeur[] professeurs, ModuleInfo[] modules) {
        for (int i = 0; i < modules.length; i++) {
            ModuleInfo module = modules[i];
            for (int j = 0; j < professeurs.length; j++) {
                Professeur prof = professeurs[j];
                if (!prof.enseigneCeModule(module.getNom())) {
                    prof.ajouterModuleEnseigne(module);
                    break;
                }
            }
        }
    }

    public boolean tousModulesCouverts(Professeur[] profs, ModuleInfo[] modules) {
        for (int i = 0; i < modules.length; i++) {
            boolean estCouverts = false;
            for (int j = 0; j < profs.length; j++) {
                if (profs[j].enseigneCeModule(modules[i].getNom())) {
                    estCouverts = true;
                    break;
                }
            }
            if (!estCouverts) {
                return false;
            }
        }
        return true;
    }
}
