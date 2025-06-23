package OOxOOxIO;

import com.baidu.ar.base.MsgField;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* loaded from: classes6.dex */
public class oxoX implements Bridge {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public volatile boolean f1871IXxxXO = false;

    /* renamed from: Oo, reason: collision with root package name */
    public Bridge f1872Oo;

    /* renamed from: XO, reason: collision with root package name */
    public NativeExpressADView f1873XO;

    public oxoX(NativeExpressADView nativeExpressADView) {
        this.f1873XO = nativeExpressADView;
    }

    private void I0Io(Map<String, Object> map) {
        if (map != null && this.f1873XO != null) {
            Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
            if (obj instanceof MediationConstant.BiddingLossReason) {
                this.f1873XO.sendLossNotification(0, xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj), null);
            }
        }
    }

    private String II0XooXoX() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f1873XO;
        if (nativeExpressADView != null && (boundData = nativeExpressADView.getBoundData()) != null) {
            return boundData.getTitle();
        }
        return "";
    }

    private void II0xO0(int i) {
        NativeExpressADView nativeExpressADView = this.f1873XO;
        if (nativeExpressADView != null) {
            nativeExpressADView.sendWinNotification(i);
        }
    }

    private String OOXIXo() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f1873XO;
        if (nativeExpressADView != null && (boundData = nativeExpressADView.getBoundData()) != null) {
            return boundData.getECPMLevel();
        }
        return "";
    }

    private int Oxx0IOOO() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f1873XO;
        if (nativeExpressADView != null && (boundData = nativeExpressADView.getBoundData()) != null) {
            return boundData.getAdPatternType();
        }
        return 4;
    }

    private int xoIox() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f1873XO;
        if (nativeExpressADView != null && (boundData = nativeExpressADView.getBoundData()) != null) {
            return boundData.getECPM();
        }
        return 0;
    }

    private String xxIXOIIO() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f1873XO;
        if (nativeExpressADView != null && (boundData = nativeExpressADView.getBoundData()) != null) {
            return boundData.getDesc();
        }
        return "";
    }

    public void X0o0xo() {
        Bridge bridge = this.f1872Oo;
        if (bridge != null) {
            bridge.call(60004, null, Void.class);
        }
    }

    public void XO() {
        Bridge bridge = this.f1872Oo;
        if (bridge != null) {
            bridge.call(60006, null, Void.class);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v27, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v28, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v33, types: [T, java.lang.String] */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 40003) {
            int xoIox2 = xoIox();
            OxxIIOOXO.oIX0oI("getECPM ecpm = " + xoIox2);
            return (T) Integer.valueOf(xoIox2);
        }
        if (i == 40004) {
            ?? r1 = (T) OOXIXo();
            OxxIIOOXO.oIX0oI("getECPMLevel level = " + ((String) r1));
            return r1;
        }
        if (i == 40021) {
            int Oxx0IOOO2 = Oxx0IOOO();
            OxxIIOOXO.oIX0oI("getAdPatternType adPatternType = " + Oxx0IOOO2);
            return (T) Integer.valueOf(Oxx0IOOO2);
        }
        if (i == 40022) {
            OxxIIOOXO.oIX0oI("setMediaListener");
            oO();
            return null;
        }
        if (i == 40032) {
            ?? r12 = (T) II0XooXoX();
            OxxIIOOXO.oIX0oI("getTitle title = " + ((String) r12));
            return r12;
        }
        if (i == 40033) {
            ?? r13 = (T) xxIXOIIO();
            OxxIIOOXO.oIX0oI("desc title = " + ((String) r13));
            return r13;
        }
        if (i == 40034) {
            OxxIIOOXO.oIX0oI("render");
            x0XOIxOo();
            return null;
        }
        if (i == 40007) {
            if (this.f1873XO != null) {
                int intValue = valueSet.intValue(MsgField.IMSG_VPS_CREATE_SESSION_FAIL);
                OxxIIOOXO.oIX0oI("setBidECPM ecpm = " + intValue);
                this.f1873XO.setBidECPM(intValue);
                return null;
            }
            return null;
        }
        if (i == 40035) {
            OxxIIOOXO.oIX0oI("ad view = " + this.f1873XO);
            return (T) this.f1873XO;
        }
        if (i == 40011) {
            OxxIIOOXO.oIX0oI("onDestroy");
            oOoXoXO();
            return null;
        }
        if (i == 40012) {
            T t = (T) Boolean.valueOf(this.f1871IXxxXO);
            OxxIIOOXO.oIX0oI("hasDestroy  flag  = " + t);
            return t;
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
            I0Io(map);
            return null;
        }
        if (i == 40009) {
            this.f1872Oo = (Bridge) valueSet.objectValue(MsgField.MSG_HIDE_UI_BTN, Bridge.class);
            return null;
        }
        if (i == 40015) {
            T t2 = (T) ooOOo0oXI();
            OxxIIOOXO.oIX0oI("getExtraInfo  map  = " + t2);
            return t2;
        }
        return null;
    }

    public void oIX0oI() {
        Bridge bridge = this.f1872Oo;
        if (bridge != null) {
            bridge.call(60012, null, Void.class);
        }
    }

    public final void oO() {
        NativeExpressADView nativeExpressADView = this.f1873XO;
        if (nativeExpressADView != null) {
            nativeExpressADView.setMediaListener(new oIX0oI());
        }
    }

    public final void oOoXoXO() {
        this.f1871IXxxXO = true;
        NativeExpressADView nativeExpressADView = this.f1873XO;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
        }
    }

    public final Map<String, Object> ooOOo0oXI() {
        NativeExpressADView nativeExpressADView = this.f1873XO;
        if (nativeExpressADView != null) {
            return nativeExpressADView.getExtraInfo();
        }
        return null;
    }

    public void oxoX() {
        Bridge bridge = this.f1872Oo;
        if (bridge != null) {
            bridge.call(60009, null, Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public final void x0XOIxOo() {
        NativeExpressADView nativeExpressADView = this.f1873XO;
        if (nativeExpressADView != null) {
            nativeExpressADView.render();
        }
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements NativeExpressMediaListener {
        public oIX0oI() {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoCached(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoComplete(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoInit(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoLoading(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoPageClose(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoPageOpen(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoPause(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoStart(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoError(NativeExpressADView nativeExpressADView, AdError adError) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoReady(NativeExpressADView nativeExpressADView, long j) {
        }
    }
}
