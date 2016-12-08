package automate.exoFTP;

import automate.Automate;

import javax.swing.*;
import java.awt.*;

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

        //this.showWindow();
    }

    private void showWindow() {
        JFrame window = new JFrame("AutomateFTP");

        window.setSize(new Dimension(400, 250));

        Point centreEcran = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        window.setLocation((int)centreEcran.getX() - (window.getSize().width / 2),
                (int)centreEcran.getY() - (window.getSize().height / 2));

        JPanel mainPanel = new JPanel();
        CardLayout layout = new CardLayout();

        JPanel etat0 = new JPanel(new BorderLayout());
        etat0.add(new JLabel("état en cours : E0 - prochain état : E1"), BorderLayout.NORTH);

        JButton open = new JButton("open");
        open.addActionListener(e -> layout.show(mainPanel, "E1"));

        etat0.add(open, BorderLayout.CENTER);
        layout.addLayoutComponent(etat0, "E0");

        JPanel etat1 = new JPanel(new BorderLayout());
        etat1.add(new JLabel("état en cours : E1 - prochains états : E1 / E2"), BorderLayout.NORTH);

        layout.addLayoutComponent(etat1, "E1");

        mainPanel.setLayout(layout);
        window.setContentPane(mainPanel);

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //window.pack();
        window.setVisible(true);
    }
}
