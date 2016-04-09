//==============================================================================
// HEIA-FR / Jacques Bapst
//==============================================================================
package ex04;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FlipTextView extends Application {
  
  private static final String TITLE = "/resources/FlipText_Title.png";
  private static final String ICON  = "/resources/Blue_Right_Arrow.png";
  
  private VBox       root    = new VBox(20);
  private ImageView  title   = new ImageView(TITLE);
  private Label      fText   = new Label("Click Button to Change");
  private ImageView  icon    = new ImageView(ICON);
  private Button     btnFlip = new Button("Next Text");
  
  private IFlipTextModel model;

  //----------------------------------------------------------------------------
  @Override
  public void init() throws Exception {
    super.init();
    //--- Create Application Model
//  model = new FlipTextModel();            // Variant using index management
//  model = new FlipTextModelIter();        // Variant using an iterator
    model = new FlipTextModelWithTime();    // Variant with time
    
    //--- Populate Model
    model.addText("A Kind of Magic     ");
    model.addText("News of the World   ");
    model.addText("A Night at the Opera");
    model.addText("Ghost of a Smile    ");
    model.addText("Made in Heaven      ");
  }
  
  @Override
  public void start(Stage mainStage) throws Exception {
    mainStage.setTitle("FlipText App v1.0");
    mainStage.setMinWidth(500);
    
    root.setPadding(new Insets(20));
    
    Border border = new Border(
        new BorderStroke(Color.DARKBLUE,
                         BorderStrokeStyle.SOLID,
                         new CornerRadii(20),
                         new BorderWidths(2),
                         new Insets(20)           ));
    root.setBorder(border);

    //--- Title
    root.setAlignment(Pos.CENTER);
    root.getChildren().add(title);
    
    //--- Icon and Text
    fText.setGraphic(icon);
    fText.setFont(Font.font("SansSerif", FontWeight.BOLD, 20));
    fText.setTextFill(Color.DARKRED);
    root.getChildren().add(fText);
    
    //--- Button
    root.getChildren().add(btnFlip);
    defineButtonController();

    Scene scene = new Scene(root);
    mainStage.setScene(scene);
    mainStage.show();
  }

  //----------------------------------------------------------------------------
  // Create and register button controller
  // Variant with embedded controller (for very simple controller)
  //----------------------------------------------------------------------------
  private void defineButtonController() {
    btnFlip.setOnAction(event -> {
      String nextText = model.getNextText();
      fText.setText(nextText);
    });
  }

  //----------------------------------------------------------------------------
  // Create and register button controller
  // Variant with external Controller (for more complex controller)
  //----------------------------------------------------------------------------
  private void defineButtonController2() {
    FlipTextController ftController = new FlipTextController(model, this);
    btnFlip.setOnAction(event -> {
      ftController.displayNextText();
    });
  }
  
  //----------------------------------------------------------------------------
  // Update View (for variant with external controller) 
  //----------------------------------------------------------------------------
  public void displayText(String nextText) {
    fText.setText(nextText);
  }
}