import javax.swing.*;
import java.awt.*;
import java.util.List;

class Admin {
    private List<Mobil> daftarMobil;
    private List<Pesanan> daftarPesanan;

    public Admin(List<Mobil> daftarMobil, List<Pesanan> daftarPesanan) {
        this.daftarMobil = daftarMobil;
        this.daftarPesanan = daftarPesanan;
    }

    public void tambahMobil(String namaKendaraan, String nomorKendaraan, String nomorPolisi, double harga) {
        Mobil mobilBaru = new Mobil(nomorKendaraan, nomorPolisi, harga);
        mobilBaru.setNamaKendaraan(namaKendaraan);
        daftarMobil.add(mobilBaru);
        JOptionPane.showMessageDialog(null, "Mobil berhasil ditambahkan!");
    }

    public void tampilkanDaftarMobil() {
        StringBuilder mobilList = new StringBuilder("Daftar Mobil:\n");
        for (Mobil mobil : daftarMobil) {
            mobilList.append(mobil.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mobilList.toString());
    }

    public void tampilkanDaftarPesanan() {
        StringBuilder pesananList = new StringBuilder("Daftar Pesanan:\n");
        for (Pesanan pesanan : daftarPesanan) {
            pesananList.append(pesanan.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, pesananList.toString());
    }

    public void kelolaAdmin() {
        int pilihan;
        do {
            String[] options = {"Menambahkan Mobil Baru", "Melihat daftar pesanan", "Melihat daftar mobil yang disewakan", "Keluar"};
            pilihan = JOptionPane.showOptionDialog(null, "Pilihan Admin:", "Admin Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (pilihan) {
                case 0:
                    showTambahMobilMenu();
                    break;
                case 1:
                    tampilkanDaftarPesanan();
                    break;
                case 2:
                    tampilkanDaftarMobil();
                    break;
            }
        } while (pilihan != 3);
    }

    private void showTambahMobilMenu() {
        JTextField namaField = new JTextField(10);
        JTextField nomorField = new JTextField(10);
        JTextField polisiField = new JTextField(10);
        JTextField hargaField = new JTextField(10);

        JPanel tambahMobilPanel = new JPanel(new GridLayout(0, 2));
        tambahMobilPanel.add(new JLabel("Nama Kendaraan:"));
        tambahMobilPanel.add(namaField);
        tambahMobilPanel.add(new JLabel("Nomor Kendaraan:"));
        tambahMobilPanel.add(nomorField);
        tambahMobilPanel.add(new JLabel("Nomor Polisi:"));
        tambahMobilPanel.add(polisiField);
        tambahMobilPanel.add(new JLabel("Harga:"));
        tambahMobilPanel.add(hargaField);

        int result = JOptionPane.showConfirmDialog(null, tambahMobilPanel, "Tambah Mobil", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String namaKendaraan = namaField.getText();
            String nomorKendaraan = nomorField.getText();
            String nomorPolisi = polisiField.getText();
            double harga = Double.parseDouble(hargaField.getText());

            tambahMobil(namaKendaraan, nomorKendaraan, nomorPolisi, harga);
        }
    }
}