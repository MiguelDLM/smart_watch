package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;

/* loaded from: classes7.dex */
public class JNIOfflineDataControl {

    /* loaded from: classes7.dex */
    public static class LazyHolder {
        private static JNIOfflineDataControl sInstance = new JNIOfflineDataControl();

        private LazyHolder() {
        }
    }

    public static JNIOfflineDataControl getInstance() {
        return LazyHolder.sInstance;
    }

    public native boolean CopyProvinceMapData(int i);

    public native int DownLoadCityMapData(int i);

    public native boolean GetUpdatedInfo(int i, Bundle bundle);

    public native int cancelUpdateData(int i);

    public native boolean checkCitySpeakDataDownload(int i, int i2);

    public native boolean checkNewVer(Bundle bundle, int[] iArr);

    public native int checkVer(int[] iArr, int[] iArr2);

    public native int downLoadAppData();

    public native int downloadData(int i);

    public native int downloadDataRequest(int i);

    public native int getI18nItemTable(int i, Bundle[] bundleArr);

    public native int getItemTable(int i, Bundle[] bundleArr);

    public native int getProvinceMapFileId(int i, int[] iArr, int[] iArr2);

    public native int pauseAppDataDownLoad();

    public native boolean releaseGlobal();

    public native int removeAppData();

    public native int removeDownloadData(int i);

    public native boolean renameProvinceData(int i);

    public native int suspendDownloadData(int i);

    public native int updateData(int i);

    private JNIOfflineDataControl() {
        JNINaviManager.sInstance.initSubSystem(3);
    }
}
