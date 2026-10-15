package Service;

import java.util.Scanner;
import java.util.InputMismatchException;

public class InputValidator {

    private Scanner scanner;
    private final int maksimal_kapasitas = 25;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }


    public int inputInteger(String pesan) {

    while (true) {
        try {
            System.out.print(pesan);

            int angka = scanner.nextInt();
            scanner.nextLine();

            return angka;

        } catch (InputMismatchException e) {System.out.println(">> Input harus berupa angka yaa, GeetsMates!");
            scanner.nextLine();
        }
    }
}


    public String inputString(String pesan) {

        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine();

            if (!input.trim().isEmpty()) {
                return input;
            }

            System.out.println(">> Input tidak boleh kosong ya, GeetsMates!");
        }
    }


    public int inputPilihan(String pesan, int min, int max) {

        while (true) {
            int pilihan = inputInteger(pesan);

            if (pilihan >= min && pilihan <= max) {
                return pilihan;
            }

            System.out.println(
                ">> Pilihan harus antara " + min + " - " + max + "!");
        }
    }


    public String inputStatus() {

        System.out.println("\nPilih Status:");
        System.out.println("1. Terjadwal");
        System.out.println("2. Selesai");
        System.out.println("3. Batal");

        int pilihan = inputPilihan("Pilih status: ", 1, 3);

        switch (pilihan) {
            case 1:
                return "Terjadwal";
            case 2:
                return "Selesai";
            case 3:
                return "Batal";
            default:
                return "Terjadwal";
        }
    }
    
    public String inputNoTelepon(String pesan) {
        while (true) {
            System.out.print(pesan);
            String noTelepon = scanner.nextLine();

            if (noTelepon.length() >= 10 && noTelepon.length() <= 12) {
                return noTelepon;
        }

            System.out.println(">> Nomor telepon harus 10 - 12 digit ya, GeetsMates!");
    }
}
    
    
    public int inputUsia(String pesan) {
    while (true) {
        int usia = inputInteger(pesan);

        if (usia >= 1 && usia <= 100) {
            return usia;
        }

        System.out.println(">> Usia harus berada antara 1 - 100 tahun!");
    }
}
    public int inputKapasitas(String pesan) {
        while (true) {
            int kapasitas = inputInteger(pesan);

            if (kapasitas > 0 && kapasitas <= maksimal_kapasitas) {
                return kapasitas;
            }

            System.out.println(">> Kapasitas harus berada antara 1 - "+ maksimal_kapasitas + " orang!");
        }
    }

    
    public String inputJenisKelamin() {
    System.out.println("\nPilih Jenis Kelamin:");
    System.out.println("1. Laki-laki");
    System.out.println("2. Perempuan");

    int pilihan = inputPilihan("Pilih jenis kelamin: ", 1, 2);

    if (pilihan == 1) {
        return "Laki-laki";
    } else {
        return "Perempuan";
    }
}
    
    public String inputStatusAktif() {

    System.out.println("\nPilih Status:");
    System.out.println("1. Aktif");
    System.out.println("2. Nonaktif");

    int pilihan = inputPilihan(
        "Pilih status: ", 1, 2
    );

    if (pilihan == 1) {
        return "Aktif";
    } else {
        return "Nonaktif";
    }
}
    
    public String inputStatusJenisKelas() {

    System.out.println("\nPilih Status:");
    System.out.println("1. Tersedia");
    System.out.println("2. Tidak Tersedia");

    int pilihan = inputPilihan(
        "Pilih status: ", 1, 2
    );

    if (pilihan == 1) {
        return "Tersedia";
    } else {
        return "Tidak Tersedia";
    }
}
   
}

