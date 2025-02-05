/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet1;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLrechercheController implements Initializable {

     @FXML
    private TextField titre ;
      @FXML
    private Label user ;
    @FXML
    private TextArea source ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void recherche ( String str) throws ClassNotFoundException, SQLException
      {
         String pilot="oracle.jdbc.driver.OracleDriver";
          Class.forName(pilot);
          Connection  conn= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","ameni","AMENI");
           Statement cmd=conn.createStatement(); ResultSet s=cmd.executeQuery("select * from TAGS ");
            while(s.next())
          {
              if ((s.getString("utilisateur")).equals(user.getText()))
              {
                   if (str.equals(s.getString(1))||str.equals(s.getString(2))||(s.getString(3)).contains(str))
                   {
                      titre.setText(s.getString(2));
                      source.setText(s.getString(7));
                   }
              }
          }
      } 
       public void utilisateur ( String s)
      {
           user.setText(s);
      }  
}
