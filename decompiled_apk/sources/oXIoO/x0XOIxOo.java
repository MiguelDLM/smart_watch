package oXIoO;

import XXXI.oIX0oI;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.octopus.ad.utils.a.e;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import oXIoO.ooOOo0oXI;

/* loaded from: classes11.dex */
public class x0XOIxOo implements oXxOI0oIx.oxoX {

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f32138II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f32139oIX0oI;

    /* loaded from: classes11.dex */
    public class oIX0oI implements ooOOo0oXI.oIX0oI {
        public oIX0oI() {
        }

        @Override // oXIoO.ooOOo0oXI.oIX0oI
        public String a(IBinder iBinder) throws e, RemoteException {
            try {
                return x0XOIxOo.this.II0xO0(iBinder);
            } catch (RemoteException e) {
                throw e;
            } catch (e e2) {
                throw e2;
            } catch (Exception e3) {
                throw new e(e3);
            }
        }
    }

    public x0XOIxOo(Context context) {
        if (context instanceof Application) {
            this.f32139oIX0oI = context;
        } else {
            this.f32139oIX0oI = context.getApplicationContext();
        }
    }

    public final String I0Io(IBinder iBinder, String str, String str2) throws RemoteException, e {
        XXXI.oIX0oI Oxx0IOOO2 = oIX0oI.AbstractBinderC0065oIX0oI.Oxx0IOOO(iBinder);
        if (Oxx0IOOO2 != null) {
            return Oxx0IOOO2.a(str, str2, "OUID");
        }
        throw new e("IOpenID is null");
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public final String II0xO0(IBinder iBinder) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException, e {
        String packageName = this.f32139oIX0oI.getPackageName();
        String str = this.f32138II0xO0;
        if (str == null) {
            byte[] digest = MessageDigest.getInstance(IoxX.I0Io.f849Oxx0IOOO).digest(this.f32139oIX0oI.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            String sb2 = sb.toString();
            this.f32138II0xO0 = sb2;
            return I0Io(iBinder, packageName, sb2);
        }
        return I0Io(iBinder, packageName, str);
    }

    @Override // oXxOI0oIx.oxoX
    public boolean a() {
        Context context = this.f32139oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.heytap.openid", 0) == null) {
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
        if (this.f32139oIX0oI != null && i0Io != null) {
            Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            ooOOo0oXI.oIX0oI(this.f32139oIX0oI, intent, i0Io, new oIX0oI());
        }
    }
}
