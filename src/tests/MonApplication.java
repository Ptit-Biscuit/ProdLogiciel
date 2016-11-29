package tests;

import automate.Automate;
import automate.Validable;
import automate.exo1.AutomateHeureMinute;
import automate.exo2.AutomateSmiley;
import automate.exo3.AutomateHeureMinuteSeconde;
import automate.exo3.AutomateJourMoisAnnee;
import automate.exo4.AutomateMail;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by Brebion Vincent on 16/11/2016.
 * @version 1.0
 * @since 1.0
 */
public class MonApplication {
    public static void validateHeureMinute() {
        Automate automate = new AutomateHeureMinute();
        String automateUtilisé = automate.getClass().getSimpleName();

        /*
         * Redirection de la sortie standard
         * -> Création d'un fichier par automate
         */
        try {
            System.setOut(new PrintStream(automateUtilisé + ".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("L'automate utilisé est un: " + automateUtilisé);

        System.out.println();
        System.out.println("Validité des heures (format HH:MM)");
        System.out.println();

        System.out.println("Validité de \"13:46\"");
        if (automate.validate("13:46")) System.out.println("\t-->Cette heure est valide");
        else System.out.println("\t-->Cette heure n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"00:00\"");
        if (automate.validate("00:00")) System.out.println("\t-->Cette heure est valide");
        else System.out.println("\t-->Cette heure n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"19:76\"");
        if (automate.validate("19:76")) System.out.println("\t-->Cette heure est valide");
        else System.out.println("\t-->Cette heure n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"33:46\"");
        if (automate.validate("33:46")) System.out.println("\t-->Cette heure est valide");
        else System.out.println("\t-->Cette heure n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"AAA\"");
        if (automate.validate("AAA")) System.out.println("\t-->C'est valide");
        else System.out.println("\t-->Ce n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"\"");
        if (automate.validate("")) System.out.println("\t-->C'est valide");
        else System.out.println("\t-->Ce n'est pas valide");
    }

    public static void validateSmiley() {
        // **********  CHANGEMENT D'AUTOMATE  **********
        Automate automate = new AutomateSmiley();
        String automateUtilisé = automate.getClass().getSimpleName();

        /*
         * Redirection de la sortie standard
         * -> Création d'un fichier par automate
         */
        try {
            System.setOut(new PrintStream(automateUtilisé + ".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("L'automate utilisé est un: " + automateUtilisé);

        System.out.println();
        System.out.println("Validité des smileys");
        System.out.println();

        System.out.println("Validité de \":=)\"");
        if (automate.validate(":=)")) System.out.println("\t-->Ce smiley est valide");
        else System.out.println("\t-->Ce smiley est invalide");

        System.out.println();
        System.out.println("Validité de \":-)\"");
        if (automate.validate(":-)")) System.out.println("\t-->Ce smiley est valide");
        else System.out.println("\t-->Ce smiley est invalide");

        System.out.println();
        System.out.println("Validité de \";=)\"");
        if (automate.validate(";=)")) System.out.println("\t-->Ce smiley est valide");
        else System.out.println("\t-->Ce smiley est invalide");

        System.out.println();
        System.out.println("Validité de \";;)\"");
        if (automate.validate(";;)")) System.out.println("\t-->Ce smiley est valide");
        else System.out.println("\t-->Ce smiley est invalide");

        System.out.println();
        System.out.println("Validité de \"AAA\"");
        if (automate.validate("AAA")) System.out.println("\t-->C'est valide");
        else System.out.println("\t-->Ce n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"\"");
        if (automate.validate("")) System.out.println("\t-->C'est valide");
        else System.out.println("\t-->Ce n'est pas valide");
    }

    public static void validateHeureMinuteSeconde() {
        // **********  CHANGEMENT D'AUTOMATE  **********
        Automate automate = new AutomateHeureMinuteSeconde();
        String automateUtilisé = automate.getClass().getSimpleName();

        /*
         * Redirection de la sortie standard
         * -> Création d'un fichier par automate
         */
        try {
            System.setOut(new PrintStream(automateUtilisé + ".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("L'automate utilisé est un: " + automateUtilisé);

        System.out.println();
        System.out.println("Validité des heures (format HH:MM:SS)");
        System.out.println();

        System.out.println("Validité de \"13:46:00\"");
        if (automate.validate("13:46:00")) System.out.println("\t-->Cette heure est valide");
        else System.out.println("\t-->Cette heure n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"00:00:59\"");
        if (automate.validate("00:00:59")) System.out.println("\t-->Cette heure est valide");
        else System.out.println("\t-->Cette heure n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"12:34:94\"");
        if (automate.validate("12:34:94")) System.out.println("\t-->Cette heure est valide");
        else System.out.println("\t-->Cette heure n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"21:46:715\"");
        if (automate.validate("21:46:715")) System.out.println("\t-->Cette heure est valide");
        else System.out.println("\t-->Cette heure n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"AAA\"");
        if (automate.validate("AAA")) System.out.println("\t-->C'est valide");
        else System.out.println("\t-->Ce n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"\"");
        if (automate.validate("")) System.out.println("\t-->C'est valide");
        else System.out.println("\t-->Ce n'est pas valide");
    }

    public static void validateDate() {
        // **********  CHANGEMENT D'AUTOMATE  **********
        Validable automate = new AutomateJourMoisAnnee();
        String automateUtilisé = automate.getClass().getSimpleName();

        /*
         * Redirection de la sortie standard
         * -> Création d'un fichier par automate
         */
        try {
            System.setOut(new PrintStream(automateUtilisé + ".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("L'automate utilisé est un: " + automateUtilisé);

        System.out.println();
        System.out.println("Validité des dates (format jj/mm/aaaa)");
        System.out.println();

        System.out.println("Validité de \"16/11/2016\"");
        if (automate.simpleValidate("16/11/2016")) System.out.println("\t-->Cette date est valide");
        else System.out.println("\t-->Cette date n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"01/01/2000\"");
        if (automate.simpleValidate("01/01/2000")) System.out.println("\t-->Cette date est valide");
        else System.out.println("\t-->Cette date n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"15/106/1994\"");
        if (automate.simpleValidate("15/106/1994")) System.out.println("\t-->Cette date est valide");
        else System.out.println("\t-->Cette date n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"31/02/1664\"");
        if (automate.simpleValidate("31/02/1664")) System.out.println("\t-->Cette date est valide");
        else System.out.println("\t-->Cette date n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"AAA\"");
        if (automate.simpleValidate("AAA")) System.out.println("\t-->C'est valide");
        else System.out.println("\t-->Ce n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"\"");
        if (automate.simpleValidate("")) System.out.println("\t-->C'est valide");
        else System.out.println("\t-->Ce n'est pas valide");
    }

    public static void validateMail() {
        // **********  CHANGEMENT D'AUTOMATE  **********
        Automate automate = new AutomateMail();
        String automateUtilisé = automate.getClass().getSimpleName();

        /*
         * Redirection de la sortie standard
         * -> Création d'un fichier par automate
         */
        try {
            System.setOut(new PrintStream(automateUtilisé + ".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("L'automate utilisé est un: " + automateUtilisé);

        System.out.println();
        System.out.println("Validité des mail (format ***.***@*****)");
        System.out.println();

        System.out.println("Validité de \"mon.Mail@monDomain\"");
        if (automate.validate("mon.Mail@monDomain")) System.out.println("\t-->Cette date est valide");
        else System.out.println("\t-->Cette date n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"MAILTEST.MAIL@MONDOMAIN\"");
        if (automate.validate("MAILTEST.MAIL@MONDOMAIN")) System.out.println("\t-->Cette date est valide");
        else System.out.println("\t-->Cette date n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"MailInvalide@invalide\"");
        if (automate.validate("MailInvalide@invalide")) System.out.println("\t-->Cette date est valide");
        else System.out.println("\t-->Cette date n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"AutreMail.Invalide\"");
        if (automate.validate("AutreMail.Invalide")) System.out.println("\t-->Cette date est valide");
        else System.out.println("\t-->Cette date n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"ChaineInvalide\"");
        if (automate.validate("ChaineInvalide")) System.out.println("\t-->Cette date est valide");
        else System.out.println("\t-->Cette date n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"AAA\"");
        if (automate.validate("AAA")) System.out.println("\t-->C'est valide");
        else System.out.println("\t-->Ce n'est pas valide");

        System.out.println();
        System.out.println("Validité de \"\"");
        if (automate.validate("")) System.out.println("\t-->C'est valide");
        else System.out.println("\t-->Ce n'est pas valide");
    }

    public static void main(String[] args) {
        validateHeureMinute();
        validateSmiley();
        validateHeureMinuteSeconde();
        validateDate();
        validateMail();
    }
}
