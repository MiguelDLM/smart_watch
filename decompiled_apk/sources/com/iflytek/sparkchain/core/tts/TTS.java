package com.iflytek.sparkchain.core.tts;

import android.util.Log;
import com.iflytek.sparkchain.core.AiHelper;
import com.iflytek.sparkchain.core.Const;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes10.dex */
public class TTS {
    private static final String TAG = "TTS";
    private TTSCallbacks cbs;
    protected int sid;
    private AtomicInteger usrTagId = new AtomicInteger(0);
    private HashMap<Integer, Object> contextMap = new HashMap<>();

    /* loaded from: classes10.dex */
    public enum RequestType implements Const {
        Auto(0),
        OffLine(1),
        Online(2);

        private final int value;

        RequestType(int i) {
            this.value = i;
        }

        @Override // com.iflytek.sparkchain.core.Const
        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes10.dex */
    public class TTSError {
        private int code;
        private int engineType;
        private String errMsg;
        private String sid;

        public TTSError() {
        }

        public int getCode() {
            return this.code;
        }

        public int getEngineType() {
            return this.engineType;
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

        public void setEngineType(int i) {
            this.engineType = i;
        }

        public void setErrMsg(String str) {
            this.errMsg = str;
        }

        public void setSid(String str) {
            this.sid = str;
        }
    }

    /* loaded from: classes10.dex */
    public class TTSEvent {
        private int engineType;
        private String phoneme;
        private String progressLen;
        private String progressPoi;
        private String sid;
        private int type;

        public TTSEvent() {
        }

        public int getEngineType() {
            return this.engineType;
        }

        public String getPhoneme() {
            return this.phoneme;
        }

        public String getProgressLen() {
            return this.progressLen;
        }

        public String getProgressPoi() {
            return this.progressPoi;
        }

        public String getSid() {
            return this.sid;
        }

        public int getType() {
            return this.type;
        }

        public void setEngineType(int i) {
            this.engineType = i;
        }

        public void setPhoneme(String str) {
            this.phoneme = str;
        }

        public void setProgressLen(String str) {
            this.progressLen = str;
        }

        public void setProgressPoi(String str) {
            this.progressPoi = str;
        }

        public void setSid(String str) {
            this.sid = str;
        }

        public void setType(int i) {
            this.type = i;
        }
    }

    /* loaded from: classes10.dex */
    public class TTSResult {
        private String ced;
        private byte[] data;
        private int engineType;
        private int len;
        private String pybuf;
        private int seq;
        private String sid;
        private int status;
        private String version;

        public TTSResult() {
        }

        public String getCed() {
            return this.ced;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getEngineType() {
            return this.engineType;
        }

        public int getLen() {
            return this.len;
        }

        public String getPybuf() {
            return this.pybuf;
        }

        public int getSeq() {
            return this.seq;
        }

        public String getSid() {
            return this.sid;
        }

        public int getStatus() {
            return this.status;
        }

        public String getVersion() {
            return this.version;
        }

        public void setCed(String str) {
            this.ced = str;
        }

        public void setData(byte[] bArr) {
            this.data = bArr;
        }

        public void setEngineType(int i) {
            this.engineType = i;
        }

        public void setLen(int i) {
            this.len = i;
        }

        public void setPybuf(String str) {
            this.pybuf = str;
        }

        public void setSeq(int i) {
            this.seq = i;
        }

        public void setSid(String str) {
            this.sid = str;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        public void setVersion(String str) {
            this.version = str;
        }
    }

    public TTS(String str) {
        this.sid = 0;
        this.sid = create(str);
    }

    private native void setTTSBgs(int i, int i2);

    private native void setTTSBitDepth(int i, int i2);

    private native void setTTSChannels(int i, int i2);

    private native void setTTSEmotion(int i, int i2);

    private native void setTTSEncoding(int i, String str);

    private native void setTTSFrameSize(int i, int i2);

    private native void setTTSL5SilLen(int i, int i2);

    private native void setTTSParagraphSilLen(int i, int i2);

    private native void setTTSPitch(int i, int i2);

    private native void setTTSRdn(int i, int i2);

    private native void setTTSReg(int i, int i2);

    private native void setTTSRhy(int i, boolean z);

    private native void setTTSSampleRate(int i, int i2);

    private native void setTTSScn(int i, int i2);

    private native void setTTSSpeed(int i, int i2);

    private native void setTTSVcn(int i, String str);

    private native void setTTSVersion(int i, boolean z);

    private native void setTTSVolume(int i, int i2);

    private native int ttsArun(int i, String str, int i2);

    private native int ttsArunStream(int i, String str, int i2, int i3);

    private native int ttsCreate(String str, String str2, int i);

    private native void ttsStop(int i);

    public int aRun(String str) {
        return ttsArunStream(this.sid, str, 2, 0);
    }

    public void bgs(int i) {
        setTTSBgs(this.sid, i);
    }

    public void bitDepth(int i) {
        setTTSBitDepth(this.sid, i);
    }

    public void channels(int i) {
        setTTSChannels(this.sid, i);
    }

    public int create(String str) {
        return create(str, RequestType.Online.getValue());
    }

    public void emotion(int i) {
        setTTSEmotion(this.sid, i);
    }

    public void encoding(String str) {
        setTTSEncoding(this.sid, str);
    }

    public void finalize() throws Throwable {
        super.finalize();
        AiHelper.getInst().ttsObjDestroy(this.sid);
    }

    public void frameSize(int i) {
        setTTSFrameSize(this.sid, i);
    }

    public void l5SilLen(int i) {
        setTTSL5SilLen(this.sid, i);
    }

    public void paragraphSilLen(int i) {
        setTTSParagraphSilLen(this.sid, i);
    }

    public void pitch(int i) {
        setTTSPitch(this.sid, i);
    }

    public void rdn(int i) {
        setTTSRdn(this.sid, i);
    }

    public void reg(int i) {
        setTTSReg(this.sid, i);
    }

    public void registerCallbacks(TTSCallbacks tTSCallbacks) {
        this.cbs = tTSCallbacks;
    }

    public void rhy(boolean z) {
        setTTSRhy(this.sid, z);
    }

    public void sampleRate(int i) {
        setTTSSampleRate(this.sid, i);
    }

    public void scn(int i) {
        setTTSScn(this.sid, i);
    }

    public void speed(int i) {
        setTTSSpeed(this.sid, i);
    }

    public void stop() {
        ttsStop(this.sid);
    }

    public void ttsErrorCallback(TTSError tTSError, int i) {
        Log.i(TAG, "Java ttsErrorCallback");
        TTSCallbacks tTSCallbacks = this.cbs;
        if (tTSCallbacks != null) {
            tTSCallbacks.onError(tTSError, this.contextMap.get(Integer.valueOf(i)));
        }
        this.contextMap.remove(Integer.valueOf(i));
    }

    public void ttsEventCallback(TTSEvent tTSEvent, int i) {
        Log.i(TAG, "Java ttsEventCallback");
        TTSCallbacks tTSCallbacks = this.cbs;
        if (tTSCallbacks != null) {
            tTSCallbacks.onEvent(tTSEvent, this.contextMap.get(Integer.valueOf(i)));
        }
        if (tTSEvent.getType() == 2) {
            this.contextMap.remove(Integer.valueOf(i));
        }
    }

    public void ttsResultCallback(TTSResult tTSResult, int i) {
        Log.i(TAG, "Java ttsResultCallback");
        TTSCallbacks tTSCallbacks = this.cbs;
        if (tTSCallbacks != null) {
            tTSCallbacks.onResult(tTSResult, this.contextMap.get(Integer.valueOf(i)));
        }
        if (tTSResult.getStatus() == 2) {
            this.contextMap.remove(Integer.valueOf(i));
        }
    }

    public void vcn(String str) {
        setTTSVcn(this.sid, str);
    }

    public void version(boolean z) {
        setTTSVersion(this.sid, z);
    }

    public void volume(int i) {
        setTTSVolume(this.sid, i);
    }

    public TTS(String str, int i) {
        this.sid = 0;
        this.sid = create(str, i);
    }

    public int aRun(String str, int i) {
        return ttsArunStream(this.sid, str, i, 0);
    }

    public int create(String str, int i) {
        return create(str, str, i);
    }

    public TTS(String str, String str2, int i) {
        this.sid = 0;
        this.sid = create(str, str2, i);
    }

    public int aRun(String str, int i, Object obj) {
        int incrementAndGet = this.usrTagId.incrementAndGet();
        this.contextMap.put(Integer.valueOf(incrementAndGet), obj);
        return ttsArunStream(this.sid, str, i, incrementAndGet);
    }

    public int create(String str, String str2, int i) {
        return ttsCreate(str, str2, i);
    }

    public int aRun(String str, Object obj) {
        int incrementAndGet = this.usrTagId.incrementAndGet();
        this.contextMap.put(Integer.valueOf(incrementAndGet), obj);
        return ttsArun(this.sid, str, incrementAndGet);
    }
}
