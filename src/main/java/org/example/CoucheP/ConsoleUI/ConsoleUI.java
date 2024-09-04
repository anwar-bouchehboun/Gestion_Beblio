package org.example.CoucheP.ConsoleUI;


import org.example.CoucheM.controller.ControllerBiblio;
import java.util.Scanner;


public class ConsoleUI {
    ControllerBiblio Bibliotheque =new ControllerBiblio();
    private final Scanner choix= new Scanner(System.in);

 public  void Start(){
     do {
         System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
         System.out.println(CostumColor.WHITE_BOLD_BRIGHT+"|                  Welcome to Bibliotheque :     "+ CostumColor.RESET);
         System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option from Below According to your Designation  : " + CostumColor.RESET);
         System.out.println("|Press 1 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Ajouter un document (Livre ou Magazine)"      + CostumColor.RESET);
         System.out.println("|Press 2 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Liste Emprunter/Retouner un document"  + CostumColor.RESET);
         System.out.println("|Press 3 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Afficher tous les documents "+ CostumColor.RESET);
         System.out.println("|Press 4 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Rechercher un document "+ CostumColor.RESET);
         System.out.println("|Press 5 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| Supprimer et modifer Documents"+ CostumColor.RESET);
         System.out.println("|Press 6 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT__________"+ CostumColor.RESET);
         System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);

         System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);

         int ch = choix.nextInt();

     switch (ch) {
         case 1:
             Bibliotheque.AjouterDoc();
             break;
         case 2:
             Bibliotheque.MenuEmpRetouDoc();
             break;
         case 3:
             Bibliotheque.afficherTousLesDocuments();
             break;
         case 4:
             Bibliotheque.rechDocument();

             break;
         case 5:
             Bibliotheque.DeleteUpdateoDoc();
             break;
         case 6:
             System.out.println(CostumColor.PURPLE_BOLD_BRIGHT +"-----_____Exit_______------"+ CostumColor.RESET);
             return;


         default:
             System.out.println(CostumColor.RED_BOLD_BRIGHT+"Invalid choice");
             break;
     }
       }while (true);
 }


}
