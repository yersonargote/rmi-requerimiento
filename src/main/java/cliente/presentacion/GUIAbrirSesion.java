/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.presentacion;

import cliente.Cliente;
import gestion_usuarios.dto.CredencialDTO;
import java.rmi.RemoteException;

/**
 *
 * @author yerso
 */
public class GUIAbrirSesion extends javax.swing.JFrame {

    /**
     * Creates new form GUIAbrirSesion
     */
    public GUIAbrirSesion() {
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
        lblUsuarioLogin = new javax.swing.JLabel();
        txtUsuarioLogin = new javax.swing.JTextField();
        pnl2 = new javax.swing.JPanel();
        lblClaveLogin = new javax.swing.JLabel();
        txtClaveLogin = new javax.swing.JTextField();
        pnl3 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        pnl4 = new javax.swing.JPanel();
        lblMensajeErrorLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 300));

        pnlPrincipal.setLayout(new java.awt.GridLayout(5, 2));

        pnl0.setLayout(new java.awt.BorderLayout());

        lblTituloLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloLogin.setText("Abrir Sesión");
        pnl0.add(lblTituloLogin, java.awt.BorderLayout.CENTER);

        pnlPrincipal.add(pnl0);

        pnl1.setLayout(new java.awt.GridLayout(1, 2));

        lblUsuarioLogin.setText("Usuario");
        pnl1.add(lblUsuarioLogin);
        pnl1.add(txtUsuarioLogin);

        pnlPrincipal.add(pnl1);

        pnl2.setLayout(new java.awt.GridLayout(1, 2));

        lblClaveLogin.setText("Clave");
        pnl2.add(lblClaveLogin);
        pnl2.add(txtClaveLogin);

        pnlPrincipal.add(pnl2);

        pnl3.setLayout(new java.awt.BorderLayout());

        btnLogin.setText("Iniciar Sesión");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnl3.add(btnLogin, java.awt.BorderLayout.CENTER);

        pnlPrincipal.add(pnl3);

        pnl4.setLayout(new java.awt.BorderLayout());

        lblMensajeErrorLogin.setText("-");
        pnl4.add(lblMensajeErrorLogin, java.awt.BorderLayout.CENTER);

        pnlPrincipal.add(pnl4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String usuario = this.txtUsuarioLogin.getText();
        String clave = this.txtClaveLogin.getText();
        int tipoUsuario = -1;
        boolean logeado = false;
        CredencialDTO credencial = new CredencialDTO(usuario, clave);
        try{
            tipoUsuario = this.cliente.getGestor().abrirSesion(credencial);
            logeado = (tipoUsuario >= 0 && tipoUsuario <= 3);
        }catch(RemoteException ex){}
        if (logeado) {
            // TODO: SWITCH para mostrar el menu de admin o secretaria o paf o paciente
        } else {
            this.lblMensajeErrorLogin.setText("Credenciales INCORRECTAS");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
//            java.util.logging.Logger.getLogger(GUIAbrirSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUIAbrirSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUIAbrirSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUIAbrirSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUIAbrirSesion().setVisible(true);
//            }
//        });
//    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    // Variables
    private Cliente cliente;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblClaveLogin;
    private javax.swing.JLabel lblMensajeErrorLogin;
    private javax.swing.JLabel lblTituloLogin;
    private javax.swing.JLabel lblUsuarioLogin;
    private javax.swing.JPanel pnl0;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnl3;
    private javax.swing.JPanel pnl4;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextField txtClaveLogin;
    private javax.swing.JTextField txtUsuarioLogin;
    // End of variables declaration//GEN-END:variables
}