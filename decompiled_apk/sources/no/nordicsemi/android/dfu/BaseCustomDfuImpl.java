package no.nordicsemi.android.dfu;

import XXO0.oIX0oI;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.ExoPlayer;
import java.io.IOException;
import java.util.UUID;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.BaseDfuImpl;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.HexFileValidationException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"MissingPermission"})
/* loaded from: classes6.dex */
public abstract class BaseCustomDfuImpl extends BaseDfuImpl {
    boolean mFirmwareUploadInProgress;
    private boolean mInitPacketInProgress;
    int mPacketsBeforeNotification;
    private int mPacketsSentSinceNotification;
    boolean mRemoteErrorOccurred;

    /* loaded from: classes6.dex */
    public class BaseCustomBluetoothCallback extends BaseDfuImpl.BaseBluetoothGattCallback {
        public BaseCustomBluetoothCallback() {
            super();
        }

        public void handleNotification(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Notification received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bArr));
            BaseCustomDfuImpl baseCustomDfuImpl = BaseCustomDfuImpl.this;
            baseCustomDfuImpl.mReceivedData = bArr;
            baseCustomDfuImpl.mFirmwareUploadInProgress = false;
        }

        public void handlePacketReceiptNotification(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            BaseCustomDfuImpl baseCustomDfuImpl = BaseCustomDfuImpl.this;
            if (!baseCustomDfuImpl.mFirmwareUploadInProgress) {
                handleNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
                return;
            }
            BluetoothGattCharacteristic characteristic = bluetoothGatt.getService(baseCustomDfuImpl.getDfuServiceUUID()).getCharacteristic(BaseCustomDfuImpl.this.getPacketCharacteristicUUID());
            try {
                BaseCustomDfuImpl.this.mPacketsSentSinceNotification = 0;
                BaseCustomDfuImpl.this.waitIfPaused();
                BaseCustomDfuImpl baseCustomDfuImpl2 = BaseCustomDfuImpl.this;
                if (!baseCustomDfuImpl2.mAborted && baseCustomDfuImpl2.mError == 0 && !baseCustomDfuImpl2.mRemoteErrorOccurred && !baseCustomDfuImpl2.mResetRequestSent) {
                    boolean isComplete = baseCustomDfuImpl2.mProgressInfo.isComplete();
                    boolean isObjectComplete = BaseCustomDfuImpl.this.mProgressInfo.isObjectComplete();
                    if (!isComplete && !isObjectComplete) {
                        int availableObjectSizeIsBytes = BaseCustomDfuImpl.this.mProgressInfo.getAvailableObjectSizeIsBytes();
                        BaseCustomDfuImpl baseCustomDfuImpl3 = BaseCustomDfuImpl.this;
                        byte[] bArr2 = baseCustomDfuImpl3.mBuffer;
                        if (availableObjectSizeIsBytes < bArr2.length) {
                            bArr2 = new byte[availableObjectSizeIsBytes];
                        }
                        BaseCustomDfuImpl.this.writePacket(bluetoothGatt, characteristic, bArr2, baseCustomDfuImpl3.mFirmwareStream.read(bArr2));
                        return;
                    }
                    BaseCustomDfuImpl baseCustomDfuImpl4 = BaseCustomDfuImpl.this;
                    baseCustomDfuImpl4.mFirmwareUploadInProgress = false;
                    baseCustomDfuImpl4.notifyLock();
                    return;
                }
                baseCustomDfuImpl2.mFirmwareUploadInProgress = false;
                baseCustomDfuImpl2.mService.sendLogBroadcast(15, "Upload terminated");
            } catch (HexFileValidationException unused) {
                BaseCustomDfuImpl.this.loge("Invalid HEX file");
                BaseCustomDfuImpl.this.mError = 4099;
            } catch (IOException e) {
                BaseCustomDfuImpl.this.loge("Error while reading the input stream", e);
                BaseCustomDfuImpl.this.mError = 4100;
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            boolean z = true;
            if (i == 0) {
                UUID uuid = bluetoothGattCharacteristic.getUuid();
                if (uuid.equals(BaseCustomDfuImpl.this.getPacketCharacteristicUUID())) {
                    if (BaseCustomDfuImpl.this.mInitPacketInProgress) {
                        BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + uuid);
                        BaseCustomDfuImpl.this.mInitPacketInProgress = false;
                    } else {
                        BaseCustomDfuImpl baseCustomDfuImpl = BaseCustomDfuImpl.this;
                        if (baseCustomDfuImpl.mFirmwareUploadInProgress) {
                            baseCustomDfuImpl.mPacketsSentSinceNotification++;
                            BaseCustomDfuImpl baseCustomDfuImpl2 = BaseCustomDfuImpl.this;
                            if (baseCustomDfuImpl2.mPacketsBeforeNotification <= 0 || baseCustomDfuImpl2.mPacketsSentSinceNotification < BaseCustomDfuImpl.this.mPacketsBeforeNotification) {
                                z = false;
                            }
                            boolean isComplete = BaseCustomDfuImpl.this.mProgressInfo.isComplete();
                            boolean isObjectComplete = BaseCustomDfuImpl.this.mProgressInfo.isObjectComplete();
                            if (z) {
                                return;
                            }
                            if (!isComplete && !isObjectComplete) {
                                try {
                                    BaseCustomDfuImpl.this.waitIfPaused();
                                    BaseCustomDfuImpl baseCustomDfuImpl3 = BaseCustomDfuImpl.this;
                                    if (!baseCustomDfuImpl3.mAborted && baseCustomDfuImpl3.mError == 0 && !baseCustomDfuImpl3.mRemoteErrorOccurred && !baseCustomDfuImpl3.mResetRequestSent) {
                                        int availableObjectSizeIsBytes = baseCustomDfuImpl3.mProgressInfo.getAvailableObjectSizeIsBytes();
                                        BaseCustomDfuImpl baseCustomDfuImpl4 = BaseCustomDfuImpl.this;
                                        byte[] bArr = baseCustomDfuImpl4.mBuffer;
                                        if (availableObjectSizeIsBytes < bArr.length) {
                                            bArr = new byte[availableObjectSizeIsBytes];
                                        }
                                        BaseCustomDfuImpl.this.writePacket(bluetoothGatt, bluetoothGattCharacteristic, bArr, baseCustomDfuImpl4.mFirmwareStream.read(bArr));
                                        return;
                                    }
                                    baseCustomDfuImpl3.mFirmwareUploadInProgress = false;
                                    baseCustomDfuImpl3.mService.sendLogBroadcast(15, "Upload terminated");
                                    BaseCustomDfuImpl.this.notifyLock();
                                    return;
                                } catch (HexFileValidationException unused) {
                                    BaseCustomDfuImpl.this.loge("Invalid HEX file");
                                    BaseCustomDfuImpl.this.mError = 4099;
                                } catch (IOException e) {
                                    BaseCustomDfuImpl.this.loge("Error while reading the input stream", e);
                                    BaseCustomDfuImpl.this.mError = 4100;
                                }
                            } else {
                                BaseCustomDfuImpl baseCustomDfuImpl5 = BaseCustomDfuImpl.this;
                                baseCustomDfuImpl5.mFirmwareUploadInProgress = false;
                                baseCustomDfuImpl5.notifyLock();
                                return;
                            }
                        } else {
                            baseCustomDfuImpl.mService.sendLogBroadcast(5, "Data written to " + uuid);
                            onPacketCharacteristicWrite();
                        }
                    }
                } else {
                    BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + uuid);
                    BaseCustomDfuImpl.this.mRequestCompleted = true;
                }
            } else {
                BaseCustomDfuImpl baseCustomDfuImpl6 = BaseCustomDfuImpl.this;
                if (baseCustomDfuImpl6.mResetRequestSent) {
                    baseCustomDfuImpl6.mRequestCompleted = true;
                } else {
                    baseCustomDfuImpl6.loge("Characteristic write error: " + i);
                    BaseCustomDfuImpl.this.mError = i | 16384;
                }
            }
            BaseCustomDfuImpl.this.notifyLock();
        }

        public void onPacketCharacteristicWrite() {
        }
    }

    public BaseCustomDfuImpl(@NonNull Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        int i = 12;
        if (intent.hasExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED)) {
            boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED, Build.VERSION.SDK_INT < 23);
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_VALUE, 12);
            if (intExtra >= 0 && intExtra <= 65535) {
                i = intExtra;
            }
            this.mPacketsBeforeNotification = booleanExtra ? i : 0;
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(dfuBaseService);
        boolean z = defaultSharedPreferences.getBoolean(DfuSettingsConstants.SETTINGS_PACKET_RECEIPT_NOTIFICATION_ENABLED, Build.VERSION.SDK_INT < 23);
        try {
            int parseInt = Integer.parseInt(defaultSharedPreferences.getString(DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS, String.valueOf(12)));
            if (parseInt >= 0 && parseInt <= 65535) {
                i = parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        this.mPacketsBeforeNotification = z ? i : 0;
    }

    private void writeInitPacket(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        if (!this.mAborted) {
            if (bArr.length != i) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                bArr = bArr2;
            }
            this.mReceivedData = null;
            this.mError = 0;
            this.mInitPacketInProgress = true;
            logi("Sending init packet (size: " + bArr.length + ", value: 0x" + parse(bArr) + oIX0oI.I0Io.f4095I0Io);
            this.mService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid() + " value (0x): " + parse(bArr));
            if (Build.VERSION.SDK_INT >= 33) {
                this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ", value=0x" + parse(bArr) + ", WRITE_TYPE_NO_RESPONSE)");
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
                            if (this.mInitPacketInProgress && this.mConnected && this.mError == 0) {
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
            if (this.mConnected) {
                if (this.mError == 0) {
                    return;
                } else {
                    throw new DfuException("Unable to write Init DFU Parameters", this.mError);
                }
            }
            throw new DeviceDisconnectedException("Unable to write Init DFU Parameters: device disconnected", this.mError);
        }
        throw new UploadAbortedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writePacket(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        if (i <= 0) {
            return;
        }
        if (bArr.length != i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            bArr = bArr2;
        }
        this.mProgressInfo.addBytesSent(i);
        if (Build.VERSION.SDK_INT >= 33) {
            bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic, bArr, 1);
            return;
        }
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(bArr);
        bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    public void finalize(Intent intent, boolean z) {
        boolean z2;
        boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_KEEP_BOND, false);
        DfuBaseService dfuBaseService = this.mService;
        BluetoothGatt bluetoothGatt = this.mGatt;
        if (!z && booleanExtra) {
            z2 = false;
        } else {
            z2 = true;
        }
        dfuBaseService.refreshDeviceCache(bluetoothGatt, z2);
        this.mService.close(this.mGatt);
        if (this.mGatt.getDevice().getBondState() == 12) {
            boolean booleanExtra2 = intent.getBooleanExtra(DfuBaseService.EXTRA_RESTORE_BOND, false);
            if (booleanExtra2 || !booleanExtra) {
                removeBond();
                this.mService.waitFor(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
            if (booleanExtra2 && (this.mFileType & 4) > 0 && !createBond()) {
                logw("Creating bond failed");
            }
        }
        if (this.mProgressInfo.isLastPart()) {
            this.mProgressInfo.setProgress(-6);
            return;
        }
        logi("Starting service that will upload application");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        intent2.putExtra(DfuBaseService.EXTRA_FILE_MIME_TYPE, DfuBaseService.MIME_TYPE_ZIP);
        intent2.putExtra(DfuBaseService.EXTRA_FILE_TYPE, 4);
        intent2.putExtra(DfuBaseService.EXTRA_PART_CURRENT, this.mProgressInfo.getCurrentPart() + 1);
        intent2.putExtra(DfuBaseService.EXTRA_PARTS_TOTAL, this.mProgressInfo.getTotalParts());
        restartService(intent2, true, getDfuServiceUUID());
    }

    public abstract UUID getControlPointCharacteristicUUID();

    public abstract UUID getPacketCharacteristicUUID();

    public void uploadFirmwareImage(BluetoothGattCharacteristic bluetoothGattCharacteristic) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        if (!this.mAborted) {
            this.mReceivedData = null;
            this.mError = 0;
            this.mFirmwareUploadInProgress = true;
            this.mPacketsSentSinceNotification = 0;
            try {
                int availableObjectSizeIsBytes = this.mProgressInfo.getAvailableObjectSizeIsBytes();
                byte[] bArr = this.mBuffer;
                if (availableObjectSizeIsBytes < bArr.length) {
                    bArr = new byte[availableObjectSizeIsBytes];
                }
                int read = this.mFirmwareStream.read(bArr);
                this.mService.sendLogBroadcast(1, "Sending firmware to characteristic " + bluetoothGattCharacteristic.getUuid() + "...");
                writePacket(this.mGatt, bluetoothGattCharacteristic, bArr, read);
                try {
                    synchronized (this.mLock) {
                        while (true) {
                            try {
                                if (this.mFirmwareUploadInProgress && this.mReceivedData == null && this.mConnected && this.mError == 0) {
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
                if (this.mConnected) {
                    if (this.mError == 0) {
                        return;
                    } else {
                        throw new DfuException("Uploading Firmware Image failed", this.mError);
                    }
                }
                throw new DeviceDisconnectedException("Uploading Firmware Image failed: device disconnected", this.mError);
            } catch (HexFileValidationException unused) {
                throw new DfuException("HEX file not valid", 4099);
            } catch (IOException unused2) {
                throw new DfuException("Error while reading file", 4100);
            }
        }
        throw new UploadAbortedException();
    }

    public void writeInitData(BluetoothGattCharacteristic bluetoothGattCharacteristic, CRC32 crc32) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        try {
            byte[] bArr = this.mBuffer;
            while (true) {
                int read = this.mInitPacketStream.read(bArr, 0, bArr.length);
                if (read != -1) {
                    writeInitPacket(bluetoothGattCharacteristic, bArr, read);
                    if (crc32 != null) {
                        crc32.update(bArr, 0, read);
                    }
                } else {
                    return;
                }
            }
        } catch (IOException e) {
            loge("Error while reading Init packet file", e);
            throw new DfuException("Error while reading Init packet file", 4098);
        }
    }
}
