package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.resource.drawable.II0xO0;
import com.bumptech.glide.load.resource.drawable.oIX0oI;
import com.jd.ad.sdk.jad_gp.jad_ly;
import com.jd.ad.sdk.jad_hs.jad_fs;
import com.jd.ad.sdk.jad_hs.jad_jt;
import com.jd.ad.sdk.jad_hs.jad_jw;
import com.jd.ad.sdk.jad_kv.jad_xk;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

@RequiresApi(28)
/* loaded from: classes10.dex */
public final class jad_an {
    public final List<com.jd.ad.sdk.jad_hs.jad_fs> jad_an;
    public final com.jd.ad.sdk.jad_lw.jad_bo jad_bo;

    /* renamed from: com.jd.ad.sdk.jad_te.jad_an$jad_an, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0717jad_an implements jad_xk<Drawable> {
        public final AnimatedImageDrawable jad_an;

        public C0717jad_an(AnimatedImageDrawable animatedImageDrawable) {
            this.jad_an = animatedImageDrawable;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_xk
        @NonNull
        public Drawable get() {
            return this.jad_an;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_xk
        public int jad_bo() {
            int intrinsicWidth;
            int intrinsicHeight;
            intrinsicWidth = this.jad_an.getIntrinsicWidth();
            intrinsicHeight = this.jad_an.getIntrinsicHeight();
            return jad_ly.jad_an(Bitmap.Config.ARGB_8888) * intrinsicHeight * intrinsicWidth * 2;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_xk
        @NonNull
        public Class<Drawable> jad_cp() {
            return Drawable.class;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_xk
        public void jad_dq() {
            this.jad_an.stop();
            this.jad_an.clearAnimationCallbacks();
        }
    }

    /* loaded from: classes10.dex */
    public static final class jad_bo implements com.jd.ad.sdk.jad_hs.jad_ly<ByteBuffer, Drawable> {
        public final jad_an jad_an;

        public jad_bo(jad_an jad_anVar) {
            this.jad_an = jad_anVar;
        }

        @Override // com.jd.ad.sdk.jad_hs.jad_ly
        public jad_xk<Drawable> jad_an(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull jad_jw jad_jwVar) {
            ImageDecoder.Source createSource;
            createSource = ImageDecoder.createSource(byteBuffer);
            return this.jad_an.jad_an(createSource, i, i2, jad_jwVar);
        }

        @Override // com.jd.ad.sdk.jad_hs.jad_ly
        public boolean jad_an(@NonNull ByteBuffer byteBuffer, @NonNull jad_jw jad_jwVar) {
            return this.jad_an.jad_an(byteBuffer);
        }
    }

    /* loaded from: classes10.dex */
    public static final class jad_cp implements com.jd.ad.sdk.jad_hs.jad_ly<InputStream, Drawable> {
        public final jad_an jad_an;

        public jad_cp(jad_an jad_anVar) {
            this.jad_an = jad_anVar;
        }

        @Override // com.jd.ad.sdk.jad_hs.jad_ly
        public jad_xk<Drawable> jad_an(@NonNull InputStream inputStream, int i, int i2, @NonNull jad_jw jad_jwVar) {
            ImageDecoder.Source createSource;
            createSource = ImageDecoder.createSource(com.jd.ad.sdk.jad_gp.jad_an.jad_an(inputStream));
            return this.jad_an.jad_an(createSource, i, i2, jad_jwVar);
        }

        @Override // com.jd.ad.sdk.jad_hs.jad_ly
        public boolean jad_an(@NonNull InputStream inputStream, @NonNull jad_jw jad_jwVar) {
            return this.jad_an.jad_an(inputStream);
        }
    }

    public jad_an(List<com.jd.ad.sdk.jad_hs.jad_fs> list, com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        this.jad_an = list;
        this.jad_bo = jad_boVar;
    }

    public static com.jd.ad.sdk.jad_hs.jad_ly<ByteBuffer, Drawable> jad_an(List<com.jd.ad.sdk.jad_hs.jad_fs> list, com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        return new jad_bo(new jad_an(list, jad_boVar));
    }

    public static com.jd.ad.sdk.jad_hs.jad_ly<InputStream, Drawable> jad_bo(List<com.jd.ad.sdk.jad_hs.jad_fs> list, com.jd.ad.sdk.jad_lw.jad_bo jad_boVar) {
        return new jad_cp(new jad_an(list, jad_boVar));
    }

    public jad_xk<Drawable> jad_an(@NonNull ImageDecoder.Source source, int i, int i2, @NonNull jad_jw jad_jwVar) {
        Drawable decodeDrawable;
        decodeDrawable = ImageDecoder.decodeDrawable(source, new com.jd.ad.sdk.jad_qb.jad_an(i, i2, jad_jwVar));
        if (oIX0oI.oIX0oI(decodeDrawable)) {
            return new C0717jad_an(II0xO0.oIX0oI(decodeDrawable));
        }
        throw new IOException("Received unexpected drawable type for animated webp, failing: " + decodeDrawable);
    }

    public boolean jad_an(InputStream inputStream) {
        return jad_jt.jad_bo(this.jad_an, inputStream, this.jad_bo) == jad_fs.jad_bo.ANIMATED_WEBP;
    }

    public boolean jad_an(ByteBuffer byteBuffer) {
        return jad_jt.jad_an(this.jad_an, byteBuffer) == jad_fs.jad_bo.ANIMATED_WEBP;
    }
}
