/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.presentacion;

/**
 *
 * @author yerso
 */
public class GUIMenuAdmin extends javax.swing.JFrame {

    /**
     * Creates new form GUIMenuAdmin
     */
    public GUIMenuAdmin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpPrincipal = new javax.swing.JTabbedPane();
        pnlRegistrarPersonal = new javax.swing.JPanel();
        pnlModificarPersonal = new javax.swing.JPanel();
        pnlEliminarPersonal = new javax.swing.JPanel();
        pnlConsultarPersonal = new javax.swing.JPanel();
        pnlListarPersonal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout pnlRegistrarPersonalLayout = new javax.swing.GroupLayout(pnlRegistrarPersonal);
        pnlRegistrarPersonal.setLayout(pnlRegistrarPersonalLayout);
        pnlRegistrarPersonalLayout.setHorizontalGroup(
            pnlRegistrarPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        pnlRegistrarPersonalLayout.setVerticalGroup(
            pnlRegistrarPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        tbpPrincipal.addTab("Registar", pnlRegistrarPersonal);

        javax.swing.GroupLayout pnlModificarPersonalLayout = new javax.swing.GroupLayout(pnlModificarPersonal);
        pnlModificarPersonal.setLayout(pnlModificarPersonalLayout);
        pnlModificarPersonalLayout.setHorizontalGroup(
            pnlModificarPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        pnlModificarPersonalLayout.setVerticalGroup(
            pnlModificarPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        tbpPrincipal.addTab("Modificar", pnlModificarPersonal);

        javax.swing.GroupLayout pnlEliminarPersonalLayout = new javax.swing.GroupLayout(pnlEliminarPersonal);
        pnlEliminarPersonal.setLayout(pnlEliminarPersonalLayout);
        pnlEliminarPersonalLayout.setHorizontalGroup(
            pnlEliminarPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        pnlEliminarPersonalLayout.setVerticalGroup(
            pnlEliminarPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        tbpPrincipal.addTab("Eliminar", pnlEliminarPersonal);

        javax.swing.GroupLayout pnlConsultarPersonalLayout = new javax.swing.GroupLayout(pnlConsultarPersonal);
        pnlConsultarPersonal.setLayout(pnlConsultarPersonalLayout);
        pnlConsultarPersonalLayout.setHorizontalGroup(
            pnlConsultarPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        pnlConsultarPersonalLayout.setVerticalGroup(
            pnlConsultarPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        tbpPrincipal.addTab("Consultar", pnlConsultarPersonal);

        javax.swing.GroupLayout pnlListarPersonalLayout = new javax.swing.GroupLayout(pnlListarPersonal);
        pnlListarPersonal.setLayout(pnlListarPersonalLayout);
        pnlListarPersonalLayout.setHorizontalGroup(
            pnlListarPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        pnlListarPersonalLayout.setVerticalGroup(
            pnlListarPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        tbpPrincipal.addTab("Listar", pnlListarPersonal);

        getContentPane().add(tbpPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIMenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlConsultarPersonal;
    private javax.swing.JPanel pnlEliminarPersonal;
    private javax.swing.JPanel pnlListarPersonal;
    private javax.swing.JPanel pnlModificarPersonal;
    private javax.swing.JPanel pnlRegistrarPersonal;
    private javax.swing.JTabbedPane tbpPrincipal;
    // End of variables declaration//GEN-END:variables
}