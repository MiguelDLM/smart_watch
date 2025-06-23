package xxIXOIIO;

import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.msdk.adapter.gdt.GdtDrawLoader;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class XO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f35472II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final GdtDrawLoader f35473oIX0oI;

    /* loaded from: classes.dex */
    public class II0xO0 implements NativeADUnifiedListener {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ MediationAdSlotValueSet f35475oIX0oI;

        public II0xO0(MediationAdSlotValueSet mediationAdSlotValueSet) {
            this.f35475oIX0oI = mediationAdSlotValueSet;
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (NativeUnifiedADData nativeUnifiedADData : list) {
                    Bridge gMBridge = XO.this.f35473oIX0oI.getGMBridge();
                    VideoOption build = new VideoOption.Builder().build();
                    if (this.f35475oIX0oI.getGdtVideoOption() instanceof VideoOption) {
                        build = (VideoOption) this.f35475oIX0oI.getGdtVideoOption();
                    }
                    new xxIXOIIO.II0xO0(nativeUnifiedADData, XO.this.f35473oIX0oI, gMBridge, build, XO.this.f35472II0xO0);
                    arrayList.add(gMBridge);
                }
                XO.this.f35473oIX0oI.notifyAdSuccess(arrayList);
                return;
            }
            XO.this.f35473oIX0oI.notifyAdFailed(80001, "请求成功，但无广告可用");
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            if (adError != null) {
                XO.this.f35473oIX0oI.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
            } else {
                XO.this.f35473oIX0oI.notifyAdFailed(80001, "error is null");
            }
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ MediationAdSlotValueSet f35477Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f35478XO;

        public oIX0oI(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
            this.f35478XO = context;
            this.f35477Oo = mediationAdSlotValueSet;
        }

        @Override // java.lang.Runnable
        public void run() {
            XO.this.oxoX(this.f35478XO.getApplicationContext(), this.f35477Oo);
            oOoXoXO.oxoX(getClass().getName(), this.f35478XO.getApplicationContext());
        }
    }

    public XO(GdtDrawLoader gdtDrawLoader) {
        this.f35473oIX0oI = gdtDrawLoader;
    }

    public void II0xO0(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean oxoX2 = xxIXOIIO.oIX0oI.oxoX(this.f35473oIX0oI, mediationAdSlotValueSet);
        this.f35472II0xO0 = oxoX2;
        if (oxoX2) {
            oOoXoXO.I0Io(new oIX0oI(context, mediationAdSlotValueSet));
        } else {
            oxoX(context.getApplicationContext(), mediationAdSlotValueSet);
        }
    }

    public final void oxoX(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        NativeUnifiedAD nativeUnifiedAD = new NativeUnifiedAD(context, mediationAdSlotValueSet.getADNId(), new II0xO0(mediationAdSlotValueSet));
        int gdtMaxVideoDuration = mediationAdSlotValueSet.getGdtMaxVideoDuration();
        int gdtMinVideoDuration = mediationAdSlotValueSet.getGdtMinVideoDuration();
        if (gdtMinVideoDuration > 0) {
            nativeUnifiedAD.setMinVideoDuration(gdtMinVideoDuration);
        }
        if (gdtMaxVideoDuration > 0) {
            nativeUnifiedAD.setMaxVideoDuration(gdtMaxVideoDuration);
        }
        nativeUnifiedAD.loadData(mediationAdSlotValueSet.getAdCount());
    }
}
