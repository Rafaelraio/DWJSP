/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SQLDB {
    Connection conn;

 public Connection getConnection(){
 try {
 Class.forName("com.mysql.cj.jdbc.Driver");
 conn =
DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","1234");
 } catch (ClassNotFoundException ex) {
    Logger.getLogger(SQLDB.class.getName()).log(Level.SEVERE, null, ex);
 } catch (SQLException ex) {
    Logger.getLogger(SQLDB.class.getName()).log(Level.SEVERE, null, ex);
 }
 return conn;
 }  
}
