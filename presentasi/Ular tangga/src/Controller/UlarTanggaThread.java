// Import paket yang diperlukan
package src.Controller;

import src.Game.UlarTangga;

// Kelas UlarTanggaThread yang mengimplementasikan antarmuka Runnable
public class UlarTanggaThread implements Runnable {
    // Metode run untuk menjalankan logika pengocokan dadu secara konkuren
    public void run() {
        try {
            // Loop while untuk melakukan pengocokan dadu selama thread belum diinterupsi dan game belum berakhir
            while (!Thread.interrupted() && !UlarTangga.temp) {
                // Menghasilkan angka acak antara 0 dan 5 untuk dadu pertama
                UlarTangga.dc1 = (int) (Math.random() * 6.0D);
                // Menetapkan ikon dadu pertama sesuai dengan nilai yang dihasilkan
                UlarTangga.dice1.setIcon(UlarTangga.dadu[UlarTangga.dc1]);

                // Menghasilkan angka acak antara 0 dan 5 untuk dadu kedua
                UlarTangga.dc2 = (int) (Math.random() * 6.0D);
                // Menetapkan ikon dadu kedua sesuai dengan nilai yang dihasilkan
                UlarTangga.dice2.setIcon(UlarTangga.dadu[UlarTangga.dc2]);

                // Menunda eksekusi thread selama 10 milidetik
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            // Menampilkan stack trace jika terjadi kesalahan pada thread
            e.printStackTrace();
        }
    }
}
