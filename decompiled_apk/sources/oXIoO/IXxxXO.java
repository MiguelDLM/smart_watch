package oXIoO;

import android.annotation.SuppressLint;
import android.content.Context;
import com.octopus.ad.utils.a.e;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes11.dex */
public class IXxxXO implements oXxOI0oIx.oxoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public Object f32118I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Class<?> f32119II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f32120oIX0oI;

    @SuppressLint({"PrivateApi"})
    public IXxxXO(Context context) {
        this.f32120oIX0oI = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f32119II0xO0 = cls;
            this.f32118I0Io = cls.newInstance();
        } catch (Exception e) {
            oXxOI0oIx.X0o0xo.oIX0oI(e);
        }
    }

    public final String II0xO0() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (String) this.f32119II0xO0.getMethod("getOAID", Context.class).invoke(this.f32118I0Io, this.f32120oIX0oI);
    }

    @Override // oXxOI0oIx.oxoX
    public boolean a() {
        if (this.f32118I0Io != null) {
            return true;
        }
        return false;
    }

    @Override // oXxOI0oIx.oxoX
    public void oIX0oI(oXxOI0oIx.I0Io i0Io) {
        if (this.f32120oIX0oI != null && i0Io != null) {
            if (this.f32119II0xO0 != null && this.f32118I0Io != null) {
                try {
                    String II0xO02 = II0xO0();
                    if (II0xO02 != null && II0xO02.length() != 0) {
                        oXxOI0oIx.X0o0xo.oIX0oI("OAID query success: " + II0xO02);
                        i0Io.a(II0xO02);
                        return;
                    }
                    throw new e("OAID query failed");
                } catch (Exception e) {
                    oXxOI0oIx.X0o0xo.oIX0oI(e);
                    i0Io.a(e);
                    return;
                }
            }
            i0Io.a(new e("Xiaomi IdProvider not exists"));
        }
    }
}
