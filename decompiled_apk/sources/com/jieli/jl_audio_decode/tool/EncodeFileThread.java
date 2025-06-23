package com.jieli.jl_audio_decode.tool;

import android.text.TextUtils;
import com.jieli.jl_audio_decode.callback.OnStateCallback;
import com.jieli.jl_audio_decode.callback.OnThreadFinishListener;
import java.io.File;

/* loaded from: classes10.dex */
public class EncodeFileThread extends Thread {
    private final String inFile;
    private final OnStateCallback mCallback;
    private final BaseManager mManager;
    private final OnThreadFinishListener mThreadListener;
    private final String outFile;

    public EncodeFileThread(BaseManager baseManager, String str, String str2, OnStateCallback onStateCallback, OnThreadFinishListener onThreadFinishListener) {
        this.mManager = baseManager;
        this.inFile = str;
        this.outFile = str2;
        this.mCallback = onStateCallback;
        this.mThreadListener = onThreadFinishListener;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.mManager != null) {
            File file = new File(this.inFile);
            if (!TextUtils.isEmpty(this.inFile) && !TextUtils.isEmpty(this.outFile) && file.exists() && file.isFile()) {
                this.mManager.nativeEncodeFile(this.inFile, this.outFile);
            } else {
                OnStateCallback onStateCallback = this.mCallback;
                if (onStateCallback != null) {
                    onStateCallback.onError(-2, "file not exist.");
                }
            }
        } else {
            OnStateCallback onStateCallback2 = this.mCallback;
            if (onStateCallback2 != null) {
                onStateCallback2.onError(-1, "Invalid parameter");
            }
        }
        OnThreadFinishListener onThreadFinishListener = this.mThreadListener;
        if (onThreadFinishListener != null) {
            onThreadFinishListener.onThreadFinish(getId());
        }
    }
}
