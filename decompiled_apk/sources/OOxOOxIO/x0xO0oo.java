package OOxOOxIO;

import android.app.Activity;
import com.baidu.ar.base.MsgField;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import java.util.Map;

/* loaded from: classes6.dex */
public class x0xO0oo implements Bridge {

    /* renamed from: Oo, reason: collision with root package name */
    public Bridge f1880Oo;

    /* renamed from: XO, reason: collision with root package name */
    public RewardVideoAD f1881XO;

    public x0xO0oo(RewardVideoAD rewardVideoAD) {
        this.f1881XO = rewardVideoAD;
    }

    private void II0XooXoX() {
        if (this.f1881XO != null) {
            this.f1881XO = null;
        }
    }

    private void II0xO0(int i) {
        RewardVideoAD rewardVideoAD = this.f1881XO;
        if (rewardVideoAD != null) {
            rewardVideoAD.sendWinNotification(i);
        }
    }

    private void X0o0xo(Map<String, Object> map) {
        if (map != null && this.f1881XO != null) {
            Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
            if (obj instanceof MediationConstant.BiddingLossReason) {
                this.f1881XO.sendLossNotification(0, xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj), null);
            }
        }
    }

    private Map<String, Object> xxIXOIIO() {
        RewardVideoAD rewardVideoAD = this.f1881XO;
        if (rewardVideoAD != null) {
            return rewardVideoAD.getExtraInfo();
        }
        return null;
    }

    public void I0Io(Map<String, Object> map) {
        if (this.f1880Oo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(MsgField.MSG_SESSION_INVALID, map);
            this.f1880Oo.call(60007, create.build(), Void.class);
        }
    }

    public void Oxx0IOOO() {
        Bridge bridge = this.f1880Oo;
        if (bridge != null) {
            bridge.call(60006, null, Void.class);
        }
    }

    public void XO() {
        Bridge bridge = this.f1880Oo;
        if (bridge != null) {
            bridge.call(60005, null, Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        Object obj;
        int i2;
        if (i == 40003) {
            RewardVideoAD rewardVideoAD = this.f1881XO;
            if (rewardVideoAD != null) {
                i2 = rewardVideoAD.getECPM();
            } else {
                i2 = -1;
            }
            OxxIIOOXO.oIX0oI("getECPM ecpm = " + i2);
            return (T) Integer.valueOf(i2);
        }
        if (i == 40007 && this.f1881XO != null) {
            int intValue = valueSet.intValue(MsgField.IMSG_VPS_CREATE_SESSION_FAIL);
            OxxIIOOXO.oIX0oI("setBidECPM ecpm = " + intValue);
            this.f1881XO.setBidECPM(intValue);
        }
        if (i == 40004) {
            RewardVideoAD rewardVideoAD2 = this.f1881XO;
            if (rewardVideoAD2 != null) {
                obj = (T) rewardVideoAD2.getECPMLevel();
            } else {
                obj = (T) "";
            }
            OxxIIOOXO.oIX0oI("getECPMLevel level = " + ((String) obj));
            return (T) obj;
        }
        if (i == 40008) {
            Activity activity = (Activity) valueSet.objectValue(MsgField.MSG_MOBILE_NETWORK_NOT_USED, Activity.class);
            if (this.f1881XO != null && activity != null) {
                OxxIIOOXO.oIX0oI("showAD  activity  = " + activity);
                this.f1881XO.showAD(activity);
                return null;
            }
            return null;
        }
        if (i == 40009) {
            this.f1880Oo = (Bridge) valueSet.objectValue(MsgField.MSG_HIDE_UI_BTN, Bridge.class);
            return null;
        }
        boolean z = false;
        if (i == 40010) {
            RewardVideoAD rewardVideoAD3 = this.f1881XO;
            if (rewardVideoAD3 != null) {
                z = rewardVideoAD3.isValid();
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
            if (this.f1881XO == null) {
                z = true;
            }
            T t2 = (T) Boolean.valueOf(z);
            OxxIIOOXO.oIX0oI("hasDestroy  flag  = " + t2);
            return t2;
        }
        if (i == 40013) {
            int intValue2 = valueSet.intValue(40013);
            OxxIIOOXO.oIX0oI("sendWinNotification  ecpm  = " + intValue2);
            II0xO0(intValue2);
            return null;
        }
        if (i == 40014) {
            Map<String, Object> map = (Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class);
            OxxIIOOXO.oIX0oI("sendLossNotification  map  = " + map);
            X0o0xo(map);
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
        Bridge bridge = this.f1880Oo;
        if (bridge != null) {
            bridge.call(60002, null, Void.class);
        }
    }

    public void oxoX() {
        Bridge bridge = this.f1880Oo;
        if (bridge != null) {
            bridge.call(60004, null, Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
