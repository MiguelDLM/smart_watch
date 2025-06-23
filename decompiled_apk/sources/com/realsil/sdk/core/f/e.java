package com.realsil.sdk.core.f;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Build;
import com.realsil.sdk.core.bluetooth.scanner.LeScannerPresenter;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.f.a;
import com.realsil.sdk.core.logger.ZLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@TargetApi(21)
/* loaded from: classes11.dex */
public final class e extends com.realsil.sdk.core.f.a {
    public BluetoothLeScanner g;
    public final a h;

    /* loaded from: classes11.dex */
    public class a extends ScanCallback {
        public a() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onBatchScanResults(List<ScanResult> list) {
            super.onBatchScanResults(list);
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanFailed(int i) {
            super.onScanFailed(i);
            ZLogger.w(e.this.f19516a, "scan failed with " + i);
            e eVar = e.this;
            a.InterfaceC0909a interfaceC0909a = eVar.f;
            if (interfaceC0909a != null) {
                ZLogger.v(LeScannerPresenter.this.b, "onLeScanFailed:" + i);
                return;
            }
            ZLogger.v(eVar.b, "no listeners register");
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanResult(int i, ScanResult scanResult) {
            byte[] bArr;
            boolean isConnectable;
            boolean isConnectable2;
            boolean isLegacy;
            int primaryPhy;
            int secondaryPhy;
            int advertisingSid;
            int txPower;
            int periodicAdvertisingInterval;
            super.onScanResult(i, scanResult);
            if (e.this.f19516a) {
                StringBuilder sb = new StringBuilder();
                sb.append("ScanResult{");
                BluetoothDevice device = scanResult.getDevice();
                if (device != null) {
                    sb.append(String.format("\n\t%s", BluetoothHelper.dumpBluetoothDevice(device)));
                }
                if (scanResult.getScanRecord() != null) {
                    sb.append("\n\tscanRecord=");
                    sb.append(b.a(scanResult.getScanRecord()));
                }
                sb.append("\n\trssi=");
                sb.append(scanResult.getRssi());
                sb.append("\n\ttimestampNanos=");
                sb.append(scanResult.getTimestampNanos());
                if (Build.VERSION.SDK_INT >= 26) {
                    sb.append("\n\tisConnectable=");
                    isConnectable2 = scanResult.isConnectable();
                    sb.append(isConnectable2);
                    sb.append("\n\tisLegacy=");
                    isLegacy = scanResult.isLegacy();
                    sb.append(isLegacy);
                    Locale locale = Locale.US;
                    primaryPhy = scanResult.getPrimaryPhy();
                    Integer valueOf = Integer.valueOf(primaryPhy);
                    secondaryPhy = scanResult.getSecondaryPhy();
                    sb.append(String.format(locale, "\n\tprimaryPhy=%d,secondaryPhy=%d", valueOf, Integer.valueOf(secondaryPhy)));
                    sb.append("\n\tadvertisingSid=");
                    advertisingSid = scanResult.getAdvertisingSid();
                    sb.append(advertisingSid);
                    sb.append("\n\ttxPower=");
                    txPower = scanResult.getTxPower();
                    sb.append(txPower);
                    sb.append("\n\tperiodicAdvertisingInterval=");
                    periodicAdvertisingInterval = scanResult.getPeriodicAdvertisingInterval();
                    sb.append(periodicAdvertisingInterval);
                }
                sb.append("\n}");
                ZLogger.v(sb.toString());
            }
            e eVar = e.this;
            if (!eVar.d) {
                ZLogger.v("scan procedure has already been stopped, ignore.");
                return;
            }
            ScannerParams scannerParams = eVar.e;
            if (scannerParams != null && scannerParams.isConnectable() && Build.VERSION.SDK_INT >= 26) {
                isConnectable = scanResult.isConnectable();
                if (!isConnectable) {
                    if (e.this.b) {
                        ZLogger.v("ignore noconnectable device");
                        return;
                    }
                    return;
                }
            }
            ScanRecord scanRecord = scanResult.getScanRecord();
            e eVar2 = e.this;
            BluetoothDevice device2 = scanResult.getDevice();
            int rssi = scanResult.getRssi();
            if (scanRecord != null) {
                bArr = scanRecord.getBytes();
            } else {
                bArr = new byte[0];
            }
            a.InterfaceC0909a interfaceC0909a = eVar2.f;
            if (interfaceC0909a != null) {
                LeScannerPresenter.this.a(device2, rssi, bArr);
            } else {
                ZLogger.v(eVar2.b, "no listeners register");
            }
        }
    }

    public e(Context context) {
        super(context);
        this.h = new a();
        ZLogger.v(this.b, "LeScannerV21 init");
        BluetoothAdapter bluetoothAdapter = this.c;
        if (bluetoothAdapter != null) {
            this.g = bluetoothAdapter.getBluetoothLeScanner();
        }
        if (this.g == null) {
            ZLogger.d("mBluetoothLeScanner == null");
        }
    }

    @Override // com.realsil.sdk.core.f.a
    public final boolean a(ScannerParams scannerParams) {
        ScanSettings.Builder phy;
        if (!super.a(scannerParams)) {
            ZLogger.w("startScan failed");
            return false;
        }
        if (this.g == null) {
            ZLogger.d("getBluetoothLeScanner...");
            this.g = this.c.getBluetoothLeScanner();
        }
        if (this.g == null) {
            ZLogger.w("mBluetoothLeScanner is null");
            a();
            return false;
        }
        ArrayList arrayList = new ArrayList();
        List<CompatScanFilter> scanFilters = scannerParams.getScanFilters();
        if (scanFilters != null && scanFilters.size() > 0) {
            boolean z = this.b;
            StringBuilder a2 = com.realsil.sdk.core.a.a.a("contains ");
            a2.append(scanFilters.size());
            a2.append(" filters");
            ZLogger.v(z, a2.toString());
            for (CompatScanFilter compatScanFilter : scanFilters) {
                ScanFilter.Builder builder = new ScanFilter.Builder();
                builder.setServiceUuid(compatScanFilter.getServiceUuid()).setDeviceAddress(compatScanFilter.getDeviceAddress()).setDeviceName(compatScanFilter.getDeviceName()).setManufacturerData(compatScanFilter.getManufacturerId(), compatScanFilter.getManufacturerData(), compatScanFilter.getManufacturerDataMask());
                if (compatScanFilter.getServiceDataUuid() != null) {
                    builder.setServiceData(compatScanFilter.getServiceDataUuid(), compatScanFilter.getServiceData());
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    builder.setServiceSolicitationUuid(compatScanFilter.getServiceSolicitationUuid());
                }
                arrayList.add(builder.build());
                ZLogger.v(this.b, compatScanFilter.toString());
            }
        }
        ScanSettings.Builder scanMode = new ScanSettings.Builder().setScanMode(2);
        if (Build.VERSION.SDK_INT >= 26) {
            phy = scanMode.setPhy(scannerParams.getPhy());
            phy.setLegacy(false);
        }
        try {
            this.g.startScan(arrayList, scanMode.build(), this.h);
            return true;
        } catch (Exception e) {
            ZLogger.w(e.toString());
            return false;
        }
    }

    @Override // com.realsil.sdk.core.f.a
    public final boolean a() {
        super.a();
        BluetoothAdapter bluetoothAdapter = this.c;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            BluetoothLeScanner bluetoothLeScanner = this.g;
            if (bluetoothLeScanner == null) {
                ZLogger.w("BluetoothLeScanner has not been initialized");
                return false;
            }
            try {
                bluetoothLeScanner.stopScan(this.h);
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
