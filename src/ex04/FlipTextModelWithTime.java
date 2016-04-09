//==============================================================================
// HEIA-FR / Jacques Bapst
//==============================================================================
package ex04;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//------------------------------------------------------------------------------
// Model implementation
//
// Variant adding a time-stamp in front of the text returned by getNextText()
//------------------------------------------------------------------------------
public class FlipTextModelWithTime implements IFlipTextModel {
  
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
    
    return getTime() + textList.get(nextIndex++);
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
  
  //----------------------------------------------------------------------------
  private String getTime() {
    LocalTime now = LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String sTime = formatter.format(now);
    return "[" + sTime + "]  ";
  }
}