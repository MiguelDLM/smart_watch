package com.tencent.connect.share;

import XxXX.I0Io;
import XxXX.Oxx0IOOO;
import XxXX.X0o0xo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.content.FileProvider;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.tencent.tauth.Tencent;
import java.io.File;
import java.util.ArrayList;
import xoX.OOXIXo;
import xox.oO;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class QQShare extends com.tencent.connect.common.oIX0oI {
    public static final int QQ_SHARE_SUMMARY_MAX_LENGTH = 512;
    public static final int QQ_SHARE_TITLE_MAX_LENGTH = 128;
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_ARK_INFO = "share_to_qq_ark_info";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final int SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN = 1;
    public static final int SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE = 2;
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QQ_MINI_PROGRAM = 7;
    public static final String SHARE_TO_QQ_MINI_PROGRAM_APPID = "mini_program_appid";
    public static final String SHARE_TO_QQ_MINI_PROGRAM_PATH = "mini_program_path";
    public static final String SHARE_TO_QQ_MINI_PROGRAM_TYPE = "mini_program_type";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final int SHARE_TO_QQ_TYPE_APP = 6;
    public static final int SHARE_TO_QQ_TYPE_AUDIO = 2;
    public static final int SHARE_TO_QQ_TYPE_DEFAULT = 1;
    public static final int SHARE_TO_QQ_TYPE_IMAGE = 5;
    public String mViaShareQQType;

    /* loaded from: classes13.dex */
    public class oIX0oI implements I0Io {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ String f26925I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ String f26926II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public final /* synthetic */ Activity f26927X0o0xo;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Bundle f26929oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public final /* synthetic */ o0Oo.II0xO0 f26930oxoX;

        public oIX0oI(Bundle bundle, String str, String str2, o0Oo.II0xO0 iI0xO0, Activity activity) {
            this.f26929oIX0oI = bundle;
            this.f26926II0xO0 = str;
            this.f26925I0Io = str2;
            this.f26930oxoX = iI0xO0;
            this.f26927X0o0xo = activity;
        }

        @Override // XxXX.I0Io
        public void a(int i, ArrayList<String> arrayList) {
        }

        @Override // XxXX.I0Io
        public void a(int i, String str) {
            if (i == 0) {
                this.f26929oIX0oI.putString("imageLocalUrl", str);
            } else if (TextUtils.isEmpty(this.f26926II0xO0) && TextUtils.isEmpty(this.f26925I0Io)) {
                o0Oo.II0xO0 iI0xO0 = this.f26930oxoX;
                if (iI0xO0 != null) {
                    iI0xO0.oIX0oI(new o0Oo.I0Io(-6, com.tencent.connect.common.II0xO0.f26865ox, null));
                    xxIXOIIO.II0XooXoX("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                }
                OOXIXo.oIX0oI().II0xO0(1, "SHARE_CHECK_SDK", com.tencent.connect.common.II0xO0.f26842oIX0oI, ((com.tencent.connect.common.oIX0oI) QQShare.this).c.X0o0xo(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.II0xO0.f26865ox);
                return;
            }
            QQShare.this.Oxx0xo(this.f26927X0o0xo, this.f26929oIX0oI, this.f26930oxoX);
        }
    }

    public QQShare(Context context, xIxooxXX.II0xO0 iI0xO0) {
        super(iI0xO0);
        this.mViaShareQQType = "";
    }

    public final void IXxxXO(Activity activity, Bundle bundle, o0Oo.II0xO0 iI0xO0) {
        String str;
        String string = bundle.getString("imageLocalUrl");
        String str2 = null;
        if (new File(string).length() >= CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(new o0Oo.I0Io(-16, com.tencent.connect.common.II0xO0.f26730I0, null));
            }
            xxIXOIIO.II0XooXoX("openSDK_LOG.QQShare", "doShareImageToQQ -- error: 图片太大，请压缩到5M内再分享!");
            return;
        }
        File externalFilesDir = X0o0xo.oIX0oI().getExternalFilesDir("Images");
        if (externalFilesDir != null) {
            str = externalFilesDir.getAbsolutePath() + File.separator + com.tencent.connect.common.II0xO0.f26764O0OOX0IIx;
        } else {
            xxIXOIIO.oOoXoXO("openSDK_LOG.QQShare", "doShareImageToQQ() getExternalFilesDir return null");
            str = null;
        }
        File file = new File(string);
        String absolutePath = file.getAbsolutePath();
        String name = file.getName();
        boolean oxxXoxO2 = com.tencent.open.utils.II0xO0.oxxXoxO(absolutePath);
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQShare", "doShareImageToQQ() check file: isAppSpecificDir=" + oxxXoxO2 + ",hasSDPermission=" + com.tencent.open.utils.II0xO0.IIX0o() + ",fileDir=" + absolutePath);
        ArrayList<String> arrayList = new ArrayList<>(2);
        if (oxxXoxO2) {
            str2 = absolutePath;
        } else if (!TextUtils.isEmpty(str)) {
            String str3 = str + File.separator + name;
            boolean O0xOxO2 = com.tencent.open.utils.II0xO0.O0xOxO(absolutePath, str3);
            xxIXOIIO.oOoXoXO("openSDK_LOG.QQShare", "doShareImageToQQ() sd permission not denied. copy to app sepcific:" + str3 + ",isSuccess=" + O0xOxO2);
            if (O0xOxO2) {
                str2 = str3;
            }
        }
        arrayList.add(absolutePath);
        arrayList.add(str2);
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQShare", "doShareImageToQQ() destFilePaths=[" + arrayList.get(0) + "," + arrayList.get(1) + "]");
        bundle.putStringArrayList("imageLocalUrlArray", arrayList);
        Oxx0xo(activity, bundle, iI0xO0);
    }

    public final void Oxx0xo(Activity activity, Bundle bundle, o0Oo.II0xO0 iI0xO0) {
        int i;
        int i2;
        String str;
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQShare", "doShareToQQ() -- start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_fri?src_type=app&version=1&file_type=news");
        String string = bundle.getString("imageUrl");
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("summary");
        String string4 = bundle.getString("targetUrl");
        String string5 = bundle.getString("audio_url");
        int i3 = bundle.getInt("req_type", 1);
        String string6 = bundle.getString(SHARE_TO_QQ_ARK_INFO);
        String string7 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_APPID);
        String string8 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_PATH);
        String string9 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_TYPE);
        int i4 = bundle.getInt("cflag", 0);
        String string10 = bundle.getString("share_qq_ext_str");
        String II0XooXoX2 = com.tencent.open.utils.II0xO0.II0XooXoX(activity);
        if (II0XooXoX2 == null) {
            II0XooXoX2 = bundle.getString("appName");
        }
        String str2 = II0XooXoX2;
        String string11 = bundle.getString("imageLocalUrl");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageLocalUrlArray");
        String X0o0xo2 = this.c.X0o0xo();
        String xxIXOIIO2 = this.c.xxIXOIIO();
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQShare", "doShareToQQ -- openid: " + xxIXOIIO2 + ",appName=" + str2);
        if (stringArrayList != null && stringArrayList.size() >= 2) {
            String str3 = stringArrayList.get(0);
            if (str3 == null) {
                str3 = "";
            }
            stringBuffer.append("&file_data=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(str3), 2));
            String str4 = stringArrayList.get(1);
            if (i3 == 7 && !TextUtils.isEmpty(str4) && Oxx0IOOO.x0XOIxOo(activity, "8.3.3") < 0) {
                xxIXOIIO.II0XooXoX("openSDK_LOG.QQShare", "doShareToQQ() share to mini program set file uri empty");
                str4 = null;
            }
            if (!TextUtils.isEmpty(str4)) {
                try {
                    Uri uriForFile = FileProvider.getUriForFile(activity, Tencent.getAuthorities(X0o0xo2), new File(str4));
                    activity.grantUriPermission("com.tencent.mobileqq", uriForFile, 3);
                    stringBuffer.append("&file_uri=");
                    stringBuffer.append(Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(uriForFile.toString()), 2));
                } catch (Exception e) {
                    xxIXOIIO.xxIXOIIO("openSDK_LOG.QQShare", "doShareToQQ() getUriForFile exception:", e);
                }
            }
        } else if (!TextUtils.isEmpty(string11)) {
            stringBuffer.append("&file_data=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(string11), 2));
        }
        if (!TextUtils.isEmpty(string)) {
            stringBuffer.append("&image_url=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(string), 2));
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&title=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(string2), 2));
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuffer.append("&description=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(string3), 2));
        }
        if (!TextUtils.isEmpty(X0o0xo2)) {
            stringBuffer.append("&share_id=" + X0o0xo2);
        }
        if (!TextUtils.isEmpty(string4)) {
            stringBuffer.append("&url=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(string4), 2));
        }
        if (!TextUtils.isEmpty(str2)) {
            if (str2.length() > 20) {
                str2 = str2.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(str2), 2));
        }
        if (!TextUtils.isEmpty(xxIXOIIO2)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(xxIXOIIO2), 2));
        }
        if (!TextUtils.isEmpty(string5)) {
            stringBuffer.append("&audioUrl=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(string5), 2));
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(String.valueOf(i3)), 2));
        if (!TextUtils.isEmpty(string7)) {
            stringBuffer.append("&mini_program_appid=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(String.valueOf(string7)), 2));
        }
        if (!TextUtils.isEmpty(string8)) {
            stringBuffer.append("&mini_program_path=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(String.valueOf(string8)), 2));
        }
        if (!TextUtils.isEmpty(string9)) {
            stringBuffer.append("&mini_program_type=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(String.valueOf(string9)), 2));
        }
        if (!TextUtils.isEmpty(string6)) {
            stringBuffer.append("&share_to_qq_ark_info=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(string6), 2));
        }
        if (!TextUtils.isEmpty(string10)) {
            stringBuffer.append("&share_qq_ext_str=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(string10), 2));
        }
        stringBuffer.append("&cflag=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(String.valueOf(i4)), 2));
        stringBuffer.append("&third_sd=" + Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(String.valueOf(com.tencent.open.utils.II0xO0.IIX0o())), 2));
        xxIXOIIO.IXxxXO("openSDK_LOG.QQShare", "doShareToQQ -- url: " + stringBuffer.toString());
        oO.oIX0oI(X0o0xo.oIX0oI(), this.c, "requireApi", "shareToNativeQQ");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putExtra("pkg_name", activity.getPackageName());
        if (com.tencent.open.utils.II0xO0.Xx000oIo(activity, "4.6.0")) {
            xxIXOIIO.oOoXoXO("openSDK_LOG.QQShare", "doShareToQQ, qqver below 4.6.");
            if (II0XooXoX(intent)) {
                com.tencent.connect.common.I0Io.II0xO0().Oxx0IOOO(11103, iI0xO0);
                X0o0xo(activity, intent, 11103);
            }
            i2 = i4;
            i = 1;
        } else {
            xxIXOIIO.oOoXoXO("openSDK_LOG.QQShare", "doShareToQQ, qqver greater than 4.6.");
            if (com.tencent.connect.common.I0Io.II0xO0().II0XooXoX("shareToQQ", iI0xO0) != null) {
                xxIXOIIO.oOoXoXO("openSDK_LOG.QQShare", "doShareToQQ, last listener is not null, cancel it.");
            }
            if (II0XooXoX(intent)) {
                i = 1;
                oxoX(activity, 10103, intent, true);
            } else {
                i = 1;
            }
            i2 = i4;
        }
        if (i2 == i) {
            str = "11";
        } else {
            str = "10";
        }
        String str5 = str;
        if (II0XooXoX(intent)) {
            OOXIXo.oIX0oI().X0o0xo(this.c.II0XooXoX(), this.c.X0o0xo(), com.tencent.connect.common.II0xO0.f26884xIOXX, str5, "3", "0", this.mViaShareQQType, "0", "1", "0");
            OOXIXo.oIX0oI().II0xO0(0, "SHARE_CHECK_SDK", com.tencent.connect.common.II0xO0.f26842oIX0oI, this.c.X0o0xo(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
        } else {
            OOXIXo.oIX0oI().X0o0xo(this.c.II0XooXoX(), this.c.X0o0xo(), com.tencent.connect.common.II0xO0.f26884xIOXX, str5, "3", "1", this.mViaShareQQType, "0", "1", "0");
            OOXIXo.oIX0oI().II0xO0(1, "SHARE_CHECK_SDK", com.tencent.connect.common.II0xO0.f26842oIX0oI, this.c.X0o0xo(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
        }
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQShare", "doShareToQQ() --end");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0362 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0358  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void oI0IIXIo(android.app.Activity r28, android.os.Bundle r29, o0Oo.II0xO0 r30) {
        /*
            Method dump skipped, instructions count: 924
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QQShare.oI0IIXIo(android.app.Activity, android.os.Bundle, o0Oo.II0xO0):void");
    }

    @Override // com.tencent.connect.common.oIX0oI
    public void oOoXoXO() {
    }

    public final void x0xO0oo(Activity activity, Bundle bundle, o0Oo.II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQShare", "shareToMobileQQ() -- start.");
        String string = bundle.getString("imageUrl");
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("summary");
        xxIXOIIO.IXxxXO("openSDK_LOG.QQShare", "shareToMobileQQ -- imageUrl: " + string);
        if (!TextUtils.isEmpty(string)) {
            if (com.tencent.open.utils.II0xO0.xII(string)) {
                if (!com.tencent.open.utils.II0xO0.Xx000oIo(activity, "4.3.0")) {
                    Oxx0xo(activity, bundle, iI0xO0);
                } else {
                    new XxXX.II0xO0(activity).oxoX(string, new oIX0oI(bundle, string2, string3, iI0xO0, activity));
                }
            } else {
                bundle.putString("imageUrl", null);
                if (com.tencent.open.utils.II0xO0.Xx000oIo(activity, "4.3.0")) {
                    xxIXOIIO.XO("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is < 4.3.0 ");
                    Oxx0xo(activity, bundle, iI0xO0);
                } else {
                    xxIXOIIO.XO("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is > 4.3.0:isAppSpecificDir=" + com.tencent.open.utils.II0xO0.oxxXoxO(string) + ",hasSDPermission:" + com.tencent.open.utils.II0xO0.IIX0o());
                    oo0oIXo.I0Io.X0o0xo(activity, string, new II0xO0(bundle, string2, string3, iI0xO0, activity));
                }
            }
        } else if (bundle.getInt("req_type", 1) == 5) {
            IXxxXO(activity, bundle, iI0xO0);
        } else {
            Oxx0xo(activity, bundle, iI0xO0);
        }
        xxIXOIIO.oOoXoXO("openSDK_LOG.QQShare", "shareToMobileQQ() -- end");
    }

    /* loaded from: classes13.dex */
    public class II0xO0 implements I0Io {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ String f26919I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ String f26920II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public final /* synthetic */ Activity f26921X0o0xo;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Bundle f26923oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public final /* synthetic */ o0Oo.II0xO0 f26924oxoX;

        public II0xO0(Bundle bundle, String str, String str2, o0Oo.II0xO0 iI0xO0, Activity activity) {
            this.f26923oIX0oI = bundle;
            this.f26920II0xO0 = str;
            this.f26919I0Io = str2;
            this.f26924oxoX = iI0xO0;
            this.f26921X0o0xo = activity;
        }

        @Override // XxXX.I0Io
        public void a(int i, String str) {
            if (i == 0) {
                this.f26923oIX0oI.putString("imageLocalUrl", str);
            } else if (TextUtils.isEmpty(this.f26920II0xO0) && TextUtils.isEmpty(this.f26919I0Io)) {
                o0Oo.II0xO0 iI0xO0 = this.f26924oxoX;
                if (iI0xO0 != null) {
                    iI0xO0.oIX0oI(new o0Oo.I0Io(-6, com.tencent.connect.common.II0xO0.f26865ox, null));
                    xxIXOIIO.II0XooXoX("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                }
                OOXIXo.oIX0oI().II0xO0(1, "SHARE_CHECK_SDK", com.tencent.connect.common.II0xO0.f26842oIX0oI, ((com.tencent.connect.common.oIX0oI) QQShare.this).c.X0o0xo(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.II0xO0.f26865ox);
                return;
            }
            QQShare.this.Oxx0xo(this.f26921X0o0xo, this.f26923oIX0oI, this.f26924oxoX);
        }

        @Override // XxXX.I0Io
        public void a(int i, ArrayList<String> arrayList) {
            if (i == 0) {
                this.f26923oIX0oI.putStringArrayList("imageLocalUrlArray", arrayList);
            } else if (TextUtils.isEmpty(this.f26920II0xO0) && TextUtils.isEmpty(this.f26919I0Io)) {
                o0Oo.II0xO0 iI0xO0 = this.f26924oxoX;
                if (iI0xO0 != null) {
                    iI0xO0.oIX0oI(new o0Oo.I0Io(-6, com.tencent.connect.common.II0xO0.f26865ox, null));
                    xxIXOIIO.II0XooXoX("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                }
                OOXIXo.oIX0oI().II0xO0(1, "SHARE_CHECK_SDK", com.tencent.connect.common.II0xO0.f26842oIX0oI, ((com.tencent.connect.common.oIX0oI) QQShare.this).c.X0o0xo(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.II0xO0.f26865ox);
                return;
            }
            QQShare.this.Oxx0xo(this.f26921X0o0xo, this.f26923oIX0oI, this.f26924oxoX);
        }
    }
}
