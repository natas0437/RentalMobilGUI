class Mobil {
    private String namaKendaraan;
    private String nomorKendaraan;
    private String nomorPolisi;
    private double harga;
    private boolean tersedia;

    public Mobil(String nomorKendaraan, String nomorPolisi, double harga) {
        this.nomorKendaraan = nomorKendaraan;
        this.nomorPolisi = nomorPolisi;
        this.harga = harga;
        this.tersedia = true;
    }

    public String getNamaKendaraan() {
        return namaKendaraan;
    }

    public void setNamaKendaraan(String namaKendaraan) {
        this.namaKendaraan = namaKendaraan;
    }

    public String getNomorKendaraan() {
        return nomorKendaraan;
    }

    public String getNomorPolisi() {
        return nomorPolisi;
    }

    public double getHarga() {
        return harga;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    @Override
    public String toString() {
        return namaKendaraan + " - " + nomorKendaraan + " - " + nomorPolisi + " - " +
                harga + " - " + (tersedia ? "Tersedia" : "Tidak Tersedia");
    }
}