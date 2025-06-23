package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.IdRes;

/* loaded from: classes11.dex */
public abstract class s extends d {
    protected ViewGroup sA;

    public final void a(ViewGroup viewGroup, @IdRes int i, @IdRes int i2) {
        if (this.sA != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i);
        if (viewStub != null) {
            this.sA = (ViewGroup) viewStub.inflate();
        } else {
            this.sA = (ViewGroup) viewGroup.findViewById(i2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public ViewGroup gG() {
        return this.sA;
    }
}
