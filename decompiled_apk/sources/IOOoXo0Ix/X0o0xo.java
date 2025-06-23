package IOOoXo0Ix;

import IOOoXo0Ix.x0XOIxOo;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.core.android.creator.IdsSupplier;

/* loaded from: classes13.dex */
public class X0o0xo implements xo.Oxx0IOOO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f584oIX0oI;

    /* loaded from: classes13.dex */
    public class oIX0oI implements x0XOIxOo.oIX0oI {
        public oIX0oI() {
        }

        @Override // IOOoXo0Ix.x0XOIxOo.oIX0oI
        public String oIX0oI(IBinder iBinder) throws OAIDException, RemoteException {
            IdsSupplier asInterface = IdsSupplier.Stub.asInterface(iBinder);
            if (asInterface != null) {
                return asInterface.getOAID();
            }
            throw new OAIDException("IdsSupplier is null");
        }
    }

    public X0o0xo(Context context) {
        this.f584oIX0oI = context;
    }

    @Override // xo.Oxx0IOOO
    public boolean II0xO0() {
        Context context = this.f584oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.android.creator", 0) == null) {
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
        if (this.f584oIX0oI != null && xo2 != null) {
            Intent intent = new Intent("android.service.action.msa");
            intent.setPackage("com.android.creator");
            x0XOIxOo.oIX0oI(this.f584oIX0oI, intent, xo2, new oIX0oI());
        }
    }
}
