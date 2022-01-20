package com.senacfuc.vurna.screens;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.senacfuc.vurna.objs.Eleitor;
import com.senacfuc.vurna.utils.DbManager;

public class UrnaScreen extends JFrame {
    private String vote_number = "";
    private final DbManager dbmanager;

    public UrnaScreen(DbManager dbmanager, Eleitor eleitor) {
        this.dbmanager = dbmanager;
    }

    public void init() {
        initComponents();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbPhoto = new JLabel();
        jPanel1 = new JPanel();
        btnOne = new JButton();
        btnTwo = new JButton();
        btnThree = new JButton();
        btnFour = new JButton();
        btnFive = new JButton();
        btnSix = new JButton();
        btnSeven = new JButton();
        btnEight = new JButton();
        btnNine = new JButton();
        btnZero = new JButton();
        btnWhite = new JButton();
        btnFix = new JButton();
        btnConfirm = new JButton();
        lbName = new JLabel();
        lbNumber = new JLabel();
        lbPosition = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        lbPhoto.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        btnOne.setBackground(new java.awt.Color(51, 51, 51));
        btnOne.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnOne.setForeground(new java.awt.Color(255, 255, 255));
        btnOne.setText("1");
        btnOne.setBorder(BorderFactory.createEtchedBorder());
        btnOne.setBorderPainted(false);
        btnOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOneActionPerformed(evt);
            }
        });

        btnTwo.setBackground(new java.awt.Color(51, 51, 51));
        btnTwo.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnTwo.setForeground(new java.awt.Color(255, 255, 255));
        btnTwo.setText("2");
        btnTwo.setBorder(BorderFactory.createEtchedBorder());
        btnTwo.setBorderPainted(false);
        btnTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTwoActionPerformed(evt);
            }
        });

        btnThree.setBackground(new java.awt.Color(51, 51, 51));
        btnThree.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnThree.setForeground(new java.awt.Color(255, 255, 255));
        btnThree.setText("3");
        btnThree.setBorder(BorderFactory.createEtchedBorder());
        btnThree.setBorderPainted(false);
        btnThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThreeActionPerformed(evt);
            }
        });

        btnFour.setBackground(new java.awt.Color(51, 51, 51));
        btnFour.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnFour.setForeground(new java.awt.Color(255, 255, 255));
        btnFour.setText("4");
        btnFour.setBorder(BorderFactory.createEtchedBorder());
        btnFour.setBorderPainted(false);
        btnFour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFourActionPerformed(evt);
            }
        });

        btnFive.setBackground(new java.awt.Color(51, 51, 51));
        btnFive.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnFive.setForeground(new java.awt.Color(255, 255, 255));
        btnFive.setText("5");
        btnFive.setBorder(BorderFactory.createEtchedBorder());
        btnFive.setBorderPainted(false);
        btnFive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiveActionPerformed(evt);
            }
        });

        btnSix.setBackground(new java.awt.Color(51, 51, 51));
        btnSix.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSix.setForeground(new java.awt.Color(255, 255, 255));
        btnSix.setText("6");
        btnSix.setBorder(BorderFactory.createEtchedBorder());
        btnSix.setBorderPainted(false);
        btnSix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSixActionPerformed(evt);
            }
        });

        btnSeven.setBackground(new java.awt.Color(51, 51, 51));
        btnSeven.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSeven.setForeground(new java.awt.Color(255, 255, 255));
        btnSeven.setText("7");
        btnSeven.setBorder(BorderFactory.createEtchedBorder());
        btnSeven.setBorderPainted(false);
        btnSeven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSevenActionPerformed(evt);
            }
        });

        btnEight.setBackground(new java.awt.Color(51, 51, 51));
        btnEight.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEight.setForeground(new java.awt.Color(255, 255, 255));
        btnEight.setText("8");
        btnEight.setBorder(BorderFactory.createEtchedBorder());
        btnEight.setBorderPainted(false);
        btnEight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEightActionPerformed(evt);
            }
        });

        btnNine.setBackground(new java.awt.Color(51, 51, 51));
        btnNine.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnNine.setForeground(new java.awt.Color(255, 255, 255));
        btnNine.setText("9");
        btnNine.setBorder(BorderFactory.createEtchedBorder());
        btnNine.setBorderPainted(false);
        btnNine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNineActionPerformed(evt);
            }
        });

        btnZero.setBackground(new java.awt.Color(51, 51, 51));
        btnZero.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnZero.setForeground(new java.awt.Color(255, 255, 255));
        btnZero.setText("0");
        btnZero.setBorder(BorderFactory.createEtchedBorder());
        btnZero.setBorderPainted(false);
        btnZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZeroActionPerformed(evt);
            }
        });

        btnWhite.setBackground(new java.awt.Color(255, 255, 255));
        btnWhite.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnWhite.setForeground(new java.awt.Color(51, 51, 51));
        btnWhite.setText("Branco");
        btnWhite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnWhiteMouseClicked(evt);
            }
        });

        btnFix.setBackground(new java.awt.Color(255, 102, 51));
        btnFix.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFix.setForeground(new java.awt.Color(0, 0, 0));
        btnFix.setText("Corrige");
        btnFix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFixActionPerformed(evt);
            }
        });

        btnConfirm.setBackground(new java.awt.Color(0, 153, 51));
        btnConfirm.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnConfirm.setForeground(new java.awt.Color(0, 0, 0));
        btnConfirm.setText("Confirma");
        btnConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnConfirmMousePressed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btnOne, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFour, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeven, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btnTwo, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFive, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEight, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnZero, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btnThree, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSix, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNine, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnWhite, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFix, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirm, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(btnOne, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTwo, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThree, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(btnFour, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFive, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSix, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(btnSeven, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEight, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNine, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnZero, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnWhite, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFix, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnConfirm, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        lbName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbNumber.setBackground(new java.awt.Color(204, 204, 255));
        lbNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbPosition.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbPosition.setText("Seu voto para {vaga}:");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(lbName, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lbPhoto, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(lbPosition))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(lbNumber, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lbPosition)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNumber, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPhoto, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbName, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFixActionPerformed
        lbName.setText("");
        lbName.setText("");
    }//GEN-LAST:event_btnFixActionPerformed

    //Adicionar o nome e foto quando selecionado
    private void btnOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOneActionPerformed
        vote_number = vote_number + "1";
    }//GEN-LAST:event_btnOneActionPerformed
    //Adicionar o nome e foto quando selecionado
    private void btnFourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFourActionPerformed
        vote_number = vote_number + "4";
    }//GEN-LAST:event_btnFourActionPerformed
    //Adicionar o nome e foto quando selecionado
    private void btnSevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSevenActionPerformed
        vote_number = vote_number + "7";

    }//GEN-LAST:event_btnSevenActionPerformed
    //Adicionar o nome e foto quando selecionado
    private void btnEightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEightActionPerformed
        vote_number = vote_number + "8";

    }//GEN-LAST:event_btnEightActionPerformed
    //Adicionar o nome e foto quando selecionado
    private void btnFiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiveActionPerformed
        vote_number = vote_number + "5";

    }//GEN-LAST:event_btnFiveActionPerformed
    //Adicionar o nome e foto quando selecionado
    private void btnTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTwoActionPerformed
        vote_number = vote_number + "2";

    }//GEN-LAST:event_btnTwoActionPerformed
    //Adicionar o nome e foto quando selecionado
    private void btnThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThreeActionPerformed
        vote_number = vote_number + "3";

    }//GEN-LAST:event_btnThreeActionPerformed
    //Adicionar o nome e foto quando selecionado
    private void btnSixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSixActionPerformed
        vote_number = vote_number + "6";

    }//GEN-LAST:event_btnSixActionPerformed
    //Adicionar o nome e foto quando selecionado
    private void btnNineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNineActionPerformed
        vote_number = vote_number + "9";

    }//GEN-LAST:event_btnNineActionPerformed

    private void btnConfirmMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmMousePressed
        JOptionPane.showMessageDialog(rootPane, "Seu voto foi para " + vote_number);
        this.dispose();
    }//GEN-LAST:event_btnConfirmMousePressed

    private void btnWhiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWhiteMouseClicked
        vote_number  = null;
    }//GEN-LAST:event_btnWhiteMouseClicked

    private void btnZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZeroActionPerformed
       vote_number += "0";
    }//GEN-LAST:event_btnZeroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnConfirm;
    private JButton btnEight;
    private JButton btnFive;
    private JButton btnFix;
    private JButton btnFour;
    private JButton btnNine;
    private JButton btnOne;
    private JButton btnSeven;
    private JButton btnSix;
    private JButton btnThree;
    private JButton btnTwo;
    private JButton btnWhite;
    private JButton btnZero;
    private JPanel jPanel1;
    private JLabel lbName;
    private JLabel lbNumber;
    private JLabel lbPhoto;
    private JLabel lbPosition;
    // End of variables declaration//GEN-END:variables
}
