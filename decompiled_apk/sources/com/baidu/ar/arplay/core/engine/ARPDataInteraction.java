package com.baidu.ar.arplay.core.engine;

import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.ar.ab;
import com.baidu.ar.arplay.core.engine.ARPContent;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class ARPDataInteraction implements ARPContent.a {
    private ab mDataStore;
    private a mHtmlCallback;
    private b mInteraction = null;
    boolean mIsCaseCreated = false;
    public ByteBuffer mMaskBuffer;
    private c mVideoCallback;

    /* loaded from: classes7.dex */
    public interface a {
        boolean e(int i, int i2);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(float f, float f2, float f3);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(String str, int i, String str2, String str3);
    }

    private static void updateVideoFrame(Object obj, String str, int i, String str2, String str3) {
        ARPDataInteraction aRPDataInteraction = (ARPDataInteraction) ((WeakReference) obj).get();
        if (aRPDataInteraction == null) {
            return;
        }
        aRPDataInteraction.updateVideoFrame(str, i, str2, str3);
    }

    public void addAlgoType(int[] iArr, int i) {
        nativeAddAlgoType(iArr, i);
    }

    public void clearARMemory() {
        ab abVar = this.mDataStore;
        if (abVar != null) {
            abVar.clearARMemory();
        }
    }

    public void clearAlgoCache() {
        nativeClearAlgoCache();
    }

    public void destroy() {
        nativeRelease();
    }

    public void destroyMockAlgoHandle(long j) {
        nativeDestoryMockFaceAlgoHandle(j);
    }

    public String getValue(int i, String str) {
        ab abVar = this.mDataStore;
        if (abVar != null) {
            return abVar.getValue(i, str);
        }
        Log.e("ARPDataInteraction", "get value error!");
        return "";
    }

    public void initDataStore(SharedPreferences sharedPreferences) {
        if (this.mDataStore == null) {
            ab abVar = new ab();
            this.mDataStore = abVar;
            abVar.a(sharedPreferences);
        }
    }

    public long mockFaceAlgoHandle(long j, float[] fArr) {
        return nativeMockFaceAlgoHandle(j, fArr);
    }

    public native void nativeAddAlgoType(int[] iArr, int i);

    public native void nativeClearAlgoCache();

    public native void nativeDestoryMockFaceAlgoHandle(long j);

    public native long nativeMockFaceAlgoHandle(long j, float[] fArr);

    public native void nativeRelease();

    public native void nativeRemoveAlgoType(int[] iArr);

    public native void nativeSetAlgoDataHandle(long j);

    public native void nativeSetAlgoHandle(long j);

    public native void nativeSetFaceLandMark(long j, int i);

    public native void nativeSetFaceLandMarkFrameAcheMode(int i);

    public native void nativeSetup(Object obj);

    public native void nativeUpdateAlgoDataToNode(int i, int i2, ByteBuffer byteBuffer);

    @Override // com.baidu.ar.arplay.core.engine.ARPContent.a
    public void onCaseLoaded(boolean z) {
        this.mIsCaseCreated = z;
    }

    public void onGestureUpdate(int i, long j, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, float f8, int i4, float f9) {
        onGestureUpdateNative(i, j, i2, f, f2, f3, f4, i3, f5, f6, f7, f8, i4, f9, false);
    }

    public native void onGestureUpdateNative(int i, long j, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, float f8, int i4, float f9, boolean z);

    public void onGestureUpdateWithScaleFinish(int i, long j, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, float f8, int i4, float f9, boolean z) {
        onGestureUpdateNative(i, j, i2, f, f2, f3, f4, i3, f5, f6, f7, f8, i4, f9, z);
    }

    public void onInteractionFinish(float f, float f2, float f3) {
        b bVar = this.mInteraction;
        if (bVar != null) {
            bVar.a(f, f2, f3);
        }
    }

    public void onTouchUpdate(int i, float f, float f2, float f3, float f4, long j, int i2, float f5) {
        onTouchUpdateNative(i, f, f2, f3, f4, j, i2, f5);
    }

    public native void onTouchUpdateNative(int i, float f, float f2, float f3, float f4, long j, int i2, float f5);

    public void removeAlgoType(int[] iArr) {
        nativeRemoveAlgoType(iArr);
    }

    public synchronized void setAlgoDataHandle(long j) {
        nativeSetAlgoHandle(j);
    }

    public void setFaceLandMarkFrameAcheMode(int i) {
        nativeSetFaceLandMarkFrameAcheMode(i);
    }

    public synchronized void setHtmlUpdateCallback(a aVar) {
        this.mHtmlCallback = aVar;
    }

    public void setInteraction(b bVar) {
        this.mInteraction = bVar;
    }

    public void setValue(int i, String str, String str2) {
        ab abVar = this.mDataStore;
        if (abVar != null) {
            abVar.setValue(i, str, str2);
        } else {
            Log.e("ARPDataInteraction", "set value error!");
        }
    }

    public synchronized void setVideoUpdateCallback(c cVar) {
        this.mVideoCallback = cVar;
    }

    public void setup() {
        nativeSetup(new WeakReference(this));
    }

    public void updateAlgoDataToNode(int i, int i2, byte[] bArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        this.mMaskBuffer = allocateDirect;
        allocateDirect.put(bArr);
        nativeUpdateAlgoDataToNode(i, i2, this.mMaskBuffer);
    }

    public boolean updateWebViewFrame(int i, int i2) {
        a aVar = this.mHtmlCallback;
        if (aVar == null || !this.mIsCaseCreated) {
            return false;
        }
        return aVar.e(i, i2);
    }

    private static String getValue(Object obj, int i, String str) {
        ARPDataInteraction aRPDataInteraction = (ARPDataInteraction) ((WeakReference) obj).get();
        return aRPDataInteraction == null ? "" : aRPDataInteraction.getValue(i, str);
    }

    public static void onInteractionFinish(Object obj, float f, float f2, float f3) {
        ARPDataInteraction aRPDataInteraction = (ARPDataInteraction) ((WeakReference) obj).get();
        if (aRPDataInteraction == null) {
            return;
        }
        aRPDataInteraction.onInteractionFinish(f, f2, f3);
    }

    private static void setValue(Object obj, int i, String str, String str2) {
        ARPDataInteraction aRPDataInteraction = (ARPDataInteraction) ((WeakReference) obj).get();
        if (aRPDataInteraction == null) {
            return;
        }
        aRPDataInteraction.setValue(i, str, str2);
    }

    public static boolean updateWebViewFrame(Object obj, int i, int i2) {
        ARPDataInteraction aRPDataInteraction = (ARPDataInteraction) ((WeakReference) obj).get();
        if (aRPDataInteraction == null) {
            return false;
        }
        return aRPDataInteraction.updateWebViewFrame(i, i2);
    }

    public void updateVideoFrame(String str, int i, String str2, String str3) {
        c cVar = this.mVideoCallback;
        if (cVar == null || !this.mIsCaseCreated) {
            return;
        }
        cVar.a(str, i, str2, str3);
    }
}
