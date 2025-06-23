package com.jd.ad.sdk.jad_pa;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.jd.ad.sdk.jad_ep.jad_jt;
import com.jd.ad.sdk.jad_hs.jad_jw;
import com.jd.ad.sdk.jad_it.jad_dq;
import com.jd.ad.sdk.jad_oz.jad_na;
import com.jd.ad.sdk.jad_oz.jad_ob;
import com.jd.ad.sdk.jad_oz.jad_re;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collections;

@RequiresApi(29)
/* loaded from: classes10.dex */
public final class jad_dq<DataT> implements jad_na<Uri, DataT> {
    public final Context jad_an;
    public final jad_na<File, DataT> jad_bo;
    public final jad_na<Uri, DataT> jad_cp;
    public final Class<DataT> jad_dq;

    /* loaded from: classes10.dex */
    public static abstract class jad_an<DataT> implements jad_ob<Uri, DataT> {
        public final Context jad_an;
        public final Class<DataT> jad_bo;

        public jad_an(Context context, Class<DataT> cls) {
            this.jad_an = context;
            this.jad_bo = cls;
        }

        @Override // com.jd.ad.sdk.jad_oz.jad_ob
        @NonNull
        public final jad_na<Uri, DataT> jad_an(@NonNull jad_re jad_reVar) {
            return new jad_dq(this.jad_an, jad_reVar.jad_an(File.class, this.jad_bo), jad_reVar.jad_an(Uri.class, this.jad_bo), this.jad_bo);
        }
    }

    @RequiresApi(29)
    /* loaded from: classes10.dex */
    public static final class jad_bo extends jad_an<ParcelFileDescriptor> {
        public jad_bo(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    @RequiresApi(29)
    /* loaded from: classes10.dex */
    public static final class jad_cp extends jad_an<InputStream> {
        public jad_cp(Context context) {
            super(context, InputStream.class);
        }
    }

    /* renamed from: com.jd.ad.sdk.jad_pa.jad_dq$jad_dq, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0711jad_dq<DataT> implements com.jd.ad.sdk.jad_it.jad_dq<DataT> {
        public static final String[] jad_kx = {"_data"};
        public final Context jad_an;
        public final jad_na<File, DataT> jad_bo;
        public final jad_na<Uri, DataT> jad_cp;
        public final Uri jad_dq;
        public final int jad_er;
        public final int jad_fs;
        public final Class<DataT> jad_hu;
        public volatile boolean jad_iv;
        public final jad_jw jad_jt;

        @Nullable
        public volatile com.jd.ad.sdk.jad_it.jad_dq<DataT> jad_jw;

        public C0711jad_dq(Context context, jad_na<File, DataT> jad_naVar, jad_na<Uri, DataT> jad_naVar2, Uri uri, int i, int i2, jad_jw jad_jwVar, Class<DataT> cls) {
            this.jad_an = context.getApplicationContext();
            this.jad_bo = jad_naVar;
            this.jad_cp = jad_naVar2;
            this.jad_dq = uri;
            this.jad_er = i;
            this.jad_fs = i2;
            this.jad_jt = jad_jwVar;
            this.jad_hu = cls;
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        @NonNull
        public Class<DataT> jad_an() {
            return this.jad_hu;
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        public void jad_bo() {
            com.jd.ad.sdk.jad_it.jad_dq<DataT> jad_dqVar = this.jad_jw;
            if (jad_dqVar != null) {
                jad_dqVar.jad_bo();
            }
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        public void jad_cp() {
            this.jad_iv = true;
            com.jd.ad.sdk.jad_it.jad_dq<DataT> jad_dqVar = this.jad_jw;
            if (jad_dqVar != null) {
                jad_dqVar.jad_cp();
            }
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        @NonNull
        public com.jd.ad.sdk.jad_hs.jad_an jad_dq() {
            return com.jd.ad.sdk.jad_hs.jad_an.LOCAL;
        }

        @Nullable
        public final com.jd.ad.sdk.jad_it.jad_dq<DataT> jad_er() {
            boolean isExternalStorageLegacy;
            jad_na.jad_an<DataT> jad_an;
            isExternalStorageLegacy = Environment.isExternalStorageLegacy();
            Cursor cursor = null;
            if (isExternalStorageLegacy) {
                jad_na<File, DataT> jad_naVar = this.jad_bo;
                Uri uri = this.jad_dq;
                try {
                    Cursor query = this.jad_an.getContentResolver().query(uri, jad_kx, null, null, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst()) {
                                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                                if (!TextUtils.isEmpty(string)) {
                                    File file = new File(string);
                                    query.close();
                                    jad_an = jad_naVar.jad_an(file, this.jad_er, this.jad_fs, this.jad_jt);
                                } else {
                                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = query;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                jad_an = this.jad_cp.jad_an(this.jad_dq, this.jad_er, this.jad_fs, this.jad_jt);
            }
            if (jad_an == null) {
                return null;
            }
            return jad_an.jad_cp;
        }

        @Override // com.jd.ad.sdk.jad_it.jad_dq
        public void jad_an(@NonNull jad_jt jad_jtVar, @NonNull jad_dq.jad_an<? super DataT> jad_anVar) {
            try {
                com.jd.ad.sdk.jad_it.jad_dq<DataT> jad_er = jad_er();
                if (jad_er == null) {
                    jad_anVar.jad_an((Exception) new IllegalArgumentException("Failed to build fetcher for: " + this.jad_dq));
                    return;
                }
                this.jad_jw = jad_er;
                if (this.jad_iv) {
                    jad_cp();
                } else {
                    jad_er.jad_an(jad_jtVar, jad_anVar);
                }
            } catch (FileNotFoundException e) {
                jad_anVar.jad_an((Exception) e);
            }
        }
    }

    public jad_dq(Context context, jad_na<File, DataT> jad_naVar, jad_na<Uri, DataT> jad_naVar2, Class<DataT> cls) {
        this.jad_an = context.getApplicationContext();
        this.jad_bo = jad_naVar;
        this.jad_cp = jad_naVar2;
        this.jad_dq = cls;
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public jad_na.jad_an jad_an(@NonNull Uri uri, int i, int i2, @NonNull jad_jw jad_jwVar) {
        Uri uri2 = uri;
        return new jad_na.jad_an(new com.jd.ad.sdk.jad_fo.jad_bo(uri2), Collections.emptyList(), new C0711jad_dq(this.jad_an, this.jad_bo, this.jad_cp, uri2, i, i2, jad_jwVar, this.jad_dq));
    }

    @Override // com.jd.ad.sdk.jad_oz.jad_na
    public boolean jad_an(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && com.jd.ad.sdk.jad_ju.jad_bo.jad_an(uri);
    }
}
