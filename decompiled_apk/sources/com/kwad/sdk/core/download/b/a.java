package com.kwad.sdk.core.download.b;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media2.session.II0XooXoX;
import androidx.media2.session.Oxx0IOOO;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.at;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes11.dex */
public final class a implements d {
    private static c avM;
    private static HashMap<String, WeakReference<Bitmap>> avL = new HashMap<>();
    private static final Handler avN = new HandlerC0853a();

    /* renamed from: com.kwad.sdk.core.download.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class HandlerC0853a extends Handler {
        private final SparseArray<Long> avO;

        public HandlerC0853a() {
            super(Looper.getMainLooper());
            this.avO = new SparseArray<>();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z;
            boolean z2;
            boolean z3 = false;
            if (message.arg1 == 1) {
                z = true;
            } else {
                z = false;
            }
            int i = message.arg2;
            if (i == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (i == 2) {
                z3 = true;
            }
            Long l = this.avO.get(message.what);
            NotificationManager notificationManager = (NotificationManager) com.kwad.sdk.c.yq().getContext().getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            if (com.kwad.sdk.c.yq().bS(message.what) == null && !z3) {
                removeMessages(message.what);
                notificationManager.cancel(message.what);
            } else {
                if (!z && l != null && System.currentTimeMillis() - l.longValue() < 110) {
                    sendMessageDelayed(Message.obtain(message), (l.longValue() + 110) - System.currentTimeMillis());
                    return;
                }
                if (z2) {
                    notificationManager.cancel(message.what);
                }
                a.a(message.what, (Notification) message.obj);
                this.avO.put(message.what, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        private static String avP = "ksad_notification_default_icon";
        private String abi;
        private String avQ;
        private String avR;
        private String avT;
        private String name;
        private int progress;
        private File avS = null;
        private boolean avU = false;

        private b() {
        }

        public static String DU() {
            return avP;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadTask downloadTask, String str, String str2) {
            b bVar = new b();
            Object tag = downloadTask.getTag();
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File bZ = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).bZ(downloadParams.mAppIcon);
                if (bZ != null && bZ.exists()) {
                    bVar.avS = bZ;
                }
                bVar.name = downloadParams.mAppName;
            }
            bVar.avU = downloadTask.isPaused();
            bVar.abi = str;
            bVar.avT = str2;
            bVar.avQ = a.ap(downloadTask.getSmallFileSoFarBytes()) + " / " + a.ap(downloadTask.getSmallFileTotalBytes());
            bVar.avR = a.ap((long) downloadTask.getSmallFileTotalBytes());
            bVar.progress = (int) ((((float) downloadTask.getSmallFileSoFarBytes()) * 100.0f) / ((float) downloadTask.getSmallFileTotalBytes()));
            return bVar;
        }

        public final String DV() {
            return this.avQ;
        }

        public final String DW() {
            return this.avR;
        }

        public final String DX() {
            return this.abi;
        }

        public final File DY() {
            return this.avS;
        }

        public final String DZ() {
            return "正在下载 " + this.progress + "%";
        }

        public final String Ea() {
            return this.avT;
        }

        public final String getName() {
            String str = this.name;
            if (str == null) {
                return "";
            }
            return str;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final boolean isPaused() {
            return this.avU;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadParams downloadParams, String str, String str2) {
            File bZ;
            b bVar = new b();
            bVar.name = downloadParams.mAppName;
            if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (bZ = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).bZ(downloadParams.mAppIcon)) != null && bZ.exists()) {
                bVar.avS = bZ;
            }
            bVar.abi = str;
            bVar.avR = a.ap(downloadParams.mAppSize);
            bVar.avT = str2;
            return bVar;
        }
    }

    /* loaded from: classes11.dex */
    public static class c extends BroadcastReceiver {
        private static void d(@NonNull Intent intent) {
            DownloadTask f = f(intent);
            if (f == null) {
                return;
            }
            com.kwad.sdk.c.yq().bU(f.getId());
        }

        private static void e(@NonNull Intent intent) {
            DownloadTask f = f(intent);
            if (f == null) {
                return;
            }
            f.setNotificationRemoved(true);
        }

        @Nullable
        private static DownloadTask f(Intent intent) {
            int i = intent.getExtras().getInt("taskId", 0);
            if (i == 0) {
                return null;
            }
            return com.kwad.sdk.c.yq().bS(i);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getExtras() != null) {
                String action = intent.getAction();
                if ("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN".equals(action)) {
                    d(intent);
                } else if ("com.ksad.action.ACTION_NOTIFICATION_REMOVED".equals(action)) {
                    e(intent);
                }
            }
        }
    }

    private static void DT() {
        if (avM != null) {
            return;
        }
        avM = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN");
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
        if (Build.VERSION.SDK_INT >= 33) {
            ServiceProvider.Lw().registerReceiver(avM, intentFilter, 2);
        } else {
            ServiceProvider.Lw().registerReceiver(avM, intentFilter);
        }
    }

    private static Bitmap F(Context context, String str) {
        Bitmap bitmap;
        WeakReference<Bitmap> weakReference = avL.get(str);
        if (weakReference != null) {
            bitmap = weakReference.get();
        } else {
            bitmap = null;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            Bitmap decodeResource = BitmapFactory.decodeResource(at.cH(context), at.at(context, str));
            avL.put(str, new WeakReference<>(decodeResource));
            return decodeResource;
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i, Notification notification) {
        DT();
        NotificationManager notificationManager = (NotificationManager) ServiceProvider.Lw().getSystemService("notification");
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                II0XooXoX.oIX0oI();
                NotificationChannel oIX0oI2 = Oxx0IOOO.oIX0oI("download_channel", "ksad", 3);
                oIX0oI2.enableLights(false);
                oIX0oI2.enableVibration(false);
                oIX0oI2.setSound(null, null);
                oIX0oI2.setShowBadge(false);
                notificationManager.createNotificationChannel(oIX0oI2);
            }
            notificationManager.notify(i, notification);
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DefaultLocale"})
    public static String ap(long j) {
        return String.format("%.2fMB", Float.valueOf((((float) j) / 1000.0f) / 1000.0f));
    }

    private static DownloadParams m(DownloadTask downloadTask) {
        DownloadParams downloadParams;
        if (downloadTask == null) {
            return null;
        }
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            downloadParams = (DownloadParams) tag;
        } else {
            downloadParams = new DownloadParams();
        }
        downloadParams.mAppSize = downloadTask.getSmallFileTotalBytes();
        downloadParams.mTaskId = downloadTask.getId();
        downloadParams.filePath = downloadTask.getTargetFilePath();
        return downloadParams;
    }

    private static Bitmap q(File file) {
        Bitmap bitmap;
        String absolutePath = file.getAbsolutePath();
        WeakReference<Bitmap> weakReference = avL.get(absolutePath);
        if (weakReference != null) {
            bitmap = weakReference.get();
        } else {
            bitmap = null;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath);
            avL.put(absolutePath, new WeakReference<>(decodeFile));
            return decodeFile;
        }
        return bitmap;
    }

    @Override // com.kwad.sdk.d
    public final void bV(int i) {
        Context Lw = ServiceProvider.Lw();
        if (Lw == null) {
            return;
        }
        ((NotificationManager) Lw.getSystemService("notification")).cancel(i);
    }

    @Override // com.kwad.sdk.d
    public final void bX(String str) {
        Context Lw = ServiceProvider.Lw();
        DownloadParams dc = com.kwad.sdk.core.a.BK().dc(str);
        com.kwad.sdk.core.a.BK().dd(str);
        if (Lw != null && dc != null) {
            com.kwad.sdk.core.a.BK().dd(dc.filePath);
            b a2 = b.a(dc, "安装完成", "立刻打开");
            com.kwad.sdk.core.download.b.b bl = com.kwad.sdk.core.download.b.b.bl(Lw);
            if (bl == null) {
                return;
            }
            a(Lw, bl, a2);
            a(Lw, bl.build(), false, false, am.d(Lw, dc.mPkgname, dc.mTaskId), dc.mTaskId, 1, 2);
        }
    }

    @Override // com.kwad.sdk.d
    public final void g(File file) {
        Context Lw = ServiceProvider.Lw();
        if (Lw == null) {
            return;
        }
        DownloadParams dc = com.kwad.sdk.core.a.BK().dc(file.getAbsolutePath());
        com.kwad.sdk.core.a.BK().dd(file.getAbsolutePath());
        if (dc == null) {
            return;
        }
        AdTemplate de = com.kwad.sdk.core.a.BK().de(dc.mDownloadid);
        if (de != null) {
            de.installFrom = "recall";
        }
        b a2 = b.a(dc, "下载完成", "立即安装");
        com.kwad.sdk.core.download.b.b bl = com.kwad.sdk.core.download.b.b.bl(Lw);
        if (bl == null) {
            return;
        }
        a(Lw, bl, a2);
        a(Lw, bl.build(), false, false, am.a(Lw, file, dc.mTaskId, dc.requestInstallPermission), dc.mTaskId, 1, 2);
    }

    @Override // com.kwad.sdk.d
    public final void i(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (!TextUtils.isEmpty(str)) {
                File bZ = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).bZ(str);
                if (bZ == null || !bZ.exists()) {
                    ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).a(true, str, "", "");
                }
            }
        }
    }

    @Override // com.kwad.sdk.d
    public final void j(DownloadTask downloadTask) {
        String str;
        Context Lw = ServiceProvider.Lw();
        if (Lw == null || downloadTask.isNotificationRemoved()) {
            return;
        }
        if (downloadTask.getSmallFileSoFarBytes() > 0 && downloadTask.getSmallFileTotalBytes() > 0) {
            str = "正在下载";
        } else {
            str = "准备下载";
        }
        b a2 = b.a(downloadTask, str, (String) null);
        com.kwad.sdk.core.download.b.c a3 = com.kwad.sdk.core.download.b.c.a(Lw, downloadTask.getId(), downloadTask.downloadEnablePause);
        if (a3 == null) {
            return;
        }
        a(Lw, a3, a2);
        a(Lw, a3.build(), false, true, null, downloadTask.getId(), 1, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.kwad.sdk.d
    public final void k(DownloadTask downloadTask) {
        DownloadParams m;
        com.kwad.sdk.core.download.b.b bl;
        Context Lw = ServiceProvider.Lw();
        if (Lw == null || (m = m(downloadTask)) == null || (bl = com.kwad.sdk.core.download.b.b.bl(Lw)) == null) {
            return;
        }
        a(Lw, bl, b.a(downloadTask, "下载完成", "立即安装"));
        com.kwad.sdk.core.a.BK().a(downloadTask.getTargetFilePath(), m);
        com.kwad.sdk.core.a.BK().a(m.mPkgname, m);
        a(Lw, bl.build(), false, false, am.a(Lw, new File(downloadTask.getTargetFilePath()), m.mTaskId, m.requestInstallPermission), downloadTask.getId(), 1, 1);
    }

    @Override // com.kwad.sdk.d
    public final void a(DownloadTask downloadTask, boolean z) {
        com.kwad.sdk.core.download.b.c a2;
        Context Lw = ServiceProvider.Lw();
        if (Lw == null || downloadTask.isNotificationRemoved() || (a2 = com.kwad.sdk.core.download.b.c.a(Lw, downloadTask.getId(), downloadTask.downloadEnablePause)) == null) {
            return;
        }
        a(Lw, a2, b.a(downloadTask, "正在下载", (String) null));
        a(Lw, a2.build(), false, true, null, downloadTask.getId(), z ? 1 : 0, downloadTask.isCompleted() ? 1 : 0);
    }

    private boolean a(com.kwad.sdk.core.download.b.c cVar, File file) {
        try {
            cVar.setIcon(q(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            com.kwad.sdk.service.c.gatherException(e);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.c cVar, String str) {
        try {
            cVar.setIcon(F(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            com.kwad.sdk.service.c.gatherException(e);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.b.b bVar, File file) {
        try {
            bVar.setIcon(q(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            com.kwad.sdk.service.c.gatherException(e);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.b bVar, String str) {
        try {
            bVar.setIcon(F(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            com.kwad.sdk.service.c.gatherException(e);
            return false;
        }
    }

    private void a(Context context, RemoteViews remoteViews, boolean z, boolean z2, @Nullable PendingIntent pendingIntent, int i, int i2, int i3) {
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(at.getAppIconId(context));
        a(builder, remoteViews);
        if (z2) {
            Intent intent = new Intent("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
            intent.putExtra("taskId", i);
            builder.setDeleteIntent(am.a(context, i, intent));
        }
        Handler handler = avN;
        handler.removeMessages(i);
        handler.obtainMessage(i, i2, i3, builder.build()).sendToTarget();
    }

    private static void a(KsNotificationCompat.Builder builder, RemoteViews remoteViews) {
        try {
            builder.setDecoratedCustomStyle().setCustomBigContentView(remoteViews).setCustomContentView(remoteViews);
        } catch (Throwable unused) {
            builder.setContent(remoteViews);
        }
    }

    private void a(Context context, com.kwad.sdk.core.download.b.c cVar, b bVar) {
        cVar.setName(bVar.getName());
        File DY = bVar.DY();
        if (!((DY == null || !DY.exists()) ? false : a(cVar, DY))) {
            a(context, cVar, b.DU());
        }
        cVar.setStatus(bVar.DX());
        cVar.setSize(bVar.DV());
        cVar.setPercentNum(bVar.DZ());
        cVar.setProgress(100, bVar.getProgress(), false);
        cVar.setControlBtnPaused(bVar.isPaused());
    }

    private void a(Context context, com.kwad.sdk.core.download.b.b bVar, b bVar2) {
        bVar.setName(bVar2.getName());
        File DY = bVar2.DY();
        if (!((DY == null || !DY.exists()) ? false : a(bVar, DY))) {
            a(context, bVar, b.DU());
        }
        bVar.setStatus(bVar2.DX());
        bVar.setSize(bVar2.DW());
        bVar.setInstallText(bVar2.Ea());
    }
}
