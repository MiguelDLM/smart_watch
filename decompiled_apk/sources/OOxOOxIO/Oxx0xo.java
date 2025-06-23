package OOxOOxIO;

import android.view.ViewGroup;
import com.baidu.ar.base.MsgField;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.splash.SplashAD;
import java.util.Map;

/* loaded from: classes6.dex */
public class Oxx0xo implements Bridge {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public oI0IIXIo f1831IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public Bridge f1832Oo;

    /* renamed from: XO, reason: collision with root package name */
    public SplashAD f1833XO;

    public Oxx0xo(SplashAD splashAD, oI0IIXIo oi0iixio) {
        this.f1833XO = splashAD;
        this.f1831IXxxXO = oi0iixio;
    }

    private void I0Io(Map<String, Object> map) {
        if (map != null && this.f1833XO != null) {
            Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
            if (obj instanceof MediationConstant.BiddingLossReason) {
                this.f1833XO.sendLossNotification(0, xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj), null);
            }
        }
    }

    private void II0XooXoX() {
        this.f1833XO = null;
        oI0IIXIo oi0iixio = this.f1831IXxxXO;
        if (oi0iixio != null) {
            oi0iixio.II0xO0();
            this.f1831IXxxXO = null;
        }
    }

    private void II0xO0(int i) {
        SplashAD splashAD = this.f1833XO;
        if (splashAD != null) {
            splashAD.sendWinNotification(i);
        }
    }

    private Map<String, Object> xxIXOIIO() {
        SplashAD splashAD = this.f1833XO;
        if (splashAD != null) {
            return splashAD.getExtraInfo();
        }
        return null;
    }

    public void Oxx0IOOO() {
        Bridge bridge = this.f1832Oo;
        if (bridge != null) {
            bridge.call(60015, null, Void.class);
        }
    }

    public void X0o0xo() {
        Bridge bridge = this.f1832Oo;
        if (bridge != null) {
            bridge.call(60013, null, Void.class);
        }
    }

    public void XO() {
        Bridge bridge = this.f1832Oo;
        if (bridge != null) {
            bridge.call(60014, null, Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        Object obj;
        int i2;
        if (i == 40003) {
            SplashAD splashAD = this.f1833XO;
            if (splashAD != null) {
                i2 = splashAD.getECPM();
            } else {
                i2 = -1;
            }
            OxxIIOOXO.oIX0oI("getECPM ecpm = " + i2);
            return (T) Integer.valueOf(i2);
        }
        if (i == 40004) {
            SplashAD splashAD2 = this.f1833XO;
            if (splashAD2 != null) {
                obj = (T) splashAD2.getECPMLevel();
            } else {
                obj = (T) "";
            }
            OxxIIOOXO.oIX0oI("getECPMLevel level = " + ((String) obj));
            return (T) obj;
        }
        if (i == 40008) {
            ViewGroup viewGroup = (ViewGroup) valueSet.objectValue(MsgField.MSG_MARKER_CREATE_SESSION_END, ViewGroup.class);
            if (this.f1833XO != null && viewGroup != null) {
                OxxIIOOXO.oIX0oI("showAD  viewGroup  = " + viewGroup);
                this.f1833XO.showAd(viewGroup);
                return null;
            }
            return null;
        }
        if (i == 40029) {
            ViewGroup viewGroup2 = (ViewGroup) valueSet.objectValue(MsgField.MSG_MARKER_CREATE_SESSION_END, ViewGroup.class);
            if (this.f1833XO != null && viewGroup2 != null) {
                OxxIIOOXO.oIX0oI("showAD  viewGroup  = " + viewGroup2);
                this.f1833XO.showFullScreenAd(viewGroup2);
                return null;
            }
            return null;
        }
        if (i == 40009) {
            this.f1832Oo = (Bridge) valueSet.objectValue(MsgField.MSG_HIDE_UI_BTN, Bridge.class);
            return null;
        }
        boolean z = false;
        if (i == 40010) {
            SplashAD splashAD3 = this.f1833XO;
            if (splashAD3 != null) {
                z = splashAD3.isValid();
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
            if (this.f1833XO == null) {
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
            I0Io(map);
            return null;
        }
        if (i == 40015) {
            T t3 = (T) xxIXOIIO();
            OxxIIOOXO.oIX0oI("getExtraInfo  map  = " + t3);
            return t3;
        }
        return null;
    }

    public void oIX0oI() {
        Bridge bridge = this.f1832Oo;
        if (bridge != null) {
            bridge.call(60009, null, Void.class);
        }
    }

    public void oxoX() {
        Bridge bridge = this.f1832Oo;
        if (bridge != null) {
            bridge.call(60004, null, Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
