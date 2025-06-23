package com.baidu.ar;

/* loaded from: classes7.dex */
public interface fx {
    void onCreateSessionFail();

    void onCreateVpasAlgoFail();

    void onPositionSuccess(int i);

    void onVpasAlgoStatePrint(int i, int i2, float f);

    void onVpasLocationSuccess();

    void onVpasSendFrame();

    void onVpasTrackingState(int i);
}
