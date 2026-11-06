public class Exercice1 {
    public static void main(String[] args) {
        Compte c = new Compte("Amina", 100.0);
        c.deposer(50);
        c.retirer(30);
        System.out.println(c);
        try {
            c.retirer(500);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        try {
            c.deposer(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        System.out.println(c);
    }
}
