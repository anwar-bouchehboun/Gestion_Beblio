package org.example.CoucheU.optionel;


import org.example.CoucheM.abstraite.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Recherche {

    private static final Map<Integer, Document> documentsMaping = new HashMap<>();

    public static void ajouterDocument(Document document) {
        documentsMaping.put(document.getId(), document);
    }

    public static Optional<Document> trouverDocumentParTitre(String titre) {
        return documentsMaping.values().stream()
                .filter(doc -> doc.getTitre().equalsIgnoreCase(titre))
                .findFirst();
    }

    public static Optional<Document> trouverDocumentParId(Integer id) {
        return Optional.ofNullable(documentsMaping.get(id));
    }

}
