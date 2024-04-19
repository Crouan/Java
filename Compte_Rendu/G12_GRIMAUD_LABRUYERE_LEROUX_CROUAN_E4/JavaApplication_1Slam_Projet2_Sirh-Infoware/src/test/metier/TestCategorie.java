/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test.metier;
import modele.metier.Categorie;
/**
 *
 * @author btssio
 */
public class TestCategorie {
    public static void main(String[] args) {
        Categorie fausseCategorie;
        double smic;  
        int prime;
        smic=1300;
        prime=50;
        fausseCategorie = new Categorie("0A429","Chomeur",smic,"les loby laitier",prime);
        
        System.out.println("test classe categorie");
        System.out.println(fausseCategorie.toString());
    }
    
}
