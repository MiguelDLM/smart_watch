package com.jd.ad.sdk.jad_oz;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class jad_uh<Data> implements jad_na<String, Data> {
    public final jad_na<Uri, Data> jad_an;

    /* loaded from: classes10.dex */
    public static final class jad_an implements jad_ob<String, AssetFileDescriptor> {
        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        public jad_na<String, AssetFileDescriptor> jad_an(@NonNull jad_re jad_reVar) {
            return new jad_uh(jad_reVar.jad_an(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_bo implements jad_ob<String, ParcelFileDescriptor> {
        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        @NonNull
        public jad_na<String, ParcelFileDescriptor> jad_an(@NonNull jad_re jad_reVar) {
            return new jad_uh(jad_reVar.jad_an(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_cp implements jad_ob<String, InputStream> {
        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        @NonNull
        public jad_na<String, InputStream> jad_an(@NonNull jad_re jad_reVar) {
            return new jad_uh(jad_reVar.jad_an(Uri.class, InputStream.class));
        }
    }

    public jad_uh(jad_na<Uri, Data> jad_naVar) {
        this.jad_an = jad_naVar;
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull String str) {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:
    
        if (r0.getScheme() == null) goto L10;
     */
    @Override // com.jd.ad.sdk.jad_oz.jad_na
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.jd.ad.sdk.jad_oz.jad_na.jad_an jad_an(@androidx.annotation.NonNull java.lang.String r4, int r5, int r6, @androidx.annotation.NonNull com.jd.ad.sdk.jad_hs.jad_jw r7) {
        /*
            r3 = this;
            java.lang.String r4 = (java.lang.String) r4
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto Lb
            r0 = r1
            goto L28
        Lb:
            r0 = 0
            char r0 = r4.charAt(r0)
            r2 = 47
            if (r0 != r2) goto L15
            goto L1f
        L15:
            android.net.Uri r0 = android.net.Uri.parse(r4)
            java.lang.String r2 = r0.getScheme()
            if (r2 != 0) goto L28
        L1f:
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            android.net.Uri r0 = android.net.Uri.fromFile(r0)
        L28:
            if (r0 == 0) goto L39
            com.jd.ad.sdk.jad_oz.jad_na<android.net.Uri, Data> r4 = r3.jad_an
            boolean r4 = r4.jad_an(r0)
            if (r4 != 0) goto L33
            goto L39
        L33:
            com.jd.ad.sdk.jad_oz.jad_na<android.net.Uri, Data> r4 = r3.jad_an
            com.jd.ad.sdk.jad_oz.jad_na$jad_an r1 = r4.jad_an(r0, r5, r6, r7)
        L39:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_oz.jad_uh.jad_an(java.lang.Object, int, int, com.jd.ad.sdk.jad_hs.jad_jw):com.jd.ad.sdk.jad_oz.jad_na$jad_an");
    }
}
