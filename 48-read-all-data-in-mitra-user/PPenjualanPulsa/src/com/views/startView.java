package com.views;
import com.templates.cStartFrame;
import com.partials.*;
import com.program.Controller;

public class startView extends cStartFrame {

  // components of Login Customer
  private cFormLabel labelNoHpLoginCustomer         = new cFormLabel("Nomor Hp", 0, 84, 450, true);
  private cTextField txtNoHpLoginCustomer           = new cTextField(65, 114, 320, true);
  private cErrorLabel errorNoHpLoginCustomer        = new cErrorLabel("no. hp kosong!!", 0, 149, 450, true);
  private cFormLabel labelPasswordLoginCustomer     = new cFormLabel("Password", 0, 183, 450, true);
  private cPasswordField txtPasswordLoginCustomer   = new cPasswordField(65, 213, 320, true);
  private cErrorLabel errorPasswordLoginCustomer    = new cErrorLabel("password kosong!!", 0, 248, 450, true);
  private cBlueButton btnLoginLoginCustomer         = new cBlueButton("Login", 65, 282, 320);
  private cLinkStart toLoginMitraLoginCustomer      = new cLinkStart("sudah punya akun mitra?", 322);
  private cLinkStart toDaftarMitraLoginCustomer     = new cLinkStart("daftar sebagai mitra", 342);
  private cLinkStart toDaftarCustomerLoginCustomer  = new cLinkStart("belum punya akun customer?", 362);
  private cLinkStart toLoginAdminLoginCustomer      = new cLinkStart("login admin", 382);

  // components of Register Customer
  private cFormLabel labelNamaDaftarCustomer        = new cFormLabel("Nama", 0, 84, 450, true);
  private cTextField txtNamaDaftarCustomer          = new cTextField(65, 114, 320, true);
  private cErrorLabel errorNamaDaftarCustomer       = new cErrorLabel("nama kosong!!", 0, 149, 450, true);
  private cFormLabel labelNoHpDaftarCustomer        = new cFormLabel("Nomor Hp", 0, 183, 450, true);
  private cTextField txtNoHpDaftarCustomer          = new cTextField(65, 213, 320, true);
  private cErrorLabel errorNoHpDaftarCustomer       = new cErrorLabel("no. hp kosong!!", 0, 248, 450, true);
  private cFormLabel labelPasswordDaftarCustomer    = new cFormLabel("Password", 0, 282, 450, true);
  private cPasswordField txtPasswordDaftarCustomer  = new cPasswordField(65, 312, 320, true);
  private cErrorLabel errorPasswordDaftarCustomer   = new cErrorLabel("password kosong!!", 0, 347, 450, true);
  private cBlueButton btnDaftarDaftarCustomer       = new cBlueButton("Daftar", 65, 381, 320);
  private cLinkStart toLoginMitraDaftarCustomer     = new cLinkStart("sudah punya akun mitra?", 421);
  private cLinkStart toDaftarMitraDaftarCustomer    = new cLinkStart("daftar sebagai mitra", 441);
  private cLinkStart toLoginCustomerDaftarCustomer  = new cLinkStart("sudah punya akun customer?", 461);
  private cLinkStart toLoginAdminDaftarCustomer     = new cLinkStart("login admin", 481);

  // components of Login Mitra
  private cFormLabel labelEmailLoginMitra         = new cFormLabel("Email", 0, 84, 450, true);
  private cTextField txtEmailLoginMitra           = new cTextField(65, 114, 320, true);
  private cErrorLabel errorEmailLoginMitra        = new cErrorLabel("email kosong!!", 0, 149, 450, true);
  private cFormLabel labelPasswordLoginMitra     = new cFormLabel("Password", 0, 183, 450, true);
  private cPasswordField txtPasswordLoginMitra   = new cPasswordField(65, 213, 320, true);
  private cErrorLabel errorPasswordLoginMitra    = new cErrorLabel("password kosong!!", 0, 248, 450, true);
  private cBlueButton btnLoginLoginMitra         = new cBlueButton("Login", 65, 282, 320);
  private cLinkStart toDaftarMitraLoginMitra      = new cLinkStart("belum punya akun mitra?", 322);
  private cLinkStart toDaftarCustomerLoginMitra     = new cLinkStart("daftar sebagai customer", 342);
  private cLinkStart toLoginCustomerLoginMitra  = new cLinkStart("belum punya akun customer?", 362);
  private cLinkStart toLoginAdminLoginMitra      = new cLinkStart("login admin", 382);

  // components of Register Mitra
  private cFormLabel labelNamaDaftarMitra        = new cFormLabel("Nama", 0, 84, 450, true);
  private cTextField txtNamaDaftarMitra          = new cTextField(65, 114, 320, true);
  private cErrorLabel errorNamaDaftarMitra       = new cErrorLabel("nama kosong!!", 0, 149, 450, true);
  private cFormLabel labelEmailDaftarMitra        = new cFormLabel("Email", 0, 183, 450, true);
  private cTextField txtEmailDaftarMitra          = new cTextField(65, 213, 320, true);
  private cErrorLabel errorEmailDaftarMitra       = new cErrorLabel("email kosong!!", 0, 248, 450, true);
  private cFormLabel labelPasswordDaftarMitra    = new cFormLabel("Password", 0, 282, 450, true);
  private cPasswordField txtPasswordDaftarMitra  = new cPasswordField(65, 312, 320, true);
  private cErrorLabel errorPasswordDaftarMitra   = new cErrorLabel("password kosong!!", 0, 347, 450, true);
  private cBlueButton btnDaftarDaftarMitra       = new cBlueButton("Daftar", 65, 381, 320);
  private cLinkStart toLoginMitraDaftarMitra     = new cLinkStart("sudah punya akun mitra?", 421);
  private cLinkStart toDaftarCustomerDaftarMitra    = new cLinkStart("daftar sebagai customer", 441);
  private cLinkStart toLoginCustomerDaftarMitra  = new cLinkStart("sudah punya akun customer?", 461);
  private cLinkStart toLoginAdminDaftarMitra     = new cLinkStart("login admin", 481);

    // components of Login Admin
    private cFormLabel labelUsernameLoginAdmin         = new cFormLabel("Username", 0, 84, 450, true);
    private cTextField txtUsernameLoginAdmin           = new cTextField(65, 114, 320, true);
    private cErrorLabel errorUsernameLoginAdmin        = new cErrorLabel("username kosong!!", 0, 149, 450, true);
    private cFormLabel labelPasswordLoginAdmin     = new cFormLabel("Password", 0, 183, 450, true);
    private cPasswordField txtPasswordLoginAdmin   = new cPasswordField(65, 213, 320, true);
    private cErrorLabel errorPasswordLoginAdmin    = new cErrorLabel("password kosong!!", 0, 248, 450, true);
    private cBlueButton btnLoginLoginAdmin         = new cBlueButton("Login", 65, 282, 320);
    private cLinkStart toDaftarMitraLoginAdmin      = new cLinkStart("belum punya akun mitra?", 322);
    private cLinkStart toLoginMitraLoginAdmin     = new cLinkStart("sudah punya akun mitra?", 342);
    private cLinkStart toDaftarCustomerLoginAdmin  = new cLinkStart("daftar sebagai customer", 362);
    private cLinkStart toLoginCustomerLoginAdmin      = new cLinkStart("sudah punya akun customer?", 382);


  public startView()
  {
    super();
    // implement for link frame loginCustomer
    toLoginMitraLoginCustomer.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showLoginMitra();
      }
    });
    toDaftarMitraLoginCustomer.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showDaftarMitra();
      }
    });
    toDaftarCustomerLoginCustomer.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showDaftarCustomer();
      }
    });
    toLoginAdminLoginCustomer.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showLoginAdmin();
      }
    });

    // implement for link frame daftarCustomer
    toLoginMitraDaftarCustomer.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showLoginMitra();
      }
    });
    toDaftarMitraDaftarCustomer.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showDaftarMitra();
      }
    });
    toLoginCustomerDaftarCustomer.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showLoginCustomer();
      }
    });
    toLoginAdminDaftarCustomer.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showLoginAdmin();
      }
    });

    // implement for link frame loginMitra
    toDaftarMitraLoginMitra.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showDaftarMitra();
      }
    });
    toDaftarCustomerLoginMitra.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showDaftarCustomer();
      }
    });
    toLoginCustomerLoginMitra.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showLoginCustomer();
      }
    });
    toLoginAdminLoginMitra.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showLoginAdmin();
      }
    });

    // implement for link frame daftarMitra
    toLoginMitraDaftarMitra.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showLoginMitra();
      }
    });
    toDaftarCustomerDaftarMitra.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showDaftarCustomer();
      }
    });
    toLoginCustomerDaftarMitra.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showLoginCustomer();
      }
    });
    toLoginAdminDaftarMitra.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showLoginAdmin();
      }
    });

    // implement for link frame loginAdmin
    toDaftarMitraLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showDaftarMitra();
      }
    });
    toLoginMitraLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showLoginMitra();
      }
    });
    toDaftarCustomerLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showDaftarCustomer();
      }
    });
    toLoginCustomerLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter()
    {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent me)
      {
        Controller.showLoginCustomer();
      }
    });

  }

  public void initsLoginCustomer()
  {
    this.setTitle("Login Customer");
    cardStart.removeAll();
    titleStart.setText("Login Customer");
    cardStart.add(titleStart);

    btnLoginLoginCustomer.addActionListener( new java.awt.event.ActionListener()
    {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        if( txtNoHpLoginCustomer.getText().equalsIgnoreCase("") || String.valueOf(txtPasswordLoginCustomer.getPassword()).equalsIgnoreCase("") ){
          Controller.showLoginCustomer();
          if( txtNoHpLoginCustomer.getText().equalsIgnoreCase("") ){
            cardStart.add(errorNoHpLoginCustomer);
          }
          if( String.valueOf(txtPasswordLoginCustomer.getPassword()).equalsIgnoreCase("") ){
            cardStart.add(errorPasswordLoginCustomer);
          }
        }
      }
    });

    cardStart.add(labelNoHpLoginCustomer);
    cardStart.add(txtNoHpLoginCustomer);
    cardStart.add(labelPasswordLoginCustomer);
    cardStart.add(txtPasswordLoginCustomer);
    cardStart.add(btnLoginLoginCustomer);
    cardStart.add(toLoginMitraLoginCustomer);
    cardStart.add(toDaftarMitraLoginCustomer);
    cardStart.add(toDaftarCustomerLoginCustomer);
    cardStart.add(toLoginAdminLoginCustomer);

  }

  public void initsDaftarCustomer()
  {
    this.setTitle("Daftar Customer");
    cardStart.removeAll();
    titleStart.setText("Daftar Customer");
    cardStart.add(titleStart);

    btnDaftarDaftarCustomer.addActionListener( new java.awt.event.ActionListener()
    {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        if( txtNamaDaftarCustomer.getText().equalsIgnoreCase("") || txtNoHpDaftarCustomer.getText().equalsIgnoreCase("") || String.valueOf(txtPasswordDaftarCustomer.getPassword()).equalsIgnoreCase("") ){

          Controller.showDaftarCustomer();
          if( txtNamaDaftarCustomer.getText().equalsIgnoreCase("") ){
            cardStart.add(errorNamaDaftarCustomer);
          }
          if( txtNoHpDaftarCustomer.getText().equalsIgnoreCase("") ){
            cardStart.add(errorNoHpDaftarCustomer);
          }
          if( String.valueOf(txtPasswordDaftarCustomer.getPassword()).equalsIgnoreCase("") ){
            cardStart.add(errorPasswordDaftarCustomer);
          }
        }
      }
    });

    cardStart.add(labelNamaDaftarCustomer);
    cardStart.add(txtNamaDaftarCustomer);
    cardStart.add(labelNoHpDaftarCustomer);
    cardStart.add(txtNoHpDaftarCustomer);
    cardStart.add(labelPasswordDaftarCustomer);
    cardStart.add(txtPasswordDaftarCustomer);
    cardStart.add(btnDaftarDaftarCustomer);
    cardStart.add(toLoginMitraDaftarCustomer);
    cardStart.add(toDaftarMitraDaftarCustomer);
    cardStart.add(toLoginCustomerDaftarCustomer);
    cardStart.add(toLoginAdminDaftarCustomer);


  }

  public void initsLoginMitra()
  {
    this.setTitle("Login Mitra");
    cardStart.removeAll();
    titleStart.setText("Login Mitra");
    cardStart.add(titleStart);

    btnLoginLoginMitra.addActionListener( new java.awt.event.ActionListener()
    {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        if( txtEmailLoginMitra.getText().equalsIgnoreCase("") || String.valueOf(txtPasswordLoginMitra.getPassword()).equalsIgnoreCase("") ){
          Controller.showLoginMitra();
          if( txtEmailLoginMitra.getText().equalsIgnoreCase("") ){
            cardStart.add(errorEmailLoginMitra);
          }
          if( String.valueOf(txtPasswordLoginMitra.getPassword()).equalsIgnoreCase("") ){
            cardStart.add(errorPasswordLoginMitra);
          }
        }
      }
    });

    cardStart.add(labelEmailLoginMitra);
    cardStart.add(txtEmailLoginMitra);
    cardStart.add(labelPasswordLoginMitra);
    cardStart.add(txtPasswordLoginMitra);
    cardStart.add(btnLoginLoginMitra);
    cardStart.add(toDaftarMitraLoginMitra);
    cardStart.add(toDaftarCustomerLoginMitra);
    cardStart.add(toLoginCustomerLoginMitra);
    cardStart.add(toLoginAdminLoginMitra);

  }

  public void initsDaftarMitra()
  {
    this.setTitle("Daftar Mitra");
    cardStart.removeAll();
    titleStart.setText("Daftar Mitra");
    cardStart.add(titleStart);

    btnDaftarDaftarMitra.addActionListener( new java.awt.event.ActionListener()
    {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        if( txtNamaDaftarMitra.getText().equalsIgnoreCase("") || txtEmailDaftarMitra.getText().equalsIgnoreCase("") || String.valueOf(txtPasswordDaftarMitra.getPassword()).equalsIgnoreCase("") ){

          Controller.showDaftarMitra();
          if( txtNamaDaftarMitra.getText().equalsIgnoreCase("") ){
            cardStart.add(errorNamaDaftarMitra);
          }
          if( txtEmailDaftarMitra.getText().equalsIgnoreCase("") ){
            cardStart.add(errorEmailDaftarMitra);
          }
          if( String.valueOf(txtPasswordDaftarMitra.getPassword()).equalsIgnoreCase("") ){
            cardStart.add(errorPasswordDaftarMitra);
          }
        }
      }
    });

    cardStart.add(labelNamaDaftarMitra);
    cardStart.add(txtNamaDaftarMitra);
    cardStart.add(labelEmailDaftarMitra);
    cardStart.add(txtEmailDaftarMitra);
    cardStart.add(labelPasswordDaftarMitra);
    cardStart.add(txtPasswordDaftarMitra);
    cardStart.add(btnDaftarDaftarMitra);
    cardStart.add(toLoginMitraDaftarMitra);
    cardStart.add(toDaftarCustomerDaftarMitra);
    cardStart.add(toLoginCustomerDaftarMitra);
    cardStart.add(toLoginAdminDaftarMitra);


  }

  public void initsLoginAdmin()
  {
    this.setTitle("Login Admin");
    cardStart.removeAll();
    titleStart.setText("Login Admin");
    cardStart.add(titleStart);

    btnLoginLoginAdmin.addActionListener( new java.awt.event.ActionListener()
    {
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        if( txtUsernameLoginAdmin.getText().equalsIgnoreCase("") || String.valueOf(txtPasswordLoginAdmin.getPassword()).equalsIgnoreCase("") ){
          Controller.showLoginAdmin();
          if( txtUsernameLoginAdmin.getText().equalsIgnoreCase("") ){
            cardStart.add(errorUsernameLoginAdmin);
          }
          if( String.valueOf(txtPasswordLoginAdmin.getPassword()).equalsIgnoreCase("") ){
            cardStart.add(errorPasswordLoginAdmin);
          }
        }
      }
    });

    cardStart.add(labelUsernameLoginAdmin);
    cardStart.add(txtUsernameLoginAdmin);
    cardStart.add(labelPasswordLoginAdmin);
    cardStart.add(txtPasswordLoginAdmin);
    cardStart.add(btnLoginLoginAdmin);
    cardStart.add(toDaftarMitraLoginAdmin);
    cardStart.add(toLoginMitraLoginAdmin);
    cardStart.add(toDaftarCustomerLoginAdmin);
    cardStart.add(toLoginCustomerLoginAdmin);

  }

  
}
