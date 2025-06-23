package IOOoXo0Ix;

import android.app.KeyguardManager;
import android.content.Context;
import com.tanx.onlyid.api.OAIDException;
import java.util.Objects;

/* loaded from: classes13.dex */
public class I0Io implements xo.Oxx0IOOO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final KeyguardManager f554II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f555oIX0oI;

    public I0Io(Context context) {
        this.f555oIX0oI = context;
        this.f554II0xO0 = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // xo.Oxx0IOOO
    public boolean II0xO0() {
        KeyguardManager keyguardManager;
        if (this.f555oIX0oI == null || (keyguardManager = this.f554II0xO0) == null) {
            return false;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("isSupported", null).invoke(this.f554II0xO0, null);
            Objects.requireNonNull(invoke);
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            xo.xxIXOIIO.II0xO0(e);
            return false;
        }
    }

    @Override // xo.Oxx0IOOO
    public void oIX0oI(xo.XO xo2) {
        if (this.f555oIX0oI != null && xo2 != null) {
            KeyguardManager keyguardManager = this.f554II0xO0;
            if (keyguardManager == null) {
                xo2.oaidError(new OAIDException("KeyguardManager not found"));
                return;
            }
            try {
                Object invoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", null).invoke(this.f554II0xO0, null);
                if (invoke != null) {
                    String obj = invoke.toString();
                    xo.xxIXOIIO.II0xO0("OAID obtain success: " + obj);
                    xo2.oaidSucc(obj);
                    return;
                }
                throw new OAIDException("OAID obtain failed");
            } catch (Exception e) {
                xo.xxIXOIIO.II0xO0(e);
            }
        }
    }
}
