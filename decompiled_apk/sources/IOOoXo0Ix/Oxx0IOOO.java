package IOOoXo0Ix;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.tanx.onlyid.api.OAIDException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.Executors;
import xOoOIoI.II0xO0;
import xOoOIoI.oIX0oI;

/* loaded from: classes13.dex */
public class Oxx0IOOO implements xo.Oxx0IOOO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Context f566II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public oxoX f567Oxx0IOOO;

    /* renamed from: XO, reason: collision with root package name */
    public xo.XO f569XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f570oIX0oI = "HonorImpl";

    /* renamed from: I0Io, reason: collision with root package name */
    public final Handler f564I0Io = new Handler(Looper.getMainLooper());

    /* renamed from: oxoX, reason: collision with root package name */
    public String f571oxoX = "com.hihonor.id";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String f568X0o0xo = "com.hihonor.id.HnOaIdService";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public long f565II0XooXoX = System.currentTimeMillis();

    /* loaded from: classes13.dex */
    public class I0Io implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Exception f573XO;

        public I0Io(Exception exc) {
            this.f573XO = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Oxx0IOOO.this.f569XO != null) {
                Oxx0IOOO.this.f569XO.oaidError(this.f573XO);
            } else {
                Log.e(Oxx0IOOO.this.f570oIX0oI, "iGetter==null,无法回调");
            }
            Oxx0IOOO oxx0IOOO = Oxx0IOOO.this;
            oxx0IOOO.OxxIIOOXO(oxx0IOOO.f567Oxx0IOOO);
        }
    }

    /* loaded from: classes13.dex */
    public class II0xO0 implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f575XO;

        public II0xO0(String str) {
            this.f575XO = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Oxx0IOOO.this.f569XO != null) {
                Oxx0IOOO.this.f569XO.oaidSucc(this.f575XO);
                Log.d(Oxx0IOOO.this.f570oIX0oI, "耗时：" + (System.currentTimeMillis() - Oxx0IOOO.this.f565II0XooXoX));
            } else {
                Log.e(Oxx0IOOO.this.f570oIX0oI, "iGetter==null,无法回调");
            }
            Oxx0IOOO oxx0IOOO = Oxx0IOOO.this;
            oxx0IOOO.OxxIIOOXO(oxx0IOOO.f567Oxx0IOOO);
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Oxx0IOOO.this.oI0IIXIo();
        }
    }

    /* loaded from: classes13.dex */
    public class oxoX implements ServiceConnection {

        /* renamed from: XO, reason: collision with root package name */
        public String f580XO = "HiHonorServiceConnection";

        public oxoX() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(this.f580XO, "onServiceConnected ");
            try {
                xOoOIoI.II0xO0 XO2 = II0xO0.AbstractBinderC1158II0xO0.XO(iBinder);
                XO2.I0Io(new X0o0xo());
                XO2.X0o0xo(new XO());
            } catch (Exception e) {
                Oxx0IOOO.this.IXxxXO(e);
                Log.e(this.f580XO, "onServiceConnected error:" + e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Oxx0IOOO.this.f567Oxx0IOOO = null;
        }
    }

    public Oxx0IOOO(Context context) {
        this.f566II0xO0 = context;
    }

    public static boolean Oo() {
        if (!TextUtils.isEmpty(ooOOo0oXI(OI0.oxoX.f1509II0XooXoX))) {
            return true;
        }
        return false;
    }

    public static boolean oO() {
        return Build.MANUFACTURER.equalsIgnoreCase("HONOR");
    }

    public static String ooOOo0oXI(String str) {
        String str2;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (ClassNotFoundException e) {
            Log.e("HONOR", "getBuildVersion ClassNotFoundException" + e.getMessage());
            str2 = "";
            Log.i("HONOR", "getBuildVersion: " + str2);
            return str2;
        } catch (IllegalAccessException e2) {
            Log.e("HONOR", "getBuildVersion IllegalAccessException" + e2.getMessage());
            str2 = "";
            Log.i("HONOR", "getBuildVersion: " + str2);
            return str2;
        } catch (NoSuchMethodException e3) {
            Log.e("HONOR", "getBuildVersion NoSuchMethodException" + e3.getMessage());
            str2 = "";
            Log.i("HONOR", "getBuildVersion: " + str2);
            return str2;
        } catch (InvocationTargetException e4) {
            Log.e("HONOR", "getBuildVersion InvocationTargetException" + e4.getMessage());
            str2 = "";
            Log.i("HONOR", "getBuildVersion: " + str2);
            return str2;
        } catch (Exception e5) {
            Log.e("HONOR", "getBuildVersion Exception" + e5.getMessage());
            str2 = "";
            Log.i("HONOR", "getBuildVersion: " + str2);
            return str2;
        }
        Log.i("HONOR", "getBuildVersion: " + str2);
        return str2;
    }

    public static boolean x0xO0oo() {
        if (oO() && !Oo()) {
            return true;
        }
        return false;
    }

    @Override // xo.Oxx0IOOO
    public boolean II0xO0() {
        Context context = this.f566II0xO0;
        if (context == null) {
            return false;
        }
        return x0XOIxOo(context);
    }

    public final void IXxxXO(Exception exc) {
        this.f564I0Io.post(new I0Io(exc));
    }

    public final void Oxx0xo(String str) {
        this.f564I0Io.post(new II0xO0(str));
    }

    public final void OxxIIOOXO(ServiceConnection serviceConnection) {
        try {
            Context context = this.f566II0xO0;
            if (context != null && serviceConnection != null) {
                context.unbindService(serviceConnection);
            }
        } catch (Exception unused) {
        }
    }

    public final void oI0IIXIo() {
        try {
            if (this.f567Oxx0IOOO == null) {
                this.f567Oxx0IOOO = new oxoX();
            }
            OxxIIOOXO(this.f567Oxx0IOOO);
            oOoXoXO(this.f566II0xO0);
        } catch (Exception e) {
            Log.e(this.f570oIX0oI, "bind service exception: " + e.getMessage());
            xo.xxIXOIIO.II0xO0(e);
            IXxxXO(new OAIDException(e));
        }
    }

    @Override // xo.Oxx0IOOO
    public void oIX0oI(xo.XO xo2) {
        if (this.f566II0xO0 != null && xo2 != null) {
            this.f569XO = xo2;
            Executors.newSingleThreadExecutor().execute(new oIX0oI());
        }
    }

    public final void oOoXoXO(Context context) {
        Intent intent = new Intent();
        intent.setAction(this.f568X0o0xo);
        intent.setPackage(this.f571oxoX);
        oxoX oxox = this.f567Oxx0IOOO;
        if (oxox != null) {
            boolean bindService = context.bindService(intent, oxox, 1);
            Log.e(this.f570oIX0oI, "bind service failed: " + bindService);
        }
    }

    public final boolean x0XOIxOo(Context context) {
        List<ResolveInfo> list;
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(this.f568X0o0xo);
        intent.setPackage(this.f571oxoX);
        if (packageManager != null) {
            list = packageManager.queryIntentServices(intent, 0);
        } else {
            list = null;
        }
        if (list == null) {
            return false;
        }
        return !list.isEmpty();
    }

    /* loaded from: classes13.dex */
    public class X0o0xo extends oIX0oI.II0xO0 {
        public X0o0xo() {
        }

        @Override // xOoOIoI.oIX0oI
        public void II0xO0(int i, Bundle bundle) throws RemoteException {
            Log.d("OAIDCallBack", "OAIDCallBack handleResult retCode=" + i + " retInfo=" + bundle);
            if (i == 0 && bundle != null) {
                Oxx0IOOO.this.Oxx0xo(bundle.getString(Oxo00O.oIX0oI.f3009II0xO0));
            }
        }

        @Override // xOoOIoI.oIX0oI
        public void oIX0oI(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
        }
    }

    /* loaded from: classes13.dex */
    public class XO extends oIX0oI.II0xO0 {
        public XO() {
        }

        @Override // xOoOIoI.oIX0oI
        public void II0xO0(int i, Bundle bundle) throws RemoteException {
            Log.d("OAIDLimitCallback", "OAIDCallBack handleResult retCode=" + i + " retInfo=" + bundle);
            if (i == 0 && bundle != null) {
                if (bundle.getBoolean(Oxo00O.oIX0oI.f3008I0Io)) {
                    Oxx0IOOO.this.IXxxXO(new OAIDException("用户启用了oaid限制获取开关"));
                    Oxx0IOOO oxx0IOOO = Oxx0IOOO.this;
                    oxx0IOOO.OxxIIOOXO(oxx0IOOO.f567Oxx0IOOO);
                    return;
                }
                Log.i("OAIDLimitCallback", "OAIDLimitCallback handleResult success");
            }
        }

        @Override // xOoOIoI.oIX0oI
        public void oIX0oI(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
        }
    }
}
