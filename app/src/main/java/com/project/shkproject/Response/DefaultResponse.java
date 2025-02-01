package com.project.shkproject.Response;

import com.google.gson.annotations.SerializedName;

public class DefaultResponse {
    @SerializedName("_embedded")
    private Embedded embedded;

    @SerializedName("_links")
    private Links links;

    @SerializedName("page")
    private Page page;

    public DefaultResponse() {
    }

    public DefaultResponse(Embedded embedded, Links links, Page page) {
        this.embedded = embedded;
        this.links = links;
        this.page = page;
    }

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
