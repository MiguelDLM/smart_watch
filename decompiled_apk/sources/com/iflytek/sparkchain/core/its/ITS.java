package com.iflytek.sparkchain.core.its;

import android.util.Log;
import com.iflytek.sparkchain.core.AiHelper;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes10.dex */
public class ITS {
    private static final String TAG = "ITS";
    private ITSCallbacks cbs;
    protected int sid;
    private AtomicInteger usrTagId = new AtomicInteger(0);
    private HashMap<Integer, Object> contextMap = new HashMap<>();

    /* loaded from: classes10.dex */
    public class ITSError {
        private int code;
        private String errMsg;
        private String sid;

        public ITSError() {
        }

        public int getCode() {
            return this.code;
        }

        public String getErrMsg() {
            return this.errMsg;
        }

        public String getSid() {
            return this.sid;
        }

        public void setCode(int i) {
            this.code = i;
        }

        public void setErrMsg(String str) {
            this.errMsg = str;
        }

        public void setSid(String str) {
            this.sid = str;
        }
    }

    /* loaded from: classes10.dex */
    public class ITSResult {
        private String from;
        private String sid;
        private int status;
        private String to;
        private TransResult transResult;

        public ITSResult() {
        }

        public String getFrom() {
            return this.from;
        }

        public String getSid() {
            return this.sid;
        }

        public int getStatus() {
            return this.status;
        }

        public String getTo() {
            return this.to;
        }

        public TransResult getTransResult() {
            return this.transResult;
        }

        public void setFrom(String str) {
            this.from = str;
        }

        public void setSid(String str) {
            this.sid = str;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        public void setTo(String str) {
            this.to = str;
        }

        public void setTransResult(TransResult transResult) {
            this.transResult = transResult;
        }
    }

    /* loaded from: classes10.dex */
    public class TransResult {
        private String dst;
        private String src;

        public TransResult() {
        }

        public String getDst() {
            return this.dst;
        }

        public String getSrc() {
            return this.src;
        }

        public void setDst(String str) {
            this.dst = str;
        }

        public void setSrc(String str) {
            this.src = str;
        }
    }

    /* loaded from: classes10.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17463a;

        public a(int i) {
            this.f17463a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.v(ITS.TAG, "rtasrDestroy:index:" + this.f17463a);
            ITS.this.itsDestroy(this.f17463a);
        }
    }

    public ITS() {
        this.sid = 0;
        this.sid = create(TransType.ITRANS);
    }

    private native int itsArun(int i, String str, int i2);

    private native int itsCreate(String str, String str2, int i);

    private native int itsCreateType(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native void itsDestroy(int i);

    private native void setITSFromlanguage(int i, String str);

    private native void setITSResId(int i, String str);

    private native void setITSTolanguage(int i, String str);

    public int arun(String str, Object obj) {
        int incrementAndGet = this.usrTagId.incrementAndGet();
        this.contextMap.put(Integer.valueOf(incrementAndGet), obj);
        return itsArun(this.sid, str, incrementAndGet);
    }

    public int create(TransType transType) {
        return itsCreateType(transType.ordinal());
    }

    public void finalize() throws Throwable {
        super.finalize();
        AiHelper.getInst().getHandler().postDelayed(new a(this.sid), 1000L);
    }

    public void fromlanguage(String str) {
        setITSFromlanguage(this.sid, str);
    }

    public void itsErrorCallback(ITSError iTSError, int i) {
        Log.i(TAG, "Java itsErrorCallback");
        ITSCallbacks iTSCallbacks = this.cbs;
        if (iTSCallbacks != null) {
            iTSCallbacks.onError(iTSError, this.contextMap.get(Integer.valueOf(i)));
        }
        this.contextMap.remove(Integer.valueOf(i));
    }

    public void itsResultCallback(ITSResult iTSResult, int i) {
        Log.i(TAG, "Java itsResultCallback");
        ITSCallbacks iTSCallbacks = this.cbs;
        if (iTSCallbacks != null) {
            iTSCallbacks.onResult(iTSResult, this.contextMap.get(Integer.valueOf(i)));
        }
        if (iTSResult.getStatus() == 3) {
            this.contextMap.remove(Integer.valueOf(i));
        }
    }

    public void registerCallbacks(ITSCallbacks iTSCallbacks) {
        this.cbs = iTSCallbacks;
    }

    public void resId(String str) {
        setITSResId(this.sid, str);
    }

    public void tolanguage(String str) {
        setITSTolanguage(this.sid, str);
    }

    public ITS(TransType transType) {
        this.sid = 0;
        this.sid = create(transType);
    }

    public int create(String str, String str2, TransType transType) {
        return itsCreate(str, str2, transType.ordinal());
    }

    public ITS(String str, String str2, TransType transType) {
        this.sid = 0;
        this.sid = create(str, str2, transType);
    }
}
