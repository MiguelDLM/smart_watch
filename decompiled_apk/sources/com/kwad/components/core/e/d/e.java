package com.kwad.components.core.e.d;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.commercial.smallApp.JumpFrom;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class e {
    private static boolean LK = false;

    public static boolean E(AdInfo adInfo) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo;
        if (adInfo != null && (smallAppJumpInfo = adInfo.adConversionInfo.smallAppJumpInfo) != null && !TextUtils.isEmpty(smallAppJumpInfo.mediaSmallAppId) && !TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.originId) && !TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.smallAppJumpUrl)) {
            return true;
        }
        return false;
    }

    public static int a(Context context, AdInfo.SmallAppJumpInfo smallAppJumpInfo, JumpFrom jumpFrom, AdTemplate adTemplate) {
        Throwable th;
        Cursor cursor;
        if (!com.kwad.sdk.core.response.b.a.a(smallAppJumpInfo)) {
            com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo, "smallAppJumpInfo is invalid");
            com.kwad.sdk.core.adlog.c.j(adTemplate, 1);
            return 0;
        }
        try {
            com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo);
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(268435456);
            intent.setComponent(launchIntentForPackage.getComponent());
            context.startActivity(intent);
            cursor = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, "0", ""}, null);
            if (cursor != null) {
                try {
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        com.kwad.sdk.commercial.smallApp.a.a(adTemplate, jumpFrom, smallAppJumpInfo, bo.t(th));
                        com.kwad.sdk.core.adlog.c.j(adTemplate, 2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return -1;
                    } finally {
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    }
                }
            }
            com.kwad.sdk.commercial.smallApp.a.b(adTemplate, jumpFrom, smallAppJumpInfo);
            com.kwad.sdk.core.adlog.c.a(adTemplate, "wxsmallapp", 1, (com.kwad.sdk.core.adlog.c.a) null);
            a(jumpFrom, smallAppJumpInfo.mediaSmallAppId, smallAppJumpInfo.originId, smallAppJumpInfo.smallAppJumpUrl, adTemplate);
            return 1;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aA(boolean z) {
        LK = z;
    }

    public static int d(Context context, AdTemplate adTemplate) {
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        if (com.kwad.sdk.core.response.b.a.S(dS)) {
            return 0;
        }
        return a(context, dS.adConversionInfo.smallAppJumpInfo, JumpFrom.AD_PAGE, adTemplate);
    }

    private static boolean oO() {
        return LK;
    }

    private static void a(final JumpFrom jumpFrom, final String str, final String str2, final String str3, final AdTemplate adTemplate) {
        if (oO()) {
            return;
        }
        aA(true);
        int abs = Math.abs(com.kwad.sdk.core.config.d.CC());
        if (abs > 0) {
            bo.a(new Runnable() { // from class: com.kwad.components.core.e.d.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    e.aA(false);
                    com.kwad.sdk.core.c.b.En();
                    if (!com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        com.kwad.sdk.commercial.smallApp.a.a(AdTemplate.this, jumpFrom, str, str2, str3);
                        com.kwad.sdk.core.adlog.c.c(AdTemplate.this, "wxsmallapp", 1);
                    }
                }
            }, null, abs * 1000);
        } else {
            aA(false);
        }
    }
}
