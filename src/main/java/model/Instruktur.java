package model;

public class Instruktur {

    private int idInstruktur;
    private String namaInstruktur;
    private String spesialisasi;
    private String noTelepon;
    private String jenisKelamin;
    private String domisili;
    private String status;

    public Instruktur(int idInstruktur, String namaInstruktur, String spesialisasi, String noTelepon, String jenisKelamin, String domisili, String status) {
        this.idInstruktur = idInstruktur;
        this.namaInstruktur = namaInstruktur;
        this.spesialisasi = spesialisasi;
        this.noTelepon = noTelepon;
        this.jenisKelamin = jenisKelamin;
        this.domisili = domisili;
        this.status = status;
    }
    
    public int getIdInstruktur() {
        return idInstruktur;
    }

    public String getNamaInstruktur() {
        return namaInstruktur;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public String getNoTelepon() {
        return noTelepon;
    }
    
    public String getJenisKelamin () {
        return jenisKelamin;
    }
    
    public String getDomisili () {
        return domisili;
    }
    
    public String getStatus () {
        return status;
    }

    public void setIdInstruktur(int idInstruktur) {
        this.idInstruktur = idInstruktur;
    }

    public void setNamaInstruktur(String namaInstruktur) {
        this.namaInstruktur = namaInstruktur;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public void setDomisili(String domisili) {
        this.domisili = domisili;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    

}