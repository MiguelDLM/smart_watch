package com.kwad.components.core.g;

import android.os.Handler;
import androidx.annotation.Nullable;

/* loaded from: classes11.dex */
public final class a implements Runnable {
    private long Mc = 1000;
    private boolean Md = true;
    private long Me = 0;
    private InterfaceC0789a Mf;

    @Nullable
    private volatile Handler fS;

    /* renamed from: com.kwad.components.core.g.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0789a {
        void y(long j);
    }

    public a(Handler handler) {
        this.fS = handler;
    }

    public final void a(InterfaceC0789a interfaceC0789a) {
        this.Mf = interfaceC0789a;
    }

    public final void destroy() {
        stop();
        this.fS = null;
    }

    public final void pause() {
        this.Md = true;
    }

    public final void resume() {
        this.Md = false;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        InterfaceC0789a interfaceC0789a;
        try {
            if (this.fS != null) {
                if (!this.Md && (interfaceC0789a = this.Mf) != null) {
                    interfaceC0789a.y(this.Me);
                    this.Me += this.Mc;
                }
                if (this.fS != null) {
                    this.fS.postDelayed(this, this.Mc);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void start() {
        this.Md = false;
        if (this.fS != null) {
            this.fS.post(this);
        }
    }

    public final void stop() {
        if (this.fS != null) {
            this.fS.removeCallbacks(this);
        }
    }
}
