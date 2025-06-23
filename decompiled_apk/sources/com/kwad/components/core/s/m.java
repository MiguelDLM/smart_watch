package com.kwad.components.core.s;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media2.session.MediaConstants;
import com.kwad.sdk.core.config.item.p;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o0oIxXOx.XIxXXX0x0;

/* loaded from: classes11.dex */
public class m {
    public static final String TAG = "m";
    private static final String TW = "com.kwad.components.core.s.m";
    private static volatile m TX;
    private boolean TY = false;
    private p.a TZ;

    private m() {
    }

    private static void I(long j) {
        com.kwad.sdk.core.e.c.d(TAG, "checkBySuper end:" + (SystemClock.elapsedRealtime() - j));
    }

    private static boolean aC(String str) {
        if (!str.startsWith("android") && !str.startsWith(XIxXXX0x0.f31176x0XOIxOo) && !str.startsWith("dalvik") && !str.startsWith("com.android") && !str.contains(TW) && str.startsWith(MediaConstants.MEDIA_URI_SCHEME)) {
            return true;
        }
        return false;
    }

    private static boolean aD(String str) {
        if (!str.startsWith("com.kwad")) {
            return true;
        }
        return false;
    }

    private static boolean aE(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static m rI() {
        if (TX == null) {
            synchronized (m.class) {
                try {
                    if (TX == null) {
                        TX = new m();
                    }
                } finally {
                }
            }
        }
        return TX;
    }

    private void rK() {
        p.a aVar = this.TZ;
        if (aVar == null) {
            return;
        }
        if (!this.TY && aVar.auI.size() > 0) {
            Iterator<String> it = this.TZ.auI.iterator();
            while (it.hasNext()) {
                boolean aE = aE(it.next());
                this.TY = aE;
                if (aE) {
                    break;
                }
            }
        }
        if (!this.TY) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.TZ.auF.size() > 0) {
            for (Map.Entry<Integer, String> entry : this.TZ.auF.entrySet()) {
                if (aE(entry.getValue())) {
                    arrayList.add(entry.getKey());
                }
            }
        }
        p.a aVar2 = this.TZ;
        com.kwad.components.core.o.a.qI().a(a(aVar2.auG, aVar2.auH), arrayList);
    }

    public final boolean a(SceneImpl sceneImpl, String str) {
        boolean z;
        if (this.TY) {
            p.a aVar = this.TZ;
            z = a(aVar.auG, aVar.auH);
        } else {
            z = false;
        }
        com.kwad.components.core.o.a.qI().a(sceneImpl, z, str);
        return z;
    }

    public final void init() {
        p.a aVar = (p.a) com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.aso);
        this.TZ = aVar;
        if (aVar != null) {
            rK();
        }
    }

    public final int rJ() {
        p.a aVar = this.TZ;
        if (aVar != null) {
            return aVar.auJ;
        }
        return 0;
    }

    private boolean a(List<String> list, List<String> list2) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (className.contains(it.next())) {
                        return true;
                    }
                }
            }
        }
        return a(list2, stackTrace);
    }

    private boolean a(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null && !list.isEmpty()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.sdk.core.e.c.d(TAG, "checkBySuper begin:" + elapsedRealtime);
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                String className = stackTraceElement.getClassName();
                if (className != null && aC(className) && aD(className)) {
                    try {
                        if (a(list, Class.forName(className).getSuperclass())) {
                            I(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        if (className.contains("$") && a(list, Class.forName(className.substring(0, className.lastIndexOf("$"))).getSuperclass())) {
                            I(elapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused2) {
                        continue;
                    }
                }
            }
            I(elapsedRealtime);
        }
        return false;
    }

    private static boolean a(List<String> list, Class cls) {
        int i = 0;
        while (cls != null && !TextUtils.equals(cls.getName(), "java.lang.Object")) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (cls.getName().contains(it.next())) {
                    return true;
                }
            }
            cls = cls.getSuperclass();
            i++;
            if (i >= 4) {
                break;
            }
        }
        return false;
    }
}
