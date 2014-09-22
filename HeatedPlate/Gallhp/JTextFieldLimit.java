package Gallhp;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument {
	
	  private int limit;
	  private String perStr = "0";
	  
	  JTextFieldLimit(int limit) {
	    this.limit = limit;
	  }
	  
	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		  if (!(isInteger(str))) {
			  return;
		  }
		  if(perStr == "0") {
			  perStr = str;
		  }
		  else if (!(perStr.equals("10")) && perStr.length() == 2) {
			  return;
		  }
		  else if (perStr.length() == 2 && !(str.equals("0"))) {
			  return;
		  }
		  else if (perStr.length() == 3) {
			  return;
		  }
		  else {
			  perStr = perStr.concat(str);
		  }
		  if (str == null || !(isInteger(str))) {
		      return;
		    }

		    if ((getLength() + str.length()) <= limit) {
		      super.insertString(offset, str, attr);
		    }
	  }
	  
	  public void remove(int offset, int len) throws BadLocationException {
		  super.remove(offset, len);
		  if(perStr.length() > 1) {
			  perStr = perStr.substring(0, perStr.length() - len);  
		  }
		  else {
			  perStr = "0";
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
