package xxIXOIIO;

import android.content.Context;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.msdk.adapter.gdt.GdtNativeLoader;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class xxIXOIIO {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static Map<NativeExpressADView, oxoX> f35511Oxx0IOOO = new HashMap();

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f35512I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final GdtNativeLoader f35513II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final NativeExpressAD.NativeExpressADListener f35514X0o0xo = new II0xO0();

    /* renamed from: XO, reason: collision with root package name */
    public final NativeADUnifiedListener f35515XO = new I0Io();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public MediationAdSlotValueSet f35516oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public WeakReference<Context> f35517oxoX;

    /* loaded from: classes.dex */
    public class I0Io implements NativeADUnifiedListener {
        public I0Io() {
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (NativeUnifiedADData nativeUnifiedADData : list) {
                    if (nativeUnifiedADData != null) {
                        Bridge gMBridge = xxIXOIIO.this.f35513II0xO0.getGMBridge();
                        VideoOption build = new VideoOption.Builder().build();
                        FrameLayout.LayoutParams layoutParams = null;
                        if (xxIXOIIO.this.f35516oIX0oI != null) {
                            Object gdtNativeLogoParams = xxIXOIIO.this.f35516oIX0oI.getGdtNativeLogoParams();
                            if (gdtNativeLogoParams instanceof FrameLayout.LayoutParams) {
                                layoutParams = (FrameLayout.LayoutParams) gdtNativeLogoParams;
                            }
                            if (xxIXOIIO.this.f35516oIX0oI.getGdtVideoOption() instanceof VideoOption) {
                                build = (VideoOption) xxIXOIIO.this.f35516oIX0oI.getGdtVideoOption();
                            }
                        }
                        FrameLayout.LayoutParams layoutParams2 = layoutParams;
                        new xxIXOIIO.I0Io(xxIXOIIO.this.xxIXOIIO(), xxIXOIIO.this.f35513II0xO0, gMBridge, nativeUnifiedADData, layoutParams2, build, xxIXOIIO.this.f35512I0Io);
                        arrayList.add(gMBridge);
                    }
                }
                xxIXOIIO.this.f35513II0xO0.notifyAdSuccess(arrayList);
                return;
            }
            xxIXOIIO.this.f35513II0xO0.notifyAdFailed(80001, "请求成功，但无广告可用");
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            if (adError != null) {
                xxIXOIIO.this.f35513II0xO0.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
            } else {
                xxIXOIIO.this.f35513II0xO0.notifyAdFailed(80001, "请求失败");
            }
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ MediationAdSlotValueSet f35521Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f35522XO;

        public oIX0oI(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
            this.f35522XO = context;
            this.f35521Oo = mediationAdSlotValueSet;
        }

        @Override // java.lang.Runnable
        public void run() {
            xxIXOIIO.this.Oxx0IOOO(this.f35522XO, this.f35521Oo);
            oOoXoXO.oxoX(getClass().getName(), this.f35522XO);
        }
    }

    public xxIXOIIO(GdtNativeLoader gdtNativeLoader) {
        this.f35513II0xO0 = gdtNativeLoader;
    }

    public Map<NativeExpressADView, oxoX> I0Io() {
        return f35511Oxx0IOOO;
    }

    public final ADSize II0xO0(MediationAdSlotValueSet mediationAdSlotValueSet) {
        ADSize aDSize = new ADSize(-1, -2);
        if (mediationAdSlotValueSet.getExpressWidth() > 0.0f) {
            return new ADSize((int) mediationAdSlotValueSet.getExpressWidth(), -2);
        }
        return aDSize;
    }

    public final void OOXIXo(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        NativeExpressAD nativeExpressAD;
        VideoOption build;
        if (this.f35513II0xO0.isServerBidding()) {
            nativeExpressAD = new NativeExpressAD(context, II0xO0(mediationAdSlotValueSet), mediationAdSlotValueSet.getADNId(), this.f35514X0o0xo, this.f35513II0xO0.getAdm());
        } else {
            nativeExpressAD = new NativeExpressAD(context, II0xO0(mediationAdSlotValueSet), mediationAdSlotValueSet.getADNId(), this.f35514X0o0xo);
        }
        int gdtMaxVideoDuration = mediationAdSlotValueSet.getGdtMaxVideoDuration();
        int gdtMinVideoDuration = mediationAdSlotValueSet.getGdtMinVideoDuration();
        if (gdtMinVideoDuration > 0) {
            nativeExpressAD.setMinVideoDuration(gdtMinVideoDuration);
        }
        if (gdtMaxVideoDuration > 0) {
            nativeExpressAD.setMaxVideoDuration(gdtMaxVideoDuration);
        }
        if (mediationAdSlotValueSet.getGdtVideoOption() instanceof VideoOption) {
            build = (VideoOption) mediationAdSlotValueSet.getGdtVideoOption();
        } else {
            build = new VideoOption.Builder().build();
        }
        nativeExpressAD.setVideoOption(build);
        nativeExpressAD.loadAD(mediationAdSlotValueSet.getAdCount());
    }

    public final void Oxx0IOOO(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        this.f35516oIX0oI = mediationAdSlotValueSet;
        boolean isExpress = mediationAdSlotValueSet.isExpress();
        Context applicationContext = context.getApplicationContext();
        if (isExpress) {
            OOXIXo(applicationContext, mediationAdSlotValueSet);
        } else {
            ooOOo0oXI(applicationContext, mediationAdSlotValueSet);
        }
    }

    public final void ooOOo0oXI(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        NativeUnifiedAD nativeUnifiedAD;
        if (this.f35513II0xO0.isServerBidding()) {
            nativeUnifiedAD = new NativeUnifiedAD(context, this.f35513II0xO0.getAdnId(), this.f35515XO, this.f35513II0xO0.getAdm());
        } else {
            nativeUnifiedAD = new NativeUnifiedAD(context, this.f35513II0xO0.getAdnId(), this.f35515XO);
        }
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

    public void oxoX(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        this.f35517oxoX = new WeakReference<>(context.getApplicationContext());
        boolean oxoX2 = xxIXOIIO.oIX0oI.oxoX(this.f35513II0xO0, mediationAdSlotValueSet);
        this.f35512I0Io = oxoX2;
        if (oxoX2) {
            oOoXoXO.I0Io(new oIX0oI(context, mediationAdSlotValueSet));
        } else {
            Oxx0IOOO(context, mediationAdSlotValueSet);
        }
    }

    public final Context xxIXOIIO() {
        WeakReference<Context> weakReference = this.f35517oxoX;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* loaded from: classes.dex */
    public class II0xO0 implements NativeExpressAD.NativeExpressADListener {
        public II0xO0() {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            oxoX oxox;
            if (xxIXOIIO.f35511Oxx0IOOO != null && (oxox = (oxoX) xxIXOIIO.f35511Oxx0IOOO.get(nativeExpressADView)) != null) {
                oxox.notifyOnClickAd();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            if (xxIXOIIO.f35511Oxx0IOOO != null) {
                oxoX oxox = (oxoX) xxIXOIIO.f35511Oxx0IOOO.get(nativeExpressADView);
                if (oxox != null) {
                    oxox.a();
                }
                xxIXOIIO.f35511Oxx0IOOO.remove(nativeExpressADView);
            }
            if (nativeExpressADView != null) {
                nativeExpressADView.destroy();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            oxoX oxox;
            if (xxIXOIIO.f35511Oxx0IOOO != null && (oxox = (oxoX) xxIXOIIO.f35511Oxx0IOOO.get(nativeExpressADView)) != null) {
                oxox.notifyOnShowAd();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            if (list != null && list.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (NativeExpressADView nativeExpressADView : list) {
                    if (nativeExpressADView != null && nativeExpressADView.getBoundData() != null) {
                        Bridge gMBridge = xxIXOIIO.this.f35513II0xO0.getGMBridge();
                        Map map = xxIXOIIO.f35511Oxx0IOOO;
                        xxIXOIIO xxixoiio = xxIXOIIO.this;
                        map.put(nativeExpressADView, new oxoX(xxixoiio, xxixoiio.f35513II0xO0, gMBridge, nativeExpressADView, xxIXOIIO.this.f35512I0Io));
                        arrayList.add(gMBridge);
                    }
                }
                xxIXOIIO.this.f35513II0xO0.notifyAdSuccess(arrayList);
                return;
            }
            xxIXOIIO.this.f35513II0xO0.notifyAdFailed(80001, "list is empty");
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            if (adError != null) {
                xxIXOIIO.this.f35513II0xO0.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
            } else {
                xxIXOIIO.this.f35513II0xO0.notifyAdFailed(80001, "adError is null");
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            oxoX oxox;
            if (xxIXOIIO.f35511Oxx0IOOO != null && (oxox = (oxoX) xxIXOIIO.f35511Oxx0IOOO.get(nativeExpressADView)) != null) {
                oxox.notifyRenderFail(nativeExpressADView, 80003, "渲染失败");
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            oxoX oxox;
            if (xxIXOIIO.f35511Oxx0IOOO != null && (oxox = (oxoX) xxIXOIIO.f35511Oxx0IOOO.get(nativeExpressADView)) != null) {
                oxox.notifyRenderSuccess(-1.0f, -2.0f);
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
        }
    }
}
