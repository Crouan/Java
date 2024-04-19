/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.vue;

import vue.JFrameListeSalaries;
import java.util.ArrayList;
import java.sql.Date;
import modele.metier.Salarie;
import modele.metier.Service;

/**
 *
 * @author btssio
 */
public class TestJFrameListeSalaries {

    public static void main(String args[]) {
        JFrameListeSalaries jfListeSalaries;
        ArrayList<Service> lesServices = null;
        ArrayList<Salarie> lesSalaries = null;

        jfListeSalaries = new JFrameListeSalaries();

        // BOUCHON 
        lesServices = Bouchon.daoServiceGetAll();
        jfListeSalaries.remplirJComBoxServices(lesServices);

        // Remplissage jtable des salariés avec
        // BOUCHON
        lesSalaries = Bouchon.daoSalarieGetAll();        
        jfListeSalaries.remplirJTableSalaries(lesSalaries);
        jfListeSalaries.setVisible(true);

    }
}
