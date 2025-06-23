package xoX;

import android.os.SystemClock;
import com.tencent.open.utils.II0xO0;

/* loaded from: classes13.dex */
public class OOXIXo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static OOXIXo f35113oIX0oI;

    public static synchronized OOXIXo oIX0oI() {
        OOXIXo oOXIXo;
        synchronized (OOXIXo.class) {
            try {
                if (f35113oIX0oI == null) {
                    f35113oIX0oI = new OOXIXo();
                }
                oOXIXo = f35113oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
        return oOXIXo;
    }

    public void I0Io(String str, String str2, String str3, String str4, String str5, String str6) {
        x0XOIxOo.II0xO0().I0Io(II0xO0.oxoX(str, str3, str4, str5, str2, str6), str2, true);
    }

    public void II0xO0(int i, String str, String str2, String str3, String str4, Long l, int i2, int i3, String str5) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - l.longValue();
        if (l.longValue() == 0 || elapsedRealtime < 0) {
            elapsedRealtime = 0;
        }
        StringBuffer stringBuffer = new StringBuffer("https://huatuocode.huatuo.qq.com");
        stringBuffer.append("?domain=mobile.opensdk.com&cgi=opensdk&type=");
        stringBuffer.append(i);
        stringBuffer.append("&code=");
        stringBuffer.append(i2);
        stringBuffer.append("&time=");
        stringBuffer.append(elapsedRealtime);
        stringBuffer.append("&rate=");
        stringBuffer.append(i3);
        stringBuffer.append("&uin=");
        stringBuffer.append(str2);
        stringBuffer.append("&data=");
        x0XOIxOo.II0xO0().XO(stringBuffer.toString(), "GET", II0xO0.X0o0xo(String.valueOf(i), String.valueOf(i2), String.valueOf(elapsedRealtime), String.valueOf(i3), str, str2, str3, str4, str5), true);
    }

    public void X0o0xo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        x0XOIxOo.II0xO0().I0Io(II0xO0.XO(str, str4, str5, str3, str2, str6, str7, "", "", str8, str9, str10), str2, false);
    }

    public void oxoX(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        x0XOIxOo.II0xO0().I0Io(II0xO0.XO(str, str4, str5, str3, str2, str6, "", str7, str8, "", "", ""), str2, false);
    }
}
