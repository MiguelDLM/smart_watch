package com.kwad.components.ad.splashscreen.presenter.a;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.r;

/* loaded from: classes11.dex */
public abstract class c extends e implements j {
    private b FG;

    public void a(aw awVar) {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        int mc = mc();
        b bVar = new b(getContext(), mc, mc);
        this.FG = bVar;
        bVar.a((Activity) null, this.Di.mAdResultData, this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bG() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.Di.mRootContainer;
    }

    public int mc() {
        return 1000;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.FG.jq();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(m mVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
    }

    public void a(r rVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0809a c0809a) {
        String str = c0809a.WC;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1929947611:
                if (str.equals("adShowCallback")) {
                    c = 0;
                    break;
                }
                break;
            case -1291763712:
                if (str.equals("adDownloadConfirmTipCancel")) {
                    c = 1;
                    break;
                }
                break;
            case -1228923142:
                if (str.equals("adCloseCallback")) {
                    c = 2;
                    break;
                }
                break;
            case -532703741:
                if (str.equals("adDownloadConfirmTipShow")) {
                    c = 3;
                    break;
                }
                break;
            case -268512828:
                if (str.equals("adDownloadConfirmTipDismiss")) {
                    c = 4;
                    break;
                }
                break;
            case 1609027339:
                if (str.equals("adAutoCloseCallback")) {
                    c = 5;
                    break;
                }
                break;
            case 1699234957:
                if (str.equals("adShowErrorCallback")) {
                    c = 6;
                    break;
                }
                break;
            case 1852274314:
                if (str.equals("adClickCallback")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.Di.kG();
                return;
            case 1:
                this.Di.kL();
                return;
            case 2:
                this.Di.kI();
                return;
            case 3:
                this.Di.kK();
                return;
            case 4:
                this.Di.kM();
                return;
            case 5:
                this.Di.kH();
                return;
            case 6:
                this.Di.kF();
                return;
            case 7:
                this.Di.kJ();
                return;
            default:
                return;
        }
    }
}
