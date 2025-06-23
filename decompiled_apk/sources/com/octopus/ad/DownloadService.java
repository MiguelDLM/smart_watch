package com.octopus.ad;

import android.app.DownloadManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import java.io.File;
import java.util.HashMap;
import o0IXXIx.II0XooXoX;
import o0IXXIx.X0o0xo;
import x0.IO;
import x0.xXxxox0I;

/* loaded from: classes11.dex */
public final class DownloadService extends Service {

    /* renamed from: OxI, reason: collision with root package name */
    public static xXxxox0I.oIX0oI f18570OxI;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public HashMap<String, IO0XoXxO.II0xO0> f18571IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public DownloadManager f18572IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public String f18573Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public II0xO0 f18574Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public oxoX f18575OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public long f18576XO;

    /* renamed from: o00, reason: collision with root package name */
    public HashMap<Long, String> f18577o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public I0Io f18578oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public HashMap<String, Boolean> f18579xoXoI;

    /* loaded from: classes11.dex */
    public class I0Io extends BroadcastReceiver {
        public I0Io() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction())) {
                    long longExtra = intent.getLongExtra("extra_download_id", -1L);
                    DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(longExtra);
                    Cursor query2 = downloadManager.query(query);
                    if (query2 != null && query2.moveToFirst()) {
                        if (query2.getInt(query2.getColumnIndex("status")) == 8) {
                            DownloadService.this.oxoX(context, longExtra);
                        }
                    } else {
                        DownloadService downloadService = DownloadService.this;
                        downloadService.xxIXOIIO(Long.valueOf(downloadService.f18576XO));
                    }
                } else {
                    "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED".equals(intent.getAction());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class II0xO0 extends ContentObserver {
        public II0xO0(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            int[] iArr = {0, 0, 0};
            Cursor cursor = null;
            try {
                try {
                    cursor = DownloadService.this.f18572IXxxXO.query(new DownloadManager.Query().setFilterById(DownloadService.this.f18576XO));
                    if (cursor != null && cursor.moveToFirst()) {
                        int i = cursor.getInt(cursor.getColumnIndex("status"));
                        II0XooXoX.oIX0oI("DownloadService", "onChange status：" + i);
                        if (i == 1) {
                            DownloadService.this.ooOOo0oXI(IO0XoXxO.I0Io.XO(DownloadService.this).oIX0oI());
                        }
                        iArr[0] = cursor.getInt(cursor.getColumnIndexOrThrow("bytes_so_far"));
                        iArr[1] = cursor.getInt(cursor.getColumnIndexOrThrow("total_size"));
                        iArr[2] = cursor.getInt(cursor.getColumnIndex("status"));
                        II0XooXoX.oIX0oI("DownloadService", "progress：" + iArr[0] + "/" + iArr[1] + "");
                    }
                    if (cursor == null) {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (cursor == null) {
                        return;
                    }
                }
                cursor.close();
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements xXxxox0I.I0Io {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ IO0XoXxO.II0xO0 f18583oIX0oI;

        public oIX0oI(IO0XoXxO.II0xO0 iI0xO0) {
            this.f18583oIX0oI = iI0xO0;
        }

        @Override // x0.xXxxox0I.I0Io
        public boolean oIX0oI(File file) {
            return true;
        }

        @Override // x0.xXxxox0I.I0Io
        public void onFail(int i) {
            II0XooXoX.oIX0oI("DownloadService", "--appUpdate downloadApk onFail--");
            try {
                String oIX0oI2 = this.f18583oIX0oI.oIX0oI();
                if (!TextUtils.isEmpty(oIX0oI2) && oIX0oI2.contains("http")) {
                    if (DownloadService.this.f18579xoXoI != null) {
                        DownloadService.this.f18579xoXoI.put(this.f18583oIX0oI.I0Io(), Boolean.TRUE);
                    }
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(oIX0oI2));
                    intent.setFlags(268435456);
                    DownloadService.this.startActivity(intent);
                }
            } catch (Exception e) {
                II0XooXoX.oIX0oI("DownloadService", "skip browser fail:" + e);
            }
        }

        @Override // x0.xXxxox0I.I0Io
        public void onProgress(long j, long j2) {
        }

        @Override // x0.xXxxox0I.I0Io
        public void onSuccess(File file) {
            II0XooXoX.oIX0oI("DownloadService", "--appUpdate downloadApk onSuccess--");
            if (DownloadService.this.f18579xoXoI != null) {
                DownloadService.this.f18579xoXoI.put(this.f18583oIX0oI.I0Io(), Boolean.FALSE);
            }
            DownloadService.this.X0o0xo(DownloadService.this.getApplicationContext(), -1L, this.f18583oIX0oI);
        }
    }

    /* loaded from: classes11.dex */
    public class oxoX extends BroadcastReceiver {
        public oxoX() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                II0XooXoX.oIX0oI("DownloadService", "Install Success:" + schemeSpecificPart);
                if (DownloadService.this.f18571IIXOooo == null) {
                    return;
                }
                IO0XoXxO.II0xO0 iI0xO0 = (IO0XoXxO.II0xO0) DownloadService.this.f18571IIXOooo.get(schemeSpecificPart);
                if (iI0xO0 != null) {
                    File file = new File(iI0xO0.oxoX(), iI0xO0.II0xO0());
                    if (file.exists()) {
                        file.delete();
                    }
                    IO0XoXxO.I0Io.XO(context).x0xO0oo(true);
                    if (iI0xO0.II0XooXoX() != null) {
                        IO.oIX0oI(iI0xO0.II0XooXoX().xxIXOIIO());
                    }
                    DownloadService.this.f18571IIXOooo.remove(schemeSpecificPart);
                }
            }
            if (DownloadService.this.f18571IIXOooo != null && DownloadService.this.f18571IIXOooo.isEmpty()) {
                DownloadService.this.stopSelf();
            }
        }
    }

    public static File OOXIXo(Context context, long j) {
        Cursor query;
        String path;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        File file = null;
        if (j != -1) {
            DownloadManager.Query query2 = new DownloadManager.Query();
            query2.setFilterById(j);
            query2.setFilterByStatus(8);
            if (downloadManager != null && (query = downloadManager.query(query2)) != null) {
                if (query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndex("local_uri"));
                    if (!TextUtils.isEmpty(string) && (path = Uri.parse(string).getPath()) != null) {
                        file = new File(path);
                    }
                }
                query.close();
            }
        }
        return file;
    }

    public final synchronized void I0Io(IO0XoXxO.II0xO0 iI0xO0) {
        Uri uriForFile;
        HashMap<String, Boolean> hashMap = this.f18579xoXoI;
        if (hashMap != null && hashMap.get(iI0xO0.I0Io()) != null && Boolean.TRUE.equals(this.f18579xoXoI.get(iI0xO0.I0Io()))) {
            II0XooXoX.oIX0oI("DownloadService", "downloading..." + iI0xO0.I0Io() + "...please not repeat click");
            Toast.makeText(this, "正在下载…请勿重复点击", 0).show();
            return;
        }
        File file = new File(iI0xO0.oxoX(), iI0xO0.II0xO0());
        if (file.exists()) {
            try {
                IO0XoXxO.I0Io.XO(this).x0xO0oo(false);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setAction("android.intent.action.VIEW");
                if (Build.VERSION.SDK_INT < 24) {
                    uriForFile = Uri.fromFile(file);
                } else {
                    uriForFile = FileProvider.getUriForFile(this, iI0xO0.Oxx0IOOO(), file);
                    intent.addFlags(3);
                }
                if (uriForFile != null) {
                    II0XooXoX.oIX0oI("DownloadService", "uri......" + uriForFile);
                    intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
                    startActivity(intent);
                    x0xO0oo(iI0xO0);
                }
            } catch (Exception e) {
                II0XooXoX.I0Io("DownloadService", "apkFile.exists():" + e);
            }
        }
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(iI0xO0.oIX0oI()));
            request.setTitle(iI0xO0.X0o0xo());
            request.setDescription(iI0xO0.XO());
            request.setNotificationVisibility(1);
            request.setDestinationUri(Uri.fromFile(file));
            request.setMimeType("application/vnd.android.package-archive");
            this.f18576XO = this.f18572IXxxXO.enqueue(request);
            II0XooXoX.II0xO0("DownloadService", "mReqId:" + this.f18576XO);
            HashMap<Long, String> hashMap2 = this.f18577o00;
            if (hashMap2 != null) {
                hashMap2.put(Long.valueOf(this.f18576XO), iI0xO0.I0Io());
            }
            HashMap<String, Boolean> hashMap3 = this.f18579xoXoI;
            if (hashMap3 != null) {
                hashMap3.put(iI0xO0.I0Io(), Boolean.TRUE);
            }
            Toast.makeText(this, "已开始下载…", 0).show();
            II0XooXoX.oIX0oI("DownloadService", "BEGIN_DOWNLOAD!");
            if (iI0xO0.II0XooXoX() != null) {
                IO.oIX0oI(iI0xO0.II0XooXoX().I0Io());
            }
        } catch (Exception e2) {
            Log.d("octopus", "DownloadManager download fail:" + e2);
            try {
                if (!TextUtils.isEmpty(iI0xO0.oIX0oI()) && iI0xO0.oIX0oI().contains("http")) {
                    HashMap<String, Boolean> hashMap4 = this.f18579xoXoI;
                    if (hashMap4 != null) {
                        hashMap4.put(iI0xO0.I0Io(), Boolean.TRUE);
                    }
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(iI0xO0.oIX0oI()));
                    intent2.setFlags(268435456);
                    startActivity(intent2);
                }
            } catch (Exception e3) {
                II0XooXoX.I0Io("DownloadService", "skip browser fail:" + e3);
            }
        }
    }

    public final void II0xO0() {
        getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, this.f18574Oxx0xo);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f18578oI0IIXIo, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f18575OxxIIOOXO, intentFilter);
    }

    public final void IXxxXO() {
        xXxxox0I.oIX0oI oix0oi = f18570OxI;
        if (oix0oi != null) {
            oix0oi.destroy();
        }
        if (this.f18579xoXoI != null) {
            this.f18579xoXoI = null;
        }
        if (this.f18571IIXOooo != null) {
            this.f18571IIXOooo = null;
        }
        if (this.f18577o00 != null) {
            this.f18577o00 = null;
        }
        IO0XoXxO.I0Io.XO(this).IXxxXO();
        II0XooXoX.oIX0oI("DownloadService", "releaseResources()");
    }

    public final void X0o0xo(Context context, Long l, IO0XoXxO.II0xO0 iI0xO0) {
        Uri uriForFile;
        try {
            IO0XoXxO.I0Io.XO(context).x0xO0oo(false);
            File file = new File(iI0xO0.oxoX(), iI0xO0.I0Io() + OTAManager.OTA_ZIP_SUFFIX);
            if (file.exists()) {
                File file2 = new File(iI0xO0.oxoX(), iI0xO0.II0xO0());
                file.renameTo(file2);
                II0XooXoX.oIX0oI("DownloadService", "apkFile......raName:" + file2.exists());
            }
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            int i = Build.VERSION.SDK_INT;
            if (i < 23) {
                uriForFile = this.f18572IXxxXO.getUriForDownloadedFile(l.longValue());
            } else if (i < 24) {
                File OOXIXo2 = OOXIXo(context, l.longValue());
                if (OOXIXo2 != null) {
                    uriForFile = Uri.fromFile(OOXIXo2);
                } else {
                    uriForFile = null;
                }
            } else {
                uriForFile = FileProvider.getUriForFile(context, this.f18573Oo, new File(iI0xO0.oxoX(), iI0xO0.II0xO0()));
                intent.addFlags(3);
            }
            if (uriForFile != null) {
                II0XooXoX.oIX0oI("DownloadService", "uri......" + uriForFile);
                intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
                context.startActivity(intent);
                x0xO0oo(iI0xO0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void oO() {
        IO0XoXxO.II0xO0 oIX0oI2 = IO0XoXxO.I0Io.XO(this).oIX0oI();
        if (oIX0oI2 == null) {
            return;
        }
        HashMap<String, IO0XoXxO.II0xO0> hashMap = this.f18571IIXOooo;
        if (hashMap != null) {
            hashMap.put(oIX0oI2.I0Io(), oIX0oI2);
        }
        HashMap<String, Boolean> hashMap2 = this.f18579xoXoI;
        if (hashMap2 != null && hashMap2.get(oIX0oI2.I0Io()) == null) {
            II0XooXoX.oIX0oI("DownloadService", "not have package status...");
            this.f18579xoXoI.put(oIX0oI2.I0Io(), Boolean.FALSE);
        }
        if (TextUtils.isEmpty(oIX0oI2.Oxx0IOOO())) {
            this.f18573Oo = getPackageName() + ".octopus.provider";
        } else {
            this.f18573Oo = oIX0oI2.Oxx0IOOO();
        }
        X0o0xo.I0Io(oIX0oI2.oxoX());
        I0Io(oIX0oI2);
    }

    public final void oOoXoXO() {
        getContentResolver().unregisterContentObserver(this.f18574Oxx0xo);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f18578oI0IIXIo);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f18575OxxIIOOXO);
        II0XooXoX.oIX0oI("DownloadService", "unregister()");
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        II0XooXoX.oIX0oI("DownloadService", "DownloadService onCreate()");
        this.f18572IXxxXO = (DownloadManager) getSystemService("download");
        this.f18574Oxx0xo = new II0xO0(new Handler());
        this.f18578oI0IIXIo = new I0Io();
        this.f18575OxxIIOOXO = new oxoX();
        this.f18571IIXOooo = new HashMap<>();
        this.f18579xoXoI = new HashMap<>();
        this.f18577o00 = new HashMap<>();
        II0xO0();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        II0XooXoX.oIX0oI("DownloadService", "DownloadService onDestroy()");
        oOoXoXO();
        IXxxXO();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 1;
        }
        II0XooXoX.oIX0oI("DownloadService", "DownloadService onStartCommand()");
        oO();
        return super.onStartCommand(intent, i, i2);
    }

    public final void ooOOo0oXI(IO0XoXxO.II0xO0 iI0xO0) {
        if (iI0xO0 == null) {
            return;
        }
        II0XooXoX.oIX0oI("DownloadService", "--appUpdate downloadApk start--");
        xXxxox0I.oIX0oI oIX0oI2 = xXxxox0I.oIX0oI();
        f18570OxI = oIX0oI2;
        oIX0oI2.II0xO0(new oIX0oI(iI0xO0));
        f18570OxI.oIX0oI(new xXxxox0I.X0o0xo(iI0xO0.oIX0oI(), iI0xO0.oxoX(), iI0xO0.II0xO0()));
    }

    public final void oxoX(Context context, long j) {
        II0XooXoX.oIX0oI("DownloadService", "onReceived...download finish...begin install！");
        HashMap<Long, String> hashMap = this.f18577o00;
        if (hashMap != null && this.f18571IIXOooo != null) {
            String str = hashMap.get(Long.valueOf(j));
            HashMap<String, Boolean> hashMap2 = this.f18579xoXoI;
            if (hashMap2 != null) {
                hashMap2.put(str, Boolean.FALSE);
            }
            IO0XoXxO.II0xO0 iI0xO0 = this.f18571IIXOooo.get(str);
            if (iI0xO0 != null) {
                if (iI0xO0.II0XooXoX() != null) {
                    IO.oIX0oI(iI0xO0.II0XooXoX().X0o0xo());
                }
                X0o0xo(context, Long.valueOf(j), iI0xO0);
            }
        }
    }

    public final void x0xO0oo(IO0XoXxO.II0xO0 iI0xO0) {
        II0XooXoX.oIX0oI("DownloadService", "BEGIN_INSTALL!");
        if (iI0xO0.II0XooXoX() != null) {
            IO.oIX0oI(iI0xO0.II0XooXoX().Oxx0IOOO());
        }
    }

    public void xxIXOIIO(Long l) {
        try {
            HashMap<Long, String> hashMap = this.f18577o00;
            if (hashMap != null) {
                String str = hashMap.get(l);
                if (!TextUtils.isEmpty(str)) {
                    HashMap<String, Boolean> hashMap2 = this.f18579xoXoI;
                    if (hashMap2 != null) {
                        hashMap2.put(str, Boolean.FALSE);
                    }
                    HashMap<String, IO0XoXxO.II0xO0> hashMap3 = this.f18571IIXOooo;
                    if (hashMap3 != null) {
                        hashMap3.remove(str);
                    }
                }
            }
            DownloadManager downloadManager = this.f18572IXxxXO;
            if (downloadManager != null && l != null) {
                downloadManager.remove(l.longValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
