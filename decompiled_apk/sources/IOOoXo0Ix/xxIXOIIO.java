package IOOoXo0Ix;

import IOOoXo0Ix.x0XOIxOo;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.core.zui.deviceidservice.IDeviceidInterface;

/* loaded from: classes13.dex */
public class xxIXOIIO implements xo.Oxx0IOOO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f601oIX0oI;

    /* loaded from: classes13.dex */
    public class oIX0oI implements x0XOIxOo.oIX0oI {
        public oIX0oI() {
        }

        @Override // IOOoXo0Ix.x0XOIxOo.oIX0oI
        public String oIX0oI(IBinder iBinder) throws OAIDException, RemoteException {
            IDeviceidInterface asInterface = IDeviceidInterface.Stub.asInterface(iBinder);
            if (asInterface != null) {
                if (asInterface.isSupport()) {
                    return asInterface.getOAID();
                }
                throw new OAIDException("IDeviceidInterface#isSupport return false");
            }
            throw new OAIDException("IDeviceidInterface is null");
        }
    }

    public xxIXOIIO(Context context) {
        this.f601oIX0oI = context;
    }

    @Override // xo.Oxx0IOOO
    public boolean II0xO0() {
        Context context = this.f601oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) == null) {
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
        if (this.f601oIX0oI != null && xo2 != null) {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            x0XOIxOo.oIX0oI(this.f601oIX0oI, intent, xo2, new oIX0oI());
        }
    }
}
