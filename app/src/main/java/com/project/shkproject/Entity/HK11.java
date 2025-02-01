package com.project.shkproject.Entity;

public class HK11 {
    private int id;
    private String responden;
    private Long kode_kualitas;
    private String komoditas;
    private String kualitas;
    private int harga_sebelum;
    private int harga_sesudah;

    public HK11() {
    }

    public HK11(int id, String responden, Long kode_kualitas, String komoditas, String kualitas, int harga_sebelum, int harga_sesudah) {
        this.id = id;
        this.responden = responden;
        this.kode_kualitas = kode_kualitas;
        this.komoditas = komoditas;
        this.kualitas = kualitas;
        this.harga_sebelum = harga_sebelum;
        this.harga_sesudah = harga_sesudah;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponden() {
        return responden;
    }

    public void setResponden(String responden) {
        this.responden = responden;
    }

    public Long getKode_kualitas() {
        return kode_kualitas;
    }

    public void setKode_kualitas(Long kode_kualitas) {
        this.kode_kualitas = kode_kualitas;
    }

    public String getKomoditas() {
        return komoditas;
    }

    public void setKomoditas(String komoditas) {
        this.komoditas = komoditas;
    }

    public String getKualitas() {
        return kualitas;
    }

    public void setKualitas(String kualitas) {
        this.kualitas = kualitas;
    }

    public int getHarga_sebelum() {
        return harga_sebelum;
    }

    public void setHarga_sebelum(int harga_sebelum) {
        this.harga_sebelum = harga_sebelum;
    }

    public int getHarga_sesudah() {
        return harga_sesudah;
    }

    public void setHarga_sesudah(int harga_sesudah) {
        this.harga_sesudah = harga_sesudah;
    }
}
