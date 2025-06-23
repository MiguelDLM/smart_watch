package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes11.dex */
public final class ba {
    private static Context aQQ;
    private static Map<String, j> aQR = new HashMap();

    /* loaded from: classes11.dex */
    public static class a extends j<com.kwad.sdk.k.a.b> {
        private static com.kwad.sdk.k.a.b aQS;

        public a(boolean z) {
            super(z);
        }

        @RequiresApi(api = 17)
        @SuppressLint({"BlockedPrivateApi"})
        private static int a(CellInfo cellInfo) {
            if (cellInfo == null) {
                return -1;
            }
            try {
                return ((CellSignalStrength) s.callMethod(cellInfo, "getCellSignalStrength", new Object[0])).getLevel();
            } catch (Throwable unused) {
                return -1;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.utils.j
        /* renamed from: de, reason: merged with bridge method [inline-methods] */
        public com.kwad.sdk.k.a.b cc(Context context) {
            int i;
            int i2;
            if (!av.MT() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ab(64L)) {
                com.kwad.sdk.k.a.b bVar = aQS;
                if (bVar != null) {
                    return bVar;
                }
                CellInfo cellInfo = null;
                if (context == null || av.MT()) {
                    return null;
                }
                int i3 = -1;
                if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == -1) {
                    return null;
                }
                if (bj.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        i2 = cdmaCellLocation.getBaseStationId();
                        i = cdmaCellLocation.getNetworkId();
                    } else if (cellLocation instanceof GsmCellLocation) {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        i2 = gsmCellLocation.getCid();
                        i = gsmCellLocation.getLac();
                    } else {
                        i = -1;
                        i2 = -1;
                    }
                    Iterator<CellInfo> it = telephonyManager.getAllCellInfo().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        CellInfo next = it.next();
                        if (next != null && next.isRegistered()) {
                            cellInfo = next;
                            break;
                        }
                    }
                    if (cellInfo != null) {
                        i3 = a(cellInfo);
                    }
                    aQS = new com.kwad.sdk.k.a.b(i2, i, i3);
                }
                return aQS;
            }
            return aQS;
        }
    }

    /* loaded from: classes11.dex */
    public static class b extends j<com.kwad.sdk.k.a.f> {
        public b(boolean z) {
            super(z);
        }

        @Nullable
        private static com.kwad.sdk.k.a.f df(Context context) {
            com.kwad.sdk.k.a.f fVar = new com.kwad.sdk.k.a.f();
            fVar.aOl = aw.cR(context);
            fVar.aOk = aw.cP(context);
            return fVar;
        }

        @Override // com.kwad.sdk.utils.j
        @Nullable
        public final /* synthetic */ com.kwad.sdk.k.a.f cc(Context context) {
            return df(context);
        }
    }

    @Nullable
    public static com.kwad.sdk.k.a.b Lg() {
        if (!Nm()) {
            return null;
        }
        return (com.kwad.sdk.k.a.b) gV("baseStationEnable");
    }

    @Nullable
    public static com.kwad.sdk.k.a.f Lh() {
        if (!Nm()) {
            return null;
        }
        return (com.kwad.sdk.k.a.f) gV("simCardInfoEnable");
    }

    private static boolean Nm() {
        if (aQQ != null) {
            return true;
        }
        return false;
    }

    @Nullable
    private static <T> j<T> gU(String str) {
        try {
            return aQR.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    private static <T> T gV(String str) {
        j gU = gU(str);
        if (gU != null) {
            return (T) gU.cb(aQQ);
        }
        return null;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.e.c.d("SensitiveInfoCollectors", "init sdkConfigProvider is null");
            return;
        }
        if (Nm()) {
            if (aQR.containsKey("baseStationEnable")) {
                boolean zi = hVar.zi();
                j gU = gU("baseStationEnable");
                if (gU != null) {
                    gU.bQ(zi);
                }
            }
            if (aQR.containsKey("simCardInfoEnable")) {
                boolean zg = hVar.zg();
                j gU2 = gU("simCardInfoEnable");
                if (gU2 != null) {
                    gU2.bQ(zg);
                    return;
                }
                return;
            }
            return;
        }
        aQQ = context.getApplicationContext();
        aQR.put("baseStationEnable", new a(hVar.zi()));
        aQR.put("simCardInfoEnable", new b(hVar.zg()));
    }
}
