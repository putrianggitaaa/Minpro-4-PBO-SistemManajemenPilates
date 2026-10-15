package view;

public class JenisKelasView {

    public void tampilkanMenu() {

    System.out.println("\n========================================");
    System.out.println("          MENU JENIS KELAS");
    System.out.println("========================================");
    System.out.println("1. Tambah Jenis Kelas");
    System.out.println("2. Lihat Jenis Kelas");
    System.out.println("3. Update Status Jenis Kelas");
    System.out.println("4. Hapus Jenis Kelas");
    System.out.println("5. Kembali");
    System.out.println("========================================");
}

    public void tampilkanPilihanJenisKelas() {
        System.out.println("\nPilih Jenis Kelas DIbawah");
        System.out.println("1. Kelas Private");
        System.out.println("2. Kelas Publik");
        System.out.println("----------------------------------------");
    }

    public void tampilkanHeaderTambah() {
        System.out.println("\n========================================");
        System.out.println("          TAMBAH JENIS KELAS");
        System.out.println("========================================");
    }

    public void tampilkanHeaderDaftar() {
        System.out.println("\n========================================");
        System.out.println("          DAFTAR JENIS KELAS");
        System.out.println("========================================");
    }
    
    public void tampilkanHeaderUpdate() {

    System.out.println("\n========================================");
    System.out.println("      UPDATE STATUS JENIS KELAS");
    System.out.println("========================================");
    }
    
    public void tampilkanHeaderHapus() {

    System.out.println("\n========================================");
    System.out.println("          HAPUS JENIS KELAS");
    System.out.println("========================================");
    }

    public void tampilkanPesanBerhasil() {
        System.out.println(
            ">> Kelas Pilates Berhasil Ditambahkan ^,^!"
        );
    }

    public void tampilkanPesanKembali() {
        System.out.println(">> Kembali ke menu utama...");
    }
}