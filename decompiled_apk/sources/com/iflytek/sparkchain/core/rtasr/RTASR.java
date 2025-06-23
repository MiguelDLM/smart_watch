package com.iflytek.sparkchain.core.rtasr;

import android.util.Log;
import com.iflytek.sparkchain.core.AiHelper;
import com.iflytek.sparkchain.core.asr.AudioRecorder;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes10.dex */
public class RTASR implements AudioRecorder.AudioDataCallback {
    private static final String TAG = "RTASR";
    private RTASRCallbacks cbs;
    private AudioRecorder recorder;
    private int sessionId;
    protected int sid;
    private AtomicInteger usrTagId = new AtomicInteger(0);
    private HashMap<Integer, Object> contextMap = new HashMap<>();
    private AtomicBoolean isWrite = new AtomicBoolean(false);

    /* loaded from: classes10.dex */
    public class RtAsrError {
        private int code;
        private String errMsg;
        private String sid;

        public RtAsrError() {
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
    public class RtAsrResult {
        private String data;
        private String rawResult;
        private String sid;
        private int status;
        private RtTransResult transResult;

        public RtAsrResult() {
        }

        public String getData() {
            return this.data;
        }

        public String getRawResult() {
            return this.rawResult;
        }

        public String getSid() {
            return this.sid;
        }

        public int getStatus() {
            return this.status;
        }

        public RtTransResult getTransResult() {
            return this.transResult;
        }

        public void setData(String str) {
            this.data = str;
        }

        public void setRawResult(String str) {
            this.rawResult = str;
        }

        public void setSid(String str) {
            this.sid = str;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        public void setTransResult(RtTransResult rtTransResult) {
            this.transResult = rtTransResult;
        }
    }

    /* loaded from: classes10.dex */
    public class RtTransResult {
        private String dst;
        private String src;
        private int status;

        public RtTransResult() {
        }

        public String getDst() {
            return this.dst;
        }

        public String getSrc() {
            return this.src;
        }

        public int getStatus() {
            return this.status;
        }

        public void setDst(String str) {
            this.dst = str;
        }

        public void setSrc(String str) {
            this.src = str;
        }

        public void setStatus(int i) {
            this.status = i;
        }
    }

    /* loaded from: classes10.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17465a;

        public a(int i) {
            this.f17465a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.v(RTASR.TAG, "rtasrDestroy:index:" + this.f17465a);
            RTASR.this.rtasrDestroy(this.f17465a);
        }
    }

    public RTASR(String str) {
        this.sid = 0;
        this.sid = create(str);
    }

    private native int rtasrCreate(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void rtasrDestroy(int i);

    private native int rtasrStart(int i, int i2);

    private native int rtasrStop(int i);

    private native int rtasrWrite(int i, byte[] bArr);

    private native void setRTASREngLangType(int i, int i2);

    private native void setRTASRLang(int i, String str);

    private native void setRTASRPd(int i, String str);

    private native void setRTASRPunc(int i, String str);

    private native void setRTASRRoleType(int i, int i2);

    private native void setRTASRTargetLang(int i, String str);

    private native void setRTASRTransStrategy(int i, int i2);

    private native void setRTASRTransType(int i, String str);

    private native void setRTASRVadMdn(int i, int i2);

    public void cancel() {
        this.isWrite.set(false);
        RTASRCallbacks rTASRCallbacks = this.cbs;
        if (rTASRCallbacks != null) {
            rTASRCallbacks.onEndOfSpeech();
        }
    }

    public int create(String str) {
        return rtasrCreate(str);
    }

    public void engLangType(int i) {
        setRTASREngLangType(this.sid, i);
    }

    public void finalize() throws Throwable {
        super.finalize();
        AiHelper.getInst().getHandler().postDelayed(new a(this.sid), 1000L);
    }

    public void lang(String str) {
        setRTASRLang(this.sid, str);
    }

    @Override // com.iflytek.sparkchain.core.asr.AudioRecorder.AudioDataCallback
    public void onAudioData(byte[] bArr, int i) {
        if (this.isWrite.get()) {
            write(bArr);
        }
    }

    public void pd(String str) {
        setRTASRPd(this.sid, str);
    }

    public void punc(String str) {
        setRTASRPunc(this.sid, str);
    }

    public void registerCallbacks(RTASRCallbacks rTASRCallbacks) {
        this.cbs = rTASRCallbacks;
    }

    public void roleType(int i) {
        setRTASRRoleType(this.sid, i);
    }

    public void rtasrErrorCallback(RtAsrError rtAsrError, int i) {
        Log.i(TAG, "Java rtasrErrorCallback");
        RTASRCallbacks rTASRCallbacks = this.cbs;
        if (rTASRCallbacks != null) {
            rTASRCallbacks.onError(rtAsrError, this.contextMap.get(Integer.valueOf(i)));
        }
        this.sessionId = i;
        if (this.recorder != null) {
            cancel();
        }
        this.contextMap.remove(Integer.valueOf(i));
    }

    public void rtasrResultCallback(RtAsrResult rtAsrResult, int i) {
        Log.i(TAG, "Java rtasrResultCallback");
        if (rtAsrResult == null) {
            return;
        }
        this.sessionId = i;
        if (rtAsrResult.getStatus() == 3 && this.recorder != null) {
            cancel();
        }
        RTASRCallbacks rTASRCallbacks = this.cbs;
        if (rTASRCallbacks != null) {
            rTASRCallbacks.onResult(rtAsrResult, this.contextMap.get(Integer.valueOf(i)));
        }
        if (rtAsrResult.getStatus() == 3) {
            this.contextMap.remove(Integer.valueOf(i));
        }
    }

    public int start(Object obj) {
        int incrementAndGet = this.usrTagId.incrementAndGet();
        this.contextMap.put(Integer.valueOf(incrementAndGet), obj);
        return rtasrStart(this.sid, incrementAndGet);
    }

    public int startListener(Object obj) {
        if (this.recorder == null) {
            this.recorder = AudioRecorder.getInstance();
        }
        int start = start(obj);
        if (start == 0) {
            this.isWrite.set(true);
            AudioRecorder audioRecorder = this.recorder;
            if (audioRecorder != null) {
                audioRecorder.startRecord();
                this.recorder.registerCallBack(this);
            }
            RTASRCallbacks rTASRCallbacks = this.cbs;
            if (rTASRCallbacks != null) {
                rTASRCallbacks.onBeginOfSpeech();
            }
        }
        return start;
    }

    public int stop() {
        return rtasrStop(this.sid);
    }

    public int stopListener() {
        AudioRecorder audioRecorder = this.recorder;
        if (audioRecorder != null) {
            audioRecorder.stopRecord();
            this.recorder = null;
        }
        return stop();
    }

    public void targetLang(String str) {
        setRTASRTargetLang(this.sid, str);
    }

    public void transStrategy(int i) {
        setRTASRTransStrategy(this.sid, i);
    }

    public void transType(String str) {
        setRTASRTransType(this.sid, str);
    }

    public void vadMdn(int i) {
        setRTASRVadMdn(this.sid, i);
    }

    public int write(byte[] bArr) {
        return rtasrWrite(this.sid, bArr);
    }
}
