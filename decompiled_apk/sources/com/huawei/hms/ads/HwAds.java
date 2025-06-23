package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.annotation.GlobalApi;

@GlobalApi
/* loaded from: classes10.dex */
public class HwAds {
    private HwAds() {
    }

    @GlobalApi
    public static int getAppActivateStyle() {
        return k.Code().C();
    }

    @GlobalApi
    public static RequestOptions getRequestOptions() {
        return k.Code().I();
    }

    @GlobalApi
    public static String getSDKVersion() {
        return k.Code().V();
    }

    @GlobalApi
    public static void init(Context context) {
        init(context, null);
    }

    @GlobalApi
    public static boolean isAppInstalledNotify() {
        return k.Code().B();
    }

    @GlobalApi
    public static void setAppActivateStyle(int i) {
        k.Code().V(i);
    }

    @GlobalApi
    public static void setAppInstalledNotify(boolean z) {
        k.Code().V(z);
    }

    @GlobalApi
    public static void setBrand(int i) {
        k.Code().Code(i);
    }

    @GlobalApi
    public static void setConsent(String str) {
        k.Code().Code(str);
    }

    @GlobalApi
    public static void setInfoController(InformationController informationController) {
        k.Code().Code(informationController);
    }

    @GlobalApi
    public static void setRequestOptions(RequestOptions requestOptions) {
        k.Code().Code(requestOptions);
    }

    @GlobalApi
    public static void setVideoMuted(boolean z) {
        k.Code().Code(z);
    }

    @GlobalApi
    public static void setVideoVolume(float f) {
        k.Code().Code(f);
    }

    @GlobalApi
    public static void init(Context context, String str) {
        k.Code().Code(context, str);
    }
}
