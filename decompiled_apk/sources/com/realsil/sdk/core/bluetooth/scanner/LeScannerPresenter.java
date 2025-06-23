package com.realsil.sdk.core.bluetooth.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.f.a;
import com.realsil.sdk.core.f.c;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import java.util.List;
import java.util.Locale;

/* loaded from: classes11.dex */
public final class LeScannerPresenter extends com.realsil.sdk.core.d.a {
    public c q;
    public final a r;

    /* loaded from: classes11.dex */
    public class a implements a.InterfaceC0909a {
        public a() {
        }
    }

    public LeScannerPresenter(Context context) {
        this(context, null, null, null);
    }

    @Override // com.realsil.sdk.core.d.a
    public final void a() {
    }

    @Override // com.realsil.sdk.core.d.a
    public final boolean b() {
        if (!super.b()) {
            return false;
        }
        this.q = new c(this.c);
        return true;
    }

    @Override // com.realsil.sdk.core.d.a
    public final boolean e() {
        c cVar = this.q;
        synchronized (cVar) {
            com.realsil.sdk.core.f.a aVar = cVar.f19517a;
            if (aVar != null) {
                aVar.f = null;
            }
        }
        if (this.q.f19517a.d) {
            ZLogger.v(this.b, "stop the le scan process");
            if (!this.q.f19517a.a(null, false)) {
                ZLogger.w("scanLeDevice failed");
                return false;
            }
        }
        a(0);
        return true;
    }

    @Override // com.realsil.sdk.core.d.a
    public /* bridge */ /* synthetic */ BluetoothAdapter getBluetoothAdapter() {
        return super.getBluetoothAdapter();
    }

    @Override // com.realsil.sdk.core.d.a
    public /* bridge */ /* synthetic */ List getPairedDevices() {
        return super.getPairedDevices();
    }

    @Override // com.realsil.sdk.core.d.a
    public /* bridge */ /* synthetic */ List getPairedDevicesByProfile(int i) {
        return super.getPairedDevicesByProfile(i);
    }

    @Override // com.realsil.sdk.core.d.a
    public /* bridge */ /* synthetic */ int getState() {
        return super.getState();
    }

    @Override // com.realsil.sdk.core.d.a
    public /* bridge */ /* synthetic */ boolean isBluetoothEnabled() {
        return super.isBluetoothEnabled();
    }

    @Override // com.realsil.sdk.core.d.a
    public /* bridge */ /* synthetic */ boolean isBluetoothSupported() {
        return super.isBluetoothSupported();
    }

    @Override // com.realsil.sdk.core.d.a
    public /* bridge */ /* synthetic */ boolean isScanning() {
        return super.isScanning();
    }

    @Override // com.realsil.sdk.core.d.a
    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    @Override // com.realsil.sdk.core.d.a
    public /* bridge */ /* synthetic */ boolean scanDevice(boolean z) {
        return super.scanDevice(z);
    }

    @Override // com.realsil.sdk.core.d.a
    public /* bridge */ /* synthetic */ void setScanMode(int i) {
        super.setScanMode(i);
    }

    @Override // com.realsil.sdk.core.d.a
    public /* bridge */ /* synthetic */ void setScannerCallback(ScannerCallback scannerCallback) {
        super.setScannerCallback(scannerCallback);
    }

    @Override // com.realsil.sdk.core.d.a
    public /* bridge */ /* synthetic */ void setScannerParams(ScannerParams scannerParams) {
        super.setScannerParams(scannerParams);
    }

    @Override // com.realsil.sdk.core.d.a
    public boolean startScan() {
        if (!d()) {
            return true;
        }
        if (this.b) {
            boolean z = this.f19509a;
            StringBuilder a2 = com.realsil.sdk.core.a.a.a("startDiscovery for ");
            a2.append(this.d.toString());
            ZLogger.v(z, a2.toString());
        } else {
            boolean z2 = this.f19509a;
            StringBuilder a3 = com.realsil.sdk.core.a.a.a("startDiscovery for ");
            a3.append(this.d.getScanPeriod());
            a3.append("ms");
            ZLogger.v(z2, a3.toString());
        }
        c cVar = this.q;
        a aVar = this.r;
        synchronized (cVar) {
            com.realsil.sdk.core.f.a aVar2 = cVar.f19517a;
            if (aVar2 != null) {
                aVar2.f = aVar;
            }
        }
        c cVar2 = this.q;
        if (!cVar2.f19517a.a(this.d, true)) {
            ZLogger.v("scanLeDevice failed");
            stopScan();
            return false;
        }
        c();
        ZLogger.v("");
        return true;
    }

    @Override // com.realsil.sdk.core.d.a
    public /* bridge */ /* synthetic */ boolean stopScan() {
        return super.stopScan();
    }

    public LeScannerPresenter(Context context, ScannerParams scannerParams, ScannerCallback scannerCallback) {
        this(context, null, scannerParams, scannerCallback);
    }

    @Override // com.realsil.sdk.core.d.a
    public final boolean a(@NonNull BluetoothDevice bluetoothDevice) {
        int type = bluetoothDevice.getType();
        if (this.d.getScanMode() != 18) {
            this.d.getScanMode();
        } else if (type != 2) {
            if (this.b) {
                ZLogger.v(String.format(Locale.US, "filter, invalid type: %d, expect type is %d", Integer.valueOf(type), 2));
            }
            return false;
        }
        if (!b(bluetoothDevice)) {
            return false;
        }
        if (TextUtils.isEmpty(this.d.getAddressFilter()) || DataConverter.equals(this.d.getAddressFilter(), bluetoothDevice.getAddress())) {
            return true;
        }
        if (this.b) {
            StringBuilder a2 = com.realsil.sdk.core.a.a.a("address not match:");
            a2.append(BluetoothHelper.formatAddress(bluetoothDevice.getAddress(), true));
            ZLogger.v(a2.toString());
        }
        return false;
    }

    @Override // com.realsil.sdk.core.d.a
    public /* bridge */ /* synthetic */ List getPairedDevices(int i) {
        return super.getPairedDevices(i);
    }

    @Override // com.realsil.sdk.core.d.a
    public /* bridge */ /* synthetic */ boolean scanDevice(boolean z, boolean z2) {
        return super.scanDevice(z, z2);
    }

    public LeScannerPresenter(Context context, Handler handler, ScannerParams scannerParams, ScannerCallback scannerCallback) {
        this.r = new a();
        this.c = context.getApplicationContext();
        this.g = handler;
        this.d = scannerParams;
        this.e = scannerCallback;
        b();
    }
}
