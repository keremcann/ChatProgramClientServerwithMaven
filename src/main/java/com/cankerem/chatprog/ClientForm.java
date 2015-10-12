package com.cankerem.chatprog;

/**
 *
 * @author can
 */
public class ClientForm extends javax.swing.JFrame {

    ClientProcess process = new ClientProcess(this);
    
    public ClientForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txt_ClientArea = new javax.swing.JTextArea();
        btn_Conncect = new javax.swing.JButton();
        txt_ClientSend = new javax.swing.JTextField();
        btn_ClientSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("İstemci");

        txt_ClientArea.setColumns(20);
        txt_ClientArea.setRows(5);
        jScrollPane1.setViewportView(txt_ClientArea);

        btn_Conncect.setText("Bağlan");
        btn_Conncect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConncectActionPerformed(evt);
            }
        });

        txt_ClientSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ClientSendActionPerformed(evt);
            }
        });

        btn_ClientSend.setText("Gönder");
        btn_ClientSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClientSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Conncect, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txt_ClientSend, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ClientSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Conncect, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(btn_ClientSend, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_ClientSend)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ConncectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConncectActionPerformed
        process.ConnectServer();
    }//GEN-LAST:event_btn_ConncectActionPerformed

    private void txt_ClientSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ClientSendActionPerformed
        process.SendClientMessage();
    }//GEN-LAST:event_txt_ClientSendActionPerformed

    private void btn_ClientSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClientSendActionPerformed
        process.SendClientMessage();
    }//GEN-LAST:event_btn_ClientSendActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ClientSend;
    private javax.swing.JButton btn_Conncect;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea txt_ClientArea;
    public javax.swing.JTextField txt_ClientSend;
    // End of variables declaration//GEN-END:variables
}
