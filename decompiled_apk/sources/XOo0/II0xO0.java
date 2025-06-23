package XOo0;

import II0XooXoX.XO;
import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* loaded from: classes6.dex */
public class II0xO0 implements HostnameVerifier {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ I0Io f3939oIX0oI;

    public II0xO0(I0Io i0Io) {
        this.f3939oIX0oI = i0Io;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        XO.II0xO0("DynamicRegisterHttps", "hostname--" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f3939oIX0oI.f3930I0Io.contains(str)) {
            return true;
        }
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
    }
}
