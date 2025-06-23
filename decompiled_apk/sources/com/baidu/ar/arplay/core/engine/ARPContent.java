package com.baidu.ar.arplay.core.engine;

import com.baidu.ar.aa;
import com.baidu.ar.ae;
import com.baidu.ar.ar;
import com.baidu.ar.as;
import com.baidu.ar.aw;
import com.baidu.ar.camera.CameraManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class ARPContent {
    private c mCaseState = c.EUninit;
    private volatile boolean mIsEngineCreated = false;
    private volatile boolean mIsTempleteCreating = false;
    private volatile boolean mIsTempleteCreated = false;
    private volatile boolean mIsTempleteDestoring = true;
    private volatile boolean mIsTempleteDestoryed = false;
    private long mStartTime = 0;
    private boolean mIsFrontCamera = true;
    private int mPreviewWidth = 0;
    private int mPreviewHeight = 0;
    private int mWindowWidth = CameraManager.DEFAULTHEIGHT;
    private int mWindowHeight = 1280;
    private List<a> mCaseLoadListenerList = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ar.arplay.core.engine.ARPContent$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] gv;

        static {
            int[] iArr = new int[b.values().length];
            gv = iArr;
            try {
                iArr[b.LoadCase.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                gv[b.UnloadCase.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                gv[b.OnCaseLoaded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                gv[b.OnCaseUnloaded.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface a {
        void onCaseLoaded(boolean z);
    }

    /* loaded from: classes7.dex */
    public enum b {
        LoadCase,
        UnloadCase,
        OnCaseLoaded,
        OnCaseUnloaded
    }

    /* loaded from: classes7.dex */
    public enum c {
        EUninit,
        ECreating,
        ECreated,
        EDestroying
    }

    private void releaseComponents() {
        aa.aA().aB();
        ae.aK().release();
        aw.bi().release();
        ARPScriptEnvironment.getInstance().release();
    }

    public boolean checkValid(b bVar) {
        c cVar;
        int i = AnonymousClass1.gv[bVar.ordinal()];
        if (i != 2) {
            if (i == 3 && (!this.mIsEngineCreated || this.mCaseState != c.ECreating)) {
                return false;
            }
        } else if (!this.mIsEngineCreated || (cVar = this.mCaseState) == c.EDestroying || cVar == c.EUninit) {
            return false;
        }
        return true;
    }

    public void clearAllCaseLoadListener() {
        this.mCaseLoadListenerList.clear();
    }

    public void destroy() {
        this.mCaseState = c.EUninit;
        notifyCaseLoadListener();
        clearAllCaseLoadListener();
        this.mIsEngineCreated = false;
        this.mIsTempleteCreating = false;
        this.mIsTempleteCreated = false;
        this.mIsTempleteDestoring = false;
        this.mIsTempleteDestoryed = false;
        releaseComponents();
    }

    public float[] getPreviewSize() {
        return new float[]{this.mPreviewWidth, this.mPreviewHeight};
    }

    public float[] getWindowSize() {
        return new float[]{this.mWindowWidth, this.mWindowHeight};
    }

    public boolean isCaseCreated() {
        return this.mCaseState == c.ECreated;
    }

    public boolean isEngineCanAccess() {
        return this.mIsEngineCreated && this.mCaseState == c.ECreated;
    }

    public int loadCaseWithResPath(String str, int i, int i2) {
        int i3;
        if (!this.mIsEngineCreated) {
            return -1;
        }
        c cVar = this.mCaseState;
        c cVar2 = c.ECreating;
        if (cVar == cVar2) {
            return -1;
        }
        this.mCaseState = cVar2;
        notifyCaseLoadListener();
        ARPScriptEnvironment.getInstance().setDataPipKV(ARPScriptEnvironment.KEY_DATA_CAMERA_POSITION, Integer.valueOf(this.mIsFrontCamera ? 1 : 0));
        this.mStartTime = System.currentTimeMillis();
        int i4 = this.mPreviewWidth;
        if (i4 > 0) {
            i = i4;
        }
        this.mPreviewWidth = i;
        int i5 = this.mPreviewHeight;
        if (i5 > 0) {
            i2 = i5;
        }
        this.mPreviewHeight = i2;
        int i6 = this.mWindowWidth;
        if (i6 > 0 && (i3 = this.mWindowHeight) > 0) {
            nativeSetWindowSize(i6, i3);
        }
        nativeLoadCase(str, this.mPreviewWidth, this.mPreviewHeight);
        return 0;
    }

    public native void nativeLoadCase(String str, int i, int i2);

    public native void nativeSetPreviewSize(int i, int i2);

    public native void nativeSetWindowSize(int i, int i2);

    public native void nativeUnloadCase();

    public void notifyCaseLoadListener() {
        for (int i = 0; i < this.mCaseLoadListenerList.size(); i++) {
            this.mCaseLoadListenerList.get(i).onCaseLoaded(isCaseCreated());
        }
    }

    public void onCaseLoadCompleted(Map map) {
        if (this.mIsEngineCreated && this.mCaseState == c.ECreating && map != null) {
            int a2 = as.a(map.get("case_id"), 0);
            ar.b("ARPEngine", "caseId : " + a2);
            ar.b("ARPEngine", "caseId : " + a2 + " cost: " + (System.currentTimeMillis() - this.mStartTime));
            this.mCaseState = c.ECreated;
            notifyCaseLoadListener();
        }
    }

    public void onCaseUnloadCompleted() {
        if (this.mIsEngineCreated && this.mCaseState == c.EDestroying) {
            this.mCaseState = c.EUninit;
        }
    }

    public void registerCaseLoadListener(a aVar) {
        this.mCaseLoadListenerList.add(aVar);
    }

    public void setEngineCreated(boolean z) {
        this.mIsEngineCreated = z;
    }

    public void setIsFrontCamera(boolean z) {
        this.mIsFrontCamera = z;
    }

    public void setPreviewSize(int i, int i2) {
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
        if (isEngineCanAccess()) {
            nativeSetPreviewSize(i, i2);
        }
    }

    public void setWindowSize(int i, int i2) {
        this.mWindowWidth = i;
        this.mWindowHeight = i2;
        if (isEngineCanAccess()) {
            nativeSetWindowSize(i, i2);
        }
    }

    public void unloadCase() {
        c cVar;
        c cVar2;
        if (!this.mIsEngineCreated || (cVar = this.mCaseState) == (cVar2 = c.EDestroying) || cVar == c.EUninit) {
            return;
        }
        ar.b("ARPEngine", "unloadCase");
        this.mCaseState = cVar2;
        notifyCaseLoadListener();
        this.mPreviewWidth = 0;
        this.mPreviewHeight = 0;
        nativeUnloadCase();
        releaseComponents();
        ar.b("ARPEngine", "unloadCase finished");
    }

    public void unregisterCaseLoadListener(a aVar) {
        this.mCaseLoadListenerList.remove(aVar);
    }
}
