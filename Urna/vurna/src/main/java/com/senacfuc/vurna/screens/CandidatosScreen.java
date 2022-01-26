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

import com.senacfuc.vurna.data.CandidatoDao;
import com.senacfuc.vurna.data.CargoDao;
import com.senacfuc.vurna.objs.Candidato;
import com.senacfuc.vurna.utils.Constants;
import com.senacfuc.vurna.utils.DbManager;


public class CandidatosScreen extends javax.swing.JFrame {
    private final DbManager dbmanager;
    private final String cod_cargo;

    public CandidatosScreen(DbManager dbmanager, String cod_cargo) {
        this.dbmanager = dbmanager;
        this.cod_cargo = cod_cargo;
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
            // Popula a tabela
            CandidatoDao cd = new CandidatoDao(dbmanager);

            String[] cols = null;
            List<Candidato> candidatos;

            // Se o cargo for null entao pega a lista completa
            if (cod_cargo == null) {
                cols = new String[]{Constants.CANDIDATO, Constants.INSCRICAO, Constants.PARTIDO, Constants.CARGO};
                candidatos = cd.getAllCandidatos();
            } else {
                cols = new String[]{Constants.CANDIDATO, Constants.INSCRICAO, Constants.PARTIDO};
                candidatos = cd.getAllCandidatos(cod_cargo);
            }

            DefaultTableModel dtm = new DefaultTableModel(cols, 0);

            for (Candidato candidato : candidatos) {
                Object[] data = new Object[]{
                    candidato.getNome(),
                    candidato.getInscricao(),
                    candidato.getCodPartido(),
                    new CargoDao(dbmanager).getCargo(candidato.getCodCargo()).getNome()
                };

                dtm.addRow(data);
            }

            candidatosTable.setModel(dtm);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLb = new JLabel();
        jSeparator1 = new JSeparator();
        jScrollPane1 = new JScrollPane();
        candidatosTable = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VUrna - Candidatos");
        setResizable(false);

        titleLb.setFont(new Font("Dialog", 1, 20)); // NOI18N
        titleLb.setText("Candidatos");

        jScrollPane1.setViewportView(candidatosTable);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLb)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLb)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTable candidatosTable;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JLabel titleLb;
    // End of variables declaration//GEN-END:variables
}
