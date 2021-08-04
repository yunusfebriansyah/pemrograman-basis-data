import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;
import java.awt.Font;

public class App {

  public static void main(String[] args) throws Exception {

    // frame
    JFrame mainWindow = new JFrame();
    mainWindow.setSize(1280, 720);
    mainWindow.setTitle("Frame Utama");
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setLayout(null);
    mainWindow.setLocationRelativeTo(null);

    // panel
    JPanel sidebar = new JPanel();
    sidebar.setSize(200, 720);
    sidebar.setBackground( new Color(23, 35, 51) );
    sidebar.setLayout(null);
    
    JPanel header = new JPanel();
    header.setBounds(200, 0, 1080, 70);
    header.setBackground(new Color(71, 120, 197));
    header.setLayout(null);

    JPanel content = new JPanel();
    content.setBounds(200, 70, 1080, 650);
    content.setBackground(Color.WHITE);
    content.setLayout(null);

    // ini component
    JLabel title = new JLabel("Isi Data User");
    title.setBounds(20, 20, 300, 30);
    title.setFont(new Font("Poppins Bold", Font.PLAIN, 30));

    JLabel nama = new JLabel("Nama");
    nama.setBounds(20, 70, 300, 20);
    nama.setFont(new Font("Poppins Medium", Font.PLAIN, 20 ));
    
    JTextField txtNama = new JTextField();
    txtNama.setBounds(20, 100, 400, 30);
    txtNama.setFont(new Font("Poppins", Font.PLAIN, 16));
    
    JLabel username = new JLabel("Username");
    username.setBounds(20, (int)txtNama.getLocation().getY()+45, 300, 20);
    username.setFont(new Font("Poppins Medium", Font.PLAIN, 20 ));

    JTextField txtUsername = new JTextField();
    txtUsername.setBounds(20, (int)username.getLocation().getY()+30, 400, 30);
    txtUsername.setFont(new Font("Poppins", Font.PLAIN, 16));
    
    JLabel password = new JLabel("Password");
    password.setBounds(20, (int)txtUsername.getLocation().getY()+45, 300, 20);
    password.setFont(new Font("Poppins Medium", Font.PLAIN, 20 ));
    
    JPasswordField txtPassword = new JPasswordField();
    txtPassword.setBounds(20, (int)password.getLocation().getY()+30, 400, 30);
    txtPassword.setFont(new Font("Poppins", Font.PLAIN, 16 ));
    
    JLabel alamat = new JLabel("Alamat");
    alamat.setBounds(20, (int)txtPassword.getLocation().getY()+45, 300, 20);
    alamat.setFont(new Font("Poppins Medium", Font.PLAIN, 20 ));
    
    JTextArea txtAlamat = new JTextArea();
    txtAlamat.setFont(new Font("Poppins", Font.PLAIN, 16 ));
    txtAlamat.setLineWrap(true);
    txtAlamat.setWrapStyleWord(true);
    
    JScrollPane scrollTxtAlamat = new JScrollPane(txtAlamat);
    scrollTxtAlamat.setBounds(20, (int)alamat.getLocation().getY()+30, 400, 100);
    
    JLabel jk = new JLabel("Jenis Kelamin");
    jk.setBounds(20, (int)scrollTxtAlamat.getLocation().getY()+115, 300, 20);
    jk.setFont(new Font("Poppins Medium", Font.PLAIN, 20 ));

    JRadioButton rdPria = new JRadioButton("Pria");
    rdPria.setBounds(20, (int)jk.getLocation().getY()+20, 100, 30);
    rdPria.setFont( new Font("Poppins", Font.PLAIN, 16) );
    rdPria.setBackground( new Color(255,255,255) );
    rdPria.setActionCommand("Pria");
    
    JRadioButton rdPerempuan = new JRadioButton("Perempuan");
    rdPerempuan.setBounds(120, (int)jk.getLocation().getY()+20, 130, 30);
    rdPerempuan.setFont( new Font("Poppins", Font.PLAIN, 16) );
    rdPerempuan.setBackground( new Color(255,255,255) );
    rdPerempuan.setActionCommand("Perempuan");
    
    ButtonGroup groupJK = new ButtonGroup();
    groupJK.add(rdPria);
    groupJK.add(rdPerempuan);

    JLabel hobi = new JLabel("Hobi");
    hobi.setBounds(20, (int)rdPerempuan.getLocation().getY()+40, 300, 20);
    hobi.setFont(new Font("Poppins Medium", Font.PLAIN, 20 ));

    JCheckBox chMancing = new JCheckBox("Mancing");
    chMancing.setBounds(20, (int)hobi.getLocation().getY()+20, 130, 30);
    chMancing.setFont( new Font("Poppins", Font.PLAIN, 16) );
    chMancing.setBackground( new Color(255,255,255) );
    
    JCheckBox chGame = new JCheckBox("NgeGame");
    chGame.setBounds(150, (int)hobi.getLocation().getY()+20, 130, 30);
    chGame.setFont( new Font("Poppins", Font.PLAIN, 16) );
    chGame.setBackground( new Color(255,255,255) );
    
    JCheckBox chTouring = new JCheckBox("Touring");
    chTouring.setBounds(280, (int)hobi.getLocation().getY()+20, 130, 30);
    chTouring.setFont( new Font("Poppins", Font.PLAIN, 16) );
    chTouring.setBackground( new Color(255,255,255) );
    
    JLabel agama = new JLabel("Agama");
    agama.setBounds(500, 65, 300, 25);
    agama.setFont(new Font("Poppins Medium", Font.PLAIN, 20 ));

    String pilihanAgama[] = {"Islam", "Hindu", "Katholik", "Kristen"};
    JComboBox<String> cmbAgama = new JComboBox<String>(pilihanAgama);
    cmbAgama.setFont( new Font("Poppins", Font.PLAIN, 16) );
    cmbAgama.setBounds(500, (int)agama.getLocation().getY()+35, 400, 30);
    cmbAgama.setBackground(Color.WHITE);
    cmbAgama.addItem("Budha");

    JLabel pekerjaan = new JLabel("Pekerjaan");
    pekerjaan.setBounds(500, (int)cmbAgama.getLocation().getY()+45, 300, 25);
    pekerjaan.setFont(new Font("Poppins Medium", Font.PLAIN, 20 ));

    String listPekerjaan[] = {"Designer", "Programmer", "Data Analysis", "Influencer", "Youtuber"};
    JList<String> lsPekerjaan = new JList<String>(listPekerjaan);
    lsPekerjaan.setFont(new Font("Poppins", Font.PLAIN, 16));

    JScrollPane scrollLsPekerjaan = new JScrollPane(lsPekerjaan);
    scrollLsPekerjaan.setBounds(500, (int)pekerjaan.getLocation().getY()+30, 400, 100);

    JButton btnSubmit = new JButton("Submit");
    btnSubmit.setFont( new Font("Poppins", Font.PLAIN, 16) );
    btnSubmit.setBounds(500, (int)scrollLsPekerjaan.getLocation().getY()+115, 100, 40);
    btnSubmit.setBackground( new Color(71, 120, 197) );
    btnSubmit.setForeground( Color.WHITE );



    // event handling

    //buat objek action listener
    // ActionListener clickButton = new ActionListener(){
    //   @Override
    //   public void actionPerformed( ActionEvent e ){
    //     // response
    //     System.out.println("ok");
    //   }
    // };


    btnSubmit.addActionListener( new ActionListener(){
      @Override
      public void actionPerformed( ActionEvent ae ){
        // getter value dari inputan
        // getter value JTextField
        String nama = txtNama.getText();
        String username = txtUsername.getText();

        // Getter value JPasswordField
        String password = String.valueOf(txtPassword.getPassword());
        // Getter value JTextarea
        String alamat = txtAlamat.getText();
        String jk = "";
        String hobi = "";
        // Getter value JComboBox
        String agama = cmbAgama.getSelectedItem().toString();
        String pekerjaan = "";
        
        // Getter value JRadioButton
        try {
          jk = groupJK.getSelection().getActionCommand();
        } catch (Exception e) {
          JOptionPane.showMessageDialog( mainWindow, "Pilih jenis kelamin", "Peringatan", JOptionPane.WARNING_MESSAGE );
          return;
        }
        
        // Cek seleksi pada JCheckbox
        if( chMancing.isSelected() ){
          hobi += "Mancing,";
        }
        if( chGame.isSelected() ){
          hobi += "NgeGame,";
        }
        if( chTouring.isSelected() ){
          hobi += "Touring,";
        }

        // Getter Index yang terseleksi pada JList
        int indexSelecteds[] = lsPekerjaan.getSelectedIndices();
        for( int i = 0; i < indexSelecteds.length; i++ ){
          pekerjaan += lsPekerjaan.getModel().getElementAt(indexSelecteds[i]) + ",";
        }
        
        

        String message = 
          "Nama : " + nama + "\n"
          + "Username : " + username + "\n"
          + "Password : " + password + "\n"
          + "Alamat : " + alamat + "\n"
          + "Jenis Kelamin : " + jk + "\n"
          + "Hobi : " + hobi + "\n"
          + "Agama : " + agama + "\n"
          + "Pekerjaan : " + pekerjaan + "\n"
        ;

        JOptionPane.showMessageDialog(
          mainWindow,
          message,
          "Hasil inputan",
          JOptionPane.INFORMATION_MESSAGE
        );

      }
    } );
    
    
    // finally
    content.add(title);
    content.add(nama);
    content.add(txtNama);
    content.add(username);
    content.add(txtUsername);
    content.add(password);
    content.add(txtPassword);
    content.add(alamat);
    content.add(scrollTxtAlamat);
    content.add(jk);
    content.add(rdPria);
    content.add(rdPerempuan);
    content.add(hobi);
    content.add(chMancing);
    content.add(chGame);
    content.add(chTouring);
    content.add(agama);
    content.add(cmbAgama);
    content.add(pekerjaan);
    content.add(scrollLsPekerjaan);
    content.add(btnSubmit);
    mainWindow.add(sidebar);
    mainWindow.add(header);
    mainWindow.add(content);
    mainWindow.setVisible(true);
    

  }
}
