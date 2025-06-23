package com.sma.smartv3.ble;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.blankj.utilcode.util.ServiceUtils;
import com.sma.smartv3.util.TextConvertKt;
import com.szabh.smable3.entity.BleNotification;
import com.szabh.smable3.music.MusicControllerCompat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nMyNotificationListenerService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyNotificationListenerService.kt\ncom/sma/smartv3/ble/MyNotificationListenerService\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,659:1\n13309#2,2:660\n1#3:662\n*S KotlinDebug\n*F\n+ 1 MyNotificationListenerService.kt\ncom/sma/smartv3/ble/MyNotificationListenerService\n*L\n132#1:660,2\n*E\n"})
/* loaded from: classes12.dex */
public final class MyNotificationListenerService extends NotificationListenerService {

    /* renamed from: O0xOxO, reason: collision with root package name */
    @OOXIXo
    public static final String f20318O0xOxO = "MyNotificationListenerService";

    /* renamed from: OxI, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f20319OxI = new oIX0oI(null);

    /* renamed from: IXxxXO, reason: collision with root package name */
    public long f20321IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @oOoXoXO
    public MusicControllerCompat f20322Oo;

    /* renamed from: XO, reason: collision with root package name */
    public long f20325XO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OOXIXo
    public String f20323Oxx0xo = "";

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OOXIXo
    public String f20327oI0IIXIo = "";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OOXIXo
    public String f20324OxxIIOOXO = "";

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OOXIXo
    public final Map<String, String> f20320IIXOooo = new LinkedHashMap();

    /* renamed from: xoXoI, reason: collision with root package name */
    @OOXIXo
    public final Map<String, Long> f20328xoXoI = new LinkedHashMap();

    /* renamed from: o00, reason: collision with root package name */
    @OOXIXo
    public final Map<String, String> f20326o00 = new LinkedHashMap();

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public final void I0Io(@OOXIXo Context context) {
            IIX0o.x0xO0oo(context, "context");
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, (Class<?>) MyNotificationListenerService.class), 1, 1);
        }

        public final void II0XooXoX(@OOXIXo Context context) {
            IIX0o.x0xO0oo(context, "context");
            context.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
        }

        public final void II0xO0(@OOXIXo Context context) {
            IIX0o.x0xO0oo(context, "context");
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, (Class<?>) MyNotificationListenerService.class), 2, 1);
        }

        public final void Oxx0IOOO(@OOXIXo Context context) {
            IIX0o.x0xO0oo(context, "context");
            OI0.oIX0oI.f1507oIX0oI.XO("MyNotificationListenerService reEnable");
            II0xO0(context);
            I0Io(context);
        }

        public final boolean X0o0xo(@OOXIXo Context context) {
            IIX0o.x0xO0oo(context, "context");
            boolean contains = NotificationManagerCompat.getEnabledListenerPackages(context).contains(context.getPackageName());
            OI0.oIX0oI.f1507oIX0oI.XO("MyNotificationListenerService isEnabled=" + contains);
            return contains;
        }

        public final boolean XO() {
            return ServiceUtils.isServiceRunning((Class<?>) MyNotificationListenerService.class);
        }

        public final void oIX0oI(@OOXIXo Context context) {
            IIX0o.x0xO0oo(context, "context");
            if (X0o0xo(context) && !XO()) {
                Oxx0IOOO(context);
            }
        }

        public final boolean oxoX(@OOXIXo String packageName, @OOXIXo String[] filter) {
            IIX0o.x0xO0oo(packageName, "packageName");
            IIX0o.x0xO0oo(filter, "filter");
            for (String str : filter) {
                if (IIX0o.Oxx0IOOO(str, packageName)) {
                    return true;
                }
            }
            return false;
        }

        public oIX0oI() {
        }
    }

    public final boolean I0Io(String str) {
        Long l = this.f20328xoXoI.get(str);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("Last push time: " + l);
        if (l != null && System.currentTimeMillis() - l.longValue() < 600) {
            return true;
        }
        return false;
    }

    public final String II0xO0(Notification notification, String str) {
        String str2;
        CharSequence[] charSequenceArray;
        boolean z;
        Bundle bundle = notification.extras;
        if (bundle != null && (charSequenceArray = bundle.getCharSequenceArray(NotificationCompat.EXTRA_TEXT_LINES)) != null) {
            if (charSequenceArray.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                int hashCode = str.hashCode();
                if (hashCode == -1901151293 ? str.equals(BleNotification.ZALO) : !(hashCode == -1547699361 ? !str.equals(BleNotification.WHATS_APP) : !(hashCode == 10619783 && str.equals(BleNotification.TWITTER)))) {
                    Object O0X0xoXo = ArraysKt___ArraysKt.O0X0xoXo(charSequenceArray);
                    IIX0o.oO(O0X0xoXo, "last(...)");
                    str2 = TextConvertKt.I0oOoX((CharSequence) O0X0xoXo);
                } else {
                    Object XXOXXx = ArraysKt___ArraysKt.XXOXXx(charSequenceArray);
                    IIX0o.oO(XXOXXx, "first(...)");
                    str2 = TextConvertKt.I0oOoX((CharSequence) XXOXXx);
                }
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("getTextlines -> " + str2);
                return str2;
            }
        }
        str2 = null;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("getTextlines -> " + str2);
        return str2;
    }

    public final Pair<String, String> Oxx0IOOO(String str, String str2, String str3, String str4) {
        if (IIX0o.Oxx0IOOO(str3, BleNotification.GMAIL)) {
            if (StringsKt__StringsKt.o00xOoIO(str2, " ", false, 2, null)) {
                str = (String) StringsKt__StringsKt.XXoO0oX(str2, new String[]{" "}, false, 0, 6, null).get(0);
                str2 = str2.substring(StringsKt__StringsKt.O0O0Io00X(str2, " ", 0, false, 6, null));
                IIX0o.oO(str2, "substring(...)");
            } else if (StringsKt__StringsKt.o00xOoIO(str2, "  ", false, 2, null)) {
                str = (String) StringsKt__StringsKt.XXoO0oX(str2, new String[]{"  "}, false, 0, 6, null).get(0);
                str2 = str2.substring(StringsKt__StringsKt.O0O0Io00X(str2, "  ", 0, false, 6, null));
                IIX0o.oO(str2, "substring(...)");
            }
        } else {
            if (IIX0o.Oxx0IOOO(str3, BleNotification.WHATS_APP)) {
                return XO(str, str2);
            }
            if (IIX0o.Oxx0IOOO(str, str4)) {
                return XO(str, str2);
            }
        }
        return new Pair<>(StringsKt__StringsKt.oIoIXxIO(str).toString(), StringsKt__StringsKt.oIoIXxIO(str2).toString());
    }

    public final boolean X0o0xo() {
        return ProductManager.f20544oIX0oI.oXxOXOX();
    }

    public final Pair<String, String> XO(String str, String str2) {
        if (StringsKt__StringsKt.o00xOoIO(str2, ":", false, 2, null)) {
            str = (String) StringsKt__StringsKt.XXoO0oX(str2, new String[]{":"}, false, 0, 6, null).get(0);
            String substring = str2.substring(StringsKt__StringsKt.O0O0Io00X(str2, ":", 0, false, 6, null));
            IIX0o.oO(substring, "substring(...)");
            if (StringsKt__StringsKt.o00xOoIO(str, " @ ", false, 2, null)) {
                String str3 = (String) StringsKt__StringsKt.XXoO0oX(str, new String[]{" @ "}, false, 0, 6, null).get(1);
                str2 = ((String) StringsKt__StringsKt.XXoO0oX(str, new String[]{" @ "}, false, 0, 6, null).get(0)) + substring;
                str = str3;
            } else {
                str2 = substring.substring(1);
                IIX0o.oO(str2, "substring(...)");
            }
        }
        return new Pair<>(StringsKt__StringsKt.oIoIXxIO(str).toString(), StringsKt__StringsKt.oIoIXxIO(str2).toString());
    }

    public final String oIX0oI(CharSequence[] charSequenceArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (charSequenceArr != null) {
            for (CharSequence charSequence : charSequenceArr) {
                stringBuffer.append(charSequence);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        IIX0o.oO(stringBuffer2, "toString(...)");
        return stringBuffer2;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        OI0.oIX0oI.f1507oIX0oI.XO("MyNotificationListenerService onCreate");
        try {
            MusicControllerCompat newInstance = MusicControllerCompat.Companion.newInstance();
            newInstance.launch(this);
            this.f20322Oo = newInstance;
        } catch (Exception e) {
            OI0.oIX0oI.f1507oIX0oI.XO("MyNotificationListenerService MusicController launch error:" + e.getMessage());
        }
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public void onDestroy() {
        OI0.oIX0oI.f1507oIX0oI.XO("MyNotificationListenerService onDestroy");
        MusicControllerCompat musicControllerCompat = this.f20322Oo;
        if (musicControllerCompat != null) {
            musicControllerCompat.exit();
        }
        super.onDestroy();
    }

    @Override // android.service.notification.NotificationListenerService
    @RequiresApi(api = 24)
    public void onListenerDisconnected() {
        OI0.oIX0oI.f1507oIX0oI.XO("MyNotificationListenerService onListenerDisconnected");
        NotificationListenerService.requestRebind(new ComponentName(this, (Class<?>) MyNotificationListenerService.class));
    }

    /* JADX WARN: Code restructure failed: missing block: B:403:0x0833, code lost:
    
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(r10.toString(), "null") != false) goto L377;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0546 A[Catch: Exception -> 0x00a1, TryCatch #1 {Exception -> 0x00a1, blocks: (B:3:0x001a, B:7:0x005f, B:10:0x0066, B:13:0x0072, B:16:0x0082, B:20:0x00ce, B:22:0x0131, B:23:0x0144, B:25:0x014a, B:27:0x0177, B:28:0x018d, B:31:0x0197, B:33:0x019d, B:35:0x01a1, B:38:0x01a8, B:41:0x01af, B:42:0x01b1, B:44:0x01ba, B:46:0x01be, B:49:0x01c5, B:51:0x01cd, B:53:0x01d3, B:57:0x01e8, B:60:0x01f0, B:62:0x01fa, B:64:0x0200, B:68:0x0218, B:70:0x0249, B:72:0x0256, B:75:0x025f, B:82:0x0279, B:84:0x027f, B:87:0x0290, B:89:0x0296, B:92:0x02a0, B:94:0x02af, B:95:0x02b3, B:97:0x02bc, B:98:0x02c2, B:100:0x02d2, B:102:0x02d8, B:105:0x02df, B:107:0x02ee, B:110:0x02f5, B:112:0x0305, B:114:0x030e, B:118:0x0318, B:121:0x0324, B:123:0x032c, B:125:0x0335, B:127:0x033d, B:129:0x0346, B:131:0x034e, B:133:0x0356, B:135:0x035e, B:137:0x0366, B:139:0x036e, B:141:0x0376, B:143:0x037e, B:145:0x0386, B:147:0x038e, B:149:0x0396, B:151:0x039e, B:153:0x03a7, B:155:0x03af, B:157:0x03b7, B:159:0x03bf, B:161:0x03c8, B:183:0x03d1, B:185:0x03d9, B:187:0x03e5, B:189:0x03ee, B:191:0x03f6, B:193:0x03fe, B:195:0x0406, B:197:0x040e, B:199:0x0417, B:201:0x041f, B:203:0x0428, B:205:0x0430, B:207:0x0439, B:209:0x0442, B:211:0x044a, B:213:0x0453, B:215:0x045b, B:217:0x0463, B:219:0x046b, B:221:0x0474, B:242:0x047e, B:244:0x0484, B:247:0x0491, B:249:0x0497, B:251:0x04a3, B:253:0x04ab, B:258:0x04b5, B:260:0x04bb, B:262:0x04c7, B:264:0x04d0, B:266:0x04d9, B:268:0x04e1, B:270:0x04e9, B:272:0x04f1, B:274:0x04fa, B:276:0x0503, B:278:0x050c, B:280:0x0515, B:282:0x051e, B:284:0x0527, B:286:0x052f, B:288:0x0537, B:305:0x0540, B:307:0x0546, B:310:0x0557, B:312:0x055d, B:314:0x0565, B:316:0x056d, B:318:0x0575, B:321:0x0583, B:322:0x058b, B:325:0x059a, B:327:0x05a0, B:329:0x05ac, B:333:0x0618, B:335:0x061e, B:337:0x0634, B:339:0x063c, B:342:0x065b, B:345:0x0672, B:347:0x06b8, B:350:0x06c1, B:352:0x06c9, B:354:0x06d1, B:356:0x06d9, B:358:0x06e1, B:362:0x06eb, B:365:0x0702, B:367:0x070a, B:369:0x0710, B:371:0x0718, B:375:0x0750, B:377:0x0758, B:379:0x0760, B:381:0x0768, B:383:0x0770, B:385:0x0778, B:387:0x07da, B:390:0x07e1, B:392:0x07e7, B:394:0x07f4, B:396:0x0814, B:398:0x081e, B:402:0x0829, B:404:0x0837, B:407:0x0856, B:410:0x085e, B:412:0x0876, B:414:0x0889, B:415:0x08c5, B:417:0x08f2, B:418:0x093f, B:420:0x0934, B:421:0x093a, B:422:0x0942, B:424:0x0780, B:426:0x0786, B:430:0x079b, B:432:0x07b1, B:434:0x07bd, B:437:0x07ca, B:438:0x0726, B:441:0x0738, B:446:0x0745, B:451:0x02c6, B:460:0x00a5, B:462:0x00b4), top: B:2:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:325:0x059a A[Catch: Exception -> 0x00a1, TRY_ENTER, TryCatch #1 {Exception -> 0x00a1, blocks: (B:3:0x001a, B:7:0x005f, B:10:0x0066, B:13:0x0072, B:16:0x0082, B:20:0x00ce, B:22:0x0131, B:23:0x0144, B:25:0x014a, B:27:0x0177, B:28:0x018d, B:31:0x0197, B:33:0x019d, B:35:0x01a1, B:38:0x01a8, B:41:0x01af, B:42:0x01b1, B:44:0x01ba, B:46:0x01be, B:49:0x01c5, B:51:0x01cd, B:53:0x01d3, B:57:0x01e8, B:60:0x01f0, B:62:0x01fa, B:64:0x0200, B:68:0x0218, B:70:0x0249, B:72:0x0256, B:75:0x025f, B:82:0x0279, B:84:0x027f, B:87:0x0290, B:89:0x0296, B:92:0x02a0, B:94:0x02af, B:95:0x02b3, B:97:0x02bc, B:98:0x02c2, B:100:0x02d2, B:102:0x02d8, B:105:0x02df, B:107:0x02ee, B:110:0x02f5, B:112:0x0305, B:114:0x030e, B:118:0x0318, B:121:0x0324, B:123:0x032c, B:125:0x0335, B:127:0x033d, B:129:0x0346, B:131:0x034e, B:133:0x0356, B:135:0x035e, B:137:0x0366, B:139:0x036e, B:141:0x0376, B:143:0x037e, B:145:0x0386, B:147:0x038e, B:149:0x0396, B:151:0x039e, B:153:0x03a7, B:155:0x03af, B:157:0x03b7, B:159:0x03bf, B:161:0x03c8, B:183:0x03d1, B:185:0x03d9, B:187:0x03e5, B:189:0x03ee, B:191:0x03f6, B:193:0x03fe, B:195:0x0406, B:197:0x040e, B:199:0x0417, B:201:0x041f, B:203:0x0428, B:205:0x0430, B:207:0x0439, B:209:0x0442, B:211:0x044a, B:213:0x0453, B:215:0x045b, B:217:0x0463, B:219:0x046b, B:221:0x0474, B:242:0x047e, B:244:0x0484, B:247:0x0491, B:249:0x0497, B:251:0x04a3, B:253:0x04ab, B:258:0x04b5, B:260:0x04bb, B:262:0x04c7, B:264:0x04d0, B:266:0x04d9, B:268:0x04e1, B:270:0x04e9, B:272:0x04f1, B:274:0x04fa, B:276:0x0503, B:278:0x050c, B:280:0x0515, B:282:0x051e, B:284:0x0527, B:286:0x052f, B:288:0x0537, B:305:0x0540, B:307:0x0546, B:310:0x0557, B:312:0x055d, B:314:0x0565, B:316:0x056d, B:318:0x0575, B:321:0x0583, B:322:0x058b, B:325:0x059a, B:327:0x05a0, B:329:0x05ac, B:333:0x0618, B:335:0x061e, B:337:0x0634, B:339:0x063c, B:342:0x065b, B:345:0x0672, B:347:0x06b8, B:350:0x06c1, B:352:0x06c9, B:354:0x06d1, B:356:0x06d9, B:358:0x06e1, B:362:0x06eb, B:365:0x0702, B:367:0x070a, B:369:0x0710, B:371:0x0718, B:375:0x0750, B:377:0x0758, B:379:0x0760, B:381:0x0768, B:383:0x0770, B:385:0x0778, B:387:0x07da, B:390:0x07e1, B:392:0x07e7, B:394:0x07f4, B:396:0x0814, B:398:0x081e, B:402:0x0829, B:404:0x0837, B:407:0x0856, B:410:0x085e, B:412:0x0876, B:414:0x0889, B:415:0x08c5, B:417:0x08f2, B:418:0x093f, B:420:0x0934, B:421:0x093a, B:422:0x0942, B:424:0x0780, B:426:0x0786, B:430:0x079b, B:432:0x07b1, B:434:0x07bd, B:437:0x07ca, B:438:0x0726, B:441:0x0738, B:446:0x0745, B:451:0x02c6, B:460:0x00a5, B:462:0x00b4), top: B:2:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0618 A[Catch: Exception -> 0x00a1, TryCatch #1 {Exception -> 0x00a1, blocks: (B:3:0x001a, B:7:0x005f, B:10:0x0066, B:13:0x0072, B:16:0x0082, B:20:0x00ce, B:22:0x0131, B:23:0x0144, B:25:0x014a, B:27:0x0177, B:28:0x018d, B:31:0x0197, B:33:0x019d, B:35:0x01a1, B:38:0x01a8, B:41:0x01af, B:42:0x01b1, B:44:0x01ba, B:46:0x01be, B:49:0x01c5, B:51:0x01cd, B:53:0x01d3, B:57:0x01e8, B:60:0x01f0, B:62:0x01fa, B:64:0x0200, B:68:0x0218, B:70:0x0249, B:72:0x0256, B:75:0x025f, B:82:0x0279, B:84:0x027f, B:87:0x0290, B:89:0x0296, B:92:0x02a0, B:94:0x02af, B:95:0x02b3, B:97:0x02bc, B:98:0x02c2, B:100:0x02d2, B:102:0x02d8, B:105:0x02df, B:107:0x02ee, B:110:0x02f5, B:112:0x0305, B:114:0x030e, B:118:0x0318, B:121:0x0324, B:123:0x032c, B:125:0x0335, B:127:0x033d, B:129:0x0346, B:131:0x034e, B:133:0x0356, B:135:0x035e, B:137:0x0366, B:139:0x036e, B:141:0x0376, B:143:0x037e, B:145:0x0386, B:147:0x038e, B:149:0x0396, B:151:0x039e, B:153:0x03a7, B:155:0x03af, B:157:0x03b7, B:159:0x03bf, B:161:0x03c8, B:183:0x03d1, B:185:0x03d9, B:187:0x03e5, B:189:0x03ee, B:191:0x03f6, B:193:0x03fe, B:195:0x0406, B:197:0x040e, B:199:0x0417, B:201:0x041f, B:203:0x0428, B:205:0x0430, B:207:0x0439, B:209:0x0442, B:211:0x044a, B:213:0x0453, B:215:0x045b, B:217:0x0463, B:219:0x046b, B:221:0x0474, B:242:0x047e, B:244:0x0484, B:247:0x0491, B:249:0x0497, B:251:0x04a3, B:253:0x04ab, B:258:0x04b5, B:260:0x04bb, B:262:0x04c7, B:264:0x04d0, B:266:0x04d9, B:268:0x04e1, B:270:0x04e9, B:272:0x04f1, B:274:0x04fa, B:276:0x0503, B:278:0x050c, B:280:0x0515, B:282:0x051e, B:284:0x0527, B:286:0x052f, B:288:0x0537, B:305:0x0540, B:307:0x0546, B:310:0x0557, B:312:0x055d, B:314:0x0565, B:316:0x056d, B:318:0x0575, B:321:0x0583, B:322:0x058b, B:325:0x059a, B:327:0x05a0, B:329:0x05ac, B:333:0x0618, B:335:0x061e, B:337:0x0634, B:339:0x063c, B:342:0x065b, B:345:0x0672, B:347:0x06b8, B:350:0x06c1, B:352:0x06c9, B:354:0x06d1, B:356:0x06d9, B:358:0x06e1, B:362:0x06eb, B:365:0x0702, B:367:0x070a, B:369:0x0710, B:371:0x0718, B:375:0x0750, B:377:0x0758, B:379:0x0760, B:381:0x0768, B:383:0x0770, B:385:0x0778, B:387:0x07da, B:390:0x07e1, B:392:0x07e7, B:394:0x07f4, B:396:0x0814, B:398:0x081e, B:402:0x0829, B:404:0x0837, B:407:0x0856, B:410:0x085e, B:412:0x0876, B:414:0x0889, B:415:0x08c5, B:417:0x08f2, B:418:0x093f, B:420:0x0934, B:421:0x093a, B:422:0x0942, B:424:0x0780, B:426:0x0786, B:430:0x079b, B:432:0x07b1, B:434:0x07bd, B:437:0x07ca, B:438:0x0726, B:441:0x0738, B:446:0x0745, B:451:0x02c6, B:460:0x00a5, B:462:0x00b4), top: B:2:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0786 A[Catch: Exception -> 0x00a1, TryCatch #1 {Exception -> 0x00a1, blocks: (B:3:0x001a, B:7:0x005f, B:10:0x0066, B:13:0x0072, B:16:0x0082, B:20:0x00ce, B:22:0x0131, B:23:0x0144, B:25:0x014a, B:27:0x0177, B:28:0x018d, B:31:0x0197, B:33:0x019d, B:35:0x01a1, B:38:0x01a8, B:41:0x01af, B:42:0x01b1, B:44:0x01ba, B:46:0x01be, B:49:0x01c5, B:51:0x01cd, B:53:0x01d3, B:57:0x01e8, B:60:0x01f0, B:62:0x01fa, B:64:0x0200, B:68:0x0218, B:70:0x0249, B:72:0x0256, B:75:0x025f, B:82:0x0279, B:84:0x027f, B:87:0x0290, B:89:0x0296, B:92:0x02a0, B:94:0x02af, B:95:0x02b3, B:97:0x02bc, B:98:0x02c2, B:100:0x02d2, B:102:0x02d8, B:105:0x02df, B:107:0x02ee, B:110:0x02f5, B:112:0x0305, B:114:0x030e, B:118:0x0318, B:121:0x0324, B:123:0x032c, B:125:0x0335, B:127:0x033d, B:129:0x0346, B:131:0x034e, B:133:0x0356, B:135:0x035e, B:137:0x0366, B:139:0x036e, B:141:0x0376, B:143:0x037e, B:145:0x0386, B:147:0x038e, B:149:0x0396, B:151:0x039e, B:153:0x03a7, B:155:0x03af, B:157:0x03b7, B:159:0x03bf, B:161:0x03c8, B:183:0x03d1, B:185:0x03d9, B:187:0x03e5, B:189:0x03ee, B:191:0x03f6, B:193:0x03fe, B:195:0x0406, B:197:0x040e, B:199:0x0417, B:201:0x041f, B:203:0x0428, B:205:0x0430, B:207:0x0439, B:209:0x0442, B:211:0x044a, B:213:0x0453, B:215:0x045b, B:217:0x0463, B:219:0x046b, B:221:0x0474, B:242:0x047e, B:244:0x0484, B:247:0x0491, B:249:0x0497, B:251:0x04a3, B:253:0x04ab, B:258:0x04b5, B:260:0x04bb, B:262:0x04c7, B:264:0x04d0, B:266:0x04d9, B:268:0x04e1, B:270:0x04e9, B:272:0x04f1, B:274:0x04fa, B:276:0x0503, B:278:0x050c, B:280:0x0515, B:282:0x051e, B:284:0x0527, B:286:0x052f, B:288:0x0537, B:305:0x0540, B:307:0x0546, B:310:0x0557, B:312:0x055d, B:314:0x0565, B:316:0x056d, B:318:0x0575, B:321:0x0583, B:322:0x058b, B:325:0x059a, B:327:0x05a0, B:329:0x05ac, B:333:0x0618, B:335:0x061e, B:337:0x0634, B:339:0x063c, B:342:0x065b, B:345:0x0672, B:347:0x06b8, B:350:0x06c1, B:352:0x06c9, B:354:0x06d1, B:356:0x06d9, B:358:0x06e1, B:362:0x06eb, B:365:0x0702, B:367:0x070a, B:369:0x0710, B:371:0x0718, B:375:0x0750, B:377:0x0758, B:379:0x0760, B:381:0x0768, B:383:0x0770, B:385:0x0778, B:387:0x07da, B:390:0x07e1, B:392:0x07e7, B:394:0x07f4, B:396:0x0814, B:398:0x081e, B:402:0x0829, B:404:0x0837, B:407:0x0856, B:410:0x085e, B:412:0x0876, B:414:0x0889, B:415:0x08c5, B:417:0x08f2, B:418:0x093f, B:420:0x0934, B:421:0x093a, B:422:0x0942, B:424:0x0780, B:426:0x0786, B:430:0x079b, B:432:0x07b1, B:434:0x07bd, B:437:0x07ca, B:438:0x0726, B:441:0x0738, B:446:0x0745, B:451:0x02c6, B:460:0x00a5, B:462:0x00b4), top: B:2:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:428:0x0797  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0296 A[Catch: Exception -> 0x00a1, TRY_LEAVE, TryCatch #1 {Exception -> 0x00a1, blocks: (B:3:0x001a, B:7:0x005f, B:10:0x0066, B:13:0x0072, B:16:0x0082, B:20:0x00ce, B:22:0x0131, B:23:0x0144, B:25:0x014a, B:27:0x0177, B:28:0x018d, B:31:0x0197, B:33:0x019d, B:35:0x01a1, B:38:0x01a8, B:41:0x01af, B:42:0x01b1, B:44:0x01ba, B:46:0x01be, B:49:0x01c5, B:51:0x01cd, B:53:0x01d3, B:57:0x01e8, B:60:0x01f0, B:62:0x01fa, B:64:0x0200, B:68:0x0218, B:70:0x0249, B:72:0x0256, B:75:0x025f, B:82:0x0279, B:84:0x027f, B:87:0x0290, B:89:0x0296, B:92:0x02a0, B:94:0x02af, B:95:0x02b3, B:97:0x02bc, B:98:0x02c2, B:100:0x02d2, B:102:0x02d8, B:105:0x02df, B:107:0x02ee, B:110:0x02f5, B:112:0x0305, B:114:0x030e, B:118:0x0318, B:121:0x0324, B:123:0x032c, B:125:0x0335, B:127:0x033d, B:129:0x0346, B:131:0x034e, B:133:0x0356, B:135:0x035e, B:137:0x0366, B:139:0x036e, B:141:0x0376, B:143:0x037e, B:145:0x0386, B:147:0x038e, B:149:0x0396, B:151:0x039e, B:153:0x03a7, B:155:0x03af, B:157:0x03b7, B:159:0x03bf, B:161:0x03c8, B:183:0x03d1, B:185:0x03d9, B:187:0x03e5, B:189:0x03ee, B:191:0x03f6, B:193:0x03fe, B:195:0x0406, B:197:0x040e, B:199:0x0417, B:201:0x041f, B:203:0x0428, B:205:0x0430, B:207:0x0439, B:209:0x0442, B:211:0x044a, B:213:0x0453, B:215:0x045b, B:217:0x0463, B:219:0x046b, B:221:0x0474, B:242:0x047e, B:244:0x0484, B:247:0x0491, B:249:0x0497, B:251:0x04a3, B:253:0x04ab, B:258:0x04b5, B:260:0x04bb, B:262:0x04c7, B:264:0x04d0, B:266:0x04d9, B:268:0x04e1, B:270:0x04e9, B:272:0x04f1, B:274:0x04fa, B:276:0x0503, B:278:0x050c, B:280:0x0515, B:282:0x051e, B:284:0x0527, B:286:0x052f, B:288:0x0537, B:305:0x0540, B:307:0x0546, B:310:0x0557, B:312:0x055d, B:314:0x0565, B:316:0x056d, B:318:0x0575, B:321:0x0583, B:322:0x058b, B:325:0x059a, B:327:0x05a0, B:329:0x05ac, B:333:0x0618, B:335:0x061e, B:337:0x0634, B:339:0x063c, B:342:0x065b, B:345:0x0672, B:347:0x06b8, B:350:0x06c1, B:352:0x06c9, B:354:0x06d1, B:356:0x06d9, B:358:0x06e1, B:362:0x06eb, B:365:0x0702, B:367:0x070a, B:369:0x0710, B:371:0x0718, B:375:0x0750, B:377:0x0758, B:379:0x0760, B:381:0x0768, B:383:0x0770, B:385:0x0778, B:387:0x07da, B:390:0x07e1, B:392:0x07e7, B:394:0x07f4, B:396:0x0814, B:398:0x081e, B:402:0x0829, B:404:0x0837, B:407:0x0856, B:410:0x085e, B:412:0x0876, B:414:0x0889, B:415:0x08c5, B:417:0x08f2, B:418:0x093f, B:420:0x0934, B:421:0x093a, B:422:0x0942, B:424:0x0780, B:426:0x0786, B:430:0x079b, B:432:0x07b1, B:434:0x07bd, B:437:0x07ca, B:438:0x0726, B:441:0x0738, B:446:0x0745, B:451:0x02c6, B:460:0x00a5, B:462:0x00b4), top: B:2:0x001a }] */
    /* JADX WARN: Type inference failed for: r12v29, types: [java.lang.CharSequence, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v33, types: [java.lang.CharSequence, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v37, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r12v38, types: [java.lang.CharSequence] */
    @Override // android.service.notification.NotificationListenerService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onNotificationPosted(@OXOo.OOXIXo android.service.notification.StatusBarNotification r40) {
        /*
            Method dump skipped, instructions count: 2423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ble.MyNotificationListenerService.onNotificationPosted(android.service.notification.StatusBarNotification):void");
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(@oOoXoXO StatusBarNotification statusBarNotification) {
    }

    public final boolean oxoX(String str, String str2) {
        int hashCode;
        if (str != null && ((hashCode = str.hashCode()) == 714499313 ? str.equals("com.facebook.katana") : !(hashCode == 1659293491 ? !str.equals(BleNotification.GIF_MAKER) : !(hashCode == 2094270320 && str.equals(BleNotification.SNAPCHAT))))) {
            return false;
        }
        return IIX0o.Oxx0IOOO(this.f20320IIXOooo.get(str), str2);
    }
}
