package com.partials;
import javax.swing.JTextArea;

public class cTextarea extends JTextArea {

  public cTextarea(boolean editable)
  {
    super();
    setFont(cFonts.TEXTFIELD_FONT);
    setBackground(cColor.WHITE);
    if( editable ){
      setForeground(cColor.BLACK);
    }else{
      setForeground(cColor.RED);
      setEditable(false);
    }
    setLineWrap(true);
    setWrapStyleWord(true);
  }
  
}
