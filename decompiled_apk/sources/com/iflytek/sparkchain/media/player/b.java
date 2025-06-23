package com.iflytek.sparkchain.media.player;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iflytek.sparkchain.core.media.player.PcmPlayer;
import com.iflytek.sparkchain.media.speech.SpeechError;
import com.iflytek.sparkchain.utils.FuncAdapter;
import com.iflytek.sparkchain.utils.log.LogUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes10.dex */
public class b {
    public static final int BUFFERING = 1;
    public static final int INIT = 0;
    private static final int MIN_SLEEP = 5;
    private static final int MSG_ERROR = 0;
    private static final int MSG_PAUSE = 1;
    private static final int MSG_PERCENT = 3;
    private static final int MSG_RESUME = 2;
    private static final int MSG_STOPED = 4;
    public static final int PAUSED = 3;
    public static final int PLAYING = 2;
    public static final int STOPED = 4;
    private static final String TAG = "PcmPlayer";
    private final int BYTES_OF_PER_SAMPLE;
    private final int FADE_PERIOD;
    private final int FADE_TIME;
    private final float MAX_VOL;
    private final float MIN_VOL;
    private final float PER;
    AudioManager.OnAudioFocusChangeListener afChangeListener;
    private AtomicBoolean isExist;
    private com.iflytek.sparkchain.media.player.c listener;
    private boolean mAudioFocus;
    private Object mAudioLock;
    private AudioTrack mAudioTrack;
    private com.iflytek.sparkchain.media.record.a mBuffer;
    private int mBufferSize;
    private boolean mBufferingFadingEnable;
    private boolean mChangeListenerFlag;
    private Context mContext;
    private int mCurEndPos;
    private float mCurFadingPeriod;
    private float mCurVol;
    Condition mEndCondition;
    ReentrantLock mEndLock;
    private boolean mFading;
    private boolean mFadingEnable;
    private int mFadingSize;
    private int mPerPlaySize;
    private volatile int mPlaytate;
    private boolean mRequestFocus;
    private int mStreamType;
    private Object mSyncObj;
    private float mTargetVol;
    private d mThread;
    private Handler mUihandler;

    /* loaded from: classes10.dex */
    public class a implements AudioManager.OnAudioFocusChangeListener {
        public a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (i == -2 || i == -3 || i == -1) {
                LogUtil.d(b.TAG, "pause start");
                if (b.this.pause()) {
                    LogUtil.d(b.TAG, "pause success");
                    b.this.mChangeListenerFlag = true;
                    b.this.onPause();
                    return;
                }
                return;
            }
            if (i == 1) {
                LogUtil.d(b.TAG, "resume start");
                if (b.this.mChangeListenerFlag) {
                    b.this.mChangeListenerFlag = false;
                    if (b.this.resume()) {
                        LogUtil.d(b.TAG, "resume success");
                        b.this.onResume();
                    }
                }
            }
        }
    }

    /* renamed from: com.iflytek.sparkchain.media.player.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class HandlerC0673b extends Handler {
        public HandlerC0673b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                b.this.onError((SpeechError) message.obj);
                return;
            }
            if (i == 1) {
                b.this.onPause();
                return;
            }
            if (i == 2) {
                b.this.onResume();
            } else if (i == 3) {
                b.this.onPercent(message.arg1, message.arg2);
            } else {
                if (i != 4) {
                    return;
                }
                b.this.onStop();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements com.iflytek.sparkchain.media.player.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PcmPlayer.PcmPlayerListener f17473a;

        public c(b bVar, PcmPlayer.PcmPlayerListener pcmPlayerListener) {
            this.f17473a = pcmPlayerListener;
        }

        @Override // com.iflytek.sparkchain.media.player.c
        public void onError(SpeechError speechError) {
            this.f17473a.onError((com.iflytek.sparkchain.core.media.speech.SpeechError) speechError);
        }

        @Override // com.iflytek.sparkchain.media.player.c
        public void onPause() {
            this.f17473a.onPaused();
        }

        @Override // com.iflytek.sparkchain.media.player.c
        public void onPercent(int i, int i2, int i3) {
            this.f17473a.onPercent(i, i2, i3);
        }

        @Override // com.iflytek.sparkchain.media.player.c
        public void onResume() {
            this.f17473a.onResume();
        }

        @Override // com.iflytek.sparkchain.media.player.c
        public void onStop() {
            this.f17473a.onStoped();
        }
    }

    /* loaded from: classes10.dex */
    public class d extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private int f17474a;

        /* loaded from: classes10.dex */
        public class a implements AudioTrack.OnPlaybackPositionUpdateListener {
            public a() {
            }

            @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
            public void onMarkerReached(AudioTrack audioTrack) {
                LogUtil.i("PcmPlayer onMarkerReached");
                b.this.mEndLock.lock();
                try {
                    b.this.mEndCondition.signalAll();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    b.this.mEndLock.unlock();
                    throw th;
                }
                b.this.mEndLock.unlock();
            }

            @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
            public void onPeriodicNotification(AudioTrack audioTrack) {
            }
        }

        private d() {
            this.f17474a = b.this.mStreamType;
        }

        public int a() {
            return this.f17474a;
        }

        /* JADX WARN: Code restructure failed: missing block: B:119:0x0349, code lost:
        
            if (r9.b.mAudioFocus != false) goto L142;
         */
        /* JADX WARN: Code restructure failed: missing block: B:120:0x03ab, code lost:
        
            com.iflytek.sparkchain.utils.FuncAdapter.UnLock(r9.b.mContext, java.lang.Boolean.valueOf(r9.b.mRequestFocus), null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x03be, code lost:
        
            r9.b.mThread = null;
            com.iflytek.sparkchain.utils.log.LogUtil.d(com.iflytek.sparkchain.media.player.b.TAG, "player stopped");
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x03ca, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:123:0x0393, code lost:
        
            com.iflytek.sparkchain.utils.FuncAdapter.UnLock(r9.b.mContext, java.lang.Boolean.valueOf(r9.b.mRequestFocus), r9.b.afChangeListener);
         */
        /* JADX WARN: Code restructure failed: missing block: B:189:0x0391, code lost:
        
            if (r9.b.mAudioFocus == false) goto L143;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 1076
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sparkchain.media.player.b.d.run():void");
        }

        public /* synthetic */ d(b bVar, a aVar) {
            this();
        }

        public void a(int i) {
            this.f17474a = i;
        }
    }

    public b(Context context) {
        this.mAudioTrack = null;
        this.mBuffer = null;
        this.mContext = null;
        this.mThread = null;
        this.listener = null;
        this.mPlaytate = 0;
        this.mAudioFocus = true;
        this.mStreamType = 3;
        this.mRequestFocus = false;
        this.mChangeListenerFlag = false;
        this.mAudioLock = new Object();
        this.mSyncObj = this;
        this.BYTES_OF_PER_SAMPLE = 2;
        this.FADE_TIME = 500;
        this.FADE_PERIOD = 50;
        this.mPerPlaySize = 1600;
        this.MAX_VOL = 1.0f;
        this.MIN_VOL = 0.0f;
        this.PER = 0.1f;
        this.mFadingSize = 16000;
        this.mCurVol = 0.0f;
        this.mTargetVol = 1.0f;
        this.mCurFadingPeriod = 0.1f;
        this.mFading = false;
        this.isExist = new AtomicBoolean(true);
        this.mBufferingFadingEnable = false;
        this.mFadingEnable = false;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mEndLock = reentrantLock;
        this.mEndCondition = reentrantLock.newCondition();
        this.afChangeListener = new a();
        this.mCurEndPos = 0;
        this.mUihandler = new HandlerC0673b(Looper.getMainLooper());
        this.mContext = context;
    }

    private void createAudio() throws Exception {
        LogUtil.d(TAG, "createAudio start");
        int rate = this.mBuffer.getRate();
        this.mBufferSize = AudioTrack.getMinBufferSize(rate, 2, 2);
        int i = rate / 1000;
        this.mPerPlaySize = i * 100;
        this.mFadingSize = i * 1000;
        if (this.mAudioTrack != null) {
            release();
        }
        LogUtil.d(TAG, "createAudio || mStreamType = " + this.mStreamType + ", buffer size: " + this.mBufferSize);
        this.mAudioTrack = new AudioTrack(this.mStreamType, rate, 2, 2, this.mBufferSize * 2, 1);
        this.mBuffer.setAudioTrackBuffSize(this.mBufferSize * 2);
        int i2 = this.mBufferSize;
        if (i2 == -2 || i2 == -1) {
            throw new Exception();
        }
        LogUtil.d(TAG, "createAudio end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(SpeechError speechError) {
        com.iflytek.sparkchain.media.player.c cVar = this.listener;
        if (cVar != null) {
            cVar.onError(speechError);
            this.listener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPause() {
        com.iflytek.sparkchain.media.player.c cVar = this.listener;
        if (cVar != null) {
            cVar.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPercent(int i, int i2) {
        if (this.listener == null || this.mPlaytate == 4) {
            return;
        }
        this.listener.onPercent(i, i2, this.mCurEndPos);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResume() {
        com.iflytek.sparkchain.media.player.c cVar = this.listener;
        if (cVar != null) {
            cVar.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        com.iflytek.sparkchain.media.player.c cVar = this.listener;
        if (cVar != null) {
            cVar.onStop();
            this.listener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepAudioPlayer() throws Exception {
        d dVar = this.mThread;
        if (this.mAudioTrack == null || !(dVar == null || dVar.a() == this.mStreamType)) {
            LogUtil.d(TAG, "prepAudioPlayer || audiotrack is null or stream type is change.");
            createAudio();
            if (dVar != null) {
                dVar.a(this.mStreamType);
            }
        }
    }

    public void fading() {
        if (!this.mFadingEnable) {
            this.mFading = false;
            return;
        }
        synchronized (this.mSyncObj) {
            try {
                if (Math.abs(this.mTargetVol - this.mCurVol) < 0.1f) {
                    this.mCurVol = this.mTargetVol;
                    this.mFading = false;
                    LogUtil.d("fading finish");
                } else {
                    this.mCurVol += this.mCurFadingPeriod;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        AudioTrack audioTrack = this.mAudioTrack;
        float f = this.mCurVol;
        audioTrack.setStereoVolume(f, f);
    }

    public int getState() {
        return this.mPlaytate;
    }

    public boolean pause() {
        if (this.mPlaytate == 4 || this.mPlaytate == 3) {
            return false;
        }
        LogUtil.d("pause start fade out");
        startFadeOut();
        this.mPlaytate = 3;
        return true;
    }

    public boolean play(com.iflytek.sparkchain.media.record.a aVar) {
        boolean z;
        LogUtil.d(TAG, "play mPlaytate= " + this.mPlaytate + ",mAudioFocus= " + this.mAudioFocus);
        synchronized (this.mSyncObj) {
            try {
                z = false;
                if (this.mPlaytate == 4 || this.mPlaytate == 0 || this.mPlaytate == 3 || this.mThread == null) {
                    if (this.mThread == null) {
                        this.mThread = new d(this, null);
                        this.mPlaytate = 0;
                    }
                    this.mBuffer = aVar;
                    this.isExist.set(false);
                    this.mThread.start();
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    public boolean rePlay(com.iflytek.sparkchain.media.record.a aVar) {
        setState(0);
        return play(aVar);
    }

    public boolean reSetStatus() {
        setState(0);
        return true;
    }

    public void release() {
        synchronized (this.mAudioLock) {
            try {
                AudioTrack audioTrack = this.mAudioTrack;
                if (audioTrack != null) {
                    if (audioTrack.getPlayState() == 3) {
                        this.mAudioTrack.stop();
                    }
                    this.mAudioTrack.release();
                    this.mAudioTrack = null;
                }
                LogUtil.d(TAG, "mAudioTrack released");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean resume() {
        boolean state = setState(3, 2);
        FuncAdapter.Lock(this.mContext, Boolean.valueOf(this.mRequestFocus), this.afChangeListener);
        if (state) {
            LogUtil.d("resume start fade in");
            Message.obtain(this.mUihandler, 2).sendToTarget();
            startFadeIn();
        }
        return state;
    }

    public void setAudioFocus(boolean z) {
        LogUtil.d(TAG, "setAudioFocus " + z);
        this.mAudioFocus = z;
    }

    public void setListener(PcmPlayer.PcmPlayerListener pcmPlayerListener) {
        setListener(new c(this, pcmPlayerListener));
    }

    public void setSilence() {
        LogUtil.d("fading set silence");
        synchronized (this.mSyncObj) {
            try {
                if (Math.abs(0.0f - this.mTargetVol) < 0.1f) {
                    this.mCurVol = 0.0f;
                    this.mFading = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        AudioTrack audioTrack = this.mAudioTrack;
        float f = this.mCurVol;
        audioTrack.setStereoVolume(f, f);
    }

    public void setState(int i) {
        this.mPlaytate = i;
    }

    public void setStreamType(int i) {
        LogUtil.d(TAG, "setmStreamType || streamType = " + i);
        this.mStreamType = i;
    }

    public void startFadeIn() {
        if (this.mFadingEnable) {
            synchronized (this.mSyncObj) {
                LogUtil.d("start fade in");
                this.mFading = true;
                this.mTargetVol = 1.0f;
                this.mCurFadingPeriod = 0.1f;
            }
        }
    }

    public void startFadeOut() {
        if (this.mFadingEnable) {
            synchronized (this.mSyncObj) {
                LogUtil.d("start fade out");
                this.mFading = true;
                this.mTargetVol = 0.0f;
                this.mCurFadingPeriod = -0.1f;
            }
        }
    }

    public boolean stop() {
        if (4 != this.mPlaytate) {
            LogUtil.d("stop start fade out");
            startFadeOut();
        }
        synchronized (this.mSyncObj) {
            this.mPlaytate = 4;
        }
        return true;
    }

    public b(Context context, int i, boolean z, boolean z2, boolean z3) {
        this.mAudioTrack = null;
        this.mBuffer = null;
        this.mContext = null;
        this.mThread = null;
        this.listener = null;
        this.mPlaytate = 0;
        this.mAudioFocus = true;
        this.mStreamType = 3;
        this.mRequestFocus = false;
        this.mChangeListenerFlag = false;
        this.mAudioLock = new Object();
        this.mSyncObj = this;
        this.BYTES_OF_PER_SAMPLE = 2;
        this.FADE_TIME = 500;
        this.FADE_PERIOD = 50;
        this.mPerPlaySize = 1600;
        this.MAX_VOL = 1.0f;
        this.MIN_VOL = 0.0f;
        this.PER = 0.1f;
        this.mFadingSize = 16000;
        this.mCurVol = 0.0f;
        this.mTargetVol = 1.0f;
        this.mCurFadingPeriod = 0.1f;
        this.mFading = false;
        this.isExist = new AtomicBoolean(true);
        this.mBufferingFadingEnable = false;
        this.mFadingEnable = false;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mEndLock = reentrantLock;
        this.mEndCondition = reentrantLock.newCondition();
        this.afChangeListener = new a();
        this.mCurEndPos = 0;
        this.mUihandler = new HandlerC0673b(Looper.getMainLooper());
        this.mContext = context;
        this.mStreamType = i;
        this.mRequestFocus = z;
        this.mFadingEnable = z2;
        this.mBufferingFadingEnable = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setState(int i, int i2) {
        boolean z;
        synchronized (this.mSyncObj) {
            try {
                if (i == this.mPlaytate) {
                    this.mPlaytate = i2;
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public void setListener(com.iflytek.sparkchain.media.player.c cVar) {
        this.listener = cVar;
    }
}
