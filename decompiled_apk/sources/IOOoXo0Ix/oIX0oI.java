package IOOoXo0Ix;

import IOOoXo0Ix.x0XOIxOo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface;

/* loaded from: classes13.dex */
public class oIX0oI implements xo.Oxx0IOOO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f588oIX0oI;

    /* renamed from: IOOoXo0Ix.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class C0016oIX0oI implements x0XOIxOo.oIX0oI {
        public C0016oIX0oI() {
        }

        @Override // IOOoXo0Ix.x0XOIxOo.oIX0oI
        public String oIX0oI(IBinder iBinder) throws OAIDException, RemoteException {
            IDidAidlInterface asInterface = IDidAidlInterface.Stub.asInterface(iBinder);
            if (asInterface != null) {
                if (asInterface.isSupport()) {
                    return asInterface.getOAID();
                }
                throw new OAIDException("IDidAidlInterface#isSupport return false");
            }
            throw new OAIDException("IDidAidlInterface is null");
        }
    }

    public oIX0oI(Context context) {
        this.f588oIX0oI = context;
    }

    @Override // xo.Oxx0IOOO
    public boolean II0xO0() {
        Context context = this.f588oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) == null) {
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
        if (this.f588oIX0oI != null && xo2 != null) {
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            x0XOIxOo.oIX0oI(this.f588oIX0oI, intent, xo2, new C0016oIX0oI());
        }
    }
}
