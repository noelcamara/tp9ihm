package edu.mermet.tp8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import edu.mermet.tp8.fenetres.FenetreBoutons;
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
	private Action actionAfficherConversion;
	private Action actionAfficherTexte;
	private Action actionAfficherDiaporama;
	private Action actionAfficherBoutons;
	private Action actionCmntFaire;
	private Action actionConfigMenu;

	public Application() {
		super("multi-fenêtres");
		this.setContentPane(new JDesktopPane());

		// ****** Barre de menu ******
		JMenuBar barre = new JMenuBar();
		// ------ menu Fichier ------
		JMenu menuFichier = new JMenu("Fichier");
		menuFichier.setMnemonic(KeyEvent.VK_F);
		JMenuItem quitter = new JMenuItem("Quitter");
		quitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent aev) {
				System.exit(0);
			}
		});
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		menuFichier.add(quitter);
		barre.add(menuFichier);
		this.setJMenuBar(barre);
		// ------ menu Applications ------
		JMenu menuApplication = new JMenu("Applications");
		menuApplication.setMnemonic(KeyEvent.VK_A);
		actionAfficherConversion = new ActionAfficherConversion();
		JMenuItem itemConversion = new JMenuItem(actionAfficherConversion);
		menuApplication.add(itemConversion);
		actionAfficherTexte = new ActionAfficherTexte();
		JMenuItem itemTexte = new JMenuItem(actionAfficherTexte);
		menuApplication.add(itemTexte);
		actionAfficherDiaporama = new ActionAfficherDiaporama();
		JMenuItem itemDiaporama = new JMenuItem(actionAfficherDiaporama);
		menuApplication.add(itemDiaporama);
		actionAfficherBoutons = new ActionAfficherBoutons();
		JMenuItem itemBoutons = new JMenuItem(actionAfficherBoutons);
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
		// ****** Fin création fenêtres ******
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);
		this.setLocationRelativeTo(null);
		setVisible(true);
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
			System.out.println("2");

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

}
