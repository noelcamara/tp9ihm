package edu.mermet.tp8.fenetres;

import java.awt.Dimension;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Action;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 
 * @author Billal ihaddaden
 *
 */
public class FentreCmntFaire extends JDialog {
	JList<String> maliste;
	JScrollPane scroll;
	JEditorPane explication;
	JSplitPane panneauPrincipale;
	Locale loc;
	ResourceBundle resTitres, resTextes;

	/**
	 * Constructeur de la fentre non modale
	 * 
	 * @param me
	 * @param action
	 */
	public FentreCmntFaire(JFrame me, Action action) {
		super(me, "Comment Faire?");
		setLocationRelativeTo(me);
		initComponent();
		pack();
	}

	/**
	 * permet d'initialiser l'ensemble des composant
	 */
	private void initComponent() {
		creationLocal();
		panneauPrincipale = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		this.setContentPane(panneauPrincipale);
		creationList();
		creationpanneau();

	}

	/**
	 * creation des objets necessaire afin de permettre l'ajout d'aide et la
	 * traduction
	 */
	private void creationLocal() {
		loc = new Locale("fr", "FR");
		resTitres = ResourceBundle.getBundle("HowTo/titres_fr_FR", loc);
		resTextes = ResourceBundle.getBundle("HowTo/textes_fr_FR", loc);
	}

	/**
	 * creation de la Jlist à partir d'un fichier .propreties
	 */
	private void creationList() {
		String[] data = { resTitres.getString("titre1"), resTitres.getString("titre2"), resTitres.getString("titre3"),
				resTitres.getString("titre4"), resTitres.getString("titre5"), resTitres.getString("titre6") };
		maliste = new JList<String>(data);
		panneauPrincipale.setLeftComponent(maliste);

	}

	/**
	 * creation de JEditorPane qui va contenir les aides associés à la Jlist grâce à
	 * un ecouteur
	 */
	private void creationpanneau() {
		scroll = new JScrollPane();
		scroll.setPreferredSize(new Dimension(200, 50));
		explication = new JEditorPane();
		explication.setEditable(false);
		explication.setContentType("text/html");
		scroll.setViewportView(explication);
		// ----------------listner sur le composant JList------------------------
		maliste.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				switch (maliste.getSelectedIndex()) {
				case 0:
					explication.setText(resTextes.getString("titre1"));

					break;
				case 1:
					explication.setText(resTextes.getString("titre2"));

					break;
				case 2:
					explication.setText(resTextes.getString("titre3"));

					break;
				case 3:
					explication.setText(resTextes.getString("titre4"));

					break;
				case 4:
					explication.setText(resTextes.getString("titre5"));

					break;
				case 5:
					explication.setText(resTextes.getString("titre6"));

					break;
				default:
					break;
				}

			}
		});
		panneauPrincipale.setRightComponent(scroll);
	}

}
