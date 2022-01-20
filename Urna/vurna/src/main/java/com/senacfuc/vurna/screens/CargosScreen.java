package com.senacfuc.vurna.screens;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import com.senacfuc.vurna.data.CargoDao;
import com.senacfuc.vurna.objs.Cargo;
import com.senacfuc.vurna.utils.DbManager;

public class CargosScreen extends javax.swing.JFrame {
    private DbManager dbmanager;
    private List<Cargo> cargos;

    public CargosScreen(DbManager dbmanager) {
        this.dbmanager = dbmanager;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cargosLb = new JLabel();
        separator = new JSeparator();
        jScrollPane1 = new JScrollPane();
        cargosList = new JList<>();
        tipLb = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VUrna - Cargos");
        setResizable(false);

        cargosLb.setFont(new Font("Dialog", 1, 20)); // NOI18N
        cargosLb.setText("Cargos");

        cargosList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                cargosListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cargosList);

        tipLb.setFont(new Font("Dialog", 0, 14)); // NOI18N
        tipLb.setText("Para ver estatísticas de voto double-click em uma das opções abaixo:");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(separator)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cargosLb)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tipLb)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cargosLb)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(tipLb)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void init() {
        initComponents();
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });

        try {
            // Popula a lista:
            CargoDao gd = new CargoDao(dbmanager);
            DefaultListModel<String> dlm = new DefaultListModel<>();

            cargos = gd.getAllCargos();
            for (Cargo cargo : cargos) {
                dlm.addElement(cargo.getNome());
            }

            cargosList.setModel(dlm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void cargosListMouseClicked(MouseEvent evt) {//GEN-FIRST:event_cargosListMouseClicked
        JList list = (JList) evt.getSource();

        if (evt.getClickCount() == 2) {
            int row = list.locationToIndex(evt.getPoint());
            new InfoScreen(dbmanager, cargos.get(row).getCodCargo()).init();
        }
    }//GEN-LAST:event_cargosListMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel cargosLb;
    private JList<String> cargosList;
    private JScrollPane jScrollPane1;
    private JSeparator separator;
    private JLabel tipLb;
    // End of variables declaration//GEN-END:variables
}
