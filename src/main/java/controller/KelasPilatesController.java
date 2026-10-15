package controller;

import Service.Service;
import view.KelasPilatesView;

public class KelasPilatesController {

    private Service service;
    private KelasPilatesView view;

    public KelasPilatesController(
            Service service,
            KelasPilatesView view) {

        this.service = service;
        this.view = view;
    }

    public void jalankanMenu() {

        boolean kembali = false;

        while (!kembali) {

            view.tampilkanMenu();

            int pilihan = service.getValidator().inputPilihan(
    "Pilih menu: ", 1, 5
);

            switch (pilihan) {

                case 1:
                    tambahKelas();
                    break;

                case 2:
                    lihatKelas();
                    break;

                case 3:
                    updateKelas();
                    break;

                case 4:
                    hapusKelas();
                    break;

                case 5:
                    kembali = true;
                    view.tampilkanPesanKembali();
                    break;

                default:
                    System.out.println(
                        ">> Pilihan tidak tersedia!"
                    );
            }
        }
    }

    public void tambahKelas() {
        view.tampilkanHeaderTambah();
        service.tambahKelas();
    }

    public void lihatKelas() {
        view.tampilkanHeaderPendaftar();
        service.lihatPendaftarKelas();
    }

    public void updateKelas() {
        service.updateKelas();
    }

    public void hapusKelas() {
        service.hapusDaftarKelas();
    }
}