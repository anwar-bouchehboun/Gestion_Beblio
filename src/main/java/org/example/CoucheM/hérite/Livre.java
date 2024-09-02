package org.example.CoucheM.hérite;

import org.example.CoucheM.abstraite.Document;

import java.time.LocalDate;

public class Livre extends Document {

    private String isbn;

    public Livre(String titre, String auteur, LocalDate datePublication, int nombreDePages, String isbn) {
        super( titre, auteur, datePublication, nombreDePages);
        this.isbn = isbn;
    }

    @Override
    public void emprunter() {
        if (!this.isStatus()) {
            this.setStatus(true);
            System.out.println("Le Livre a été emprunté avec succès.");

        }else{
            System.out.println("Le Livre est déjà emprunté.");

        }
    }

    @Override
    public void retourner() {
        if (this.isStatus()){
            this.setStatus(false);
            System.out.println("Le Livre a été retourné avec succès.");
        }else{
            System.out.println("Le Livre n'est pas emprunté.");

        }
    }

    @Override
    public void afficherDetails() {

        // Affichage des détails du document
        System.out.printf("%-10d | %-20s | %-30s | %-15s | %-10d |  %-12s | %-15s  %n",
                getId(), getTitre(), getAuteur(), getDatePublication(), getNombreDePages(),
                (isStatus() ? "Emprunté" : "Disponible"),isbn);

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");


    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + getId() +
                ", titre='" + getTitre() + '\'' +
                ", auteur='" + getAuteur() + '\'' +
                ", datePublication='" + getDatePublication() + '\'' +
                ", nombreDePages=" + getNombreDePages() +
                ", Isbn=" + isbn +
                '}';
    }
}
