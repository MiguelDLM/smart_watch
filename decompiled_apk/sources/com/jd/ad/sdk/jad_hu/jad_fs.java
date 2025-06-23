package com.jd.ad.sdk.jad_hu;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_js.jad_na;

/* loaded from: classes10.dex */
public class jad_fs extends com.jd.ad.sdk.jad_bm.jad_an<Bitmap> {
    public final /* synthetic */ jad_na jad_dq;
    public final /* synthetic */ Bitmap[] jad_er;

    public jad_fs(jad_jt jad_jtVar, jad_na jad_naVar, Bitmap[] bitmapArr) {
        this.jad_dq = jad_naVar;
        this.jad_er = bitmapArr;
    }

    @Override // com.jd.ad.sdk.jad_bm.jad_er
    public void jad_an(@Nullable Drawable drawable) {
    }

    @Override // com.jd.ad.sdk.jad_bm.jad_an, com.jd.ad.sdk.jad_bm.jad_er
    public void jad_cp(@Nullable Drawable drawable) {
    }

    @Override // com.jd.ad.sdk.jad_bm.jad_er
    public /* bridge */ /* synthetic */ void jad_an(@NonNull Object obj, @Nullable com.jd.ad.sdk.jad_en.jad_bo jad_boVar) {
        jad_an((Bitmap) obj, (com.jd.ad.sdk.jad_en.jad_bo<? super Bitmap>) jad_boVar);
    }

    public void jad_an(@NonNull Bitmap bitmap, @Nullable com.jd.ad.sdk.jad_en.jad_bo<? super Bitmap> jad_boVar) {
        jad_na jad_naVar = this.jad_dq;
        this.jad_er[0] = jad_hu.jad_an(bitmap, jad_naVar.jad_an, jad_naVar.jad_bo);
    }
}
