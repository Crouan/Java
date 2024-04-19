package modele.metier;

import java.util.Date;
import java.util.Locale;

/**
 * Classe métier
 *
 * @author btssio
 */
public class Salarie {

    private String code = "";
    private String nom = "";
    private String prenom = "";
    private Date dateNaiss;
    private Date dateEmbauche;
    private String fonction;
    private double tauxHoraire;
    private String situationFamiliale;
    private int nbrEnfants;
    private Service service;
    private Categorie categorie;

    /**
     * Constructeur du salarié sans service associé
     *
     * @param code matricule du salarié
     * @param nom
     * @param prenom
     * @param dateNaiss date de naissance du salarié
     * @param dateEmbauche date d'embauche du salarié
     * @param fonction ex : Developpeur, Standardiste, ...
     * @param tauxHoraire salaire horaire
     * @param situationFamiliale Marié, Célibataire, ...
     * @param nbrEnfants nombre d'enfants
     */
    public Salarie(String code, String nom, String prenom, Date dateNaiss, Date dateEmbauche, String fonction, double tauxHoraire, String situationFamiliale, int nbrEnfants) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.dateEmbauche = dateEmbauche;
        this.fonction = fonction;
        this.tauxHoraire = tauxHoraire;
        this.situationFamiliale = situationFamiliale;
        this.nbrEnfants = nbrEnfants;
        this.service = null;
        this.categorie = null;
    }

    /**
     * Constructeur du salarié avec son service
     *
     * @param code matricule du salarié
     * @param nom
     * @param prenom
     * @param dateNaiss date de naissance du salarié
     * @param dateEmbauche date d'embauche du salarié
     * @param fonction ex : Developpeur, Standardiste, ...
     * @param tauxHoraire salaire horaire
     * @param situationFamiliale Marié, Célibataire, ...
     * @param nbrEnfants nombre d'enfants
     * @param serv objet Service représentant le service danns lequel travaille
     * le salarié
     */
    public Salarie(String code, String nom, String prenom, Date dateNaiss, Date dateEmbauche, String fonction, double tauxHoraire, String situationFamiliale, int nbrEnfants, Service serv,Categorie categorie) {
        this(code, nom, prenom, dateNaiss, dateEmbauche, fonction, tauxHoraire, situationFamiliale, nbrEnfants);
        this.service = serv;
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        String dateNaissFmt = String.format("%1$td/%1$tm/%1$tY  ", dateNaiss);
        String dateEmbFmt = String.format("%1$td/%1$tm/%1$tY  ", dateEmbauche);
        String txHoraireFmt = String.format(Locale.FRANCE, "%1$5.2f", tauxHoraire);
        String serviceToString = (service == null ? "Néant" : service.toStringEtat());
        String categorieToString = (categorie == null ? "Néant" : categorie.toString());
        return "Salarie{" + "code=" + code + ", nom=" + nom + ", prenom=" + prenom + ", dateNaiss=" + dateNaissFmt + ", dateEmbauche=" + dateEmbFmt
                + ", fonction=" + fonction + ", tauxHoraire=" + txHoraireFmt + ", situationFamiliale=" + situationFamiliale + ", nbrEnfants=" + nbrEnfants
                + ",\n service=" + serviceToString + ",\n Categorie=" + categorieToString +'}';

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(java.sql.Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(java.sql.Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    public String getSituationFamiliale() {
        return situationFamiliale;
    }

    public void setSituationFamiliale(String situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }

    public int getNbrEnfants() {
        return nbrEnfants;
    }

    public void setNbrEnfants(int nbrEnfants) {
        this.nbrEnfants = nbrEnfants;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
