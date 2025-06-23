package com.jd.ad.sdk.jad_ju;

import android.content.ContentResolver;
import com.jd.ad.sdk.jad_hs.jad_fs;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_er {
    public static final jad_an jad_er = new jad_an();
    public final jad_dq jad_an;
    public final com.jd.ad.sdk.jad_lw.jad_bo jad_bo;
    public final ContentResolver jad_cp;
    public final List<jad_fs> jad_dq;

    public jad_er(List<jad_fs> list, jad_an jad_anVar, jad_dq jad_dqVar, com.jd.ad.sdk.jad_lw.jad_bo jad_boVar, ContentResolver contentResolver) {
        this.jad_an = jad_dqVar;
        this.jad_bo = jad_boVar;
        this.jad_cp = contentResolver;
        this.jad_dq = list;
    }
}
