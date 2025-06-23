package com.kwad.components.ad.interstitial.f;

import android.app.Activity;
import android.content.DialogInterface;
import com.kwad.components.ad.interstitial.d;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a {
    public static boolean d(final c cVar) {
        Activity ownerActivity;
        d dVar = cVar.f18436io;
        if (dVar != null && (ownerActivity = dVar.getOwnerActivity()) != null && !ownerActivity.isFinishing()) {
            AdInfo dS = e.dS(cVar.mAdTemplate);
            int cM = com.kwad.components.ad.interstitial.c.b.cM();
            int cN = com.kwad.components.ad.interstitial.c.b.cN();
            if (cM > com.kwad.sdk.core.response.b.a.co(dS) && cN < com.kwad.sdk.core.response.b.a.cp(dS)) {
                if (com.kwad.sdk.core.response.b.a.cq(dS) == 2) {
                    com.kwad.components.ad.interstitial.g.b.e(cVar);
                    return true;
                }
                if (com.kwad.sdk.core.response.b.a.cq(dS) == 1) {
                    new com.kwad.components.core.page.widget.a(ownerActivity, com.kwad.sdk.core.response.b.a.cr(dS), new a.InterfaceC0803a() { // from class: com.kwad.components.ad.interstitial.f.a.1
                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0803a
                        public final void a(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.adlog.c.c(c.this.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cR(8));
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0803a
                        public final void b(DialogInterface dialogInterface) {
                            c cVar2 = c.this;
                            cVar2.a(false, -1, cVar2.eN);
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.adlog.c.e(c.this.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cM(151).cR(8));
                            c.this.f18436io.dismiss();
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0803a
                        public final void c(DialogInterface dialogInterface) {
                        }
                    }).show();
                    com.kwad.sdk.core.adlog.c.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.adlog.c.b().cM(149).cR(8));
                    return true;
                }
            }
        }
        return false;
    }
}
