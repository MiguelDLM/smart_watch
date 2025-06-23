package com.baidu.ar.dumixhuman.dumix;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.baidu.ar.DefaultParams;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.DuMixController;
import com.baidu.ar.DuMixErrorType;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.digital.IDigital;
import com.baidu.ar.dumixhuman.callback.DumixState;
import com.baidu.ar.dumixhuman.callback.IDigitalStateCallback;
import com.baidu.ar.dumixhuman.callback.IMessageLuaCallback;
import com.baidu.ar.dumixhuman.callback.IMessageSubtitleCallback;
import com.baidu.ar.dumixhuman.callback.IMessageWidgetCallback;
import com.baidu.ar.dumixhuman.callback.ISurfaceTouchCallback;
import com.baidu.ar.ec;
import com.baidu.ar.ef;
import com.baidu.ar.fn;
import com.baidu.ar.fp;
import com.baidu.ar.gd;
import com.baidu.ar.kf;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.huawei.openalliance.ad.constant.aw;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes7.dex */
public class DigitalHuman implements gd {
    public static final String TAG = "DigitalHuman";
    private final boolean isDebug;
    private final boolean mCaseLoadFromServer;
    private String mCasePath;
    private Context mContext;
    private File mLibDir;
    private ISurfaceTouchCallback qC;
    private IDigitalStateCallback qD;
    private final String qF;
    private final int qG;
    private final int qH;
    private boolean qI;
    private boolean qJ;
    private TextureView qK;
    private boolean qL;
    private DuMixInput qM;
    private DuMixOutput qN;
    private DuMixController qO;
    private IDigital qP;
    private long qA = 0;
    private long qB = 0;
    private Set<IMessageLuaCallback> qE = new HashSet();
    private final Handler mHandler = new Handler();
    private boolean dn = true;
    private boolean qQ = false;

    public DigitalHuman(Context context, IMessageSubtitleCallback iMessageSubtitleCallback, IMessageWidgetCallback iMessageWidgetCallback, ISurfaceTouchCallback iSurfaceTouchCallback, IDigitalStateCallback iDigitalStateCallback, String str, String str2, int i, int i2, boolean z, boolean z2) {
        this.mContext = context;
        this.qC = iSurfaceTouchCallback;
        this.qD = iDigitalStateCallback;
        this.qF = str;
        this.mCasePath = str2;
        this.isDebug = z;
        this.mCaseLoadFromServer = z2;
        this.qG = i;
        this.qH = i2;
        dz();
    }

    private void dz() {
        File file = new File(DuMixController.getSoDownLoadDir(this.mContext));
        this.mLibDir = file;
        fn.a(new fp(file.getAbsolutePath()));
        fn.require("dumixar");
        fn.setLibReadyListener("dumixar", new ILibLoader.c() { // from class: com.baidu.ar.dumixhuman.dumix.DigitalHuman.1
            @Override // com.baidu.ar.libloader.ILibLoader.c
            public void onError() {
                kf.u(DigitalHuman.TAG, "onError: load dumixar error");
            }

            @Override // com.baidu.ar.libloader.ILibLoader.c
            public void onReady() {
                kf.u(DigitalHuman.TAG, "onReady: load dumixar success");
                fn.release();
                DigitalHuman digitalHuman = DigitalHuman.this;
                digitalHuman.d(digitalHuman.mContext, DigitalHuman.this.qF);
                DigitalHuman digitalHuman2 = DigitalHuman.this;
                digitalHuman2.k(digitalHuman2.qG, DigitalHuman.this.qH);
                StatisticApi.init(DigitalHuman.this.mContext);
                StatisticApi.onEvent(StatisticConstants.EVENT_AR_DIGIT_START);
                kf.u(DigitalHuman.TAG, "SDK Version : 1.3.7.2 mDigitalStateCallback:" + DigitalHuman.this.qD);
                DigitalHuman.this.qA = System.currentTimeMillis();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, int i2) {
        this.qM = new DuMixInput(i2, i);
        this.qN = new DuMixOutput(i, i2);
        kf.u(TAG, "DigitalTime begin setup!!");
        this.qO.setup(this.qM, this.qN, new DuMixCallback() { // from class: com.baidu.ar.dumixhuman.dumix.DigitalHuman.4
            @Override // com.baidu.ar.DuMixCallback
            public void onCaseCreate(boolean z, String str, String str2) {
                kf.u(DigitalHuman.TAG, "DuMixCallback  onCaseCreate  result： " + z + " casePath:" + str);
                DigitalHuman.this.qJ = true;
                StringBuilder sb = new StringBuilder();
                sb.append("DigitalTime case load completed Time = ");
                sb.append(((float) (System.currentTimeMillis() - DigitalHuman.this.qB)) / 1000.0f);
                kf.u(DigitalHuman.TAG, sb.toString());
                if (DigitalHuman.this.qD == null || !z) {
                    return;
                }
                DigitalHuman.this.qD.onState(DumixState.CASE_LOAD_FINISH, null);
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onCaseDestroy() {
                kf.u(DigitalHuman.TAG, "DigitalTime onCaseDestroy");
                kf.u(DigitalHuman.TAG, "DuMixCallback  onCaseDestroy  ");
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
                kf.u(DigitalHuman.TAG, "DigitalTime onError  errorType : " + duMixErrorType + "  errorMessage : " + str + " extra :" + str2);
                StringBuilder sb = new StringBuilder();
                sb.append("DuMixCallback  onError  errorMessage : ");
                sb.append(str);
                kf.u(DigitalHuman.TAG, sb.toString());
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onRelease() {
                kf.u(DigitalHuman.TAG, "DigitalTime onRelease");
                kf.u(DigitalHuman.TAG, "DuMixCallback  onRelease  ");
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
                DigitalHuman.this.qQ = z;
                kf.u(DigitalHuman.TAG, "DigitalTime setup callback result :" + z);
                kf.u(DigitalHuman.TAG, "DigitalTime setup completed Time = " + (((float) (System.currentTimeMillis() - DigitalHuman.this.qA)) / 1000.0f));
                if (DigitalHuman.this.qD != null) {
                    DigitalHuman.this.qD.onState(DumixState.ENGINE_SETUP, "");
                }
                if (z) {
                    DigitalHuman digitalHuman = DigitalHuman.this;
                    digitalHuman.loadCaseWithResPath(digitalHuman.mCasePath);
                }
            }
        });
    }

    public void addMessageLuaCallback(IMessageLuaCallback iMessageLuaCallback) {
        this.qE.add(iMessageLuaCallback);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void addOutputView(TextureView textureView, boolean z) {
        kf.u(TAG, "addOutputView: " + this.qI + " mCaseLoadFinish:" + this.qJ + " textureView:" + textureView);
        if (this.qI || textureView == null) {
            return;
        }
        this.qK = textureView;
        this.qL = z;
        if (textureView.isAvailable()) {
            a(this.qK);
        }
        this.qK.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.baidu.ar.dumixhuman.dumix.DigitalHuman.2
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                DigitalHuman digitalHuman = DigitalHuman.this;
                digitalHuman.a(digitalHuman.qK);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (DigitalHuman.this.qK == null) {
                    return false;
                }
                DigitalHuman digitalHuman = DigitalHuman.this;
                digitalHuman.removeOutputView(digitalHuman.qK);
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                DigitalHuman digitalHuman = DigitalHuman.this;
                digitalHuman.a(digitalHuman.qK);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
        if (this.qL) {
            this.qK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.dumixhuman.dumix.DigitalHuman.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (DigitalHuman.this.qO != null) {
                        return DigitalHuman.this.qO.onTouch(view, motionEvent);
                    }
                    return false;
                }
            });
        }
    }

    public void changeAnimation(String str) {
        changeRenderParameter(new ec().w(1).v(1).ar("play").aq(str).du());
    }

    public void changeRenderParameter(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            kf.u(TAG, "changeRenderParameter Thread: params: " + hashMap.toString());
            DuMixController duMixController = this.qO;
            if (duMixController != null) {
                duMixController.sendMsg2Lua(hashMap);
            }
        }
    }

    public void destroy() {
        this.qQ = false;
        kf.u(TAG, "destroy");
        TextureView textureView = this.qK;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(null);
        }
        destroySDK();
        DuMixController duMixController = this.qO;
        if (duMixController != null) {
            duMixController.release();
        }
        if (this.mLibDir != null) {
            this.mLibDir = null;
            fn.release();
        }
        if (this.mContext != null) {
            this.mContext = null;
        }
    }

    public void destroySDK() {
        kf.u(TAG, "destroySDK mDigitalStateCallback:" + this.qD);
        this.qD = null;
        ef.dA().release();
    }

    public void finishRecordAudio() {
        IDigital iDigital = this.qP;
        if (iDigital != null) {
            iDigital.stopRecord();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public void interruptReading() {
        IDigital iDigital = this.qP;
        if (iDigital != null) {
            iDigital.stop();
        }
    }

    public void loadCaseWithResPath(String str) {
        kf.u(TAG, "DigitalTime mSetupSuccess :" + this.qQ);
        kf.u(TAG, "DigitalTime begin loadCase  path :" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mCasePath = str;
        kf.u(TAG, "loadCaseWithResPath path:" + str);
        String replace = str.replace("/ar", "");
        this.qB = System.currentTimeMillis();
        IDigitalStateCallback iDigitalStateCallback = this.qD;
        if (iDigitalStateCallback != null) {
            iDigitalStateCallback.onState(DumixState.CASE_LOAD_START, "");
        }
        if (this.qO == null || !this.qQ) {
            return;
        }
        kf.u(TAG, "DigitalTime mDuMixController loadCase path :" + replace);
        this.qO.loadCase(replace, "");
    }

    @Override // com.baidu.ar.gd
    public void onEngineCreate(int i) {
        if (i == 1 || this.qD == null) {
            return;
        }
        kf.u(TAG, "onEngineCreate : " + i + " Thread:" + Thread.currentThread().getName());
        this.qD.onState(DumixState.MULT_ENGINE_SETUP, Integer.valueOf(i));
    }

    public void pause() {
        kf.u(TAG, "pause");
        if (this.dn) {
            return;
        }
        this.dn = true;
        DuMixController duMixController = this.qO;
        if (duMixController != null) {
            duMixController.pause();
        }
    }

    public void removeOutputView(TextureView textureView) {
        kf.u(TAG, "removeOutputView");
        if (textureView != null) {
            kf.u(TAG, "removeOutputView textureView hashcode:" + textureView.hashCode());
            DuMixController duMixController = this.qO;
            if (duMixController != null) {
                this.qQ = false;
                duMixController.removeOutput(this.qN);
            }
        } else {
            kf.u(TAG, "removeOutputView textureView is null");
        }
        this.qI = false;
    }

    public void resume() {
        kf.u(TAG, aw.ag);
        if (this.qJ && this.dn) {
            this.dn = false;
            DuMixController duMixController = this.qO;
            if (duMixController != null) {
                duMixController.resume();
            }
        }
    }

    public void sendChatMessage(String str) {
        kf.u(TAG, "sendChatMessage textMsg:" + str);
        IDigital iDigital = this.qP;
        if (iDigital != null) {
            iDigital.sendChatMessage(str);
        }
    }

    public void sendReadingMessage(String str) {
        kf.u(TAG, "sendReadingMessage textMsg:" + str);
        IDigital iDigital = this.qP;
        if (iDigital != null) {
            iDigital.sendReadingMessage(str);
        }
    }

    public void setOutputViewStatus(boolean z) {
        this.qI = z;
    }

    public void startRecordAudio() {
        IDigital iDigital = this.qP;
        if (iDigital != null) {
            iDigital.startRecord();
        }
    }

    public void unloadCase() {
        this.qJ = false;
        kf.u(TAG, "unloadCase");
        DuMixController duMixController = this.qO;
        if (duMixController != null) {
            duMixController.clearCase();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, String str) {
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setDigitalArEnable(true);
        defaultParams.setDigitalSocketEnable(false);
        defaultParams.setDigitalSocketUrl(str);
        defaultParams.setDigitalUnitAppId("i-kgqiz7g0gv22a");
        defaultParams.setDigitalUnitAppKey("2p78v82ihj8cg04edt17");
        defaultParams.setUseBeautyFilter(false);
        defaultParams.setUseFaceFilter(false);
        defaultParams.setUseMakeupFilter(false);
        defaultParams.setRenderPipeline("filter_pipeline = function()\n\n    fm = ae.FilterManager:get_instance();\n\n\n    engine_filter = fm:create_filter(\"EngineFilter\", \"globalEngineFilter\", true);\n    fm:reset_pipeline();\n\n\n    fm:connect_filter_to_camera(engine_filter);\n    fm:connect_filter_to_output(engine_filter);\n\nend\n\nfilter_pipeline()\n\n");
        DuMixController duMixController = DuMixController.getInstance(context, defaultParams);
        this.qO = duMixController;
        this.qP = duMixController.getARProxyManager().getDigitalAR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextureView textureView) {
        DuMixOutput duMixOutput;
        if (this.qO == null || (duMixOutput = this.qN) == null || textureView == null) {
            return;
        }
        duMixOutput.setOutputWidth(this.qK.getWidth());
        this.qN.setOutputHeight(this.qK.getHeight());
        if (this.qI) {
            this.qO.changeOutput(this.qN);
            return;
        }
        this.qN.setOutputSurface(new Surface(textureView.getSurfaceTexture()));
        this.qI = true;
        this.qO.addOutput(this.qN);
    }
}
