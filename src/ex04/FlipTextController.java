//==============================================================================
// HEIA-FR / Jacques Bapst
//==============================================================================
package ex04;

public class FlipTextController {
  
  private IFlipTextModel model;
  private FlipTextView   view;
  
  //----------------------------------------------------------------------------
  public FlipTextController(IFlipTextModel model,
                            FlipTextView   view  ) {
    this.model = model;
    this.view  = view;
  }
  
  //----------------------------------------------------------------------------
  // Get next text from model and update view
  //----------------------------------------------------------------------------
  public void displayNextText() {
    String nextText = model.getNextText();
    view.displayText(nextText);
  }
}