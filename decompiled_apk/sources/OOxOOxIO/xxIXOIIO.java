package OOxOOxIO;

import android.app.Activity;
import com.baidu.ar.base.MsgField;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* loaded from: classes6.dex */
public class xxIXOIIO implements Bridge {

    /* renamed from: Oo, reason: collision with root package name */
    public Bridge f1887Oo;

    /* renamed from: XO, reason: collision with root package name */
    public UnifiedInterstitialAD f1888XO;

    /* loaded from: classes6.dex */
    public class II0xO0 implements ADRewardListener {
        public II0xO0() {
        }

        @Override // com.qq.e.comm.listeners.ADRewardListener
        public void onReward(Map<String, Object> map) {
            OxxIIOOXO.oIX0oI("onReward map = " + map);
            xxIXOIIO.this.oxoX(map);
        }
    }

    public xxIXOIIO(UnifiedInterstitialAD unifiedInterstitialAD) {
        this.f1888XO = unifiedInterstitialAD;
    }

    private void II0xO0(int i) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f1888XO;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.sendWinNotification(i);
        }
    }

    private void OOXIXo() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f1888XO;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setMediaListener(new oIX0oI());
        }
    }

    private void XO(Map<String, Object> map) {
        if (map != null && this.f1888XO != null) {
            Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
            if (obj instanceof MediationConstant.BiddingLossReason) {
                this.f1888XO.sendLossNotification(0, xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj), null);
            }
        }
    }

    private void oOoXoXO() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f1888XO;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setRewardListener(new II0xO0());
        }
    }

    private Map<String, Object> xoIox() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f1888XO;
        if (unifiedInterstitialAD != null) {
            return unifiedInterstitialAD.getExtraInfo();
        }
        return null;
    }

    private void xxIXOIIO() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f1888XO;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
            this.f1888XO = null;
        }
    }

    public void I0Io(AdError adError) {
        if (this.f1887Oo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(50006, new II0XooXoX(adError));
            this.f1887Oo.call(60010, create.build(), Void.class);
        }
    }

    public void II0XooXoX() {
        Bridge bridge = this.f1887Oo;
        if (bridge != null) {
            bridge.call(60006, null, Void.class);
        }
    }

    public void Oxx0IOOO() {
        Bridge bridge = this.f1887Oo;
        if (bridge != null) {
            bridge.call(60005, null, Void.class);
        }
    }

    public void X0o0xo() {
        Bridge bridge = this.f1887Oo;
        if (bridge != null) {
            bridge.call(60004, null, Void.class);
        }
    }

    /* JADX WARN: Type inference failed for: r2v35, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        ?? r2;
        int i2;
        if (i == 40003) {
            UnifiedInterstitialAD unifiedInterstitialAD = this.f1888XO;
            if (unifiedInterstitialAD != null) {
                i2 = unifiedInterstitialAD.getECPM();
            } else {
                i2 = -1;
            }
            OxxIIOOXO.oIX0oI("getECPM ecpm = " + i2);
            return (T) Integer.valueOf(i2);
        }
        if (i == 40004) {
            UnifiedInterstitialAD unifiedInterstitialAD2 = this.f1888XO;
            if (unifiedInterstitialAD2 != null) {
                r2 = (T) unifiedInterstitialAD2.getECPMLevel();
            } else {
                r2 = (T) "";
            }
            OxxIIOOXO.oIX0oI("getECPMLevel level = " + ((String) r2));
            return (T) r2;
        }
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        if (i == 40021) {
            UnifiedInterstitialAD unifiedInterstitialAD3 = this.f1888XO;
            if (unifiedInterstitialAD3 != null) {
                i3 = unifiedInterstitialAD3.getAdPatternType();
            }
            OxxIIOOXO.oIX0oI("getAdPatternType adPatternType = " + i3);
            return (T) Integer.valueOf(i3);
        }
        if (i == 40022) {
            OxxIIOOXO.oIX0oI("setMediaListener");
            OOXIXo();
            return null;
        }
        if (i == 40023) {
            OxxIIOOXO.oIX0oI("setRewardListener");
            oOoXoXO();
            return null;
        }
        if (i == 40008) {
            Activity activity = (Activity) valueSet.objectValue(MsgField.MSG_MOBILE_NETWORK_NOT_USED, Activity.class);
            if (this.f1888XO != null && activity != null) {
                OxxIIOOXO.oIX0oI("showFullScreenAD  activity  = " + activity);
                this.f1888XO.showFullScreenAD(activity);
                return null;
            }
            return null;
        }
        if (i == 40009) {
            this.f1887Oo = (Bridge) valueSet.objectValue(MsgField.MSG_HIDE_UI_BTN, Bridge.class);
            return null;
        }
        if (i == 40010) {
            UnifiedInterstitialAD unifiedInterstitialAD4 = this.f1888XO;
            if (unifiedInterstitialAD4 != null) {
                z2 = unifiedInterstitialAD4.isValid();
            }
            T t = (T) Boolean.valueOf(z2);
            OxxIIOOXO.oIX0oI("isValid  flag  = " + t);
            return t;
        }
        if (i == 40011) {
            OxxIIOOXO.oIX0oI("onDestroy");
            xxIXOIIO();
            return null;
        }
        if (i == 40012) {
            if (this.f1888XO == null) {
                z = true;
            }
            T t2 = (T) Boolean.valueOf(z);
            OxxIIOOXO.oIX0oI("hasDestroy  flag  = " + t2);
            return t2;
        }
        if (i == 40013) {
            int intValue = valueSet.intValue(40013);
            OxxIIOOXO.oIX0oI("sendWinNotification  ecpm  = " + intValue);
            II0xO0(intValue);
            return null;
        }
        if (i == 40014) {
            Map<String, Object> map = (Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class);
            OxxIIOOXO.oIX0oI("sendLossNotification  map  = " + map);
            XO(map);
            return null;
        }
        if (i == 40015) {
            T t3 = (T) xoIox();
            OxxIIOOXO.oIX0oI("getExtraInfo  map  = " + t3);
            return t3;
        }
        return null;
    }

    public void oIX0oI() {
        Bridge bridge = this.f1887Oo;
        if (bridge != null) {
            bridge.call(60009, null, Void.class);
        }
    }

    public void oxoX(Map<String, Object> map) {
        if (this.f1887Oo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(MsgField.MSG_SESSION_INVALID, map);
            this.f1887Oo.call(60007, create.build(), Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements UnifiedInterstitialMediaListener {
        public oIX0oI() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoComplete() {
            OxxIIOOXO.oIX0oI("onVideoComplete");
            xxIXOIIO.this.Oxx0IOOO();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
        public void onVideoError(AdError adError) {
            OxxIIOOXO.oIX0oI("onVideoError adError = " + adError);
            xxIXOIIO.this.I0Io(adError);
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
}
