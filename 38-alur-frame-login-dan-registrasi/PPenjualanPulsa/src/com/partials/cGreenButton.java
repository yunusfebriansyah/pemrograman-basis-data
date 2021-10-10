package com.partials;

public class cGreenButton extends cBlueButton{

  public cGreenButton(String text, int x, int y, int width)
  {
    super(text, x, y, width);
    setFont(cFonts.BUTON_FONT);
    setBackground(cColor.GREEN);
    setForeground(cColor.WHITE);
    setBorder(null);
  }
  
}
