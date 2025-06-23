package com.baidu.nplatform.comapi.map.gesture;

import XIXIX.OOXIXo;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.baidu.nplatform.comapi.map.gesture.a;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private VelocityTracker f9507a;
    public final int b;
    public final int c;

    public c() {
        ViewConfiguration viewConfiguration = null;
        if (com.baidu.navisdk.framework.a.c().a() != null) {
            try {
                viewConfiguration = ViewConfiguration.get(com.baidu.navisdk.framework.a.c().a());
            } catch (Exception unused) {
            }
        }
        if (viewConfiguration == null) {
            this.c = ViewConfiguration.getMinimumFlingVelocity();
            this.b = ViewConfiguration.getMaximumFlingVelocity();
        } else {
            this.c = viewConfiguration.getScaledMinimumFlingVelocity();
            this.b = viewConfiguration.getScaledMaximumFlingVelocity();
        }
    }

    public void a() {
        VelocityTracker velocityTracker = this.f9507a;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f9507a = null;
        }
    }

    public void b() {
        this.f9507a = VelocityTracker.obtain();
    }

    public Pair<a.d, a.d> c() {
        VelocityTracker velocityTracker = this.f9507a;
        if (velocityTracker == null) {
            return new Pair<>(new a.d(OOXIXo.f3760XO, OOXIXo.f3760XO), new a.d(OOXIXo.f3760XO, OOXIXo.f3760XO));
        }
        velocityTracker.computeCurrentVelocity(1000, this.b);
        return new Pair<>(new a.d(this.f9507a.getXVelocity(0), this.f9507a.getYVelocity(0)), new a.d(this.f9507a.getXVelocity(1), this.f9507a.getYVelocity(1)));
    }

    public void a(MotionEvent motionEvent) {
        VelocityTracker velocityTracker = this.f9507a;
        if (velocityTracker == null) {
            this.f9507a = VelocityTracker.obtain();
        } else {
            velocityTracker.addMovement(motionEvent);
        }
    }
}
