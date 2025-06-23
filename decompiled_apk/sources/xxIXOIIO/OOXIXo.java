package xxIXOIIO;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.view.ViewGroup;
import com.baidu.mapapi.UIMsg;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.gdt.GdtSplashLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADZoomOutListener;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class OOXIXo extends MediationBaseAdBridge {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f35374IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final GdtSplashLoader f35375Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final boolean f35376Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public SplashAD f35377XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public SplashADZoomOutListener f35378oI0IIXIo;

    /* loaded from: classes.dex */
    public class I0Io implements Callable<MediationConstant.AdIsReadyStatus> {
        public I0Io() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public MediationConstant.AdIsReadyStatus call() {
            return OOXIXo.this.II0xO0();
        }
    }

    /* loaded from: classes.dex */
    public class II0XooXoX implements Callable<String> {
        public II0XooXoX() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public String call() {
            return OOXIXo.this.xoXoI();
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f35382XO;

        public II0xO0(ViewGroup viewGroup) {
            this.f35382XO = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            OOXIXo.this.OOXIXo(this.f35382XO);
        }
    }

    /* loaded from: classes.dex */
    public class Oxx0IOOO implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ int f35384XO;

        public Oxx0IOOO(int i) {
            this.f35384XO = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            OOXIXo.this.f35377XO.sendLossNotification(0, this.f35384XO, null);
        }
    }

    /* loaded from: classes.dex */
    public class XO implements Runnable {
        public XO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OOXIXo.this.f35377XO.sendWinNotification((int) OOXIXo.this.getCpm());
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ boolean f35388IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ int f35389Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f35391XO;

        public oIX0oI(Context context, int i, boolean z) {
            this.f35391XO = context;
            this.f35389Oo = i;
            this.f35388IXxxXO = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            OOXIXo.this.xoIox(this.f35391XO, this.f35389Oo, this.f35388IXxxXO);
            oOoXoXO.oxoX(getClass().getName(), this.f35391XO);
        }
    }

    /* loaded from: classes.dex */
    public class oxoX implements Callable<Bitmap> {
        public oxoX() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Bitmap call() {
            return OOXIXo.this.Oo();
        }
    }

    /* loaded from: classes.dex */
    public class xxIXOIIO implements Runnable {
        public xxIXOIIO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OOXIXo.this.x0XOIxOo();
        }
    }

    public OOXIXo(MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge, Context context, GdtSplashLoader gdtSplashLoader) {
        super(mediationAdSlotValueSet, bridge);
        this.f35374IXxxXO = 2;
        this.f35378oI0IIXIo = new X0o0xo();
        this.f35375Oo = gdtSplashLoader;
        this.f35376Oxx0xo = xxIXOIIO.oIX0oI.oxoX(gdtSplashLoader, mediationAdSlotValueSet);
        int originType = mediationAdSlotValueSet.getOriginType();
        this.f35374IXxxXO = originType;
        if (originType != 0 && originType != 1 && originType != 2) {
            this.f35374IXxxXO = 2;
        }
    }

    private String IIXOooo() {
        try {
            return (String) oOoXoXO.oIX0oI(new II0XooXoX()).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String OxxIIOOXO() {
        if (this.f35376Oxx0xo) {
            return IIXOooo();
        }
        return xoXoI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String xoXoI() {
        Object obj;
        try {
            SplashAD splashAD = this.f35377XO;
            if (splashAD != null && (obj = splashAD.getExtraInfo().get("request_id")) != null) {
                return obj.toString();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void I0Io(Context context, int i, boolean z) {
        if (this.f35376Oxx0xo) {
            oO(context, i, z);
        } else {
            xoIox(context, i, z);
        }
    }

    public MediationConstant.AdIsReadyStatus II0XooXoX() {
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

    public MediationConstant.AdIsReadyStatus II0xO0() {
        SplashAD splashAD = this.f35377XO;
        if (splashAD != null && splashAD.isValid() && !this.f35375Oo.hasNotifyFail()) {
            return MediationConstant.AdIsReadyStatus.AD_IS_READY;
        }
        return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
    }

    public final void IXxxXO(ViewGroup viewGroup) {
        int i = this.f35374IXxxXO;
        if (i == 2) {
            this.f35377XO.showAd(viewGroup);
        } else if (i == 0 || i == 1) {
            this.f35377XO.showFullScreenAd(viewGroup);
        }
    }

    public final void OOXIXo(ViewGroup viewGroup) {
        if (this.f35377XO != null && viewGroup != null) {
            viewGroup.removeAllViews();
            Context context = viewGroup.getContext();
            if (context instanceof Activity) {
                ViewGroup viewGroup2 = (ViewGroup) ((Activity) context).findViewById(R.id.content);
                if (viewGroup.getParent() == null) {
                    if (viewGroup2 != null) {
                        viewGroup.setAlpha(0.0f);
                        viewGroup2.addView(viewGroup);
                    }
                    IXxxXO(viewGroup);
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(viewGroup);
                        viewGroup.setAlpha(1.0f);
                        return;
                    }
                    return;
                }
            }
            IXxxXO(viewGroup);
        }
    }

    public Bitmap Oo() {
        SplashAD splashAD = this.f35377XO;
        if (splashAD != null) {
            splashAD.getZoomOutBitmap();
            return null;
        }
        return null;
    }

    public Bitmap Oxx0xo() {
        try {
            Bitmap bitmap = (Bitmap) oOoXoXO.oIX0oI(new oxoX()).get(500L, TimeUnit.MILLISECONDS);
            if (bitmap == null) {
                return null;
            }
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void X0o0xo(Map<String, Object> map) {
        SplashAD splashAD;
        if (!this.f35375Oo.isClientBidding() || (splashAD = this.f35377XO) == null) {
            return;
        }
        try {
            if (this.f35376Oxx0xo) {
                oOoXoXO.I0Io(new XO());
            } else {
                splashAD.sendWinNotification((int) getCpm());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 6162) {
            MediationApiLog.i("TMe", "GdtSplashLoader splashMinWindowAnimationFinish");
            if (this.f35376Oxx0xo) {
                oOoXoXO.X0o0xo(new xxIXOIIO());
            } else {
                x0XOIxOo();
            }
        } else {
            if (i == 6163) {
                MediationApiLog.i("TMe", "GdtSplashLoader getSplashBitMap");
                return (T) oI0IIXIo();
            }
            if (i == 8142) {
                MediationApiLog.i("TMe", "GdtSplashLoader bidWinNotify");
                Map<String, Object> map = (Map) valueSet.objectValue(8006, Map.class);
                if (map != null) {
                    X0o0xo(map);
                }
            } else if (i == 8144) {
                MediationApiLog.i("TMe", "GdtSplashLoader bidLoseNotify");
                Map<String, Object> map2 = (Map) valueSet.objectValue(8006, Map.class);
                if (map2 != null) {
                    oOoXoXO(map2);
                }
            } else if (i == 6152) {
                MediationApiLog.i("TMe", "GdtSplashLoader showSplashAd");
                ViewGroup viewGroup = (ViewGroup) valueSet.objectValue(20060, ViewGroup.class);
                if (viewGroup != null) {
                    oxoX(viewGroup);
                }
            } else if (i != 6154 && i != 6153 && i != 6161) {
                if (i == 8109) {
                    onDestroy();
                } else {
                    if (i == 8120) {
                        return (T) Boolean.valueOf(hasDestroyed());
                    }
                    if (i == 8121) {
                        return (T) isReadyStatus();
                    }
                    if (i == 8147) {
                        return (T) OxxIIOOXO();
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
    public boolean hasDestroyed() {
        if (this.f35377XO == null) {
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
    public MediationConstant.AdIsReadyStatus isReadyStatus() {
        if (this.f35376Oxx0xo) {
            return II0XooXoX();
        }
        return II0xO0();
    }

    public Bitmap oI0IIXIo() {
        if (this.f35376Oxx0xo) {
            return Oxx0xo();
        }
        return Oo();
    }

    public final void oO(Context context, int i, boolean z) {
        oOoXoXO.I0Io(new oIX0oI(context, i, z));
    }

    public void oOoXoXO(Map<String, Object> map) {
        if (!this.f35375Oo.isClientBidding() || this.f35377XO == null || map == null) {
            return;
        }
        try {
            Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
            if (obj instanceof MediationConstant.BiddingLossReason) {
                int oIX0oI2 = xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj);
                if (this.f35376Oxx0xo) {
                    oOoXoXO.I0Io(new Oxx0IOOO(oIX0oI2));
                } else {
                    this.f35377XO.sendLossNotification(0, oIX0oI2, null);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
    public void onDestroy() {
        this.f35377XO = null;
        this.f35378oI0IIXIo = null;
    }

    public void oxoX(ViewGroup viewGroup) {
        if (this.f35376Oxx0xo) {
            x0xO0oo(viewGroup);
        } else {
            OOXIXo(viewGroup);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public void x0XOIxOo() {
        SplashAD splashAD = this.f35377XO;
        if (splashAD != null) {
            splashAD.zoomOutAnimationFinish();
        }
    }

    public final void x0xO0oo(ViewGroup viewGroup) {
        oOoXoXO.X0o0xo(new II0xO0(viewGroup));
    }

    @JProtect
    public final void xoIox(Context context, int i, boolean z) {
        if (context instanceof Activity) {
            if (!this.f35375Oo.getSplashShakeButton()) {
                HashMap hashMap = new HashMap();
                hashMap.put("shakable", "0");
                GlobalSetting.setExtraUserData(hashMap);
            }
            if (i < 0) {
                i = 3000;
            } else if (i > 5000) {
                i = 5000;
            }
            SplashAD splashAD = new SplashAD(context, this.f35375Oo.getAdnId(), this.f35378oI0IIXIo, i);
            this.f35377XO = splashAD;
            if (z) {
                splashAD.preLoad();
            }
            int i2 = this.f35374IXxxXO;
            if (i2 == 2) {
                this.f35377XO.fetchAdOnly();
            } else if (i2 == 0 || i2 == 1) {
                this.f35377XO.fetchFullScreenAdOnly();
            }
        }
    }

    /* loaded from: classes.dex */
    public class X0o0xo implements SplashADZoomOutListener {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public long f35386oIX0oI;

        public X0o0xo() {
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public boolean isSupportZoomOut() {
            MediationApiLog.i("TMe", "GdtSplashLoader isSupportZoomOut");
            return true;
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        @JProtect
        public void onADClicked() {
            MediationApiLog.i("TMe", "GdtSplashLoader onADClicked");
            Bridge bridge = OOXIXo.this.mGMAd;
            if (bridge != null) {
                bridge.call(1009, null, Void.class);
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADDismissed() {
            MediationApiLog.i("TMe", "GdtSplashLoader onADDismissed");
            Bridge bridge = OOXIXo.this.mGMAd;
            if (bridge != null) {
                bridge.call(1011, null, Void.class);
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        @JProtect
        public void onADExposure() {
            MediationApiLog.i("TMe", "GdtSplashLoader onADExposure");
            Bridge bridge = OOXIXo.this.mGMAd;
            if (bridge != null) {
                bridge.call(1008, null, Void.class);
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        @JProtect
        public void onADLoaded(long j) {
            StringBuilder sb;
            double d;
            MediationApiLog.i("TMe", "GdtSplashLoader onADLoaded");
            long elapsedRealtime = j - SystemClock.elapsedRealtime();
            if (OOXIXo.this.f35377XO != null && elapsedRealtime > 1000) {
                if (OOXIXo.this.f35375Oo.isClientBidding()) {
                    OOXIXo oOXIXo = OOXIXo.this;
                    if (oOXIXo.f35377XO.getECPM() != -1) {
                        d = OOXIXo.this.f35377XO.getECPM();
                    } else {
                        d = XIXIX.OOXIXo.f3760XO;
                    }
                    oOXIXo.setCpm(d);
                    sb = new StringBuilder();
                    sb.append("GdtSplashLoader GDT_clientBidding splash 返回的 cpm价格：");
                    sb.append(OOXIXo.this.f35377XO.getECPM());
                } else {
                    if (OOXIXo.this.f35375Oo.isMultiBidding()) {
                        OOXIXo oOXIXo2 = OOXIXo.this;
                        oOXIXo2.setLevelTag(oOXIXo2.f35377XO.getECPMLevel());
                        sb = new StringBuilder();
                        sb.append("GdtSplashLoader GDT_多阶底价 splash 返回的 价格标签：");
                        sb.append(OOXIXo.this.f35377XO.getECPMLevel());
                    }
                    GdtSplashLoader gdtSplashLoader = OOXIXo.this.f35375Oo;
                    OOXIXo oOXIXo3 = OOXIXo.this;
                    gdtSplashLoader.notifyAdSuccess(oOXIXo3, oOXIXo3.mGMAd);
                    return;
                }
                MediationApiLog.i("TMe", sb.toString());
                GdtSplashLoader gdtSplashLoader2 = OOXIXo.this.f35375Oo;
                OOXIXo oOXIXo32 = OOXIXo.this;
                gdtSplashLoader2.notifyAdSuccess(oOXIXo32, oOXIXo32.mGMAd);
                return;
            }
            OOXIXo.this.f35375Oo.notifyAdFailed(80001, "暂无广告");
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADTick(long j) {
            MediationApiLog.i("TMe", "GdtSplashLoader onADTick");
            this.f35386oIX0oI = j;
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        @JProtect
        public void onNoAD(AdError adError) {
            if (adError != null) {
                MediationApiLog.i("TMe", "GdtSplashLoader onNoAD err_code:" + adError.getErrorCode() + "  msg:" + adError.getErrorMsg());
                if (adError.getErrorCode() != 4004 && adError.getErrorCode() != 4005) {
                    OOXIXo.this.f35375Oo.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
                    return;
                }
                MediationValueSetBuilder create = MediationValueSetBuilder.create();
                create.add(UIMsg.m_AppUI.MSG_MAP_HOTKEYS, adError.getErrorCode());
                create.add(8015, adError.getErrorMsg());
                OOXIXo.this.mGMAd.call(1017, create.build(), Void.class);
                return;
            }
            MediationApiLog.i("TMe", "GdtSplashLoader onNoAD ");
            OOXIXo.this.f35375Oo.notifyAdFailed(80001, "暂无广告");
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public void onZoomOut() {
            MediationApiLog.i("TMe", "GdtSplashLoader onZoomOut");
            Bridge bridge = OOXIXo.this.mGMAd;
            if (bridge != null) {
                bridge.call(1051, null, Void.class);
            }
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public void onZoomOutPlayFinish() {
            MediationApiLog.i("TMe", "GdtSplashLoader onZoomOutPlayFinish");
            Bridge bridge = OOXIXo.this.mGMAd;
            if (bridge != null) {
                bridge.call(1052, null, Void.class);
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
        }
    }
}
