/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet1;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 *
 * @author ASUS
 */
public class FXMLinscriptionController implements Initializable {
    Connection con=null;
   @FXML
    private TextField name;
    @FXML
    private TextField nom ;
    @FXML
    private TextField login ;
    @FXML
    private TextField password ;
    @FXML
    private TextField email ;
    @FXML
    private Button continuer;
     @FXML
    private Label lblErrors ;
      @FXML
    private Label inscrire ;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
      if (event.getSource() == continuer) {
        if((name.getText().trim().length()==0) || (email.getText().trim().length()==0)|| (password.getText().trim().length()==0) ||(login.getText().trim().length()==0)||(nom.getText().trim().length()==0)) {  
            setLblError(Color.TOMATO, "Entrez vos données");
        } else {
                try{int trouv=0;
         Statement cmd=con.createStatement();
          //
          ResultSet s=cmd.executeQuery("select * from UTILISATEUR ");
         while((s.next())&&(trouv==0))
          {
              if (((s.getString("login")).equals(login.getText())))
              {setLblError(Color.TOMATO, "Nom d'utilisateur deja utilisé");trouv=1;}  
          } 
         if (trouv==0)
         {PreparedStatement stmt = null;
           Statement st = con.createStatement();
           
           String sql="INSERT INTO UTILISATEUR (NOM,PRENOM,EMAIL,LOGIN,MDP) "+
                   "VALUES ('"+name.getText()+"','"+nom.getText()+"','"+email.getText()+"','"+login.getText()+"','"+password.getText()+"')";
           //String sql="insert into tbl1(id,catagory) values('" + a + "','" + b + "')";
           st.executeUpdate(sql);
           setLblError(Color.GREEN, "utilisateur ajouté avec succés");
         }
          con.close();
                }
      catch (SQLException e){System.out.println("prob d'accés a la BD!!");}
        }}
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
    }   
      public FXMLinscriptionController() {
        bd_cnx con = new bd_cnx();
    }
     private void setLblError(Color color, String text) {
        lblErrors.setTextFill(color);
        lblErrors.setText(text);
       //System.out.println(text);
    }
}
