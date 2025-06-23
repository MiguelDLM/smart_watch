package com.realsil.sdk.dfu.m;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
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
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.l.i;
import com.realsil.sdk.dfu.l.k;
import com.realsil.sdk.dfu.l.l;
import com.realsil.sdk.dfu.l.o;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.utils.DfuUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.OX00O0xII;

/* loaded from: classes11.dex */
public abstract class d extends com.realsil.sdk.dfu.l.e {
    public List<BluetoothGattCharacteristic> a0;
    public final BluetoothGattCallback b0;

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
                            if (d.this.VDBG) {
                                ZLogger.v(String.format("responseType = %02X , requestOpCode = %02X", Integer.valueOf(i), Integer.valueOf(i2)));
                            }
                            if (i == 16) {
                                if (i2 == 7) {
                                    synchronized (d.this.p) {
                                        ZLogger.d("ignore connection parameters notification");
                                        d.this.I = bArr;
                                        d.this.K = true;
                                        d.this.p.notifyAll();
                                    }
                                } else if (i2 != 8) {
                                    synchronized (d.this.p) {
                                        d.this.I = bArr;
                                        d.this.K = true;
                                        d.this.p.notifyAll();
                                    }
                                } else {
                                    if (bArr.length >= 3) {
                                        b = bArr[2];
                                    } else {
                                        b = 0;
                                    }
                                    ZLogger.d("remote state changed, busyMode=" + ((int) b));
                                    synchronized (d.this.v) {
                                        d dVar = d.this;
                                        if (b != 1) {
                                            z = false;
                                        }
                                        dVar.u = z;
                                        d.this.v.notifyAll();
                                    }
                                }
                            }
                            return;
                        }
                    } finally {
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
                d.this.mReadRxData = bluetoothGattCharacteristic.getValue();
            } else {
                d.this.mErrorState = i | 1024;
                ZLogger.w(String.format(Locale.US, "read Characteristic error:0x%04X", Integer.valueOf(d.this.mErrorState)));
            }
            d.this.notifyReadLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (i == 0) {
                d.this.mWriteRetransFlag = false;
                if (d.this.U != null && d.this.U.equals(bluetoothGattCharacteristic.getUuid())) {
                    if (value != null) {
                        d.this.getDfuProgressInfo().addBytesSent(value.length);
                        d.this.notifyProcessChanged();
                    } else {
                        ZLogger.w("characteristic'value is null, exception");
                    }
                }
            } else if (i != 257 && i != 143) {
                d.this.mErrorState = i | 1024;
                ZLogger.w(String.format("Characteristic write error: 0x%04X", Integer.valueOf(d.this.mErrorState)));
            } else if (d.this.U != null && d.this.U.equals(bluetoothGattCharacteristic.getUuid())) {
                if (i == 143) {
                    d.this.mWriteRetransFlag = false;
                    if (value != null) {
                        d.this.getDfuProgressInfo().addBytesSent(value.length);
                        d.this.notifyProcessChanged();
                    } else {
                        ZLogger.w("characteristic'value is null, exception");
                    }
                } else {
                    d.this.mWriteRetransFlag = true;
                    if (d.this.DBG) {
                        ZLogger.d("write image packet error, status=" + i + ", please retry.");
                    }
                }
            }
            d.this.g();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i == 0) {
                if (i2 == 2) {
                    d dVar = d.this;
                    if (dVar.mAborted) {
                        ZLogger.w("task already aborted, ignore");
                        return;
                    } else if (dVar.mConnectionState == 256) {
                        BluetoothGattImpl.refresh(bluetoothGatt);
                        d.this.p();
                        return;
                    }
                } else if (i2 == 0) {
                    if (d.this.mProcessState == 521) {
                        d.this.mErrorState = i | 2048;
                        d dVar2 = d.this;
                        if (dVar2.DBG) {
                            ZLogger.d(String.format("disconnect in OTA process, mErrorState: 0x%04X", Integer.valueOf(dVar2.mErrorState)));
                        }
                        d.this.g();
                    }
                    d.this.setConnectionState(0);
                }
            } else {
                if (i2 == 0) {
                    d.this.setConnectionState(0);
                }
                d.this.mErrorState = i | 2048;
            }
            d.this.notifyConnectionLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (i == 0) {
                if (o.f19568a.equals(bluetoothGattDescriptor.getUuid())) {
                    d.this.J = true;
                }
            } else {
                d.this.mErrorState = i | 1024;
            }
            d.this.e();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 0) {
                ZLogger.v(d.this.VDBG, "mtu=" + i);
                if (d.this.getDfuConfig().isMtuUpdateEnabled()) {
                    d.this.d(i);
                }
            }
            d.this.L = true;
            d.this.e();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            super.onPhyUpdate(bluetoothGatt, i, i2, i3);
            ZLogger.v(String.format("onPhyUpdate: mConnectionState=0x%04X", Integer.valueOf(d.this.mConnectionState)));
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            d dVar = d.this;
            if (dVar.mAborted) {
                ZLogger.w("task already aborted, ignore");
                return;
            }
            if (i == 0) {
                dVar.u();
                if (d.this.VDBG) {
                    ZLogger.v(BluetoothHelper.dumpBluetoothGattService(bluetoothGatt));
                }
                d.this.e(bluetoothGatt);
                d.this.c(bluetoothGatt);
                d.this.d(bluetoothGatt);
                d.this.setConnectionState(515);
                d.this.notifyConnectionLock();
                return;
            }
            dVar.mErrorState = i | 2048;
            d.this.notifyConnectionLock();
        }
    }

    public d(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
        this.b0 = new a();
    }

    public boolean A() throws DfuException {
        if (this.R == null) {
            return false;
        }
        if (this.DBG) {
            ZLogger.v("start to read remote dev info");
        }
        byte[] a2 = a(this.R);
        if (a2 != null) {
            getOtaDeviceInfo().parseX0012(a2);
            a(getOtaDeviceInfo().maxBufferchecksize);
            return true;
        }
        ZLogger.w("Get dev info failed");
        throw new OtaException("get remote dev info failed", 270);
    }

    public boolean B() throws DfuException {
        if (this.S == null) {
            return false;
        }
        if (this.DBG) {
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
        ZLogger.d("<<  OPCODE_DFU_REPORT_CURRENT_BUFFER_SIZE(0x0A)");
        a(this.X, new byte[]{10}, false);
        if (this.DBG) {
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
        if (this.X == null) {
            ZLogger.w("no mControlPointCharacteristic found");
            return 0;
        }
        ZLogger.d("<< OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE(0x09)");
        a(this.X, new byte[]{9}, false);
        try {
            if (this.DBG) {
                ZLogger.d("... Reading OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE notification");
            }
            byte[] b = b(1600L);
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
        } catch (DfuException unused) {
            ZLogger.w("Read DFU_REPORT_OTA_FUNCTION_VERSION failed, just think remote is normal function.");
            this.mErrorState = 0;
        }
        return 0;
    }

    public int E() throws DfuException {
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

    public boolean F() {
        try {
            ZLogger.d(this.DBG, "<< OPCODE_DFU_RESET_SYSTEM (0x05)");
            return a(this.X, new byte[]{5}, true);
        } catch (DfuException e) {
            ZLogger.w(String.format("Send OPCODE_DFU_RESET_SYSTEM failed, ignore it, errorcode= 0x%04X", Integer.valueOf(e.getErrCode())));
            this.mErrorState = 0;
            return false;
        }
    }

    public void G() throws DfuException {
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
        ZLogger.w(String.format("0x%02X(not supported), start dfu failed", Byte.valueOf(b)));
        throw new OtaException("start dfu failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    public void H() throws DfuException {
        a((byte) 7);
    }

    public void x() throws DfuException {
        b(new byte[]{4});
    }

    public void y() throws DfuException {
        byte[] hex2Bytes = DataConverter.hex2Bytes(DfuUtils.genNonceHexString(16));
        byte[] aesEncrypt = this.l.aesEncrypt(hex2Bytes, 0, hex2Bytes.length);
        byte[] a2 = c.a(hex2Bytes);
        byte[] aesEncrypt2 = this.l.aesEncrypt(a2, 0, a2.length);
        k a3 = new k.b().a(hex2Bytes, aesEncrypt).b(a2, aesEncrypt2).a();
        if (this.VDBG) {
            ZLogger.v("originData:\n" + DataConverter.bytes2Hex(hex2Bytes));
            ZLogger.v("targetData:\n" + DataConverter.bytes2Hex(a2));
        }
        a(this.X, a3.a(), false);
        if (this.DBG) {
            ZLogger.v("... Reading OPCODE_DFU_HANDSHAKE notification");
        }
        i a4 = i.a(q());
        if (a4 != null && a4.a() == 1) {
            byte[] bArr = a4.d;
            if (bArr != null && bArr.length > 0) {
                if (Arrays.equals(bArr, aesEncrypt2)) {
                    ZLogger.d("hand shake OK");
                    return;
                } else {
                    ZLogger.w("hand shake failed, conflict data");
                    throw new OtaException("hand shake failed", 286);
                }
            }
            ZLogger.w("hand shake failed, invalid response");
            throw new OtaException("hand shake failed", 286);
        }
        ZLogger.w("hand shake failed");
        throw new OtaException("hand shake failed", 286);
    }

    public void z() throws DfuException {
        List<BluetoothGattCharacteristic> list = this.a0;
        byte[] bArr = null;
        if (list != null && list.size() > 0) {
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.a0) {
                if (this.DBG) {
                    ZLogger.v("read image version : " + bluetoothGattCharacteristic.getUuid().toString());
                } else {
                    ZLogger.v("read image version");
                }
                byte[] a2 = a(bluetoothGattCharacteristic);
                if (a2 != null) {
                    if (bArr == null) {
                        bArr = a2;
                    } else {
                        byte[] bArr2 = new byte[bArr.length + a2.length];
                        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                        System.arraycopy(a2, 0, bArr2, bArr.length, a2.length);
                        bArr = bArr2;
                    }
                }
            }
            getOtaDeviceInfo().setImageVersionValues(bArr);
            return;
        }
        getOtaDeviceInfo().setImageVersionValues(null);
        ZLogger.v(this.VDBG, "no ImageVersionCharacteristics to read");
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
        BaseBinInputStream baseBinInputStream;
        List<BaseBinInputStream> list = this.pendingImageInputStreams;
        if (list == null) {
            return;
        }
        Iterator<BaseBinInputStream> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                baseBinInputStream = null;
                break;
            } else {
                baseBinInputStream = it.next();
                if (baseBinInputStream.getImageId() == i) {
                    break;
                }
            }
        }
        if (baseBinInputStream == null) {
            return;
        }
        a(baseBinInputStream.getImageId(), baseBinInputStream.imageVersion);
    }

    public void h(int i) throws DfuException {
        int i2;
        if (this.DBG) {
            ZLogger.d("<< OPCODE_DFU_REPORT_TARGET_IMAGE_INFO(0x06)");
        }
        a(this.X, new byte[]{6, (byte) (i & 255), (byte) ((i >> 8) & 255)}, false);
        if (this.DBG) {
            ZLogger.d("... Reading OPCODE_DFU_REPORT_TARGET_IMAGE_INFO(0x06) notification");
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
        ZLogger.w(String.format("0x%02X, Get target image info failed", Integer.valueOf(DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED)));
        throw new OtaException("Get target image info failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    public void i(int i) throws DfuException {
        int i2 = this.mImageUpdateOffset;
        if (i2 == 0) {
            this.mImageUpdateOffset = 12;
            if (this.DBG) {
                ZLogger.v(String.format(Locale.US, "First Packet, mImageUpdateOffset=0x%08X(%d)", 12, Integer.valueOf(this.mImageUpdateOffset)));
            }
        } else if (this.DBG) {
            ZLogger.v(String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i2), Integer.valueOf(this.mImageUpdateOffset)));
        }
        b(i, this.mImageUpdateOffset);
        int bytesSent = getDfuProgressInfo().getBytesSent();
        int i3 = this.mImageUpdateOffset;
        if (bytesSent == i3 || i3 == -1) {
            return;
        }
        ZLogger.d("mBytesSent != mImageUpdateOffset, reload image bin file");
        this.imageFileLoaded = false;
        l();
        alignmentSendBytes(this.mImageUpdateOffset, false);
    }

    public void j(int i) throws DfuException {
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
            ZLogger.w(String.format("0x%02X, Validate FW failed, CRC check error", Byte.valueOf(b)));
            throw new OtaException("Validate FW failed", 517);
        }
        ZLogger.w(String.format("0x%02X(not supported), Validate FW failed", Byte.valueOf(b)));
        throw new OtaException("Validate FW failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    public int c(String str) {
        return a(str, this.b0);
    }

    @Override // com.realsil.sdk.dfu.l.e
    public boolean e(BluetoothGatt bluetoothGatt) {
        if (!super.e(bluetoothGatt)) {
            return false;
        }
        this.a0 = new ArrayList();
        for (int i = 65504; i < 65519; i++) {
            UUID fromShortValue = BluetoothUuid.fromShortValue(i);
            BluetoothGattCharacteristic characteristic = this.P.getCharacteristic(fromShortValue);
            if (characteristic == null) {
                if (!this.VDBG) {
                    return true;
                }
                ZLogger.v("not found image version characteristic:" + fromShortValue.toString());
                return true;
            }
            if (this.DBG) {
                ZLogger.v("find image version characteristic: " + fromShortValue.toString());
            }
            ZLogger.d(BluetoothGattImpl.parseProperty2(characteristic.getProperties()));
            this.a0.add(characteristic);
        }
        return true;
    }

    public void b(boolean z) throws DfuException {
        ZLogger.d("<< OPCODE_DFU_ENSURE_CURRENT_BUFFER(0x0C)");
        a(this.X, new byte[]{12, !z ? 1 : 0}, false);
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
            F();
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

    public boolean b(byte[] bArr, int i) throws DfuException {
        if (bArr == null) {
            ZLogger.w("buffer == null");
            return false;
        }
        if (this.VDBG) {
            ZLogger.v(String.format(Locale.US, "bufferCheck (%d) >> (%d) %s", Integer.valueOf(i), Integer.valueOf(bArr.length), DataConverter.bytes2Hex(bArr)));
        }
        l a2 = new l.b().a(bArr, i).a();
        if (this.DBG) {
            ZLogger.d("<< " + a2.toString());
        }
        a(this.X, a2.a(), false);
        if (this.VDBG) {
            ZLogger.d("... waiting OPCODE_DFU_REPORT_BUFFER_CRC(0x0A) response");
        }
        i a3 = i.a(q());
        if (a3 == null) {
            return false;
        }
        byte a4 = a3.a();
        ByteBuffer wrap = ByteBuffer.wrap(a3.d);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        this.mImageUpdateOffset = wrap.getInt(0);
        if (this.DBG) {
            ZLogger.d(String.format(Locale.US, "status:0x%04X, mImageUpdateOffset=0x%08X(%d)", Byte.valueOf(a4), Integer.valueOf(this.mImageUpdateOffset), Integer.valueOf(this.mImageUpdateOffset)));
        }
        if (a4 == 1) {
            return true;
        }
        if (a4 == 5 || a4 == 6 || a4 == 7) {
            return false;
        }
        if (a4 != 8) {
            throw new OtaException("ERROR_OPCODE_RESPONSE_NOT_SUPPORTED", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
        throw new OtaException("DFU_STATUS_FLASH_ERASE_ERROR", a4 | 512);
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x005e, code lost:
    
        if (r2 != (getDfuProgressInfo().getBytesSent() + r9)) goto L17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0071 A[Catch: IOException -> 0x0223, TryCatch #0 {IOException -> 0x0223, blocks: (B:78:0x0050, B:80:0x0055, B:13:0x006d, B:15:0x0071, B:17:0x0086, B:18:0x008d, B:19:0x00c0, B:21:0x00c4, B:22:0x00d7, B:24:0x00e1, B:26:0x00ed, B:75:0x009e, B:76:0x00ae, B:12:0x0060), top: B:77:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c4 A[Catch: IOException -> 0x0223, TryCatch #0 {IOException -> 0x0223, blocks: (B:78:0x0050, B:80:0x0055, B:13:0x006d, B:15:0x0071, B:17:0x0086, B:18:0x008d, B:19:0x00c0, B:21:0x00c4, B:22:0x00d7, B:24:0x00e1, B:26:0x00ed, B:75:0x009e, B:76:0x00ae, B:12:0x0060), top: B:77:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e1 A[Catch: IOException -> 0x0223, TryCatch #0 {IOException -> 0x0223, blocks: (B:78:0x0050, B:80:0x0055, B:13:0x006d, B:15:0x0071, B:17:0x0086, B:18:0x008d, B:19:0x00c0, B:21:0x00c4, B:22:0x00d7, B:24:0x00e1, B:26:0x00ed, B:75:0x009e, B:76:0x00ae, B:12:0x0060), top: B:77:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0113 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x009c  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.m.d.a(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattCharacteristic, com.realsil.sdk.dfu.image.stream.BaseBinInputStream):void");
    }

    public void b(int i, int i2) throws DfuException {
        ZLogger.d("<< OPCODE_DFU_RECEIVE_FW_IMAGE (0x02)");
        a(this.X, new byte[]{2, (byte) (i & 255), (byte) ((i >> 8) & 255), (byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)}, false);
    }

    public void b(byte b) throws DfuException {
        b(new byte[]{4, b});
    }

    public void b(byte[] bArr) throws DfuException {
        int errCode;
        notifyStateChanged(DfuConstants.PROGRESS_ACTIVE_IMAGE_AND_RESET);
        boolean z = false;
        try {
            ZLogger.d("<< OPCODE_DFU_ACTIVE_IMAGE_RESET(0x04)");
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
            ZLogger.d("image active success");
            e(this.mErrorState);
            closeInputStream(this.mCurBinInputStream);
            return;
        }
        throw new OtaException(errCode);
    }

    public void a(int i, int i2) throws DfuException {
        ZLogger.v(String.format("<< OPCODE_DFU_CHECK_IMAGE(0x%02X)", (byte) 13));
        a(this.X, new byte[]{13, (byte) (i & 255), (byte) ((i >> 8) & 255), (byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)}, false);
        if (this.DBG) {
            ZLogger.v("... Reading OPCODE_DFU_CHECK_IMAGE notification");
        }
        byte b = q()[2];
        if (b == 1) {
            return;
        }
        ZLogger.w(String.format("0x%02X: check image failed", Byte.valueOf(b)));
        throw new OtaException("check image failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }
}
