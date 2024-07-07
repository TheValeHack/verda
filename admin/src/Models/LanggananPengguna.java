package Models;

public class LanggananPengguna {
    private int id, idPengguna;
    private String aktifHingga;

    public LanggananPengguna(int id, int idPengguna, String aktifHingga) {
        this.id = id;
        this.idPengguna = idPengguna;
        this.aktifHingga = aktifHingga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(int idPengguna) {
        this.idPengguna = idPengguna;
    }

    public String getAktifHingga() {
        return aktifHingga;
    }

    public void setAktifHingga(String aktifHingga) {
        this.aktifHingga = aktifHingga;
    }
}
