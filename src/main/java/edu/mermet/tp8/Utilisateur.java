package edu.mermet.tp8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilisateur {
	private String nom, chemin;
	private Properties properties;

	/**
	 * Constructeur par defaut si aucun nom n'est passé en parametre l'utilisateur
	 * sera login
	 */
	public Utilisateur() {
		this.nom = "login";
		chemin = "src/ressources/.ihm/login.xml";
		properties = new Properties();
		try {
			properties.loadFromXML(new FileInputStream(chemin));
		} catch (IOException e) {
			System.err.println("le fichier login.xml n'existe pas");
		}
	}

	/**
	 * constrcuteur avec paramètre qui represente l'utilisateur actuel
	 * @param nom String l'utilisateur
	 */
	public Utilisateur(String nom) {
		this.nom = nom;
		properties = new Properties();
		chemin = "src/ressources/.ihm/" + nom + ".xml";
		try {
			properties.loadFromXML(new FileInputStream(chemin));
		} catch (IOException e) {
			System.out.println("Fichier utilisateur de " + nom
					+ " non existant ! Création objet utilisateur avec propriétés vides.");
		}

	}

	/**
	 * Méthode pour sauvegarder les modifications sur le fichier xml de
	 * l'utilisateur
	 */
	public void enregistrer() {
		try {
			properties.storeToXML(new FileOutputStream(chemin), null);
		} catch (IOException e) {
			System.err.println("erreur d'enregistrement");
		}
	}

	/**
	 * Méthode qui récupere la valeur associée à la clé dans le fichier xml de
	 * l'utilisateur
	 * 
	 * @param cle String clé
	 * @return String
	 */
	public String getProperties(String cle) {
		String valeur = properties.getProperty(cle);

		return valeur;
	}

	/**
	 * Méthode qui permet de modifier la valeur associée à la clé par une nouvelle
	 * @param cle String 
	 * @param valeur String
	 */
	public void setProperties(String cle, String valeur) {
		properties.setProperty(cle, valeur);
	}
	
	/**
	 * méthode qui récupere le nom de l'utilsateur
	 * @return
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Méthode qui récupere le chemin du fichier xml de l'utilsateur
	 * @return
	 */
	public String getChemin() {
		return chemin;
	}

}
