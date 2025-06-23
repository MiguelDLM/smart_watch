package com.baidu.ar;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.IAuthCallback;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.bean.CaseModel;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.fp;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class g {
    private DefaultParams D;
    private fs F;
    private bb G;
    private List<Integer> aA;
    private ft aB;
    private c aC;
    private CaseModel aG;
    private String aH;
    private String aI;
    private CaseModel aK;
    private a aR;
    private ej ab;
    private DuMixInput ax;
    private DuMixOutput ay;
    protected DuMixCallback az;
    private Context mContext;
    private boolean aD = false;
    private boolean aE = false;
    private boolean aF = false;
    private volatile boolean aJ = false;
    private boolean aL = false;
    private boolean aM = true;
    private boolean aN = false;
    private boolean aO = false;
    private boolean aP = false;
    private boolean aQ = true;
    private ConcurrentHashMap<PixelReadParams, PixelReadListener> aS = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ar.g$8, reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] aW;

        static {
            int[] iArr = new int[ARType.values().length];
            aW = iArr;
            try {
                iArr[ARType.IMU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aW[ARType.TRACK_2D.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aW[ARType.CLOUD_IR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                aW[ARType.ON_DEVICE_IR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                aW[ARType.VO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 4001:
                    kf.c("ControllerHelper", "CaseHandler MSG_CREATE_CASE");
                    CaseModel caseModel = (CaseModel) message.obj;
                    g.this.c(caseModel.mCaseType, caseModel.mCasePath, caseModel.mCaseId);
                    return;
                case 4002:
                    kf.c("ControllerHelper", "CaseHandler MSG_DESTROY_CASE");
                    g.this.I();
                    return;
                case 4003:
                    kf.c("ControllerHelper", "CaseHandler MSG_ON_FILTER_CREATE");
                    g.this.J();
                    return;
                case 4004:
                    kf.c("ControllerHelper", "CaseHandler MSG_ON_FILTER_CHANGE");
                    g.this.c((List<String>) ((HashMap) message.obj).get("filter_name_list"));
                    return;
                case 4005:
                    kf.c("ControllerHelper", "CaseHandler MSG_ON_ENGINE_CREATE");
                    g.this.K();
                    return;
                case 4006:
                    kf.c("ControllerHelper", "CaseHandler MSG_ON_ENGINE_DESTROY");
                    g.this.L();
                    return;
                case 4007:
                    kf.c("ControllerHelper", "CaseHandler MSG_ON_CASE_CREATE");
                    g.this.M();
                    return;
                case 4008:
                    kf.c("ControllerHelper", "CaseHandler MSG_ON_CASE_DESTROY");
                    g.this.N();
                    return;
                default:
                    return;
            }
        }
    }

    public g(Context context, DefaultParams defaultParams, HandlerThread handlerThread) {
        this.mContext = context;
        this.D = defaultParams;
        this.aR = new a(handlerThread.getLooper());
    }

    private void A() {
        this.aA = Arrays.asList(12, 50, 6, 7, 8, 9);
        ft ftVar = new ft() { // from class: com.baidu.ar.g.3
            @Override // com.baidu.ar.ft
            public void a(int i, int i2, HashMap<String, Object> hashMap) {
                a aVar;
                a aVar2;
                int i3;
                Message message;
                kf.u("ControllerHelper", "DigitalTime onEngineMessage msgType = " + i + " && msgId = " + i2);
                kf.c("ControllerHelper", "onEngineMessage msgType = " + i + " && msgId = " + i2);
                if (i != 12) {
                    if (i == 50) {
                        if (g.this.aR != null) {
                            aVar = g.this.aR;
                            message = g.this.aR.obtainMessage(4004, hashMap);
                            aVar.sendMessage(message);
                        }
                        return;
                    }
                    switch (i) {
                        case 6:
                            if (g.this.aR != null) {
                                aVar = g.this.aR;
                                aVar2 = g.this.aR;
                                i3 = 4005;
                                break;
                            } else {
                                return;
                            }
                        case 7:
                            if (g.this.aR != null) {
                                aVar = g.this.aR;
                                aVar2 = g.this.aR;
                                i3 = 4006;
                                break;
                            } else {
                                return;
                            }
                        case 8:
                            g.this.G.updateDeviceOrientation();
                            if (g.this.aR != null) {
                                aVar = g.this.aR;
                                aVar2 = g.this.aR;
                                i3 = 4007;
                                break;
                            } else {
                                return;
                            }
                        case 9:
                            if (g.this.aR != null) {
                                aVar = g.this.aR;
                                aVar2 = g.this.aR;
                                i3 = 4008;
                                break;
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                } else {
                    if (g.this.aR == null) {
                        return;
                    }
                    aVar = g.this.aR;
                    aVar2 = g.this.aR;
                    i3 = 4003;
                }
                message = aVar2.obtainMessage(i3);
                aVar.sendMessage(message);
            }

            @Override // com.baidu.ar.ft
            public List<Integer> q() {
                return g.this.aA;
            }
        };
        this.aB = ftVar;
        fs fsVar = this.F;
        if (fsVar != null) {
            fsVar.c(ftVar);
        }
    }

    private void B() {
        fn.load(this.mContext, new ILibLoader.b() { // from class: com.baidu.ar.g.4
            @Override // com.baidu.ar.libloader.ILibLoader.b
            public void a(DuMixErrorType duMixErrorType, Exception exc) {
                g gVar = g.this;
                DuMixCallback duMixCallback = gVar.az;
                if (duMixCallback != null) {
                    duMixCallback.onSetup(false, gVar.ax, g.this.ay);
                    if (exc != null) {
                        g.this.az.onError(duMixErrorType, exc.getMessage(), "");
                    }
                }
            }

            @Override // com.baidu.ar.libloader.ILibLoader.b
            public void onSuccess() {
            }
        });
    }

    private void C() {
        ARAuth.loadAuthInfo(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        Bitmap createTipBitmap;
        if (this.G == null || this.ay == null || (createTipBitmap = ARAuth.createTipBitmap(this.mContext)) == null) {
            return;
        }
        float outputWidth = ((this.ay.getOutputWidth() * createTipBitmap.getHeight()) * 0.78125f) / (this.ay.getOutputHeight() * createTipBitmap.getWidth());
        this.G.a(createTipBitmap, 0.109375f, (0.25f - outputWidth) / 2.0f, 0.78125f, outputWidth);
    }

    private void G() {
        if (this.aC == null) {
            return;
        }
        if (this.aN && this.aK != null && H()) {
            this.aC.i();
        } else {
            this.aC.h();
        }
    }

    private boolean H() {
        ARType aRType = this.aK.mCaseType;
        return (aRType == null || aRType == ARType.FACE) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        G();
        bb bbVar = this.G;
        if (bbVar != null) {
            bbVar.bt();
        }
        StatisticApi.onEventEnd(StatisticConstants.EVENT_CASE_END);
        ej ejVar = this.ab;
        if (ejVar != null) {
            ejVar.clearCaseLutFilter();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.aD = true;
        ej ejVar = this.ab;
        if (ejVar != null && !this.aO) {
            ejVar.dC();
        }
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        c cVar = this.aC;
        if (cVar != null) {
            cVar.g();
        }
        bb bbVar = this.G;
        if (bbVar != null) {
            bbVar.o(true);
        }
        this.aE = true;
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        DuMixCallback duMixCallback = this.az;
        if (duMixCallback != null) {
            duMixCallback.onRelease();
            this.az = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        a aVar;
        this.aL = true;
        this.aO = false;
        c cVar = this.aC;
        if (cVar != null) {
            cVar.onCaseCreate(this.aH + File.separator + "ar");
        }
        if ((this.aN || this.aP) && (aVar = this.aR) != null) {
            aVar.removeMessages(4002);
            a aVar2 = this.aR;
            aVar2.sendMessage(aVar2.obtainMessage(4002));
        } else {
            this.aM = true;
        }
        DuMixCallback duMixCallback = this.az;
        if (duMixCallback != null) {
            duMixCallback.onCaseCreate(true, this.aH, this.aI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        CaseModel caseModel;
        this.aL = false;
        G();
        c cVar = this.aC;
        if (cVar != null) {
            cVar.onCaseDestroy();
        }
        if (!this.aN || (caseModel = this.aK) == null || this.aR == null) {
            this.aM = true;
            this.aH = null;
            this.aI = null;
            ej ejVar = this.ab;
            if (ejVar != null) {
                ejVar.av(null);
            }
        } else {
            this.aO = true;
            CaseModel caseModel2 = new CaseModel(caseModel.mCaseType, caseModel.mCasePath, caseModel.mCaseId);
            this.aR.removeMessages(4001);
            a aVar = this.aR;
            aVar.sendMessageDelayed(aVar.obtainMessage(4001, caseModel2), 100L);
        }
        this.aK = null;
        this.aN = false;
        this.aP = false;
        DuMixCallback duMixCallback = this.az;
        if (duMixCallback != null) {
            duMixCallback.onCaseDestroy();
        }
    }

    private void O() {
        DuMixCallback duMixCallback;
        if (!this.aD || !this.aE || this.aF || (duMixCallback = this.az) == null) {
            return;
        }
        this.aF = true;
        duMixCallback.onSetup(true, this.ax, this.ay);
    }

    private void P() {
        HashMap hashMap = new HashMap();
        hashMap.put("continuous_mapping", p("interaction_plane_move"));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("limit_radius", 1);
        hashMap2.put("radius_min", Float.valueOf(0.0f));
        hashMap2.put("radius_max", Float.valueOf(3000.0f));
        hashMap2.put("limit_step_length", 1);
        hashMap2.put("step_length", Float.valueOf(80.0f));
        hashMap2.put("limit_far_frustum", 1);
        hashMap2.put("move_leave_callback", 1);
        hashMap.put("plane_move_config", hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("limit_world_axis", 1);
        hashMap3.put("world_axis", "y");
        hashMap.put("rotate_config", hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put("limit_distance_factor", 1);
        hashMap.put("scale_config", hashMap4);
        ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("interactioninfo", hashMap);
    }

    public static String getSoDownLoadDir(Context context) {
        if (context == null) {
            kf.b("ControllerHelper", "get so download dir error");
            return null;
        }
        File file = new File(context.getFilesDir(), "arlibs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private HashMap<String, Object> p(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("gesture_scroll", str);
        hashMap.put("gesture_two_finger_scroll", "interaction_rotate");
        hashMap.put("gesture_two_finger_pinch", "interaction_scale_down");
        hashMap.put("gesture_two_finger_unpinch", "interaction_scale_up");
        return hashMap;
    }

    public void D() {
        if (f.m(this.mContext.getPackageName())) {
            ARAuth.loadWhiteAuthInfo(this.mContext);
        } else {
            ARAuth.doAuth(this.mContext, new IAuthCallback() { // from class: com.baidu.ar.g.7
                private boolean aV = false;

                @Override // com.baidu.ar.auth.IAuthCallback
                public void onError(String str, int i) {
                    kf.b("ControllerHelper", String.format("auth fail feature: %d msg: %s", Integer.valueOf(i), str));
                    if (i == 0) {
                        g.this.aJ = true;
                        if (g.this.aR != null) {
                            g.this.aR.sendMessage(g.this.aR.obtainMessage(4002));
                        }
                    }
                    if (this.aV || !ARAuth.isShowAuthTip()) {
                        return;
                    }
                    this.aV = true;
                    g.this.F();
                }

                @Override // com.baidu.ar.auth.IAuthCallback
                public void onSuccess() {
                    kf.c("ControllerHelper", "auth success");
                }
            });
        }
    }

    public void E() {
        ConcurrentHashMap<PixelReadParams, PixelReadListener> concurrentHashMap = this.aS;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return;
        }
        for (Map.Entry<PixelReadParams, PixelReadListener> entry : this.aS.entrySet()) {
            this.G.createPixelReader(entry.getKey(), entry.getValue());
        }
        this.aS.clear();
    }

    public void clearCase() {
        kf.u("ControllerHelper", "DigitalTime clearCase mLoadCaseEnable = " + this.aM + " && mCaseLoaded = " + this.aL);
        kf.c("ControllerHelper", "clearCase mLoadCaseEnable = " + this.aM + " && mCaseLoaded = " + this.aL);
        if (this.aM && this.aL) {
            this.aM = false;
            a aVar = this.aR;
            if (aVar != null) {
                aVar.sendMessage(aVar.obtainMessage(4002));
            }
        } else {
            this.aK = null;
            this.aP = true;
        }
        this.aG = null;
    }

    public void loadCase(ARType aRType, String str, String str2) {
        if (this.aJ) {
            kf.b("ControllerHelper", "auth rejected");
            return;
        }
        CaseModel caseModel = new CaseModel(aRType, str, str2);
        CaseModel caseModel2 = this.aG;
        if (caseModel2 == null || !caseModel.equals(caseModel2)) {
            this.aG = caseModel;
            fn.prepareCaseRes(aRType, str, str2, new ILibLoader.a() { // from class: com.baidu.ar.g.1
                @Override // com.baidu.ar.libloader.ILibLoader.a
                public void a(ARType aRType2, String str3, String str4) {
                    g.this.b(aRType2, str3, str4);
                }

                @Override // com.baidu.ar.libloader.ILibLoader.a
                public void a(DuMixErrorType duMixErrorType, String str3) {
                    DuMixCallback duMixCallback = g.this.az;
                    if (duMixCallback != null) {
                        duMixCallback.onError(duMixErrorType, str3, "");
                    }
                }
            });
            return;
        }
        kf.u("ControllerHelper", "DigitalTime loadCase() case has loaded!!!:" + str);
        kf.c("ControllerHelper", "loadCase() case has loaded!!!");
        DuMixCallback duMixCallback = this.az;
        if (duMixCallback != null) {
            duMixCallback.onCaseCreate(true, str, str2);
        }
    }

    public void n(String str) {
        a("recorder_video", "msg", str);
    }

    public void o(String str) {
        a("dumix_system_message", "system_message", str);
    }

    public void release() {
        ConcurrentHashMap<PixelReadParams, PixelReadListener> concurrentHashMap = this.aS;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.aS = null;
        }
        this.G = null;
        this.aC = null;
        this.ab = null;
        this.ax = null;
        this.ay = null;
        this.mContext = null;
        this.D = null;
        this.aA = null;
        this.aB = null;
        this.F = null;
        this.aR = null;
    }

    public void setup(DuMixInput duMixInput, DuMixOutput duMixOutput, DuMixCallback duMixCallback) {
        this.ax = duMixInput;
        this.ay = duMixOutput;
        this.az = duMixCallback;
        A();
        C();
        B();
    }

    public void v() {
        a aVar = this.aR;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
        }
    }

    private void a(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("continuous_mapping", p("interaction_space_move"));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("limit_radius_invariant", Integer.valueOf(i));
        hashMap.put("space_move_config", hashMap2);
        ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("interactioninfo", hashMap);
    }

    private void b(ARType aRType) {
        int i = AnonymousClass8.aW[aRType.ordinal()];
        if (i == 1) {
            a(1);
            return;
        }
        if (i == 2 || i == 3 || i == 4) {
            a(0);
        } else {
            if (i != 5) {
                return;
            }
            P();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ARType aRType, String str, String str2) {
        c cVar;
        if (this.aJ) {
            kf.b("ControllerHelper", "handleCreateCase ignored; auth rejected");
            return;
        }
        if (aRType != null) {
            ARConfig.setARType(aRType.getTypeValue());
            b(aRType);
        }
        ARConfig.setARKey(str2);
        boolean z = false;
        if (this.aQ) {
            this.aQ = false;
            StatisticApi.onEvent(StatisticConstants.EVENT_CASE_FIRST);
        }
        StatisticApi.onEventStart(StatisticConstants.EVENT_CASE_START);
        if (this.G != null && !TextUtils.isEmpty(str)) {
            String substring = str.substring(0, str.lastIndexOf(File.separator + "ar"));
            this.aH = substring;
            this.aI = str2;
            ej ejVar = this.ab;
            if (ejVar != null) {
                ejVar.av(substring);
            }
            bb bbVar = this.G;
            if (!this.D.isUseInputSizeInEngine() && aRType != ARType.FACE && aRType != ARType.VPAS) {
                z = true;
            }
            bbVar.p(z);
            this.G.J(str);
        }
        if (aRType == null || (cVar = this.aC) == null) {
            return;
        }
        cVar.a(aRType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ARType aRType, String str, String str2) {
        a aVar;
        Message obtainMessage;
        kf.c("ControllerHelper", "executeLoadCase arType = " + aRType + " && casePath = " + str + "&& mLoadCaseEnable = " + this.aM + " && mCaseSwitched = " + this.aN);
        if (!ARType.ON_DEVICE_IR.equals(aRType) && !ARType.CLOUD_IR.equals(aRType) && TextUtils.isEmpty(str)) {
            kf.b("ControllerHelper", "casePath is empty!!!");
            DuMixCallback duMixCallback = this.az;
            if (duMixCallback != null) {
                duMixCallback.onCaseCreate(false, str, str2);
                return;
            }
            return;
        }
        if (this.aJ) {
            kf.b("ControllerHelper", "auth rejected");
            return;
        }
        CaseModel caseModel = new CaseModel(aRType, str + File.separator + "ar", str2);
        if (this.aM) {
            this.aM = false;
            kf.c("ControllerHelper", "executeLoadCase mCaseLoaded = " + this.aL);
            if (this.aL) {
                this.aK = caseModel;
                this.aN = true;
                aVar = this.aR;
                obtainMessage = aVar.obtainMessage(4002);
            } else {
                aVar = this.aR;
                obtainMessage = aVar.obtainMessage(4001, caseModel);
            }
            aVar.sendMessage(obtainMessage);
        } else {
            this.aK = caseModel;
            this.aN = true;
        }
        this.aP = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<String> list) {
        ej ejVar = this.ab;
        if (ejVar != null) {
            ejVar.f(list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v7, types: [com.baidu.ar.libloader.ILibLoader] */
    public void a(DuMixController duMixController) {
        fp fpVar;
        String soDownLoadDir = getSoDownLoadDir(this.mContext);
        Object a2 = kr.a("com.baidu.ar.remoteres.RemoteResLoader", new Class[]{DuMixController.class, String.class}, new Object[]{duMixController, soDownLoadDir});
        if (a2 != null) {
            fpVar = (ILibLoader) a2;
        } else if (TextUtils.isEmpty(soDownLoadDir) || fn.isRegistered()) {
            fn.eg();
            return;
        } else {
            fp fpVar2 = new fp(soDownLoadDir);
            fpVar2.a(new fp.a() { // from class: com.baidu.ar.g.2
                @Override // com.baidu.ar.fp.a
                public void a(String str, String str2) {
                    DuMixCallback duMixCallback = g.this.az;
                    if (duMixCallback != null) {
                        duMixCallback.onError(DuMixErrorType.LibraryError, str2, str);
                    }
                }
            });
            fpVar = fpVar2;
        }
        fn.a(fpVar);
    }

    public void a(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        ConcurrentHashMap<PixelReadParams, PixelReadListener> concurrentHashMap = this.aS;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(pixelReadParams, pixelReadListener);
        }
    }

    public void a(bb bbVar, c cVar, ej ejVar, fs fsVar) {
        this.G = bbVar;
        this.aC = cVar;
        this.ab = ejVar;
        this.F = fsVar;
    }

    public void a(final p pVar) {
        if (pVar != null) {
            pVar.a(new ICallbackWith<String>() { // from class: com.baidu.ar.g.5
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: q, reason: merged with bridge method [inline-methods] */
                public void run(String str) {
                    DuMixCallback duMixCallback = g.this.az;
                    if (duMixCallback != null) {
                        duMixCallback.onError(DuMixErrorType.AbilitySchemeFetchFail, str, null);
                    }
                }
            });
            pVar.b(new ICallbackWith<JSONObject>() { // from class: com.baidu.ar.g.6
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public void run(JSONObject jSONObject) {
                    if (g.this.G != null) {
                        if (jSONObject != null) {
                            g.this.G.a(jSONObject);
                        } else if (pVar != null) {
                            g.this.G.setLocalDeviceGrade(pVar.ar());
                        }
                    }
                }
            });
        }
    }

    private void a(String str, String str2, String str3) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("event_name", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(str2, str3);
        hashMap.put("event_data", hashMap2);
        fs fsVar = this.F;
        if (fsVar != null) {
            fsVar.b(1902, hashMap);
        }
    }
}
