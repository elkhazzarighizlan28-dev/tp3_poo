import java.util.*;
public class Compte6{
    private static int prochainNumero = 1 ;
    private final int  numero ;
    private final String titulaire ;
    private double solde ;
    public Compte6(String titulaire, double soldeInitial) {
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
    private Compte6(Compte6 autre) {
    this.numero = autre.numero;
    this.titulaire = autre.titulaire;
    this.solde = autre.solde;
    }
    public Compte6 copieDeSauvegarde() {
        return new Compte6(this);
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

    public static Compte6 depuisLigneCsv(String ligne) {
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
    return new Compte6(champs[0].trim(), solde);
    }
    @Override
    public boolean equals(Object o) {
    if (!(o instanceof Compte6)) {
        return false;
    }
    Compte6 autre = (Compte6) o;
    return numero == autre.numero;
    }

    @Override
    public int hashCode() {
    return Integer.hashCode(numero);
}



    @Override
    public String toString() { 
    return String.format(Locale.ROOT, "Compte %d (%s) : %.2f", numero, titulaire, solde);
}
static class Tests {
    static int reussis = 0,echecs = 0;
    static void verifier(boolean condition, String nom) {
        if (condition) {
            reussis++;
        } else {
            echecs++;
            System.out.println("Echec : " + nom);
  
}}
static void doitEchouer(String nom, Runnable operation) {
    try {
        operation.run();
    } catch (IllegalArgumentException e) {
        reussis++;          
        return;
    }
    echecs++;               
    System.out.println("ECHEC : " + nom + " ne devait pas reussir");
}

public static void main(String[] args){
    Compte6 c = new Compte6("Amina", 100.0);
    c.deposer(50);

 

}
   


}
public static void main(String[] args) {
    Compte6 c = new Compte6("Amina", 100.0);
    c.deposer(50);
    Tests.verifier(c.getSolde() == 150.0, "depot valide");
    c.retirer(150);
    Tests.verifier(c.getSolde() == 0.0, "retrait valide");
    c.deposer(100);
    Tests.doitEchouer("depot nul", () -> c.deposer(0));
    Tests.doitEchouer("depot negatif", () -> c.deposer(-5));
    Tests.doitEchouer("retrait nul", () -> c.retirer(0));
    Tests.doitEchouer("retrait trop grand", () -> c.retirer(500));
    Tests.verifier(c.getSolde() == 100.0, "solde inchange apres les refus");
    Tests.doitEchouer("titulaire vide", () -> new Compte("", 10));
    Tests.doitEchouer("titulaire espaces", () -> new Compte("", 10));
    Tests.doitEchouer("solde initial negatif", () -> new Compte("Karim", -1));
    System.out.println(Tests.reussis + " tests reussis, " + Tests.echecs + " echec(s)");
}
}