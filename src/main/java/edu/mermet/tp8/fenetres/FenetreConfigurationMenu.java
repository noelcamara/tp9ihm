package edu.mermet.tp8.fenetres;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 
 * @author Rida GHOUTI TERKI
 *
 */
public class FenetreConfigurationMenu extends JDialog {
	
	private JPanel ligne1;
    private JPanel ligne2;
    private JPanel ligne3;
    private JPanel ligne4;
    private JPanel ligne5;
	
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
	 * Constructeur de la fentre non modale
	 * 
	 * @param me
	 * @param action
	 */
	public FenetreConfigurationMenu(JFrame me, Action action) {
		super(me, "Configuration des menus");
		setLocationRelativeTo(me);
		initComponent();
		pack();
		setModal(true);
	}

	/**
	 * permet d'initialiser l'ensemble des composant
	 */
	private void initComponent() {
        JPanel panel = new JPanel();
        this.setLayout(new GridLayout(5,1));
        
        ligne1 = new JPanel();
        ligne2 = new JPanel();
        ligne3 = new JPanel();
        ligne4 = new JPanel();
        ligne5 = new JPanel();
        
        this.creationLabelsRadios();
        this.creationBoutons();
    	
		this.add(ligne1);
		this.add(ligne2);
		this.add(ligne3);
		this.add(ligne4);
		this.add(ligne5);
	}

	/**
	 * Création des labels et des boutons radios 
	 */
	private void creationLabelsRadios() {
		conversionLabel = new JLabel("Conversion Celsius/Farenheit");
    	saisieLabel = new JLabel("Saisie de texte");
    	diaporamaLabel = new JLabel("Diaporama");
    	boutonsLabel = new JLabel("Boutons");
    	autoLabel = new JLabel("Automatique");
    	afficheLabel = new JLabel("Affiché");
    	cacheLabel = new JLabel("Caché");
    	
    	groupeConversion = new ButtonGroup();
    	groupeSaisie = new ButtonGroup();
    	groupeDiaporama = new ButtonGroup();
    	groupeBoutons = new ButtonGroup();
    	
    	radioAuto1 = new JRadioButton("Automatique");
    	radioAffiche1 = new JRadioButton("Affiché");
    	radioCache1 = new JRadioButton("Caché");

    	radioAuto2 = new JRadioButton("Automatique");
    	radioAffiche2 = new JRadioButton("Affiché");
    	radioCache2 = new JRadioButton("Caché");

    	radioAuto3 = new JRadioButton("Automatique");
    	radioAffiche3 = new JRadioButton("Affiché");
    	radioCache3 = new JRadioButton("Caché");

    	radioAuto4 = new JRadioButton("Automatique");
    	radioAffiche4 = new JRadioButton("Affiché");
    	radioCache4 = new JRadioButton("Caché");

    	ligne1.add(conversionLabel);
    	ligne1.add(radioAuto1);
    	ligne1.add(radioAffiche1);
    	ligne1.add(radioCache1);
    	
    	groupeConversion.add(radioAuto1);
    	groupeConversion.add(radioAffiche1);
    	groupeConversion.add(radioCache1);
    	
    	ligne2.add(saisieLabel);
    	ligne2.add(radioAuto2);
    	ligne2.add(radioAffiche2);
    	ligne2.add(radioCache2);
    	
    	groupeSaisie.add(radioAuto2);
    	groupeSaisie.add(radioAffiche2);
    	groupeSaisie.add(radioCache2);
    	
    	ligne3.add(diaporamaLabel);
    	ligne3.add(radioAuto3);
    	ligne3.add(radioAffiche3);
    	ligne3.add(radioCache3);
    	
    	groupeDiaporama.add(radioAuto3);
    	groupeDiaporama.add(radioAffiche3);
    	groupeDiaporama.add(radioCache3);
    	
    	ligne4.add(boutonsLabel);
    	ligne4.add(radioAuto4);
    	ligne4.add(radioAffiche4);
    	ligne4.add(radioCache4);
    	
    	groupeBoutons.add(radioAuto4);
    	groupeBoutons.add(radioAffiche4);
    	groupeBoutons.add(radioCache4);
	}

	/**
	 * creation de la Jlist à partir d'un fichier .propreties
	 */
	private void creationBoutons() {
		validerBouton = new JButton("Valider");
		annulerBouton = new JButton("Annuler");
		ligne5.add(validerBouton);
		ligne5.add(annulerBouton);
		
	}

	/**
	 * creation de JEditorPane qui va contenir les aides associés à la Jlist grâce à
	 * un ecouteur
	 */
	private void creationpanneau() {

	}

}
