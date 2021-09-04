/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package New.connect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Laptopkhanhtran.vn
 */
public class MyConnection {
      String kindOfDb;
      String hostName;
      String dbName;
      String userName;
      String password;
      String jdbc;
      String port;
      String className;
      String connURL;
    private static MyConnection instance;
    private MyConnection(){
        try {
            InputStream inputStream=new FileInputStream("resources/db.properties");
            Properties prop=new Properties();
            prop.load(inputStream);
            kindOfDb=prop.getProperty("kindOfDb");
            if(kindOfDb.equals("mysql")){
            hostName=prop.getProperty("hostName");
            dbName=prop.getProperty("dbName");
            userName=prop.getProperty("userName");
            password=prop.getProperty("password");
            jdbc=prop.getProperty("jdbc");
            port=prop.getProperty("port");
            port=prop.getProperty("port");
            className=prop.getProperty("className");
            connURL=jdbc+hostName+port+dbName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static MyConnection getInstance(){
       if(instance==null){
               instance=new MyConnection();
       }
       return instance;
    }
    public Connection getConnection(){
        Connection conn=null;
        try {
             //khai báo driver->mysql
            Class.forName(className);
             conn= DriverManager.getConnection(connURL, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public boolean closeConnection(Connection conn){
        try {
            conn.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static void main(String[] args) {
        Connection conn=MyConnection.getInstance().getConnection();
        if(conn!=null){
            System.out.println("Kết nối thành công");
        }else{
            System.out.println("Kết nối thất bại");
        }
    }
}
   
