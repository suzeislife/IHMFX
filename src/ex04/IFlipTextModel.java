//==============================================================================
// HEIA-FR / Jacques Bapst
//==============================================================================
package ex04;

/**
 * FlipText Application Model
 * 
 * Allow to store texts in a circular list and to extract them sequentially.
 * 
 */

public interface IFlipTextModel {

  /**
   * Add a new text at the end of the list
   * 
   * @param text : text to be added
   */
  void addText(String text); 
  
  /**
   * Return the next text in the circular list
   * 
   * @return next text (with circular behavior)
   */
  String getNextText();
  
  /**
   * Reset the iterator to the first text in the list
   */
  void goToFirstText();
  
  /**
   * Clear (empty) the text list
   */
  void clear();
}