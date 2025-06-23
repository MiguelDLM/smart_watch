package com.sma.smartv3.location;

import OXOo.OOXIXo;
import android.app.PendingIntent;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.IntentUtils;
import com.blankj.utilcode.util.Utils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.IIXOooo;
import com.sma.smartv3.location.BaiDuLocationClient;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class X0o0xo {

    /* loaded from: classes12.dex */
    public static final class I0Io extends Oxx0IOOO {

        /* renamed from: oIX0oI */
        public final /* synthetic */ com.sma.smartv3.location.oxoX f20950oIX0oI;

        public I0Io(com.sma.smartv3.location.oxoX oxox) {
            this.f20950oIX0oI = oxox;
        }

        @Override // com.sma.smartv3.location.Oxx0IOOO
        public void II0xO0(@OOXIXo com.sma.smartv3.location.oIX0oI location) {
            IIX0o.x0xO0oo(location, "location");
            this.f20950oIX0oI.X0o0xo(location);
        }

        @Override // com.sma.smartv3.location.Oxx0IOOO
        public void oIX0oI(@OOXIXo String message) {
            IIX0o.x0xO0oo(message, "message");
        }
    }

    /* loaded from: classes12.dex */
    public static final class II0xO0 extends XO {

        /* renamed from: oIX0oI */
        public final /* synthetic */ com.sma.smartv3.location.II0xO0 f20951oIX0oI;

        public II0xO0(com.sma.smartv3.location.II0xO0 iI0xO0) {
            this.f20951oIX0oI = iI0xO0;
        }

        @Override // com.sma.smartv3.location.XO
        public void II0xO0(@OOXIXo com.sma.smartv3.location.oIX0oI location) {
            IIX0o.x0xO0oo(location, "location");
            this.f20951oIX0oI.oIX0oI(location);
        }

        @Override // com.sma.smartv3.location.XO
        public void oIX0oI(@OOXIXo String message) {
            IIX0o.x0xO0oo(message, "message");
            this.f20951oIX0oI.onError(message);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends Oxx0IOOO {

        /* renamed from: oIX0oI */
        public final /* synthetic */ com.sma.smartv3.location.II0xO0 f20952oIX0oI;

        public oIX0oI(com.sma.smartv3.location.II0xO0 iI0xO0) {
            this.f20952oIX0oI = iI0xO0;
        }

        @Override // com.sma.smartv3.location.Oxx0IOOO
        public void II0xO0(@OOXIXo com.sma.smartv3.location.oIX0oI location) {
            IIX0o.x0xO0oo(location, "location");
            this.f20952oIX0oI.oIX0oI(location);
        }

        @Override // com.sma.smartv3.location.Oxx0IOOO
        public void oIX0oI(@OOXIXo String message) {
            IIX0o.x0xO0oo(message, "message");
            this.f20952oIX0oI.onError(message);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oxoX extends XO {

        /* renamed from: oIX0oI */
        public final /* synthetic */ com.sma.smartv3.location.oxoX f20953oIX0oI;

        public oxoX(com.sma.smartv3.location.oxoX oxox) {
            this.f20953oIX0oI = oxox;
        }

        @Override // com.sma.smartv3.location.XO
        public void II0xO0(@OOXIXo com.sma.smartv3.location.oIX0oI location) {
            IIX0o.x0xO0oo(location, "location");
            this.f20953oIX0oI.X0o0xo(location);
        }

        @Override // com.sma.smartv3.location.XO
        public void oIX0oI(@OOXIXo String message) {
            IIX0o.x0xO0oo(message, "message");
        }
    }

    @OOXIXo
    public static final NotificationCompat.Builder I0Io(int i) {
        NotificationCompat.Builder priority = new NotificationCompat.Builder(Utils.getApp(), IIXOooo.f20833Oo).setSmallIcon(R.mipmap.ic_launcher).setContentTitle(Utils.getApp().getString(R.string.get_your_location)).setContentText(Utils.getApp().getString(i)).setContentIntent(PendingIntent.getActivity(Utils.getApp(), 0, IntentUtils.getLaunchAppIntent(Utils.getApp().getPackageName()), 67108864)).setOngoing(true).setWhen(System.currentTimeMillis()).setPriority(-1);
        IIX0o.oO(priority, "setPriority(...)");
        return priority;
    }

    public static /* synthetic */ com.sma.smartv3.location.oxoX II0xO0(com.sma.smartv3.location.II0xO0 iI0xO0, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return oIX0oI(iI0xO0, z);
    }

    @OOXIXo
    public static final com.sma.smartv3.location.oxoX oIX0oI(@OOXIXo com.sma.smartv3.location.II0xO0 listener, boolean z) {
        IIX0o.x0xO0oo(listener, "listener");
        com.sma.smartv3.location.oxoX oxox = new com.sma.smartv3.location.oxoX(null, null, 3, null);
        if (Xo0.f24349oIX0oI.oIX0oI().getBoolean(XoI0Ixx0.f24367IXxxXO)) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("client BaiDu Location client");
            oxox.I0Io(BaiDuLocationClient.f20938X0o0xo.oIX0oI(new oIX0oI(listener), z));
        } else {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("client Google Location client");
            oxox.oxoX(com.sma.smartv3.location.I0Io.f20943Oxx0IOOO.oIX0oI(new II0xO0(listener)));
        }
        return oxox;
    }

    @OOXIXo
    public static final com.sma.smartv3.location.oxoX oxoX() {
        com.sma.smartv3.location.oxoX oxox = new com.sma.smartv3.location.oxoX(null, null, 3, null);
        if (Xo0.f24349oIX0oI.oIX0oI().getBoolean(XoI0Ixx0.f24367IXxxXO)) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("sportRunClientByBle BaiDu Location client");
            oxox.I0Io(BaiDuLocationClient.oIX0oI.II0xO0(BaiDuLocationClient.f20938X0o0xo, new I0Io(oxox), false, 2, null));
        } else {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("sportRunClientByBle Google Location client");
            oxox.oxoX(com.sma.smartv3.location.I0Io.f20943Oxx0IOOO.oIX0oI(new oxoX(oxox)));
        }
        return oxox;
    }
}
