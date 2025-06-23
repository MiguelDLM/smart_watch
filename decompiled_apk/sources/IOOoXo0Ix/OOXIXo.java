package IOOoXo0Ix;

import IOOoXo0Ix.x0XOIxOo;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.core.bun.lib.MsaIdInterface;

/* loaded from: classes13.dex */
public class OOXIXo implements xo.Oxx0IOOO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f562oIX0oI;

    /* loaded from: classes13.dex */
    public class oIX0oI implements x0XOIxOo.oIX0oI {
        public oIX0oI() {
        }

        @Override // IOOoXo0Ix.x0XOIxOo.oIX0oI
        public String oIX0oI(IBinder iBinder) throws OAIDException, RemoteException {
            MsaIdInterface asInterface = MsaIdInterface.Stub.asInterface(iBinder);
            if (asInterface != null) {
                if (asInterface.isSupported()) {
                    return asInterface.getOAID();
                }
                throw new OAIDException("MsaIdInterface#isSupported return false");
            }
            throw new OAIDException("MsaIdInterface is null");
        }
    }

    public OOXIXo(Context context) {
        this.f562oIX0oI = context;
    }

    public final void I0Io() {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.f562oIX0oI.getPackageName());
            if (Build.VERSION.SDK_INT >= 26) {
                this.f562oIX0oI.startForegroundService(intent);
            } else {
                this.f562oIX0oI.startService(intent);
            }
        } catch (Exception e) {
            xo.xxIXOIIO.II0xO0(e);
        }
    }

    @Override // xo.Oxx0IOOO
    public boolean II0xO0() {
        Context context = this.f562oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.mdid.msa", 0) == null) {
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
        if (this.f562oIX0oI != null && xo2 != null) {
            I0Io();
            Intent intent = new Intent("com.bun.msa.action.bindto.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.putExtra("com.bun.msa.param.pkgname", this.f562oIX0oI.getPackageName());
            x0XOIxOo.oIX0oI(this.f562oIX0oI, intent, xo2, new oIX0oI());
        }
    }
}
