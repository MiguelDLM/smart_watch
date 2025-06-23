package com.jd.ad.sdk.jad_gp;

/* loaded from: classes10.dex */
public final class jad_fs {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes10.dex */
    public class jad_an<T> implements jad_bo<T> {
        public volatile T jad_an;
        public final /* synthetic */ jad_bo jad_bo;

        public jad_an(jad_bo jad_boVar) {
            this.jad_bo = jad_boVar;
        }

        @Override // com.jd.ad.sdk.jad_gp.jad_fs.jad_bo
        public T get() {
            if (this.jad_an == null) {
                synchronized (this) {
                    try {
                        if (this.jad_an == null) {
                            this.jad_an = (T) jad_kx.jad_an(this.jad_bo.get());
                        }
                    } finally {
                    }
                }
            }
            return this.jad_an;
        }
    }

    /* loaded from: classes10.dex */
    public interface jad_bo<T> {
        T get();
    }

    public static <T> jad_bo<T> jad_an(jad_bo<T> jad_boVar) {
        return new jad_an(jad_boVar);
    }
}
