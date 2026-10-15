package model;

public abstract class JenisKelas  {

    private int idJenis;
    private String namaJenis;
    private String level;
    private String durasi;
    private String status;

    public JenisKelas(int idJenis, String namaJenis, String level, String durasi, String status) {
        this.idJenis = idJenis;
        this.namaJenis = namaJenis;
        this.level = level;
        this.durasi = durasi;
        this.status = status;
    }
    
    public abstract void tampilkanInfo();
    
     public int getIdJenis() {
        return idJenis;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    public String getLevel() {
        return level;
    }

    public String getDurasi() {
        return durasi;
    }
    
    public String getStatus() {
        return status;
    }

    public void setIdJenis(int idJenis) {
        this.idJenis = idJenis;
    }

    public void setNamaJenis(String namaJenis) {
        this.namaJenis = namaJenis;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}