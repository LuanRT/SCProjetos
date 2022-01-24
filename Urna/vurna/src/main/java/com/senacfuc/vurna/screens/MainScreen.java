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

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eleiçao");
        setBackground(new Color(51, 51, 51));
        setResizable(false);

        btnVote.setFont(new Font("Franklin Gothic Book", 0, 14)); // NOI18N
        btnVote.setText("Iniciar Votação ");
        btnVote.setFocusPainted(false);
        btnVote.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnVoteActionPerformed(evt);
            }
        });

        titleLb.setFont(new Font("Dialog", 1, 20)); // NOI18N
        titleLb.setText("Eleição");

        btnCargos.setFont(new Font("Franklin Gothic Book", 0, 14)); // NOI18N
        btnCargos.setText("Cargos");
        btnCargos.setFocusPainted(false);
        btnCargos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCargosActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(titleLb)
                            .addComponent(welcomeText))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCargos, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnVoteActionPerformed
        try {
            // Verifica se o candidato ja participou dessa votacao antes.
            EleitorDao ld = new EleitorDao(dbmanager);
            if (ld.jaVotou(eleitor.getInscricao())) {
                JOptionPane.showMessageDialog(rootPane, Constants.VOTE_TIP_3);
            } else {
                UrnaScreen urna = new UrnaScreen(dbmanager, eleitor);
                urna.init();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, Constants.DB_ERR);
        }
    }//GEN-LAST:event_btnVoteActionPerformed

    private void btnCargosActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCargosActionPerformed
        CargosScreen cargos = new CargosScreen(dbmanager);
        cargos.init();
    }//GEN-LAST:event_btnCargosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnCargos;
    private JButton btnVote;
    private JSeparator separator;
    private JLabel titleLb;
    private JLabel welcomeText;
    // End of variables declaration//GEN-END:variables
}
