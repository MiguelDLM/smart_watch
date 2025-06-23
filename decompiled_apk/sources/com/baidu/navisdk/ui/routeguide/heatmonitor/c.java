package com.baidu.navisdk.ui.routeguide.heatmonitor;

import android.view.Choreographer;
import java.util.concurrent.TimeUnit;

/* loaded from: classes8.dex */
public class c implements Choreographer.FrameCallback {
    private a c;

    /* renamed from: a, reason: collision with root package name */
    private long f8618a = 0;
    private int b = 0;
    private boolean d = false;

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i);
    }

    public void a() {
        this.d = true;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void b() {
        this.d = false;
        Choreographer.getInstance().removeFrameCallback(this);
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.f8618a == 0) {
            this.f8618a = j;
        }
        if (j - this.f8618a > TimeUnit.NANOSECONDS.convert(1000L, TimeUnit.MILLISECONDS)) {
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(this.b);
            }
            this.f8618a = j;
            this.b = 1;
        }
        this.b++;
        if (this.d) {
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void a(a aVar) {
        this.c = aVar;
    }
}
