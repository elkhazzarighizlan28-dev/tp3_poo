import java.util.*;
public class Compte5{
    private static int prochainNumero = 1 ;
    private final int  numero ;
    private final String titulaire ;
    private double solde ;
    public Compte5(String titulaire, double soldeInitial) {
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
    private Compte5(Compte5 autre) {
    this.numero = autre.numero;
    this.titulaire = autre.titulaire;
    this.solde = autre.solde;
    }
    public Compte5 copieDeSauvegarde() {
        return new Compte5(this);
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

    public static Compte5 depuisLigneCsv(String ligne) {
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
    return new Compte5(champs[0].trim(), solde);
    }
    @Override
    public boolean equals(Object o) {
    if (!(o instanceof Compte5)) {
        return false;
    }
    Compte5 autre = (Compte5) o;
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

public static void main(String[] args){
    Compte5 a = new Compte5("Amina", 100.0);
    Compte5 b = a ;
    Compte5 c = new Compte5("Amina", 100.0);
    Compte5 d = a.copieDeSauvegarde();
    System.out.println("a/b : meme objet = " + (a == b) + ", egaux = " + a.equals(b));
    System.out.println("a/c : meme objet = " + (a == c) + ", egaux = " + a.equals(c));
    System.out.println("a/d : meme objet = " + (a == d) + ", egaux = " + a.equals(d));
    Set<Compte5> ensemble= new HashSet<>();
    ensemble.add(b);
    ensemble.add(d);
    System.out.println("Ensemble {a, b, c, d} : " + ensemble.size() + " comptes");


}
   static String oui(boolean b) {
        return b ? "oui" : "non";
    }


}