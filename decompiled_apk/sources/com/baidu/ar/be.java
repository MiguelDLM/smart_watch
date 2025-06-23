package com.baidu.ar;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.engine.ARPEngineParams;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.core.renderer.IARPRenderer;
import com.baidu.ar.arrender.Texture;
import com.baidu.ar.bean.RotationType;
import com.baidu.ar.bean.Size;
import com.baidu.ar.libloader.ILibLoader;
import java.io.File;
import java.lang.ref.SoftReference;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class be implements SurfaceTexture.OnFrameAvailableListener {
    fs F;
    DuMixInput ax;
    DuMixOutput ay;
    String bk;
    private bm jD;
    ARPEngine jH;
    az jJ;
    ac jK;
    aw jL;
    boolean jM;
    private String jN;
    private int jO;
    private Size jP;
    protected EGLContext jQ;
    DuMixStateListener jR;
    Context mContext;
    private boolean jE = false;
    private boolean jF = false;
    private long jG = 0;
    String bf = "filter_pipeline = function()\n\n    fm = ae.FilterManager:get_instance();\n\n    global_copy_filter = fm:create_filter(\"Tex2DFilter\", \"globalTex2DFilter\", true);\n    gl_makeup_filer = fm:create_filter(\"BeautyMakeupFilter\",\"globalBeautyMakeupFilter\",true);\n\n    skin_filter = fm:create_filter(\"SkinFilter\", \"globalSkinFilter\", true);\n    engine_filter = fm:create_filter(\"EngineFilter\", \"globalEngineFilter\", true);\n    fm:update_property_int(engine_filter, \"is_enable\", 0);\n    face_filter = fm:create_filter(\"FaceFilter\", \"globalFaceFilter\", true);\n    lut_filter = fm:create_filter(\"LUTFilter\", \"globalLutFilter\", true);\n    tune_color_filter = fm:create_filter(\"TuneColorFilter\", \"globalTuneColorFilter\", true);\n    fm:reset_pipeline();\n    fm:connect_filters_by_id(skin_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(skin_filter, global_copy_filter);\n    fm:connect_filters_by_id(global_copy_filter, gl_makeup_filer);\n    fm:connect_filters_by_id(gl_makeup_filer, face_filter);\n    fm:connect_filters_by_id(face_filter, tune_color_filter);\n    fm:connect_filters_by_id(tune_color_filter, engine_filter);\n    fm:connect_filters_by_id(engine_filter, lut_filter);\n\n    fm:connect_filter_to_camera(skin_filter);\n    fm:connect_filter_to_output(lut_filter);\n\nend\nfilter_pipeline()\n\n";
    volatile boolean jI = false;
    String mCasePath = null;
    private boolean jS = false;
    protected boolean jT = false;
    volatile boolean jU = false;
    volatile boolean jV = false;
    private boolean jW = false;

    public be(Context context, fs fsVar, EGLContext eGLContext, String str) {
        this.bk = null;
        this.jQ = null;
        kf.c("AbstractRenderer", "create start!!!");
        this.mContext = context;
        this.F = fsVar;
        this.jQ = eGLContext;
        this.jK = new ac(context);
        this.jL = aw.bi();
        this.jJ = new az(context);
        iy.b(this.F);
        this.bk = str;
        ARPEngine aRPEngine = ARPEngine.getInstance();
        this.jH = aRPEngine;
        aRPEngine.setContext(new SoftReference<>(context));
        kf.c("AbstractRenderer", "create end!!!");
    }

    private void K(String str) {
        aw awVar = this.jL;
        if (awVar != null) {
            awVar.H(str);
            File file = new File(str, "res/webview");
            if (file.exists()) {
                File file2 = new File(this.mContext.getFilesDir(), "ar/res/webview");
                km.d(file2);
                km.b(file, file2, true);
            }
        }
    }

    private Surface b(DuMixOutput duMixOutput, Object obj) {
        Surface surface;
        Object outputSurface = duMixOutput.getOutputSurface();
        if (obj == null) {
            obj = outputSurface;
        }
        if (obj == null) {
            bz();
            obj = this.ay.getOutputSurface();
            this.jF = true;
        }
        if (obj instanceof SurfaceHolder) {
            SurfaceHolder surfaceHolder = (SurfaceHolder) obj;
            surface = surfaceHolder.getSurface();
            duMixOutput.setOutputSurface(surfaceHolder);
        } else if (obj instanceof SurfaceTexture) {
            SurfaceTexture surfaceTexture = (SurfaceTexture) obj;
            surfaceTexture.setDefaultBufferSize(duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight());
            surface = new Surface(surfaceTexture);
            duMixOutput.setOutputSurface(surfaceTexture);
        } else if (obj instanceof Surface) {
            surface = (Surface) obj;
            duMixOutput.setOutputSurface(surface);
        } else {
            surface = null;
        }
        if (surface == null) {
            kf.b("AbstractRenderer", "initOutputSurface outputSurface error!!!");
        }
        return surface;
    }

    private void bC() {
        this.jH.getARPRenderer().connectCameraWithTarget();
    }

    private void bD() {
        this.jH.getARPRenderer().runLuaScriptStr(this.bf);
    }

    private void bE() {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null && aRPEngine.getARPRenderer() != null) {
            this.jH.getARPRenderer().runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.be.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DuMixInput duMixInput = be.this.ax;
                        if (duMixInput == null || duMixInput.getInputSurface() == null) {
                            return;
                        }
                        be.this.jV = false;
                        be.this.ax.getInputSurface().detachFromGLContext();
                    } catch (Exception unused) {
                        kf.u("AbstractRenderer", "releaseInput() surfaceTexture.detachFromGLContext() fail!!!");
                    }
                }
            });
        }
        DuMixInput duMixInput = this.ax;
        if (duMixInput != null && duMixInput.getInputSurface() != null) {
            this.ax.getInputSurface().setOnFrameAvailableListener(null);
            if (this.jE) {
                this.ax.getInputSurface().release();
            }
        }
        ARPEngine aRPEngine2 = this.jH;
        if (aRPEngine2 == null || aRPEngine2.getARPRenderer() == null || this.jG <= 0) {
            return;
        }
        this.jH.getARPRenderer().destroyTexture(this.jG);
    }

    private void bF() {
        DuMixOutput duMixOutput = this.ay;
        if (duMixOutput != null && duMixOutput.getOutputSurface() != null && this.jF) {
            if (this.ay.getOutputSurface() instanceof Surface) {
                ((Surface) this.ay.getOutputSurface()).release();
            } else if (this.ay.getOutputSurface() instanceof SurfaceTexture) {
                ((SurfaceTexture) this.ay.getOutputSurface()).release();
            }
        }
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || this.jD == null) {
            return;
        }
        this.jH.getARPRenderer().removeOutputTargetByAddr(this.jD.bQ());
    }

    private void bG() {
        IARPRenderer aRPRenderer;
        String bQ;
        PixelRotation pixelRotation;
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || this.jD == null) {
            return;
        }
        if (kt.isScreenOrientationLandscape(this.mContext)) {
            aRPRenderer = this.jH.getARPRenderer();
            bQ = this.jD.bQ();
            pixelRotation = PixelRotation.RotateLeft;
        } else {
            aRPRenderer = this.jH.getARPRenderer();
            bQ = this.jD.bQ();
            pixelRotation = PixelRotation.NoRotation;
        }
        aRPRenderer.updateOutputSurfaceRotation(bQ, pixelRotation);
    }

    private void bz() {
        this.jH.getARPRenderer().runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.be.2
            @Override // java.lang.Runnable
            public void run() {
                int createTexture = (int) be.this.jH.getARPRenderer().createTexture(3553, be.this.ay.getOutputWidth(), be.this.ay.getOutputHeight());
                kf.c("AbstractRenderer", "setup outputTextureId = " + createTexture);
                be.this.ay.setOutputSurface(new SurfaceTexture(createTexture));
            }
        });
    }

    public void J(String str) {
        kf.c("AbstractRenderer", "createCase() casePath = " + str);
        az azVar = this.jJ;
        if (azVar != null) {
            azVar.bm();
        }
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.loadCaseWithResPath(str);
            DuMixOutput duMixOutput = this.ay;
            if (duMixOutput != null) {
                changeOutputSize(duMixOutput.getOutputWidth(), this.ay.getOutputHeight());
            }
        }
        this.mCasePath = str;
        K(str);
    }

    public Size a(DuMixInput duMixInput) {
        if (duMixInput == null) {
            kf.b("AbstractRenderer", "getEngineInputSize duMixInput is null!!!");
            return null;
        }
        Size size = this.jP;
        if (size != null && size.getWidth() != 0 && this.jP.getHeight() != 0) {
            return this.jP;
        }
        Size size2 = new Size(duMixInput.getInputHeight(), duMixInput.getInputWidth());
        if (!duMixInput.isCameraInput() && (duMixInput.getRotationType() == RotationType.ROTATE_0 || duMixInput.getRotationType() == RotationType.ROTATE_180)) {
            size2.setWidth(duMixInput.getInputWidth());
            size2.setHeight(duMixInput.getInputHeight());
        }
        return size2;
    }

    public void bA() {
        this.jS = true;
        fn.require("dumixar");
        fn.setLibReadyListener("dumixar", new ILibLoader.c() { // from class: com.baidu.ar.be.3
            @Override // com.baidu.ar.libloader.ILibLoader.c
            public void onError() {
            }

            @Override // com.baidu.ar.libloader.ILibLoader.c
            public void onReady() {
                be.this.jS = false;
                be beVar = be.this;
                if (beVar.jT) {
                    return;
                }
                beVar.bB();
            }
        });
    }

    public void bB() {
        if (this.jH != null) {
            try {
                if (TextUtils.isEmpty(this.jN)) {
                    this.jH.setLocalDeviceGrade(this.jO);
                } else {
                    this.jH.setConfig("grading", this.jN);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        bD();
        bu();
    }

    public void bt() {
        kf.c("AbstractRenderer", "destroyCase()");
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.unloadCase();
        }
        bD();
        ARPEngine aRPEngine2 = this.jH;
        if (aRPEngine2 != null && aRPEngine2.getARPRenderer() != null) {
            this.jH.getARPRenderer().purgeMemory();
        }
        this.mCasePath = null;
        aw awVar = this.jL;
        if (awVar != null) {
            awVar.H(null);
        }
    }

    public void bu() {
        DuMixInput duMixInput;
        kf.c("AbstractRenderer", "startARPEngine()");
        if (this.jH == null) {
            this.jH = ARPEngine.getInstance();
        }
        if (this.jH != null && (duMixInput = this.ax) != null && this.ay != null) {
            Size a2 = a(duMixInput);
            Size a3 = a(a2, this.ay);
            ARPEngineParams aRPEngineParams = new ARPEngineParams();
            aRPEngineParams.setInputWidth(a2.getWidth());
            aRPEngineParams.setInputHeight(a2.getHeight());
            aRPEngineParams.setOutputWidth(a3.getWidth());
            aRPEngineParams.setOutputHeight(a3.getHeight());
            aRPEngineParams.setDensity(kt.w(this.mContext));
            if (this.ax.isCameraInput()) {
                aRPEngineParams.setIsFrontCamera(this.ax.isFrontCamera());
            }
            aRPEngineParams.setShaderDBPath(this.bk);
            this.jH.createEngine(aRPEngineParams);
        }
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.resume();
        }
        az azVar = this.jJ;
        if (azVar != null) {
            azVar.bm();
        }
        try {
            ac acVar = this.jK;
            if (acVar != null) {
                acVar.start();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void bv() {
        kf.c("AbstractRenderer", "stopARPEngine()");
        if (this.jH == null || !this.jI) {
            fs fsVar = this.F;
            if (fsVar != null) {
                fsVar.handleMessage(7, 0, null);
            }
        } else {
            this.jH.destroyEngine();
            this.jI = false;
        }
        this.jJ = null;
        ac acVar = this.jK;
        if (acVar != null) {
            acVar.release();
        }
    }

    public boolean bw() {
        return this.jS;
    }

    public abstract void bx();

    public void c(DuMixInput duMixInput) {
        if (duMixInput.getInputTexture() == null) {
            if (duMixInput.getInputSurface() != null) {
                a(duMixInput.getInputSurface(), duMixInput.isCameraInput() ? 36197 : 3553, duMixInput.getInputWidth(), duMixInput.getInputHeight());
            }
        } else {
            if (duMixInput.getInputTexture().getId() == -1) {
                long createTexture = this.jH.getARPRenderer().createTexture(duMixInput.getInputTexture().getType(), duMixInput.getInputWidth(), duMixInput.getInputHeight());
                duMixInput.getInputTexture().setHandle(createTexture);
                duMixInput.getInputTexture().setId(this.jH.getARPRenderer().getTextureId(createTexture));
            }
            this.jH.getARPRenderer().setInputTexture(duMixInput.getInputTexture().getType(), duMixInput.getInputTexture().getId(), duMixInput.getInputWidth(), duMixInput.getInputHeight());
        }
    }

    public void changeOutput(DuMixOutput duMixOutput) {
        bF();
        this.ay = duMixOutput;
        a(duMixOutput, (Object) null);
    }

    public void changeOutputSize(int i, int i2) {
        DuMixOutput duMixOutput;
        bm bmVar;
        if (this.ax == null || (duMixOutput = this.ay) == null) {
            return;
        }
        if (duMixOutput.getOutputHeight() == i2 && this.ay.getOutputWidth() == i) {
            return;
        }
        kf.c("AbstractRenderer", "changeOutputSize() size = " + i + "x" + i2);
        Object outputSurface = this.ay.getOutputSurface();
        if (outputSurface instanceof SurfaceTexture) {
            ((SurfaceTexture) outputSurface).setDefaultBufferSize(i, i2);
        }
        this.ay.setOutputWidth(i);
        this.ay.setOutputHeight(i2);
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null && aRPEngine.getARPRenderer() != null && (bmVar = this.jD) != null && !TextUtils.isEmpty(bmVar.bQ())) {
            this.jH.getARPRenderer().addOutputSurface(this.jD.getSurface(), i, i2);
        }
        if (this.jH != null) {
            Size a2 = a(a(this.ax), this.ay);
            this.jH.setWindowSize(a2.getWidth(), a2.getHeight());
        }
        if (this.ay.isFitScreenAuto()) {
            bG();
        }
    }

    public void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        ARPEngine aRPEngine;
        if (!this.jI || (aRPEngine = this.jH) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        ba.a(this.mContext, this.ax.isFrontCamera(), pixelReadParams);
        this.jH.getARPRenderer().createPixelReaderByPreFilterID(pixelReadParams, pixelReadListener);
    }

    public void destroyPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        ARPEngine aRPEngine;
        if (!this.jI || (aRPEngine = this.jH) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.jH.getARPRenderer().destroyPixelReaderByPreFilterID(pixelReadParams, pixelReadListener);
    }

    public void o(boolean z) {
        this.jI = z;
    }

    public void p(boolean z) {
        DuMixInput duMixInput = this.ax;
        if (duMixInput == null) {
            return;
        }
        this.jW = z;
        if (z) {
            Size b = ba.b(this.ay.getOutputWidth(), this.ay.getOutputHeight(), this.ax.getInputHeight(), this.ax.getInputWidth());
            this.jP = b;
            this.jH.setPreviewSize(b.getWidth(), this.jP.getHeight());
            this.jH.setWindowSize(this.ay.getOutputWidth(), this.ay.getOutputHeight());
            return;
        }
        this.jP = null;
        Size a2 = a(duMixInput);
        Size a3 = a(a2, this.ay);
        this.jH.setPreviewSize(a2.getWidth(), a2.getHeight());
        this.jH.setWindowSize(a3.getWidth(), a3.getHeight());
    }

    public void pause() {
        kf.c("AbstractRenderer", "pause()");
        ac acVar = this.jK;
        if (acVar != null) {
            acVar.release();
        }
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.pause();
        }
    }

    public void q(boolean z) {
        this.jT = z;
    }

    public void release() {
        kf.c("AbstractRenderer", "release() start!!!");
        this.jU = true;
        pause();
        aw awVar = this.jL;
        if (awVar != null) {
            awVar.release();
            this.jL = null;
        }
        iy.c(this.F);
        bv();
        this.jR = null;
        bE();
        this.ax = null;
        bF();
        this.ay = null;
        this.jD = null;
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.destroy();
            this.jH = null;
        }
        ARPEngine.releaseInstance();
        this.mContext = null;
        this.jQ = null;
        kf.c("AbstractRenderer", "release() end!!!");
    }

    public void resume() {
        kf.c("AbstractRenderer", "resume()");
        try {
            this.jK.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.resume();
        }
    }

    public void setLocalDeviceGrade(int i) {
        this.jO = i;
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            try {
                aRPEngine.setLocalDeviceGrade(i);
            } catch (Throwable unused) {
            }
        }
    }

    public void updatePixelReader(PixelReadParams pixelReadParams, PixelRotation pixelRotation) {
        ARPEngine aRPEngine;
        if (!this.jI || (aRPEngine = this.jH) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        pixelReadParams.setPixelRotate(pixelRotation);
        ba.a(this.mContext, this.ax.isFrontCamera(), pixelReadParams);
        this.jH.getARPRenderer().setPixelReaderRotation(pixelReadParams, pixelReadParams.getPixelRotate());
    }

    public Size a(Size size, DuMixOutput duMixOutput) {
        int width;
        int height;
        int outputWidth;
        int outputHeight;
        if (kt.isScreenOrientationLandscape(this.mContext)) {
            width = size.getWidth();
            height = size.getHeight();
            outputWidth = duMixOutput.getOutputHeight();
            outputHeight = duMixOutput.getOutputWidth();
        } else {
            width = size.getWidth();
            height = size.getHeight();
            outputWidth = duMixOutput.getOutputWidth();
            outputHeight = duMixOutput.getOutputHeight();
        }
        return ba.a(width, height, outputWidth, outputHeight);
    }

    public void b(Object obj, int i, int i2) {
        if (obj == null || i <= 0 || i2 <= 0 || this.ay == null || !this.jI) {
            kf.b("AbstractRenderer", "changeOutputSurface error!!!");
            return;
        }
        bF();
        if (obj instanceof SurfaceTexture) {
            this.ay.setOutputSurface((SurfaceTexture) obj);
        } else if (obj instanceof SurfaceHolder) {
            this.ay.setOutputSurface((SurfaceHolder) obj);
        } else {
            if (!(obj instanceof Surface)) {
                kf.b("AbstractRenderer", "changeOutputSurface error!!! As outputSurface is not a surface!!!");
                return;
            }
            this.ay.setOutputSurface((Surface) obj);
        }
        this.ay.setOutputWidth(i);
        this.ay.setOutputHeight(i2);
        DuMixInput duMixInput = this.ax;
        if (duMixInput == null || duMixInput.getInputSurface() != null || this.ax.getInputTexture() != null) {
            a(this.ay, obj);
            return;
        }
        Surface surface = new Surface((SurfaceTexture) obj);
        String addOutputSurface = ARPEngine.getInstance().getARPRenderer().addOutputSurface(surface, i, i2, kt.isScreenOrientationLandscape(this.mContext) ? PixelRotation.RotateLeft : PixelRotation.NoRotation);
        bm bmVar = new bm(this.ay);
        this.jD = bmVar;
        bmVar.setSurface(surface);
        this.jD.M(addOutputSurface);
    }

    private void a(final SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        final int textureId = this.jH.getARPRenderer().getTextureId(this.jH.getARPRenderer().createTexture(i, i2, i3));
        surfaceTexture.setOnFrameAvailableListener(this);
        this.jH.getARPRenderer().setInputTexture(i, textureId, i2, i3);
        try {
            surfaceTexture.detachFromGLContext();
        } catch (Exception unused) {
            kf.v("AbstractRenderer", "attachInputSurface surfaceTexture.detachFromGLContext() fail!!!");
        }
        this.jH.getARPRenderer().runSyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.be.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    surfaceTexture.attachToGLContext(textureId);
                    be.this.jV = true;
                    surfaceTexture.updateTexImage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        surfaceTexture.setDefaultBufferSize(i2, i3);
        DuMixStateListener duMixStateListener = this.jR;
        if (duMixStateListener != null) {
            duMixStateListener.onInputSurfaceTextureAttach(surfaceTexture);
        }
    }

    private boolean b(DuMixInput duMixInput) {
        try {
            this.jH.getARPRenderer().setUpEGLEnv(this.jQ);
            if (duMixInput.getInputTexture() == null && duMixInput.getInputSurface() == null) {
                this.jH.getARPRenderer().createNoInputSource();
            } else {
                this.jH.getARPRenderer().setCameraFace(duMixInput.isFrontCamera());
                PixelRotation a2 = ba.a(duMixInput.isFitCameraAuto(), duMixInput.getRotationType(), duMixInput.getMirriorType());
                ao aoVar = ao.INTERNAL_OES_TEX;
                if ((duMixInput.getInputTexture() != null && duMixInput.getInputTexture().getType() == 3553) || (duMixInput.getInputSurface() != null && !duMixInput.isCameraInput())) {
                    aoVar = ao.INTERNAL_2D_TEX;
                }
                if (duMixInput.isSyncInputContent()) {
                    this.jH.getARPRenderer().createSyncInputSource(a2, aoVar);
                } else {
                    this.jH.getARPRenderer().createInputSource(a2, aoVar);
                }
            }
            Size a3 = a(this.ax);
            this.jH.setPreviewSize(a3.getWidth(), a3.getHeight());
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void a(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        ARPEngine aRPEngine;
        kf.c("AbstractRenderer", "setup() start");
        if (duMixInput == null || duMixOutput == null || (aRPEngine = this.jH) == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.ax = duMixInput;
        this.ay = duMixOutput;
        fn.require("dumixar");
        bx();
        if (b(duMixInput)) {
            c(duMixInput);
            a(duMixOutput, (Object) null);
            bC();
            bA();
            kf.c("AbstractRenderer", "setup() end");
        }
    }

    public void a(DuMixOutput duMixOutput, Object obj) {
        Surface b;
        String addOutputSurface;
        if (duMixOutput.getOutputTexture() == null || duMixOutput.getOutputTexture().getId() == -1) {
            b = b(duMixOutput, obj);
            addOutputSurface = this.jH.getARPRenderer().addOutputSurface(b, duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), ba.a(duMixOutput.getRotationType(), duMixOutput.getMirriorType()), ba.a(duMixOutput.getScaleType()));
        } else {
            addOutputSurface = this.jH.getARPRenderer().addOutputTarget(duMixOutput.getOutputTexture().getType(), duMixOutput.getOutputTexture().getId(), duMixOutput.getOutputWidth(), duMixOutput.getOutputHeight(), ba.a(this.ay.getRotationType(), this.ay.getMirriorType()));
            b = null;
        }
        bm bmVar = new bm(duMixOutput);
        this.jD = bmVar;
        bmVar.setSurface(b);
        this.jD.M(addOutputSurface);
        if (duMixOutput.isFitScreenAuto()) {
            bG();
        }
        Size a2 = a(a(this.ax), this.ay);
        this.jH.setWindowSize(a2.getWidth(), a2.getHeight());
    }

    public void a(Object obj, int i, int i2) {
        if (this.ax == null || this.jH == null) {
            return;
        }
        bE();
        this.ax.setInputWidth(i);
        this.ax.setInputHeight(i2);
        if (obj instanceof SurfaceTexture) {
            this.ax.setInputSurface((SurfaceTexture) obj);
        } else if (obj instanceof Texture) {
            this.ax.setInputTexture((Texture) obj);
        }
        c(this.ax);
        p(this.jW);
    }

    public void a(JSONObject jSONObject) {
        if (this.jH == null || jSONObject == null) {
            return;
        }
        String jSONObject2 = jSONObject.toString();
        this.jN = jSONObject2;
        try {
            this.jH.setConfig("grading", jSONObject2);
        } catch (Throwable unused) {
        }
    }
}
