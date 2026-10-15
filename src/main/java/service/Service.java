
package Service;

import java.sql.SQLException;
import java.util.Scanner;

import model.Member;
import model.MemberDAO;
import model.Instruktur;
import model.InstrukturDAO;
import model.JenisKelas;
import model.JenisKelasDAO;
import model.JenisKelasPrivate;
import model.JenisKelasPublik;
import model.KelasPilates;
import model.KelasPilatesDAO;

public class Service {

    private Scanner scanner;
    private InputValidator validator;

    private MemberDAO memberDAO;
    private InstrukturDAO instrukturDAO;
    private JenisKelasDAO jenisKelasDAO;
    private KelasPilatesDAO kelasPilatesDAO;

    public Service(Scanner scanner) {
        this.scanner = scanner;
        this.validator = new InputValidator(scanner);

        this.memberDAO = new MemberDAO();
        this.instrukturDAO = new InstrukturDAO();
        this.jenisKelasDAO = new JenisKelasDAO();
        this.kelasPilatesDAO = new KelasPilatesDAO();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public InputValidator getValidator() {
        return validator;
    }

    // ==================== MEMBER ====================

    public void tambahMember() {
        try {
            int id;

            while (true) {
                id = validator.inputInteger("ID Member: ");

                if (id <= 0) {
                    System.out.println("ID harus lebih dari 0!");
                } else if (memberDAO.existsById(id)) {
                    System.out.println(
                        ">> ID Member sudah digunakan, masukkan ID baru yaa!"
                    );
                } else {
                    break;
                }
            }

            String nama = validator.inputString("Nama: ");
            String telepon = validator.inputNoTelepon("No Telepon: ");
            int usia = validator.inputUsia("Usia: ");
            String jk = validator.inputJenisKelamin();
            String status = validator.inputStatusAktif();

            Member member = new Member(
                id, nama, telepon, usia, jk, status
            );

            if (memberDAO.insert(member)) {
                System.out.println(
                    ">> Selamat Bergabung, GeetsMates ^'^!"
                );
            }

        } catch (SQLException e) {
    System.out.println("Maaf, member gagal disimpan yaa huhu: " + e.getMessage());
}
    }

    public void lihatMember() {
        try {
            final boolean[] ada = {false};

            memberDAO.forEach(m -> {
                ada[0] = true;

                System.out.println("--------------------------------");
                System.out.println("ID Member      : " + m.getIdMember());
                System.out.println("Nama Member    : " + m.getNamaMember());
                System.out.println("No Telepon     : " + m.getNoTelepon());
                System.out.println("Usia           : " + m.getUsia());
                System.out.println("Jenis Kelamin  : " + m.getJenisKelamin());
                System.out.println("Status         : " + m.getStatus());
            });

            if (!ada[0]) {
                System.out.println("Belum ada data member yaa GeetsMates.");
            }

            System.out.println("--------------------------------");

        } catch (SQLException e) {
    System.out.println("Maaf, member gagal disimpan yaa huhu: " + e.getMessage());
}
    }

    public void updateStatusMember() {
        lihatMember();

        try {
            int id = validator.inputInteger("Masukkan ID Member: ");
            Member member = memberDAO.findById(id);

            if (member == null) {
                System.out.println("Member tidak ditemukan yaa GeetsMates!");
                return;
            }

            System.out.println("Status saat ini: " + member.getStatus());

            String status = validator.inputStatusAktif();

            if (memberDAO.updateStatus(id, status)) {
                System.out.println(">> Status member berhasil diperbarui GeetsMates!");
            } else {
                System.out.println("Ooopss Status member gagal diperbarui.");
            }

} catch (SQLException e) {
    System.out.println("Gagal membaca member: " + e.getMessage());
}
    }

    public void hapusMember() {
        lihatMember();

        try {
            int id = validator.inputInteger(
                "Masukkan ID Member yang ingin dihapus: "
            );

            Member member = memberDAO.findById(id);

            if (member == null) {
                System.out.println("Member tidak ditemukan!");
                return;
            }

            if (memberDAO.isUsedInKelas(id)) {
                System.out.println(
                    "Member tidak dapat dihapus karena masih terdaftar dalam kelas!"
                );
                return;
            }

            if (memberDAO.delete(id)) {
                System.out.println(">> Oopss, Sampai Jumpa Lagi, GeetsMates!");
            } else {
                System.out.println("Member gagal dihapus.");
            }

        } catch (SQLException e) {
    System.out.println("Gagal menghapus member: " + e.getMessage());
}
    }

  

    public void tambahInstruktur() {
        try {
            int id;

            while (true) {
                id = validator.inputInteger("ID Instruktur: ");

                if (id <= 0) {
                    System.out.println("ID harus lebih dari 0!");
                } else if (instrukturDAO.existsById(id)) {
                    System.out.println(
                        ">> ID Instruktur sudah digunakan, masukkan ID baru!"
                    );
                } else {
                    break;
                }
            }

            String nama = validator.inputString("Nama: ");
            String spesialisasi = validator.inputString("Spesialisasi: ");
            String telepon = validator.inputNoTelepon("No Telepon: ");
            String jk = validator.inputJenisKelamin();
            String domisili = validator.inputString("Domisili: ");
            String status = validator.inputStatusAktif();

            Instruktur instruktur = new Instruktur(
                id, nama, spesialisasi, telepon, jk, domisili, status
            );

            if (instrukturDAO.insert(instruktur)) {
                System.out.println(
                    ">> Selamat Bergabung, Instruktur GeetsMates! ^'^"
                );
            }

        } catch (SQLException e) {
            System.out.println("Gagal menyimpan instruktur: " + e.getMessage());
        }
    }

    public void lihatInstruktur() {
        try {
            final boolean[] ada = {false};

            instrukturDAO.forEach(i -> {
                ada[0] = true;

                System.out.println("--------------------------------");
                System.out.println("ID Instruktur : " + i.getIdInstruktur());
                System.out.println("Nama          : " + i.getNamaInstruktur());
                System.out.println("Spesialisasi  : " + i.getSpesialisasi());
                System.out.println("No Telepon    : " + i.getNoTelepon());
                System.out.println("Jenis Kelamin : " + i.getJenisKelamin());
                System.out.println("Domisili      : " + i.getDomisili());
                System.out.println("Status        : " + i.getStatus());
            });

            if (!ada[0]) {
                System.out.println("Belum ada data instruktur.");
            }

            System.out.println("--------------------------------");

        } catch (SQLException e) {
            System.out.println("Gagal membaca instruktur: " + e.getMessage());
        }
    }

    public void lihatInstruktur(String spesialisasi) {
        System.out.println("===========================================");
        System.out.println("     INSTRUKTUR " + spesialisasi.toUpperCase());
        System.out.println("===========================================");

        try {
            final boolean[] ditemukan = {false};

            instrukturDAO.forEach(i -> {
                if (i.getSpesialisasi() != null
                        && i.getSpesialisasi().equalsIgnoreCase(spesialisasi)) {

                    ditemukan[0] = true;

                    System.out.println("ID Instruktur : " + i.getIdInstruktur());
                    System.out.println("Nama          : " + i.getNamaInstruktur());
                    System.out.println("Spesialisasi  : " + i.getSpesialisasi());
                    System.out.println("No Telepon    : " + i.getNoTelepon());
                    System.out.println("Jenis Kelamin : " + i.getJenisKelamin());
                    System.out.println("Domisili      : " + i.getDomisili());
                    System.out.println("Status        : " + i.getStatus());
                    System.out.println("--------------------------------");
                }
            });

            if (!ditemukan[0]) {
                System.out.println(
                    "Instruktur dengan spesialisasi tersebut belum terdaftar yaaa GeetsMates."
                );
            }

        } catch (SQLException e) {
            System.out.println("Gagal membaca instruktur: " + e.getMessage());
        }
    }

    public void updateStatusInstruktur() {
        lihatInstruktur();

        try {
            int id = validator.inputInteger("Masukkan ID Instruktur: ");
            Instruktur instruktur = instrukturDAO.findById(id);

            if (instruktur == null) {
                System.out.println(" Ooppss Instruktur tidak ditemukan!");
                return;
            }

            System.out.println("Status saat ini: " + instruktur.getStatus());

            String status = validator.inputStatusAktif();

            if (instrukturDAO.updateStatus(id, status)) {
                System.out.println(">> Status instruktur berhasil diperbarui!");
            } else {
                System.out.println("Ooopss Status instruktur gagal diperbarui.");
            }

        } catch (SQLException e) {
            System.out.println("Gagal memperbarui instruktur: " + e.getMessage());
        }
    }

    public void hapusInstruktur() {
        lihatInstruktur();

        try {
            int id = validator.inputInteger(
                "Masukkan ID Instruktur yang ingin dihapus: "
            );

            if (instrukturDAO.findById(id) == null) {
                System.out.println("Instruktur tidak ditemukan!");
                return;
            }

            if (instrukturDAO.isUsedInKelas(id)) {
                System.out.println(
                    "Instruktur tidak dapat dihapus karena masih terdaftar dalam kelas!"
                );
                return;
            }

            if (instrukturDAO.delete(id)) {
                System.out.println(">> Instruktur berhasil dihapus. Sampai jumpa lagii.");
            } else {
                System.out.println("Instruktur gagal dihapus.");
            }

        } catch (SQLException e) {
            System.out.println("Gagal menghapus instruktur: " + e.getMessage());
        }
    }

  

    public void tambahJenisKelas() {
        try {
            int pilihan = validator.inputPilihan(
                "Pilih jenis kelas (1. Private, 2. Publik): ", 1, 2
            );

            int id;

            while (true) {
                id = validator.inputInteger("ID Jenis: ");

                if (id <= 0) {
                    System.out.println("ID harus lebih dari 0!");
                } else if (jenisKelasDAO.existsById(id)) {
                    System.out.println(
                        ">> ID Jenis Kelas sudah digunakan, masukkan ID baru!"
                    );
                } else {
                    break;
                }
            }

            String nama = validator.inputString("Nama Pilates: ");

            String level;
            while (true) {
                level = validator.inputString(
                    "Level (Beginner/Intermediate/Advanced): "
                );

                if (level.equalsIgnoreCase("Beginner")) {
                    level = "Beginner";
                    break;
                } else if (level.equalsIgnoreCase("Intermediate")) {
                    level = "Intermediate";
                    break;
                } else if (level.equalsIgnoreCase("Advanced")) {
                    level = "Advanced";
                    break;
                }

                System.out.println(
                    "Level harus Beginner, Intermediate, atau Advanced!"
                );
            }

            String durasi = validator.inputString("Durasi: ");
            String status = validator.inputStatusJenisKelas();

            boolean berhasil;

            if (pilihan == 1) {
                String sesi = validator.inputString("Jenis Sesi: ");

                JenisKelasPrivate jenis = new JenisKelasPrivate(
                    id, nama, level, durasi, sesi, status
                );

                berhasil = jenisKelasDAO.insertPrivate(jenis);

            } else {
                int kapasitas = validator.inputKapasitas("Kapasitas: ");

                JenisKelasPublik jenis = new JenisKelasPublik(
                    id, nama, level, durasi, kapasitas, status
                );

                berhasil = jenisKelasDAO.insertPublik(jenis);
            }

            if (berhasil) {
                System.out.println(">> Yaaayy Kelas Pilates berhasil ditambahkan!");
            }

        } catch (SQLException e) {
            System.out.println("Gagal menyimpan jenis kelas: " + e.getMessage());
        }
    }

    public void lihatJenisKelas() {
        try {
            final boolean[] ada = {false};

            jenisKelasDAO.forEach(jenis -> {
                ada[0] = true;
                System.out.println("--------------------------------");
                System.out.println("ID Jenis: " + jenis.getIdJenis());
                jenis.tampilkanInfo();
            });

            if (!ada[0]) {
                System.out.println(">> Belum ada data jenis kelas Pilates.");
            }

            System.out.println("--------------------------------");

        } catch (SQLException e) {
            System.out.println("Gagal membaca jenis kelas: " + e.getMessage());
        }
    }

    public void updateStatusJenisKelas() {
        lihatJenisKelas();

        try {
            int id = validator.inputInteger("Masukkan ID Jenis Kelas: ");
            JenisKelas jenis = jenisKelasDAO.findById(id);

            if (jenis == null) {
                System.out.println("Jenis kelas tidak ditemukan!");
                return;
            }

            System.out.println("Status saat ini: " + jenis.getStatus());

            String status = validator.inputStatusJenisKelas();

            if (jenisKelasDAO.updateStatus(id, status)) {
                System.out.println(">> Status jenis kelas berhasil diperbarui!");
            } else {
                System.out.println("Status jenis kelas gagal diperbarui.");
            }

        } catch (SQLException e) {
            System.out.println("Gagal memperbarui jenis kelas: " + e.getMessage());
        }
    }

    public void hapusJenisKelas() {
        lihatJenisKelas();

        try {
            int id = validator.inputInteger(
                "Masukkan ID Jenis Kelas yang ingin dihapus: "
            );

            if (jenisKelasDAO.findById(id) == null) {
                System.out.println("Jenis kelas tidak ditemukan!");
                return;
            }

            if (jenisKelasDAO.isUsedInKelas(id)) {
                System.out.println(
                    "Jenis kelas tidak dapat dihapus karena masih digunakan dalam kelas Pilates!"
                );
                return;
            }

            if (jenisKelasDAO.delete(id)) {
                System.out.println(">> Jenis kelas berhasil dihapus!");
            } else {
                System.out.println("Jenis kelas gagal dihapus.");
            }

        } catch (SQLException e) {
            System.out.println("Gagal menghapus jenis kelas: " + e.getMessage());
        }
    }



    public void lihatPendaftarKelas() {
        try {
            final boolean[] ada = {false};

            kelasPilatesDAO.forEach(kelas -> {
                ada[0] = true;

                String namaMember = "Tidak ditemukan";
                String namaInstruktur = "Tidak ditemukan";
                String namaJenis = "Tidak ditemukan";

                try {
                    Member member = memberDAO.findById(kelas.getIdMember());
                    Instruktur instruktur =
                        instrukturDAO.findById(kelas.getIdInstruktur());
                    JenisKelas jenis =
                        jenisKelasDAO.findById(kelas.getIdJenis());

                    if (member != null) {
                        namaMember = member.getNamaMember();
                    }

                    if (instruktur != null) {
                        namaInstruktur = instruktur.getNamaInstruktur();
                    }

                    if (jenis != null) {
                        namaJenis = jenis.getNamaJenis();
                    }

                } catch (SQLException e) {
                    System.out.println(
                        "Gagal membaca detail pendaftar: " + e.getMessage()
                    );
                }

                System.out.println("--------------------------------");
                System.out.println("ID Kelas        : " + kelas.getIdKelas());
                System.out.println("Nama Member     : " + namaMember);
                System.out.println("Nama Instruktur : " + namaInstruktur);
                System.out.println("Jenis Pilates   : " + namaJenis);
                System.out.println("Tanggal         : " + kelas.getTanggal());
                System.out.println("Waktu           : " + kelas.getWaktu());
                System.out.println("Status          : " + kelas.getStatus());
            });

            if (!ada[0]) {
                System.out.println(">> Belum ada pendaftar kelas Pilates.");
            }

            System.out.println("--------------------------------");

        } catch (SQLException e) {
            System.out.println("Gagal membaca pendaftar kelas: " + e.getMessage());
        }
    }

    public void tambahKelas() {
        try {
            final boolean[] adaMember = {false};
            memberDAO.forEach(m -> adaMember[0] = true);

            if (!adaMember[0]) {
                System.out.println(">> Belum ada data member!");
                return;
            }

            final boolean[] adaInstruktur = {false};
            instrukturDAO.forEach(i -> adaInstruktur[0] = true);

            if (!adaInstruktur[0]) {
                System.out.println(">> Belum ada data instruktur!");
                return;
            }

            final boolean[] adaJenis = {false};
            jenisKelasDAO.forEach(j -> adaJenis[0] = true);

            if (!adaJenis[0]) {
                System.out.println(">> Belum ada data jenis kelas!");
                return;
            }

            System.out.println("\nDaftar Member:");
            lihatMember();

            Member memberDipilih = null;

            while (memberDipilih == null) {
                int id = validator.inputInteger("Pilih ID Member: ");
                Member member = memberDAO.findById(id);

                if (member == null) {
                    System.out.println("ID Member tidak ditemukan!");
                } else if (!"Aktif".equalsIgnoreCase(member.getStatus())) {
                    System.out.println("Member tidak aktif dan tidak dapat mendaftar!");
                } else {
                    memberDipilih = member;
                }
            }

            System.out.println("\nDaftar Jenis Kelas:");
            lihatJenisKelas();

            JenisKelas jenisDipilih = null;

            while (jenisDipilih == null) {
                int id = validator.inputInteger("Pilih ID Jenis: ");
                JenisKelas jenis = jenisKelasDAO.findById(id);

                if (jenis == null) {
                    System.out.println("ID Jenis Kelas tidak ditemukan!");
                } else if (!"Tersedia".equalsIgnoreCase(jenis.getStatus())) {
                    System.out.println("Jenis kelas sedang tidak tersedia!");
                } else {
                    jenisDipilih = jenis;
                }
            }

            System.out.println("\nDaftar Instruktur:");
            lihatInstruktur();

            Instruktur instrukturDipilih = null;

            while (instrukturDipilih == null) {
                int id = validator.inputInteger("Pilih ID Instruktur: ");
                Instruktur instruktur = instrukturDAO.findById(id);

                if (instruktur == null) {
                    System.out.println("ID Instruktur tidak ditemukan!");
                } else if (!"Aktif".equalsIgnoreCase(instruktur.getStatus())) {
                    System.out.println("Instruktur sedang tidak aktif!");
                } else {
                    instrukturDipilih = instruktur;
                }
            }

            int idKelas;

            while (true) {
                idKelas = validator.inputInteger("ID Kelas: ");

                if (idKelas <= 0) {
                    System.out.println("ID Kelas harus lebih dari 0!");
                } else if (kelasPilatesDAO.existsById(idKelas)) {
                    System.out.println("ID Kelas sudah digunakan, masukkan ID baru!");
                } else {
                    break;
                }
            }

            String tanggal = validator.inputString("Tanggal (YYYY-MM-DD): ");
            String waktu = validator.inputString(
                "Waktu (YYYY-MM-DD HH:MM:SS): "
            );
            String status = validator.inputStatus();
            
            
            

            KelasPilates kelas = new KelasPilates(
                idKelas,
                memberDipilih.getIdMember(),
                instrukturDipilih.getIdInstruktur(),
                jenisDipilih.getIdJenis(),
                tanggal,
                waktu,
                status
            );

            if (kelasPilatesDAO.insert(kelas)) {
                System.out.println(">> Selamat Mengikuti Kelas, GeetsMates!");

                if ("Aktif".equalsIgnoreCase(status)) {
                    kelas.cetakStruk(
                        memberDipilih.getNamaMember(),
                        instrukturDipilih.getNamaInstruktur(),
                        jenisDipilih.getNamaJenis()
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Gagal menambahkan kelas: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(
                "Format tanggal atau waktu tidak valid. "
                + "Silakan gunakan format YYYY-MM-DD dan YYYY-MM-DD HH:MM:SS."
            );
        }
    }

    public void hapusDaftarKelas() {
        lihatPendaftarKelas();

        try {
            int id = validator.inputInteger(
                "Masukkan ID Kelas yang ingin dihapus: "
            );

            if (kelasPilatesDAO.findById(id) == null) {
                System.out.println(">> ID Kelas tidak ditemukan!");
                return;
            }

            if (kelasPilatesDAO.delete(id)) {
                System.out.println(">> Sampai Ketemu Lagi, GeetsMates!");
            } else {
                System.out.println("Oooppss Kelas gagal dihapus.");
            }

        } catch (SQLException e) {
            System.out.println("Gagal menghapus pendaftaran: " + e.getMessage());
        }
    }

    public void updateKelas() {
        lihatPendaftarKelas();

        try {
            int id = validator.inputInteger(
                "Masukkan ID Kelas yang ingin diupdate: "
            );

            KelasPilates kelas = kelasPilatesDAO.findById(id);

            if (kelas == null) {
                System.out.println(">> ID Kelas tidak ditemukan!");
                return;
            }

            System.out.println("Status saat ini: " + kelas.getStatus());

            String statusBaru = validator.inputStatus();

            if (kelasPilatesDAO.updateStatus(id, statusBaru)) {
                System.out.println(">> Status kelas berhasil diperbarui!");
                System.out.println(">> Status baru: " + statusBaru);

                if ("Aktif".equalsIgnoreCase(statusBaru)) {
                    Member member = memberDAO.findById(kelas.getIdMember());
                    Instruktur instruktur =
                        instrukturDAO.findById(kelas.getIdInstruktur());
                    JenisKelas jenis =
                        jenisKelasDAO.findById(kelas.getIdJenis());

                    if (member != null && instruktur != null && jenis != null) {
                        kelas.cetakStruk(
                            member.getNamaMember(),
                            instruktur.getNamaInstruktur(),
                            jenis.getNamaJenis()
                        );
                    }
                } else {
                    System.out.println(">> Struk tidak dicetak.");
                }
            } else {
                System.out.println("Status kelas gagal diperbarui.");
            }

        } catch (SQLException e) {
            System.out.println("Gagal memperbarui kelas: " + e.getMessage());
        }
    }
}
