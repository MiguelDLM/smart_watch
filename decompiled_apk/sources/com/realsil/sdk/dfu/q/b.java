package com.realsil.sdk.dfu.q;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import com.realsil.sdk.core.bluetooth.impl.BluetoothGattImpl;
import com.realsil.sdk.core.bluetooth.scanner.LeScannerPresenter;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.bluetooth.utils.BluetoothUuid;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import com.realsil.sdk.dfu.DfuConstants;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.l.o;
import com.realsil.sdk.dfu.model.DfuConfig;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.OX00O0xII;

/* loaded from: classes11.dex */
public abstract class b extends com.realsil.sdk.dfu.l.e {
    public BluetoothGattCharacteristic a0;
    public BluetoothGattCharacteristic b0;
    public BluetoothGattCharacteristic c0;
    public List<BluetoothGattCharacteristic> d0;
    public final BluetoothGattCallback e0;
    public byte f0;

    /* loaded from: classes11.dex */
    public class a extends BluetoothGattCallback {
        public a() {
        }

        public final synchronized void a(byte[] bArr) {
            byte b;
            boolean z = true;
            synchronized (this) {
                if (bArr != null) {
                    try {
                        if (bArr.length >= 2) {
                            int i = bArr[0] & 255;
                            int i2 = bArr[1] & 255;
                            if (b.this.VDBG) {
                                ZLogger.v(String.format("responseType = %02X , requestOpCode = %02X", Integer.valueOf(i), Integer.valueOf(i2)));
                            }
                            if (i == 16) {
                                if (i2 == 7) {
                                    synchronized (b.this.p) {
                                        try {
                                            if (b.this.f0 == 7) {
                                                b.this.I = bArr;
                                                b.this.K = true;
                                                b.this.p.notifyAll();
                                            } else {
                                                ZLogger.v(b.this.VDBG, "ignore connection parameters notification");
                                            }
                                        } finally {
                                        }
                                    }
                                } else if (i2 != 8) {
                                    synchronized (b.this.p) {
                                        b.this.I = bArr;
                                        b.this.K = true;
                                        b.this.p.notifyAll();
                                    }
                                } else {
                                    if (bArr.length >= 3) {
                                        b = bArr[2];
                                    } else {
                                        b = 0;
                                    }
                                    ZLogger.v(b.this.DBG, "remote state changed, busyMode=" + ((int) b));
                                    synchronized (b.this.v) {
                                        b bVar = b.this;
                                        if (b != 1) {
                                            z = false;
                                        }
                                        bVar.u = z;
                                        b.this.v.notifyAll();
                                    }
                                }
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                ZLogger.w("notification data invalid");
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            a(bluetoothGattCharacteristic.getValue());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                b.this.mReadRxData = bluetoothGattCharacteristic.getValue();
            } else {
                b.this.mErrorState = i | 1024;
                ZLogger.w(String.format(Locale.US, "read Characteristic error:0x%04X", Integer.valueOf(b.this.mErrorState)));
            }
            b.this.notifyReadLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (i == 0) {
                b.this.mWriteRetransFlag = false;
                if (b.this.U != null && b.this.U.equals(bluetoothGattCharacteristic.getUuid())) {
                    if (value != null) {
                        b.this.getDfuProgressInfo().addBytesSent(value.length);
                        b.this.notifyProcessChanged();
                    } else {
                        ZLogger.w("characteristic'value is null, exception");
                    }
                }
            } else if (i != 257 && i != 143) {
                b.this.mErrorState = i | 1024;
                ZLogger.w(String.format("Characteristic write error: 0x%04X", Integer.valueOf(b.this.mErrorState)));
            } else if (b.this.U != null && b.this.U.equals(bluetoothGattCharacteristic.getUuid())) {
                if (i == 143) {
                    b.this.mWriteRetransFlag = false;
                    if (value != null) {
                        b.this.getDfuProgressInfo().addBytesSent(value.length);
                        b.this.notifyProcessChanged();
                    } else {
                        ZLogger.w("characteristic'value is null, exception");
                    }
                } else {
                    b.this.mWriteRetransFlag = true;
                    if (b.this.DBG) {
                        ZLogger.d("write image packet error, status=" + i + ", please retry.");
                    }
                }
            }
            b.this.g();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i == 0) {
                if (i2 == 2) {
                    b bVar = b.this;
                    if (bVar.mAborted) {
                        ZLogger.w("task already aborted, ignore");
                        return;
                    } else if (bVar.mConnectionState == 256) {
                        BluetoothGattImpl.refresh(bluetoothGatt);
                        b.this.p();
                        return;
                    }
                } else if (i2 == 0) {
                    if (b.this.mProcessState == 521) {
                        b.this.mErrorState = i | 2048;
                        b bVar2 = b.this;
                        if (bVar2.DBG) {
                            ZLogger.d(String.format("disconnect in OTA process, mErrorState: 0x%04X", Integer.valueOf(bVar2.mErrorState)));
                        }
                        b.this.g();
                    }
                    b.this.setConnectionState(0);
                }
            } else {
                if (i2 == 0) {
                    b.this.setConnectionState(0);
                }
                b.this.mErrorState = i | 2048;
            }
            b.this.notifyConnectionLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (i == 0) {
                if (o.f19568a.equals(bluetoothGattDescriptor.getUuid())) {
                    b.this.J = true;
                }
            } else {
                b.this.mErrorState = i | 1024;
            }
            b.this.e();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 0 && b.this.getDfuConfig().isMtuUpdateEnabled()) {
                b.this.d(i);
            }
            b.this.L = true;
            b.this.e();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            super.onPhyUpdate(bluetoothGatt, i, i2, i3);
            b bVar = b.this;
            ZLogger.v(bVar.VDBG, String.format("onPhyUpdate: mConnectionState=0x%04X", Integer.valueOf(bVar.mConnectionState)));
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            b bVar = b.this;
            if (bVar.mAborted) {
                ZLogger.w("task already aborted, ignore");
                return;
            }
            if (i == 0) {
                bVar.u();
                if (b.this.VDBG) {
                    ZLogger.v(BluetoothHelper.dumpBluetoothGattService(bluetoothGatt));
                }
                b.this.e(bluetoothGatt);
                b.this.c(bluetoothGatt);
                b.this.d(bluetoothGatt);
                b.this.setConnectionState(515);
                b.this.notifyConnectionLock();
                return;
            }
            bVar.mErrorState = i | 2048;
            b.this.notifyConnectionLock();
        }
    }

    public b(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
        this.e0 = new a();
        this.f0 = (byte) -1;
    }

    public void A() throws DfuException {
        int i;
        short s;
        int i2;
        short s2;
        if (getOtaDeviceInfo().specVersion == 0) {
            if (this.b0 != null) {
                ZLogger.v("read patch version");
                byte[] a2 = a(this.b0);
                if (a2 != null) {
                    try {
                        ByteBuffer wrap = ByteBuffer.wrap(a2);
                        wrap.order(ByteOrder.LITTLE_ENDIAN);
                        if (getOtaDeviceInfo().icType <= 3) {
                            s2 = wrap.getShort(0);
                        } else {
                            if (getOtaDeviceInfo().icType != 5 && getOtaDeviceInfo().icType != 9 && getOtaDeviceInfo().icType != 12) {
                                s2 = wrap.getShort(0);
                            }
                            i2 = wrap.getInt(0);
                            getOtaDeviceInfo().setPatchVersion(i2);
                        }
                        i2 = s2 & OX00O0xII.f29066Oxx0xo;
                        getOtaDeviceInfo().setPatchVersion(i2);
                    } catch (Exception e) {
                        ZLogger.w(e.toString());
                    }
                }
            }
            if (this.a0 != null) {
                ZLogger.v("read app version");
                byte[] a3 = a(this.a0);
                if (a3 != null) {
                    try {
                        ByteBuffer wrap2 = ByteBuffer.wrap(a3);
                        wrap2.order(ByteOrder.LITTLE_ENDIAN);
                        if (getOtaDeviceInfo().icType <= 3) {
                            s = wrap2.getShort(0);
                        } else {
                            if (getOtaDeviceInfo().icType != 5 && getOtaDeviceInfo().icType != 9 && getOtaDeviceInfo().icType != 12) {
                                s = wrap2.getShort(0);
                            }
                            i = wrap2.getInt(0);
                            getOtaDeviceInfo().setAppVersion(i);
                        }
                        i = s & OX00O0xII.f29066Oxx0xo;
                        getOtaDeviceInfo().setAppVersion(i);
                    } catch (Exception e2) {
                        ZLogger.e(e2.toString());
                    }
                }
            }
            if (this.c0 != null) {
                ZLogger.v("read patch extension version");
                byte[] a4 = a(this.c0);
                if (a4 != null) {
                    ByteBuffer wrap3 = ByteBuffer.wrap(a4);
                    wrap3.order(ByteOrder.LITTLE_ENDIAN);
                    getOtaDeviceInfo().setPatchExtensionVersion(wrap3.getShort(0) & OX00O0xII.f29066Oxx0xo);
                    return;
                }
                return;
            }
            return;
        }
        List<BluetoothGattCharacteristic> list = this.d0;
        byte[] bArr = null;
        if (list != null && list.size() > 0) {
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.d0) {
                if (this.VDBG) {
                    ZLogger.v("read image version : " + bluetoothGattCharacteristic.getUuid().toString());
                } else {
                    ZLogger.v("read image version");
                }
                byte[] a5 = a(bluetoothGattCharacteristic);
                if (a5 != null) {
                    if (bArr == null) {
                        bArr = a5;
                    } else {
                        byte[] bArr2 = new byte[bArr.length + a5.length];
                        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                        System.arraycopy(a5, 0, bArr2, bArr.length, a5.length);
                        bArr = bArr2;
                    }
                }
            }
            getOtaDeviceInfo().setImageVersionValues(bArr);
            return;
        }
        getOtaDeviceInfo().setImageVersionValues(null);
        ZLogger.v(this.DBG, "no ImageVersionCharacteristics to read");
    }

    public boolean B() throws DfuException {
        if (this.S == null) {
            return false;
        }
        if (this.VDBG) {
            ZLogger.v("start to read remote dev Mac Addr info");
        }
        byte[] a2 = a(this.S);
        if (a2 != null && a2.length >= 6) {
            byte[] bArr = new byte[6];
            System.arraycopy(a2, 0, bArr, 0, 6);
            getOtaDeviceInfo().setDeviceMac(bArr);
            return true;
        }
        ZLogger.w("Get remote dev Mac Addr info failed, do nothing.");
        throw new OtaException("remote dev Mac Addr info error", 277);
    }

    public void C() throws DfuException {
        ZLogger.d(this.DBG, "<<  OPCODE_DFU_REPORT_CURRENT_BUFFER_SIZE(0x0A)");
        a(this.X, new byte[]{10}, false);
        if (this.VDBG) {
            ZLogger.d("... Reading OPCODE_DFU_REPORT_CURRENT_BUFFER_SIZE notification");
        }
        byte[] q = q();
        byte b = q[2];
        if (b == 1) {
            ByteBuffer wrap = ByteBuffer.wrap(q);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int i = wrap.getInt(3);
            ZLogger.v(String.format(Locale.US, "maxBufferCheckSize=(0x%04X, %d)", Integer.valueOf(i), Integer.valueOf(i)));
            a(i);
            return;
        }
        ZLogger.w("Get remote buffer size info failed, status: " + ((int) b));
        throw new OtaException("Get remote buffer size info failed", b | 512);
    }

    public int D() throws DfuException {
        byte[] b;
        byte b2;
        if (this.X == null) {
            ZLogger.w("no mControlPointCharacteristic found");
            return 0;
        }
        ZLogger.v("<< OPCODE_DFU_REPORT_OTA_FUNCTION_VERSION(0x09)");
        a(this.X, new byte[]{9}, false);
        try {
            if (this.DBG) {
                ZLogger.d("Reading OPCODE_DFU_REPORT_OTA_FUNCTION_VERSION notification");
            }
            b = b(1600L);
            b2 = b[2];
        } catch (DfuException unused) {
            ZLogger.w("Reading OPCODE_DFU_REPORT_OTA_FUNCTION_VERSION notification failed, just think remote is normal function.");
            this.mErrorState = 0;
        }
        if (b2 == 1) {
            ByteBuffer.wrap(b).order(ByteOrder.LITTLE_ENDIAN);
            return 1;
        }
        ZLogger.w("reportOtaFunctionVersion failed, status: " + ((int) b2));
        return 0;
    }

    public boolean E() {
        try {
            ZLogger.d(this.DBG, "<< OPCODE_DFU_RESET_SYSTEM (0x05)");
            return a(this.X, new byte[]{5}, true);
        } catch (DfuException e) {
            ZLogger.w(String.format("Send OPCODE_DFU_RESET_SYSTEM failed, ignore it, errorcode= 0x%04X", Integer.valueOf(e.getErrCode())));
            this.mErrorState = 0;
            return false;
        }
    }

    public void F() throws DfuException {
        ZLogger.v("<< OPCODE_DFU_START_DFU(0x01)");
        byte[] bArr = new byte[16];
        System.arraycopy(this.mCurBinInputStream.getHeaderBuf(), 0, bArr, 0, 12);
        byte[] bArr2 = new byte[17];
        bArr2[0] = 1;
        if (getOtaDeviceInfo().isAesEncryptEnabled()) {
            System.arraycopy(this.l.aesEncrypt(bArr, 0, 16), 0, bArr2, 1, 16);
        } else {
            System.arraycopy(bArr, 0, bArr2, 1, 16);
        }
        a(this.X, bArr2, false);
        if (this.DBG) {
            ZLogger.v("... Reading OPCODE_DFU_START_DFU(0x01) notification");
        }
        byte b = q()[2];
        if (b == 1) {
            return;
        }
        ZLogger.e(String.format("0x%02X(not supported), start dfu failed", Byte.valueOf(b)));
        throw new OtaException("start dfu failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    public void G() throws DfuException {
        ZLogger.d("<< OPCODE_DFU_CONNECTION_PARAMETER_UPDATE(0x07)");
        this.f0 = (byte) 7;
        a((byte) 7);
        this.f0 = (byte) -1;
    }

    public void x() throws DfuException {
        b(new byte[]{4});
    }

    public void y() {
        if (getDfuConfig().getActiveImageDelayTime().longValue() > 0) {
            sleepInner(getDfuConfig().getActiveImageDelayTime().longValue());
        }
    }

    public int z() throws DfuException {
        byte[] b;
        if (this.X == null) {
            ZLogger.w("no mControlPointCharacteristic found");
            return 0;
        }
        ZLogger.d("<< OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE(0x09)");
        a(this.X, new byte[]{9}, false);
        try {
            if (this.VDBG) {
                ZLogger.v("... Reading OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE notification");
            }
            b = b(1600L);
        } catch (DfuException unused) {
            ZLogger.w("Read OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE exception, just think remote is normal function.");
            this.mErrorState = 0;
        }
        if (b[2] == 1) {
            ByteBuffer wrap = ByteBuffer.wrap(b);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int i = (((short) (wrap.get(4) & 255)) << 8) | ((short) (wrap.get(3) & 255));
            int i2 = ((short) (wrap.get(5) & 255)) | (((short) (wrap.get(6) & 255)) << 8);
            if (this.DBG) {
                ZLogger.v("maxBufferSize=" + i + ", bufferCheckMtuSize=" + i2);
            }
            a(i);
            c(i2);
            return 1;
        }
        ZLogger.d("Read OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE failed, just think remote is normal function.");
        return 0;
    }

    public boolean f(int i) throws DfuException {
        ZLogger.d(String.format("<< OPCODE_DFU_CHECK_CURRENT_BUFFER(0x0B) , crc=0x%04X", Integer.valueOf(i)));
        a(this.X, new byte[]{11}, false);
        if (this.DBG) {
            ZLogger.d("... waiting CHECK_CURRENT_BUFFER response");
        }
        byte[] q = q();
        byte b = q[2];
        if (b == 1) {
            int i2 = ((q[4] << 8) & 65280) | (q[3] & 255);
            if (i2 == i) {
                return true;
            }
            ZLogger.w("CRC check error, local: " + i + ", remote : " + i2);
        } else {
            ZLogger.w("check current buffer failed, status: " + ((int) b));
        }
        return false;
    }

    public void g(int i) throws DfuException {
        int i2;
        if (this.DBG) {
            ZLogger.d("<< OPCODE_DFU_REPORT_TARGET_IMAGE_INFO(0x06)");
        }
        a(this.X, new byte[]{6, (byte) (i & 255), (byte) ((i >> 8) & 255)}, false);
        if (this.DBG) {
            ZLogger.v("... Reading OPCODE_DFU_REPORT_TARGET_IMAGE_INFO(0x06) notification");
        }
        byte[] q = q();
        int length = q != null ? q.length : 0;
        if ((length > 2 ? q[2] : (byte) -2) == 1) {
            ByteBuffer wrap = ByteBuffer.wrap(q);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            if (length >= 11) {
                i2 = wrap.getShort(3) & OX00O0xII.f29066Oxx0xo;
                this.mImageUpdateOffset = wrap.getInt(7);
            } else if (length >= 9) {
                i2 = wrap.getShort(3) & OX00O0xII.f29066Oxx0xo;
                this.mImageUpdateOffset = wrap.getInt(5);
            } else {
                this.mImageUpdateOffset = 0;
                i2 = 0;
            }
            ZLogger.d(String.format(Locale.US, "mOriginalFwVersion=%d, mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i2), Integer.valueOf(this.mImageUpdateOffset), Integer.valueOf(this.mImageUpdateOffset)));
            return;
        }
        ZLogger.e(String.format("0x%02X, Get target image info failed", Integer.valueOf(DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED)));
        throw new OtaException("Get target image info failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    public void h(int i) throws DfuException {
        int i2 = this.mImageUpdateOffset;
        if (i2 == 0) {
            this.mImageUpdateOffset = 12;
            if (this.DBG) {
                ZLogger.v(String.format(Locale.US, "First Packet, mImageUpdateOffset=0x%08X(%d)", 12, Integer.valueOf(this.mImageUpdateOffset)));
            }
        } else if (this.DBG) {
            ZLogger.v(String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i2), Integer.valueOf(this.mImageUpdateOffset)));
        }
        a(i, this.mImageUpdateOffset);
        if (this.mImageUpdateOffset == getDfuProgressInfo().getBytesSent() + 12 || this.mImageUpdateOffset == -1) {
            return;
        }
        if (this.DBG) {
            ZLogger.d(String.format(Locale.US, "mBytesSent(%d) != mImageUpdateOffset(%d), reload image bin file", Integer.valueOf(getDfuProgressInfo().getBytesSent() + 12), Integer.valueOf(this.mImageUpdateOffset)));
        }
        this.imageFileLoaded = false;
        l();
        alignmentSendBytes(this.mImageUpdateOffset, false);
    }

    public void i(int i) throws DfuException {
        ZLogger.d("<< OPCODE_DFU_VALIDATE_FW_IMAGE (0x03)");
        a(this.X, new byte[]{3, (byte) (i & 255), (byte) ((i >> 8) & 255)}, false);
        int i2 = 10000;
        if ((getOtaDeviceInfo().icType == 5 || getOtaDeviceInfo().icType == 9 || getOtaDeviceInfo().icType == 12) && getDfuProgressInfo().getImageSizeInBytes() > 2097152) {
            i2 = Math.max(((getDfuProgressInfo().getImageSizeInBytes() / 1048576) + 1) * 4000, 10000);
        }
        if (this.DBG) {
            ZLogger.d("... waiting DFU_VALIDATE_FW_IMAGE response for " + i2);
        }
        byte b = b(i2)[2];
        if (b == 1) {
            return;
        }
        if (b == 5) {
            ZLogger.e(String.format("0x%02X, Validate FW failed, CRC check error", Byte.valueOf(b)));
            throw new OtaException("Validate FW failed", 517);
        }
        ZLogger.e(String.format("0x%02X(not supported), Validate FW failed", Byte.valueOf(b)));
        throw new OtaException("Validate FW failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    public int c(String str) {
        return a(str, this.e0);
    }

    @Override // com.realsil.sdk.dfu.l.e
    public boolean e(BluetoothGatt bluetoothGatt) {
        if (!super.e(bluetoothGatt)) {
            return false;
        }
        BluetoothGattService bluetoothGattService = this.P;
        UUID uuid = h.c;
        BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(uuid);
        this.b0 = characteristic;
        if (characteristic == null) {
            ZLogger.d("OTA_READ_PATCH_CHARACTERISTIC_UUID not found:" + uuid);
        } else if (this.VDBG) {
            ZLogger.v("find OTA_PATCH_VERSION_CHARACTERISTIC_UUID: " + uuid.toString());
            ZLogger.v(BluetoothGattImpl.parseProperty2(this.b0.getProperties()));
        }
        BluetoothGattService bluetoothGattService2 = this.P;
        UUID uuid2 = h.d;
        BluetoothGattCharacteristic characteristic2 = bluetoothGattService2.getCharacteristic(uuid2);
        this.a0 = characteristic2;
        if (characteristic2 == null) {
            ZLogger.d("OTA_READ_APP_CHARACTERISTIC_UUID not found: " + uuid2);
        } else if (this.VDBG) {
            ZLogger.v("find OTA_APP_VERSION_CHARACTERISTIC_UUID: " + uuid2.toString());
            ZLogger.v(BluetoothGattImpl.parseProperty2(this.a0.getProperties()));
        }
        BluetoothGattService bluetoothGattService3 = this.P;
        UUID uuid3 = h.e;
        BluetoothGattCharacteristic characteristic3 = bluetoothGattService3.getCharacteristic(uuid3);
        this.c0 = characteristic3;
        if (characteristic3 == null) {
            ZLogger.d("OTA_PATCH_EXTENSION_VERSION_CHARACTERISTIC_UUID not found:" + uuid3);
        } else if (this.VDBG) {
            ZLogger.v("find OTA_PATCH_EXTENSION_VERSION_CHARACTERISTIC_UUID: " + uuid3.toString());
            ZLogger.v(BluetoothGattImpl.parseProperty2(this.c0.getProperties()));
        }
        this.d0 = new ArrayList();
        for (int i = 65504; i < 65519; i++) {
            UUID fromShortValue = BluetoothUuid.fromShortValue(i);
            BluetoothGattCharacteristic characteristic4 = this.P.getCharacteristic(fromShortValue);
            if (characteristic4 == null) {
                if (!this.VDBG) {
                    return true;
                }
                ZLogger.v("not found image version characteristic:" + fromShortValue.toString());
                return true;
            }
            if (this.VDBG) {
                ZLogger.v("find image version characteristic: " + fromShortValue.toString());
                ZLogger.v(BluetoothGattImpl.parseProperty2(characteristic4.getProperties()));
            }
            this.d0.add(characteristic4);
        }
        return true;
    }

    public void b(boolean z) throws DfuException {
        ZLogger.d("<< OPCODE_DFU_ENSURE_CURRENT_BUFFER(0x0C)");
        a(this.X, new byte[]{12, !z ? 1 : 0}, false);
    }

    public void a(int i, int i2) throws DfuException {
        ZLogger.d(this.DBG, "<< OPCODE_DFU_RECEIVE_FW_IMAGE (0x02)");
        a(this.X, new byte[]{2, (byte) (i & 255), (byte) ((i >> 8) & 255), (byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)}, false);
    }

    public boolean b(byte[] bArr, int i) throws DfuException {
        if (bArr == null) {
            ZLogger.w("buffer == null");
            return false;
        }
        short a2 = a(bArr, i);
        if (this.VDBG) {
            ZLogger.v(String.format(Locale.US, "bufferCheck (%d) >> (%d) %s", Short.valueOf(a2), Integer.valueOf(i), DataConverter.bytes2Hex(bArr)));
        }
        if (this.DBG) {
            ZLogger.d("<< OPCODE_DFU_REPORT_BUFFER_CRC(0x0A)");
        }
        a(this.X, new byte[]{10, (byte) (i & 255), (byte) (i >> 8), (byte) (a2 & 255), (byte) ((a2 >> 8) & 255)}, false);
        if (this.VDBG) {
            ZLogger.v("... waiting OPCODE_DFU_REPORT_BUFFER_CRC(0x0A) response");
        }
        byte[] q = q();
        byte b = q[2];
        ByteBuffer wrap = ByteBuffer.wrap(q);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        this.mImageUpdateOffset = wrap.getInt(3);
        if (this.VDBG) {
            ZLogger.v(String.format(Locale.US, "status:0x%04X, mImageUpdateOffset=0x%08X(%d)", Byte.valueOf(b), Integer.valueOf(this.mImageUpdateOffset), Integer.valueOf(this.mImageUpdateOffset)));
        }
        if (b == 1) {
            return true;
        }
        if (b == 5 || b == 6 || b == 7) {
            return false;
        }
        if (b != 8) {
            throw new OtaException("ERROR_OPCODE_RESPONSE_NOT_SUPPORTED", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
        throw new OtaException("DFU_STATUS_FLASH_ERASE_ERROR", b | 512);
    }

    @Override // com.realsil.sdk.dfu.internal.base.BaseDfuTask
    public void a(int i, boolean z) {
        if (this.mAborted) {
            i = DfuException.ERROR_DFU_ABORTED;
        }
        if (i != 4128) {
            notifyStateChanged(260, true);
        }
        ZLogger.v(String.format("error = 0x%04X, needReset=%b", Integer.valueOf(i), Boolean.valueOf(z)));
        if (z) {
            E();
        }
        LeScannerPresenter leScannerPresenter = this.D;
        if (leScannerPresenter != null) {
            leScannerPresenter.stopScan();
        }
        closeInputStream(this.mCurBinInputStream);
        if (getDfuConfig().isErrorActionEnabled(1)) {
            e(i);
        }
        DfuThreadCallback dfuThreadCallback = this.mThreadCallback;
        if (dfuThreadCallback != null) {
            dfuThreadCallback.onError(i);
        }
        this.mAborted = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0061, code lost:
    
        if (r2 != (getDfuProgressInfo().getBytesSent() + r9)) goto L17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0074 A[Catch: IOException -> 0x0223, TryCatch #0 {IOException -> 0x0223, blocks: (B:76:0x0053, B:78:0x0058, B:13:0x0070, B:15:0x0074, B:17:0x0089, B:18:0x0090, B:19:0x00b1, B:21:0x00b5, B:22:0x00c8, B:24:0x00d2, B:26:0x00de, B:74:0x009f, B:12:0x0063), top: B:75:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b5 A[Catch: IOException -> 0x0223, TryCatch #0 {IOException -> 0x0223, blocks: (B:76:0x0053, B:78:0x0058, B:13:0x0070, B:15:0x0074, B:17:0x0089, B:18:0x0090, B:19:0x00b1, B:21:0x00b5, B:22:0x00c8, B:24:0x00d2, B:26:0x00de, B:74:0x009f, B:12:0x0063), top: B:75:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d2 A[Catch: IOException -> 0x0223, TryCatch #0 {IOException -> 0x0223, blocks: (B:76:0x0053, B:78:0x0058, B:13:0x0070, B:15:0x0074, B:17:0x0089, B:18:0x0090, B:19:0x00b1, B:21:0x00b5, B:22:0x00c8, B:24:0x00d2, B:26:0x00de, B:74:0x009f, B:12:0x0063), top: B:75:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x009f A[Catch: IOException -> 0x0223, TryCatch #0 {IOException -> 0x0223, blocks: (B:76:0x0053, B:78:0x0058, B:13:0x0070, B:15:0x0074, B:17:0x0089, B:18:0x0090, B:19:0x00b1, B:21:0x00b5, B:22:0x00c8, B:24:0x00d2, B:26:0x00de, B:74:0x009f, B:12:0x0063), top: B:75:0x0053 }] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.bluetooth.BluetoothGatt r19, android.bluetooth.BluetoothGattCharacteristic r20, com.realsil.sdk.dfu.image.stream.BaseBinInputStream r21) throws com.realsil.sdk.dfu.DfuException {
        /*
            Method dump skipped, instructions count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.q.b.a(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattCharacteristic, com.realsil.sdk.dfu.image.stream.BaseBinInputStream):void");
    }

    public void b(byte b) throws DfuException {
        b(new byte[]{4, b});
    }

    public void b(byte[] bArr) throws DfuException {
        int errCode;
        notifyStateChanged(DfuConstants.PROGRESS_ACTIVE_IMAGE_AND_RESET);
        boolean z = false;
        try {
            ZLogger.d(this.DBG, "<< OPCODE_DFU_ACTIVE_IMAGE_RESET(0x04)");
            z = a(this.X, bArr, false);
            errCode = 0;
        } catch (DfuException e) {
            if (e.getErrCode() == 4128) {
                errCode = DfuException.ERROR_DFU_ABORTED;
            } else if (!getDfuConfig().isWaitActiveCmdAckEnabled()) {
                ZLogger.d("active cmd has no response, ignore");
                errCode = 0;
                z = true;
            } else {
                ZLogger.w("active cmd has no response, notify error");
                errCode = e.getErrCode();
            }
        }
        if (z) {
            ZLogger.d(this.DBG, "image active success");
            e(this.mErrorState);
            closeInputStream(this.mCurBinInputStream);
            return;
        }
        throw new OtaException(errCode);
    }
}
