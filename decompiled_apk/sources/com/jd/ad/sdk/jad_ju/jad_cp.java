package com.jd.ad.sdk.jad_ju;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.jd.ad.sdk.jad_ep.jad_jt;
import com.jd.ad.sdk.jad_it.jad_dq;
import com.jd.ad.sdk.logger.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class jad_cp implements com.jd.ad.sdk.jad_it.jad_dq<InputStream> {
    public final Uri jad_an;
    public final jad_er jad_bo;
    public InputStream jad_cp;

    /* loaded from: classes10.dex */
    public static class jad_an implements jad_dq {
        public static final String[] jad_bo = {"_data"};
        public final ContentResolver jad_an;

        public jad_an(ContentResolver contentResolver) {
            this.jad_an = contentResolver;
        }

        @Override // com.jd.ad.sdk.jad_ju.jad_dq
        public Cursor jad_an(Uri uri) {
            return this.jad_an.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, jad_bo, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_bo implements jad_dq {
        public static final String[] jad_bo = {"_data"};
        public final ContentResolver jad_an;

        public jad_bo(ContentResolver contentResolver) {
            this.jad_an = contentResolver;
        }

        @Override // com.jd.ad.sdk.jad_ju.jad_dq
        public Cursor jad_an(Uri uri) {
            return this.jad_an.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, jad_bo, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    public jad_cp(Uri uri, jad_er jad_erVar) {
        this.jad_an = uri;
        this.jad_bo = jad_erVar;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_dq
    @NonNull
    public Class<InputStream> jad_an() {
        return InputStream.class;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_dq
    public void jad_bo() {
        InputStream inputStream = this.jad_cp;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
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

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0054, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002a, code lost:
    
        if (r8 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0052, code lost:
    
        if (r8 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0057, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0025: MOVE (r7 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]) (LINE:38), block:B:68:0x0025 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0105  */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.InputStream jad_er() {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_ju.jad_cp.jad_er():java.io.InputStream");
    }

    @Override // com.jd.ad.sdk.jad_it.jad_dq
    public void jad_an(@NonNull jad_jt jad_jtVar, @NonNull jad_dq.jad_an<? super InputStream> jad_anVar) {
        try {
            InputStream jad_er = jad_er();
            this.jad_cp = jad_er;
            jad_anVar.jad_an((jad_dq.jad_an<? super InputStream>) jad_er);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Logger.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            jad_anVar.jad_an((Exception) e);
        }
    }

    public static jad_cp jad_an(Context context, Uri uri, jad_dq jad_dqVar) {
        com.jd.ad.sdk.jad_lw.jad_bo jad_boVar = com.jd.ad.sdk.jad_ep.jad_cp.jad_an(context).jad_er;
        return new jad_cp(uri, new jad_er(com.jd.ad.sdk.jad_ep.jad_cp.jad_an(context).jad_dq.jad_an(), jad_er.jad_er, jad_dqVar, jad_boVar, context.getContentResolver()));
    }
}
