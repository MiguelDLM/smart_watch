package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes10.dex */
public class iz {
    private static final int C = 0;
    private static final String Code = "ClctCtxProcessor";
    private static iz Z;
    private Context d;
    private Class<?> e;
    private static final byte[] V = new byte[0];
    private static final byte[] I = new byte[0];
    private static Map<String, String[]> B = new ConcurrentHashMap();
    private int S = 0;
    private int F = 0;
    private int D = 0;
    private int L = 0;

    /* renamed from: a, reason: collision with root package name */
    private int f17307a = 0;
    private int b = 0;
    private int c = 100;

    private iz(Context context) {
        this.d = context.getApplicationContext();
        try {
            this.e = Class.forName("com.huawei.openalliance.ad.views.PPSNativeView");
        } catch (Throwable unused) {
            fb.I(Code, "init unClctViewClass error");
        }
    }

    public static iz Code(Context context) {
        return I(context);
    }

    private static iz I(Context context) {
        iz izVar;
        synchronized (V) {
            try {
                if (Z == null) {
                    Z = new iz(context);
                }
                izVar = Z;
            } catch (Throwable th) {
                throw th;
            }
        }
        return izVar;
    }

    public String Code() {
        if (ed.Code(this.d).ae()) {
            fb.Code(Code, "get AutoContentBundle");
            return com.huawei.openalliance.ad.utils.aa.V(B);
        }
        fb.Code(Code, "get AutoContentBundle off");
        B.clear();
        return null;
    }

    public void V(final Context context) {
        com.huawei.openalliance.ad.utils.h.B(new Runnable() { // from class: com.huawei.hms.ads.iz.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    ed Code2 = ed.Code(context);
                    if (Code2.ae()) {
                        int N = Code2.N() * 1000;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - Code2.af() <= N && N != 0) {
                            fb.Code(iz.Code, "collect AutoContentBundle is limited in %s ", Integer.valueOf(N));
                            return;
                        }
                        fb.Code(iz.Code, "collectAutoContentBundle");
                        Code2.I(currentTimeMillis);
                        Context context2 = context;
                        if (context2 instanceof Activity) {
                            Activity activity = (Activity) context2;
                            String simpleName = activity.getClass().getSimpleName();
                            fb.Code(iz.Code, "getActivityInfo-name: %s", activity.getClass().getSimpleName());
                            if (!com.huawei.openalliance.ad.utils.ay.Code(simpleName)) {
                                iz.B.clear();
                                iz.B.put("activityName", new String[]{simpleName});
                            }
                            Map Code3 = iz.this.Code(activity, Code2.P());
                            int O = Code2.O();
                            if (!com.huawei.openalliance.ad.utils.ai.Code(Code3)) {
                                iz.this.Code(activity, (Map<Integer, String>) Code3, O);
                                return;
                            }
                            fb.Code(iz.Code, "no id list, getAutoContent");
                            String[] Code4 = iz.this.Code(activity, O);
                            if (Code4 == null || Code4.length <= 0) {
                                return;
                            }
                            iz.B.put(com.huawei.openalliance.ad.constant.x.cm, Code4);
                            return;
                        }
                        str = "getActivityInfo-name: not Activity";
                    } else {
                        iz.B.clear();
                        str = "collectAutoContentBundle off";
                    }
                    fb.Code(iz.Code, str);
                } catch (Throwable th) {
                    fb.Code(iz.Code, "collect AutoContentBundle error: %s", th.getClass().getSimpleName());
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0082, code lost:
    
        if (android.text.TextUtils.isEmpty(r6) == false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<java.lang.String> Code(android.view.View r10, int r11, int r12) {
        /*
            r9 = this;
            r0 = 0
            r1 = 1
            if (r10 != 0) goto L6
            r10 = 0
            return r10
        L6:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            boolean r3 = r10 instanceof android.view.ViewGroup
            if (r3 == 0) goto Lbc
            int r12 = r12 + r1
            int r3 = r9.c
            if (r12 < r3) goto L24
            java.lang.String r10 = "ClctCtxProcessor"
            java.lang.String r11 = "autoContentRur outer round %s "
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r12
            com.huawei.hms.ads.fb.Code(r10, r11, r1)
            return r2
        L24:
            android.view.ViewGroup r10 = (android.view.ViewGroup) r10
            r3 = 0
        L27:
            int r4 = r10.getChildCount()
            if (r3 >= r4) goto Lbc
            android.view.View r4 = r10.getChildAt(r3)
            boolean r5 = r9.Code(r4)
            if (r5 == 0) goto L39
            goto Lb9
        L39:
            boolean r5 = r4 instanceof android.widget.TextView
            if (r5 == 0) goto L9e
            boolean r5 = r4.isShown()
            if (r5 == 0) goto L9e
            byte[] r5 = com.huawei.hms.ads.iz.I
            monitor-enter(r5)
            r6 = r4
            android.widget.TextView r6 = (android.widget.TextView) r6     // Catch: java.lang.Throwable -> L78
            java.lang.CharSequence r6 = r6.getText()     // Catch: java.lang.Throwable -> L78
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L78
            int r7 = r9.S     // Catch: java.lang.Throwable -> L78
            if (r7 >= r11) goto L88
            int r8 = r6.length()     // Catch: java.lang.Throwable -> L78
            int r7 = r7 + r8
            if (r7 <= r11) goto L88
            int r7 = r9.S     // Catch: java.lang.Throwable -> L78
            int r8 = r6.length()     // Catch: java.lang.Throwable -> L78
            int r7 = r7 + r8
            r9.S = r7     // Catch: java.lang.Throwable -> L78
            int r7 = r6.length()     // Catch: java.lang.Throwable -> L78
            int r8 = r9.S     // Catch: java.lang.Throwable -> L78
            int r7 = r7 - r8
            int r7 = r7 + r11
            int r8 = r6.length()     // Catch: java.lang.Throwable -> L78
            if (r7 <= r8) goto L7a
            int r7 = r6.length()     // Catch: java.lang.Throwable -> L78
            goto L7a
        L78:
            r10 = move-exception
            goto L9c
        L7a:
            java.lang.String r6 = r6.substring(r0, r7)     // Catch: java.lang.Throwable -> L78
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L78
            if (r7 != 0) goto L9a
        L84:
            r2.add(r6)     // Catch: java.lang.Throwable -> L78
            goto L9a
        L88:
            int r7 = r9.S     // Catch: java.lang.Throwable -> L78
            if (r7 >= r11) goto L9a
            int r8 = r6.length()     // Catch: java.lang.Throwable -> L78
            int r7 = r7 + r8
            r9.S = r7     // Catch: java.lang.Throwable -> L78
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L78
            if (r7 != 0) goto L9a
            goto L84
        L9a:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L78
            goto L9e
        L9c:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L78
            throw r10
        L9e:
            int r5 = r9.S
            if (r5 < r11) goto Lb2
            java.lang.String r10 = "ClctCtxProcessor"
            java.lang.String r12 = "autoContentSize maxSize %s"
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r11
            com.huawei.hms.ads.fb.Code(r10, r12, r1)
            return r2
        Lb2:
            java.util.List r4 = r9.Code(r4, r11, r12)
            r2.addAll(r4)
        Lb9:
            int r3 = r3 + r1
            goto L27
        Lbc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.iz.Code(android.view.View, int, int):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<Integer, String> Code(Context context, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (!com.huawei.openalliance.ad.utils.ai.Code(map)) {
            Code(context, "title", map, hashMap);
            Code(context, "content", map, hashMap);
            Code(context, "category", map, hashMap);
            Code(context, com.huawei.openalliance.ad.constant.x.cr, map, hashMap);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Activity activity, Map<Integer, String> map, int i) {
        HashMap hashMap = new HashMap();
        this.F = 0;
        this.L = 0;
        this.f17307a = 0;
        this.D = 0;
        Code(activity.getWindow().getDecorView(), map, hashMap, i, this.b);
        if (com.huawei.openalliance.ad.utils.ai.Code(hashMap)) {
            fb.Code(Code, "no get cfg, getAutoContent");
            String[] Code2 = Code(activity, i);
            if (Code2 == null || Code2.length <= 0) {
                return;
            }
            B.put(com.huawei.openalliance.ad.constant.x.cm, Code2);
            return;
        }
        Code(hashMap, "title", B);
        if (!Code(hashMap, "content", B)) {
            fb.Code(Code, "no get cfg content, getAutoContent");
            String[] Code3 = Code(activity, i);
            if (Code3 != null && Code3.length > 0) {
                B.put(com.huawei.openalliance.ad.constant.x.cm, Code3);
            }
        }
        Code(hashMap, "category", B);
        Code(hashMap, com.huawei.openalliance.ad.constant.x.cr, B);
    }

    private void Code(Context context, String str, Map<String, String> map, Map<Integer, String> map2) {
        List list = (List) com.huawei.openalliance.ad.utils.aa.V(map.get(str), List.class, new Class[0]);
        if (com.huawei.openalliance.ad.utils.ad.Code(list)) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int identifier = context.getResources().getIdentifier((String) it.next(), "id", context.getPackageName());
            if (identifier != 0) {
                map2.put(Integer.valueOf(identifier), str);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ca, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) == false) goto L48;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0076. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Code(android.view.View r11, java.util.Map<java.lang.Integer, java.lang.String> r12, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.iz.Code(android.view.View, java.util.Map, java.util.Map, int, int):void");
    }

    private boolean Code(View view) {
        Class<?> cls = this.e;
        return cls != null && cls.isInstance(view);
    }

    private boolean Code(Map<String, List<String>> map, String str, Map<String, String[]> map2) {
        if (!map.containsKey(str)) {
            return false;
        }
        List<String> list = map.get(str);
        if (!com.huawei.openalliance.ad.utils.ad.Code(list)) {
            map2.put(str, (String[]) list.toArray(new String[list.size()]));
            return true;
        }
        fb.Code(Code, "get %s is null " + str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] Code(Activity activity, int i) {
        this.S = 0;
        String[] strArr = new String[0];
        List<String> Code2 = Code(activity.getWindow().getDecorView(), i, this.b);
        if (!com.huawei.openalliance.ad.utils.ad.Code(Code2)) {
            return (String[]) Code2.toArray(new String[Code2.size()]);
        }
        fb.Code(Code, "get contentAuto is null");
        return strArr;
    }
}
