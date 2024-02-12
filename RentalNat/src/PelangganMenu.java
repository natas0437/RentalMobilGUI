import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PelangganMenu {
    private List<Mobil> daftarMobil;
    private List<Pelanggan> daftarPelanggan;
    private List<Pesanan> daftarPesanan;
    private Pelanggan pelanggan;


    public PelangganMenu(List<Mobil> daftarMobil, List<Pelanggan> daftarPelanggan, List<Pesanan> daftarPesanan) {
        this.daftarMobil = daftarMobil;
        this.daftarPelanggan = daftarPelanggan;
        this.daftarPesanan = daftarPesanan;
    }

    public void kelolaPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;

        JFrame frame = new JFrame("Menu Pelanggan");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Selamat Datang, " + pelanggan.getNama() + "!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JButton lihatMobilButton = new JButton("Lihat Daftar Mobil Tersedia");
        lihatMobilButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tampilkanDaftarMobil();
            }
        });

        JButton pesanMobilButton = new JButton("Pesan Mobil");
        pesanMobilButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pesanMobil();
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
        panel.add(lihatMobilButton);
        panel.add(pesanMobilButton);
        panel.add(keluarButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void tampilkanDaftarMobil() {
        JFrame frame = new JFrame("Daftar Mobil Tersedia");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        for (Mobil mobil : daftarMobil) {
            if (mobil.isTersedia()) {
                textArea.append(mobil.toString() + "\n");
            }
        }

        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton kembaliButton = new JButton("Kembali");
        kembaliButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                kelolaPelanggan(pelanggan);
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(kembaliButton, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    public void pesanMobil() {
        JFrame frame = new JFrame("Pesan Mobil");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Pilih nomor kendaraan untuk pesan:");
        label.setFont(new Font("Arial", Font.PLAIN, 14));

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        JComboBox<String> comboBox = new JComboBox<>(model);

        for (Mobil mobil : daftarMobil) {
            if (mobil.isTersedia()) {
                model.addElement(mobil.getNomorKendaraan());
            }
        }

        JButton pesanButton = new JButton("Pesan");
        pesanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomorKendaraan = (String) comboBox.getSelectedItem();
                pesanMobil(nomorKendaraan);
                frame.dispose();
            }
        });

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.add(label);
        panel.add(comboBox);
        panel.add(pesanButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void pesanMobil(String nomorKendaraan) {
        Mobil mobil = cariMobil(nomorKendaraan);
        if (mobil != null && mobil.isTersedia()) {
            String tanggal = JOptionPane.showInputDialog("Masukkan tanggal (format: dd-mm-yyyy):");
            String jam = JOptionPane.showInputDialog("Masukkan jam:");

            Pesanan pesanan = new Pesanan(pelanggan, mobil, tanggal, jam);
            daftarPesanan.add(pesanan);
            mobil.setTersedia(false);

            JOptionPane.showMessageDialog(null, "Pesanan berhasil dibuat!");
        } else {
            JOptionPane.showMessageDialog(null, "Mobil tidak tersedia atau nomor kendaraan tidak valid.");
        }
    }

    private Mobil cariMobil(String nomorKendaraan) {
        for (Mobil mobil : daftarMobil) {
            if (mobil.getNomorKendaraan().equals(nomorKendaraan)) {
                return mobil;
            }
        }
        return null;
    }
}
