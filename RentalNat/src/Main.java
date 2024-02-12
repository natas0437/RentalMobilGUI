import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Mobil> daftarMobil = new ArrayList<>();
        List<Pelanggan> daftarPelanggan = new ArrayList<>();
        List<Pesanan> daftarPesanan = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int role;
        do {
            System.out.println("Pilihan Login:");
            System.out.println("1. Admin");
            System.out.println("2. Pelanggan");
            System.out.println("0. Keluar");

            System.out.print("Masukkan pilihan: ");
            role = scanner.nextInt();

            switch (role) {
                case 1:
                    Admin admin = new Admin(daftarMobil, daftarPesanan);
                    admin.kelolaAdmin();
                    break;
                case 2:
                    System.out.print("Masukkan nama pelanggan: ");
                    String namaPelanggan = scanner.next();
                    System.out.print("Masukkan nomor KTP: ");
                    String nomorKTP = scanner.next();
                    System.out.print("Masukkan alamat: ");
                    String alamat = scanner.next();

                    Pelanggan pelanggan = new Pelanggan(namaPelanggan, nomorKTP, alamat);
                    daftarPelanggan.add(pelanggan);

                    PelangganMenu pelangganMenu = new PelangganMenu(daftarMobil, daftarPelanggan, daftarPesanan);
                    pelangganMenu.kelolaPelanggan(pelanggan);
                    break;
            }
        } while (role != 0);
    }
}