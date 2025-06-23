package com.huawei.openalliance.ad.inter;

import android.content.Context;
import com.huawei.hms.ads.jc;
import com.huawei.openalliance.ad.constant.v;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AdEventRecord;
import com.huawei.openalliance.ad.inter.data.AdEventType;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.w;
import java.util.List;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: classes10.dex */
public class f {
    private static f Code;
    private static final byte[] V = new byte[0];
    private Context I;

    private f(Context context) {
        this.I = context.getApplicationContext();
    }

    @com.huawei.openalliance.ad.annotations.b
    public static f Code(Context context) {
        return V(context);
    }

    private static f V(Context context) {
        f fVar;
        synchronized (V) {
            try {
                if (Code == null) {
                    Code = new f(context);
                }
                fVar = Code;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    private void Code(AdContentData adContentData, Long l, boolean z) {
        if (adContentData == null) {
            return;
        }
        adContentData.I(String.valueOf(w.Code()));
        jc.Code(this.I, adContentData, (String) null, l, Boolean.valueOf(z));
    }

    private void Code(com.huawei.openalliance.ad.inter.data.d dVar, Long l, boolean z) {
        Code(dVar.n(), l, z);
        jc.Code(this.I, dVar.n(), Long.valueOf(Math.min(dVar.g() - dVar.f(), dVar.u())), Integer.valueOf(dVar.v()), (Integer) 7, l, Boolean.valueOf(z));
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(List<AdEventRecord> list) {
        com.huawei.openalliance.ad.inter.data.d Code2;
        if (ad.Code(list)) {
            return;
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            AdEventRecord adEventRecord = list.get(i);
            if (adEventRecord != null && (Code2 = adEventRecord.Code()) != null && Code2.A()) {
                String Z = adEventRecord.Z();
                Long valueOf = Long.valueOf(adEventRecord.B() == null ? w.Code() : adEventRecord.B().longValue());
                boolean z = i >= size + (-1);
                if ("imp".equalsIgnoreCase(Z)) {
                    Code(Code2, valueOf, z);
                } else if (AdEventType.SHOW_START.equalsIgnoreCase(Z)) {
                    Code(Code2.n(), valueOf, z);
                } else if ("click".equalsIgnoreCase(Z)) {
                    MaterialClickInfo materialClickInfo = new MaterialClickInfo();
                    materialClickInfo.B(1);
                    jc.Code(this.I, Code2.n(), null, 0, 0, v.D, 12, null, valueOf, Boolean.valueOf(z), materialClickInfo);
                } else if ("intentSuccess".equalsIgnoreCase(Z)) {
                    jc.Code(this.I, Code2.n(), "intentSuccess", (Integer) 1, (Integer) null, valueOf, Boolean.valueOf(z));
                }
            }
            i++;
        }
    }
}
