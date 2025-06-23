package com.kwad.components.core.webview.tachikoma.c;

import android.view.View;
import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.components.m;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: classes11.dex */
public final class d extends Presenter {
    private FrameLayout Tr;
    private m Tx;
    private e Zt;
    protected b abk;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        b bVar = (b) Kf();
        this.abk = bVar;
        e eVar = bVar.Zt;
        this.Zt = eVar;
        if (eVar != null) {
            eVar.a(new com.kwad.components.core.webview.tachikoma.e.d() { // from class: com.kwad.components.core.webview.tachikoma.c.d.1
                @Override // com.kwad.components.core.webview.tachikoma.e.d
                public final void fS() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.e.d
                public final void ga() {
                }
            });
        }
        m a2 = this.abk.abn.a(null);
        this.Tx = a2;
        if (a2 == null) {
            this.abk.abm.callbackPageStatus(false, null);
            this.Zt.getDialog().dismiss();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View view = this.Tx.getView();
        view.setLayoutParams(layoutParams);
        this.Tr.addView(view);
        this.Tx.render();
        this.abk.abm.callbackPageStatus(true, null);
    }

    public final boolean onBackPressed() {
        m mVar = this.Tx;
        if (mVar != null && mVar.onBackPressed()) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Tr = (FrameLayout) findViewById(R.id.ksad_tk_dialog_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
