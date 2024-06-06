// Import paket dan kelas yang diperlukan
package src.Game;
import javax.swing.*;
import src.Database.DatabaseHandler;
import java.util.ArrayList;

// Deklarasi kelas Leaderboard yang merupakan turunan dari JFrame
public class Leaderboard extends JFrame {
    // Deklarasi variabel untuk daftar leaderboard yang dapat di-scroll
    private JScrollPane leaderboardList;
    // Deklarasi JList untuk menampilkan data leaderboard
    private JList<String> list;

    // Konstruktor kelas Leaderboard
    public Leaderboard() {
        // Mengatur judul frame
        setTitle("Leaderboard");
        // Mengatur ukuran frame
        setSize(200, 250);
        // Mengatur operasi penutupan frame ketika ditutup
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Menempatkan frame di tengah layar
        setLocationRelativeTo(null);

        // Membuat objek JList
        list = new JList<>();
        // Membuat JScrollPane yang berisi JList
        leaderboardList = new JScrollPane(list);

        // Mendapatkan data leaderboard dari DatabaseHandler
        ArrayList<String> leaderboardData = DatabaseHandler.showLeaderboard();

        // Menetapkan model data JList dengan AbstractListModel
        list.setModel(new AbstractListModel<String>() {
            // Menggunakan array dari ArrayList sebagai model data
            public String[] nama = leaderboardData.toArray(new String[0]);

            // Mendapatkan jumlah elemen dalam model
            public int getSize() {
                return nama.length;
            }

            // Mendapatkan elemen pada indeks tertentu dalam model
            public String getElementAt(int i) {
                return nama[i];
            }
        });

        // Menetapkan konten frame dengan JScrollPane yang berisi JList
        setContentPane(leaderboardList);
        // Menampilkan frame
        setVisible(true);
    }
}
