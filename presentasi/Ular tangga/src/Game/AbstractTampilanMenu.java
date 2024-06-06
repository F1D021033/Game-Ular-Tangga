package src.Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Deklarasi kelas abstrak AbstractTampilanMenu
public abstract class AbstractTampilanMenu {
    // Metode abstrak untuk menginisialisasi frame
    public abstract void initializeFrame();

    // Metode abstrak untuk mengonfigurasi tata letak (layout)
    public abstract void configureLayout(JPanel panel);

    // Metode abstrak untuk membuat tombol dengan parameter yang diberikan
    public abstract JButton createButton(JPanel panel, String label, Color background, Color foreground, int x, int y, int width, int height, ActionListener actionListener);

    // Metode abstrak untuk menambahkan action listener untuk tombol keluar (exit)
    public abstract void addExitActionListener(JButton button);

    // Metode abstrak untuk menambahkan action listener untuk tombol skor (score)
    public abstract void addScoreActionListener(JButton button);

    // Metode abstrak untuk menambahkan action listener untuk tombol main (play)
    public abstract void addPlayActionListener(JButton button);

    // Metode abstrak untuk menampilkan dialog pesan
    public abstract void showMessageDialog(String message);

    // Metode abstrak untuk memuat gambar dan mengatur ikon label dengan path gambar yang diberikan
    public abstract void loadImageAndSetIcon(JLabel label, String imagePath);
}
