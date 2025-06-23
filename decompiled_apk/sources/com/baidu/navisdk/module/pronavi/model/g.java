package com.baidu.navisdk.module.pronavi.model;

import XIXIX.OOXIXo;
import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.ui.routeguide.model.p;
import com.baidu.navisdk.util.common.x;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class g {
    private static g s;
    private int p;
    private int q;

    /* renamed from: a, reason: collision with root package name */
    private Bundle f7467a = new Bundle();
    private p b = new p();
    private List<a> c = new ArrayList();
    private int d = 0;
    private int e = 0;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    private boolean i = true;
    private double j = OOXIXo.f3760XO;
    public int k = -1;
    public int l = -1;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean r = false;

    public static g o() {
        if (s == null) {
            synchronized (g.class) {
                try {
                    if (s == null) {
                        s = new g();
                    }
                } finally {
                }
            }
        }
        return s;
    }

    private int p() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            if (this.c.get(i).f7468a == 3) {
                return i;
            }
        }
        return -1;
    }

    public double a(double d) {
        return d * 3.6d;
    }

    public void b(int i, int i2) {
        this.p = i;
        this.q = i2;
    }

    public void c(boolean z) {
        this.i = z;
    }

    public int d() {
        return this.q;
    }

    public void e(boolean z) {
        this.o = z;
        if (z) {
            return;
        }
        b(0, 0);
    }

    public p f() {
        return this.b;
    }

    public boolean g() {
        return this.r;
    }

    public boolean h() {
        return this.o;
    }

    public boolean i() {
        if (this.m && !x.s()) {
            return true;
        }
        return false;
    }

    public boolean j() {
        int i = this.k;
        if (i == -1) {
            return false;
        }
        if (this.f) {
            if (this.e <= i) {
                return false;
            }
            return true;
        }
        if (!this.i || this.d <= i) {
            return false;
        }
        return true;
    }

    public boolean k() {
        return this.i;
    }

    public boolean l() {
        return this.n;
    }

    public void m() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGAssistGuideModel", "reset");
        }
        this.i = true;
        this.j = OOXIXo.f3760XO;
        this.d = 0;
        this.k = -1;
        this.l = -1;
        this.e = 0;
        this.f = false;
        List<a> list = this.c;
        if (list != null) {
            list.clear();
        }
        Bundle bundle = this.f7467a;
        if (bundle != null) {
            bundle.clear();
        }
        this.r = false;
        this.b.a();
        e(false);
    }

    public void n() {
        this.j = BNRouteGuider.getInstance().getCarProgress();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGAssistGuideModel", "updateCarProgress " + this.j);
        }
    }

    public void a(boolean z) {
        this.m = z;
    }

    public int c() {
        return this.d;
    }

    public void d(boolean z) {
        this.n = z;
    }

    private int c(int i, int i2, int i3) {
        int size = this.c.size();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGAssistGuideModel", "recieveShowInfo  size=" + size);
        }
        if (size == 0) {
            a aVar = new a();
            aVar.f7468a = 1;
            aVar.b = i2;
            aVar.c = i3;
            aVar.d = 0;
            aVar.e = i;
            this.c.add(aVar);
            return 0;
        }
        int b = b(i2);
        if (b < 0) {
            b = p();
        }
        if (b == -1) {
            if (size < 3) {
                a aVar2 = new a();
                aVar2.f7468a = 1;
                aVar2.b = i2;
                aVar2.c = i3;
                aVar2.e = i;
                aVar2.d = 0;
                this.c.add(aVar2);
                return size;
            }
            int size2 = this.c.size();
            if (b >= 0 && b < size2) {
                for (int i4 = 0; i4 < size2; i4++) {
                    if (i2 < this.c.get(i4).b) {
                        this.c.get(b).f7468a = 1;
                        this.c.get(b).b = i2;
                        this.c.get(b).c = i3;
                        this.c.get(b).e = i;
                        this.c.get(b).d = 0;
                    }
                }
            }
            return -1;
        }
        this.c.get(b).f7468a = 1;
        this.c.get(b).b = i2;
        this.c.get(b).c = i3;
        this.c.get(b).e = i;
        this.c.get(b).d = 0;
        return b;
    }

    private int d(int i, int i2, int i3) {
        int b = b(i2);
        if (b == -1 || b >= this.c.size()) {
            return -1;
        }
        this.c.get(b).f7468a = 2;
        this.c.get(b).b = i2;
        a aVar = this.c.get(b);
        if (i3 >= 95) {
            i3 = 100;
        }
        aVar.d = i3;
        return b;
    }

    public Bundle a(int i, int i2, int i3) {
        this.f7467a.clear();
        this.f7467a.putInt("updatetype", i);
        this.f7467a.putInt(RouteGuideParams.RGKey.AssistInfo.AssistType, i2);
        this.f7467a.putInt(RouteGuideParams.RGKey.AssistInfo.Speed, i3);
        Bundle bundle = new Bundle();
        bundle.putInt("key_assist_index", e(i, i2, i3));
        return bundle;
    }

    public void b(boolean z) {
        this.r = z;
    }

    public int e() {
        return this.p;
    }

    private int e(int i, int i2, int i3) {
        if (i == 1) {
            int a2 = a(i2, i3);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGAssistGuideModel", "AssistantIconUpdate UPDATE_TYPE_SHOW! nAssistType:" + i2 + ",nSpeed:" + i3);
            }
            return c(a2, i2, i3);
        }
        if (i == 2) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGAssistGuideModel", "AssistantIconUpdate UPDATE_TYPE_UPDATE! nAssistType:" + i2 + ",nSpeed:" + i3);
            }
            return d(0, i2, i3);
        }
        if (i != 3) {
            return -1;
        }
        com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar3.d()) {
            gVar3.e("RGAssistGuideModel", "AssistantIconUpdate UPDATE_TYPE_HIDE! nAssistType:" + i2 + ",nSpeed:" + i3);
        }
        return b(0, i2, i3);
    }

    public void b(double d) {
        if (d >= OOXIXo.f3760XO) {
            this.d = (int) a(d);
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGAssistGuideModel", "updateCurCarSpeed-> speed = " + d + ", mCurCarSpeed = " + this.d);
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements Comparable<a> {

        /* renamed from: a, reason: collision with root package name */
        public int f7468a;
        public int b;
        public int c;
        public int d;
        public int e;

        public a a() {
            a aVar = new a();
            aVar.f7468a = this.f7468a;
            aVar.b = this.b;
            aVar.c = this.c;
            aVar.d = this.d;
            aVar.e = this.e;
            return aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass() && this.b == ((a) obj).b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.b + 31;
        }

        public String toString() {
            return "AssistType: " + this.b + " SpeedLimit: " + this.c;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int i = this.b - aVar.b;
            if (i > 0) {
                return 1;
            }
            return i < 0 ? -1 : 0;
        }
    }

    public String b() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGAssistGuideModel", "isTunnelVdrMode = " + this.f + ", getCurCarSpeed = " + this.d + ", mCurVdrSpeed = " + this.e + ", isSpeedShowFromEngine = " + this.i);
        }
        if (this.f || !this.i) {
            return HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
        }
        return "" + this.d;
    }

    public a a(int i) {
        if (i < 0 || i >= this.c.size()) {
            return null;
        }
        return this.c.get(i);
    }

    public void a(float f) {
        if (f >= 0.0f) {
            this.e = (int) a(f);
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGAssistGuideModel", "updateCurVdrSpeed-> speed = " + f + ", mCurVdrSpeed = " + this.e);
        }
    }

    private int b(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.c.get(i2).b == i) {
                return i2;
            }
        }
        return -1;
    }

    public double a() {
        return this.j;
    }

    private int b(int i, int i2, int i3) {
        int b = b(i2);
        if (b != -1) {
            this.c.get(b).f7468a = 3;
        }
        return b;
    }

    public int a(int i, int i2) {
        return com.baidu.navisdk.module.pronavi.constant.a.a(i, i2);
    }
}
