package xxIXOIIO;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.gdt.GdtInterstitialLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class II0XooXoX extends MediationBaseAdBridge {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final GdtInterstitialLoader f35333IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final MediationAdSlotValueSet f35334Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f35335Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public UnifiedInterstitialAD f35336XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public UnifiedInterstitialADListener f35337oI0IIXIo;

    /* loaded from: classes.dex */
    public class I0Io implements Callable<MediationConstant.AdIsReadyStatus> {
        public I0Io() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public MediationConstant.AdIsReadyStatus call() {
            return II0XooXoX.this.II0xO0();
        }
    }

    /* renamed from: xxIXOIIO.II0XooXoX$II0XooXoX, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC1178II0XooXoX implements Callable<String> {
        public CallableC1178II0XooXoX() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public String call() {
            return II0XooXoX.this.Oxx0xo();
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Activity f35341XO;

        public II0xO0(Activity activity) {
            this.f35341XO = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            II0XooXoX.this.I0Io(this.f35341XO);
        }
    }

    /* loaded from: classes.dex */
    public class Oxx0IOOO implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ int f35343XO;

        public Oxx0IOOO(int i) {
            this.f35343XO = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            II0XooXoX.this.f35336XO.sendLossNotification(0, this.f35343XO, null);
        }
    }

    /* loaded from: classes.dex */
    public class XO implements Runnable {
        public XO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            II0XooXoX.this.f35336XO.sendWinNotification((int) II0XooXoX.this.getCpm());
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f35347XO;

        public oIX0oI(Context context) {
            this.f35347XO = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            II0XooXoX.this.xoIox(this.f35347XO);
            oOoXoXO.oxoX(getClass().getName(), this.f35347XO);
        }
    }

    /* loaded from: classes.dex */
    public class oxoX implements Runnable {
        public oxoX() {
        }

        @Override // java.lang.Runnable
        public void run() {
            II0XooXoX.this.II0XooXoX();
        }
    }

    public II0XooXoX(MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge, GdtInterstitialLoader gdtInterstitialLoader) {
        super(mediationAdSlotValueSet, bridge);
        this.f35337oI0IIXIo = new X0o0xo();
        this.f35334Oo = mediationAdSlotValueSet;
        this.f35333IXxxXO = gdtInterstitialLoader;
        this.f35335Oxx0xo = xxIXOIIO.oIX0oI.oxoX(gdtInterstitialLoader, mediationAdSlotValueSet);
    }

    private String IXxxXO() {
        try {
            return (String) oOoXoXO.oIX0oI(new CallableC1178II0XooXoX()).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String Oo() {
        if (this.f35335Oxx0xo) {
            return IXxxXO();
        }
        return Oxx0xo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Oxx0xo() {
        Object obj;
        try {
            UnifiedInterstitialAD unifiedInterstitialAD = this.f35336XO;
            if (unifiedInterstitialAD != null && (obj = unifiedInterstitialAD.getExtraInfo().get("request_id")) != null) {
                return obj.toString();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void oO(Context context) {
        oOoXoXO.I0Io(new oIX0oI(context));
    }

    private void x0XOIxOo(Activity activity) {
        oOoXoXO.X0o0xo(new II0xO0(activity));
    }

    private MediationConstant.AdIsReadyStatus x0xO0oo() {
        try {
            MediationConstant.AdIsReadyStatus adIsReadyStatus = (MediationConstant.AdIsReadyStatus) oOoXoXO.oIX0oI(new I0Io()).get(500L, TimeUnit.MILLISECONDS);
            if (adIsReadyStatus != null) {
                return adIsReadyStatus;
            }
            return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        } catch (Exception e) {
            e.printStackTrace();
            return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JProtect
    public void xoIox(Context context) {
        UnifiedInterstitialAD unifiedInterstitialAD;
        VideoOption build;
        MediationApiLog.i("TMe", "GdtInterstitialLoader loadAd adnId:" + this.f35333IXxxXO.getAdnId());
        if (context instanceof Activity) {
            this.f35336XO = new UnifiedInterstitialAD((Activity) context, this.f35333IXxxXO.getAdnId(), this.f35337oI0IIXIo);
            if (getGdtVideoOption() instanceof VideoOption) {
                unifiedInterstitialAD = this.f35336XO;
                build = (VideoOption) getGdtVideoOption();
            } else {
                unifiedInterstitialAD = this.f35336XO;
                build = new VideoOption.Builder().build();
            }
            unifiedInterstitialAD.setVideoOption(build);
            if (this.f35334Oo.getGdtMaxVideoDuration() > 0) {
                this.f35336XO.setMaxVideoDuration(this.f35334Oo.getGdtMaxVideoDuration());
            }
            if (this.f35334Oo.getGdtMinVideoDuration() > 0) {
                this.f35336XO.setMinVideoDuration(this.f35334Oo.getGdtMinVideoDuration());
            }
            this.f35336XO.loadAD();
            return;
        }
        MediationApiLog.i("TMe", "GdtInterstitialLoader 传入mContext 不是 Activity 请求中断");
    }

    @JProtect
    public void I0Io(Activity activity) {
        if (this.f35336XO != null && activity != null && !activity.isFinishing()) {
            this.f35336XO.show(activity);
        }
    }

    public void II0XooXoX() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f35336XO;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
            this.f35336XO = null;
        }
    }

    public MediationConstant.AdIsReadyStatus II0xO0() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f35336XO;
        if (unifiedInterstitialAD != null && unifiedInterstitialAD.isValid()) {
            return MediationConstant.AdIsReadyStatus.AD_IS_READY;
        }
        return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
    }

    public void OOXIXo(Map<String, Object> map) {
        if (!this.f35333IXxxXO.isClientBidding() || this.f35336XO == null || map == null) {
            return;
        }
        try {
            Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
            if (obj instanceof MediationConstant.BiddingLossReason) {
                int oIX0oI2 = xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj);
                if (this.f35335Oxx0xo) {
                    oOoXoXO.I0Io(new Oxx0IOOO(oIX0oI2));
                } else {
                    this.f35336XO.sendLossNotification(0, oIX0oI2, null);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void X0o0xo(Map<String, Object> map) {
        UnifiedInterstitialAD unifiedInterstitialAD;
        if (!this.f35333IXxxXO.isClientBidding() || (unifiedInterstitialAD = this.f35336XO) == null) {
            return;
        }
        try {
            if (this.f35335Oxx0xo) {
                oOoXoXO.I0Io(new XO());
            } else {
                unifiedInterstitialAD.sendWinNotification((int) getCpm());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8142) {
            MediationApiLog.i("TMe", "GdtInterstitialLoader bidWinNotify");
            Map<String, Object> map = (Map) valueSet.objectValue(8006, Map.class);
            if (map != null) {
                X0o0xo(map);
            }
        } else if (i == 8144) {
            MediationApiLog.i("TMe", "GdtInterstitialLoader bidLoseNotify");
            Map<String, Object> map2 = (Map) valueSet.objectValue(8006, Map.class);
            if (map2 != null) {
                OOXIXo(map2);
            }
        } else if (i == 8113) {
            MediationApiLog.i("TMe", "GdtInterstitialLoader showAd");
            Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
            if (activity != null) {
                xxIXOIIO(activity);
            }
        } else if (i == 8109) {
            onDestroy();
        } else {
            if (i == 8120) {
                return (T) Boolean.valueOf(hasDestroyed());
            }
            if (i == 8121) {
                return (T) isReadyStatus();
            }
            if (i == 8147) {
                return (T) Oo();
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
    public boolean hasDestroyed() {
        if (this.f35336XO == null) {
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
    public MediationConstant.AdIsReadyStatus isReadyStatus() {
        if (this.f35335Oxx0xo) {
            return x0xO0oo();
        }
        return II0xO0();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
    public void onDestroy() {
        if (this.f35335Oxx0xo) {
            ooOOo0oXI();
        } else {
            II0XooXoX();
        }
    }

    public void ooOOo0oXI() {
        oOoXoXO.X0o0xo(new oxoX());
    }

    public void oxoX(Context context) {
        if (this.f35335Oxx0xo) {
            oO(context);
        } else {
            xoIox(context);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public void xxIXOIIO(Activity activity) {
        if (this.f35335Oxx0xo) {
            x0XOIxOo(activity);
        } else {
            I0Io(activity);
        }
    }

    /* loaded from: classes.dex */
    public class X0o0xo implements UnifiedInterstitialADListener {
        public X0o0xo() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        @JProtect
        public void onADClicked() {
            MediationApiLog.i("TMe", "GdtInterstitialLoader onADClicked");
            Bridge bridge = II0XooXoX.this.mGMAd;
            if (bridge != null) {
                bridge.call(1009, null, Void.class);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        @JProtect
        public void onADClosed() {
            MediationApiLog.i("TMe", "GdtInterstitialLoader onADClosed");
            Bridge bridge = II0XooXoX.this.mGMAd;
            if (bridge != null) {
                bridge.call(1014, null, Void.class);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        @JProtect
        public void onADExposure() {
            MediationApiLog.i("TMe", "GdtInterstitialLoader onADExposure");
            Bridge bridge = II0XooXoX.this.mGMAd;
            if (bridge != null) {
                bridge.call(1008, null, Void.class);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        @JProtect
        public void onADLeftApplication() {
            MediationApiLog.i("TMe", "GdtInterstitialLoader onADLeftApplication");
            Bridge bridge = II0XooXoX.this.mGMAd;
            if (bridge != null) {
                bridge.call(1016, null, Void.class);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        @JProtect
        public void onADOpened() {
            MediationApiLog.i("TMe", "GdtInterstitialLoader onADOpened");
            Bridge bridge = II0XooXoX.this.mGMAd;
            if (bridge != null) {
                bridge.call(1015, null, Void.class);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0095  */
        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onADReceive() {
            /*
                r4 = this;
                java.lang.String r0 = "GdtInterstitialLoader onADReceive"
                java.lang.String r1 = "TMe"
                com.bytedance.sdk.openadsdk.mediation.MediationApiLog.i(r1, r0)
                xxIXOIIO.II0XooXoX r0 = xxIXOIIO.II0XooXoX.this
                com.bytedance.msdk.adapter.gdt.GdtInterstitialLoader r0 = xxIXOIIO.II0XooXoX.oIX0oI(r0)
                boolean r0 = r0.isClientBidding()
                if (r0 == 0) goto L50
                xxIXOIIO.II0XooXoX r0 = xxIXOIIO.II0XooXoX.this
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = xxIXOIIO.II0XooXoX.Oxx0IOOO(r0)
                int r2 = r2.getECPM()
                r3 = -1
                if (r2 == r3) goto L2c
                xxIXOIIO.II0XooXoX r2 = xxIXOIIO.II0XooXoX.this
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = xxIXOIIO.II0XooXoX.Oxx0IOOO(r2)
                int r2 = r2.getECPM()
                double r2 = (double) r2
                goto L2e
            L2c:
                r2 = 0
            L2e:
                r0.setCpm(r2)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "GdtInterstitialLoader GDT_clientBidding 插屏 返回的 cpm价格："
                r0.append(r2)
                xxIXOIIO.II0XooXoX r2 = xxIXOIIO.II0XooXoX.this
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = xxIXOIIO.II0XooXoX.Oxx0IOOO(r2)
                int r2 = r2.getECPM()
                r0.append(r2)
            L48:
                java.lang.String r0 = r0.toString()
                com.bytedance.sdk.openadsdk.mediation.MediationApiLog.i(r1, r0)
                goto L81
            L50:
                xxIXOIIO.II0XooXoX r0 = xxIXOIIO.II0XooXoX.this
                com.bytedance.msdk.adapter.gdt.GdtInterstitialLoader r0 = xxIXOIIO.II0XooXoX.oIX0oI(r0)
                boolean r0 = r0.isMultiBidding()
                if (r0 == 0) goto L81
                xxIXOIIO.II0XooXoX r0 = xxIXOIIO.II0XooXoX.this
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = xxIXOIIO.II0XooXoX.Oxx0IOOO(r0)
                java.lang.String r2 = r2.getECPMLevel()
                r0.setLevelTag(r2)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "GdtInterstitialLoader GDT_多阶底价 插屏 返回的价格标签："
                r0.append(r2)
                xxIXOIIO.II0XooXoX r2 = xxIXOIIO.II0XooXoX.this
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = xxIXOIIO.II0XooXoX.Oxx0IOOO(r2)
                java.lang.String r2 = r2.getECPMLevel()
                r0.append(r2)
                goto L48
            L81:
                xxIXOIIO.II0XooXoX r0 = xxIXOIIO.II0XooXoX.this
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r0 = xxIXOIIO.II0XooXoX.Oxx0IOOO(r0)
                int r0 = r0.getAdPatternType()
                r1 = 2
                if (r0 != r1) goto L95
                xxIXOIIO.II0XooXoX r0 = xxIXOIIO.II0XooXoX.this
                r1 = 5
            L91:
                r0.setImageMode(r1)
                goto L99
            L95:
                xxIXOIIO.II0XooXoX r0 = xxIXOIIO.II0XooXoX.this
                r1 = 3
                goto L91
            L99:
                xxIXOIIO.II0XooXoX r0 = xxIXOIIO.II0XooXoX.this
                com.bytedance.msdk.adapter.gdt.GdtInterstitialLoader r0 = xxIXOIIO.II0XooXoX.oIX0oI(r0)
                xxIXOIIO.II0XooXoX r1 = xxIXOIIO.II0XooXoX.this
                com.bykv.vk.openvk.api.proto.Bridge r2 = r1.mGMAd
                r0.notifyAdSuccess(r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: xxIXOIIO.II0XooXoX.X0o0xo.onADReceive():void");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        @JProtect
        public void onNoAD(AdError adError) {
            MediationApiLog.i("TMe", "GdtInterstitialLoader onNoAD");
            if (adError != null) {
                II0XooXoX.this.f35333IXxxXO.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
            } else {
                II0XooXoX.this.f35333IXxxXO.notifyAdFailed(80001, "暂无广告");
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
        }
    }
}
