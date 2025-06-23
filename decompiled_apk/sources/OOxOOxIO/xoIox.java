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
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* loaded from: classes6.dex */
public class xoIox implements Bridge {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public xxIXOIIO f1882IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public Bridge f1883Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public UnifiedInterstitialADListener f1884Oxx0xo = new oIX0oI();

    /* renamed from: XO, reason: collision with root package name */
    public UnifiedInterstitialAD f1885XO;

    private void II0XooXoX(Map<String, Object> map) {
        OxxIIOOXO.oIX0oI("setVideoOption map = " + map);
        VideoOption build = new VideoOption.Builder().build();
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_VIDEO_OPTION);
            if (obj instanceof VideoOption) {
                build = (VideoOption) obj;
            }
        }
        UnifiedInterstitialAD unifiedInterstitialAD = this.f1885XO;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setVideoOption(build);
        }
    }

    private void OOXIXo(Map<String, Object> map) {
        int intValue;
        UnifiedInterstitialAD unifiedInterstitialAD;
        OxxIIOOXO.oIX0oI("setMaxVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MAX_VIDEO_DURATION);
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) > 0 && (unifiedInterstitialAD = this.f1885XO) != null) {
                unifiedInterstitialAD.setMaxVideoDuration(intValue);
            }
        }
    }

    private void X0o0xo(Bridge bridge) {
        OxxIIOOXO.oIX0oI("loadFullScreenAD ad bridge = " + bridge);
        UnifiedInterstitialAD unifiedInterstitialAD = this.f1885XO;
        if (unifiedInterstitialAD != null) {
            this.f1883Oo = bridge;
            unifiedInterstitialAD.loadFullScreenAD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XO(AdError adError) {
        if (this.f1883Oo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(50006, new II0XooXoX(adError));
            this.f1883Oo.call(60001, create.build(), null);
        }
    }

    private void oIX0oI() {
        if (this.f1882IXxxXO == null) {
            this.f1882IXxxXO = new xxIXOIIO(this.f1885XO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ooOOo0oXI() {
        if (this.f1883Oo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            oIX0oI();
            create.add(50005, this.f1882IXxxXO);
            this.f1883Oo.call(60003, create.build(), null);
        }
    }

    private void oxoX(Context context, String str) {
        OxxIIOOXO.oIX0oI("createUnifiedInterstitialAD context = " + context + " adnId = " + str);
        if (context instanceof Activity) {
            this.f1885XO = new UnifiedInterstitialAD((Activity) context, str, this.f1884Oxx0xo);
            if (!Thread.currentThread().getName().equals("gm_t_main")) {
                xxIXOIIO.oOoXoXO.oxoX(getClass().getName(), context);
            }
        }
    }

    private void x0XOIxOo(Map<String, Object> map) {
        int intValue;
        UnifiedInterstitialAD unifiedInterstitialAD;
        OxxIIOOXO.oIX0oI("setMinVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MIN_VIDEO_DURATION);
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) > 0 && (unifiedInterstitialAD = this.f1885XO) != null) {
                unifiedInterstitialAD.setMinVideoDuration(intValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xxIXOIIO() {
        if (this.f1883Oo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            oIX0oI();
            create.add(50005, this.f1882IXxxXO);
            this.f1883Oo.call(60008, create.build(), null);
        }
    }

    public final void Oxx0IOOO(String str, String str2) {
        UnifiedInterstitialAD unifiedInterstitialAD;
        OxxIIOOXO.oIX0oI("setServerSideVerificationOptions userId = " + str + " customStr = " + str2);
        ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
        if (str != null) {
            builder.setUserId(str);
        }
        if (str2 != null) {
            builder.setCustomData(str2);
        }
        if ((str != null || !TextUtils.isEmpty(str2)) && (unifiedInterstitialAD = this.f1885XO) != null) {
            unifiedInterstitialAD.setServerSideVerificationOptions(builder.build());
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 40017) {
            oxoX((Context) valueSet.objectValue(10000, Context.class), (String) valueSet.objectValue(50000, String.class));
            return null;
        }
        if (i == 40018) {
            II0XooXoX((Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class));
            return null;
        }
        if (i == 40019) {
            OOXIXo((Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class));
            return null;
        }
        if (i == 40020) {
            x0XOIxOo((Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class));
            return null;
        }
        if (i == 40001) {
            Oxx0IOOO((String) valueSet.objectValue(50003, String.class), (String) valueSet.objectValue(SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM, String.class));
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
            if (xoIox.this.f1882IXxxXO != null) {
                xoIox.this.f1882IXxxXO.X0o0xo();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            OxxIIOOXO.oIX0oI("onADClose");
            if (xoIox.this.f1882IXxxXO != null) {
                xoIox.this.f1882IXxxXO.II0XooXoX();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            OxxIIOOXO.oIX0oI("onADExposure");
            if (xoIox.this.f1882IXxxXO != null) {
                xoIox.this.f1882IXxxXO.oIX0oI();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            OxxIIOOXO.oIX0oI("adn onADReceive");
            xoIox.this.xxIXOIIO();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            OxxIIOOXO.oIX0oI("adnOnError adError = " + adError);
            xoIox.this.XO(adError);
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
            OxxIIOOXO.oIX0oI("adn onVideoCached");
            xoIox.this.ooOOo0oXI();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
        }
    }
}
