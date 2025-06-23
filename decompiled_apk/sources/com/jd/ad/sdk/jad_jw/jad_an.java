package com.jd.ad.sdk.jad_jw;

import android.text.TextUtils;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.jd.ad.sdk.jad_sf.jad_an;

/* loaded from: classes10.dex */
public class jad_an {
    public static String jad_an = "";

    /* renamed from: com.jd.ad.sdk.jad_jw.jad_an$jad_an, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0691jad_an implements IIdentifierListener {
        public void OnSupport(boolean z, IdSupplier idSupplier) {
            if (z && idSupplier != null && idSupplier.isSupported()) {
                String oaid = idSupplier.getOAID();
                jad_an.jad_an = oaid;
                if (!TextUtils.isEmpty(oaid)) {
                    com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
                    jad_anVar.jad_an("refo", jad_an.jad_an);
                    jad_anVar.jad_an("refot", Long.valueOf(System.currentTimeMillis()));
                }
            }
        }

        public void onSupport(IdSupplier idSupplier) {
            if (idSupplier != null && idSupplier.isSupported()) {
                String oaid = idSupplier.getOAID();
                jad_an.jad_an = oaid;
                if (!TextUtils.isEmpty(oaid)) {
                    com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
                    jad_anVar.jad_an("refo", jad_an.jad_an);
                    jad_anVar.jad_an("refot", Long.valueOf(System.currentTimeMillis()));
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0065 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void jad_an(android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_jw.jad_an.jad_an(android.content.Context):void");
    }

    /* loaded from: classes10.dex */
    public class jad_bo implements com.bun.miitmdid.core.IIdentifierListener {
        public void OnSupport(boolean z, com.bun.miitmdid.supplier.IdSupplier idSupplier) {
            if (z && idSupplier != null && idSupplier.isSupported()) {
                String oaid = idSupplier.getOAID();
                jad_an.jad_an = oaid;
                if (TextUtils.isEmpty(oaid)) {
                    return;
                }
                com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
                jad_anVar.jad_an("refo", jad_an.jad_an);
                jad_anVar.jad_an("refot", Long.valueOf(System.currentTimeMillis()));
            }
        }

        public void OnSupport(com.bun.miitmdid.supplier.IdSupplier idSupplier) {
            if (idSupplier == null || !idSupplier.isSupported()) {
                return;
            }
            String oaid = idSupplier.getOAID();
            jad_an.jad_an = oaid;
            if (TextUtils.isEmpty(oaid)) {
                return;
            }
            com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
            jad_anVar.jad_an("refo", jad_an.jad_an);
            jad_anVar.jad_an("refot", Long.valueOf(System.currentTimeMillis()));
        }
    }
}
