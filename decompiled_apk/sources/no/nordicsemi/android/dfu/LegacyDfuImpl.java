package no.nordicsemi.android.dfu;

import XXO0.oIX0oI;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.UUID;
import no.nordicsemi.android.dfu.BaseCustomDfuImpl;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"MissingPermission"})
/* loaded from: classes6.dex */
public class LegacyDfuImpl extends BaseCustomDfuImpl {
    static final UUID DEFAULT_DFU_CONTROL_POINT_UUID;
    static final UUID DEFAULT_DFU_PACKET_UUID;
    static final UUID DEFAULT_DFU_SERVICE_UUID;
    static final UUID DEFAULT_DFU_VERSION_UUID;
    static UUID DFU_CONTROL_POINT_UUID = null;
    static UUID DFU_PACKET_UUID = null;
    static UUID DFU_SERVICE_UUID = null;
    private static final int DFU_STATUS_SUCCESS = 1;
    static UUID DFU_VERSION_UUID = null;
    private static final byte[] OP_CODE_ACTIVATE_AND_RESET;
    private static final int OP_CODE_ACTIVATE_AND_RESET_KEY = 5;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_COMPLETE;
    private static final int OP_CODE_INIT_DFU_PARAMS_KEY = 2;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_START;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_KEY = 17;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 8;
    private static final byte[] OP_CODE_RECEIVE_FIRMWARE_IMAGE;
    private static final int OP_CODE_RECEIVE_FIRMWARE_IMAGE_KEY = 3;
    private static final byte[] OP_CODE_RESET;
    private static final int OP_CODE_RESET_KEY = 6;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 16;
    private static final byte[] OP_CODE_START_DFU;
    private static final int OP_CODE_START_DFU_KEY = 1;
    private static final byte[] OP_CODE_START_DFU_V1;
    private static final byte[] OP_CODE_VALIDATE;
    private static final int OP_CODE_VALIDATE_KEY = 4;
    private final LegacyBluetoothCallback mBluetoothCallback;
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private boolean mImageSizeInProgress;
    private BluetoothGattCharacteristic mPacketCharacteristic;

    /* loaded from: classes6.dex */
    public class LegacyBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        public LegacyBluetoothCallback() {
            super();
        }

        @Override // no.nordicsemi.android.dfu.BaseDfuImpl.BaseBluetoothGattCallback, android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(@NonNull BluetoothGatt bluetoothGatt, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr) {
            if ((bArr[0] & 255) == 17) {
                LegacyDfuImpl.this.mProgressInfo.setBytesReceived(getInt(bArr, 1));
                handlePacketReceiptNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
            } else {
                LegacyDfuImpl legacyDfuImpl = LegacyDfuImpl.this;
                if (!legacyDfuImpl.mRemoteErrorOccurred) {
                    if ((bArr[2] & 255) != 1) {
                        legacyDfuImpl.mRemoteErrorOccurred = true;
                    }
                    handleNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
                }
            }
            LegacyDfuImpl.this.notifyLock();
        }

        @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl.BaseCustomBluetoothCallback
        public void onPacketCharacteristicWrite() {
            if (LegacyDfuImpl.this.mImageSizeInProgress) {
                LegacyDfuImpl.this.mImageSizeInProgress = false;
            }
        }
    }

    static {
        UUID uuid = new UUID(23296205844446L, 1523193452336828707L);
        DEFAULT_DFU_SERVICE_UUID = uuid;
        UUID uuid2 = new UUID(23300500811742L, 1523193452336828707L);
        DEFAULT_DFU_CONTROL_POINT_UUID = uuid2;
        UUID uuid3 = new UUID(23304795779038L, 1523193452336828707L);
        DEFAULT_DFU_PACKET_UUID = uuid3;
        UUID uuid4 = new UUID(23313385713630L, 1523193452336828707L);
        DEFAULT_DFU_VERSION_UUID = uuid4;
        DFU_SERVICE_UUID = uuid;
        DFU_CONTROL_POINT_UUID = uuid2;
        DFU_PACKET_UUID = uuid3;
        DFU_VERSION_UUID = uuid4;
        OP_CODE_START_DFU = new byte[]{1, 0};
        OP_CODE_START_DFU_V1 = new byte[]{1};
        OP_CODE_INIT_DFU_PARAMS = new byte[]{2};
        OP_CODE_INIT_DFU_PARAMS_START = new byte[]{2, 0};
        OP_CODE_INIT_DFU_PARAMS_COMPLETE = new byte[]{2, 1};
        OP_CODE_RECEIVE_FIRMWARE_IMAGE = new byte[]{3};
        OP_CODE_VALIDATE = new byte[]{4};
        OP_CODE_ACTIVATE_AND_RESET = new byte[]{5};
        OP_CODE_RESET = new byte[]{6};
        OP_CODE_PACKET_RECEIPT_NOTIF_REQ = new byte[]{8, 0, 0};
    }

    public LegacyDfuImpl(@NonNull Intent intent, @NonNull DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        this.mBluetoothCallback = new LegacyBluetoothCallback();
    }

    private int getStatusCode(@Nullable byte[] bArr, int i) throws UnknownResponseException {
        byte b;
        if (bArr != null && bArr.length == 3 && bArr[0] == 16 && bArr[1] == i && (b = bArr[2]) >= 1 && b <= 6) {
            return b;
        }
        throw new UnknownResponseException("Invalid response received", bArr, 16, i);
    }

    private int readVersion(@Nullable BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic == null) {
            return 0;
        }
        return bluetoothGattCharacteristic.getIntValue(18, 0).intValue();
    }

    private void resetAndRestart(@NonNull BluetoothGatt bluetoothGatt, @NonNull Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        boolean z;
        this.mService.sendLogBroadcast(15, "Last upload interrupted. Restarting device...");
        this.mProgressInfo.setProgress(-5);
        logi("Sending Reset command (Op Code = 6)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
        this.mService.sendLogBroadcast(10, "Reset request sent");
        this.mService.waitUntilDisconnected();
        this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        BluetoothGattService service = bluetoothGatt.getService(BaseDfuImpl.GENERIC_ATTRIBUTE_SERVICE_UUID);
        if (service != null && service.getCharacteristic(BaseDfuImpl.SERVICE_CHANGED_UUID) != null) {
            z = true;
        } else {
            z = false;
        }
        this.mService.refreshDeviceCache(bluetoothGatt, !z);
        this.mService.close(bluetoothGatt);
        logi("Restarting the service");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        restartService(intent2, false, DFU_SERVICE_UUID);
    }

    private void setImageSize(@NonNull byte[] bArr, int i, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >> 24) & 255);
    }

    private void setNumberOfPackets(@NonNull byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
    }

    private void writeImageSize(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mImageSizeInProgress = true;
        byte[] bArr = new byte[4];
        setImageSize(bArr, i, 0);
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bArr));
        if (Build.VERSION.SDK_INT >= 33) {
            this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ", value=" + parse(bArr) + ", WRITE_TYPE_NO_RESPONSE)");
            this.mGatt.writeCharacteristic(bluetoothGattCharacteristic, bArr, 1);
        } else {
            bluetoothGattCharacteristic.setWriteType(1);
            bluetoothGattCharacteristic.setValue(bArr);
            this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + oIX0oI.I0Io.f4095I0Io);
            this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
        }
        try {
            synchronized (this.mLock) {
                while (true) {
                    try {
                        if (this.mImageSizeInProgress && this.mConnected && this.mError == 0 && !this.mAborted) {
                            this.mLock.wait();
                        }
                        if (!this.mPaused) {
                            break;
                        } else {
                            this.mLock.wait();
                        }
                    } finally {
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mAborted) {
            if (this.mConnected) {
                if (this.mError != 0) {
                    throw new DfuException("Unable to write Image Size", this.mError);
                }
                return;
            }
            throw new DeviceDisconnectedException("Unable to write Image Size: device disconnected", this.mError);
        }
        throw new UploadAbortedException();
    }

    private void writeOpCode(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        boolean z = false;
        byte b = bArr[0];
        if (b == 6 || b == 5) {
            z = true;
        }
        writeOpCode(bluetoothGattCharacteristic, bArr, z);
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    public UUID getControlPointCharacteristicUUID() {
        return DFU_CONTROL_POINT_UUID;
    }

    @Override // no.nordicsemi.android.dfu.BaseDfuImpl
    @NonNull
    public UUID getDfuServiceUUID() {
        return DFU_SERVICE_UUID;
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    public UUID getPacketCharacteristicUUID() {
        return DFU_PACKET_UUID;
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean isClientCompatible(@NonNull Intent intent, @NonNull BluetoothGatt bluetoothGatt) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = bluetoothGatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_PACKET_UUID);
        this.mPacketCharacteristic = characteristic2;
        if (characteristic2 == null) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x05ee A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0609 A[Catch: UploadAbortedException -> 0x0222, RemoteDfuException -> 0x05f9, UnknownResponseException -> 0x05fd, TryCatch #8 {UploadAbortedException -> 0x0222, blocks: (B:37:0x0159, B:40:0x015e, B:43:0x0167, B:48:0x0215, B:54:0x025d, B:63:0x026d, B:66:0x0299, B:143:0x0351, B:72:0x0431, B:74:0x044e, B:76:0x0459, B:77:0x04c9, B:79:0x04f7, B:81:0x04fd, B:85:0x0506, B:86:0x050d, B:87:0x049c, B:89:0x0510, B:95:0x0520, B:96:0x055e, B:99:0x057f, B:100:0x058e, B:102:0x05a6, B:105:0x05f2, B:108:0x0609, B:110:0x06b9, B:113:0x06ea, B:116:0x06ef, B:117:0x06f6, B:118:0x06f7, B:119:0x06fe, B:134:0x070a, B:135:0x0712, B:136:0x051c, B:137:0x0363, B:139:0x0367, B:140:0x036a, B:149:0x037d, B:153:0x0387, B:156:0x0423, B:161:0x0713, B:162:0x071a, B:164:0x071d, B:166:0x0720, B:174:0x0376, B:176:0x0378, B:184:0x0238, B:187:0x023c, B:188:0x023f), top: B:36:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x06f7 A[Catch: UploadAbortedException -> 0x0222, RemoteDfuException -> 0x05f9, UnknownResponseException -> 0x05fd, TryCatch #8 {UploadAbortedException -> 0x0222, blocks: (B:37:0x0159, B:40:0x015e, B:43:0x0167, B:48:0x0215, B:54:0x025d, B:63:0x026d, B:66:0x0299, B:143:0x0351, B:72:0x0431, B:74:0x044e, B:76:0x0459, B:77:0x04c9, B:79:0x04f7, B:81:0x04fd, B:85:0x0506, B:86:0x050d, B:87:0x049c, B:89:0x0510, B:95:0x0520, B:96:0x055e, B:99:0x057f, B:100:0x058e, B:102:0x05a6, B:105:0x05f2, B:108:0x0609, B:110:0x06b9, B:113:0x06ea, B:116:0x06ef, B:117:0x06f6, B:118:0x06f7, B:119:0x06fe, B:134:0x070a, B:135:0x0712, B:136:0x051c, B:137:0x0363, B:139:0x0367, B:140:0x036a, B:149:0x037d, B:153:0x0387, B:156:0x0423, B:161:0x0713, B:162:0x071a, B:164:0x071d, B:166:0x0720, B:174:0x0376, B:176:0x0378, B:184:0x0238, B:187:0x023c, B:188:0x023f), top: B:36:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x071e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x044e A[Catch: UnknownResponseException -> 0x0219, UploadAbortedException -> 0x0222, RemoteDfuException -> 0x0427, TRY_ENTER, TryCatch #5 {RemoteDfuException -> 0x0427, blocks: (B:74:0x044e, B:76:0x0459, B:77:0x04c9, B:79:0x04f7, B:81:0x04fd, B:85:0x0506, B:86:0x050d, B:87:0x049c, B:89:0x0510, B:95:0x0520, B:156:0x0423), top: B:36:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0510 A[Catch: UnknownResponseException -> 0x0219, UploadAbortedException -> 0x0222, RemoteDfuException -> 0x0427, TRY_LEAVE, TryCatch #5 {RemoteDfuException -> 0x0427, blocks: (B:74:0x044e, B:76:0x0459, B:77:0x04c9, B:79:0x04f7, B:81:0x04fd, B:85:0x0506, B:86:0x050d, B:87:0x049c, B:89:0x0510, B:95:0x0520, B:156:0x0423), top: B:36:0x0159 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0520 A[Catch: UnknownResponseException -> 0x0219, UploadAbortedException -> 0x0222, RemoteDfuException -> 0x0427, TRY_ENTER, TRY_LEAVE, TryCatch #5 {RemoteDfuException -> 0x0427, blocks: (B:74:0x044e, B:76:0x0459, B:77:0x04c9, B:79:0x04f7, B:81:0x04fd, B:85:0x0506, B:86:0x050d, B:87:0x049c, B:89:0x0510, B:95:0x0520, B:156:0x0423), top: B:36:0x0159 }] */
    /* JADX WARN: Type inference failed for: r12v38, types: [int] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r32v1 */
    /* JADX WARN: Type inference failed for: r32v20 */
    /* JADX WARN: Type inference failed for: r32v5 */
    /* JADX WARN: Type inference failed for: r32v7 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v35 */
    @Override // no.nordicsemi.android.dfu.DfuService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void performDfu(@androidx.annotation.NonNull android.content.Intent r36) throws no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            Method dump skipped, instructions count: 2007
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.LegacyDfuImpl.performDfu(android.content.Intent):void");
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public BaseCustomDfuImpl.BaseCustomBluetoothCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    private void writeImageSize(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, int i2, int i3) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mImageSizeInProgress = true;
        byte[] bArr = new byte[12];
        setImageSize(bArr, i, 0);
        setImageSize(bArr, i2, 4);
        setImageSize(bArr, i3, 8);
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bArr));
        if (Build.VERSION.SDK_INT >= 33) {
            this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ", value=" + parse(bArr) + ", WRITE_TYPE_NO_RESPONSE)");
            this.mGatt.writeCharacteristic(bluetoothGattCharacteristic, bArr, 1);
        } else {
            bluetoothGattCharacteristic.setWriteType(1);
            bluetoothGattCharacteristic.setValue(bArr);
            this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + oIX0oI.I0Io.f4095I0Io);
            this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
        }
        try {
            synchronized (this.mLock) {
                while (true) {
                    try {
                        if (this.mImageSizeInProgress && this.mConnected && this.mError == 0 && !this.mAborted) {
                            this.mLock.wait();
                        }
                        if (!this.mPaused) {
                            break;
                        } else {
                            this.mLock.wait();
                        }
                    } finally {
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mAborted) {
            if (this.mConnected) {
                if (this.mError != 0) {
                    throw new DfuException("Unable to write Image Sizes", this.mError);
                }
                return;
            }
            throw new DeviceDisconnectedException("Unable to write Image Sizes: device disconnected", this.mError);
        }
        throw new UploadAbortedException();
    }
}
