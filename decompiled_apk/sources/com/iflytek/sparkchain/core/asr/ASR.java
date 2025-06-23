package com.iflytek.sparkchain.core.asr;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.iflytek.sparkchain.core.AiHelper;
import com.iflytek.sparkchain.core.asr.AudioRecorder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ASR implements AudioRecorder.AudioDataCallback {
    private static final String TAG = "AEE_ASR";
    private AudioRecorder recorder;
    private int sessionId;
    private AtomicInteger usrTagId = new AtomicInteger(0);
    private HashMap<Integer, Object> contextMap = new HashMap<>();
    private AsrCallbacks cbs = null;
    private AtomicBoolean isWrite = new AtomicBoolean(false);
    private final int index = asrCreate();

    /* loaded from: classes10.dex */
    public class ASRError {
        private int code;
        private String errMsg;
        private String sid;

        public ASRError() {
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
    public class ASRResult {
        private int begin;
        private String bestMatchText;
        private int end;
        private String sid;
        private int status;
        private List<Transcription> transcriptions;
        private List<Vad> vads;

        public ASRResult() {
        }

        public int getBegin() {
            return this.begin;
        }

        public String getBestMatchText() {
            return this.bestMatchText;
        }

        public int getEnd() {
            return this.end;
        }

        public String getSid() {
            return this.sid;
        }

        public int getStatus() {
            return this.status;
        }

        public List<Transcription> getTranscriptions() {
            return this.transcriptions;
        }

        public List<Vad> getVads() {
            return this.vads;
        }

        public void setBegin(int i) {
            this.begin = i;
        }

        public void setBestMatchText(String str) {
            this.bestMatchText = str;
        }

        public void setEnd(int i) {
            this.end = i;
        }

        public void setSid(String str) {
            this.sid = str;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        public void setTranscriptions(List<Transcription> list) {
            this.transcriptions = list;
        }

        public void setVads(List<Vad> list) {
            this.vads = list;
        }
    }

    public ASR() {
    }

    private native int asrCreate();

    /* JADX INFO: Access modifiers changed from: private */
    public native void asrDestroy(int i);

    private native int asrStart(int i, int i2);

    private native int asrStartWithAudioAttributes(int i, int i2, int i3, String str, int i4, int i5, int i6);

    private native int asrStop(int i, boolean z);

    private native int asrWrite(int i, byte[] bArr);

    private ASRResult parseJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            ASRResult aSRResult = new ASRResult();
            aSRResult.setBegin(jSONObject.optInt("begin"));
            aSRResult.setEnd(jSONObject.optInt("end"));
            aSRResult.setSid(jSONObject.optString(MapItem.KEY_ITEM_SID));
            aSRResult.setBestMatchText(jSONObject.optString("bestMatchText"));
            aSRResult.setStatus(jSONObject.optInt("status"));
            JSONArray optJSONArray = jSONObject.optJSONArray("transcriptions");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    Transcription transcription = new Transcription();
                    transcription.setIndex(jSONObject2.optInt(MapBundleKey.MapObjKey.OBJ_SL_INDEX));
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("segments");
                    ArrayList arrayList2 = new ArrayList();
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                            Segment segment = new Segment();
                            segment.setScore(jSONObject3.optInt("score"));
                            segment.setText(jSONObject3.optString("text"));
                            segment.setLg(jSONObject3.optString("lg"));
                            arrayList2.add(segment);
                        }
                    }
                    transcription.setSegments(arrayList2);
                    arrayList.add(transcription);
                }
            }
            aSRResult.setTranscriptions(arrayList);
            JSONArray optJSONArray3 = jSONObject.optJSONArray("vads");
            ArrayList arrayList3 = new ArrayList();
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    JSONObject jSONObject4 = optJSONArray3.getJSONObject(i3);
                    Vad vad = new Vad();
                    vad.setBegin(jSONObject4.optInt("begin"));
                    vad.setEnd(jSONObject4.optInt("end"));
                    arrayList3.add(vad);
                }
            }
            aSRResult.setVads(arrayList3);
            return aSRResult;
        } catch (JSONException e) {
            Log.w(TAG, "Java tts parseJson:" + e.toString());
            return null;
        }
    }

    private native void setAsrAccent(int i, String str);

    private native void setAsrDomain(int i, String str);

    private native void setAsrDwa(int i, String str);

    private native void setAsrLanguage(int i, String str);

    private native void setAsrNbest(int i, int i2);

    private native void setAsrNunum(int i, boolean z);

    private native void setAsrPd(int i, String str);

    private native void setAsrPtt(int i, boolean z);

    private native void setAsrRlang(int i, String str);

    private native void setAsrSpeexSize(int i, int i2);

    private native void setAsrVadEos(int i, int i2);

    private native void setAsrVinfo(int i, boolean z);

    private native void setAsrWbest(int i, int i2);

    private native void setLn(int i, String str);

    private native void setProc(int i, boolean z);

    private native void setSmth(int i, boolean z);

    private native void setVgap(int i, int i2);

    public void accent(String str) {
        setAsrAccent(this.index, str);
    }

    public void asrErrorCallback(ASRError aSRError, int i) {
        Log.i(TAG, "Java ttsErrorCallback");
        this.sessionId = i;
        AsrCallbacks asrCallbacks = this.cbs;
        if (asrCallbacks != null) {
            asrCallbacks.onError(aSRError, this.contextMap.get(Integer.valueOf(i)));
        }
        if (this.recorder != null) {
            cancel();
        }
        this.contextMap.remove(Integer.valueOf(i));
    }

    public void asrResultCallback(String str, int i) {
        ASRResult parseJson;
        Log.i(TAG, "Java ttsResultCallback");
        if (TextUtils.isEmpty(str) || (parseJson = parseJson(str)) == null) {
            return;
        }
        this.sessionId = i;
        if (this.recorder != null && parseJson.getStatus() == 2) {
            cancel();
        }
        AsrCallbacks asrCallbacks = this.cbs;
        if (asrCallbacks != null) {
            asrCallbacks.onResult(parseJson, this.contextMap.get(Integer.valueOf(i)));
        }
        if (parseJson.getStatus() == 2) {
            this.contextMap.remove(Integer.valueOf(i));
        }
    }

    public void cancel() {
        this.isWrite.set(false);
        AsrCallbacks asrCallbacks = this.cbs;
        if (asrCallbacks != null) {
            asrCallbacks.onEndOfSpeech();
        }
    }

    public void domain(String str) {
        setAsrDomain(this.index, str);
    }

    public void dwa(String str) {
        setAsrDwa(this.index, str);
    }

    public void finalize() throws Throwable {
        super.finalize();
        final int i = this.index;
        AiHelper.getInst().getHandler().postDelayed(new Runnable() { // from class: com.iflytek.sparkchain.core.asr.ASR.1
            @Override // java.lang.Runnable
            public void run() {
                Log.v(ASR.TAG, "asrDestroy:index:" + ASR.this.index);
                ASR.this.asrDestroy(i);
            }
        }, 1000L);
    }

    public void language(String str) {
        setAsrLanguage(this.index, str);
    }

    public void ln(String str) {
        setLn(this.index, str);
    }

    public void nbest(int i) {
        setAsrNbest(this.index, i);
    }

    public void nunum(boolean z) {
        setAsrNunum(this.index, z);
    }

    @Override // com.iflytek.sparkchain.core.asr.AudioRecorder.AudioDataCallback
    public void onAudioData(byte[] bArr, int i) {
        int write;
        if (!this.isWrite.get() || (write = write(bArr)) == 0) {
            return;
        }
        this.isWrite.set(false);
        if (this.cbs != null) {
            ASRError aSRError = new ASRError();
            aSRError.setCode(write);
            this.cbs.onError(aSRError, this.contextMap.get(Integer.valueOf(this.sessionId)));
        }
    }

    public void pd(String str) {
        setAsrPd(this.index, str);
    }

    public void proc(boolean z) {
        setProc(this.index, z);
    }

    public void ptt(boolean z) {
        setAsrPtt(this.index, z);
    }

    public void registerCallbacks(AsrCallbacks asrCallbacks) {
        this.cbs = asrCallbacks;
    }

    public void rlang(String str) {
        setAsrRlang(this.index, str);
    }

    public void smth(boolean z) {
        setSmth(this.index, z);
    }

    public void speexSize(int i) {
        setAsrSpeexSize(this.index, i);
    }

    public int start(AudioAttributes audioAttributes, Object obj) {
        if (audioAttributes == null) {
            return start(obj);
        }
        int incrementAndGet = this.usrTagId.incrementAndGet();
        this.contextMap.put(Integer.valueOf(incrementAndGet), obj);
        return asrStartWithAudioAttributes(this.index, incrementAndGet, audioAttributes.getSampleRate(), audioAttributes.getEncoding(), audioAttributes.getChannels(), audioAttributes.getBitdepth(), audioAttributes.getFrameSize());
    }

    public int startListener(AudioAttributes audioAttributes, Object obj) {
        int start = start(audioAttributes, obj);
        if (start == 0) {
            this.isWrite.set(true);
            AudioRecorder audioRecorder = AudioRecorder.getInstance();
            this.recorder = audioRecorder;
            audioRecorder.startRecord();
            this.recorder.registerCallBack(this);
            AsrCallbacks asrCallbacks = this.cbs;
            if (asrCallbacks != null) {
                asrCallbacks.onBeginOfSpeech();
            }
        }
        return start;
    }

    public int stop(boolean z) {
        return asrStop(this.index, z);
    }

    public int stopListener() {
        AudioRecorder audioRecorder = this.recorder;
        if (audioRecorder != null) {
            audioRecorder.stopRecord();
            this.recorder = null;
        }
        return stop(false);
    }

    public void vadEos(int i) {
        setAsrVadEos(this.index, i);
    }

    public void vgap(int i) {
        setVgap(this.index, i);
    }

    public void vinfo(boolean z) {
        setAsrVinfo(this.index, z);
    }

    public void wbest(int i) {
        setAsrWbest(this.index, i);
    }

    public int write(byte[] bArr) {
        return asrWrite(this.index, bArr);
    }

    public ASR(String str, String str2, String str3) {
        language(str);
        domain(str2);
        accent(str3);
    }

    public int start(Object obj) {
        int incrementAndGet = this.usrTagId.incrementAndGet();
        this.contextMap.put(Integer.valueOf(incrementAndGet), obj);
        return asrStart(this.index, incrementAndGet);
    }

    public int startListener(Object obj) {
        int start = start(obj);
        if (start == 0) {
            this.isWrite.set(true);
            AudioRecorder audioRecorder = AudioRecorder.getInstance();
            this.recorder = audioRecorder;
            audioRecorder.startRecord();
            this.recorder.registerCallBack(this);
            AsrCallbacks asrCallbacks = this.cbs;
            if (asrCallbacks != null) {
                asrCallbacks.onBeginOfSpeech();
            }
        }
        return start;
    }

    public int stopListener(boolean z) {
        AudioRecorder audioRecorder = this.recorder;
        if (audioRecorder != null) {
            audioRecorder.stopRecord();
            this.recorder = null;
        }
        return stop(z);
    }
}
