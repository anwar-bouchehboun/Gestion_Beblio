package org.example.CoucheM;

import org.example.CoucheM.abstraite.Document;
import org.example.CoucheP.ConsoleUI.CostumColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bibliotheque {
    private List<Document> documents;
    private Map<Integer, Document> documentsMaping;
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
    public void afficherTousLesDocuments() {
         //method reference
      //  documents.forEach(Document::afficherDetails);
        for (Document document : documents) {
            document.afficherDetails();
        }
    }


}
