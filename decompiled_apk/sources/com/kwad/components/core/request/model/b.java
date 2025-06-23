package com.kwad.components.core.request.model;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.util.MimeTypes;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.k.a.d;
import com.kwad.sdk.k.a.e;
import com.kwad.sdk.k.a.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.utils.n;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class b implements com.kwad.sdk.core.b {
    private boolean SA;
    private List<a> SC;
    private f SD;
    private d SE;
    private com.kwad.sdk.k.a.b SF;
    private List<e> SG;
    private int Sj;
    private String Sk;
    private int Sl;
    private Long Sm;
    private Long Sn;
    private Long So;
    private Long Sp;
    private String Sq;
    private String Sr;
    private long St;
    private String Su;
    private String Sv;
    private long Sw;
    private String Sy;
    private String Sz;
    private List<bv.a> Ss = new CopyOnWriteArrayList();
    private int Sx = -1;
    private float screenBrightness = -1.0f;
    private int SB = -1;

    @KsJson
    /* loaded from: classes11.dex */
    public static class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int SH = -1;
        public int SI = -1;
        public int SJ = -1;
        public int streamType;

        private a(int i) {
            this.streamType = i;
        }

        private static int aG(int i) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 1;
            }
            if (i == 2) {
                return 2;
            }
            if (i == 3) {
                return 3;
            }
            if (i != 4) {
                return i != 5 ? 0 : 5;
            }
            return 4;
        }

        public static List<a> ar(Context context) {
            AudioManager audioManager;
            int streamMinVolume;
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                return arrayList;
            }
            if (com.kwad.sdk.core.config.d.ab(256L)) {
                return arrayList;
            }
            try {
                audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            } catch (Exception unused) {
            }
            if (audioManager == null) {
                return arrayList;
            }
            for (int i = 0; i <= 5; i++) {
                a aVar = new a(i);
                int aG = aG(i);
                aVar.SJ = audioManager.getStreamVolume(aG);
                aVar.SH = audioManager.getStreamMaxVolume(aG);
                if (Build.VERSION.SDK_INT >= 28) {
                    streamMinVolume = audioManager.getStreamMinVolume(aG);
                    aVar.SI = streamMinVolume;
                }
                arrayList.add(aVar);
            }
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041 A[Catch: Exception -> 0x0044, TryCatch #0 {Exception -> 0x0044, blocks: (B:7:0x001e, B:9:0x0024, B:15:0x0037, B:17:0x0041, B:20:0x0048, B:24:0x004e, B:27:0x0054), top: B:6:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void aq(@androidx.annotation.NonNull android.content.Context r7) {
        /*
            r6 = this;
            r0 = 512(0x200, double:2.53E-321)
            boolean r0 = com.kwad.sdk.core.config.d.ab(r0)
            if (r0 == 0) goto L9
            return
        L9:
            android.content.IntentFilter r0 = new android.content.IntentFilter
            r0.<init>()
            java.lang.String r1 = "android.intent.action.ACTION_POWER_CONNECTED"
            r0.addAction(r1)
            java.lang.String r1 = "android.intent.action.ACTION_POWER_DISCONNECTED"
            r0.addAction(r1)
            java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
            r0.addAction(r1)
            r1 = 0
            android.content.Intent r7 = r7.registerReceiver(r1, r0)     // Catch: java.lang.Exception -> L44
            if (r7 == 0) goto L56
            java.lang.String r0 = "status"
            r1 = -1
            int r0 = r7.getIntExtra(r0, r1)     // Catch: java.lang.Exception -> L44
            r2 = 0
            r3 = 1
            r4 = 2
            if (r0 == r4) goto L36
            r5 = 5
            if (r0 != r5) goto L34
            goto L36
        L34:
            r0 = 0
            goto L37
        L36:
            r0 = 1
        L37:
            r6.SA = r0     // Catch: java.lang.Exception -> L44
            java.lang.String r0 = "plugged"
            int r7 = r7.getIntExtra(r0, r1)     // Catch: java.lang.Exception -> L44
            if (r7 != r4) goto L46
            r6.SB = r3     // Catch: java.lang.Exception -> L44
            goto L5a
        L44:
            r7 = move-exception
            goto L57
        L46:
            if (r7 != r3) goto L4b
            r6.SB = r4     // Catch: java.lang.Exception -> L44
            goto L5a
        L4b:
            r0 = 4
            if (r7 != r0) goto L52
            r7 = 3
            r6.SB = r7     // Catch: java.lang.Exception -> L44
            goto L5a
        L52:
            if (r7 != 0) goto L56
            r6.SB = r2     // Catch: java.lang.Exception -> L44
        L56:
            return
        L57:
            com.kwad.sdk.core.e.c.printStackTrace(r7)
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.request.model.b.aq(android.content.Context):void");
    }

    private static Context getContext() {
        return ServiceProvider.Lw();
    }

    @WorkerThread
    public static b rb() {
        b bVar = new b();
        bVar.Sj = bj.NH();
        bVar.Sk = AbiUtil.bQ(getContext());
        bVar.Sl = bj.dk(getContext());
        bVar.Sm = Long.valueOf(bj.dl(getContext()));
        bVar.Sn = Long.valueOf(bj.dj(getContext()));
        bVar.So = Long.valueOf(bj.NE());
        bVar.Sp = Long.valueOf(bj.NF());
        bVar.Sq = aw.cN(getContext());
        bVar.Sr = aw.cO(getContext());
        bVar.Ss.addAll(aw.o(getContext(), 15));
        bVar.St = bj.NL();
        bVar.Sw = bj.NM();
        bVar.Sz = bj.NN();
        bVar.Sy = bj.NO();
        bVar.Su = bj.NP();
        bVar.Sv = bj.NQ();
        Context context = getContext();
        if (context != null) {
            bVar.Sx = bj.ds(context);
            bVar.SC = new CopyOnWriteArrayList(a.ar(context));
            bVar.aq(context);
        }
        bVar.SE = n.LO();
        bVar.SF = aw.Lg();
        bVar.SG = bc.No().Np();
        bVar.SD = aw.Lh();
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "cpuCount", this.Sj);
        t.putValue(jSONObject, "cpuAbi", this.Sk);
        t.putValue(jSONObject, "batteryPercent", this.Sl);
        t.putValue(jSONObject, "totalMemorySize", this.Sm.longValue());
        t.putValue(jSONObject, "availableMemorySize", this.Sn.longValue());
        t.putValue(jSONObject, "totalDiskSize", this.So.longValue());
        t.putValue(jSONObject, "availableDiskSize", this.Sp.longValue());
        t.putValue(jSONObject, "imsi", this.Sq);
        t.putValue(jSONObject, "iccid", this.Sr);
        t.putValue(jSONObject, "wifiList", this.Ss);
        t.putValue(jSONObject, "bootTime", this.St);
        t.putValue(jSONObject, "romName", this.Su);
        t.putValue(jSONObject, "romVersion", this.Sv);
        t.putValue(jSONObject, "romBuildTimestamp", this.Sw);
        t.putValue(jSONObject, "ringerMode", this.Sx);
        t.putValue(jSONObject, "audioStreamInfo", this.SC);
        t.putValue(jSONObject, "baseBandVersion", this.Sy);
        t.putValue(jSONObject, "fingerPrint", this.Sz);
        t.putValue(jSONObject, "screenBrightness", this.screenBrightness);
        t.putValue(jSONObject, "isCharging", this.SA);
        t.putValue(jSONObject, "chargeType", this.SB);
        f fVar = this.SD;
        if (fVar != null) {
            t.a(jSONObject, "simCardInfo", fVar);
        }
        d dVar = this.SE;
        if (dVar != null) {
            t.a(jSONObject, "environmentInfo", dVar);
        }
        com.kwad.sdk.k.a.b bVar = this.SF;
        if (bVar != null) {
            t.a(jSONObject, "baseStationInfo", bVar);
        }
        List<e> list = this.SG;
        if (list != null) {
            t.putValue(jSONObject, "sensorEventInfoList", list);
        }
        return jSONObject;
    }
}
