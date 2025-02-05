package projet1;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
//
//
public class FXMLdashboardController implements Initializable {
    Connection conn;  
    ObservableList<utilisateur> utilisateurs = FXCollections.observableArrayList();
     ObservableList<String> tags = FXCollections.observableArrayList();
      ObservableList<String> tags_user = FXCollections.observableArrayList();
    //
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Button menu;
    @FXML
    private Button dashboard;
    @FXML
    private JFXButton user;
    //pane2 utilisateurs par tag recherché
     @FXML
    private JFXButton tag;
     @FXML private TextField tagrecherche;
       @FXML private TableView<String> utilisateur_recherche ;
      @FXML private TableColumn<String, String> utilisateur= new TableColumn<>("utilisateur");
      @FXML private TableColumn<String, String> titre= new TableColumn<>("titre");
        //
     @FXML
    private BarChart bar_chart;
     private CategoryAxis x = new CategoryAxis();
     private NumberAxis y = new NumberAxis();
     //
    @FXML private TableView<String > tag_user ;
     @FXML private TableColumn<String , String> mots_cle= new TableColumn<>("tags");
     //
   @FXML private TextField nom_user_tag;
    @FXML private TableView<String > tag_user1 ;
     @FXML private TableColumn<String , String> mots_cle1= new TableColumn<>("tags");
     //
          @FXML
    private PieChart pie_chart;
          //
           @FXML private TableView<utilisateur> tableView ;
      @FXML private TableColumn<utilisateur, String> login= new TableColumn<>("login");
      @FXML private TableColumn<utilisateur, String> email= new TableColumn<>("email");
     @FXML private TableColumn<utilisateur, String> nom= new TableColumn<>("nom");
       // 
     //
      @FXML
    private JFXButton affichage_user_recherche;
      @FXML
    private JFXButton affichage_users;
       @FXML
    private JFXButton affichage_tag_recherche;
        @FXML
    private JFXButton affichage_tags;
      
      //
      @FXML
        private void handleButtonAction(ActionEvent event) throws ClassNotFoundException, SQLException  {
            ArrayList<String> altag=new ArrayList<String>();
         if (event.getSource() == menu) 
            {
                 pane1.toFront();
            }
        if (event.getSource() == dashboard) 
            {
                pane2.toFront();
            }
         if (event.getSource() == user) 
            {
                Statement cmd=conn.createStatement();
                   ResultSet s=cmd.executeQuery("select * from tags  ");
             while(s.next())
             {
                   if ((s.getString("utilisateur")).equals(nom_user_tag.getText()))
                   {
                        String str= s.getString(3);
                        String[] arrOfStr = str.split(";");
                        for (String a : arrOfStr)
                        tags_user.add(a);
                   }
             }
               mots_cle1.setCellValueFactory(tags -> new SimpleStringProperty(tags.getValue()));
                tag_user1.setItems(tags_user);
            }
         //recherche d'utilisateurs par tag 
          if (event.getSource() == tag) 
            {
             utilisateur.setCellValueFactory(new PropertyValueFactory<String, String>("utilisateur"));
           titre.setCellValueFactory(new PropertyValueFactory<String, String>("nom"));
           ObservableList<String> user_tag = FXCollections.observableArrayList();
                Statement cmd=conn.createStatement();
                   ResultSet s=cmd.executeQuery("select * from tags  ");
             while(s.next())
             {
                 String str2= s.getString(3);
                        String[] arrOfStr = str2.split(";");
                        for (String a : arrOfStr)
                        altag.add(a);
                     for (int i=0;i<altag.size();i++)     
                     {
                         if ((altag.get(i)).equals(tagrecherche.getText()))
                         {
                            String x=altag.get(i);
                               //insertion dans le tableview de l'utilisateur
                              tags_user .add( s.getString(6));
                               utilisateur.setCellValueFactory(tags -> new SimpleStringProperty(tags.getValue()));
                               utilisateur_recherche.setItems(tags_user);
                         }
                     }
             }
              
            }
       }//fin handlebutton
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //tous les utilisateurs dans pane1
             login.setCellValueFactory(new PropertyValueFactory<utilisateur, String>("login"));
            nom.setCellValueFactory(new PropertyValueFactory<utilisateur, String>("nom"));
            email.setCellValueFactory(new PropertyValueFactory<utilisateur, String>("email"));
            try{
             String pilot="oracle.jdbc.driver.OracleDriver";
             Class.forName(pilot);
             conn= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","ameni","AMENI");
             Statement cmd=conn.createStatement();
             ResultSet s=cmd.executeQuery("select * from utilisateur  ");
             while(s.next())
             {
                  String col1=s.getString(1);
                  String col2=s.getString(2);
                  String col3=s.getString(3);
                  String col4=s.getString(4);
                  String col5=s.getString(5);
                  utilisateurs.add(new utilisateur(col1,col2,col3,col4,col5));   
             } 
                tableView.setItems  (utilisateurs);
        // tous les tags dans pane2
              ResultSet s2=cmd.executeQuery("select * from tags  ");
             while(s2.next())
             {
                String str= s2.getString(3);
                String[] arrOfStr = str.split(";");
                for (String a : arrOfStr)
                {
                    //System.out.println(a);
                      tags.add(a);
                }
             }
               mots_cle.setCellValueFactory(tags -> new SimpleStringProperty(tags.getValue()));
                tag_user.setItems(tags);
               
        //pie chart
                int n=0,i=0; ArrayList<String> al=new ArrayList<String>();int tab[]=new int [10];
                 ObservableList <PieChart.Data> piechart_donnee= FXCollections.observableArrayList(); 
                 ResultSet s3=cmd.executeQuery("select * from tags order by utilisateur  ");
                 while(s3.next())
                 {
                    al.add(s3.getString(6));
                    //piechart_donnee.add(new PieChart.Data(s3.getString(6),1));
                 }
                     pie_chart.setData(piechart_donnee);
                     //
                     //
             ArrayList<String> al2=null;
                 for (i=0;i<al.size()-1;i++)
                     {
                             if (!((al.get(i)).equals(al.get(i+1))))
                             {
                                  al2=new ArrayList<String>();
                                  for (int j=0;j<i;j++)
                                  al2.add(al.get(j));
                                  //System.out.println(al2.size());
                                 // piechart_donnee.add(new PieChart.Data(al2.get(0) , al2.size()));
                             }
                     }
               // if(!( al.get(al.size()).equals(al2.get(0)))) piechart_donnee.add(new PieChart.Data(al2.get(0),al2.size()));
                    
         //barchart 
                      BarChart<String,Number> bc =  new BarChart<String,Number>(x,y);
                     ResultSet s4=cmd.executeQuery("select * from tags  ");
                      XYChart.Series series1 = new XYChart.Series();
        series1.setName("nombre d'utilisateurs par tag");       
        series1.getData().add(new XYChart.Data("aaa", 12));
        series1.getData().add(new XYChart.Data("bbb", 15));
             while(s4.next())
             {
                String bdbarchart= s4.getString(3);
                String[] strbarchart = bdbarchart.split(";");
               /* for (String a : arrOfStr)
                {
                    System.out.println(a);
                      tags.add(a);
                }*/
             }
             bar_chart.getData().addAll(series1);
          } catch (SQLException ex) {
            Logger.getLogger(FXMLaffichageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLaffichageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
