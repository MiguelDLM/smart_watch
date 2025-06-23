package OOxOOxIO;

import android.content.Context;
import android.text.TextUtils;
import androidx.media2.session.SessionCommand;
import com.baidu.ar.base.MsgField;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public class oO implements Bridge {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public ADSize f1852IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public NativeUnifiedAD f1853Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public Bridge f1854Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public NativeExpressAD f1856XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public Map<NativeExpressADView, x0XOIxOo> f1857oI0IIXIo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public final NativeExpressAD.NativeExpressADListener f1855OxxIIOOXO = new oIX0oI();

    /* renamed from: IIXOooo, reason: collision with root package name */
    public final NativeADUnifiedListener f1851IIXOooo = new II0xO0();

    /* loaded from: classes6.dex */
    public class II0xO0 implements NativeADUnifiedListener {
        public II0xO0() {
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
            oO.this.x0xO0oo(list);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            OxxIIOOXO.oIX0oI("onNoAD adError = " + adError);
            oO.this.II0XooXoX(adError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void II0XooXoX(AdError adError) {
        if (this.f1854Oxx0xo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(50006, new II0XooXoX(adError));
            this.f1854Oxx0xo.call(60001, create.build(), null);
        }
    }

    private void Oo(Map<String, Object> map) {
        int intValue;
        OxxIIOOXO.oIX0oI("setMaxVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MAX_VIDEO_DURATION);
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) > 0) {
                NativeExpressAD nativeExpressAD = this.f1856XO;
                if (nativeExpressAD != null) {
                    nativeExpressAD.setMaxVideoDuration(intValue);
                }
                NativeUnifiedAD nativeUnifiedAD = this.f1853Oo;
                if (nativeUnifiedAD != null) {
                    nativeUnifiedAD.setMaxVideoDuration(intValue);
                }
            }
        }
    }

    private void X0o0xo(Context context, String str, String str2) {
        OxxIIOOXO.oIX0oI("createNativeExpressAD context = " + context + " adnId = " + str + " adm = " + str2);
        if (TextUtils.isEmpty(str2)) {
            this.f1856XO = new NativeExpressAD(context, this.f1852IXxxXO, str, this.f1855OxxIIOOXO);
        } else {
            this.f1856XO = new NativeExpressAD(context, this.f1852IXxxXO, str, this.f1855OxxIIOOXO, str2);
        }
        if (!Thread.currentThread().getName().equals("gm_t_main")) {
            xxIXOIIO.oOoXoXO.oxoX(getClass().getName(), context);
        }
    }

    private void XO(Bridge bridge, int i) {
        OxxIIOOXO.oIX0oI("loadAd ad bridge = " + bridge);
        NativeExpressAD nativeExpressAD = this.f1856XO;
        if (nativeExpressAD != null) {
            this.f1854Oxx0xo = bridge;
            nativeExpressAD.loadAD(i);
        }
    }

    private void oI0IIXIo(Map<String, Object> map) {
        int intValue;
        OxxIIOOXO.oIX0oI("setMinVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MIN_VIDEO_DURATION);
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) > 0) {
                NativeExpressAD nativeExpressAD = this.f1856XO;
                if (nativeExpressAD != null) {
                    nativeExpressAD.setMinVideoDuration(intValue);
                }
                NativeUnifiedAD nativeUnifiedAD = this.f1853Oo;
                if (nativeUnifiedAD != null) {
                    nativeUnifiedAD.setMinVideoDuration(intValue);
                }
            }
        }
    }

    private void oIX0oI(int i) {
        OxxIIOOXO.oIX0oI("createAdSize expressWidth = " + i);
        this.f1852IXxxXO = new ADSize(-1, -2);
        if (i > 0) {
            this.f1852IXxxXO = new ADSize(i, -2);
        }
    }

    private void ooOOo0oXI(Context context, String str, String str2) {
        OxxIIOOXO.oIX0oI("createNativeUnifiedAD context = " + context + " adnId = " + str + " adm = " + str2);
        if (TextUtils.isEmpty(str2)) {
            this.f1853Oo = new NativeUnifiedAD(context, str, this.f1851IIXOooo);
        } else {
            this.f1853Oo = new NativeUnifiedAD(context, str, this.f1851IIXOooo, str2);
        }
        if (!Thread.currentThread().getName().equals("gm_t_main")) {
            xxIXOIIO.oOoXoXO.oxoX(getClass().getName(), context);
        }
    }

    private void x0XOIxOo(Bridge bridge, int i) {
        OxxIIOOXO.oIX0oI("loadData ad bridge = " + bridge);
        NativeUnifiedAD nativeUnifiedAD = this.f1853Oo;
        if (nativeUnifiedAD != null) {
            this.f1854Oxx0xo = bridge;
            nativeUnifiedAD.loadData(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0xO0oo(List<NativeUnifiedADData> list) {
        if (this.f1854Oxx0xo != null && list != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<NativeUnifiedADData> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new ooOOo0oXI(it.next()));
            }
            create.add(MsgField.MSG_MARKER_ALGO_START, arrayList);
            this.f1854Oxx0xo.call(60000, create.build(), null);
        }
    }

    private void xoIox(Map<String, Object> map) {
        OxxIIOOXO.oIX0oI("setVideoOption map = " + map);
        VideoOption build = new VideoOption.Builder().build();
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_VIDEO_OPTION);
            if (obj instanceof VideoOption) {
                build = (VideoOption) obj;
            }
        }
        NativeExpressAD nativeExpressAD = this.f1856XO;
        if (nativeExpressAD != null) {
            nativeExpressAD.setVideoOption(build);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xxIXOIIO(List<NativeExpressADView> list) {
        if (this.f1854Oxx0xo != null && list != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            ArrayList arrayList = new ArrayList(list.size());
            if (this.f1857oI0IIXIo == null) {
                this.f1857oI0IIXIo = new ConcurrentHashMap();
            }
            for (NativeExpressADView nativeExpressADView : list) {
                x0XOIxOo x0xoixoo = new x0XOIxOo(this, nativeExpressADView);
                arrayList.add(x0xoixoo);
                this.f1857oI0IIXIo.put(nativeExpressADView, x0xoixoo);
            }
            create.add(MsgField.MSG_MARKER_ALGO_START, arrayList);
            this.f1854Oxx0xo.call(60000, create.build(), null);
        }
    }

    public final void IIXOooo(NativeExpressADView nativeExpressADView) {
        x0XOIxOo x0xoixoo;
        Map<NativeExpressADView, x0XOIxOo> map = this.f1857oI0IIXIo;
        if (map != null && (x0xoixoo = map.get(nativeExpressADView)) != null) {
            x0xoixoo.II0XooXoX();
        }
    }

    public final void OxI(NativeExpressADView nativeExpressADView) {
        x0XOIxOo x0xoixoo;
        Map<NativeExpressADView, x0XOIxOo> map = this.f1857oI0IIXIo;
        if (map != null && (x0xoixoo = map.get(nativeExpressADView)) != null) {
            x0xoixoo.oIX0oI();
        }
    }

    public void Oxx0IOOO(NativeExpressADView nativeExpressADView) {
        Map<NativeExpressADView, x0XOIxOo> map = this.f1857oI0IIXIo;
        if (map != null) {
            map.remove(nativeExpressADView);
        }
    }

    public final void Oxx0xo(NativeExpressADView nativeExpressADView) {
        x0XOIxOo x0xoixoo;
        Map<NativeExpressADView, x0XOIxOo> map = this.f1857oI0IIXIo;
        if (map != null && (x0xoixoo = map.get(nativeExpressADView)) != null) {
            x0xoixoo.xxIXOIIO();
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 40031) {
            oIX0oI(valueSet.intValue(MsgField.MSG_MARKER_CREATE_SESSION_FAIL));
            return null;
        }
        if (i == 40030) {
            X0o0xo((Context) valueSet.objectValue(10000, Context.class), (String) valueSet.objectValue(50000, String.class), (String) valueSet.objectValue(50002, String.class));
            return null;
        }
        if (i == 40018) {
            xoIox((Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class));
            return null;
        }
        if (i == 40019) {
            Oo((Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class));
            return null;
        }
        if (i == 40020) {
            oI0IIXIo((Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class));
            return null;
        }
        if (i == 40002) {
            XO((Bridge) valueSet.objectValue(10004, Bridge.class), valueSet.intValue(SessionCommand.COMMAND_CODE_PLAYER_ADD_PLAYLIST_ITEM));
            return null;
        }
        if (i == 40036) {
            ooOOo0oXI((Context) valueSet.objectValue(10000, Context.class), (String) valueSet.objectValue(50000, String.class), (String) valueSet.objectValue(50002, String.class));
            return null;
        }
        if (i == 40037) {
            x0XOIxOo((Bridge) valueSet.objectValue(10004, Bridge.class), valueSet.intValue(SessionCommand.COMMAND_CODE_PLAYER_ADD_PLAYLIST_ITEM));
            return null;
        }
        return null;
    }

    public final void o00(NativeExpressADView nativeExpressADView) {
        x0XOIxOo x0xoixoo;
        Map<NativeExpressADView, x0XOIxOo> map = this.f1857oI0IIXIo;
        if (map != null && (x0xoixoo = map.get(nativeExpressADView)) != null) {
            x0xoixoo.Oxx0IOOO();
        }
    }

    public final void oO(NativeExpressADView nativeExpressADView) {
        Map<NativeExpressADView, x0XOIxOo> map = this.f1857oI0IIXIo;
        if (map != null) {
            x0XOIxOo x0xoixoo = map.get(nativeExpressADView);
            if (x0xoixoo != null) {
                x0xoixoo.xoIox();
            }
            this.f1857oI0IIXIo.remove(nativeExpressADView);
        }
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements NativeExpressAD.NativeExpressADListener {
        public oIX0oI() {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            OxxIIOOXO.oIX0oI("onADClicked nativeExpressADView = " + nativeExpressADView);
            oO.this.Oxx0xo(nativeExpressADView);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            OxxIIOOXO.oIX0oI("onADClosed nativeExpressADView = " + nativeExpressADView);
            oO.this.oO(nativeExpressADView);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            OxxIIOOXO.oIX0oI("onADExposure nativeExpressADView = " + nativeExpressADView);
            oO.this.IIXOooo(nativeExpressADView);
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
            oO.this.xxIXOIIO(list);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            OxxIIOOXO.oIX0oI("onNoAD adError = " + adError);
            oO.this.II0XooXoX(adError);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            OxxIIOOXO.oIX0oI("onRenderFail nativeExpressADView = " + nativeExpressADView);
            oO.this.OxI(nativeExpressADView);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            OxxIIOOXO.oIX0oI("onRenderSuccess nativeExpressADView = " + nativeExpressADView);
            oO.this.o00(nativeExpressADView);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
        }
    }
}
