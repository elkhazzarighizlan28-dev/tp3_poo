# tp3_poo
— Vérifier avant de modifier. Dans deposer/retirer, toutes les vérifications viennent avant
la ligne qui change le solde : un refus ne doit laisser aucune trace.
— Ordre dans le constructeur. Validez d’abord, attribuez le numéro (prochainNumero++) en
dernier, sinon un compte refusé consomme un numéro.
— Tester null avant isBlank(). Écrivez titulaire == null || titulaire.isBlank() (dans
cet ordre) pour éviter une NullPointerException. Rappel : isBlank() demande Java 11 ou
plus.
— private + pas de setter pour le solde. Un setSolde annule l’encapsulation ; n’exposez que
les accesseurs (get) nécessaires.
— Compilation. Un fichier .java ne peut contenir qu’une seule classe public, qui doit porter le
nom du fichier (Exercice1.java). Commandes : javac Exercice1.java puis java Exercice1.
— Locale.ROOT dans String.format. Garantit le point décimal (120.00) quelle que soit la langue
du système (sinon 120,00).
— Méthode static. Pas de this ni d’attribut d’instance dedans ; on l’appelle avec le nom de la
classe : Compte.nombreComptes().
— nombreComptes(). Comme prochainNumero commence à 1, le nombre de comptes créés est
prochainNumero - 1.
— Découpage CSV. "Hind".split(";") donne un seul champ, donc refus. Attention : "Karim;".split(";")
supprime aussi les champs vides finaux. Convertissez le nombre avant d’appeler le constructeur.
— Message métier. Capturez NumberFormatException et relancez une IllegalArgumentException
avec un message clair
