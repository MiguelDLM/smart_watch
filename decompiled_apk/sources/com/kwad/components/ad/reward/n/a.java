package com.kwad.components.ad.reward.n;

import android.content.Context;

/* loaded from: classes11.dex */
public class a implements b {
    private Context mContext;
    private com.kwad.components.ad.reward.g qp;

    public a(Context context, com.kwad.components.ad.reward.g gVar) {
        this.qp = gVar;
        this.mContext = context;
    }

    @Override // com.kwad.components.ad.reward.n.b
    public final void gK() {
        this.qp.a(1, this.mContext, 1, 1);
    }

    @Override // com.kwad.components.ad.reward.n.b
    public void ii() {
        this.qp.a(1, this.mContext, 13, 2);
    }

    @Override // com.kwad.components.ad.reward.n.b
    public void ij() {
        this.qp.a(1, this.mContext, 117, 2);
    }
}
