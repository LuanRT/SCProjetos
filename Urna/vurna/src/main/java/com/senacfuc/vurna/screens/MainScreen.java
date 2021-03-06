package com.senacfuc.vurna.screens;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.senacfuc.vurna.data.EleitorDao;
import com.senacfuc.vurna.objs.Eleitor;
import com.senacfuc.vurna.utils.Constants;
import com.senacfuc.vurna.utils.DbManager;

public class MainScreen extends JFrame {
    private final DbManager dbmanager;
    private final Eleitor eleitor;

    public MainScreen(DbManager dbmanager, Eleitor eleitor) {
        this.dbmanager = dbmanager;
        this.eleitor = eleitor;
    }

    public void init() {
        initComponents();

        welcomeText.setText(Constants.WELCOME.replace("{user}", eleitor.getNome()));
        btnCargos.setVisible(eleitor.getInscricao() == Integer.parseInt(Constants.ADMIN));
        btnUsers.setVisible(eleitor.getInscricao() == Integer.parseInt(Constants.ADMIN));
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVote = new JButton();
        titleLb = new JLabel();
        separator = new JSeparator();
        btnCargos = new JButton();
        welcomeText = new JLabel();
        btnUsers = new JButton();
        candidatosBtn = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eleiçao");
        setBackground(new Color(51, 51, 51));
        setResizable(false);

        btnVote.setFont(new Font("Franklin Gothic Book", 0, 14)); // NOI18N
        btnVote.setText("Votar");
        btnVote.setFocusPainted(false);
        btnVote.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnVoteActionPerformed(evt);
            }
        });

        titleLb.setFont(new Font("Dialog", 1, 20)); // NOI18N
        titleLb.setText("Eleiçao");

        btnCargos.setFont(new Font("Franklin Gothic Book", 0, 14)); // NOI18N
        btnCargos.setText("Cargos & Estatísticas");
        btnCargos.setFocusPainted(false);
        btnCargos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCargosActionPerformed(evt);
            }
        });

        btnUsers.setFont(new Font("Franklin Gothic Book", 0, 14)); // NOI18N
        btnUsers.setText("Eleitores");
        btnUsers.setFocusPainted(false);
        btnUsers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnUsersActionPerformed(evt);
            }
        });

        candidatosBtn.setFont(new Font("Franklin Gothic Book", 0, 14)); // NOI18N
        candidatosBtn.setText("Candidatos");
        candidatosBtn.setFocusPainted(false);
        candidatosBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                candidatosBtnActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(separator)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btnVote, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(btnCargos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUsers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(titleLb)
                            .addComponent(welcomeText))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(candidatosBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLb)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcomeText)
                .addGap(10, 10, 10)
                .addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVote, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(candidatosBtn, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsers, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCargos, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnVoteActionPerformed
        try {
            // Verifica se o candidato ja participou dessa votacao antes.
            EleitorDao ld = new EleitorDao(dbmanager);
            if (ld.jaVotou(eleitor.getInscricao())) {
                JOptionPane.showMessageDialog(rootPane, Constants.VOTE_TIP_3, Constants.INFO, JOptionPane.INFORMATION_MESSAGE);
            } else {
                UrnaScreen urna = new UrnaScreen(dbmanager, eleitor);
                urna.init();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, Constants.DB_ERR, Constants.ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVoteActionPerformed

    private void btnCargosActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCargosActionPerformed
        CargosScreen cargos = new CargosScreen(dbmanager);
        cargos.init();
    }//GEN-LAST:event_btnCargosActionPerformed

    private void btnUsersActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        UsersScreen us = new UsersScreen(dbmanager);
        us.init();
    }//GEN-LAST:event_btnUsersActionPerformed

    private void candidatosBtnActionPerformed(ActionEvent evt) {//GEN-FIRST:event_candidatosBtnActionPerformed
        CandidatosScreen cs = new CandidatosScreen(dbmanager, null);
        cs.init();
    }//GEN-LAST:event_candidatosBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnCargos;
    private JButton btnUsers;
    private JButton btnVote;
    private JButton candidatosBtn;
    private JSeparator separator;
    private JLabel titleLb;
    private JLabel welcomeText;
    // End of variables declaration//GEN-END:variables
}