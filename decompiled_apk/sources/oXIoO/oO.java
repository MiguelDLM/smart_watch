package oXIoO;

import I0xX0.oIX0oI;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.octopus.ad.utils.a.e;
import oXIoO.ooOOo0oXI;

/* loaded from: classes11.dex */
public class oO implements oXxOI0oIx.oxoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f32131oIX0oI;

    /* loaded from: classes11.dex */
    public class oIX0oI implements ooOOo0oXI.oIX0oI {
        public oIX0oI() {
        }

        @Override // oXIoO.ooOOo0oXI.oIX0oI
        public String a(IBinder iBinder) throws e, RemoteException {
            I0xX0.oIX0oI XO2 = oIX0oI.AbstractBinderC0002oIX0oI.XO(iBinder);
            if (XO2 != null) {
                return XO2.a();
            }
            throw new e("IDeviceIdService is null");
        }
    }

    public oO(Context context) {
        this.f32131oIX0oI = context;
    }

    @Override // oXxOI0oIx.oxoX
    public boolean a() {
        Context context = this.f32131oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) == null) {
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
        if (this.f32131oIX0oI != null && i0Io != null) {
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            ooOOo0oXI.oIX0oI(this.f32131oIX0oI, intent, i0Io, new oIX0oI());
        }
    }
}
