/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet1;
import java.sql.*;


/**
 *
 * @author ASUS
 */
public class bd_cnx {
     Connection conn=null;
     Statement s=null;
    public static Connection obtenirconn()
    {Connection con=null;
       try{
          String pilot="oracle.jdbc.driver.OracleDriver";
          Class.forName(pilot);
          con= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","ameni","AMENI");
          Statement cmd=con.createStatement();
          return con;
      }
      catch (SQLException e){System.out.println("prob d'accés a la BD!!");return null;}
      catch (ClassNotFoundException e){System.out.println("prob de pilote");return null;}
      
    }
    public  bd_cnx(){
    try{
          String pilot="oracle.jdbc.driver.OracleDriver";
          Class.forName(pilot);
          conn= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","ameni","AMENI");
           Statement cmd=conn.createStatement();
          conn.close();
      }
      catch (SQLException e){System.out.println("prob d'accés a la BD!!");}
      catch (ClassNotFoundException e){System.out.println("prob de pilote");}
}
}
