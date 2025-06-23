package com.adp.sdk.dto;

public class SourceVO {
    private String id;
    private String price;
    private int rate;
    private boolean showAfterTimeOut;
    private String source;

    public String getId() {
        return this.id;
    }

    public String getPrice() {
        return this.price;
    }

    public int getRate() {
        return this.rate;
    }

    public String getSource() {
        return this.source;
    }

    public boolean isShowAfterTimeOut() {
        return this.showAfterTimeOut;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setRate(int i) {
        this.rate = i;
    }

    public void setShowAfterTimeOut(boolean z) {
        this.showAfterTimeOut = z;
    }

    public void setSource(String str) {
        this.source = str;
    }
}
