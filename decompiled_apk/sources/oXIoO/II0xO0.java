package oXIoO;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.octopus.ad.utils.a.e;
import oIIxXoo.oIX0oI;
import oXIoO.ooOOo0oXI;

/* loaded from: classes11.dex */
public class II0xO0 implements oXxOI0oIx.oxoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f32116oIX0oI;

    /* loaded from: classes11.dex */
    public class oIX0oI implements ooOOo0oXI.oIX0oI {
        public oIX0oI() {
        }

        @Override // oXIoO.ooOOo0oXI.oIX0oI
        public String a(IBinder iBinder) throws e, RemoteException {
            oIIxXoo.oIX0oI XO2 = oIX0oI.AbstractBinderC1123oIX0oI.XO(iBinder);
            if (XO2 != null) {
                return XO2.b(II0xO0.this.f32116oIX0oI.getPackageName());
            }
            throw new e("IDeviceIdManager is null");
        }
    }

    public II0xO0(Context context) {
        if (context instanceof Application) {
            this.f32116oIX0oI = context;
        } else {
            this.f32116oIX0oI = context.getApplicationContext();
        }
    }

    @Override // oXxOI0oIx.oxoX
    public boolean a() {
        Context context = this.f32116oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) == null) {
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
        if (this.f32116oIX0oI != null && i0Io != null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
            ooOOo0oXI.oIX0oI(this.f32116oIX0oI, intent, i0Io, new oIX0oI());
        }
    }
}
