package view;

import controller.ControllerComponentes;
import controller.ControllerHistoricoComponente;
import controller.ControllerProcessos;
import controller.ControllerUsuarioMaquina;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Mattos/ Raylane Fernandes
 */
public class TelaInit extends javax.swing.JFrame {

    ControllerHistoricoComponente controllerHistoricoComponente = new ControllerHistoricoComponente();
    ControllerProcessos controllerProcessos = new ControllerProcessos();
    ControllerComponentes controllerComponentes = new ControllerComponentes();

    /**
     * Creates new form TelaInit
     */
    public TelaInit() {
        initComponents();
        //Colocando cor no fundo da página;
        getContentPane().setBackground(Color.decode("#080425"));

        // Variaveis para adicionar "favicon" na barra superior da página;
        URL caminhoImagem = this.getClass().getClassLoader().getResource("tela-login-rxmonitoramento.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
        setIconImage(iconeTitulo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(8, 4, 37));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                userLogout(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seja bem vindo !");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 200, 160, 22);

        btnLogout.setBackground(new java.awt.Color(79, 80, 101));
        btnLogout.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Sair");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout);
        btnLogout.setBounds(140, 360, 120, 30);

        jLabel3.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Coletando informações do seu computador.");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 270, 290, 16);

        jLabel4.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Para encerrar, clique em sair.");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(100, 290, 200, 20);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tela-login-rxmonitoramento.png"))); // NOI18N
        jLabelLogo.setRequestFocusEnabled(false);
        getContentPane().add(jLabelLogo);
        jLabelLogo.setBounds(0, -20, 450, 480);

        setSize(new java.awt.Dimension(398, 468));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userLogout(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_userLogout
        ControllerUsuarioMaquina usuarioMaquina = new ControllerUsuarioMaquina();
        try {
            usuarioMaquina.insertUsuarioMaquinaLogout();
        } catch (UnknownHostException ex) {
            Logger.getLogger(TelaInit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_userLogout

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        ControllerUsuarioMaquina usuarioMaquina = new ControllerUsuarioMaquina();
        try {
            usuarioMaquina.insertUsuarioMaquinaLogout();
            dispose();
            System.exit(0);
        } catch (UnknownHostException ex) {
            Logger.getLogger(TelaInit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelLogo;
    // End of variables declaration//GEN-END:variables
}
