package com.realsil.sdk.dfu.r;

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
import java.util.Arrays;
import java.util.UUID;

/* loaded from: classes11.dex */
public class a extends com.realsil.sdk.dfu.l.a {
    public a(int i, ConnectParams connectParams, String str, BluetoothGatt bluetoothGatt, BluetoothGattService bluetoothGattService, BluetoothGattService bluetoothGattService2, a.c cVar) {
        super(i, connectParams, str, bluetoothGatt, bluetoothGattService, bluetoothGattService2, cVar);
        k();
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
            if (j.c.equals(uuid)) {
                b().parseX0010(bArr);
                i();
                return;
            }
            if (j.b.equals(uuid)) {
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
            int shortValue = BluetoothUuid.toShortValue(uuid);
            if (shortValue >= 65504 && shortValue <= 65519) {
                b().appendImageVersionBytes(bArr);
            } else if (shortValue >= 65472 && shortValue <= 65487) {
                b().appendDebugCharacteristicInfo(shortValue, bArr);
            } else if (shortValue >= 65524 && shortValue <= 65526) {
                b().appendImageSectionSizeBytes(bArr);
            }
            i();
            return;
        }
        ZLogger.w(this.h, "Characteristic read error: " + i);
        if (j.c.equals(uuid)) {
            b(2);
            i();
        } else {
            ZLogger.d("ignore exctption when read other info");
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
                ZLogger.v(this.j, "not found debug characteristic:" + fromShortValue.toString());
                break;
            }
            ZLogger.d(this.j, "find debug characteristic: " + fromShortValue.toString());
            this.v.add(characteristic);
            i++;
        }
        int i2 = 65504;
        while (true) {
            if (i2 > 65519) {
                break;
            }
            UUID fromShortValue2 = BluetoothUuid.fromShortValue(i2);
            BluetoothGattCharacteristic characteristic2 = this.o.getCharacteristic(fromShortValue2);
            if (characteristic2 == null) {
                ZLogger.v(this.j, "not found image version characteristic:" + fromShortValue2.toString());
                break;
            }
            ZLogger.v(this.j, "find image version characteristic: " + fromShortValue2.toString());
            this.s.add(characteristic2);
            i2++;
        }
        for (int i3 = 65524; i3 <= 65526; i3++) {
            UUID fromShortValue3 = BluetoothUuid.fromShortValue(i3);
            BluetoothGattCharacteristic characteristic3 = this.o.getCharacteristic(fromShortValue3);
            if (characteristic3 == null) {
                ZLogger.d(this.h, "not found image session size characteristic:" + fromShortValue3.toString());
                return true;
            }
            ZLogger.d(this.j, "find image session size characteristic: " + fromShortValue3.toString());
            this.v.add(characteristic3);
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
        int i = b().specVersion;
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.v) {
            int shortValue = BluetoothUuid.toShortValue(bluetoothGattCharacteristic.getUuid());
            ZLogger.v(this.j, String.format("uuidShortValue=0x%4x", Integer.valueOf(shortValue)));
            if (shortValue >= 65472 && shortValue <= 65487) {
                b(266);
                boolean a6 = a(bluetoothGattCharacteristic);
                ZLogger.v(this.j, "read debug info :" + a6);
            } else if (shortValue >= 65524 && shortValue <= 65526) {
                b(268);
                boolean a7 = a(bluetoothGattCharacteristic);
                ZLogger.v(this.j, "read image section version :" + a7);
            }
        }
        if (i < 4) {
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : this.s) {
                int shortValue2 = BluetoothUuid.toShortValue(bluetoothGattCharacteristic2.getUuid());
                ZLogger.v(this.j, String.format("uuidShortValue=0x%4x", Integer.valueOf(shortValue2)));
                if (shortValue2 >= 65504 && shortValue2 <= 65519) {
                    b(267);
                    boolean a8 = a(bluetoothGattCharacteristic2);
                    ZLogger.v(this.j, "read image version :" + a8);
                }
            }
        } else {
            BluetoothGattService bluetoothGattService = this.o;
            if (bluetoothGattService != null) {
                BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(BluetoothUuid.fromShortValue(65504));
                b(267);
                boolean a9 = a(characteristic);
                ZLogger.v(this.j, "read image version :" + a9);
            }
            l();
        }
        m();
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

    public final boolean l() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.u;
        if (bluetoothGattCharacteristic == null) {
            return false;
        }
        if (!a(this.l, bluetoothGattCharacteristic, true)) {
            ZLogger.d(this.i, "setCharacteristicNotification failed");
            return false;
        }
        b(269);
        if (this.l != null && this.u != null) {
            ZLogger.v("attempt to read inactive device info ....: ");
            this.u.setValue(new byte[]{13});
            boolean writeCharacteristic = this.l.writeCharacteristic(this.u);
            if (writeCharacteristic) {
                j();
            }
            return writeCharacteristic;
        }
        ZLogger.w("mBtGatt is null maybe disconnected just now");
        return false;
    }

    public final void m() {
        this.x.clear();
        if (this.t != null) {
            if (b().isVpIdOtaSupported()) {
                this.x.add(new OtaModeInfo(24));
            } else {
                this.x.add(new OtaModeInfo(16));
            }
            if (b().isSeqOtaSupported()) {
                this.x.add(new OtaModeInfo(23));
            }
        }
        if (b().leNormalModeSupported && this.p != null) {
            this.x.add(new OtaModeInfo(0));
            if (b().isSeqOtaSupported()) {
                this.x.add(new OtaModeInfo(22));
            }
        }
    }

    @Override // com.realsil.sdk.dfu.l.a
    public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        super.a(bluetoothGatt, bluetoothGattCharacteristic, bArr);
        bluetoothGattCharacteristic.getUuid();
        if (com.realsil.sdk.dfu.q.g.c.equals(bluetoothGattCharacteristic.getUuid())) {
            if (bArr != null && bArr.length >= 2) {
                int i = bArr[0] & 255;
                int i2 = bArr[1] & 255;
                byte b = bArr[2];
                if (this.j) {
                    ZLogger.v(String.format("responseType = %02X , requestOpCode = %02X", Integer.valueOf(i), Integer.valueOf(i2)));
                }
                if (i == 16 && i2 == 13) {
                    if (b == 1) {
                        b().appendImageVersionBytes(Arrays.copyOfRange(bArr, 3, bArr.length - 3));
                    } else {
                        ZLogger.w("Get image version info failed");
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
