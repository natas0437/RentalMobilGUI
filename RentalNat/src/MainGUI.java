import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainGUI {
    private List<Mobil> daftarMobil;
    private List<Pelanggan> daftarPelanggan;
    private List<Pesanan> daftarPesanan;

    public MainGUI(List<Mobil> daftarMobil, List<Pelanggan> daftarPelanggan, List<Pesanan> daftarPesanan) {
        this.daftarMobil = daftarMobil;
        this.daftarPelanggan = daftarPelanggan;
        this.daftarPesanan = daftarPesanan;
    }

    public void bukaGUI() {
        JFrame frame = new JFrame("Rental Nat");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Selamat Datang di Rental Nat");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JButton adminButton = new JButton("Login as Admin");
        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginAdmin();
            }
        });

        JButton pelangganButton = new JButton("Login as Pelanggan");
        pelangganButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginPelanggan();
            }
        });

        JButton keluarButton = new JButton("Keluar");
        keluarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.add(welcomeLabel);
        panel.add(adminButton);
        panel.add(pelangganButton);
        panel.add(keluarButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void loginAdmin() {
        String username = JOptionPane.showInputDialog("Masukkan username admin:");
        String password = JOptionPane.showInputDialog("Masukkan password admin:");

        if (username.equals("1234") && password.equals("1234")) {
            JOptionPane.showMessageDialog(null, "Login Admin berhasil!");
            Admin admin = new Admin(daftarMobil, daftarPesanan);
            admin.kelolaAdmin();
        } else {
            JOptionPane.showMessageDialog(null, "Login Admin gagal. Coba lagi.");
        }
    }

    private void loginPelanggan() {
        String namaPelanggan = JOptionPane.showInputDialog("Masukkan nama pelanggan:");
        String nomorKTP = JOptionPane.showInputDialog("Masukkan nomor KTP:");
        String alamat = JOptionPane.showInputDialog("Masukkan alamat:");

        Pelanggan pelanggan = new Pelanggan(namaPelanggan, nomorKTP, alamat);
        daftarPelanggan.add(pelanggan);

        JOptionPane.showMessageDialog(null, "Login Pelanggan berhasil!");
        PelangganMenu pelangganMenu = new PelangganMenu(daftarMobil, daftarPelanggan, daftarPesanan);
        pelangganMenu.kelolaPelanggan(pelanggan);
    }

    public static void main(String[] args) {
        List<Mobil> daftarMobil = new ArrayList<>();
        List<Pelanggan> daftarPelanggan = new ArrayList<>();
        List<Pesanan> daftarPesanan = new ArrayList<>();

        MainGUI mainGUI = new MainGUI(daftarMobil, daftarPelanggan, daftarPesanan);
        mainGUI.bukaGUI();
    }
}
