package projet1;
import com.jfoenix.controls.JFXPasswordField;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 *
 * @author ASUS
 */
public class FXMLconnectionController implements Initializable {
Connection con = null;
    String utilisateur=null;
    
   @FXML
    private Label lblErrors ;
   
     @FXML
    private VBox vbox;
    @FXML
    private TextField name ;
    @FXML
    private JFXPasswordField mdp ;
    @FXML
    private Button se_connecter;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException {     
   if (event.getSource() == se_connecter) {
        if((name.getText().trim().length()==0) || (mdp.getText().trim().length()==0)) {  
            setLblError(Color.TOMATO, "Ecrivez votre nom et mot de passe");
        } else {
            String a=FXMLconnectiondata();
            if (a ==null)
                System.out.println("connection non effectuée");
            else if(a.equals("admin"))
            {
                   setLblError(Color.GREEN, "Connection effectuée");
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLdashboard.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
            }      
            else {
                 setLblError(Color.GREEN, "Connection effectuée");
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLdesktop.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);
        //
         FXMLdesktopController data =(FXMLdesktopController) loader.getController();
         data.utilisateur(a);
        //
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
            }      
        }    
   }
  
    
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (con == null) {
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Probleme base de donnees");
        } else {
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Base de données ouverte");
        }
        /*
         TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(vbox.getLayoutX() * 20);
        t.play();
        t.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("FXMLconnection.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }catch(IOException ex){
                
            }
        });*/
    }    
    
    
    
     private void passing_data (ActionEvent event) throws IOException, SQLException 

         {
         FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLajout.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);
        //
        FXMLconnectionController data=loader.getController();
      String s=  data.FXMLconnectiondata();
      System.out.print(s);
              
        //
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(tableViewScene);
        stage.show();
     }  
    
    
    
    public String FXMLconnectiondata() throws SQLException {
          java.sql.Statement cmd=con.createStatement();
          ResultSet s=cmd.executeQuery("select * from UTILISATEUR ");
         while(s.next())
          {
           if (((s.getString("login")).equals(name.getText()))&&((s.getString("mdp")).equals(mdp.getText())))
               utilisateur=s.getString("login");
          }
         return utilisateur;
    }
    public FXMLconnectionController() {
        con = bd_cnx.obtenirconn();
    }
   
    
    private void setLblError(Color color, String text) {
        lblErrors.setTextFill(color);
        lblErrors.setText(text);
    }
     @FXML
    private void open_signup(ActionEvent event){
          TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(0);
        t.play();
        t.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }catch(IOException ex){}
        });
     
     } 
}
