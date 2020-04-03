package edu.mermet.tp8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import edu.mermet.tp8.fenetres.FenetreBoutons;
import edu.mermet.tp8.fenetres.FenetreConfigurationMenu;
import edu.mermet.tp8.fenetres.FenetreConversion;
import edu.mermet.tp8.fenetres.FenetreDiaporama;
import edu.mermet.tp8.fenetres.FenetreTexte;
import edu.mermet.tp8.fenetres.FentreCmntFaire;

/**
 *
 * @author
 */
public class Application extends JFrame {

	private JInternalFrame conversion;
	private JInternalFrame texte;
	private JInternalFrame diaporama;
	private JInternalFrame boutons;
	private JDialog comntfaire;
	private JDialog configMenus;
	private Action actionAfficherConversion;
	private Action actionAfficherTexte;
	private Action actionAfficherDiaporama;
	private Action actionAfficherBoutons;
	private Action actionCmntFaire;
	private Action actionConfigMenu;
	
	private static JMenu menuApplication;
	private static JMenuItem itemConversion;
	private static JMenuItem itemTexte;
	private static JMenuItem itemDiaporama;
	private static JMenuItem itemBoutons;

	public Application() {
		super("multi-fenêtres");
		this.setContentPane(new JDesktopPane());

		// ****** Barre de menu ******
		JMenuBar barre = new JMenuBar();
		// ------ menu Fichier ------
		JMenu menuFichier = new JMenu("Fichier");
		menuFichier.setMnemonic(KeyEvent.VK_F);
		// Bouton quitter auquel on affecte l'action de fermer la page
		JMenuItem quitter = new JMenuItem("Quitter");
		quitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent aev) {
				System.exit(0);
			}
		});
		// Ajout du raccourci pour quitter la page
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		//Ajout de "Quitter" dans le menu
		menuFichier.add(quitter);
		barre.add(menuFichier);
		this.setJMenuBar(barre);
		// ------ menu Applications ------
		menuApplication = new JMenu("Applications");
		menuApplication.setMnemonic(KeyEvent.VK_A);
		actionAfficherConversion = new ActionAfficherConversion();
		itemConversion = new JMenuItem(actionAfficherConversion);
		menuApplication.add(itemConversion);
		
		actionAfficherTexte = new ActionAfficherTexte();
		itemTexte = new JMenuItem(actionAfficherTexte);
		menuApplication.add(itemTexte);
		actionAfficherDiaporama = new ActionAfficherDiaporama();
		itemDiaporama = new JMenuItem(actionAfficherDiaporama);
		menuApplication.add(itemDiaporama);
		actionAfficherBoutons = new ActionAfficherBoutons();
		itemBoutons = new JMenuItem(actionAfficherBoutons);
		menuApplication.add(itemBoutons);
		barre.add(menuApplication);
		// ******aide******
		JMenu aide = new JMenu("Aide");
		actionCmntFaire = new ActionComntFaire();
		JMenuItem cmntFaire = new JMenuItem(actionCmntFaire);
		actionConfigMenu = new ActionConfigMenu();
		JMenuItem confMenu = new JMenuItem(actionConfigMenu);
		aide.add(cmntFaire);
		aide.add(confMenu);
		barre.add(aide);

		// ****** Fin barre de menu ******

		// ****** Création des fenêtres ******
		// ------ fenêtre conversion ------
		conversion = new FenetreConversion(actionAfficherConversion);
		this.add(conversion);
		// ------ fenêtre texte ------
		texte = new FenetreTexte(actionAfficherTexte);
		this.add(texte);
		// ------ fenêtre diaporama ------
		diaporama = new FenetreDiaporama(actionAfficherDiaporama);
		this.add(diaporama);
		// ------ fenêtre boutons ------
		boutons = new FenetreBoutons(this, actionAfficherBoutons);
		this.add(boutons);
		// ------ jdialog -------
		comntfaire = new FentreCmntFaire(this, actionCmntFaire);
		
		configMenus = new FenetreConfigurationMenu(this, actionConfigMenu);
		// ****** Fin création fenêtres ******
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);
		this.setLocationRelativeTo(null);
		setVisible(true);
		initSuggestion();
	}
	
	// ---------------------------partie une--------------------------------
	private class ActionComntFaire extends AbstractAction {

		public ActionComntFaire() {
			super("Comment faire ?");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
			putValue(Action.MNEMONIC_KEY, KeyEvent.VK_I);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			comntfaire.setVisible(true);
		}

	}

	private class ActionConfigMenu extends AbstractAction {

		public ActionConfigMenu() {
			super("Configuration des menus");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
			putValue(Action.MNEMONIC_KEY, KeyEvent.VK_O);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			configMenus.setVisible(true);

		}

	}

	private class ActionAfficherBoutons extends AbstractAction {
		public ActionAfficherBoutons() {
			super("Boutons");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
			putValue(Action.MNEMONIC_KEY, KeyEvent.VK_B);
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			boutons.setVisible(true);
			enableBoutons(false);
		}
	}

	private class ActionAfficherDiaporama extends AbstractAction {
		public ActionAfficherDiaporama() {
			super("Diaporama");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
			putValue(Action.MNEMONIC_KEY, KeyEvent.VK_D);
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			diaporama.setVisible(true);
			enableDiaporama(false);
		}
	}

	private class ActionAfficherTexte extends AbstractAction {
		public ActionAfficherTexte() {
			super("Saisie de texte");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
			putValue(Action.MNEMONIC_KEY, KeyEvent.VK_T);
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			texte.setVisible(true);
			enableTexte(false);
		}
	}

	public class ActionAfficherConversion extends AbstractAction {
		public ActionAfficherConversion() {
			super("Conversion Celsius/Farenheit");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
			putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			conversion.setVisible(true);
			enableConversion(false);
		}
	}

	public void enableConversion(boolean b) {
		actionAfficherConversion.setEnabled(b);
	}

	public void enableTexte(boolean b) {
		actionAfficherTexte.setEnabled(b);
	}

	public void enableDiaporama(boolean b) {
		actionAfficherDiaporama.setEnabled(b);
	}

	public void enableBoutons(boolean b) {
		actionAfficherBoutons.setEnabled(b);
	}
	
	// Pour la classe FenetreConfigurationMenu
	
	public static void afficheConversion() { 
		//menuApplication.add(itemConversion);
		itemConversion.setVisible(true);
	}
	
	public static void afficheTexte() { 
		//menuApplication.add(itemTexte);
		itemTexte.setVisible(true);
		
	}
	
	public static void afficheDiaporama() { 
		//menuApplication.add(itemDiaporama); 
		itemDiaporama.setVisible(true);
		
	}
	
	public static void afficheBoutons() { 
		//menuApplication.add(itemBoutons); 
		itemBoutons.setVisible(true);
		}
	
	public static void removeConversion() { 
		itemConversion.setVisible(false);
		System.out.println(itemConversion.isVisible());
		}
	
	public static void removeTexte() { 
		//menuApplication.remove(itemTexte); 
		itemTexte.setVisible(false);
		}
	
	public static void removeDiaporama() { 
		//menuApplication.remove(itemDiaporama); 
		itemDiaporama.setVisible(false);
		}
	
	public static void removeBoutons() { 
		itemBoutons.setVisible(false); 
		}
	

	public Action getActionAfficherConversion() {
		return actionAfficherConversion;
	}

	public Action getActionAfficherTexte() {
		return actionAfficherTexte;
	}

	public Action getActionAfficherDiaporama() {
		return actionAfficherDiaporama;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Application::new);
	}

	private void initSuggestion() {
		JDialog suggestion = new JDialog(this);
		suggestion.setLayout(new BorderLayout());
		JTextArea areaSuggestion = new JTextArea(5, 60);
		areaSuggestion.setEditable(false);
		JScrollPane scroll = new JScrollPane(areaSuggestion);
		areaSuggestion.append(getRandomSuggestion());
		JPanel panelButton = new JPanel();
		panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton fermer = new JButton("Fermer");
		fermer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				suggestion.dispose();
			}
		});
		panelButton.add(fermer);
		JButton NePlusAfficher = new JButton("Ne plus afficher");
		NePlusAfficher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				suggestion.dispose();
			}
		});
		panelButton.add(NePlusAfficher);
		suggestion.add(panelButton, BorderLayout.SOUTH);
		suggestion.add(scroll, BorderLayout.CENTER);
		suggestion.setSize(500, 150);
		suggestion.setLocationRelativeTo(null);
		suggestion.setUndecorated(true);
		suggestion.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));
		suggestion.setVisible(true);
	}

	private static String getRandomSuggestion() {
		try {
			List<String> listeSuggestion = new ArrayList<String>();
			BufferedReader reader = new BufferedReader(new FileReader(new File("src/ressources/Astuces")));
			String ligne;
			while ((ligne = reader.readLine()) != null) {
				listeSuggestion.add(ligne);
			}
			Random rand = new Random();
			int nombreAleatoire = rand.nextInt(listeSuggestion.size());
			System.out.println(nombreAleatoire);
			return listeSuggestion.get(nombreAleatoire);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

}
