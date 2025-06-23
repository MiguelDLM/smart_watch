package oXIoO;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.octopus.ad.utils.a.e;
import oXIoO.ooOOo0oXI;
import oXX0IoI.oIX0oI;

/* loaded from: classes11.dex */
public class XO implements oXxOI0oIx.oxoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f32127oIX0oI;

    /* loaded from: classes11.dex */
    public class oIX0oI implements ooOOo0oXI.oIX0oI {
        public oIX0oI() {
        }

        @Override // oXIoO.ooOOo0oXI.oIX0oI
        public String a(IBinder iBinder) throws e, RemoteException {
            oXX0IoI.oIX0oI XO2 = oIX0oI.AbstractBinderC1131oIX0oI.XO(iBinder);
            if (XO2.a(true)) {
                oXxOI0oIx.X0o0xo.oIX0oI("User has disabled advertising identifier");
            }
            return XO2.a();
        }
    }

    public XO(Context context) {
        this.f32127oIX0oI = context;
    }

    @Override // oXxOI0oIx.oxoX
    public boolean a() {
        Context context = this.f32127oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.android.vending", 0) == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            oXxOI0oIx.X0o0xo.oIX0oI(e);
            return false;
        }
    }

    @Override // oXxOI0oIx.oxoX
    public void oIX0oI(oXxOI0oIx.I0Io i0Io) {
        if (this.f32127oIX0oI != null && i0Io != null) {
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            ooOOo0oXI.oIX0oI(this.f32127oIX0oI, intent, i0Io, new oIX0oI());
        }
    }
}
