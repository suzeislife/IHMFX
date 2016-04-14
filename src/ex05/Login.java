package ex05;
        
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Login extends Application {
        @Override
        public void start(Stage primaryStage) {
                try {
                        AnchorPane root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                        //BorderPane root = new BorderPane();
                        Scene scene = new Scene(root,400,400);
                        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                        primaryStage.setScene(scene);
                        primaryStage.show();
                } catch(Exception e) {
                        e.printStackTrace();
                }
        }
        
        public static void main(String[] args) {
                launch(args);
                
        }
}
