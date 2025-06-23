package com.baidu.navisdk.jni.nativeif;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.trajectory.MileageInfo;
import com.baidu.navisdk.comapi.trajectory.NaviTrajectory;
import com.baidu.navisdk.comapi.trajectory.NaviTrajectoryGPSData;
import com.baidu.navisdk.comapi.trajectory.NaviTrajectoryStatusInfo;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.UUID;

/* loaded from: classes7.dex */
public class JNITrajectoryControl {
    public static final int TRAJECTORY_FAILED = -1;
    public static final int TRAJECTORY_SUCCESS = 0;
    public static JNITrajectoryControl sInstance = new JNITrajectoryControl();
    private String mCarNaviUUID;
    private String mUUID;

    private JNITrajectoryControl() {
    }

    public native int GetTrajectoryGPSListDirect(String str, ArrayList<NaviTrajectoryGPSData> arrayList);

    public native int cancelSync();

    public native boolean carNaviTrajectorySendPostRecord(String str, String str2, String str3, String str4);

    public native void checkNaviDistForBusiness(String str, Bundle bundle);

    public native int delete(String str);

    public native int endRecord(String str, String str2, boolean z, Bundle bundle);

    public native int endRecordCarNavi(String str, String str2, boolean z, Bundle bundle);

    public native String eventIdEncode(long j);

    public String getCurrentCarNaviUUID() {
        return this.mCarNaviUUID;
    }

    public String getCurrentGuid() {
        return this.mUUID;
    }

    public String getCurrentUUID() {
        return this.mUUID;
    }

    public native int getGpsListBound(String str, Rect rect);

    public native int getLastSyncTime(String str, Bundle bundle);

    public String getLastSyncTime(String str) {
        Bundle bundle = new Bundle();
        return getLastSyncTime(str, bundle) != 0 ? "" : bundle.getString("count");
    }

    public native int getMileageDataById(String str, MileageInfo mileageInfo);

    public native int getNotSyncMileageByUser(String str, String str2, ArrayList<Bundle> arrayList);

    public native void getPostParams(int i, String str, Bundle bundle);

    public native void getPostParamsForBdussUpdated(Bundle bundle, String str);

    public native int getPostParamsForNavingUpload(String str, Bundle bundle);

    public native boolean getTrackPostResultData(Bundle bundle);

    public native String getTrajecotryFilePath(String str);

    public native int getTrajectoryById(String str, NaviTrajectory naviTrajectory);

    public native int getTrajectoryCnt(String str, String str2);

    public native long getTrajectoryLength(String str);

    public native int getTrajectoryList(String str, String str2, ArrayList<NaviTrajectory> arrayList);

    public native int getTrajectoryStatusById(String str, NaviTrajectoryStatusInfo naviTrajectoryStatusInfo);

    public native int getUnSyncTrajectoryCnt(String str, String str2);

    public native String getUrlParamsSign(String str);

    public native String getUrlParamsSignRp(String str);

    public native int logoutCleanUp();

    public native int patchDelete(ArrayList<String> arrayList);

    public native int recording(double d, double d2, float f, float f2, float f3, long j, int i, int i2, String str);

    public native int recordingCarNavi(double d, double d2, float f, float f2, float f3, long j, int i);

    public native int rename(String str, String str2);

    public int startRecord(String str, String str2, int i, boolean z) {
        return startRecord(str, str2, i, z, "");
    }

    public native int startRecord(String str, String str2, String str3, int i, boolean z, String str4);

    public int startRecordCarNavi(String str, String str2, int i, boolean z) {
        TextUtils.isEmpty(str);
        String uuid = UUID.randomUUID().toString();
        this.mCarNaviUUID = uuid;
        try {
            return startRecordCarNavi(str, uuid, str2, i, z);
        } catch (Exception unused) {
            return -1;
        }
    }

    public native int startRecordCarNavi(String str, String str2, String str3, int i, boolean z);

    public native int startSync(String str, String str2);

    public native boolean trajectoryVdrRecodingWithJson(String str);

    public native int updateEndName(String str, String str2);

    public native int updateStartName(String str, String str2);

    public native void updateUserInfo(String str, String str2, int i);

    public int startRecord(String str, String str2, int i, boolean z, String str3) {
        TextUtils.isEmpty(str);
        this.mUUID = UUID.randomUUID().toString();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("startRecord", "UUID.randomUUID():" + this.mUUID);
        }
        try {
            return startRecord(str, this.mUUID, str2, i, z, str3);
        } catch (Throwable unused) {
            return -1;
        }
    }
}
