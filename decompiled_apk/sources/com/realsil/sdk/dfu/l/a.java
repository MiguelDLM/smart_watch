package com.realsil.sdk.dfu.l;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.facebook.login.widget.ToolTipPopup;
import com.realsil.sdk.core.bluetooth.GlobalGatt;
import com.realsil.sdk.core.bluetooth.impl.BluetoothGattImpl;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.RtkDfu;
import com.realsil.sdk.dfu.model.OtaDeviceInfo;
import com.realsil.sdk.dfu.model.OtaModeInfo;
import com.realsil.sdk.dfu.utils.ConnectParams;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes11.dex */
public abstract class a implements o {
    public ConnectParams A;
    public int B;
    public b C;
    public final BluetoothGattCallback D;
    public Object E;
    public boolean F;
    public int G;
    public boolean H;
    public Object I;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public BluetoothGatt l;
    public BluetoothGattCharacteristic m;
    public BluetoothGattCharacteristic n;
    public BluetoothGattService o;
    public BluetoothGattCharacteristic p;
    public BluetoothGattCharacteristic q;
    public BluetoothGattCharacteristic r;
    public List<BluetoothGattCharacteristic> s;
    public BluetoothGattService t;
    public BluetoothGattCharacteristic u;
    public List<BluetoothGattCharacteristic> v;
    public OtaDeviceInfo w;
    public List<OtaModeInfo> x;
    public String y;
    public c z;

    /* loaded from: classes11.dex */
    public class b extends Thread {
        public b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            setName("AdapterXGBase-DeviceInfoThread");
            a.this.g();
        }

        public /* synthetic */ b(a aVar, C0913a c0913a) {
            this();
        }
    }

    /* loaded from: classes11.dex */
    public interface c {
        void a(int i);
    }

    public a(int i, ConnectParams connectParams, String str, BluetoothGatt bluetoothGatt, BluetoothGattService bluetoothGattService, BluetoothGattService bluetoothGattService2, c cVar) {
        this.h = true;
        this.i = true;
        this.j = false;
        this.x = new ArrayList();
        this.B = 1;
        C0913a c0913a = new C0913a();
        this.D = c0913a;
        this.E = new Object();
        this.F = true;
        this.G = 0;
        this.H = false;
        this.I = new Object();
        boolean z = RtkDfu.DEBUG_ENABLE;
        this.i = z;
        this.h = z;
        this.j = RtkDfu.VDBG;
        this.k = i;
        this.A = connectParams;
        this.y = str;
        this.l = GlobalGatt.getInstance().getBluetoothGatt(str);
        this.o = bluetoothGattService;
        this.t = bluetoothGattService2;
        this.z = cVar;
        this.x = new ArrayList();
        this.v = new ArrayList();
        this.s = new ArrayList();
        ConnectParams connectParams2 = this.A;
        if (connectParams2 != null) {
            this.B = connectParams2.getBatteryValueFormat();
        } else {
            this.B = 1;
        }
        BluetoothGatt bluetoothGatt2 = this.l;
        if (bluetoothGatt2 != null) {
            a(bluetoothGatt2);
            b(this.l);
        }
        f();
        GlobalGatt.getInstance().registerCallback(this.y, c0913a);
    }

    public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
    }

    public final void b(BluetoothGatt bluetoothGatt) {
        UUID uuid = g.f19557a;
        BluetoothGattService service = bluetoothGatt.getService(uuid);
        if (service == null) {
            ZLogger.v("DEVICE_INFORMATION_SERVICE not found");
            return;
        }
        ZLogger.d("find DEVICE_INFORMATION_SERVICE: " + uuid.toString());
        UUID uuid2 = g.e;
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
        this.n = characteristic;
        if (characteristic == null) {
            ZLogger.d("DIS_PNP_ID_CHARACTERISTIC not found");
            return;
        }
        ZLogger.d("find DIS_PNP_ID_CHARACTERISTIC: " + uuid2.toString());
    }

    public List<OtaModeInfo> c() {
        return this.x;
    }

    public boolean d() {
        if ((this.G & 256) == 256) {
            return true;
        }
        return false;
    }

    public void e() {
        if (this.t == null) {
            this.u = null;
            ZLogger.v(this.j, "not find DFU_SERVICE_UUID = " + com.realsil.sdk.dfu.q.g.f19593a);
            return;
        }
        ZLogger.v(this.j, "find DFU_SERVICE_UUID = " + this.t.getUuid());
        BluetoothGattService bluetoothGattService = this.t;
        UUID uuid = com.realsil.sdk.dfu.q.g.c;
        BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(uuid);
        this.u = characteristic;
        if (characteristic == null) {
            ZLogger.v(this.j, "not found DFU_CONTROL_POINT_CHARACTERISTIC: " + uuid);
            return;
        }
        if (this.i) {
            ZLogger.d("find DFU_CONTROL_POINT_CHARACTERISTIC: " + uuid);
            ZLogger.d(BluetoothGattImpl.parseProperty2(this.u.getProperties()));
        }
        this.u.setWriteType(2);
    }

    public boolean f() {
        BluetoothGattService bluetoothGattService = this.o;
        if (bluetoothGattService == null) {
            ZLogger.w(this.i, "mOtaService is null");
            return false;
        }
        UUID uuid = com.realsil.sdk.dfu.p.f.f19589a;
        BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(uuid);
        this.p = characteristic;
        if (characteristic == null) {
            if (this.i) {
                ZLogger.d("OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC not found");
            }
        } else {
            ZLogger.v(this.i, "find OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC = " + uuid);
        }
        BluetoothGattService bluetoothGattService2 = this.o;
        UUID uuid2 = com.realsil.sdk.dfu.m.g.b;
        BluetoothGattCharacteristic characteristic2 = bluetoothGattService2.getCharacteristic(uuid2);
        this.r = characteristic2;
        if (characteristic2 == null) {
            ZLogger.d("OTA_DEVICE_MAC_CHARACTERISTIC_UUID not found");
        } else if (this.h) {
            ZLogger.v("find OTA_DEVICE_MAC_CHARACTERISTIC_UUID = " + uuid2);
            ZLogger.v(BluetoothGattImpl.parseProperty2(this.r.getProperties()));
        }
        BluetoothGattService bluetoothGattService3 = this.o;
        UUID uuid3 = com.realsil.sdk.dfu.m.g.g;
        BluetoothGattCharacteristic characteristic3 = bluetoothGattService3.getCharacteristic(uuid3);
        this.q = characteristic3;
        if (characteristic3 == null) {
            if (this.h) {
                ZLogger.d("OTA_DEVICE_INFO_CHARACTERISTIC_UUID not found");
                return true;
            }
            return true;
        }
        if (this.j) {
            ZLogger.v("find OTA_DEVICE_INFO_CHARACTERISTIC_UUID = " + uuid3);
            ZLogger.v(BluetoothGattImpl.parseProperty2(this.q.getProperties()));
            return true;
        }
        return true;
    }

    public void g() {
    }

    public void h() {
        ZLogger.v("sync data ...");
        b bVar = new b(this, null);
        this.C = bVar;
        bVar.start();
    }

    public void i() {
        synchronized (this.I) {
            try {
                if (this.j) {
                    ZLogger.v("trigger SyncLock");
                }
                this.H = true;
                this.I.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j() {
        synchronized (this.I) {
            try {
                try {
                    if (this.j) {
                        ZLogger.v("waitSyncLock");
                    }
                    this.I.wait(ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
                } catch (InterruptedException e) {
                    ZLogger.w("wait sync data interrupted: " + e.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: com.realsil.sdk.dfu.l.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0913a extends BluetoothGattCallback {
        public C0913a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic, bArr);
            a.this.a(bluetoothGatt, bluetoothGattCharacteristic, bArr);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, bArr, i);
            a.this.a(bluetoothGatt, bluetoothGattCharacteristic, bArr, i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i == 0 && i2 == 0 && a.this.d()) {
                a.this.b(2);
                a.this.i();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
            try {
                ZLogger.v(a.this.j, "onDescriptorWrite: " + i);
                synchronized (a.this.E) {
                    a.this.F = true;
                    a.this.E.notifyAll();
                }
            } catch (Exception e) {
                ZLogger.w(e.toString());
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            a.this.a(bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            a.this.a(bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue(), i);
        }
    }

    public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
    }

    public void a() {
        b bVar = this.C;
        if (bVar != null) {
            bVar.interrupt();
            this.C = null;
        }
        this.G = 0;
        GlobalGatt.getInstance().unRegisterCallback(this.y, this.D);
    }

    public OtaDeviceInfo b() {
        if (this.w == null) {
            this.w = new OtaDeviceInfo(this.k, 2);
        }
        return this.w;
    }

    public final void a(BluetoothGatt bluetoothGatt) {
        UUID uuid = com.realsil.sdk.dfu.l.b.f19551a;
        BluetoothGattService service = bluetoothGatt.getService(uuid);
        if (service == null) {
            ZLogger.v(this.i, "BATTERY_SERVICE not found");
            return;
        }
        if (this.j) {
            ZLogger.v("find BATTERY_SERVICE: " + uuid.toString());
        }
        UUID uuid2 = com.realsil.sdk.dfu.l.b.b;
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
        this.m = characteristic;
        if (characteristic == null) {
            ZLogger.v(this.j, "BAS_READ_CHARACTERITIC not found");
        } else if (this.i) {
            ZLogger.v("find BAS_READ_CHARACTERITIC: " + uuid2.toString());
        }
    }

    public void b(int i) {
        ZLogger.d(String.format("syncState: 0x%04X >> 0x%04X", Integer.valueOf(this.G), Integer.valueOf(i)));
        this.G = i;
        c cVar = this.z;
        if (cVar != null) {
            cVar.a(i);
        } else {
            ZLogger.v(this.j, "no callback registered");
        }
    }

    public boolean a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.l == null) {
            ZLogger.w("mBluetoothGatt is null maybe disconnected just now");
            return false;
        }
        if (bluetoothGattCharacteristic == null) {
            ZLogger.w("characteristic can not be null");
            return false;
        }
        if (this.h) {
            ZLogger.v(String.format(Locale.US, "readCharacteristic:(%d) %s", Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()), bluetoothGattCharacteristic.getUuid().toString()));
        }
        this.H = false;
        if (this.l.readCharacteristic(bluetoothGattCharacteristic)) {
            j();
            return this.G != 2;
        }
        ZLogger.w("readCharacteristic failed");
        return false;
    }

    public OtaModeInfo a(int i) {
        List<OtaModeInfo> list = this.x;
        if (list != null && list.size() > 0) {
            for (OtaModeInfo otaModeInfo : this.x) {
                if (otaModeInfo != null && otaModeInfo.getWorkmode() == i) {
                    return otaModeInfo;
                }
            }
            return this.x.get(0);
        }
        return new OtaModeInfo(0);
    }

    public boolean a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        int properties = bluetoothGattCharacteristic.getProperties();
        if ((properties & 16) == 0) {
            ZLogger.w("check properties failed: " + properties);
            this.F = false;
            return false;
        }
        if (this.h) {
            ZLogger.v("setCharacteristicNotification() - uuid: " + bluetoothGattCharacteristic.getUuid() + " enabled: " + z);
        } else {
            ZLogger.v("setCharacteristicNotification()  enabled: " + z);
        }
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z);
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(o.f19568a);
        if (descriptor != null) {
            boolean z2 = descriptor.getValue() != null && descriptor.getValue().length == 2 && descriptor.getValue()[0] > 0 && descriptor.getValue()[1] == 0;
            ZLogger.v(this.h, "current cccd state: " + z2);
            if (z && z2) {
                this.F = true;
                ZLogger.w("cccd already enabled");
                return true;
            }
            if (!z && !z2) {
                ZLogger.w("cccd already disable");
                this.F = true;
                return true;
            }
            descriptor.setValue(z ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
            if (bluetoothGatt.writeDescriptor(descriptor)) {
                synchronized (this.E) {
                    ZLogger.d(this.i, "wait write Characteristic Notification 15000ms");
                    try {
                        this.F = false;
                        this.E.wait(30000L);
                    } catch (InterruptedException e) {
                        ZLogger.w("wait writeDescriptor interrupted: " + e.toString());
                    }
                }
                return this.F;
            }
        }
        return false;
    }

    public void a(byte[] bArr) {
        short s;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        if (this.B == 1) {
            if (bArr.length > 0) {
                s = wrap.get();
            }
            s = 0;
        } else if (bArr.length >= 2) {
            s = wrap.getShort();
        } else {
            if (bArr.length > 0) {
                s = wrap.get();
            }
            s = 0;
        }
        ZLogger.v(this.i, "current battery: " + ((int) s));
        b().setBatteryLevel(s);
    }
}
