package com.cankerem.chatprog;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author can
 */
public class ServerProcess {
    ServerSocket server = null;
    Socket client = null;
    DataOutputStream dos = null;
    DataInputStream dis = null;
    
    private ResultSet rs;
    private ServerForm sf;
    private LoginForm lg;
    private RegistrationForm rf;
    
    DBprocesses process = new DBprocesses();
    
    public ServerProcess(ServerForm sf, LoginForm lg, RegistrationForm rf){
        this.sf = sf;
        this.lg = lg;
        this.rf = rf;
    }
    
    public void StartServer() throws Exception{
        try {
            server = new ServerSocket(1234);
            client = server.accept();
            JOptionPane.showMessageDialog(null, "İstemci isteği kabul etti");
            dos = new DataOutputStream(client.getOutputStream());
            dis = new DataInputStream(client.getInputStream());
            ReceiveMessage serverThread = new ReceiveMessage(dis, sf.txt_ServerArea);
            serverThread.setDaemon(true);
            serverThread.setName("İstemci");
            serverThread.start();
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "İstemci bulunamadı"+ex);
        } 
    }
    
    public void OnlineUsers() throws Exception{
        try {
            try (ResultSet resultset = process.ConnectDB().executeQuery("SELECT ad FROM users")) { 
                int colcount = resultset.getMetaData().getColumnCount();
                DefaultTableModel tm = new DefaultTableModel();
                for(int i = 1; i <= colcount; i++)
                    tm.addColumn(resultset.getMetaData().getColumnName(i));
                while(resultset.next())
                    {
                        Object[] row = new Object[colcount];
                        for(int i=1;i<=colcount;i++)
                            row[i-1] = resultset.getObject(i);
                        tm.addRow(row);
                    }
                sf.tbl_online.setModel(tm);
                process.CloseDBConnect();
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Hata !"+e);
        }
    }
    
    public void SendServerMessage(){
        String message = sf.txt_ServerSend.getText();
        try {
            dos.writeUTF(message);
            try{
                process.ConnectDB().executeUpdate("INSERT INTO serverSide VALUES ('"+sf.txt_ServerSend.getText()+"')");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Kaydedilmedi!"+e);
            }
            sf.txt_ServerSend.setText("");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Mesaj gönderilemedi"+ex);
        }
    }
    
    public void Login() throws Exception{

        try {
            String username = lg.txt_username.getText();
            String password = lg.txt_password.getText();
            rs = process.ConnectDB().executeQuery("select kadi,sifre from users ");
            
            while(rs.next()){
                if(username.equals(rs.getString("kadi")) && password.equals(rs.getString("sifre"))){
                    new ServerForm().setVisible(true);
                }                
            }
                JOptionPane.showMessageDialog(null, "Bir Sorun var");
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Bağlantı Hatası"+ex);
        }
    }
    
    public void Registration(){
        try {
            String name = rf.txt_name.getText();
            String surname = rf.txt_surname.getText();
            String username = rf.txt_username.getText();
            String password = rf.txt_password.getText();
            
            process.ConnectDB().executeUpdate("INSERT INTO users VALUES ('"+name+"', '"+surname+"', '"+username+"', '"+password+"')");

            JOptionPane.showMessageDialog(null, "Kayıt Eklendi!");
            
            process.CloseDBConnect();
            
            rf.txt_name.setText(null);
            rf.txt_surname.setText(null);
            rf.txt_username.setText(null);
            rf.txt_password.setText(null);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Bağlantı Hatası!"+ex);
        }
    }
}
