package s02;

import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;



import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MineHunt extends Application {

  private static final String TITLE      = "s02/resources/minehunt.png";

  private MineHuntModel       model;
  private MineHuntController  ctrl;

  private ImageView           mine;
  private ImageView           flag;

  private VBox                root       = new VBox(20);
  private ImageView           title      = new ImageView(TITLE);
  private HBox                infoGame   = new HBox(20);
  private Label               clickNb    = new Label("Nb clicks:");
  private Label               clickCount = new Label("");
  private Label               errorNb    = new Label("Nb errors:");
  private Label               errorCount = new Label("");
  // Button Table List:
  private GridPane            grid       = new GridPane();
  private CellButton[][]      mineGrid   = new CellButton[CONSTANTE.NBR_ROW][CONSTANTE.NBR_COL];

  private HBox                gameButton = new HBox(10);
  private Button              showMines  = new Button("Show Mines");
  private Button              newGame    = new Button("New Game");

  private BorderPane          window2    = new BorderPane();
  private TextInputDialog               dbox       = new TextInputDialog("");
  

  @Override
  public void init() throws Exception {
    super.init();

    // --- Title
    root.setAlignment(Pos.CENTER);
    root.getChildren().add(title);
    root.setStyle("-fx-background-color: #faf5c8");

    clickCount.setStyle("-fx-background-color: #33CC33");
    clickCount.setMinSize(60, 20);
    clickCount.setAlignment(Pos.CENTER);

    errorCount.setStyle("-fx-background-color: #FF3333");
    errorCount.setMinSize(60, 20);
    errorCount.setAlignment(Pos.CENTER);
    // --- Add Label Info Game:
    infoGame.getChildren().addAll(clickNb, clickCount, errorNb, errorCount);
    infoGame.setAlignment(Pos.CENTER);
    // --- Info Game
    root.getChildren().add(infoGame);

    // --- Button Table List:
    root.getChildren().add(grid);
    grid.setHgap(CONSTANTE.NBR_COL);
    grid.setVgap(CONSTANTE.NBR_ROW);
    grid.setAlignment(Pos.CENTER);

    // --- Add Buton Game
    gameButton.getChildren().add(showMines);

    gameButton.getChildren().add(newGame);
    gameButton.setAlignment(Pos.CENTER);
    // --- Game Button
    root.getChildren().add(gameButton);

  }

  @Override
  public void start(Stage mainStage) throws Exception {

    model = new MineHuntModel();
    ctrl = new MineHuntController(this, model);

    mainStage.setTitle("MineHunt V1.0");
    Scene scene = new Scene(root);
    // Bind Label info
    clickCount.textProperty().bind(model.getNbClick().asString());
    errorCount.textProperty().bind(model.getNbError().asString());
    // Add grid and event to CellButton
    for (int i = 0; i < CONSTANTE.NBR_COL; i++) {
      for (int j = 0; j < CONSTANTE.NBR_ROW; j++) {
        CellButton cellB = new CellButton(i, j);
        mineGrid[i][j] = cellB;
        cellB.setMinSize(40, 30);
        cellB.setOnMouseClicked(event -> {
          if (event.getButton() == MouseButton.SECONDARY)
            ctrl.boutonClicked(cellB, true);
          else
            ctrl.boutonClicked(cellB, false);
        });
        grid.add(cellB, i, j);
      }
    }
    showMines.setOnAction(event -> {
      ctrl.showMine(mineGrid);
    });
    
    newGame.setOnAction(event ->{
      dbox.setTitle("Game Setting");
      dbox.setHeaderText("Parametre Game:");

      GridPane gameGrid = new GridPane();
      gameGrid.setHgap(10);
      gameGrid.setVgap(10);
      
      Label numberRow = new Label("Number row: ");
      Label numbreCol = new Label("Number col: ");
      Label numberMine = new Label("Number mine: ");
      TextField textRow = new TextField();
      TextField textCol = new TextField();
      TextField textMine = new TextField();
      
      gameGrid.add(numberRow, 0, 0);
      gameGrid.add(numbreCol, 0, 1);
      gameGrid.add(numberMine, 0, 2);
      gameGrid.add(textRow, 1, 0);
      gameGrid.add(textCol, 1, 1);
      gameGrid.add(textMine, 1, 2);
      
      dbox.getDialogPane().setContent(gameGrid);
      
      dbox.showAndWait();
    });

    mainStage.setScene(scene);
    mainStage.show();

  }

  public static void main(String[] args) {
    launch(args);
  }

  public void setImageButton(CellButton cellB, int i, int nb) {
    // Error, mine
    if (i == 0) {
      mine = new ImageView(CONSTANTE.MINE);
      mine.setFitWidth(20);
      mine.setFitHeight(20);
      cellB.setStyle("-fx-background-color: #FF3333");
      cellB.setGraphic(mine);
    }
    // flag

    else if (i == 1) {
      flag = new ImageView(CONSTANTE.FLAG);
      flag.setFitWidth(20);
      flag.setFitHeight(20);
      cellB.setGraphic(flag);
    }
    // remove flag

    else if (i == 2) {
      cellB.setGraphic(null);
    }
    // blanc
    else if (i == 3) {
      cellB.setGraphic(null);
      cellB.setText("" + nb);
      cellB.setStyle("-fx-background-color: #fff27f");
    }
  }

  public void endGame(int errors) {
    Alert dialog = new Alert(AlertType.INFORMATION);
    dialog.setTitle("MineHunt - GameOver");
    dialog.setHeaderText("MineHunt");
    if (errors == 0) {
      dialog.setAlertType(AlertType.INFORMATION);
      dialog.setContentText(
          "Congratulation !\n" + "Current game endes successfully (no error)");
      dialog.showAndWait();
    } else {
      dialog.setAlertType(AlertType.WARNING);
      dialog.setContentText("Current game ended with " + errors + " errors");
      dialog.showAndWait();
    }
  }

}
