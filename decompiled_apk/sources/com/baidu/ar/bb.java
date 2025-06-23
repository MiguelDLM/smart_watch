package com.baidu.ar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.engine.engine3d.IARPCamera;
import com.baidu.ar.arplay.core.engine.engine3d.IARPNode;
import com.baidu.ar.arplay.core.engine.engine3d.IARPScene;
import com.baidu.ar.arplay.core.engine.rotate.Orientation;
import com.baidu.ar.arplay.core.engine.rotate.OrientationManager;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.core.renderer.OnNeedCacheFrameListener;
import com.baidu.ar.arplay.representation.Matrixf4x4;
import com.baidu.ar.arplay.representation.Quaternion;
import com.baidu.ar.arplay.representation.Vector3f;
import com.baidu.ar.arplay.representation.Vector4f;
import com.baidu.ar.arrender.ARRenderFpsCallback;
import com.baidu.ar.arrender.FrameRenderListener;
import com.baidu.ar.arrender.IARRenderer;
import com.baidu.ar.bh;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class bb extends bd implements OrientationManager.OrientationListener, IARRenderer {
    private List<String> U;
    private b ar;
    private a iU;
    private Runnable iV;
    private bl iW;
    protected Runnable iX;
    protected bi iY;
    private Runnable iZ;
    private bk ja;
    private Runnable jb;
    private float jc;
    private int jd;
    private boolean je;
    private int jf;
    private ARRenderFpsCallback jg;

    /* renamed from: com.baidu.ar.bb$6, reason: invalid class name */
    /* loaded from: classes7.dex */
    /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] jk;

        static {
            int[] iArr = new int[bh.a.values().length];
            jk = iArr;
            try {
                iArr[bh.a.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jk[bh.a.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                jk[bh.a.FLOAT_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                jk[bh.a.STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface a {
        void onInputSizeChange(int i, int i2);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i, int i2);
    }

    public bb(Context context, Looper looper, fs fsVar, EGLContext eGLContext, String str) {
        super(context, looper, fsVar, eGLContext, str);
        this.jd = 0;
        this.je = true;
        this.jf = 0;
    }

    private void br() {
        int i;
        if (this.jI && (i = this.jd) >= 0 && this.je) {
            if (i == 3) {
                this.jH.setEngineBlendState(0);
            } else if (i == 0) {
                this.jH.setEngineBlendState(1);
            }
            this.jd--;
        }
    }

    private void n(boolean z) {
        if (this.F == null) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", Integer.valueOf(ErrorCode.MSP_ERROR_NET_GENERAL));
        hashMap.put("front_camera", Integer.valueOf(!z ? 1 : 0));
        this.F.b(1902, hashMap);
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.be
    public /* bridge */ /* synthetic */ void J(String str) {
        super.J(str);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void addAlgoCache(int i, boolean z) {
        if (this.jH == null || i < 0) {
            return;
        }
        kf.c("ARRenderer", "addAlgoCache type = " + i + " && sync = " + z);
        this.jH.addAlgoType(new int[]{i}, z ? 1 : 0);
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void addFrameRenderListener(FrameRenderListener frameRenderListener) {
        super.addFrameRenderListener(frameRenderListener);
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void addOutputSurface(DuMixOutput duMixOutput) {
        super.addOutputSurface(duMixOutput);
    }

    public DuMixInput bp() {
        return this.ax;
    }

    public DuMixOutput bq() {
        return this.ay;
    }

    @Override // com.baidu.ar.bd
    public /* bridge */ /* synthetic */ jf bs() {
        return super.bs();
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.be
    public /* bridge */ /* synthetic */ void bt() {
        super.bt();
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.be
    public /* bridge */ /* synthetic */ void bu() {
        super.bu();
    }

    @Override // com.baidu.ar.be
    public /* bridge */ /* synthetic */ void bv() {
        super.bv();
    }

    @Override // com.baidu.ar.be
    public /* bridge */ /* synthetic */ boolean bw() {
        return super.bw();
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void calibrationTouchAngle() {
        ac acVar = this.jK;
        if (acVar != null) {
            acVar.calibrationTouchAngle();
        }
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void cancelAysncRenderTask(Runnable runnable) {
        super.cancelAysncRenderTask(runnable);
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.be
    public /* bridge */ /* synthetic */ void changeOutput(DuMixOutput duMixOutput) {
        super.changeOutput(duMixOutput);
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.be
    public void changeOutputSize(int i, int i2) {
        super.changeOutputSize(i, i2);
        b bVar = this.ar;
        if (bVar != null) {
            bVar.a(i, i2);
        }
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void clearAlgoCache() {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.clearAlgoCache();
        }
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void clearCaseLutFilter() {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.disableCaseLutTexture();
        }
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void convertAlgo2ScreenPoint(PointF pointF, boolean z) {
        ba.a(pointF, z, this.ax, this.ay, this.jv);
    }

    @Override // com.baidu.ar.be
    public /* bridge */ /* synthetic */ void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        super.createPixelReader(pixelReadParams, pixelReadListener);
    }

    @Override // com.baidu.ar.be
    public /* bridge */ /* synthetic */ void destroyPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener) {
        super.destroyPixelReader(pixelReadParams, pixelReadListener);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void enableSyncFaceLandmark(boolean z) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.setFaceLandMarkFrameAcheMode(z ? 1 : 0);
        }
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void enableSyncRender(boolean z) {
        kf.u("ARRenderer", "enableSyncRender enable = " + z);
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.jH.getARPRenderer().setSourceSyncProperty(z);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public String getCurrentCasePath() {
        return this.mCasePath;
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public Matrixf4x4 getInitialTransform() {
        IARPScene currentScene;
        IARPCamera activeCamera;
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || (currentScene = aRPEngine.getCurrentScene()) == null || (activeCamera = currentScene.getActiveCamera()) == null) {
            return null;
        }
        return activeCamera.getInitialTransform();
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.arrender.IARRenderer
    public /* bridge */ /* synthetic */ h getLuaApplicationState() {
        return super.getLuaApplicationState();
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void getSnapShot(com.baidu.ar.arplay.core.renderer.TakePictureCallback takePictureCallback) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.jH.getARPRenderer().getSnapShot(takePictureCallback, this.ay.getOutputWidth(), this.ay.getOutputHeight(), OrientationManager.getGlobalOrientation().getDegree());
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void initWorldAxis() {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.initWorldAxis();
        }
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public boolean isDriverdByARPVersion() {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            return aRPEngine.isDriverdByARPVersion();
        }
        return false;
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public float[] location2ScreenPoint(float[] fArr) {
        IARPScene currentScene;
        ARPEngine aRPEngine = this.jH;
        return (aRPEngine == null || (currentScene = aRPEngine.getCurrentScene()) == null) ? new float[0] : currentScene.sceneProject(fArr);
    }

    @Override // com.baidu.ar.be
    public /* bridge */ /* synthetic */ void o(boolean z) {
        super.o(z);
    }

    @Override // com.baidu.ar.bd, android.graphics.SurfaceTexture.OnFrameAvailableListener
    public /* bridge */ /* synthetic */ void onFrameAvailable(SurfaceTexture surfaceTexture) {
        super.onFrameAvailable(surfaceTexture);
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.arplay.core.renderer.OnRenderFinishedListener
    public void onRenderFinished(long j) {
        ARRenderFpsCallback aRRenderFpsCallback = this.jg;
        if (aRRenderFpsCallback != null && (aRRenderFpsCallback.listenType() & 2) != 0) {
            this.jg.onRenderFinished();
        }
        super.onRenderFinished(j);
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.arplay.core.renderer.OnRenderStartedListener
    public void onRenderStarted(long j) {
        ARRenderFpsCallback aRRenderFpsCallback = this.jg;
        if (aRRenderFpsCallback != null && (aRRenderFpsCallback.listenType() & 1) != 0) {
            this.jg.onRenderStarted();
        }
        super.onRenderStarted(j);
        br();
    }

    @Override // com.baidu.ar.arplay.core.engine.rotate.OrientationManager.OrientationListener
    public void onRotateOrientation(Orientation orientation) {
        if (this.F != null) {
            kf.c("ARRenderer", "sendOrientation2Render orientation = " + orientation);
            this.F.b(4001, ba.a(orientation));
        }
    }

    @Override // com.baidu.ar.bd, android.view.View.OnTouchListener
    public /* bridge */ /* synthetic */ boolean onTouch(View view, MotionEvent motionEvent) {
        return super.onTouch(view, motionEvent);
    }

    @Override // com.baidu.ar.be
    public /* bridge */ /* synthetic */ void p(boolean z) {
        super.p(z);
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.be
    public /* bridge */ /* synthetic */ void pause() {
        super.pause();
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void pauseScene() {
        kf.c("ARRenderer", "pauseScene()");
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            this.jM = true;
            aRPEngine.pauseScene();
        }
    }

    @Override // com.baidu.ar.be
    public /* bridge */ /* synthetic */ void q(boolean z) {
        super.q(z);
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.be
    public void release() {
        this.U = null;
        this.ar = null;
        this.iU = null;
        this.jg = null;
        super.release();
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void removeAlgoCache(int i) {
        if (this.jH == null || i < 0) {
            return;
        }
        kf.c("ARRenderer", "removeAlgoCache type = " + i);
        this.jH.removeAlgoType(new int[]{i});
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void removeFrameRenderListener(FrameRenderListener frameRenderListener) {
        super.removeFrameRenderListener(frameRenderListener);
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void removeOutputSurface(DuMixOutput duMixOutput) {
        super.removeOutputSurface(duMixOutput);
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void render() {
        super.render();
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.be
    public /* bridge */ /* synthetic */ void resume() {
        super.resume();
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void resumeScene() {
        kf.c("ARRenderer", "resumeScene()");
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.resumeScene();
            this.jM = false;
        }
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void runAsyncOnRenderContext(Runnable runnable) {
        super.runAsyncOnRenderContext(runnable);
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void runSyncOnRenderContext(Runnable runnable) {
        super.runSyncOnRenderContext(runnable);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void sceneRelocate() {
        IARPScene currentScene;
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || (currentScene = aRPEngine.getCurrentScene()) == null) {
            return;
        }
        currentScene.relocate();
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void sceneRotateToCamera() {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.sceneRotateToCamera();
        }
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void sceneWorldPositionToOrigin() {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.sceneWorldPositionToOrigin();
        }
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public boolean set3DModelVisible(boolean z) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getCurrentScene() == null) {
            return false;
        }
        return this.jH.getCurrentScene().setVisible(z);
    }

    public void setARRenderFpsCallback(ARRenderFpsCallback aRRenderFpsCallback) {
        this.jg = aRRenderFpsCallback;
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setAlgoHandleData(long j, String str) {
        if (this.jH == null || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        n nVar = new n();
        nVar.u(str);
        nVar.setTimestamp(AlgoHandleAdapter.getHandleTimeStamp(j));
        nVar.i(AlgoHandleAdapter.getHandleIsFront(j));
        nVar.h(AlgoHandleAdapter.getHandleEnableSync(j));
        if (a(nVar)) {
            return;
        }
        this.jH.setAlgoDataHandle(j);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setAvatarGestureConfig() {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.setAvatarGestureConfig();
        }
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setBlendShape(HashMap<String, Double> hashMap) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.setBlendShape(hashMap);
        }
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setCacheFrameListener(OnNeedCacheFrameListener onNeedCacheFrameListener) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.jH.getARPRenderer().setOnNeedCacheFrameListener(onNeedCacheFrameListener);
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void setCameraSwitchListener(bf bfVar) {
        super.setCameraSwitchListener(bfVar);
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void setDefaultPipeLine(String str) {
        super.setDefaultPipeLine(str);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setEnabledAbilities(List<String> list) {
        this.U = list;
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setEnvironmentDataPipKV(final String str, final Object obj) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.jH.getARPRenderer().runAsyncOnRenderContext(new Runnable() { // from class: com.baidu.ar.bb.5
            @Override // java.lang.Runnable
            public void run() {
                az azVar = bb.this.jJ;
                if (azVar != null) {
                    azVar.setDataPipKV(str, obj);
                }
            }
        });
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setFieldOfView(float f) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.jc = f;
        if (this.jb == null) {
            this.jb = new Runnable() { // from class: com.baidu.ar.bb.4
                @Override // java.lang.Runnable
                public void run() {
                    IARPCamera activeCamera;
                    IARPScene currentScene = bb.this.jH.getCurrentScene();
                    if (currentScene == null || (activeCamera = currentScene.getActiveCamera()) == null) {
                        return;
                    }
                    activeCamera.setFieldOfView(bb.this.jc);
                }
            };
        }
        this.jH.getARPRenderer().cancelAysncRenderTask(this.jb);
        this.jH.getARPRenderer().runAsyncOnRenderContext(this.jb);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setGLWebViewUseable(Context context, ViewGroup viewGroup) {
        aw awVar = this.jL;
        if (awVar != null) {
            awVar.a(context, viewGroup, this);
        }
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setImuType(fd fdVar) {
        ac acVar = this.jK;
        if (acVar != null) {
            acVar.e(fdVar.getTypeValue());
        }
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void setInputMatrix(float[] fArr) {
        super.setInputMatrix(fArr);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setInteractionCallback(ARPDataInteraction.b bVar) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.setInteraction(bVar);
        }
    }

    @Override // com.baidu.ar.be
    public /* bridge */ /* synthetic */ void setLocalDeviceGrade(int i) {
        super.setLocalDeviceGrade(i);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setNativeWebViewUseable(Context context, ViewGroup viewGroup) {
        aw awVar = this.jL;
        if (awVar != null) {
            awVar.b(context, viewGroup, null);
        }
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setOffScreenGuideWork(boolean z) {
        IARPScene currentScene;
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || (currentScene = aRPEngine.getCurrentScene()) == null) {
            return;
        }
        currentScene.setOffScreenGuideWork(z);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setRenderBlendInput(boolean z) {
        this.je = z;
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.setEngineBlendState(z ? 3 : 2);
        }
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setRootNodeEulerAngle(float f, float f2, float f3) {
        IARPNode rootNode;
        if (this.jH == null) {
            return;
        }
        Vector3f vector3f = new Vector3f((float) ((f * 3.141592653589793d) / 180.0d), (float) ((f2 * 3.141592653589793d) / 180.0d), (float) ((f3 * 3.141592653589793d) / 180.0d));
        IARPScene currentScene = this.jH.getCurrentScene();
        if (currentScene == null || (rootNode = currentScene.getRootNode()) == null) {
            return;
        }
        rootNode.setEulerAnges(vector3f);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setRootNodeRotation(float f, float f2, float f3) {
        IARPNode rootNode;
        if (this.jH == null) {
            return;
        }
        Quaternion quaternion = new Quaternion();
        Quaternion quaternion2 = new Quaternion();
        quaternion2.setAxisAngle(new Vector3f(0.0f, 0.0f, 1.0f), f);
        Quaternion quaternion3 = new Quaternion();
        quaternion3.setAxisAngle(new Vector3f(1.0f, 0.0f, 0.0f), f2);
        Quaternion quaternion4 = new Quaternion();
        quaternion4.setAxisAngle(new Vector3f(0.0f, 0.0f, 1.0f), f3);
        quaternion.multiplyByQuat(quaternion2);
        quaternion.multiplyByQuat(quaternion3);
        quaternion.multiplyByQuat(quaternion4);
        Vector4f vector4f = new Vector4f();
        quaternion.toAxisAngle(vector4f);
        vector4f.setW((float) Math.toRadians(vector4f.getW()));
        IARPScene currentScene = this.jH.getCurrentScene();
        if (currentScene == null || (rootNode = currentScene.getRootNode()) == null) {
            return;
        }
        rootNode.setRotation(vector4f);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setSkeletonData(HashMap<String, List<Double>> hashMap) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.setSkeletionData(hashMap);
        }
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.arrender.IRenderer
    public /* bridge */ /* synthetic */ void setStateListener(DuMixStateListener duMixStateListener) {
        super.setStateListener(duMixStateListener);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setSyncFrameTimestamp(long j) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null) {
            return;
        }
        this.jH.getARPRenderer().setAlgoPts(j);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void setTouchEnable(boolean z) {
        ak akVar = this.jn;
        if (akVar != null) {
            akVar.m(z);
        }
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void updateDeviceOrientation() {
        onRotateOrientation(OrientationManager.getGlobalOrientation());
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public String updateFilterCase(String str) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            return aRPEngine.adjustFilterWithCasePathParam(str);
        }
        return null;
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void updateFilterData(bh bhVar) {
        if (this.jH == null || bhVar == null || a(bhVar) || this.jT) {
            kf.b("ARRenderer", "updateFilterData error!!!");
            return;
        }
        int i = AnonymousClass6.jk[bhVar.bK().ordinal()];
        if (i == 1) {
            this.jH.adjustFilterWithIntParam(bhVar.getFilterName(), bhVar.bI(), ((Integer) bhVar.bJ()).intValue(), bhVar.getTimestamp());
            return;
        }
        if (i == 2) {
            Object bJ = bhVar.bJ();
            this.jH.adjustFilterWithFloatParam(bhVar.getFilterName(), bhVar.bI(), bJ instanceof Double ? (float) ((Double) bJ).doubleValue() : ((Float) bJ).floatValue(), bhVar.getTimestamp());
        } else if (i == 3) {
            this.jH.adjustFilterWithFloatArrayParam(bhVar.getFilterName(), bhVar.bI(), (float[]) bhVar.bJ(), bhVar.getTimestamp());
        } else if (i != 4) {
            kf.b("ARRenderer", "updateFilterData filterData.getAdjustValueType() error!!!");
        } else {
            this.jH.adjustFilterWithStringParam(bhVar.getFilterName(), bhVar.bI(), (String) bhVar.bJ(), bhVar.getTimestamp());
        }
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void updateFilterNodeData(bi biVar) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || biVar == null) {
            kf.b("ARRenderer", "updateFilterNodeData error!!!");
            return;
        }
        this.iY = biVar;
        if (this.iX == null) {
            this.iX = new Runnable() { // from class: com.baidu.ar.bb.2
                @Override // java.lang.Runnable
                public void run() {
                    bi biVar2 = bb.this.iY;
                    if (biVar2 == null || TextUtils.isEmpty(biVar2.getNodeName()) || bb.this.iY.bL() == null) {
                        return;
                    }
                    bb bbVar = bb.this;
                    if (bbVar.jH == null || bbVar.a(bbVar.iY)) {
                        return;
                    }
                    bb bbVar2 = bb.this;
                    bbVar2.jH.updateNodeUniform(bbVar2.iY.getNodeName(), bb.this.iY.bL());
                }
            };
        }
        this.jH.getARPRenderer().cancelAysncRenderTask(this.iX);
        this.jH.getARPRenderer().runAsyncOnRenderContext(this.iX);
    }

    @Override // com.baidu.ar.be
    public /* bridge */ /* synthetic */ void updatePixelReader(PixelReadParams pixelReadParams, PixelRotation pixelRotation) {
        super.updatePixelReader(pixelReadParams, pixelRotation);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void updateRenderCameraData(bk bkVar) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || bkVar == null || a(bkVar)) {
            kf.b("ARRenderer", "updateRenderCameraData error!!!");
            return;
        }
        this.ja = bkVar;
        if (this.iZ == null) {
            this.iZ = new Runnable() { // from class: com.baidu.ar.bb.3
                @Override // java.lang.Runnable
                public void run() {
                    IARPCamera activeCamera;
                    IARPScene currentScene = bb.this.jH.getCurrentScene();
                    if (currentScene == null || (activeCamera = currentScene.getActiveCamera()) == null) {
                        return;
                    }
                    activeCamera.setViewMatrix(bb.this.ja.getMatrix());
                }
            };
        }
        this.jH.getARPRenderer().cancelAysncRenderTask(this.iZ);
        this.jH.getARPRenderer().runAsyncOnRenderContext(this.iZ);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void updateRenderNodeData(bl blVar, boolean z) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || aRPEngine.getARPRenderer() == null || blVar == null || a(blVar)) {
            kf.b("ARRenderer", "updateRenderNodeData error!!!");
            return;
        }
        if (!z) {
            this.jH.updateAlgoDataToNode(blVar.getWidth(), blVar.getHeight(), blVar.bP());
            return;
        }
        this.iW = blVar;
        if (this.iV == null) {
            this.iV = new Runnable() { // from class: com.baidu.ar.bb.1
                @Override // java.lang.Runnable
                public void run() {
                    bb bbVar = bb.this;
                    bbVar.jH.updateAlgoDataToNode(bbVar.iW.getWidth(), bb.this.iW.getHeight(), bb.this.iW.bP());
                }
            };
        }
        this.jH.getARPRenderer().cancelAysncRenderTask(this.iV);
        this.jH.getARPRenderer().runAsyncOnRenderContext(this.iV);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void updateTransforms(Matrixf4x4 matrixf4x4) {
        IARPScene currentScene;
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine == null || (currentScene = aRPEngine.getCurrentScene()) == null) {
            return;
        }
        currentScene.getActiveCamera().setTransform(matrixf4x4);
    }

    public bb(Context context, Looper looper, fs fsVar, String str) {
        this(context, looper, fsVar, null, str);
    }

    private boolean c(n nVar) {
        return nVar.an() && nVar.ao() != this.jx;
    }

    public void a(Bitmap bitmap, float f, float f2, float f3, float f4) {
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null) {
            aRPEngine.setAuthPic(bitmap, new float[]{f, f2, f3, f4});
        }
    }

    @Override // com.baidu.ar.bd, com.baidu.ar.be
    public /* bridge */ /* synthetic */ void b(Object obj, int i, int i2) {
        super.b(obj, i, i2);
    }

    @Override // com.baidu.ar.arrender.IARRenderer
    public void render(long j) {
        if (this.jH == null || !this.jI) {
            return;
        }
        this.jH.getARPRenderer().render(j);
    }

    @Override // com.baidu.ar.be
    public /* bridge */ /* synthetic */ void a(DuMixInput duMixInput, DuMixOutput duMixOutput) {
        super.a(duMixInput, duMixOutput);
    }

    @Override // com.baidu.ar.bd
    public void b(boolean z) {
        kf.c("ARRenderer", "onCameraSwitch front = " + z);
        super.b(z);
        ARPEngine aRPEngine = this.jH;
        if (aRPEngine != null && aRPEngine.getARPRenderer() != null) {
            this.jH.getARPRenderer().setCameraFace(z);
        }
        ARPEngine aRPEngine2 = this.jH;
        if (aRPEngine2 != null) {
            aRPEngine2.setIsFrontCamera(z);
        }
        DuMixInput duMixInput = this.ax;
        if (duMixInput != null && duMixInput.isCameraInput()) {
            this.ax.setFrontCamera(z);
        }
        n(!z);
        updateDeviceOrientation();
        this.jd = 3;
    }

    private boolean b(n nVar) {
        List<String> list = this.U;
        return list == null || !list.contains(nVar.am());
    }

    public void a(a aVar) {
        this.iU = aVar;
    }

    public void a(b bVar) {
        this.ar = bVar;
    }

    @Override // com.baidu.ar.be
    public void a(Object obj, int i, int i2) {
        super.a(obj, i, i2);
        a aVar = this.iU;
        if (aVar != null) {
            aVar.onInputSizeChange(i, i2);
        }
    }

    @Override // com.baidu.ar.be
    public /* bridge */ /* synthetic */ void a(JSONObject jSONObject) {
        super.a(jSONObject);
    }

    public boolean a(n nVar) {
        return !nVar.ap() && (b(nVar) || c(nVar));
    }
}
