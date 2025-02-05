/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet1;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLdesktopController implements Initializable {

     @FXML
     private TextField motcle;
    @FXML
     private Button recherche;
    @FXML
     private AnchorPane anchorpane;
    @FXML
     private JFXButton ajout;
    @FXML
     private JFXButton modification;
     @FXML
     private JFXButton affichage;
    @FXML
     private Label tentative;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
    }  
    @FXML
     private void handleButtonAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException 
     {     
         if (event.getSource() == ajout) 
        { 
             FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLajout.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);   
        FXMLajoutController data =(FXMLajoutController) loader.getController();
         data.userajout(tentative.getText());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        }
         if (event.getSource() == modification) 
        { 
             FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLmodification.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);   
        FXMLmodificationController data =(FXMLmodificationController) loader.getController();
         data.useraffichage(tentative.getText());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        }
         if (event.getSource() == affichage) 
        { 
             FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLchoixaffichage.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);   
        FXMLchoixaffichageController data =(FXMLchoixaffichageController) loader.getController();
         data.utilisateur(tentative.getText());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        } 
          if (event.getSource() == recherche) 
        { 
           
             FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLrecherche.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);   
        FXMLrechercheController data =(FXMLrechercheController) loader.getController();
        data.utilisateur(tentative.getText());
        data.recherche(motcle.getText());
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        }
         
     }
       
      public void utilisateur ( String s)
      {
           tentative.setText(s);
      }  
}
