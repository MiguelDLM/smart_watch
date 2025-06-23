package com.baidu.ar.recorder;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.ho;
import com.baidu.ar.hp;
import com.baidu.ar.hq;
import com.baidu.ar.hr;
import com.baidu.ar.hu;
import com.baidu.ar.hv;
import com.baidu.ar.hw;
import com.baidu.ar.kf;
import com.baidu.ar.record.EncoderParams;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class MovieRecorder implements ho {
    public static final int ERROR_CODE_ON_START = 4001;
    public static final int ERROR_CODE_ON_STOP = 4002;
    private static final String TAG = "MovieRecorder";
    private static volatile int wK = 0;
    private static volatile boolean wU = false;
    private static volatile MovieRecorder xb;
    private Context mContext;
    private EncoderParams wB;
    private com.baidu.ar.record.MovieRecorderCallback wC;
    private HandlerThread wN;
    private a wQ;
    private hp wR;
    private hv wS;
    private hw wT;
    private hq wV;
    private hu wW;
    private hr wY;
    private hu wZ;
    private int wL = 0;
    private boolean wM = false;
    private volatile boolean wO = false;
    private boolean wP = false;
    private volatile boolean wX = false;
    private volatile boolean xa = false;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 7000:
                    if (MovieRecorder.this.wC != null) {
                        MovieRecorder.this.wC.onRecorderInit((Surface) message.obj);
                        break;
                    }
                    break;
                case ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE /* 7001 */:
                    if (MovieRecorder.this.wC != null) {
                        MovieRecorder.this.wC.onRecorderStart(((Boolean) message.obj).booleanValue());
                    }
                    MovieRecorder.this.wO = false;
                    break;
                case 7002:
                    if (MovieRecorder.this.wC != null) {
                        MovieRecorder.this.wC.onRecorderProcess(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7003:
                    if (MovieRecorder.this.wC != null) {
                        MovieRecorder.this.wC.onRecorderComplete(((Boolean) message.obj).booleanValue(), MovieRecorder.this.wB != null ? MovieRecorder.this.wB.getOutputFile() : null);
                        break;
                    }
                    break;
                case 7004:
                    if (MovieRecorder.this.wC != null) {
                        MovieRecorder.this.wC.onRecorderError(((Integer) message.obj).intValue());
                        break;
                    }
                    break;
                case 7005:
                    MovieRecorder.this.fk();
                    break;
                case 7006:
                    MovieRecorder.this.wO = false;
                    MovieRecorder.this.stopRecorder();
                    break;
            }
            super.handleMessage(message);
        }
    }

    private static void G(boolean z) {
        wU = z;
    }

    private static void K(int i) {
        wK = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fk() {
        fm();
        fn();
        if (fo()) {
            fp();
            fq();
        } else if (this.wP) {
            fl();
        } else {
            fr();
        }
    }

    private void fl() {
        a aVar = this.wQ;
        if (aVar != null) {
            aVar.sendMessageDelayed(aVar.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.FALSE), 500L);
        }
    }

    private void fm() {
        this.wS = new hv();
        if (this.wB.isAudioIncluded()) {
            this.wV = new hq();
        } else {
            wU = true;
        }
        this.wY = new hr();
        this.wL = 0;
        if (!this.wM && this.wN == null) {
            HandlerThread handlerThread = new HandlerThread(TAG);
            this.wN = handlerThread;
            handlerThread.start();
        }
        a aVar = this.wQ;
        if (aVar == null) {
            this.wQ = this.wN != null ? new a(this.wN.getLooper()) : new a(this.mContext.getMainLooper());
        } else {
            aVar.removeCallbacksAndMessages(null);
        }
        this.wR = new hp(this.wB.getOutputTotalMs());
    }

    private void fn() {
        this.wZ = new hu() { // from class: com.baidu.ar.recorder.MovieRecorder.1
            @Override // com.baidu.ar.hu
            public void I(boolean z) {
                MovieRecorder.this.xa = z;
                MovieRecorder.this.a(2, z);
            }

            @Override // com.baidu.ar.hu
            public void J(boolean z) {
            }

            @Override // com.baidu.ar.hu
            public void K(boolean z) {
                if (MovieRecorder.this.wY != null) {
                    MovieRecorder.this.wY.fx();
                    MovieRecorder.this.wY = null;
                }
                MovieRecorder.this.wZ = null;
                MovieRecorder.this.c(2, z);
            }

            @Override // com.baidu.ar.hu
            public void a(boolean z, Object obj) {
                if (z) {
                    if (MovieRecorder.this.wQ != null) {
                        MovieRecorder.this.wQ.sendMessage(MovieRecorder.this.wQ.obtainMessage(7000, obj));
                    }
                    if (MovieRecorder.this.wY != null) {
                        MovieRecorder.this.wY.startRecording();
                    }
                }
            }
        };
        this.wW = new hu() { // from class: com.baidu.ar.recorder.MovieRecorder.2
            @Override // com.baidu.ar.hu
            public void I(boolean z) {
                MovieRecorder.this.wX = z;
                MovieRecorder.this.a(4, z);
            }

            @Override // com.baidu.ar.hu
            public void J(boolean z) {
                boolean unused = MovieRecorder.wU = z;
            }

            @Override // com.baidu.ar.hu
            public void K(boolean z) {
                MovieRecorder.this.wV.fx();
                MovieRecorder.this.wV = null;
                MovieRecorder.this.wW = null;
                MovieRecorder.this.c(4, z);
            }

            @Override // com.baidu.ar.hu
            public void a(boolean z, Object obj) {
                if (z) {
                    MovieRecorder.this.wV.startRecording();
                }
            }
        };
        this.wT = new hw() { // from class: com.baidu.ar.recorder.MovieRecorder.3
            @Override // com.baidu.ar.hw
            public void L(boolean z) {
                MovieRecorder.this.a(1, z);
            }

            @Override // com.baidu.ar.hw
            public void M(boolean z) {
                MovieRecorder.this.wS.fL();
                MovieRecorder.this.wS = null;
                MovieRecorder.this.wT = null;
                MovieRecorder.this.c(1, z);
            }
        };
    }

    private boolean fo() {
        boolean z;
        hq hqVar = this.wV;
        if (hqVar == null || !hqVar.isRunning()) {
            z = true;
        } else {
            kf.b(TAG, "prepareMovieRecorder mAudioRecorder.isRunning !!!");
            this.wV.stopRecording();
            this.wV.fx();
            z = false;
        }
        hr hrVar = this.wY;
        if (hrVar != null && hrVar.isRunning()) {
            kf.b(TAG, "prepareMovieRecorder mVideoRecorder.isRunning !!!");
            this.wY.stopRecording();
            this.wY.fx();
            z = false;
        }
        EncoderParams encoderParams = this.wB;
        if (encoderParams == null || this.wS.a(encoderParams.getOutputFile(), this.wB.getOutputFormat(), this.wT)) {
            return z;
        }
        kf.b(TAG, "prepareMovieRecorder movieMuxerInit error!!!");
        return false;
    }

    private void fp() {
        hq hqVar = this.wV;
        if (hqVar != null) {
            hqVar.a(this.wB, this.wS, this.wW);
        }
    }

    private void fq() {
        this.wY.a(this.wB, this.wS, this.wZ);
    }

    private void fr() {
        kf.u(TAG, "restartRecorder mRestartTried = " + this.wP);
        a aVar = this.wQ;
        if (aVar != null) {
            this.wP = true;
            aVar.sendMessageDelayed(aVar.obtainMessage(7005), 500L);
        }
    }

    private boolean fs() {
        EncoderParams encoderParams = this.wB;
        if (encoderParams == null) {
            return false;
        }
        if (encoderParams.isAudioIncluded()) {
            if (this.wL == 3) {
                return true;
            }
        } else if (this.wL == 2) {
            return true;
        }
        return false;
    }

    private synchronized boolean ft() {
        int i;
        kf.u(TAG, "isMovieRecordStarted sMovieRecordState = " + wK);
        int i2 = wK;
        i = i2 ^ 3;
        EncoderParams encoderParams = this.wB;
        if (encoderParams != null) {
            if (encoderParams.isAudioIncluded()) {
                i = i2 ^ 7;
            }
        }
        return i == 0;
    }

    private boolean fu() {
        return this.wL == 0;
    }

    private synchronized boolean fv() {
        return wK == 0;
    }

    private void g(long j) {
        a aVar;
        if (!this.wR.fw()) {
            this.wR.h(j);
            return;
        }
        int i = this.wR.i(j);
        if (i <= 0 || (aVar = this.wQ) == null) {
            return;
        }
        aVar.sendMessage(aVar.obtainMessage(7002, Integer.valueOf(i)));
    }

    public static MovieRecorder getInstance() {
        if (xb == null) {
            synchronized (MovieRecorder.class) {
                try {
                    if (xb == null) {
                        xb = new MovieRecorder();
                    }
                } finally {
                }
            }
        }
        return xb;
    }

    private static void releaseInstance() {
        xb = null;
    }

    @Override // com.baidu.ar.ho
    public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
        hq hqVar;
        if (this.wX && (hqVar = this.wV) != null && hqVar.isRunning()) {
            this.wV.a(byteBuffer, i, j);
        }
    }

    public void onDestroy() {
        this.wR = null;
        this.mContext = null;
        this.wB = null;
        this.wC = null;
        K(0);
        releaseInstance();
        a aVar = this.wQ;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
            this.wQ = null;
        }
        HandlerThread handlerThread = this.wN;
        if (handlerThread != null) {
            handlerThread.quit();
            this.wN = null;
        }
    }

    @Override // com.baidu.ar.ho
    public void onVideoFrameAvailable(long j) {
        hr hrVar = this.wY;
        if (hrVar != null && hrVar.isRunning() && this.xa && wU) {
            this.wY.j(j);
            g(j / 1000000);
        }
    }

    @Override // com.baidu.ar.ho
    public void startRecorder(Context context, EncoderParams encoderParams, com.baidu.ar.record.MovieRecorderCallback movieRecorderCallback) {
        kf.u(TAG, "startRecorder mStarting = " + this.wO);
        if (this.wO) {
            fl();
            return;
        }
        this.wO = true;
        this.mContext = context;
        this.wB = encoderParams;
        this.wC = movieRecorderCallback;
        fk();
    }

    @Override // com.baidu.ar.ho
    public void stopRecorder() {
        a aVar;
        String str = TAG;
        kf.u(str, "stopRecorder mStarting = " + this.wO);
        if (this.wO) {
            if (!ft() && (aVar = this.wQ) != null) {
                aVar.sendMessage(aVar.obtainMessage(7004, 4002));
            }
            kf.c(str, "stopRecorder() MovieRecorder is starting, we will try to stop 500ms later!!!");
            a aVar2 = this.wQ;
            if (aVar2 != null) {
                aVar2.sendMessageDelayed(aVar2.obtainMessage(7006), 500L);
                return;
            }
            return;
        }
        this.wX = false;
        this.xa = false;
        hq hqVar = this.wV;
        if (hqVar != null && hqVar.isRunning()) {
            this.wV.stopRecording();
        }
        hr hrVar = this.wY;
        if (hrVar != null && hrVar.isRunning()) {
            this.wY.stopRecording();
        }
        G(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(int i, boolean z) {
        String str = TAG;
        kf.u(str, "checkMovieRecordStopState condition = " + i + " && state = " + z);
        d(i, z);
        StringBuilder sb = new StringBuilder();
        sb.append("checkMovieRecordStopState sMovieRecordState = ");
        sb.append(wK);
        kf.u(str, sb.toString());
        if (fu() && this.wQ != null) {
            boolean fv = fv();
            a aVar = this.wQ;
            aVar.sendMessage(aVar.obtainMessage(7003, Boolean.valueOf(fv)));
        }
    }

    private void d(int i, boolean z) {
        if (z) {
            wK = i ^ wK;
        }
        this.wL--;
    }

    private void b(int i, boolean z) {
        if (z) {
            wK = i | wK;
        }
        this.wL++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(int i, boolean z) {
        String str = TAG;
        kf.u(str, "checkMovieRecordStartState condition = " + i + " && state = " + z);
        b(i, z);
        StringBuilder sb = new StringBuilder();
        sb.append("checkMovieRecordStartState sMovieRecordState = ");
        sb.append(wK);
        kf.u(str, sb.toString());
        if (fs()) {
            boolean ft = ft();
            a aVar = this.wQ;
            aVar.sendMessage(aVar.obtainMessage(ARPMessageType.MSG_OPEN_OFFSCREEN_UPDATE, Boolean.valueOf(ft)));
        }
    }
}
