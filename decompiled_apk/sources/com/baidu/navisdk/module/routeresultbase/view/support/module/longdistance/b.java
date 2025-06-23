package com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance;

import android.text.TextUtils;
import com.baidu.navisdk.model.datastruct.h;
import com.baidu.navisdk.model.datastruct.i;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.Comparator;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private i f7527a;
    private com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.c b = new c();

    /* renamed from: com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0290b implements Comparator<h> {
        private C0290b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(h hVar, h hVar2) {
            if (hVar == null && hVar2 == null) {
                return 0;
            }
            if (hVar == null) {
                return Integer.MIN_VALUE;
            }
            if (hVar2 == null) {
                return Integer.MAX_VALUE;
            }
            return hVar.a() - hVar2.a();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.c {
        private c(b bVar) {
        }

        @Override // com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.c
        public void a(i iVar) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNMeteorModel", "NullMeteorDataChangeListener.onDataChanged --> meteorsAllRoute = " + iVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0324 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.baidu.navisdk.model.datastruct.i b() {
        /*
            Method dump skipped, instructions count: 1051
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.b.b():com.baidu.navisdk.model.datastruct.i");
    }

    private void c() {
        i m90clone;
        if (this.b != null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNMeteorModel", "notifyDataChanged --> mMeteorsAllRoute = " + this.f7527a);
            }
            com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.c cVar = this.b;
            i iVar = this.f7527a;
            if (iVar == null) {
                m90clone = null;
            } else {
                m90clone = iVar.m90clone();
            }
            cVar.a(m90clone);
        }
    }

    public synchronized void a() {
        try {
            i b = b();
            if (b == null) {
                this.f7527a = null;
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BNMeteorModel", "updateWeatherDataFromEngine!!!");
                }
                c();
                return;
            }
            if (!b.equals(this.f7527a)) {
                this.f7527a = b;
                b.a(System.currentTimeMillis());
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BNMeteorModel", "updateWeatherDataFromEngine!!!");
                }
                c();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a(com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.c cVar) {
        this.b = cVar;
        if (cVar == null || this.f7527a == null) {
            return;
        }
        c();
    }

    private static boolean a(h hVar) {
        h.d dVar;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMeteorModel", "checkWeatherValid --> meteorInfo = " + hVar);
        }
        if (hVar == null || (dVar = hVar.f) == null || TextUtils.isEmpty(dVar.f6931a)) {
            return false;
        }
        if (hVar.e == null) {
            return true;
        }
        return !e.a(hVar.f.f6931a, r0.d, r0.e);
    }
}
