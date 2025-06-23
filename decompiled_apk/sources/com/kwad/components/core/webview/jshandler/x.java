package com.kwad.components.core.webview.jshandler;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class x implements com.kwad.sdk.core.webview.c.a {
    protected final com.kwad.sdk.core.webview.b WQ;
    private int Xc;
    private boolean Xd;
    private final boolean Xe;
    private boolean Xf;
    private List<com.kwad.components.core.e.d.c> Xg;
    private boolean Xh;

    @Nullable
    private com.kwad.sdk.core.webview.d.a.a cR;

    @Nullable
    private DialogInterface.OnDismissListener xC;

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z, int i, boolean z2, boolean z3) {
        this.Xd = false;
        this.Xg = new ArrayList();
        this.Xd = z;
        this.WQ = bVar;
        this.Xc = i;
        if (cVar != null) {
            cVar.as(1);
            this.Xg.add(cVar);
        }
        this.cR = aVar;
        this.Xe = z2;
        this.Xh = z3;
    }

    private static boolean aB(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.b.e.dN(adTemplate) == 13) {
            return true;
        }
        return false;
    }

    @Nullable
    public final com.kwad.components.core.e.d.c J(long j) {
        List<com.kwad.components.core.e.d.c> list = this.Xg;
        if (list == null) {
            return null;
        }
        if (j < 0 && list.size() == 1) {
            return this.Xg.get(0);
        }
        for (com.kwad.components.core.e.d.c cVar : this.Xg) {
            if (com.kwad.sdk.core.response.b.e.ec(cVar.oB()) == j) {
                return cVar;
            }
        }
        return null;
    }

    public void K(int i) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickAction";
    }

    public void ji() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.cR = null;
    }

    public static /* synthetic */ boolean a(x xVar, com.kwad.sdk.core.webview.d.b.a aVar) {
        return b(aVar);
    }

    private static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        return aVar.Yn == 1;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        if (this.WQ.Hx() && aVar.adTemplate == null) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        if (this.WQ.aEY && !aVar.aGb) {
            bo.runOnUiThread(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.x.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    String str2;
                    boolean z;
                    TKAdLiveShopItemInfo tKAdLiveShopItemInfo;
                    com.kwad.sdk.core.webview.b bVar = x.this.WQ;
                    if (!bVar.aEZ) {
                        return;
                    }
                    com.kwad.sdk.core.webview.d.b.a aVar2 = aVar;
                    AdTemplate adTemplate = aVar2.adTemplate;
                    if (adTemplate != null) {
                        x.this.Xg.add(new com.kwad.components.core.e.d.c(adTemplate));
                    } else if (aVar2.creativeId >= 0) {
                        List<AdTemplate> Hw = bVar.Hw();
                        com.kwad.sdk.core.webview.d.b.a aVar3 = aVar;
                        adTemplate = com.kwad.sdk.core.response.b.e.a(Hw, aVar3.creativeId, aVar3.adStyle);
                    } else {
                        adTemplate = bVar.getAdTemplate();
                        aVar.creativeId = com.kwad.sdk.core.response.b.e.ec(adTemplate);
                        aVar.adStyle = com.kwad.sdk.core.response.b.e.dN(adTemplate);
                    }
                    com.kwad.components.core.e.d.c J = x.this.J(aVar.creativeId);
                    if (x.this.xC != null && J != null) {
                        J.setOnDismissListener(x.this.xC);
                    }
                    if (!TextUtils.isEmpty(aVar.Lt)) {
                        try {
                            str2 = com.kwad.components.core.e.b.a.t(Long.parseLong(aVar.Lt));
                        } catch (Exception unused) {
                            str2 = aVar.Lt;
                        }
                    } else if (adTemplate != null && (tKAdLiveShopItemInfo = adTemplate.tkLiveShopItemInfo) != null) {
                        str2 = tKAdLiveShopItemInfo.itemId;
                    } else {
                        str2 = null;
                    }
                    a.C0788a am = new a.C0788a(x.this.WQ.Ph.getContext()).ar(adTemplate).b(J).ag(str2).ao(x.a(x.this, aVar)).ap(x.this.Xd).c(x.this.WQ.mReportExtData).an(aVar.Yn).al(aVar.aGa).am(aVar.kl);
                    if (!x.this.Xe && !aVar.Lf) {
                        z = false;
                    } else {
                        z = true;
                    }
                    x.this.K(com.kwad.components.core.e.d.a.a(x.this.a(am.aq(z).ar(x.this.Xc).al(x.this.Xh).as(x.this.Xf).aw(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.x.1.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            x.this.ji();
                            if (x.this.cR != null) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                if (!aVar.aGc) {
                                    x.this.cR.a(aVar);
                                }
                            }
                        }
                    }), aVar, adTemplate)));
                }
            });
        } else if (this.cR != null) {
            bo.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.x.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (x.this.cR != null && !aVar.aGc) {
                        x.this.cR.a(aVar);
                    }
                }
            });
        }
        cVar.a(null);
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        this(bVar, cVar, aVar, false, 0, false, false);
        this.xC = onDismissListener;
    }

    public a.C0788a a(a.C0788a c0788a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        com.kwad.sdk.core.webview.d.b.c cVar;
        int i;
        com.kwad.sdk.core.webview.d.b.c cVar2 = aVar.Yo;
        if (cVar2 != null && !TextUtils.isEmpty(cVar2.Lh)) {
            c0788a.ah(aVar.Yo.Lh);
        }
        com.kwad.sdk.core.webview.d.b.c cVar3 = aVar.Yo;
        if (cVar3 != null && (i = cVar3.aGd) != 0) {
            c0788a.ap(i);
        }
        if (aB(adTemplate) && (cVar = aVar.Yo) != null && cVar.aGe != null) {
            ac.a aVar2 = new ac.a();
            com.kwad.sdk.core.webview.d.b.b bVar = aVar.Yo.aGe;
            aVar2.g((float) bVar.x, (float) bVar.y);
            com.kwad.sdk.core.webview.d.b.b bVar2 = aVar.Yo.aGe;
            aVar2.f((float) bVar2.x, (float) bVar2.y);
            com.kwad.sdk.core.webview.d.b.b bVar3 = aVar.Yo.aGe;
            aVar2.z(bVar3.width, bVar3.height);
            c0788a.d(aVar2);
        } else {
            com.kwad.sdk.widget.e eVar = this.WQ.aEW;
            if (eVar != null) {
                c0788a.d(eVar.getTouchCoords());
            }
        }
        c0788a.a(null, null, null);
        return c0788a;
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, cVar, aVar, false, 0, false, false);
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z) {
        this(bVar, cVar, aVar, false, 0, false, false);
        this.Xf = true;
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, int i, boolean z) {
        this(bVar, cVar, null, false, 2, z, false);
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, int i) {
        this(bVar, cVar, aVar, false, 1, false, false);
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable List<com.kwad.components.core.e.d.c> list, @Nullable com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, null, aVar, false, 0, false, false);
        if (list != null) {
            this.Xg.addAll(list);
        }
    }
}
