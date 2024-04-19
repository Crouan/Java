/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Categorie {

    private String code;
    private String libele;
    private double salaireMini;
    private String caisseRetraite;
    private int prime;

    public Categorie(String code, String libele, double salaireMini, String caisseRetraite, int prime) {
        this.code = code;
        this.libele = libele;
        this.salaireMini = salaireMini;
        this.caisseRetraite = caisseRetraite;
        this.prime = prime;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public String getLibele() {
        return libele;
    }

    public void setSalaireMini(double mini) {
        this.salaireMini = mini;
    }

    public double getSalaireMini() {
        return salaireMini;
    }

    public void setCaisseRetraite(String caisseRetraite) {
        this.caisseRetraite = caisseRetraite;
    }

    public String getCaisseRetraite() {
        return caisseRetraite;
    }

    public void setPrime(int prime) {
        this.prime = prime;
    }

    public int getPrime() {
        return prime;
    }
    
    @Override
    public String toString() {
        String image;
        image=code+";"+libele+":Un Salaire Minimum de "+salaireMini+",une Caisse de Retraite de "+caisseRetraite+" avec une prime de "+prime;
        return image;
    }
}
