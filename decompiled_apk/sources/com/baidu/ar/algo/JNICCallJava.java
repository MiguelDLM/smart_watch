package com.baidu.ar.algo;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.kg;
import com.baidu.ar.u;
import com.baidu.ar.v;
import com.baidu.ar.w;
import com.baidu.ar.z;

/* loaded from: classes7.dex */
public class JNICCallJava {
    private static u sIAlgoTransmitProtobufCallBack;
    private static v sIGravityOperation;
    private static w sITransModelPointCallback;
    private static String sUserID;
    private static z sVPASParamsTransCallback;

    public static float[] getGPS() {
        return sVPASParamsTransCallback.az() == null ? new float[]{0.0f, 0.0f} : new float[]{(float) sVPASParamsTransCallback.az()[0], (float) sVPASParamsTransCallback.az()[1], 0.0f};
    }

    public static float[] getGravityDirection() {
        v vVar = sIGravityOperation;
        return vVar != null ? vVar.av() : new float[]{0.0f, 0.0f, 0.0f};
    }

    public static String getPhoneType() {
        return "Android_" + Build.MODEL;
    }

    public static String getSessionId() {
        return sVPASParamsTransCallback.ay() != null ? sVPASParamsTransCallback.ay() : "";
    }

    public static String getUserID() {
        return TextUtils.isEmpty(sUserID) ? "" : sUserID;
    }

    public static String getVersion() {
        return kg.getVersionName();
    }

    public static void removeAllCallback() {
        sITransModelPointCallback = null;
        sIGravityOperation = null;
        sIAlgoTransmitProtobufCallBack = null;
        sUserID = null;
    }

    public static void setAlgoGeneraProtobufCallBack(u uVar) {
        sIAlgoTransmitProtobufCallBack = uVar;
    }

    public static void setGravityCallBack(v vVar) {
        sIGravityOperation = vVar;
    }

    public static int setProtobufBufStrs(byte[] bArr) {
        u uVar = sIAlgoTransmitProtobufCallBack;
        if (uVar == null) {
            return 0;
        }
        uVar.a(bArr);
        return 0;
    }

    public static void setUserID(String str) {
        sUserID = str;
    }

    public static void setVPASsParamsTransCallback(z zVar) {
        sVPASParamsTransCallback = zVar;
    }

    public static void setsITransModelPointCallback(w wVar) {
        sITransModelPointCallback = wVar;
    }

    public static int transModelPointsData(float[] fArr) {
        w wVar = sITransModelPointCallback;
        if (wVar != null) {
            wVar.a(0, fArr);
        }
        return 0;
    }

    public static void transSessionState(int i, String str) {
        w wVar = sITransModelPointCallback;
        if (wVar == null || i != 1015) {
            return;
        }
        wVar.a(2, Integer.valueOf(i));
    }

    public static void transTrackerState(int i) {
        w wVar = sITransModelPointCallback;
        if (wVar != null) {
            wVar.a(1, Integer.valueOf(i));
        }
    }
}
