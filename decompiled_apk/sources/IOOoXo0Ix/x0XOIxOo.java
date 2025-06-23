package IOOoXo0Ix;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;

/* loaded from: classes13.dex */
public class x0XOIxOo implements ServiceConnection {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final oIX0oI f595IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final xo.XO f596Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final Context f597XO;

    @FunctionalInterface
    /* loaded from: classes13.dex */
    public interface oIX0oI {
        String oIX0oI(IBinder iBinder) throws OAIDException, RemoteException;
    }

    public x0XOIxOo(Context context, xo.XO xo2, oIX0oI oix0oi) {
        if (context instanceof Application) {
            this.f597XO = context;
        } else {
            this.f597XO = context.getApplicationContext();
        }
        this.f596Oo = xo2;
        this.f595IXxxXO = oix0oi;
    }

    public static void oIX0oI(Context context, Intent intent, xo.XO xo2, oIX0oI oix0oi) {
        new x0XOIxOo(context, xo2, oix0oi).II0xO0(intent);
    }

    public final void II0xO0(Intent intent) {
        try {
            if (this.f597XO.bindService(intent, this, 1)) {
                xo.xxIXOIIO.II0xO0("Service has been bound: " + intent);
                return;
            }
            throw new OAIDException("Service binding failed");
        } catch (Exception e) {
            this.f596Oo.oaidError(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String oIX0oI2;
        xo.xxIXOIIO.II0xO0("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    oIX0oI2 = this.f595IXxxXO.oIX0oI(iBinder);
                } catch (Throwable th) {
                    try {
                        this.f597XO.unbindService(this);
                        xo.xxIXOIIO.II0xO0("Service has been unbound: " + componentName.getClassName());
                    } catch (Exception e) {
                        xo.xxIXOIIO.II0xO0(e);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                xo.xxIXOIIO.II0xO0(e2);
                this.f596Oo.oaidError(e2);
                this.f597XO.unbindService(this);
                xo.xxIXOIIO.II0xO0("Service has been unbound: " + componentName.getClassName());
            }
            if (oIX0oI2 != null && oIX0oI2.length() != 0) {
                xo.xxIXOIIO.II0xO0("OAID/AAID acquire success: " + oIX0oI2);
                this.f596Oo.oaidSucc(oIX0oI2);
                this.f597XO.unbindService(this);
                xo.xxIXOIIO.II0xO0("Service has been unbound: " + componentName.getClassName());
                return;
            }
            throw new OAIDException("OAID/AAID acquire failed");
        } catch (Exception e3) {
            xo.xxIXOIIO.II0xO0(e3);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        xo.xxIXOIIO.II0xO0("Service has been disconnected: " + componentName.getClassName());
    }
}
