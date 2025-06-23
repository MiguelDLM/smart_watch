package xIxooxXX;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import org.json.JSONObject;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class II0xO0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f34398II0XooXoX = 3;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f34399Oxx0IOOO = 2;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f34400XO = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static SharedPreferences f34401xxIXOIIO;

    /* renamed from: I0Io, reason: collision with root package name */
    public String f34402I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f34403II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f34405oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f34406oxoX = 1;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public long f34404X0o0xo = -1;

    public II0xO0(String str) {
        this.f34405oIX0oI = str;
    }

    public static synchronized void I0Io(String str, JSONObject jSONObject) {
        synchronized (II0xO0.class) {
            if (XxXX.X0o0xo.oIX0oI() == null) {
                xxIXOIIO.oOoXoXO("QQToken", "saveJsonPreference context null");
                return;
            }
            if (str != null && jSONObject != null) {
                try {
                    String string = jSONObject.getString("expires_in");
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put(com.tencent.connect.common.II0xO0.f26864ooXIXxIX, System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                        String str2 = Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(str), 2) + "_spkey";
                        String X0o0xo2 = XxXX.oxoX.X0o0xo(jSONObject.toString(), "4026aec5f46360286842041e8cd49856");
                        if (str2.length() > 6 && X0o0xo2 != null) {
                            oIX0oI().edit().putString(str2, X0o0xo2).commit();
                            xxIXOIIO.oOoXoXO("QQToken", "saveJsonPreference sucess");
                            return;
                        }
                        xxIXOIIO.oOoXoXO("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                        return;
                    }
                    xxIXOIIO.oOoXoXO("QQToken", "expires is null");
                    return;
                } catch (Exception e) {
                    xxIXOIIO.II0XooXoX("QQToken", "saveJsonPreference exception:" + e.toString());
                    return;
                }
            }
            xxIXOIIO.oOoXoXO("QQToken", "saveJsonPreference prefKey or jsonObject null");
        }
    }

    public static synchronized JSONObject II0xO0(String str) {
        String Oxx0IOOO2;
        synchronized (II0xO0.class) {
            if (XxXX.X0o0xo.oIX0oI() == null) {
                xxIXOIIO.oOoXoXO("QQToken", "loadJsonPreference context null");
                return null;
            }
            if (str == null) {
                xxIXOIIO.oOoXoXO("QQToken", "loadJsonPreference prefKey is null");
                return null;
            }
            String encodeToString = Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(str), 2);
            String str2 = encodeToString + "_spkey";
            String string = oIX0oI().getString(str2, null);
            if (string == null) {
                String string2 = oIX0oI().getString(encodeToString, null);
                if (string2 == null) {
                    xxIXOIIO.oOoXoXO("QQToken", "loadJsonPreference encoded value null");
                    return null;
                }
                Oxx0IOOO2 = XxXX.oxoX.oIX0oI(string2, "asdfghjk");
                if (!TextUtils.isEmpty(Oxx0IOOO2)) {
                    String X0o0xo2 = XxXX.oxoX.X0o0xo(Oxx0IOOO2, "4026aec5f46360286842041e8cd49856");
                    if (str2.length() > 6 && X0o0xo2 != null) {
                        oIX0oI().edit().putString(str2, X0o0xo2).commit();
                        oIX0oI().edit().remove(encodeToString).commit();
                        xxIXOIIO.oOoXoXO("QQToken", "loadJsonPreference convert old to new save sucess");
                    }
                }
            } else {
                Oxx0IOOO2 = XxXX.oxoX.Oxx0IOOO(string, "4026aec5f46360286842041e8cd49856");
            }
            try {
                JSONObject jSONObject = new JSONObject(Oxx0IOOO2);
                xxIXOIIO.oOoXoXO("QQToken", "loadJsonPreference sucess");
                return jSONObject;
            } catch (Exception e) {
                xxIXOIIO.oOoXoXO("QQToken", "loadJsonPreference decode " + e.toString());
                return null;
            }
        }
    }

    @TargetApi(11)
    public static synchronized SharedPreferences oIX0oI() {
        SharedPreferences sharedPreferences;
        synchronized (II0xO0.class) {
            try {
                if (f34401xxIXOIIO == null) {
                    f34401xxIXOIIO = XxXX.X0o0xo.oIX0oI().getSharedPreferences("token_info_file", 0);
                }
                sharedPreferences = f34401xxIXOIIO;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sharedPreferences;
    }

    public String II0XooXoX() {
        return this.f34402I0Io;
    }

    public JSONObject OOXIXo(String str) {
        try {
            return II0xO0(str);
        } catch (Exception e) {
            xxIXOIIO.oOoXoXO("QQToken", "login loadSession" + e.toString());
            return null;
        }
    }

    public void Oo(String str) {
        this.f34402I0Io = str;
    }

    public long Oxx0IOOO() {
        return this.f34404X0o0xo;
    }

    public String X0o0xo() {
        return this.f34405oIX0oI;
    }

    public int XO() {
        return this.f34406oxoX;
    }

    public void oO(String str) {
        this.f34405oIX0oI = str;
    }

    public void oOoXoXO(String str) {
        String encodeToString = Base64.encodeToString(com.tencent.open.utils.II0xO0.OI0(str), 2);
        oIX0oI().edit().remove(encodeToString + "_spkey").commit();
        oIX0oI().edit().remove(encodeToString).commit();
        xxIXOIIO.oOoXoXO("QQToken", "removeSession sucess");
    }

    public void ooOOo0oXI(JSONObject jSONObject) {
        try {
            I0Io(this.f34405oIX0oI, jSONObject);
        } catch (Exception e) {
            xxIXOIIO.oOoXoXO("QQToken", "login saveSession" + e.toString());
        }
    }

    public String oxoX() {
        return this.f34403II0xO0;
    }

    public void x0XOIxOo(String str, String str2) throws NumberFormatException {
        this.f34403II0xO0 = str;
        this.f34404X0o0xo = 0L;
        if (str2 != null) {
            this.f34404X0o0xo = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public void x0xO0oo(int i) {
        this.f34406oxoX = i;
    }

    public boolean xoIox() {
        if (this.f34403II0xO0 != null && System.currentTimeMillis() < this.f34404X0o0xo) {
            return true;
        }
        return false;
    }

    public String xxIXOIIO() {
        String II0XooXoX2 = II0XooXoX();
        try {
            if (TextUtils.isEmpty(II0XooXoX2)) {
                JSONObject OOXIXo2 = OOXIXo(this.f34405oIX0oI);
                if (OOXIXo2 != null) {
                    II0XooXoX2 = OOXIXo2.getString("openid");
                    if (!TextUtils.isEmpty(II0XooXoX2)) {
                        Oo(II0XooXoX2);
                    }
                }
                xxIXOIIO.oOoXoXO("QQToken", "getOpenId from Session openId = " + II0XooXoX2 + " appId = " + this.f34405oIX0oI);
            } else {
                xxIXOIIO.oOoXoXO("QQToken", "getOpenId from field openId = " + II0XooXoX2 + " appId = " + this.f34405oIX0oI);
            }
        } catch (Exception e) {
            xxIXOIIO.oOoXoXO("QQToken", "getLocalOpenIdByAppId " + e.toString());
        }
        return II0XooXoX2;
    }
}
