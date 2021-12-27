package cliente.presentacion;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import mvcf.AModel;
import mvcf.AView;

/**
 *
 * @author yerso
 */
public class GUIPrincipal extends javax.swing.JFrame implements AView {

    /**
     * Creates new form GUIAbrirSesion
     */
    public GUIPrincipal() {
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

        pnlPrincipal = new javax.swing.JPanel();
        pnl0 = new javax.swing.JPanel();
        lblTituloLogin = new javax.swing.JLabel();
        pnl1 = new javax.swing.JPanel();
        lblIp = new javax.swing.JLabel();
        txtIp = new javax.swing.JTextField();
        pnl2 = new javax.swing.JPanel();
        lblPuerto = new javax.swing.JLabel();
        txtPuerto = new javax.swing.JTextField();
        pnl3 = new javax.swing.JPanel();
        btnRegistro = new javax.swing.JButton();
        pnl4 = new javax.swing.JPanel();
        lblMensajeErrorLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal.setLayout(new java.awt.GridLayout(5, 2));

        pnl0.setLayout(new java.awt.BorderLayout());

        lblTituloLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloLogin.setText("Configuración Cliente");
        pnl0.add(lblTituloLogin, java.awt.BorderLayout.CENTER);

        pnlPrincipal.add(pnl0);

        pnl1.setLayout(new java.awt.GridLayout(1, 2));

        lblIp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIp.setText("Ip");
        pnl1.add(lblIp);
        pnl1.add(txtIp);

        pnlPrincipal.add(pnl1);

        pnl2.setLayout(new java.awt.GridLayout(1, 2));

        lblPuerto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPuerto.setText("Puerto");
        pnl2.add(lblPuerto);
        pnl2.add(txtPuerto);

        pnlPrincipal.add(pnl2);

        pnl3.setLayout(new java.awt.BorderLayout());

        btnRegistro.setText("RegistrarC");
        pnl3.add(btnRegistro, java.awt.BorderLayout.CENTER);

        pnlPrincipal.add(pnl3);

        pnl4.setLayout(new java.awt.BorderLayout());

        lblMensajeErrorLogin.setText("-");
        pnl4.add(lblMensajeErrorLogin, java.awt.BorderLayout.CENTER);

        pnlPrincipal.add(pnl4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        </editor-fold>
//        </editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> {
//            new GUIPrincipal().setVisible(true);
//        });
//    }
    
    // GETTERS Y SETTERS GUI
    
    public JTextField getTxtIp() {
        return txtIp;
    }

    public void setTxtIp(JTextField txtIp) {
        this.txtIp = txtIp;
    }

    public JTextField getTxtPuerto() {
        return txtPuerto;
    }

    public void setTxtPuerto(JTextField txtPuerto) {
        this.txtPuerto = txtPuerto;
    }

    public JLabel getLblMensajeErrorLogin() {
        return lblMensajeErrorLogin;
    }

    public void setLblMensajeErrorLogin(JLabel lblMensajeErrorLogin) {
        this.lblMensajeErrorLogin = lblMensajeErrorLogin;
    }

    public JButton getBtnRegistro() {
        return btnRegistro;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistro;
    private javax.swing.JLabel lblIp;
    private javax.swing.JLabel lblMensajeErrorLogin;
    private javax.swing.JLabel lblPuerto;
    private javax.swing.JLabel lblTituloLogin;
    private javax.swing.JPanel pnl0;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnl3;
    private javax.swing.JPanel pnl4;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextField txtIp;
    private javax.swing.JTextField txtPuerto;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizar(AModel arg0) {
    }
}
