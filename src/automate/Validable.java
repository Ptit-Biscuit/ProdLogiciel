package automate;

import java.util.HashMap;

/**
 * Created by Brebion Vincent on 16/11/2016.
 * @version 1.0
 * @since 1.0
 */
public interface Validable {
    HashMap<HashMap<String, Character>, String> delta();
    boolean simpleValidate(String string);
}
