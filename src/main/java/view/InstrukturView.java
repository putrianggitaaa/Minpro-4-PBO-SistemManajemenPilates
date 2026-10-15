package view;

public class InstrukturView {

    public void tampilkanMenu() {

    System.out.println("\n========================================");
    System.out.println("          MENU INSTRUKTUR");
    System.out.println("========================================");
    System.out.println("1. Tambah Instruktur");
    System.out.println("2. Lihat Semua Instruktur");
    System.out.println("3. Lihat Berdasarkan Spesialisasi");
    System.out.println("4. Update Status Instruktur");
    System.out.println("5. Hapus Instruktur");
    System.out.println("6. Kembali");
    System.out.println("========================================");
}

    public void tampilkanHeaderTambah() {
        System.out.println("\n========================================");
        System.out.println("           TAMBAH INSTRUKTUR");
        System.out.println("========================================");
    }

    public void tampilkanHeaderDaftar() {
        System.out.println("\n========================================");
        System.out.println("           DAFTAR INSTRUKTUR");
        System.out.println("========================================");
    }
    
        public void tampilkanHeaderSpesialisasi() {
        System.out.println("\n========================================");
        System.out.println("    ^ Cari Instruktur Favorit Kamu!      ");
        System.out.println("========================================");
    }
    
    public void tampilkanHeaderUpdate() {

    System.out.println("\n========================================");
    System.out.println("       UPDATE STATUS INSTRUKTUR");
    System.out.println("========================================");
    }
    
    public void tampilkanHeaderHapus() {

    System.out.println("\n========================================");
    System.out.println("           HAPUS INSTRUKTUR");
    System.out.println("========================================");
    }
    

    public void tampilkanPesanBerhasil() {
        System.out.println(
            ">> Selamat Bergabung, Instruktur GeetsMates! ^'^"
        );
    }

    public void tampilkanPesanKembali() {
        System.out.println(">> Kembali ke menu utama...");
    }
}