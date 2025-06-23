package com.huawei.openalliance.ad.uriaction;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.jc;
import com.huawei.hms.ads.jn;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.ai;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.utils.SafeIntent;

/* loaded from: classes10.dex */
public class a extends p {
    private static final String Code = "AppAction";

    public a(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    private void Code(Intent intent) {
        if (intent == null) {
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        String I = com.huawei.openalliance.ad.inter.b.Code().I();
        fb.V(Code, "at is null ? " + TextUtils.isEmpty(I));
        if (TextUtils.isEmpty(I)) {
            return;
        }
        if (!V(safeIntent.getDataString())) {
            fb.V(Code, "isHwPPSUri false.");
        } else if (com.huawei.openalliance.ad.utils.g.Code(this.I)) {
            safeIntent.putExtra("accessToken", I);
        } else {
            fb.V(Code, "isHMSInstalled false.");
        }
    }

    private boolean V(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            if (TextUtils.equals("hwpps", parse.getScheme())) {
                return TextUtils.equals(x.cZ, host);
            }
            return false;
        } catch (Throwable th) {
            fb.I(Code, "isHwPPSUri exception." + th.getClass().getSimpleName());
            return false;
        }
    }

    private void Z() {
        String str;
        ApkInfo e;
        try {
            MetaData S = this.Z.S();
            jc.Code(this.I, this.Z, ai.D, (Integer) 1, Integer.valueOf((S == null || (e = S.e()) == null || com.huawei.openalliance.ad.utils.g.V(this.I, e.Code()) == null) ? 1 : 2));
        } catch (IllegalStateException unused) {
            str = "recordOpenFailEvent IllegalStateException";
            fb.I(Code, str);
        } catch (Exception e2) {
            str = "recordOpenFailEvent " + e2.getClass().getSimpleName();
            fb.I(Code, str);
        }
    }

    private void Code(Intent intent, String str) {
        if (intent == null || TextUtils.isEmpty(str) || str.indexOf("hwpps") <= 0) {
            return;
        }
        intent.addFlags(268435456);
    }

    private static void Code(final AppInfo appInfo) {
        if (appInfo == null) {
            fb.V(Code, "appInfo is empty.");
        } else {
            com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.openalliance.ad.uriaction.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a Code2 = com.huawei.openalliance.ad.download.a.Code();
                    if (Code2 != null) {
                        Code2.Code(AppInfo.this.Code());
                    }
                }
            });
            com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.openalliance.ad.uriaction.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.download.a Code2 = com.huawei.openalliance.ad.download.a.Code();
                    if (Code2 != null) {
                        Code2.Code(AppInfo.this);
                    }
                }
            });
        }
    }

    @Override // com.huawei.openalliance.ad.uriaction.p
    public boolean Code() {
        String str;
        AppInfo y;
        String m;
        Intent Code2;
        fb.V(Code, "handle app action");
        try {
            y = this.Z.y();
            String Code3 = y == null ? null : y.Code();
            m = this.Z.m();
            Code2 = com.huawei.openalliance.ad.utils.g.Code(this.I, m, Code3);
        } catch (ActivityNotFoundException unused) {
            str = "activity not exist";
            fb.I(Code, str);
            Z();
            return V();
        } catch (Exception unused2) {
            str = "handle intent url fail";
            fb.I(Code, str);
            Z();
            return V();
        }
        if (Code2 == null) {
            fb.I(Code, "cannot find target activity");
            Z();
            return V();
        }
        Code2.addFlags(268435456);
        Code(Code2, m);
        Code(Code2);
        jn.a aVar = new jn.a();
        aVar.Code(y).Code(this.Z).Code(Code2);
        com.huawei.openalliance.ad.utils.g.Code(this.I, Code2, aVar.Code());
        Code("app");
        Code(this.Z.y());
        jc.Code(this.I, this.Z, "intentSuccess", (Integer) 1, (Integer) null);
        return true;
    }
}
