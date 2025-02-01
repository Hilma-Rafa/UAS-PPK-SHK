package com.project.shkproject.Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HK11Response {
    @SerializedName("responden")
    private String responden;

    @SerializedName("kode_kualitas")
    private String kodeKualitas;

    @SerializedName("komoditas")
    private String komoditas;

    @SerializedName("kualitas")
    private String kualitas;

    @SerializedName("harga_sebelum")
    private int hargaSebelum;

    @SerializedName("harga_sekarang")
    private int hargaSekarang;

    @SerializedName("_links")
    private Links links;

    public HK11Response() {
    }

    public String getResponden() {
        return responden;
    }

    public void setResponden(String responden) {
        this.responden = responden;
    }

    public String getKodeKualitas() {
        return kodeKualitas;
    }

    public void setKodeKualitas(String kodeKualitas) {
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

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}
