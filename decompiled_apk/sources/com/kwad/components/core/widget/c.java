package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.bs;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes11.dex */
public final class c extends View implements bs.a {
    private View Vt;
    private final AtomicBoolean Vu;
    private boolean abQ;
    private boolean abR;
    private a ack;
    private boolean acl;
    private final int acm;
    private final bs hh;

    /* loaded from: classes11.dex */
    public interface a {
        void er();
    }

    public c(Context context, View view) {
        super(context);
        this.hh = new bs(this);
        this.Vu = new AtomicBoolean(true);
        this.acm = (int) (com.kwad.sdk.core.config.d.CV() * 100.0f);
        this.Vt = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void tK() {
        if (this.abR) {
            this.hh.removeCallbacksAndMessages(null);
            this.abR = false;
        }
    }

    private void tL() {
        if (this.acl && !this.abR) {
            this.abR = true;
            this.hh.sendEmptyMessage(1);
        }
    }

    private void tP() {
        this.Vu.getAndSet(false);
    }

    private void tQ() {
        this.Vu.getAndSet(true);
    }

    @Override // com.kwad.sdk.utils.bs.a
    public final void a(Message message) {
        a aVar;
        int i = message.what;
        if (i != 1) {
            if (i == 2) {
                if (!br.a(this.Vt, this.acm, false)) {
                    if (!this.abQ) {
                        setNeedCheckingShow(true);
                        return;
                    }
                    return;
                } else {
                    if (message.arg1 == 1000 && (aVar = this.ack) != null) {
                        aVar.er();
                    }
                    this.hh.sendEmptyMessageDelayed(2, 500L);
                    return;
                }
            }
            return;
        }
        com.kwad.sdk.core.e.c.d("EmptyView", "handleMsg MSG_CHECKING");
        if (this.abR) {
            if (br.a(this.Vt, this.acm, false)) {
                tK();
                Message obtainMessage = this.hh.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 1000;
                this.hh.sendMessageDelayed(obtainMessage, 1000L);
                return;
            }
            this.hh.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.e.c.d("EmptyView", "onAttachedToWindow:" + this);
        tL();
        this.abQ = false;
        tP();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.e.c.d("EmptyView", "onDetachedFromWindow" + this);
        tK();
        this.abQ = true;
        tQ();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.e.c.d("EmptyView", "onFinishTemporaryDetach:" + this.Vt.getParent());
        tP();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.e.c.d("EmptyView", "onStartTemporaryDetach:" + this.Vt.getParent());
        tQ();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.kwad.sdk.core.e.c.d("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.kwad.sdk.core.e.c.d("EmptyView", "onWindowVisibilityChanged visibility:" + i);
    }

    public final void setNeedCheckingShow(boolean z) {
        this.acl = z;
        if (!z && this.abR) {
            tK();
        } else if (z && !this.abR) {
            tL();
        }
    }

    public final void setViewCallback(a aVar) {
        this.ack = aVar;
    }
}
