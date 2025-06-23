package com.jd.ad.sdk.dl.model;

import XIXIX.OOXIXo;

/* loaded from: classes10.dex */
public class JADExtra implements IJADExtra {
    private double price = OOXIXo.f3760XO;

    @Override // com.jd.ad.sdk.dl.model.IJADExtra
    public int getPrice() {
        return (int) Math.round(this.price);
    }

    public void setPrice(double d) {
        this.price = d;
    }
}
