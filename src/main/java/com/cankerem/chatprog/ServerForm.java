package com.cankerem.chatprog;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author can
 */
public class ServerForm extends javax.swing.JFrame {

    ServerProcess srvr = new ServerProcess(this, null, null);
    
    public ServerForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_online = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_ServerArea = new javax.swing.JTextArea();
        btn_ServerOnline = new javax.swing.JButton();
        txt_ServerSend = new javax.swing.JTextField();
        btn_ServerSend = new javax.swing.JButton();
        btn_StartServer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sunucu");

        tbl_online.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Çevirimiçi"
            }
        ));
        jScrollPane3.setViewportView(tbl_online);

        txt_ServerArea.setColumns(20);
        txt_ServerArea.setRows(5);
        jScrollPane1.setViewportView(txt_ServerArea);

        btn_ServerOnline.setText("Çevirimiçi");
        btn_ServerOnline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ServerOnlineActionPerformed(evt);
            }
        });

        txt_ServerSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ServerSendActionPerformed(evt);
            }
        });

        btn_ServerSend.setText("Gönder");
        btn_ServerSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ServerSendActionPerformed(evt);
            }
        });

        btn_StartServer.setText("Server Başlat");
        btn_StartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_StartServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btn_ServerOnline, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txt_ServerSend, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ServerSend, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_StartServer, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_ServerOnline)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ServerSend, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(btn_ServerSend, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btn_StartServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ServerOnlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ServerOnlineActionPerformed
        try {
            srvr.OnlineUsers();
        } catch (Exception ex) {
            Logger.getLogger(ServerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ServerOnlineActionPerformed

    private void txt_ServerSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ServerSendActionPerformed
        srvr.SendServerMessage();
    }//GEN-LAST:event_txt_ServerSendActionPerformed

    private void btn_ServerSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ServerSendActionPerformed
        srvr.SendServerMessage();
    }//GEN-LAST:event_btn_ServerSendActionPerformed

    private void btn_StartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_StartServerActionPerformed
        try {
            srvr.StartServer();
        } catch (Exception ex) {
            Logger.getLogger(ServerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_StartServerActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ServerOnline;
    private javax.swing.JButton btn_ServerSend;
    private javax.swing.JButton btn_StartServer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable tbl_online;
    public javax.swing.JTextArea txt_ServerArea;
    public javax.swing.JTextField txt_ServerSend;
    // End of variables declaration//GEN-END:variables
}
