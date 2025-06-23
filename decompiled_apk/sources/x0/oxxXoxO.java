package x0;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.provider.CalendarContract;
import androidx.core.app.NotificationCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import com.huawei.openalliance.ad.constant.x;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class oxxXoxO {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static boolean f33767OOXIXo = false;

    /* renamed from: Oo, reason: collision with root package name */
    public static SimpleDateFormat f33768Oo = null;

    /* renamed from: oO, reason: collision with root package name */
    public static final String f33769oO = "yearly";

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f33770oOoXoXO = "daily";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final String f33771ooOOo0oXI = "weekly";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final String f33772x0XOIxOo = "monthly";

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static SimpleDateFormat f33773x0xO0oo;

    /* renamed from: I0Io, reason: collision with root package name */
    public String f33774I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f33775II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f33776II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f33777Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f33778X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public String f33779XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f33780oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public String f33781oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public XoX f33782xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String f33783xxIXOIIO;

    static {
        Locale locale = Locale.US;
        f33773x0xO0oo = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", locale);
        f33768Oo = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZZZZZ", locale);
    }

    public static oxxXoxO oIX0oI(String str) {
        oxxXoxO oxxxoxo = new oxxXoxO();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("id")) {
                oxxxoxo.x0xO0oo(jSONObject.getString("id"));
            }
            if (!jSONObject.isNull("description")) {
                oxxxoxo.x0XOIxOo(jSONObject.getString("description"));
            }
            if (!jSONObject.isNull("location")) {
                oxxxoxo.Oo(jSONObject.getString("location"));
            }
            if (!jSONObject.isNull("summary")) {
                oxxxoxo.IIXOooo(jSONObject.getString("summary"));
            }
            if (!jSONObject.isNull("start")) {
                oxxxoxo.oI0IIXIo(jSONObject.getString("start"));
            }
            if (!jSONObject.isNull("end")) {
                if (jSONObject.isNull("start")) {
                    oxxxoxo.oI0IIXIo(jSONObject.getString("end"));
                }
                oxxxoxo.oO(jSONObject.getString("end"));
            }
            if (!jSONObject.isNull("status")) {
                oxxxoxo.OxxIIOOXO(jSONObject.getString("status"));
            }
            if (!jSONObject.isNull("freebusy")) {
                oxxxoxo.xoXoI(jSONObject.getString("freebusy"));
            }
            if (!jSONObject.isNull(NotificationCompat.CATEGORY_REMINDER)) {
                oxxxoxo.Oxx0xo(jSONObject.getString(NotificationCompat.CATEGORY_REMINDER));
            }
            if (!jSONObject.isNull("recurrence")) {
                oxxxoxo.IXxxXO(new XoX());
                JSONObject jSONObject2 = jSONObject.getJSONObject("recurrence");
                if (!jSONObject2.isNull("frequency")) {
                    oxxxoxo.Oxx0IOOO().x0xO0oo(jSONObject2.getString("frequency"));
                }
                if (!jSONObject2.isNull("interval")) {
                    oxxxoxo.Oxx0IOOO().Oo(jSONObject2.getInt("interval"));
                }
                if (!jSONObject2.isNull(ClientCookie.EXPIRES_ATTR)) {
                    oxxxoxo.Oxx0IOOO().oO(jSONObject2.getString(ClientCookie.EXPIRES_ATTR));
                }
                if (!jSONObject2.isNull("exceptionDates")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("exceptionDates");
                    int length = jSONArray.length();
                    oxxxoxo.Oxx0IOOO().x0XOIxOo(new String[length]);
                    for (int i = 0; i < length; i++) {
                        oxxxoxo.Oxx0IOOO().X0o0xo()[i] = jSONArray.getString(i);
                    }
                }
                if (!jSONObject2.isNull("daysInWeek")) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("daysInWeek");
                    int length2 = jSONArray2.length();
                    oxxxoxo.Oxx0IOOO().oOoXoXO(new int[length2]);
                    for (int i2 = 0; i2 < length2; i2++) {
                        oxxxoxo.Oxx0IOOO().I0Io()[i2] = jSONArray2.getInt(i2);
                    }
                }
                if (!jSONObject2.isNull("daysInMonth")) {
                    JSONArray jSONArray3 = jSONObject2.getJSONArray("daysInMonth");
                    int length3 = jSONArray3.length();
                    oxxxoxo.Oxx0IOOO().OOXIXo(new int[length3]);
                    for (int i3 = 0; i3 < length3; i3++) {
                        oxxxoxo.Oxx0IOOO().II0xO0()[i3] = jSONArray3.getInt(i3);
                    }
                }
                if (!jSONObject2.isNull("daysInYear")) {
                    JSONArray jSONArray4 = jSONObject2.getJSONArray("daysInYear");
                    int length4 = jSONArray4.length();
                    oxxxoxo.Oxx0IOOO().ooOOo0oXI(new int[length4]);
                    for (int i4 = 0; i4 < length4; i4++) {
                        oxxxoxo.Oxx0IOOO().oxoX()[i4] = jSONArray4.getInt(i4);
                    }
                }
                if (!jSONObject2.isNull("weeksInMonth")) {
                    JSONArray jSONArray5 = jSONObject2.getJSONArray("weeksInMonth");
                    int length5 = jSONArray5.length();
                    oxxxoxo.Oxx0IOOO().Oxx0xo(new int[length5]);
                    for (int i5 = 0; i5 < length5; i5++) {
                        oxxxoxo.Oxx0IOOO().xoIox()[i5] = jSONArray5.getInt(i5);
                    }
                }
                if (!jSONObject2.isNull("monthsInYear")) {
                    JSONArray jSONArray6 = jSONObject2.getJSONArray("monthsInYear");
                    int length6 = jSONArray6.length();
                    oxxxoxo.Oxx0IOOO().IXxxXO(new int[length6]);
                    for (int i6 = 0; i6 < length6; i6++) {
                        oxxxoxo.Oxx0IOOO().xxIXOIIO()[i6] = jSONArray6.getInt(i6);
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return oxxxoxo;
    }

    public String I0Io() {
        return this.f33779XO;
    }

    public String II0XooXoX() {
        return this.f33783xxIXOIIO;
    }

    public String II0xO0() {
        return this.f33776II0xO0;
    }

    public void IIXOooo(String str) {
        this.f33781oxoX = str;
    }

    public void IXxxXO(XoX xoX2) {
        this.f33782xoIox = xoX2;
    }

    public String OOXIXo() {
        return this.f33781oxoX;
    }

    public void Oo(String str) {
        this.f33774I0Io = str;
    }

    public XoX Oxx0IOOO() {
        return this.f33782xoIox;
    }

    public void Oxx0xo(String str) {
        this.f33783xxIXOIIO = str;
    }

    public void OxxIIOOXO(String str) {
        this.f33777Oxx0IOOO = str;
    }

    @SuppressLint({"NewApi", "InlinedApi"})
    public Intent X0o0xo() {
        Intent type;
        boolean z = f33767OOXIXo;
        if (!z) {
            type = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        } else {
            type = new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event");
        }
        if (!x0o.II0XooXoX(II0xO0())) {
            if (!z) {
                type.putExtra("title", II0xO0());
            } else {
                type.putExtra("title", II0xO0());
            }
        }
        if (!x0o.II0XooXoX(XO())) {
            if (!z) {
                type.putExtra("eventLocation", XO());
            } else {
                type.putExtra("eventLocation", XO());
            }
        }
        if (!x0o.II0XooXoX(OOXIXo())) {
            if (!z) {
                type.putExtra("description", OOXIXo());
            } else {
                type.putExtra("description", OOXIXo());
            }
        }
        if (!x0o.II0XooXoX(xxIXOIIO())) {
            long ooOOo0oXI2 = ooOOo0oXI(xxIXOIIO());
            if (ooOOo0oXI2 > 0) {
                if (!z) {
                    type.putExtra("beginTime", ooOOo0oXI2);
                } else {
                    type.putExtra("beginTime", ooOOo0oXI2);
                }
            }
        }
        if (!x0o.II0XooXoX(I0Io())) {
            long ooOOo0oXI3 = ooOOo0oXI(I0Io());
            if (ooOOo0oXI3 > 0) {
                if (!z) {
                    type.putExtra("endTime", ooOOo0oXI3);
                } else {
                    type.putExtra("endTime", ooOOo0oXI3);
                }
            }
        }
        if (!x0o.II0XooXoX(xoIox()) && !z) {
            type.putExtra("eventStatus", xoIox());
        }
        if (!x0o.II0XooXoX(oOoXoXO()) && !z) {
            type.putExtra(MapBundleKey.MapObjKey.OBJ_SL_VISI, !oOoXoXO().equals("opaque"));
        }
        if (!x0o.II0XooXoX(II0XooXoX())) {
            long ooOOo0oXI4 = ooOOo0oXI(II0XooXoX());
            if (ooOOo0oXI4 < 0) {
                if (!z) {
                    type.putExtra("minutes", Math.abs(ooOOo0oXI4 / 60000));
                }
            } else if (!x0o.II0XooXoX(xxIXOIIO()) && !z) {
                long ooOOo0oXI5 = ooOOo0oXI(xxIXOIIO());
                if (ooOOo0oXI5 > 0) {
                    type.putExtra("minutes", Math.abs((ooOOo0oXI5 - ooOOo0oXI4) / 60000));
                }
            }
        }
        String str = "";
        StringBuilder sb = new StringBuilder("");
        if (Oxx0IOOO() != null) {
            String Oxx0IOOO2 = Oxx0IOOO().Oxx0IOOO();
            if (!x0o.II0XooXoX(Oxx0IOOO2)) {
                if (f33770oOoXoXO.equals(Oxx0IOOO2)) {
                    sb.append("FREQ=DAILY;");
                } else if (f33771ooOOo0oXI.equals(Oxx0IOOO2)) {
                    sb.append("FREQ=WEEKLY;");
                } else if (f33772x0XOIxOo.equals(Oxx0IOOO2)) {
                    sb.append("FREQ=MONTHLY;");
                } else if (f33769oO.equals(Oxx0IOOO2)) {
                    sb.append("FREQ=YEARLY;");
                }
                str = Oxx0IOOO2;
            }
            if (Oxx0IOOO().II0XooXoX() > 0) {
                sb.append("INTERVAL=");
                sb.append(Oxx0IOOO().II0XooXoX());
                sb.append(x.aL);
            }
            if (f33771ooOOo0oXI.equals(str) && Oxx0IOOO().I0Io() != null && Oxx0IOOO().I0Io().length > 0) {
                sb.append("BYDAY=");
                for (int i : Oxx0IOOO().I0Io()) {
                    switch (i) {
                        case 0:
                            sb.append("SU,");
                            break;
                        case 1:
                            sb.append("MO,");
                            break;
                        case 2:
                            sb.append("TU,");
                            break;
                        case 3:
                            sb.append("WE,");
                            break;
                        case 4:
                            sb.append("TH,");
                            break;
                        case 5:
                            sb.append("FR,");
                            break;
                        case 6:
                            sb.append("SA,");
                            break;
                    }
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if (f33772x0XOIxOo.equals(str) && Oxx0IOOO().II0xO0() != null && Oxx0IOOO().II0xO0().length > 0) {
                sb.append("BYMONTHDAY=");
                for (int i2 : Oxx0IOOO().II0xO0()) {
                    sb.append(i2);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if (f33769oO.equals(str) && Oxx0IOOO().oxoX() != null && Oxx0IOOO().oxoX().length > 0) {
                sb.append("BYYEARDAY=");
                for (int i3 : Oxx0IOOO().oxoX()) {
                    sb.append(i3);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if (f33769oO.equals(str) && Oxx0IOOO().xxIXOIIO() != null && Oxx0IOOO().xxIXOIIO().length > 0) {
                sb.append("BYMONTH=");
                for (int i4 : Oxx0IOOO().xxIXOIIO()) {
                    sb.append(i4);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if (f33772x0XOIxOo.equals(str) && Oxx0IOOO().xoIox() != null && Oxx0IOOO().xoIox().length > 0) {
                sb.append("BYWEEKNO=");
                for (int i5 : Oxx0IOOO().xoIox()) {
                    sb.append(i5);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if (!x0o.II0XooXoX(Oxx0IOOO().XO())) {
                sb.append("UNTIL=");
                sb.append(Oxx0IOOO().XO());
                sb.append(x.aL);
            }
            if (Oxx0IOOO().X0o0xo() != null && Oxx0IOOO().X0o0xo().length > 0) {
                sb.append("EXDATE=");
                for (String str2 : Oxx0IOOO().X0o0xo()) {
                    sb.append(str2);
                    sb.append(",");
                }
                sb.setCharAt(sb.length() - 1, ';');
            }
            if (!z) {
                type.putExtra("rrule", sb.toString());
            } else {
                type.putExtra("rrule", sb.toString());
            }
        }
        return type;
    }

    public String XO() {
        return this.f33774I0Io;
    }

    public void oI0IIXIo(String str) {
        this.f33778X0o0xo = str;
    }

    public void oO(String str) {
        this.f33779XO = str;
    }

    public String oOoXoXO() {
        return this.f33775II0XooXoX;
    }

    public final long ooOOo0oXI(String str) {
        try {
            try {
                try {
                    return f33773x0xO0oo.parse(str).getTime();
                } catch (ParseException unused) {
                    return Long.parseLong(str);
                }
            } catch (ParseException unused2) {
                return f33768Oo.parse(str).getTime();
            }
        } catch (NumberFormatException unused3) {
            return -1L;
        }
    }

    public String oxoX() {
        return this.f33780oIX0oI;
    }

    public void x0XOIxOo(String str) {
        this.f33776II0xO0 = str;
    }

    public void x0xO0oo(String str) {
        this.f33780oIX0oI = str;
    }

    public String xoIox() {
        return this.f33777Oxx0IOOO;
    }

    public void xoXoI(String str) {
        this.f33775II0XooXoX = str;
    }

    public String xxIXOIIO() {
        return this.f33778X0o0xo;
    }
}
