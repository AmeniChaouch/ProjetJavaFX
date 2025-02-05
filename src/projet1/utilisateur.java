/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author ASUS
 */
public class utilisateur {
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String mdp;

    public utilisateur() {
        this.nom = "";
        this.prenom = "";
        this.email = "";
        this.login = "";
        this.mdp ="";
    }
    
      
    public utilisateur(String nom, String prenom, String email, String login, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.mdp = mdp;
    }

    public utilisateur(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
    }
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    /* public GridPane se_connecter () throws FileNotFoundException
    {
           //
      GridPane grid = new GridPane();
grid.setAlignment(Pos.CENTER);
grid.setVgap(10);
grid.setHgap(20);
//defining label se connecter

                        Label label = new Label("Se connecter");
                        GridPane.setConstraints(label, 0, 0);
                         
                        grid.setHalignment(label, HPos.CENTER);
                        grid.getChildren().add(label);
                        
                        label.setId("fancytext");
                        //image login
                        FileInputStream inputstream1 = new FileInputStream("C:\\Users\\ASUS\\OneDrive\\Bureau\\proj\\src\\media\\20944201_1.jpg"); 
                        Image image1 = new Image(inputstream1); 
                         ImageView imageView1 = new ImageView(image1);
                         imageView1.setFitHeight(300); 
                         imageView1.setFitWidth(350); 
                        GridPane.setConstraints(imageView1, 0, 1);
                         grid.setHalignment(imageView1, HPos.CENTER);
                         grid.getChildren().add(imageView1 );
                         //
                    
  
 //
                       
//Defining the Name text field
                       final TextField name = new TextField();
                       name.setPromptText("Nom d'utilisateur.");
                       name.setPrefColumnCount(10);
                       GridPane.setConstraints(name, 0, 2);
                       name.setPrefWidth(260);
                       name.setMaxWidth(260);
                       grid.setHalignment(name, HPos.CENTER);
                       grid.getChildren().add(name);
//Defining the Last Name text field
                       final PasswordField mdp = new PasswordField();
                       mdp.setPromptText("Mot de passe");
                       mdp.setMaxWidth(260);
                       GridPane.setConstraints(mdp, 0, 3);
                       grid.setHalignment(mdp, HPos.CENTER);
                       grid.getChildren().add(mdp);
//
                       final Tooltip tooltip = new Tooltip();
                       tooltip.setText(
                           "Votre mot de passe \n" );
                       mdp.setTooltip(tooltip);
                       //
                       /* Label labelv = new Label("Creer un compte?");
                        GridPane.setConstraints(labelv, 0,4 );
                        grid.setHalignment(labelv, HPos.CENTER);
                        grid.getChildren().add(labelv);
                        labelv.setId("inscri");*/
                         
//Defining the Submit button
                     /*  Button btn = new Button("Suivant");
                       btn.setMaxWidth(260);
                       btn.setPrefWidth(260);
 btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 //if (name.getText()==)
                if (name.getText().trim().length()==0) 
                  name.setStyle("-fx-border-color: red ; -fx-border-width: 1px ;");
                  else if(mdp.getText().trim().length()==0)
                      mdp.setStyle("-fx-border-color: red ; -fx-border-width: 1px ;");
                  else{
                 name.setStyle("");
                 mdp.setStyle("");
                Connection con=null;
                try{
          String pilot="oracle.jdbc.driver.OracleDriver";
          Class.forName(pilot);
          con= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","ameni","AMENI");
          Statement cmd=con.createStatement();//ne peut que lire dans le sens croissant de la table nn parametre
          //
          ResultSet s=cmd.executeQuery("select * from UTILISATEUR ");
         while(s.next())
          {
              if (((s.getString("login")).equals(name.getText()))&&((s.getString("mdp")).equals(mdp.getText())))
              //interface file manager ici
                  System.out.print("aaa");
              else if (((s.getString("login")).equals(name.getText()))&&((!(s.getString("mdp")).equals(mdp.getText()))))
                  mdp.setStyle("-fx-border-color: red ; -fx-border-width: 1px ;");
          } 
         mdp.setStyle("");
          con.close();
      }
      catch (SQLException e){System.out.println("prob d'accés a la BD!!");}
      catch (ClassNotFoundException e){System.out.println("prob de pilote");}
                  }          
            }
        });   


                       GridPane.setConstraints(btn, 0, 5);
                       grid.setHalignment(btn, HPos.CENTER);
                grid.getChildren().add(btn);       
//  
                 Label ou = new Label("ou");
                        GridPane.setConstraints(ou, 0, 6);
                        grid.setHalignment(ou, HPos.CENTER);
                        grid.getChildren().add(ou);
               
                        
 //
                          FileInputStream inputstream2 = new FileInputStream("C:\\Users\\ASUS\\OneDrive\\Bureau\\proj\\src\\media\\google.png"); 
                        Image image2 = new Image(inputstream2); 
                         ImageView imageView2 = new ImageView(image2);
                         imageView2.setFitHeight(43); 
                         imageView2.setFitWidth(260); 
                        GridPane.setConstraints(imageView2, 0, 7);
                         grid.setHalignment(imageView2, HPos.CENTER);
                         grid.getChildren().add(imageView2 );
                         //
                          FileInputStream inputstream3 = new FileInputStream("C:\\Users\\ASUS\\OneDrive\\Bureau\\proj\\src\\media\\facebook.png"); 
                        Image image3 = new Image(inputstream3); 
                         ImageView imageView3 = new ImageView(image3);
                         imageView3.setFitHeight(43); 
                         imageView3.setFitWidth(260); 
                        GridPane.setConstraints(imageView3, 0, 8);
                         grid.setHalignment(imageView3, HPos.CENTER);
                         grid.getChildren().add(imageView3 );
 
//
return grid;
    }
      public GridPane inscrire() throws FileNotFoundException
    {
          GridPane grid = new GridPane();
grid.setAlignment(Pos.CENTER);
grid.setVgap(10);
grid.setHgap(20);
//defining label se connecter

                        Label label = new Label("S'inscrire");
                        GridPane.setConstraints(label, 0, 0);
                         
                        grid.setHalignment(label, HPos.CENTER);
                        grid.getChildren().add(label);
                        
                        label.setId("fancytext");
                        //image login
                      /*  FileInputStream inputstream1 = new FileInputStream("C:\\Users\\ASUS\\OneDrive\\Bureau\\proj\\src\\media\\sign up.jpg"); 
                        Image image1 = new Image(inputstream1); 
                         ImageView imageView1 = new ImageView(image1);
                         imageView1.setFitHeight(300); 
                         imageView1.setFitWidth(350); 
                        GridPane.setConstraints(imageView1, 0, 1);
                         grid.setHalignment(imageView1, HPos.CENTER);
                         grid.getChildren().add(imageView1 );
                         //*/
                    
  
 //
                       
//Defining the Name text field
                      /* final TextField name = new TextField();
                       name.setPromptText("Nom d'utilisateur.");
                       name.setPrefColumnCount(10);
                       GridPane.setConstraints(name, 0, 2);
                       name.setPrefWidth(260);
                       name.setMaxWidth(260);
                       grid.setHalignment(name, HPos.CENTER);
                       grid.getChildren().add(name);
//
                        final TextField lastname = new TextField();
                       lastname.setPromptText("Nom");
                       lastname.setPrefColumnCount(10);
                       GridPane.setConstraints(lastname, 0, 3);
                       name.setPrefWidth(260);
                       lastname.setMaxWidth(260);
                       grid.setHalignment(lastname, HPos.CENTER);
                       grid.getChildren().add(lastname);
//
                        final TextField email = new TextField();
                       email.setPromptText("Adresse Email");
                       email.setPrefColumnCount(10);
                       GridPane.setConstraints(email, 0, 4);
                       email.setPrefWidth(260);
                       email.setMaxWidth(260);
                       grid.setHalignment(email, HPos.CENTER);
                       grid.getChildren().add(email);
//
                        final TextField login = new TextField();
                       login.setPromptText("Nom d'utilisateur.");
                       login.setPrefColumnCount(10);
                       GridPane.setConstraints(login, 0, 5);
                       login.setPrefWidth(260);
                       login.setMaxWidth(260);
                       grid.setHalignment(login, HPos.CENTER);
                       grid.getChildren().add(login);
//Defining the Last Name text field
                       final PasswordField mdp = new PasswordField();
                       mdp.setPromptText("Mot de passe");
                       mdp.setMaxWidth(260);
                       GridPane.setConstraints(mdp, 0, 6);
                       grid.setHalignment(mdp, HPos.CENTER);
                       grid.getChildren().add(mdp);
//
                       final Tooltip tooltip = new Tooltip();
                       tooltip.setText(
                           "Votre mot de passe \n" );
                       mdp.setTooltip(tooltip);
                       //
                       /* Label labelv = new Label("Creer un compte?");
                        GridPane.setConstraints(labelv, 0,4 );
                        grid.setHalignment(labelv, HPos.CENTER);
                        grid.getChildren().add(labelv);
                        labelv.setId("inscri");*/
                         
//Defining the Submit button
                     /*  Button btn = new Button("Suivant");
                       btn.setMaxWidth(260);
                       btn.setPrefWidth(260);
 btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 //if (name.getText()==)
                if (name.getText().trim().length()==0) 
                  name.setStyle("-fx-border-color: red ; -fx-border-width: 1px ;");
                  else if(mdp.getText().trim().length()==0)
                      mdp.setStyle("-fx-border-color: red ; -fx-border-width: 1px ;");
                  else{
                 name.setStyle("");
                 mdp.setStyle("");
                Connection con=null;
                try{
          String pilot="oracle.jdbc.driver.OracleDriver";
          Class.forName(pilot);
          con= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","ameni","AMENI");
          Statement cmd=con.createStatement();//ne peut que lire dans le sens croissant de la table nn parametre
          //
          ResultSet s=cmd.executeQuery("select * from UTILISATEUR ");
         while(s.next())
          {
              if (((s.getString("login")).equals(name.getText()))&&((s.getString("mdp")).equals(mdp.getText())))
              //interface file manager ici
                  System.out.print("aaa");
              else if (((s.getString("login")).equals(name.getText()))&&((!(s.getString("mdp")).equals(mdp.getText()))))
                  mdp.setStyle("-fx-border-color: red ; -fx-border-width: 1px ;");
          } 
         mdp.setStyle("");
          con.close();
      }
      catch (SQLException e){System.out.println("prob d'accés a la BD!!");}
      catch (ClassNotFoundException e){System.out.println("prob de pilote");}
                  }          
            }
        });   


                       GridPane.setConstraints(btn, 0, 7);
                       grid.setHalignment(btn, HPos.CENTER);
                grid.getChildren().add(btn);       
//  
                 Label ou = new Label("ou");
                        GridPane.setConstraints(ou, 0, 8);
                        grid.setHalignment(ou, HPos.CENTER);
                        grid.getChildren().add(ou);
               
                        
 //
                          FileInputStream inputstream2 = new FileInputStream("C:\\Users\\ASUS\\OneDrive\\Bureau\\proj\\src\\media\\google.png"); 
                        Image image2 = new Image(inputstream2); 
                         ImageView imageView2 = new ImageView(image2);
                         imageView2.setFitHeight(43); 
                         imageView2.setFitWidth(260); 
                        GridPane.setConstraints(imageView2, 0, 9);
                         grid.setHalignment(imageView2, HPos.CENTER);
                         grid.getChildren().add(imageView2 );
                         //
                          FileInputStream inputstream3 = new FileInputStream("C:\\Users\\ASUS\\OneDrive\\Bureau\\proj\\src\\media\\facebook.png"); 
                        Image image3 = new Image(inputstream3); 
                         ImageView imageView3 = new ImageView(image3);
                         imageView3.setFitHeight(43); 
                         imageView3.setFitWidth(260); 
                        GridPane.setConstraints(imageView3, 0, 10);
                         grid.setHalignment(imageView3, HPos.CENTER);
                         grid.getChildren().add(imageView3 );
                         //
                          Label label1 = new Label("   En continuant, vous acceptez\n     les Conditions d'utilisation\n et la Politique de confidentialité.");
                        GridPane.setConstraints(label1, 0, 11);
                         
                        grid.setHalignment(label1, HPos.CENTER);
                        grid.getChildren().add(label1);
                        
 
return grid;
    }*/
     
}
