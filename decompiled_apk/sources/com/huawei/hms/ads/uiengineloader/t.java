package com.huawei.hms.ads.uiengineloader;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.huawei.hms.ads.dynamic.IDynamicLoader;
import java.util.HashMap;

/* loaded from: classes10.dex */
public final class t implements u {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17358a = "ads_HMSLoadStrategy";
    private static final String b = "content://com.huawei.hms";
    private static final String c = "huawei_module_dynamicloader";
    private static final String d = "errcode";
    private static final String e = "loader_version";
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = 6;
    private static HashMap<String, Bundle> i = new HashMap<>();

    /* renamed from: com.huawei.hms.ads.uiengineloader.t$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static class AnonymousClass1 extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f17359a;
        final /* synthetic */ String b;
        final /* synthetic */ int c = 0;

        public AnonymousClass1(Context context, String str) {
            this.f17359a = context;
            this.b = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            t.a(this.f17359a, this.b, this.c);
        }
    }

    public static int a(Context context, String str) throws com.huawei.hms.ads.dynamicloader.j {
        Bundle bundle;
        if (i.containsKey(str) && (bundle = i.get(str)) != null) {
            af.b(f17358a, "cachedModuleInfo containsKey, version: " + bundle.getInt("module_version"));
            return bundle.getInt("module_version");
        }
        Bundle c2 = c(context, str);
        if (c2 == null) {
            af.c(f17358a, "Query module bundle info failed: null.");
            return 0;
        }
        if (c2.getInt("errcode") != 0) {
            return 0;
        }
        return c2.getInt("module_version");
    }

    private static Context b(Context context, y yVar) throws com.huawei.hms.ads.dynamicloader.j {
        IDynamicLoader asInterface = IDynamicLoader.Stub.asInterface(w.a(context, yVar.e));
        if (asInterface == null) {
            af.c(f17358a, "Get iDynamicLoader failed: null.");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("module_name", yVar.f17365a);
        bundle.putString("loader_path", yVar.e);
        bundle.putInt("module_version", yVar.d);
        bundle.putString(com.huawei.hms.ads.dynamicloader.b.e, yVar.f);
        return w.a(context, yVar.f17365a, bundle, asInterface);
    }

    private static Bundle c(Context context, String str) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                af.c(f17358a, "Query remote version failed: null contentResolver.");
                return null;
            }
            Bundle call = contentResolver.call(Uri.parse("content://com.huawei.hms"), str, (String) null, (Bundle) null);
            if (call == null) {
                af.c(f17358a, "query module:" + str + " failed: null.");
                return null;
            }
            int i2 = call.getInt("errcode");
            if (i2 == 0) {
                i.put(str, call);
            }
            af.b(f17358a, "Query module info result code:".concat(String.valueOf(i2)));
            return call;
        } catch (Exception e2) {
            af.c(f17358a, "Query module:" + str + " info failed:" + e2.getMessage());
            return null;
        }
    }

    private static void d(Context context, String str) {
        new AnonymousClass1(context, str).start();
    }

    private static void e(Context context, String str) {
        try {
            Bundle c2 = c(context, str);
            if (c2 == null) {
                af.c(f17358a, "query failed to get bundle info: null.");
                return;
            }
            int i2 = c2.getInt("errcode");
            if (i2 == 1) {
                af.c(f17358a, "the query module:" + str + " is not existed in HMS.");
                return;
            }
            if (i2 != 0) {
                af.c(f17358a, "failed to get bundle info for " + str + ", errcode:" + i2);
                return;
            }
            af.b(f17358a, "Ready to cp module.");
            boolean a2 = x.a(context, c2);
            af.a(f17358a, "bundle info: errorCode:" + i2 + ", moduleName:" + str + ", moduleVersion:" + c2.getInt("module_version"));
            StringBuilder sb = new StringBuilder("cp remote version by module name:");
            sb.append(str);
            sb.append(" ,result:");
            sb.append(a2);
            af.b(f17358a, sb.toString());
        } catch (Throwable th) {
            af.c(f17358a, "Failed to cp remote hms module version." + th.getClass().getSimpleName());
        }
    }

    private static y b(Context context, String str) throws com.huawei.hms.ads.dynamicloader.j {
        Bundle c2;
        y yVar = new y();
        try {
            c2 = c(context, str);
        } catch (com.huawei.hms.ads.dynamicloader.j e2) {
            throw e2;
        } catch (Exception e3) {
            af.c(f17358a, "Failed to Query remote module version." + e3.getClass().getSimpleName());
        }
        if (c2 == null) {
            af.c(f17358a, "Failed to get bundle info: null.");
            return yVar;
        }
        int i2 = c2.getInt("errcode");
        if (i2 == 1) {
            af.c(f17358a, "The query module:" + str + " is not existed in HMS.");
            return yVar;
        }
        if (i2 != 0) {
            af.c(f17358a, "Failed to get bundle info for " + str + ", errcode:" + i2);
            throw new com.huawei.hms.ads.dynamicloader.j("Query module unavailable, maybe you need to download it.", c2);
        }
        yVar.f17365a = str;
        yVar.b = c2.getString("module_path");
        yVar.c = c2.getString(com.huawei.hms.ads.dynamicloader.b.k);
        yVar.d = c2.getInt("module_version");
        yVar.e = c2.getString("loader_path");
        yVar.g = c2.getInt("loader_version");
        yVar.h = c2.getInt("armeabiType");
        af.b(f17358a, "bundle info: errorCode:" + i2 + ", moduleName:" + str + ", moduleVersion:" + yVar.d);
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                boolean a2 = x.a(context, c2);
                af.b(f17358a, "android s,  result:".concat(String.valueOf(a2)));
                if (a2) {
                    yVar.b = c2.getString("module_path");
                }
            } else {
                new AnonymousClass1(context, yVar.f17365a).start();
            }
        } catch (Throwable th) {
            af.c(f17358a, "copyRemoteModule err:" + th.getClass().getSimpleName());
        }
        af.b(f17358a, "Query remote version by module name:" + str + " success.");
        return yVar;
    }

    @Override // com.huawei.hms.ads.uiengineloader.u
    public final Context a(Context context, y yVar) throws com.huawei.hms.ads.dynamicloader.j {
        try {
            if (yVar.e.contains(c)) {
                Bundle bundle = new Bundle();
                bundle.putString("module_path", yVar.b);
                bundle.putString("module_name", yVar.f17365a);
                bundle.putInt("armeabiType", yVar.h);
                bundle.putString(com.huawei.hms.ads.dynamicloader.b.e, yVar.f);
                com.huawei.hms.ads.dynamicloader.h.a(context);
                return com.huawei.hms.ads.dynamicloader.h.a(context, bundle);
            }
            af.b(f17358a, "The loader is not dynamicLoader，use it to load.");
            IDynamicLoader asInterface = IDynamicLoader.Stub.asInterface(w.a(context, yVar.e));
            if (asInterface == null) {
                af.c(f17358a, "Get iDynamicLoader failed: null.");
                return null;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("module_name", yVar.f17365a);
            bundle2.putString("loader_path", yVar.e);
            bundle2.putInt("module_version", yVar.d);
            bundle2.putString(com.huawei.hms.ads.dynamicloader.b.e, yVar.f);
            return w.a(context, yVar.f17365a, bundle2, asInterface);
        } catch (com.huawei.hms.ads.dynamicloader.j e2) {
            throw e2;
        } catch (Exception unused) {
            af.d(f17358a, "Load DynamicModule failed.");
            Bundle bundle3 = new Bundle();
            bundle3.putInt("errcode", 6);
            throw new com.huawei.hms.ads.dynamicloader.j("load HMS dynamic module failed.", bundle3);
        }
    }

    @Override // com.huawei.hms.ads.uiengineloader.u
    public final y a(Context context, String str, String str2) throws com.huawei.hms.ads.dynamicloader.j {
        return b(context, str);
    }

    private static void a(Context context, y yVar, Bundle bundle) {
        try {
            if (Build.VERSION.SDK_INT < 31) {
                new AnonymousClass1(context, yVar.f17365a).start();
                return;
            }
            boolean a2 = x.a(context, bundle);
            af.b(f17358a, "android s,  result:".concat(String.valueOf(a2)));
            if (a2) {
                yVar.b = bundle.getString("module_path");
            }
        } catch (Throwable th) {
            af.c(f17358a, "copyRemoteModule err:" + th.getClass().getSimpleName());
        }
    }

    public static void a(Context context, String str, int i2) {
        try {
            int a2 = a(context, str);
            af.b(f17358a, "remoteVersion:" + a2 + " localModuleVersion:" + i2);
            if (a2 > i2) {
                try {
                    Bundle c2 = c(context, str);
                    if (c2 == null) {
                        af.c(f17358a, "query failed to get bundle info: null.");
                        return;
                    }
                    int i3 = c2.getInt("errcode");
                    if (i3 == 1) {
                        af.c(f17358a, "the query module:" + str + " is not existed in HMS.");
                        return;
                    }
                    if (i3 != 0) {
                        af.c(f17358a, "failed to get bundle info for " + str + ", errcode:" + i3);
                        return;
                    }
                    af.b(f17358a, "Ready to cp module.");
                    boolean a3 = x.a(context, c2);
                    af.a(f17358a, "bundle info: errorCode:" + i3 + ", moduleName:" + str + ", moduleVersion:" + c2.getInt("module_version"));
                    StringBuilder sb = new StringBuilder("cp remote version by module name:");
                    sb.append(str);
                    sb.append(" ,result:");
                    sb.append(a3);
                    af.b(f17358a, sb.toString());
                } catch (Throwable th) {
                    af.c(f17358a, "Failed to cp remote hms module version." + th.getClass().getSimpleName());
                }
            }
        } catch (Throwable th2) {
            af.c(f17358a, "cp error: " + th2.getLocalizedMessage());
        }
    }
}
