package OOxOOxIO;

import com.baidu.ar.base.MsgField;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.banner2.UnifiedBannerView;
import java.util.Map;

/* loaded from: classes6.dex */
public class oIX0oI implements Bridge {

    /* renamed from: Oo, reason: collision with root package name */
    public Bridge f1849Oo;

    /* renamed from: XO, reason: collision with root package name */
    public UnifiedBannerView f1850XO;

    public oIX0oI(UnifiedBannerView unifiedBannerView) {
        this.f1850XO = unifiedBannerView;
    }

    private void I0Io(Map<String, Object> map) {
        if (map != null && this.f1850XO != null) {
            Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
            if (obj instanceof MediationConstant.BiddingLossReason) {
                this.f1850XO.sendLossNotification(0, xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj), null);
            }
        }
    }

    private void II0xO0(int i) {
        UnifiedBannerView unifiedBannerView = this.f1850XO;
        if (unifiedBannerView != null) {
            unifiedBannerView.sendWinNotification(i);
        }
    }

    private void Oxx0IOOO() {
        UnifiedBannerView unifiedBannerView = this.f1850XO;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
        }
    }

    public final Map<String, Object> II0XooXoX() {
        UnifiedBannerView unifiedBannerView = this.f1850XO;
        if (unifiedBannerView != null) {
            return unifiedBannerView.getExtraInfo();
        }
        return null;
    }

    public void X0o0xo() {
        Bridge bridge = this.f1849Oo;
        if (bridge != null) {
            bridge.call(60006, null, Void.class);
        }
    }

    public void XO() {
        Bridge bridge = this.f1849Oo;
        if (bridge != null) {
            bridge.call(60012, null, Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        Object obj;
        int i2;
        boolean z;
        if (i == 40035) {
            return (T) this.f1850XO;
        }
        if (i == 40010) {
            UnifiedBannerView unifiedBannerView = this.f1850XO;
            if (unifiedBannerView != null) {
                z = unifiedBannerView.isValid();
            } else {
                z = false;
            }
            T t = (T) Boolean.valueOf(z);
            OxxIIOOXO.oIX0oI("isValid  flag  = " + t);
            return t;
        }
        if (i == 40011) {
            OxxIIOOXO.oIX0oI("onDestroy");
            Oxx0IOOO();
            return null;
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
        if (i == 40009) {
            this.f1849Oo = (Bridge) valueSet.objectValue(MsgField.MSG_HIDE_UI_BTN, Bridge.class);
            return null;
        }
        if (i == 40015) {
            T t2 = (T) II0XooXoX();
            OxxIIOOXO.oIX0oI("getExtraInfo  map  = " + t2);
            return t2;
        }
        if (i == 40003) {
            UnifiedBannerView unifiedBannerView2 = this.f1850XO;
            if (unifiedBannerView2 != null) {
                i2 = unifiedBannerView2.getECPM();
            } else {
                i2 = -1;
            }
            OxxIIOOXO.oIX0oI("getECPM ecpm = " + i2);
            return (T) Integer.valueOf(i2);
        }
        if (i == 40004) {
            UnifiedBannerView unifiedBannerView3 = this.f1850XO;
            if (unifiedBannerView3 != null) {
                obj = (T) unifiedBannerView3.getECPMLevel();
            } else {
                obj = (T) "";
            }
            OxxIIOOXO.oIX0oI("getECPMLevel level = " + ((String) obj));
            return (T) obj;
        }
        return null;
    }

    public void oIX0oI() {
        Bridge bridge = this.f1849Oo;
        if (bridge != null) {
            bridge.call(60009, null, Void.class);
        }
    }

    public void oxoX() {
        Bridge bridge = this.f1849Oo;
        if (bridge != null) {
            bridge.call(60004, null, Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
