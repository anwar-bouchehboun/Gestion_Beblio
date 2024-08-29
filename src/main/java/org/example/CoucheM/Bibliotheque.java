package org.example.CoucheM;

import org.example.CoucheM.abstraite.Document;
import org.example.CoucheP.ConsoleUI.CostumColor;

import java.util.*;

public class Bibliotheque {
    private final List<Document> documents;
    private final Map<Integer, Document> documentsMaping;
     public Bibliotheque(){
         documents=new ArrayList<>();
         documentsMaping= new HashMap<>();
     }


     public void AddDoc(Document document){
      /*   String doc = document.toString();
         System.out.println(doc);*/
        documents.add(document);
         documentsMaping.put(document.getId(),document);
         System.out.println(   CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"Document ajouté avec succès. "+ CostumColor.RESET);

     }
     //Affiche Doc
    public void afficherTousLesDocuments() {

        if (documents.isEmpty()) {
            System.out.println("Aucun document n'est disponible dans la bibliothèque.");
        } else {
            System.out.printf("%-10s | %-20s | %-30s | %-15s | %-10s  | %-12s |%n",
                    "ID", "Titre", "Auteur", "Date Pub.", "Pages", "Statut");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

            //method reference
            //lambda
            documents.forEach(Document::afficherDetails);
      /*  for (Document document : documents) {
            document.afficherDetails();
        }*/
        }
    }
//filter par titre
    public Optional<Document> trouverDocumentParTitre(String titre) {
        //Hashmap
        return documentsMaping.values().stream()
                .filter(doc -> doc.getTitre().equalsIgnoreCase(titre))
                .findFirst();
    }
   // emprunter Document
    public void emprunterDocument(String titre) {

        Optional<Document> document=  trouverDocumentParTitre(titre);

        document.ifPresentOrElse(Document::emprunter, () -> System.out.println("Document introuvable."));
    }
//retourner Document
    public  void retournerDocument(String titre){
        Optional<Document> document=  trouverDocumentParTitre(titre);
        document.ifPresentOrElse(Document::retourner, () -> System.out.println("Document introuvable."));

    }
    public void rechDocument(String titre){
        Optional<Document> document=  trouverDocumentParTitre(titre);
        document.ifPresentOrElse(Document::afficherDetails, () -> System.out.println("Aucun document trouvé avec le titre \"" + titre + "\"."));

    }


}
