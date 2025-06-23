package com.jd.ad.sdk.jad_oz;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_oz.jad_na;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes10.dex */
public class jad_wj<Data> implements jad_na<Uri, Data> {
    public static final Set<String> jad_bo = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));
    public final jad_cp<Data> jad_an;

    /* loaded from: classes10.dex */
    public static final class jad_an implements jad_ob<Uri, AssetFileDescriptor>, jad_cp<AssetFileDescriptor> {
        public final ContentResolver jad_an;

        public jad_an(ContentResolver contentResolver) {
            this.jad_an = contentResolver;
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_wj.jad_cp
        public com.jd.ad.sdk.jad_it.jad_dq<AssetFileDescriptor> jad_an(Uri uri) {
            return new com.jd.ad.sdk.jad_it.jad_an(this.jad_an, uri);
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        public jad_na<Uri, AssetFileDescriptor> jad_an(jad_re jad_reVar) {
            return new jad_wj(this);
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_bo implements jad_ob<Uri, ParcelFileDescriptor>, jad_cp<ParcelFileDescriptor> {
        public final ContentResolver jad_an;

        public jad_bo(ContentResolver contentResolver) {
            this.jad_an = contentResolver;
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_wj.jad_cp
        public com.jd.ad.sdk.jad_it.jad_dq<ParcelFileDescriptor> jad_an(Uri uri) {
            return new com.jd.ad.sdk.jad_it.jad_iv(this.jad_an, uri);
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        @NonNull
        public jad_na<Uri, ParcelFileDescriptor> jad_an(jad_re jad_reVar) {
            return new jad_wj(this);
        }
    }

    /* loaded from: classes10.dex */
    public interface jad_cp<Data> {
        com.jd.ad.sdk.jad_it.jad_dq<Data> jad_an(Uri uri);
    }

    /* loaded from: classes10.dex */
    public static class jad_dq implements jad_ob<Uri, InputStream>, jad_cp<InputStream> {
        public final ContentResolver jad_an;

        public jad_dq(ContentResolver contentResolver) {
            this.jad_an = contentResolver;
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_wj.jad_cp
        public com.jd.ad.sdk.jad_it.jad_dq<InputStream> jad_an(Uri uri) {
            return new com.jd.ad.sdk.jad_it.jad_ob(this.jad_an, uri);
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        @NonNull
        public jad_na<Uri, InputStream> jad_an(jad_re jad_reVar) {
            return new jad_wj(this);
        }
    }

    public jad_wj(jad_cp<Data> jad_cpVar) {
        this.jad_an = jad_cpVar;
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public jad_na.jad_an jad_an(@NonNull Uri uri, int i, int i2, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        Uri uri2 = uri;
        return new jad_na.jad_an(new com.jd.ad.sdk.jad_fo.jad_bo(uri2), Collections.emptyList(), this.jad_an.jad_an(uri2));
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public boolean jad_an(@NonNull Uri uri) {
        return jad_bo.contains(uri.getScheme());
    }
}
