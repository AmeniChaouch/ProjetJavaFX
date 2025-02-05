
package projet1;

import com.jfoenix.controls.JFXButton;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLchoixaffichageController implements Initializable {
     @FXML
    private JFXButton fichier;
        @FXML
    private JFXButton ecran;
         @FXML
     private Label tentative;
          // 
      @FXML
        private void handleButtonAction(ActionEvent event) throws ClassNotFoundException, SQLException, IOException  {
           if (event.getSource() == ecran)
           { 
                FXMLLoader loader= new FXMLLoader();
                loader.setLocation(getClass().getResource("FXMLaffichage.fxml"));
                Parent tableViewParent = loader.load();
                Scene tableViewScene = new Scene(tableViewParent);
                 FXMLaffichageController data =(FXMLaffichageController) loader.getController();
         data.useraffichage(tentative.getText());
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.show();
           }
           if (event.getSource() == fichier)
           {
               PrintWriter Fsortie = new PrintWriter(new FileWriter("C:\\Users\\ASUS\\OneDrive\\Bureau\\Projet1\\fichiers\\affichagedesktop.txt"));
             int i=0;
         String pilot="oracle.jdbc.driver.OracleDriver";
          Class.forName(pilot);
          Connection con= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","ameni","AMENI");
          Statement cmd=con.createStatement();
          ResultSet s=cmd.executeQuery("select * from TAGS ");
         while(s.next())
          {   
              if((s.getString(6)).equals(tentative.getText()))
              { i++;
                  String col1=s.getString(1);
                  String col2=s.getString(2);
                  String col3=s.getString(3);
                  String col4=s.getString(4);
                  String col5=s.getString(5);
                  String col6=s.getString(7);
                  Fsortie.println("Fichier tag numero "+i+":");
                  Fsortie.println("auteur         :"+col1);
                  Fsortie.println("titre          :"+col2);
                  Fsortie.println("tags           :"+col3);
                  Fsortie.println("resume         :"+col4);
                  Fsortie.println("commentaire    :"+col5);
                  Fsortie.println("source         :"+col6);
              }
          }
               
               Fsortie.close();
               
           }
        }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
     public void utilisateur ( String s)
      {
           tentative.setText(s);
      }  
}
