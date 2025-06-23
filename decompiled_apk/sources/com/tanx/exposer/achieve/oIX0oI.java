package com.tanx.exposer.achieve;

import java.util.List;
import xIx.oxoX;

/* loaded from: classes13.dex */
public class oIX0oI {

    /* renamed from: com.tanx.exposer.achieve.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C1083oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static volatile oIX0oI f26505oIX0oI = new oIX0oI(0);
    }

    public /* synthetic */ oIX0oI(byte b) {
        this();
    }

    public AdMonitorCommitResult oIX0oI(AdMonitorType adMonitorType, List<String> list, oxoX oxox) {
        try {
            if (XOxoX.oIX0oI.f3985oIX0oI && oxox != null) {
                XOxoX.oIX0oI.oxoX("utArgs", oxox.toString());
            }
            if (list != null && !list.isEmpty()) {
                x0oxIIIX.II0xO0.X0o0xo(oxox, adMonitorType);
                if (adMonitorType != AdMonitorType.EXPOSE && adMonitorType != AdMonitorType.INTERACT_DEDUPLICATION) {
                    return new IIOIX.oIX0oI(adMonitorType, list, oxox).oIX0oI();
                }
                return new IIOIX.II0xO0(adMonitorType, list, oxox).oIX0oI();
            }
            x0oxIIIX.II0xO0.XO(oxox, adMonitorType, "urls is empty");
            return AdMonitorCommitResult.PARAMS_ERROR;
        } catch (Exception e) {
            e.printStackTrace();
            x0oxIIIX.II0xO0.XO(oxox, adMonitorType, e.getMessage());
            return AdMonitorCommitResult.INTERNAL_ERROR;
        }
    }

    public oIX0oI() {
    }
}
