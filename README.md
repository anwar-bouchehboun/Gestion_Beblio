#Lien Planification : https://anouarab95.atlassian.net/jira/software/projects/GDBA/boards/3/backlog

Contexte du projet
Une bibliothèque municipale souhaite automatiser ses tâches via un système de gestion informatisé. Votre mission est de développer une application console en Java 8 pour gérer efficacement l'inventaire des livres et magazines, ainsi que les emprunts et retours.

​

Votre responsabilité consiste à :

• Concevoir une architecture en couches (présentation, métier, utilitaire)

• Implémenter les classes principales et leurs fonctionnalités

• Utiliser les concepts de base de Java (héritage)

• Gérer le projet avec Git et JIRA

​

Structure de l'application :

Couche de présentation :

Classe ConsoleUI pour l'interface utilisateur
Couche métier :

Classe abstraite Document
Classes Livre et Magazine (héritant de Document)
Classe Bibliotheque pour la gestion des documents
Couche utilitaire :

Classe DateUtils pour la manipulation des dates
​

Contenu des classes :

Classe abstraite Document :

• Attributs : id, titre, auteur, datePublication, nombreDePages

• Méthodes abstraites : emprunter(), retourner(), afficherDetails()

Classe Livre (hérite de Document) :

• Attribut supplémentaire : isbn

• Implémente les méthodes abstraites

Classe Magazine (hérite de Document) :

• Attribut supplémentaire : numero

• Implémente les méthodes abstraites

​

Fonctionnalités principales :

• Ajouter un document (livre ou magazine)

• Emprunter un document

• Retourner un document

• Afficher tous les documents

• Rechercher un document

​

Spécifications techniques :

• Utiliser ArrayList pour stocker les documents

• Implémenter une recherche rapide avec HashMap<String, Document>

• Intégrer Java Time API pour la gestion des dates

• Appliquer les expressions lambda

​

Interface utilisateur : Créer un menu interactif dans la console avec les options suivantes :

Ajouter un document
Emprunter un document
Retourner un document
Afficher tous les documents
Rechercher un document
Quitter
​

Veuillez entrer votre choix (1-6) :

​

Contraintes :

• Les données persistent en mémoire jusqu'à la fermeture de l'application

• Implémenter une validation des entrées utilisateur pour la gestion des erreurs possibles

​

Gestion de projet :

• Utiliser Git pour le contrôle de version

• Gérer les tâches avec JIRA

• Participer à des daily stand-ups simulés