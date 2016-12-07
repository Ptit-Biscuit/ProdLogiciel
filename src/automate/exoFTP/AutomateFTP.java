package automate.exoFTP;

import automate.Automate;
import automate.Validable;

import java.util.HashMap;

/**
 * Created by E155939Z on 29/11/16.
 */
public class AutomateFTP extends Automate implements Validable {

    public AutomateFTP() {
        Automate.Etat[] etats = new Automate.Etat[] {
                new Automate.Etat("E0", true, true),
                new Automate.Etat("E1"),
                new Automate.Etat("E2"),
        };

        this.addEtatsInitAndFinal(etats[0], etats[0]);

        this.addSameTransition(this.getEtatInit(), etats[1], ' ');
        this.addSameTransition(etats[1], etats[1], ' ');
        this.addSameTransition(etats[1], etats[2], ' ');
        this.addSameTransition(etats[2], etats[2], ' ');
        this.addSameTransition(etats[2], etats[2], ' ');
        this.addSameTransition(etats[2], this.getEtatFinal(), ' ');
    }

    @Override
    public HashMap<HashMap<String, Character>, String> delta() {
        return null;
    }

    @Override
    public boolean simpleValidate(String string) {
        return false;
    }
}
