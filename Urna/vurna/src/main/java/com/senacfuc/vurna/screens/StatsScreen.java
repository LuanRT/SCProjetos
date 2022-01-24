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
import com.senacfuc.vurna.data.VotoDao;
import com.senacfuc.vurna.objs.Candidato;
import com.senacfuc.vurna.utils.Constants;
import com.senacfuc.vurna.utils.DbManager;

public class StatsScreen extends javax.swing.JFrame {
    private DbManager dbmanager;
    private String cargo;

    public StatsScreen(DbManager dbmanager, String cargo) {
        this.dbmanager = dbmanager;
        this.cargo = cargo;
    }

    public void init() {
        initComponents();
        initStatistics();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
    }

    private void initStatistics() {
        try {
            String[] cols = new String[] { Constants.CANDIDATO, Constants.INSCRICAO, Constants.VOTOS, Constants.PER };
            DefaultTableModel dtm = new DefaultTableModel(cols, 0);

            VotoDao vd = new VotoDao(dbmanager);
            CandidatoDao cd = new CandidatoDao(dbmanager);

            // Exibe o nome do cargo, contage de votos etc.
            cargoName.setText(new CargoDao(dbmanager).getCargo(cargo).getNome());
            voteCount.setText(vd.getTotalVotesCount(cargo) + "");
            whiteVotesCount.setText(vd.getWhiteVotesCount(cargo) + " (" + vd.getWhiteVotesCount(cargo) + "%" + ")");

            // Popula a tabela com as estatisticas.
            List<Candidato> candidatos = cd.getAllCandidatos(cargo);
            for (Candidato candidato : candidatos) {
                Object[] data = new Object[] {
                        candidato.getNome(),
                        candidato.getInscricao(),
                        vd.getVotesCount(candidato.getInscricao()),
                        vd.getVotePercentage(cargo, candidato.getInscricao()) + "%"
                };
                dtm.addRow(data);
            }

            infoTable.setModel(dtm);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cargoName = new JLabel();
        votesLb = new JLabel();
        voteCount = new JLabel();
        whiteVotesLb = new JLabel();
        whiteVotesCount = new JLabel();
        jScrollPane1 = new JScrollPane();
        infoTable = new JTable();
        separator = new JSeparator();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estatísticas");
        setResizable(false);

        cargoName.setFont(new Font("Dialog", 1, 18)); // NOI18N
        cargoName.setText("Cargo");

        votesLb.setText("Votos:");

        voteCount.setText("0");

        whiteVotesLb.setText("Votos Brancos:");

        whiteVotesCount.setText("0");

        jScrollPane1.setViewportView(infoTable);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(separator, GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(votesLb)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(voteCount))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(whiteVotesLb)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(whiteVotesCount)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cargoName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cargoName, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(votesLb)
                    .addComponent(voteCount))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(whiteVotesLb)
                    .addComponent(whiteVotesCount))
                .addGap(18, 18, 18)
                .addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel cargoName;
    private JTable infoTable;
    private JScrollPane jScrollPane1;
    private JSeparator separator;
    private JLabel voteCount;
    private JLabel votesLb;
    private JLabel whiteVotesCount;
    private JLabel whiteVotesLb;
    // End of variables declaration//GEN-END:variables
}
