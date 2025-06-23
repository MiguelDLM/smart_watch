package x00IOx;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.androidnetworking.common.Priority;
import com.baidu.mobads.sdk.internal.an;
import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.ui.me.O0X;
import com.sma.smartv3.util.TimePeriod;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.xoIox;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;
import kotlin.text.oxoX;
import org.json.JSONObject;

@XX({"SMAP\nZewaFitManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZewaFitManager.kt\ncom/sma/smartv3/biz/zewafit/ZewaFitManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,444:1\n1855#2,2:445\n1855#2,2:447\n1855#2,2:449\n1855#2,2:451\n1855#2,2:453\n1559#2:455\n1590#2,4:456\n1549#2:464\n1620#2,2:465\n1622#2:468\n74#3,4:460\n78#3:467\n80#3,2:469\n67#3,2:471\n*S KotlinDebug\n*F\n+ 1 ZewaFitManager.kt\ncom/sma/smartv3/biz/zewafit/ZewaFitManager\n*L\n251#1:445,2\n271#1:447,2\n292#1:449,2\n312#1:451,2\n331#1:453,2\n350#1:455\n350#1:456,4\n435#1:464\n435#1:465,2\n435#1:468\n435#1:460,4\n435#1:467\n435#1:469,2\n442#1:471,2\n*E\n"})
/* loaded from: classes12.dex */
public final class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public static final String f33824I0Io = "ZewaFitManager";

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public static final String f33825II0xO0 = "yyyy-MM-dd HH:mm:ss";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static boolean f33826X0o0xo = false;

    /* renamed from: XO, reason: collision with root package name */
    public static boolean f33827XO = false;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f33828oIX0oI = new oIX0oI();

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public static final String f33829oxoX = "YWN0aXZpdHl0cmFja2VyIHpld2EgZml0IHBybw==";

    /* renamed from: x00IOx.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C1144oIX0oI extends ThreadUtils.SimpleTask<Void> {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ TimePeriod f33830XO;

        public C1144oIX0oI(TimePeriod timePeriod) {
            this.f33830XO = timePeriod;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        @oOoXoXO
        public Void doInBackground() {
            try {
                oIX0oI oix0oi = oIX0oI.f33828oIX0oI;
                if (!oix0oi.Oxx0IOOO()) {
                    String IIOIX2 = OxI.IIOIX(BleCache.INSTANCE.getMBleAddress(), ":", "", false, 4, null);
                    ANRequest.PostRequestBuilder contentType = AndroidNetworking.post(oix0oi.XO()).setContentType(an.d);
                    byte[] bytes = ("{\"mac_address\":[\"" + IIOIX2 + "\"]}").getBytes(oxoX.f29581II0xO0);
                    IIX0o.oO(bytes, "getBytes(...)");
                    ANResponse executeForJSONObject = contentType.addByteBody(bytes).setTag((Object) "ZewaFitManager GET_STATUS").setPriority(Priority.LOW).build().executeForJSONObject();
                    OI0.oIX0oI oix0oi2 = OI0.oIX0oI.f1507oIX0oI;
                    oix0oi2.oIX0oI("ZewaFitManager GET_STATUS -> error:" + executeForJSONObject.getError() + ", result:" + executeForJSONObject.getResult());
                    Object result = executeForJSONObject.getResult();
                    if (result != null) {
                        IIX0o.ooOOo0oXI(result);
                        if (!new JSONObject(result.toString()).getJSONObject(IIOIX2).getBoolean("active_status")) {
                            oix0oi2.II0xO0("ZewaFitManager GET_STATUS -> " + IIOIX2 + " status is false, can not upload.");
                            oix0oi.oOoXoXO(false);
                            return null;
                        }
                    }
                    oix0oi.OOXIXo(true);
                }
                TimePeriod timePeriod = this.f33830XO;
                TimePeriod timePeriod2 = TimePeriod.HOUR;
                if (timePeriod == timePeriod2) {
                    if (oix0oi.II0XooXoX().isEmpty()) {
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("ZewaFitManager uploadToZewaFit -> only upload previous hour");
                        Calendar calendar = Calendar.getInstance();
                        IIX0o.oO(calendar, "getInstance(...)");
                        oix0oi.ooOOo0oXI(xoIox.o00(calendar, timePeriod2, -1));
                    } else {
                        String str = (String) CollectionsKt___CollectionsKt.O0O0Io00X(oix0oi.II0XooXoX());
                        String format = oix0oi.oxoX().format(new Date());
                        IIX0o.ooOOo0oXI(format);
                        int oOoXoXO2 = xoIox.oOoXoXO(str, format, "yyyy-MM-dd HH:mm:ss");
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("ZewaFitManager uploadToZewaFit -> lastDate=" + str + ", curDate=" + format + ", hours=" + oOoXoXO2);
                        if (oOoXoXO2 > 0) {
                            for (int i = 0; i < oOoXoXO2; i++) {
                                oIX0oI oix0oi3 = oIX0oI.f33828oIX0oI;
                                Calendar calendar2 = Calendar.getInstance();
                                IIX0o.oO(calendar2, "getInstance(...)");
                                oix0oi3.ooOOo0oXI(xoIox.o00(calendar2, TimePeriod.HOUR, i - oOoXoXO2));
                            }
                        }
                    }
                } else if (oix0oi.II0XooXoX().isEmpty()) {
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI("ZewaFitManager uploadToZewaFit -> only upload previous day");
                    Calendar calendar3 = Calendar.getInstance();
                    IIX0o.oO(calendar3, "getInstance(...)");
                    oix0oi.ooOOo0oXI(xoIox.o00(calendar3, TimePeriod.DAY, -1));
                } else {
                    String str2 = (String) CollectionsKt___CollectionsKt.O0O0Io00X(oix0oi.II0XooXoX());
                    String format2 = oix0oi.oxoX().format(new Date());
                    IIX0o.ooOOo0oXI(format2);
                    int OOXIXo2 = xoIox.OOXIXo(str2, format2, "yyyy-MM-dd HH:mm:ss");
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI("ZewaFitManager uploadToZewaFit -> lastDate=" + str2 + ", curDate=" + format2 + ", days=" + OOXIXo2);
                    if (OOXIXo2 > 0) {
                        for (int i2 = 0; i2 < OOXIXo2; i2++) {
                            oIX0oI oix0oi4 = oIX0oI.f33828oIX0oI;
                            Calendar calendar4 = Calendar.getInstance();
                            IIX0o.oO(calendar4, "getInstance(...)");
                            oix0oi4.ooOOo0oXI(xoIox.o00(calendar4, TimePeriod.DAY, i2 - OOXIXo2));
                        }
                    }
                }
            } catch (Exception e) {
                oIX0oI.f33828oIX0oI.oOoXoXO(false);
                e.printStackTrace();
            }
            oIX0oI.f33828oIX0oI.oOoXoXO(false);
            return null;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(@oOoXoXO Void r1) {
        }
    }

    public final boolean I0Io() {
        if (f33826X0o0xo) {
            OI0.oIX0oI.f1507oIX0oI.II0xO0("ZewaFitManager canUpload -> isUploading,  can not upload");
            return false;
        }
        if (!Xo0.f24349oIX0oI.XO().getBoolean(XoI0Ixx0.f24474x0xO, false)) {
            OI0.oIX0oI.f1507oIX0oI.II0xO0("ZewaFitManager canUpload -> User is not allowed to upload data");
            return false;
        }
        if (!BleConnector.INSTANCE.isBound()) {
            OI0.oIX0oI.f1507oIX0oI.II0xO0("ZewaFitManager canUpload -> User is Not bound");
            return false;
        }
        return true;
    }

    @OOXIXo
    public final List<String> II0XooXoX() {
        try {
            byte[] base64Decode = EncodeUtils.base64Decode(Xo0.f24349oIX0oI.oIX0oI().getString(XoI0Ixx0.f24390OO0x0xX));
            IIX0o.oO(base64Decode, "base64Decode(...)");
            JsonArray asJsonArray = JsonParser.parseString(new String(base64Decode, oxoX.f29581II0xO0)).getAsJsonArray();
            IIX0o.ooOOo0oXI(asJsonArray);
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                arrayList.add(new Gson().fromJson(it.next(), String.class));
            }
            return arrayList;
        } catch (Exception unused) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
    }

    public final void II0xO0(@OOXIXo String date) {
        IIX0o.x0xO0oo(date, "date");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(II0XooXoX());
        arrayList.add(date);
        SPUtils oIX0oI2 = Xo0.f24349oIX0oI.oIX0oI();
        String json = new Gson().toJson(arrayList);
        IIX0o.oO(json, "toJson(...)");
        byte[] bytes = json.getBytes(oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        oIX0oI2.put(XoI0Ixx0.f24390OO0x0xX, EncodeUtils.base64Encode2String(bytes));
    }

    public final void OOXIXo(boolean z) {
        f33827XO = z;
    }

    public final boolean Oxx0IOOO() {
        return f33827XO;
    }

    public final String X0o0xo() {
        if (xxIXOIIO()) {
            return "https://dev.smartdevices.health/telemetry/activity-tracker";
        }
        return "https://api.smartdevices.health/telemetry/activity-tracker";
    }

    public final String XO() {
        if (xxIXOIIO()) {
            return "https://zewadev.smartdevices.health/api/v1/device/get-status/";
        }
        return "https://portal.smartdevices.health/api/v1/device/get-status/";
    }

    public final void oOoXoXO(boolean z) {
        f33826X0o0xo = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0579 A[Catch: Exception -> 0x0185, TryCatch #0 {Exception -> 0x0185, blocks: (B:7:0x008a, B:9:0x014b, B:10:0x0155, B:12:0x015b, B:14:0x0167, B:15:0x016a, B:17:0x0172, B:18:0x0175, B:20:0x017d, B:25:0x0188, B:26:0x01a0, B:28:0x01d8, B:29:0x01f1, B:31:0x01f7, B:33:0x0203, B:34:0x0207, B:38:0x020f, B:44:0x0214, B:45:0x0223, B:47:0x025b, B:48:0x0278, B:50:0x027e, B:52:0x028a, B:53:0x028e, B:57:0x0296, B:63:0x029b, B:64:0x02ae, B:66:0x02e6, B:67:0x02ff, B:69:0x0305, B:71:0x0311, B:72:0x0315, B:76:0x031d, B:82:0x0322, B:83:0x0331, B:85:0x0369, B:86:0x0382, B:88:0x0388, B:90:0x0394, B:91:0x0398, B:95:0x03a0, B:101:0x03a5, B:102:0x03b4, B:104:0x03ec, B:105:0x0405, B:107:0x040b, B:109:0x0417, B:110:0x041b, B:114:0x0423, B:120:0x0428, B:121:0x0437, B:123:0x04b5, B:124:0x04d1, B:126:0x04d7, B:128:0x04df, B:129:0x04e2, B:131:0x04ec, B:133:0x04f1, B:136:0x0510, B:140:0x0546, B:141:0x054f, B:143:0x0579, B:145:0x0593, B:147:0x0626, B:149:0x063c, B:150:0x067a, B:153:0x054b), top: B:6:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0593 A[Catch: Exception -> 0x0185, TryCatch #0 {Exception -> 0x0185, blocks: (B:7:0x008a, B:9:0x014b, B:10:0x0155, B:12:0x015b, B:14:0x0167, B:15:0x016a, B:17:0x0172, B:18:0x0175, B:20:0x017d, B:25:0x0188, B:26:0x01a0, B:28:0x01d8, B:29:0x01f1, B:31:0x01f7, B:33:0x0203, B:34:0x0207, B:38:0x020f, B:44:0x0214, B:45:0x0223, B:47:0x025b, B:48:0x0278, B:50:0x027e, B:52:0x028a, B:53:0x028e, B:57:0x0296, B:63:0x029b, B:64:0x02ae, B:66:0x02e6, B:67:0x02ff, B:69:0x0305, B:71:0x0311, B:72:0x0315, B:76:0x031d, B:82:0x0322, B:83:0x0331, B:85:0x0369, B:86:0x0382, B:88:0x0388, B:90:0x0394, B:91:0x0398, B:95:0x03a0, B:101:0x03a5, B:102:0x03b4, B:104:0x03ec, B:105:0x0405, B:107:0x040b, B:109:0x0417, B:110:0x041b, B:114:0x0423, B:120:0x0428, B:121:0x0437, B:123:0x04b5, B:124:0x04d1, B:126:0x04d7, B:128:0x04df, B:129:0x04e2, B:131:0x04ec, B:133:0x04f1, B:136:0x0510, B:140:0x0546, B:141:0x054f, B:143:0x0579, B:145:0x0593, B:147:0x0626, B:149:0x063c, B:150:0x067a, B:153:0x054b), top: B:6:0x008a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ooOOo0oXI(@OXOo.OOXIXo long[] r42) {
        /*
            Method dump skipped, instructions count: 1693
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x00IOx.oIX0oI.ooOOo0oXI(long[]):void");
    }

    @OOXIXo
    public final SimpleDateFormat oxoX() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    }

    public final void x0XOIxOo(@OOXIXo Context context) {
        boolean z;
        IIX0o.x0xO0oo(context, "context");
        Xo0 xo0 = Xo0.f24349oIX0oI;
        if (!xo0.XO().contains(XoI0Ixx0.f24417XIo0oOXIx)) {
            String str = xoIox.Oxx0IOOO().format(new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L))) + " 00:00:00";
            xo0.XO().put(XoI0Ixx0.f24417XIo0oOXIx, str);
            if (II0XooXoX().isEmpty()) {
                II0xO0(str);
            }
        }
        Api api = Api.INSTANCE;
        if (!IIX0o.Oxx0IOOO(api.getBASE_URL(), O0X.f23385II0xO0) && !IIX0o.Oxx0IOOO(api.getBASE_URL(), O0X.f23389oIX0oI)) {
            z = false;
        } else {
            z = true;
        }
        TimePeriod timePeriod = TimePeriod.DAY;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("ZewaFitManager firstUploadDate -> " + xo0.XO().getString(XoI0Ixx0.f24417XIo0oOXIx) + ", isTest -> " + z + ", timePeriod -> " + timePeriod + ", serverStatus -> " + f33827XO);
        if (!I0Io()) {
            return;
        }
        f33826X0o0xo = true;
        ThreadUtils.executeBySingle(new C1144oIX0oI(timePeriod));
    }

    public final boolean xoIox() {
        return f33826X0o0xo;
    }

    public final boolean xxIXOIIO() {
        return false;
    }
}
