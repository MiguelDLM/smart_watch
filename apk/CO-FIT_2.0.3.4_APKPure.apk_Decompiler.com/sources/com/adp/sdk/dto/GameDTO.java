package com.adp.sdk.dto;

import java.io.Serializable;
import java.util.List;

public class GameDTO implements Serializable {
    private List<GameItemDTO> ads;
    private String name;
    private String url;

    public List<GameItemDTO> getAds() {
        return this.ads;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setAds(List<GameItemDTO> list) {
        this.ads = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
