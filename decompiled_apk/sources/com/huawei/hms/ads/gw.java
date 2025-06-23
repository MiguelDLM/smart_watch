package com.huawei.hms.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class gw {
    public static final String B = "com.iab.omid.library.huawei.adsession.media.InteractionType";
    public static final String C = "com.iab.omid.library.huawei.adsession.media.MediaEvents";
    public static final String Code = "1";
    public static final String D = "com.iab.omid.library.huawei.adsession.media.VastProperties";
    public static final String F = "com.iab.omid.library.huawei.adsession.media.Position";
    public static final String I = "com.iab.omid.library.huawei.adsession.media";
    public static final String L = "com.iab.omid.library.huawei.adsession.media.InteractionType";
    public static final String S = "com.iab.omid.library.huawei.adsession.media.PlayerState";
    public static final String V = "com.iab.omid.library.huawei.adsession";
    public static final String Z = "com.iab.omid.library.huawei.adsession.video";

    /* renamed from: a, reason: collision with root package name */
    public static final String f17291a = "com.iab.omid.library.huawei.adsession.media.MediaEvents";
    public static final String b = "com.iab.omid.library.huawei.adsession.media.PlayerState";
    public static final String c = "com.iab.omid.library.huawei.adsession.media.Position";
    public static final String d = "com.iab.omid.library.huawei.adsession.media.VastProperties";
    public static final String e = "com.iab.omid.library.huawei.adsession.AdEvents";
    public static final String f = "com.iab.omid.library.huawei.adsession.AdSession";
    public static final String g = "com.iab.omid.library.huawei.adsession.AdSessionConfiguration";
    public static final String h = "com.iab.omid.library.huawei.publisher.AdSessionStatePublisher";
    public static final String i = "com.iab.omid.library.huawei.adsession.AdSessionContext";
    public static final String j = "com.iab.omid.library.huawei.adsession.AdSessionContextType";
    public static final String k = "com.iab.omid.library.huawei.adsession.CreativeType";
    public static final String l = "com.iab.omid.library.huawei.adsession.ErrorType";
    public static final String m = "com.iab.omid.library.huawei.adsession.FriendlyObstructionPurpose";
    public static final String n = "com.iab.omid.library.huawei.adsession.ImpressionType";
    public static final String o = "com.iab.omid.library.huawei.adsession.Owner";
    public static final String p = "com.iab.omid.library.huawei.adsession.Partner";
    public static final String q = "com.iab.omid.library.huawei.adsession.VerificationScriptResource";
    private static final String r = "OMSDKCheckUtil";

    public static boolean Code(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean Code(Context context, List<String> list) {
        PackageManager packageManager = context.getPackageManager();
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                packageManager.getPackageInfo(it.next(), 1);
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean Code(String str) {
        try {
            Class.forName(str);
            fb.V(r, str);
            return true;
        } catch (ClassNotFoundException unused) {
            fb.V(r, str + " is not avaliable");
            return false;
        }
    }

    public static boolean Code(List<String> list) {
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                Class.forName(it.next());
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
