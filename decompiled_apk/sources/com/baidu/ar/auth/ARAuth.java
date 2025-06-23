package com.baidu.ar.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.ar.bu;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.kl;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class ARAuth {
    private static kl<bu> kY = new kl<>("com.baidu.ar.auth.ARAuthFacade");

    public static List<Integer> checkAuth(Context context, byte[] bArr, IDuMixAuthCallback iDuMixAuthCallback) {
        bu hh = kY.hh();
        return hh != null ? hh.checkAuth(context, bArr, iDuMixAuthCallback) : new ArrayList();
    }

    public static boolean checkFeatureAuth(int i) {
        bu hh = kY.hh();
        if (hh != null) {
            return hh.checkFeatureAuth(i);
        }
        return true;
    }

    public static boolean checkOfflineLicenseAuth(Context context, byte[] bArr) {
        bu hh = kY.hh();
        if (hh != null) {
            return hh.checkOfflineLicenseAuth(context, bArr);
        }
        return true;
    }

    public static Bitmap createTipBitmap(Context context) {
        bu hh = kY.hh();
        if (hh != null) {
            return hh.createTipBitmap(context);
        }
        return null;
    }

    public static void doAuth(Context context, IAuthCallback iAuthCallback) {
        AuthJni.init();
        bu hh = kY.hh();
        if (hh != null) {
            hh.doAuth(context, iAuthCallback);
        }
    }

    public static boolean enableFeature(int i) {
        bu hh = kY.hh();
        if (hh != null) {
            return hh.enableFeature(i);
        }
        return true;
    }

    public static boolean isShowAuthTip() {
        bu hh = kY.hh();
        if (hh != null) {
            return hh.isShowAuthTip();
        }
        return true;
    }

    public static void loadAuthInfo(Context context) {
        bu hh = kY.hh();
        if (hh != null) {
            hh.loadAuthInfo(context);
        }
    }

    public static void loadWhiteAuthInfo(Context context) {
        bu hh = kY.hh();
        if (hh != null) {
            hh.loadWhiteAuthInfo(context);
        }
    }

    public static void n(int i) {
        bu hh = kY.hh();
        if (hh != null) {
            hh.n(i);
        }
    }

    public static void release() {
        bu hi = kY.hi();
        if (hi != null) {
            hi.release();
        }
        kY.release();
        AuthJni.release();
    }

    public static void setAuthLicense(byte[] bArr, String str, String str2, String str3) {
        bu hh = kY.hh();
        if (hh != null) {
            hh.setAuthLicense(bArr, str, str2, str3);
        }
    }

    public static List<Integer> checkAuth(Context context, byte[] bArr, ICallbackWith<List<Integer>> iCallbackWith, ICallbackWith<Integer> iCallbackWith2) {
        bu hh = kY.hh();
        return hh != null ? hh.checkAuth(context, bArr, iCallbackWith, iCallbackWith2) : new ArrayList();
    }
}
