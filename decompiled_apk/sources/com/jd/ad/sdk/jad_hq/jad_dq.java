package com.jd.ad.sdk.jad_hq;

import androidx.annotation.NonNull;

/* loaded from: classes10.dex */
public abstract class jad_dq {

    /* loaded from: classes10.dex */
    public static class jad_bo extends jad_dq {
        public volatile boolean jad_an;

        public jad_bo() {
            super();
        }

        @Override // com.jd.ad.sdk.jad_hq.jad_dq
        public void jad_bo() {
            if (this.jad_an) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public jad_dq() {
    }

    @NonNull
    public static jad_dq jad_an() {
        return new jad_bo();
    }

    public abstract void jad_bo();
}
