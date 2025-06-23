package com.baidu.ar.recorder;

/* loaded from: classes7.dex */
public interface MovieRecorderCallback {
    void onRecorderComplete(boolean z, String str);

    void onRecorderError(int i);

    void onRecorderProcess(int i);

    void onRecorderStart(boolean z);
}
