package xxIXOIIO;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.gdt.GdtRewardLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class xoIox extends MediationBaseAdBridge {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final MediationAdSlotValueSet f35495IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f35496Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final Bridge f35497Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public RewardVideoADListener f35498OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public RewardVideoAD f35499XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public final GdtRewardLoader f35500oI0IIXIo;

    /* loaded from: classes.dex */
    public class I0Io implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Activity f35502XO;

        public I0Io(Activity activity) {
            this.f35502XO = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            xoIox.this.x0XOIxOo(this.f35502XO);
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 implements Callable<MediationConstant.AdIsReadyStatus> {
        public II0xO0() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public MediationConstant.AdIsReadyStatus call() {
            return xoIox.this.II0XooXoX();
        }
    }

    /* loaded from: classes.dex */
    public class Oxx0IOOO implements Callable<String> {
        public Oxx0IOOO() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public String call() {
            return xoIox.this.OxxIIOOXO();
        }
    }

    /* loaded from: classes.dex */
    public class X0o0xo implements Runnable {
        public X0o0xo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xoIox.this.f35499XO.sendWinNotification((int) xoIox.this.getCpm());
        }
    }

    /* loaded from: classes.dex */
    public class XO implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ int f35507XO;

        public XO(int i) {
            this.f35507XO = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            xoIox.this.f35499XO.sendLossNotification(0, this.f35507XO, null);
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f35509XO;

        public oIX0oI(Context context) {
            this.f35509XO = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            xoIox.this.oO(this.f35509XO.getApplicationContext());
            oOoXoXO.oxoX(getClass().getName(), this.f35509XO);
        }
    }

    public xoIox(MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge, GdtRewardLoader gdtRewardLoader) {
        super(mediationAdSlotValueSet, bridge);
        this.f35498OxxIIOOXO = new oxoX();
        this.f35495IXxxXO = mediationAdSlotValueSet;
        this.f35497Oxx0xo = bridge;
        this.f35500oI0IIXIo = gdtRewardLoader;
        this.f35496Oo = xxIXOIIO.oIX0oI.oxoX(gdtRewardLoader, mediationAdSlotValueSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediationConstant.AdIsReadyStatus II0XooXoX() {
        RewardVideoAD rewardVideoAD = this.f35499XO;
        if (rewardVideoAD != null && rewardVideoAD.isValid()) {
            return MediationConstant.AdIsReadyStatus.AD_IS_READY;
        }
        return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
    }

    private String IXxxXO() {
        if (this.f35496Oo) {
            return oI0IIXIo();
        }
        return OxxIIOOXO();
    }

    private void OOXIXo(Context context) {
        oOoXoXO.I0Io(new oIX0oI(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String OxxIIOOXO() {
        Object obj;
        try {
            RewardVideoAD rewardVideoAD = this.f35499XO;
            if (rewardVideoAD != null && (obj = rewardVideoAD.getExtraInfo().get("request_id")) != null) {
                return obj.toString();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String oI0IIXIo() {
        try {
            return (String) oOoXoXO.oIX0oI(new Oxx0IOOO()).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private MediationConstant.AdIsReadyStatus oIX0oI() {
        try {
            MediationConstant.AdIsReadyStatus adIsReadyStatus = (MediationConstant.AdIsReadyStatus) oOoXoXO.oIX0oI(new II0xO0()).get(500L, TimeUnit.MILLISECONDS);
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
    public void oO(Context context) {
        RewardVideoAD rewardVideoAD;
        String str;
        boolean z = !this.f35495IXxxXO.isMuted();
        if (!TextUtils.isEmpty(this.f35500oI0IIXIo.getAdm())) {
            rewardVideoAD = new RewardVideoAD(context, this.f35500oI0IIXIo.getAdnId(), this.f35498OxxIIOOXO, z, this.f35500oI0IIXIo.getAdm());
        } else {
            rewardVideoAD = new RewardVideoAD(context, this.f35500oI0IIXIo.getAdnId(), this.f35498OxxIIOOXO, z);
        }
        this.f35499XO = rewardVideoAD;
        ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
        String userId = this.f35495IXxxXO.getUserId();
        if (userId != null) {
            builder.setUserId(userId);
        }
        Map<String, Object> extraObject = this.f35495IXxxXO.getExtraObject();
        if (extraObject != null && extraObject.get(MediationConstant.ADN_GDT) != null) {
            str = String.valueOf(extraObject.get(MediationConstant.ADN_GDT));
            builder.setCustomData(str);
        } else {
            str = null;
        }
        if (userId != null || !TextUtils.isEmpty(str)) {
            this.f35499XO.setServerSideVerificationOptions(builder.build());
        }
        this.f35499XO.loadAD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0XOIxOo(Activity activity) {
        if (this.f35499XO != null) {
            if (this.f35500oI0IIXIo.isServerBidding()) {
                RewardVideoAD rewardVideoAD = this.f35499XO;
                rewardVideoAD.setBidECPM(rewardVideoAD.getECPM());
            }
            this.f35499XO.showAD(activity);
        }
    }

    private boolean x0xO0oo() {
        return true;
    }

    private void xoIox(Activity activity) {
        oOoXoXO.X0o0xo(new I0Io(activity));
    }

    @JProtect
    public void I0Io(Activity activity) {
        if (this.f35496Oo) {
            xoIox(activity);
        } else {
            x0XOIxOo(activity);
        }
    }

    public void X0o0xo(Map<String, Object> map) {
        RewardVideoAD rewardVideoAD;
        if (!this.f35500oI0IIXIo.isClientBidding() || (rewardVideoAD = this.f35499XO) == null) {
            return;
        }
        try {
            if (this.f35496Oo) {
                oOoXoXO.I0Io(new X0o0xo());
            } else {
                rewardVideoAD.sendWinNotification((int) getCpm());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        boolean x0xO0oo2;
        if (i == 8113) {
            Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
            if (activity != null) {
                I0Io(activity);
            }
        } else if (i == 8109) {
            onDestroy();
        } else {
            if (i == 8120) {
                x0xO0oo2 = hasDestroyed();
            } else {
                if (i == 8121) {
                    return (T) isReadyStatus();
                }
                if (i == 8211) {
                    x0xO0oo2 = x0xO0oo();
                } else if (i == 8142) {
                    MediationApiLog.i("GdtReward", "GdtSplashLoader bidWinNotify");
                    Map<String, Object> map = (Map) valueSet.objectValue(8006, Map.class);
                    if (map != null) {
                        X0o0xo(map);
                    }
                } else if (i == 8144) {
                    MediationApiLog.i("GdtReward", "GdtSplashLoader bidLoseNotify");
                    Map<String, Object> map2 = (Map) valueSet.objectValue(8006, Map.class);
                    if (map2 != null) {
                        oOoXoXO(map2);
                    }
                } else if (i == 8147) {
                    return (T) IXxxXO();
                }
            }
            return (T) Boolean.valueOf(x0xO0oo2);
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
    public boolean hasDestroyed() {
        if (this.f35499XO == null) {
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
    public MediationConstant.AdIsReadyStatus isReadyStatus() {
        if (this.f35496Oo) {
            return oIX0oI();
        }
        return II0XooXoX();
    }

    public void oOoXoXO(Map<String, Object> map) {
        if (!this.f35500oI0IIXIo.isClientBidding() || this.f35499XO == null || map == null) {
            return;
        }
        try {
            Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
            if (obj instanceof MediationConstant.BiddingLossReason) {
                int oIX0oI2 = xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj);
                if (this.f35496Oo) {
                    oOoXoXO.I0Io(new XO(oIX0oI2));
                } else {
                    this.f35499XO.sendLossNotification(0, oIX0oI2, null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
    public void onDestroy() {
        if (this.f35499XO != null) {
            this.f35499XO = null;
        }
    }

    public void oxoX(Context context) {
        boolean z = this.f35496Oo;
        Context applicationContext = context.getApplicationContext();
        if (z) {
            OOXIXo(applicationContext);
        } else {
            oO(applicationContext);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    /* loaded from: classes.dex */
    public class oxoX implements RewardVideoADListener {
        public oxoX() {
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        @JProtect
        public void onADClick() {
            if (xoIox.this.f35497Oxx0xo != null) {
                xoIox.this.f35497Oxx0xo.call(8115, null, Void.class);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        @JProtect
        public void onADClose() {
            if (xoIox.this.f35497Oxx0xo != null) {
                xoIox.this.f35497Oxx0xo.call(8116, null, Void.class);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        @JProtect
        public void onADLoad() {
            double d;
            if (xoIox.this.f35499XO != null) {
                if (xoIox.this.f35500oI0IIXIo.isClientBidding()) {
                    xoIox xoiox = xoIox.this;
                    if (xoiox.f35499XO.getECPM() != -1) {
                        d = xoIox.this.f35499XO.getECPM();
                    } else {
                        d = XIXIX.OOXIXo.f3760XO;
                    }
                    xoiox.setCpm(d);
                } else if (xoIox.this.f35500oI0IIXIo.isMultiBidding()) {
                    xoIox xoiox2 = xoIox.this;
                    xoiox2.setLevelTag(xoiox2.f35499XO.getECPMLevel());
                } else {
                    xoIox.this.f35500oI0IIXIo.isServerBidding();
                }
                GdtRewardLoader gdtRewardLoader = xoIox.this.f35500oI0IIXIo;
                xoIox xoiox3 = xoIox.this;
                gdtRewardLoader.notifyAdSuccess(xoiox3, xoiox3.f35497Oxx0xo);
                return;
            }
            xoIox.this.f35500oI0IIXIo.notifyAdFailed(80001, "load成功但广告为空");
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        @JProtect
        public void onADShow() {
            if (xoIox.this.f35497Oxx0xo != null) {
                xoIox.this.f35497Oxx0xo.call(8230, null, Void.class);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        @JProtect
        public void onError(AdError adError) {
            if (adError != null) {
                xoIox.this.f35500oI0IIXIo.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
            } else {
                xoIox.this.f35500oI0IIXIo.notifyAdFailed(80001, "error is null");
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        @JProtect
        public void onReward(Map<String, Object> map) {
            if (xoIox.this.f35497Oxx0xo != null) {
                MediationValueSetBuilder create = MediationValueSetBuilder.create();
                create.add(UIMsg.m_AppUI.MSG_MAP_HOTKEYSOPEN, true);
                create.add(UIMsg.m_AppUI.MSG_SUG_TEXTCHAGNE, xoIox.this.f35495IXxxXO.getRewardAmount());
                create.add(8019, xoIox.this.f35495IXxxXO.getRewardName());
                create.add(8020, map);
                xoIox.this.f35497Oxx0xo.call(8231, create.build(), Void.class);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        @JProtect
        public void onVideoCached() {
            xoIox.this.f35500oI0IIXIo.notifyAdCache(xoIox.this.f35497Oxx0xo, -1, "");
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        @JProtect
        public void onVideoComplete() {
            if (xoIox.this.f35497Oxx0xo != null) {
                xoIox.this.f35497Oxx0xo.call(8118, null, Void.class);
            }
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
        }
    }
}
