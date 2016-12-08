package automate.exoFTP;

import automate.Automate;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by E155939Z on 29/11/16.
 */
public class AutomateFTP extends Automate {

    public AutomateFTP() {
        Automate.Etat[] etats = new Automate.Etat[] {
                new Automate.Etat("E0", true, true),
                new Automate.Etat("E1"),
                new Automate.Etat("E2"),
        };

        this.addEtatsInitAndFinal(etats[0], etats[0]);

        this.addTransition(this.getEtatInit(), etats[1], 'o');
        this.addTransition(etats[1], etats[1], '0');
        this.addTransition(etats[1], etats[2], '1');
        this.addTransition(etats[2], etats[2], 'i');
        this.addTransition(etats[2], etats[2], 'p');
        this.addTransition(etats[2], this.getEtatFinal(), 'c');
        this.addTransition(this.getEtatFinal(), this.getEtatInit(), null);
    }

    private void showWindow() {
        JLabel simulation = new JLabel();
        simulation.setFont(new Font("name", Font.PLAIN, 30));

        // Fenêtre principale
        JFrame window = new JFrame("AutomateFTP");

        window.setSize(new Dimension(400, 250));

        Point centreEcran = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        window.setLocation((int)centreEcran.getX() - (window.getSize().width / 2),
                (int)centreEcran.getY() - (window.getSize().height / 2));

        // Panneau principal ainsi que son layout
        JPanel mainPanel = new JPanel();
        CardLayout layout = new CardLayout();

        // sous-panneau représentant l'état E0
        JPanel etat0 = new JPanel(new BorderLayout());

        JLabel label = new JLabel("état en cours : E0 - prochain état : E1");
        label.setPreferredSize(new Dimension(500, 50));

        JButton open = new JButton("open");
        open.setPreferredSize(new Dimension(400, 150));
        open.addActionListener(e -> {
            simulation.setText(simulation.getText() + "o");
            layout.show(mainPanel, "E1");
        });

        etat0.add(label, BorderLayout.NORTH);
        etat0.add(open, BorderLayout.SOUTH);

        // ajout du sous-panneau 'etat0' au panneau et layout principal
        layout.addLayoutComponent(etat0, "E0");
        mainPanel.add(etat0);

        // sous-panneau représentant l'état E1
        JPanel etat1 = new JPanel();
        etat1.setLayout(new BoxLayout(etat1, BoxLayout.PAGE_AXIS));

        JLabel label1 = new JLabel("état en cours : E1 - prochains états : E1 / E2");
        label1.setPreferredSize(new Dimension(500, 50));

        JTextField motDePasse = new JPasswordField();

        JButton valider = new JButton("valider");
        valider.addActionListener(e -> {
            if (motDePasse.getText().equals("password")) {
                simulation.setText(simulation.getText() + "1");
                layout.show(mainPanel, "E2");
            }
            else {
                simulation.setText(simulation.getText() + "0");
                motDePasse.setText("");
                layout.show(mainPanel, "E1");
            }
        });

        etat1.add(label1);
        etat1.add(motDePasse);
        etat1.add(valider);

        // ajout du sous-panneau 'etat1' au panneau et layout principal
        layout.addLayoutComponent(etat1, "E1");
        mainPanel.add(etat1);

        // sous-panneau représentant l'état E2
        JPanel etat2 = new JPanel();
        etat2.setLayout(new BoxLayout(etat2, BoxLayout.PAGE_AXIS));

        JLabel label2 = new JLabel("état en cours : E2 - prochains états : E2 / E0");
        label2.setPreferredSize(new Dimension(500, 50));

        JPanel commandes = new JPanel();
        commandes.setLayout(new BoxLayout(commandes, BoxLayout.PAGE_AXIS));

        JTextArea text = new JTextArea("");

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("");
        comboBox.addItem("ls");
        comboBox.addItem("get");
        comboBox.addItem("put");
        comboBox.addItemListener(e -> {
            Object item = e.getItem();
            if (item.equals("ls") || item.equals("get"))
                simulation.setText(simulation.getText() + "i");
            else if (item.equals("put"))
                simulation.setText(simulation.getText() + "p");

            text.setText("Message reçu : " + item.toString());
        });

        commandes.add(comboBox);
        commandes.add(text);

        JPanel end = new JPanel();

        JButton close = new JButton("close");
        close.addActionListener(e -> {
            motDePasse.setText("");
            simulation.setText(simulation.getText() + "c");
            layout.show(mainPanel, "X");
        });

        end.add(close);

        etat2.add(label2);
        etat2.add(commandes);
        etat2.add(end);

        // ajout du sous-panneau 'etat2' au panneau et layout principal
        layout.addLayoutComponent(etat2, "E2");
        mainPanel.add(etat2);

        // sous-panneau représentant le chemin suivi par la simulation
        JPanel x = new JPanel(new BorderLayout());

        JButton depart = new JButton("Retour E0");
        depart.addActionListener(e -> {
            simulation.setText("");
            comboBox.setSelectedIndex(0);
            layout.show(mainPanel, "E0");
        });

        x.add(simulation, BorderLayout.CENTER);
        x.add(depart, BorderLayout.SOUTH);

        // ajout du sous-panneau 'x' au panneau et layout principal
        layout.addLayoutComponent(x, "X");
        mainPanel.add(x);

        mainPanel.setLayout(layout);
        window.setContentPane(mainPanel);

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        AutomateFTP automate = new AutomateFTP();
        automate.showWindow();

        /* Une simulation est du type: o001iiiiiipiipc
         * 'o' est l'action d'ouverture de connexion
         * '1' (ou '0') signifie que le mot de passe est correct (incorrect dans le cas de '0')
         * 'i' correspond à une action du client, il s'agit de la commande 'ls' ou 'get'
         * 'p' correspond à un acquittement (commande 'put')
         * 'c' est l'action de fermeture de connexion
         */
    }
}
