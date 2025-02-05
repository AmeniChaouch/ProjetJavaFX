
package projet1;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ASUS
 */
public class Projet1 extends Application {
     private double xOffset = 0;
    private double yOffset = 0;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLdesktop.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene); 
        stage.initStyle(StageStyle.UNDECORATED);
          /*root.setOnMousePressed((MouseEvent event) -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            // Move around here
            root.setOnMouseDragged((MouseEvent event) -> {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            });*/
      stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
