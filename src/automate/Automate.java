package automate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by Brebion Vincent on 16/11/16
 * @version 3.2
 * @since 1.0
 */
public class Automate {
    /**
     * Classe interne représentant les états
     */
    public class Etat {
        /**
         * Le nom de l'état
         */
        private String nom;

        /**
         * Si l'état est initial
         */
        private boolean isInit;

        /**
         * Si l'état est final
         */
        private boolean isFinal;

        /**
         * Constructeur d'Etat
         * @param nom Le nom de l'état
         */
        public Etat(String nom) { this(nom, false, false); }

        /**
         * Constructeur d'Etat
         * @param nom Le nom de l'état
         * @param isInit si l'état est initial
         * @param isFinal si l'état est final
         */
        public Etat(String nom, boolean isInit, boolean isFinal) {
            this.nom = nom;
            this.isInit = isInit;
            this.isFinal = isFinal;
        }

        /**
         * Retourne le nom de l'état
         * @return Le nom de l'état
         */
        public String getNom() { return nom; }

        /**
         * Retourne si l'état est initial
         * @return si l'état est initial
         */
        public boolean isInit() { return this.isInit; }

        /**
         * Retourne si l'état est final
         * @return si l'état est final
         */
        public boolean isFinal() { return this.isFinal; }

        /**
         * Equals method
         * @param o
         * @return true if o equals this
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Etat)) return false;

            Etat etat = (Etat) o;

            return getNom().equals(etat.getNom());
        }
    }

    /**
     * Matrice des transitions de l'automate
     */
    private HashMap<HashMap<Automate.Etat, Character>, Automate.Etat> transitions;

    /**
     * Liste des états dans l'automate
     */
    private List<Etat> etats;

    public Automate() {
        this.transitions = new HashMap<>();
        this.etats = new ArrayList<>();
    }

    /**
     * Ajoute l'état initial et l'état final de l'automate
     * @param etatInitial l'état initial de l'automate
     * @param etatFinal l'état final de l'automate
     * @return true si les ajouts ont été fait, false sinon
     */
    public boolean addEtatsInitAndFinal(Automate.Etat etatInitial, Automate.Etat etatFinal) {
        boolean ok = true;

        if(!etatInitial.isInit() && !etatFinal.isFinal) { return !ok; }
        else {
            if(!this.etats.contains(etatInitial))
                this.etats.add(etatInitial);

            if(!this.etats.contains(etatFinal))
                this.etats.add(etatFinal);
        }

        return ok;
    }

    /**
     * Retourne l'état initial de l'automate
     * @return l'état initial de l'automate
     */
    public Automate.Etat getEtatInit() {
        for(Automate.Etat etat : this.etats) {
            if(etat.isInit()) return etat;
        }

        return null;
    }

    /**
     * Retourne l'état final de l'automate
     * @return l'état final de l'automate
     */
    public Automate.Etat getEtatFinal() {
        for(Automate.Etat etat : this.etats) {
            if(etat.isFinal()) return etat;
        }

        return null;
    }

    /**
     * Retourne l'état suivant en fonction de l'action
     * @param etat l'état de départ de la relation
     * @param action l'action pour accéder à l'état suivant
     * @return l'état suivant
     */
    public Automate.Etat getEtatSuivant(Automate.Etat etat, Character action) {
        HashMap<Automate.Etat, Character> relation = new HashMap<>();
        relation.put(etat, action);

        return this.transitions.getOrDefault(relation, null);
    }

    public List<Automate.Etat> getEtats() { return this.etats; }

    /**
     * Ajoute une transition entre deux états
     * @param etatDep l'état de départ
     * @param etatArr l'état d'arrivé
     * @param action la relation entre les deux états
     * @return true si transition n'existait pas, false sinon
     */
    public boolean addTransition(Automate.Etat etatDep, Automate.Etat etatArr, Character action) {
        HashMap<Automate.Etat, Character> relation = new HashMap<>();
        relation.putIfAbsent(etatDep, action);

        if(!this.etats.contains(etatDep))
            this.etats.add(etatDep);

        if(!this.etats.contains(etatArr))
            this.etats.add(etatArr);

        for (HashMap<Etat, Character> key : this.transitions.keySet()) {
            if (key.equals(relation))
                System.err.println(this.transitions.get(key).getNom() + "\n");
        }

        return this.transitions.putIfAbsent(relation, etatArr) == null;
    }

    /**
     * Ajoute une transition entre deux états
     * @param etatDep l'état de départ
     * @param etatArr l'état d'arrivé
     * @param actions les relations entre les deux états
     * @return true si transition n'existait pas, false sinon
     */
    public boolean addSameTransition(Automate.Etat etatDep, Automate.Etat etatArr, Character ... actions) {
        boolean ok = true;

        for(Character action : actions) {
            ok = ok & this.addTransition(etatDep, etatArr, action);
        }

        return ok;
    }

    /**
     * Met à jour une relation de l'automate
     * @param etatDep l'état de départ de la relation à modifier
     * @param etatArr l'état d'arrivé de la relation à modifier
     * @param action l'action de la relation à modifier
     * @return true si la relation a bien été modifée, false sinon
     */
    public boolean setTransition(String etatDep, String etatArr, Character action) {
        boolean changeOk = false;
        HashMap<Automate.Etat, Character> relation = new HashMap<>();
        relation.put(new Automate.Etat(etatDep), action);

        if (!this.transitions.containsKey(relation)) changeOk = this.addTransition(new Automate.Etat(etatDep), new Automate.Etat(etatArr), action);
        else {
            Automate.Etat ancienEtatArr = this.transitions.get(relation);
            changeOk = this.transitions.replace(relation, ancienEtatArr, new Automate.Etat(etatArr));
        }

        return changeOk;
    }

    /**
     * Supprime une transition de l'automate
     * @param etatDep l'état de départ de la relation à supprimer
     * @param action l'action vers l'état d'arrivé de la relation à supprimer
     * @return true si la relation a bien été supprimée, false sinon
     */
    public boolean supTransition(String etatDep, Character action) {
        HashMap<Automate.Etat, Character> relation = new HashMap<>();
        relation.put(new Automate.Etat(etatDep), action);

        Automate.Etat etatArr = this.transitions.get(relation);

        return this.transitions.remove(relation, etatArr);
    }

    public HashMap<HashMap<Etat, Character>, Etat> getTransitions() { return this.transitions; }

    /**
     * Méthode validant la srting passée en paramètre
     * @param string la string à valider
     * @return true si la string est valide, false sinon
     */
    public boolean validate(String string) {
        int i = 0;

        Automate.Etat etatC = this.getEtatInit();
        String etatFinal = this.getEtatFinal().getNom();
        String chaine = "";

        System.out.println("etat en cours : " + etatC.getNom() + "\tetat final : " + etatFinal);

        while (this.etats.contains(etatC)) {
            Character carCourantX;

            if (i >= string.length()) break;
            else {
                carCourantX = string.charAt(i);

                etatC = this.getEtatSuivant(etatC, carCourantX);

                if (etatC != null) {
                    chaine += carCourantX;
                    System.out.println("etat suivant : " + etatC.getNom() + "\tchaine lue : " + chaine);
                }
                else {
                    System.out.println("etat invalide");
                    return false;
                }
            }

            i++;
        }

        return etatC.getNom().equals(etatFinal);
    }
}
