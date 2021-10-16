package com.partials;
import javax.swing.JLabel;

public class cBigFont extends JLabel{

  public cBigFont(String text, int x, int y)
  {
    super();
    setText(text);
    setBounds(x, y, 450, 70);
    setVerticalAlignment(JLabel.CENTER);
    setFont(cFonts.BIG_FONT);
    setForeground(cColor.RED);
  }
  
}
