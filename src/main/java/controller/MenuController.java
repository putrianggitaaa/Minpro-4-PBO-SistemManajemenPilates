package controller;

import java.util.Scanner;

import Service.Service;
import view.MenuView;
import view.MemberView;
import view.InstrukturView;
import view.JenisKelasView;
import view.KelasPilatesView;

public class MenuController {

    private Service service;
    private MenuView view;

    private MemberController memberController;
    private InstrukturController instrukturController;
    private JenisKelasController jenisKelasController;
    private KelasPilatesController kelasPilatesController;

    private Scanner scanner;

    public MenuController(Service service, Scanner scanner) {

        this.service = service;
        this.scanner = scanner;

        this.view = new MenuView();

        this.memberController =
                new MemberController(
                        service,
                        new MemberView()
                );

        this.instrukturController =
                new InstrukturController(
                        service,
                        new InstrukturView()
                );

        this.jenisKelasController =
                new JenisKelasController(
                        service,
                        new JenisKelasView()
                );

        this.kelasPilatesController =
                new KelasPilatesController(
                        service,
                        new KelasPilatesView()
                );
    }

    public void jalankanProgram() {

        boolean berjalan = true;


        while (berjalan) {

            view.tampilkanMenuUtama();

            int pilihan = service.getValidator().inputPilihan(
            "Pilih Menu: ", 1, 5);
            
            switch (pilihan) {

                case 1:
                    memberController.jalankanMenu();
                    break;

                case 2:
                    instrukturController.jalankanMenu();
                    break;

                case 3:
                    jenisKelasController.jalankanMenu();
                    break;

                case 4:
                    kelasPilatesController.jalankanMenu();
                    break;

                case 5:
                    view.tampilkanPesanKeluar();
                    berjalan = false;
                    break;

                default:
                    System.out.println(
                        ">> Pilihan tidak tersedia!"
                    );
            }
        }
    }
}