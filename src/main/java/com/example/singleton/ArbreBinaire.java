public class ArbreBinaire {
    private Integer clef;
    private ArbreBinaire gauche;
    private ArbreBinaire droite;
    private static ArbreBinaire arbreVide = new ArbreBinaire();

    private ArbreBinaire() {
        this.clef = null;
        this.gauche = null;
        this.droite = null;
    }


    public static ArbreBinaire creer() {
        return arbreVide;
    }

    // Getters et setters
    public Integer getClef() {
        return clef;
    }

    public void setClef(Integer clef) {
        this.clef = clef;
    }

    public ArbreBinaire getGauche() {
        return gauche;
    }

    public void setGauche(ArbreBinaire gauche) {
        this.gauche = gauche;
    }

    public ArbreBinaire getDroite() {
        return droite;
    }

    public void setDroite(ArbreBinaire droite) {
        this.droite = droite;
    }

    public boolean estVide() {
        return this.clef == null;
    }


    public int taille() {
        if (this.estVide()) {
            return 0;
        } else {
            int tailleGauche = this.gauche == null ? 0 : this.gauche.taille();
            int tailleDroite = this.droite == null ? 0 : this.droite.taille();
            return 1 + tailleGauche + tailleDroite;
        }
    }


    public boolean rechercher(Integer valeur) {
        if (this.estVide()) {
            return false;
        } else if (this.clef.equals(valeur)) {
            return true;
        } else {
            boolean rechercheGauche = this.gauche != null && this.gauche.rechercher(valeur);
            boolean rechercheDroite = this.droite != null && this.droite.rechercher(valeur);
            return rechercheGauche || rechercheDroite;
        }
    }

    public void inserer(Integer nouvelleClef) {
        // methode inserer la nouvelle clé dans l'arbre
        if (this.estVide()) {
            this.clef = nouvelleClef;

            this.gauche = new ArbreBinaire();
            this.droite = new ArbreBinaire();
        } else {
            if (nouvelleClef < this.clef) {

                if (this.gauche.estVide()) {
                    this.gauche.clef = nouvelleClef;
                    this.gauche.gauche = new ArbreBinaire();
                    this.gauche.droite = new ArbreBinaire();
                } else {
                    this.gauche.inserer(nouvelleClef);
                }
            } else if (nouvelleClef > this.clef) {

                if (this.droite.estVide()) {
                    this.droite.clef = nouvelleClef;
                    this.droite.gauche = new ArbreBinaire();
                    this.droite.droite = new ArbreBinaire();
                } else {
                    this.droite.inserer(nouvelleClef);
                }
            }

        }
    }


    public void afficher() {
        if (!this.estVide()) {
            if (this.gauche != null) this.gauche.afficher();
            System.out.print(this.clef + " ");
            if (this.droite != null) this.droite.afficher();
        }
    }
    public static void main(String[] args) {
            //main
            ArbreBinaire arbre = ArbreBinaire.creer();

            arbre.inserer(1);
            arbre.inserer(6);
            arbre.inserer(4);

            arbre.afficher();

            int valeurARechercher = 9;
            boolean trouve = arbre.rechercher(valeurARechercher);
            System.out.println("\nLa valeur " + valeurARechercher + " est dans l'arbre: " + trouve);
        }
}


