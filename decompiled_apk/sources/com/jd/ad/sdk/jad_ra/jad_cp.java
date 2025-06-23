package com.jd.ad.sdk.jad_ra;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_js.jad_mz;
import com.jd.ad.sdk.jad_js.jad_na;
import com.jd.ad.sdk.jad_js.jad_re;
import com.jd.ad.sdk.jad_mv.jad_qd;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes10.dex */
public class jad_cp extends jad_an {
    public final Paint jad_do;
    public final Rect jad_ep;
    public final Rect jad_fq;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<ColorFilter, ColorFilter> jad_gr;

    @Nullable
    public com.jd.ad.sdk.jad_mv.jad_an<Bitmap, Bitmap> jad_hs;

    public jad_cp(jad_mz jad_mzVar, jad_er jad_erVar) {
        super(jad_mzVar, jad_erVar);
        this.jad_do = new com.jd.ad.sdk.jad_kt.jad_an(3);
        this.jad_ep = new Rect();
        this.jad_fq = new Rect();
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an, com.jd.ad.sdk.jad_lu.jad_er
    public void jad_an(RectF rectF, Matrix matrix, boolean z) {
        super.jad_an(rectF, matrix, z);
        if (jad_ly() != null) {
            rectF.set(0.0f, 0.0f, com.jd.ad.sdk.jad_ve.jad_hu.jad_an() * r3.getWidth(), com.jd.ad.sdk.jad_ve.jad_hu.jad_an() * r3.getHeight());
            this.jad_mz.mapRect(rectF);
        }
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an
    public void jad_bo(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap jad_ly = jad_ly();
        if (jad_ly == null || jad_ly.isRecycled()) {
            return;
        }
        float jad_an = com.jd.ad.sdk.jad_ve.jad_hu.jad_an();
        this.jad_do.setAlpha(i);
        com.jd.ad.sdk.jad_mv.jad_an<ColorFilter, ColorFilter> jad_anVar = this.jad_gr;
        if (jad_anVar != null) {
            this.jad_do.setColorFilter(jad_anVar.jad_fs());
        }
        canvas.save();
        canvas.concat(matrix);
        this.jad_ep.set(0, 0, jad_ly.getWidth(), jad_ly.getHeight());
        this.jad_fq.set(0, 0, (int) (jad_ly.getWidth() * jad_an), (int) (jad_ly.getHeight() * jad_an));
        canvas.drawBitmap(jad_ly, this.jad_ep, this.jad_fq, this.jad_do);
        canvas.restore();
    }

    @Nullable
    public final Bitmap jad_ly() {
        com.jd.ad.sdk.jad_nw.jad_bo jad_boVar;
        Context context;
        jad_na jad_naVar;
        String str;
        Bitmap bitmap;
        Bitmap jad_fs;
        com.jd.ad.sdk.jad_mv.jad_an<Bitmap, Bitmap> jad_anVar = this.jad_hs;
        if (jad_anVar != null && (jad_fs = jad_anVar.jad_fs()) != null) {
            return jad_fs;
        }
        String str2 = this.jad_ob.jad_jt;
        jad_mz jad_mzVar = this.jad_na;
        if (jad_mzVar.getCallback() == null) {
            jad_boVar = null;
        } else {
            com.jd.ad.sdk.jad_nw.jad_bo jad_boVar2 = jad_mzVar.jad_iv;
            if (jad_boVar2 != null) {
                Drawable.Callback callback = jad_mzVar.getCallback();
                if (callback != null && (callback instanceof View)) {
                    context = ((View) callback).getContext();
                } else {
                    context = null;
                }
                if ((context != null || jad_boVar2.jad_an != null) && !jad_boVar2.jad_an.equals(context)) {
                    jad_mzVar.jad_iv = null;
                }
            }
            if (jad_mzVar.jad_iv == null) {
                jad_mzVar.jad_iv = new com.jd.ad.sdk.jad_nw.jad_bo(jad_mzVar.getCallback(), jad_mzVar.jad_jw, jad_mzVar.jad_kx, jad_mzVar.jad_bo.jad_dq);
            }
            jad_boVar = jad_mzVar.jad_iv;
        }
        if (jad_boVar != null) {
            jad_na jad_naVar2 = jad_boVar.jad_dq.get(str2);
            if (jad_naVar2 == null) {
                return null;
            }
            Bitmap bitmap2 = jad_naVar2.jad_er;
            if (bitmap2 != null) {
                return bitmap2;
            }
            com.jd.ad.sdk.jad_js.jad_bo jad_boVar3 = jad_boVar.jad_cp;
            if (jad_boVar3 != null) {
                com.jd.ad.sdk.jad_hu.jad_jt jad_jtVar = (com.jd.ad.sdk.jad_hu.jad_jt) jad_boVar3;
                String str3 = jad_naVar2.jad_cp;
                Map map = jad_jtVar.jad_an;
                if (map != null && map.containsKey(str3)) {
                    bitmap = (Bitmap) jad_jtVar.jad_an.get(str3);
                } else {
                    Bitmap[] bitmapArr = {null};
                    try {
                        com.jd.ad.sdk.jad_ep.jad_cp.jad_bo(jad_jtVar.jad_bo).jad_er().jad_an(jad_naVar2.jad_dq).jad_an((com.jd.ad.sdk.jad_ep.jad_iv<Bitmap>) new com.jd.ad.sdk.jad_hu.jad_fs(jad_jtVar, jad_naVar2, bitmapArr));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    bitmap = bitmapArr[0];
                }
                Bitmap bitmap3 = bitmap;
                if (bitmap3 != null) {
                    jad_boVar.jad_an(str2, bitmap3);
                    return bitmap3;
                }
                return bitmap3;
            }
            String str4 = jad_naVar2.jad_dq;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = true;
            options.inDensity = 160;
            if (str4.startsWith("data:") && str4.indexOf("base64,") > 0) {
                try {
                    byte[] decode = Base64.decode(str4.substring(str4.indexOf(44) + 1), 0);
                    return jad_boVar.jad_an(str2, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
                } catch (IllegalArgumentException e2) {
                    com.jd.ad.sdk.jad_ve.jad_dq.jad_an("data URL did not have correct base64 format.", e2);
                    return null;
                }
            }
            try {
                if (!TextUtils.isEmpty(jad_boVar.jad_bo)) {
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(jad_boVar.jad_an.getAssets().open(jad_boVar.jad_bo + str4), null, options);
                        int i = jad_naVar2.jad_an;
                        int i2 = jad_naVar2.jad_bo;
                        ThreadLocal<PathMeasure> threadLocal = com.jd.ad.sdk.jad_ve.jad_hu.jad_an;
                        if (decodeStream.getWidth() != i || decodeStream.getHeight() != i2) {
                            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, i, i2, true);
                            decodeStream.recycle();
                            decodeStream = createScaledBitmap;
                        }
                        return jad_boVar.jad_an(str2, decodeStream);
                    } catch (IllegalArgumentException e3) {
                        e = e3;
                        str = "Unable to decode image.";
                        com.jd.ad.sdk.jad_ve.jad_dq.jad_an(str, e);
                        return null;
                    }
                }
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            } catch (IOException e4) {
                e = e4;
                str = "Unable to open asset.";
            }
        } else {
            com.jd.ad.sdk.jad_js.jad_jt jad_jtVar2 = jad_mzVar.jad_bo;
            if (jad_jtVar2 == null) {
                jad_naVar = null;
            } else {
                jad_naVar = jad_jtVar2.jad_dq.get(str2);
            }
            if (jad_naVar == null) {
                return null;
            }
            return jad_naVar.jad_er;
        }
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_an, com.jd.ad.sdk.jad_ox.jad_fs
    public <T> void jad_an(T t, @Nullable com.jd.ad.sdk.jad_wf.jad_cp<T> jad_cpVar) {
        this.jad_vi.jad_an(t, jad_cpVar);
        if (t == jad_re.jad_mx) {
            if (jad_cpVar == null) {
                this.jad_gr = null;
                return;
            } else {
                this.jad_gr = new jad_qd(jad_cpVar, null);
                return;
            }
        }
        if (t == jad_re.jad_pa) {
            if (jad_cpVar == null) {
                this.jad_hs = null;
            } else {
                this.jad_hs = new jad_qd(jad_cpVar, null);
            }
        }
    }
}
