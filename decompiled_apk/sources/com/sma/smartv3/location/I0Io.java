package com.sma.smartv3.location;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Application;
import android.content.Context;
import android.os.Looper;
import androidx.core.app.NotificationManagerCompat;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.sma.smartv3.app.ProjectManager;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class I0Io {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f20943Oxx0IOOO = new oIX0oI(null);

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public final FusedLocationProviderClient f20944I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public final String f20945II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @oOoXoXO
    public LocationRequest f20946X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @oOoXoXO
    public XO f20947XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final Context f20948oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public final NotificationManagerCompat f20949oxoX;

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final I0Io oIX0oI(@OOXIXo XO callback) {
            IIX0o.x0xO0oo(callback, "callback");
            Application app = Utils.getApp();
            IIX0o.oO(app, "getApp(...)");
            I0Io i0Io = new I0Io(app, "Google Client");
            LocationRequest create = LocationRequest.create();
            create.setInterval(ProjectManager.f19822oIX0oI.O0xOxO());
            create.setFastestInterval(5000L);
            create.setPriority(100);
            IIX0o.oO(create, "apply(...)");
            i0Io.II0xO0(create, callback);
            return i0Io;
        }

        public oIX0oI() {
        }
    }

    public I0Io(@OOXIXo Context mContext, @OOXIXo String mTag) {
        IIX0o.x0xO0oo(mContext, "mContext");
        IIX0o.x0xO0oo(mTag, "mTag");
        this.f20948oIX0oI = mContext;
        this.f20945II0xO0 = mTag;
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(mContext);
        IIX0o.oO(fusedLocationProviderClient, "getFusedLocationProviderClient(...)");
        this.f20944I0Io = fusedLocationProviderClient;
        NotificationManagerCompat from = NotificationManagerCompat.from(Utils.getApp());
        IIX0o.oO(from, "from(...)");
        this.f20949oxoX = from;
    }

    public static /* synthetic */ void XO(I0Io i0Io, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        i0Io.X0o0xo(z);
    }

    public static /* synthetic */ void oxoX(I0Io i0Io, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        i0Io.I0Io(i, z);
    }

    public final void I0Io(int i, boolean z) {
        LogUtils.v("LocationClient " + this.f20945II0xO0 + " -> startLocation " + z);
        if (z) {
            this.f20949oxoX.notify(1, X0o0xo.I0Io(i).build());
        }
        try {
            FusedLocationProviderClient fusedLocationProviderClient = this.f20944I0Io;
            LocationRequest locationRequest = this.f20946X0o0xo;
            IIX0o.ooOOo0oXI(locationRequest);
            XO xo2 = this.f20947XO;
            IIX0o.ooOOo0oXI(xo2);
            fusedLocationProviderClient.requestLocationUpdates(locationRequest, xo2, Looper.getMainLooper());
        } catch (SecurityException e) {
            LogUtils.e("Exception: %s", e.getMessage(), e);
        }
    }

    public final void II0xO0(@OOXIXo LocationRequest request, @OOXIXo XO callback) {
        IIX0o.x0xO0oo(request, "request");
        IIX0o.x0xO0oo(callback, "callback");
        this.f20946X0o0xo = request;
        this.f20947XO = callback;
    }

    public final void X0o0xo(boolean z) {
        LogUtils.v("LocationClient " + this.f20945II0xO0 + " -> stopLocation");
        if (z) {
            this.f20949oxoX.cancel(1);
        }
        FusedLocationProviderClient fusedLocationProviderClient = this.f20944I0Io;
        XO xo2 = this.f20947XO;
        IIX0o.ooOOo0oXI(xo2);
        fusedLocationProviderClient.removeLocationUpdates(xo2);
    }

    @OOXIXo
    public final Context oIX0oI() {
        return this.f20948oIX0oI;
    }
}
