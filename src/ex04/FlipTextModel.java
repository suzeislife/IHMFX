//==============================================================================
// HEIA-FR / Jacques Bapst
//==============================================================================
package ex04;

import java.util.ArrayList;
import java.util.List;

//------------------------------------------------------------------------------
// Model implementation
//
// Variant with index management to get the successive elements of the list
//------------------------------------------------------------------------------
public class FlipTextModel implements IFlipTextModel {
  
  private static final String EMPTY = "Empty Text List";
  
  private List<String>  textList    = new ArrayList<>();
  private int           nextIndex   = 0;

  //----------------------------------------------------------------------------
  @Override
  public void addText(String text) {
    textList.add(text);
  }

  //----------------------------------------------------------------------------
  @Override
  public String getNextText() {
    int len = textList.size();
    if (len == 0) return EMPTY;
    if (nextIndex >= len) goToFirstText();   // Start a new cycle 
    
    return textList.get(nextIndex++);
  }

  //----------------------------------------------------------------------------
  @Override
  public void goToFirstText() {
    nextIndex = 0;
  }

  //----------------------------------------------------------------------------
  @Override
  public void clear() {
    textList.clear();
  }
}