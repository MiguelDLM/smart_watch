package com.baidu.navisdk.ui.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class TipTool {
    private static final int MAX_TOAST_TEXT_LENGTH = 30;
    private static String mLastMessagePrefix = null;
    private static long mLastTime = 0;
    private static Context sApplicationContext = null;
    private static boolean sIsForBaiduMap = false;
    private static boolean sIsForeground = true;
    public static boolean sShowDebugToast = false;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f9193a;
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, Context context, String str3) {
            super(str, str2);
            this.f9193a = context;
            this.b = str3;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            TipTool.showToastInner(this.f9193a, this.b, true);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f9194a;
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, Context context, String str3, boolean z) {
            super(str, str2);
            this.f9194a = context;
            this.b = str3;
            this.c = z;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            TipTool.showToastInner(this.f9194a, this.b, false, this.c);
            return null;
        }
    }

    private static boolean isCanShowToast(Context context) {
        List<ActivityManager.RunningAppProcessInfo> list;
        if (sIsForBaiduMap) {
            return sIsForeground;
        }
        if (Build.VERSION.SDK_INT < 26) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                list = activityManager.getRunningAppProcesses();
            } else {
                list = null;
            }
            if (list != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.processName.equals(context.getPackageName())) {
                        if (next.importance == 100) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static void onCreateDebugToast(Context context, String str) {
        String str2;
        if (sShowDebugToast && str != null && str.length() >= 2) {
            long currentTimeMillis = System.currentTimeMillis();
            String str3 = str.split(" ")[0];
            if (currentTimeMillis - mLastTime < 5000 && (str2 = mLastMessagePrefix) != null && str2.equals(str3)) {
                mLastTime = System.currentTimeMillis();
                return;
            }
            mLastMessagePrefix = str3;
            mLastTime = System.currentTimeMillis();
            onCreateJNIToast(context, str);
        }
    }

    public static void onCreateJNIToast(Context context, String str) {
        if (sShowDebugToast && context != null && str != null && str.length() <= 30) {
            Context applicationContext = context.getApplicationContext();
            if (!isCanShowToast(applicationContext)) {
                return;
            }
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new a("TipTool-debug", null, applicationContext, str), new com.baidu.navisdk.util.worker.e(99, 0));
        }
    }

    public static void onCreateToastDialog(Context context, int i) {
        try {
            String string = context.getString(i);
            if (string == null || string.length() > 30) {
                return;
            }
            onCreateToastDialog(context, string);
        } catch (Exception unused) {
        }
    }

    public static void onCreateToastDialog2(Context context, String str) {
        onCreateToastDialog2(context, str, false);
    }

    public static void replaceDefaultContext(View view, Context context) {
        try {
            Field declaredField = View.class.getDeclaredField("mContext");
            declaredField.setAccessible(true);
            declaredField.set(view, context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setContext(Context context) {
        sApplicationContext = context;
    }

    public static void setIsForBaiduMap(boolean z) {
        sIsForBaiduMap = z;
    }

    public static void setIsForeground(boolean z) {
        sIsForeground = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showToastInner(Context context, String str, boolean z) {
        showToastInner(context, str, z, false);
    }

    public static void toast(String str) {
        Context context = sApplicationContext;
        if (context != null) {
            onCreateToastDialog2(context, str);
        }
    }

    public static void onCreateToastDialog2(Context context, String str, boolean z) {
        if (context == null || str == null || str.length() > 50) {
            return;
        }
        if (!e.a(context)) {
            e.a(context, str);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (isCanShowToast(applicationContext)) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                showToastInner(applicationContext, str, false, z);
            } else {
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new b("TipTool", null, applicationContext, str, z), new com.baidu.navisdk.util.worker.e(99, 0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014 A[Catch: Exception -> 0x001b, TryCatch #0 {Exception -> 0x001b, blocks: (B:2:0x0000, B:7:0x000e, B:9:0x0014, B:12:0x0029, B:16:0x001d), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void showToastInner(android.content.Context r2, java.lang.String r3, boolean r4, boolean r5) {
        /*
            int r0 = r3.length()     // Catch: java.lang.Exception -> L1b
            r1 = 15
            if (r0 > r1) goto Ld
            if (r5 == 0) goto Lb
            goto Ld
        Lb:
            r5 = 0
            goto Le
        Ld:
            r5 = 1
        Le:
            android.widget.Toast r3 = android.widget.Toast.makeText(r2, r3, r5)     // Catch: java.lang.Exception -> L1b
            if (r4 != 0) goto L1d
            boolean r4 = com.baidu.navisdk.ui.util.i.a()     // Catch: java.lang.Exception -> L1b
            if (r4 == 0) goto L29
            goto L1d
        L1b:
            r2 = move-exception
            goto L2d
        L1d:
            android.view.View r4 = r3.getView()     // Catch: java.lang.Exception -> L1b
            com.baidu.navisdk.ui.util.i r5 = new com.baidu.navisdk.ui.util.i     // Catch: java.lang.Exception -> L1b
            r5.<init>(r2)     // Catch: java.lang.Exception -> L1b
            replaceDefaultContext(r4, r5)     // Catch: java.lang.Exception -> L1b
        L29:
            r3.show()     // Catch: java.lang.Exception -> L1b
            goto L4b
        L2d:
            boolean r3 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
            if (r3 == 0) goto L4b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "showToastInner Exception 1:"
            r3.append(r4)
            java.lang.Throwable r2 = r2.getCause()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "TipTool"
            com.baidu.navisdk.util.common.LogUtil.e(r3, r2)
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.util.TipTool.showToastInner(android.content.Context, java.lang.String, boolean, boolean):void");
    }

    public static void onCreateToastDialog(Context context, String str) {
        onCreateToastDialog(context, str, false);
    }

    public static void onCreateToastDialog(Context context, String str, boolean z) {
        if (context == null || str == null || str.length() > 30) {
            return;
        }
        onCreateToastDialog2(context, str, z);
    }
}
