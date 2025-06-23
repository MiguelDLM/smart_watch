package com.iflytek.sparkchain.core.raasr;

import android.util.Log;
import com.iflytek.sparkchain.core.AiHelper;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes10.dex */
public class RAASR {
    private static final String TAG = "RAASR";
    private RAASRCallbacks cbs;
    protected int sid;
    private AtomicInteger usrTagId = new AtomicInteger(0);
    private HashMap<Integer, Object> contextMap = new HashMap<>();

    /* loaded from: classes10.dex */
    public class RaAsrError {
        private int code;
        private String errMsg;
        private int failType;
        private String orderId;

        public RaAsrError() {
        }

        public int getCode() {
            return this.code;
        }

        public String getErrMsg() {
            return this.errMsg;
        }

        public int getFailType() {
            return this.failType;
        }

        public String getOrderId() {
            return this.orderId;
        }

        public void setCode(int i) {
            this.code = i;
        }

        public void setErrMsg(String str) {
            this.errMsg = str;
        }

        public void setFailType(int i) {
            this.failType = i;
        }

        public void setOrderId(String str) {
            this.orderId = str;
        }
    }

    /* loaded from: classes10.dex */
    public class RaAsrResult {
        private int code;
        private String descInfo;
        private long expireTime;
        private int failType;
        private String orderId;
        private String orderResult;
        private long originalDuration;
        private long realDuration;
        private int status;
        private int taskEstimateTime;
        private RaAsrTransResult[] transResult;

        public RaAsrResult() {
        }

        public int getCode() {
            return this.code;
        }

        public String getDescInfo() {
            return this.descInfo;
        }

        public long getExpireTime() {
            return this.expireTime;
        }

        public int getFailType() {
            return this.failType;
        }

        public String getOrderId() {
            return this.orderId;
        }

        public String getOrderResult() {
            return this.orderResult;
        }

        public long getOriginalDuration() {
            return this.originalDuration;
        }

        public long getRealDuration() {
            return this.realDuration;
        }

        public int getStatus() {
            return this.status;
        }

        public int getTaskEstimateTime() {
            return this.taskEstimateTime;
        }

        public RaAsrTransResult[] getTransResult() {
            return this.transResult;
        }

        public void setCode(int i) {
            this.code = i;
        }

        public void setDescInfo(String str) {
            this.descInfo = str;
        }

        public void setExpireTime(long j) {
            this.expireTime = j;
        }

        public void setFailType(int i) {
            this.failType = i;
        }

        public void setOrderId(String str) {
            this.orderId = str;
        }

        public void setOrderResult(String str) {
            this.orderResult = str;
        }

        public void setOriginalDuration(long j) {
            this.originalDuration = j;
        }

        public void setRealDuration(long j) {
            this.realDuration = j;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        public void setTaskEstimateTime(int i) {
            this.taskEstimateTime = i;
        }

        public void setTransResult(RaAsrTransResult[] raAsrTransResultArr) {
            this.transResult = raAsrTransResultArr;
        }
    }

    /* loaded from: classes10.dex */
    public class RaAsrTransResult {
        private int bg;
        private String dst;
        private int ed;
        private String[] roles;
        private String segId;
        private String[] tags;

        public RaAsrTransResult() {
        }

        public int getBg() {
            return this.bg;
        }

        public String getDst() {
            return this.dst;
        }

        public int getEd() {
            return this.ed;
        }

        public String[] getRoles() {
            return this.roles;
        }

        public String getSegId() {
            return this.segId;
        }

        public String[] getTags() {
            return this.tags;
        }

        public void setBg(int i) {
            this.bg = i;
        }

        public void setDst(String str) {
            this.dst = str;
        }

        public void setEd(int i) {
            this.ed = i;
        }

        public void setRoles(String[] strArr) {
            this.roles = strArr;
        }

        public void setSegId(String str) {
            this.segId = str;
        }

        public void setTags(String[] strArr) {
            this.tags = strArr;
        }
    }

    /* loaded from: classes10.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17464a;

        public a(int i) {
            this.f17464a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.v(RAASR.TAG, "raasrDestroy:index:" + this.f17464a);
            RAASR.this.raasrDestroy(this.f17464a);
        }
    }

    public RAASR(String str) {
        this.sid = 0;
        this.sid = create(str);
    }

    private native int raasrCreate(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void raasrDestroy(int i);

    private native int raasrGetResultOnceAsync(int i, String str, String str2, int i2);

    private native int raasrStop(int i);

    private native int raasrUploadAsync(int i, String str, int i2);

    private native void setRAASRAudioMode(int i, String str);

    private native void setRAASRAudioUrl(int i, String str);

    private native void setRAASRCandidate(int i, int i2);

    private native void setRAASREngColloqproc(int i, boolean z);

    private native void setRAASREngRlang(int i, int i2);

    private native void setRAASREngSegMax(int i, int i2);

    private native void setRAASREngSegMin(int i, int i2);

    private native void setRAASREngSegWeight(int i, float f);

    private native void setRAASREngSmoothproc(int i, boolean z);

    private native void setRAASREngVadMargin(int i, int i2);

    private native void setRAASREngVadMdn(int i, int i2);

    private native void setRAASRHotWord(int i, String str);

    private native void setRAASRLanguage(int i, String str);

    private native void setRAASRLanguageType(int i, int i2);

    private native void setRAASRPd(int i, String str);

    private native void setRAASRRoleNum(int i, int i2);

    private native void setRAASRRoleType(int i, int i2);

    private native void setRAASRStandardWav(int i, int i2);

    private native void setRAASRTrackMode(int i, int i2);

    private native void setRAASRTransLanguage(int i, String str);

    private native void setRAASRTransMode(int i, int i2);

    public void audioMode(String str) {
        setRAASRAudioMode(this.sid, str);
    }

    public void audioUrl(String str) {
        setRAASRAudioUrl(this.sid, str);
    }

    public void candidate(int i) {
        setRAASRCandidate(this.sid, i);
    }

    public int create(String str) {
        return raasrCreate(str);
    }

    public void engColloqproc(boolean z) {
        setRAASREngColloqproc(this.sid, z);
    }

    public void engRlang(int i) {
        setRAASREngRlang(this.sid, i);
    }

    public void engSegMax(int i) {
        setRAASREngSegMax(this.sid, i);
    }

    public void engSegMin(int i) {
        setRAASREngSegMin(this.sid, i);
    }

    public void engSegWeight(float f) {
        setRAASREngSegWeight(this.sid, f);
    }

    public void engSmoothproc(boolean z) {
        setRAASREngSmoothproc(this.sid, z);
    }

    public void engVadMargin(int i) {
        setRAASREngVadMargin(this.sid, i);
    }

    public void engVadMdn(int i) {
        setRAASREngVadMdn(this.sid, i);
    }

    public void finalize() throws Throwable {
        super.finalize();
        AiHelper.getInst().getHandler().postDelayed(new a(this.sid), 1000L);
    }

    public int getResultOnceAsync(String str, String str2, Object obj) {
        int incrementAndGet = this.usrTagId.incrementAndGet();
        this.contextMap.put(Integer.valueOf(incrementAndGet), obj);
        return raasrGetResultOnceAsync(this.sid, str, str2, incrementAndGet);
    }

    public void hotWord(String str) {
        setRAASRHotWord(this.sid, str);
    }

    public void language(String str) {
        setRAASRLanguage(this.sid, str);
    }

    public void languageType(int i) {
        setRAASRLanguageType(this.sid, i);
    }

    public void pd(String str) {
        setRAASRPd(this.sid, str);
    }

    public void raasrErrorCallback(RaAsrError raAsrError, int i) {
        Log.i(TAG, "Java raasrErrorCallback");
        RAASRCallbacks rAASRCallbacks = this.cbs;
        if (rAASRCallbacks != null) {
            rAASRCallbacks.onError(raAsrError, this.contextMap.get(Integer.valueOf(i)));
        }
        this.contextMap.remove(Integer.valueOf(i));
    }

    public void raasrResultCallback(RaAsrResult raAsrResult, int i) {
        Log.i(TAG, "Java raasrResultCallback");
        RAASRCallbacks rAASRCallbacks = this.cbs;
        if (rAASRCallbacks != null) {
            rAASRCallbacks.onResult(raAsrResult, this.contextMap.get(Integer.valueOf(i)));
        }
        this.contextMap.remove(Integer.valueOf(i));
    }

    public void registerCallbacks(RAASRCallbacks rAASRCallbacks) {
        this.cbs = rAASRCallbacks;
    }

    public void roleNum(int i) {
        setRAASRRoleNum(this.sid, i);
    }

    public void roleType(int i) {
        setRAASRRoleType(this.sid, i);
    }

    public void standardWav(int i) {
        setRAASRStandardWav(this.sid, i);
    }

    public int stop() {
        return raasrStop(this.sid);
    }

    public void trackMode(int i) {
        setRAASRTrackMode(this.sid, i);
    }

    public void transLanguage(String str) {
        setRAASRTransLanguage(this.sid, str);
    }

    public void transMode(int i) {
        setRAASRTransMode(this.sid, i);
    }

    public int uploadAsync(String str, Object obj) {
        int incrementAndGet = this.usrTagId.incrementAndGet();
        this.contextMap.put(Integer.valueOf(incrementAndGet), obj);
        return raasrUploadAsync(this.sid, str, incrementAndGet);
    }
}
