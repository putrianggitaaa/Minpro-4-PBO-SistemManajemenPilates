package view;

public class KelasPilatesView {

    public void tampilkanMenu() {
        System.out.println("\n========================================");
        System.out.println("            MENU KELAS PILATES");
        System.out.println("========================================");
        System.out.println("1. Daftar Kelas");
        System.out.println("2. Lihat Pendaftar Kelas");
        System.out.println("3. Update Status Kelas");
        System.out.println("4. Hapus Daftar Kelas");
        System.out.println("5. Kembali");
        System.out.println("----------------------------------------");
        
    }

    public void tampilkanHeaderTambah() {
        System.out.println("\n========================================");
        System.out.println("            DAFTAR KELAS PILATES");
        System.out.println("========================================");
    }

    public void tampilkanHeaderPendaftar() {
        System.out.println("\n========================================");
        System.out.println("         DAFTAR PENDAFTAR KELAS");
        System.out.println("========================================");
    }

    public void tampilkanPesanBerhasil() {
        System.out.println(
            "\n>> Selamat Mengikuti Kelas, GeetsMates!"
        );
    }

    public void tampilkanPesanUpdate() {
        System.out.println(
            ">> Status kelas berhasil diperbarui!"
        );
    }

    public void tampilkanPesanHapus() {
        System.out.println(
            ">> Sampai Ketemu Lagi, GeetsMates!"
        );
    }

    public void tampilkanPesanTidakDitemukan() {
        System.out.println(
            ">> ID Kelas tidak ditemukan!"
        );
    }

    public void tampilkanPesanKembali() {
        System.out.println(">> Kembali ke menu utama...");
    }
}