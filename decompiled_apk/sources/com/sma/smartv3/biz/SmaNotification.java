package com.sma.smartv3.biz;

import XO0OX.x0XOIxOo;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.ServiceCompat;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.IntentUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ServiceUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.co_fit.R;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;
import kotlin.random.Random;

/* loaded from: classes12.dex */
public final class SmaNotification {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f20193I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f20194II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public RemoteViews f20195X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public NotificationManagerCompat f20196XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Application f20197oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f20198oxoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f20192Oxx0IOOO = new oIX0oI(null);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final X0IIOO<SmaNotification> f20191II0XooXoX = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SmaNotification>() { // from class: com.sma.smartv3.biz.SmaNotification$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final SmaNotification invoke() {
            return new SmaNotification(null);
        }
    });

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        public static /* synthetic */ void II0xO0() {
        }

        @OXOo.OOXIXo
        public final SmaNotification oIX0oI() {
            return (SmaNotification) SmaNotification.f20191II0XooXoX.getValue();
        }

        public oIX0oI() {
        }
    }

    public /* synthetic */ SmaNotification(IIXOooo iIXOooo) {
        this();
    }

    @OXOo.OOXIXo
    public static final SmaNotification II0xO0() {
        return f20192Oxx0IOOO.oIX0oI();
    }

    public static /* synthetic */ Notification oxoX(SmaNotification smaNotification, String str, Bitmap bitmap, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            bitmap = null;
        }
        return smaNotification.I0Io(str, bitmap);
    }

    public final Notification I0Io(String str, Bitmap bitmap) {
        Application application = this.f20197oIX0oI;
        NotificationManagerCompat notificationManagerCompat = null;
        if (application == null) {
            IIX0o.XOxIOxOx("mApp");
            application = null;
        }
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(application, this.f20193I0Io).setSmallIcon(R.mipmap.ic_launcher);
        Application application2 = this.f20197oIX0oI;
        if (application2 == null) {
            IIX0o.XOxIOxOx("mApp");
            application2 = null;
        }
        Application application3 = this.f20197oIX0oI;
        if (application3 == null) {
            IIX0o.XOxIOxOx("mApp");
            application3 = null;
        }
        NotificationCompat.Builder priority = smallIcon.setContentIntent(PendingIntent.getActivity(application2, 0, IntentUtils.getLaunchAppIntent(application3.getPackageName()), 67108864)).setAutoCancel(false).setOngoing(true).setSound(null).setVibrate(null).setLights(0, 0, 0).setVisibility(-1).setPriority(-2);
        RemoteViews remoteViews = this.f20195X0o0xo;
        if (remoteViews != null) {
            priority.setContent(remoteViews);
        }
        if (str != null) {
            Application application4 = this.f20197oIX0oI;
            if (application4 == null) {
                IIX0o.XOxIOxOx("mApp");
                application4 = null;
            }
            priority.setContentTitle(application4.getString(R.string.app_name));
            priority.setContentText(str);
        }
        if (bitmap != null) {
            priority.setLargeIcon(bitmap);
        }
        Notification build = priority.build();
        IIX0o.oO(build, "build(...)");
        if (Build.VERSION.SDK_INT >= 26) {
            androidx.media2.session.II0XooXoX.oIX0oI();
            NotificationChannel oIX0oI2 = androidx.media2.session.Oxx0IOOO.oIX0oI(this.f20193I0Io, this.f20198oxoX, 2);
            NotificationManagerCompat notificationManagerCompat2 = this.f20196XO;
            if (notificationManagerCompat2 == null) {
                IIX0o.XOxIOxOx("mManagerCompat");
            } else {
                notificationManagerCompat = notificationManagerCompat2;
            }
            notificationManagerCompat.createNotificationChannel(oIX0oI2);
        }
        return build;
    }

    public final void II0XooXoX() {
        if (ServiceUtils.isServiceRunning((Class<?>) LocalService.class)) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("SmaNotification startService isServiceRunning");
            return;
        }
        Application application = this.f20197oIX0oI;
        Application application2 = null;
        if (application == null) {
            IIX0o.XOxIOxOx("mApp");
            application = null;
        }
        Intent intent = new Intent(application, (Class<?>) LocalService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            Application application3 = this.f20197oIX0oI;
            if (application3 == null) {
                IIX0o.XOxIOxOx("mApp");
            } else {
                application2 = application3;
            }
            application2.startForegroundService(intent);
            return;
        }
        Application application4 = this.f20197oIX0oI;
        if (application4 == null) {
            IIX0o.XOxIOxOx("mApp");
        } else {
            application2 = application4;
        }
        application2.startService(intent);
    }

    public final void OOXIXo(@OXOo.OOXIXo String text, @OXOo.OOXIXo Bitmap largeIcon) {
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(largeIcon, "largeIcon");
        if (!ServiceUtils.isServiceRunning((Class<?>) LocalService.class)) {
            return;
        }
        NotificationManagerCompat notificationManagerCompat = this.f20196XO;
        if (notificationManagerCompat == null) {
            IIX0o.XOxIOxOx("mManagerCompat");
            notificationManagerCompat = null;
        }
        notificationManagerCompat.notify(this.f20194II0xO0, I0Io(text, largeIcon));
    }

    public final void Oxx0IOOO(@OXOo.OOXIXo Service service) {
        IIX0o.x0xO0oo(service, "service");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("showNotification");
        NotificationManagerCompat notificationManagerCompat = null;
        try {
            Notification oxoX2 = oxoX(this, null, null, 3, null);
            NotificationManagerCompat notificationManagerCompat2 = this.f20196XO;
            if (notificationManagerCompat2 == null) {
                IIX0o.XOxIOxOx("mManagerCompat");
            } else {
                notificationManagerCompat = notificationManagerCompat2;
            }
            notificationManagerCompat.notify(this.f20194II0xO0, oxoX2);
            if (Build.VERSION.SDK_INT >= 34) {
                ServiceCompat.startForeground(service, this.f20194II0xO0, oxoX2, 8);
            } else {
                service.startForeground(this.f20194II0xO0, oxoX2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void X0o0xo(@OXOo.OOXIXo Service service) {
        IIX0o.x0xO0oo(service, "service");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("hideNotification");
        NotificationManagerCompat notificationManagerCompat = null;
        try {
            Notification oxoX2 = oxoX(this, null, null, 3, null);
            NotificationManagerCompat notificationManagerCompat2 = this.f20196XO;
            if (notificationManagerCompat2 == null) {
                IIX0o.XOxIOxOx("mManagerCompat");
            } else {
                notificationManagerCompat = notificationManagerCompat2;
            }
            notificationManagerCompat.cancel(this.f20194II0xO0);
            if (Build.VERSION.SDK_INT >= 34) {
                ServiceCompat.startForeground(service, this.f20194II0xO0, oxoX2, 8);
            } else {
                service.startForeground(this.f20194II0xO0, oxoX2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void XO(@OXOo.OOXIXo Application app) {
        IIX0o.x0xO0oo(app, "app");
        this.f20197oIX0oI = app;
        if (app == null) {
            IIX0o.XOxIOxOx("mApp");
            app = null;
        }
        NotificationManagerCompat from = NotificationManagerCompat.from(app);
        IIX0o.oO(from, "from(...)");
        this.f20196XO = from;
    }

    public final void oOoXoXO(int i, int i2) {
        LogUtils.d("updateSportData -> " + ServiceUtils.isServiceRunning((Class<?>) LocalService.class));
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(TokenParser.SP);
        Application application = this.f20197oIX0oI;
        Application application2 = null;
        if (application == null) {
            IIX0o.XOxIOxOx("mApp");
            application = null;
        }
        sb.append(application.getString(R.string.steps));
        sb.append("  ");
        sb.append(i2);
        sb.append(TokenParser.SP);
        Application application3 = this.f20197oIX0oI;
        if (application3 == null) {
            IIX0o.XOxIOxOx("mApp");
        } else {
            application2 = application3;
        }
        sb.append(application2.getString(R.string.calories));
        String sb2 = sb.toString();
        com.sma.smartv3.view.oxoX oIX0oI2 = com.sma.smartv3.view.oxoX.f25482xxIXOIIO.oIX0oI(i / BleCache.getInt$default(BleCache.INSTANCE, BleKey.STEP_GOAL, 0, null, 6, null), 200, 200);
        oIX0oI2.II0xO0(oIX0oI2.getBounds().width() / 8);
        oIX0oI2.XO(oIX0oI2.getBounds().width() / 4);
        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        OOXIXo(sb2, oIX0oI2.Oxx0IOOO());
    }

    public final void xoIox(@OXOo.OOXIXo RemoteViews remoteViews) {
        IIX0o.x0xO0oo(remoteViews, "remoteViews");
        if (!ServiceUtils.isServiceRunning((Class<?>) LocalService.class)) {
            return;
        }
        this.f20195X0o0xo = remoteViews;
        NotificationManagerCompat notificationManagerCompat = this.f20196XO;
        if (notificationManagerCompat == null) {
            IIX0o.XOxIOxOx("mManagerCompat");
            notificationManagerCompat = null;
        }
        notificationManagerCompat.notify(this.f20194II0xO0, oxoX(this, null, null, 3, null));
    }

    public final void xxIXOIIO() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("stopService LocalService");
        Application application = this.f20197oIX0oI;
        Application application2 = null;
        if (application == null) {
            IIX0o.XOxIOxOx("mApp");
            application = null;
        }
        Application application3 = this.f20197oIX0oI;
        if (application3 == null) {
            IIX0o.XOxIOxOx("mApp");
        } else {
            application2 = application3;
        }
        application.stopService(new Intent(application2, (Class<?>) LocalService.class));
    }

    public SmaNotification() {
        this.f20194II0xO0 = X0.IIXOooo.xXoOI00O(new X0.oOoXoXO(100, Integer.MAX_VALUE), Random.Default);
        this.f20193I0Io = oX0I0O.oIX0oI.f32082II0xO0;
        String appName = AppUtils.getAppName();
        IIX0o.oO(appName, "getAppName(...)");
        this.f20198oxoX = appName;
    }
}
