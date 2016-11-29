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

        Character[] chars = new Character[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y' ,'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };

        this.addSameTransition(this.getEtatInit(), etats[1], chars);
        this.addSameTransition(etats[1], etats[1], chars);
        this.addSameTransition(etats[1], etats[2], chars);
        this.addSameTransition(etats[2], etats[2], chars);
        this.addSameTransition(etats[2], etats[2], chars);
        this.addSameTransition(etats[2], this.getEtatFinal(), chars);
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
