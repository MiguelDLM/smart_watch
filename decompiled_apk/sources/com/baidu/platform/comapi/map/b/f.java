package com.baidu.platform.comapi.map.b;

import XIXIX.OOXIXo;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.map.b.a;

/* loaded from: classes8.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final int f9654a;
    public final int b;
    private VelocityTracker c;

    public f() {
        if (JNIInitializer.getCachedContext() == null) {
            this.b = ViewConfiguration.getMinimumFlingVelocity();
            this.f9654a = ViewConfiguration.getMaximumFlingVelocity();
            return;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(JNIInitializer.getCachedContext());
        if (viewConfiguration == null) {
            this.b = ViewConfiguration.getMinimumFlingVelocity();
            this.f9654a = ViewConfiguration.getMaximumFlingVelocity();
        } else {
            this.b = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f9654a = viewConfiguration.getScaledMaximumFlingVelocity();
        }
    }

    public void a() {
        this.c = VelocityTracker.obtain();
    }

    public void b() {
        VelocityTracker velocityTracker = this.c;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.c = null;
        }
    }

    public Pair<a.d, a.d> c() {
        VelocityTracker velocityTracker = this.c;
        if (velocityTracker == null) {
            return new Pair<>(new a.d(OOXIXo.f3760XO, OOXIXo.f3760XO), new a.d(OOXIXo.f3760XO, OOXIXo.f3760XO));
        }
        velocityTracker.computeCurrentVelocity(1000, this.f9654a);
        return new Pair<>(new a.d(this.c.getXVelocity(0), this.c.getYVelocity(0)), new a.d(this.c.getXVelocity(1), this.c.getYVelocity(1)));
    }

    public void a(MotionEvent motionEvent) {
        VelocityTracker velocityTracker = this.c;
        if (velocityTracker == null) {
            this.c = VelocityTracker.obtain();
        } else {
            velocityTracker.addMovement(motionEvent);
        }
    }
}
