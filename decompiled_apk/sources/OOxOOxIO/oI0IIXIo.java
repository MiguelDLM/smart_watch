package OOxOOxIO;

import android.app.Activity;
import android.content.Context;
import com.baidu.ar.base.MsgField;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADZoomOutListener;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* loaded from: classes6.dex */
public class oI0IIXIo implements Bridge {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Oxx0xo f1844IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public Bridge f1845Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public SplashADZoomOutListener f1846Oxx0xo = new oIX0oI();

    /* renamed from: XO, reason: collision with root package name */
    public SplashAD f1847XO;

    /* JADX INFO: Access modifiers changed from: private */
    public void I0Io(long j) {
        if (this.f1845Oo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            xoIox();
            create.add(50005, this.f1844IXxxXO);
            create.add(MsgField.MSG_MARKER_CREATE_SESSION_BEGIN, j);
            this.f1845Oo.call(60000, create.build(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void II0XooXoX(AdError adError) {
        if (this.f1845Oo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(50006, new II0XooXoX(adError));
            this.f1845Oo.call(60001, create.build(), null);
        }
    }

    private void Oxx0IOOO(Bridge bridge) {
        OxxIIOOXO.oIX0oI("load ad fetchAdOnly = " + bridge);
        SplashAD splashAD = this.f1847XO;
        if (splashAD != null) {
            this.f1845Oo = bridge;
            splashAD.fetchAdOnly();
        }
    }

    private void oOoXoXO() {
        OxxIIOOXO.oIX0oI("preload");
        SplashAD splashAD = this.f1847XO;
        if (splashAD != null) {
            splashAD.preLoad();
        }
    }

    private void xoIox() {
        if (this.f1844IXxxXO == null) {
            this.f1844IXxxXO = new Oxx0xo(this.f1847XO, this);
        }
    }

    private void xxIXOIIO(Map<String, String> map) {
        OxxIIOOXO.oIX0oI("setExtraUserData map = " + map);
        if (map != null) {
            GlobalSetting.setExtraUserData(map);
        }
    }

    public void II0xO0() {
        this.f1846Oxx0xo = null;
    }

    public final void OOXIXo(Bridge bridge) {
        OxxIIOOXO.oIX0oI("load ad fetchFullScreenAdOnly = " + bridge);
        SplashAD splashAD = this.f1847XO;
        if (splashAD != null) {
            this.f1845Oo = bridge;
            splashAD.fetchFullScreenAdOnly();
        }
    }

    public final void XO(Context context, String str, int i) {
        OxxIIOOXO.oIX0oI("createUnifiedInterstitialAD context = " + context + " adnId = " + str + " loadTimeOut = " + i);
        if (context instanceof Activity) {
            this.f1847XO = new SplashAD(context, str, this.f1846Oxx0xo, i);
            if (!Thread.currentThread().getName().equals("gm_t_main")) {
                xxIXOIIO.oOoXoXO.oxoX(getClass().getName(), context);
            }
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 40024) {
            XO((Context) valueSet.objectValue(10000, Context.class), (String) valueSet.objectValue(50000, String.class), ((Integer) valueSet.objectValue(MsgField.MSG_VPS_STATISTIC, Integer.class)).intValue());
            return null;
        }
        if (i == 40025) {
            xxIXOIIO((Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class));
            return null;
        }
        if (i == 40026) {
            oOoXoXO();
            return null;
        }
        if (i == 40027) {
            Oxx0IOOO((Bridge) valueSet.objectValue(10004, Bridge.class));
            return null;
        }
        if (i == 40028) {
            OOXIXo((Bridge) valueSet.objectValue(10004, Bridge.class));
            return null;
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements SplashADZoomOutListener {
        public oIX0oI() {
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public boolean isSupportZoomOut() {
            return true;
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADClicked() {
            OxxIIOOXO.oIX0oI("onADClicked");
            if (oI0IIXIo.this.f1844IXxxXO != null) {
                oI0IIXIo.this.f1844IXxxXO.oxoX();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADDismissed() {
            OxxIIOOXO.oIX0oI("onADDismissed");
            if (oI0IIXIo.this.f1844IXxxXO != null) {
                oI0IIXIo.this.f1844IXxxXO.X0o0xo();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADExposure() {
            OxxIIOOXO.oIX0oI("onADExposure");
            if (oI0IIXIo.this.f1844IXxxXO != null) {
                oI0IIXIo.this.f1844IXxxXO.oIX0oI();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADLoaded(long j) {
            OxxIIOOXO.oIX0oI("onADLoaded expireTimestamp = " + j);
            oI0IIXIo.this.I0Io(j);
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onNoAD(AdError adError) {
            OxxIIOOXO.oIX0oI("onNoAD adError = " + adError);
            oI0IIXIo.this.II0XooXoX(adError);
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public void onZoomOut() {
            OxxIIOOXO.oIX0oI("onZoomOut");
            if (oI0IIXIo.this.f1844IXxxXO != null) {
                oI0IIXIo.this.f1844IXxxXO.Oxx0IOOO();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public void onZoomOutPlayFinish() {
            OxxIIOOXO.oIX0oI("onZoomOutPlayFinish");
            if (oI0IIXIo.this.f1844IXxxXO != null) {
                oI0IIXIo.this.f1844IXxxXO.XO();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADTick(long j) {
        }
    }
}
