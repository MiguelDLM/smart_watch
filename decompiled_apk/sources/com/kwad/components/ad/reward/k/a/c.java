package com.kwad.components.ad.reward.k.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.c.f;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.sdk.components.r;

/* loaded from: classes11.dex */
public final class c extends com.kwad.components.core.webview.tachikoma.c.c implements e {
    private a xv;

    public final void a(com.kwad.components.ad.reward.c.b bVar) {
        a aVar = this.xv;
        if (aVar != null) {
            aVar.b(bVar);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a
    public final i hO() {
        this.xv = (a) this.abk;
        return new d(this.xv.jj(), this.xv.xt, getContext());
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        super.a(aVar);
        a aVar2 = this.xv;
        if (aVar2 == null || aVar2.jj() == null) {
            return;
        }
        this.xv.jj().oJ.bJ();
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(r rVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(rVar, bVar);
        rVar.c(new f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.k.a.c.1
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar2) {
                com.kwad.sdk.core.e.c.d("RewardTKDialogFragmentPresenter", "onUpdateExtraReward : " + bVar2.gP());
                c.this.a(bVar2);
            }
        }));
        rVar.c(new h(new n() { // from class: com.kwad.components.ad.reward.k.a.c.2
            @Override // com.kwad.components.core.webview.jshandler.n
            public final void a(h hVar, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    hVar.a(com.kwad.components.ad.reward.c.a.gM().gN());
                    com.kwad.components.ad.reward.c.a.gM().a(hVar);
                }
            }
        }));
    }
}
