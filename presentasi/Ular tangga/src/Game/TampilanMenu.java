package src.Game;
import javax.swing.*;
import src.Database.DatabaseHandler;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
// Deklarasi kelas TampilanMenu yang mengimplementasikan AbstractTampilanMenu
public class TampilanMenu extends AbstractTampilanMenu {
    // Metode utama untuk menjalankan aplikasi
    public static void main(String[] args) {
        TampilanMenu tampilanMenu = new TampilanMenu();
        tampilanMenu.initializeFrame();
    }
    // Implementasi metode initializeFrame dari AbstractTampilanMenu
    @Override
    public void initializeFrame() {
        JFrame frame = new JFrame("Ular Tangga");
        frame.setSize(510, 285);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        configureLayout(panel);
        frame.setVisible(true);
    }
    // Implementasi metode configureLayout dari AbstractTampilanMenu
    @Override
    public void configureLayout(JPanel panel) {
        panel.setLayout(null);
        JButton button1 = createButton(panel, "Exit", Color.BLUE, Color.RED, 350, 180, 120, 25, null);
        JButton button2 = createButton(panel, "Score", Color.BLUE, Color.RED, 350, 140, 120, 25, null);
        JButton button3 = createButton(panel, "Play", Color.BLUE, Color.RED, 350, 100, 120, 25, null);
        addExitActionListener(button1);
        addScoreActionListener(button2);
        addPlayActionListener(button3);
        panel.setLayout(new BorderLayout());
        JLabel imageLabel = new JLabel();
        panel.add(imageLabel, BorderLayout.CENTER);
        loadImageAndSetIcon(imageLabel, "img/unnamed.png");
    }
    // Implementasi metode createButton dari AbstractTampilanMenu
    @Override
    public JButton createButton(JPanel panel, String label, Color background, Color foreground, int x, int y, int width, int height, ActionListener actionListener) {
        JButton button = new JButton(label);
        button.setBackground(background);
        button.setForeground(foreground);
        button.setBounds(x, y, width, height);
        panel.add(button);
        if (actionListener != null) {
            button.addActionListener(actionListener);
        }
        return button;
    }
    // Implementasi metode addExitActionListener dari AbstractTampilanMenu
    @Override
    public void addExitActionListener(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessageDialog("Terima Kasih Telah Bermain");
                System.exit(0);
            }
        });
    }
    // Implementasi metode addScoreActionListener dari AbstractTampilanMenu
    @Override
    public void addScoreActionListener(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatabaseHandler.showLeaderboard();
            new Leaderboard();
            }
        });
    }
    // Implementasi metode addPlayActionListener dari AbstractTampilanMenu
    @Override
    public void addPlayActionListener(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessageDialog("Selamat Bermain!!!");
                String N1 = "";
                String N2 = "";
                new UlarTangga(0, N1, N2, 1, 1, false, 1);
            }
        });
    }
    // Implementasi metode showMessageDialog dari AbstractTampilanMenu
    @Override
    public void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
      // Implementasi metode loadImageAndSetIcon dari AbstractTampilanMenu
    @Override
    public void loadImageAndSetIcon(JLabel label, String imagePath) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            ImageIcon icon = new ImageIcon(image);
            label.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}