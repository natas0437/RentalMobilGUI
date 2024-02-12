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
    //polymorphism
    @Override
    public String toString() {
        return "Pesanan oleh " + pelanggan.getNama() + " untuk mobil " + mobil.getNomorKendaraan() +
                " pada tanggal " + tanggal + " jam " + jam;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }
}
