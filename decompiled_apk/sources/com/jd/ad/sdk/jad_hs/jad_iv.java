package com.jd.ad.sdk.jad_hs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.security.MessageDigest;

/* loaded from: classes10.dex */
public final class jad_iv<T> {
    public static final jad_bo<Object> jad_er = new jad_an();
    public final T jad_an;
    public final jad_bo<T> jad_bo;
    public final String jad_cp;
    public volatile byte[] jad_dq;

    /* loaded from: classes10.dex */
    public class jad_an implements jad_bo<Object> {
        @Override // com.jd.ad.sdk.jad_hs.jad_iv.jad_bo
        public void jad_an(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }

    /* loaded from: classes10.dex */
    public interface jad_bo<T> {
        void jad_an(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    public jad_iv(@NonNull String str, @Nullable T t, @NonNull jad_bo<T> jad_boVar) {
        this.jad_cp = com.jd.ad.sdk.jad_gp.jad_kx.jad_an(str);
        this.jad_an = t;
        this.jad_bo = (jad_bo) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_boVar);
    }

    @NonNull
    public static <T> jad_iv<T> jad_an(@NonNull String str, @NonNull T t) {
        return new jad_iv<>(str, t, jad_er);
    }

    public boolean equals(Object obj) {
        if (obj instanceof jad_iv) {
            return this.jad_cp.equals(((jad_iv) obj).jad_cp);
        }
        return false;
    }

    public int hashCode() {
        return this.jad_cp.hashCode();
    }

    public String toString() {
        StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Option{key='");
        jad_an2.append(this.jad_cp);
        jad_an2.append('\'');
        jad_an2.append('}');
        return jad_an2.toString();
    }
}
