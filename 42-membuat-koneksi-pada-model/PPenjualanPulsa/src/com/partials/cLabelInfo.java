package com.partials;
import javax.swing.JLabel;

public class cLabelInfo extends JLabel{

  public cLabelInfo(String text, int x, int y)
  {
    super();
    setText(text);
    setBounds(x, y, 450, 40);
    setVerticalAlignment(JLabel.CENTER);
    setFont(cFonts.LABEL_INFO_FONT);
    setForeground(cColor.BLACK);
  }
  
}
