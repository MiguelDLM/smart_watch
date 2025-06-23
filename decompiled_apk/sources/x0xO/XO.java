package x0xO;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class XO {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f34062II0XooXoX = "responseData";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f34063Oxx0IOOO = "responseId";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f34064XO = "callbackId";

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f34065xoIox = "handlerName";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f34066xxIXOIIO = "data";

    /* renamed from: I0Io, reason: collision with root package name */
    public String f34067I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f34068II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f34069X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f34070oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public String f34071oxoX;

    public static List<XO> OOXIXo(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                XO xo2 = new XO();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String str6 = null;
                if (jSONObject.has(f34065xoIox)) {
                    str2 = jSONObject.getString(f34065xoIox);
                } else {
                    str2 = null;
                }
                xo2.II0XooXoX(str2);
                if (jSONObject.has(f34064XO)) {
                    str3 = jSONObject.getString(f34064XO);
                } else {
                    str3 = null;
                }
                xo2.XO(str3);
                if (jSONObject.has(f34062II0XooXoX)) {
                    str4 = jSONObject.getString(f34062II0XooXoX);
                } else {
                    str4 = null;
                }
                xo2.xxIXOIIO(str4);
                if (jSONObject.has(f34063Oxx0IOOO)) {
                    str5 = jSONObject.getString(f34063Oxx0IOOO);
                } else {
                    str5 = null;
                }
                xo2.xoIox(str5);
                if (jSONObject.has("data")) {
                    str6 = jSONObject.getString("data");
                }
                xo2.Oxx0IOOO(str6);
                arrayList.add(xo2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static XO ooOOo0oXI(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        XO xo2 = new XO();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str6 = null;
            if (jSONObject.has(f34065xoIox)) {
                str2 = jSONObject.getString(f34065xoIox);
            } else {
                str2 = null;
            }
            xo2.II0XooXoX(str2);
            if (jSONObject.has(f34064XO)) {
                str3 = jSONObject.getString(f34064XO);
            } else {
                str3 = null;
            }
            xo2.XO(str3);
            if (jSONObject.has(f34062II0XooXoX)) {
                str4 = jSONObject.getString(f34062II0XooXoX);
            } else {
                str4 = null;
            }
            xo2.xxIXOIIO(str4);
            if (jSONObject.has(f34063Oxx0IOOO)) {
                str5 = jSONObject.getString(f34063Oxx0IOOO);
            } else {
                str5 = null;
            }
            xo2.xoIox(str5);
            if (jSONObject.has("data")) {
                str6 = jSONObject.getString("data");
            }
            xo2.Oxx0IOOO(str6);
            return xo2;
        } catch (JSONException e) {
            e.printStackTrace();
            return xo2;
        }
    }

    public String I0Io() {
        return this.f34069X0o0xo;
    }

    public void II0XooXoX(String str) {
        this.f34069X0o0xo = str;
    }

    public String II0xO0() {
        return this.f34071oxoX;
    }

    public void Oxx0IOOO(String str) {
        this.f34071oxoX = str;
    }

    public String X0o0xo() {
        return this.f34068II0xO0;
    }

    public void XO(String str) {
        this.f34070oIX0oI = str;
    }

    public String oIX0oI() {
        return this.f34070oIX0oI;
    }

    public String oOoXoXO() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f34064XO, oIX0oI());
            jSONObject.put("data", II0xO0());
            jSONObject.put(f34065xoIox, I0Io());
            jSONObject.put(f34062II0XooXoX, oxoX());
            jSONObject.put(f34063Oxx0IOOO, X0o0xo());
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String oxoX() {
        return this.f34067I0Io;
    }

    public void xoIox(String str) {
        this.f34068II0xO0 = str;
    }

    public void xxIXOIIO(String str) {
        this.f34067I0Io = str;
    }
}
