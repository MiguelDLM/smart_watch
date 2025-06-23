package com.baidu.navisdk.module.ar.utils;

import OXOo.OOXIXo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.module.ar.d;
import com.baidu.navisdk.module.ar.utils.b;
import java.util.Calendar;
import java.util.Observable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class a extends Observable implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private Handler f7005a;
    private boolean b;
    private final d c;

    /* renamed from: com.baidu.navisdk.module.ar.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0218a {
        private C0218a() {
        }

        public /* synthetic */ C0218a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new C0218a(null);
    }

    public a(@OOXIXo d mContext) {
        IIX0o.x0xO0oo(mContext, "mContext");
        this.c = mContext;
        this.b = true;
    }

    private final void d() {
        boolean a2 = a();
        com.baidu.navisdk.module.ar.util.a.a("BNARDayNightLooper", "自动切换 -> isDay = " + this.b + ", day" + a2);
        if (this.b != a2) {
            this.b = a2;
            setChanged();
            notifyObservers(Boolean.valueOf(this.b));
        }
    }

    public final boolean a() {
        com.baidu.navisdk.module.ar.util.a.a("BNARDayNightLooper", "自动切换 -> isDay = " + this.c.c() + " ," + this.c.d());
        b.c riseDown = b.a().a(this.c.c(), this.c.d());
        long currentTimeMillis = System.currentTimeMillis();
        Calendar c = Calendar.getInstance();
        IIX0o.oO(riseDown, "riseDown");
        c.set(11, riseDown.a());
        c.set(12, riseDown.b());
        IIX0o.oO(c, "c");
        long timeInMillis = c.getTimeInMillis();
        c.set(11, riseDown.c());
        c.set(12, riseDown.d());
        if (c.getTimeInMillis() + 1 <= currentTimeMillis && timeInMillis > currentTimeMillis) {
            return true;
        }
        return false;
    }

    public final void b() {
        if (this.f7005a == null) {
            this.f7005a = new Handler(Looper.getMainLooper(), this);
        }
        Handler handler = this.f7005a;
        if (handler != null) {
            handler.removeMessages(1);
        }
        Handler handler2 = this.f7005a;
        if (handler2 != null) {
            handler2.sendEmptyMessageDelayed(1, 60000);
        }
    }

    public final void c() {
        Handler handler = this.f7005a;
        if (handler == null) {
            return;
        }
        handler.removeMessages(1);
        Handler handler2 = this.f7005a;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        this.f7005a = null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@OOXIXo Message msg) {
        IIX0o.x0xO0oo(msg, "msg");
        try {
            d();
        } catch (Throwable unused) {
        }
        Handler handler = this.f7005a;
        if (handler != null) {
            handler.removeMessages(1);
        }
        Handler handler2 = this.f7005a;
        if (handler2 != null) {
            handler2.sendEmptyMessageDelayed(1, 60000);
        }
        return true;
    }
}
