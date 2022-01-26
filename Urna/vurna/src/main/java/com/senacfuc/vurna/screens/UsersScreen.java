package com.senacfuc.vurna.screens;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.senacfuc.vurna.data.EleitorDao;
import com.senacfuc.vurna.objs.Eleitor;
import com.senacfuc.vurna.utils.Constants;
import com.senacfuc.vurna.utils.DbManager;

public class UsersScreen extends javax.swing.JFrame {
    private final DbManager dbmanager;

    public UsersScreen(DbManager dbmanager) {
        this.dbmanager = dbmanager;
    }

    public void init() {
        initComponents();
        initList();

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }

    private void initList() {
         try {
            String[] cols = new String[] {  Constants.ELEITOR, Constants.INSCRICAO, Constants.VOTOU  };
            DefaultTableModel dtm = new DefaultTableModel(cols, 0);

            EleitorDao cd = new EleitorDao(dbmanager);

            // Popula a tabela
            List<Eleitor> eleitores = cd.getAllEleitores();
            for (Eleitor eleitor : eleitores) {
                Object[] data = new Object[] {
                        eleitor.getNome(),
                        eleitor.getInscricao(),
                        cd.jaVotou(eleitor.getInscricao()) ? "Sim" : "Não"
                };
                dtm.addRow(data);
            }

            usersTable.setModel(dtm);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        usersTable = new JTable();
        titleLb = new JLabel();
        jSeparator1 = new JSeparator();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VUrna - Eleitores");
        setResizable(false);

        jScrollPane1.setViewportView(usersTable);

        titleLb.setFont(new Font("Dialog", 1, 20)); // NOI18N
        titleLb.setText("Eleitores");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLb)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLb)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JLabel titleLb;
    private JTable usersTable;
    // End of variables declaration//GEN-END:variables

}
