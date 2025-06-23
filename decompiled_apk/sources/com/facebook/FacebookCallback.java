package com.facebook;

/* loaded from: classes8.dex */
public interface FacebookCallback<RESULT> {
    void onCancel();

    void onError(@OXOo.OOXIXo FacebookException facebookException);

    void onSuccess(RESULT result);
}
