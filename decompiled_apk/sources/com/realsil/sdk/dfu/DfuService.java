package com.realsil.sdk.dfu;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.realsil.sdk.core.bluetooth.BluetoothProfileCallback;
import com.realsil.sdk.core.bluetooth.BluetoothProfileManager;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.a;
import com.realsil.sdk.dfu.internal.base.BaseDfuTask;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.model.Throughput;
import com.realsil.sdk.dfu.params.QcConfig;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes11.dex */
public class DfuService extends Service {
    public static boolean p = true;

    /* renamed from: a, reason: collision with root package name */
    public IBinder f19521a;
    public BaseDfuTask f;
    public BluetoothManager g;
    public BluetoothAdapter h;
    public BluetoothProfileManager i;
    public Throughput l;
    public String b = "";
    public RemoteCallbackList<com.realsil.sdk.dfu.b> c = new RemoteCallbackList<>();
    public HashMap<String, com.realsil.sdk.dfu.b> d = new HashMap<>();
    public int e = 0;
    public boolean j = false;
    public int k = 257;
    public Handler m = new a(Looper.getMainLooper());
    public final BluetoothProfileCallback n = new b();
    public DfuThreadCallback o = new c();

    /* loaded from: classes11.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                DfuService.this.a(1, message.obj);
            } else if (i == 2) {
                DfuService.this.a(2, message.obj);
            } else if (i == 3) {
                DfuService.this.a(3, message.obj);
            } else if (i == 4) {
                DfuService.this.a(4, message.obj);
            }
            super.handleMessage(message);
        }
    }

    /* loaded from: classes11.dex */
    public class b extends BluetoothProfileCallback {
        public b() {
        }

        @Override // com.realsil.sdk.core.bluetooth.BluetoothProfileCallback
        public void onHfpConnectionStateChanged(BluetoothDevice bluetoothDevice, int i) {
            super.onHfpConnectionStateChanged(bluetoothDevice, i);
            if (DfuService.this.e == 1 && i == 2 && DfuService.this.f != null && (DfuService.this.f instanceof com.realsil.sdk.dfu.j.b)) {
                ((com.realsil.sdk.dfu.j.b) DfuService.this.f).a(bluetoothDevice, i);
            }
        }

        @Override // com.realsil.sdk.core.bluetooth.BluetoothProfileCallback
        public void onHidStateChanged(BluetoothDevice bluetoothDevice, int i) {
            super.onHidStateChanged(bluetoothDevice, i);
            if (DfuService.this.e == 0 && i == 2 && DfuService.this.f != null && (DfuService.this.f instanceof com.realsil.sdk.dfu.j.b)) {
                ((com.realsil.sdk.dfu.j.b) DfuService.this.f).a(bluetoothDevice, i);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c extends DfuThreadCallback {
        public c() {
        }

        @Override // com.realsil.sdk.dfu.internal.base.DfuThreadCallback
        public void onError(int i) {
            super.onError(i);
            DfuService.this.j = false;
            if (DfuService.this.m != null) {
                DfuService.this.m.sendMessage(DfuService.this.m.obtainMessage(2, Integer.valueOf(i)));
            } else {
                ZLogger.v(false, "handle was not initialized");
            }
        }

        @Override // com.realsil.sdk.dfu.internal.base.DfuThreadCallback
        public void onProgressChanged(DfuProgressInfo dfuProgressInfo) {
            super.onProgressChanged(dfuProgressInfo);
            DfuService.this.l = dfuProgressInfo.getThroughput();
            if (DfuService.this.m != null) {
                DfuService.this.m.sendMessage(DfuService.this.m.obtainMessage(3, dfuProgressInfo));
            } else {
                ZLogger.v(false, "handle was not initialized");
            }
        }

        @Override // com.realsil.sdk.dfu.internal.base.DfuThreadCallback
        public void onStateChanged(int i, Throughput throughput) {
            boolean z;
            super.onStateChanged(i, throughput);
            DfuService.this.k = i;
            DfuService.this.l = throughput;
            DfuService dfuService = DfuService.this;
            if ((dfuService.k & 512) == 512) {
                z = true;
            } else {
                z = false;
            }
            dfuService.j = z;
            if (DfuService.this.m != null) {
                DfuService.this.m.sendMessage(DfuService.this.m.obtainMessage(1, Integer.valueOf(i)));
            } else {
                ZLogger.v(false, "handle was not initialized");
            }
        }
    }

    public boolean abort() {
        BaseDfuTask baseDfuTask = this.f;
        if (baseDfuTask != null) {
            baseDfuTask.abort();
            return true;
        }
        return true;
    }

    public boolean activeImage(boolean z) {
        BaseDfuTask baseDfuTask = this.f;
        if (baseDfuTask != null && baseDfuTask.activeImage(z)) {
            return true;
        }
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (p) {
            ZLogger.v("onBind");
        }
        return this.f19521a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f19521a = new d(this);
        BluetoothProfileManager bluetoothProfileManager = BluetoothProfileManager.getInstance();
        this.i = bluetoothProfileManager;
        if (bluetoothProfileManager == null) {
            BluetoothProfileManager.initial(this);
            this.i = BluetoothProfileManager.getInstance();
        }
        BluetoothProfileManager bluetoothProfileManager2 = this.i;
        if (bluetoothProfileManager2 != null) {
            bluetoothProfileManager2.addManagerCallback(this.n);
        } else {
            ZLogger.d("BluetoothProfileManager not initialized");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (p) {
            ZLogger.v("onDestroy()+");
        }
        this.j = false;
        this.k = 257;
        BluetoothProfileManager bluetoothProfileManager = this.i;
        if (bluetoothProfileManager != null) {
            bluetoothProfileManager.removeManagerCallback(this.n);
        }
        if (p) {
            ZLogger.v("onDestroy()-");
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (p) {
            ZLogger.d("onUnbind");
        }
        return super.onUnbind(intent);
    }

    public boolean start(String str, DfuConfig dfuConfig, QcConfig qcConfig) {
        if (str == null) {
            ZLogger.w("the packageName is null");
            return false;
        }
        if (dfuConfig == null) {
            ZLogger.w("dfuConfig can not be null");
            return false;
        }
        boolean z = this.j;
        if (z && (this.k & 512) == 512) {
            ZLogger.w(String.format(Locale.US, "isInOtaProcess=%b, mProcessState=0x%04X", Boolean.valueOf(z), Integer.valueOf(this.k)));
            return false;
        }
        if (!a()) {
            ZLogger.w("initialize failed");
            return false;
        }
        if (this.d.get(str) == null) {
            ZLogger.w("didn't find the special callback in the service");
            return false;
        }
        this.k = 257;
        this.l = null;
        this.b = str;
        this.e = dfuConfig.getChannelType();
        BaseDfuTask a2 = com.realsil.sdk.dfu.i.a.a(this, dfuConfig, qcConfig, this.o);
        this.f = a2;
        if (a2 == null) {
            return false;
        }
        a2.start();
        return true;
    }

    /* loaded from: classes11.dex */
    public class d extends a.AbstractBinderC0910a {

        /* renamed from: a, reason: collision with root package name */
        public DfuService f19525a;

        public d(DfuService dfuService) {
            this.f19525a = dfuService;
        }

        @Override // com.realsil.sdk.dfu.a
        public boolean a(String str, DfuConfig dfuConfig, QcConfig qcConfig) {
            DfuService e = e();
            return e != null && e.start(str, dfuConfig, qcConfig);
        }

        @Override // com.realsil.sdk.dfu.a
        public boolean b(String str, com.realsil.sdk.dfu.b bVar) {
            if (bVar == null) {
                return false;
            }
            ZLogger.v("registerCallback: " + str);
            DfuService.this.c.register(bVar);
            DfuService.this.d.put(str, bVar);
            return DfuService.this.d.get(str) != null;
        }

        @Override // com.realsil.sdk.dfu.a
        public boolean c() {
            DfuService e = e();
            if (e != null && e.abort()) {
                return true;
            }
            return false;
        }

        @Override // android.os.Binder, android.os.IBinder
        public void dump(FileDescriptor fileDescriptor, String[] strArr) {
        }

        @Override // android.os.Binder, android.os.IBinder
        public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) {
        }

        public final DfuService e() {
            DfuService dfuService = this.f19525a;
            if (dfuService != null) {
                return dfuService;
            }
            return null;
        }

        @Override // android.os.Binder, android.os.IBinder
        public String getInterfaceDescriptor() {
            return null;
        }

        @Override // android.os.Binder, android.os.IBinder
        public boolean isBinderAlive() {
            return false;
        }

        @Override // android.os.Binder, android.os.IBinder
        public void linkToDeath(IBinder.DeathRecipient deathRecipient, int i) {
        }

        @Override // android.os.Binder, android.os.IBinder
        public boolean pingBinder() {
            return false;
        }

        @Override // android.os.Binder, android.os.IBinder
        public IInterface queryLocalInterface(String str) {
            return null;
        }

        @Override // android.os.Binder, android.os.IBinder
        public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int i) {
            return false;
        }

        @Override // com.realsil.sdk.dfu.a
        public boolean a(boolean z) {
            DfuService e = e();
            return e != null && e.activeImage(z);
        }

        @Override // com.realsil.sdk.dfu.a
        public void a(String str, com.realsil.sdk.dfu.b bVar) {
            if (bVar != null) {
                ZLogger.v("unregisterCallback: " + str);
                DfuService.this.c.unregister(bVar);
                DfuService.this.d.remove(str);
            }
        }

        @Override // com.realsil.sdk.dfu.a
        public Throughput b() {
            return DfuService.this.l;
        }

        @Override // com.realsil.sdk.dfu.a
        public int a() {
            return DfuService.this.k;
        }
    }

    public final void a(int i, Object obj) {
        com.realsil.sdk.dfu.b bVar = this.d.get(this.b);
        if (bVar == null) {
            return;
        }
        this.c.beginBroadcast();
        try {
        } catch (RemoteException e) {
            ZLogger.e(e.toString());
        }
        if (i == 1) {
            bVar.a(((Integer) obj).intValue());
        } else if (i == 2) {
            bVar.b(((Integer) obj).intValue());
        } else {
            if (i == 3) {
                bVar.a((DfuProgressInfo) obj);
            }
            this.c.finishBroadcast();
        }
        this.c.finishBroadcast();
    }

    public final boolean a() {
        if (this.g == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
            this.g = bluetoothManager;
            if (bluetoothManager == null) {
                ZLogger.w("Unable to initialize BluetoothManager.");
                return false;
            }
        }
        BluetoothAdapter adapter = this.g.getAdapter();
        this.h = adapter;
        if (adapter == null) {
            ZLogger.w("Unable to obtain a BluetoothAdapter.");
            return false;
        }
        boolean z = RtkDfu.DEBUG_ENABLE;
        p = z;
        if (!z) {
            return true;
        }
        ZLogger.v("initialize success");
        return true;
    }
}
