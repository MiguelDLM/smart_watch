package com.baidu.ar.dumixhuman.dumix;

import android.content.Context;
import com.baidu.ar.DuMixController;
import com.baidu.ar.camera.CameraManager;
import com.baidu.ar.dumixhuman.callback.IDigitalStateCallback;
import com.baidu.ar.dumixhuman.callback.IMessageSubtitleCallback;
import com.baidu.ar.dumixhuman.callback.IMessageWidgetCallback;
import com.baidu.ar.dumixhuman.callback.ISurfaceTouchCallback;
import com.baidu.ar.kf;
import com.baidu.ar.kr;
import java.io.File;

/* loaded from: classes7.dex */
public final class DigitalHumanBuilder {
    private static final String DUMIX_LIBS_NAME = "libdumixar.so";
    private static final String REMOTE_CLASS_NAME = "com.baidu.ar.remoteres.RemoteResLoader";
    private static final String TAG = "DigitalHumanBuilder";
    private static volatile DigitalHuman sInstance;
    private String casePath;
    private Context context;
    private IDigitalStateCallback digitalStateCallback;
    private boolean isDebug;
    private IMessageSubtitleCallback messageSubtitleCallback;
    private IMessageWidgetCallback messageWidgetCallback;
    private ISurfaceTouchCallback surfaceTouchCallback;
    private String digitalUrl = "wss://dusee.baidu.com/digitalhuman-ws";
    private int mInputWidth = CameraManager.DEFAULTHEIGHT;
    private int mInputHeight = 1280;
    private boolean mCaseLoadFromServer = false;

    private boolean engineFileExists(Context context) {
        if (context == null) {
            return false;
        }
        return isCoreFileExists(context);
    }

    private boolean isCoreFileExists(Context context) {
        if (kr.a(REMOTE_CLASS_NAME, context.getClassLoader())) {
            return new File(DuMixController.getSoDownLoadDir(context), DUMIX_LIBS_NAME).exists();
        }
        return true;
    }

    public static void removeShareInstance() {
        synchronized (DigitalHumanBuilder.class) {
            sInstance = null;
        }
    }

    public DigitalHuman create() {
        if (engineFileExists(this.context)) {
            return new DigitalHuman(this.context, this.messageSubtitleCallback, this.messageWidgetCallback, this.surfaceTouchCallback, this.digitalStateCallback, this.digitalUrl, this.casePath, this.mInputWidth, this.mInputHeight, this.isDebug, this.mCaseLoadFromServer);
        }
        kf.b(TAG, "DigitalHuman create error!!! As libEglCore.so not exists!!!");
        return null;
    }

    public DigitalHuman createShareInstance() {
        kf.u(TAG, "createShareInstance : " + sInstance);
        if (sInstance == null) {
            synchronized (DigitalHumanBuilder.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new DigitalHuman(this.context, this.messageSubtitleCallback, this.messageWidgetCallback, this.surfaceTouchCallback, this.digitalStateCallback, this.digitalUrl, this.casePath, this.mInputWidth, this.mInputHeight, this.isDebug, this.mCaseLoadFromServer);
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public DigitalHumanBuilder setCaseLoadFromServer(boolean z) {
        this.mCaseLoadFromServer = z;
        return this;
    }

    public DigitalHumanBuilder setCasePath(String str) {
        this.casePath = str;
        return this;
    }

    public DigitalHumanBuilder setContext(Context context) {
        this.context = context;
        return this;
    }

    public DigitalHumanBuilder setDebug(boolean z) {
        this.isDebug = z;
        return this;
    }

    public DigitalHumanBuilder setDigitalStateCallback(IDigitalStateCallback iDigitalStateCallback) {
        this.digitalStateCallback = iDigitalStateCallback;
        return this;
    }

    public DigitalHumanBuilder setDigitalUrl(String str) {
        this.digitalUrl = str;
        return this;
    }

    public DigitalHumanBuilder setInputSize(int i, int i2) {
        this.mInputWidth = i;
        this.mInputHeight = i2;
        return this;
    }

    public DigitalHumanBuilder setMessageSubtitleCallback(IMessageSubtitleCallback iMessageSubtitleCallback) {
        this.messageSubtitleCallback = iMessageSubtitleCallback;
        return this;
    }

    public DigitalHumanBuilder setMessageWidgetCallback(IMessageWidgetCallback iMessageWidgetCallback) {
        this.messageWidgetCallback = iMessageWidgetCallback;
        return this;
    }

    public DigitalHumanBuilder setSurfaceTouchCallback(ISurfaceTouchCallback iSurfaceTouchCallback) {
        this.surfaceTouchCallback = iSurfaceTouchCallback;
        return this;
    }
}
