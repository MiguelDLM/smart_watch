package com.sma.smartv3.initializer;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import com.sma.smartv3.biz.SmaNotification;
import com.sma.smartv3.co_fit.R;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class IIXOooo implements com.bestmafen.androidbase.base.II0xO0 {

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20833Oo = "Location Notification Channel";

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final IIXOooo f20834XO = new IIXOooo();

    @Override // com.bestmafen.androidbase.base.II0xO0
    public void oIX0oI(@OXOo.OOXIXo Application app) {
        IIX0o.x0xO0oo(app, "app");
        if (Build.VERSION.SDK_INT >= 26) {
            String string = app.getString(R.string.location_notification);
            IIX0o.oO(string, "getString(...)");
            String string2 = app.getString(R.string.location_notification_description);
            IIX0o.oO(string2, "getString(...)");
            androidx.media2.session.II0XooXoX.oIX0oI();
            NotificationChannel oIX0oI2 = androidx.media2.session.Oxx0IOOO.oIX0oI(f20833Oo, string, 2);
            oIX0oI2.setDescription(string2);
            Object systemService = app.getSystemService("notification");
            IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).createNotificationChannel(oIX0oI2);
        }
        SmaNotification.f20192Oxx0IOOO.oIX0oI().XO(app);
    }
}
