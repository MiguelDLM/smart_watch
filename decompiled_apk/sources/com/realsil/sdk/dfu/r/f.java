package com.realsil.sdk.dfu.r;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.ParcelUuid;
import com.realsil.sdk.core.bluetooth.impl.BluetoothGattImpl;
import com.realsil.sdk.core.bluetooth.scanner.SpecScanRecord;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.bluetooth.utils.BluetoothUuid;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import com.realsil.sdk.dfu.DfuConstants;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import com.realsil.sdk.dfu.internal.base.DfuThreadCallback;
import com.realsil.sdk.dfu.l.f;
import com.realsil.sdk.dfu.l.n;
import com.realsil.sdk.dfu.l.o;
import com.realsil.sdk.dfu.l.p;
import com.realsil.sdk.dfu.l.q;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.r.b;
import com.realsil.sdk.dfu.r.c;
import com.realsil.sdk.dfu.s.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.OX00O0xII;

/* loaded from: classes11.dex */
public abstract class f extends com.realsil.sdk.dfu.l.e {
    public List<BluetoothGattCharacteristic> a0;
    public List<BluetoothGattCharacteristic> b0;
    public final BluetoothGattCallback c0;

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
                            if (f.this.VDBG) {
                                ZLogger.v(String.format("responseType = %02X , requestOpCode = %02X", Integer.valueOf(i), Integer.valueOf(i2)));
                            }
                            if (i == 16) {
                                if (i2 == 7) {
                                    synchronized (f.this.p) {
                                        ZLogger.d("ignore connection parameters notification");
                                        f.this.I = bArr;
                                        f.this.K = true;
                                        f.this.p.notifyAll();
                                    }
                                } else if (i2 != 8) {
                                    synchronized (f.this.p) {
                                        f.this.I = bArr;
                                        f.this.K = true;
                                        f.this.p.notifyAll();
                                    }
                                } else {
                                    if (bArr.length >= 3) {
                                        b = bArr[2];
                                    } else {
                                        b = 0;
                                    }
                                    ZLogger.d("remote state changed, busyMode=" + ((int) b));
                                    synchronized (f.this.v) {
                                        f fVar = f.this;
                                        if (b != 1) {
                                            z = false;
                                        }
                                        fVar.u = z;
                                        f.this.v.notifyAll();
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
                f.this.mReadRxData = bluetoothGattCharacteristic.getValue();
            } else {
                f.this.mErrorState = i | 1024;
                ZLogger.w(String.format(Locale.US, "read Characteristic error:0x%04X", Integer.valueOf(f.this.mErrorState)));
            }
            f.this.notifyReadLock();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (i == 0) {
                f.this.mWriteRetransFlag = false;
                if (f.this.U != null && f.this.U.equals(bluetoothGattCharacteristic.getUuid())) {
                    if (value != null) {
                        f.this.getDfuProgressInfo().addBytesSent(value.length);
                        f.this.notifyProcessChanged();
                    } else {
                        ZLogger.w("characteristic'value is null, exception");
                    }
                }
            } else if (i != 257 && i != 143) {
                f.this.mErrorState = i | 1024;
                ZLogger.w(String.format("Characteristic write error: 0x%04X", Integer.valueOf(f.this.mErrorState)));
            } else if (f.this.U != null && f.this.U.equals(bluetoothGattCharacteristic.getUuid())) {
                if (i == 143) {
                    f.this.mWriteRetransFlag = false;
                    if (value != null) {
                        f.this.getDfuProgressInfo().addBytesSent(value.length);
                        f.this.notifyProcessChanged();
                    } else {
                        ZLogger.w("characteristic'value is null, exception");
                    }
                } else {
                    f.this.mWriteRetransFlag = true;
                    if (f.this.DBG) {
                        ZLogger.d("write image packet error, status=" + i + ", please retry.");
                    }
                }
            }
            f.this.g();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i == 0) {
                if (i2 == 2) {
                    f fVar = f.this;
                    if (fVar.mAborted) {
                        ZLogger.w("task already aborted, ignore");
                        return;
                    } else if (fVar.mConnectionState == 256) {
                        BluetoothGattImpl.refresh(bluetoothGatt);
                        f.this.p();
                        return;
                    }
                } else if (i2 == 0) {
                    if (f.this.mProcessState == 521) {
                        f.this.mErrorState = i | 2048;
                        f fVar2 = f.this;
                        if (fVar2.DBG) {
                            ZLogger.d(String.format("disconnect in OTA process, mErrorState:0x%04X ", Integer.valueOf(fVar2.mErrorState)));
                        }
                        f.this.g();
                    }
                    f.this.setConnectionState(0);
                }
            } else {
                if (i2 == 0) {
                    f.this.setConnectionState(0);
                }
                f.this.mErrorState = i | 2048;
            }
            synchronized (f.this.mConnectionLock) {
                try {
                    f fVar3 = f.this;
                    if (fVar3.mConnectionState != 256) {
                        fVar3.isConnectedCallbackCome = true;
                    }
                    f.this.mConnectionLock.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (i == 0) {
                if (o.f19568a.equals(bluetoothGattDescriptor.getUuid())) {
                    f.this.J = true;
                }
            } else {
                f.this.mErrorState = i | 1024;
            }
            f.this.e();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 0) {
                ZLogger.v(f.this.VDBG, "mtu=" + i);
                if (f.this.getDfuConfig().isMtuUpdateEnabled()) {
                    f.this.d(i);
                }
                f.this.c(i);
            }
            f.this.L = true;
            f.this.e();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            super.onPhyUpdate(bluetoothGatt, i, i2, i3);
            ZLogger.v(String.format("onPhyUpdate: mConnectionState=0x%04X", Integer.valueOf(f.this.mConnectionState)));
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            f fVar = f.this;
            if (fVar.mAborted) {
                ZLogger.w("task already aborted, ignore");
                return;
            }
            if (i == 0) {
                fVar.u();
                if (f.this.VDBG) {
                    ZLogger.v(BluetoothHelper.dumpBluetoothGattService(bluetoothGatt));
                }
                f.this.e(bluetoothGatt);
                f.this.c(bluetoothGatt);
                f.this.setConnectionState(515);
                f.this.notifyConnectionLock();
            } else {
                fVar.mErrorState = i | 2048;
            }
            synchronized (f.this.mConnectionLock) {
                try {
                    f fVar2 = f.this;
                    if (fVar2.mConnectionState == 515) {
                        fVar2.isConnectedCallbackCome = true;
                    }
                    f.this.mConnectionLock.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public f(Context context, DfuConfig dfuConfig, DfuThreadCallback dfuThreadCallback) {
        super(context, dfuConfig, dfuThreadCallback);
        this.c0 = new a();
    }

    public int A() throws DfuException {
        int i;
        if (!getOtaDeviceInfo().isBankEnabled() || getOtaDeviceInfo().specVersion < 4) {
            return 0;
        }
        ZLogger.d(String.format(Locale.US, "binId=0x%04X, activeCompareVersionFlag=%d, inactiveCompareVersionFlag=%d", Integer.valueOf(this.mCurBinInputStream.getBinId()), Integer.valueOf(this.mCurBinInputStream.getActiveCompareVersionFlag()), Integer.valueOf(this.mCurBinInputStream.getInactiveVersionCompFlag())));
        if (!b(this.mCurBinInputStream)) {
            return 0;
        }
        byte a2 = a(getDfuProgressInfo().getCurImageId(), this.mCurBinInputStream.getSha256());
        if ((a2 & 1) == 1) {
            ZLogger.d("current image's sha256 is same as the inactive bank image, need to skip");
            i = 1;
        } else {
            i = 0;
        }
        if ((a2 & 2) == 2) {
            if (g(getDfuProgressInfo().getBinId())) {
                ZLogger.d("current image's sha256 is same as the active bank image, need to copy");
                return i | 2;
            }
            ZLogger.v(String.format("0x%04X not support copy image", Integer.valueOf(getDfuProgressInfo().getBinId())));
            return i;
        }
        return i;
    }

    public boolean B() {
        if (getOtaDeviceInfo().specVersion >= 2) {
            return false;
        }
        return true;
    }

    public void C() throws DfuException {
        byte[] bArr = null;
        if (getOtaDeviceInfo().specVersion < 4) {
            List<BluetoothGattCharacteristic> list = this.a0;
            if (list != null && list.size() > 0) {
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.a0) {
                    if (this.VDBG) {
                        ZLogger.v("read active image version : " + bluetoothGattCharacteristic.getUuid().toString());
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
            } else {
                ZLogger.d(this.DBG, "no ImageVersionCharacteristics to read");
            }
        } else {
            BluetoothGattService bluetoothGattService = this.P;
            if (bluetoothGattService != null) {
                BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(BluetoothUuid.fromShortValue(65504));
                if (characteristic != null) {
                    if (this.VDBG) {
                        ZLogger.v("read active image version : " + characteristic.getUuid().toString());
                    }
                    byte[] a3 = a(characteristic);
                    if (a3 != null) {
                        bArr = a3;
                    }
                } else {
                    ZLogger.d(this.DBG, String.format("not found active image characteristic：0x%04X", 65504));
                }
            } else {
                ZLogger.w(this.DBG, "ota gatt service is null");
            }
        }
        getOtaDeviceInfo().setImageVersionValues(bArr);
    }

    public boolean D() throws DfuException {
        if (this.R == null) {
            return false;
        }
        if (this.DBG) {
            ZLogger.v("start to read remote device info");
        }
        byte[] a2 = a(this.R);
        if (a2 == null) {
            if (this.DBG) {
                ZLogger.v("read device info failed");
            }
            throw new OtaException("read remote device info failed", 270);
        }
        getOtaDeviceInfo().parseX0010(a2);
        a(getOtaDeviceInfo().maxBufferchecksize);
        return true;
    }

    public boolean E() throws DfuException {
        if (this.S == null) {
            return false;
        }
        if (this.DBG) {
            ZLogger.v("start to read remote dev Mac Addr info");
        }
        byte[] a2 = a(this.S);
        if (a2 != null) {
            if (a2.length >= 6) {
                byte[] bArr = new byte[6];
                System.arraycopy(a2, 0, bArr, 0, 6);
                getOtaDeviceInfo().setDeviceMac(bArr);
            }
            if (a2.length >= 12) {
                byte[] bArr2 = new byte[6];
                System.arraycopy(a2, 6, bArr2, 0, 6);
                getOtaDeviceInfo().setRwsBdAddr(bArr2);
                return true;
            }
            return true;
        }
        ZLogger.w("Get remote dev Mac Addr info failed, do nothing.");
        throw new OtaException("remote dev Mac Addr info error", 277);
    }

    public void F() throws DfuException {
        byte[] bArr = null;
        if (getOtaDeviceInfo().specVersion < 4) {
            List<BluetoothGattCharacteristic> list = this.b0;
            if (list != null && list.size() > 0) {
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.b0) {
                    if (this.VDBG) {
                        ZLogger.v("read image section size : " + bluetoothGattCharacteristic.getUuid().toString());
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
            } else {
                ZLogger.d(this.DBG, "no ImageSectionCharacteristics to read");
            }
        } else {
            BluetoothGattService bluetoothGattService = this.P;
            if (bluetoothGattService != null) {
                BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(BluetoothUuid.fromShortValue(65524));
                if (characteristic != null) {
                    if (this.VDBG) {
                        ZLogger.v("read image section size : " + characteristic.getUuid().toString());
                    }
                    byte[] a3 = a(characteristic);
                    if (a3 != null) {
                        bArr = a3;
                    }
                } else {
                    ZLogger.d(this.DBG, String.format("not found image section size characteristic：0x%04X", 65524));
                }
            } else {
                ZLogger.w(this.DBG, "ota gatt service is null");
            }
        }
        getOtaDeviceInfo().setImageSectionSizeValues(bArr);
    }

    public void G() throws DfuException {
        if (!this.mAborted) {
            ZLogger.d(this.DBG, "isBufferCheckEnabled=" + getOtaDeviceInfo().isBufferCheckEnabled());
            if (getOtaDeviceInfo().isBufferCheckEnabled()) {
                if (z()) {
                    this.r = 1;
                } else {
                    this.r = 0;
                }
            } else {
                this.r = 0;
            }
            ZLogger.v(this.VDBG, "mRemoteOtaFunctionInfo=" + this.r);
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public boolean H() {
        try {
            ZLogger.d(this.DBG, "<< OPCODE_DFU_RESET_SYSTEM (0x05)");
            return a(this.X, new byte[]{5}, true);
        } catch (DfuException e) {
            ZLogger.d(String.format("Send OPCODE_DFU_RESET_SYSTEM failed, ignore it, errorcode= 0x%04X", Integer.valueOf(e.getErrCode())));
            this.mErrorState = 0;
            return false;
        }
    }

    public void I() throws DfuException {
        c((byte) 0);
    }

    public void J() throws DfuException {
        a((byte) 7);
    }

    public boolean g(int i) {
        return i == 1024 || i == 1040 || i == 1280 || i == 1538 || i == 2304;
    }

    public void x() throws DfuException {
        b(new byte[]{4});
    }

    public void y() throws DfuException {
        byte[] bArr;
        int i;
        if (getOtaDeviceInfo().specVersion < 6) {
            return;
        }
        List<BaseBinInputStream> list = this.pendingImageInputStreams;
        if (list != null && list.size() > 0) {
            bArr = new byte[this.pendingImageInputStreams.size() * 6];
            i = 0;
            for (BaseBinInputStream baseBinInputStream : this.pendingImageInputStreams) {
                if (baseBinInputStream.getPubKeyHash() != null && baseBinInputStream.getPubKeyHash().length == 4) {
                    int i2 = i * 6;
                    bArr[i2] = (byte) (baseBinInputStream.getImageId() & 255);
                    bArr[i2 + 1] = (byte) ((baseBinInputStream.getImageId() >> 8) & 255);
                    System.arraycopy(baseBinInputStream.getPubKeyHash(), 0, bArr, i2 + 2, 4);
                    i++;
                }
            }
        } else {
            bArr = null;
            i = 0;
        }
        if (bArr != null && bArr.length > 0) {
            a(this.X, new b.C0915b().a(i, bArr).a().a(), false);
            if (this.DBG) {
                ZLogger.d("... waiting OPCODE_DFU_CHECK_PUB_KEYS response");
            }
            byte[] q = q();
            if (q != null && q.length > 2 && q[2] == 1) {
                return;
            }
            ZLogger.w("check pub key failed");
            throw new OtaException("ERROR_DFU_PUB_KEYS_CONFLICT", 285);
        }
    }

    public boolean z() throws DfuException {
        if (this.X == null) {
            ZLogger.w(this.DBG, "no mControlPointCharacteristic found");
            return false;
        }
        ZLogger.d(this.DBG, "<< OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE(0x09)");
        a(this.X, new byte[]{9}, false);
        try {
            ZLogger.d(this.DBG, "... Reading OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE notification");
            com.realsil.sdk.dfu.l.h a2 = com.realsil.sdk.dfu.l.h.a(getOtaDeviceInfo().protocolType, getOtaDeviceInfo().specVersion, b(1600L));
            if (a2 != null && a2.a()) {
                a(a2.e);
                if (a2.f) {
                    c(a2.g);
                }
            }
            return true;
        } catch (DfuException unused) {
            ZLogger.w("enableBufferCheck failed, just think remote is normal function.");
            this.mErrorState = 0;
            return false;
        }
    }

    public void f(int i) throws DfuException {
        com.realsil.sdk.dfu.l.f a2 = new f.b().a(i).a();
        if (this.DBG) {
            ZLogger.d(a2.toString());
        }
        a(this.X, a2.a(), false);
        if (this.VDBG) {
            ZLogger.v("... Reading copy image notification");
        }
        byte b = q()[2];
        if (b == 1) {
            return;
        }
        ZLogger.w(String.format("0x%02X(not supported), copy image failed", Byte.valueOf(b)));
        throw new OtaException("copy image failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    public void h(int i) throws DfuException {
        int i2;
        if (!this.mAborted) {
            ZLogger.d(this.DBG, "<< OPCODE_DFU_REPORT_TARGET_IMAGE_INFO(0x06)");
            a(this.X, new byte[]{6, (byte) (i & 255), (byte) ((i >> 8) & 255)}, false);
            ZLogger.d(this.DBG, "... Reading OPCODE_DFU_REPORT_TARGET_IMAGE_INFO(0x06) notification");
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
            ZLogger.w(String.format("0x%04X, Get target image info failed", Integer.valueOf(DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED)));
            throw new OtaException("Get target image info failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public void i(int i) throws DfuException {
        int i2 = this.mImageUpdateOffset;
        if (i2 == 0) {
            if (B()) {
                this.mImageUpdateOffset = 12;
            }
            ZLogger.v(this.DBG, String.format(Locale.US, "First Packet, mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(this.mImageUpdateOffset), Integer.valueOf(this.mImageUpdateOffset)));
        } else {
            ZLogger.v(this.DBG, String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i2), Integer.valueOf(this.mImageUpdateOffset)));
        }
        a(i, this.mImageUpdateOffset);
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

    public final int c(String str) {
        return a(str, this.c0);
    }

    @Override // com.realsil.sdk.dfu.l.e
    public boolean e(BluetoothGatt bluetoothGatt) {
        if (!super.e(bluetoothGatt)) {
            return false;
        }
        this.a0 = new ArrayList();
        int i = 65504;
        while (true) {
            if (i >= 65519) {
                break;
            }
            UUID fromShortValue = BluetoothUuid.fromShortValue(i);
            BluetoothGattCharacteristic characteristic = this.P.getCharacteristic(fromShortValue);
            if (characteristic == null) {
                if (this.VDBG) {
                    ZLogger.v("not found image version characteristic:" + fromShortValue.toString());
                }
            } else {
                if (this.VDBG) {
                    ZLogger.v("find image version characteristic: " + fromShortValue.toString());
                }
                this.a0.add(characteristic);
                i++;
            }
        }
        this.b0 = new ArrayList();
        for (int i2 = 65524; i2 < 65526; i2++) {
            UUID fromShortValue2 = BluetoothUuid.fromShortValue(i2);
            BluetoothGattCharacteristic characteristic2 = this.P.getCharacteristic(fromShortValue2);
            if (characteristic2 == null) {
                if (!this.VDBG) {
                    return true;
                }
                ZLogger.v("not found image session size characteristic:" + fromShortValue2.toString());
                return true;
            }
            if (this.VDBG) {
                ZLogger.v("find image session size characteristic: " + fromShortValue2.toString());
            }
            this.b0.add(characteristic2);
        }
        return true;
    }

    public void c(byte b) throws DfuException {
        byte[] bArr = new byte[16];
        System.arraycopy(this.mCurBinInputStream.getDfuHeader(), 0, bArr, 0, 12);
        bArr[12] = b;
        p.b bVar = new p.b(getOtaDeviceInfo().specVersion);
        if (getOtaDeviceInfo().isAesEncryptEnabled()) {
            bVar.a(this.l.aesEncrypt(bArr, 0, 16));
        } else {
            bVar.a(bArr);
        }
        p a2 = bVar.a();
        if (this.DBG) {
            ZLogger.d(a2.toString());
        }
        a(this.X, a2.a(), false);
        if (this.VDBG) {
            ZLogger.v("... Reading OPCODE_DFU_START_DFU(0x01) notification");
        }
        byte b2 = q()[2];
        if (b2 == 1) {
            return;
        }
        ZLogger.w(String.format("0x%02X(not supported), start dfu failed", Byte.valueOf(b2)));
        throw new OtaException("start dfu failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    public boolean b(byte[] bArr, int i) throws DfuException {
        if (bArr == null) {
            ZLogger.w("buffer == null");
            return false;
        }
        if (this.DBG) {
            ZLogger.v(String.format(Locale.US, "bufferCheck (%d) >> (%d) %s", Integer.valueOf(i), Integer.valueOf(bArr.length), DataConverter.bytes2Hex(bArr)));
        }
        short a2 = a(bArr, i);
        if (this.DBG) {
            ZLogger.d("<< OPCODE_DFU_REPORT_BUFFER_CRC(0x0A)");
        }
        a(this.X, new byte[]{10, (byte) (i & 255), (byte) (i >> 8), (byte) (a2 & 255), (byte) ((a2 >> 8) & 255)}, false);
        if (this.DBG) {
            ZLogger.d("... waiting OPCODE_DFU_REPORT_BUFFER_CRC(0x0A) response");
        }
        byte[] q = q();
        byte b = q[2];
        ByteBuffer wrap = ByteBuffer.wrap(q);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        this.mImageUpdateOffset = wrap.getInt(3);
        if (this.DBG) {
            ZLogger.d(String.format(Locale.US, "status:0x%04X, mImageUpdateOffset=0x%08X(%d)", Byte.valueOf(b), Integer.valueOf(this.mImageUpdateOffset), Integer.valueOf(this.mImageUpdateOffset)));
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

    public int a(String str, int i) {
        int i2 = 0;
        while (a()) {
            int c = c(str);
            if (c == 0) {
                return 0;
            }
            if ((c & (-2049)) != 133) {
                b(this.H);
            } else {
                ZLogger.w("connect fail with GATT_ERROR, do not need disconnect");
            }
            a(this.H);
            sleepInner(1600L);
            i2++;
            ZLogger.v(this.VDBG, "tryConnectTime=" + i2);
            if (i2 > i) {
                return c;
            }
        }
        return DfuException.ERROR_DFU_ABORTED;
    }

    public void a(int i, int i2) throws DfuException {
        n a2 = new n.b(getOtaDeviceInfo().specVersion).a(i).b(i2).a();
        if (this.DBG) {
            ZLogger.d(a2.toString());
        }
        a(this.X, a2.a(), false);
    }

    public final byte a(int i, byte[] bArr) throws DfuException {
        if (bArr != null && bArr.length == 32) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new c.C0917c(i, bArr));
            c a2 = new c.b().a(new c.b().a(arrayList).a()).a();
            if (this.DBG) {
                ZLogger.v(a2.toString());
            }
            a(this.X, a2.a(), false);
            if (this.DBG) {
                ZLogger.d("... waiting OPCODE_DFU_CHECK_IMAGE response");
            }
            com.realsil.sdk.dfu.l.i a3 = com.realsil.sdk.dfu.l.i.a(q());
            if (a3 == null || a3.a() != 1) {
                return (byte) 0;
            }
            com.realsil.sdk.dfu.s.a a4 = com.realsil.sdk.dfu.s.a.a(a3.d);
            if (this.DBG) {
                ZLogger.v(a4.toString());
            }
            return a3.a();
        }
        ZLogger.v("invalid sha256:" + DataConverter.bytes2Hex(bArr));
        return (byte) 0;
    }

    public boolean b(BaseBinInputStream baseBinInputStream) {
        return (baseBinInputStream.icType == 11 && baseBinInputStream.getBinId() == 520) || this.mCurBinInputStream.getActiveCompareVersionFlag() == 0 || this.mCurBinInputStream.getInactiveVersionCompFlag() == 0;
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
            ZLogger.i("image active success");
            e(this.mErrorState);
            closeInputStream(this.mCurBinInputStream);
            return;
        }
        throw new OtaException(errCode);
    }

    public void a(int i, byte b) throws DfuException {
        q a2 = new q.b(getOtaDeviceInfo().protocolType, getOtaDeviceInfo().specVersion).a(i).a(b).a();
        if (this.DBG) {
            ZLogger.d(a2.toString());
        }
        a(this.X, a2.a(), false);
        if (this.DBG) {
            ZLogger.v("... waiting DFU_VALIDATE_FW_IMAGE response");
        }
        byte b2 = q()[2];
        if (b2 == 1) {
            return;
        }
        if (b2 == 5) {
            ZLogger.w(String.format("0x%02X, Validate FW failed, CRC check error", Byte.valueOf(b2)));
            throw new OtaException("Validate FW failed", 517);
        }
        ZLogger.w(String.format("0x%02X(not supported), Validate FW failed", Byte.valueOf(b2)));
        throw new OtaException("Validate FW failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x005c, code lost:
    
        if (r3 != (getDfuProgressInfo().getBytesSent() + r9)) goto L14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006f A[Catch: IOException -> 0x021c, TryCatch #0 {IOException -> 0x021c, blocks: (B:70:0x004e, B:72:0x0053, B:10:0x006b, B:12:0x006f, B:14:0x0084, B:15:0x008b, B:16:0x00be, B:18:0x00db, B:67:0x009c, B:68:0x00ac, B:9:0x005e), top: B:69:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00db A[Catch: IOException -> 0x021c, TRY_LEAVE, TryCatch #0 {IOException -> 0x021c, blocks: (B:70:0x004e, B:72:0x0053, B:10:0x006b, B:12:0x006f, B:14:0x0084, B:15:0x008b, B:16:0x00be, B:18:0x00db, B:67:0x009c, B:68:0x00ac, B:9:0x005e), top: B:69:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x009a  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(android.bluetooth.BluetoothGatt r19, android.bluetooth.BluetoothGattCharacteristic r20, com.realsil.sdk.dfu.image.stream.BaseBinInputStream r21) throws com.realsil.sdk.dfu.DfuException {
        /*
            Method dump skipped, instructions count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.r.f.b(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattCharacteristic, com.realsil.sdk.dfu.image.stream.BaseBinInputStream):void");
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
            H();
        }
        this.D.stopScan();
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

    public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, BaseBinInputStream baseBinInputStream) throws DfuException {
        int read;
        c();
        this.mErrorState = 0;
        this.lastPacketTransferred = false;
        int i = this.MAX_PACKET_SIZE;
        byte[] bArr = new byte[i];
        while (!this.lastPacketTransferred) {
            if (!this.mAborted) {
                startSpeedControl();
                if (this.DBG) {
                    ZLogger.v(getDfuProgressInfo().toString());
                }
                try {
                    if (getDfuProgressInfo().getBytesSent() == 0) {
                        int i2 = this.MAX_PACKET_SIZE;
                        byte[] bArr2 = new byte[i2];
                        baseBinInputStream.read(bArr2, i2 - 12);
                        System.arraycopy(baseBinInputStream.getHeaderBuf(), 0, bArr, 0, 12);
                        System.arraycopy(bArr2, 0, bArr, 12, this.MAX_PACKET_SIZE - 12);
                        read = this.MAX_PACKET_SIZE;
                    } else {
                        read = baseBinInputStream.read(bArr, i);
                    }
                    if (getDfuProgressInfo().getRemainSizeInBytes() < this.MAX_PACKET_SIZE) {
                        ZLogger.v("reach the end of the file, only read some");
                        read = getDfuProgressInfo().getRemainSizeInBytes();
                    }
                    int i3 = read;
                    if (i3 <= 0) {
                        if (getDfuProgressInfo().isFileSendOver()) {
                            ZLogger.d("image file has already been send over");
                            return;
                        }
                        ZLogger.w("Error while reading file with size: " + i3);
                        throw new OtaException("Error while reading file", 257);
                    }
                    if (getOtaDeviceInfo().isAesEncryptEnabled()) {
                        for (int i4 = i3; i4 > 0; i4 -= 16) {
                            if (i4 >= 16) {
                                int i5 = i3 - i4;
                                System.arraycopy(this.l.aesEncrypt(bArr, i5, 16), 0, bArr, i5, 16);
                                if (getOtaDeviceInfo().getAesEncryptMode() == 0) {
                                    break;
                                }
                            }
                        }
                    }
                    a(bluetoothGatt, bluetoothGattCharacteristic, bArr, i3, false);
                    j();
                    blockSpeedControl();
                } catch (IOException unused) {
                    throw new OtaException("Error while reading file", 257);
                }
            } else {
                throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
            }
        }
    }

    public boolean a(SpecScanRecord specScanRecord) {
        List<ParcelUuid> serviceUuids;
        if (specScanRecord == null) {
            ZLogger.d(this.DBG, "ignore , specScanRecord is null");
            return false;
        }
        ZLogger.v(specScanRecord.toString());
        byte[] manufacturerSpecificData = specScanRecord.getManufacturerSpecificData(getDfuConfig().getManufacturerId());
        if (manufacturerSpecificData == null) {
            return false;
        }
        ZLogger.v(this.VDBG, "manufacturerSpecificData=" + DataConverter.bytes2Hex(manufacturerSpecificData));
        ZLogger.v(this.VDBG, "rwsBdAddr= " + DataConverter.bytes2Hex(getOtaDeviceInfo().getRwsBdAddr()));
        boolean equals = Arrays.equals(manufacturerSpecificData, getOtaDeviceInfo().getRwsBdAddr());
        if (equals) {
            return (getOtaDeviceInfo().specVersion < 5 || (serviceUuids = specScanRecord.getServiceUuids()) == null) ? equals : serviceUuids.contains(ParcelUuid.fromString("020002fd-3c17-d293-8e48-14fe2e4da212"));
        }
        ZLogger.v(this.VDBG, "not the same device");
        return false;
    }
}
