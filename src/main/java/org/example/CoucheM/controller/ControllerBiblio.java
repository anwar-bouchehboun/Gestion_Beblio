package org.example.CoucheM.controller;

import org.example.CoucheM.Bibliotheque;
import org.example.CoucheM.hérite.Livre;
import org.example.CoucheM.hérite.Magazine;
import org.example.CoucheP.ConsoleUI.CostumColor;
import org.example.CoucheU.Pattern.PattrenUtils;
import org.example.CoucheU.date.DateUtils;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ControllerBiblio {


      Bibliotheque Bibliotheque = new Bibliotheque();

    public void AjouterDoc() {

     //   int id = PattrenUtils.getIntInput("Entrez l'ID du document (numérique) :");
        String titre = PattrenUtils.getStringInput("Entrez le titre du document :");
        String auteur = PattrenUtils.getStringInput("Entrez l'auteur du document :");
        int nombreDePages = PattrenUtils.getIntInput("Entrez le nombre de pages :");

        Scanner choix = new Scanner(System.in);
        LocalDate datePublication,currentDate;
        currentDate  = LocalDate.now();
        do {
            System.out.println("Entrez la date de publication (AAAA-MM-JJ) :");
            datePublication = DateUtils.parseDate(choix.nextLine());

            if (datePublication == null || datePublication.isAfter(currentDate)) {
                System.out.println("Date de publication invalide, opération annulée.");

            }
        } while (datePublication == null || datePublication.isAfter(currentDate));
        int type = PattrenUtils.getDocumentType();
        if (type == 1) {

            String isbn = PattrenUtils.getStringInputType("Entrez l'ISBN du livre :");

                Bibliotheque.AddDoc(new Livre(titre, auteur, datePublication, nombreDePages, isbn));



        } else if (type == 2) {
            int numero = PattrenUtils.getIntInput("Entrez le numéro du magazine :");
            Bibliotheque.AddDoc(new Magazine(titre, auteur, datePublication, nombreDePages, numero) {
            });
        } else {
            System.out.println("Type de document invalide.");
        }
    }


    public void Emprunter(){
        Bibliotheque.affichedocumentEmp();
        Scanner scanner= new Scanner(System.in);
        System.out.println("Entrez le titre du document :");
        String titre = scanner.nextLine();
        Bibliotheque.emprunterDocument(titre);
    }
    public  void Retourner(){
        Bibliotheque.affichedocumentEmp();
        Scanner scanner= new Scanner(System.in);
        System.out.println("Entrez le titre du document :");
        String titre = scanner.nextLine();
        Bibliotheque.retournerDocument(titre);
    }

    public void MenuEmpRetouDoc(){

        do {
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option from Below According to your Designation  : " + CostumColor.RESET);
            System.out.println("|Press 1 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Emprunter Doc "      + CostumColor.RESET);
            System.out.println("|Press 2 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Retourner Doc"  + CostumColor.RESET);
            System.out.println("|Press 3 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Affiche EMP/Ret Doc"  + CostumColor.RESET);
            System.out.println("|Press 4 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT (Emp_Ret) __________"+ CostumColor.RESET);
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);

            System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);
            Scanner choix= new Scanner(System.in);
            String ch = choix.nextLine();
            switch (ch){
                case "1":
                    Emprunter();
                    break;
                case "2":
                    Retourner();
                    break;
                case "3":
                    Bibliotheque.affichedocumentEmp();
                    break;
                case "4" :
                    System.out.println(CostumColor.PURPLE_BOLD_BRIGHT +"-----_____Exit EMP_Ret ------"+ CostumColor.RESET);
                    return;

                default:
                    System.out.println(CostumColor.RED_BOLD_BRIGHT+"Invalid choice");
                    break;
            }
        }while (true);
    }


    public void afficherTousLesDocuments() {
        Bibliotheque.afficherTousLesDocuments();
    }

    public void rechDocument() {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println(CostumColor.PURPLE_BOLD_BRIGHT +"Choisissez une option :\n1. Recherche par titre\n2. Recherche par ID\n3. Quitter"  + CostumColor.RESET);
            String choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    System.out.println("Entrez le titre du document :");
                    String titre = scanner.nextLine();
                    Bibliotheque.rechDocument(titre);
                    break;

                case "2":
                    System.out.println("Entrez l'id du document :");
                    try {
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        Bibliotheque.rechDocumentGetId(id);
                    } catch (InputMismatchException e) {
                        System.out.println("Veuillez entrer un nombre valide pour l'id.");
                        scanner.nextLine();
                    }
                    break;

                case "3":
                    System.out.println(CostumColor.PURPLE_BOLD_BRIGHT + "-----_____Exit Recherche_______------" + CostumColor.RESET);
                    return;

                default:
                    System.out.println(CostumColor.RED_BOLD_BRIGHT + "Choix invalide, veuillez réessayer." + CostumColor.RESET);
                    break;
            }
        }
    }
}
