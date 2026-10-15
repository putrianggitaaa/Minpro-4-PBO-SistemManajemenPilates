package model;

public class JenisKelasPrivate extends JenisKelas{
     private String jenisSesi;

    public JenisKelasPrivate(int idJenis, String namaJenis, String level,
                             String durasi, String jenisSesi, String status) {
        super(idJenis, namaJenis, level, durasi, status);
        this.jenisSesi = jenisSesi;
    }

    public String getJenisSesi() {
        return jenisSesi;
    }

    public void setJenisSesi(String jenisSesi) {
        this.jenisSesi = jenisSesi;
    }
    
    

    @Override
    public void tampilkanInfo() {
    System.out.println("Nama Jenis : " + getNamaJenis());
    System.out.println("Level      : " + getLevel());
    System.out.println("Durasi     : " + getDurasi());
    System.out.println("Status     : " + getStatus());
    System.out.println("Jenis Sesi : " + jenisSesi);
}
    
}
