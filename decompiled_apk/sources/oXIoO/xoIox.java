package oXIoO;

import IOoo.oIX0oI;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.octopus.ad.utils.a.e;
import oXIoO.ooOOo0oXI;

/* loaded from: classes11.dex */
public class xoIox implements oXxOI0oIx.oxoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f32142oIX0oI;

    /* loaded from: classes11.dex */
    public class oIX0oI implements ooOOo0oXI.oIX0oI {
        public oIX0oI() {
        }

        @Override // oXIoO.ooOOo0oXI.oIX0oI
        public String a(IBinder iBinder) throws e, RemoteException {
            IOoo.oIX0oI XO2 = oIX0oI.AbstractBinderC0017oIX0oI.XO(iBinder);
            if (XO2 != null) {
                if (XO2.a()) {
                    return XO2.c();
                }
                throw new e("MsaIdInterface#isSupported return false");
            }
            throw new e("MsaIdInterface is null");
        }
    }

    public xoIox(Context context) {
        this.f32142oIX0oI = context;
    }

    public final void II0xO0() {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.f32142oIX0oI.getPackageName());
            if (Build.VERSION.SDK_INT >= 26) {
                this.f32142oIX0oI.startForegroundService(intent);
            } else {
                this.f32142oIX0oI.startService(intent);
            }
        } catch (Exception e) {
            oXxOI0oIx.X0o0xo.oIX0oI(e);
        }
    }

    @Override // oXxOI0oIx.oxoX
    public boolean a() {
        Context context = this.f32142oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.mdid.msa", 0) == null) {
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
        if (this.f32142oIX0oI != null && i0Io != null) {
            II0xO0();
            Intent intent = new Intent("com.bun.msa.action.bindto.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.putExtra("com.bun.msa.param.pkgname", this.f32142oIX0oI.getPackageName());
            ooOOo0oXI.oIX0oI(this.f32142oIX0oI, intent, i0Io, new oIX0oI());
        }
    }
}
