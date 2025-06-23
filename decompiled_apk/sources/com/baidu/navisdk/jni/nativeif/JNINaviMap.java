package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import com.baidu.navisdk.module.init.a;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class JNINaviMap {
    private static final String TAG = "JNINaviMap";
    private long mAddrBaseMap;
    private long mAddrNaviMap;

    private native boolean nativeCheckCamera(long j);

    private native void nativeClearLayer(long j, int i);

    private native long nativeCreate(String str, long j, long j2);

    private native void nativeDestroy(long j);

    private native void nativeDraw(long j);

    private native void nativeFocusMGDataset(long j, int i, int i2, long[] jArr, int[] iArr);

    private native void nativeFocusMGDatasetBySid(long j, int i, int i2, String[] strArr);

    private native void nativeFullView(long j, boolean z);

    private native void nativeFullViewInLight(long j);

    private native void nativeGetMapStatus(long j, Bundle bundle, boolean z);

    private native boolean nativeIsLayerShow(long j, int i);

    private boolean nativeLoaded() {
        return a.a();
    }

    private native void nativeOnResize(long j, int i, int i2);

    private native void nativeSetAnimationEnabled(long j, boolean z);

    private native boolean nativeSetBrowse(long j, boolean z);

    private native boolean nativeSetDIYDataToMap(long j, int i, String str, String str2);

    private native boolean nativeSetHdDataToMap(long j, Bundle bundle);

    private native void nativeSetMGDataset(long j, int i, ArrayList<Bundle> arrayList);

    private native void nativeSetMapElementInfo(long j, int i, Bundle bundle);

    private native void nativeSetMapStatus(long j, Bundle bundle);

    private native void nativeSetNaviMode(long j, int i);

    private native boolean nativeSetNightMode(long j, boolean z);

    private native boolean nativeSetNormalHdDataToMap(long j, Bundle bundle);

    private native void nativeSetOverview(long j, boolean z);

    private native void nativeSetShowRect(long j, long j2, long j3, long j4, long j5);

    private native void nativeSetUIViewBound(long j, ArrayList<Bundle> arrayList, int i);

    private native void nativeShowLayer(long j, int i, boolean z);

    private native void nativeShowMGDataset(long j, int i, int i2, long[] jArr, int[] iArr);

    private native void nativeShowMGDatasetBySid(long j, int i, int i2, String[] strArr);

    private native void nativeUpdateLayer(long j, int i);

    private native void nativeZoomMGDataset(long j, int i, int i2, long[] jArr, int[] iArr, int i3, int i4);

    private native void nativeZoomMGDatasetBySid(long j, int i, int i2, String[] strArr, int[] iArr, int i3, int i4);

    public boolean checkCamera() {
        if (this.mAddrBaseMap != 0 && nativeLoaded()) {
            return nativeCheckCamera(this.mAddrBaseMap);
        }
        return false;
    }

    public void clearLayer(int i) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeClearLayer(this.mAddrNaviMap, i);
        }
    }

    public void create(String str, long j) {
        if (j == 0) {
            return;
        }
        this.mAddrBaseMap = j;
        this.mAddrNaviMap = nativeCreate(str, j, 0L);
    }

    public void destroy() {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeDestroy(this.mAddrNaviMap);
            this.mAddrNaviMap = 0L;
        }
    }

    public void draw() {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeDraw(this.mAddrNaviMap);
        }
    }

    public void focusMGDataset(int i, int i2, long[] jArr, int[] iArr) {
        if (this.mAddrNaviMap == 0 || !nativeLoaded()) {
            return;
        }
        nativeFocusMGDataset(this.mAddrNaviMap, i, i2, jArr, iArr);
    }

    public void focusMGDatasetBySid(int i, int i2, String[] strArr) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeFocusMGDatasetBySid(this.mAddrNaviMap, i, i2, strArr);
        }
    }

    public void fullView(boolean z) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeFullView(this.mAddrNaviMap, z);
        }
    }

    public void fullViewInLight() {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeFullViewInLight(this.mAddrNaviMap);
        }
    }

    public Bundle getMapStatus(boolean z) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            Bundle bundle = new Bundle();
            nativeGetMapStatus(this.mAddrNaviMap, bundle, z);
            return bundle;
        }
        return null;
    }

    public boolean isLayerShow(int i) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            return nativeIsLayerShow(this.mAddrNaviMap, i);
        }
        return false;
    }

    public native boolean nativeSetDynamicLayerShowKeys(long j, int[] iArr);

    public native boolean nativeSetLimitFrame(long j, int i);

    public void onResize(int i, int i2) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeOnResize(this.mAddrNaviMap, i, i2);
        }
    }

    public void setAnimationEnabled(boolean z) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeSetAnimationEnabled(this.mAddrNaviMap, z);
        }
    }

    public boolean setBrowse(boolean z) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            return nativeSetBrowse(this.mAddrNaviMap, z);
        }
        return false;
    }

    public boolean setDIYDataToMap(int i, String str, String str2) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            return nativeSetDIYDataToMap(this.mAddrNaviMap, i, str, str2);
        }
        return false;
    }

    public boolean setDynamicLayerShowKeys(int[] iArr) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            return nativeSetDynamicLayerShowKeys(this.mAddrNaviMap, iArr);
        }
        return false;
    }

    public boolean setHdDataToMap(Bundle bundle) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            return nativeSetHdDataToMap(this.mAddrNaviMap, bundle);
        }
        return false;
    }

    public boolean setLimitFrame(int i) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            return nativeSetLimitFrame(this.mAddrNaviMap, i);
        }
        return false;
    }

    public void setMGDataset(int i, ArrayList<Bundle> arrayList) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeSetMGDataset(this.mAddrNaviMap, i, arrayList);
        }
    }

    public void setMapElementInfo(int i, Bundle bundle) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeSetMapElementInfo(this.mAddrNaviMap, i, bundle);
        }
    }

    public void setMapStatus(Bundle bundle) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeSetMapStatus(this.mAddrNaviMap, bundle);
        }
    }

    public void setNaviMode(int i) {
        if (this.mAddrNaviMap != 0 || !nativeLoaded()) {
            nativeSetNaviMode(this.mAddrNaviMap, i);
        }
    }

    public boolean setNightMode(boolean z) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            return nativeSetNightMode(this.mAddrNaviMap, z);
        }
        return false;
    }

    public boolean setNormalHdDataToMap(Bundle bundle) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(TAG, "setNormalHdDataToMap: " + bundle);
            }
            return nativeSetNormalHdDataToMap(this.mAddrNaviMap, bundle);
        }
        return false;
    }

    public void setOverview(boolean z) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeSetOverview(this.mAddrNaviMap, z);
        }
    }

    public void setShowRect(long j, long j2, long j3, long j4) {
        g gVar = g.MAP;
        if (gVar.d()) {
            gVar.e(TAG, "setShowRect --> left = " + j + ", top = " + j2 + ", right = " + j3 + ", bottom = " + j4);
        }
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeSetShowRect(this.mAddrNaviMap, j, j2, j3, j4);
        }
    }

    public void setUIViewBound(ArrayList<Bundle> arrayList, int i) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeSetUIViewBound(this.mAddrNaviMap, arrayList, i);
        }
    }

    public void showLayer(int i, boolean z) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeShowLayer(this.mAddrNaviMap, i, z);
        }
    }

    public void showMGDataset(int i, int i2, long[] jArr) {
        showMGDataset(i, i2, jArr, null);
    }

    public void showMGDatasetBySid(int i, int i2, String[] strArr) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeShowMGDatasetBySid(this.mAddrNaviMap, i, i2, strArr);
        }
    }

    public void updateLayer(int i) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeUpdateLayer(this.mAddrNaviMap, i);
        }
    }

    public void zoomMGDataset(int i, int i2, long[] jArr, int[] iArr, int i3, int i4) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeZoomMGDataset(this.mAddrNaviMap, i, i2, jArr, iArr, i3, i4);
        }
    }

    public void zoomMGDatasetBySid(int i, int i2, String[] strArr, int[] iArr, int i3, int i4) {
        if (this.mAddrNaviMap != 0 && nativeLoaded()) {
            nativeZoomMGDatasetBySid(this.mAddrNaviMap, i, i2, strArr, iArr, i3, i4);
        }
    }

    public void showMGDataset(int i, int i2, long[] jArr, int[] iArr) {
        if (this.mAddrNaviMap == 0 || !nativeLoaded()) {
            return;
        }
        nativeShowMGDataset(this.mAddrNaviMap, i, i2, jArr, iArr);
    }

    public void focusMGDataset(int i, int i2, long[] jArr) {
        focusMGDataset(i, i2, jArr, null);
    }
}
