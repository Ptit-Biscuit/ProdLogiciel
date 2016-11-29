package automate.exo4;

import automate.Automate;
import automate.Validable;
import sun.misc.ASCIICaseInsensitiveComparator;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by E155939Z on 23/11/16.
 */
public class AutomateMail extends Automate implements Validable {

    public AutomateMail() {
        Etat[] etats = new Etat[] {
                new Automate.Etat("E0", true, false),
                new Automate.Etat("E1"),
                new Automate.Etat("E2"),
                new Automate.Etat("E3"),
                new Automate.Etat("E4"),
                new Automate.Etat("E5", false, true),
        };

        this.addEtatsInitAndFinal(etats[0], etats[5]);

        Character[] chars = new Character[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y' ,'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };

        this.addSameTransition(this.getEtatInit(), etats[1], chars);
        this.addSameTransition(etats[1], etats[1], chars);
        this.addTransition(etats[1], etats[2], '.');
        this.addSameTransition(etats[2], etats[3], chars);
        this.addSameTransition(etats[3], etats[3], chars);
        this.addTransition(etats[3], etats[4], '@');
        this.addSameTransition(etats[4], this.getEtatFinal(), chars);
        this.addSameTransition(this.getEtatFinal(), this.getEtatFinal(), chars);
        this.addTransition(this.getEtatFinal(), this.getEtatInit(), ';');
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
