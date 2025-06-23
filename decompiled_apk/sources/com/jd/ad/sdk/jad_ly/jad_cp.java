package com.jd.ad.sdk.jad_ly;

import android.text.TextUtils;
import com.jd.ad.sdk.dl.model.IJADExtra;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes10.dex */
public class jad_cp {
    public final ConcurrentHashMap<String, String> jad_an = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, IJADExtra> jad_bo = new ConcurrentHashMap<>();

    /* loaded from: classes10.dex */
    public static class jad_an {
        public static final jad_cp jad_an = new jad_cp();
    }

    public String jad_an(String str) {
        String str2 = this.jad_an.get(str);
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        return str2;
    }
}
