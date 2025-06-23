package com.baidu.ar;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ar.ability.AbilityType;
import com.baidu.ar.arplay.core.engine.rotate.OrientationManager;
import com.baidu.ar.arplay.core.pixel.IPixelReader;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arrender.ARRenderFpsCallback;
import com.baidu.ar.arrender.FrameRenderListener;
import com.baidu.ar.arrender.IARRenderer;
import com.baidu.ar.arrender.IGLRenderer;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.IAuthenticator;
import com.baidu.ar.auth.IDuMixAuthCallback;
import com.baidu.ar.auth.IOfflineAuthenticator;
import com.baidu.ar.bean.CaseModel;
import com.baidu.ar.bean.Watermark;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.content.IContentPlatform;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterParam;
import com.baidu.ar.filter.FilterStateListener;
import com.baidu.ar.filter.IFilter;
import com.baidu.ar.libloader.ILibLoaderPlugin;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.ar.photo.IPhoto;
import com.baidu.ar.photo.PhotoCallback;
import com.baidu.ar.record.IRecord;
import com.baidu.ar.record.RecordCallback;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.steploading.IStepLoading;
import com.garmin.fit.OxXXx0X;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class DuMixController implements IDuMix, IPixelReader, IFilter, IPhoto, IRecord {
    private static volatile int bA;
    private static volatile DuMixController bq;
    private static volatile Object sLock = new Object();
    private DefaultParams D;
    private fs F;
    private bb G;
    private p W;
    private c aC;
    private ej ab;
    private DuMixInput ax;
    private DuMixOutput ay;
    protected DuMixCallback az;
    private HandlerThread br;
    private Handler bs;
    private Handler bt;
    private DuMixCallback bu;
    private g bv;
    private fv bw;
    private OrientationManager bx;
    private hn by;
    private IContentPlatform bz;
    private gm k;
    private Context mContext;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 3000:
                    DuMixController.this.Q();
                    return;
                case 3001:
                    DuMixController.this.S();
                    return;
                case 3002:
                    DuMixController.this.T();
                    return;
                case 3003:
                    DuMixController.this.U();
                    return;
                case 3004:
                    DuMixController.this.a((CaseModel) message.obj);
                    return;
                case 3005:
                    DuMixController.this.V();
                    return;
                case 3006:
                    if (DuMixController.this.G != null) {
                        DuMixController.this.G.changeOutputSize(message.arg1, message.arg2);
                        return;
                    }
                    return;
                case 3007:
                    DuMixController.this.ay = (DuMixOutput) message.obj;
                    if (DuMixController.this.G != null) {
                        DuMixController.this.G.changeOutput(DuMixController.this.ay);
                        return;
                    }
                    return;
                case 3008:
                    if (DuMixController.this.G != null) {
                        DuMixController.this.G.pauseScene();
                        return;
                    }
                    return;
                case 3009:
                    if (DuMixController.this.G != null) {
                        DuMixController.this.G.resumeScene();
                        return;
                    }
                    return;
                case 3010:
                    if (DuMixController.this.G != null) {
                        DuMixController.this.G.a(message.obj, message.arg1, message.arg2);
                        return;
                    }
                    return;
                case OxXXx0X.f13274xx0o0O /* 3011 */:
                    if (DuMixController.this.G != null) {
                        DuMixController.this.G.addOutputSurface((DuMixOutput) message.obj);
                        return;
                    }
                    return;
                case 3012:
                    if (DuMixController.this.G != null) {
                        DuMixController.this.G.removeOutputSurface((DuMixOutput) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private DuMixController(Context context, DefaultParams defaultParams) {
        this.mContext = context;
        if (defaultParams != null) {
            this.D = defaultParams;
        } else {
            this.D = new DefaultParams();
        }
        kf.c("DuMixController", "create DuMixController sState = " + bA);
        if (bA == 3) {
            synchronized (sLock) {
                try {
                    kf.c("DuMixController", "create DuMixController wait for release!");
                    sLock.wait(3000L);
                } catch (Exception unused) {
                    kf.b("DuMixController", "create DuMixController wait error!!!");
                }
            }
        }
        HandlerThread handlerThread = new HandlerThread("DuMixController");
        this.br = handlerThread;
        handlerThread.start();
        this.bs = new a(this.br.getLooper());
        bo.bR().a(this.br.getLooper());
        a(this.mContext, this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        kf.c("DuMixController", "handleSetup() sState = " + bA);
        if (bA != 0 || this.bv == null || this.G == null || this.ab == null || this.aC == null || this.W == null) {
            return;
        }
        bA = 1;
        this.bu = R();
        this.bv.a(this.G, this.aC, this.ab, this.F);
        this.bv.setup(this.ax, this.ay, this.bu);
        StatisticApi.setPubParam(StatisticConstants.FRAME_DATA_FROM, this.ax.isCameraInput() ? PixelReadParams.DEFAULT_FILTER_ID : "video");
        StatisticApi.onEventStart(StatisticConstants.EVENT_SDK_START);
        this.bx.addOrientationListener(this.G);
        this.bx.enable();
        this.ab.a(this.G);
        p pVar = this.W;
        if (pVar != null) {
            JSONObject aq = pVar.aq();
            if (aq != null) {
                this.G.a(aq);
            } else {
                this.G.setLocalDeviceGrade(this.W.ar());
            }
        }
        this.aC.a(this.F, this.G);
        this.G.a(this.ax, this.ay);
        this.bv.a(this.W);
        this.bv.D();
    }

    private DuMixCallback R() {
        return new DuMixCallback() { // from class: com.baidu.ar.DuMixController.1
            @Override // com.baidu.ar.DuMixCallback
            public void onCaseCreate(final boolean z, final String str, final String str2) {
                if (DuMixController.this.bt != null) {
                    DuMixController.this.bt.post(new Runnable() { // from class: com.baidu.ar.DuMixController.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DuMixCallback duMixCallback = DuMixController.this.az;
                            if (duMixCallback != null) {
                                duMixCallback.onCaseCreate(z, str, str2);
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onCaseDestroy() {
                if (DuMixController.this.bt != null) {
                    DuMixController.this.bt.post(new Runnable() { // from class: com.baidu.ar.DuMixController.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            DuMixCallback duMixCallback = DuMixController.this.az;
                            if (duMixCallback != null) {
                                duMixCallback.onCaseDestroy();
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onError(final DuMixErrorType duMixErrorType, final String str, final String str2) {
                if (DuMixController.this.bt != null) {
                    DuMixController.this.bt.post(new Runnable() { // from class: com.baidu.ar.DuMixController.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            DuMixCallback duMixCallback = DuMixController.this.az;
                            if (duMixCallback != null) {
                                duMixCallback.onError(duMixErrorType, str, str2);
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onRelease() {
                kf.c("DuMixController", "getDuMixCallbackProxy onRelease sState = " + DuMixController.bA);
                int unused = DuMixController.bA = 0;
                synchronized (DuMixController.sLock) {
                    try {
                        DuMixController.sLock.notifyAll();
                    } catch (Exception unused2) {
                        kf.c("DuMixController", "onRelease normal!!!");
                    }
                }
                if (DuMixController.this.bt != null) {
                    DuMixController.this.bt.post(new Runnable() { // from class: com.baidu.ar.DuMixController.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            DuMixCallback duMixCallback = DuMixController.this.az;
                            if (duMixCallback != null) {
                                duMixCallback.onRelease();
                                DuMixController.this.az = null;
                            }
                        }
                    });
                    DuMixController.this.bt = null;
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onSetup(final boolean z, final DuMixInput duMixInput, final DuMixOutput duMixOutput) {
                kf.c("DuMixController", "getDuMixCallbackProxy onSetup sState = " + DuMixController.bA);
                int unused = DuMixController.bA = z ? 2 : 0;
                if (DuMixController.this.bv != null) {
                    DuMixController.this.bv.E();
                }
                if (DuMixController.this.bt != null) {
                    DuMixController.this.bt.post(new Runnable() { // from class: com.baidu.ar.DuMixController.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (DuMixController.this.az != null) {
                                kf.c("DuMixController", "mDuMixCallback.onSetup()");
                                DuMixController.this.az.onSetup(z, duMixInput, duMixOutput);
                            }
                        }
                    });
                }
                synchronized (DuMixController.sLock) {
                    try {
                        DuMixController.sLock.notifyAll();
                    } catch (Exception unused2) {
                        kf.c("DuMixController", "onSetup normal!!!");
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        if (bA != 2) {
            return;
        }
        c cVar = this.aC;
        if (cVar != null) {
            cVar.pause();
        }
        bb bbVar = this.G;
        if (bbVar != null) {
            bbVar.pause();
        }
        OrientationManager orientationManager = this.bx;
        if (orientationManager != null) {
            orientationManager.disable();
        }
        StatisticApi.pause();
        g gVar = this.bv;
        if (gVar != null) {
            gVar.o("pause");
        }
        gm gmVar = this.k;
        if (gmVar != null) {
            gmVar.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (bA != 2) {
            return;
        }
        g gVar = this.bv;
        if (gVar != null) {
            gVar.o(com.huawei.openalliance.ad.constant.aw.ag);
        }
        StatisticApi.resume();
        OrientationManager orientationManager = this.bx;
        if (orientationManager != null) {
            orientationManager.enable();
        }
        bb bbVar = this.G;
        if (bbVar != null) {
            bbVar.resume();
        }
        c cVar = this.aC;
        if (cVar != null) {
            cVar.resume();
        }
        gm gmVar = this.k;
        if (gmVar != null) {
            gmVar.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        kf.c("DuMixController", "handleRelease() sState = " + bA);
        Handler handler = this.bs;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.bs = null;
        }
        this.bz = null;
        g gVar = this.bv;
        if (gVar != null) {
            gVar.v();
        }
        fv fvVar = this.bw;
        if (fvVar != null) {
            fvVar.release();
            this.bw = null;
        }
        ej ejVar = this.ab;
        if (ejVar != null) {
            ejVar.clearAllFilter();
            this.ab.release();
            this.ab = null;
        }
        c cVar = this.aC;
        if (cVar != null) {
            cVar.release();
            this.aC = null;
        }
        bb bbVar = this.G;
        if (bbVar != null) {
            bbVar.release();
            this.G = null;
        }
        OrientationManager orientationManager = this.bx;
        if (orientationManager != null) {
            orientationManager.destroy();
            this.bx = null;
        }
        p pVar = this.W;
        if (pVar != null) {
            pVar.release();
            this.W = null;
        }
        fn.release();
        ARAuth.release();
        StatisticApi.onEventEnd(StatisticConstants.EVENT_CASE_END);
        StatisticApi.onEventEnd(StatisticConstants.EVENT_SDK_END);
        StatisticApi.release();
        fs fsVar = this.F;
        if (fsVar != null) {
            fsVar.destroy();
            this.F = null;
        }
        g gVar2 = this.bv;
        if (gVar2 != null) {
            gVar2.release();
            this.bv = null;
        }
        gm gmVar = this.k;
        if (gmVar != null) {
            gmVar.release();
            this.k = null;
        }
        this.ax = null;
        this.ay = null;
        this.D = null;
        this.bu = null;
        this.mContext = null;
        kf.c("DuMixController", "handleRelease() end");
        HandlerThread handlerThread = this.br;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.br = null;
        }
        gm gmVar2 = this.k;
        if (gmVar2 != null) {
            gmVar2.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        if (this.bv == null || bA != 2) {
            kf.b("DuMixController", "handleClearCase DuMix has not setup!!!!!!");
        } else {
            this.bv.clearCase();
        }
    }

    public static IAuthenticator getAsyncAuthenticator(String str, String str2, String str3) {
        return bt.getAsyncAuthenticator(str, str2, str3);
    }

    public static IAuthenticator getAuthenticator() {
        return bt.getAuthenticator();
    }

    public static DuMixController getInstance(Context context, DefaultParams defaultParams) {
        if (context == null) {
            kf.b("DuMixController", "getInstance() context must be set!!!");
            return null;
        }
        if (bq == null) {
            synchronized (DuMixController.class) {
                try {
                    if (bq == null) {
                        bq = new DuMixController(context, defaultParams);
                    }
                } finally {
                }
            }
        }
        return bq;
    }

    public static IOfflineAuthenticator getOfflineAuthenticator() {
        return bt.getOfflineAuthenticator();
    }

    public static String getSoDownLoadDir(Context context) {
        return g.getSoDownLoadDir(context);
    }

    public static int getVersionCode() {
        return kg.getVersionCode();
    }

    public static String getVersionName() {
        return kg.getVersionName();
    }

    public boolean addAbility(String str, String str2) {
        return addAbility(str, str2, null);
    }

    @Override // com.baidu.ar.IDuMix
    public void addFrameRenderListener(FrameRenderListener frameRenderListener) {
        bb bbVar = this.G;
        if (bbVar != null) {
            bbVar.addFrameRenderListener(frameRenderListener);
        }
    }

    public boolean addLuaMsgListener(LuaMsgListener luaMsgListener) {
        fs fsVar = this.F;
        if (fsVar == null || fsVar.ei() == null) {
            return false;
        }
        return this.F.ei().addLuaMsgListener(luaMsgListener);
    }

    @Override // com.baidu.ar.IDuMix
    public void addOutput(DuMixOutput duMixOutput) {
        Handler handler;
        if (duMixOutput == null || (handler = this.bs) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(OxXXx0X.f13274xx0o0O, duMixOutput));
    }

    public boolean adjustAbility(AbilityType abilityType, HashMap<String, Object> hashMap) {
        if (this.aC == null || abilityType == null || bA != 2) {
            return false;
        }
        return this.aC.adjustAbility(abilityType.getTypeValue(), hashMap);
    }

    @Override // com.baidu.ar.IDuMix
    public void changeInputSize(int i, int i2) {
        kf.c("DuMixController", "changeInputSize width * height = " + i + " * " + i2);
        Handler handler = this.bs;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(3010, i, i2, null));
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void changeOutput(DuMixOutput duMixOutput) {
        Handler handler;
        if (duMixOutput == null || (handler = this.bs) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(3007, duMixOutput));
    }

    @Override // com.baidu.ar.IDuMix
    public void changeOutputObject(Object obj, int i, int i2) {
        bb bbVar;
        if (obj == null || (bbVar = this.G) == null) {
            return;
        }
        bbVar.b(obj, i, i2);
    }

    @Override // com.baidu.ar.IDuMix
    public void changeOutputSize(int i, int i2) {
        kf.c("DuMixController", "changeOutputSize width * height = " + i + " * " + i2);
        Handler handler = this.bs;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(3006, i, i2));
        }
    }

    @Deprecated
    public List<Integer> checkAuth(byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback) {
        return ARAuth.checkAuth(this.mContext, bArr, iDuMixAuthCallback);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void clearAllFilter() {
        if (this.ab == null || bA != 2) {
            return;
        }
        this.ab.clearAllFilter();
    }

    @Override // com.baidu.ar.IDuMix
    public void clearCase() {
        kf.c("DuMixController", "AR clearCase");
        Handler handler = this.bs;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(3005));
        }
    }

    @Override // com.baidu.ar.arplay.core.pixel.IPixelReader
    public void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        g gVar;
        bb bbVar;
        if ((bA == 0 || bA == 1) && (gVar = this.bv) != null) {
            gVar.a(pixelReadParams, pixelReadListener);
        } else {
            if (bA != 2 || (bbVar = this.G) == null) {
                return;
            }
            bbVar.createPixelReader(pixelReadParams, pixelReadListener);
        }
    }

    @Override // com.baidu.ar.arplay.core.pixel.IPixelReader
    public void destroyPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        bb bbVar = this.G;
        if (bbVar != null) {
            bbVar.destroyPixelReader(pixelReadParams, pixelReadListener);
        }
    }

    public ARProxyManager getARProxyManager() {
        c cVar = this.aC;
        if (cVar != null) {
            return cVar.getARProxyManager();
        }
        return null;
    }

    public IARRenderer getARRenderer() {
        bb bbVar = this.G;
        if (bbVar == null || !(bbVar instanceof IARRenderer)) {
            return null;
        }
        return bbVar;
    }

    public List<String> getActiveAbilities() {
        if (this.aC == null || bA != 2) {
            return null;
        }
        return this.aC.getActiveAbilities();
    }

    public IContentPlatform getContentPlatform() {
        if (this.bz == null) {
            this.bz = (IContentPlatform) kr.a("com.baidu.ar.content.ContentCloud", new Class[]{Context.class}, new Object[]{this.mContext});
        }
        return this.bz;
    }

    public IGLRenderer getGLRenderer() {
        IARRenderer iARRenderer = this.G;
        if (iARRenderer == null || !(iARRenderer instanceof IGLRenderer)) {
            return null;
        }
        return (IGLRenderer) iARRenderer;
    }

    public Map<String, Object> getGradingInfo() {
        p pVar = this.W;
        if (pVar != null) {
            return pVar.getGradingInfo();
        }
        return null;
    }

    public IStepLoading getStepLoading() {
        bb bbVar = this.G;
        if (bbVar != null) {
            return bbVar.bs();
        }
        return null;
    }

    public List<String> getSupportedAbilities() {
        if (this.aC == null || bA != 2) {
            return null;
        }
        return this.aC.getSupportedAbilities();
    }

    public boolean isAbilityActive(AbilityType abilityType) {
        if (this.aC == null || abilityType == null || bA != 2) {
            return false;
        }
        return this.aC.isAbilityActive(abilityType.getTypeValue());
    }

    public boolean isAbilitySupported(String str) {
        if (this.aC == null || bA != 2) {
            return false;
        }
        return this.aC.isAbilitySupported(str);
    }

    @Override // com.baidu.ar.IDuMix
    public void loadCase(ARType aRType, String str, String str2) {
        kf.c("DuMixController", "AR loadCase");
        if (this.bs != null) {
            CaseModel caseModel = new CaseModel(aRType, str, str2);
            Handler handler = this.bs;
            handler.sendMessage(handler.obtainMessage(3004, caseModel));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.G == null || bA != 2) {
            return false;
        }
        return this.G.onTouch(view, motionEvent);
    }

    @Override // com.baidu.ar.IDuMix
    public void pause() {
        kf.c("DuMixController", "AR pause");
        Handler handler = this.bs;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(3001));
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void pauseRecord() {
        if (this.by == null || bA != 2) {
            return;
        }
        this.by.pauseRecord();
    }

    @Override // com.baidu.ar.IDuMix
    public void pauseScene() {
        kf.c("DuMixController", "AR pauseScene");
        Handler handler = this.bs;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(3008));
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void release() {
        kf.c("DuMixController", "release() sState = " + bA);
        ge.ew().release();
        if (bA == 1) {
            bb bbVar = this.G;
            if (bbVar == null || !bbVar.bw()) {
                synchronized (sLock) {
                    try {
                        kf.c("DuMixController", "release DuMixController wait for setup!");
                        sLock.wait(3000L);
                    } catch (Exception unused) {
                        kf.b("DuMixController", "release DuMixController wait error!!!");
                    }
                }
            } else {
                this.G.q(true);
                Handler handler = this.bs;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                    Handler handler2 = this.bs;
                    handler2.sendMessage(handler2.obtainMessage(3003));
                }
                bA = 0;
                bq = null;
            }
        }
        if (bA == 0) {
            bq = null;
            return;
        }
        if (bA == 3) {
            return;
        }
        if (bA != 2) {
            kf.b("DuMixController", "release error!!!");
            return;
        }
        bA = 3;
        Handler handler3 = this.bs;
        if (handler3 != null) {
            handler3.removeCallbacksAndMessages(null);
            Handler handler4 = this.bs;
            handler4.sendMessage(handler4.obtainMessage(3003));
        }
        bq = null;
    }

    @Override // com.baidu.ar.IDuMix
    public void removeFrameRenderListener(FrameRenderListener frameRenderListener) {
        bb bbVar = this.G;
        if (bbVar != null) {
            bbVar.removeFrameRenderListener(frameRenderListener);
        }
    }

    public boolean removeLuaMsgListener(LuaMsgListener luaMsgListener) {
        fs fsVar = this.F;
        if (fsVar == null || fsVar.ei() == null) {
            return false;
        }
        return this.F.ei().removeLuaMsgListener(luaMsgListener);
    }

    @Override // com.baidu.ar.IDuMix
    public void removeOutput(DuMixOutput duMixOutput) {
        Handler handler;
        if (duMixOutput == null || (handler = this.bs) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(3012, duMixOutput));
    }

    @Override // com.baidu.ar.filter.IFilter
    public void resetAllFilter() {
        if (this.ab == null || bA != 2) {
            return;
        }
        this.ab.resetAllFilter();
    }

    @Override // com.baidu.ar.IDuMix
    public void resume() {
        kf.c("DuMixController", "AR resume");
        Handler handler = this.bs;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(3002));
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void resumeRecord() {
        if (this.by == null || bA != 2) {
            return;
        }
        this.by.resumeRecord();
    }

    @Override // com.baidu.ar.IDuMix
    public void resumeScene() {
        kf.c("DuMixController", "AR resumeScene");
        Handler handler = this.bs;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(3009));
        }
    }

    public boolean sendLuaScript2Engine(String str) {
        if (this.F == null || bA != 2) {
            return false;
        }
        this.F.aK(str);
        return true;
    }

    public boolean sendMsg2Lua(HashMap<String, Object> hashMap) {
        if (this.F == null || bA != 2) {
            return false;
        }
        this.F.b(1902, hashMap);
        return true;
    }

    public void setARRenderFpsCallback(ARRenderFpsCallback aRRenderFpsCallback) {
        bb bbVar = this.G;
        if (bbVar != null) {
            bbVar.setARRenderFpsCallback(aRRenderFpsCallback);
        }
    }

    public void setAuthLicense(byte[] bArr, String str, String str2, String str3) {
        ARAuth.setAuthLicense(bArr, str, str2, str3);
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        if (this.bw == null) {
            this.bw = new fv(this.F);
        }
        this.bw.setDefinedLuaListener(definedLuaListener);
    }

    public void setDownloadComplete() {
        this.k.setDownloadComplete();
    }

    @Override // com.baidu.ar.filter.IFilter
    public void setFilterStateListener(FilterStateListener filterStateListener) {
        ej ejVar = this.ab;
        if (ejVar != null) {
            ejVar.setFilterStateListener(filterStateListener);
        }
    }

    public void setGLWebViewUseable(Context context, ViewGroup viewGroup) {
        bb bbVar = this.G;
        if (bbVar != null) {
            bbVar.setGLWebViewUseable(context, viewGroup);
        }
    }

    public void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        fn.setLibLoadPlugin(iLibLoaderPlugin);
    }

    public void setMdlModelPath(String str) {
        c cVar = this.aC;
        if (cVar != null) {
            cVar.setMdlModelPath(str);
        }
    }

    public void setNativeWebViewUseable(Context context, ViewGroup viewGroup) {
        bb bbVar = this.G;
        if (bbVar != null) {
            bbVar.setNativeWebViewUseable(context, viewGroup);
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void setRecordWatermark(Watermark watermark) {
        if (bA == 2) {
            if (this.by == null && this.G != null) {
                this.by = new hn(this.mContext, this.G);
            }
            hn hnVar = this.by;
            if (hnVar != null) {
                hnVar.setRecordWatermark(watermark);
            }
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void setStateListener(DuMixStateListener duMixStateListener) {
        bb bbVar = this.G;
        if (bbVar != null) {
            bbVar.setStateListener(duMixStateListener);
        }
    }

    @Override // com.baidu.ar.IDuMix
    public void setup(DuMixInput duMixInput, DuMixOutput duMixOutput, DuMixCallback duMixCallback) {
        ge ew;
        int i;
        kf.c("DuMixController", "setup() sState = " + bA);
        if (duMixInput == null || duMixOutput == null) {
            kf.b("DuMixController", "setup error!!! params maybe null!!!");
            if (duMixCallback != null) {
                duMixCallback.onSetup(false, duMixInput, duMixOutput);
                return;
            }
            return;
        }
        this.ax = duMixInput;
        this.ay = duMixOutput;
        this.az = duMixCallback;
        DefaultParams defaultParams = this.D;
        if (defaultParams == null || !defaultParams.isDigitalArEnable()) {
            ew = ge.ew();
            i = 2;
        } else {
            ew = ge.ew();
            i = 1;
        }
        ew.F(i);
        Handler handler = this.bs;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(3000));
        }
    }

    public boolean startAbility(AbilityType abilityType, HashMap<String, Object> hashMap) {
        if (this.aC == null || abilityType == null || bA != 2) {
            return false;
        }
        return this.aC.a(abilityType.getTypeValue(), hashMap, true);
    }

    @Override // com.baidu.ar.record.IRecord
    public void startRecord(String str, long j, RecordCallback recordCallback) {
        DefaultParams defaultParams;
        if (bA == 2) {
            if (this.by == null && this.G != null) {
                this.by = new hn(this.mContext, this.G);
            }
            g gVar = this.bv;
            if (gVar != null) {
                gVar.n("start");
            }
            if (this.by != null) {
                if (this.ay != null && (defaultParams = this.D) != null && defaultParams.isRecordAutoCrop()) {
                    this.by.l(this.ay.getOutputWidth(), this.ay.getOutputHeight());
                }
                this.by.startRecord(str, j, recordCallback);
            }
        }
    }

    public boolean stopAbility(AbilityType abilityType) {
        if (this.aC == null || abilityType == null || bA != 2) {
            return false;
        }
        return this.aC.a(abilityType.getTypeValue(), true);
    }

    @Override // com.baidu.ar.record.IRecord
    public void stopRecord() {
        if (bA == 2) {
            hn hnVar = this.by;
            if (hnVar != null) {
                hnVar.stopRecord();
                this.by = null;
            }
            g gVar = this.bv;
            if (gVar != null) {
                gVar.n("stop");
            }
        }
    }

    @Override // com.baidu.ar.photo.IPhoto
    public void takePicture(String str, PhotoCallback photoCallback) {
        if (this.G == null || bA != 2) {
            return;
        }
        new gq().a(this.G, str, photoCallback);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFaceFilterWithKneadJson(String str) {
        if (this.ab == null || TextUtils.isEmpty(str) || bA != 2) {
            return;
        }
        this.ab.updateFilter(FilterNode.faceFilter.getNodeName(), FilterParam.FaceFilter.kneadJsonStr.getParamName(), str);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, float f) {
        if (this.ab == null || bA != 2) {
            return;
        }
        this.ab.a(filterParam, Float.valueOf(f));
    }

    @Override // com.baidu.ar.filter.IFilter
    public String updateFilterCase(String str) {
        if (this.ab == null || bA != 2) {
            return null;
        }
        return this.ab.updateFilterCase(str);
    }

    @Override // com.baidu.ar.arplay.core.pixel.IPixelReader
    public void updatePixelReader(PixelReadParams pixelReadParams, PixelRotation pixelRotation) {
        bb bbVar = this.G;
        if (bbVar != null) {
            bbVar.updatePixelReader(pixelReadParams, pixelRotation);
        }
    }

    public boolean addAbility(String str, String str2, String str3) {
        c cVar = this.aC;
        if (cVar != null) {
            return cVar.a(str, Arrays.asList(str2), str3);
        }
        return false;
    }

    public boolean adjustAbility(String str, HashMap<String, Object> hashMap) {
        if (this.aC == null || TextUtils.isEmpty(str) || bA != 2) {
            return false;
        }
        return this.aC.adjustAbility(str, hashMap);
    }

    @Override // com.baidu.ar.IDuMix
    public void changeInputSize(SurfaceTexture surfaceTexture, int i, int i2) {
        kf.c("DuMixController", "changeInputSize width * height = " + i + " * " + i2 + " && texture = " + surfaceTexture);
        Handler handler = this.bs;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(3010, i, i2, surfaceTexture));
        }
    }

    @Deprecated
    public List<Integer> checkAuth(byte[] bArr, ICallbackWith<List<Integer>> iCallbackWith, ICallbackWith<Integer> iCallbackWith2) {
        return ARAuth.checkAuth(this.mContext, bArr, iCallbackWith, iCallbackWith2);
    }

    public boolean isAbilityActive(String str) {
        if (this.aC == null || TextUtils.isEmpty(str) || bA != 2) {
            return false;
        }
        return this.aC.isAbilityActive(str);
    }

    @Override // com.baidu.ar.IDuMix
    public void loadCase(String str, String str2) {
        loadCase(null, str, str2);
    }

    public boolean startAbility(String str, HashMap<String, Object> hashMap) {
        if (this.aC == null || TextUtils.isEmpty(str) || bA != 2) {
            return false;
        }
        return this.aC.a(str, hashMap, true);
    }

    public boolean stopAbility(String str) {
        if (this.aC == null || TextUtils.isEmpty(str) || bA != 2) {
            return false;
        }
        return this.aC.a(str, true);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, int i) {
        if (this.ab == null || bA != 2) {
            return;
        }
        this.ab.a(filterParam, Integer.valueOf(i));
    }

    private void a(Context context, DefaultParams defaultParams) {
        kf.c("DuMixController", "createManagers start!!!");
        if (this.bt == null) {
            this.bt = new Handler(context.getMainLooper());
        }
        kf.ae(defaultParams.isLogEnable());
        ke.setPackageName(context.getPackageName());
        if (this.bx == null) {
            this.bx = new OrientationManager(context);
        }
        StatisticApi.init(context);
        if (this.bv == null) {
            g gVar = new g(context, defaultParams, this.br);
            this.bv = gVar;
            gVar.a(this);
        }
        if (this.W == null) {
            p pVar = new p(context);
            this.W = pVar;
            pVar.c(defaultParams.getGradingConfig());
        }
        if (this.ab == null) {
            this.ab = new ej(defaultParams);
            this.aC = new c(context, this.br.getLooper(), defaultParams, this.W, this.ab);
        }
        if (this.F == null) {
            fs fsVar = new fs(context);
            this.F = fsVar;
            fsVar.setUserPlayAudio(defaultParams.isUserPlayAudio());
        }
        if (defaultParams.getOBRConfig() != null && this.k == null) {
            this.k = new gm(this.mContext, this.F, defaultParams.getOBRConfig());
        }
        if (this.G == null) {
            this.G = defaultParams.isUseTextureIO() ? new bc(context, this.br.getLooper(), this.F, defaultParams.getShareContext(), defaultParams.get3dShaderDBPath()) : new bb(context, this.br.getLooper(), this.F, defaultParams.get3dShaderDBPath());
            if (!TextUtils.isEmpty(defaultParams.getRenderPipeline())) {
                this.G.setDefaultPipeLine(defaultParams.getRenderPipeline());
            }
        }
        kf.c("DuMixController", "createManagers end!!!");
    }

    public boolean addAbility(String str, List<String> list) {
        c cVar = this.aC;
        if (cVar != null) {
            return cVar.a(str, list, (String) null);
        }
        return false;
    }

    @Override // com.baidu.ar.IDuMix
    public void changeInputSize(Texture texture, int i, int i2) {
        kf.c("DuMixController", "changeInputSize width * height = " + i + " * " + i2 + " && texture = " + texture);
        Handler handler = this.bs;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(3010, i, i2, texture));
        }
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, String str) {
        if (this.ab == null || bA != 2) {
            return;
        }
        this.ab.a(filterParam, str);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, List<Point> list) {
        if (list == null || bA != 2) {
            return;
        }
        float[] fArr = new float[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            int i2 = i * 2;
            fArr[i2] = list.get(i).x;
            fArr[i2 + 1] = list.get(i).y;
        }
        ej ejVar = this.ab;
        if (ejVar == null || filterParam == null) {
            return;
        }
        ejVar.a(filterParam.getFilterNode().getNodeName(), filterParam.getParamName(), Integer.valueOf(list.size()), "_count", false);
        this.ab.a(filterParam, fArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CaseModel caseModel) {
        bb bbVar;
        DefaultParams defaultParams = this.D;
        if (defaultParams != null && defaultParams.isDigitalArEnable() && (bbVar = this.G) != null) {
            bbVar.setAvatarGestureConfig();
        }
        DefaultParams defaultParams2 = this.D;
        if (defaultParams2 != null && defaultParams2.getOBRConfig() != null) {
            this.k.eL();
        }
        if (this.bv != null && bA == 2) {
            this.bv.loadCase(caseModel.mCaseType, caseModel.mCasePath, caseModel.mCaseId);
            return;
        }
        kf.b("DuMixController", "handleLoadCase DuMix has not setup!!!!!!");
        DuMixCallback duMixCallback = this.bu;
        if (duMixCallback != null) {
            duMixCallback.onCaseCreate(false, caseModel.mCasePath, caseModel.mCaseId);
        }
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(FilterParam filterParam, float[] fArr) {
        if (this.ab == null || bA != 2) {
            return;
        }
        this.ab.a(filterParam, fArr);
    }

    @Override // com.baidu.ar.filter.IFilter
    public void updateFilter(String str, String str2, Object obj) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.ab == null || bA != 2) {
            return;
        }
        this.ab.updateFilter(str, str2, obj);
    }
}
