package com.kwad.components.ad.reward.presenter.d;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.presenter.d.b.c;
import com.kwad.components.ad.reward.presenter.d.b.d;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* loaded from: classes11.dex */
public class a extends com.kwad.components.ad.reward.presenter.b implements g, j {
    public a() {
        ch();
    }

    private void ca() {
        this.qp.b(this);
        com.kwad.components.ad.reward.a.eY().a(this);
    }

    private void ea() {
        List<Presenter> Ke = Ke();
        if (Ke == null) {
            return;
        }
        for (Object obj : Ke) {
            if (obj instanceof c) {
                ((c) obj).iF();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ca();
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void bL() {
        ea();
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bY() {
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bZ() {
        ea();
    }

    public void ch() {
        a(new d());
        a(new com.kwad.components.ad.reward.presenter.d.b.a());
        a(new com.kwad.components.ad.reward.presenter.d.b.b());
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qp.c(this);
        com.kwad.components.ad.reward.a.eY().b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
