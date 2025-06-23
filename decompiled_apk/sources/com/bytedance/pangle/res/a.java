package com.bytedance.pangle.res;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.util.j;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Integer> f10601a = new HashMap();
    private LinkedHashMap<String, Integer> b;

    static {
        List<String> a2 = j.a();
        if (a2 != null && a2.size() > 0) {
            Iterator<String> it = a2.iterator();
            while (it.hasNext()) {
                f10601a.put(it.next(), 0);
            }
        }
    }

    public a() {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        this.b = linkedHashMap;
        linkedHashMap.put(Zeus.getAppApplication().getApplicationInfo().sourceDir, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        if (r4 > 0) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.content.res.AssetManager b(android.content.res.AssetManager r9, java.lang.String r10, boolean r11) {
        /*
            r0 = 0
            r1 = 1
            java.lang.String r2 = "addAssetPath"
            if (r11 == 0) goto L9
            java.lang.String r3 = "addAssetPathAsSharedLibrary"
            goto La
        L9:
            r3 = r2
        La:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 30
            if (r4 >= r5) goto L1a
            r5 = 29
            if (r4 != r5) goto L26
            int r4 = com.bytedance.pangle.I0Io.oIX0oI()
            if (r4 <= 0) goto L26
        L1a:
            if (r11 != 0) goto L26
            java.lang.String r4 = "/product/overlay/"
            boolean r4 = r10.startsWith(r4)
            if (r4 == 0) goto L26
            java.lang.String r3 = "addOverlayPath"
        L26:
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            java.lang.Class[] r5 = new java.lang.Class[r1]
            r5[r0] = r4
            java.lang.Class<android.content.res.AssetManager> r6 = android.content.res.AssetManager.class
            java.lang.reflect.Method r5 = com.bytedance.pangle.util.MethodUtils.getAccessibleMethod(r6, r3, r5)
            java.lang.String r7 = "Zeus/load_pangle"
            if (r5 != 0) goto L46
            if (r11 == 0) goto L46
            java.lang.Class[] r3 = new java.lang.Class[r1]
            r3[r0] = r4
            java.lang.reflect.Method r5 = com.bytedance.pangle.util.MethodUtils.getAccessibleMethod(r6, r2, r3)
            java.lang.String r3 = "AssetManagerProcessor AssetManager.addAssetPath() invoke addAssetPathAsSharedLibrary failed. use addAssetPath."
            com.bytedance.pangle.log.ZeusLogger.w(r7, r3)
            goto L47
        L46:
            r2 = r3
        L47:
            if (r5 == 0) goto Laf
            r3 = 3
        L4a:
            int r4 = r3 + (-1)
            if (r3 < 0) goto Lc8
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L78
            r3[r0] = r10     // Catch: java.lang.Exception -> L78
            java.lang.Object r3 = r5.invoke(r9, r3)     // Catch: java.lang.Exception -> L78
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Exception -> L78
            int r3 = r3.intValue()     // Catch: java.lang.Exception -> L78
            if (r3 == 0) goto L7a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L78
            java.lang.String r8 = "AssetManagerProcessor invoke AssetManager.addAssetPath() success, cookie = "
            r6.<init>(r8)     // Catch: java.lang.Exception -> L78
            r6.append(r3)     // Catch: java.lang.Exception -> L78
            java.lang.String r3 = ", path = "
            r6.append(r3)     // Catch: java.lang.Exception -> L78
            r6.append(r10)     // Catch: java.lang.Exception -> L78
            java.lang.String r3 = r6.toString()     // Catch: java.lang.Exception -> L78
            com.bytedance.pangle.log.ZeusLogger.i(r7, r3)     // Catch: java.lang.Exception -> L78
            goto Lc8
        L78:
            r3 = move-exception
            goto L94
        L7a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L78
            java.lang.String r8 = "AssetManagerProcessor invoke AssetManager.addAssetPath() failed, cookie = "
            r6.<init>(r8)     // Catch: java.lang.Exception -> L78
            r6.append(r3)     // Catch: java.lang.Exception -> L78
            java.lang.String r3 = " "
            r6.append(r3)     // Catch: java.lang.Exception -> L78
            r6.append(r10)     // Catch: java.lang.Exception -> L78
            java.lang.String r3 = r6.toString()     // Catch: java.lang.Exception -> L78
            com.bytedance.pangle.log.ZeusLogger.w(r7, r3)     // Catch: java.lang.Exception -> L78
            goto Lad
        L94:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "AssetManagerProcessor invoke AssetManager.addAssetPath() failed. asSharedLibrary = "
            r6.<init>(r8)
            r6.append(r11)
            java.lang.String r8 = ", methodName = "
            r6.append(r8)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            com.bytedance.pangle.log.ZeusLogger.w(r7, r6, r3)
        Lad:
            r3 = r4
            goto L4a
        Laf:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "AssetManagerProcessor reflect AssetManager.addAssetPath() failed. addAssetPathMethod == null. asSharedLibrary = "
            r10.<init>(r0)
            r10.append(r11)
            java.lang.String r11 = " methodName:"
            r10.append(r11)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            com.bytedance.pangle.log.ZeusLogger.w(r7, r10)
        Lc8:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.res.a.b(android.content.res.AssetManager, java.lang.String, boolean):android.content.res.AssetManager");
    }

    private static AssetManager c(AssetManager assetManager, String str, boolean z) {
        int i;
        int i2;
        Throwable th = null;
        int i3 = 3;
        loop0: while (true) {
            int i4 = i3 - 1;
            if (i3 < 0) {
                break;
            }
            try {
                synchronized (assetManager) {
                    i = 0;
                    for (int i5 = 0; i5 < 3; i5++) {
                        try {
                            if (i.c()) {
                                i = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str}, new Class[]{String.class})).intValue();
                            } else {
                                int i6 = Build.VERSION.SDK_INT;
                                if (i6 >= 24 && i6 <= 25) {
                                    i = ((Integer) MethodUtils.invokeMethod(assetManager, "addAssetPathNative", new Object[]{str, Boolean.valueOf(z)}, new Class[]{String.class, Boolean.TYPE})).intValue();
                                }
                            }
                            if (i != 0) {
                                break loop0;
                            }
                        } finally {
                        }
                    }
                    break loop0;
                }
            } catch (Throwable th2) {
                th = th2;
                i3 = i4;
            }
        }
        if (i == 0) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.appendAssetPathSafely() failed, cookie = " + i + " " + str);
        } else {
            Object readField = FieldUtils.readField(assetManager, "mStringBlocks");
            if (readField != null) {
                i2 = Array.getLength(readField);
            } else {
                i2 = 0;
            }
            int intValue = ((Integer) MethodUtils.invokeMethod(assetManager, "getStringBlockCount", new Object[0])).intValue();
            Object newInstance = Array.newInstance(readField.getClass().getComponentType(), intValue);
            for (int i7 = 0; i7 < intValue; i7++) {
                if (i7 < i2) {
                    Array.set(newInstance, i7, Array.get(readField, i7));
                } else {
                    Long l = (Long) MethodUtils.invokeMethod(assetManager, "getNativeStringBlock", new Object[]{Integer.valueOf(i7)}, new Class[]{Integer.TYPE});
                    l.longValue();
                    Array.set(newInstance, i7, MethodUtils.invokeConstructor(readField.getClass().getComponentType(), new Object[]{l, Boolean.TRUE}, new Class[]{Long.TYPE, Boolean.TYPE}));
                }
            }
            FieldUtils.writeField(assetManager, "mStringBlocks", newInstance);
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely success, sourceDir = ".concat(String.valueOf(str)));
        }
        if (th != null) {
            if (!TextUtils.equals(Build.BRAND.toLowerCase(), "samsung")) {
                ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
            }
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = ".concat(String.valueOf(str)), th);
        }
        return assetManager;
    }

    public final AssetManager a(AssetManager assetManager, String str, boolean z) {
        AssetManager a2;
        if (str.endsWith(".frro")) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor updateAssetManager skip frro. ".concat(str));
            return assetManager;
        }
        if (i.a()) {
            if (i.e()) {
                a2 = c(assetManager, str, z);
                if (!j.a(a2, str)) {
                    a2 = b(assetManager, str, z);
                }
            } else {
                a2 = b(assetManager, str, z);
            }
        } else {
            a2 = a(assetManager, str);
        }
        synchronized (this.b) {
            this.b.put(str, 0);
        }
        return a2;
    }

    private AssetManager a(AssetManager assetManager, String str) {
        AssetManager assetManager2;
        List<String> a2 = j.a(assetManager);
        ArrayList<String> arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (String str2 : a2) {
            if (!f10601a.containsKey(str2) && !this.b.containsKey(str2) && !str2.equals(str)) {
                arrayList.add(str2);
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager, runtimeAdditionalAssets path = ".concat(String.valueOf(str)));
        try {
            if (assetManager.getClass().getName().equals("android.content.res.BaiduAssetManager")) {
                assetManager2 = (AssetManager) Class.forName("android.content.res.BaiduAssetManager").getConstructor(null).newInstance(null);
            } else {
                assetManager2 = (AssetManager) AssetManager.class.newInstance();
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager = ".concat(String.valueOf(assetManager2)));
            synchronized (this.b) {
                try {
                    for (Map.Entry<String, Integer> entry : this.b.entrySet()) {
                        if (!f10601a.containsKey(entry.getKey())) {
                            sb.append(entry.getKey());
                            b(assetManager2, entry.getKey(), false);
                        }
                    }
                } finally {
                }
            }
            if (!sb.toString().contains(Zeus.getAppApplication().getApplicationInfo().sourceDir)) {
                b(assetManager2, Zeus.getAppApplication().getApplicationInfo().sourceDir, false);
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager lost host path : " + f10601a.containsKey(Zeus.getAppApplication().getApplicationInfo().sourceDir));
            }
            sb.append(str);
            b(assetManager2, str, false);
            if (!arrayList.isEmpty()) {
                for (String str3 : arrayList) {
                    sb.append(str3);
                    b(assetManager2, str3, false);
                }
            }
            if (i.d() && !sb.toString().toLowerCase().contains("webview")) {
                try {
                    Resources resources = Zeus.getAppApplication().getResources();
                    String str4 = Zeus.getAppApplication().createPackageContext(resources.getString(resources.getIdentifier("android:string/config_webViewPackageName", TypedValues.Custom.S_STRING, "android")), 0).getApplicationInfo().sourceDir;
                    if (!TextUtils.isEmpty(str4)) {
                        b(assetManager2, str4, false);
                    }
                } catch (Exception e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager appendAsset webview failed.", e);
                }
            }
            assetManager = assetManager2;
        } catch (Exception e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor newAssetManager failed.", e2);
            b(assetManager, str, false);
        }
        try {
            MethodUtils.invokeMethod(assetManager, "ensureStringBlocks", new Object[0]);
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks");
        } catch (Exception e3) {
            ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor ensureStringBlocks failed.", e3);
        }
        return assetManager;
    }
}
