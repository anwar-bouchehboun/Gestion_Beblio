package org.example.CoucheP.ConsoleUI;

import org.example.CoucheM.Bibliotheque;
import org.example.CoucheM.hérite.Livre;
import org.example.CoucheM.hérite.Magazine;
import org.example.CoucheU.date.DateUtils;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI {
    private static Scanner choix= new Scanner(System.in);
    Bibliotheque Bibliotheque =new Bibliotheque();

 public void Start(){
     do {
     System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"Welcome to Bibliotheque : "+ CostumColor.RESET);
     System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"Choose  Option from Below According to your Designation  : " + CostumColor.RESET);
     System.out.println("Press 1 to" +CostumColor.PURPLE_BOLD_BRIGHT +"• Ajouter un document (livre ou magazine)"      + CostumColor.RESET);
     System.out.println("Press 2 to" +CostumColor.PURPLE_BOLD_BRIGHT +"• Emprunter un document"  + CostumColor.RESET);
     System.out.println("Press 3 to" +CostumColor.PURPLE_BOLD_BRIGHT +"• Retourner un document"+ CostumColor.RESET);
     System.out.println("Press 4 to" +CostumColor.PURPLE_BOLD_BRIGHT +"• Afficher tous les documents "+ CostumColor.RESET);
     System.out.println("Press 5 to" +CostumColor.PURPLE_BOLD_BRIGHT +"• Rechercher un document "+ CostumColor.RESET);
     System.out.println("Press 6 to" +CostumColor.PURPLE_BOLD_BRIGHT +" _____EXIT__________"+ CostumColor.RESET);
     System.out.println("Choix " +CostumColor.PURPLE_BOLD_BRIGHT +" CHOIX "+ CostumColor.RESET);
         int ch = choix.nextInt();

     switch (ch) {
         case 1:
             AjouterDoc();
             break;
         case 2:

             break;
         case 3:

             break;
         case 4:
             Bibliotheque.afficherTousLesDocuments();

             break;
         case 5:
             break;
         case 6 :
             break;
         default:
             System.out.println(CostumColor.RED_BOLD_BRIGHT+"Invalid choice");
             break;
     }
       }while (true);
 }



 public void AjouterDoc() {

     Scanner choix = new Scanner(System.in);


     System.out.println("Entrez l'ID du document :");
     Integer id = Integer.parseInt(choix.nextLine());
     System.out.println("Entrez le titre du document :");
     String titre = choix.nextLine();
     System.out.println("Entrez l'auteur du document :");
     String auteur = choix.nextLine();
     LocalDate datePublication;
     do {
         System.out.println("Entrez la date de publication (AAAA-MM-JJ) :");
         datePublication = DateUtils.parseDate(choix.nextLine());

         if (datePublication == null) {
             System.out.println("Date de publication invalide, opération annulée.");

         }
     } while (datePublication == null);

     System.out.println("Entrez le nombre de pages :");
     int nombreDePages = choix.nextInt();
     choix.nextLine();
     System.out.println("Quel type de document voulez-vous ajouter ? (1. Livre, 2. Magazine)");
     int type = choix.nextInt();

     if (type == 1) {
         System.out.println("Entrez l'ISBN du livre :");
         String isbn = choix.nextLine();
         //Bibliotheque.AddDoc(new Livre(id, titre, auteur, datePublication, nombreDePages, isbn));
     } else if (type == 2) {
         System.out.println("Entrez le numéro du magazine :");
         int numero = choix.nextInt();
         choix.nextLine();  // Consume newline
         Bibliotheque.AddDoc(new Magazine(id, titre, auteur, datePublication, nombreDePages, numero) {
         });
     } else {
         System.out.println("Type de document invalide.");
     }
 }
}
