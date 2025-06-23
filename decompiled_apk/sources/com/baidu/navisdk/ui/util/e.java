package com.baidu.navisdk.ui.util;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.garmin.fit.OxXXx0X;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9199a = "com.baidu.navisdk.ui.util.e";
    private static c b;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f9200a;
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, Context context, String str3) {
            super(str, str2);
            this.f9200a = context;
            this.b = str3;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            try {
                e.c(this.f9200a, this.b, 0);
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    private static int a(int i) {
        if (1 == i) {
            return OxXXx0X.f13024OIII0O;
        }
        return 2000;
    }

    private static void b(Context context, String str, int i) {
        if (context instanceof Activity) {
            c cVar = new c(context, R.style.TiptoolDialog, str);
            b = cVar;
            cVar.setCanceledOnTouchOutside(false);
            b.getWindow().setFlags(8, 8);
            b.a(str, i);
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(f9199a, "createDialog context is null or not activity");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str, int i) {
        int i2;
        if (str.length() > 15) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        LogUtil.e(f9199a, "showToastMessage1 " + str + ", dialog= " + b);
        int a2 = a(i2);
        c cVar = b;
        if (cVar == null) {
            b(context, str, a2);
            return;
        }
        cVar.a();
        try {
            b.dismiss();
        } catch (Exception unused) {
        }
        b = null;
        b(context, str, a2);
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new a("", null, context, str), new com.baidu.navisdk.util.worker.e(99, 0));
    }

    public static boolean a(Context context) {
        if (context == null) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
            Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
            num.intValue();
            return ((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return true;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return true;
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
            return true;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return true;
        } catch (NullPointerException e5) {
            e5.printStackTrace();
            return true;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return true;
        }
    }
}
