package s02;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MineHunt extends Application {

	private static final String TITLE = "s02/resources/minehunt.png";
	
	private int clickNumber;
	private int errorNumber;
	
	private VBox root = new VBox(20);
	private ImageView title = new ImageView(TITLE);
	private HBox infoGame = new HBox(20);
	private Label clickNb = new Label("Nb clicks:");
	private Label clickCount = new Label(""+clickNumber);
	private Label errorNb = new Label("Nb errors:");
	private Label errorCount = new Label(""+errorNumber);
	//Button Table List:
	private GridPane grille = new GridPane();
	
	private HBox gameButton = new HBox(10);
	private Button showMines = new Button("Show Mines");
	private Button newGame = new Button("New Game");
	
	@Override
	public void start(Stage mainStage) throws Exception {
		mainStage.setTitle("MineHunt V1.0");
		
		Scene scene = new Scene(root);
		//--- Title
		root.setAlignment(Pos.CENTER);
		root.getChildren().add(title);
		
		clickCount.setStyle("-fx-background-color: #33CC33");
		errorCount.setStyle("-fx-background-color: #FF3333");
		//--- Add Label Info Game:
		infoGame.getChildren().addAll(clickNb,clickCount,errorNb,errorCount);
		infoGame.setAlignment(Pos.CENTER);
		//--- Info Game
		root.getChildren().add(infoGame);
		
		//--- Button Table List:
		root.getChildren().add(grille);
		grille.setHgap(10);
		grille.setVgap(10);
		for(int i=0; i< 10; i++){
		  for(int j=0; j < 10; j++){
		    grille.add(new CellButton(i,j), i, j);
		    
		  }
		}
		//--- Add Buton Game
		gameButton.getChildren().add(showMines);
		gameButton.getChildren().add(newGame);
		gameButton.setAlignment(Pos.CENTER);
		//--- Game Button
		root.getChildren().add(gameButton);
		
		mainStage.setScene(scene);
		mainStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
