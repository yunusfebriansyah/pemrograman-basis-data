package com.templates;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import com.partials.cColor;
import com.partials.cFonts;

public class cStartFrame extends JFrame{

  public JPanel bg = new JPanel();
  public JPanel cardStart = new JPanel();
  public JLabel titleStart = new JLabel("Title Start");

  public cStartFrame()
  {
    super();
    setSize(1280, 720);
    setLocationRelativeTo(null);
    setLayout(null);
    setUndecorated(true);
    setDefaultCloseOperation(cStartFrame.EXIT_ON_CLOSE);

    bg.setBackground(cColor.BLUE);
    bg.setBounds(0, 0, 1280, 720);
    bg.setLayout(null);

    cardStart.setBackground(cColor.WHITE90);
    cardStart.setBounds(415, 90, 450, 540);
    cardStart.setLayout(null);

    titleStart.setFont(cFonts.TITLE_START_FONT);
    titleStart.setForeground(cColor.BLACK);
    titleStart.setBounds(0, 30, 450, 40);
    titleStart.setHorizontalAlignment(JLabel.CENTER);
    titleStart.setVerticalAlignment(JLabel.CENTER);


    cardStart.add(titleStart);
    bg.add(cardStart);
    add(bg);

  }

  public cStartFrame(String title)
  {
    this();
    setTitle(title);
  }
  
}
