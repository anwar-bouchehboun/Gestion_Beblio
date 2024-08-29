package org.example.CoucheP.ConsoleUI;

import org.example.CoucheM.Bibliotheque;
import org.example.CoucheM.hérite.Livre;
import org.example.CoucheM.hérite.Magazine;
import org.example.CoucheU.Pattern.PattrenUtils;
import org.example.CoucheU.date.DateUtils;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleUI {
    private final Scanner choix= new Scanner(System.in);
    Bibliotheque Bibliotheque =new Bibliotheque();

 public void Start(){
     do {
     System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"Welcome to Bibliotheque : "+ CostumColor.RESET);
     System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"Choose  Option from Below According to your Designation  : " + CostumColor.RESET);
     System.out.println("Press 1 to" +CostumColor.PURPLE_BOLD_BRIGHT +"• Ajouter un document (Livre ou Magazine)"      + CostumColor.RESET);
     System.out.println("Press 2 to" +CostumColor.PURPLE_BOLD_BRIGHT +"• Emprunter un document"  + CostumColor.RESET);
     System.out.println("Press 3 to" +CostumColor.PURPLE_BOLD_BRIGHT +"• Retourner un document"+ CostumColor.RESET);
     System.out.println("Press 4 to" +CostumColor.PURPLE_BOLD_BRIGHT +"• Afficher tous les documents "+ CostumColor.RESET);
     System.out.println("Press 5 to" +CostumColor.PURPLE_BOLD_BRIGHT +"• Rechercher un document "+ CostumColor.RESET);
     System.out.println("Press 6 to" +CostumColor.PURPLE_BOLD_BRIGHT +" _____EXIT__________"+ CostumColor.RESET);
     System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);
         int ch = choix.nextInt();

     switch (ch) {
         case 1:
             AjouterDoc();
             break;
         case 2:
             Emprunter();
             break;
         case 3:
             Retourner();
             break;
         case 4:
             Bibliotheque.afficherTousLesDocuments();

             break;
         case 5:
             rechDocument();
             break;
         case 6 :
             System.out.println("-----_____Exit_______------");
             return;

         default:
             System.out.println(CostumColor.RED_BOLD_BRIGHT+"Invalid choice");
             break;
     }
       }while (true);
 }



 public void AjouterDoc() {

     int id = PattrenUtils.getIntInput("Entrez l'ID du document (numérique) :");
     String titre = PattrenUtils.getStringInput("Entrez le titre du document :");
     String auteur = PattrenUtils.getStringInput("Entrez l'auteur du document :");
     int nombreDePages = PattrenUtils.getIntInput("Entrez le nombre de pages :");

     Scanner choix = new Scanner(System.in);
     LocalDate datePublication;
     do {
         System.out.println("Entrez la date de publication (AAAA-MM-JJ) :");
         datePublication = DateUtils.parseDate(choix.nextLine());

         if (datePublication == null) {
             System.out.println("Date de publication invalide, opération annulée.");

         }
     } while (datePublication == null);
     int type = PattrenUtils.getDocumentType();
     if (type == 1) {
         String isbn = PattrenUtils.getStringInput("Entrez l'ISBN du livre :");
         Bibliotheque.AddDoc(new Livre(id, titre, auteur, datePublication, nombreDePages, isbn));
     } else if (type == 2) {
         int numero = PattrenUtils.getIntInput("Entrez le numéro du magazine :");
         Bibliotheque.AddDoc(new Magazine(id, titre, auteur, datePublication, nombreDePages, numero) {
         });
     } else {
         System.out.println("Type de document invalide.");
     }
 }

 public void Emprunter(){
     Scanner scanner= new Scanner(System.in);
     System.out.println("Entrez le titre du document :");
     String titre = scanner.nextLine();
     Bibliotheque.emprunterDocument(titre);
 }
 public  void Retourner(){
     Scanner scanner= new Scanner(System.in);
     System.out.println("Entrez le titre du document :");
     String titre = scanner.nextLine();
     Bibliotheque.retournerDocument(titre);
 }
    public void rechDocument(){

        Scanner scanner= new Scanner(System.in);
        System.out.println("Entrez le titre du document :");
        String titre = scanner.nextLine();
        Bibliotheque.rechDocument(titre);
    }

}
