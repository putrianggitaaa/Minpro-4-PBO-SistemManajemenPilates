package controller;

import Service.Service;
import view.MemberView;

public class MemberController {

    private Service service;
    private MemberView view;

    public MemberController(Service service, MemberView view) {
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
                tambahMember();
                break;

            case 2:
                lihatMember();
                break;

            case 3:
                updateMember();
                break;

            case 4:
                hapusMember();
                break;

            case 5:
                kembali = true;
                view.tampilkanPesanKembali();
                break;
        }
    }
}

    public void tambahMember() {
        view.tampilkanHeaderTambah();
        service.tambahMember();
    }

    public void lihatMember() {
        view.tampilkanHeaderDaftar();
        service.lihatMember();
    }
    
    public void updateMember() {
    view.tampilkanHeaderUpdate();
    service.updateStatusMember();
}

public void hapusMember() {
    view.tampilkanHeaderHapus();
    service.hapusMember();
}
}