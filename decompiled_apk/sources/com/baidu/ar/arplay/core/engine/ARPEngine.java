package com.baidu.ar.arplay.core.engine;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import com.baidu.ar.am;
import com.baidu.ar.ar;
import com.baidu.ar.arplay.core.engine.ARPContent;
import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
import com.baidu.ar.arplay.core.engine.engine3d.AbstractARPEngine3D;
import com.baidu.ar.arplay.core.engine.engine3d.IARPEngine3D;
import com.baidu.ar.arplay.core.engine.engine3d.IARPScene;
import com.baidu.ar.arplay.core.engine3d.ARPEngine3D;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.core.renderer.ARPFilter;
import com.baidu.ar.arplay.core.renderer.ARPRenderer;
import com.baidu.ar.arplay.core.renderer.IARPRenderer;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class ARPEngine implements am {
    private static final String ENGINE_3D_CLASS_NAME = "com.baidu.ar.arplay.core.engine3d.ARPEngine3D";
    private static final String LOWEST_VERSION_KEY = "compatible_version";
    private static final String TAG = "ARPEngine";
    private static ARPEngine self;
    private ARPDataInteraction mARPDataInteraction;
    private AbstractARPEngine3D mARPEngine3D;
    private ARPEngineParams mARPEngineParams;
    private a mListener;
    boolean mScenePausedByUser;
    private boolean mIsInitNative = false;
    private volatile boolean mIsEngineCreated = false;
    private boolean mIsPaused = false;
    private ARPContent mARPContent = new ARPContent();
    private ARPFilter mARPFilter = new ARPFilter();
    private ARPRenderer mARPRenderer = new ARPRenderer();

    /* loaded from: classes7.dex */
    public interface a {
        void aQ();
    }

    private ARPEngine() {
        ARPDataInteraction aRPDataInteraction = new ARPDataInteraction();
        this.mARPDataInteraction = aRPDataInteraction;
        this.mARPContent.registerCaseLoadListener(aRPDataInteraction);
        initEngine3DInstance();
    }

    private boolean createApp(int i, int i2, int i3, int i4, float f, String str) {
        ar.b(TAG, "createApp [width*height]: [" + i + "*" + i2 + "]");
        boolean nativeCreateApp = nativeCreateApp(i, i2, i3, i4, f, str);
        this.mIsEngineCreated = true;
        ARPContent aRPContent = this.mARPContent;
        if (aRPContent != null) {
            aRPContent.setEngineCreated(this.mIsEngineCreated);
        }
        return nativeCreateApp;
    }

    public static synchronized ARPEngine getInstance() {
        ARPEngine aRPEngine;
        synchronized (ARPEngine.class) {
            try {
                if (self == null) {
                    self = new ARPEngine();
                    ar.b(TAG, "create instance : " + self);
                }
                aRPEngine = self;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aRPEngine;
    }

    private void initEngine3DInstance() {
        try {
            Object newInstance = ARPEngine3D.class.newInstance();
            if (newInstance instanceof IARPEngine3D) {
                this.mARPEngine3D = (AbstractARPEngine3D) newInstance;
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static synchronized boolean isEngineCreated() {
        boolean z;
        synchronized (ARPEngine.class) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("isEngineCreated : ");
                sb.append(self);
                sb.append(" ：");
                ARPEngine aRPEngine = self;
                z = false;
                sb.append(aRPEngine != null && aRPEngine.mIsEngineCreated);
                ar.b(TAG, sb.toString());
                ARPEngine aRPEngine2 = self;
                if (aRPEngine2 != null) {
                    if (aRPEngine2.mIsEngineCreated) {
                        z = true;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    private native boolean nativeSetup(Object obj, String str);

    public static synchronized void releaseInstance() {
        synchronized (ARPEngine.class) {
            try {
                ARPEngine aRPEngine = self;
                if (aRPEngine != null) {
                    aRPEngine.destroy();
                }
                ar.b(TAG, "release instance : " + self);
                self = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addAlgoType(int[] iArr, int i) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.addAlgoType(iArr, i);
        }
    }

    public String adjustFilterWithCasePathParam(String str) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter == null) {
            return null;
        }
        aRPFilter.adjustFilterWithCasePathParam(str);
        return null;
    }

    public void adjustFilterWithFloatArrayParam(String str, String str2, float[] fArr, long j) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.adjustFilterWithFloatArrayParam(str, str2, fArr, j);
        }
    }

    public void adjustFilterWithFloatParam(String str, String str2, float f, long j) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.adjustFilterWithFloatParam(str, str2, f, j);
        }
    }

    public void adjustFilterWithIntParam(String str, String str2, int i, long j) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.adjustFilterWithIntParam(str, str2, i, j);
        }
    }

    public String adjustFilterWithJsonPathParam(String str) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            return aRPFilter.adjustFilterWithJsonPathParam(str);
        }
        return null;
    }

    public void adjustFilterWithStringParam(String str, String str2, String str3, long j) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.adjustFilterWithStringParam(str, str2, str3, j);
        }
    }

    public void clearARMemory() {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.clearARMemory();
        }
    }

    public void clearAlgoCache() {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.clearAlgoCache();
        }
    }

    public boolean createEngine(ARPEngineParams aRPEngineParams) {
        synchronized (this) {
            boolean z = false;
            try {
                if (aRPEngineParams == null) {
                    return false;
                }
                this.mARPEngineParams = aRPEngineParams;
                if (!this.mIsInitNative) {
                    z = nativeSetup(new WeakReference(this), "6.0.0");
                    this.mIsInitNative = true;
                }
                if (!this.mIsEngineCreated) {
                    z = createApp(this.mARPEngineParams.getInputWidth(), this.mARPEngineParams.getInputHeight(), this.mARPEngineParams.getOutputWidth(), this.mARPEngineParams.getOutputHeight(), this.mARPEngineParams.getDensity(), this.mARPEngineParams.getShaderDBPath());
                    ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
                    if (aRPDataInteraction != null) {
                        aRPDataInteraction.setup();
                    }
                }
                AbstractARPEngine3D abstractARPEngine3D = this.mARPEngine3D;
                if (abstractARPEngine3D != null) {
                    abstractARPEngine3D.setIsActiveByARPlayVersionCase(isDriverdByARPVersion());
                }
                this.mARPContent.setIsFrontCamera(this.mARPEngineParams.isIsFrontCamera());
                return z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.baidu.ar.an
    public synchronized void destroy() {
        ar.b(TAG, "destroy");
        ARPRenderer aRPRenderer = this.mARPRenderer;
        if (aRPRenderer != null) {
            aRPRenderer.destroy();
        }
    }

    public synchronized void destroyEngine() {
        try {
            ar.b(TAG, "destroyEngine");
            this.mIsEngineCreated = false;
            ARPFilter aRPFilter = this.mARPFilter;
            if (aRPFilter != null) {
                aRPFilter.destroy();
            }
            ARPContent aRPContent = this.mARPContent;
            if (aRPContent != null) {
                aRPContent.setEngineCreated(this.mIsEngineCreated);
                this.mARPContent.destroy();
            }
            AbstractARPEngine3D abstractARPEngine3D = this.mARPEngine3D;
            if (abstractARPEngine3D != null) {
                abstractARPEngine3D.destroy();
            }
            nativeSetEngineBlendState(0);
            ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
            if (aRPDataInteraction != null) {
                aRPDataInteraction.destroy();
            }
            ARPMessage.getInstance().receiveMsgFromEngine(7, 0, null, 0);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void destroyMockAlgoHandle(long j) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.destroyMockAlgoHandle(j);
        }
    }

    public void disableCaseLutTexture() {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.disableCaseLutTexture();
        }
    }

    public void disableFilterByAuthCode(int i) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.disableFilterByAuthCode(i);
        }
    }

    public IARPRenderer getARPRenderer() {
        return this.mARPRenderer;
    }

    public IARPScene getCurrentScene() {
        AbstractARPEngine3D abstractARPEngine3D;
        if (isEngineCanAccess() && (abstractARPEngine3D = this.mARPEngine3D) != null) {
            return abstractARPEngine3D.getCurrentScene();
        }
        return null;
    }

    public float[] getPreviewSize() {
        ARPContent aRPContent = this.mARPContent;
        if (aRPContent != null) {
            return aRPContent.getPreviewSize();
        }
        return null;
    }

    public float[] getWindowSize() {
        ARPContent aRPContent = this.mARPContent;
        return aRPContent != null ? aRPContent.getWindowSize() : new float[0];
    }

    public void initDataStore(SharedPreferences sharedPreferences) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.initDataStore(sharedPreferences);
        }
    }

    public void initWorldAxis() {
        AbstractARPEngine3D abstractARPEngine3D = this.mARPEngine3D;
        if (abstractARPEngine3D != null) {
            abstractARPEngine3D.initWorldAxis();
        }
    }

    public boolean isAppControllerInterrupt() {
        return nativeIsAppControllerInterrupt();
    }

    public boolean isDriverdByARPVersion() {
        String str;
        Object sharedEnvironmentValue = ARPScriptEnvironment.getInstance().getSharedEnvironmentValue("caseinfo");
        if (sharedEnvironmentValue != null && (sharedEnvironmentValue instanceof HashMap)) {
            HashMap hashMap = (HashMap) sharedEnvironmentValue;
            return (hashMap.get(LOWEST_VERSION_KEY) instanceof String) && (str = (String) hashMap.get(LOWEST_VERSION_KEY)) != "" && str.compareTo("2.0.0") >= 0;
        }
        return false;
    }

    public boolean isEngineCanAccess() {
        return this.mIsEngineCreated && this.mARPContent.isCaseCreated();
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public synchronized int loadCaseWithResPath(String str) {
        ARPRenderer aRPRenderer;
        ARPContent aRPContent = this.mARPContent;
        if (aRPContent == null || (aRPRenderer = this.mARPRenderer) == null) {
            return -1;
        }
        return aRPContent.loadCaseWithResPath(str, aRPRenderer.getCameraPreviewWidth(), this.mARPRenderer.getCameraPreviewHeight());
    }

    public long mockFaceAlgoHandle(long j, float[] fArr) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            return aRPDataInteraction.mockFaceAlgoHandle(j, fArr);
        }
        return -1L;
    }

    public native boolean nativeCreateApp(int i, int i2, int i3, int i4, float f, String str);

    public native void nativeDestroyEngine();

    public native boolean nativeIsAppControllerInterrupt();

    public native void nativeOnPause();

    public native void nativeOnResume();

    public native void nativeSetConfig(String str, String str2);

    public native void nativeSetEngineBlendState(int i);

    public native void nativeSetLocalDeviceGrade(int i);

    public synchronized void onCaseLoadCompleted(Map map) {
        if (map == null) {
            return;
        }
        try {
            AbstractARPEngine3D abstractARPEngine3D = this.mARPEngine3D;
            if (abstractARPEngine3D != null) {
                abstractARPEngine3D.setIsActiveByARPlayVersionCase(isDriverdByARPVersion());
            }
            ARPContent aRPContent = this.mARPContent;
            if (aRPContent != null && aRPContent.checkValid(ARPContent.b.OnCaseLoaded)) {
                ARPRenderer aRPRenderer = this.mARPRenderer;
                if (aRPRenderer != null) {
                    aRPRenderer.clearAllAsyncRenderTask();
                }
                this.mARPContent.onCaseLoadCompleted(map);
                a aVar = this.mListener;
                if (aVar != null) {
                    aVar.aQ();
                }
            }
            if (this.mIsPaused) {
                nativeOnPause();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void onCaseUnloadCompleted() {
        ARPContent aRPContent = this.mARPContent;
        if (aRPContent != null) {
            aRPContent.onCaseUnloadCompleted();
        }
    }

    public void onGestureUpdate(int i, long j, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, float f8, int i4, float f9) {
        ARPDataInteraction aRPDataInteraction;
        if (isEngineCanAccess() && (aRPDataInteraction = this.mARPDataInteraction) != null) {
            aRPDataInteraction.onGestureUpdate(i, j, i2, f, f2, f3, f4, i3, f5, f6, f7, f8, i4, f9);
        }
    }

    public void onGestureUpdateWithScaleFinish(int i, long j, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, float f8, int i4, float f9, boolean z) {
        ARPDataInteraction aRPDataInteraction;
        if (isEngineCanAccess() && (aRPDataInteraction = this.mARPDataInteraction) != null) {
            aRPDataInteraction.onGestureUpdateWithScaleFinish(i, j, i2, f, f2, f3, f4, i3, f5, f6, f7, f8, i4, f9, z);
        }
    }

    public void onTouchUpdate(int i, float f, float f2, float f3, float f4, long j, int i2, float f5) {
        ARPDataInteraction aRPDataInteraction;
        if (isEngineCanAccess() && (aRPDataInteraction = this.mARPDataInteraction) != null) {
            aRPDataInteraction.onTouchUpdate(i, f, f2, f3, f4, j, i2, f5);
        }
    }

    public synchronized void pause() {
        try {
            this.mIsPaused = true;
            if (isEngineCanAccess()) {
                nativeOnPause();
            }
            ARPRenderer aRPRenderer = this.mARPRenderer;
            if (aRPRenderer != null) {
                aRPRenderer.pause();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void pauseScene() {
        try {
            this.mIsPaused = true;
            if (isEngineCanAccess()) {
                nativeOnPause();
            }
            this.mScenePausedByUser = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void removeAlgoType(int[] iArr) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.removeAlgoType(iArr);
        }
    }

    public synchronized void resume() {
        try {
            if (!this.mScenePausedByUser) {
                resumeScene();
            }
            ARPRenderer aRPRenderer = this.mARPRenderer;
            if (aRPRenderer != null) {
                aRPRenderer.resume();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void resumeScene() {
        try {
            this.mIsPaused = false;
            if (isEngineCanAccess()) {
                nativeOnResume();
            }
            this.mScenePausedByUser = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void sceneRotateToCamera() {
        AbstractARPEngine3D abstractARPEngine3D = this.mARPEngine3D;
        if (abstractARPEngine3D != null) {
            abstractARPEngine3D.sceneRotateToCamera();
        }
    }

    public void sceneWorldPositionToOrigin() {
        AbstractARPEngine3D abstractARPEngine3D = this.mARPEngine3D;
        if (abstractARPEngine3D != null) {
            abstractARPEngine3D.sceneWorldPositionToOrigin();
        }
    }

    public synchronized void setAlgoDataHandle(long j) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.setAlgoDataHandle(j);
        }
    }

    public void setAuthPic(Bitmap bitmap, float[] fArr) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.setAuthPic(bitmap, fArr);
        }
    }

    public void setAvatarGestureConfig() {
        HashMap hashMap = new HashMap();
        hashMap.put("gesture_scroll", "interaction_rotate");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("continuous_mapping", hashMap);
        ARPScriptEnvironment.getInstance().setSharedEnvironmentKV("interactioninfo", hashMap2);
    }

    public void setBlendShape(HashMap<String, Double> hashMap) {
        AbstractARPEngine3D abstractARPEngine3D = this.mARPEngine3D;
        if (abstractARPEngine3D != null) {
            abstractARPEngine3D.setBlendShape(hashMap);
        }
    }

    public void setCompletedListener(a aVar) {
        this.mListener = aVar;
    }

    public void setConfig(String str, String str2) {
        ar.b(TAG, "syncServerConfig :" + str2);
        nativeSetConfig(str, str2);
    }

    public void setContext(SoftReference<Context> softReference) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.setContext(softReference);
        }
    }

    public void setEngineBlendState(int i) {
        nativeSetEngineBlendState(i);
    }

    public void setFaceLandMarkFrameAcheMode(int i) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.setFaceLandMarkFrameAcheMode(i);
        }
    }

    public synchronized void setHtmlUpdateCallback(ARPDataInteraction.a aVar) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.setHtmlUpdateCallback(aVar);
        }
    }

    public void setInteraction(ARPDataInteraction.b bVar) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.setInteraction(bVar);
        }
    }

    public void setIsFrontCamera(boolean z) {
        this.mARPContent.setIsFrontCamera(z);
    }

    public void setLocalDeviceGrade(int i) {
        ar.b(TAG, "setLocalDeviceGrade :" + i);
        nativeSetLocalDeviceGrade(i);
    }

    public void setPreviewSize(int i, int i2) {
        ARPContent aRPContent = this.mARPContent;
        if (aRPContent != null) {
            aRPContent.setPreviewSize(i, i2);
        }
    }

    public void setSkeletionData(HashMap<String, List<Double>> hashMap) {
        AbstractARPEngine3D abstractARPEngine3D = this.mARPEngine3D;
        if (abstractARPEngine3D != null) {
            abstractARPEngine3D.setSkeletionData(hashMap);
        }
    }

    public synchronized void setVideoUpdateCallback(ARPDataInteraction.c cVar) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.setVideoUpdateCallback(cVar);
        }
    }

    public void setWatermark(String str, Bitmap bitmap, float[] fArr) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.setWatermark(str, bitmap, fArr);
        }
    }

    public void setWindowSize(int i, int i2) {
        ARPContent aRPContent = this.mARPContent;
        if (aRPContent != null) {
            aRPContent.setWindowSize(i, i2);
        }
    }

    public synchronized void unloadCase() {
        try {
            ARPContent aRPContent = this.mARPContent;
            if (aRPContent != null && aRPContent.checkValid(ARPContent.b.UnloadCase)) {
                ARPRenderer aRPRenderer = this.mARPRenderer;
                if (aRPRenderer != null) {
                    aRPRenderer.clearAllAsyncRenderTask();
                }
                this.mARPContent.unloadCase();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void updateAlgoDataToNode(int i, int i2, byte[] bArr) {
        ARPDataInteraction aRPDataInteraction;
        ar.c(TAG, "updateAlgoDataToNode");
        if (isEngineCanAccess() && (aRPDataInteraction = this.mARPDataInteraction) != null) {
            aRPDataInteraction.updateAlgoDataToNode(i, i2, bArr);
        }
    }

    public void updateNodeUniform(String str, HashMap<String, Object> hashMap) {
        AbstractARPEngine3D abstractARPEngine3D;
        if (!isEngineCanAccess() || isAppControllerInterrupt() || (abstractARPEngine3D = this.mARPEngine3D) == null) {
            return;
        }
        abstractARPEngine3D.updateNodeUniform(str, hashMap);
    }
}
