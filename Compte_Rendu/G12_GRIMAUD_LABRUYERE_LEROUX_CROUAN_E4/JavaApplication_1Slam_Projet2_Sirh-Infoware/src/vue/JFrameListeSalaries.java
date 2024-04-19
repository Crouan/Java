package vue;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modele.dao.DaoSalarie;
import modele.metier.Salarie;
import modele.metier.Service;

/**
 * GUI liste des salariés par service
 * @author btssio
 */
public class JFrameListeSalaries extends javax.swing.JFrame {


    // les modèles 
    private DefaultTableModel modeleJTableLesSalaries;
    private DefaultComboBoxModel modeleJComboLesServices;

    /**
     * Creates new form JFrameListeSalariess
     */
    public JFrameListeSalaries() {
        initComponents();
        this.setLocation(150, 150);

        // Définition du nouveau modèle de JComboBox
        modeleJComboLesServices = new DefaultComboBoxModel();
        jComboBoxLesServices.setModel(modeleJComboLesServices);

        // Définition du nouveau modèle de JTable :
        //      - rendre les cellules non éditables
        modeleJTableLesSalaries = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int iRowIndex, int iColumnIndex) {
                return false;
            }
        };
        //      - affecter le modèle au composant JTable       
        jTableSalaries.setModel(modeleJTableLesSalaries);
        //      - configurer les colonnes
        String[] titres = {"Code", "Nom", "Prenom", "Date naiss.", "Date emb.", "Fonction", "Service"};
        modeleJTableLesSalaries.setColumnIdentifiers(titres);
        //      - adapter la largeur des colonnes
        jTableSalaries.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableSalaries.getColumnModel().getColumn(3).setPreferredWidth(90);
        jTableSalaries.getColumnModel().getColumn(4).setPreferredWidth(90);
        jTableSalaries.getColumnModel().getColumn(5).setPreferredWidth(150);
        jTableSalaries.getColumnModel().getColumn(6).setPreferredWidth(100);



    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSalaries = new javax.swing.JTable();
        jComboBoxLesServices = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButtonSupprimer = new javax.swing.JButton();
        jButtonQuitter1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("InfoWare - SIRH");

        jLabel1.setText("Liste des salariés par service");

        jTableSalaries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableSalaries.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSalariesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSalaries);

        jLabel2.setText("Service :");

        jButtonSupprimer.setText("Supp");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });

        jButtonQuitter1.setText("Quitter");
        jButtonQuitter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitter1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxLesServices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(310, 310, 310))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(241, 241, 241))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonSupprimer)
                                .addGap(80, 80, 80)))
                        .addGap(26, 26, 26))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(695, Short.MAX_VALUE)
                    .addComponent(jButtonQuitter1)
                    .addGap(16, 16, 16)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxLesServices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButtonSupprimer)
                .addGap(17, 17, 17))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(318, Short.MAX_VALUE)
                    .addComponent(jButtonQuitter1)
                    .addGap(16, 16, 16)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableSalariesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSalariesMouseClicked
        // Un salarié sélectionné ?
        if (jTableSalaries.getSelectedRow() > -1) {
            String codeSalarie = (String) jTableSalaries.getValueAt(jTableSalaries.getSelectedRow(), 0);
            // Lire le salarié sélectionné
            Salarie unSalarie = null;
            // Lire le salarié sélectionné dans la BDD
            try {
                unSalarie = DaoSalarie.getOneById(codeSalarie);
                System.out.println("Salarié sélexctionné :\n" + unSalarie.toString());
            } catch (Exception ex) {
                System.out.println("JFrameListeSalaries - pb lecture salarie sélectionné : " + ex.getMessage());
            }
        }

    }//GEN-LAST:event_jTableSalariesMouseClicked

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

    private void jButtonQuitter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitter1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonQuitter1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameListeSalaries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameListeSalaries().setVisible(true);
            }
        });
    }

    // SERVICES
    public void remplirJComBoxServices(List<Service> desServices) {
        modeleJComboLesServices.removeAllElements();
        // La première option permet de sélectionner tous les salariés
        modeleJComboLesServices.addElement(new Service(0, "*** Tous services ***"));
        // Options suivantes : une par service
        for (Service unService : desServices) {
            modeleJComboLesServices.addElement(unService);
        }
    }

    public void remplirJTableSalaries(List<Salarie> desSalaries) {
        modeleJTableLesSalaries.setRowCount(0);
        // Une ligne de la table est un tableau d'objets
        Object[] rowData = new Object[jTableSalaries.getColumnModel().getColumnCount()];
        for (Salarie unSalarie : desSalaries) {
            rowData[0] = unSalarie.getCode();
            rowData[1] = unSalarie.getNom();
            rowData[2] = unSalarie.getPrenom();
            rowData[3] = unSalarie.getDateNaiss();
            rowData[4] = unSalarie.getDateEmbauche();
            rowData[5] = unSalarie.getFonction();
            if (unSalarie.getService() != null){
                rowData[6] = unSalarie.getService().getDesignation();
            }else{
                rowData[6] = "";
            }
            
            modeleJTableLesSalaries.addRow(rowData);
        }
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonQuitter1;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JComboBox jComboBoxLesServices;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSalaries;
    // End of variables declaration//GEN-END:variables
}
