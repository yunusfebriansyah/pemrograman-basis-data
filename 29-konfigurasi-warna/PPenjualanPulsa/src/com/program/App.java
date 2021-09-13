package com.program;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.partials.cColor;

public class App {

  public static void main(String[] args) {

    JFrame myFrame = new JFrame("Tes Warna");
    myFrame.setSize(600, 400);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel1 = new JPanel();
    panel1.setBounds(0, 0, 600, 400);
    panel1.setBackground(cColor.GREEN);
    panel1.setLayout(null);
    
    JPanel panel2 = new JPanel();
    panel2.setBounds(0, 0, 300, 200);
    panel2.setBackground(cColor.GRAY);
    panel2.setLayout(null);

    panel1.add(panel2);
    myFrame.add(panel1);
    myFrame.setVisible(true);

  }

}
