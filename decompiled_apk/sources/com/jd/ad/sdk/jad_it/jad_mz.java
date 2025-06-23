package com.jd.ad.sdk.jad_it;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.jd.ad.sdk.jad_it.jad_er;
import java.io.IOException;

/* loaded from: classes10.dex */
public final class jad_mz implements jad_er<ParcelFileDescriptor> {
    public final jad_bo jad_an;

    @RequiresApi(21)
    /* loaded from: classes10.dex */
    public static final class jad_an implements jad_er.jad_an<ParcelFileDescriptor> {
        @Override // com.jd.ad.sdk.jad_it.jad_er.jad_an
        @NonNull
        public Class<ParcelFileDescriptor> jad_an() {
            return ParcelFileDescriptor.class;
        }

        @Override // com.jd.ad.sdk.jad_it.jad_er.jad_an
        @NonNull
        public jad_er<ParcelFileDescriptor> jad_an(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            return new jad_mz(parcelFileDescriptor);
        }
    }

    @RequiresApi(21)
    /* loaded from: classes10.dex */
    public static final class jad_bo {
        public final ParcelFileDescriptor jad_an;

        public jad_bo(ParcelFileDescriptor parcelFileDescriptor) {
            this.jad_an = parcelFileDescriptor;
        }

        public ParcelFileDescriptor jad_an() {
            try {
                Os.lseek(this.jad_an.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.jad_an;
            } catch (ErrnoException e) {
                throw new IOException(e);
            }
        }
    }

    @RequiresApi(21)
    public jad_mz(ParcelFileDescriptor parcelFileDescriptor) {
        this.jad_an = new jad_bo(parcelFileDescriptor);
    }

    public static boolean jad_cp() {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_er
    @NonNull
    @RequiresApi(21)
    public ParcelFileDescriptor jad_an() {
        return this.jad_an.jad_an();
    }

    @Override // com.jd.ad.sdk.jad_it.jad_er
    public void jad_bo() {
    }
}
