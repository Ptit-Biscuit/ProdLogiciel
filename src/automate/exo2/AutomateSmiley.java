package automate.exo2;

import automate.Automate;
import automate.Validable;
import automate.exo4.AutomateMail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Brebion Vincent on 15/11/2016.
 * @version 1.0
 * @since 1.0
 */
public class AutomateSmiley extends Automate implements Validable {
    /*
     * Pseudo-algorithme:
     *  etatC ← E0 {partons de l’état initial}
     *  etats <- {ensemble des états valides}
     *
     *  {On a une suite de caractères en entrée}
     *  {On prendra carCourant comme le caractère suivant dans la suite}
     *
     *  while etatC != Ef and etatC € etats do
	 *      lire carCourant {on parcourt la suite de car en entrée}
	 *      afficher carCourant
	 *      etatC ← delta(etatC, carCourant)
     *  end while
     *
     *  if etatC = Ef then
	 *      Bien terminé : la suite de caractères en entrée est reconnue
     *  else {On s’est arreté sur un état non défini}
     *      Echec : la suite de caractères n’est pas reconnue
     *  end if
     */

    // Code java associé
    /**
     *
     */
    public AutomateSmiley() {
        Etat[] etats = new Etat[] {
                new Automate.Etat("E0", true, false),
                new Automate.Etat("E1"),
                new Automate.Etat("E2"),
                new Automate.Etat("E3"),
                new Automate.Etat("E4", false, true),

        };

        this.addEtatsInitAndFinal(etats[0], etats[4]);

        this.addTransition(this.getEtatInit(), etats[1], ':');
        this.addTransition(this.getEtatInit(), etats[2], ';');
        this.addSameTransition(etats[1], etats[3], '-', '=');
        this.addTransition(etats[2], etats[3], '-');
        this.addSameTransition(etats[3], this.getEtatFinal(), '(', ')');
    }

    /**
     * Initialise une fonction de transition pour reconnaitre
     * un smiley valide
     * @return la fonction de transition
     */
    public HashMap<HashMap<String, Character>, String> delta() {
        HashMap<HashMap<String, Character>, String> delta = new HashMap<>();

        HashMap<String, Character> relation1 = new HashMap<>();
        relation1.put("E0", ':');
        delta.put(relation1, "E1");

        HashMap<String, Character> relation2 = new HashMap<>();
        relation2.put("E0", ';');
        delta.put(relation2, "E2");

        HashMap<String, Character> relation3 = new HashMap<>();
        relation3.put("E1", '-');
        delta.put(relation3, "E3");

        HashMap<String, Character> relation4 = new HashMap<>();
        relation4.put("E1", '=');
        delta.put(relation4, "E3");

        HashMap<String, Character> relation5 = new HashMap<>();
        relation5.put("E2", '-');
        delta.put(relation5, "E3");

        HashMap<String, Character> relation6 = new HashMap<>();
        relation6.put("E3", '(');
        delta.put(relation6, "E4");

        HashMap<String, Character> relation7 = new HashMap<>();
        relation7.put("E3", ')');
        delta.put(relation7, "E4");

        return delta;
    }

    /*
        Une autre solution en utilisant les expressions régulières:
        return smiley.matches("(((:(-|=))|;-)(\\(|\\)))");
    */

    /**
     * Méthode <code>validate(String smiley)</code> simplifiée
     * par l'utilisation d'expression régulière
     * @param smiley le smiley à valider
     * @return true si le smiley est valide, false sinon
     */
    public boolean simpleValidate(String smiley) { return smiley.matches("(((:(-|=))|;-)(\\(|\\)))"); }
}
