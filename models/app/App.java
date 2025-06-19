package app;

import models.Horaire;
import models.ModuleInfo;
import models.Professeur;

public class App {

   public static final String[] NOMS_MODULES = { "G300", "187", "162", "123", "293", "117", "164", "216", "106", "231",
         "122", "431" };

   public static void main(String[] args) {
      Horaire horaire = new Horaire();
      ModuleInfo modules1ere = new ModuleInfo[12];
      modules1ere[0] =  new ModuleInfo("G300");
      modules1ere[1] =  new ModuleInfo("187");
      modules1ere[2] =  new ModuleInfo("162");
      modules1ere[3] =  new ModuleInfo("123");
      modules1ere[4] =  new ModuleInfo("293");
      modules1ere[5] =  new ModuleInfo("117");
      modules1ere[6] =  new ModuleInfo("164");
      modules1ere[7] =  new ModuleInfo("231");
      modules1ere[8] =  new ModuleInfo("216");
      modules1ere[9] =  new ModuleInfo("106");
      modules1ere[10] =  new ModuleInfo("122");
      modules1ere[11] =  new ModuleInfo("431");

      Professeur profs = new Professeur[5];
      profs[0] = new Professeur("Mario", "Ramalho");
      profs[1] = new Professeur("Quentin", "Badoud");
      profs[2] = new Professeur("Nicolas", "Rouiller");
      profs[3] = new Professeur("Lionel", "Messi");
      profs[4] = new Professeur("Neymar", "Jr");
      while (!tousModulesCouverts()) {
         attribuerModules(profs, modules1ere);
         tousModulesCouverts(profs, modules1ere);
      }
      System.out.println("L'école a engagé les professeurs suivant : ");
      for (int i = 0; i < profs.length; i++) {
         System.out.println("-" + profs + "peut enseigner les modules :" + getModulesEnseignes());
         System.out.println(" " + modules1ere.getNom());
         System.out.println();
      }
      System.out.println("\n il est de préparer l'horaire.\n");
      planifier(modules1ere, profs);
      afficherHoraire();
      Horaire success;
      if (success) {
         System.out.println("modules planifiés avec succés");
      } else {
         System.out.println("problème de planification");
      }
   }
}