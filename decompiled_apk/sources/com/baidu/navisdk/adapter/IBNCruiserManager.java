package com.baidu.navisdk.adapter;

import android.content.Context;

/* loaded from: classes7.dex */
public interface IBNCruiserManager {

    /* loaded from: classes7.dex */
    public interface ICruiserListener {
        void onCruiserStart();
    }

    boolean isCruiserStarted();

    void startCruiser(Context context, ICruiserListener iCruiserListener);

    void stopCruise();
}
