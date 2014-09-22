package Gallhp;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument {
	
	  private int limit;
	  
	  JTextFieldLimit(int limit) {
	    this.limit = limit;
	  }
	  
	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		    if (str == null || !(isInteger(str))) {
		      return;
		    }

		    if ((getLength() + str.length()) <= limit) {
		      super.insertString(offset, str, attr);
		    }
	  }
	  
	  public static boolean isInteger(String s) {
		    try { 
		        Integer.parseInt(s); 
		    } catch(NumberFormatException e) { 
		        return false; 
		    }
		    // only got here if we didn't return false
		    return true;
		}
}
