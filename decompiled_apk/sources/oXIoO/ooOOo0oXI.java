package oXIoO;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.octopus.ad.utils.a.e;

/* loaded from: classes11.dex */
public class ooOOo0oXI implements ServiceConnection {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final oIX0oI f32135IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final oXxOI0oIx.I0Io f32136Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final Context f32137XO;

    @FunctionalInterface
    /* loaded from: classes11.dex */
    public interface oIX0oI {
        String a(IBinder iBinder) throws e, RemoteException;
    }

    public ooOOo0oXI(Context context, oXxOI0oIx.I0Io i0Io, oIX0oI oix0oi) {
        if (context instanceof Application) {
            this.f32137XO = context;
        } else {
            this.f32137XO = context.getApplicationContext();
        }
        this.f32136Oo = i0Io;
        this.f32135IXxxXO = oix0oi;
    }

    public static void oIX0oI(Context context, Intent intent, oXxOI0oIx.I0Io i0Io, oIX0oI oix0oi) {
        new ooOOo0oXI(context, i0Io, oix0oi).II0xO0(intent);
    }

    public final void II0xO0(Intent intent) {
        try {
            if (this.f32137XO.bindService(intent, this, 1)) {
                oXxOI0oIx.X0o0xo.oIX0oI("Service has been bound: " + intent);
                return;
            }
            throw new e("Service binding failed");
        } catch (Exception e) {
            this.f32136Oo.a(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String a2;
        oXxOI0oIx.X0o0xo.oIX0oI("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    a2 = this.f32135IXxxXO.a(iBinder);
                } catch (Throwable th) {
                    try {
                        this.f32137XO.unbindService(this);
                        oXxOI0oIx.X0o0xo.oIX0oI("Service has been unbound: " + componentName.getClassName());
                    } catch (Exception e) {
                        oXxOI0oIx.X0o0xo.oIX0oI(e);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                oXxOI0oIx.X0o0xo.oIX0oI(e2);
                this.f32136Oo.a(e2);
                this.f32137XO.unbindService(this);
                oXxOI0oIx.X0o0xo.oIX0oI("Service has been unbound: " + componentName.getClassName());
            }
            if (a2 != null && a2.length() != 0) {
                oXxOI0oIx.X0o0xo.oIX0oI("OAID/GAID acquire success: " + a2);
                this.f32136Oo.a(a2);
                this.f32137XO.unbindService(this);
                oXxOI0oIx.X0o0xo.oIX0oI("Service has been unbound: " + componentName.getClassName());
                return;
            }
            throw new e("OAID/GAID acquire failed");
        } catch (Exception e3) {
            oXxOI0oIx.X0o0xo.oIX0oI(e3);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        oXxOI0oIx.X0o0xo.oIX0oI("Service has been disconnected: " + componentName.getClassName());
    }
}
