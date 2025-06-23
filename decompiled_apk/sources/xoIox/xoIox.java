package xoIox;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.msdk.adapter.ks.KsNativeLoader;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class xoIox {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f35078oIX0oI;

    /* loaded from: classes.dex */
    public class I0Io implements KsLoadManager.NativeAdListener {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ MediationAdSlotValueSet f35079I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ Context f35080II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ KsNativeLoader f35081oIX0oI;

        public I0Io(KsNativeLoader ksNativeLoader, Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
            this.f35081oIX0oI = ksNativeLoader;
            this.f35080II0xO0 = context;
            this.f35079I0Io = mediationAdSlotValueSet;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i, String str) {
            this.f35081oIX0oI.notifyAdFailed(i, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (KsNativeAd ksNativeAd : list) {
                    Bridge gMBridge = this.f35081oIX0oI.getGMBridge();
                    new oxoX(this.f35080II0xO0, ksNativeAd, this.f35079I0Io, gMBridge, this.f35081oIX0oI, xoIox.this.f35078oIX0oI);
                    arrayList.add(gMBridge);
                }
                this.f35081oIX0oI.notifyAdSuccess(arrayList);
                return;
            }
            this.f35081oIX0oI.notifyAdFailed(80001, "返回广告位列表空");
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 implements KsLoadManager.FeedAdListener {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ MediationAdSlotValueSet f35083I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ Context f35084II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ KsNativeLoader f35085oIX0oI;

        public II0xO0(KsNativeLoader ksNativeLoader, Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
            this.f35085oIX0oI = ksNativeLoader;
            this.f35084II0xO0 = context;
            this.f35083I0Io = mediationAdSlotValueSet;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onError(int i, String str) {
            this.f35085oIX0oI.notifyAdFailed(i, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (KsFeedAd ksFeedAd : list) {
                    if (ksFeedAd != null) {
                        Bridge gMBridge = this.f35085oIX0oI.getGMBridge();
                        new X0o0xo(this.f35084II0xO0, ksFeedAd, this.f35083I0Io, gMBridge, this.f35085oIX0oI, xoIox.this.f35078oIX0oI);
                        arrayList.add(gMBridge);
                    }
                }
                this.f35085oIX0oI.notifyAdSuccess(arrayList);
                return;
            }
            this.f35085oIX0oI.notifyAdFailed(80001, "返回广告位列表空");
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ KsNativeLoader f35087IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ MediationAdSlotValueSet f35088Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f35090XO;

        public oIX0oI(Context context, MediationAdSlotValueSet mediationAdSlotValueSet, KsNativeLoader ksNativeLoader) {
            this.f35090XO = context;
            this.f35088Oo = mediationAdSlotValueSet;
            this.f35087IXxxXO = ksNativeLoader;
        }

        @Override // java.lang.Runnable
        public void run() {
            xoIox.this.X0o0xo(this.f35090XO.getApplicationContext(), this.f35088Oo, this.f35087IXxxXO);
            ooOOo0oXI.oxoX(getClass().getName(), this.f35090XO.getApplicationContext());
        }
    }

    public final void II0xO0(Context context, KsScene ksScene, MediationAdSlotValueSet mediationAdSlotValueSet, KsNativeLoader ksNativeLoader) {
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager != null) {
            loadManager.loadConfigFeedAd(ksScene, new II0xO0(ksNativeLoader, context, mediationAdSlotValueSet));
        }
    }

    public final void X0o0xo(Context context, MediationAdSlotValueSet mediationAdSlotValueSet, KsNativeLoader ksNativeLoader) {
        try {
            long longValue = Long.valueOf(mediationAdSlotValueSet.getADNId()).longValue();
            KsScene build = new KsScene.Builder(longValue).adNum(mediationAdSlotValueSet.getAdCount()).build();
            if (context != null) {
                int I0Io2 = x0XOIxOo.I0Io(context);
                if (mediationAdSlotValueSet.getWidth() != 0) {
                    I0Io2 = mediationAdSlotValueSet.getWidth();
                } else if (mediationAdSlotValueSet.getExpressWidth() != 0.0f) {
                    I0Io2 = (int) x0XOIxOo.oIX0oI(context, mediationAdSlotValueSet.getExpressWidth());
                }
                build = new KsScene.Builder(longValue).width(I0Io2).adNum(mediationAdSlotValueSet.getAdCount()).build();
            }
            if (mediationAdSlotValueSet.isExpress()) {
                II0xO0(context, build, mediationAdSlotValueSet, ksNativeLoader);
            } else {
                XO(context, build, mediationAdSlotValueSet, ksNativeLoader);
            }
        } catch (Exception unused) {
            ksNativeLoader.notifyAdFailed(80001, "代码位不合法");
        }
    }

    public final void XO(Context context, KsScene ksScene, MediationAdSlotValueSet mediationAdSlotValueSet, KsNativeLoader ksNativeLoader) {
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager != null) {
            loadManager.loadNativeAd(ksScene, new I0Io(ksNativeLoader, context, mediationAdSlotValueSet));
        }
    }

    public void oIX0oI(Context context, MediationAdSlotValueSet mediationAdSlotValueSet, KsNativeLoader ksNativeLoader) {
        boolean Oxx0IOOO2 = x0XOIxOo.Oxx0IOOO(ksNativeLoader, mediationAdSlotValueSet);
        this.f35078oIX0oI = Oxx0IOOO2;
        if (Oxx0IOOO2) {
            ooOOo0oXI.I0Io(new oIX0oI(context, mediationAdSlotValueSet, ksNativeLoader));
        } else {
            X0o0xo(context.getApplicationContext(), mediationAdSlotValueSet, ksNativeLoader);
        }
    }
}
