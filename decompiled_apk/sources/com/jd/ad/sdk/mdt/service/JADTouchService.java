package com.jd.ad.sdk.mdt.service;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes10.dex */
public interface JADTouchService {
    int onViewClicked(@NonNull Context context, @NonNull View view, @NonNull String str);

    void onViewTouch(@NonNull View view, @NonNull MotionEvent motionEvent, @NonNull String str);

    void registerTouchView(@NonNull String str);

    void unregisterTouchView(@NonNull String str);
}
