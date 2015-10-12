package com.cankerem.chatprog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author can
 */
public class DBprocesses {
   
    private Connection connect = null; //Bağlantı nesnemiz
    private String url = "jdbc:mysql://localhost:3306/";//veritabanının adresi ve portu
    private String dbName = "dbChatApp"; //veritabanının ismi
    private String properties= "?useUnicode=true&amp;characterEncoding=utf8"; //Türkçe karakter problemi yaşamamak için
    private String driver = "com.mysql.jdbc.Driver";//MySQL-Java bağlantısını sağlayan JDBC sürücüsü
    private String userName = "root"; //veritabanı için kullanıcı adı
    private String password = ""; //kullanıcı şifresi
    //private ResultSet rs; // sorgulardan dönecek kayıtlar (sonuç kümesi) bu nesne içerisinde tutulacak
        
    public DBprocesses(){

    }
    public Statement ConnectDB() throws Exception {
    Class.forName(driver).newInstance();
    connect = DriverManager.getConnection(url + dbName + properties, userName, password);//bağlantı açılıyor
    return connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
    //return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
 
    }
    
    public void CloseDBConnect() throws Exception {
    connect.close();
    }
}
