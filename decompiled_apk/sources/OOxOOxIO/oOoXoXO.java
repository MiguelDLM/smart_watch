package OOxOOxIO;

import android.app.Activity;
import android.content.Context;
import com.baidu.ar.base.MsgField;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* loaded from: classes6.dex */
public class oOoXoXO implements Bridge {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public OOXIXo f1860IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public Bridge f1861Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public UnifiedInterstitialADListener f1862Oxx0xo = new oIX0oI();

    /* renamed from: XO, reason: collision with root package name */
    public UnifiedInterstitialAD f1863XO;

    private void OOXIXo(Map<String, Object> map) {
        OxxIIOOXO.oIX0oI("setVideoOption map = " + map);
        VideoOption build = new VideoOption.Builder().build();
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_VIDEO_OPTION);
            if (obj instanceof VideoOption) {
                build = (VideoOption) obj;
            }
        }
        UnifiedInterstitialAD unifiedInterstitialAD = this.f1863XO;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setVideoOption(build);
        }
    }

    private void Oxx0IOOO(Map<String, Object> map) {
        int intValue;
        UnifiedInterstitialAD unifiedInterstitialAD;
        OxxIIOOXO.oIX0oI("setMaxVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MAX_VIDEO_DURATION);
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) > 0 && (unifiedInterstitialAD = this.f1863XO) != null) {
                unifiedInterstitialAD.setMaxVideoDuration(intValue);
            }
        }
    }

    private void X0o0xo(Bridge bridge) {
        OxxIIOOXO.oIX0oI("load ad bridge = " + bridge);
        UnifiedInterstitialAD unifiedInterstitialAD = this.f1863XO;
        if (unifiedInterstitialAD != null) {
            this.f1861Oo = bridge;
            unifiedInterstitialAD.loadAD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XO(AdError adError) {
        if (this.f1861Oo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(50006, new II0XooXoX(adError));
            this.f1861Oo.call(60001, create.build(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oIX0oI() {
        if (this.f1861Oo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            xxIXOIIO();
            create.add(50005, this.f1860IXxxXO);
            this.f1861Oo.call(60008, create.build(), null);
        }
    }

    private void oxoX(Context context, String str) {
        OxxIIOOXO.oIX0oI("createUnifiedInterstitialAD context = " + context + " adnId = " + str);
        if (context instanceof Activity) {
            this.f1863XO = new UnifiedInterstitialAD((Activity) context, str, this.f1862Oxx0xo);
            if (!Thread.currentThread().getName().equals("gm_t_main")) {
                xxIXOIIO.oOoXoXO.oxoX(getClass().getName(), context);
            }
        }
    }

    private void xoIox(Map<String, Object> map) {
        int intValue;
        UnifiedInterstitialAD unifiedInterstitialAD;
        OxxIIOOXO.oIX0oI("setMinVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MIN_VIDEO_DURATION);
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) > 0 && (unifiedInterstitialAD = this.f1863XO) != null) {
                unifiedInterstitialAD.setMinVideoDuration(intValue);
            }
        }
    }

    private void xxIXOIIO() {
        if (this.f1860IXxxXO == null) {
            this.f1860IXxxXO = new OOXIXo(this.f1863XO);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 40017) {
            oxoX((Context) valueSet.objectValue(10000, Context.class), (String) valueSet.objectValue(50000, String.class));
            return null;
        }
        if (i == 40018) {
            OOXIXo((Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class));
            return null;
        }
        if (i == 40019) {
            Oxx0IOOO((Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class));
            return null;
        }
        if (i == 40020) {
            xoIox((Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class));
            return null;
        }
        if (i == 40002) {
            X0o0xo((Bridge) valueSet.objectValue(10004, Bridge.class));
            return null;
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements UnifiedInterstitialADListener {
        public oIX0oI() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            OxxIIOOXO.oIX0oI("onADClicked");
            if (oOoXoXO.this.f1860IXxxXO != null) {
                oOoXoXO.this.f1860IXxxXO.oxoX();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            OxxIIOOXO.oIX0oI("onADClose");
            if (oOoXoXO.this.f1860IXxxXO != null) {
                oOoXoXO.this.f1860IXxxXO.X0o0xo();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            OxxIIOOXO.oIX0oI("onADExposure");
            if (oOoXoXO.this.f1860IXxxXO != null) {
                oOoXoXO.this.f1860IXxxXO.oIX0oI();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
            OxxIIOOXO.oIX0oI("onADLeftApplication");
            if (oOoXoXO.this.f1860IXxxXO != null) {
                oOoXoXO.this.f1860IXxxXO.Oxx0IOOO();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
            OxxIIOOXO.oIX0oI("onADOpened");
            if (oOoXoXO.this.f1860IXxxXO != null) {
                oOoXoXO.this.f1860IXxxXO.XO();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            OxxIIOOXO.oIX0oI("adn onADReceive");
            oOoXoXO.this.oIX0oI();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            OxxIIOOXO.oIX0oI("adnOnError adError = " + adError);
            oOoXoXO.this.XO(adError);
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
        }
    }
}
