import java.util.*;
public class Compte2 {

    private static int prochainNumero = 1 ;
    private final int  numero ;
    private final String titulaire ;
    private double solde ;
    public Compte2(String titulaire, double soldeInitial) {
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
        Compte2 a = new Compte2("Amina", 100.0);
        try{
            new Compte("",50.0 );
        } catch(IllegalArgumentException e){
            System.out.println("Erreur :" + e.getMessage());
        }
         try{
            new Compte("Karim",-10.0 );
        } catch(IllegalArgumentException e){
            System.out.println("Erreur :" + e.getMessage());
        }
         try{
            new Compte("Youssef",2500.0 );
        } catch(IllegalArgumentException e){
            System.out.println("Erreur :" + e.getMessage());
        }
        Compte2 b = new Compte2("Youssef",250.00 );
        System.out.println(a);
        System.out.println(b);

        }
    }

    
        
    