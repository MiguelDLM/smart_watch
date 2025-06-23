package IOOoXo0Ix;

import IOOoXo0Ix.x0XOIxOo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService;

/* loaded from: classes13.dex */
public class II0XooXoX implements xo.Oxx0IOOO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f556II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f557oIX0oI;

    /* loaded from: classes13.dex */
    public class oIX0oI implements x0XOIxOo.oIX0oI {
        public oIX0oI() {
        }

        @Override // IOOoXo0Ix.x0XOIxOo.oIX0oI
        public String oIX0oI(IBinder iBinder) throws OAIDException, RemoteException {
            OpenDeviceIdentifierService asInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
            if (!asInterface.isOaidTrackLimited()) {
                return asInterface.getOaid();
            }
            throw new OAIDException("User has disabled advertising identifier");
        }
    }

    public II0XooXoX(Context context) {
        this.f557oIX0oI = context;
    }

    @Override // xo.Oxx0IOOO
    public boolean II0xO0() {
        Context context = this.f557oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f556II0xO0 = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f556II0xO0 = "com.huawei.hwid.tv";
            } else {
                this.f556II0xO0 = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            xo.xxIXOIIO.II0xO0(e);
            return false;
        }
    }

    @Override // xo.Oxx0IOOO
    public void oIX0oI(xo.XO xo2) {
        Context context = this.f557oIX0oI;
        if (context != null && xo2 != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                    if (!TextUtils.isEmpty(string)) {
                        xo.xxIXOIIO.II0xO0("Get oaid from global settings: " + string);
                        xo2.oaidSucc(string);
                        return;
                    }
                } catch (Exception e) {
                    xo.xxIXOIIO.II0xO0(e);
                }
            }
            if (TextUtils.isEmpty(this.f556II0xO0) && !II0xO0()) {
                xo2.oaidError(new OAIDException("Huawei Advertising ID not available"));
                return;
            }
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(this.f556II0xO0);
            x0XOIxOo.oIX0oI(this.f557oIX0oI, intent, xo2, new oIX0oI());
        }
    }
}
