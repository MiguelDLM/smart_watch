package com.bytedance.sdk.openadsdk;

/* loaded from: classes8.dex */
public interface TTClientBidding {
    void loss(Double d, String str, String str2);

    void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener);

    void setPrice(Double d);

    void win(Double d);
}
