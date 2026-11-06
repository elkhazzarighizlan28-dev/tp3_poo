import java.util.*;
/**
 * Compte4
 */
public class Compte4{

    private static int prochainNumero = 1 ;
    private final int  numero ;
    private final String titulaire ;
    private double solde ;
    public Compte4(String titulaire, double soldeInitial) {
    if (titulaire == null || titulaire.isBlank()) {
        throw new IllegalArgumentException("titulaire vide");
    }
    if (soldeInitial < 0) {
        throw new IllegalArgumentException("solde initial negatif");
    }
    this.numero = prochainNumero++;   
    this.titulaire = titulaire;
    this.solde = soldeInitial;
    }
    public int getNumero() {
    return numero;
    }

    public String getTitulaire() {
    return titulaire;
    }

    public double getSolde() {
    return solde;
    }
    public void deposer(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("montant invalide");
        }
        solde = solde + montant;
    }

    public void retirer(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("montant invalide");
        }
        if (montant > solde) {
            throw new IllegalArgumentException("solde insuffisant");
        }
        solde = solde - montant;
    }
    public static int nombreComptes() {
    return prochainNumero - 1;
    }

    public static Compte4 depuisLigneCsv(String ligne) {
    String[] champs = ligne.split(";");
    if (champs.length != 2) {
        throw new IllegalArgumentException("ligne mal formee : " + ligne);
    }
    double solde;
    try {
        solde = Double.parseDouble(champs[1]);
    } catch (NumberFormatException e) {
        throw new IllegalArgumentException("solde non numerique : " + champs[1]);
    }
    return new Compte4(champs[0].trim(), solde);
    }



    @Override
    public String toString() { 
    return String.format(Locale.ROOT, "Compte %d (%s) : %.2f", numero, titulaire, solde);
}
public static void main(String[] args) {
    String[] lignes = {"Youssef; 250.0" , "Salma;80.5","Karim;abc","hind"};
    for (String ligne : lignes) {
        try {
            System.out.println(Compte4.depuisLigneCsv(ligne));
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
    System.out.println("Nombre de comptes crees : " + Compte4.nombreComptes());

}
}