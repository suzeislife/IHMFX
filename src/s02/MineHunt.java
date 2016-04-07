package s02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MineHunt extends Application{

  @Override
  public void start(Stage primaryStage) throws Exception {
    StackPane root = new StackPane();
    
    Scene scene = new Scene(root);
    
    primaryStage.setTitle("MineHunt V1.0");
    primaryStage.setScene(scene);
    primaryStage.show();
    
  }
  
  public static void main(String[] args) {
    //launch(args);
  }

}
