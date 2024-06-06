package src.Game;
// Deklarasi antarmuka (interface) GameInterface
interface GameInterface {
    // Deklarasi metode jalan yang harus diimplementasikan oleh kelas yang mengimplementasi GameInterface
    void jalan(int posisiP1, int posisiP2, int giliran);

    // Deklarasi metode callImage yang harus diimplementasikan oleh kelas yang mengimplementasi GameInterface
    void callImage();
}
