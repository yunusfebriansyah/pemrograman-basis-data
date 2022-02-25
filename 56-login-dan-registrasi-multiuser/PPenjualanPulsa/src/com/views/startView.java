package com.views;
import com.templates.cStartFrame;

import javax.swing.JOptionPane;

import com.partials.*;
import com.program.Controller;
import com.program.Model;

public class startView extends cStartFrame {

  // components of Login Customer
  private cFormLabel labelNoHpLoginCustomer         = new cFormLabel("Nomor Hp", 0, 84, 450, true);
  private cTextField txtNoHpLoginCustomer           = new cTextField(65, 114, 320, true);
  private cErrorLabel errorNoHpLoginCustomer        = new cErrorLabel("no. hp harus diisi!!", 0, 149, 450, true);
  private cFormLabel labelPasswordLoginCustomer     = new cFormLabel("Password", 0, 183, 450, true);
  private cPasswordField txtPasswordLoginCustomer   = new cPasswordField(65, 213, 320, true);
  private cErrorLabel errorPasswordLoginCustomer    = new cErrorLabel("password harus diisi!!!!", 0, 248, 450, true);
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
  private cErrorLabel errorNoHpDaftarCustomer       = new cErrorLabel("no. hp harus diisi!!", 0, 248, 450, true);
  private cFormLabel labelPasswordDaftarCustomer    = new cFormLabel("Password", 0, 282, 450, true);
  private cPasswordField txtPasswordDaftarCustomer  = new cPasswordField(65, 312, 320, true);
  private cErrorLabel errorPasswordDaftarCustomer   = new cErrorLabel("password harus diisi!!!!", 0, 347, 450, true);
  private cBlueButton btnDaftarDaftarCustomer       = new cBlueButton("Daftar", 65, 381, 320);
  private cLinkStart toLoginMitraDaftarCustomer     = new cLinkStart("sudah punya akun mitra?", 421);
  private cLinkStart toDaftarMitraDaftarCustomer    = new cLinkStart("daftar sebagai mitra", 441);
  private cLinkStart toLoginCustomerDaftarCustomer  = new cLinkStart("sudah punya akun customer?", 461);
  private cLinkStart toLoginAdminDaftarCustomer     = new cLinkStart("login admin", 481);

  // components of Login Mitra
  private cFormLabel labelEmailLoginMitra         = new cFormLabel("Email", 0, 84, 450, true);
  private cTextField txtEmailLoginMitra           = new cTextField(65, 114, 320, true);
  private cErrorLabel errorEmailLoginMitra        = new cErrorLabel("email harus diisi!!!!", 0, 149, 450, true);
  private cFormLabel labelPasswordLoginMitra     = new cFormLabel("Password", 0, 183, 450, true);
  private cPasswordField txtPasswordLoginMitra   = new cPasswordField(65, 213, 320, true);
  private cErrorLabel errorPasswordLoginMitra    = new cErrorLabel("password harus diisi!!!!", 0, 248, 450, true);
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
  private cErrorLabel errorEmailDaftarMitra       = new cErrorLabel("email harus diisi!!!!", 0, 248, 450, true);
  private cFormLabel labelPasswordDaftarMitra    = new cFormLabel("Password", 0, 282, 450, true);
  private cPasswordField txtPasswordDaftarMitra  = new cPasswordField(65, 312, 320, true);
  private cErrorLabel errorPasswordDaftarMitra   = new cErrorLabel("password harus diisi!!!!", 0, 347, 450, true);
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
    private cErrorLabel errorPasswordLoginAdmin    = new cErrorLabel("password harus diisi!!!!", 0, 248, 450, true);
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
    this.setVisible(false);
    this.setTitle("Login Customer");
    cardStart.removeAll();
    titleStart.setText("Login Customer");
    cardStart.add(titleStart);

    
    btnLoginLoginCustomer.addActionListener( new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        String nohp = txtNoHpLoginCustomer.getText();
        String password = String.valueOf(txtPasswordLoginCustomer.getPassword());

        // kalau salah satu datanya kosong
        if( nohp.equalsIgnoreCase("") || nohp.isEmpty() || password.equalsIgnoreCase("") || password.isEmpty() ){

          startView.this.setVisible(false);
          
          // masuk validasi
          if( nohp.equalsIgnoreCase("") || nohp.isEmpty() )
          {
            cardStart.add(errorNoHpLoginCustomer);
          }else{
            cardStart.remove(errorNoHpLoginCustomer);
          }
          
          if( password.equalsIgnoreCase("") || password.isEmpty() ) cardStart.add(errorPasswordLoginCustomer); else cardStart.remove(errorPasswordLoginCustomer);
          
          startView.this.setVisible(true);
        }else{
          // lolos validasi

          if( Model.verifyAkunCustomer(nohp, password) )
          {
            // kalo berhasil login
            Controller.showDashboardCustomer( Integer.valueOf( Model.getDetailCustomerByNoHp(nohp)[0].toString() ) );
            startView.this.setVisible(false);
          }else{
            // kalo gagal login
            JOptionPane.showMessageDialog(startView.this, "Silahkan periksa no. hp dan password!!", "Gagal Login", JOptionPane.ERROR_MESSAGE);
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

    this.setVisible(true);

  }

  public void initsDaftarCustomer()
  {
    this.setVisible(false);
    this.setTitle("Daftar Customer");
    cardStart.removeAll();
    titleStart.setText("Daftar Customer");
    cardStart.add(titleStart);

    btnDaftarDaftarCustomer.addActionListener( new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        String nama = txtNamaDaftarCustomer.getText();
        String noHp = txtNoHpDaftarCustomer.getText();
        String password = String.valueOf( txtPasswordDaftarCustomer.getPassword() );

        if( nama.equalsIgnoreCase("") || nama.isEmpty() || noHp.equalsIgnoreCase("") || noHp.isEmpty() || password.equalsIgnoreCase("") || password.isEmpty() ){

          startView.this.setVisible(false);

          // kalau namanya yang kosong
          if( nama.equalsIgnoreCase("") || nama.isEmpty() ) cardStart.add(errorNamaDaftarCustomer); else cardStart.remove(errorNamaDaftarCustomer);
          
          // kalau noHpnya yang kosong
          if( noHp.equalsIgnoreCase("") || noHp.isEmpty() ) cardStart.add(errorNoHpDaftarCustomer); else cardStart.remove(errorNoHpDaftarCustomer);

          // kalau Passwordnya yang kosong
          if( password.equalsIgnoreCase("") || password.isEmpty() ) cardStart.add(errorPasswordDaftarCustomer); else cardStart.remove(errorPasswordDaftarCustomer);

          startView.this.setVisible(true);

        }else{
          // lolos validasi

          // cek apakah noHp sudah terdaftar atau belum
          if( Model.verifyNoHpCustomer(noHp) ){
            // berarti noHp belum terdaftar
            if( Model.daftarCustomer(nama, noHp, password) )
            {
              // kalau berhasil daftar
              JOptionPane.showMessageDialog(startView.this, "Daftar Berhasil!!", "Berhasil Daftar", JOptionPane.INFORMATION_MESSAGE);
              initsLoginCustomer();
            }else{
              // kalau gagal daftar
              JOptionPane.showMessageDialog(startView.this, "Pendafaran gagal!!", "Gagal Daftar", JOptionPane.ERROR_MESSAGE);
            }

          }else{
            // berarti noHp sudah terdaftar
            JOptionPane.showMessageDialog(startView.this, "Silahkan cek kembali data anda!!", "Gagal Daftar", JOptionPane.ERROR_MESSAGE);
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
    
    this.setVisible(true);
    
  }

  public void initsLoginMitra()
  {
    this.setVisible(false);
    this.setTitle("Login Mitra");
    cardStart.removeAll();
    titleStart.setText("Login Mitra");
    cardStart.add(titleStart);

    btnLoginLoginMitra.addActionListener( new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        String email = txtEmailLoginMitra.getText();
        String password = String.valueOf(txtPasswordLoginMitra.getPassword());

        // kalau salah satu datanya kosong
        if( email.equalsIgnoreCase("") || email.isEmpty() || password.equalsIgnoreCase("") || password.isEmpty() ){

          startView.this.setVisible(false);
          
          // masuk validasi
          if( email.equalsIgnoreCase("") || email.isEmpty() )
          {
            cardStart.add(errorEmailLoginMitra);
          }else{
            cardStart.remove(errorEmailLoginMitra);
          }
          
          if( password.equalsIgnoreCase("") || password.isEmpty() ) cardStart.add(errorPasswordLoginMitra); else cardStart.remove(errorPasswordLoginMitra);
          
          startView.this.setVisible(true);
        }else{
          // lolos validasi

          if( Model.verifyAkunMitra(email, password) )
          {
            // kalo berhasil login
            Controller.showDashboardMitra( Integer.valueOf( Model.getDetailMitraByEmail(email)[0].toString() ) );
            startView.this.setVisible(false);
          }else{
            // kalo gagal login
            JOptionPane.showMessageDialog(startView.this, "Silahkan periksa email dan password!!", "Gagal Login", JOptionPane.ERROR_MESSAGE);
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

    this.setVisible(true);

  }

  public void initsDaftarMitra()
  {
    this.setVisible(false);
    this.setTitle("Daftar Mitra");
    cardStart.removeAll();
    titleStart.setText("Daftar Mitra");
    cardStart.add(titleStart);

    btnDaftarDaftarMitra.addActionListener( new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        String nama = txtNamaDaftarMitra.getText();
        String email = txtEmailDaftarMitra.getText();
        String password = String.valueOf( txtPasswordDaftarMitra.getPassword() );

        if( nama.equalsIgnoreCase("") || nama.isEmpty() || email.equalsIgnoreCase("") || email.isEmpty() || password.equalsIgnoreCase("") || password.isEmpty() ){

          startView.this.setVisible(false);

          // kalau namanya yang kosong
          if( nama.equalsIgnoreCase("") || nama.isEmpty() ) cardStart.add(errorNamaDaftarMitra); else cardStart.remove(errorNamaDaftarMitra);
          
          // kalau Emailnya yang kosong
          if( email.equalsIgnoreCase("") || email.isEmpty() ) cardStart.add(errorEmailDaftarMitra); else cardStart.remove(errorEmailDaftarMitra);

          // kalau Passwordnya yang kosong
          if( password.equalsIgnoreCase("") || password.isEmpty() ) cardStart.add(errorPasswordDaftarMitra); else cardStart.remove(errorPasswordDaftarMitra);

          startView.this.setVisible(true);

        }else{
          // lolos validasi

          // cek apakah email sudah terdaftar atau belum
          if( Model.verifyEmailMitra(email) ){
            // berarti email belum terdaftar
            if( Model.daftarMitra(nama, email, password) )
            {
              // kalau berhasil daftar
              JOptionPane.showMessageDialog(startView.this, "Daftar Berhasil!!", "Berhasil Daftar", JOptionPane.INFORMATION_MESSAGE);
              initsLoginMitra();
            }else{
              // kalau gagal daftar
              JOptionPane.showMessageDialog(startView.this, "Pendafaran gagal!!", "Gagal Daftar", JOptionPane.ERROR_MESSAGE);
            }

          }else{
            // berarti email sudah terdaftar
            JOptionPane.showMessageDialog(startView.this, "Silahkan cek kembali data anda!!", "Gagal Daftar", JOptionPane.ERROR_MESSAGE);
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

    this.setVisible(true);

  }

  public void initsLoginAdmin()
  {
    this.setVisible(false);
    this.setTitle("Login Admin");
    cardStart.removeAll();
    titleStart.setText("Login Admin");
    cardStart.add(titleStart);

    btnLoginLoginAdmin.addActionListener( new java.awt.event.ActionListener(){
      @Override
      public void actionPerformed(java.awt.event.ActionEvent ae)
      {
        
        String username = txtUsernameLoginAdmin.getText();
        String password = String.valueOf(txtPasswordLoginAdmin.getPassword());
        
        if( username.equals("admin") && password.equals("admin") ){
          // loginnya Berhasil
          Controller.showDashboardAdmin(true);
          startView.this.setVisible(false);
        }else{
          // loginnya gagal
          JOptionPane.showMessageDialog(startView.this, "Silahkan periksa username dan password!", "Gagal Login", JOptionPane.ERROR_MESSAGE);
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
    
    this.setVisible(true);
    
  }

  
}
