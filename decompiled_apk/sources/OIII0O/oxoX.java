package OIII0O;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/* loaded from: classes6.dex */
public class oxoX extends Authenticator {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ X0o0xo f1615oIX0oI;

    public oxoX(X0o0xo x0o0xo) {
        this.f1615oIX0oI = x0o0xo;
    }

    public PasswordAuthentication oIX0oI() {
        String str;
        String str2;
        str = this.f1615oIX0oI.f1600x0XOIxOo;
        str2 = this.f1615oIX0oI.f1597oO;
        return new PasswordAuthentication(str, str2);
    }
}
