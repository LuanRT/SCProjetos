package com.senacfuc.vurna.screens;

import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.senacfuc.vurna.data.EleitorDao;
import com.senacfuc.vurna.objs.Eleitor;
import com.senacfuc.vurna.utils.Constants;
import com.senacfuc.vurna.utils.DbManager;

public class EleitorCreds extends JFrame {

    private final boolean is_logged_in = false;
    private final DbManager dbmanager;

    public EleitorCreds(DbManager dbmanager) {
        this.dbmanager = dbmanager;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputAccessCode = new JTextField();
        tipText = new JLabel();
        loginBtn = new JButton();
        jSeparator1 = new JSeparator();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        inputAccessCode.setToolTipText("codetitle");
        inputAccessCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputAccessCodeActionPerformed(evt);
            }
        });

        tipText.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        tipText.setText("Por favor, digite a sua inscrição:");

        loginBtn.setText("Entrar");
        loginBtn.setFocusPainted(false);
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(tipText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputAccessCode)
                    .addComponent(loginBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(119, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(tipText, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputAccessCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void init() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                initComponents();
                setVisible(true);
            }
        });
    }

    private void inputAccessCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputAccessCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputAccessCodeActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        try {
            int inscricao = Integer.parseInt(inputAccessCode.getText());
            EleitorDao ed = new EleitorDao(dbmanager);
            if (!ed.existe(inscricao)) {
                inputAccessCode.setText("");
                JOptionPane.showMessageDialog(rootPane, Constants.UNAUTHORIZED);
            } else {
                Eleitor eleitor = ed.getEleitor(inscricao);

                this.dispose();

                MainScreen ms = new MainScreen(dbmanager, eleitor);
                ms.init();
            }
        } catch (SQLException e) {
            inputAccessCode.setText("");
            JOptionPane.showMessageDialog(rootPane, Constants.INVALID_INPUT);
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextField inputAccessCode;
    private JSeparator jSeparator1;
    private JButton loginBtn;
    private JLabel tipText;
    // End of variables declaration//GEN-END:variables
}
