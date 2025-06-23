package IOOoXo0Ix;

import IOOoXo0Ix.x0XOIxOo;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.core.samsung.android.deviceidservice.IDeviceIdService;

/* loaded from: classes13.dex */
public class x0xO0oo implements xo.Oxx0IOOO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f598oIX0oI;

    /* loaded from: classes13.dex */
    public class oIX0oI implements x0XOIxOo.oIX0oI {
        public oIX0oI() {
        }

        @Override // IOOoXo0Ix.x0XOIxOo.oIX0oI
        public String oIX0oI(IBinder iBinder) throws OAIDException, RemoteException {
            IDeviceIdService asInterface = IDeviceIdService.Stub.asInterface(iBinder);
            if (asInterface != null) {
                return asInterface.getOAID();
            }
            throw new OAIDException("IDeviceIdService is null");
        }
    }

    public x0xO0oo(Context context) {
        this.f598oIX0oI = context;
    }

    @Override // xo.Oxx0IOOO
    public boolean II0xO0() {
        Context context = this.f598oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) == null) {
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
        if (this.f598oIX0oI != null && xo2 != null) {
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            x0XOIxOo.oIX0oI(this.f598oIX0oI, intent, xo2, new oIX0oI());
        }
    }
}
