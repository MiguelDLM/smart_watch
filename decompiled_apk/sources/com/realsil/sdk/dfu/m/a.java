package com.realsil.sdk.dfu.m;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.realsil.sdk.core.bluetooth.utils.BluetoothUuid;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import com.realsil.sdk.dfu.l.a;
import com.realsil.sdk.dfu.model.OtaModeInfo;
import com.realsil.sdk.dfu.utils.ConnectParams;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import kotlin.OX00O0xII;

/* loaded from: classes11.dex */
public final class a extends com.realsil.sdk.dfu.l.a {
    public a(int i, ConnectParams connectParams, String str, BluetoothGatt bluetoothGatt, BluetoothGattService bluetoothGattService, BluetoothGattService bluetoothGattService2, a.c cVar) {
        super(i, connectParams, str, bluetoothGatt, bluetoothGattService, bluetoothGattService2, cVar);
        e();
    }

    @Override // com.realsil.sdk.dfu.l.a
    public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        int i2;
        super.a(bluetoothGatt, bluetoothGattCharacteristic, bArr, i);
        UUID uuid = bluetoothGattCharacteristic.getUuid();
        ZLogger.v(this.i, "processCharacteristicRead");
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
            if (com.realsil.sdk.dfu.l.g.e.equals(uuid)) {
                ZLogger.v("PNP_ID: " + DataConverter.bytes2Hex(bArr));
                b().setPnpId(bArr);
                i();
                return;
            }
            if (g.g.equals(uuid)) {
                ZLogger.v(this.j, "update device info");
                b().parseX0012(bArr);
                i();
                return;
            }
            if (g.b.equals(uuid)) {
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
            if (g.c.equals(uuid)) {
                if (i2 > 0) {
                    ByteBuffer wrap2 = ByteBuffer.wrap(bArr);
                    wrap2.order(ByteOrder.LITTLE_ENDIAN);
                    if (i2 == 2) {
                        b().setPatchVersion(wrap2.getShort(0) & OX00O0xII.f29066Oxx0xo);
                    } else if (i2 >= 4) {
                        b().setPatchVersion(wrap2.getInt(0) & 65535);
                    }
                }
                i();
                return;
            }
            if (g.d.equals(uuid)) {
                if (i2 > 0) {
                    ByteBuffer wrap3 = ByteBuffer.wrap(bArr);
                    wrap3.order(ByteOrder.LITTLE_ENDIAN);
                    if (i2 == 2) {
                        b().setAppVersion(wrap3.getShort(0) & OX00O0xII.f29066Oxx0xo);
                    } else if (i2 >= 4) {
                        b().setAppVersion(wrap3.getInt(0));
                    }
                }
                i();
                return;
            }
            if (g.e.equals(uuid)) {
                if (i2 > 0) {
                    ByteBuffer wrap4 = ByteBuffer.wrap(bArr);
                    wrap4.order(ByteOrder.LITTLE_ENDIAN);
                    if (i2 == 1) {
                        b().setPatchExtensionVersion(wrap4.get(0));
                    } else if (i2 == 2) {
                        b().setPatchExtensionVersion(wrap4.getShort(0) & OX00O0xII.f29066Oxx0xo);
                    }
                }
                i();
                return;
            }
            int shortValue = BluetoothUuid.toShortValue(uuid);
            if (shortValue >= 65504 && shortValue <= 65519) {
                ZLogger.v(this.i, "X0012:appendActiveImageVersionBytes");
                b().appendActiveImageVersionBytes(bArr);
            } else if (shortValue >= 65472 && shortValue <= 65487) {
                b().appendDebugCharacteristicInfo(shortValue, bArr);
            }
            i();
            return;
        }
        ZLogger.w(this.i, "Characteristic read error: " + i);
        if (g.g.equals(uuid)) {
            b(2);
            i();
        } else {
            ZLogger.d("ignore exception when read other info");
        }
    }

    @Override // com.realsil.sdk.dfu.l.a
    public void e() {
        super.e();
        if (this.t != null) {
            this.x.add(new OtaModeInfo(16));
        }
        if (this.p != null) {
            this.x.add(new OtaModeInfo(0));
        }
    }

    @Override // com.realsil.sdk.dfu.l.a
    public boolean f() {
        if (!super.f()) {
            return false;
        }
        int i = 65472;
        while (true) {
            if (i > 65487) {
                break;
            }
            UUID fromShortValue = BluetoothUuid.fromShortValue(i);
            BluetoothGattCharacteristic characteristic = this.o.getCharacteristic(fromShortValue);
            if (characteristic == null) {
                if (this.j) {
                    ZLogger.v("not found debug characteristic:" + fromShortValue.toString());
                }
            } else {
                if (this.j) {
                    ZLogger.v("find debug characteristic: " + fromShortValue.toString());
                }
                this.v.add(characteristic);
                i++;
            }
        }
        for (int i2 = 65504; i2 <= 65519; i2++) {
            UUID fromShortValue2 = BluetoothUuid.fromShortValue(i2);
            BluetoothGattCharacteristic characteristic2 = this.o.getCharacteristic(fromShortValue2);
            if (characteristic2 == null) {
                ZLogger.v(this.j, "not found image version characteristic:" + fromShortValue2.toString());
                return true;
            }
            ZLogger.v(this.h, "find image version characteristic: " + fromShortValue2.toString());
            this.s.add(characteristic2);
        }
        return true;
    }

    @Override // com.realsil.sdk.dfu.l.a
    public void g() {
        super.g();
        b(257);
        if (this.m != null) {
            b(258);
            boolean a2 = a(this.m);
            ZLogger.v(this.i, "read battery level :" + a2);
        }
        if (this.n != null) {
            b(259);
            boolean a3 = a(this.n);
            ZLogger.v(this.i, "read PnP_ID :" + a3);
        }
        if (this.q != null) {
            b(260);
            boolean a4 = a(this.q);
            ZLogger.v(this.i, "read device info :" + a4);
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
            ZLogger.v(this.i, "read device mac :" + a5);
        }
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.v) {
            int shortValue = BluetoothUuid.toShortValue(bluetoothGattCharacteristic.getUuid());
            ZLogger.v(this.j, String.format("uuidShortValue=0x%4x", Integer.valueOf(shortValue)));
            if (shortValue >= 65472 && shortValue <= 65487) {
                b(266);
                boolean a6 = a(bluetoothGattCharacteristic);
                ZLogger.v(this.j, "read debug info :" + a6);
            }
        }
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : this.s) {
            int shortValue2 = BluetoothUuid.toShortValue(bluetoothGattCharacteristic2.getUuid());
            ZLogger.v(this.j, String.format("uuidShortValue=0x%4x", Integer.valueOf(shortValue2)));
            if (shortValue2 >= 65504 && shortValue2 <= 65519) {
                b(267);
                boolean a7 = a(bluetoothGattCharacteristic2);
                ZLogger.d(this.i, "X0012: read image version :" + a7);
            }
        }
        if (this.j) {
            ZLogger.d("readDeviceInfo complete: " + b().toString());
        }
        this.v.clear();
        this.s.clear();
        b(1);
    }
}
