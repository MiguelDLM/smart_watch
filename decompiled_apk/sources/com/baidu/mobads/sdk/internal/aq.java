package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.sdk.api.PromoteInstallManager;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class aq {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6230a = x.m;
    private static final String b = "__sdk_remote_dl_no_install";
    private static final long c = 3600000;
    private Context d;
    private SharedPreferences e;
    private SharedPreferences.Editor f;
    private au g;
    private PromoteInstallManager.PromoteInstallListener h;
    private int i;
    private long j;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final aq f6231a = new aq(null);

        private a() {
        }
    }

    public /* synthetic */ aq(ar arVar) {
        this();
    }

    public static aq a(Context context, PromoteInstallManager.PromoteInstallListener promoteInstallListener) {
        a.f6231a.b(context, promoteInstallListener);
        return a.f6231a;
    }

    private void b(Context context, PromoteInstallManager.PromoteInstallListener promoteInstallListener) {
        this.d = context;
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(b, 0);
        this.e = sharedPreferences;
        this.f = sharedPreferences.edit();
        this.g = au.a(context, f6230a);
        this.h = promoteInstallListener;
    }

    private aq() {
        this.i = 0;
        this.j = 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b9, code lost:
    
        r8 = new com.baidu.mobads.sdk.internal.ap(r11, r18.d, r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c0, code lost:
    
        if (r19 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c2, code lost:
    
        r0 = new org.json.JSONObject(r11.toString());
        r0.put("install_ts", r12);
        r0 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d9, code lost:
    
        r0.printStackTrace();
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d5, code lost:
    
        r6 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x012e, code lost:
    
        r0 = r18.h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0130, code lost:
    
        if (r0 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0132, code lost:
    
        r0.onFail("暂无可用物料，请稍后再试");
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0135, code lost:
    
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.baidu.mobads.sdk.api.IPromoteInstallAdInfo a(boolean r19) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.aq.a(boolean):com.baidu.mobads.sdk.api.IPromoteInstallAdInfo");
    }

    public int b() {
        Object b2 = this.g.b(null, "getInstallPopType", new Object[0]);
        if (b2 instanceof Integer) {
            return ((Integer) b2).intValue();
        }
        return 0;
    }

    private boolean a(JSONObject jSONObject) {
        File file = new File(jSONObject.optString("folder") + jSONObject.optString("filename"));
        return file.exists() && file.length() > 0;
    }

    public boolean a() {
        Object b2 = this.g.b(null, "isInstallPopSwitch", new Object[0]);
        if (b2 instanceof Boolean) {
            return ((Boolean) b2).booleanValue();
        }
        return false;
    }

    public void a(Context context, String str) {
        this.g.b(null, "handleAdInstall", context, str);
    }
}
