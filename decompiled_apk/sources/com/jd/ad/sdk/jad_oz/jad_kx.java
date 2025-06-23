package com.jd.ad.sdk.jad_oz;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_it.jad_dq;
import com.jd.ad.sdk.jad_oz.jad_na;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;

/* loaded from: classes10.dex */
public final class jad_kx implements jad_na<Uri, File> {
    public final Context jad_an;

    /* loaded from: classes10.dex */
    public static final class jad_an implements jad_ob<Uri, File> {
        public final Context jad_an;

        public jad_an(Context context) {
            this.jad_an = context;
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        @NonNull
        public jad_na<Uri, File> jad_an(jad_re jad_reVar) {
            return new jad_kx(this.jad_an);
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_bo implements com.jd.ad.sdk.jad_it.jad_dq<File> {
        public static final String[] jad_cp = {"_data"};
        public final Context jad_an;
        public final Uri jad_bo;

        public jad_bo(Context context, Uri uri) {
            this.jad_an = context;
            this.jad_bo = uri;
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        @NonNull
        public Class<File> jad_an() {
            return File.class;
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        public void jad_bo() {
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
        public void jad_an(@NonNull com.jd.ad.sdk.jad_ep.jad_jt jad_jtVar, @NonNull jad_dq.jad_an<? super File> jad_anVar) {
            Cursor query = this.jad_an.getContentResolver().query(this.jad_bo, jad_cp, null, null, null);
            if (query != null) {
                try {
                    r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    query.close();
                }
            }
            if (!TextUtils.isEmpty(r0)) {
                jad_anVar.jad_an((jad_dq.jad_an<? super File>) new File(r0));
                return;
            }
            StringBuilder jad_an = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Failed to find file path for: ");
            jad_an.append(this.jad_bo);
            jad_anVar.jad_an((Exception) new FileNotFoundException(jad_an.toString()));
        }
    }

    public jad_kx(Context context) {
        this.jad_an = context;
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public jad_na.jad_an<File> jad_an(@NonNull Uri uri, int i, int i2, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        Uri uri2 = uri;
        return new jad_na.jad_an<>(new com.jd.ad.sdk.jad_fo.jad_bo(uri2), Collections.emptyList(), new jad_bo(this.jad_an, uri2));
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public boolean jad_an(@NonNull Uri uri) {
        return com.jd.ad.sdk.jad_ju.jad_bo.jad_an(uri);
    }
}
