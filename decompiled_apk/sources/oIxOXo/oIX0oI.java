package oIxOXo;

import OoOoXO0.xoXoI;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.TextUtils;
import oX0O.xoIox;
import org.json.JSONException;
import org.json.JSONObject;
import skin.support.exception.SkinCompatException;

/* loaded from: classes6.dex */
public final class oIX0oI {

    /* renamed from: oO, reason: collision with root package name */
    public static final String f31794oO = "ColorState";

    /* renamed from: I0Io, reason: collision with root package name */
    public String f31795I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f31796II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f31797II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public String f31798OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f31799Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f31800X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public String f31801XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f31802oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public String f31803oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public String f31804ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public String f31805oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public String f31806x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public String f31807xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String f31808xxIXOIIO;

    /* renamed from: oIxOXo.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1126oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public String f31809I0Io;

        /* renamed from: II0XooXoX, reason: collision with root package name */
        public String f31810II0XooXoX;

        /* renamed from: II0xO0, reason: collision with root package name */
        public String f31811II0xO0;

        /* renamed from: OOXIXo, reason: collision with root package name */
        public String f31812OOXIXo;

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        public String f31813Oxx0IOOO;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public String f31814X0o0xo;

        /* renamed from: XO, reason: collision with root package name */
        public String f31815XO;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public String f31816oIX0oI;

        /* renamed from: oOoXoXO, reason: collision with root package name */
        public String f31817oOoXoXO;

        /* renamed from: oxoX, reason: collision with root package name */
        public String f31818oxoX;

        /* renamed from: xoIox, reason: collision with root package name */
        public String f31819xoIox;

        /* renamed from: xxIXOIIO, reason: collision with root package name */
        public String f31820xxIXOIIO;

        public C1126oIX0oI() {
        }

        public C1126oIX0oI I0Io(String str) {
            if (oIX0oI.oIX0oI("colorAccelerated", str)) {
                this.f31810II0XooXoX = str;
            }
            return this;
        }

        public C1126oIX0oI II0XooXoX(Context context, @IXo.oxoX int i) {
            this.f31817oOoXoXO = context.getResources().getResourceEntryName(i);
            return this;
        }

        public C1126oIX0oI II0xO0(Context context, @IXo.oxoX int i) {
            this.f31810II0XooXoX = context.getResources().getResourceEntryName(i);
            return this;
        }

        public C1126oIX0oI IIXOooo(Context context, @IXo.oxoX int i) {
            this.f31811II0xO0 = context.getResources().getResourceEntryName(i);
            return this;
        }

        public C1126oIX0oI IXxxXO(Context context, @IXo.oxoX int i) {
            this.f31820xxIXOIIO = context.getResources().getResourceEntryName(i);
            return this;
        }

        public C1126oIX0oI OOXIXo(String str) {
            if (oIX0oI.oIX0oI("colorDragCanAccept", str)) {
                this.f31819xoIox = str;
            }
            return this;
        }

        public C1126oIX0oI Oo(String str) {
            if (oIX0oI.oIX0oI("colorFocused", str)) {
                this.f31809I0Io = str;
            }
            return this;
        }

        public C1126oIX0oI OxI(String str) {
            if (oIX0oI.oIX0oI("colorWindowFocused", str)) {
                this.f31816oIX0oI = str;
            }
            return this;
        }

        public C1126oIX0oI Oxx0IOOO(String str) {
            if (oIX0oI.oIX0oI("colorChecked", str)) {
                this.f31815XO = str;
            }
            return this;
        }

        public C1126oIX0oI Oxx0xo(String str) {
            if (oIX0oI.oIX0oI("colorHovered", str)) {
                this.f31820xxIXOIIO = str;
            }
            return this;
        }

        public C1126oIX0oI OxxIIOOXO(String str) {
            if (oIX0oI.oIX0oI("colorPressed", str)) {
                this.f31814X0o0xo = str;
            }
            return this;
        }

        public C1126oIX0oI X0o0xo(String str) {
            if (oIX0oI.oIX0oI("colorActivated", str)) {
                this.f31813Oxx0IOOO = str;
            }
            return this;
        }

        public C1126oIX0oI XO(Context context, @IXo.oxoX int i) {
            this.f31815XO = context.getResources().getResourceEntryName(i);
            return this;
        }

        public C1126oIX0oI o00(Context context, @IXo.oxoX int i) {
            this.f31816oIX0oI = context.getResources().getResourceEntryName(i);
            return this;
        }

        public C1126oIX0oI oI0IIXIo(Context context, @IXo.oxoX int i) {
            this.f31814X0o0xo = context.getResources().getResourceEntryName(i);
            return this;
        }

        public oIX0oI oIX0oI() {
            if (!TextUtils.isEmpty(this.f31817oOoXoXO)) {
                return new oIX0oI(this.f31816oIX0oI, this.f31811II0xO0, this.f31809I0Io, this.f31818oxoX, this.f31814X0o0xo, this.f31815XO, this.f31813Oxx0IOOO, this.f31810II0XooXoX, this.f31820xxIXOIIO, this.f31819xoIox, this.f31812OOXIXo, this.f31817oOoXoXO);
            }
            throw new SkinCompatException("Default color can not empty!");
        }

        public C1126oIX0oI oO(String str) {
            if (oIX0oI.oIX0oI("colorEnabled", str)) {
                this.f31818oxoX = str;
            }
            return this;
        }

        public C1126oIX0oI oOoXoXO(Context context, @IXo.oxoX int i) {
            this.f31812OOXIXo = context.getResources().getResourceEntryName(i);
            return this;
        }

        public C1126oIX0oI ooOOo0oXI(String str) {
            if (oIX0oI.oIX0oI("colorDragHovered", str)) {
                this.f31812OOXIXo = str;
            }
            return this;
        }

        public C1126oIX0oI oxoX(Context context, @IXo.oxoX int i) {
            this.f31813Oxx0IOOO = context.getResources().getResourceEntryName(i);
            return this;
        }

        public C1126oIX0oI x0XOIxOo(Context context, @IXo.oxoX int i) {
            this.f31818oxoX = context.getResources().getResourceEntryName(i);
            return this;
        }

        public C1126oIX0oI x0xO0oo(Context context, @IXo.oxoX int i) {
            this.f31809I0Io = context.getResources().getResourceEntryName(i);
            return this;
        }

        public C1126oIX0oI xoIox(Context context, @IXo.oxoX int i) {
            this.f31819xoIox = context.getResources().getResourceEntryName(i);
            return this;
        }

        public C1126oIX0oI xoXoI(String str) {
            if (oIX0oI.oIX0oI("colorSelected", str)) {
                this.f31811II0xO0 = str;
            }
            return this;
        }

        public C1126oIX0oI xxIXOIIO(String str) {
            if (oIX0oI.oIX0oI("colorDefault", str)) {
                this.f31817oOoXoXO = str;
            }
            return this;
        }

        public C1126oIX0oI(oIX0oI oix0oi) {
            this.f31816oIX0oI = oix0oi.f31795I0Io;
            this.f31811II0xO0 = oix0oi.f31805oxoX;
            this.f31809I0Io = oix0oi.f31800X0o0xo;
            this.f31818oxoX = oix0oi.f31801XO;
            this.f31814X0o0xo = oix0oi.f31799Oxx0IOOO;
            this.f31815XO = oix0oi.f31796II0XooXoX;
            this.f31813Oxx0IOOO = oix0oi.f31808xxIXOIIO;
            this.f31810II0XooXoX = oix0oi.f31807xoIox;
            this.f31820xxIXOIIO = oix0oi.f31798OOXIXo;
            this.f31819xoIox = oix0oi.f31803oOoXoXO;
            this.f31812OOXIXo = oix0oi.f31804ooOOo0oXI;
            this.f31817oOoXoXO = oix0oi.f31806x0XOIxOo;
        }
    }

    public oIX0oI(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.f31795I0Io = str;
        this.f31805oxoX = str2;
        this.f31800X0o0xo = str3;
        this.f31801XO = str4;
        this.f31799Oxx0IOOO = str5;
        this.f31796II0XooXoX = str6;
        this.f31808xxIXOIIO = str7;
        this.f31807xoIox = str8;
        this.f31798OOXIXo = str9;
        this.f31803oOoXoXO = str10;
        this.f31804ooOOo0oXI = str11;
        this.f31806x0XOIxOo = str12;
        boolean z = TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str7) && TextUtils.isEmpty(str8) && TextUtils.isEmpty(str9) && TextUtils.isEmpty(str10) && TextUtils.isEmpty(str11);
        this.f31802oIX0oI = z;
        if (z && !str12.startsWith(xoXoI.f2670oxoX)) {
            throw new SkinCompatException("Default color cannot be a reference, when only default color is available!");
        }
    }

    public static oIX0oI II0xO0(JSONObject jSONObject) {
        if (jSONObject.has("colorName") && jSONObject.has("colorDefault") && jSONObject.has("onlyDefaultColor")) {
            try {
                boolean z = jSONObject.getBoolean("onlyDefaultColor");
                String string = jSONObject.getString("colorName");
                String string2 = jSONObject.getString("colorDefault");
                if (z) {
                    return new oIX0oI(string, string2);
                }
                C1126oIX0oI c1126oIX0oI = new C1126oIX0oI();
                c1126oIX0oI.xxIXOIIO(string2);
                if (jSONObject.has("colorWindowFocused")) {
                    c1126oIX0oI.OxI(jSONObject.getString("colorWindowFocused"));
                }
                if (jSONObject.has("colorSelected")) {
                    c1126oIX0oI.xoXoI(jSONObject.getString("colorSelected"));
                }
                if (jSONObject.has("colorFocused")) {
                    c1126oIX0oI.Oo(jSONObject.getString("colorFocused"));
                }
                if (jSONObject.has("colorEnabled")) {
                    c1126oIX0oI.oO(jSONObject.getString("colorEnabled"));
                }
                if (jSONObject.has("colorPressed")) {
                    c1126oIX0oI.OxxIIOOXO(jSONObject.getString("colorPressed"));
                }
                if (jSONObject.has("colorChecked")) {
                    c1126oIX0oI.Oxx0IOOO(jSONObject.getString("colorChecked"));
                }
                if (jSONObject.has("colorActivated")) {
                    c1126oIX0oI.X0o0xo(jSONObject.getString("colorActivated"));
                }
                if (jSONObject.has("colorAccelerated")) {
                    c1126oIX0oI.I0Io(jSONObject.getString("colorAccelerated"));
                }
                if (jSONObject.has("colorHovered")) {
                    c1126oIX0oI.Oxx0xo(jSONObject.getString("colorHovered"));
                }
                if (jSONObject.has("colorDragCanAccept")) {
                    c1126oIX0oI.OOXIXo(jSONObject.getString("colorDragCanAccept"));
                }
                if (jSONObject.has("colorDragHovered")) {
                    c1126oIX0oI.ooOOo0oXI(jSONObject.getString("colorDragHovered"));
                }
                oIX0oI oIX0oI2 = c1126oIX0oI.oIX0oI();
                oIX0oI2.f31797II0xO0 = string;
                return oIX0oI2;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static JSONObject oI0IIXIo(oIX0oI oix0oi) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (oix0oi.f31802oIX0oI) {
            jSONObject.putOpt("colorName", oix0oi.f31797II0xO0).putOpt("colorDefault", oix0oi.f31806x0XOIxOo).putOpt("onlyDefaultColor", Boolean.valueOf(oix0oi.f31802oIX0oI));
        } else {
            jSONObject.putOpt("colorName", oix0oi.f31797II0xO0).putOpt("colorWindowFocused", oix0oi.f31795I0Io).putOpt("colorSelected", oix0oi.f31805oxoX).putOpt("colorFocused", oix0oi.f31800X0o0xo).putOpt("colorEnabled", oix0oi.f31801XO).putOpt("colorPressed", oix0oi.f31799Oxx0IOOO).putOpt("colorChecked", oix0oi.f31796II0XooXoX).putOpt("colorActivated", oix0oi.f31808xxIXOIIO).putOpt("colorAccelerated", oix0oi.f31807xoIox).putOpt("colorHovered", oix0oi.f31798OOXIXo).putOpt("colorDragCanAccept", oix0oi.f31803oOoXoXO).putOpt("colorDragHovered", oix0oi.f31804ooOOo0oXI).putOpt("colorDefault", oix0oi.f31806x0XOIxOo).putOpt("onlyDefaultColor", Boolean.valueOf(oix0oi.f31802oIX0oI));
        }
        return jSONObject;
    }

    public static boolean oIX0oI(String str, String str2) {
        boolean z;
        if (!TextUtils.isEmpty(str2) && (!str2.startsWith(xoXoI.f2670oxoX) || str2.length() == 7 || str2.length() == 9)) {
            z = true;
        } else {
            z = false;
        }
        if (xoIox.f32102oIX0oI && !z) {
            xoIox.II0xO0(f31794oO, "Invalid color -> " + str + ": " + str2);
        }
        return z;
    }

    public String I0Io() {
        return this.f31807xoIox;
    }

    public String II0XooXoX() {
        return this.f31804ooOOo0oXI;
    }

    public ColorStateList IXxxXO() {
        if (this.f31802oIX0oI) {
            return ColorStateList.valueOf(Color.parseColor(this.f31806x0XOIxOo));
        }
        return Oxx0xo();
    }

    public String OOXIXo() {
        return this.f31798OOXIXo;
    }

    public boolean Oo() {
        return this.f31802oIX0oI;
    }

    public String Oxx0IOOO() {
        return this.f31803oOoXoXO;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01cd A[Catch: Exception -> 0x01e0, TryCatch #0 {Exception -> 0x01e0, blocks: (B:25:0x01c1, B:27:0x01cd, B:28:0x01e2, B:30:0x01e8, B:32:0x01ff), top: B:24:0x01c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01e8 A[Catch: Exception -> 0x01e0, LOOP:0: B:29:0x01e6->B:30:0x01e8, LOOP_END, TryCatch #0 {Exception -> 0x01e0, blocks: (B:25:0x01c1, B:27:0x01cd, B:28:0x01e2, B:30:0x01e8, B:32:0x01ff), top: B:24:0x01c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0153 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.content.res.ColorStateList Oxx0xo() {
        /*
            Method dump skipped, instructions count: 556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: oIxOXo.oIX0oI.Oxx0xo():android.content.res.ColorStateList");
    }

    public String X0o0xo() {
        return this.f31796II0XooXoX;
    }

    public String XO() {
        return this.f31806x0XOIxOo;
    }

    public final String oO(String str) {
        if (str.startsWith(xoXoI.f2670oxoX)) {
            return str;
        }
        oIX0oI IXxxXO2 = XO.x0XOIxOo().IXxxXO(str);
        if (IXxxXO2 != null) {
            if (IXxxXO2.Oo()) {
                return IXxxXO2.f31806x0XOIxOo;
            }
            if (xoIox.f32102oIX0oI) {
                xoIox.II0xO0(f31794oO, str + " cannot reference " + IXxxXO2.f31797II0xO0);
                return null;
            }
            return null;
        }
        return null;
    }

    public String oOoXoXO() {
        return this.f31797II0xO0;
    }

    public String ooOOo0oXI() {
        return this.f31799Oxx0IOOO;
    }

    public String oxoX() {
        return this.f31808xxIXOIIO;
    }

    public String x0XOIxOo() {
        return this.f31805oxoX;
    }

    public String x0xO0oo() {
        return this.f31795I0Io;
    }

    public String xoIox() {
        return this.f31800X0o0xo;
    }

    public String xxIXOIIO() {
        return this.f31801XO;
    }

    public oIX0oI(String str, String str2) {
        this.f31797II0xO0 = str;
        this.f31806x0XOIxOo = str2;
        this.f31802oIX0oI = true;
        if (!str2.startsWith(xoXoI.f2670oxoX)) {
            throw new SkinCompatException("Default color cannot be a reference, when only default color is available!");
        }
    }
}
