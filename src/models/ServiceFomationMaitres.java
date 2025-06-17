package models;

public class ServiceFomationMaitres {
    public static final int MIN = 0;
    public static final int MAX = 11;

    public void attribuerModules(Professeur[] professeurs, ModuleInfo[] modules) {
        int index = (int) (Math.random() * (MAX - MIN + 1)) + MIN;
        for (int i = 0; i < modules.length; i++) {
            if (modules.enseigneCeModule() == false) {
                continue;
            } else {
                modules.ajouterModuleEnseignes();
            }
        }
    }

    public boolean tousModulesCouverts(Professeur[] profs, moduleInfo[] modules){
       boolean moduleCouvert = true;
  for (int i = 0; i < modules.length; i++) {
    if (enseigneCeModule() == false) {
        moduleCouvert = false;
    }
  }
    return moduleCouvert;
    }
  }
