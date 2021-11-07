package com.templates;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import com.partials.cLinkKeluar;

import com.partials.cColor;
import com.partials.cFonts;


public abstract class cDashboardFrame extends JFrame{

  public JPanel sidebar = new JPanel();
  public JPanel header = new JPanel();
  public JPanel main = new JPanel();
  public JPanel content = new JPanel();

  private JLabel appText = new JLabel("PulsaKu");
  public JLabel roleText = new JLabel("Role | Nama User");
  public JLabel menuTitle = new JLabel("Menu Title");
  public JLabel copyrightText = new JLabel("Copyright 2021. Yunus Febriansyah.");

  private cLinkKeluar exitLink = new cLinkKeluar(930);

  public cDashboardFrame()
  {
    super();
    setSize(1280, 720);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setUndecorated(true);
    setLocationRelativeTo(null);
    setLayout(null);

    sidebar.setBackground(cColor.WHITE);
    sidebar.setBounds(0, 0, 230, 720);
    sidebar.setLayout(null);

    header.setBackground(cColor.BLUE);
    header.setBounds(230, 0, 1050, 70);
    header.setLayout(null);

    main.setBackground(cColor.WHITE_GRAY);
    main.setBounds(230, 70, 1050, 650);
    main.setLayout(null);

    content.setBackground(cColor.WHITE);
    content.setBounds(30, 70, 990, 520);
    content.setLayout(null);

    appText.setFont(cFonts.APP_FONT);
    appText.setBounds(0, 0, 230, 70);
    appText.setHorizontalAlignment(JLabel.CENTER);
    appText.setVerticalAlignment(JLabel.CENTER);
    appText.setForeground(cColor.BLUE);

    roleText.setFont(cFonts.ROLE_FONT);
    roleText.setBounds(30, 0, 400, 70);
    roleText.setVerticalAlignment(JLabel.CENTER);
    roleText.setForeground(cColor.WHITE);

    menuTitle.setFont(cFonts.MENU_TITLE_FONT);
    menuTitle.setBounds(30, 10, 600, 50);
    menuTitle.setVerticalAlignment(JLabel.CENTER);
    menuTitle.setForeground(cColor.BLACK_GRAY);

    copyrightText.setFont(cFonts.TEXTFIELD_FONT);
    copyrightText.setBounds(0, 610, 1050, 20);
    copyrightText.setHorizontalAlignment(JLabel.CENTER);
    copyrightText.setVerticalAlignment(JLabel.CENTER);
    copyrightText.setForeground(cColor.GRAY);
    
    header.add(exitLink);
    header.add(roleText);
    sidebar.add(appText);
    main.add(content);
    main.add(menuTitle);
    main.add(copyrightText);
    add(sidebar);
    add(header);
    add(main);
  }

  public cDashboardFrame(String title)
  {
    this();
    setTitle(title);
  }
  
}
