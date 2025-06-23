package com.baidu.ar;

import android.content.Context;
import android.view.Surface;
import com.baidu.ar.arplay.core.engine.rotate.Orientation;
import com.baidu.ar.arplay.core.engine.rotate.OrientationManager;
import com.baidu.ar.arrender.FrameRenderListener;
import com.baidu.ar.arrender.IARRenderer;
import com.baidu.ar.audio.AudioParams;
import com.baidu.ar.audio.EasyAudioCallback;
import com.baidu.ar.audio.IEasyAudio;
import com.baidu.ar.bean.RotationType;
import com.baidu.ar.bean.Watermark;
import com.baidu.ar.record.EncoderParams;
import com.baidu.ar.record.IRecord;
import com.baidu.ar.record.MovieRecorderCallback;
import com.baidu.ar.record.RecordCallback;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class hn implements FrameRenderListener, IRecord {
    private static final String TAG = "hn";
    private DuMixOutput ay;
    private Watermark bY;
    private AudioParams kK;
    private Context mContext;
    private IARRenderer rm;
    private ho wA;
    private EncoderParams wB;
    private MovieRecorderCallback wC;
    private IEasyAudio wD;
    private EasyAudioCallback wE;
    private long wH;
    private RecordCallback wz;
    private int mWindowWidth = 0;
    private int mWindowHeight = 0;
    private boolean wF = false;
    private boolean wG = false;
    private long wI = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ar.hn$3, reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation;

        static {
            int[] iArr = new int[Orientation.values().length];
            $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation = iArr;
            try {
                iArr[Orientation.LANDSCAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[Orientation.LANDSCAPE_REVERSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[Orientation.PORTRAIT_REVERSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public hn(Context context, IARRenderer iARRenderer) {
        this.mContext = context;
        this.rm = iARRenderer;
    }

    private void fg() {
        Watermark watermark;
        RotationType rotationType;
        Orientation globalOrientation = OrientationManager.getGlobalOrientation();
        Watermark watermark2 = this.bY;
        if (watermark2 != null) {
            if (globalOrientation == Orientation.LANDSCAPE) {
                watermark2.setCoordinateType(Watermark.CoordinateType.RIGHT_BOTTOM);
                watermark = this.bY;
                rotationType = RotationType.ROTATE_270;
            } else if (globalOrientation == Orientation.LANDSCAPE_REVERSE) {
                watermark2.setCoordinateType(Watermark.CoordinateType.LEFT_TOP);
                watermark = this.bY;
                rotationType = RotationType.ROTATE_90;
            } else if (globalOrientation == Orientation.PORTRAIT_REVERSE) {
                watermark2.setCoordinateType(Watermark.CoordinateType.RIGHT_TOP);
                watermark = this.bY;
                rotationType = RotationType.ROTATE_180;
            } else {
                watermark2.setCoordinateType(Watermark.CoordinateType.LEFT_BOTTOM);
                watermark = this.bY;
                rotationType = RotationType.ROTATE_0;
            }
            watermark.setRotationType(rotationType);
        }
    }

    private void fh() {
        if (this.kK == null) {
            this.kK = new AudioParams();
        }
        if (this.wE == null) {
            this.wE = new EasyAudioCallback() { // from class: com.baidu.ar.hn.1
                @Override // com.baidu.ar.audio.EasyAudioCallback
                public void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j) {
                    hn.this.a(byteBuffer, i);
                }

                @Override // com.baidu.ar.audio.EasyAudioCallback
                public void onAudioStart(boolean z, AudioParams audioParams) {
                    kf.c(hn.TAG, "onAudioStart result = " + z);
                    hn.this.a(z, audioParams);
                }

                @Override // com.baidu.ar.audio.EasyAudioCallback
                public void onAudioStop(boolean z) {
                    kf.c(hn.TAG, "onAudioStop result = " + z);
                }
            };
        }
        if (this.wD == null) {
            this.wD = b.e();
        }
    }

    private void fi() {
        if (this.wB == null) {
            this.wB = new EncoderParams();
        }
        if (this.wC == null) {
            this.wC = new MovieRecorderCallback() { // from class: com.baidu.ar.hn.2
                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderComplete(boolean z, String str) {
                    kf.c(hn.TAG, "onRecorderComplete result = " + z);
                    hn.this.wF = false;
                    if (hn.this.wz != null) {
                        hn.this.wz.onRecorderComplete(z, str);
                        hn.this.wz = null;
                    }
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderError(int i) {
                    kf.b(hn.TAG, "onRecorderError error = " + i);
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderInit(Surface surface) {
                    if (hn.this.wB == null) {
                        return;
                    }
                    kf.c(hn.TAG, "onRecorderInit inputSurface = " + surface.hashCode());
                    hn hnVar = hn.this;
                    hnVar.ay = new DuMixOutput(surface, hnVar.wB.getVideoWidth(), hn.this.wB.getVideoHeight());
                    hn.this.ay.setRotationType(hn.this.fj());
                    hn.this.ay.setWatermark(hn.this.bY);
                    if (hn.this.rm == null || hn.this.wB == null) {
                        return;
                    }
                    hn.this.rm.addOutputSurface(hn.this.ay);
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderProcess(int i) {
                    kf.c(hn.TAG, "onRecorderProcess process = " + i);
                    if (i > 100) {
                        hn.this.stopRecord();
                    } else if (hn.this.wz != null) {
                        hn.this.wz.onRecorderProcess(i);
                    }
                }

                @Override // com.baidu.ar.record.MovieRecorderCallback
                public void onRecorderStart(boolean z) {
                    kf.c(hn.TAG, "onRecorderStart result = " + z);
                    hn.this.wF = z;
                    if (hn.this.wz != null) {
                        hn.this.wz.onRecorderStart(z);
                    }
                }
            };
        }
        if (this.wA == null) {
            this.wA = b.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RotationType fj() {
        RotationType rotationType = RotationType.ROTATE_0;
        int i = AnonymousClass3.$SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[OrientationManager.getGlobalOrientation().ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? rotationType : RotationType.ROTATE_180 : RotationType.ROTATE_270 : RotationType.ROTATE_90;
    }

    public void l(int i, int i2) {
        this.mWindowWidth = i;
        this.mWindowHeight = i2;
    }

    @Override // com.baidu.ar.arrender.FrameRenderListener
    public void onRenderFinished(long j) {
        if (this.wA == null || this.wG) {
            return;
        }
        this.wA.onVideoFrameAvailable(System.nanoTime() - this.wI);
    }

    @Override // com.baidu.ar.arrender.FrameRenderListener
    public void onRenderStarted(long j) {
    }

    @Override // com.baidu.ar.record.IRecord
    public void pauseRecord() {
        if (!this.wF || this.wG) {
            return;
        }
        this.wG = true;
        this.wH = System.nanoTime();
    }

    @Override // com.baidu.ar.record.IRecord
    public void resumeRecord() {
        if (this.wF && this.wG) {
            this.wG = false;
            this.wI += System.nanoTime() - this.wH;
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public void setRecordWatermark(Watermark watermark) {
        this.bY = watermark;
    }

    @Override // com.baidu.ar.record.IRecord
    public void startRecord(String str, long j, RecordCallback recordCallback) {
        fh();
        fi();
        this.wz = recordCallback;
        EncoderParams encoderParams = this.wB;
        if (encoderParams != null) {
            encoderParams.setOutputFile(str);
            this.wB.setOutputTotalMs(j);
        }
        IEasyAudio iEasyAudio = this.wD;
        if (iEasyAudio != null) {
            iEasyAudio.startAudio(this.kK, this.wE);
        }
        IARRenderer iARRenderer = this.rm;
        if (iARRenderer != null) {
            iARRenderer.addFrameRenderListener(this);
        }
    }

    @Override // com.baidu.ar.record.IRecord
    public synchronized void stopRecord() {
        try {
            IEasyAudio iEasyAudio = this.wD;
            if (iEasyAudio != null) {
                iEasyAudio.stopAudio(this.wE);
                this.wD = null;
            }
            this.kK = null;
            this.wE = null;
            ho hoVar = this.wA;
            if (hoVar != null) {
                hoVar.stopRecorder();
                this.wA = null;
            }
            this.wB = null;
            this.wC = null;
            IARRenderer iARRenderer = this.rm;
            if (iARRenderer != null) {
                iARRenderer.removeOutputSurface(this.ay);
                this.rm.removeFrameRenderListener(this);
            }
            this.ay = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void a(EncoderParams encoderParams, AudioParams audioParams) {
        int videoWidth = encoderParams.getVideoWidth();
        int videoHeight = encoderParams.getVideoHeight();
        if (this.mWindowWidth > 0 && this.mWindowHeight > 0) {
            if (videoHeight > videoWidth) {
                videoHeight = (this.wB.getVideoWidth() * this.mWindowHeight) / this.mWindowWidth;
            } else {
                videoWidth = (this.wB.getVideoHeight() * this.mWindowHeight) / this.mWindowWidth;
            }
        }
        Orientation globalOrientation = OrientationManager.getGlobalOrientation();
        if (globalOrientation == Orientation.LANDSCAPE || globalOrientation == Orientation.LANDSCAPE_REVERSE) {
            int i = videoHeight;
            videoHeight = videoWidth;
            videoWidth = i;
        }
        if (videoWidth % 2 == 1) {
            videoWidth++;
        }
        if (videoHeight % 2 == 1) {
            videoHeight++;
        }
        encoderParams.setVideoWidth(videoWidth);
        encoderParams.setVideoHeight(videoHeight);
        encoderParams.setAudioSampleRate(audioParams.getSampleRate());
        encoderParams.setAudioFrameSize(audioParams.getFrameSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(ByteBuffer byteBuffer, int i) {
        long nanoTime = System.nanoTime() - this.wI;
        ho hoVar = this.wA;
        if (hoVar != null && byteBuffer != null && i > 0 && !this.wG) {
            hoVar.onAudioFrameAvailable(byteBuffer, i, nanoTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, AudioParams audioParams) {
        this.wB.setAudioIncluded(z);
        if (this.wA != null) {
            a(this.wB, audioParams);
            fg();
            this.wA.startRecorder(this.mContext, this.wB, this.wC);
        }
    }
}
