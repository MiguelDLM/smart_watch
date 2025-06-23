package x0;

import com.octopus.ad.R;
import com.octopus.ad.internal.utilities.oIX0oI;
import com.octopus.ad.model.e;

/* loaded from: classes11.dex */
public class o0 {

    /* renamed from: XO, reason: collision with root package name */
    public static o0 f33736XO;

    /* renamed from: I0Io, reason: collision with root package name */
    public String f33737I0Io;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public e.d f33740oIX0oI;

    /* renamed from: II0xO0, reason: collision with root package name */
    public e.c f33738II0xO0 = e.c.ISP_OTHER;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f33741oxoX = true;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f33739X0o0xo = -1;

    public static o0 oIX0oI() {
        o0 o0Var;
        synchronized (o0.class) {
            try {
                if (f33736XO == null) {
                    f33736XO = new o0();
                    oIX0oI.ooXIXxIX(oIX0oI.f18685II0xO0, oIX0oI.xxIXOIIO(R.string.init));
                }
                o0Var = f33736XO;
            } catch (Throwable th) {
                throw th;
            }
        }
        return o0Var;
    }

    public void I0Io(int i) {
        if (i > 6) {
            this.f33739X0o0xo = 6;
            oIX0oI.oo0xXOI0I(oIX0oI.f18685II0xO0, "Out of range input " + i + ", set location digits after decimal to maximum 6");
            return;
        }
        if (i >= -1) {
            this.f33739X0o0xo = i;
            return;
        }
        this.f33739X0o0xo = -1;
        oIX0oI.oo0xXOI0I(oIX0oI.f18685II0xO0, "Negative input " + i + ", set location digits after decimal to default");
    }

    public int II0xO0() {
        return this.f33739X0o0xo;
    }
}
