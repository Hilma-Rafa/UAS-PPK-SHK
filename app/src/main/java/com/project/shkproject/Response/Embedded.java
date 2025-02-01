package com.project.shkproject.Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Embedded {
    @SerializedName("hK1_1s")
    private List<HK11Response> hK1_1s;

    public List<HK11Response> getHK1_1s() {
        return hK1_1s;
    }
}
