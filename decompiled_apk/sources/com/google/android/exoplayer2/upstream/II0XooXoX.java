package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.a;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.base.Ascii;
import com.google.common.base.Predicate;
import o0oIxXOx.XIxXXX0x0;

/* loaded from: classes9.dex */
public final /* synthetic */ class II0XooXoX {
    static {
        Predicate<String> predicate = HttpDataSource.REJECT_PAYWALL_TYPES;
    }

    public static /* synthetic */ boolean oIX0oI(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = Ascii.toLowerCase(str);
        if (TextUtils.isEmpty(lowerCase)) {
            return false;
        }
        if ((lowerCase.contains("text") && !lowerCase.contains(MimeTypes.TEXT_VTT)) || lowerCase.contains(a.f) || lowerCase.contains(XIxXXX0x0.f31179xoXoI)) {
            return false;
        }
        return true;
    }
}
