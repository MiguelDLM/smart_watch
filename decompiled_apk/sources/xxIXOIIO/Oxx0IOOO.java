package xxIXOIIO;

import android.app.Activity;
import android.content.Context;
import com.baidu.mapapi.UIMsg;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.gdt.GdtFullVideoLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class Oxx0IOOO extends MediationBaseAdBridge {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public UnifiedInterstitialMediaListener f35394IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final GdtFullVideoLoader f35395IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public UnifiedInterstitialAD f35396Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final MediationAdSlotValueSet f35397Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public UnifiedInterstitialADListener f35398OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public final String f35399XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f35400oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public ADRewardListener f35401xoXoI;

    /* loaded from: classes.dex */
    public class I0Io implements Callable<String> {
        public I0Io() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public String call() {
            return Oxx0IOOO.this.OxxIIOOXO();
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f35405XO;

        public II0xO0(Context context) {
            this.f35405XO = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Oxx0IOOO.this.OOXIXo(this.f35405XO);
            oOoXoXO.oxoX(getClass().getName(), this.f35405XO);
        }
    }

    /* loaded from: classes.dex */
    public class X0o0xo implements Callable<MediationConstant.AdIsReadyStatus> {
        public X0o0xo() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public MediationConstant.AdIsReadyStatus call() {
            return Oxx0IOOO.this.ooOOo0oXI();
        }
    }

    /* loaded from: classes.dex */
    public class XO implements Runnable {
        public XO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Oxx0IOOO.this.II0xO0();
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ int f35410XO;

        public oIX0oI(int i) {
            this.f35410XO = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Oxx0IOOO.this.f35396Oo.sendLossNotification(0, this.f35410XO, null);
        }
    }

    /* loaded from: classes.dex */
    public class oxoX implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Activity f35412XO;

        public oxoX(Activity activity) {
            this.f35412XO = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Oxx0IOOO.this.xoIox(this.f35412XO);
        }
    }

    /* loaded from: classes.dex */
    public class xoIox implements Runnable {
        public xoIox() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Oxx0IOOO.this.f35396Oo.sendWinNotification((int) Oxx0IOOO.this.getCpm());
        }
    }

    /* loaded from: classes.dex */
    public class xxIXOIIO implements ADRewardListener {
        public xxIXOIIO() {
        }

        @Override // com.qq.e.comm.listeners.ADRewardListener
        public void onReward(Map<String, Object> map) {
            MediationApiLog.i("TMe", "GdtFullVideoLoader onRewardVerify");
            if (Oxx0IOOO.this.mGMAd != null) {
                MediationValueSetBuilder create = MediationValueSetBuilder.create();
                create.add(UIMsg.m_AppUI.MSG_MAP_HOTKEYSOPEN, true);
                create.add(UIMsg.m_AppUI.MSG_SUG_TEXTCHAGNE, Oxx0IOOO.this.getRewardAmount());
                create.add(8019, Oxx0IOOO.this.getRewardName());
                Oxx0IOOO.this.mGMAd.call(1018, create.build(), Void.class);
            }
        }
    }

    public Oxx0IOOO(MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge, GdtFullVideoLoader gdtFullVideoLoader) {
        super(mediationAdSlotValueSet, bridge);
        this.f35399XO = "TMe";
        this.f35398OxxIIOOXO = new C1180Oxx0IOOO();
        this.f35394IIXOooo = new II0XooXoX();
        this.f35401xoXoI = new xxIXOIIO();
        this.f35395IXxxXO = gdtFullVideoLoader;
        this.f35397Oxx0xo = mediationAdSlotValueSet;
        this.f35400oI0IIXIo = xxIXOIIO.oIX0oI.oxoX(gdtFullVideoLoader, mediationAdSlotValueSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JProtect
    public void OOXIXo(Context context) {
        UnifiedInterstitialAD unifiedInterstitialAD;
        VideoOption build;
        String str;
        if (context instanceof Activity) {
            this.f35396Oo = new UnifiedInterstitialAD((Activity) context, this.f35395IXxxXO.getAdnId(), this.f35398OxxIIOOXO);
            if (getGdtVideoOption() instanceof VideoOption) {
                unifiedInterstitialAD = this.f35396Oo;
                build = (VideoOption) getGdtVideoOption();
            } else {
                unifiedInterstitialAD = this.f35396Oo;
                build = new VideoOption.Builder().build();
            }
            unifiedInterstitialAD.setVideoOption(build);
            if (this.f35397Oxx0xo.getGdtMaxVideoDuration() > 0) {
                this.f35396Oo.setMaxVideoDuration(this.f35397Oxx0xo.getGdtMaxVideoDuration());
            }
            if (this.f35397Oxx0xo.getGdtMinVideoDuration() > 0) {
                this.f35396Oo.setMinVideoDuration(this.f35397Oxx0xo.getGdtMinVideoDuration());
            }
            ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
            String userID = getUserID();
            if (userID != null) {
                builder.setUserId(userID);
            }
            Map<String, Object> customData = getCustomData();
            if (customData != null && (customData.get(MediationConstant.ADN_GDT) instanceof String) && (str = (String) customData.get(MediationConstant.ADN_GDT)) != null) {
                builder.setCustomData(str);
            }
            if (userID != null || customData != null) {
                this.f35396Oo.setServerSideVerificationOptions(builder.build());
            }
            this.f35396Oo.loadFullScreenAD();
        }
    }

    private String Oxx0xo() {
        if (this.f35400oI0IIXIo) {
            return oI0IIXIo();
        }
        return OxxIIOOXO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String OxxIIOOXO() {
        Object obj;
        try {
            UnifiedInterstitialAD unifiedInterstitialAD = this.f35396Oo;
            if (unifiedInterstitialAD != null && (obj = unifiedInterstitialAD.getExtraInfo().get("request_id")) != null) {
                return obj.toString();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String oI0IIXIo() {
        try {
            return (String) oOoXoXO.oIX0oI(new I0Io()).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void oO(Activity activity) {
        oOoXoXO.X0o0xo(new oxoX(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediationConstant.AdIsReadyStatus ooOOo0oXI() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f35396Oo;
        if (unifiedInterstitialAD != null && unifiedInterstitialAD.isValid()) {
            return MediationConstant.AdIsReadyStatus.AD_IS_READY;
        }
        return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JProtect
    public void xoIox(Activity activity) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f35396Oo;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.showFullScreenAD(activity);
        }
    }

    public void I0Io(Activity activity) {
        if (this.f35400oI0IIXIo) {
            oO(activity);
        } else {
            xoIox(activity);
        }
    }

    public void II0xO0() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f35396Oo;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
            this.f35396Oo = null;
        }
    }

    public final MediationConstant.AdIsReadyStatus Oo() {
        try {
            MediationConstant.AdIsReadyStatus adIsReadyStatus = (MediationConstant.AdIsReadyStatus) oOoXoXO.oIX0oI(new X0o0xo()).get(500L, TimeUnit.MILLISECONDS);
            if (adIsReadyStatus != null) {
                return adIsReadyStatus;
            }
            return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        } catch (Exception e) {
            e.printStackTrace();
            return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        }
    }

    public void X0o0xo(Map<String, Object> map) {
        UnifiedInterstitialAD unifiedInterstitialAD;
        if (!this.f35395IXxxXO.isClientBidding() || (unifiedInterstitialAD = this.f35396Oo) == null) {
            return;
        }
        try {
            if (this.f35400oI0IIXIo) {
                oOoXoXO.I0Io(new xoIox());
            } else {
                unifiedInterstitialAD.sendWinNotification((int) getCpm());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8211) {
            MediationApiLog.i("TMe", "GdtFullVideoLoader METHOD_ADN_HAS_AD_VIDEO_CACHED_API");
            return (T) Boolean.TRUE;
        }
        if (i == 8142) {
            MediationApiLog.i("TMe", "GdtFullVideoLoader bidWinNotify");
            Map<String, Object> map = (Map) valueSet.objectValue(8006, Map.class);
            if (map != null) {
                X0o0xo(map);
            }
        } else if (i == 8144) {
            MediationApiLog.i("TMe", "GdtFullVideoLoader bidLoseNotify");
            Map<String, Object> map2 = (Map) valueSet.objectValue(8006, Map.class);
            if (map2 != null) {
                oOoXoXO(map2);
            }
        } else if (i == 8113) {
            MediationApiLog.i("TMe", "GdtFullVideoLoader showAd");
            Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
            if (activity != null) {
                I0Io(activity);
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
                return (T) Oxx0xo();
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
    public boolean hasDestroyed() {
        if (this.f35396Oo == null) {
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
    public MediationConstant.AdIsReadyStatus isReadyStatus() {
        if (this.f35400oI0IIXIo) {
            return Oo();
        }
        return ooOOo0oXI();
    }

    public void oOoXoXO(Map<String, Object> map) {
        if (!this.f35395IXxxXO.isClientBidding() || this.f35396Oo == null || map == null) {
            return;
        }
        try {
            Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
            if (obj instanceof MediationConstant.BiddingLossReason) {
                int oIX0oI2 = xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj);
                if (this.f35400oI0IIXIo) {
                    oOoXoXO.I0Io(new oIX0oI(oIX0oI2));
                } else {
                    this.f35396Oo.sendLossNotification(0, oIX0oI2, null);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
    public void onDestroy() {
        if (this.f35400oI0IIXIo) {
            xxIXOIIO();
        } else {
            II0xO0();
        }
    }

    public void oxoX(Context context) {
        if (this.f35400oI0IIXIo) {
            x0xO0oo(context);
        } else {
            OOXIXo(context);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public final void x0xO0oo(Context context) {
        oOoXoXO.I0Io(new II0xO0(context));
    }

    public void xxIXOIIO() {
        oOoXoXO.X0o0xo(new XO());
    }

    /* loaded from: classes.dex */
    public class II0XooXoX implements UnifiedInterstitialMediaListener {
        public II0XooXoX() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        @JProtect
        public void onVideoComplete() {
            MediationApiLog.i("TMe", "GdtFullVideoLoader onVideoComplete");
            Bridge bridge = Oxx0IOOO.this.mGMAd;
            if (bridge != null) {
                bridge.call(1026, null, Void.class);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        @JProtect
        public void onVideoError(AdError adError) {
            MediationApiLog.i("TMe", "GdtFullVideoLoader onVideoError");
            if (Oxx0IOOO.this.mGMAd != null && adError != null) {
                MediationValueSetBuilder create = MediationValueSetBuilder.create();
                create.add(8015, adError.getErrorMsg());
                create.add(UIMsg.m_AppUI.MSG_MAP_HOTKEYS, adError.getErrorCode());
                Oxx0IOOO.this.mGMAd.call(1021, create.build(), Void.class);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoInit() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoLoading() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoPageClose() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoPageOpen() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoPause() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoStart() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoReady(long j) {
        }
    }

    /* renamed from: xxIXOIIO.Oxx0IOOO$Oxx0IOOO, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C1180Oxx0IOOO implements UnifiedInterstitialADListener {
        public C1180Oxx0IOOO() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        @JProtect
        public void onADClicked() {
            MediationApiLog.i("TMe", "GdtFullVideoLoader onADClicked");
            Bridge bridge = Oxx0IOOO.this.mGMAd;
            if (bridge != null) {
                bridge.call(1009, null, Void.class);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        @JProtect
        public void onADClosed() {
            MediationApiLog.i("TMe", "GdtFullVideoLoader onADClosed");
            Bridge bridge = Oxx0IOOO.this.mGMAd;
            if (bridge != null) {
                bridge.call(1014, null, Void.class);
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        @JProtect
        public void onADExposure() {
            MediationApiLog.i("TMe", "GdtFullVideoLoader onADExposure");
            Bridge bridge = Oxx0IOOO.this.mGMAd;
            if (bridge != null) {
                bridge.call(1008, null, Void.class);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x008e  */
        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        @com.bytedance.JProtect
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onADReceive() {
            /*
                r4 = this;
                java.lang.String r0 = "GdtFullVideoLoader onADReceive"
                java.lang.String r1 = "TMe"
                com.bytedance.sdk.openadsdk.mediation.MediationApiLog.i(r1, r0)
                xxIXOIIO.Oxx0IOOO r0 = xxIXOIIO.Oxx0IOOO.this
                com.bytedance.msdk.adapter.gdt.GdtFullVideoLoader r0 = xxIXOIIO.Oxx0IOOO.II0XooXoX(r0)
                boolean r0 = r0.isClientBidding()
                if (r0 == 0) goto L50
                xxIXOIIO.Oxx0IOOO r0 = xxIXOIIO.Oxx0IOOO.this
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = xxIXOIIO.Oxx0IOOO.x0XOIxOo(r0)
                int r2 = r2.getECPM()
                r3 = -1
                if (r2 == r3) goto L2c
                xxIXOIIO.Oxx0IOOO r2 = xxIXOIIO.Oxx0IOOO.this
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = xxIXOIIO.Oxx0IOOO.x0XOIxOo(r2)
                int r2 = r2.getECPM()
                double r2 = (double) r2
                goto L2e
            L2c:
                r2 = 0
            L2e:
                r0.setCpm(r2)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "GdtFullVideoLoader GDT_clientBidding FullVideo 返回的 cpm价格："
                r0.append(r2)
                xxIXOIIO.Oxx0IOOO r2 = xxIXOIIO.Oxx0IOOO.this
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = xxIXOIIO.Oxx0IOOO.x0XOIxOo(r2)
                int r2 = r2.getECPM()
                r0.append(r2)
            L48:
                java.lang.String r0 = r0.toString()
                com.bytedance.sdk.openadsdk.mediation.MediationApiLog.i(r1, r0)
                goto L81
            L50:
                xxIXOIIO.Oxx0IOOO r0 = xxIXOIIO.Oxx0IOOO.this
                com.bytedance.msdk.adapter.gdt.GdtFullVideoLoader r0 = xxIXOIIO.Oxx0IOOO.II0XooXoX(r0)
                boolean r0 = r0.isMultiBidding()
                if (r0 == 0) goto L81
                xxIXOIIO.Oxx0IOOO r0 = xxIXOIIO.Oxx0IOOO.this
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = xxIXOIIO.Oxx0IOOO.x0XOIxOo(r0)
                java.lang.String r2 = r2.getECPMLevel()
                r0.setLevelTag(r2)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "GdtFullVideoLoader GDT_多阶底价 FullVideo 返回的价格标签："
                r0.append(r2)
                xxIXOIIO.Oxx0IOOO r2 = xxIXOIIO.Oxx0IOOO.this
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r2 = xxIXOIIO.Oxx0IOOO.x0XOIxOo(r2)
                java.lang.String r2 = r2.getECPMLevel()
                r0.append(r2)
                goto L48
            L81:
                xxIXOIIO.Oxx0IOOO r0 = xxIXOIIO.Oxx0IOOO.this
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r0 = xxIXOIIO.Oxx0IOOO.x0XOIxOo(r0)
                int r0 = r0.getAdPatternType()
                r1 = 2
                if (r0 != r1) goto Lae
                xxIXOIIO.Oxx0IOOO r0 = xxIXOIIO.Oxx0IOOO.this
                r1 = 5
                r0.setImageMode(r1)
                xxIXOIIO.Oxx0IOOO r0 = xxIXOIIO.Oxx0IOOO.this
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r0 = xxIXOIIO.Oxx0IOOO.x0XOIxOo(r0)
                xxIXOIIO.Oxx0IOOO r1 = xxIXOIIO.Oxx0IOOO.this
                com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener r1 = r1.f35394IIXOooo
                r0.setMediaListener(r1)
                xxIXOIIO.Oxx0IOOO r0 = xxIXOIIO.Oxx0IOOO.this
                com.qq.e.ads.interstitial2.UnifiedInterstitialAD r0 = xxIXOIIO.Oxx0IOOO.x0XOIxOo(r0)
                xxIXOIIO.Oxx0IOOO r1 = xxIXOIIO.Oxx0IOOO.this
                com.qq.e.comm.listeners.ADRewardListener r1 = r1.f35401xoXoI
                r0.setRewardListener(r1)
            Lae:
                xxIXOIIO.Oxx0IOOO r0 = xxIXOIIO.Oxx0IOOO.this
                com.bytedance.msdk.adapter.gdt.GdtFullVideoLoader r0 = xxIXOIIO.Oxx0IOOO.II0XooXoX(r0)
                xxIXOIIO.Oxx0IOOO r1 = xxIXOIIO.Oxx0IOOO.this
                com.bykv.vk.openvk.api.proto.Bridge r2 = r1.mGMAd
                r0.notifyAdSuccess(r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: xxIXOIIO.Oxx0IOOO.C1180Oxx0IOOO.onADReceive():void");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        @JProtect
        public void onNoAD(AdError adError) {
            MediationApiLog.i("TMe", "GdtFullVideoLoader onNoAD");
            if (adError != null) {
                Oxx0IOOO.this.f35395IXxxXO.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
            } else {
                Oxx0IOOO.this.f35395IXxxXO.notifyAdFailed(80001, "暂无广告");
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        @JProtect
        public void onVideoCached() {
            MediationApiLog.i("TMe", "GdtFullVideoLoader onVideoCached");
            Oxx0IOOO.this.f35395IXxxXO.notifyAdCache(Oxx0IOOO.this.mGMAd, -1, "");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
        }
    }
}
