/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet1;

import com.jfoenix.controls.JFXButton;
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
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLmodificationController implements Initializable {
  ObservableList<fichier_favoris> files = FXCollections.observableArrayList();
    @FXML private TableView<fichier_favoris> tableView ;
      @FXML private TableColumn<fichier_favoris, String> auteur= new TableColumn<>("auteur");
     @FXML private TableColumn<fichier_favoris, String> titre= new TableColumn<>("titre");
    @FXML private TableColumn<fichier_favoris, String> tags= new TableColumn<>("tags");
     @FXML private TableColumn<fichier_favoris, String> resume= new TableColumn<>("resume");
    @FXML private TableColumn<fichier_favoris, String> commentaire= new TableColumn<>("commentaire");
    @FXML private TableColumn<fichier_favoris, String> fichier= new TableColumn<>("fichier");
     @FXML private TableColumn<fichier_favoris, String> source= new TableColumn<>("source");
     //
     @FXML
     private Label tentative;
     @FXML
     private JFXButton modifier;
      @FXML
     private JFXButton supprimer;
     
        @FXML
     private void handleButtonAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException 
     {
          if (event.getSource() == modifier) 
        { 
             FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLmiseajour.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);   
        FXMLmiseajourController data =(FXMLmiseajourController) loader.getController();
        data.usermiseajour(tentative.getText());
        selectionfichier ();
        data.initData(getselectedfile());
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();   
        } 
          if (event.getSource() == supprimer) 
        { 
            String pilot="oracle.jdbc.driver.OracleDriver";
          Class.forName(pilot);
          Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","ameni","AMENI");
           Statement cmd=conn.createStatement();
           String sql="delete from TAGS where fichier='"+getselectedfile ( ).getFichier()+"'";
           cmd.executeUpdate(sql);
            conn.close();
        }
     }
     
    
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
              { 
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
      public void selectionfichier ( )
      {
          tableView.getSelectionModel().setCellSelectionEnabled(true);
          fichier_favoris f = tableView.getSelectionModel().getSelectedItem();
           if(f == null) 
           {
               System.out.print("selectinnez un fichier");
           }
        
      }
      public fichier_favoris getselectedfile ( )
      {
          tableView.getSelectionModel().setCellSelectionEnabled(true);
          fichier_favoris f = tableView.getSelectionModel().getSelectedItem();
          return f;
      }
}
