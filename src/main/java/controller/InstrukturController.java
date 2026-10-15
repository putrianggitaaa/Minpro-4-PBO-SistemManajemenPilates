package controller;

import Service.Service;
import view.InstrukturView;

public class InstrukturController {

    private Service service;
    private InstrukturView view;

    public InstrukturController(Service service, InstrukturView view) {
        this.service = service;
        this.view = view;
    }

    public void jalankanMenu() {

        boolean kembali = false;

        while (!kembali) {

            view.tampilkanMenu();

            int pilihan = service.getValidator().inputPilihan(
                "Pilih menu: ", 1, 6
            );

            switch (pilihan) {

                case 1:
                    tambahInstruktur();
                    break;

                case 2:
                    lihatInstruktur();
                    break;

                case 3:
                    lihatInstrukturBerdasarkanSpesialisasi();
                    break;

                case 4:
                    updateInstruktur();
                    break;

                case 5:
                    hapusInstruktur();
                    break;

                case 6:
                    kembali = true;
                    view.tampilkanPesanKembali();
                    break;
            }
        }
    }

    public void tambahInstruktur() {
        view.tampilkanHeaderTambah();
        service.tambahInstruktur();
    }

    public void lihatInstruktur() {
        view.tampilkanHeaderDaftar();
        service.lihatInstruktur();
    }
    
    public void lihatInstrukturBerdasarkanSpesialisasi() {
        view.tampilkanHeaderSpesialisasi();

        String spesialisasi = service.getValidator().inputString(
            "Masukkan spesialisasi: "
        );

        service.lihatInstruktur(spesialisasi);
    }

    public void updateInstruktur() {
        view.tampilkanHeaderUpdate();
        service.updateStatusInstruktur();
    }

    public void hapusInstruktur() {
        view.tampilkanHeaderHapus();
        service.hapusInstruktur();
    }
}