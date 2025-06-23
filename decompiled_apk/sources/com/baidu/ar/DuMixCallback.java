package com.baidu.ar;

/* loaded from: classes7.dex */
public interface DuMixCallback {
    void onCaseCreate(boolean z, String str, String str2);

    void onCaseDestroy();

    void onError(DuMixErrorType duMixErrorType, String str, String str2);

    void onRelease();

    void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput);
}
