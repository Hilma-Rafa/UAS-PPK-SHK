package com.project.shkproject.Request;

import com.google.gson.annotations.SerializedName;

public class HK11Request {
    @SerializedName("responden")
    private String responden;

    @SerializedName("kode_kualitas")
    private long kodeKualitas;

    @SerializedName("komoditas")
    private String komoditas;

    @SerializedName("kualitas")
    private String kualitas;

    @SerializedName("harga_sebelum")
    private int hargaSebelum;

    @SerializedName("harga_sekarang")
    private int hargaSekarang;

    public HK11Request() {
    }

    public String getResponden() {
        return responden;
    }

    public void setResponden(String responden) {
        this.responden = responden;
    }

    public long getKodeKualitas() {
        return kodeKualitas;
    }

    public void setKodeKualitas(long kodeKualitas) {
        this.kodeKualitas = kodeKualitas;
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

    public int getHargaSebelum() {
        return hargaSebelum;
    }

    public void setHargaSebelum(int hargaSebelum) {
        this.hargaSebelum = hargaSebelum;
    }

    public int getHargaSekarang() {
        return hargaSekarang;
    }

    public void setHargaSekarang(int hargaSekarang) {
        this.hargaSekarang = hargaSekarang;
    }
}
