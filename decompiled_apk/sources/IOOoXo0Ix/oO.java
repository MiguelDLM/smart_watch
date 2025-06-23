package IOOoXo0Ix;

import IOOoXo0Ix.x0XOIxOo;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.core.heytap.openid.IOpenID;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes13.dex */
public class oO implements xo.Oxx0IOOO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f590II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f591oIX0oI;

    /* loaded from: classes13.dex */
    public class oIX0oI implements x0XOIxOo.oIX0oI {
        public oIX0oI() {
        }

        @Override // IOOoXo0Ix.x0XOIxOo.oIX0oI
        public String oIX0oI(IBinder iBinder) throws OAIDException, RemoteException {
            try {
                return oO.this.X0o0xo(iBinder);
            } catch (RemoteException e) {
                throw e;
            } catch (OAIDException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new OAIDException(e3);
            }
        }
    }

    public oO(Context context) {
        if (context instanceof Application) {
            this.f591oIX0oI = context;
        } else {
            this.f591oIX0oI = context.getApplicationContext();
        }
    }

    @Override // xo.Oxx0IOOO
    public boolean II0xO0() {
        Context context = this.f591oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.heytap.openid", 0) == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            xo.xxIXOIIO.II0xO0(e);
            return false;
        }
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public final String X0o0xo(IBinder iBinder) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException, OAIDException {
        String packageName = this.f591oIX0oI.getPackageName();
        String str = this.f590II0xO0;
        if (str == null) {
            byte[] digest = MessageDigest.getInstance(IoxX.I0Io.f849Oxx0IOOO).digest(this.f591oIX0oI.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            String sb2 = sb.toString();
            this.f590II0xO0 = sb2;
            return oxoX(iBinder, packageName, sb2);
        }
        return oxoX(iBinder, packageName, str);
    }

    @Override // xo.Oxx0IOOO
    public void oIX0oI(xo.XO xo2) {
        if (this.f591oIX0oI != null && xo2 != null) {
            Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            x0XOIxOo.oIX0oI(this.f591oIX0oI, intent, xo2, new oIX0oI());
        }
    }

    public final String oxoX(IBinder iBinder, String str, String str2) throws RemoteException, OAIDException {
        IOpenID asInterface = IOpenID.Stub.asInterface(iBinder);
        if (asInterface != null) {
            return asInterface.getSerID(str, str2, "OUID");
        }
        throw new OAIDException("IOpenID is null");
    }
}
