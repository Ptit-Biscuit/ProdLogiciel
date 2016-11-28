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
        this.addEtatsInitAndFinal(new Automate.Etat("E0", true, false),
                new Automate.Etat("E5", false, true));

        char[] chars = new char[] {};

        System.out.println(Arrays.toString(chars));
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
