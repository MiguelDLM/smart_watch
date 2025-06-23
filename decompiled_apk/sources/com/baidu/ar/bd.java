package com.baidu.ar;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.Matrix;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.renderer.OnRenderFinishedListener;
import com.baidu.ar.arplay.core.renderer.OnRenderStartedListener;
import com.baidu.ar.arrender.FrameRenderListener;
import com.baidu.ar.arrender.IRenderer;
import com.baidu.ar.bean.RotationType;
import com.baidu.ar.bean.ScaleType;
import com.baidu.ar.bean.Size;
import com.baidu.ar.bean.StorageType;
import com.baidu.ar.bean.Watermark;
import com.baidu.ar.statistic.StatisticApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class bd extends be implements View.OnTouchListener, OnRenderFinishedListener, OnRenderStartedListener, IRenderer {
    private bf ad;
    private float[] jA;
    ak jn;
    private boolean jo;
    private ii jp;
    private jf jq;
    private fr jr;
    private ConcurrentHashMap<DuMixOutput, bm> js;
    private List<FrameRenderListener> jt;
    private bg ju;
    protected boolean jv;
    private bj jw;
    boolean jx;
    float[] jy;
    private float[] jz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ar.bd$2, reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] jC;

        static {
            int[] iArr = new int[Watermark.CoordinateType.values().length];
            jC = iArr;
            try {
                iArr[Watermark.CoordinateType.LEFT_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jC[Watermark.CoordinateType.LEFT_BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                jC[Watermark.CoordinateType.RIGHT_TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                jC[Watermark.CoordinateType.RIGHT_BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public bd(Context context, Looper looper, fs fsVar, EGLContext eGLContext, String str) {
        super(context, fsVar, eGLContext, str);
        this.jo = false;
        this.jt = Collections.synchronizedList(new ArrayList());
        this.jv = false;
        this.jx = false;
        this.jy = new float[16];
        this.jn = new ak(Looper.getMainLooper());
        ii iiVar = new ii(context);
        this.jp = iiVar;
        iiVar.b(this.F);
        fr frVar = new fr();
        this.jr = frVar;
        frVar.b(this.F);
        jf jfVar = new jf(context);
        this.jq = jfVar;
        jfVar.b(this.F);
        this.js = new ConcurrentHashMap<>();
        boolean isScreenOrientationLandscape = kt.isScreenOrientationLandscape(this.mContext);
        this.jv = isScreenOrientationLandscape;
        this.jn.setScreenOrientationLandscape(isScreenOrientationLandscape);
        this.jw = new bj(looper, fsVar.ei(), this.jH.getARPRenderer());
        Matrix.setIdentityM(this.jy, 0);
        this.jH.getARPRenderer().setOnRenderStartedListener(this);
        this.jH.getARPRenderer().setOnRenderFinishedListener(this);
    }

    private void a(Watermark watermark) {
        if (watermark.getBitmap() == null && !TextUtils.isEmpty(watermark.getFilePath())) {
            watermark.setBitmap(watermark.getStorageType() == StorageType.SDCARD ? BitmapFactory.decodeFile(watermark.getFilePath()) : watermark.getStorageType() == StorageType.ASSETS ? ki.i(this.mContext, watermark.getFilePath()) : null);
        }
        if (watermark.getBitmap() == null || watermark.getRotationType() == RotationType.ROTATE_0) {
            return;
        }
        watermark.setBitmap(ki.rotateBitmap(watermark.getBitmap(), watermark.getRotationType().getDegree()));
    }

    private void b(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        int i;
        Watermark watermark = duMixOutput.getWatermark();
        if (watermark.getRenderRect() != null || watermark.getStartPoint() == null) {
            return;
        }
        int outputWidth = duMixOutput.getOutputWidth();
        int outputHeight = duMixOutput.getOutputHeight();
        RotationType rotationType = duMixOutput.getRotationType();
        RotationType rotationType2 = RotationType.ROTATE_90;
        if (rotationType == rotationType2 || duMixOutput.getRotationType() == RotationType.ROTATE_270) {
            outputHeight = outputWidth;
            outputWidth = outputHeight;
        }
        int i2 = 0;
        if (duMixOutput.getScaleType() == ScaleType.CENTER_CROP && duMixInput != null) {
            int inputWidth = duMixInput.getInputWidth();
            int inputHeight = duMixInput.getInputHeight();
            if (duMixInput.getRotationType() == rotationType2 || duMixInput.getRotationType() == RotationType.ROTATE_270) {
                inputHeight = inputWidth;
                inputWidth = inputHeight;
            }
            new Size(outputWidth, outputHeight);
            Size a2 = ba.a(inputWidth, inputHeight, outputWidth, outputHeight);
            if (a2.getWidth() != inputWidth) {
                i2 = (outputWidth - a2.getWidth()) / 2;
            } else if (a2.getHeight() != inputHeight) {
                i = (outputHeight - a2.getHeight()) / 2;
                watermark.setRenderRect(a(watermark, outputWidth, outputHeight, i2, i));
            }
        }
        i = 0;
        watermark.setRenderRect(a(watermark, outputWidth, outputHeight, i2, i));
    }

    private void by() {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null && aRPEngine.getARPRenderer() != null) {
            this.jH.getARPRenderer().setIsRender(false);
        }
        for (int i = 0; i < 5; i++) {
            ARPEngine aRPEngine2 = this.jH;
            if (aRPEngine2 != null && aRPEngine2.getARPRenderer() != null) {
                this.jH.getARPRenderer().render(System.currentTimeMillis());
            }
        }
        ARPEngine aRPEngine3 = this.jH;
        if (aRPEngine3 != null && aRPEngine3.getARPRenderer() != null) {
            this.jH.getARPRenderer().setIsRender(true);
        }
        ARPEngine aRPEngine4 = this.jH;
        if (aRPEngine4 == null || aRPEngine4.getARPRenderer() == null) {
            return;
        }
        this.jH.getARPRenderer().render(System.currentTimeMillis());
    }

    @Override // com.baidu.ar.be
    public void J(String str) {
        kf.c("ARRendererBase", "createCase() casePath = " + str);
        super.J(str);
        fr frVar = this.jr;
        if (frVar != null) {
            frVar.af();
        }
        jf jfVar = this.jq;
        if (jfVar != null) {
            jfVar.switchCase(str);
        }
    }

    public void addFrameRenderListener(FrameRenderListener frameRenderListener) {
        List<FrameRenderListener> list;
        if (frameRenderListener == null || (list = this.jt) == null) {
            return;
        }
        list.add(frameRenderListener);
    }

    public void addOutputSurface(DuMixOutput duMixOutput) {
        ARPEngine aRPEngine;
        if (duMixOutput == null || duMixOutput.getOutputSurface() == null || (aRPEngine = this.jH) == null || aRPEngine.getARPRenderer() == null || !(duMixOutput.getOutputSurface() instanceof Surface)) {
            kf.b("ARRendererBase", "addOutputSurface duMixOutput is error!!!");
            return;
        }
        kf.c("ARRendererBase", "addOutputSurface() surface = " + duMixOutput.getOutputSurface().hashCode() + " & width*height = " + duMixOutput.getOutputWidth() + "*" + duMixOutput.getOutputHeight() + " & rotation = " + duMixOutput.getRotationType() + " & mode = " + duMixOutput.getScaleType());
        String addOutputSurface = this.jH.getARPRenderer().addOutputSurface((Surface) duMixOutput.getOutputSurface(), duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), ba.a(duMixOutput.getRotationType(), duMixOutput.getMirriorType()), ba.a(duMixOutput.getScaleType()));
        a(addOutputSurface, this.ax, duMixOutput);
        bm bmVar = new bm(duMixOutput);
        bmVar.M(addOutputSurface);
        ConcurrentHashMap<DuMixOutput, bm> concurrentHashMap = this.js;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(duMixOutput, bmVar);
        }
    }

    public jf bs() {
        return this.jq;
    }

    @Override // com.baidu.ar.be
    public void bt() {
        kf.c("ARRendererBase", "destroyCase()");
        super.bt();
        bj bjVar = this.jw;
        if (bjVar != null) {
            bjVar.bM();
            this.jw.bN();
        }
        ii iiVar = this.jp;
        if (iiVar != null) {
            iiVar.reset();
        }
    }

    @Override // com.baidu.ar.be
    public void bu() {
        kf.c("ARRendererBase", "startARPEngine()");
        super.bu();
        ak akVar = this.jn;
        if (akVar != null) {
            akVar.l(true);
        }
    }

    @Override // com.baidu.ar.be
    public void bx() {
        if (this.ay.getOutputFPS() > 0) {
            this.ju = new bg(this.ay.getOutputFPS());
        }
        bj bjVar = this.jw;
        if (bjVar != null) {
            bjVar.i(this.ay.getOutputWidth(), this.ay.getOutputHeight());
        }
    }

    public void cancelAysncRenderTask(Runnable runnable) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || runnable == null) {
            return;
        }
        this.jH.getARPRenderer().cancelAysncRenderTask(runnable);
    }

    @Override // com.baidu.ar.be
    public void changeOutput(DuMixOutput duMixOutput) {
        super.changeOutput(duMixOutput);
        this.jo = false;
    }

    @Override // com.baidu.ar.be
    public void changeOutputSize(int i, int i2) {
        super.changeOutputSize(i, i2);
        this.jo = false;
    }

    public h getLuaApplicationState() {
        return this.jr;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || this.jU) {
            return;
        }
        bg bgVar = this.ju;
        if (bgVar != null && !bgVar.bH()) {
            this.jH.getARPRenderer().runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.bd.1
                @Override // java.lang.Runnable
                public void run() {
                    DuMixInput duMixInput = bd.this.ax;
                    if (duMixInput == null || duMixInput.getInputSurface() == null) {
                        return;
                    }
                    bd.this.ax.getInputSurface().updateTexImage();
                }
            });
        } else if (this.jV) {
            StatisticApi.getPerformanceApi().onFrameIn();
            this.jH.getARPRenderer().render(surfaceTexture.getTimestamp());
            StatisticApi.getPerformanceApi().onFrameOut();
        }
    }

    public void onRenderFinished(long j) {
        List<FrameRenderListener> list = this.jt;
        if (list != null) {
            Iterator<FrameRenderListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onRenderFinished(j);
            }
        }
    }

    public void onRenderStarted(long j) {
        ARPEngine aRPEngine;
        boolean z;
        List<FrameRenderListener> list = this.jt;
        if (list != null) {
            Iterator<FrameRenderListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onRenderStarted(j);
            }
        }
        DuMixInput duMixInput = this.ax;
        if (duMixInput != null && duMixInput.getInputSurface() != null) {
            this.ax.getInputSurface().updateTexImage();
            this.ax.getInputSurface().getTransformMatrix(this.jy);
        }
        DuMixInput duMixInput2 = this.ax;
        if (duMixInput2 == null || !duMixInput2.isCameraInput() || (aRPEngine = this.jH) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        boolean z2 = true;
        if (this.jz == null) {
            float[] fArr = new float[16];
            this.jz = fArr;
            float[] fArr2 = this.jy;
            System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
            this.jx = this.ax.isFrontCamera();
            z = true;
        } else {
            z = false;
        }
        if (this.jA == null) {
            this.jA = new float[16];
        }
        if (Arrays.equals(this.jy, this.jz)) {
            z2 = false;
        } else {
            this.jx = !this.jx;
            float[] fArr3 = this.jy;
            System.arraycopy(fArr3, 0, this.jz, 0, fArr3.length);
        }
        if (z || z2) {
            ba.a(this.mContext, this.jA, this.jx);
            this.jH.getARPRenderer().setInputMatrix(this.jA);
            b(this.jx);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        ak akVar = this.jn;
        if (akVar == null) {
            return false;
        }
        if (!this.jo) {
            if (view != null) {
                akVar.f(view.getWidth(), view.getHeight());
            } else {
                DuMixOutput duMixOutput = this.ay;
                if (duMixOutput != null) {
                    akVar.f(duMixOutput.getOutputWidth(), this.ay.getOutputHeight());
                }
            }
            this.jo = true;
        }
        try {
            this.jn.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return true;
    }

    @Override // com.baidu.ar.be
    public void pause() {
        kf.c("ARRendererBase", "pause()");
        ak akVar = this.jn;
        if (akVar != null) {
            akVar.onPause();
        }
        super.pause();
    }

    @Override // com.baidu.ar.be
    public void release() {
        ii iiVar = this.jp;
        if (iiVar != null) {
            iiVar.release();
            this.jp = null;
        }
        ConcurrentHashMap<DuMixOutput, bm> concurrentHashMap = this.js;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.js = null;
        }
        List<FrameRenderListener> list = this.jt;
        if (list != null) {
            list.clear();
            this.jt = null;
        }
        ak akVar = this.jn;
        if (akVar != null) {
            akVar.release();
            this.jn = null;
        }
        bj bjVar = this.jw;
        if (bjVar != null) {
            bjVar.release();
            this.jw = null;
        }
        fr frVar = this.jr;
        if (frVar != null) {
            frVar.release();
            this.jr = null;
        }
        jf jfVar = this.jq;
        if (jfVar != null) {
            jfVar.release();
            this.jq = null;
        }
        this.ju = null;
        this.ad = null;
        this.jy = null;
        this.jA = null;
        this.jz = null;
        super.release();
    }

    public void removeFrameRenderListener(FrameRenderListener frameRenderListener) {
        List<FrameRenderListener> list;
        if (frameRenderListener == null || (list = this.jt) == null) {
            return;
        }
        list.remove(frameRenderListener);
    }

    public void removeOutputSurface(DuMixOutput duMixOutput) {
        if (duMixOutput == null || duMixOutput.getOutputSurface() == null || !(duMixOutput.getOutputSurface() instanceof Surface)) {
            kf.b("ARRendererBase", "removeOutputSurface duMixOutput is error!!!");
            return;
        }
        if (this.js != null) {
            kf.c("ARRendererBase", "removeOutputSurface() surface = " + duMixOutput.getOutputSurface().hashCode());
            bm remove = this.js.remove(duMixOutput);
            ARPEngine aRPEngine = this.jH;
            if (aRPEngine == null || aRPEngine.getARPRenderer() == null || remove == null || TextUtils.isEmpty(remove.bQ())) {
                return;
            }
            this.jH.getARPRenderer().removeOutputTargetByAddr(remove.bQ());
        }
    }

    public void render() {
        DuMixInput duMixInput = this.ax;
        if (duMixInput != null && duMixInput.isSingleFrame()) {
            by();
        }
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.jH.getARPRenderer().render(System.currentTimeMillis());
    }

    @Override // com.baidu.ar.be
    public void resume() {
        kf.c("ARRendererBase", "resume()");
        super.resume();
        ak akVar = this.jn;
        if (akVar != null) {
            akVar.onResume();
        }
    }

    public void runAsyncOnRenderContext(Runnable runnable) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || runnable == null) {
            return;
        }
        this.jH.getARPRenderer().runAsyncOnRenderContext(runnable);
    }

    public void runSyncOnRenderContext(Runnable runnable) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || runnable == null) {
            return;
        }
        this.jH.getARPRenderer().runSyncOnRenderContext(runnable);
    }

    public void setCameraSwitchListener(bf bfVar) {
        this.ad = bfVar;
    }

    public void setDefaultPipeLine(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "filter_pipeline = function()\n\n    fm = ae.FilterManager:get_instance();\n\n    global_copy_filter = fm:create_filter(\"Tex2DFilter\", \"globalTex2DFilter\", true);\n    gl_makeup_filer = fm:create_filter(\"BeautyMakeupFilter\",\"globalBeautyMakeupFilter\",true);\n\n    skin_filter = fm:create_filter(\"SkinFilter\", \"globalSkinFilter\", true);\n    engine_filter = fm:create_filter(\"EngineFilter\", \"globalEngineFilter\", true);\n    fm:update_property_int(engine_filter, \"is_enable\", 0);\n    face_filter = fm:create_filter(\"FaceFilter\", \"globalFaceFilter\", true);\n    lut_filter = fm:create_filter(\"LUTFilter\", \"globalLutFilter\", true);\n    tune_color_filter = fm:create_filter(\"TuneColorFilter\", \"globalTuneColorFilter\", true);\n    fm:reset_pipeline();\n    fm:connect_filters_by_id(skin_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(skin_filter, global_copy_filter);\n    fm:connect_filters_by_id(global_copy_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(gl_makeup_filer, face_filter);\n    fm:connect_filters_by_id(face_filter, tune_color_filter);\n    fm:connect_filters_by_id(tune_color_filter, engine_filter);\n    fm:connect_filters_by_id(engine_filter, lut_filter);\n\n    fm:connect_filter_to_camera(skin_filter);\n    fm:connect_filter_to_output(lut_filter);\n\nend\nfilter_pipeline()\n\n";
        }
        this.bf = str;
    }

    public void setInputMatrix(float[] fArr) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.jH.getARPRenderer().setInputMatrix(fArr);
    }

    public void setStateListener(DuMixStateListener duMixStateListener) {
        this.jR = duMixStateListener;
    }

    private void a(String str, DuMixInput duMixInput, DuMixOutput duMixOutput) {
        if (duMixOutput == null || duMixOutput.getWatermark() == null) {
            return;
        }
        a(duMixOutput.getWatermark());
        if (duMixOutput.getWatermark().getBitmap() == null) {
            kf.b("ARRendererBase", "setWatermark error!!! As no watermark image!!!");
            return;
        }
        b(duMixInput, duMixOutput);
        if (this.jH == null || duMixOutput.getWatermark().getRenderRect() == null || duMixOutput.getWatermark().getRenderRect().length != 4) {
            return;
        }
        this.jH.setWatermark(str, duMixOutput.getWatermark().getBitmap(), duMixOutput.getWatermark().getRenderRect());
    }

    @Override // com.baidu.ar.be
    public void b(Object obj, int i, int i2) {
        super.b(obj, i, i2);
        this.jo = false;
    }

    private float[] a(Watermark watermark, float f, float f2, float f3, float f4) {
        float[] fArr = new float[4];
        Point startPoint = watermark.getStartPoint();
        float width = watermark.getBitmap().getWidth() * watermark.getScale();
        float height = watermark.getBitmap().getHeight() * watermark.getScale();
        int i = AnonymousClass2.jC[watermark.getCoordinateType().ordinal()];
        if (i == 1) {
            fArr[0] = (startPoint.x + f3) / f;
            fArr[1] = (startPoint.y + f4) / f2;
        } else if (i == 2) {
            fArr[0] = (startPoint.x + f3) / f;
            fArr[1] = (((f2 - f4) - startPoint.y) - height) / f2;
        } else if (i == 3) {
            fArr[0] = (((f - f3) - startPoint.x) - width) / f;
            fArr[1] = (startPoint.y + f4) / f2;
        } else if (i == 4) {
            fArr[0] = (((f - f3) - startPoint.x) - width) / f;
            fArr[1] = (((f2 - f4) - startPoint.y) - height) / f2;
        }
        fArr[2] = width / f;
        fArr[3] = height / f2;
        return fArr;
    }

    public void b(boolean z) {
        bf bfVar = this.ad;
        if (bfVar != null) {
            bfVar.b(z);
        }
    }
}
