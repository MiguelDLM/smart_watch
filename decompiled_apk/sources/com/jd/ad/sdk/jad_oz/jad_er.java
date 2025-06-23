package com.jd.ad.sdk.jad_oz;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_it.jad_dq;
import com.jd.ad.sdk.jad_oz.jad_na;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

/* loaded from: classes10.dex */
public final class jad_er<Model, Data> implements jad_na<Model, Data> {
    public final jad_an<Data> jad_an;

    /* loaded from: classes10.dex */
    public interface jad_an<Data> {
    }

    /* loaded from: classes10.dex */
    public static final class jad_bo<Data> implements com.jd.ad.sdk.jad_it.jad_dq<Data> {
        public final String jad_an;
        public final jad_an<Data> jad_bo;
        public Data jad_cp;

        public jad_bo(String str, jad_an<Data> jad_anVar) {
            this.jad_an = str;
            this.jad_bo = jad_anVar;
        }

        /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, Data] */
        @Override // com.jd.ad.sdk.jad_it.jad_dq
        public void jad_an(@NonNull com.jd.ad.sdk.jad_ep.jad_jt jad_jtVar, @NonNull jad_dq.jad_an<? super Data> jad_anVar) {
            try {
                ?? r2 = (Data) ((jad_cp.jad_an) this.jad_bo).jad_an(this.jad_an);
                this.jad_cp = r2;
                jad_anVar.jad_an((jad_dq.jad_an<? super Data>) r2);
            } catch (IllegalArgumentException e) {
                jad_anVar.jad_an((Exception) e);
            }
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        public void jad_bo() {
            try {
                jad_an<Data> jad_anVar = this.jad_bo;
                Data data = this.jad_cp;
                ((jad_cp.jad_an) jad_anVar).getClass();
                ((InputStream) data).close();
            } catch (IOException unused) {
            }
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        public void jad_cp() {
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        @NonNull
        public com.jd.ad.sdk.jad_hs.jad_an jad_dq() {
            return com.jd.ad.sdk.jad_hs.jad_an.LOCAL;
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        @NonNull
        public Class<Data> jad_an() {
            ((jad_cp.jad_an) this.jad_bo).getClass();
            return InputStream.class;
        }
    }

    /* loaded from: classes10.dex */
    public static final class jad_cp<Model> implements jad_ob<Model, InputStream> {
        public final jad_an<InputStream> jad_an = new jad_an(this);

        /* loaded from: classes10.dex */
        public class jad_an implements jad_an<InputStream> {
            public jad_an(jad_cp jad_cpVar) {
            }

            public Object jad_an(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf != -1) {
                        if (str.substring(0, indexOf).endsWith(";base64")) {
                            return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                        }
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                throw new IllegalArgumentException("Not a valid image data URL.");
            }
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        @NonNull
        public jad_na<Model, InputStream> jad_an(@NonNull jad_re jad_reVar) {
            return new jad_er(this.jad_an);
        }
    }

    public jad_er(jad_an<Data> jad_anVar) {
        this.jad_an = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public boolean jad_an(@NonNull Model model) {
        return model.toString().startsWith("data:image");
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public jad_na.jad_an<Data> jad_an(@NonNull Model model, int i, int i2, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        return new jad_na.jad_an<>(new com.jd.ad.sdk.jad_fo.jad_bo(model), Collections.emptyList(), new jad_bo(model.toString(), this.jad_an));
    }
}
