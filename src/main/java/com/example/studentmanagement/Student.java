package com.example.studentmanagement;

public class Student {
    private String nim;
    private String nama;
    private String tanggalLahir;
    private String alamat;

    // Constructor kosong (wajib untuk Spring)
    public Student() {}

    // Constructor lengkap (optional)
    public Student(String nim, String nama, String tanggalLahir, String alamat) {
        this.nim = nim;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.alamat = alamat;
    }

    // Getter dan Setter
    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
