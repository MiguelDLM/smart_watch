package com.octopus.ad.internal;

import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes11.dex */
public class oO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public View f18648II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public ScheduledExecutorService f18649X0o0xo;

    /* renamed from: oxoX, reason: collision with root package name */
    public Runnable f18651oxoX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f18650oIX0oI = false;

    /* renamed from: I0Io, reason: collision with root package name */
    public ArrayList<I0Io> f18647I0Io = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface I0Io {
        void a(boolean z);
    }

    /* loaded from: classes11.dex */
    public class II0xO0 implements Runnable {
        public II0xO0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            oO.this.f18648II0xO0.post(oO.this.f18651oxoX);
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (oO.this.f18647I0Io != null) {
                ArrayList arrayList = new ArrayList();
                Iterator it = oO.this.f18647I0Io.iterator();
                while (it.hasNext()) {
                    arrayList.add((I0Io) it.next());
                }
                if (oO.this.xxIXOIIO()) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        ((I0Io) it2.next()).a(true);
                    }
                } else {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        ((I0Io) it3.next()).a(false);
                    }
                }
            }
        }
    }

    public oO(View view) {
        this.f18648II0xO0 = view;
        XO();
    }

    public static oO II0xO0(View view) {
        if (view == null) {
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18703ooOOo0oXI, "Unable to check visibility");
            return null;
        }
        return new oO(view);
    }

    public boolean Oxx0IOOO(I0Io i0Io) {
        return this.f18647I0Io.remove(i0Io);
    }

    public void XO() {
        if (this.f18650oIX0oI) {
            return;
        }
        this.f18650oIX0oI = true;
        this.f18651oxoX = new oIX0oI();
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f18649X0o0xo = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleAtFixedRate(new II0xO0(), 0L, 250L, TimeUnit.MILLISECONDS);
    }

    public View oIX0oI() {
        return this.f18648II0xO0;
    }

    public void oxoX(I0Io i0Io) {
        if (i0Io != null) {
            this.f18647I0Io.add(i0Io);
        }
    }

    public void xoIox() {
        ScheduledExecutorService scheduledExecutorService = this.f18649X0o0xo;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        View view = this.f18648II0xO0;
        if (view != null) {
            view.removeCallbacks(this.f18651oxoX);
            this.f18648II0xO0 = null;
        }
        this.f18647I0Io = null;
    }

    public boolean xxIXOIIO() {
        View view = this.f18648II0xO0;
        if (view == null || view.getVisibility() != 0 || this.f18648II0xO0.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        if (!this.f18648II0xO0.getGlobalVisibleRect(rect)) {
            return false;
        }
        int height = rect.height() * rect.width();
        int height2 = this.f18648II0xO0.getHeight() * this.f18648II0xO0.getWidth();
        if (height2 <= 0 || height * 100 < height2 * 50) {
            return false;
        }
        return true;
    }
}
