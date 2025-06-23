package IOOoXo0Ix;

import IOOoXo0Ix.x0XOIxOo;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.core.coolpad.deviceidsupport.IDeviceIdManager;

/* loaded from: classes13.dex */
public class II0xO0 implements xo.Oxx0IOOO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f559oIX0oI;

    /* loaded from: classes13.dex */
    public class oIX0oI implements x0XOIxOo.oIX0oI {
        public oIX0oI() {
        }

        @Override // IOOoXo0Ix.x0XOIxOo.oIX0oI
        public String oIX0oI(IBinder iBinder) throws OAIDException, RemoteException {
            IDeviceIdManager asInterface = IDeviceIdManager.Stub.asInterface(iBinder);
            if (asInterface != null) {
                return asInterface.getOAID(II0xO0.this.f559oIX0oI.getPackageName());
            }
            throw new OAIDException("IDeviceIdManager is null");
        }
    }

    public II0xO0(Context context) {
        if (context instanceof Application) {
            this.f559oIX0oI = context;
        } else {
            this.f559oIX0oI = context.getApplicationContext();
        }
    }

    @Override // xo.Oxx0IOOO
    public boolean II0xO0() {
        Context context = this.f559oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) == null) {
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
        if (this.f559oIX0oI != null && xo2 != null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
            x0XOIxOo.oIX0oI(this.f559oIX0oI, intent, xo2, new oIX0oI());
        }
    }
}
