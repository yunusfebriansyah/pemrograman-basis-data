package com.partials;
import javax.swing.JLabel;

public class cLinkStart extends JLabel{
  
  public cLinkStart(String text, int y)
  {
    super();
    setText(text);
    setBounds(0, y, 450, 20);
    setHorizontalAlignment(JLabel.CENTER);
    setVerticalAlignment(JLabel.CENTER);
    setFont(cFonts.LINK_START_FONT);
    setForeground(cColor.BLUE);
    addMouseListener(new java.awt.event.MouseAdapter(){
      @Override
      public void mouseEntered(java.awt.event.MouseEvent e)
      {
        setCursor( new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      }
      public void mouseExited(java.awt.event.MouseEvent e)
      {
        setCursor( new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR) );
      }
    });

  }

}
