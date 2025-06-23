package com.sma.smartv3.initializer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.baidu.mapclient.liteapp.BNUtils;
import com.baidu.mapclient.liteapp.TranslateUtils;
import com.baidu.navisdk.adapter.BaiduNaviManagerFactory;
import com.baidu.navisdk.adapter.IBNTTSManager;
import com.baidu.navisdk.adapter.IBaiduNaviManager;
import com.baidu.navisdk.adapter.struct.BNTTsInitConfig;
import com.baidu.navisdk.adapter.struct.BNaviInitConfig;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.sma.smartv3.biz.StatManager;
import com.sma.smartv3.biz.voice.DcsTtsPlayer;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.util.UtilsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class Oxx0xo implements com.bestmafen.androidbase.base.II0xO0 {

    /* renamed from: Oo, reason: collision with root package name */
    public static Application f20888Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Oxx0xo f20889XO = new Oxx0xo();

    /* loaded from: classes12.dex */
    public static final class II0xO0 extends IBNTTSManager.IBNOuterTTSPlayerCallback {

        /* loaded from: classes12.dex */
        public static final class oIX0oI implements TranslateUtils.TransCallback {
            @Override // com.baidu.mapclient.liteapp.TranslateUtils.TransCallback
            public void onError(@OXOo.OOXIXo String msg) {
                IIX0o.x0xO0oo(msg, "msg");
                LogUtils.d("trans onError msg -> " + msg);
            }

            @Override // com.baidu.mapclient.liteapp.TranslateUtils.TransCallback
            public void onSuccess(@OXOo.OOXIXo String result) {
                IIX0o.x0xO0oo(result, "result");
                LogUtils.d("trans onSuccess result -> " + result);
                DcsTtsPlayer.play$default(DcsTtsPlayer.INSTANCE, result, false, false, null, null, 30, null);
            }
        }

        @Override // com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener
        public int getTTSState() {
            if (DcsTtsPlayer.INSTANCE.isPlay()) {
                return 2;
            }
            return 1;
        }

        @Override // com.baidu.navisdk.adapter.IBNTTSManager.IBNOuterTTSPlayerCallback
        public int playTTSText(@OXOo.OOXIXo String p0, int i, @OXOo.OOXIXo String p2) {
            IIX0o.x0xO0oo(p0, "p0");
            IIX0o.x0xO0oo(p2, "p2");
            LogUtils.d("playTTSText===>" + p0 + ", " + i + ", " + p2);
            DcsTtsPlayer.play$default(DcsTtsPlayer.INSTANCE, p0, false, false, null, null, 30, null);
            TranslateUtils.INSTANCE.trans(p0, new oIX0oI());
            return 1;
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements IBaiduNaviManager.INaviInitListener {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Context f20890oIX0oI;

        public oIX0oI(Context context) {
            this.f20890oIX0oI = context;
        }

        @Override // com.baidu.navisdk.adapter.IBaiduNaviManager.INaviInitListener
        public void initFailed(int i) {
            OI0.oIX0oI.f1507oIX0oI.II0xO0("initFailed = " + i);
            ToastUtils.showLong("Navigation initial failure! " + i, new Object[0]);
        }

        @Override // com.baidu.navisdk.adapter.IBaiduNaviManager.INaviInitListener
        public void initStart() {
            OI0.oIX0oI.f1507oIX0oI.II0xO0("initStart");
            BaiduNaviManagerFactory.getBaiduNaviManager().enableOutLog(true);
        }

        @Override // com.baidu.navisdk.adapter.IBaiduNaviManager.INaviInitListener
        public void initSuccess() {
            OI0.oIX0oI.f1507oIX0oI.II0xO0("initSuccess cuid = " + BaiduNaviManagerFactory.getBaiduNaviManager().getCUID());
            Oxx0xo oxx0xo = Oxx0xo.f20889XO;
            oxx0xo.oxoX();
            this.f20890oIX0oI.sendBroadcast(new Intent("com.navi.ready"));
            oxx0xo.XO(new Object());
        }

        @Override // com.baidu.navisdk.adapter.IBaiduNaviManager.INaviInitListener
        public void onAuthResult(int i, @OXOo.OOXIXo String msg) {
            String str;
            IIX0o.x0xO0oo(msg, "msg");
            if (i == 0) {
                str = "key校验成功!";
            } else {
                str = "key校验失败, " + msg;
            }
            OI0.oIX0oI.f1507oIX0oI.II0xO0(str);
        }
    }

    public final void I0Io(Context context) {
        boolean isInited = BaiduNaviManagerFactory.getBaiduNaviManager().isInited();
        OI0.oIX0oI.f1507oIX0oI.II0xO0("initNavi -> " + isInited);
        if (isInited) {
            return;
        }
        BaiduNaviManagerFactory.getBaiduNaviManager().init(context, new BNaviInitConfig.Builder().naviInitListener(new oIX0oI(context)).build());
    }

    @XO0.XO(tag = "STAT_NAV")
    public final void X0o0xo(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onStatNav");
        StatManager.f20200oIX0oI.II0xO0(2);
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24595OX00O0xII)
    public final void XO(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        boolean isInited = BaiduNaviManagerFactory.getBaiduNaviManager().isInited();
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onToNav -> " + isInited);
        if (isInited) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                BNUtils.gotoNavi(topActivity, ProductManager.f20544oIX0oI.oIX0o());
                return;
            }
            return;
        }
        Application application = f20888Oo;
        if (application == null) {
            IIX0o.XOxIOxOx("app");
            application = null;
        }
        I0Io(application);
    }

    @Override // com.bestmafen.androidbase.base.II0xO0
    public void oIX0oI(@OXOo.OOXIXo Application app) {
        IIX0o.x0xO0oo(app, "app");
        XO0.II0xO0.oxoX().x0XOIxOo(this);
        f20888Oo = app;
    }

    public final void oxoX() {
        Application app = Utils.getApp();
        IIX0o.oO(app, "getApp(...)");
        if (UtilsKt.X00IoxXI(app)) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("Use built-in TTS");
            BaiduNaviManagerFactory.getTTSManager().initTTS(new BNTTsInitConfig.Builder().context(Utils.getApp()).appId(BNUtils.getTTSAppID()).appKey(BNUtils.getTTSAppKey()).secretKey(BNUtils.getTTSsecretKey()).authSn(BNUtils.getAuth()).build());
        } else {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("Use other TTS");
            BaiduNaviManagerFactory.getTTSManager().initTTS(new II0xO0());
        }
    }
}
