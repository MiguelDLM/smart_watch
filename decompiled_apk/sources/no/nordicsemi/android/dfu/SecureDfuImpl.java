package no.nordicsemi.android.dfu;

import XXO0.oIX0oI;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.szabh.smable3.entity.BleWatchFaceId;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.UUID;
import no.nordicsemi.android.dfu.BaseCustomDfuImpl;
import no.nordicsemi.android.dfu.BaseDfuImpl;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuExtendedErrorException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import no.nordicsemi.android.error.SecureDfuError;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class SecureDfuImpl extends BaseCustomDfuImpl {
    static final UUID DEFAULT_DFU_CONTROL_POINT_UUID;
    static final UUID DEFAULT_DFU_PACKET_UUID;
    static final UUID DEFAULT_DFU_SERVICE_UUID;
    static UUID DFU_CONTROL_POINT_UUID = null;
    static UUID DFU_PACKET_UUID = null;
    static UUID DFU_SERVICE_UUID = null;
    private static final int DFU_STATUS_SUCCESS = 1;
    private static final int MAX_ATTEMPTS = 3;
    private static final int OBJECT_COMMAND = 1;
    private static final int OBJECT_DATA = 2;
    private static final byte[] OP_CODE_CALCULATE_CHECKSUM;
    private static final int OP_CODE_CALCULATE_CHECKSUM_KEY = 3;
    private static final byte[] OP_CODE_CREATE_COMMAND;
    private static final byte[] OP_CODE_CREATE_DATA;
    private static final int OP_CODE_CREATE_KEY = 1;
    private static final byte[] OP_CODE_EXECUTE;
    private static final int OP_CODE_EXECUTE_KEY = 4;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 2;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 96;
    private static final byte[] OP_CODE_SELECT_OBJECT;
    private static final int OP_CODE_SELECT_OBJECT_KEY = 6;
    private final SecureBluetoothCallback mBluetoothCallback;
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private BluetoothGattCharacteristic mPacketCharacteristic;
    private long prepareObjectDelay;

    /* loaded from: classes6.dex */
    public static class ObjectChecksum {
        int CRC32;
        int offset;

        private ObjectChecksum() {
        }
    }

    /* loaded from: classes6.dex */
    public static class ObjectInfo extends ObjectChecksum {
        int maxSize;

        private ObjectInfo() {
            super();
        }
    }

    /* loaded from: classes6.dex */
    public class SecureBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        public SecureBluetoothCallback() {
            super();
        }

        @Override // no.nordicsemi.android.dfu.BaseDfuImpl.BaseBluetoothGattCallback, android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(@NonNull BluetoothGatt bluetoothGatt, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr) {
            if (bArr.length < 3) {
                SecureDfuImpl.this.loge("Empty response: " + parse(bArr));
                SecureDfuImpl secureDfuImpl = SecureDfuImpl.this;
                secureDfuImpl.mError = 4104;
                secureDfuImpl.notifyLock();
                return;
            }
            if ((bArr[0] & 255) == 96) {
                if ((bArr[1] & 255) != 3) {
                    SecureDfuImpl secureDfuImpl2 = SecureDfuImpl.this;
                    if (!secureDfuImpl2.mRemoteErrorOccurred) {
                        if ((bArr[2] & 255) != 1) {
                            secureDfuImpl2.mRemoteErrorOccurred = true;
                        }
                        handleNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
                    }
                } else {
                    int intValue = bluetoothGattCharacteristic.getIntValue(20, 3).intValue();
                    if (((int) (((ArchiveInputStream) SecureDfuImpl.this.mFirmwareStream).getCrc32() & BleWatchFaceId.WATCHFACE_ID_INVALID)) == bluetoothGattCharacteristic.getIntValue(20, 7).intValue()) {
                        SecureDfuImpl.this.mProgressInfo.setBytesReceived(intValue);
                    } else {
                        SecureDfuImpl secureDfuImpl3 = SecureDfuImpl.this;
                        if (secureDfuImpl3.mFirmwareUploadInProgress) {
                            secureDfuImpl3.mFirmwareUploadInProgress = false;
                            secureDfuImpl3.notifyLock();
                            return;
                        }
                    }
                    handlePacketReceiptNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
                }
            } else {
                SecureDfuImpl.this.loge("Invalid response: " + parse(bArr));
                SecureDfuImpl.this.mError = 4104;
            }
            SecureDfuImpl.this.notifyLock();
        }
    }

    static {
        UUID uuid = new UUID(279658205548544L, -9223371485494954757L);
        DEFAULT_DFU_SERVICE_UUID = uuid;
        UUID uuid2 = new UUID(-8157989241631715488L, -6937650605005804976L);
        DEFAULT_DFU_CONTROL_POINT_UUID = uuid2;
        UUID uuid3 = new UUID(-8157989237336748192L, -6937650605005804976L);
        DEFAULT_DFU_PACKET_UUID = uuid3;
        DFU_SERVICE_UUID = uuid;
        DFU_CONTROL_POINT_UUID = uuid2;
        DFU_PACKET_UUID = uuid3;
        OP_CODE_CREATE_COMMAND = new byte[]{1, 1, 0, 0, 0, 0};
        OP_CODE_CREATE_DATA = new byte[]{1, 2, 0, 0, 0, 0};
        OP_CODE_PACKET_RECEIPT_NOTIF_REQ = new byte[]{2, 0, 0};
        OP_CODE_CALCULATE_CHECKSUM = new byte[]{3};
        OP_CODE_EXECUTE = new byte[]{4};
        OP_CODE_SELECT_OBJECT = new byte[]{6, 0};
    }

    public SecureDfuImpl(@NonNull Intent intent, @NonNull DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        this.mBluetoothCallback = new SecureBluetoothCallback();
    }

    private int getStatusCode(byte[] bArr, int i) throws UnknownResponseException {
        byte b;
        if (bArr != null && bArr.length >= 3 && bArr[0] == 96 && bArr[1] == i && ((b = bArr[2]) == 1 || b == 2 || b == 3 || b == 4 || b == 5 || b == 7 || b == 8 || b == 10 || b == 11)) {
            return b;
        }
        throw new UnknownResponseException("Invalid response received", bArr, 96, i);
    }

    private ObjectChecksum readChecksum() throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        if (this.mConnected) {
            writeOpCode(this.mControlPointCharacteristic, OP_CODE_CALCULATE_CHECKSUM);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 3);
            if (statusCode != 11) {
                if (statusCode == 1) {
                    ObjectChecksum objectChecksum = new ObjectChecksum();
                    objectChecksum.offset = unsignedBytesToInt(readNotificationResponse, 3);
                    objectChecksum.CRC32 = unsignedBytesToInt(readNotificationResponse, 7);
                    return objectChecksum;
                }
                throw new RemoteDfuException("Receiving Checksum failed", statusCode);
            }
            throw new RemoteDfuExtendedErrorException("Receiving Checksum failed", readNotificationResponse[3]);
        }
        throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected", this.mError);
    }

    private ObjectInfo selectObject(int i) throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        if (this.mConnected) {
            byte[] bArr = OP_CODE_SELECT_OBJECT;
            bArr[1] = (byte) i;
            writeOpCode(this.mControlPointCharacteristic, bArr);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 6);
            if (statusCode != 11) {
                if (statusCode == 1) {
                    ObjectInfo objectInfo = new ObjectInfo();
                    objectInfo.maxSize = unsignedBytesToInt(readNotificationResponse, 3);
                    objectInfo.offset = unsignedBytesToInt(readNotificationResponse, 7);
                    objectInfo.CRC32 = unsignedBytesToInt(readNotificationResponse, 11);
                    return objectInfo;
                }
                throw new RemoteDfuException("Selecting object failed", statusCode);
            }
            throw new RemoteDfuExtendedErrorException("Selecting object failed", readNotificationResponse[3]);
        }
        throw new DeviceDisconnectedException("Unable to read object info: device disconnected", this.mError);
    }

    private void sendFirmware(BluetoothGatt bluetoothGatt) throws RemoteDfuException, DeviceDisconnectedException, DfuException, UploadAbortedException, UnknownResponseException {
        int i;
        boolean z;
        long j;
        long j2;
        String str;
        int i2 = this.mPacketsBeforeNotification;
        if (i2 > 0) {
            setPacketReceiptNotifications(i2);
            this.mService.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 2) sent (Value = " + i2 + oIX0oI.I0Io.f4095I0Io);
        }
        logi("Setting object to Data (Op Code = 6, Type = 2)");
        ObjectInfo selectObject = selectObject(2);
        Locale locale = Locale.US;
        logi(String.format(locale, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(selectObject.maxSize), Integer.valueOf(selectObject.offset), Integer.valueOf(selectObject.CRC32)));
        DfuBaseService dfuBaseService = this.mService;
        Integer valueOf = Integer.valueOf(selectObject.maxSize);
        Integer valueOf2 = Integer.valueOf(selectObject.offset);
        Integer valueOf3 = Integer.valueOf(selectObject.CRC32);
        String str2 = oIX0oI.I0Io.f4095I0Io;
        dfuBaseService.sendLogBroadcast(10, String.format(locale, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", valueOf, valueOf2, valueOf3));
        this.mProgressInfo.setMaxObjectSizeInBytes(selectObject.maxSize);
        int i3 = this.mImageSizeInBytes;
        int i4 = selectObject.maxSize;
        int i5 = ((i3 + i4) - 1) / i4;
        int i6 = selectObject.offset;
        if (i6 > 0) {
            try {
                i = i6 / i4;
                int i7 = i4 * i;
                int i8 = i6 - i7;
                if (i8 == 0) {
                    i7 -= i4;
                } else {
                    i4 = i8;
                }
                int i9 = i7;
                if (i9 > 0) {
                    this.mFirmwareStream.read(new byte[i9]);
                    this.mFirmwareStream.mark(selectObject.maxSize);
                }
                this.mFirmwareStream.read(new byte[i4]);
                if (((int) (((ArchiveInputStream) this.mFirmwareStream).getCrc32() & BleWatchFaceId.WATCHFACE_ID_INVALID)) == selectObject.CRC32) {
                    logi(selectObject.offset + " bytes of data sent before, CRC match");
                    this.mService.sendLogBroadcast(10, selectObject.offset + " bytes of data sent before, CRC match");
                    this.mProgressInfo.setBytesSent(selectObject.offset);
                    this.mProgressInfo.setBytesReceived(selectObject.offset);
                    if (i4 == selectObject.maxSize && selectObject.offset < this.mImageSizeInBytes) {
                        logi("Executing data object (Op Code = 4)");
                        try {
                            writeExecute();
                            this.mService.sendLogBroadcast(10, "Data object executed");
                        } catch (RemoteDfuException e) {
                            if (e.getErrorNumber() == 8) {
                                this.mService.sendLogBroadcast(10, "Data object already executed");
                                this.mRemoteErrorOccurred = false;
                            } else {
                                throw e;
                            }
                        }
                    } else {
                        z = true;
                    }
                } else {
                    logi(selectObject.offset + " bytes sent before, CRC does not match");
                    this.mService.sendLogBroadcast(15, selectObject.offset + " bytes sent before, CRC does not match");
                    this.mProgressInfo.setBytesSent(i9);
                    this.mProgressInfo.setBytesReceived(i9);
                    selectObject.offset = selectObject.offset - i4;
                    selectObject.CRC32 = 0;
                    this.mFirmwareStream.reset();
                    logi("Resuming from byte " + selectObject.offset + "...");
                    this.mService.sendLogBroadcast(10, "Resuming from byte " + selectObject.offset + "...");
                }
                z = false;
            } catch (IOException e2) {
                loge("Error while reading firmware stream", e2);
                this.mService.terminateConnection(bluetoothGatt, 4100);
                return;
            }
        } else {
            this.mProgressInfo.setBytesSent(0);
            z = false;
            i = 0;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (selectObject.offset < this.mImageSizeInBytes) {
            int i10 = 1;
            while (this.mProgressInfo.getAvailableObjectSizeIsBytes() > 0) {
                if (!z) {
                    int availableObjectSizeIsBytes = this.mProgressInfo.getAvailableObjectSizeIsBytes();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Creating Data object (Op Code = 1, Type = 2, Size = ");
                    sb.append(availableObjectSizeIsBytes);
                    sb.append(") (");
                    int i11 = i + 1;
                    sb.append(i11);
                    sb.append("/");
                    sb.append(i5);
                    j2 = elapsedRealtime;
                    str = str2;
                    sb.append(str);
                    logi(sb.toString());
                    writeCreateRequest(2, availableObjectSizeIsBytes);
                    this.mService.sendLogBroadcast(10, "Data object (" + i11 + "/" + i5 + ") created");
                    long j3 = this.prepareObjectDelay;
                    if (j3 > 0 || i5 == 0) {
                        DfuBaseService dfuBaseService2 = this.mService;
                        if (j3 <= 0) {
                            j3 = 400;
                        }
                        dfuBaseService2.waitFor(j3);
                    }
                    this.mService.sendLogBroadcast(10, "Uploading firmware...");
                } else {
                    j2 = elapsedRealtime;
                    str = str2;
                    this.mService.sendLogBroadcast(10, "Resuming uploading firmware...");
                    z = false;
                }
                try {
                    logi("Uploading firmware...");
                    uploadFirmwareImage(this.mPacketCharacteristic);
                    logi("Sending Calculate Checksum command (Op Code = 3)");
                    ObjectChecksum readChecksum = readChecksum();
                    Locale locale2 = Locale.US;
                    logi(String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(readChecksum.offset), Integer.valueOf(readChecksum.CRC32)));
                    boolean z2 = z;
                    int i12 = i5;
                    this.mService.sendLogBroadcast(10, String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(readChecksum.offset), Integer.valueOf(readChecksum.CRC32)));
                    int bytesSent = this.mProgressInfo.getBytesSent() - readChecksum.offset;
                    if (bytesSent > 0) {
                        logw(bytesSent + " bytes were lost!");
                        this.mService.sendLogBroadcast(15, bytesSent + " bytes were lost");
                        try {
                            this.mFirmwareStream.reset();
                            this.mFirmwareStream.read(new byte[selectObject.maxSize - bytesSent]);
                            this.mProgressInfo.setBytesSent(readChecksum.offset);
                            int i13 = this.mPacketsBeforeNotification;
                            if (i13 == 0 || i13 > 1) {
                                this.mPacketsBeforeNotification = 1;
                                setPacketReceiptNotifications(1);
                                this.mService.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 2) sent (Value = 1)");
                            }
                        } catch (IOException e3) {
                            loge("Error while reading firmware stream", e3);
                            this.mService.terminateConnection(bluetoothGatt, 4100);
                            return;
                        } catch (Throwable th) {
                            loge("Progress lost. Bytes sent: " + this.mProgressInfo.getBytesSent(), th);
                            this.mService.terminateConnection(bluetoothGatt, 4111);
                            return;
                        }
                    }
                    int crc32 = (int) (((ArchiveInputStream) this.mFirmwareStream).getCrc32() & BleWatchFaceId.WATCHFACE_ID_INVALID);
                    if (crc32 == readChecksum.CRC32) {
                        if (bytesSent > 0) {
                            str2 = str;
                            elapsedRealtime = j2;
                            i5 = i12;
                            z = true;
                        } else {
                            logi("Executing data object (Op Code = 4)");
                            writeExecute(this.mProgressInfo.isComplete());
                            this.mService.sendLogBroadcast(10, "Data object executed");
                            i++;
                            this.mFirmwareStream.mark(0);
                            i10 = 1;
                        }
                    } else {
                        String format = String.format(locale2, "CRC does not match! Expected %08X but found %08X.", Integer.valueOf(crc32), Integer.valueOf(readChecksum.CRC32));
                        if (i10 < 3) {
                            int i14 = i10 + 1;
                            String str3 = format + String.format(locale2, " Retrying...(%d/%d)", Integer.valueOf(i14), 3);
                            logi(str3);
                            this.mService.sendLogBroadcast(15, str3);
                            try {
                                this.mFirmwareStream.reset();
                                this.mProgressInfo.setBytesSent(((ArchiveInputStream) this.mFirmwareStream).getBytesRead());
                                i10 = i14;
                            } catch (IOException e4) {
                                loge("Error while resetting the firmware stream", e4);
                                this.mService.terminateConnection(bluetoothGatt, 4100);
                                return;
                            }
                        } else {
                            loge(format);
                            this.mService.sendLogBroadcast(20, format);
                            this.mService.terminateConnection(bluetoothGatt, 4109);
                            return;
                        }
                    }
                    str2 = str;
                    elapsedRealtime = j2;
                    z = z2;
                    i5 = i12;
                } catch (DeviceDisconnectedException e5) {
                    loge("Disconnected while sending data");
                    throw e5;
                }
            }
            j = elapsedRealtime;
        } else {
            j = elapsedRealtime;
            logi("Executing data object (Op Code = 4)");
            writeExecute(true);
            this.mService.sendLogBroadcast(10, "Data object executed");
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Transfer of ");
        sb2.append(this.mProgressInfo.getBytesSent() - selectObject.offset);
        sb2.append(" bytes has taken ");
        long j4 = elapsedRealtime2 - j;
        sb2.append(j4);
        sb2.append(" ms");
        logi(sb2.toString());
        this.mService.sendLogBroadcast(10, "Upload completed in " + j4 + " ms");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void sendInitPacket(@androidx.annotation.NonNull android.bluetooth.BluetoothGatt r17, boolean r18) throws no.nordicsemi.android.dfu.internal.exception.RemoteDfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.UnknownResponseException {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.SecureDfuImpl.sendInitPacket(android.bluetooth.BluetoothGatt, boolean):void");
    }

    private void setNumberOfPackets(@NonNull byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
    }

    private void setObjectSize(@NonNull byte[] bArr, int i) {
        bArr[2] = (byte) (i & 255);
        bArr[3] = (byte) ((i >> 8) & 255);
        bArr[4] = (byte) ((i >> 16) & 255);
        bArr[5] = (byte) ((i >> 24) & 255);
    }

    private void setPacketReceiptNotifications(int i) throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        if (this.mConnected) {
            logi("Sending the number of packets before notifications (Op Code = 2, Value = " + i + oIX0oI.I0Io.f4095I0Io);
            byte[] bArr = OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
            setNumberOfPackets(bArr, i);
            writeOpCode(this.mControlPointCharacteristic, bArr);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 2);
            if (statusCode != 11) {
                if (statusCode == 1) {
                    return;
                } else {
                    throw new RemoteDfuException("Sending the number of packets failed", statusCode);
                }
            }
            throw new RemoteDfuExtendedErrorException("Sending the number of packets failed", readNotificationResponse[3]);
        }
        throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected", this.mError);
    }

    private int unsignedBytesToInt(@NonNull byte[] bArr, int i) {
        return (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8) + ((bArr[i + 2] & 255) << 16) + ((bArr[i + 3] & 255) << 24);
    }

    private void writeCreateRequest(int i, int i2) throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        byte[] bArr;
        if (this.mConnected) {
            if (i == 1) {
                bArr = OP_CODE_CREATE_COMMAND;
            } else {
                bArr = OP_CODE_CREATE_DATA;
            }
            setObjectSize(bArr, i2);
            writeOpCode(this.mControlPointCharacteristic, bArr);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 1);
            if (statusCode != 11) {
                if (statusCode == 1) {
                    return;
                } else {
                    throw new RemoteDfuException("Creating Command object failed", statusCode);
                }
            }
            throw new RemoteDfuExtendedErrorException("Creating Command object failed", readNotificationResponse[3]);
        }
        throw new DeviceDisconnectedException("Unable to create object: device disconnected", this.mError);
    }

    private void writeExecute() throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        if (this.mConnected) {
            writeOpCode(this.mControlPointCharacteristic, OP_CODE_EXECUTE);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 4);
            if (statusCode == 11) {
                throw new RemoteDfuExtendedErrorException("Executing object failed", readNotificationResponse[3]);
            }
            if (statusCode != 1) {
                throw new RemoteDfuException("Executing object failed", statusCode);
            }
            return;
        }
        throw new DeviceDisconnectedException("Unable to execute: device disconnected", this.mError);
    }

    private void writeOpCode(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        writeOpCode(bluetoothGattCharacteristic, bArr, false);
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

    @Override // no.nordicsemi.android.dfu.BaseDfuImpl, no.nordicsemi.android.dfu.DfuService
    public boolean initialize(@NonNull Intent intent, @NonNull BluetoothGatt bluetoothGatt, int i, @NonNull InputStream inputStream, @Nullable InputStream inputStream2) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        if (inputStream2 == null) {
            this.mService.sendLogBroadcast(20, "The Init packet is required by this version DFU Bootloader");
            this.mService.terminateConnection(bluetoothGatt, 4107);
            return false;
        }
        return super.initialize(intent, bluetoothGatt, i, inputStream, inputStream2);
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

    /* JADX WARN: Can't wrap try/catch for region: R(9:5|6|(6:11|(1:13)|14|15|16|17)|25|(0)|14|15|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008b, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0092, code lost:
    
        if (r8.mProgressInfo.isLastPart() == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0094, code lost:
    
        r8.mRemoteErrorOccurred = false;
        logw("Sending SD+BL failed. Trying to send App only");
        r8.mService.sendLogBroadcast(15, "Invalid system components. Trying to send application");
        r8.mFileType = 4;
        r5 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r8.mFirmwareStream;
        r5.setContentType(4);
        r2 = r5.getApplicationInit();
        r8.mInitPacketStream = new java.io.ByteArrayInputStream(r2);
        r8.mInitPacketSizeInBytes = r2.length;
        r2 = r5.applicationImageSize();
        r8.mImageSizeInBytes = r2;
        r8.mProgressInfo.init(r2, 2, 2);
        sendInitPacket(r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00e6, code lost:
    
        throw r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0082 A[Catch: RemoteDfuException -> 0x0077, UnknownResponseException -> 0x0079, UploadAbortedException -> 0x007c, TRY_LEAVE, TryCatch #0 {RemoteDfuException -> 0x0077, blocks: (B:6:0x0042, B:8:0x006e, B:13:0x0082, B:21:0x008c, B:23:0x0094, B:24:0x00e6, B:16:0x00cb), top: B:5:0x0042 }] */
    @Override // no.nordicsemi.android.dfu.DfuService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void performDfu(@androidx.annotation.NonNull android.content.Intent r9) throws no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.SecureDfuImpl.performDfu(android.content.Intent):void");
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public BaseDfuImpl.BaseBluetoothGattCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    private void writeExecute(boolean z) throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        try {
            writeExecute();
        } catch (RemoteDfuException e) {
            if (z && e.getErrorNumber() == 5) {
                logw(e.getMessage() + ": " + SecureDfuError.parse(517));
                if (this.mFileType == 1) {
                    logw("Are you sure your new SoftDevice is API compatible with the updated one? If not, update the bootloader as well");
                }
                this.mService.sendLogBroadcast(15, String.format(Locale.US, "Remote DFU error: %s. SD busy? Retrying...", SecureDfuError.parse(517)));
                logi("SD busy? Retrying...");
                logi("Executing data object (Op Code = 4)");
                writeExecute();
                return;
            }
            throw e;
        }
    }
}
