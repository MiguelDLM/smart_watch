package com.realsil.sdk.dfu.q;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.realsil.sdk.core.bluetooth.impl.BluetoothGattImpl;
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
    public BluetoothGattCharacteristic J;
    public BluetoothGattCharacteristic K;
    public BluetoothGattCharacteristic L;
    public boolean M;
    public boolean N;

    public a(int i, ConnectParams connectParams, String str, BluetoothGatt bluetoothGatt, BluetoothGattService bluetoothGattService, BluetoothGattService bluetoothGattService2, a.c cVar, boolean z) {
        super(i, connectParams, str, bluetoothGatt, bluetoothGattService, bluetoothGattService2, cVar);
        this.N = false;
        this.M = z;
        e();
    }

    @Override // com.realsil.sdk.dfu.l.a
    public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        super.a(bluetoothGatt, bluetoothGattCharacteristic, bArr, i);
        UUID uuid = bluetoothGattCharacteristic.getUuid();
        if (i == 0) {
            int length = bArr != null ? bArr.length : 0;
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
            if (h.g.equals(uuid)) {
                b().parseX0000(bArr);
                i();
                return;
            }
            if (h.b.equals(uuid)) {
                if (length > 0) {
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                    if (length >= 6) {
                        byte[] bArr2 = new byte[6];
                        wrap.get(bArr2, 0, 6);
                        b().setDeviceMac(bArr2);
                    }
                }
                i();
                return;
            }
            if (h.c.equals(uuid)) {
                if (length > 0) {
                    ByteBuffer wrap2 = ByteBuffer.wrap(bArr);
                    wrap2.order(ByteOrder.LITTLE_ENDIAN);
                    if (length == 2) {
                        b().setPatchVersion(wrap2.getShort(0) & OX00O0xII.f29066Oxx0xo);
                    } else if (length >= 4) {
                        b().setPatchVersion(wrap2.getInt(0) & 65535);
                    }
                }
                i();
                return;
            }
            if (h.d.equals(uuid)) {
                if (length > 0) {
                    ByteBuffer wrap3 = ByteBuffer.wrap(bArr);
                    wrap3.order(ByteOrder.LITTLE_ENDIAN);
                    if (length == 2) {
                        b().setAppVersion(wrap3.getShort(0) & OX00O0xII.f29066Oxx0xo);
                    } else if (length >= 4) {
                        b().setAppVersion(wrap3.getInt(0));
                    }
                }
                i();
                return;
            }
            if (h.e.equals(uuid)) {
                ByteBuffer wrap4 = ByteBuffer.wrap(bArr);
                wrap4.order(ByteOrder.LITTLE_ENDIAN);
                if (length == 1) {
                    b().setPatchExtensionVersion(wrap4.get(0));
                } else if (length == 2) {
                    b().setPatchExtensionVersion(wrap4.getShort(0) & OX00O0xII.f29066Oxx0xo);
                }
                i();
                return;
            }
            int shortValue = BluetoothUuid.toShortValue(uuid);
            if (shortValue >= 65504 && shortValue <= 65519) {
                b().appendActiveImageVersionBytes(bArr);
            } else if (shortValue >= 65472 && shortValue <= 65487) {
                b().appendDebugCharacteristicInfo(shortValue, bArr);
            }
            i();
            return;
        }
        ZLogger.w(this.h, "Characteristic read error: " + i);
        if (h.g.equals(uuid)) {
            b(2);
            i();
        } else {
            ZLogger.d("ignore exctption when read other info");
        }
    }

    @Override // com.realsil.sdk.dfu.l.a
    public void e() {
        super.e();
        BluetoothGattService bluetoothGattService = this.t;
        if (bluetoothGattService == null) {
            if (this.p != null) {
                this.x.add(new OtaModeInfo(0));
                return;
            }
            return;
        }
        if (this.M) {
            this.x.add(new OtaModeInfo(18));
            return;
        }
        UUID uuid = g.d;
        BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(uuid);
        if (characteristic != null) {
            ZLogger.d(this.h, "find DFU_EXTEND_FLASH_CHARACTERISTIC = " + uuid);
            this.x.add(new OtaModeInfo(17));
            ZLogger.d(BluetoothGattImpl.parseProperty2(characteristic.getProperties()));
            return;
        }
        ZLogger.d(this.h, "DFU_EXTEND_FLASH_CHARACTERISTIC not found");
        this.x.add(new OtaModeInfo(16));
        if (this.p != null) {
            this.x.add(new OtaModeInfo(0));
        }
    }

    @Override // com.realsil.sdk.dfu.l.a
    public boolean f() {
        if (!super.f()) {
            return false;
        }
        BluetoothGattService bluetoothGattService = this.o;
        UUID uuid = h.c;
        BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(uuid);
        this.K = characteristic;
        if (characteristic == null) {
            if (this.i) {
                ZLogger.d("OTA_READ_PATCH_CHARACTERISTIC_UUID not found");
            }
        } else if (this.j) {
            ZLogger.v("find OTA_READ_PATCH_CHARACTERISTIC_UUID = " + uuid);
            ZLogger.v(BluetoothGattImpl.parseProperty2(this.K.getProperties()));
        }
        BluetoothGattService bluetoothGattService2 = this.o;
        UUID uuid2 = h.d;
        BluetoothGattCharacteristic characteristic2 = bluetoothGattService2.getCharacteristic(uuid2);
        this.J = characteristic2;
        if (characteristic2 == null) {
            if (this.i) {
                ZLogger.d("OTA_APP_VERSION_CHARACTERISTIC_UUID not found");
            }
        } else if (this.j) {
            ZLogger.v("find OTA_APP_VERSION_CHARACTERISTIC_UUID = " + uuid2);
            ZLogger.v(BluetoothGattImpl.parseProperty2(this.J.getProperties()));
        }
        BluetoothGattService bluetoothGattService3 = this.o;
        UUID uuid3 = h.e;
        BluetoothGattCharacteristic characteristic3 = bluetoothGattService3.getCharacteristic(uuid3);
        this.L = characteristic3;
        if (characteristic3 == null) {
            if (this.i) {
                ZLogger.d("OTA_READ_PATCH_EXTENSION_CHARACTERISTIC_UUID not found");
            }
        } else if (this.j) {
            ZLogger.v("find OTA_READ_PATCH_EXTENSION_CHARACTERISTIC_UUID = " + uuid3);
            ZLogger.v(BluetoothGattImpl.parseProperty2(this.L.getProperties()));
        }
        int i = 65472;
        while (true) {
            if (i > 65487) {
                break;
            }
            UUID fromShortValue = BluetoothUuid.fromShortValue(i);
            BluetoothGattCharacteristic characteristic4 = this.o.getCharacteristic(fromShortValue);
            if (characteristic4 == null) {
                ZLogger.v(this.j, "not found debug characteristic:" + fromShortValue.toString());
                break;
            }
            ZLogger.d(this.i, "find debug characteristic: " + fromShortValue.toString());
            this.v.add(characteristic4);
            i++;
        }
        for (int i2 = 65504; i2 <= 65519; i2++) {
            UUID fromShortValue2 = BluetoothUuid.fromShortValue(i2);
            BluetoothGattCharacteristic characteristic5 = this.o.getCharacteristic(fromShortValue2);
            if (characteristic5 == null) {
                ZLogger.d(this.i, "not found image version characteristic:" + fromShortValue2.toString());
                return true;
            }
            ZLogger.d(this.h, "find image version characteristic: " + fromShortValue2.toString());
            this.s.add(characteristic5);
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
        if (b().specVersion == 0) {
            if (this.J != null) {
                b(262);
                boolean a6 = a(this.J);
                ZLogger.v(this.j, "read app version :" + a6);
            }
            if (this.K != null) {
                b(263);
                boolean a7 = a(this.K);
                ZLogger.v(this.j, "attempt to read patch version :" + a7);
            }
            if (this.L != null) {
                b(264);
                boolean a8 = a(this.L);
                ZLogger.v(this.j, "attempt to read patch extension version :" + a8);
            }
        }
        if (this.M) {
            k();
        }
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.v) {
            int shortValue = BluetoothUuid.toShortValue(bluetoothGattCharacteristic.getUuid());
            ZLogger.v(this.h, String.format("uuidShortValue=0x%4x", Integer.valueOf(shortValue)));
            if (shortValue >= 65472 && shortValue <= 65487) {
                b(266);
                boolean a9 = a(bluetoothGattCharacteristic);
                ZLogger.d(this.j, "read debug info :" + a9);
            }
        }
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : this.s) {
            int shortValue2 = BluetoothUuid.toShortValue(bluetoothGattCharacteristic2.getUuid());
            ZLogger.v(this.h, String.format("uuidShortValue=0x%4x", Integer.valueOf(shortValue2)));
            if (shortValue2 >= 65504 && shortValue2 <= 65519 && b().specVersion != 0) {
                b(267);
                boolean a10 = a(bluetoothGattCharacteristic2);
                ZLogger.v(this.j, "read image version :" + a10);
            }
        }
        if (this.j) {
            ZLogger.d("readDeviceInfo complete: " + b().toString());
        }
        this.v.clear();
        this.s.clear();
        b(1);
    }

    public final boolean k() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.u;
        if (bluetoothGattCharacteristic == null) {
            ZLogger.d(this.j, "mDfuControlPointCharacteristic is null");
            return false;
        }
        BluetoothGatt bluetoothGatt = this.l;
        if (bluetoothGatt == null) {
            ZLogger.w("mBtGatt is null maybe disconnected just now");
            return false;
        }
        this.N = true;
        if (!a(bluetoothGatt, bluetoothGattCharacteristic, true)) {
            ZLogger.d(this.j, "readTempDeviceInfo failed");
            return false;
        }
        b(265);
        ZLogger.v("attempt to read temp device info ....: ");
        this.u.setValue(new byte[]{13});
        boolean writeCharacteristic = this.l.writeCharacteristic(this.u);
        if (writeCharacteristic) {
            j();
        }
        this.N = true ^ writeCharacteristic;
        return writeCharacteristic;
    }

    @Override // com.realsil.sdk.dfu.l.a
    public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        super.a(bluetoothGatt, bluetoothGattCharacteristic, bArr);
        bluetoothGattCharacteristic.getUuid();
        if (g.c.equals(bluetoothGattCharacteristic.getUuid())) {
            if (bArr != null && bArr.length >= 2) {
                int i = bArr[0] & 255;
                int i2 = bArr[1] & 255;
                byte b = bArr[2];
                if (this.j) {
                    ZLogger.v(String.format("responseType = %02X , requestOpCode = %02X", Integer.valueOf(i), Integer.valueOf(i2)));
                }
                if (i == 16 && i2 == 13) {
                    if (b == 1) {
                        b().parseX0000(bArr, 3);
                    } else {
                        ZLogger.w("Get temp dev info failed");
                    }
                    i();
                    return;
                }
                return;
            }
            ZLogger.w("notification data invalid");
        }
    }
}
