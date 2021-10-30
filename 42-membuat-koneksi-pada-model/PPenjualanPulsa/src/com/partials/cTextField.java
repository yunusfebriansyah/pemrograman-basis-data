package com.partials;
import javax.swing.JTextField;

public class cTextField extends JTextField{

  public cTextField(int x, int y, int width, boolean centerAlignment)
  {
    super();
    setBounds(x, y, width, 35);
    if(centerAlignment){
      setHorizontalAlignment(JTextField.CENTER);
    }
    setFont(cFonts.TEXTFIELD_FONT);
    setForeground(cColor.BLACK);
    setBorder(new javax.swing.border.LineBorder(cColor.BLUE, 1));

  }
  
}
