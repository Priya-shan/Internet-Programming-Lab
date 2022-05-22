/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

import java.sql.*;

/**
 *
 * @author welcom
 */
public class ConnectionProvider {
     public static Connection getCon(){
      try{
          Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
          //Connection con=DriverManager.getConnection("jdbc:mysql://localhost:1527/project","priya","123456");
          Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/employee","root","root");
          return con;
      }
      catch(Exception e){
          return null;
      }
      }
}
