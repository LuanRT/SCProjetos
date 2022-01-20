package com.senacfuc.vurna.screens;

import javax.swing.JFrame;

import com.senacfuc.vurna.objs.Eleitor;
import com.senacfuc.vurna.utils.DbManager;

public class MainScreen extends JFrame {
    private final DbManager dbmanager;
    private final Eleitor eleitor;

    public MainScreen(DbManager dbmanager, Eleitor eleitor) {
        this.dbmanager = dbmanager;
        this.eleitor = eleitor;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVote = new javax.swing.JButton();
        titleLb = new javax.swing.JLabel();
        separator = new javax.swing.JSeparator();
        btnCargos = new javax.swing.JButton();
        welcomeText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eleiçao");
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        btnVote.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        btnVote.setText("Iniciar Votaçao");
        btnVote.setFocusPainted(false);
        btnVote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoteActionPerformed(evt);
            }
        });

        titleLb.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        titleLb.setText("Eleiçao");

        btnCargos.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        btnCargos.setText("Cargos");
        btnCargos.setFocusPainted(false);
        btnCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separator)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVote, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(btnCargos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLb)
                            .addComponent(welcomeText))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcomeText)
                .addGap(10, 10, 10)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVote, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoteActionPerformed
        UrnaScreen urna = new UrnaScreen(dbmanager);
        urna.init();
    }//GEN-LAST:event_btnVoteActionPerformed

    private void btnCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargosActionPerformed
        CargosScreen cargos = new CargosScreen(dbmanager, eleitor);
        cargos.init();
    }//GEN-LAST:event_btnCargosActionPerformed

    public void init() {
        initComponents();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                welcomeText.setText("Bem-vindo " + eleitor.getNome() + "!");
                setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargos;
    private javax.swing.JButton btnVote;
    private javax.swing.JSeparator separator;
    private javax.swing.JLabel titleLb;
    private javax.swing.JLabel welcomeText;
    // End of variables declaration//GEN-END:variables
}
