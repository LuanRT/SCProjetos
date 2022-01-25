package com.senacfuc.vurna.screens;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SplashScreen extends JFrame {
    private final int duration;

    public SplashScreen(int duration) {
        this.duration = duration;
    }

    public void init() {
        initComponents();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });

        try {
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }

        dispose();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLb = new javax.swing.JLabel();
        footerTextCredits = new javax.swing.JLabel();
        versionLb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VUrna Senac");
        setResizable(false);

        titleLb.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        titleLb.setText("VUrna");

        footerTextCredits.setFont(new java.awt.Font("Segoe UI Symbol", 0, 10)); // NOI18N
        footerTextCredits.setText("By SenacDevs - 2021 / 2022");

        versionLb.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        versionLb.setText("v1.0.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(footerTextCredits)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                        .addComponent(versionLb))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(titleLb)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(titleLb)
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(footerTextCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(versionLb))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel footerTextCredits;
    private javax.swing.JLabel titleLb;
    private javax.swing.JLabel versionLb;
    // End of variables declaration//GEN-END:variables
}
