package view;

public class MemberView {

    public void tampilkanMenu() {

    System.out.println("\n================================");
    System.out.println("       MENU MEMBER");
    System.out.println("================================");
    System.out.println("1. Tambah Member");
    System.out.println("2. Lihat Member");
    System.out.println("3. Update Status Member");
    System.out.println("4. Hapus Member");
    System.out.println("5. Kembali");
    System.out.println("================================");
}

    public void tampilkanHeaderTambah() {
        System.out.println("\n========================================");
        System.out.println("             TAMBAH MEMBER");
        System.out.println("========================================");
    }

    public void tampilkanHeaderDaftar() {
        System.out.println("\n========================================");
        System.out.println("             DAFTAR MEMBER");
        System.out.println("========================================");
    }
    
    public void tampilkanHeaderUpdate() {
    System.out.println("\n================================");
    System.out.println("       UPDATE STATUS MEMBER");
    System.out.println("================================");
    }
    
    public void tampilkanHeaderHapus() {
    System.out.println("\n================================");
    System.out.println("          HAPUS MEMBER");
    System.out.println("================================");
    }

    public void tampilkanPesanBerhasil() {
        System.out.println(">> Selamat Bergabung, GeetsMates ^'^!");
    }

    public void tampilkanPesanKembali() {
        System.out.println(">> Kembali ke menu utama...");
    }
}