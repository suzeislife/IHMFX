package s02;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MineHunt extends Application {

	private static final String TITLE = "s02/resources/minehunt.png";
	
	private VBox root = new VBox(20);
	private ImageView title = new ImageView(TITLE);
	private HBox infoGame = new HBox(20);
	//Button Table List:
	
	private HBox gameButton = new HBox(20);
	private Button showMines = new Button("Show Mines");
	private Button newGame = new Button("New Game");
	
	@Override
	public void start(Stage mainStage) throws Exception {
		mainStage.setTitle("MineHunt V1.0");
		
		Scene scene = new Scene(root);
		//--- Title
		root.setAlignment(Pos.CENTER);
		root.getChildren().add(title);
		
		//--- Info Game
		root.getChildren().add(infoGame);
		
		//--- Button Table List:
		
		//--- Game Button
		root.getChildren().add(gameButton);
		//--- Add Buton Game
		gameButton.setAlignment(Pos.CENTER);
		gameButton.getChildren().addAll(showMines, newGame);
		
		
		mainStage.setScene(scene);
		mainStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
