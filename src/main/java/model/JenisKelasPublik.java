package model;


public class JenisKelasPublik extends JenisKelas{
     private int kapasitas;

    public JenisKelasPublik(int idJenis, String namaJenis, String level,
                            String durasi, int kapasitas, String status) {
        super(idJenis, namaJenis, level, durasi, status);
        this.kapasitas = kapasitas;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }
    
    

    @Override
    public void tampilkanInfo() {
    System.out.println("Nama Jenis : " + getNamaJenis());
    System.out.println("Level      : " + getLevel());
    System.out.println("Durasi     : " + getDurasi());
    System.out.println("Status     : " + getStatus());
    System.out.println("Kapasitas  : " + kapasitas);

}
    
}
