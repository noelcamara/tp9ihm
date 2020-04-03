package edu.mermet.tp8.fenetres;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * 
 * @author Billal Ihaddaden and Rida GHOUTI TERKI
 *
 */
public class FenetreConfigurationMenu extends JDialog {

	private JPanel panneau;
	private JPanel panBas;
	private JPanel panHaut;

	private JLabel conversionLabel;
	private JLabel saisieLabel;
	private JLabel diaporamaLabel;
	private JLabel boutonsLabel;

	private ButtonGroup groupeConversion;
	private ButtonGroup groupeSaisie;
	private ButtonGroup groupeDiaporama;
	private ButtonGroup groupeBoutons;

	private JRadioButton radioAuto1;
	private JRadioButton radioAffiche1;
	private JRadioButton radioCache1;

	private JRadioButton radioAuto2;
	private JRadioButton radioAffiche2;
	private JRadioButton radioCache2;

	private JRadioButton radioAuto3;
	private JRadioButton radioAffiche3;
	private JRadioButton radioCache3;

	private JRadioButton radioAuto4;
	private JRadioButton radioAffiche4;
	private JRadioButton radioCache4;

	private JButton validerBouton;
	private JButton annulerBouton;

	/**
	 * Constructeur de la fentre modale des configuration des menus
	 * 
	 * @param me
	 * @param action
	 */
	public FenetreConfigurationMenu(JFrame me, Action action) {
		super(me, "Configuration des menus", true);
		setLocationRelativeTo(me);
		initComponent();
		pack();
	}

	/**
	 * permet d'initialiser l'ensemble des composants
	 */
	private void initComponent() {
		JPanel panneau = new JPanel();
		this.setContentPane(panneau);
		panneau.setLayout(new BorderLayout());
		creationPanHaut();
		creationPanBas();
	}

	/**
	 * Création du JPanel haut
	 */
	private void creationPanHaut() {
		panHaut = new JPanel();
		panHaut.setLayout(new GridLayout(4, 4));
		getContentPane().add(panHaut, BorderLayout.CENTER);
		// creation des labels
		conversionLabel = new JLabel("Conversion Celsius/Farenheit");
		saisieLabel = new JLabel("Saisie de texte");
		diaporamaLabel = new JLabel("Diaporama");
		boutonsLabel = new JLabel("Boutons");

		// creation des boutons groupes
		groupeConversion = new ButtonGroup();
		groupeSaisie = new ButtonGroup();
		groupeDiaporama = new ButtonGroup();
		groupeBoutons = new ButtonGroup();

		// creation des radios bouton
		radioAuto1 = new JRadioButton("Auto");
		radioAffiche1 = new JRadioButton("Affiché");
		radioCache1 = new JRadioButton("Caché");
		radioAuto2 = new JRadioButton("Auto");
		radioAffiche2 = new JRadioButton("Affiché");
		radioCache2 = new JRadioButton("Caché");
		radioAuto3 = new JRadioButton("Auto");
		radioAffiche3 = new JRadioButton("Affiché");
		radioCache3 = new JRadioButton("Caché");
		radioAuto4 = new JRadioButton("Auto");
		radioAffiche4 = new JRadioButton("Affiché");
		radioCache4 = new JRadioButton("Caché");

		// creation des listner
		radioAuto1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		radioAffiche1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		radioCache1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		radioAuto2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		radioAffiche2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		radioCache2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		radioAuto3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		radioAffiche3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		radioCache3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		radioAuto4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		radioAffiche4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		radioCache4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		// Ajout des radios boutons au groupe boutons
		groupeConversion.add(radioAuto1);
		groupeConversion.add(radioAffiche1);
		groupeConversion.add(radioCache1);
		groupeSaisie.add(radioAuto2);
		groupeSaisie.add(radioAffiche2);
		groupeSaisie.add(radioCache2);
		groupeDiaporama.add(radioAuto3);
		groupeDiaporama.add(radioAffiche3);
		groupeDiaporama.add(radioCache3);
		groupeBoutons.add(radioAuto4);
		groupeBoutons.add(radioAffiche4);
		groupeBoutons.add(radioCache4);

		panHaut.add(conversionLabel);
		panHaut.add(radioAuto1);
		panHaut.add(radioAffiche1);
		panHaut.add(radioCache1);

		panHaut.add(saisieLabel);
		panHaut.add(radioAuto2);
		panHaut.add(radioAffiche2);
		panHaut.add(radioCache2);

		panHaut.add(diaporamaLabel);
		panHaut.add(radioAuto3);
		panHaut.add(radioAffiche3);
		panHaut.add(radioCache3);

		panHaut.add(boutonsLabel);
		panHaut.add(radioAuto4);
		panHaut.add(radioAffiche4);
		panHaut.add(radioCache4);
	}

	/**
	 * creation du panneau bas
	 */
	private void creationPanBas() {
		panBas = new JPanel();
		getContentPane().add(panBas, BorderLayout.SOUTH);
		validerBouton = new JButton("Valider");
		annulerBouton = new JButton("Annuler");
		panBas.add(validerBouton);
		panBas.add(annulerBouton);
		validerBouton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		annulerBouton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

	}

}
