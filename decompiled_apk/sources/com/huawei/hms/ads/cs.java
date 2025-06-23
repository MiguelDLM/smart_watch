package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.huawei.android.util.HwNotchSizeUtil;

/* loaded from: classes10.dex */
public class cs extends cn {
    private static final String B = "display_notch_status";
    private static final int C = 0;
    private static final byte[] D = new byte[0];
    private static cv F = null;
    private static final String I = "HwDeviceImpl";
    private static final String S = "true";
    private static final String Z = "156";

    private cs(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F() {
        String V = V("hw_sc.build.platform.version");
        this.V.V(V);
        return V;
    }

    private static cv I(Context context) {
        cv cvVar;
        synchronized (D) {
            try {
                if (F == null) {
                    F = new cs(context);
                }
                cvVar = F;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cvVar;
    }

    public static cv V(Context context) {
        return I(context);
    }

    @Override // com.huawei.hms.ads.cm, com.huawei.hms.ads.cv
    public boolean B() {
        return !TextUtils.isEmpty(Z());
    }

    @Override // com.huawei.hms.ads.cm, com.huawei.hms.ads.cv
    public String C() {
        return com.huawei.openalliance.ad.utils.bc.Code(com.huawei.openalliance.ad.utils.l.Code);
    }

    @Override // com.huawei.hms.ads.cm, com.huawei.hms.ads.cv
    public int Code(View view) {
        StringBuilder sb;
        try {
            if (!HwNotchSizeUtil.hasNotchInScreen()) {
                return 0;
            }
            int[] notchSize = HwNotchSizeUtil.getNotchSize();
            if (notchSize.length >= 2) {
                return notchSize[1];
            }
            return 0;
        } catch (Exception e) {
            e = e;
            sb = new StringBuilder();
            sb.append("getNotchHeight error:");
            sb.append(e.getClass().getSimpleName());
            fb.I(I, sb.toString());
            return 0;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            sb.append("getNotchHeight error:");
            sb.append(e.getClass().getSimpleName());
            fb.I(I, sb.toString());
            return 0;
        }
    }

    @Override // com.huawei.hms.ads.cm, com.huawei.hms.ads.cv
    public boolean S() {
        return "true".equalsIgnoreCase(com.huawei.openalliance.ad.utils.bc.Code("hw_mc.pure_mode.enable"));
    }

    @Override // com.huawei.hms.ads.cm, com.huawei.hms.ads.cv
    public String Z() {
        String C2 = this.V.C();
        if (TextUtils.isEmpty(C2)) {
            C2 = F();
        } else {
            com.huawei.openalliance.ad.utils.h.I(new Runnable() { // from class: com.huawei.hms.ads.cs.1
                @Override // java.lang.Runnable
                public void run() {
                    cs.this.F();
                }
            });
        }
        if (TextUtils.equals(com.huawei.openalliance.ad.constant.x.aZ, C2)) {
            return null;
        }
        return C2;
    }

    private String V(String str) {
        String Code = com.huawei.openalliance.ad.utils.bc.Code(str);
        return Code == null ? com.huawei.openalliance.ad.constant.x.aZ : Code;
    }

    @Override // com.huawei.hms.ads.cm, com.huawei.hms.ads.cv
    public boolean I() {
        return com.huawei.openalliance.ad.utils.n.Code(this.Code);
    }

    @Override // com.huawei.hms.ads.cm, com.huawei.hms.ads.cv
    public boolean Code() {
        return Z.equals(com.huawei.openalliance.ad.utils.bc.Code("ro.config.hw_optb"));
    }
}
