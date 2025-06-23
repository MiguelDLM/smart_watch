package OOXIXo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class oxoX {

    /* renamed from: II0XooXoX  reason: collision with root package name */
    public static volatile oxoX f87II0XooXoX;

    /* renamed from: I0Io  reason: collision with root package name */
    public List<WeakReference<II0xO0>> f88I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public LocationManager f89II0xO0;
    @SuppressLint({"NewApi"})

    /* renamed from: Oxx0IOOO  reason: collision with root package name */
    public GnssStatus.Callback f90Oxx0IOOO;

    /* renamed from: X0o0xo  reason: collision with root package name */
    public boolean f91X0o0xo = false;

    /* renamed from: XO  reason: collision with root package name */
    public GpsStatus.Listener f92XO = new II0xO0();

    /* renamed from: oIX0oI  reason: collision with root package name */
    public Context f93oIX0oI;

    /* renamed from: oxoX  reason: collision with root package name */
    public List<X0o0xo> f94oxoX;

    public class II0xO0 implements GpsStatus.Listener {
        public II0xO0() {
        }

        public void onGpsStatusChanged(int i) {
            GpsStatus gpsStatus;
            if (oxoX.this.f88I0Io != null && oxoX.this.f88I0Io.size() != 0) {
                if (i == 1) {
                    for (WeakReference weakReference : oxoX.this.f88I0Io) {
                        if (weakReference.get() != null) {
                            ((II0xO0) weakReference.get()).onStart();
                        }
                    }
                } else if (i == 2) {
                    for (WeakReference weakReference2 : oxoX.this.f88I0Io) {
                        if (weakReference2.get() != null) {
                            ((II0xO0) weakReference2.get()).onStop();
                        }
                    }
                } else if (i == 3) {
                    for (WeakReference weakReference3 : oxoX.this.f88I0Io) {
                        if (weakReference3.get() != null) {
                            ((II0xO0) weakReference3.get()).II0xO0();
                        }
                    }
                } else if (i == 4 && ContextCompat.checkSelfPermission(oxoX.this.f93oIX0oI, g.g) == 0) {
                    synchronized (this) {
                        try {
                            gpsStatus = null;
                            if (oxoX.this.f89II0xO0 != null) {
                                gpsStatus = oxoX.this.f89II0xO0.getGpsStatus((GpsStatus) null);
                            }
                        } catch (Throwable th) {
                            while (true) {
                                throw th;
                            }
                        }
                    }
                    if (gpsStatus != null) {
                        int maxSatellites = gpsStatus.getMaxSatellites();
                        Iterator<GpsSatellite> it = gpsStatus.getSatellites().iterator();
                        List unused = oxoX.this.f94oxoX = new ArrayList();
                        int i2 = 0;
                        int i3 = 0;
                        while (it.hasNext() && i2 <= maxSatellites) {
                            GpsSatellite next = it.next();
                            i2++;
                            if (next.usedInFix()) {
                                i3++;
                            }
                            if (next.getSnr() > 0.0f) {
                                oxoX.this.f94oxoX.add(new X0o0xo(next));
                            }
                        }
                        Collections.sort(oxoX.this.f94oxoX);
                        for (WeakReference weakReference4 : oxoX.this.f88I0Io) {
                            if (weakReference4.get() != null) {
                                ((II0xO0) weakReference4.get()).oIX0oI(i3, i2);
                            }
                        }
                    }
                }
            }
        }
    }

    public class oIX0oI extends GnssStatus.Callback {

        /* renamed from: II0xO0  reason: collision with root package name */
        public final /* synthetic */ Object f97II0xO0;

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final GpsStatus.Listener f98oIX0oI;

        public oIX0oI(Object obj) {
            this.f97II0xO0 = obj;
            this.f98oIX0oI = (GpsStatus.Listener) obj;
        }

        public void onFirstFix(int i) {
            this.f98oIX0oI.onGpsStatusChanged(3);
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            int oIX0oI2 = gnssStatus.getSatelliteCount();
            int i = 0;
            for (int i2 = 0; i2 < oIX0oI2; i2++) {
                if (gnssStatus.usedInFix(i2)) {
                    i++;
                }
            }
            for (WeakReference weakReference : oxoX.this.f88I0Io) {
                if (weakReference.get() != null) {
                    ((II0xO0) weakReference.get()).oIX0oI(i, oIX0oI2);
                }
            }
        }

        public void onStarted() {
            this.f98oIX0oI.onGpsStatusChanged(1);
        }

        public void onStopped() {
            this.f98oIX0oI.onGpsStatusChanged(2);
        }
    }

    public oxoX(Context context) {
        this.f93oIX0oI = context;
    }

    public static oxoX xxIXOIIO(Context context) {
        if (f87II0XooXoX == null) {
            synchronized (oxoX.class) {
                try {
                    if (f87II0XooXoX == null) {
                        f87II0XooXoX = new oxoX(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f87II0XooXoX;
    }

    @RequiresApi(api = 24)
    public GnssStatus.Callback II0XooXoX(Object obj) {
        return new oIX0oI(obj);
    }

    public void OOXIXo(Location location) {
        this.f91X0o0xo = location.getProvider().equals("gps");
        oOoXoXO();
    }

    public final boolean Oxx0IOOO(Context context) {
        if (((LocationManager) context.getSystemService("location")).isProviderEnabled("gps")) {
            return true;
        }
        return false;
    }

    public void XO(II0xO0 iI0xO0) {
        List<WeakReference<II0xO0>> list = this.f88I0Io;
        if (list == null) {
            this.f88I0Io = new ArrayList();
        } else {
            Iterator<WeakReference<II0xO0>> it = list.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                if (next.get() == null) {
                    it.remove();
                } else if (next.get() == iI0xO0) {
                    return;
                }
            }
        }
        this.f88I0Io.add(new WeakReference(iI0xO0));
    }

    public synchronized void oO() {
        try {
            LocationManager locationManager = this.f89II0xO0;
            if (locationManager != null) {
                if (Build.VERSION.SDK_INT < 24) {
                    locationManager.removeGpsStatusListener(this.f92XO);
                }
                this.f89II0xO0 = null;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public void oOoXoXO() {
        if (this.f91X0o0xo) {
            for (WeakReference next : this.f88I0Io) {
                if (next.get() != null) {
                    ((II0xO0) next.get()).II0xO0();
                }
            }
        } else if (Oxx0IOOO(this.f93oIX0oI)) {
            for (WeakReference next2 : this.f88I0Io) {
                if (next2.get() != null) {
                    ((II0xO0) next2.get()).I0Io();
                }
            }
        } else {
            for (WeakReference next3 : this.f88I0Io) {
                if (next3.get() != null) {
                    ((II0xO0) next3.get()).onStop();
                }
            }
        }
    }

    public void ooOOo0oXI() {
        oO();
        if (ContextCompat.checkSelfPermission(this.f93oIX0oI, g.g) == 0) {
            LocationManager locationManager = (LocationManager) this.f93oIX0oI.getSystemService("location");
            this.f89II0xO0 = locationManager;
            if (Build.VERSION.SDK_INT >= 24) {
                GnssStatus.Callback II0XooXoX2 = II0XooXoX(this.f92XO);
                this.f90Oxx0IOOO = II0XooXoX2;
                boolean unused = this.f89II0xO0.registerGnssStatusCallback(II0XooXoX2);
                return;
            }
            locationManager.addGpsStatusListener(this.f92XO);
        }
    }

    public void x0XOIxOo(II0xO0 iI0xO0) {
        List<WeakReference<II0xO0>> list = this.f88I0Io;
        if (list != null) {
            Iterator<WeakReference<II0xO0>> it = list.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                if (next.get() == null || next.get() == iI0xO0) {
                    it.remove();
                }
            }
        }
    }

    public List<X0o0xo> xoIox() {
        return this.f94oxoX;
    }
}
