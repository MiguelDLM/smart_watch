package x0OxxIOxX;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.kuaishou.weapon.p0.g;
import com.octopus.ad.internal.utilities.HttpErrorCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import x0.ooXIXxIX;
import x0.xI;

/* loaded from: classes11.dex */
public class oxoX {

    /* renamed from: oxoX, reason: collision with root package name */
    public static oxoX f33950oxoX;

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f33951I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Timer f33952II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public ArrayList<II0xO0> f33953oIX0oI = new ArrayList<>();

    /* loaded from: classes11.dex */
    public class II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f33955II0xO0 = 0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public String f33956oIX0oI;

        public II0xO0(String str) {
            this.f33956oIX0oI = str;
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI extends TimerTask {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ WeakReference f33958XO;

        /* renamed from: x0OxxIOxX.oxoX$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C1147oIX0oI extends ooXIXxIX {

            /* renamed from: I0Io, reason: collision with root package name */
            public final /* synthetic */ II0xO0 f33959I0Io;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1147oIX0oI(boolean z, II0xO0 iI0xO0) {
                super(z);
                this.f33959I0Io = iI0xO0;
            }

            @Override // x0.ooXIXxIX
            public void II0XooXoX(xI xIVar) {
                if (xIVar == null || (!xIVar.X0o0xo() && xIVar.oIX0oI() == HttpErrorCode.CONNECTION_FAILURE)) {
                    this.f33959I0Io.f33955II0xO0++;
                    oxoX.this.f33953oIX0oI.add(this.f33959I0Io);
                }
            }

            @Override // x0.ooXIXxIX
            public String Oxx0IOOO() {
                return this.f33959I0Io.f33956oIX0oI;
            }
        }

        public oIX0oI(WeakReference weakReference) {
            this.f33958XO = weakReference;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Context context = (Context) this.f33958XO.get();
            if (context == null) {
                oxoX.this.I0Io();
                return;
            }
            while (!oxoX.this.f33953oIX0oI.isEmpty() && oxoX.this.XO(context)) {
                II0xO0 iI0xO0 = (II0xO0) oxoX.this.f33953oIX0oI.remove(0);
                if (iI0xO0.f33955II0xO0 < 3) {
                    new C1147oIX0oI(false, iI0xO0).XO();
                }
            }
            if (oxoX.this.f33953oIX0oI.isEmpty()) {
                oxoX.this.I0Io();
            }
        }
    }

    public oxoX(Context context) {
        boolean z;
        if (context != null) {
            if (context.getPackageManager().checkPermission(g.b, context.getPackageName()) == 0) {
                z = true;
            } else {
                z = false;
            }
            this.f33951I0Io = z;
        }
    }

    public static oxoX II0xO0(Context context) {
        if (f33950oxoX == null) {
            f33950oxoX = new oxoX(context);
        }
        return f33950oxoX;
    }

    public final void I0Io() {
        Timer timer = this.f33952II0xO0;
        if (timer != null) {
            timer.cancel();
            this.f33952II0xO0 = null;
        }
    }

    public final void Oxx0IOOO(Context context) {
        if (this.f33952II0xO0 == null) {
            WeakReference weakReference = new WeakReference(context);
            Timer timer = new Timer();
            this.f33952II0xO0 = timer;
            timer.scheduleAtFixedRate(new oIX0oI(weakReference), 10000L, 10000L);
        }
    }

    public boolean XO(Context context) {
        NetworkInfo networkInfo;
        if (!this.f33951I0Io) {
            return true;
        }
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } else {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public synchronized void oxoX(String str, Context context) {
        this.f33953oIX0oI.add(new II0xO0(str));
        Oxx0IOOO(context);
    }
}
