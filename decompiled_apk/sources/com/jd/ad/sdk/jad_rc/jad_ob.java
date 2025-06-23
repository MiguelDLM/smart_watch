package com.jd.ad.sdk.jad_rc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.jd.ad.sdk.jad_gp.jad_an;
import com.jd.ad.sdk.jad_hs.jad_fs;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes10.dex */
public interface jad_ob {

    /* loaded from: classes10.dex */
    public static final class jad_an implements jad_ob {
        public final ByteBuffer jad_an;
        public final List<com.jd.ad.sdk.jad_hs.jad_fs> jad_bo;
        public final com.jd.ad.sdk.jad_lw.jad_bo jad_cp;

        public jad_an(ByteBuffer byteBuffer, List<com.jd.ad.sdk.jad_hs.jad_fs> list, com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
            this.jad_an = byteBuffer;
            this.jad_bo = list;
            this.jad_cp = jad_boVar;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_ob
        public jad_fs.jad_bo jad_an() {
            return com.jd.ad.sdk.jad_hs.jad_jt.jad_an(this.jad_bo, com.jd.ad.sdk.jad_gp.jad_an.jad_an(this.jad_an));
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_ob
        public void jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_ob
        public int jad_cp() {
            List<com.jd.ad.sdk.jad_hs.jad_fs> list = this.jad_bo;
            ByteBuffer jad_an = com.jd.ad.sdk.jad_gp.jad_an.jad_an(this.jad_an);
            com.jd.ad.sdk.jad_lw.jad_bo jad_boVar = this.jad_cp;
            if (jad_an == null) {
                return -1;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int jad_an2 = list.get(i).jad_an(jad_an, jad_boVar);
                if (jad_an2 != -1) {
                    return jad_an2;
                }
            }
            return -1;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_ob
        @Nullable
        public Bitmap jad_an(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(new jad_an.C0684jad_an(com.jd.ad.sdk.jad_gp.jad_an.jad_an(this.jad_an)), null, options);
        }
    }

    /* loaded from: classes10.dex */
    public static final class jad_bo implements jad_ob {
        public final com.jd.ad.sdk.jad_it.jad_kx jad_an;
        public final com.jd.ad.sdk.jad_lw.jad_bo jad_bo;
        public final List<com.jd.ad.sdk.jad_hs.jad_fs> jad_cp;

        public jad_bo(InputStream inputStream, List<com.jd.ad.sdk.jad_hs.jad_fs> list, com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
            this.jad_bo = (com.jd.ad.sdk.jad_lw.jad_bo) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_boVar);
            this.jad_cp = (List) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(list);
            this.jad_an = new com.jd.ad.sdk.jad_it.jad_kx(inputStream, jad_boVar);
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_ob
        @Nullable
        public Bitmap jad_an(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(this.jad_an.jad_an(), null, options);
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_ob
        public void jad_bo() {
            jad_sf jad_sfVar = this.jad_an.jad_an;
            synchronized (jad_sfVar) {
                jad_sfVar.jad_cp = jad_sfVar.jad_an.length;
            }
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_ob
        public int jad_cp() {
            return com.jd.ad.sdk.jad_hs.jad_jt.jad_an(this.jad_cp, this.jad_an.jad_an(), this.jad_bo);
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_ob
        public jad_fs.jad_bo jad_an() {
            return com.jd.ad.sdk.jad_hs.jad_jt.jad_bo(this.jad_cp, this.jad_an.jad_an(), this.jad_bo);
        }
    }

    @Nullable
    Bitmap jad_an(BitmapFactory.Options options);

    jad_fs.jad_bo jad_an();

    void jad_bo();

    int jad_cp();

    @RequiresApi(21)
    /* loaded from: classes10.dex */
    public static final class jad_cp implements jad_ob {
        public final com.jd.ad.sdk.jad_lw.jad_bo jad_an;
        public final List<com.jd.ad.sdk.jad_hs.jad_fs> jad_bo;
        public final com.jd.ad.sdk.jad_it.jad_mz jad_cp;

        public jad_cp(ParcelFileDescriptor parcelFileDescriptor, List<com.jd.ad.sdk.jad_hs.jad_fs> list, com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
            this.jad_an = (com.jd.ad.sdk.jad_lw.jad_bo) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_boVar);
            this.jad_bo = (List) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(list);
            this.jad_cp = new com.jd.ad.sdk.jad_it.jad_mz(parcelFileDescriptor);
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_ob
        @Nullable
        public Bitmap jad_an(BitmapFactory.Options options) {
            return BitmapFactory.decodeFileDescriptor(this.jad_cp.jad_an.jad_an().getFileDescriptor(), null, options);
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_ob
        public void jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_ob
        public int jad_cp() {
            jad_sf jad_sfVar;
            List<com.jd.ad.sdk.jad_hs.jad_fs> list = this.jad_bo;
            com.jd.ad.sdk.jad_it.jad_mz jad_mzVar = this.jad_cp;
            com.jd.ad.sdk.jad_lw.jad_bo jad_boVar = this.jad_an;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.jd.ad.sdk.jad_hs.jad_fs jad_fsVar = list.get(i);
                try {
                    jad_sfVar = new jad_sf(new FileInputStream(jad_mzVar.jad_an.jad_an().getFileDescriptor()), jad_boVar, 65536);
                } catch (Throwable th) {
                    th = th;
                    jad_sfVar = null;
                }
                try {
                    int jad_an = jad_fsVar.jad_an(jad_sfVar, jad_boVar);
                    try {
                        jad_sfVar.close();
                    } catch (IOException unused) {
                    }
                    jad_mzVar.jad_an.jad_an();
                    if (jad_an != -1) {
                        return jad_an;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (jad_sfVar != null) {
                        try {
                            jad_sfVar.close();
                        } catch (IOException unused2) {
                        }
                    }
                    jad_mzVar.jad_an.jad_an();
                    throw th;
                }
            }
            return -1;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_ob
        public jad_fs.jad_bo jad_an() {
            jad_sf jad_sfVar;
            List<com.jd.ad.sdk.jad_hs.jad_fs> list = this.jad_bo;
            com.jd.ad.sdk.jad_it.jad_mz jad_mzVar = this.jad_cp;
            com.jd.ad.sdk.jad_lw.jad_bo jad_boVar = this.jad_an;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.jd.ad.sdk.jad_hs.jad_fs jad_fsVar = list.get(i);
                try {
                    jad_sfVar = new jad_sf(new FileInputStream(jad_mzVar.jad_an.jad_an().getFileDescriptor()), jad_boVar, 65536);
                } catch (Throwable th) {
                    th = th;
                    jad_sfVar = null;
                }
                try {
                    jad_fs.jad_bo jad_an = jad_fsVar.jad_an(jad_sfVar);
                    try {
                        jad_sfVar.close();
                    } catch (IOException unused) {
                    }
                    jad_mzVar.jad_an.jad_an();
                    if (jad_an != jad_fs.jad_bo.UNKNOWN) {
                        return jad_an;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (jad_sfVar != null) {
                        try {
                            jad_sfVar.close();
                        } catch (IOException unused2) {
                        }
                    }
                    jad_mzVar.jad_an.jad_an();
                    throw th;
                }
            }
            return jad_fs.jad_bo.UNKNOWN;
        }
    }
}
