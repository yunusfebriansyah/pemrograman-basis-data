import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class App {
    public static void main(String[] args) throws Exception {
        
        // frame
        JFrame mainWindow = new JFrame();
        mainWindow.setSize(1920, 1080);
        mainWindow.setTitle("Frame Utama");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLayout(null);
        mainWindow.setResizable(false);
        mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // panel
        JPanel bg = new JPanel();
        bg.setSize(1920, 1080);
        bg.setBackground( Color.blue );
        bg.setLayout(null);

        JPanel card = new JPanel();
        // card.setSize(500, 600);
        // card.setLocation(100, 50);
        card.setBounds(500, 100, 500, 600);
        card.setBackground(Color.WHITE);
        card.setLayout(null);


        // finally
        bg.add(card);
        mainWindow.add(bg);
        mainWindow.setVisible(true);

    }
}
