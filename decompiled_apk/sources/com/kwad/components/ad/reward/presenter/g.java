package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.core.i.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class g extends b implements a.InterfaceC0793a {
    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        boolean Eq = com.kwad.sdk.core.d.a.Eq();
        com.kwad.sdk.core.e.c.d("RewardInnerAdLoadPresenter", "onBind localCheckResult: " + Eq);
        SceneImpl sceneImpl = this.mAdTemplate.mAdScene;
        if (sceneImpl != null && Eq) {
            com.kwad.components.core.i.a.a(sceneImpl, this);
        }
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0793a
    public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
        if (list != null && list.size() != 0) {
            com.kwad.sdk.core.e.c.d("RewardInnerAdLoadPresenter", "onInnerAdLoad: " + list.size());
            AdTemplate adTemplate = list.get(0).getAdTemplate();
            boolean cw = com.kwad.sdk.core.response.b.b.cw(adTemplate);
            List<a.InterfaceC0793a> fJ = this.qp.fJ();
            if (cw) {
                com.kwad.sdk.core.d.a.e(com.kwad.sdk.core.response.b.b.ct(adTemplate), com.kwad.sdk.core.response.b.b.cu(adTemplate));
                if (fJ != null) {
                    Iterator<a.InterfaceC0793a> it = fJ.iterator();
                    while (it.hasNext()) {
                        it.next().e(list);
                    }
                }
            }
        }
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0793a
    public final void onError(int i, String str) {
        List<a.InterfaceC0793a> fJ = this.qp.fJ();
        if (fJ != null) {
            Iterator<a.InterfaceC0793a> it = fJ.iterator();
            while (it.hasNext()) {
                it.next().onError(i, str);
            }
        }
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0793a
    public final void onRequestResult(int i) {
        List<a.InterfaceC0793a> fJ = this.qp.fJ();
        if (fJ != null) {
            Iterator<a.InterfaceC0793a> it = fJ.iterator();
            while (it.hasNext()) {
                it.next().onRequestResult(i);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
