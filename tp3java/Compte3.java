import java.util.*;
public class Compte3{

    private static int prochainNumero = 1 ;
    private final int  numero ;
    private final String titulaire ;
    private double solde ;
    public Compte3(String titulaire, double soldeInitial) {
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

    @Override
    public String toString() { 
    return String.format(Locale.ROOT, "Compte %d (%s) : %.2f", numero, titulaire, solde);
}
public static void main(String[] args) {
    Compte3 c = new Compte3("Amina", 100.0);
    c.deposer(20);
    System.out.println("Numero : " + c.getNumero());
    System.out.println("Titulaire : " + c.getTitulaire());
    System.out.printf(Locale.ROOT, "Solde : %.2f%n", c.getSolde());
}
}
