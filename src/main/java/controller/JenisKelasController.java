package controller;

import Service.Service;
import view.JenisKelasView;

public class JenisKelasController {

    private Service service;
    private JenisKelasView view;

    public JenisKelasController(Service service, JenisKelasView view) {
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
                    tambahJenisKelas();
                    break;

                case 2:
                    lihatJenisKelas();
                    break;

                case 3:
                    updateJenisKelas();
                    break;

                case 4:
                    hapusJenisKelas();
                    break;

                case 5:
                    kembali = true;
                    view.tampilkanPesanKembali();
                    break;
            }
        }
    }

    public void tambahJenisKelas() {
        view.tampilkanHeaderTambah();
        service.tambahJenisKelas();
    }

    public void lihatJenisKelas() {
        view.tampilkanHeaderDaftar();
        service.lihatJenisKelas();
    }

    public void updateJenisKelas() {
        view.tampilkanHeaderUpdate();
        service.updateStatusJenisKelas();
    }

    public void hapusJenisKelas() {
        view.tampilkanHeaderHapus();
        service.hapusJenisKelas();
    }
}