package com.sma.smartv3.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.androidnetworking.utils.ParseUtil;
import com.baidu.mobads.sdk.internal.cn;
import com.bestmafen.baseble.scanner.BleDevice;
import com.blankj.utilcode.constant.RegexConstants;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.jieli.bluetooth_connect.constant.BluetoothConstant;
import com.sifli.siflidfu.DFUImagePath;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.voice.VoiceManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.pop.AiKeyEditPopup;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.component.BleConstsKt;
import com.szabh.smable3.entity.BleDeviceFile;
import com.szabh.smable3.entity.Languages;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.oXIO0o0XI;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/sma/smartv3/util/UtilsKt\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,736:1\n215#2,2:737\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/sma/smartv3/util/UtilsKt\n*L\n393#1:737,2\n*E\n"})
/* loaded from: classes12.dex */
public final class UtilsKt {

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends ViewOutlineProvider {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ float f24320oIX0oI;

        public oIX0oI(float f) {
            this.f24320oIX0oI = f;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@OXOo.OOXIXo View view, @OXOo.OOXIXo Outline outline) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            kotlin.jvm.internal.IIX0o.x0xO0oo(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f24320oIX0oI);
        }
    }

    @OXOo.OOXIXo
    public static final Map<String, String> I0Io(@OXOo.OOXIXo Context context, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        HashMap hashMap = new HashMap();
        Map<String, String> II0xO02 = II0xO0(context, i);
        Locale locale = Locale.ENGLISH;
        String str = II0xO02.get(locale.toString());
        if (str == null) {
            str = "";
        }
        String locale2 = locale.toString();
        kotlin.jvm.internal.IIX0o.oO(locale2, "toString(...)");
        hashMap.put(locale2, str);
        for (Map.Entry<String, String> entry : II0xO02.entrySet()) {
            if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(entry.getValue(), str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    @OXOo.OOXIXo
    @SuppressLint({"DefaultLocale"})
    public static final String II0XooXoX(float f) {
        if (f == 0.0f) {
            if (ProjectManager.f19822oIX0oI.XI()) {
                return HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
            }
            return cn.d;
        }
        kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f / 10.0f)}, 1));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        return format;
    }

    @OXOo.OOXIXo
    public static final Map<String, String> II0xO0(@OXOo.OOXIXo Context context, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        HashMap hashMap = new HashMap();
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        kotlin.jvm.internal.IIX0o.oO(configuration, "getConfiguration(...)");
        Locale[] availableLocales = Locale.getAvailableLocales();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(availableLocales);
        for (Locale locale : availableLocales) {
            configuration.setLocale(locale);
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            String string = resources.getString(i);
            kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
            if (string.length() > 0) {
                String locale2 = locale.toString();
                kotlin.jvm.internal.IIX0o.oO(locale2, "toString(...)");
                hashMap.put(locale2, string);
            }
        }
        return hashMap;
    }

    public static final boolean IIX0o(@OXOo.OOXIXo Context context) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(context.getResources().getConfiguration().locale.getCountry(), "IN");
    }

    @OXOo.OOXIXo
    public static final String IIXOooo(@OXOo.OOXIXo String string) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(string, "string");
        int hashCode = string.hashCode();
        if (hashCode != 48) {
            if (hashCode != 1440) {
                if (hashCode != 47602 || !string.equals(cn.d)) {
                    return string;
                }
            } else if (!string.equals(HelpFormatter.DEFAULT_LONG_OPT_PREFIX)) {
                return string;
            }
        } else if (!string.equals("0")) {
            return string;
        }
        if (!ProjectManager.f19822oIX0oI.XI()) {
            return "0";
        }
        return HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
    }

    public static final boolean IO(@OXOo.OOXIXo Context context) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(context.getResources().getConfiguration().locale.getLanguage(), Languages.DEFAULT_LANGUAGE_ZH);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009e A[RETURN, SYNTHETIC] */
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String IXxxXO() {
        /*
            com.sma.smartv3.network.Api r0 = com.sma.smartv3.network.Api.INSTANCE
            java.lang.String r0 = r0.getBASE_URL()
            int r1 = r0.hashCode()
            r2 = 2132018444(0x7f14050c, float:1.9675195E38)
            r3 = 2132017918(0x7f1402fe, float:1.9674128E38)
            java.lang.String r4 = "getString(...)"
            switch(r1) {
                case -2019210183: goto L96;
                case -1644804843: goto L81;
                case -1633488716: goto L6c;
                case -167076722: goto L54;
                case 1433701912: goto L3c;
                case 1582655416: goto L25;
                case 1816079795: goto L17;
                default: goto L15;
            }
        L15:
            goto L9e
        L17:
            java.lang.String r1 = "https://dev.iot-solution.net/kotlinweb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L21
            goto L9e
        L21:
            java.lang.String r0 = "Dev Server"
            goto Lac
        L25:
            java.lang.String r1 = "https://api-c.iot-solution.net/kotlinweb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2f
            goto L9e
        L2f:
            android.app.Application r0 = com.blankj.utilcode.util.Utils.getApp()
            java.lang.String r0 = r0.getString(r3)
            kotlin.jvm.internal.IIX0o.oO(r0, r4)
            goto Lac
        L3c:
            java.lang.String r1 = "https://api-usa.iot-solution.net/kotlinweb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L45
            goto L9e
        L45:
            android.app.Application r0 = com.blankj.utilcode.util.Utils.getApp()
            r1 = 2132021601(0x7f141161, float:1.9681598E38)
            java.lang.String r0 = r0.getString(r1)
            kotlin.jvm.internal.IIX0o.oO(r0, r4)
            goto Lac
        L54:
            java.lang.String r1 = "https://api.iot-solution.net/kotlinweb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5d
            goto L9e
        L5d:
            android.app.Application r0 = com.blankj.utilcode.util.Utils.getApp()
            r1 = 2132017477(0x7f140145, float:1.9673234E38)
            java.lang.String r0 = r0.getString(r1)
            kotlin.jvm.internal.IIX0o.oO(r0, r4)
            goto Lac
        L6c:
            java.lang.String r1 = "https://api.eg.iot-solution.net/kotlinweb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L75
            goto L9e
        L75:
            android.app.Application r0 = com.blankj.utilcode.util.Utils.getApp()
            java.lang.String r0 = r0.getString(r2)
            kotlin.jvm.internal.IIX0o.oO(r0, r4)
            goto Lac
        L81:
            java.lang.String r1 = "https://api-eg.iot-solution.net/kotlinweb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L8a
            goto L9e
        L8a:
            android.app.Application r0 = com.blankj.utilcode.util.Utils.getApp()
            java.lang.String r0 = r0.getString(r2)
            kotlin.jvm.internal.IIX0o.oO(r0, r4)
            goto Lac
        L96:
            java.lang.String r1 = "https://api.c.iot-solution.net/kotlinweb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto La1
        L9e:
            java.lang.String r0 = "Test Server"
            goto Lac
        La1:
            android.app.Application r0 = com.blankj.utilcode.util.Utils.getApp()
            java.lang.String r0 = r0.getString(r3)
            kotlin.jvm.internal.IIX0o.oO(r0, r4)
        Lac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.util.UtilsKt.IXxxXO():java.lang.String");
    }

    @OXOo.OOXIXo
    public static final String Io(@OXOo.OOXIXo String bleAddress) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bleAddress, "bleAddress");
        return StringsKt___StringsKt.I0xoOOIx(kotlin.text.OxI.IIOIX(bleAddress, ":", "", false, 4, null), 4);
    }

    public static final boolean IoOoX(@OXOo.OOXIXo String text) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
        return RegexUtils.isMatch(RegexConstants.REGEX_MOBILE_SIMPLE, text);
    }

    @OXOo.OOXIXo
    public static final String O0xOxO() {
        return "2_" + DeviceUtils.getUniqueDeviceId();
    }

    public static final void OI0(@OXOo.OOXIXo Activity activity, @OXOo.OOXIXo final Oox.oIX0oI<oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        com.sma.smartv3.pop.IIX0o iIX0o = new com.sma.smartv3.pop.IIX0o(activity, R.layout.pop_edit_security_code);
        final int i = 837765;
        iIX0o.IO(new Oox.oOoXoXO<String, Boolean>() { // from class: com.sma.smartv3.util.UtilsKt$showRepairSecurityCodePopup$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.OOXIXo String text) {
                boolean z;
                kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(text, String.valueOf(i))) {
                    action.invoke();
                    z = true;
                } else {
                    ToastUtils.showLong(R.string.verification_code_error);
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
        iIX0o.IIXOooo();
    }

    @OXOo.OOXIXo
    @SuppressLint({"DefaultLocale"})
    public static final String OOXIXo(int i, int i2) {
        if (i == 0 && i2 == 0) {
            if (ProjectManager.f19822oIX0oI.XI()) {
                return HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
            }
            kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
            String format = String.format("%d - %d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}, 2));
            kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
            return format;
        }
        kotlin.jvm.internal.oxxXoxO oxxxoxo2 = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format2 = String.format("%d - %d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}, 2));
        kotlin.jvm.internal.IIX0o.oO(format2, "format(...)");
        return format2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int Oo() {
        /*
            com.szabh.smable3.component.BleCache r0 = com.szabh.smable3.component.BleCache.INSTANCE
            java.lang.String r0 = r0.getMPlatform()
            int r1 = r0.hashCode()
            switch(r1) {
                case -1955887059: goto L2f;
                case -1549651556: goto L24;
                case 78896685: goto L19;
                case 1697379018: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L37
        Le:
            java.lang.String r1 = "JL707Lite"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L17
            goto L37
        L17:
            r0 = 4
            goto L3a
        L19:
            java.lang.String r1 = "SIFLI"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L22
            goto L37
        L22:
            r0 = 3
            goto L3a
        L24:
            java.lang.String r1 = "Realtek"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2d
            goto L37
        L2d:
            r0 = 1
            goto L3a
        L2f:
            java.lang.String r1 = "Nordic"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L39
        L37:
            r0 = 0
            goto L3a
        L39:
            r0 = 2
        L3a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.util.UtilsKt.Oo():int");
    }

    @OXOo.OOXIXo
    public static final String OxI(int i) {
        if (i <= 2) {
            String string = Utils.getApp().getString(R.string.low);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(string);
            return string;
        }
        if (i <= 5) {
            String string2 = Utils.getApp().getString(R.string.hr_zone3);
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(string2);
            return string2;
        }
        String string3 = Utils.getApp().getString(R.string.high);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(string3);
        return string3;
    }

    @OXOo.oOoXoXO
    public static final <T> T Oxx0IOOO(@OXOo.OOXIXo String errorBody, @OXOo.oOoXoXO Class<T> cls) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(errorBody, "errorBody");
        try {
            return (T) ParseUtil.getParserFactory().getObject(errorBody, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final int Oxx0xo() {
        String base_url = Api.INSTANCE.getBASE_URL();
        int hashCode = base_url.hashCode();
        if (hashCode != -1644804843) {
            if (hashCode != -167076722) {
                if (hashCode != 1582655416 || !base_url.equals(com.sma.smartv3.ui.login.ooOOo0oXI.f23071I0Io)) {
                    return 0;
                }
                return 1;
            }
            base_url.equals(com.sma.smartv3.ui.login.ooOOo0oXI.f23074oIX0oI);
            return 0;
        }
        if (!base_url.equals(com.sma.smartv3.ui.login.ooOOo0oXI.f23072II0xO0)) {
            return 0;
        }
        return 2;
    }

    @OXOo.OOXIXo
    public static final String OxxIIOOXO(int i) {
        if (i == 0) {
            if (ProjectManager.f19822oIX0oI.XI()) {
                return HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
            }
            return "0";
        }
        return String.valueOf(i);
    }

    public static final boolean X00IoxXI(@OXOo.OOXIXo Context context) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        Locale locale = context.getResources().getConfiguration().locale;
        String country = locale.getCountry();
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(locale.getLanguage(), Languages.DEFAULT_LANGUAGE_ZH) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(country, "CN")) {
            return true;
        }
        return false;
    }

    public static final int X0IIOO(@OXOo.OOXIXo Context mContext, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mContext, "mContext");
        try {
            return mContext.getResources().getIdentifier("pic_weather_bg" + XI0IXoo(i), "drawable", mContext.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return R.drawable.pic_weather_bg1;
        }
    }

    @OXOo.OOXIXo
    public static final String X0o0xo() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: ");
        BleCache bleCache = BleCache.INSTANCE;
        sb.append(bleCache.getMBleName());
        sb.append("\nplatform: ");
        sb.append(bleCache.getMPlatform());
        sb.append("\nprototype: ");
        sb.append(bleCache.getMPrototype());
        sb.append("\nfw flag: ");
        sb.append(bleCache.getMFirmwareFlag());
        sb.append("\nfw ver: ");
        sb.append(BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null));
        sb.append("\nui ver: ");
        sb.append(BleCache.getString$default(bleCache, BleKey.UI_PACK_VERSION, null, null, 6, null));
        sb.append("\ngps fw ver: ");
        sb.append(BleCache.getString$default(bleCache, BleKey.GPS_FIRMWARE_VERSION, null, null, 6, null));
        sb.append("\n4g fw ver: ");
        sb.append(BleCache.getString$default(bleCache, BleKey.NETWORK_FIRMWARE_VERSION, null, null, 6, null));
        return sb.toString();
    }

    public static final int XI0IXoo(int i) {
        if (ProductManager.f20544oIX0oI.OxXXx0X()) {
            if (i != 2) {
                if (i == 3) {
                    return 2;
                }
                return i;
            }
            return 3;
        }
        return i;
    }

    public static final int XIxXXX0x0(@OXOo.OOXIXo Context mContext, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mContext, "mContext");
        try {
            return mContext.getResources().getIdentifier("ic_weather" + XI0IXoo(i), "drawable", mContext.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return R.drawable.ic_weather0;
        }
    }

    @OXOo.OOXIXo
    public static final String XO(@OXOo.OOXIXo String address) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(address, "address");
        long parseLong = Long.parseLong(kotlin.text.OxI.IIOIX(address, ":", "", false, 4, null), kotlin.text.II0xO0.oIX0oI(16)) + 1;
        kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format = String.format("%012X", Arrays.copyOf(new Object[]{Long.valueOf(parseLong)}, 1));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        return CollectionsKt___CollectionsKt.OoIXo(StringsKt___StringsKt.X0OXI(format, 2), ":", null, null, 0, null, null, 62, null);
    }

    public static final void XOxIOxOx(@OXOo.OOXIXo final Activity activity) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "activity");
        LogUtils.d("showAiKeyPopup");
        final AiKeyEditPopup aiKeyEditPopup = new AiKeyEditPopup();
        aiKeyEditPopup.setMListener(new Oox.oOoXoXO<String, Boolean>() { // from class: com.sma.smartv3.util.UtilsKt$showAiKeyPopup$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.OOXIXo String text) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
                KeyboardUtils.hideSoftInput(activity);
                final String obj = StringsKt__StringsKt.oIoIXxIO(text).toString();
                if (TextUtils.isEmpty(obj)) {
                    ToastUtils.showLong(R.string.ai_key_input_tip);
                } else {
                    VoiceManager voiceManager = VoiceManager.INSTANCE;
                    String obj2 = StringsKt__StringsKt.oIoIXxIO(text).toString();
                    final AiKeyEditPopup aiKeyEditPopup2 = aiKeyEditPopup;
                    voiceManager.openAiCheck(obj2, new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.util.UtilsKt$showAiKeyPopup$1$1.1
                        @Override // xxxI.II0xO0
                        public void handleError(@OXOo.OOXIXo String error) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                        }

                        @Override // xxxI.II0xO0
                        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                        public void handleResponse(@OXOo.oOoXoXO String str) {
                            Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24480xOOOX, obj);
                            aiKeyEditPopup2.dismiss();
                        }
                    }, activity, aiKeyEditPopup.getMLayout());
                }
                return false;
            }
        });
        aiKeyEditPopup.show((AppCompatActivity) activity);
    }

    public static final boolean Xx000oIo(@OXOo.OOXIXo Context context) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(context.getResources().getConfiguration().locale.getCountry(), "US");
    }

    public static final int XxX0x0xxx(@OXOo.OOXIXo Context mContext, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mContext, "mContext");
        try {
            int identifier = mContext.getResources().getIdentifier("weather_name" + i, TypedValues.Custom.S_STRING, mContext.getPackageName());
            if (identifier == 0) {
                return R.string.weather_name1;
            }
            return identifier;
        } catch (Exception e) {
            e.printStackTrace();
            return R.string.weather_name1;
        }
    }

    public static final void o0(@OXOo.OOXIXo View view, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        if (z) {
            view.setLayerType(2, paint);
        } else {
            view.setLayerType(2, null);
        }
    }

    @OXOo.OOXIXo
    public static final String o00(int i) {
        if (i == 0) {
            if (ProjectManager.f19822oIX0oI.XI()) {
                return "_";
            }
            return "0";
        }
        return String.valueOf(i);
    }

    @OXOo.OOXIXo
    public static final String oI0IIXIo(int i) {
        String string = Utils.getApp().getResources().getString(i);
        kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
        return string;
    }

    public static final double oIX0oI(double d) {
        return 44330 * (1 - Math.pow(d / 1013.25d, 0.190284d));
    }

    @OXOo.OOXIXo
    public static final String oO() {
        return OI0.oxoX.oxoX().X0o0xo() + "-Android " + Build.VERSION.RELEASE;
    }

    public static final boolean oOXoIIIo(@OXOo.OOXIXo Context context) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(context.getResources().getConfiguration().locale.getLanguage(), "pt");
    }

    @OXOo.OOXIXo
    public static final String oOoXoXO(@OXOo.OOXIXo BleDevice device) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
        if (oo0xXOI0I(device)) {
            byte[] mScanRecord = device.getMScanRecord();
            if (mScanRecord == null) {
                mScanRecord = new byte[20];
            }
            return CollectionsKt___CollectionsKt.OoIXo(ArraysKt___ArraysKt.ooXxX(kotlin.collections.ooOOo0oXI.xxOXOOoIX(mScanRecord, 10, 16)), ":", null, null, 0, null, new Oox.oOoXoXO<Byte, CharSequence>() { // from class: com.sma.smartv3.util.UtilsKt$getJLOriginAddress$1
                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                    return invoke(b.byteValue());
                }

                @OXOo.OOXIXo
                public final CharSequence invoke(byte b) {
                    kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
                    String format = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                    kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
                    return format;
                }
            }, 30, null);
        }
        String address = device.getMBluetoothDevice().getAddress();
        kotlin.jvm.internal.IIX0o.oO(address, "getAddress(...)");
        return address;
    }

    public static final boolean oo() {
        Object systemService = Utils.getApp().getSystemService("location");
        kotlin.jvm.internal.IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        if (!locationManager.isProviderEnabled("gps") && !locationManager.isProviderEnabled("network")) {
            return false;
        }
        return true;
    }

    public static final boolean oo0xXOI0I(@OXOo.OOXIXo BleDevice device) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
        byte[] mScanRecord = device.getMScanRecord();
        if (mScanRecord == null) {
            mScanRecord = new byte[20];
        }
        if (mScanRecord.length > 20) {
            return kotlin.jvm.internal.IIX0o.Oxx0IOOO(new String(CollectionsKt___CollectionsKt.oIxXXOI(ArraysKt___ArraysKt.ooXxX(kotlin.collections.ooOOo0oXI.xxOXOOoIX(mScanRecord, 4, 9))), kotlin.text.oxoX.f29581II0xO0), BluetoothConstant.OTA_FILTER_FLAG);
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final com.sma.smartv3.location.oIX0oI ooOOo0oXI() {
        com.sma.smartv3.location.oIX0oI oix0oi = new com.sma.smartv3.location.oIX0oI(XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 0.0f, 0, 31, null);
        String string = Xo0.f24349oIX0oI.XO().getString(XoI0Ixx0.f24423XX);
        try {
            if (!TextUtils.isEmpty(string)) {
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(string);
                List XXoO0oX2 = StringsKt__StringsKt.XXoO0oX(string, new String[]{","}, false, 0, 6, null);
                oix0oi.II0XooXoX(Double.parseDouble((String) XXoO0oX2.get(0)));
                oix0oi.Oxx0IOOO(Double.parseDouble((String) XXoO0oX2.get(1)));
                oix0oi.XO(Double.parseDouble((String) XXoO0oX2.get(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("getLocationFromCache error: " + string + ", " + e.getMessage());
        }
        return oix0oi;
    }

    public static final boolean ooXIXxIX(@OXOo.OOXIXo Context context) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(context.getResources().getConfiguration().locale.getLanguage(), "it");
    }

    @OXOo.OOXIXo
    public static final ArrayList<DFUImagePath> oxoX(@OXOo.OOXIXo List<? extends File> fileList) {
        int i;
        kotlin.jvm.internal.IIX0o.x0xO0oo(fileList, "fileList");
        ArrayList<DFUImagePath> arrayList = new ArrayList<>();
        for (File file : fileList) {
            Uri fromFile = Uri.fromFile(file);
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("getDFUImagePath  path=" + fromFile.getPath() + ",scheme=" + fromFile.getScheme());
            String name = file.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -2014123484:
                        if (name.equals("otaFont.bin")) {
                            i = 4;
                            break;
                        }
                        break;
                    case -1426007810:
                        if (name.equals("otaApp.bin")) {
                            i = 0;
                            break;
                        }
                        break;
                    case -676093707:
                        if (name.equals("ctrl_packet.bin")) {
                            i = -1;
                            break;
                        }
                        break;
                    case 464502781:
                        if (name.equals("otaRes.bin")) {
                            i = 3;
                            break;
                        }
                        break;
                    case 1683716375:
                        if (name.equals("otaroot.bin")) {
                            i = 5;
                            break;
                        }
                        break;
                }
            }
            i = -333;
            if (i != -333) {
                arrayList.add(new DFUImagePath(null, fromFile, i));
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final String x0XOIxOo(@OXOo.OOXIXo String url) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(url, "url");
        String path = Uri.parse(url).getPath();
        if (path != null) {
            String name = new File(path).getName();
            kotlin.jvm.internal.IIX0o.oO(name, "getName(...)");
            return name;
        }
        String encryptMD5ToString = EncryptUtils.encryptMD5ToString(url);
        kotlin.jvm.internal.IIX0o.oO(encryptMD5ToString, "encryptMD5ToString(...)");
        return encryptMD5ToString;
    }

    public static final void x0o(@OXOo.OOXIXo View view, float f) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "<this>");
        view.setOutlineProvider(new oIX0oI(f));
        view.setClipToOutline(true);
    }

    @OXOo.OOXIXo
    public static final String x0xO0oo() {
        return OI0.oxoX.II0xO0() + TokenParser.SP + OI0.oxoX.I0Io();
    }

    public static final boolean xI(@OXOo.OOXIXo BleDevice device) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
        byte[] mScanRecord = device.getMScanRecord();
        if (mScanRecord == null) {
            mScanRecord = new byte[20];
        }
        if (mScanRecord.length > 20 && mScanRecord[2] == -42 && mScanRecord[3] == 5) {
            return true;
        }
        return false;
    }

    public static final boolean xII(@OXOo.OOXIXo BleDeviceFile deviceFile) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(deviceFile, "deviceFile");
        LogUtils.d("saveDeviceLog -> " + deviceFile);
        Date date = new Date();
        long offset = (long) TimeZone.getDefault().getOffset(System.currentTimeMillis());
        if (deviceFile.getMFileSize() == 0) {
            return true;
        }
        date.setTime(((deviceFile.getMTime() + BleConstsKt.DATA_EPOCH) * 1000) - offset);
        File file = new File(com.sma.smartv3.initializer.IXxxXO.Oxx0xo(X00IoxXI.oIX0oI.f3233oIX0oI), xoIox.OO0x0xX().format(date) + '.' + deviceFile.getMFileFormat());
        if (deviceFile.getMOffsetValue() == 0) {
            file.delete();
        }
        FileIOUtils.writeFileFromBytesByStream(file, deviceFile.getMFileContent(), true);
        BleConnector.sendData$default(BleConnector.INSTANCE, BleKey.DEVICE_FILE, BleKeyFlag.READ_CONTINUE, null, false, false, 28, null);
        return false;
    }

    public static final boolean xXxxox0I(@OXOo.OOXIXo Context context) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(context.getResources().getConfiguration().locale.getLanguage(), "es");
    }

    @OXOo.OOXIXo
    @SuppressLint({"DefaultLocale"})
    public static final String xoIox(int i) {
        if (i == 0) {
            if (ProjectManager.f19822oIX0oI.XI()) {
                return HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
            }
            return "0";
        }
        kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(i / 10.0f)}, 1));
        kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
        return format;
    }

    @OXOo.OOXIXo
    public static final String xoXoI(@OXOo.OOXIXo Context context) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        String country = context.getResources().getConfiguration().locale.getCountry();
        kotlin.jvm.internal.IIX0o.oO(country, "getCountry(...)");
        return country;
    }

    @OXOo.OOXIXo
    @SuppressLint({"DefaultLocale"})
    public static final String xxIXOIIO(float f, float f2) {
        if (f == 0.0f || f2 == 0.0f) {
            if (ProjectManager.f19822oIX0oI.XI()) {
                kotlin.jvm.internal.oxxXoxO oxxxoxo = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
                String format = String.format(HelpFormatter.DEFAULT_LONG_OPT_PREFIX, Arrays.copyOf(new Object[0], 0));
                kotlin.jvm.internal.IIX0o.oO(format, "format(...)");
                return format;
            }
            kotlin.jvm.internal.oxxXoxO oxxxoxo2 = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
            String format2 = String.format("%s - %s", Arrays.copyOf(new Object[]{cn.d, cn.d}, 2));
            kotlin.jvm.internal.IIX0o.oO(format2, "format(...)");
            return format2;
        }
        kotlin.jvm.internal.oxxXoxO oxxxoxo3 = kotlin.jvm.internal.oxxXoxO.f29356oIX0oI;
        String format3 = String.format("%.1f - %.1f", Arrays.copyOf(new Object[]{Float.valueOf(f), Float.valueOf(f2)}, 2));
        kotlin.jvm.internal.IIX0o.oO(format3, "format(...)");
        return format3;
    }

    public static final int xxX(@OXOo.OOXIXo Context mContext, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mContext, "mContext");
        try {
            return mContext.getResources().getIdentifier("ic_weather_larger" + XI0IXoo(i), "drawable", mContext.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return R.drawable.ic_weather_larger1;
        }
    }
}
