/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class FXMLmiseajourController {
     Connection conn=null;
        //
       @FXML
     private Label tentative;
       @FXML
     private AnchorPane anchorpane;
        @FXML
     private TextField sourcefichier;
    @FXML
     private Button ajouter;
    @FXML
     private JFXTextField auteur;
     @FXML
     private JFXTextField titre;
      @FXML
     private JFXTextArea tags;
       @FXML
     private JFXTextArea resume;
        @FXML
     private JFXTextArea commentaires;
     //
       //
   private fichier_favoris f;
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }   
    
    @FXML
     private void handleButtonAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException 
     {     
          if (event.getSource() == ajouter) 
        { 
            
        String pilot="oracle.jdbc.driver.OracleDriver";
          Class.forName(pilot);
          conn= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","ameni","AMENI");
           Statement cmd=conn.createStatement();
 String sql="UPDATE TAGS SET Auteur ='"+auteur.getText()+"',titre='"+titre.getText()+"',tags='"+tags.getText()+"',resume='"+resume.getText()+"',commentaire='"+commentaires.getText()+"',UTILISATEUR='"+tentative.getText()+"',fichier='"+sourcefichier.getText()+"'"+"where fichier='"+sourcefichier.getText()+"'";
           cmd.executeUpdate(sql);
            conn.close();
         }  
     }
      public void initData(fichier_favoris fav)
    {
        f=fav;
         sourcefichier.setDisable(true);
         sourcefichier.setText(f.getFichier());
        auteur.setText(f.getAuteur());
        commentaires.setText(f.getCommentaire());
        tags.setText(f.getTags());
        resume.setText(f.getResume());
        titre.setText(f.getTitre());
        
    } 
      public void usermiseajour ( String s)
      {
              tentative.setText(s);
      }    
}
