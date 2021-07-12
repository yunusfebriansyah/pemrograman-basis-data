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
    
    JLabel jk = new JLabel("Jenis Kelamin");
    jk.setBounds(20, (int)scrollTxtAlamat.getLocation().getY()+115, 300, 20);
    jk.setFont(new Font("Poppins Medium", Font.PLAIN, 20 ));

    JRadioButton rdPria = new JRadioButton("Pria");
    rdPria.setBounds(20, (int)jk.getLocation().getY()+20, 100, 30);
    rdPria.setFont( new Font("Poppins", Font.PLAIN, 16) );
    rdPria.setBackground( new Color(255,255,255) );

    JRadioButton rdPerempuan = new JRadioButton("Perempuan");
    rdPerempuan.setBounds(120, (int)jk.getLocation().getY()+20, 130, 30);
    rdPerempuan.setFont( new Font("Poppins", Font.PLAIN, 16) );
    rdPerempuan.setBackground( new Color(255,255,255) );
    
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
    
    // finally
    content.add(title);
    content.add(nama);
    content.add(txtNama);
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
    mainWindow.add(sidebar);
    mainWindow.add(header);
    mainWindow.add(content);
    mainWindow.setVisible(true);

  }
}
