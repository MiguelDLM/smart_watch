package IOOoXo0Ix;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tanx.onlyid.api.OAIDException;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes13.dex */
public class Oxx0xo implements xo.Oxx0IOOO {

    /* renamed from: I0Io, reason: collision with root package name */
    public Object f581I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Class<?> f582II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f583oIX0oI;

    @SuppressLint({"PrivateApi"})
    public Oxx0xo(Context context) {
        this.f583oIX0oI = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f582II0xO0 = cls;
            this.f581I0Io = cls.newInstance();
        } catch (Exception e) {
            xo.xxIXOIIO.II0xO0(e);
        }
    }

    public final String I0Io() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) this.f582II0xO0.getMethod("getOAID", Context.class).invoke(this.f581I0Io, this.f583oIX0oI);
    }

    @Override // xo.Oxx0IOOO
    public boolean II0xO0() {
        if (this.f581I0Io != null) {
            return true;
        }
        return false;
    }

    @Override // xo.Oxx0IOOO
    public void oIX0oI(xo.XO xo2) {
        if (this.f583oIX0oI != null && xo2 != null) {
            if (this.f582II0xO0 != null && this.f581I0Io != null) {
                try {
                    String I0Io2 = I0Io();
                    if (I0Io2 != null && I0Io2.length() != 0) {
                        xo.xxIXOIIO.II0xO0("OAID query success: " + I0Io2);
                        xo2.oaidSucc(I0Io2);
                        return;
                    }
                    throw new OAIDException("OAID query failed");
                } catch (Exception e) {
                    xo.xxIXOIIO.II0xO0(e);
                    xo2.oaidError(e);
                    return;
                }
            }
            xo2.oaidError(new OAIDException("Xiaomi IdProvider not exists"));
        }
    }
}
