package oXIoO;

import android.app.KeyguardManager;
import android.content.Context;
import com.octopus.ad.utils.a.e;
import java.util.Objects;

/* loaded from: classes11.dex */
public class I0Io implements oXxOI0oIx.oxoX {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final KeyguardManager f32112II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f32113oIX0oI;

    public I0Io(Context context) {
        this.f32113oIX0oI = context;
        this.f32112II0xO0 = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // oXxOI0oIx.oxoX
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f32113oIX0oI == null || (keyguardManager = this.f32112II0xO0) == null) {
            return false;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("isSupported", null).invoke(this.f32112II0xO0, null);
            Objects.requireNonNull(invoke);
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            oXxOI0oIx.X0o0xo.oIX0oI(e);
            return false;
        }
    }

    @Override // oXxOI0oIx.oxoX
    public void oIX0oI(oXxOI0oIx.I0Io i0Io) {
        if (this.f32113oIX0oI != null && i0Io != null) {
            KeyguardManager keyguardManager = this.f32112II0xO0;
            if (keyguardManager == null) {
                i0Io.a(new e("KeyguardManager not found"));
                return;
            }
            try {
                Object invoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", null).invoke(this.f32112II0xO0, null);
                if (invoke != null) {
                    String obj = invoke.toString();
                    oXxOI0oIx.X0o0xo.oIX0oI("OAID obtain success: " + obj);
                    i0Io.a(obj);
                    return;
                }
                throw new e("OAID obtain failed");
            } catch (Exception e) {
                oXxOI0oIx.X0o0xo.oIX0oI(e);
            }
        }
    }
}
