package com.sma.smartv3.ui.me;

import X00IoxXI.II0xO0;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.io.Location;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ZipUtils;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.gson.Gson;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import com.sma.smartv3.biz.UploadFileManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.DeviceLaseRecord;
import com.sma.smartv3.util.UtilsKt;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.io.File;
import java.util.Date;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Ref;

@kotlin.jvm.internal.XX({"SMAP\nWebViewV2Activity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewV2Activity.kt\ncom/sma/smartv3/ui/me/WebViewV2Activity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,351:1\n19#2:352\n15#2:353\n90#2:354\n90#2:355\n90#2:356\n19#2:357\n15#2:358\n*S KotlinDebug\n*F\n+ 1 WebViewV2Activity.kt\ncom/sma/smartv3/ui/me/WebViewV2Activity\n*L\n178#1:352\n178#1:353\n182#1:354\n219#1:355\n220#1:356\n256#1:357\n256#1:358\n*E\n"})
/* loaded from: classes11.dex */
public final class WebViewV2Activity extends BaseActivity {
    private final int RESULT_CODE;
    private boolean isUseWebViewTitle;

    @OXOo.oOoXoXO
    private ValueCallback<Uri> mUploadMessage;

    @OXOo.oOoXoXO
    private ValueCallback<Uri[]> mUploadMessageArray;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO webView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<BridgeWebView>() { // from class: com.sma.smartv3.ui.me.WebViewV2Activity$webView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final BridgeWebView invoke() {
            return (BridgeWebView) WebViewV2Activity.this.findViewById(R.id.webView);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO titleCenter$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.WebViewV2Activity$titleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WebViewV2Activity.this.findViewById(R.id.abh_title_center);
        }
    });

    @Keep
    /* loaded from: classes11.dex */
    public static final class WebBleInfo {

        @OXOo.oOoXoXO
        private WebInfo bleInfo;

        @OXOo.OOXIXo
        private String logPath;

        /* JADX WARN: Multi-variable type inference failed */
        public WebBleInfo() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ WebBleInfo copy$default(WebBleInfo webBleInfo, String str, WebInfo webInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                str = webBleInfo.logPath;
            }
            if ((i & 2) != 0) {
                webInfo = webBleInfo.bleInfo;
            }
            return webBleInfo.copy(str, webInfo);
        }

        @OXOo.OOXIXo
        public final String component1() {
            return this.logPath;
        }

        @OXOo.oOoXoXO
        public final WebInfo component2() {
            return this.bleInfo;
        }

        @OXOo.OOXIXo
        public final WebBleInfo copy(@OXOo.OOXIXo String logPath, @OXOo.oOoXoXO WebInfo webInfo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(logPath, "logPath");
            return new WebBleInfo(logPath, webInfo);
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WebBleInfo)) {
                return false;
            }
            WebBleInfo webBleInfo = (WebBleInfo) obj;
            return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.logPath, webBleInfo.logPath) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.bleInfo, webBleInfo.bleInfo);
        }

        @OXOo.oOoXoXO
        public final WebInfo getBleInfo() {
            return this.bleInfo;
        }

        @OXOo.OOXIXo
        public final String getLogPath() {
            return this.logPath;
        }

        public int hashCode() {
            int hashCode = this.logPath.hashCode() * 31;
            WebInfo webInfo = this.bleInfo;
            return hashCode + (webInfo == null ? 0 : webInfo.hashCode());
        }

        public final void setBleInfo(@OXOo.oOoXoXO WebInfo webInfo) {
            this.bleInfo = webInfo;
        }

        public final void setLogPath(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.logPath = str;
        }

        @OXOo.OOXIXo
        public String toString() {
            return "WebBleInfo(logPath=" + this.logPath + ", bleInfo=" + this.bleInfo + HexStringBuilder.COMMENT_END_CHAR;
        }

        public WebBleInfo(@OXOo.OOXIXo String logPath, @OXOo.oOoXoXO WebInfo webInfo) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(logPath, "logPath");
            this.logPath = logPath;
            this.bleInfo = webInfo;
        }

        public /* synthetic */ WebBleInfo(String str, WebInfo webInfo, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : webInfo);
        }
    }

    @Keep
    /* loaded from: classes11.dex */
    public static final class WebInfo {

        @OXOo.OOXIXo
        private String bleName;

        @OXOo.OOXIXo
        private String bleVersion;

        @OXOo.OOXIXo
        private String flag;

        @OXOo.OOXIXo
        private String mac;

        @OXOo.OOXIXo
        private String pVersion;

        @OXOo.OOXIXo
        private String phoneModel;
        private int phoneOs;

        @OXOo.OOXIXo
        private String pid;

        @OXOo.OOXIXo
        private String systemVersion;

        @OXOo.OOXIXo
        private String uid;

        public WebInfo() {
            this(null, null, null, null, null, null, null, 0, null, null, 1023, null);
        }

        @OXOo.OOXIXo
        public final String component1() {
            return this.uid;
        }

        @OXOo.OOXIXo
        public final String component10() {
            return this.systemVersion;
        }

        @OXOo.OOXIXo
        public final String component2() {
            return this.bleName;
        }

        @OXOo.OOXIXo
        public final String component3() {
            return this.flag;
        }

        @OXOo.OOXIXo
        public final String component4() {
            return this.pid;
        }

        @OXOo.OOXIXo
        public final String component5() {
            return this.bleVersion;
        }

        @OXOo.OOXIXo
        public final String component6() {
            return this.pVersion;
        }

        @OXOo.OOXIXo
        public final String component7() {
            return this.mac;
        }

        public final int component8() {
            return this.phoneOs;
        }

        @OXOo.OOXIXo
        public final String component9() {
            return this.phoneModel;
        }

        @OXOo.OOXIXo
        public final WebInfo copy(@OXOo.OOXIXo String uid, @OXOo.OOXIXo String bleName, @OXOo.OOXIXo String flag, @OXOo.OOXIXo String pid, @OXOo.OOXIXo String bleVersion, @OXOo.OOXIXo String pVersion, @OXOo.OOXIXo String mac, int i, @OXOo.OOXIXo String phoneModel, @OXOo.OOXIXo String systemVersion) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(uid, "uid");
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleName, "bleName");
            kotlin.jvm.internal.IIX0o.x0xO0oo(flag, "flag");
            kotlin.jvm.internal.IIX0o.x0xO0oo(pid, "pid");
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleVersion, "bleVersion");
            kotlin.jvm.internal.IIX0o.x0xO0oo(pVersion, "pVersion");
            kotlin.jvm.internal.IIX0o.x0xO0oo(mac, "mac");
            kotlin.jvm.internal.IIX0o.x0xO0oo(phoneModel, "phoneModel");
            kotlin.jvm.internal.IIX0o.x0xO0oo(systemVersion, "systemVersion");
            return new WebInfo(uid, bleName, flag, pid, bleVersion, pVersion, mac, i, phoneModel, systemVersion);
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WebInfo)) {
                return false;
            }
            WebInfo webInfo = (WebInfo) obj;
            return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.uid, webInfo.uid) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.bleName, webInfo.bleName) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.flag, webInfo.flag) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.pid, webInfo.pid) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.bleVersion, webInfo.bleVersion) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.pVersion, webInfo.pVersion) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.mac, webInfo.mac) && this.phoneOs == webInfo.phoneOs && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.phoneModel, webInfo.phoneModel) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.systemVersion, webInfo.systemVersion);
        }

        @OXOo.OOXIXo
        public final String getBleName() {
            return this.bleName;
        }

        @OXOo.OOXIXo
        public final String getBleVersion() {
            return this.bleVersion;
        }

        @OXOo.OOXIXo
        public final String getFlag() {
            return this.flag;
        }

        @OXOo.OOXIXo
        public final String getMac() {
            return this.mac;
        }

        @OXOo.OOXIXo
        public final String getPVersion() {
            return this.pVersion;
        }

        @OXOo.OOXIXo
        public final String getPhoneModel() {
            return this.phoneModel;
        }

        public final int getPhoneOs() {
            return this.phoneOs;
        }

        @OXOo.OOXIXo
        public final String getPid() {
            return this.pid;
        }

        @OXOo.OOXIXo
        public final String getSystemVersion() {
            return this.systemVersion;
        }

        @OXOo.OOXIXo
        public final String getUid() {
            return this.uid;
        }

        public int hashCode() {
            return (((((((((((((((((this.uid.hashCode() * 31) + this.bleName.hashCode()) * 31) + this.flag.hashCode()) * 31) + this.pid.hashCode()) * 31) + this.bleVersion.hashCode()) * 31) + this.pVersion.hashCode()) * 31) + this.mac.hashCode()) * 31) + this.phoneOs) * 31) + this.phoneModel.hashCode()) * 31) + this.systemVersion.hashCode();
        }

        public final void setBleName(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.bleName = str;
        }

        public final void setBleVersion(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.bleVersion = str;
        }

        public final void setFlag(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.flag = str;
        }

        public final void setMac(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.mac = str;
        }

        public final void setPVersion(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.pVersion = str;
        }

        public final void setPhoneModel(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.phoneModel = str;
        }

        public final void setPhoneOs(int i) {
            this.phoneOs = i;
        }

        public final void setPid(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.pid = str;
        }

        public final void setSystemVersion(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.systemVersion = str;
        }

        public final void setUid(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.uid = str;
        }

        @OXOo.OOXIXo
        public String toString() {
            return "WebInfo(uid=" + this.uid + ", bleName=" + this.bleName + ", flag=" + this.flag + ", pid=" + this.pid + ", bleVersion=" + this.bleVersion + ", pVersion=" + this.pVersion + ", mac=" + this.mac + ", phoneOs=" + this.phoneOs + ", phoneModel=" + this.phoneModel + ", systemVersion=" + this.systemVersion + HexStringBuilder.COMMENT_END_CHAR;
        }

        public WebInfo(@OXOo.OOXIXo String uid, @OXOo.OOXIXo String bleName, @OXOo.OOXIXo String flag, @OXOo.OOXIXo String pid, @OXOo.OOXIXo String bleVersion, @OXOo.OOXIXo String pVersion, @OXOo.OOXIXo String mac, int i, @OXOo.OOXIXo String phoneModel, @OXOo.OOXIXo String systemVersion) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(uid, "uid");
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleName, "bleName");
            kotlin.jvm.internal.IIX0o.x0xO0oo(flag, "flag");
            kotlin.jvm.internal.IIX0o.x0xO0oo(pid, "pid");
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleVersion, "bleVersion");
            kotlin.jvm.internal.IIX0o.x0xO0oo(pVersion, "pVersion");
            kotlin.jvm.internal.IIX0o.x0xO0oo(mac, "mac");
            kotlin.jvm.internal.IIX0o.x0xO0oo(phoneModel, "phoneModel");
            kotlin.jvm.internal.IIX0o.x0xO0oo(systemVersion, "systemVersion");
            this.uid = uid;
            this.bleName = bleName;
            this.flag = flag;
            this.pid = pid;
            this.bleVersion = bleVersion;
            this.pVersion = pVersion;
            this.mac = mac;
            this.phoneOs = i;
            this.phoneModel = phoneModel;
            this.systemVersion = systemVersion;
        }

        public /* synthetic */ WebInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? "" : str6, (i2 & 64) != 0 ? "" : str7, (i2 & 128) != 0 ? 0 : i, (i2 & 256) != 0 ? "" : str8, (i2 & 512) == 0 ? str9 : "");
        }
    }

    /* loaded from: classes11.dex */
    public static final class oIX0oI extends WebChromeClient {
        public oIX0oI() {
        }

        public final void I0Io(@OXOo.OOXIXo ValueCallback<Uri> uploadMsg, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(uploadMsg, "uploadMsg");
            oIX0oI(uploadMsg);
        }

        public final void II0xO0(@OXOo.OOXIXo ValueCallback<Uri> uploadMsg, @OXOo.oOoXoXO String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(uploadMsg, "uploadMsg");
            oIX0oI(uploadMsg);
        }

        public final void oIX0oI(@OXOo.OOXIXo ValueCallback<Uri> uploadMsg) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(uploadMsg, "uploadMsg");
            WebViewV2Activity.this.setMUploadMessage(uploadMsg);
            WebViewV2Activity.this.pickFile();
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(@OXOo.OOXIXo WebView webView, @OXOo.OOXIXo ValueCallback<Uri[]> filePathCallback, @OXOo.OOXIXo WebChromeClient.FileChooserParams fileChooserParams) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(webView, "webView");
            kotlin.jvm.internal.IIX0o.x0xO0oo(filePathCallback, "filePathCallback");
            kotlin.jvm.internal.IIX0o.x0xO0oo(fileChooserParams, "fileChooserParams");
            WebViewV2Activity.this.setMUploadMessageArray(filePathCallback);
            WebViewV2Activity.this.pickFile();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File genLogZipFile(String str) {
        try {
            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
            Location location = Location.EXTERNAL;
            II0xO0.oIX0oI oix0oi2 = X00IoxXI.II0xO0.f3231II0xO0;
            File oIX0oI2 = oix0oi.oIX0oI(location, oix0oi2.X0o0xo().II0xO0("share"), str);
            FileUtils.createOrExistsFile(oIX0oI2);
            ZipUtils.zipFiles(CollectionsKt__CollectionsKt.X00IoxXI(X00IoxXI.oIX0oI.II0xO0(oix0oi, Location.INTERNAL, oix0oi2.II0xO0(), null, 4, null), com.sma.smartv3.initializer.IXxxXO.X00IoxXI(oix0oi), com.sma.smartv3.initializer.IXxxXO.Xx000oIo(oix0oi)), oIX0oI2);
            return oIX0oI2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.String] */
    private final void getLog(final x0xO.oxoX oxox) {
        BleConnector bleConnector = BleConnector.INSTANCE;
        BleKey bleKey = BleKey.RAW_SLEEP;
        BleKeyFlag bleKeyFlag = BleKeyFlag.READ;
        BleConnector.sendObject$default(bleConnector, bleKey, bleKeyFlag, null, false, false, 24, null);
        BleCache bleCache = BleCache.INSTANCE;
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL) || kotlin.jvm.internal.IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707) || kotlin.jvm.internal.IIX0o.Oxx0IOOO(bleCache.getMPlatform(), BleDeviceInfo.PLATFORM_JL707LITE)) {
            BleConnector.sendData$default(bleConnector, BleKey.DEVICE_FILE, bleKeyFlag, null, false, false, 28, null);
        }
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        SPUtils XO2 = xo0.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        final AppUser appUser2 = (AppUser) appUser;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? identity = appUser2.getIdentity();
        objectRef.element = identity;
        if (((CharSequence) identity).length() == 0) {
            SPUtils oIX0oI2 = xo0.oIX0oI();
            AppUser appUser3 = (AppUser) new Gson().fromJson(oIX0oI2.getString(com.sma.smartv3.util.XoI0Ixx0.f24462ox + '_' + AppUser.class.getName()), AppUser.class);
            if (appUser3 != null) {
                objectRef.element = appUser3.getIdentity();
            }
        }
        new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.Ix0x
            @Override // java.lang.Runnable
            public final void run() {
                WebViewV2Activity.getLog$lambda$3(AppUser.this, objectRef, this, oxox);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void getLog$lambda$3(AppUser appUser, final Ref.ObjectRef identity, final WebViewV2Activity this$0, final x0xO.oxoX mBridgeHandler) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(appUser, "$appUser");
        kotlin.jvm.internal.IIX0o.x0xO0oo(identity, "$identity");
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mBridgeHandler, "$mBridgeHandler");
        final String str = appUser.getNickname() + '_' + com.sma.smartv3.util.xoIox.OO0x0xX().format(new Date()) + '_' + ((String) identity.element) + OTAManager.OTA_ZIP_SUFFIX;
        xoIXOxX.II0xO0.I0Io(false, false, null, null, 0, new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.WebViewV2Activity$getLog$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                invoke2();
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                final File genLogZipFile;
                genLogZipFile = WebViewV2Activity.this.genLogZipFile(str);
                if (genLogZipFile != null) {
                    Ref.ObjectRef<String> objectRef = identity;
                    final WebViewV2Activity webViewV2Activity = WebViewV2Activity.this;
                    final x0xO.oxoX oxox = mBridgeHandler;
                    UploadFileManager.f20210oIX0oI.X0o0xo(objectRef.element, genLogZipFile, new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.ui.me.WebViewV2Activity$getLog$2$1$1$1
                        @Override // xxxI.II0xO0
                        public void handleError(@OXOo.OOXIXo String error) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                            FileUtils.delete(genLogZipFile);
                            webViewV2Activity.sendBleInfo(error, oxox);
                        }

                        @Override // xxxI.II0xO0
                        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                        public void handleResponse(@OXOo.oOoXoXO String str2) {
                            FileUtils.delete(genLogZipFile);
                            com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24359IIX0, System.currentTimeMillis());
                            WebViewV2Activity webViewV2Activity2 = webViewV2Activity;
                            kotlin.jvm.internal.IIX0o.ooOOo0oXI(str2);
                            webViewV2Activity2.sendBleInfo(str2, oxox);
                        }
                    });
                }
            }
        }, 31, null);
    }

    public static /* synthetic */ String getWebBleInfo$default(WebViewV2Activity webViewV2Activity, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        String str6;
        String str7;
        String str8;
        String str9;
        if ((i & 2) != 0) {
            str6 = BleCache.INSTANCE.getMBleName();
        } else {
            str6 = str2;
        }
        if ((i & 4) != 0) {
            str7 = BleCache.INSTANCE.getMFirmwareFlag();
        } else {
            str7 = str3;
        }
        if ((i & 8) != 0) {
            str8 = BleCache.getString$default(BleCache.INSTANCE, BleKey.FIRMWARE_VERSION, null, null, 6, null);
        } else {
            str8 = str4;
        }
        if ((i & 16) != 0) {
            str9 = kotlin.text.OxI.IIOIX(BleCache.INSTANCE.getMBleAddress(), ":", "", false, 4, null);
        } else {
            str9 = str5;
        }
        return webViewV2Activity.getWebBleInfo(str, str6, str7, str8, str9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BridgeWebView getWebView() {
        return (BridgeWebView) this.webView$delegate.getValue();
    }

    public static /* synthetic */ void sendBleInfo$default(WebViewV2Activity webViewV2Activity, String str, x0xO.oxoX oxox, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "error";
        }
        webViewV2Activity.sendBleInfo(str, oxox);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendBleInfo$lambda$4(String bleInfo, x0xO.oxoX mBridgeHandler) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bleInfo, "$bleInfo");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mBridgeHandler, "$mBridgeHandler");
        LogUtils.d("webView shareLog  send " + bleInfo);
        mBridgeHandler.oIX0oI(bleInfo);
    }

    @OXOo.oOoXoXO
    public final ValueCallback<Uri> getMUploadMessage() {
        return this.mUploadMessage;
    }

    @OXOo.oOoXoXO
    public final ValueCallback<Uri[]> getMUploadMessageArray() {
        return this.mUploadMessageArray;
    }

    public final int getRESULT_CODE() {
        return this.RESULT_CODE;
    }

    public final TextView getTitleCenter() {
        return (TextView) this.titleCenter$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public final String getWebBleInfo(@OXOo.OOXIXo String info, @OXOo.OOXIXo String bleName, @OXOo.OOXIXo String flag, @OXOo.OOXIXo String bleVersion, @OXOo.OOXIXo String mac) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(info, "info");
        kotlin.jvm.internal.IIX0o.x0xO0oo(bleName, "bleName");
        kotlin.jvm.internal.IIX0o.x0xO0oo(flag, "flag");
        kotlin.jvm.internal.IIX0o.x0xO0oo(bleVersion, "bleVersion");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mac, "mac");
        Gson gson = new Gson();
        WebBleInfo webBleInfo = new WebBleInfo(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        webBleInfo.setLogPath(info);
        String appVersionName = AppUtils.getAppVersionName();
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        String identity = ((AppUser) appUser).getIdentity();
        String x0xO0oo2 = UtilsKt.x0xO0oo();
        String oO2 = UtilsKt.oO();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(appVersionName);
        webBleInfo.setBleInfo(new WebInfo(identity, bleName, flag, "2", bleVersion, appVersionName, mac, 0, x0xO0oo2, oO2, 128, null));
        String json = gson.toJson(webBleInfo);
        kotlin.jvm.internal.IIX0o.oO(json, "toJson(...)");
        return json;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        if (getMArg1() == -1) {
            getTitleCenter().setText(R.string.feedback);
        } else {
            this.isUseWebViewTitle = true;
        }
        WebSettings settings = getWebView().getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setCacheMode(2);
        settings.setLoadWithOverviewMode(true);
        settings.setGeolocationEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDomStorageEnabled(true);
        getWebView().setDefaultHandler(new x0xO.X0o0xo());
        getWebView().setWebViewClient(new WebViewV2Activity$initView$2(this, getWebView()));
        String mArg0 = getMArg0();
        if (mArg0 != null) {
            LogUtils.d("webView url " + mArg0);
            getWebView().loadUrl(mArg0);
        }
        getWebView().setWebChromeClient(new oIX0oI());
    }

    public final boolean isUseWebViewTitle() {
        return this.isUseWebViewTitle;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_main_webview_jsbridge;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        Uri uri;
        Uri uri2;
        super.onActivityResult(i, i2, intent);
        if (i == this.RESULT_CODE) {
            ValueCallback<Uri> valueCallback = this.mUploadMessage;
            if (valueCallback == null && this.mUploadMessageArray == null) {
                return;
            }
            if (valueCallback != null && this.mUploadMessageArray == null) {
                if (intent != null && i2 == -1) {
                    uri2 = intent.getData();
                } else {
                    uri2 = null;
                }
                ValueCallback<Uri> valueCallback2 = this.mUploadMessage;
                if (valueCallback2 != null) {
                    valueCallback2.onReceiveValue(uri2);
                }
                this.mUploadMessage = null;
            }
            if (this.mUploadMessage == null && this.mUploadMessageArray != null) {
                if (intent != null && i2 == -1) {
                    uri = intent.getData();
                } else {
                    uri = null;
                }
                if (uri != null) {
                    ValueCallback<Uri[]> valueCallback3 = this.mUploadMessageArray;
                    if (valueCallback3 != null) {
                        valueCallback3.onReceiveValue(new Uri[]{uri});
                    }
                } else {
                    ValueCallback<Uri[]> valueCallback4 = this.mUploadMessageArray;
                    if (valueCallback4 != null) {
                        valueCallback4.onReceiveValue(null);
                    }
                }
                this.mUploadMessageArray = null;
            }
        }
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getWebView().destroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, @OXOo.oOoXoXO KeyEvent keyEvent) {
        if (getWebView().canGoBack() && i == 4) {
            getWebView().goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void pickFile() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, this.RESULT_CODE);
    }

    public final void sendBleInfo(@OXOo.OOXIXo String info, @OXOo.OOXIXo final x0xO.oxoX mBridgeHandler) {
        final String webBleInfo;
        kotlin.jvm.internal.IIX0o.x0xO0oo(info, "info");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mBridgeHandler, "mBridgeHandler");
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        SPUtils oIX0oI2 = xo0.oIX0oI();
        DeviceLaseRecord deviceLaseRecord = (DeviceLaseRecord) new Gson().fromJson(oIX0oI2.getString(com.sma.smartv3.util.XoI0Ixx0.f24463oxIIX0o + '_' + DeviceLaseRecord.class.getName()), DeviceLaseRecord.class);
        SPUtils oIX0oI3 = xo0.oIX0oI();
        DeviceLaseRecord deviceLaseRecord2 = (DeviceLaseRecord) new Gson().fromJson(oIX0oI3.getString(com.sma.smartv3.util.XoI0Ixx0.f24437o0oIxOo + '_' + DeviceLaseRecord.class.getName()), DeviceLaseRecord.class);
        BleCache bleCache = BleCache.INSTANCE;
        if (bleCache.getMBleName().length() == 0 && deviceLaseRecord != null && deviceLaseRecord.getBleName().length() > 0) {
            webBleInfo = getWebBleInfo(info, deviceLaseRecord.getBleName(), deviceLaseRecord.getFlag(), deviceLaseRecord.getBleVersion(), kotlin.text.OxI.IIOIX(deviceLaseRecord.getMac(), ":", "", false, 4, null));
        } else if (bleCache.getMBleName().length() == 0 && deviceLaseRecord2 != null && deviceLaseRecord2.getBleName().length() > 0) {
            webBleInfo = getWebBleInfo(info, deviceLaseRecord2.getBleName(), "", "", kotlin.text.OxI.IIOIX(deviceLaseRecord2.getMac(), ":", "", false, 4, null));
        } else {
            webBleInfo = getWebBleInfo(info, bleCache.getMBleName(), bleCache.getMFirmwareFlag(), BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null), kotlin.text.OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null));
        }
        runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.me.OXooXo
            @Override // java.lang.Runnable
            public final void run() {
                WebViewV2Activity.sendBleInfo$lambda$4(webBleInfo, mBridgeHandler);
            }
        });
    }

    public final void setMUploadMessage(@OXOo.oOoXoXO ValueCallback<Uri> valueCallback) {
        this.mUploadMessage = valueCallback;
    }

    public final void setMUploadMessageArray(@OXOo.oOoXoXO ValueCallback<Uri[]> valueCallback) {
        this.mUploadMessageArray = valueCallback;
    }

    public final void setUseWebViewTitle(boolean z) {
        this.isUseWebViewTitle = z;
    }

    public final void shareLog(boolean z, @OXOo.OOXIXo x0xO.oxoX mBridgeHandler) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mBridgeHandler, "mBridgeHandler");
        LogUtils.d("webView shareLog bool = " + z);
        if (z) {
            getLog(mBridgeHandler);
        } else {
            sendBleInfo("", mBridgeHandler);
        }
    }
}
