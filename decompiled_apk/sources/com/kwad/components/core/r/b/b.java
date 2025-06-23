package com.kwad.components.core.r.b;

import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.proxy.c;
import com.kwad.sdk.R;
import com.kwad.sdk.components.m;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: classes11.dex */
public final class b extends Presenter {
    private FrameLayout Tr;
    private com.kwad.components.core.r.a.b Tu;
    private m Tx;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Tu = (com.kwad.components.core.r.a.b) Kf();
        this.Tr = (FrameLayout) findViewById(R.id.ksad_js_container);
        this.Tx = this.Tu.Tl.a(null);
        this.Tu.MU.add(new com.kwad.components.core.l.a.a() { // from class: com.kwad.components.core.r.b.b.1
            @Override // com.kwad.components.core.l.a.a
            public final void c(c cVar) {
            }

            @Override // com.kwad.components.core.l.a.a
            public final void d(c cVar) {
            }

            @Override // com.kwad.components.core.l.a.a
            public final void fQ() {
            }

            @Override // com.kwad.components.core.l.a.a
            public final void fR() {
                if (b.this.Tu.Tk != null) {
                    b.this.Tu.Tk.callbackDismiss();
                }
            }
        });
        if (this.Tx == null) {
            if (getActivity() != null) {
                getActivity().finish();
            }
        } else {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            View view = this.Tx.getView();
            view.setLayoutParams(layoutParams);
            this.Tr.addView(view);
            this.Tx.bindActivity(getActivity());
            this.Tx.render();
        }
    }

    public final boolean onBackPressed() {
        m mVar = this.Tx;
        if (mVar != null && mVar.onBackPressed()) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
