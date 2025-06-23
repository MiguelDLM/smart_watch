package com.baidu.ar.marker;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes7.dex */
public class JniTransDataCalback {
    private static String sDefaultStr = "empty";
    private static IMarkerDataProvider sMarkerDataProvider;
    private static String sResponseSession;

    public static float[] getGPS() {
        return new float[]{10.0f, 10.0f, 10.0f};
    }

    public static float[] getGravityDirection() {
        return new float[]{10.0f, 10.0f, 10.0f};
    }

    public static String getPhoneType() {
        return "Android_" + Build.MODEL;
    }

    public static String getSessionId() {
        if (!TextUtils.isEmpty(sResponseSession)) {
            return sResponseSession;
        }
        IMarkerDataProvider iMarkerDataProvider = sMarkerDataProvider;
        return iMarkerDataProvider != null ? iMarkerDataProvider.getSessionId() : sDefaultStr;
    }

    public static String getUserID() {
        IMarkerDataProvider iMarkerDataProvider = sMarkerDataProvider;
        return iMarkerDataProvider != null ? iMarkerDataProvider.getUserId() : sDefaultStr;
    }

    public static String getVersion() {
        IMarkerDataProvider iMarkerDataProvider = sMarkerDataProvider;
        return iMarkerDataProvider != null ? iMarkerDataProvider.getVersion() : sDefaultStr;
    }

    public static void setLocationData(boolean z, Object obj) {
        IMarkerDataProvider iMarkerDataProvider = sMarkerDataProvider;
        if (iMarkerDataProvider != null) {
            iMarkerDataProvider.setLocationData(z, obj);
        }
    }

    public static void setLocationTransForms(float[] fArr) {
        IMarkerDataProvider iMarkerDataProvider = sMarkerDataProvider;
        if (iMarkerDataProvider != null) {
            iMarkerDataProvider.setLocationTransforms(fArr);
        }
    }

    public static void setMarkerDataProvider(IMarkerDataProvider iMarkerDataProvider) {
        sMarkerDataProvider = iMarkerDataProvider;
    }

    public static int setProtobufBufStrs(byte[] bArr) {
        IMarkerDataProvider iMarkerDataProvider = sMarkerDataProvider;
        if (iMarkerDataProvider == null) {
            return 0;
        }
        iMarkerDataProvider.transDataFromJNI(bArr);
        return 1;
    }

    public static void setQueryFrameResult(int i, String str) {
        IMarkerDataProvider iMarkerDataProvider = sMarkerDataProvider;
        if (iMarkerDataProvider != null) {
            iMarkerDataProvider.queryFrameResult(i, str);
        }
    }

    public static void setVpsLocation(float f, float f2) {
        IMarkerDataProvider iMarkerDataProvider = sMarkerDataProvider;
        if (iMarkerDataProvider != null) {
            iMarkerDataProvider.setVpsLocation(f, f2);
        }
    }

    public static void updateGravityDirection(float[] fArr) {
    }

    public static void updateSession(String str) {
        sResponseSession = str;
    }
}
