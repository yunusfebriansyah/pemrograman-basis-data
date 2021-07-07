import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

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
    txtNama.setBounds(20, 100, 500, 30);
    txtNama.setFont(new Font("Poppins", Font.PLAIN, 16));
    
    JLabel password = new JLabel("Password");
    password.setBounds(20, (int)txtNama.getLocation().getY()+45, 300, 20);
    password.setFont(new Font("Poppins Medium", Font.PLAIN, 20 ));
    
    JPasswordField txtPassword = new JPasswordField();
    txtPassword.setBounds(20, (int)password.getLocation().getY()+30, 500, 30);
    txtPassword.setFont(new Font("Poppins", Font.PLAIN, 16 ));
    
    JLabel alamat = new JLabel("Alamat");
    alamat.setBounds(20, (int)txtPassword.getLocation().getY()+45, 300, 20);
    alamat.setFont(new Font("Poppins Medium", Font.PLAIN, 20 ));
    
    JTextArea txtAlamat = new JTextArea();
    txtAlamat.setFont(new Font("Poppins", Font.PLAIN, 16 ));
    txtAlamat.setLineWrap(true);
    txtAlamat.setWrapStyleWord(true);
    
    JScrollPane scrollTxtAlamat = new JScrollPane(txtAlamat);
    scrollTxtAlamat.setBounds(20, (int)alamat.getLocation().getY()+30, 500, 100);
    
    // finally
    content.add(title);
    content.add(nama);
    content.add(txtNama);
    content.add(password);
    content.add(txtPassword);
    content.add(alamat);
    content.add(scrollTxtAlamat);
    mainWindow.add(sidebar);
    mainWindow.add(header);
    mainWindow.add(content);
    mainWindow.setVisible(true);

  }
}
