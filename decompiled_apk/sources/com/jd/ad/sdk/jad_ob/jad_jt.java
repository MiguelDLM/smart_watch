package com.jd.ad.sdk.jad_ob;

import android.annotation.SuppressLint;
import android.content.Context;
import com.jd.ad.sdk.dl.baseinfo.JADLocation;
import com.jd.ad.sdk.jad_ob.jad_dq;
import com.jd.ad.sdk.jad_ob.jad_er;

/* loaded from: classes10.dex */
public class jad_jt {
    @SuppressLint({"MissingPermission"})
    public static int jad_an(Context context) {
        try {
            if (!jad_dq.jad_an.jad_an.jad_an("connectionType")) {
                return -1;
            }
            return com.jd.ad.sdk.jad_do.jad_jt.jad_an(context);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static double[] jad_bo(Context context) {
        double[] dArr = jad_bo.jad_bo;
        try {
            jad_dq jad_dqVar = jad_dq.jad_an.jad_an;
            if (!jad_dqVar.jad_fs) {
                JADLocation jADLocation = jad_dqVar.jad_dq;
                if (jADLocation != null) {
                    return jADLocation.toDoubleArray();
                }
                return dArr;
            }
            if (!jad_dqVar.jad_an("geo")) {
                return dArr;
            }
            return jad_er.jad_an.jad_an.jad_an(context);
        } catch (Exception unused) {
            return dArr;
        }
    }
}
