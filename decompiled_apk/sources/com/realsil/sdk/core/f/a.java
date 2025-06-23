package com.realsil.sdk.core.f;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import com.realsil.sdk.core.RtkCore;
import com.realsil.sdk.core.bluetooth.scanner.LeScannerPresenter;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.logger.ZLogger;

/* loaded from: classes11.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f19516a = RtkCore.DEBUG;
    public boolean b = RtkCore.VDBG;
    public BluetoothAdapter c;
    public boolean d;
    public ScannerParams e;
    public InterfaceC0909a f;

    /* renamed from: com.realsil.sdk.core.f.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0909a {
    }

    public a(Context context) {
        this.c = com.realsil.sdk.core.b.a.a(context);
    }

    public boolean a(ScannerParams scannerParams) {
        BluetoothAdapter bluetoothAdapter = this.c;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            ZLogger.v(this.b, "LeScanner--startScan");
            if (this.f == null) {
                ZLogger.v(this.b, "no listeners register");
            }
            this.d = true;
            this.e = scannerParams;
            return true;
        }
        ZLogger.w("BT Adapter is not turned ON");
        return false;
    }

    public boolean a() {
        InterfaceC0909a interfaceC0909a = this.f;
        if (interfaceC0909a != null) {
            LeScannerPresenter.a aVar = (LeScannerPresenter.a) interfaceC0909a;
            ZLogger.v(LeScannerPresenter.this.b, "onLeScanStop");
            LeScannerPresenter.this.a(3);
        } else {
            ZLogger.v(this.b, "no listeners register");
        }
        this.d = false;
        return true;
    }

    public final boolean a(ScannerParams scannerParams, boolean z) {
        if (z) {
            if (!this.c.isEnabled()) {
                ZLogger.d("BT Adapter is not enable");
                return false;
            }
            return a(scannerParams);
        }
        return a();
    }
}
