package oXIoO;

import XI.oIX0oI;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.octopus.ad.utils.a.e;
import oXIoO.ooOOo0oXI;

/* loaded from: classes11.dex */
public class oIX0oI implements oXxOI0oIx.oxoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f32129oIX0oI;

    /* renamed from: oXIoO.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C1129oIX0oI implements ooOOo0oXI.oIX0oI {
        public C1129oIX0oI() {
        }

        @Override // oXIoO.ooOOo0oXI.oIX0oI
        public String a(IBinder iBinder) throws e, RemoteException {
            XI.oIX0oI XO2 = oIX0oI.AbstractBinderC0056oIX0oI.XO(iBinder);
            if (XO2 != null) {
                if (XO2.a()) {
                    return XO2.c();
                }
                throw new e("IDidAidlInterface#isSupport return false");
            }
            throw new e("IDidAidlInterface is null");
        }
    }

    public oIX0oI(Context context) {
        this.f32129oIX0oI = context;
    }

    @Override // oXxOI0oIx.oxoX
    public boolean a() {
        Context context = this.f32129oIX0oI;
        if (context == null) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) == null) {
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
        if (this.f32129oIX0oI != null && i0Io != null) {
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            ooOOo0oXI.oIX0oI(this.f32129oIX0oI, intent, i0Io, new C1129oIX0oI());
        }
    }
}
