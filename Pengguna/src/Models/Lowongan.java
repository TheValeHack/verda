package Models;

public class Lowongan {
    private String posisi;
    private String perusahaan;
    private String lokasi;
    private String gaji;
    private String kualifikasi;
    private String waktuDiposting;

    // Constructor, getters, and setters
    public Lowongan(String posisi, String perusahaan, String lokasi, String gaji, String kualifikasi, String waktuDiposting) {
        this.posisi = posisi;
        this.perusahaan = perusahaan;
        this.lokasi = lokasi;
        this.gaji = gaji;
        this.kualifikasi = kualifikasi;
        this.waktuDiposting = waktuDiposting;
    }

    // Getters and setters
    public String getPosisi() { return posisi; }
    public void setPosisi(String posisi) { this.posisi = posisi; }

    public String getPerusahaan() { return perusahaan; }
    public void setPerusahaan(String perusahaan) { this.perusahaan = perusahaan; }

    public String getLokasi() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }

    public String getGaji() { return gaji; }
    public void setGaji(String gaji) { this.gaji = gaji; }

    public String getKualifikasi() { return kualifikasi; }
    public void setKualifikasi(String kualifikasi) { this.kualifikasi = kualifikasi; }

    public String getWaktuDiposting() { return waktuDiposting; }
    public void setWaktuDiposting(String waktuDiposting) { this.waktuDiposting = waktuDiposting; }
}
