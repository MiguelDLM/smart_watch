package OOxOOxIO;

import com.baidu.ar.base.MsgField;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* loaded from: classes6.dex */
public class x0XOIxOo implements Bridge {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public volatile boolean f1875IXxxXO = false;

    /* renamed from: Oo, reason: collision with root package name */
    public Bridge f1876Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public oO f1877Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public NativeExpressADView f1878XO;

    public x0XOIxOo(oO oOVar, NativeExpressADView nativeExpressADView) {
        this.f1877Oxx0xo = oOVar;
        this.f1878XO = nativeExpressADView;
    }

    private void II0xO0(int i) {
        NativeExpressADView nativeExpressADView = this.f1878XO;
        if (nativeExpressADView != null) {
            nativeExpressADView.sendWinNotification(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OOXIXo() {
        Bridge bridge = this.f1876Oo;
        if (bridge != null) {
            bridge.call(60005, null, Void.class);
        }
    }

    private void Oo() {
        this.f1875IXxxXO = true;
        oO oOVar = this.f1877Oxx0xo;
        if (oOVar != null) {
            oOVar.Oxx0IOOO(this.f1878XO);
        }
        NativeExpressADView nativeExpressADView = this.f1878XO;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0o0xo(AdError adError) {
        if (this.f1876Oo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(50006, new II0XooXoX(adError));
            this.f1876Oo.call(60010, create.build(), Void.class);
        }
    }

    private void XO(Map<String, Object> map) {
        if (map != null && this.f1878XO != null) {
            Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
            if (obj instanceof MediationConstant.BiddingLossReason) {
                this.f1878XO.sendLossNotification(0, xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj), null);
            }
        }
    }

    private String ooOOo0oXI() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f1878XO;
        if (nativeExpressADView != null && (boundData = nativeExpressADView.getBoundData()) != null) {
            return boundData.getTitle();
        }
        return "";
    }

    private String x0XOIxOo() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f1878XO;
        if (nativeExpressADView != null && (boundData = nativeExpressADView.getBoundData()) != null) {
            return boundData.getDesc();
        }
        return "";
    }

    private String x0xO0oo() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f1878XO;
        if (nativeExpressADView != null && (boundData = nativeExpressADView.getBoundData()) != null) {
            return boundData.getECPMLevel();
        }
        return "";
    }

    public void II0XooXoX() {
        Bridge bridge = this.f1876Oo;
        if (bridge != null) {
            bridge.call(60009, null, Void.class);
        }
    }

    public final Map<String, Object> IXxxXO() {
        NativeExpressADView nativeExpressADView = this.f1878XO;
        if (nativeExpressADView != null) {
            return nativeExpressADView.getExtraInfo();
        }
        return null;
    }

    public void Oxx0IOOO() {
        if (this.f1876Oo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(MsgField.MSG_MARKER_CREATE_SESSION_FAIL, -1);
            create.add(MsgField.MSG_MARKER_ALGO_FAIL, -2);
            this.f1876Oo.call(60017, create.build(), Void.class);
        }
    }

    public final void Oxx0xo() {
        NativeExpressADView nativeExpressADView = this.f1878XO;
        if (nativeExpressADView != null) {
            nativeExpressADView.render();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v27, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v28, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v33, types: [T, java.lang.String] */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 40003) {
            int oO2 = oO();
            OxxIIOOXO.oIX0oI("getECPM ecpm = " + oO2);
            return (T) Integer.valueOf(oO2);
        }
        if (i == 40004) {
            ?? r1 = (T) x0xO0oo();
            OxxIIOOXO.oIX0oI("getECPMLevel level = " + ((String) r1));
            return r1;
        }
        if (i == 40021) {
            int oOoXoXO2 = oOoXoXO();
            OxxIIOOXO.oIX0oI("getAdPatternType adPatternType = " + oOoXoXO2);
            return (T) Integer.valueOf(oOoXoXO2);
        }
        if (i == 40022) {
            OxxIIOOXO.oIX0oI("setMediaListener");
            oI0IIXIo();
            return null;
        }
        if (i == 40032) {
            ?? r12 = (T) ooOOo0oXI();
            OxxIIOOXO.oIX0oI("getTitle title = " + ((String) r12));
            return r12;
        }
        if (i == 40033) {
            ?? r13 = (T) x0XOIxOo();
            OxxIIOOXO.oIX0oI("desc title = " + ((String) r13));
            return r13;
        }
        if (i == 40034) {
            OxxIIOOXO.oIX0oI("render");
            Oxx0xo();
            return null;
        }
        if (i == 40007) {
            if (this.f1878XO != null) {
                int intValue = valueSet.intValue(MsgField.IMSG_VPS_CREATE_SESSION_FAIL);
                OxxIIOOXO.oIX0oI("setBidECPM ecpm = " + intValue);
                this.f1878XO.setBidECPM(intValue);
                return null;
            }
            return null;
        }
        if (i == 40035) {
            OxxIIOOXO.oIX0oI("ad view = " + this.f1878XO);
            return (T) this.f1878XO;
        }
        if (i == 40011) {
            OxxIIOOXO.oIX0oI("onDestroy");
            Oo();
            return null;
        }
        if (i == 40012) {
            T t = (T) Boolean.valueOf(this.f1875IXxxXO);
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
            XO(map);
            return null;
        }
        if (i == 40009) {
            this.f1876Oo = (Bridge) valueSet.objectValue(MsgField.MSG_HIDE_UI_BTN, Bridge.class);
            return null;
        }
        if (i == 40015) {
            T t2 = (T) IXxxXO();
            OxxIIOOXO.oIX0oI("getExtraInfo  map  = " + t2);
            return t2;
        }
        return null;
    }

    public final void oI0IIXIo() {
        NativeExpressADView nativeExpressADView = this.f1878XO;
        if (nativeExpressADView != null) {
            nativeExpressADView.setMediaListener(new oIX0oI());
        }
    }

    public void oIX0oI() {
        Bridge bridge = this.f1876Oo;
        if (bridge != null) {
            bridge.call(60016, null, Void.class);
        }
    }

    public final int oO() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f1878XO;
        if (nativeExpressADView != null && (boundData = nativeExpressADView.getBoundData()) != null) {
            return boundData.getECPM();
        }
        return 0;
    }

    public final int oOoXoXO() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f1878XO;
        if (nativeExpressADView != null && (boundData = nativeExpressADView.getBoundData()) != null) {
            return boundData.getAdPatternType();
        }
        return 4;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public void xoIox() {
        Bridge bridge = this.f1876Oo;
        if (bridge != null) {
            bridge.call(60006, null, Void.class);
        }
    }

    public void xxIXOIIO() {
        Bridge bridge = this.f1876Oo;
        if (bridge != null) {
            bridge.call(60004, null, Void.class);
        }
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements NativeExpressMediaListener {
        public oIX0oI() {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoComplete(NativeExpressADView nativeExpressADView) {
            OxxIIOOXO.oIX0oI("onVideoComplete nativeExpressADView = " + nativeExpressADView);
            x0XOIxOo.this.OOXIXo();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoError(NativeExpressADView nativeExpressADView, AdError adError) {
            OxxIIOOXO.oIX0oI("onVideoError nativeExpressADView = " + nativeExpressADView + " adError = " + adError);
            x0XOIxOo.this.X0o0xo(adError);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoCached(NativeExpressADView nativeExpressADView) {
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
        public void onVideoReady(NativeExpressADView nativeExpressADView, long j) {
        }
    }
}
