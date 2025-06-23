package IOOoXo0Ix;

import IOOoXo0Ix.x0XOIxOo;
import X0IOOI.oIX0oI;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;

/* loaded from: classes13.dex */
public class XO implements xo.Oxx0IOOO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f586oIX0oI;

    /* loaded from: classes13.dex */
    public class oIX0oI implements x0XOIxOo.oIX0oI {
        public oIX0oI() {
        }

        @Override // IOOoXo0Ix.x0XOIxOo.oIX0oI
        public String oIX0oI(IBinder iBinder) throws OAIDException, RemoteException {
            X0IOOI.oIX0oI XO2 = oIX0oI.II0xO0.XO(iBinder);
            if (XO2.oxoX(true)) {
                xo.xxIXOIIO.II0xO0("User has disabled advertising identifier");
            }
            return XO2.getId();
        }
    }

    public XO(Context context) {
        this.f586oIX0oI = context;
    }

    @Override // xo.Oxx0IOOO
    public boolean II0xO0() {
        Context context = this.f586oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.android.vending", 0) == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            xo.xxIXOIIO.II0xO0(e);
            return false;
        }
    }

    @Override // xo.Oxx0IOOO
    public void oIX0oI(xo.XO xo2) {
        if (this.f586oIX0oI != null && xo2 != null) {
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            x0XOIxOo.oIX0oI(this.f586oIX0oI, intent, xo2, new oIX0oI());
        }
    }
}
