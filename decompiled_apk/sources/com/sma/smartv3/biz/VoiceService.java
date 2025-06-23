package com.sma.smartv3.biz;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.Utils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.sma.smartv3.biz.voice.RecordingManager;
import java.util.Iterator;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class VoiceService extends Service {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f20238IXxxXO = 1;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f20239Oo = new oIX0oI(null);

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20240Oxx0xo = "ACTION_START";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20241OxxIIOOXO = "ACTION_STOP_RECORDING";

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20242oI0IIXIo = "ACTION_START_RECORDING";

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final X0IIOO f20243XO = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NotificationManager>() { // from class: com.sma.smartv3.biz.VoiceService$notificationManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final NotificationManager invoke() {
            Object systemService = VoiceService.this.getSystemService("notification");
            IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            return (NotificationManager) systemService;
        }
    });

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public final void I0Io() {
            Intent intent = new Intent(Utils.getApp(), (Class<?>) VoiceService.class);
            intent.setAction(VoiceService.f20240Oxx0xo);
            ContextCompat.startForegroundService(Utils.getApp(), intent);
        }

        public final void II0xO0() {
            Intent intent = new Intent(Utils.getApp(), (Class<?>) VoiceService.class);
            intent.setAction(VoiceService.f20242oI0IIXIo);
            ContextCompat.startForegroundService(Utils.getApp(), intent);
        }

        public final boolean oIX0oI(Context context, Class<?> cls) {
            Object systemService = context.getSystemService(TTDownloadField.TT_ACTIVITY);
            IIX0o.x0XOIxOo(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) systemService).getRunningServices(Integer.MAX_VALUE).iterator();
            while (it.hasNext()) {
                if (IIX0o.Oxx0IOOO(cls.getName(), it.next().service.getClassName())) {
                    return true;
                }
            }
            return false;
        }

        public final void oxoX() {
            Intent intent = new Intent(Utils.getApp(), (Class<?>) VoiceService.class);
            intent.setAction(VoiceService.f20241OxxIIOOXO);
            Utils.getApp().startService(intent);
        }

        public oIX0oI() {
        }
    }

    public final void I0Io() {
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                NotificationManager II0xO02 = II0xO0();
                androidx.media2.session.II0XooXoX.oIX0oI();
                II0xO02.createNotificationChannel(androidx.media2.session.Oxx0IOOO.oIX0oI("voice_channel", "Voice Channel", 2));
            }
            if (i >= 30) {
                startForeground(1, oIX0oI(), 128);
            } else {
                startForeground(1, oIX0oI());
            }
        } catch (Exception e) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(" startNotification  intent?.action = " + e);
            e.printStackTrace();
        }
    }

    public final NotificationManager II0xO0() {
        return (NotificationManager) this.f20243XO.getValue();
    }

    public final Notification oIX0oI() {
        Notification.Builder builder = new Notification.Builder(this);
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("voice_channel");
        }
        Notification build = builder.build();
        IIX0o.oO(build, "build(...)");
        return build;
    }

    @Override // android.app.Service
    @OXOo.oOoXoXO
    public IBinder onBind(@OXOo.oOoXoXO Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(@OXOo.oOoXoXO Intent intent, int i, int i2) {
        String str;
        String str2;
        String str3;
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append(" onStartCommand  intent?.action  = ");
        String str4 = null;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        sb.append(str);
        oix0oi.oIX0oI(sb.toString());
        if (intent != null) {
            str2 = intent.getAction();
        } else {
            str2 = null;
        }
        if (IIX0o.Oxx0IOOO(str2, f20240Oxx0xo)) {
            I0Io();
            return 1;
        }
        if (intent != null) {
            str3 = intent.getAction();
        } else {
            str3 = null;
        }
        if (IIX0o.Oxx0IOOO(str3, f20242oI0IIXIo)) {
            I0Io();
            RecordingManager.Companion.getInstance().startRecord();
            return 1;
        }
        if (intent != null) {
            str4 = intent.getAction();
        }
        if (IIX0o.Oxx0IOOO(str4, f20241OxxIIOOXO)) {
            RecordingManager.Companion.getInstance().stopRecording();
            return 1;
        }
        return 1;
    }
}
