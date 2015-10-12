package com.cankerem.chatprog;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author can
 */
public class ClientProcess {
    Socket server = null;
    DataInputStream dis = null;
    DataOutputStream dos = null;
    
    private ClientForm cf;
    
    DBprocesses process = new DBprocesses();
    
    public ClientProcess(ClientForm cf){
        this.cf = cf;
    }
    
    public void ConnectServer() throws Exception{
        try {
            server = new Socket("127.0.0.1", 1234);
            JOptionPane.showMessageDialog(null, "Sunucuya bağlandı");
            dis = new DataInputStream(server.getInputStream());
            dos = new DataOutputStream(server.getOutputStream());
            ReceiveMessage clientThread = new ReceiveMessage(dis, cf.txt_ClientArea);
            clientThread.setDaemon(true);
            clientThread.setName("sunucu");
            clientThread.start();
            ResultSet result = process.ConnectDB().executeQuery("select mesaj from clientSide");
            cf.txt_ClientArea.setText(result.getString("mesaj"));
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Bağlantı başarısız"+ex);
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Hata !"+ex);
        }
    }
    public void SendClientMessage(){
        try {
            dos.writeUTF(cf.txt_ClientSend.getText());
            try{
                process.ConnectDB().executeUpdate("INSERT INTO clientSide VALUES ('"+cf.txt_ClientSend.getText()+"')");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Kaydedilmedi!"+e);
            }
            cf.txt_ClientSend.setText("");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Hata !"+ex);
        }
    }
}
