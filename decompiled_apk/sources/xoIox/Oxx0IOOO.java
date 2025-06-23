package xoIox;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.msdk.adapter.ks.KsDrawLoader;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Oxx0IOOO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f34986II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final KsDrawLoader f34987oIX0oI;

    /* loaded from: classes.dex */
    public static class II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public KsDrawLoader f34988II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public KsLoadManager.DrawAdListener f34989oIX0oI;

        /* loaded from: classes.dex */
        public class oIX0oI implements KsLoadManager.DrawAdListener {

            /* renamed from: I0Io, reason: collision with root package name */
            public final /* synthetic */ boolean f34990I0Io;

            /* renamed from: II0xO0, reason: collision with root package name */
            public final /* synthetic */ MediationAdSlotValueSet f34991II0xO0;

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ Context f34992oIX0oI;

            public oIX0oI(Context context, MediationAdSlotValueSet mediationAdSlotValueSet, boolean z) {
                this.f34992oIX0oI = context;
                this.f34991II0xO0 = mediationAdSlotValueSet;
                this.f34990I0Io = z;
            }

            @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
            public void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
                if (list != null && list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    for (KsDrawAd ksDrawAd : list) {
                        if (ksDrawAd != null) {
                            Bridge gMBridge = II0xO0.this.f34988II0xO0.getGMBridge();
                            new xoIox.II0xO0(this.f34992oIX0oI, II0xO0.this.f34988II0xO0, gMBridge, ksDrawAd, this.f34991II0xO0, this.f34990I0Io);
                            arrayList.add(gMBridge);
                        }
                    }
                    if (arrayList.size() > 0) {
                        II0xO0.this.f34988II0xO0.notifyAdSuccess(arrayList);
                        return;
                    }
                } else if (II0xO0.this.f34988II0xO0 == null) {
                    return;
                }
                II0xO0.this.f34988II0xO0.notifyAdFailed(80001, "请求成功，但无广告可用");
            }

            @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
            public void onError(int i, String str) {
                if (II0xO0.this.f34988II0xO0 != null) {
                    II0xO0.this.f34988II0xO0.notifyAdFailed(i, str);
                }
            }
        }

        public II0xO0(Context context, KsDrawLoader ksDrawLoader, MediationAdSlotValueSet mediationAdSlotValueSet, boolean z) {
            this.f34988II0xO0 = ksDrawLoader;
            this.f34989oIX0oI = new oIX0oI(context, mediationAdSlotValueSet, z);
        }

        public void II0xO0(KsScene ksScene) {
            KsLoadManager loadManager = KsAdSDK.getLoadManager();
            if (loadManager != null) {
                loadManager.loadDrawAd(ksScene, this.f34989oIX0oI);
                return;
            }
            KsDrawLoader ksDrawLoader = this.f34988II0xO0;
            if (ksDrawLoader != null) {
                ksDrawLoader.notifyAdFailed(80001, "loadManager is null can not load ads");
            }
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ MediationAdSlotValueSet f34995Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f34996XO;

        public oIX0oI(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
            this.f34996XO = context;
            this.f34995Oo = mediationAdSlotValueSet;
        }

        @Override // java.lang.Runnable
        public void run() {
            Oxx0IOOO.this.I0Io(this.f34996XO.getApplicationContext(), this.f34995Oo);
            ooOOo0oXI.oxoX(getClass().getName(), this.f34996XO.getApplicationContext());
        }
    }

    public Oxx0IOOO(KsDrawLoader ksDrawLoader) {
        this.f34987oIX0oI = ksDrawLoader;
    }

    public final void I0Io(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        try {
            KsScene.Builder builder = new KsScene.Builder(Long.valueOf(mediationAdSlotValueSet.getADNId()).longValue());
            builder.height(mediationAdSlotValueSet.getHeight());
            builder.width(mediationAdSlotValueSet.getWidth());
            builder.adNum(mediationAdSlotValueSet.getAdCount());
            new II0xO0(context, this.f34987oIX0oI, mediationAdSlotValueSet, this.f34986II0xO0).II0xO0(builder.build());
        } catch (Exception unused) {
            this.f34987oIX0oI.notifyAdFailed(80001, "代码位ID不合法");
        }
    }

    public void oIX0oI(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean Oxx0IOOO2 = x0XOIxOo.Oxx0IOOO(this.f34987oIX0oI, mediationAdSlotValueSet);
        this.f34986II0xO0 = Oxx0IOOO2;
        if (Oxx0IOOO2) {
            ooOOo0oXI.I0Io(new oIX0oI(context, mediationAdSlotValueSet));
        } else {
            I0Io(context.getApplicationContext(), mediationAdSlotValueSet);
        }
    }
}
