package com.realsil.sdk.dfu.p;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.realsil.sdk.core.bluetooth.utils.BluetoothUuid;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import com.realsil.sdk.dfu.l.a;
import com.realsil.sdk.dfu.l.g;
import com.realsil.sdk.dfu.model.OtaModeInfo;
import com.realsil.sdk.dfu.utils.ConnectParams;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

/* loaded from: classes11.dex */
public class a extends com.realsil.sdk.dfu.l.a {
    public a(int i, ConnectParams connectParams, String str, BluetoothGatt bluetoothGatt, BluetoothGattService bluetoothGattService, BluetoothGattService bluetoothGattService2, a.c cVar) {
        super(i, connectParams, str, bluetoothGatt, bluetoothGattService, bluetoothGattService2, cVar);
        k();
    }

    @Override // com.realsil.sdk.dfu.l.a
    public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        int i2;
        super.a(bluetoothGatt, bluetoothGattCharacteristic, bArr, i);
        UUID uuid = bluetoothGattCharacteristic.getUuid();
        if (i == 0) {
            if (bArr != null) {
                i2 = bArr.length;
            } else {
                i2 = 0;
            }
            if (com.realsil.sdk.dfu.l.b.b.equals(uuid)) {
                a(bArr);
                i();
                return;
            }
            if (g.e.equals(uuid)) {
                ZLogger.v("PNP_ID: " + DataConverter.bytes2Hex(bArr));
                b().setPnpId(bArr);
                i();
                return;
            }
            if (f.c.equals(uuid)) {
                b().parseX0015(bArr);
                i();
                return;
            }
            if (f.b.equals(uuid)) {
                if (i2 > 0) {
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                    if (i2 >= 6) {
                        byte[] bArr2 = new byte[6];
                        wrap.get(bArr2, 0, 6);
                        b().setDeviceMac(bArr2);
                    }
                }
                i();
                return;
            }
            int shortValue = BluetoothUuid.toShortValue(uuid);
            if (shortValue == 65504) {
                b().appendImageVersionBytes(bArr);
            } else if (shortValue == 65524) {
                b().appendImageSectionSizeBytes(bArr);
            }
            i();
            return;
        }
        ZLogger.w(this.h, "Characteristic read error: " + i);
        if (f.c.equals(uuid)) {
            b(2);
            i();
        } else {
            ZLogger.d(this.h, "ignore exctption when read other info");
        }
    }

    @Override // com.realsil.sdk.dfu.l.a
    public boolean f() {
        if (!super.f()) {
            return false;
        }
        BluetoothGattCharacteristic characteristic = this.o.getCharacteristic(BluetoothUuid.fromShortValue(65504));
        if (characteristic == null) {
            ZLogger.d(this.j, "not found image version characteristic:65504");
        } else {
            ZLogger.d(this.j, "find image version characteristic: " + characteristic.getUuid());
            this.s.add(characteristic);
        }
        BluetoothGattCharacteristic characteristic2 = this.o.getCharacteristic(BluetoothUuid.fromShortValue(65524));
        if (characteristic2 == null) {
            ZLogger.v(this.j, "not found image session size characteristic:65524");
            return true;
        }
        ZLogger.v(this.j, "find image session size characteristic: " + characteristic2.getUuid());
        this.v.add(characteristic2);
        return true;
    }

    @Override // com.realsil.sdk.dfu.l.a
    public void g() {
        super.g();
        b(257);
        if (this.m != null) {
            b(258);
            boolean a2 = a(this.m);
            ZLogger.v(this.j, "read battery level :" + a2);
        }
        if (this.n != null) {
            b(259);
            boolean a3 = a(this.n);
            ZLogger.v(this.j, "read PnP_ID :" + a3);
        }
        if (this.q != null) {
            b(260);
            boolean a4 = a(this.q);
            ZLogger.v(this.j, "read device info :" + a4);
            if (!a4) {
                this.v.clear();
                this.s.clear();
                b(2);
                return;
            }
        }
        if (this.r != null) {
            b(261);
            boolean a5 = a(this.r);
            ZLogger.v(this.j, "read device mac :" + a5);
        }
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.v) {
            int shortValue = BluetoothUuid.toShortValue(bluetoothGattCharacteristic.getUuid());
            ZLogger.v(this.j, String.format("uuidShortValue=0x%4x", Integer.valueOf(shortValue)));
            if (shortValue == 65524) {
                b(268);
                boolean a6 = a(bluetoothGattCharacteristic);
                ZLogger.v(this.j, "read image section size :" + a6);
            }
        }
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : this.s) {
            int shortValue2 = BluetoothUuid.toShortValue(bluetoothGattCharacteristic2.getUuid());
            ZLogger.v(this.j, String.format("uuidShortValue=0x%4x", Integer.valueOf(shortValue2)));
            if (shortValue2 == 65504) {
                b(267);
                boolean a7 = a(bluetoothGattCharacteristic2);
                ZLogger.v(this.j, "read image version :" + a7);
            }
        }
        l();
        if (this.j) {
            ZLogger.d("readDeviceInfo complete: " + b().toString());
        }
        this.v.clear();
        this.s.clear();
        b(1);
    }

    public final void k() {
        if (this.t != null) {
            this.x.add(new OtaModeInfo(16));
        }
        if (this.p != null) {
            this.x.add(new OtaModeInfo(0));
        }
    }

    public final void l() {
        this.x.clear();
        if (this.t != null) {
            this.x.add(new OtaModeInfo(16));
        }
        if (b().leNormalModeSupported && this.p != null) {
            this.x.add(new OtaModeInfo(0));
        }
    }
}
