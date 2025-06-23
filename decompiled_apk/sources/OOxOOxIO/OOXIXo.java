package OOxOOxIO;

import android.app.Activity;
import com.baidu.ar.base.MsgField;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import java.util.Map;

/* loaded from: classes6.dex */
public class OOXIXo implements Bridge {

    /* renamed from: Oo, reason: collision with root package name */
    public Bridge f1829Oo;

    /* renamed from: XO, reason: collision with root package name */
    public UnifiedInterstitialAD f1830XO;

    public OOXIXo(UnifiedInterstitialAD unifiedInterstitialAD) {
        this.f1830XO = unifiedInterstitialAD;
    }

    private void I0Io(Map<String, Object> map) {
        if (map != null && this.f1830XO != null) {
            Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
            if (obj instanceof MediationConstant.BiddingLossReason) {
                this.f1830XO.sendLossNotification(0, xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj), null);
            }
        }
    }

    private void II0XooXoX() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f1830XO;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
            this.f1830XO = null;
        }
    }

    private void II0xO0(int i) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f1830XO;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.sendWinNotification(i);
        }
    }

    public void Oxx0IOOO() {
        Bridge bridge = this.f1829Oo;
        if (bridge != null) {
            bridge.call(60012, null, Void.class);
        }
    }

    public void X0o0xo() {
        Bridge bridge = this.f1829Oo;
        if (bridge != null) {
            bridge.call(60006, null, Void.class);
        }
    }

    public void XO() {
        Bridge bridge = this.f1829Oo;
        if (bridge != null) {
            bridge.call(60011, null, Void.class);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 40008) {
            Activity activity = (Activity) valueSet.objectValue(MsgField.MSG_MOBILE_NETWORK_NOT_USED, Activity.class);
            if (this.f1830XO != null && activity != null) {
                OxxIIOOXO.oIX0oI("showAD  activity  = " + activity);
                this.f1830XO.show(activity);
                return null;
            }
            return null;
        }
        if (i == 40009) {
            this.f1829Oo = (Bridge) valueSet.objectValue(MsgField.MSG_HIDE_UI_BTN, Bridge.class);
            return null;
        }
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        if (i == 40010) {
            UnifiedInterstitialAD unifiedInterstitialAD = this.f1830XO;
            if (unifiedInterstitialAD != null) {
                z = unifiedInterstitialAD.isValid();
            }
            T t = (T) Boolean.valueOf(z);
            OxxIIOOXO.oIX0oI("isValid  flag  = " + t);
            return t;
        }
        if (i == 40011) {
            OxxIIOOXO.oIX0oI("onDestroy");
            II0XooXoX();
            return null;
        }
        if (i == 40012) {
            if (this.f1830XO == null) {
                z2 = true;
            }
            T t2 = (T) Boolean.valueOf(z2);
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
            I0Io(map);
            return null;
        }
        if (i == 40015) {
            T t3 = (T) xxIXOIIO();
            OxxIIOOXO.oIX0oI("getExtraInfo  map  = " + t3);
            return t3;
        }
        if (i == 40021) {
            UnifiedInterstitialAD unifiedInterstitialAD2 = this.f1830XO;
            if (unifiedInterstitialAD2 != null) {
                i2 = unifiedInterstitialAD2.getAdPatternType();
            }
            OxxIIOOXO.oIX0oI("getAdPatternType adPatternType = " + i2);
            return (T) Integer.valueOf(i2);
        }
        return null;
    }

    public void oIX0oI() {
        Bridge bridge = this.f1829Oo;
        if (bridge != null) {
            bridge.call(60009, null, Void.class);
        }
    }

    public void oxoX() {
        Bridge bridge = this.f1829Oo;
        if (bridge != null) {
            bridge.call(60004, null, Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public final Map<String, Object> xxIXOIIO() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f1830XO;
        if (unifiedInterstitialAD != null) {
            return unifiedInterstitialAD.getExtraInfo();
        }
        return null;
    }
}
