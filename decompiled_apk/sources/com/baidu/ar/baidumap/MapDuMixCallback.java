package com.baidu.ar.baidumap;

import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;

/* loaded from: classes7.dex */
public interface MapDuMixCallback {
    void onError();

    void onRelease(boolean z);

    void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput);
}
