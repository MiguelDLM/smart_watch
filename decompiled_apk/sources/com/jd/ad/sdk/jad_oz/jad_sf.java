package com.jd.ad.sdk.jad_oz;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.jd.ad.sdk.jad_oz.jad_na;
import com.jd.ad.sdk.logger.Logger;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class jad_sf<Data> implements jad_na<Integer, Data> {
    public final jad_na<Uri, Data> jad_an;
    public final Resources jad_bo;

    /* loaded from: classes10.dex */
    public static final class jad_an implements jad_ob<Integer, AssetFileDescriptor> {
        public final Resources jad_an;

        public jad_an(Resources resources) {
            this.jad_an = resources;
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        public jad_na<Integer, AssetFileDescriptor> jad_an(jad_re jad_reVar) {
            return new jad_sf(this.jad_an, jad_reVar.jad_an(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_bo implements jad_ob<Integer, ParcelFileDescriptor> {
        public final Resources jad_an;

        public jad_bo(Resources resources) {
            this.jad_an = resources;
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        @NonNull
        public jad_na<Integer, ParcelFileDescriptor> jad_an(jad_re jad_reVar) {
            return new jad_sf(this.jad_an, jad_reVar.jad_an(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_cp implements jad_ob<Integer, InputStream> {
        public final Resources jad_an;

        public jad_cp(Resources resources) {
            this.jad_an = resources;
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        @NonNull
        public jad_na<Integer, InputStream> jad_an(jad_re jad_reVar) {
            return new jad_sf(this.jad_an, jad_reVar.jad_an(Uri.class, InputStream.class));
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_dq implements jad_ob<Integer, Uri> {
        public final Resources jad_an;

        public jad_dq(Resources resources) {
            this.jad_an = resources;
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        @NonNull
        public jad_na<Integer, Uri> jad_an(jad_re jad_reVar) {
            return new jad_sf(this.jad_an, jad_vi.jad_an);
        }
    }

    public jad_sf(Resources resources, jad_na<Uri, Data> jad_naVar) {
        this.jad_bo = resources;
        this.jad_an = jad_naVar;
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull Integer num) {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public jad_na.jad_an jad_an(@NonNull Integer num, int i, int i2, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        Uri uri;
        Integer num2 = num;
        try {
            uri = Uri.parse("android.resource://" + this.jad_bo.getResourcePackageName(num2.intValue()) + IOUtils.DIR_SEPARATOR_UNIX + this.jad_bo.getResourceTypeName(num2.intValue()) + IOUtils.DIR_SEPARATOR_UNIX + this.jad_bo.getResourceEntryName(num2.intValue()));
        } catch (Resources.NotFoundException e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Logger.w("ResourceLoader", "Received invalid resource id: " + num2, e);
            }
            uri = null;
        }
        if (uri == null) {
            return null;
        }
        return this.jad_an.jad_an(uri, i, i2, jad_jwVar);
    }
}
