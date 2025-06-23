package com.jd.ad.sdk.fdt.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.jad_ir.jad_an;
import com.jd.ad.sdk.jad_ir.jad_bo;
import com.jd.ad.sdk.jad_ir.jad_er;

/* loaded from: classes10.dex */
public class JADLogAdapter implements jad_bo {

    @NonNull
    private final jad_an formatStrategy;

    public JADLogAdapter() {
        jad_er.jad_an jad_bo = jad_er.jad_an().jad_bo(false).jad_an(false).jad_an(0).jad_bo(7);
        StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("JADLog");
        jad_an.append(JADYunSdk.getSDKVersion());
        this.formatStrategy = jad_bo.jad_an(jad_an.toString()).jad_an();
    }

    @Override // com.jd.ad.sdk.jad_ir.jad_bo
    public boolean isLoggable(int i, @Nullable String str) {
        return i != 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0164  */
    @Override // com.jd.ad.sdk.jad_ir.jad_bo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void log(int r17, @androidx.annotation.Nullable java.lang.String r18, @androidx.annotation.NonNull java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.fdt.logger.JADLogAdapter.log(int, java.lang.String, java.lang.String):void");
    }
}
