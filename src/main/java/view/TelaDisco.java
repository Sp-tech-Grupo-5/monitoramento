/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.Timer;
import java.util.TimerTask;
import services.ServiceDiscos;
import services.ServiceMemoria;


/**
 *
 * @author raylane
 */
public class TelaDisco extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaDisco() {
        initComponents();
        ServiceDiscos serviceDiscos= new ServiceDiscos();
        
        
        String tamanhoTotal = String.format("%.2f Gb", serviceDiscos.getTamanhoTotal());
        lblTotal.setText(tamanhoTotal);
           
    
        Timer timer = new Timer();
        Integer delay = 3000;
        Integer interval = 1000;

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                String emUso = String.format("%.2f Gb", serviceDiscos.getEmUso());
                String disponivel = String.format("%.2f Gb", serviceDiscos.getDisponivel());
                lblEmUso.setText(emUso);
                lblDisponivel.setText(disponivel);
            }
        }, delay, interval);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        lblDisco = new javax.swing.JLabel();
        lblUso = new javax.swing.JLabel();
        lblEmUso = new javax.swing.JLabel();
        lblDspnvl = new javax.swing.JLabel();
        lblDisponivel = new javax.swing.JLabel();
        lblTlt = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo-rx-monitoramento.png"))); // NOI18N

        lblDisco.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lblDisco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDisco.setText("DISCO");

        lblUso.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lblUso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUso.setText("Em Uso:");

        lblEmUso.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        lblEmUso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmUso.setText("...");

        lblDspnvl.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lblDspnvl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDspnvl.setText("Dispónivel:");

        lblDisponivel.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        lblDisponivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDisponivel.setText("...");

        lblTlt.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lblTlt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTlt.setText("Total:");

        lblTotal.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("...");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTlt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblUso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmUso, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDspnvl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblLogo)
                        .addGap(254, 254, 254))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lblLogo)
                .addGap(36, 36, 36)
                .addComponent(lblDisco)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDspnvl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDisponivel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmUso))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTlt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addGap(41, 41, 41))
        );

        setSize(new java.awt.Dimension(623, 493));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.setLocationRelativeTo(null);
        telaInicial.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDisco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDisco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDisco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDisco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDisco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel lblDisco;
    private javax.swing.JLabel lblDisponivel;
    private javax.swing.JLabel lblDspnvl;
    private javax.swing.JLabel lblEmUso;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTlt;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUso;
    // End of variables declaration//GEN-END:variables
}
