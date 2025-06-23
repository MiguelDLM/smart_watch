package com.jd.ad.sdk.jad_rc;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.jd.ad.sdk.jad_hs.jad_iv;
import com.jd.ad.sdk.logger.Logger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes10.dex */
public class jad_xk<T> implements com.jd.ad.sdk.jad_hs.jad_ly<T, Bitmap> {
    public static final com.jd.ad.sdk.jad_hs.jad_iv<Long> jad_dq = new com.jd.ad.sdk.jad_hs.jad_iv<>("com.jd.ad.sdk.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new jad_an());
    public static final com.jd.ad.sdk.jad_hs.jad_iv<Integer> jad_er = new com.jd.ad.sdk.jad_hs.jad_iv<>("com.jd.ad.sdk.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new jad_bo());
    public static final jad_er jad_fs = new jad_er();
    public final jad_fs<T> jad_an;
    public final com.jd.ad.sdk.jad_lw.jad_er jad_bo;
    public final jad_er jad_cp;

    /* loaded from: classes10.dex */
    public class jad_an implements jad_iv.jad_bo<Long> {
        public final ByteBuffer jad_an = ByteBuffer.allocate(8);

        @Override // com.jd.ad.sdk.jad_hs.jad_iv.jad_bo
        public void jad_an(@NonNull byte[] bArr, @NonNull Long l, @NonNull MessageDigest messageDigest) {
            Long l2 = l;
            messageDigest.update(bArr);
            synchronized (this.jad_an) {
                this.jad_an.position(0);
                messageDigest.update(this.jad_an.putLong(l2.longValue()).array());
            }
        }
    }

    /* loaded from: classes10.dex */
    public class jad_bo implements jad_iv.jad_bo<Integer> {
        public final ByteBuffer jad_an = ByteBuffer.allocate(4);

        @Override // com.jd.ad.sdk.jad_hs.jad_iv.jad_bo
        public void jad_an(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            Integer num2 = num;
            if (num2 != null) {
                messageDigest.update(bArr);
                synchronized (this.jad_an) {
                    this.jad_an.position(0);
                    messageDigest.update(this.jad_an.putInt(num2.intValue()).array());
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class jad_cp implements jad_fs<AssetFileDescriptor> {
        @Override // com.jd.ad.sdk.jad_rc.jad_xk.jad_fs
        public void jad_an(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            AssetFileDescriptor assetFileDescriptor2 = assetFileDescriptor;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor2.getFileDescriptor(), assetFileDescriptor2.getStartOffset(), assetFileDescriptor2.getLength());
        }
    }

    @RequiresApi(23)
    /* loaded from: classes10.dex */
    public static final class jad_dq implements jad_fs<ByteBuffer> {
        @Override // com.jd.ad.sdk.jad_rc.jad_xk.jad_fs
        public void jad_an(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new jad_yl(this, byteBuffer));
        }
    }

    @VisibleForTesting
    /* loaded from: classes10.dex */
    public static class jad_er {
    }

    @VisibleForTesting
    /* loaded from: classes10.dex */
    public interface jad_fs<T> {
        void jad_an(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* loaded from: classes10.dex */
    public static final class jad_hu extends RuntimeException {
        public jad_hu() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    /* loaded from: classes10.dex */
    public static final class jad_jt implements jad_fs<ParcelFileDescriptor> {
        @Override // com.jd.ad.sdk.jad_rc.jad_xk.jad_fs
        public void jad_an(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    @VisibleForTesting
    public jad_xk(com.jd.ad.sdk.jad_lw.jad_er jad_erVar, jad_fs<T> jad_fsVar, jad_er jad_erVar2) {
        this.jad_bo = jad_erVar;
        this.jad_an = jad_fsVar;
        this.jad_cp = jad_erVar2;
    }

    @RequiresApi(api = 23)
    public static com.jd.ad.sdk.jad_hs.jad_ly<ByteBuffer, Bitmap> jad_bo(com.jd.ad.sdk.jad_lw.jad_er jad_erVar) {
        return new jad_xk(jad_erVar, new jad_dq(), jad_fs);
    }

    public static com.jd.ad.sdk.jad_hs.jad_ly<ParcelFileDescriptor, Bitmap> jad_cp(com.jd.ad.sdk.jad_lw.jad_er jad_erVar) {
        return new jad_xk(jad_erVar, new jad_jt(), jad_fs);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public boolean jad_an(@NonNull T t, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        return true;
    }

    public static com.jd.ad.sdk.jad_hs.jad_ly<AssetFileDescriptor, Bitmap> jad_an(com.jd.ad.sdk.jad_lw.jad_er jad_erVar) {
        return new jad_xk(jad_erVar, new jad_cp(), jad_fs);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public com.jd.ad.sdk.jad_kv.jad_xk<Bitmap> jad_an(@NonNull T t, int i, int i2, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        long longValue = ((Long) jad_jwVar.jad_an(jad_dq)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) jad_jwVar.jad_an(jad_er);
        if (num == null) {
            num = 2;
        }
        jad_iv jad_ivVar = (jad_iv) jad_jwVar.jad_an(jad_iv.jad_dq);
        if (jad_ivVar == null) {
            jad_ivVar = jad_iv.jad_cp;
        }
        jad_iv jad_ivVar2 = jad_ivVar;
        this.jad_cp.getClass();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            this.jad_an.jad_an(mediaMetadataRetriever, t);
            return com.jd.ad.sdk.jad_rc.jad_er.jad_an(jad_an(mediaMetadataRetriever, longValue, num.intValue(), i, i2, jad_ivVar2), this.jad_bo);
        } finally {
            if (Build.VERSION.SDK_INT >= 29) {
                mediaMetadataRetriever.release();
            } else {
                mediaMetadataRetriever.release();
            }
        }
    }

    @Nullable
    public static Bitmap jad_an(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, jad_iv jad_ivVar) {
        Bitmap bitmap = null;
        if (Build.VERSION.SDK_INT >= 27 && i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && jad_ivVar != jad_iv.jad_bo) {
            try {
                int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                if (parseInt3 == 90 || parseInt3 == 270) {
                    parseInt2 = parseInt;
                    parseInt = parseInt2;
                }
                float jad_bo2 = jad_ivVar.jad_bo(parseInt, parseInt2, i2, i3);
                bitmap = mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(parseInt * jad_bo2), Math.round(jad_bo2 * parseInt2));
            } catch (Throwable th) {
                if (Log.isLoggable("VideoDecoder", 3)) {
                    Logger.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
                }
            }
        }
        if (bitmap == null) {
            bitmap = mediaMetadataRetriever.getFrameAtTime(j, i);
        }
        if (bitmap != null) {
            return bitmap;
        }
        throw new jad_hu();
    }
}
