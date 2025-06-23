package oXIoO;

import XOxxooXI.oIX0oI;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.octopus.ad.utils.a.e;
import oXIoO.ooOOo0oXI;

/* loaded from: classes11.dex */
public class X0o0xo implements oXxOI0oIx.oxoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f32125oIX0oI;

    /* loaded from: classes11.dex */
    public class oIX0oI implements ooOOo0oXI.oIX0oI {
        public oIX0oI() {
        }

        @Override // oXIoO.ooOOo0oXI.oIX0oI
        public String a(IBinder iBinder) throws e, RemoteException {
            XOxxooXI.oIX0oI XO2 = oIX0oI.AbstractBinderC0061oIX0oI.XO(iBinder);
            if (XO2 != null) {
                return XO2.b();
            }
            throw new e("IdsSupplier is null");
        }
    }

    public X0o0xo(Context context) {
        this.f32125oIX0oI = context;
    }

    @Override // oXxOI0oIx.oxoX
    public boolean a() {
        Context context = this.f32125oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.android.creator", 0) == null) {
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
        if (this.f32125oIX0oI != null && i0Io != null) {
            Intent intent = new Intent("android.service.action.msa");
            intent.setPackage("com.android.creator");
            ooOOo0oXI.oIX0oI(this.f32125oIX0oI, intent, i0Io, new oIX0oI());
        }
    }
}
