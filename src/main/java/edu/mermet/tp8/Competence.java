package edu.mermet.tp8;

/**
 * 
 * @author Billal Ihaddaden
 *
 */
public class Competence {
	private Double competence;

	/**
	 * Constructeur par default (le cas d'un nouveau joueur)
	 */
	public Competence() {
		this.competence = (double) 1;
	}

	/**
	 * Constructeur avec paramettre (creer un nouvelle competence a partir d'une
	 * donnee)
	 * 
	 * @param competence
	 */
	public Competence(Double competence) {
		this.competence = competence;
	}

	/**
	 * 
	 * @return competence du joueur
	 */
	public Double getCompetence() {
		return competence;
	}

	/**
	 * Ajout de la competence de 0.1 pour chaque utilisation de quitter jusqu'a ce
	 * que la competence egale a 4
	 */
	public void AjoutComQuitter() {
		if (competence <= 4) {
			competence = competence+0.1;
		}
	}

	/**
	 * ajout de la competence avec 0.2 pour l'utilisation du diaporama apres avoir
	 * depasser 2 et s'arrete en atteignant la competence 8
	 */
	public void AjoutComDiap() {
		if (competence >= 2 && competence <= 8) {
			competence = competence+0.2;
		}
	}

	/**
	 * ajout de la competence de l'utilisation de conversion et saisi de texte
	 * lorsque la competence est entre 4 et 16
	 */
	public void AjoutComConvEtSaisi() {
		if (competence >= 4 && competence <= 16) {
			competence = competence+0.4;
		}
	}

	/**
	 * ajout de la competence de l'utilisation de bouton lorsque la competence est
	 * entre 8 et 16
	 */
	public void AjoutComBouton() {
		if (competence >= 8 && competence <= 16) {
			competence = competence+0.8;
		}
	}

}
