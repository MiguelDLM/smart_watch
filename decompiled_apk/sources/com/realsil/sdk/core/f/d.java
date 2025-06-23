package com.realsil.sdk.core.f;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.ParcelUuid;
import com.realsil.sdk.core.bluetooth.scanner.LeScannerPresenter;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import com.realsil.sdk.core.f.a;
import com.realsil.sdk.core.logger.ZLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@TargetApi(19)
/* loaded from: classes11.dex */
public final class d extends com.realsil.sdk.core.f.a {
    public a g;

    /* loaded from: classes11.dex */
    public class a implements BluetoothAdapter.LeScanCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            d dVar = d.this;
            a.InterfaceC0909a interfaceC0909a = dVar.f;
            if (interfaceC0909a != null) {
                LeScannerPresenter.this.a(bluetoothDevice, i, bArr);
            } else {
                ZLogger.v(dVar.b, "no listeners register");
            }
        }
    }

    public d(Context context) {
        super(context);
        this.g = new a();
        ZLogger.v(this.b, "LeScannerV19 init");
    }

    @Override // com.realsil.sdk.core.f.a
    public final boolean a(ScannerParams scannerParams) {
        UUID[] uuidArr;
        if (!super.a(scannerParams)) {
            return false;
        }
        List<CompatScanFilter> scanFilters = scannerParams.getScanFilters();
        try {
            if (scanFilters != null && scanFilters.size() > 0) {
                boolean z = this.b;
                StringBuilder a2 = com.realsil.sdk.core.a.a.a("contains ");
                a2.append(scanFilters.size());
                a2.append(" filters");
                ZLogger.v(z, a2.toString());
                ArrayList arrayList = new ArrayList();
                for (CompatScanFilter compatScanFilter : scanFilters) {
                    ZLogger.v(compatScanFilter.toString());
                    if (compatScanFilter.getServiceUuid() != null) {
                        arrayList.add(compatScanFilter.getServiceUuid());
                    }
                }
                int size = arrayList.size();
                if (size > 0) {
                    uuidArr = new UUID[size];
                    for (int i = 0; i < size; i++) {
                        if (arrayList.get(i) != null) {
                            uuidArr[i] = ((ParcelUuid) arrayList.get(i)).getUuid();
                        }
                    }
                    return this.c.startLeScan(uuidArr, this.g);
                }
            }
            return this.c.startLeScan(uuidArr, this.g);
        } catch (Exception e) {
            ZLogger.w(e.toString());
            return false;
        }
        uuidArr = null;
    }

    @Override // com.realsil.sdk.core.f.a
    public final boolean a() {
        super.a();
        BluetoothAdapter bluetoothAdapter = this.c;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            try {
                this.c.stopLeScan(this.g);
                return true;
            } catch (Exception e) {
                ZLogger.w(e.toString());
                return false;
            }
        }
        ZLogger.w("BT Adapter is not turned ON");
        return false;
    }
}
