package com.project.shkproject.Response;

import com.google.gson.annotations.SerializedName;

public class Profile {
    @SerializedName("href")
    private String href;

    public String getHref() {
        return href;
    }
}