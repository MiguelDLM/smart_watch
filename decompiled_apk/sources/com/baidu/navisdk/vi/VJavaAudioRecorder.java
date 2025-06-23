package com.baidu.navisdk.vi;

import android.media.AudioRecord;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class VJavaAudioRecorder {
    private static final int AUDIO_FORMAT = 2;
    private static final int AUDIO_SOURCE = 1;
    protected static final int BUFFER_SIZE_IN_BYTES = Math.max(AudioRecord.getMinBufferSize(16000, 2, 2), 2048);
    private static final int CHANNEL_CONFIG = 2;
    private static final int SAMPLE_RATE = 16000;
    private static final String TAG = "VJavaAudioRecorder";
    private int mJniData;
    AudioRecord mRecord;
    private b mRecordThread;
    private a mRecorderListener;
    private boolean isInit = false;
    private boolean isThreadStart = false;
    private boolean isStart = false;
    private boolean isStop = true;
    private Object mMutex = new Object();
    private short[] mBuffer = new short[2048];

    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void a(short[] sArr, int i);
    }

    /* loaded from: classes8.dex */
    public class b extends Thread {
        public b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (VJavaAudioRecorder.this.isInit) {
                VJavaAudioRecorder vJavaAudioRecorder = VJavaAudioRecorder.this;
                if (vJavaAudioRecorder.mRecord != null) {
                    if (vJavaAudioRecorder.isStop) {
                        synchronized (VJavaAudioRecorder.this.mMutex) {
                            try {
                                LogUtil.e(VJavaAudioRecorder.TAG, "java record thread read stop");
                                VJavaAudioRecorder.this.mMutex.wait();
                                LogUtil.e(VJavaAudioRecorder.TAG, "java record thread read start");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (!VJavaAudioRecorder.this.isInit) {
                        break;
                    }
                    VJavaAudioRecorder vJavaAudioRecorder2 = VJavaAudioRecorder.this;
                    if (vJavaAudioRecorder2.mRecord == null) {
                        break;
                    }
                    if (vJavaAudioRecorder2.isStop) {
                        VJavaAudioRecorder.this.mRecord.stop();
                    } else {
                        VJavaAudioRecorder vJavaAudioRecorder3 = VJavaAudioRecorder.this;
                        int read = vJavaAudioRecorder3.mRecord.read(vJavaAudioRecorder3.mBuffer, 0, VJavaAudioRecorder.this.mBuffer.length);
                        if (!VJavaAudioRecorder.this.isStop) {
                            if (read > 0) {
                                LogUtil.e(VJavaAudioRecorder.TAG, "java record thread read len:" + read);
                                VJavaAudioRecorder vJavaAudioRecorder4 = VJavaAudioRecorder.this;
                                vJavaAudioRecorder4.onRecordReadData(vJavaAudioRecorder4.mBuffer, read);
                            } else {
                                LogUtil.e(VJavaAudioRecorder.TAG, "java record thread read error len = " + read);
                                VJavaAudioRecorder.this.onRecordReadError();
                            }
                        }
                    }
                } else {
                    break;
                }
            }
            LogUtil.e(VJavaAudioRecorder.TAG, "java record thread end");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRecordReadData(short[] sArr, int i) {
        if (this.isStop) {
            LogUtil.e(TAG, "onRecordReadData, has stopped");
            return;
        }
        a aVar = this.mRecorderListener;
        if (aVar != null) {
            aVar.a(sArr, i);
        } else {
            onReadData(sArr, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRecordReadError() {
        try {
            a aVar = this.mRecorderListener;
            if (aVar != null) {
                aVar.a();
            } else {
                onReadError();
            }
        } catch (Throwable unused) {
        }
    }

    public int getAudioSessionId() {
        AudioRecord audioRecord = this.mRecord;
        if (audioRecord != null && audioRecord.getRecordingState() == 3) {
            return this.mRecord.getAudioSessionId();
        }
        return 0;
    }

    public boolean init() {
        try {
            LogUtil.e("VoiceRecordView", "  MyClickListener isLongClick isInit " + this.isInit);
            if (this.isInit) {
                return true;
            }
            int i = 6;
            while (true) {
                int i2 = i - 1;
                if (i >= 0) {
                    AudioRecord audioRecord = new AudioRecord(1, 16000, 2, 2, BUFFER_SIZE_IN_BYTES);
                    this.mRecord = audioRecord;
                    if (audioRecord.getState() == 1) {
                        LogUtil.e(TAG, "success to onCreateView audio record!");
                        this.isInit = true;
                        b bVar = new b();
                        this.mRecordThread = bVar;
                        bVar.start();
                        return true;
                    }
                    i = i2;
                } else {
                    LogUtil.e(TAG, "fail to onCreateView audio record!");
                    return false;
                }
            }
        } catch (Exception unused) {
            LogUtil.e(TAG, "fail to onCreateView audio record for exception!");
            return false;
        }
    }

    public boolean isCanRecord() {
        return this.isInit;
    }

    public native void onReadData(short[] sArr, int i);

    public native void onReadError();

    public void release() {
        if (this.isInit && this.mRecord != null) {
            this.isInit = false;
            this.mRecordThread = null;
            LogUtil.e(TAG, "release recod");
            this.mRecord.release();
            this.mRecord = null;
            synchronized (this.mMutex) {
                this.mMutex.notify();
            }
        }
    }

    public void setRecorderListener(a aVar) {
        this.mRecorderListener = aVar;
    }

    public boolean start() {
        if (!this.isInit || this.mRecord == null) {
            return false;
        }
        if (this.isStart) {
            return true;
        }
        LogUtil.e(TAG, "start recod");
        this.isStart = true;
        this.isStop = false;
        try {
            this.mRecord.startRecording();
        } catch (Exception unused) {
        }
        synchronized (this.mMutex) {
            this.mMutex.notify();
        }
        return true;
    }

    public boolean stop() {
        if (!this.isInit || this.mRecord == null) {
            return false;
        }
        if (this.isStop) {
            return true;
        }
        LogUtil.e(TAG, "stop recod");
        this.isStart = false;
        this.isStop = true;
        return true;
    }
}
