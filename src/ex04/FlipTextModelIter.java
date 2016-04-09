//==============================================================================
// HEIA-FR / Jacques Bapst
//==============================================================================
package ex04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//------------------------------------------------------------------------------
// Model implementation
//
// Variant using an iterator to get the successive elements of the list
//------------------------------------------------------------------------------
public class FlipTextModelIter implements IFlipTextModel {
  
  private static final String EMPTY = "Empty Text List";
  
  private List<String>     textList  = new ArrayList<>();
  private Iterator<String> iterator;

  //----------------------------------------------------------------------------
  @Override
  public void addText(String text) {
    textList.add(text);
  }

  //----------------------------------------------------------------------------
  @Override
  public String getNextText() {
    if (textList.size() == 0) return EMPTY;
    if (iterator==null || !iterator.hasNext()) {
      goToFirstText();               // Renew iterator => start new cycle
    }
    return iterator.next();
  }

  //----------------------------------------------------------------------------
  @Override
  public void goToFirstText() {
    iterator = textList.iterator();  // Renew iterator => start new cycle
  }

  //----------------------------------------------------------------------------
  @Override
  public void clear() {
    textList.clear();
  }
}