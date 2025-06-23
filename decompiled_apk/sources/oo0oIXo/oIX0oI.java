package oo0oIXo;

import O0OOX0IIx.X0o0xo;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import xoX.OOXIXo;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class oIX0oI extends com.tencent.connect.common.oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f32255I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f32256II0XooXoX = "videoSize";

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f32257II0xO0 = 3;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final String f32258OOXIXo = "hulian_call_back";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f32259Oxx0IOOO = "videoDuration";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f32260X0o0xo = "summary";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f32261XO = "videoPath";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f32262oIX0oI = "req_type";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f32263oOoXoXO = "extMap";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f32264oxoX = "imageUrl";

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f32265xoIox = "hulian_extra_scene";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f32266xxIXOIIO = "appName";

    /* loaded from: classes13.dex */
    public class II0xO0 implements MediaPlayer.OnErrorListener {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ o0Oo.II0xO0 f32268XO;

        public II0xO0(o0Oo.II0xO0 iI0xO0) {
            this.f32268XO = iI0xO0;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
            this.f32268XO.oIX0oI(new o0Oo.I0Io(-5, com.tencent.connect.common.II0xO0.f26732I0X0x0oIo, null));
            return false;
        }
    }

    /* renamed from: oo0oIXo.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C1135oIX0oI implements MediaPlayer.OnPreparedListener {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Activity f32269IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Bundle f32270Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ o0Oo.II0xO0 f32271Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f32272XO;

        public C1135oIX0oI(String str, Bundle bundle, Activity activity, o0Oo.II0xO0 iI0xO0) {
            this.f32272XO = str;
            this.f32270Oo = bundle;
            this.f32269IXxxXO = activity;
            this.f32271Oxx0xo = iI0xO0;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            long length = new File(this.f32272XO).length();
            int duration = mediaPlayer.getDuration();
            this.f32270Oo.putString(oIX0oI.f32261XO, this.f32272XO);
            this.f32270Oo.putInt(oIX0oI.f32259Oxx0IOOO, duration);
            this.f32270Oo.putLong(oIX0oI.f32256II0XooXoX, length);
            oIX0oI.this.x0XOIxOo(this.f32269IXxxXO, this.f32270Oo, this.f32271Oxx0xo);
            xxIXOIIO.oOoXoXO("openSDK_LOG.QzonePublish", "publishToQzone() --end");
        }
    }

    public oIX0oI(Context context, xIxooxXX.II0xO0 iI0xO0) {
        super(iI0xO0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x035a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void x0XOIxOo(android.app.Activity r32, android.os.Bundle r33, o0Oo.II0xO0 r34) {
        /*
            Method dump skipped, instructions count: 938
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: oo0oIXo.oIX0oI.x0XOIxOo(android.app.Activity, android.os.Bundle, o0Oo.II0xO0):void");
    }

    public void oO(Activity activity, Bundle bundle, o0Oo.II0xO0 iI0xO0) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.QzonePublish", "publishToQzone() -- start");
        if (bundle == null) {
            iI0xO0.oIX0oI(new o0Oo.I0Io(-6, com.tencent.connect.common.II0xO0.f26848oX, null));
            xxIXOIIO.II0XooXoX("openSDK_LOG.QzonePublish", "-->publishToQzone, params is null");
            OOXIXo.oIX0oI().II0xO0(1, "SHARE_CHECK_SDK", com.tencent.connect.common.II0xO0.f26842oIX0oI, this.c.X0o0xo(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.II0xO0.f26848oX);
            return;
        }
        if (!com.tencent.open.utils.II0xO0.X00IoxXI(activity)) {
            iI0xO0.oIX0oI(new o0Oo.I0Io(-15, com.tencent.connect.common.II0xO0.f26774OO0x0xX, null));
            xxIXOIIO.II0XooXoX("openSDK_LOG.QzonePublish", "-->publishToQzone, this is not support below qq 5.9.5");
            OOXIXo.oIX0oI().II0xO0(1, "SHARE_CHECK_SDK", com.tencent.connect.common.II0xO0.f26842oIX0oI, this.c.X0o0xo(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publicToQzone, this is not support below qq 5.9.5");
            new X0o0xo(activity, "", I0Io(""), null, this.c).show();
            return;
        }
        String II0XooXoX2 = com.tencent.open.utils.II0xO0.II0XooXoX(activity);
        int i = 0;
        if (II0XooXoX2 == null) {
            II0XooXoX2 = bundle.getString("appName");
        } else if (II0XooXoX2.length() > 20) {
            II0XooXoX2 = II0XooXoX2.substring(0, 20) + "...";
        }
        if (!TextUtils.isEmpty(II0XooXoX2)) {
            bundle.putString("appName", II0XooXoX2);
        }
        int i2 = bundle.getInt("req_type");
        if (i2 == 3) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
            if (stringArrayList != null && stringArrayList.size() > 0) {
                while (i < stringArrayList.size()) {
                    if (!com.tencent.open.utils.II0xO0.XOxIOxOx(stringArrayList.get(i))) {
                        stringArrayList.remove(i);
                        i--;
                    }
                    i++;
                }
                bundle.putStringArrayList("imageUrl", stringArrayList);
            }
            x0XOIxOo(activity, bundle, iI0xO0);
            xxIXOIIO.oOoXoXO("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            return;
        }
        if (i2 == 4) {
            String string = bundle.getString(f32261XO);
            if (!com.tencent.open.utils.II0xO0.XOxIOxOx(string)) {
                xxIXOIIO.II0XooXoX("openSDK_LOG.QzonePublish", "publishToQzone() video url invalid");
                iI0xO0.oIX0oI(new o0Oo.I0Io(-5, com.tencent.connect.common.II0xO0.f26732I0X0x0oIo, null));
                return;
            }
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setOnPreparedListener(new C1135oIX0oI(string, bundle, activity, iI0xO0));
            mediaPlayer.setOnErrorListener(new II0xO0(iI0xO0));
            try {
                mediaPlayer.setDataSource(string);
                mediaPlayer.prepareAsync();
                return;
            } catch (Exception unused) {
                xxIXOIIO.II0XooXoX("openSDK_LOG.QzonePublish", "publishToQzone() exception(s) occurred when preparing mediaplayer");
                iI0xO0.oIX0oI(new o0Oo.I0Io(-5, com.tencent.connect.common.II0xO0.f26732I0X0x0oIo, null));
                return;
            }
        }
        iI0xO0.oIX0oI(new o0Oo.I0Io(-5, com.tencent.connect.common.II0xO0.f26818XX0, null));
        xxIXOIIO.II0XooXoX("openSDK_LOG.QzonePublish", "publishToQzone() error--end请选择支持的分享类型");
        OOXIXo.oIX0oI().II0xO0(1, "SHARE_CHECK_SDK", com.tencent.connect.common.II0xO0.f26842oIX0oI, this.c.X0o0xo(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publishToQzone() 请选择支持的分享类型");
    }
}
