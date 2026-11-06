import java.util.*;

 public class Compte {
    private String titulaire;
    private double solde;

    public Compte(String titulaire, double soldeInitial) {
        this.titulaire = titulaire;
        this.solde = soldeInitial;
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
        return String.format(Locale.ROOT, "Compte (%s) : %.2f", titulaire, solde);
    }
 }