package oXIoO;

import Oxx.oIX0oI;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.octopus.ad.utils.a.e;
import oXIoO.ooOOo0oXI;

/* loaded from: classes11.dex */
public class Oxx0IOOO implements oXxOI0oIx.oxoX {

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f32122II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f32123oIX0oI;

    /* loaded from: classes11.dex */
    public class oIX0oI implements ooOOo0oXI.oIX0oI {
        public oIX0oI() {
        }

        @Override // oXIoO.ooOOo0oXI.oIX0oI
        public String a(IBinder iBinder) throws e, RemoteException {
            Oxx.oIX0oI XO2 = oIX0oI.AbstractBinderC0044oIX0oI.XO(iBinder);
            if (!XO2.b()) {
                return XO2.a();
            }
            throw new e("User has disabled advertising identifier");
        }
    }

    public Oxx0IOOO(Context context) {
        this.f32123oIX0oI = context;
    }

    @Override // oXxOI0oIx.oxoX
    public boolean a() {
        Context context = this.f32123oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f32122II0xO0 = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f32122II0xO0 = "com.huawei.hwid.tv";
            } else {
                this.f32122II0xO0 = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            oXxOI0oIx.X0o0xo.oIX0oI(e);
            return false;
        }
    }

    @Override // oXxOI0oIx.oxoX
    public void oIX0oI(oXxOI0oIx.I0Io i0Io) {
        Context context = this.f32123oIX0oI;
        if (context != null && i0Io != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                    if (!TextUtils.isEmpty(string)) {
                        oXxOI0oIx.X0o0xo.oIX0oI("Get oaid from global settings: " + string);
                        i0Io.a(string);
                        return;
                    }
                } catch (Exception e) {
                    oXxOI0oIx.X0o0xo.oIX0oI(e);
                }
            }
            if (TextUtils.isEmpty(this.f32122II0xO0) && !a()) {
                i0Io.a(new e("Huawei Advertising ID not available"));
                return;
            }
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(this.f32122II0xO0);
            ooOOo0oXI.oIX0oI(this.f32123oIX0oI, intent, i0Io, new oIX0oI());
        }
    }
}
