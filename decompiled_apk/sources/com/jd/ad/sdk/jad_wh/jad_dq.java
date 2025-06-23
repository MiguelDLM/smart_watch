package com.jd.ad.sdk.jad_wh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_gp.jad_an;
import com.jd.ad.sdk.jad_hs.jad_jw;
import com.jd.ad.sdk.jad_kv.jad_xk;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes10.dex */
public class jad_dq implements jad_er<com.jd.ad.sdk.jad_vg.jad_cp, byte[]> {
    @Override // com.jd.ad.sdk.jad_wh.jad_er
    @Nullable
    public jad_xk<byte[]> jad_an(@NonNull jad_xk<com.jd.ad.sdk.jad_vg.jad_cp> jad_xkVar, @NonNull jad_jw jad_jwVar) {
        jad_an.jad_bo jad_boVar;
        byte[] bArr;
        ByteBuffer asReadOnlyBuffer = jad_xkVar.get().jad_an.jad_an.jad_an.jad_er().asReadOnlyBuffer();
        AtomicReference<byte[]> atomicReference = com.jd.ad.sdk.jad_gp.jad_an.jad_an;
        if (!asReadOnlyBuffer.isReadOnly() && asReadOnlyBuffer.hasArray()) {
            jad_boVar = new jad_an.jad_bo(asReadOnlyBuffer.array(), asReadOnlyBuffer.arrayOffset(), asReadOnlyBuffer.limit());
        } else {
            jad_boVar = null;
        }
        if (jad_boVar != null && jad_boVar.jad_an == 0 && jad_boVar.jad_bo == jad_boVar.jad_cp.length) {
            bArr = asReadOnlyBuffer.array();
        } else {
            ByteBuffer asReadOnlyBuffer2 = asReadOnlyBuffer.asReadOnlyBuffer();
            byte[] bArr2 = new byte[asReadOnlyBuffer2.limit()];
            asReadOnlyBuffer2.get(bArr2);
            bArr = bArr2;
        }
        return new com.jd.ad.sdk.jad_sd.jad_bo(bArr);
    }
}
