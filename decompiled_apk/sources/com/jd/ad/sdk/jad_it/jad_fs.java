package com.jd.ad.sdk.jad_it;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_it.jad_er;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class jad_fs {
    public static final jad_er.jad_an<?> jad_bo = new jad_an();
    public final Map<Class<?>, jad_er.jad_an<?>> jad_an = new HashMap();

    /* loaded from: classes10.dex */
    public class jad_an implements jad_er.jad_an<Object> {
        @Override // com.jd.ad.sdk.jad_it.jad_er.jad_an
        @NonNull
        public jad_er<Object> jad_an(@NonNull Object obj) {
            return new jad_bo(obj);
        }

        @Override // com.jd.ad.sdk.jad_it.jad_er.jad_an
        @NonNull
        public Class<Object> jad_an() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    /* loaded from: classes10.dex */
    public static final class jad_bo implements jad_er<Object> {
        public final Object jad_an;

        public jad_bo(@NonNull Object obj) {
            this.jad_an = obj;
        }

        @Override // com.jd.ad.sdk.jad_it.jad_er
        @NonNull
        public Object jad_an() {
            return this.jad_an;
        }

        @Override // com.jd.ad.sdk.jad_it.jad_er
        public void jad_bo() {
        }
    }
}
