
package model;

public class Member {
    private int idMember;
    private String namaMember;
    private String noTelepon;
    private int usia;
    private String jenisKelamin;
    private String status;

    public Member() {
    }

    public Member(int idMember, String namaMember,
                  String noTelepon, int usia,
                  String jenisKelamin, String status) {
        this.idMember = idMember;
        this.namaMember = namaMember;
        this.noTelepon = noTelepon;
        this.usia = usia;
        this.jenisKelamin = jenisKelamin;
        this.status = status;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public String getNamaMember() {
        return namaMember;
    }

    public void setNamaMember(String namaMember) {
        this.namaMember = namaMember;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
