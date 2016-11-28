package automate.exo3;

import automate.Automate;
import automate.Validable;

import java.util.HashMap;

/**
 * Created by Brebion Vincent on 16/11/2016.
 * @version 1.0
 * @since 1.0
 */
public class AutomateJourMoisAnnee extends Automate implements Validable {
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
     * Initialise une fonction de transition pour reconnaitre
     * une heure valide
     * @return la fonction de transition
     */
    public HashMap<HashMap<String, Character>, String> delta() {
        // TODO: Le principe est le même que dans les autres automates

        return null;
    }

    /**
     * Méthode <code>validate(String date)</code> simplifiée
     * par l'utilisation d'une expression régulière
     * @param date la date à valider
     * @return true si la date est valide, false sinon
     */
    public boolean simpleValidate(String date) {
        return date.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)" +
                "(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^" +
                "(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|" +
                "[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|" +
                "2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$"); }
}
