package org.example.CoucheM;

import org.example.CoucheM.abstraite.Document;
import org.example.CoucheP.ConsoleUI.CostumColor;
import org.example.CoucheU.optionel.Recherche;

import java.time.LocalDate;
import java.util.*;

public class Bibliotheque {
    private final List<Document> documents;
     public Bibliotheque(){
         documents=new ArrayList<>();
        // documentsMaping= new HashMap<>();
     }

     public void AddDoc(Document document){
        documents.add(document);
         Recherche.ajouterDocument(document);
       //  documentsMaping.put(document.getId(),document);
         System.out.println(   CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"Document ajouté avec succès. "+ CostumColor.RESET);
         System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
     }
     //Affiche Doc
    public void afficherTousLesDocuments() {

        if (documents.isEmpty()) {
            System.out.println("Aucun document n'est disponible dans la bibliothèque.");
        } else {
            System.out.printf("%-10s | %-20s | %-30s | %-15s | %-10s  | %-12s |%-15s %n",
                    "ID", "Titre", "Auteur", "Date Pub.", "Pages", "Statut", "ISBN/Numéro");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

            //method reference
            //lambda
            documents.forEach(Document::afficherDetails);
      /*  for (Document document : documents) {
            document.afficherDetails();
        }*/
        }
    }
    public void affichedocumentEmp(){
        if (documents.stream().anyMatch(Document::isStatus)) {
            System.out.printf("%-10s | %-20s | %-30s | %-15s | %-10s  | %-12s |%-15s %n",
                    "ID", "Titre", "Auteur", "Date Pub.", "Pages", "Statut", "ISBN/Numéro");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            documents.stream().filter(Document::isStatus).forEach(Document::afficherDetails);

        } else {
            System.out.println("Aucun document Emprunt  n'est disponible dans la bibliothèque.");
        }
        }

   // emprunter Document
    public void emprunterDocument(String titre) {
        Optional<Document> document = Recherche.trouverDocumentParTitre(titre);
        document.ifPresentOrElse(Document::emprunter, () -> System.out.println("Document introuvable."));
    }
//retourner Document
    public void retournerDocument(String titre) {
        Optional<Document> document = Recherche.trouverDocumentParTitre(titre);
        document.ifPresentOrElse(Document::retourner, () -> System.out.println("Document introuvable."));
    }
//Search
    public void rechDocument(String titre) {
        Optional<Document> document = Recherche.trouverDocumentParTitre(titre);
        System.out.printf("%-10s | %-20s | %-30s | %-15s | %-10s | %-12s |  %-12s %n",
                "ID", "Titre", "Auteur", "Date Pub.", "Pages", "Statut","Isbn/Numero");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

        document.ifPresentOrElse(
                Document::afficherDetails,
                () -> System.out.println("Aucun document trouvé avec le titre \"" + titre + "\".")
        );
    }
//Search Id
   public void  rechDocumentGetId(int id){
       Optional<Document> document = Recherche.trouverDocumentParId(id);
       System.out.printf("%-10s | %-20s | %-30s | %-15s | %-10s | %-12s |  %-12s %n",
               "ID", "Titre", "Auteur", "Date Pub.", "Pages", "Statut","Isbn/Numero");
       System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

       document.ifPresentOrElse(
               Document::afficherDetails,
               () -> System.out.println("Aucun document trouvé avec le id \"" + id + "\".")
       );
   }
   //update document
    public void UpdateDoc(int id, String title, String auteur, LocalDate datePb,int nmbPage){
         Optional<Document> document= Recherche.trouverDocumentParId(id);
         document.ifPresentOrElse(
                 doc->{
                     doc.setTitre(title);
                     doc.setAuteur(auteur);
                     doc.setDatePublication(datePb);
                     doc.setNombreDePages(nmbPage);
                     System.out.println(CostumColor.BROWN_BACKGROUND + CostumColor.WHITE_BOLD_BRIGHT + "Document mis à jour avec succès." + CostumColor.RESET);

                 },()->System.out.println("Aucun document trouvé avec le id \"" + id + "\".")

         );
    }
    //Delete Doc
    public void DeleteDoc(int id){
        Optional<Document> document= Recherche.trouverDocumentParId(id);
          document.ifPresentOrElse(doc->{
           documents.remove(doc);
    System.out.println(CostumColor.BROWN_BACKGROUND + CostumColor.WHITE_BOLD_BRIGHT + "Document supprimé avec succès." + CostumColor.RESET);

          },()->System.out.println("Aucun document trouvé avec le id \"" + id + "\"."));
    }
}