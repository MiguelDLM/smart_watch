package com.jd.ad.sdk.jad_kt;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;
import androidx.annotation.NonNull;

/* loaded from: classes10.dex */
public class jad_an extends Paint {
    public jad_an() {
    }

    @Override // android.graphics.Paint
    public void setTextLocales(@NonNull LocaleList localeList) {
    }

    public jad_an(int i) {
        super(i);
    }

    public jad_an(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }

    public jad_an(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }
}
