package com.project.shkproject.Response;

import com.google.gson.annotations.SerializedName;

public class Links {
    @SerializedName("self")
    private Self self;

    @SerializedName("profile")
    private Profile profile;

    @SerializedName("search")
    private Search search;
}
