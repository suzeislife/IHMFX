package ex05;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

  @FXML
  private TextField userName;
  
  @FXML
  private TextField password;
  
  @FXML
  private Button login;
  
  @FXML
  private Button cancel;
  
  @FXML
  private void initializer(){
    userName.setPrefColumnCount(6);
    
    login.disableProperty().bind(userName.textProperty().isEmpty());
  }
  
  @FXML
  private void handleLoginBtnAction(ActionEvent event){
      Alert dialog = new Alert(AlertType.INFORMATION);
      
      dialog.setTitle("Exiting the program");
      dialog.setHeaderText("Login successfull for: ");
      dialog.setContentText(userName.getText());
      dialog.showAndWait();
      
      System.out.println("Login for: "+ userName.getText());
  }
  
  @FXML
  private void handleCancelBtnAction(ActionEvent event){
    System.out.println("Exiting the program");
    
  }
  
}
