package com.partials;

public class cRedButton extends cBlueButton{

  public cRedButton(String text, int x, int y, int width)
  {
    super(text, x, y, width);
    setFont(cFonts.BUTON_FONT);
    setBackground(cColor.RED);
    setForeground(cColor.WHITE);
    setBorder(null);
  }
  
}
