class Pelanggan {
    private String nama;
    private String nomorKTP;
    private String alamat;

    public Pelanggan(String nama, String nomorKTP, String alamat) {
        this.nama = nama;
        this.nomorKTP = nomorKTP;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getNomorKTP() {
        return nomorKTP;
    }

    public String getAlamat() {
        return alamat;
    }
}

class Pesanan {
    private Pelanggan pelanggan;
    private Mobil mobil;
    private String tanggal;
    private String jam;

    public Pesanan(Pelanggan pelanggan, Mobil mobil, String tanggal, String jam) {
        this.pelanggan = pelanggan;
        this.mobil = mobil;
        this.tanggal = tanggal;
        this.jam = jam;
    }

    @Override
    public String toString() {
        return "Pesanan oleh " + pelanggan.getNama() + " untuk mobil " + mobil.getNomorKendaraan() +
                " pada tanggal " + tanggal + " jam " + jam;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }
}