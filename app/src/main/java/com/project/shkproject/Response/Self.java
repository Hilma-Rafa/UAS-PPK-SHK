package com.project.shkproject.Response;

import com.google.gson.annotations.SerializedName;

public class Self {
    @SerializedName("href")
    private String href;

    public Self(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
