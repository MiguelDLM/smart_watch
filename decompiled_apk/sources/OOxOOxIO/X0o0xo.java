package OOxOOxIO;

import android.content.Context;
import androidx.media2.session.SessionCommand;
import com.baidu.ar.base.MsgField;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class X0o0xo implements Bridge {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final NativeADUnifiedListener f1834IXxxXO = new oIX0oI();

    /* renamed from: Oo, reason: collision with root package name */
    public Bridge f1835Oo;

    /* renamed from: XO, reason: collision with root package name */
    public NativeUnifiedAD f1836XO;

    /* loaded from: classes6.dex */
    public class oIX0oI implements NativeADUnifiedListener {
        public oIX0oI() {
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
            X0o0xo.this.XO(list);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            OxxIIOOXO.oIX0oI("onNoAD adError = " + adError);
            X0o0xo.this.X0o0xo(adError);
        }
    }

    private void I0Io(Context context, String str) {
        OxxIIOOXO.oIX0oI("createNativeUnifiedAD context = " + context + " adnId = " + str);
        this.f1836XO = new NativeUnifiedAD(context, str, this.f1834IXxxXO);
        if (!Thread.currentThread().getName().equals("gm_t_main")) {
            xxIXOIIO.oOoXoXO.oxoX(getClass().getName(), context);
        }
    }

    private void II0XooXoX(Map<String, Object> map) {
        int intValue;
        NativeUnifiedAD nativeUnifiedAD;
        OxxIIOOXO.oIX0oI("setMinVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MIN_VIDEO_DURATION);
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) > 0 && (nativeUnifiedAD = this.f1836XO) != null) {
                nativeUnifiedAD.setMinVideoDuration(intValue);
            }
        }
    }

    private void Oxx0IOOO(Map<String, Object> map) {
        int intValue;
        NativeUnifiedAD nativeUnifiedAD;
        OxxIIOOXO.oIX0oI("setMaxVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MAX_VIDEO_DURATION);
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) > 0 && (nativeUnifiedAD = this.f1836XO) != null) {
                nativeUnifiedAD.setMaxVideoDuration(intValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0o0xo(AdError adError) {
        if (this.f1835Oo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(50006, new II0XooXoX(adError));
            this.f1835Oo.call(60001, create.build(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XO(List<NativeUnifiedADData> list) {
        if (this.f1835Oo != null && list != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<NativeUnifiedADData> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new XO(it.next()));
            }
            create.add(MsgField.MSG_MARKER_ALGO_START, arrayList);
            this.f1835Oo.call(60000, create.build(), null);
        }
    }

    private void oxoX(Bridge bridge, int i) {
        OxxIIOOXO.oIX0oI("loadData ad bridge = " + bridge);
        NativeUnifiedAD nativeUnifiedAD = this.f1836XO;
        if (nativeUnifiedAD != null) {
            this.f1835Oo = bridge;
            nativeUnifiedAD.loadData(i);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 40036) {
            I0Io((Context) valueSet.objectValue(10000, Context.class), (String) valueSet.objectValue(50000, String.class));
            return null;
        }
        if (i == 40019) {
            Oxx0IOOO((Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class));
            return null;
        }
        if (i == 40020) {
            II0XooXoX((Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class));
            return null;
        }
        if (i == 40037) {
            oxoX((Bridge) valueSet.objectValue(10004, Bridge.class), valueSet.intValue(SessionCommand.COMMAND_CODE_PLAYER_ADD_PLAYLIST_ITEM));
            return null;
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
