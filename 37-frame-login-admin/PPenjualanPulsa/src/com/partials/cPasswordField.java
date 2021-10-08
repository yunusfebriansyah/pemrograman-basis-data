package com.partials;
import javax.swing.JPasswordField;

public class cPasswordField extends JPasswordField{

  public cPasswordField(int x, int y, int width, boolean centerAlignment)
  {
    super();
    setBounds(x, y, width, 35);
    if(centerAlignment){
      setHorizontalAlignment(JPasswordField.CENTER);
    }
    setFont(cFonts.TEXTFIELD_FONT);
    setForeground(cColor.BLACK);
    setBorder(new javax.swing.border.LineBorder(cColor.BLUE, 1));

  }
  
}
