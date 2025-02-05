/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet1;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLaffichageController implements Initializable {
    ObservableList<fichier_favoris> files = FXCollections.observableArrayList();
    @FXML private TableView<fichier_favoris> tableView ;
      @FXML private TableColumn<fichier_favoris, String> auteur= new TableColumn<>("auteur");
     @FXML private TableColumn<fichier_favoris, String> titre= new TableColumn<>("titre");
    @FXML private TableColumn<fichier_favoris, String> tags= new TableColumn<>("tags");
     @FXML private TableColumn<fichier_favoris, String> resume= new TableColumn<>("resume");
    @FXML private TableColumn<fichier_favoris, String> commentaire= new TableColumn<>("commentaire");
     @FXML private TableColumn<fichier_favoris, String> source= new TableColumn<>("fichier");
     @FXML
     private Label tentative;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
         
        auteur.setCellValueFactory(new PropertyValueFactory<fichier_favoris, String>("auteur"));
        titre.setCellValueFactory(new PropertyValueFactory<fichier_favoris, String>("titre"));
        tags.setCellValueFactory(new PropertyValueFactory<fichier_favoris, String>("tags"));
        resume.setCellValueFactory(new PropertyValueFactory<fichier_favoris, String>("resume"));
        commentaire.setCellValueFactory(new PropertyValueFactory<fichier_favoris, String>("commentaire"));
        source.setCellValueFactory(new PropertyValueFactory<fichier_favoris, String>("fichier"));
        tableView.setItems(files);
    } 
      public void useraffichage ( String x)
      {       
        tentative.setText(x);
        try{
         String pilot="oracle.jdbc.driver.OracleDriver";
          Class.forName(pilot);
          Connection con= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","ameni","AMENI");
          Statement cmd=con.createStatement();
          ResultSet s=cmd.executeQuery("select * from TAGS ");
         while(s.next())
          {   
              if((s.getString(6)).equals(tentative.getText()))
              { System.out.print("equal");
                  String col1=s.getString(1);
                  String col2=s.getString(2);
                  String col3=s.getString(3);
                  String col4=s.getString(4);
                  String col5=s.getString(5);
                  String col6=s.getString(7);
                  files.add(new fichier_favoris(col1,col2,col3,col4,col5,col6));
              }
          }
          } catch (SQLException ex) {
            Logger.getLogger(FXMLaffichageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLaffichageController.class.getName()).log(Level.SEVERE, null, ex);
        }
      }    
}
