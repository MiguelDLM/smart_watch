package com.alimm.tanx.core.ad.bean;

public class TanxBiddingInfo extends BaseBean {
    private long adPrice;
    private boolean bidResult;
    private double winPrice;

    public long getAdPrice() {
        return this.adPrice;
    }

    public double getWinPrice() {
        return this.winPrice;
    }

    public boolean isBidResult() {
        return this.bidResult;
    }

    public void setAdPrice(long j) {
        this.adPrice = j;
    }

    public void setBidResult(boolean z) {
        this.bidResult = z;
    }

    public void setWinPrice(double d) {
        this.winPrice = d;
    }
}
