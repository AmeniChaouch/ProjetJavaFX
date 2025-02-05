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
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLajoutController implements Initializable {
       @FXML
     private Label tentative;
       @FXML
     private AnchorPane anchorpane;
        @FXML
     private TextField sourcefichier;
    @FXML
     private JFXButton ajout;
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
        Connection conn=null;
        //
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sourcefichier.setDisable(true);
    }  
    
    @FXML
     private void handleButtonAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException 
     {     
         if (event.getSource() == ajout) 
        { 
             FileChooser fileChooser = new FileChooser();
             configureFileChooser(fileChooser);   
            Stage stage=(Stage)anchorpane.getScene().getWindow();
             File file=fileChooser.showOpenDialog(stage);
            if (file != null) {
              sourcefichier.setText(file.getPath());
            } else  {
                System.out.println("Veuillez choisir un fichier"); 
             }
         }
          if (event.getSource() == ajouter) 
        { 
            String pilot="oracle.jdbc.driver.OracleDriver";
          Class.forName(pilot);
          conn= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","ameni","AMENI");
           Statement cmd=conn.createStatement();
          
           String sql="INSERT INTO TAGS (AUTEUR,TITRE,TAGS,RESUME,COMMENTAIRE,UTILISATEUR,FICHIER) "+
                   "VALUES ('"+auteur.getText()+"','"+titre.getText()+"','"+tags.getText()+"','"+resume.getText()+"','"+commentaires.getText()+"','"+tentative.getText()+"','"+sourcefichier.getText()+"')";
           cmd.executeUpdate(sql);
            conn.close();
           
         }
         
          
     }
       
      
     private static void configureFileChooser(
        final FileChooser fileChooser) {      
            fileChooser.setTitle("Choisir un fichier");            
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Tous les fichiers", "*.*"),
                new FileChooser.ExtensionFilter(".pdf", "*.pdf"),
                new FileChooser.ExtensionFilter(".docx", "*.docx"),
                new FileChooser.ExtensionFilter(".pptx", "*.pptx")
            );
    }
      
      public void userajout ( String s)
      {
              tentative.setText(s);
      }    
    
}
