package com.senacfuc.vurna.screens;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.senacfuc.vurna.data.CandidatoDao;
import com.senacfuc.vurna.data.CargoDao;
import com.senacfuc.vurna.data.EleitorDao;
import com.senacfuc.vurna.data.VotoDao;
import com.senacfuc.vurna.objs.Candidato;
import com.senacfuc.vurna.objs.Cargo;
import com.senacfuc.vurna.objs.Eleitor;
import com.senacfuc.vurna.objs.Voto;
import com.senacfuc.vurna.utils.Constants;
import com.senacfuc.vurna.utils.DbManager;

public class UrnaScreen extends JFrame {
    private String inscricao = ""; 
    private DbManager dbmanager;
    private Eleitor eleitor;
    private List<Cargo> cargos;
    private List<Voto> vote_queue;
    private Cargo current_cargo;
    private int cargo_counter = 0;

    public UrnaScreen(DbManager dbmanager, Eleitor eleitor) {
        this.dbmanager = dbmanager;
        this.eleitor = eleitor;
    }

    public void init() {
        initComponents();
        initVotacao();
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }

    private void initVotacao() {
        try {
            CargoDao cd = new CargoDao(dbmanager);
            cargos = cd.getAllCargos();
            current_cargo = cargos.get(cargo_counter);
            vote_queue = new ArrayList<>();

            lbPosition.setText(Constants.VOTE_TIP_1.replace("{cargo}", current_cargo.getNome()));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, Constants.DB_ERR);
        }
    }

    /**
     * Valida o voto, adiciona a uma fila de espera e pula para o proximo cargo.
     * 
     * @param candidato
     */
    private void validateAndEnqueueVote(Candidato candidato) {
        try {
            // Caso seja voto branco.
            if (candidato == null) {
                Voto voto = new Voto();
                voto.setInscricaoEleitor(eleitor.getInscricao());
                voto.setInscricaoCandidato(0);
                voto.setCodCargo(current_cargo.getCodCargo());
                vote_queue.add(voto);
                
                nextCargo();
                return;
            }

            EleitorDao ed = new EleitorDao(dbmanager);

            // Verifica se o usuario ja votou em algum candidato do cargo atual.
            if (ed.jaVotou(eleitor.getInscricao(), current_cargo.getCodCargo())) {
                JOptionPane.showMessageDialog(rootPane, Constants.VOTE_TIP_2.replace("{cargo}", current_cargo.getNome()));
                nextCargo();
            } else {
                // Adiciona o voto em uma fila de espera para ser processado no fim da votacao.
                Voto voto = new Voto();
                voto.setInscricaoEleitor(eleitor.getInscricao());
                voto.setInscricaoCandidato(candidato.getInscricao());
                voto.setCodCargo(current_cargo.getCodCargo());
                vote_queue.add(voto);

                nextCargo();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, Constants.DB_ERR);
        }
    }

    /**
     * Pula para o proximo cargo, ao chegar no ultimo cargo finaliza & processa a votacao.
     */
    private void nextCargo() {
        cargo_counter += 1;
        if (cargo_counter >= cargos.size()) {
            registerVotes();
        } else {
            current_cargo = cargos.get(cargo_counter);
            lbPosition.setText(Constants.VOTE_TIP_1.replace("{cargo}", current_cargo.getNome()));
            resetFields();
        }
    }

    /**
     * Verifica a fila de votos, os registra na database e finaliza a sessao.
     */
    private void registerVotes() {
        VotoDao vd = new VotoDao(dbmanager);
        for (Voto voto : vote_queue) {
            try {
                if (voto.getInscricaoCandidato() == 0) {
                    vd.registerVote(voto.getInscricaoEleitor(), voto.getCodCargo());
                } else {
                    vd.registerVote(voto.getInscricaoEleitor(), voto.getInscricaoCandidato());
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, Constants.DB_ERR);
            }
        }
        dispose();
    }

    /**
     * Reseta os campos de entrada.
     */
    private void resetFields() {
        inscricao = "";
        lbName.setText("");
        lbNumber.setText("");
    }

    /**
     * Atualiza os campos de textos baseado no input.
     */
    private void updateFields() {
        lbNumber.setText(inscricao);

        try {
            CandidatoDao cd = new CandidatoDao(dbmanager);
            int inscricao_number = Integer.parseInt(inscricao);
            if (cd.existe(inscricao_number)) {
                Candidato candidato = cd.getCandidato(inscricao_number);
                lbName.setText(candidato.getNome() + " - " + candidato.getCodPartido().toUpperCase());
            } else {
                lbName.setText("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new Color(51, 51, 51));
        setResizable(false);

        lbPhoto.setHorizontalAlignment(SwingConstants.CENTER);
        lbPhoto.setIcon(new ImageIcon(getClass().getResource("/com/senacfuc/vurna/screens/profile.png"))); // NOI18N
        lbPhoto.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        lbPhoto.setHorizontalTextPosition(SwingConstants.CENTER);

        jPanel1.setBackground(new Color(102, 102, 102));
        jPanel1.setForeground(new Color(255, 255, 255));

        btnOne.setBackground(new Color(51, 51, 51));
        btnOne.setFont(new Font("Segoe UI Black", 0, 12)); // NOI18N
        btnOne.setForeground(new Color(255, 255, 255));
        btnOne.setText("1");
        btnOne.setBorder(BorderFactory.createEtchedBorder());
        btnOne.setBorderPainted(false);
        btnOne.setFocusPainted(false);
        btnOne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnOneActionPerformed(evt);
            }
        });

        btnTwo.setBackground(new Color(51, 51, 51));
        btnTwo.setFont(new Font("Segoe UI Black", 0, 12)); // NOI18N
        btnTwo.setForeground(new Color(255, 255, 255));
        btnTwo.setText("2");
        btnTwo.setBorder(BorderFactory.createEtchedBorder());
        btnTwo.setBorderPainted(false);
        btnTwo.setFocusPainted(false);
        btnTwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTwoActionPerformed(evt);
            }
        });

        btnThree.setBackground(new Color(51, 51, 51));
        btnThree.setFont(new Font("Segoe UI Black", 0, 12)); // NOI18N
        btnThree.setForeground(new Color(255, 255, 255));
        btnThree.setText("3");
        btnThree.setBorder(BorderFactory.createEtchedBorder());
        btnThree.setBorderPainted(false);
        btnThree.setFocusPainted(false);
        btnThree.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnThreeActionPerformed(evt);
            }
        });

        btnFour.setBackground(new Color(51, 51, 51));
        btnFour.setFont(new Font("Segoe UI Black", 0, 12)); // NOI18N
        btnFour.setForeground(new Color(255, 255, 255));
        btnFour.setText("4");
        btnFour.setBorder(BorderFactory.createEtchedBorder());
        btnFour.setBorderPainted(false);
        btnFour.setFocusPainted(false);
        btnFour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnFourActionPerformed(evt);
            }
        });

        btnFive.setBackground(new Color(51, 51, 51));
        btnFive.setFont(new Font("Segoe UI Black", 0, 12)); // NOI18N
        btnFive.setForeground(new Color(255, 255, 255));
        btnFive.setText("5");
        btnFive.setBorder(BorderFactory.createEtchedBorder());
        btnFive.setBorderPainted(false);
        btnFive.setFocusPainted(false);
        btnFive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnFiveActionPerformed(evt);
            }
        });

        btnSix.setBackground(new Color(51, 51, 51));
        btnSix.setFont(new Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSix.setForeground(new Color(255, 255, 255));
        btnSix.setText("6");
        btnSix.setBorder(BorderFactory.createEtchedBorder());
        btnSix.setBorderPainted(false);
        btnSix.setFocusPainted(false);
        btnSix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSixActionPerformed(evt);
            }
        });

        btnSeven.setBackground(new Color(51, 51, 51));
        btnSeven.setFont(new Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSeven.setForeground(new Color(255, 255, 255));
        btnSeven.setText("7");
        btnSeven.setBorder(BorderFactory.createEtchedBorder());
        btnSeven.setBorderPainted(false);
        btnSeven.setFocusPainted(false);
        btnSeven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSevenActionPerformed(evt);
            }
        });

        btnEight.setBackground(new Color(51, 51, 51));
        btnEight.setFont(new Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEight.setForeground(new Color(255, 255, 255));
        btnEight.setText("8");
        btnEight.setBorder(BorderFactory.createEtchedBorder());
        btnEight.setBorderPainted(false);
        btnEight.setFocusPainted(false);
        btnEight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEightActionPerformed(evt);
            }
        });

        btnNine.setBackground(new Color(51, 51, 51));
        btnNine.setFont(new Font("Segoe UI Black", 0, 12)); // NOI18N
        btnNine.setForeground(new Color(255, 255, 255));
        btnNine.setText("9");
        btnNine.setBorder(BorderFactory.createEtchedBorder());
        btnNine.setBorderPainted(false);
        btnNine.setFocusPainted(false);
        btnNine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnNineActionPerformed(evt);
            }
        });

        btnZero.setBackground(new Color(51, 51, 51));
        btnZero.setFont(new Font("Segoe UI Black", 0, 12)); // NOI18N
        btnZero.setForeground(new Color(255, 255, 255));
        btnZero.setText("0");
        btnZero.setBorder(BorderFactory.createEtchedBorder());
        btnZero.setBorderPainted(false);
        btnZero.setFocusPainted(false);
        btnZero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnZeroActionPerformed(evt);
            }
        });

        btnWhite.setBackground(new Color(255, 255, 255));
        btnWhite.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        btnWhite.setForeground(new Color(51, 51, 51));
        btnWhite.setText("Branco");
        btnWhite.setFocusPainted(false);
        btnWhite.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnWhiteMouseClicked(evt);
            }
        });

        btnFix.setBackground(new Color(255, 102, 51));
        btnFix.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        btnFix.setForeground(new Color(0, 0, 0));
        btnFix.setText("Corrige");
        btnFix.setFocusPainted(false);
        btnFix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnFixActionPerformed(evt);
            }
        });

        btnConfirm.setBackground(new Color(0, 153, 51));
        btnConfirm.setFont(new Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnConfirm.setForeground(new Color(0, 0, 0));
        btnConfirm.setText("Confirma");
        btnConfirm.setFocusPainted(false);
        btnConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
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

        lbName.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        lbName.setHorizontalAlignment(SwingConstants.CENTER);

        lbNumber.setBackground(new Color(204, 204, 255));
        lbNumber.setFont(new Font("Franklin Gothic Medium Cond", 0, 14)); // NOI18N
        lbNumber.setHorizontalAlignment(SwingConstants.CENTER);
        lbNumber.setHorizontalTextPosition(SwingConstants.CENTER);

        lbPosition.setFont(new Font("Segoe UI Semibold", 1, 14)); // NOI18N
        lbPosition.setHorizontalAlignment(SwingConstants.CENTER);
        lbPosition.setText("Seu voto para {vaga}:");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lbPosition, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPhoto, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNumber, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
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
                        .addGap(54, 54, 54)
                        .addComponent(lbPosition)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbNumber, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPhoto, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbName, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFixActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnFixActionPerformed
       resetFields();
    }//GEN-LAST:event_btnFixActionPerformed

    private void btnConfirmMousePressed(MouseEvent evt) {// GEN-FIRST:event_btnConfirmMousePressed
        try {
            CandidatoDao cd = new CandidatoDao(dbmanager);
            int inscricao_number = Integer.parseInt(inscricao);

            if (cd.existe(inscricao_number)) {
                Candidato candidato = cd.getCandidato(inscricao_number);
                if (candidato.getCodCargo().equals(current_cargo.getCodCargo())) {
                    validateAndEnqueueVote(candidato);
                } else {
                    JOptionPane.showMessageDialog(rootPane, Constants.VOTE_ERR_1.replace("{cargo}", current_cargo.getNome()));            
                    resetFields();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, Constants.VOTE_ERR_2);
                resetFields();
            }
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, Constants.VOTE_ERR_3);
        }
    }// GEN-LAST:event_btnConfirmMousePressed

    private void btnWhiteMouseClicked(MouseEvent evt) {// GEN-FIRST:event_btnWhiteMouseClicked
        validateAndEnqueueVote(null);
    }// GEN-LAST:event_btnWhiteMouseClicked

    private void btnZeroActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btnZeroActionPerformed
        inscricao += "0";
        updateFields();
    }// GEN-LAST:event_btnZeroActionPerformed

    private void btnOneActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnOneActionPerformed
        inscricao += "1";
        updateFields();
    }//GEN-LAST:event_btnOneActionPerformed

    private void btnTwoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnTwoActionPerformed
        inscricao += "2";
        updateFields();
    }//GEN-LAST:event_btnTwoActionPerformed

    private void btnThreeActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btnThreeActionPerformed
        inscricao += "3";
        updateFields();

    }// GEN-LAST:event_btnThreeActionPerformed

    private void btnFourActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnFourActionPerformed
        inscricao += "4";
        updateFields();
    }//GEN-LAST:event_btnFourActionPerformed

     private void btnFiveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnFiveActionPerformed
        inscricao += "5";
        updateFields();
    }//GEN-LAST:event_btnFiveActionPerformed

    private void btnSixActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSixActionPerformed
        inscricao += "6";
        updateFields();

    }//GEN-LAST:event_btnSixActionPerformed

    private void btnSevenActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSevenActionPerformed
        inscricao += "7";
        updateFields();
    }//GEN-LAST:event_btnSevenActionPerformed

    private void btnEightActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnEightActionPerformed
        inscricao += "8";
        updateFields();
    }//GEN-LAST:event_btnEightActionPerformed

    private void btnNineActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnNineActionPerformed
        inscricao += "9";
        updateFields();
    }//GEN-LAST:event_btnNineActionPerformed

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
