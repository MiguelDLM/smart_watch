package com.realsil.sdk.dfu.w;

import com.realsil.sdk.core.bluetooth.utils.BluetoothUuid;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.usb.UsbGatt;
import com.realsil.sdk.core.usb.UsbGattCharacteristic;
import com.realsil.sdk.core.utility.DataConverter;
import com.realsil.sdk.dfu.l.g;
import com.realsil.sdk.dfu.model.OtaModeInfo;
import com.realsil.sdk.dfu.q.h;
import com.realsil.sdk.dfu.w.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import kotlin.OX00O0xII;

/* loaded from: classes11.dex */
public class a extends com.realsil.sdk.dfu.w.b {
    public UsbGattCharacteristic r;
    public UsbGattCharacteristic s;
    public UsbGattCharacteristic t;
    public UsbGattCharacteristic u;
    public UsbGattCharacteristic v;
    public b w;
    public boolean x = false;

    /* loaded from: classes11.dex */
    public class b extends Thread {
        public b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            setName("AdapterXU0000-DeviceInfoThread");
            a.this.b(257);
            if (a.this.s != null) {
                a aVar = a.this;
                if (aVar.j.contains(aVar.s)) {
                    a.this.b(260);
                    a aVar2 = a.this;
                    boolean a2 = aVar2.a(aVar2.s);
                    a aVar3 = a.this;
                    aVar3.j.remove(aVar3.s);
                    ZLogger.v("read device info :" + a2);
                    if (a2) {
                        a.this.g();
                    }
                }
            }
            if (a.this.r != null) {
                a aVar4 = a.this;
                if (aVar4.j.contains(aVar4.r)) {
                    a.this.b(261);
                    a aVar5 = a.this;
                    boolean a3 = aVar5.a(aVar5.r);
                    a aVar6 = a.this;
                    aVar6.j.remove(aVar6.r);
                    ZLogger.v("read device mac :" + a3);
                    if (a3) {
                        a.this.g();
                    }
                }
            }
            if (a.this.t != null) {
                a aVar7 = a.this;
                if (aVar7.j.contains(aVar7.t)) {
                    if (a.this.b().specVersion == 0) {
                        a.this.b(262);
                        a aVar8 = a.this;
                        boolean a4 = aVar8.a(aVar8.t);
                        a aVar9 = a.this;
                        aVar9.j.remove(aVar9.t);
                        ZLogger.v("read app version :" + a4);
                        if (a4) {
                            a.this.g();
                        }
                    } else {
                        a aVar10 = a.this;
                        aVar10.j.remove(aVar10.t);
                    }
                }
            }
            if (a.this.u != null) {
                a aVar11 = a.this;
                if (aVar11.j.contains(aVar11.u)) {
                    if (a.this.b().specVersion == 0) {
                        a.this.b(263);
                        a aVar12 = a.this;
                        boolean a5 = aVar12.a(aVar12.u);
                        a aVar13 = a.this;
                        aVar13.j.remove(aVar13.u);
                        ZLogger.v("attempt to read patch version :" + a5);
                        if (a5) {
                            a.this.g();
                        }
                    } else {
                        a aVar14 = a.this;
                        aVar14.j.remove(aVar14.u);
                    }
                }
            }
            if (a.this.v != null) {
                a aVar15 = a.this;
                if (aVar15.j.contains(aVar15.v)) {
                    if (a.this.b().specVersion == 0) {
                        a.this.b(264);
                        a aVar16 = a.this;
                        boolean a6 = aVar16.a(aVar16.v);
                        a aVar17 = a.this;
                        aVar17.j.remove(aVar17.v);
                        ZLogger.v("attempt to read patch extension version :" + a6);
                        if (a6) {
                            a.this.g();
                        }
                    } else {
                        a aVar18 = a.this;
                        aVar18.j.remove(aVar18.v);
                    }
                }
            }
            for (UsbGattCharacteristic usbGattCharacteristic : a.this.j) {
                int shortValue = BluetoothUuid.toShortValue(usbGattCharacteristic.getUuid());
                ZLogger.v(false, String.format("uuidShortValue=0x%4x", Integer.valueOf(shortValue)));
                if (shortValue >= 65472 && shortValue <= 65487) {
                    a.this.b(266);
                    ZLogger.v(false, "read debug info :" + a.this.a(usbGattCharacteristic));
                    a.this.g();
                } else if (shortValue >= 65504 && shortValue <= 65519 && a.this.b().specVersion != 0) {
                    a.this.b(267);
                    ZLogger.d("read image version :" + a.this.a(usbGattCharacteristic));
                    a.this.g();
                }
            }
            ZLogger.v(false, "no more characteristic to read");
            ZLogger.d(a.this.b().toString());
            a.this.j.clear();
            a.this.b(1);
        }
    }

    public a(int i) {
        this.h = i;
    }

    public final void h() {
        UUID fromShortValue;
        UsbGattCharacteristic characteristic;
        UsbGatt usbGatt = this.i;
        if (usbGatt == null) {
            return;
        }
        UUID uuid = h.b;
        UsbGattCharacteristic characteristic2 = usbGatt.getCharacteristic(uuid);
        this.r = characteristic2;
        if (characteristic2 == null) {
            ZLogger.w("OTA_DEVICE_MAC_CHARACTERISTIC_UUID not found");
        } else {
            ZLogger.d(true, "find OTA_DEVICE_MAC_CHARACTERISTIC_UUID = " + uuid);
            this.j.add(this.r);
        }
        UsbGatt usbGatt2 = this.i;
        UUID uuid2 = h.c;
        UsbGattCharacteristic characteristic3 = usbGatt2.getCharacteristic(uuid2);
        this.u = characteristic3;
        if (characteristic3 == null) {
            ZLogger.d("OTA_READ_PATCH_CHARACTERISTIC_UUID not found");
        } else {
            ZLogger.v(false, "find OTA_READ_PATCH_CHARACTERISTIC_UUID = " + uuid2);
            this.j.add(this.u);
        }
        UsbGatt usbGatt3 = this.i;
        UUID uuid3 = h.d;
        UsbGattCharacteristic characteristic4 = usbGatt3.getCharacteristic(uuid3);
        this.t = characteristic4;
        if (characteristic4 == null) {
            ZLogger.d("OTA_APP_VERSION_CHARACTERISTIC_UUID not found");
        } else {
            ZLogger.v(false, "find OTA_APP_VERSION_CHARACTERISTIC_UUID = " + uuid3);
            this.j.add(this.t);
        }
        UsbGatt usbGatt4 = this.i;
        UUID uuid4 = h.e;
        UsbGattCharacteristic characteristic5 = usbGatt4.getCharacteristic(uuid4);
        this.v = characteristic5;
        if (characteristic5 == null) {
            ZLogger.d("OTA_READ_PATCH_EXTENSION_CHARACTERISTIC_UUID not found");
        } else {
            ZLogger.v(false, "find OTA_READ_PATCH_EXTENSION_CHARACTERISTIC_UUID = " + uuid4);
            this.j.add(this.v);
        }
        UsbGatt usbGatt5 = this.i;
        UUID uuid5 = h.g;
        UsbGattCharacteristic characteristic6 = usbGatt5.getCharacteristic(uuid5);
        this.s = characteristic6;
        if (characteristic6 == null) {
            ZLogger.d("OTA_DEVICE_INFO_CHARACTERISTIC_UUID not found");
        } else {
            ZLogger.v(false, "find OTA_DEVICE_INFO_CHARACTERISTIC_UUID = " + uuid5);
            this.j.add(this.s);
        }
        for (int i = 65472; i <= 65487 && (characteristic = this.i.getCharacteristic((fromShortValue = BluetoothUuid.fromShortValue(i)))) != null; i++) {
            ZLogger.v(false, "find debug characteristic: " + fromShortValue.toString());
            this.j.add(characteristic);
        }
        for (int i2 = 65504; i2 <= 65519; i2++) {
            UUID fromShortValue2 = BluetoothUuid.fromShortValue(i2);
            UsbGattCharacteristic characteristic7 = this.i.getCharacteristic(fromShortValue2);
            if (characteristic7 == null) {
                ZLogger.d(true, "not found image version characteristic:" + fromShortValue2.toString());
                return;
            }
            ZLogger.d(true, "find image version characteristic: " + fromShortValue2.toString());
            this.j.add(characteristic7);
        }
    }

    @Override // com.realsil.sdk.dfu.w.b
    public void a(String str, UsbGatt usbGatt, b.InterfaceC0923b interfaceC0923b) {
        super.a(str, usbGatt, interfaceC0923b);
        h();
        this.l.add(new OtaModeInfo(16));
    }

    @Override // com.realsil.sdk.dfu.w.b
    public void e() {
        b bVar = new b();
        this.w = bVar;
        bVar.start();
    }

    @Override // com.realsil.sdk.dfu.w.b
    public void a() {
        super.a();
        b bVar = this.w;
        if (bVar != null) {
            bVar.interrupt();
            this.w = null;
        }
    }

    @Override // com.realsil.sdk.dfu.w.b
    public void a(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic, int i) {
        super.a(usbGatt, usbGattCharacteristic, i);
        UUID uuid = usbGattCharacteristic.getUuid();
        usbGattCharacteristic.getValue();
        if (i == 0) {
            byte[] value = usbGattCharacteristic.getValue();
            int length = value != null ? value.length : 0;
            if (com.realsil.sdk.dfu.l.b.b.equals(uuid)) {
                if (value.length > 0) {
                    int i2 = value[0] & 255;
                    ZLogger.v("current battery: " + i2);
                    b().setBatteryLevel(i2);
                }
                f();
                return;
            }
            if (g.e.equals(uuid)) {
                ZLogger.v("PNP_ID: " + DataConverter.bytes2Hex(value));
                b().setPnpId(value);
                f();
                return;
            }
            if (h.g.equals(uuid)) {
                b().parseX0000(value);
                f();
                return;
            }
            if (h.b.equals(uuid)) {
                if (length > 0) {
                    ByteBuffer wrap = ByteBuffer.wrap(value);
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                    if (length >= 6) {
                        byte[] bArr = new byte[6];
                        wrap.get(bArr, 0, 6);
                        b().setDeviceMac(bArr);
                    }
                }
                f();
                return;
            }
            if (h.c.equals(uuid)) {
                if (length > 0) {
                    ByteBuffer wrap2 = ByteBuffer.wrap(value);
                    wrap2.order(ByteOrder.LITTLE_ENDIAN);
                    if (length == 2) {
                        b().setPatchVersion(wrap2.getShort(0) & OX00O0xII.f29066Oxx0xo);
                    } else if (length >= 4) {
                        b().setPatchVersion(wrap2.getInt(0) & 65535);
                    }
                }
                f();
                return;
            }
            if (h.d.equals(uuid)) {
                if (length > 0) {
                    ByteBuffer wrap3 = ByteBuffer.wrap(value);
                    wrap3.order(ByteOrder.LITTLE_ENDIAN);
                    if (length == 2) {
                        b().setAppVersion(wrap3.getShort(0) & OX00O0xII.f29066Oxx0xo);
                    } else if (length >= 4) {
                        b().setAppVersion(wrap3.getInt(0));
                    }
                }
                f();
                return;
            }
            if (h.e.equals(uuid)) {
                ByteBuffer wrap4 = ByteBuffer.wrap(value);
                wrap4.order(ByteOrder.LITTLE_ENDIAN);
                if (length == 1) {
                    b().setPatchExtensionVersion(wrap4.get(0));
                } else if (length == 2) {
                    b().setPatchExtensionVersion(wrap4.getShort(0) & OX00O0xII.f29066Oxx0xo);
                }
                f();
                return;
            }
            int shortValue = BluetoothUuid.toShortValue(uuid);
            if (shortValue >= 65504 && shortValue <= 65519) {
                b().appendActiveImageVersionBytes(value);
            } else if (shortValue >= 65472 && shortValue <= 65487) {
                b().appendDebugCharacteristicInfo(shortValue, value);
            }
            f();
            return;
        }
        ZLogger.w(true, "Characteristic read error: " + i);
        if (h.g.equals(uuid)) {
            b(2);
        } else {
            ZLogger.d("ignore exctption when read other info");
        }
    }

    @Override // com.realsil.sdk.dfu.w.b
    public void a(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic) {
        super.a(usbGatt, usbGattCharacteristic);
        usbGattCharacteristic.getUuid();
        byte[] value = usbGattCharacteristic.getValue();
        if (com.realsil.sdk.dfu.q.g.c.equals(usbGattCharacteristic.getUuid())) {
            if (value != null && value.length >= 2) {
                int i = value[0] & 255;
                int i2 = value[1] & 255;
                byte b2 = value[2];
                if (i == 16 && i2 == 13) {
                    if (b2 == 1) {
                        b().parseX0000(value, 3);
                    } else {
                        ZLogger.w("Get temp dev info failed");
                    }
                    f();
                    return;
                }
                return;
            }
            ZLogger.w("notification data invalid");
        }
    }
}
