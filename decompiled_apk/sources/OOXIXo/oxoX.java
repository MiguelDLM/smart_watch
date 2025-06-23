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

/* loaded from: classes.dex */
public class oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static volatile oxoX f1759II0XooXoX;

    /* renamed from: I0Io, reason: collision with root package name */
    public List<WeakReference<OOXIXo.II0xO0>> f1760I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public LocationManager f1761II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @SuppressLint({"NewApi"})
    public GnssStatus.Callback f1762Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f1763X0o0xo = false;

    /* renamed from: XO, reason: collision with root package name */
    public GpsStatus.Listener f1764XO = new II0xO0();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Context f1765oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public List<X0o0xo> f1766oxoX;

    /* loaded from: classes.dex */
    public class II0xO0 implements GpsStatus.Listener {
        public II0xO0() {
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            GpsStatus gpsStatus;
            if (oxoX.this.f1760I0Io != null && oxoX.this.f1760I0Io.size() != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4 || ContextCompat.checkSelfPermission(oxoX.this.f1765oIX0oI, g.g) != 0) {
                                return;
                            }
                            synchronized (this) {
                                try {
                                    gpsStatus = null;
                                    if (oxoX.this.f1761II0xO0 != null) {
                                        gpsStatus = oxoX.this.f1761II0xO0.getGpsStatus(null);
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            if (gpsStatus != null) {
                                int maxSatellites = gpsStatus.getMaxSatellites();
                                Iterator<GpsSatellite> it = gpsStatus.getSatellites().iterator();
                                oxoX.this.f1766oxoX = new ArrayList();
                                int i2 = 0;
                                int i3 = 0;
                                while (it.hasNext() && i2 <= maxSatellites) {
                                    GpsSatellite next = it.next();
                                    i2++;
                                    if (next.usedInFix()) {
                                        i3++;
                                    }
                                    if (next.getSnr() > 0.0f) {
                                        oxoX.this.f1766oxoX.add(new X0o0xo(next));
                                    }
                                }
                                Collections.sort(oxoX.this.f1766oxoX);
                                for (WeakReference weakReference : oxoX.this.f1760I0Io) {
                                    if (weakReference.get() != null) {
                                        ((OOXIXo.II0xO0) weakReference.get()).oIX0oI(i3, i2);
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        for (WeakReference weakReference2 : oxoX.this.f1760I0Io) {
                            if (weakReference2.get() != null) {
                                ((OOXIXo.II0xO0) weakReference2.get()).II0xO0();
                            }
                        }
                        return;
                    }
                    for (WeakReference weakReference3 : oxoX.this.f1760I0Io) {
                        if (weakReference3.get() != null) {
                            ((OOXIXo.II0xO0) weakReference3.get()).onStop();
                        }
                    }
                    return;
                }
                for (WeakReference weakReference4 : oxoX.this.f1760I0Io) {
                    if (weakReference4.get() != null) {
                        ((OOXIXo.II0xO0) weakReference4.get()).onStart();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI extends GnssStatus.Callback {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ Object f1769II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final GpsStatus.Listener f1770oIX0oI;

        public oIX0oI(Object obj) {
            this.f1769II0xO0 = obj;
            this.f1770oIX0oI = (GpsStatus.Listener) obj;
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
            this.f1770oIX0oI.onGpsStatusChanged(3);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            int satelliteCount;
            boolean usedInFix;
            satelliteCount = gnssStatus.getSatelliteCount();
            int i = 0;
            for (int i2 = 0; i2 < satelliteCount; i2++) {
                usedInFix = gnssStatus.usedInFix(i2);
                if (usedInFix) {
                    i++;
                }
            }
            for (WeakReference weakReference : oxoX.this.f1760I0Io) {
                if (weakReference.get() != null) {
                    ((OOXIXo.II0xO0) weakReference.get()).oIX0oI(i, satelliteCount);
                }
            }
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            this.f1770oIX0oI.onGpsStatusChanged(1);
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            this.f1770oIX0oI.onGpsStatusChanged(2);
        }
    }

    public oxoX(Context context) {
        this.f1765oIX0oI = context;
    }

    public static oxoX xxIXOIIO(Context context) {
        if (f1759II0XooXoX == null) {
            synchronized (oxoX.class) {
                try {
                    if (f1759II0XooXoX == null) {
                        f1759II0XooXoX = new oxoX(context);
                    }
                } finally {
                }
            }
        }
        return f1759II0XooXoX;
    }

    @RequiresApi(api = 24)
    public GnssStatus.Callback II0XooXoX(Object obj) {
        return new oIX0oI(obj);
    }

    public void OOXIXo(Location location) {
        this.f1763X0o0xo = location.getProvider().equals("gps");
        oOoXoXO();
    }

    public final boolean Oxx0IOOO(Context context) {
        if (((LocationManager) context.getSystemService("location")).isProviderEnabled("gps")) {
            return true;
        }
        return false;
    }

    public void XO(OOXIXo.II0xO0 iI0xO0) {
        List<WeakReference<OOXIXo.II0xO0>> list = this.f1760I0Io;
        if (list == null) {
            this.f1760I0Io = new ArrayList();
        } else {
            Iterator<WeakReference<OOXIXo.II0xO0>> it = list.iterator();
            while (it.hasNext()) {
                WeakReference<OOXIXo.II0xO0> next = it.next();
                if (next.get() == null) {
                    it.remove();
                } else if (next.get() == iI0xO0) {
                    return;
                }
            }
        }
        this.f1760I0Io.add(new WeakReference<>(iI0xO0));
    }

    public synchronized void oO() {
        try {
            LocationManager locationManager = this.f1761II0xO0;
            if (locationManager == null) {
                return;
            }
            if (Build.VERSION.SDK_INT < 24) {
                locationManager.removeGpsStatusListener(this.f1764XO);
            }
            this.f1761II0xO0 = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void oOoXoXO() {
        if (this.f1763X0o0xo) {
            for (WeakReference<OOXIXo.II0xO0> weakReference : this.f1760I0Io) {
                if (weakReference.get() != null) {
                    weakReference.get().II0xO0();
                }
            }
            return;
        }
        if (Oxx0IOOO(this.f1765oIX0oI)) {
            for (WeakReference<OOXIXo.II0xO0> weakReference2 : this.f1760I0Io) {
                if (weakReference2.get() != null) {
                    weakReference2.get().I0Io();
                }
            }
            return;
        }
        for (WeakReference<OOXIXo.II0xO0> weakReference3 : this.f1760I0Io) {
            if (weakReference3.get() != null) {
                weakReference3.get().onStop();
            }
        }
    }

    public void ooOOo0oXI() {
        oO();
        if (ContextCompat.checkSelfPermission(this.f1765oIX0oI, g.g) != 0) {
            return;
        }
        LocationManager locationManager = (LocationManager) this.f1765oIX0oI.getSystemService("location");
        this.f1761II0xO0 = locationManager;
        if (Build.VERSION.SDK_INT >= 24) {
            GnssStatus.Callback II0XooXoX2 = II0XooXoX(this.f1764XO);
            this.f1762Oxx0IOOO = II0XooXoX2;
            this.f1761II0xO0.registerGnssStatusCallback(II0XooXoX2);
            return;
        }
        locationManager.addGpsStatusListener(this.f1764XO);
    }

    public void x0XOIxOo(OOXIXo.II0xO0 iI0xO0) {
        List<WeakReference<OOXIXo.II0xO0>> list = this.f1760I0Io;
        if (list == null) {
            return;
        }
        Iterator<WeakReference<OOXIXo.II0xO0>> it = list.iterator();
        while (it.hasNext()) {
            WeakReference<OOXIXo.II0xO0> next = it.next();
            if (next.get() == null || next.get() == iI0xO0) {
                it.remove();
            }
        }
    }

    public List<X0o0xo> xoIox() {
        return this.f1766oxoX;
    }
}
