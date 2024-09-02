package org.example.CoucheM.hérite;

import org.example.CoucheM.abstraite.Document;

import java.time.LocalDate;


public abstract class Magazine extends Document {
    private Integer Numero;



    public Magazine( String titre, String auteur, LocalDate datePublication, int nombreDePages,int Numero) {
        super(titre, auteur, datePublication, nombreDePages);
        this.Numero=Numero;
    }

          @Override
          public void emprunter() {
            if (!this.isStatus()) {
               this.setStatus(true);
                System.out.println("Le magazine a été emprunté avec succès.");

            }else{
                System.out.println("Le magazine est déjà emprunté.");

            }
          }

          @Override
          public void retourner() {
            if (this.isStatus()){
                this.setStatus(false);
                System.out.println("Le magazine a été retourné avec succès.");
            }else{
                System.out.println("Le magazine n'est pas emprunté.");

            }
          }

          @Override
          public void afficherDetails() {

              // Affichage des détails du document
              System.out.printf("%-10d | %-20s | %-30s | %-15s | %-10d |  %-12s | %-15s  %n",
                      getId(), getTitre(), getAuteur(), getDatePublication(), getNombreDePages(),
                      (isStatus() ? "Emprunté" : "Disponible"),Numero);


              System.out.println("---------------------------------------------------------------------------------------------------------------------------------");


             /* System.out.println("Titre: " + getTitre());
              System.out.println("Auteur: " + getAuteur());
              System.out.println("Date de Publication: " + getDatePublication());
              System.out.println("Nombre de Pages: " + getNombreDePages());
              System.out.println("Numéro: " + Numero);
              System.out.println("Status: " + (isStatus() ? "Emprunté" : "Disponible"));*/
          }

    @Override
    public String toString() {
        return "Magazine{" +
                "id=" + getId() +
                ", titre='" + getTitre() + '\'' +
                ", auteur='" + getAuteur() + '\'' +
                ", datePublication='" + getDatePublication() + '\'' +
                ", nombreDePages=" + getNombreDePages() +
                ", Numero=" + Numero +

                '}';
    }

}
