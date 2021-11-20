package com.partials;
import javax.swing.JScrollPane;

public class cScrollPane extends JScrollPane {

  public cScrollPane(java.awt.Component view, int x, int y, int width, int height)
  {
    super(view);
    setBounds(x, y, width, height);
    getViewport().setBackground(cColor.WHITE);
    setBorder(new javax.swing.border.LineBorder(cColor.BLUE, 1));
  }
  
}
