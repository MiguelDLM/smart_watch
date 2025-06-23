package com.kwad.sdk.components;

import java.io.Serializable;

/* loaded from: classes11.dex */
public interface DevelopMangerComponents extends a {

    /* loaded from: classes11.dex */
    public static class DevelopValue implements Serializable {
        private static final long serialVersionUID = 2793333073373146040L;
        Serializable mValue;

        public DevelopValue(Serializable serializable) {
            this.mValue = serializable;
        }

        public <T> T getValue() {
            T t = (T) this.mValue;
            if (t != null) {
                return t;
            }
            return null;
        }
    }

    String BG();
}
