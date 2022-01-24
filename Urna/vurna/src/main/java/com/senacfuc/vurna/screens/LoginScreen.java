package com.senacfuc.vurna.screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class LoginScreen extends JFrame {
    private final DbManager dbmanager;

    public LoginScreen(DbManager dbmanager) {
        this.dbmanager = dbmanager;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputAccessCode = new JTextField();
        loginBtn = new JButton();
        jSeparator1 = new JSeparator();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        inputAccessCode.setToolTipText("");
        inputAccessCode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                inputAccessCodeActionPerformed(evt);
            }
        });

        loginBtn.setText("Entrar");
        loginBtn.setFocusPainted(false);
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Por favor, digite sua inscrição");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputAccessCode)
                    .addComponent(loginBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel1)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputAccessCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
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

    private void inputAccessCodeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_inputAccessCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputAccessCodeActionPerformed

    private void loginBtnActionPerformed(ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
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
        } catch (NumberFormatException | SQLException e) {
            inputAccessCode.setText("");
            JOptionPane.showMessageDialog(rootPane, Constants.INVALID_INPUT);
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextField inputAccessCode;
    private JLabel jLabel1;
    private JSeparator jSeparator1;
    private JButton loginBtn;
    // End of variables declaration//GEN-END:variables
}
