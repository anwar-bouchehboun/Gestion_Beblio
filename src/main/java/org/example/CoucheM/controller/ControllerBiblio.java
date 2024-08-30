package org.example.CoucheM.controller;

import org.example.CoucheM.Bibliotheque;
import org.example.CoucheM.hérite.Livre;
import org.example.CoucheM.hérite.Magazine;
import org.example.CoucheU.Pattern.PattrenUtils;
import org.example.CoucheU.date.DateUtils;

import java.time.LocalDate;
import java.util.Scanner;


public class ControllerBiblio {


      Bibliotheque Bibliotheque = new Bibliotheque();

    public void AjouterDoc() {

        int id = PattrenUtils.getIntInput("Entrez l'ID du document (numérique) :");
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

    public void afficherTousLesDocuments() {
        Bibliotheque.afficherTousLesDocuments();
    }
}
