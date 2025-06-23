package com.kwad.components.core.widget.a;

import android.os.Message;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.bs;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public abstract class a implements com.kwad.sdk.core.h.a, bs.a {
    private Set<c> adh;
    private final int adi;
    private final View mRootView;
    private final AtomicBoolean adg = new AtomicBoolean(false);
    protected final bs hh = new bs(this);

    public a(@NonNull View view, int i) {
        this.mRootView = view;
        this.adi = i;
    }

    private void aZ(boolean z) {
        Set<c> set = this.adh;
        if (set == null) {
            return;
        }
        for (c cVar : set) {
            if (cVar != null) {
                if (z) {
                    cVar.aM();
                } else {
                    cVar.aN();
                }
            }
        }
    }

    private void iZ() {
        if (!this.adg.getAndSet(true)) {
            aZ(true);
        }
    }

    private void tZ() {
        if (dX()) {
            iZ();
        } else {
            uc();
        }
    }

    private void uc() {
        if (this.adg.getAndSet(false)) {
            aZ(false);
        }
    }

    @Override // com.kwad.sdk.utils.bs.a
    public final void a(Message message) {
        if (message.what == 666) {
            tZ();
            this.hh.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, 500L);
        }
    }

    @Override // com.kwad.sdk.core.h.a
    @MainThread
    public final void b(c cVar) {
        Set<c> set;
        ai.checkUiThread();
        if (cVar != null && (set = this.adh) != null) {
            set.remove(cVar);
        }
    }

    public abstract boolean dX();

    @Override // com.kwad.sdk.core.h.a
    @CallSuper
    public final void release() {
        ub();
        Set<c> set = this.adh;
        if (set != null) {
            set.clear();
        }
    }

    public final void ua() {
        this.hh.removeMessages(TTAdConstant.STYLE_SIZE_RADIO_2_3);
        this.hh.sendEmptyMessage(TTAdConstant.STYLE_SIZE_RADIO_2_3);
    }

    public final void ub() {
        tZ();
        this.hh.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.h.a
    @MainThread
    public final boolean ud() {
        return this.adg.get();
    }

    @Override // com.kwad.sdk.core.h.a
    @MainThread
    public final void a(final c cVar) {
        ai.checkUiThread();
        if (cVar == null) {
            return;
        }
        bo.postOnUiThread(new az() { // from class: com.kwad.components.core.widget.a.a.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                if (a.this.dX()) {
                    cVar.aM();
                } else {
                    cVar.aN();
                }
            }
        });
        if (this.adh == null) {
            this.adh = new HashSet();
        }
        this.adh.add(cVar);
    }
}
