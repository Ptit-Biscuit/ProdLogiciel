package automate.exo3;

import automate.Automate;
import automate.Validable;

import java.util.HashMap;

/**
 * Created by Brebion Vincent on 15/11/2016.
 * @version 1.0
 * @since 1.0
 */
public class AutomateHeureMinuteSeconde extends Automate implements Validable {
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
    public AutomateHeureMinuteSeconde() {
        Etat[] etats = new Etat[] {
                new Automate.Etat("E0", true, false),
                new Automate.Etat("H1"),
                new Automate.Etat("H2"),
                new Automate.Etat("H"),
                new Automate.Etat("M1"),
                new Automate.Etat("M2"),
                new Automate.Etat("M"),
                new Automate.Etat("S1"),
                new Automate.Etat("S2"),
                new Automate.Etat("S", false, true)
        };

        this.addEtatsInitAndFinal(etats[0], etats[9]);

        this.addSameTransition(this.getEtatInit(), etats[1], '0', '1');
        this.addSameTransition(this.getEtatInit(), etats[2], '2');
        this.addSameTransition(etats[1], etats[3],
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        this.addSameTransition(etats[2], etats[3], '0', '1', '2', '3');
        this.addTransition(etats[3], etats[4], ':');
        this.addSameTransition(etats[4], etats[5], '0', '1', '2', '3', '4', '5');
        this.addSameTransition(etats[5], etats[6],
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        this.addTransition(etats[6], etats[7], ':');
        this.addSameTransition(etats[7], etats[8], '0', '1', '2', '3', '4', '5');
        this.addSameTransition(etats[8], this.getEtatFinal(),
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
    }

    /**
     * Initialise une fonction de transition pour reconnaitre
     * une heure valide
     * @return la fonction de transition
     */
    public HashMap<HashMap<String, Character>, String> delta() {
        HashMap<HashMap<String, Character>, String> delta = new HashMap<>();

        HashMap<String, Character> relation1 = new HashMap<>();
        relation1.put("E0", '0');
        delta.put(relation1, "H1");

        HashMap<String, Character> relation2 = new HashMap<>();
        relation2.put("H1", '0');
        delta.put(relation2, "H");

        HashMap<String, Character> relation3 = new HashMap<>();
        relation3.put("H2", '0');
        delta.put(relation3, "H");

        HashMap<String, Character> relation4 = new HashMap<>();
        relation4.put("M1", '0');
        delta.put(relation4, "M2");

        HashMap<String, Character> relation5 = new HashMap<>();
        relation5.put("M2", '0');
        delta.put(relation5, "M");

        HashMap<String, Character> relation6 = new HashMap<>();
        relation6.put("E0", '1');
        delta.put(relation6, "H1");

        HashMap<String, Character> relation7 = new HashMap<>();
        relation7.put("H1", '1');
        delta.put(relation7, "H");

        HashMap<String, Character> relation8 = new HashMap<>();
        relation8.put("H2", '1');
        delta.put(relation8, "H");

        HashMap<String, Character> relation9 = new HashMap<>();
        relation9.put("M1", '1');
        delta.put(relation9, "M2");

        HashMap<String, Character> relation10 = new HashMap<>();
        relation10.put("M2", '1');
        delta.put(relation10, "M");

        HashMap<String, Character> relation11 = new HashMap<>();
        relation11.put("E0", '2');
        delta.put(relation11, "H2");

        HashMap<String, Character> relation12 = new HashMap<>();
        relation12.put("H1", '2');
        delta.put(relation12, "H");

        HashMap<String, Character> relation13 = new HashMap<>();
        relation13.put("H2", '2');
        delta.put(relation13, "H");

        HashMap<String, Character> relation14 = new HashMap<>();
        relation14.put("M1", '2');
        delta.put(relation14, "M2");

        HashMap<String, Character> relation15 = new HashMap<>();
        relation15.put("M2", '2');
        delta.put(relation15, "M");

        HashMap<String, Character> relation16 = new HashMap<>();
        relation16.put("H1", '3');
        delta.put(relation16, "H");

        HashMap<String, Character> relation17 = new HashMap<>();
        relation17.put("H2", '3');
        delta.put(relation17, "H");

        HashMap<String, Character> relation18 = new HashMap<>();
        relation18.put("M1", '3');
        delta.put(relation18, "M2");

        HashMap<String, Character> relation19 = new HashMap<>();
        relation19.put("M2", '3');
        delta.put(relation19, "M");

        HashMap<String, Character> relation20 = new HashMap<>();
        relation20.put("H1", '4');
        delta.put(relation20, "H");

        HashMap<String, Character> relation21 = new HashMap<>();
        relation21.put("M1", '4');
        delta.put(relation21, "M2");

        HashMap<String, Character> relation22 = new HashMap<>();
        relation22.put("M2", '4');
        delta.put(relation22, "M");

        HashMap<String, Character> relation23 = new HashMap<>();
        relation23.put("H1", '5');
        delta.put(relation23, "H");

        HashMap<String, Character> relation24 = new HashMap<>();
        relation24.put("M1", '5');
        delta.put(relation24, "M2");

        HashMap<String, Character> relation25 = new HashMap<>();
        relation25.put("M2", '5');
        delta.put(relation25, "M");

        HashMap<String, Character> relation26 = new HashMap<>();
        relation26.put("H1", '6');
        delta.put(relation26, "H");

        HashMap<String, Character> relation27 = new HashMap<>();
        relation27.put("M2", '6');
        delta.put(relation27, "M");

        HashMap<String, Character> relation28 = new HashMap<>();
        relation28.put("H1", '7');
        delta.put(relation28, "H");

        HashMap<String, Character> relation29 = new HashMap<>();
        relation29.put("M2", '7');
        delta.put(relation29, "M");

        HashMap<String, Character> relation30 = new HashMap<>();
        relation30.put("H1", '8');
        delta.put(relation30, "H");

        HashMap<String, Character> relation31 = new HashMap<>();
        relation31.put("M2", '8');
        delta.put(relation31, "M");

        HashMap<String, Character> relation32 = new HashMap<>();
        relation32.put("H1", '9');
        delta.put(relation32, "H");

        HashMap<String, Character> relation33 = new HashMap<>();
        relation33.put("M2", '9');
        delta.put(relation33, "M");

        HashMap<String, Character> relation34 = new HashMap<>();
        relation34.put("H", ':');
        delta.put(relation34, "M1");

        HashMap<String, Character> relation35 = new HashMap<>();
        relation35.put("M", ':');
        delta.put(relation35, "S1");

        HashMap<String, Character> relation36 = new HashMap<>();
        relation36.put("S1", '0');
        delta.put(relation36, "S1");

        HashMap<String, Character> relation37 = new HashMap<>();
        relation37.put("S1", '1');
        delta.put(relation37, "S2");

        HashMap<String, Character> relation38 = new HashMap<>();
        relation38.put("S1", '2');
        delta.put(relation38, "S2");

        HashMap<String, Character> relation39 = new HashMap<>();
        relation39.put("S1", '3');
        delta.put(relation39, "S2");

        HashMap<String, Character> relation40 = new HashMap<>();
        relation40.put("S1", '4');
        delta.put(relation40, "S2");

        HashMap<String, Character> relation41 = new HashMap<>();
        relation41.put("S1", '5');
        delta.put(relation41, "S2");

        HashMap<String, Character> relation42 = new HashMap<>();
        relation42.put("S2", '0');
        delta.put(relation42, "S");

        HashMap<String, Character> relation43 = new HashMap<>();
        relation43.put("S2", '1');
        delta.put(relation43, "S");

        HashMap<String, Character> relation44 = new HashMap<>();
        relation44.put("S2", '2');
        delta.put(relation44, "S");

        HashMap<String, Character> relation45 = new HashMap<>();
        relation45.put("S2", '3');
        delta.put(relation45, "S");

        HashMap<String, Character> relation46 = new HashMap<>();
        relation46.put("S2", '4');
        delta.put(relation46, "S");

        HashMap<String, Character> relation47 = new HashMap<>();
        relation47.put("S2", '5');
        delta.put(relation47, "S");

        HashMap<String, Character> relation48 = new HashMap<>();
        relation48.put("S2", '6');
        delta.put(relation48, "S");

        HashMap<String, Character> relation49 = new HashMap<>();
        relation49.put("S2", '7');
        delta.put(relation49, "S");

        HashMap<String, Character> relation50 = new HashMap<>();
        relation50.put("S2", '8');
        delta.put(relation50, "S");

        HashMap<String, Character> relation51 = new HashMap<>();
        relation51.put("S2", '9');
        delta.put(relation51, "S");

        return delta;
    }

    /*
        Une autre solution en utilisant les expressions régulières:
        return heure.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]");
     */

    /**
     * Méthode <code>validate(String heure)</code> simplifiée
     * par l'utilisation d'une expression régulière
     * @param heure l'heure à valider
     * @return true si l'heure est valide, false sinon
     */
    public boolean simpleValidate(String heure) { return heure.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]"); }
}
