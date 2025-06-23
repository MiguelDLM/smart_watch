package com.baidu.navisdk.ui.routeguide.model;

import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g0;

/* loaded from: classes8.dex */
public class f {
    private static final String y = "f";

    /* renamed from: a, reason: collision with root package name */
    public com.baidu.navisdk.ui.routeguide.mapmode.subview.m f8941a;
    public String b;
    public int c;
    public int d;
    public String e;
    public String f;
    public String g;
    public int h;
    public int i;
    public int j;
    public Drawable k;
    public int l;
    public g0.e m;
    public g0.d n;
    public String o;
    public com.baidu.navisdk.util.navimageloader.b p;
    public com.baidu.navisdk.util.navimageloader.e q;
    public int r;
    public int s;
    public Handler t;
    private c u;
    public int v;
    public CountDownTimer w;
    public int x;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1000) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(f.y, "AutoHide -> receiveAutoHideTime mHandler=" + toString() + ", mAutoHideTime=" + f.this.d + ", mView = " + f.this.f8941a.toString());
                }
                com.baidu.navisdk.ui.routeguide.control.s.T().b(f.this.f8941a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CountDownTimer {
        public b(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(f.y, "onFinish!!!");
            }
            cancel();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(f.y, "onTick --> millisUntilFinished = " + j);
            }
            f fVar = f.this;
            fVar.x = (int) j;
            com.baidu.navisdk.ui.routeguide.mapmode.subview.m mVar = fVar.f8941a;
            if (mVar != null) {
                mVar.a(j);
            } else {
                cancel();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void onClick(int i);
    }

    public f(com.baidu.navisdk.ui.routeguide.mapmode.subview.m mVar, String str, int i, int i2, String str2, String str3, String str4, int i3, int i4, int i5, Drawable drawable, int i6, g0.e eVar, g0.d dVar, String str5, com.baidu.navisdk.util.navimageloader.b bVar, com.baidu.navisdk.util.navimageloader.e eVar2, int i7, int i8, c cVar, int i9) {
        this.t = null;
        this.f8941a = mVar;
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = i3;
        this.i = i4;
        this.j = i5;
        this.k = drawable;
        this.l = i6;
        this.m = eVar;
        this.n = dVar;
        this.o = str5;
        this.p = bVar;
        this.q = eVar2;
        this.r = i7;
        this.s = i8;
        this.u = cVar;
        this.v = i9;
        this.t = new a(Looper.getMainLooper());
        int i10 = this.d;
        if (i10 > 0) {
            a(i10);
        }
    }

    private void a(int i) {
        if (i > 0) {
            this.w = new b(i, 1000L);
        }
    }

    public boolean b() {
        if (TextUtils.isEmpty(this.e) && TextUtils.isEmpty(this.f) && TextUtils.isEmpty(this.g)) {
            return false;
        }
        return true;
    }

    public void c() {
        this.f8941a = null;
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = null;
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = 0;
        this.s = -1;
        this.u = null;
        Handler handler = this.t;
        if (handler != null) {
            handler.removeMessages(1000);
        }
        this.t = null;
        this.v = 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(fVar.b)) {
                return this.b.equals(fVar.b);
            }
        }
        return super.equals(obj);
    }

    public String toString() {
        return "RGCommonNotificationModel{mID='" + this.b + "', mMainTitleText='" + this.e + "', mSubTitleText='" + this.f + "', mThirdTitleText='" + this.g + "', mThirdTitleColorId=" + this.j + ", mNotificationType=" + this.r + ", mSubTypeId=" + this.s + '}';
    }

    public c a() {
        return this.u;
    }
}
