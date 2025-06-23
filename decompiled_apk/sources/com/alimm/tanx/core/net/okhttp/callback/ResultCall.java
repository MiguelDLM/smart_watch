package com.alimm.tanx.core.net.okhttp.callback;

/* loaded from: classes.dex */
public interface ResultCall {
    void inProgress(float f);

    void onAfter();

    void onBefore();

    void onError(int i, String str);

    void onSuccess(String str);
}
