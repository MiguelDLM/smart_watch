package com.qq.e.ads;

import com.qq.e.comm.util.AdError;

/* loaded from: classes11.dex */
public abstract class NativeAbstractAD<T> extends AbstractAD<T> {

    /* loaded from: classes11.dex */
    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(T t) {
    }
}
