package OOxOOxIO;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.media2.session.SessionCommand;
import com.baidu.ar.base.MsgField;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class II0xO0 implements Bridge {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public NativeUnifiedAD f1812IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public NativeExpressAD f1813IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public ADSize f1814Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public OOxOOxIO.oIX0oI f1815Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public oxoX f1816OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public UnifiedBannerView f1817XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public Bridge f1819oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public final NativeExpressAD.NativeExpressADListener f1820xoXoI = new C0035II0xO0();

    /* renamed from: o00, reason: collision with root package name */
    public final NativeADUnifiedListener f1818o00 = new I0Io();

    /* loaded from: classes6.dex */
    public class I0Io implements NativeADUnifiedListener {
        public I0Io() {
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            int i;
            StringBuilder sb = new StringBuilder();
            sb.append("onADLoaded native list = ");
            sb.append(list);
            sb.append(" list.size = ");
            if (list != null) {
                i = list.size();
            } else {
                i = 0;
            }
            sb.append(i);
            OxxIIOOXO.oIX0oI(sb.toString());
            II0xO0.this.IXxxXO(list);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            OxxIIOOXO.oIX0oI("onNoAD adError = " + adError);
            II0xO0.this.xoIox(adError);
        }
    }

    /* renamed from: OOxOOxIO.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0035II0xO0 implements NativeExpressAD.NativeExpressADListener {
        public C0035II0xO0() {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            OxxIIOOXO.oIX0oI("onADClicked nativeExpressADView = " + nativeExpressADView);
            if (II0xO0.this.f1816OxxIIOOXO != null) {
                II0xO0.this.f1816OxxIIOOXO.X0o0xo();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            OxxIIOOXO.oIX0oI("onADClosed nativeExpressADView = " + nativeExpressADView);
            if (II0xO0.this.f1816OxxIIOOXO != null) {
                II0xO0.this.f1816OxxIIOOXO.XO();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            OxxIIOOXO.oIX0oI("onADExposure nativeExpressADView = " + nativeExpressADView);
            if (II0xO0.this.f1816OxxIIOOXO != null) {
                II0xO0.this.f1816OxxIIOOXO.oxoX();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            OxxIIOOXO.oIX0oI("onADClosed onADLeftApplication = " + nativeExpressADView);
            if (II0xO0.this.f1816OxxIIOOXO != null) {
                II0xO0.this.f1816OxxIIOOXO.oIX0oI();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            int i;
            StringBuilder sb = new StringBuilder();
            sb.append("onADLoaded express list = ");
            sb.append(list);
            sb.append(" list.size = ");
            if (list != null) {
                i = list.size();
            } else {
                i = 0;
            }
            sb.append(i);
            OxxIIOOXO.oIX0oI(sb.toString());
            II0xO0.this.OOXIXo(list);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            OxxIIOOXO.oIX0oI("onNoAD adError = " + adError);
            II0xO0.this.xoIox(adError);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            OxxIIOOXO.oIX0oI("onRenderFail nativeExpressADView = " + nativeExpressADView);
            II0xO0.this.xoIox(new AdError(80001, "render fail"));
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            OxxIIOOXO.oIX0oI("onRenderSuccess nativeExpressADView = " + nativeExpressADView);
            II0xO0.this.oI0IIXIo();
        }
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements UnifiedBannerADListener {
        public oIX0oI() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            OxxIIOOXO.oIX0oI("onADClicked ");
            if (II0xO0.this.f1815Oxx0xo != null) {
                II0xO0.this.f1815Oxx0xo.oxoX();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            OxxIIOOXO.oIX0oI("onADClosed ");
            if (II0xO0.this.f1815Oxx0xo != null) {
                II0xO0.this.f1815Oxx0xo.X0o0xo();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            OxxIIOOXO.oIX0oI("onADExposure ");
            if (II0xO0.this.f1815Oxx0xo != null) {
                II0xO0.this.f1815Oxx0xo.oIX0oI();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
            OxxIIOOXO.oIX0oI("onADLeftApplication ");
            if (II0xO0.this.f1815Oxx0xo != null) {
                II0xO0.this.f1815Oxx0xo.XO();
            }
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            OxxIIOOXO.oIX0oI("onADReceive");
            II0xO0.this.oIX0oI();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError adError) {
            OxxIIOOXO.oIX0oI("onNoAD adError = " + adError);
            II0xO0.this.xoIox(adError);
        }
    }

    private void II0xO0(int i) {
        OxxIIOOXO.oIX0oI("createAdSize expressWidth = " + i);
        this.f1814Oo = new ADSize(-1, -2);
        if (i > 0) {
            this.f1814Oo = new ADSize(i, -2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OOXIXo(List<NativeExpressADView> list) {
        if (list != null && list.size() > 0) {
            this.f1816OxxIIOOXO = new oxoX(list.get(0));
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(50005, this.f1816OxxIIOOXO);
            this.f1819oI0IIXIo.call(60000, create.build(), null);
        }
    }

    private void Oxx0xo(Map<String, Object> map) {
        int intValue;
        OxxIIOOXO.oIX0oI("setMaxVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MAX_VIDEO_DURATION);
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) > 0) {
                NativeExpressAD nativeExpressAD = this.f1813IXxxXO;
                if (nativeExpressAD != null) {
                    nativeExpressAD.setMaxVideoDuration(intValue);
                }
                NativeUnifiedAD nativeUnifiedAD = this.f1812IIXOooo;
                if (nativeUnifiedAD != null) {
                    nativeUnifiedAD.setMaxVideoDuration(intValue);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oI0IIXIo() {
        Bridge bridge = this.f1819oI0IIXIo;
        if (bridge != null) {
            bridge.call(60017, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oIX0oI() {
        if (this.f1819oI0IIXIo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            x0XOIxOo();
            create.add(50005, this.f1815Oxx0xo);
            this.f1819oI0IIXIo.call(60008, create.build(), null);
        }
    }

    private void oOoXoXO(Map<String, Object> map) {
        OxxIIOOXO.oIX0oI("setVideoOption map = " + map);
        VideoOption build = new VideoOption.Builder().build();
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_VIDEO_OPTION);
            if (obj instanceof VideoOption) {
                build = (VideoOption) obj;
            }
        }
        NativeExpressAD nativeExpressAD = this.f1813IXxxXO;
        if (nativeExpressAD != null) {
            nativeExpressAD.setVideoOption(build);
        }
    }

    private void x0XOIxOo() {
        UnifiedBannerView unifiedBannerView = this.f1817XO;
        if (unifiedBannerView != null) {
            this.f1815Oxx0xo = new OOxOOxIO.oIX0oI(unifiedBannerView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xoIox(AdError adError) {
        if (this.f1819oI0IIXIo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(50006, new II0XooXoX(adError));
            this.f1819oI0IIXIo.call(60001, create.build(), null);
        }
    }

    public final void II0XooXoX(Bridge bridge) {
        OxxIIOOXO.oIX0oI("loadAd = " + bridge);
        UnifiedBannerView unifiedBannerView = this.f1817XO;
        if (unifiedBannerView != null) {
            this.f1819oI0IIXIo = bridge;
            unifiedBannerView.loadAD();
        }
    }

    public final void IIXOooo(Map<String, Object> map) {
        int intValue;
        OxxIIOOXO.oIX0oI("setMinVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MIN_VIDEO_DURATION);
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) > 0) {
                NativeExpressAD nativeExpressAD = this.f1813IXxxXO;
                if (nativeExpressAD != null) {
                    nativeExpressAD.setMinVideoDuration(intValue);
                }
                NativeUnifiedAD nativeUnifiedAD = this.f1812IIXOooo;
                if (nativeUnifiedAD != null) {
                    nativeUnifiedAD.setMinVideoDuration(intValue);
                }
            }
        }
    }

    public final void IXxxXO(List<NativeUnifiedADData> list) {
        if (this.f1819oI0IIXIo != null && list != null && list.size() > 0) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(50005, new OOxOOxIO.I0Io(list.get(0)));
            this.f1819oI0IIXIo.call(60000, create.build(), null);
        }
    }

    public final void Oo(Bridge bridge, int i) {
        OxxIIOOXO.oIX0oI("loadNativeData ad bridge = " + bridge);
        NativeUnifiedAD nativeUnifiedAD = this.f1812IIXOooo;
        if (nativeUnifiedAD != null) {
            this.f1819oI0IIXIo = bridge;
            nativeUnifiedAD.loadData(i);
        }
    }

    public final void Oxx0IOOO(Context context, String str, String str2) {
        OxxIIOOXO.oIX0oI("createNativeExpressAD context = " + context + " adnId = " + str + " adm = " + str2);
        if (TextUtils.isEmpty(str2)) {
            this.f1813IXxxXO = new NativeExpressAD(context, this.f1814Oo, str, this.f1820xoXoI);
        } else {
            this.f1813IXxxXO = new NativeExpressAD(context, this.f1814Oo, str, this.f1820xoXoI, str2);
        }
        if (!Thread.currentThread().getName().equals("gm_t_main")) {
            xxIXOIIO.oOoXoXO.oxoX(getClass().getName(), context);
        }
    }

    public final void XO(Context context, String str) {
        OxxIIOOXO.oIX0oI("createUnifiedBannerView context = " + context + " adnId = " + str);
        if (context instanceof Activity) {
            this.f1817XO = new UnifiedBannerView((Activity) context, str, new oIX0oI());
            if (!Thread.currentThread().getName().equals("gm_t_main")) {
                xxIXOIIO.oOoXoXO.oxoX(getClass().getName(), context);
            }
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 40066) {
            XO((Context) valueSet.objectValue(10000, Context.class), (String) valueSet.objectValue(50000, String.class));
            return null;
        }
        if (i == 40002) {
            II0XooXoX((Bridge) valueSet.objectValue(10004, Bridge.class));
            return null;
        }
        if (i == 40067) {
            int intValue = valueSet.intValue(50022);
            OxxIIOOXO.oIX0oI("setRefresh = " + intValue);
            UnifiedBannerView unifiedBannerView = this.f1817XO;
            if (unifiedBannerView != null) {
                unifiedBannerView.setRefresh(intValue);
                return null;
            }
            return null;
        }
        if (i == 40031) {
            II0xO0(valueSet.intValue(MsgField.MSG_MARKER_CREATE_SESSION_FAIL));
            return null;
        }
        if (i == 40030) {
            Oxx0IOOO((Context) valueSet.objectValue(10000, Context.class), (String) valueSet.objectValue(50000, String.class), (String) valueSet.objectValue(50002, String.class));
            return null;
        }
        if (i == 40018) {
            oOoXoXO((Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class));
            return null;
        }
        if (i == 40019) {
            Oxx0xo((Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class));
            return null;
        }
        if (i == 40020) {
            IIXOooo((Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class));
            return null;
        }
        if (i == 40068) {
            xxIXOIIO((Bridge) valueSet.objectValue(10004, Bridge.class), valueSet.intValue(SessionCommand.COMMAND_CODE_PLAYER_ADD_PLAYLIST_ITEM));
            return null;
        }
        if (i == 40036) {
            x0xO0oo((Context) valueSet.objectValue(10000, Context.class), (String) valueSet.objectValue(50000, String.class), (String) valueSet.objectValue(50002, String.class));
            return null;
        }
        if (i == 40037) {
            Oo((Bridge) valueSet.objectValue(10004, Bridge.class), valueSet.intValue(SessionCommand.COMMAND_CODE_PLAYER_ADD_PLAYLIST_ITEM));
            return null;
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public final void x0xO0oo(Context context, String str, String str2) {
        OxxIIOOXO.oIX0oI("createNativeUnifiedAD context = " + context + " adnId = " + str + " adm = " + str2);
        if (TextUtils.isEmpty(str2)) {
            this.f1812IIXOooo = new NativeUnifiedAD(context, str, this.f1818o00);
        } else {
            this.f1812IIXOooo = new NativeUnifiedAD(context, str, this.f1818o00, str2);
        }
        if (!Thread.currentThread().getName().equals("gm_t_main")) {
            xxIXOIIO.oOoXoXO.oxoX(getClass().getName(), context);
        }
    }

    public final void xxIXOIIO(Bridge bridge, int i) {
        OxxIIOOXO.oIX0oI("loadNativeExpressAd ad bridge = " + bridge);
        NativeExpressAD nativeExpressAD = this.f1813IXxxXO;
        if (nativeExpressAD != null) {
            this.f1819oI0IIXIo = bridge;
            nativeExpressAD.loadAD(i);
        }
    }
}
