package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"MissingPermission"})
/* loaded from: classes6.dex */
public class LegacyButtonlessDfuImpl extends BaseButtonlessDfuImpl {
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private int mVersion;
    static UUID DFU_SERVICE_UUID = LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
    static UUID DFU_CONTROL_POINT_UUID = LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
    static UUID DFU_VERSION_UUID = LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
    private static final byte[] OP_CODE_ENTER_BOOTLOADER = {1, 4};

    public LegacyButtonlessDfuImpl(@NonNull Intent intent, @NonNull DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    private String getVersionFeatures(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 5) {
                    if (i != 6) {
                        if (i != 7) {
                            if (i != 8) {
                                return "Unknown version";
                            }
                            return "Bootloader from SDK 9.0 or newer. Signature supported";
                        }
                        return "Bootloader from SDK 8.0 or newer. SHA-256 used instead of CRC-16 in the Init Packet";
                    }
                    return "Bootloader from SDK 8.0 or newer. Bond sharing supported";
                }
                return "Bootloader from SDK 7.0 or newer. No bond sharing";
            }
            return "Application with Legacy buttonless update from SDK 7.0 or newer";
        }
        return "Bootloader from SDK 6.1 or older";
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0066 A[EDGE_INSN: B:21:0x0066->B:22:0x0066 BREAK  A[LOOP:0: B:13:0x0043->B:41:0x005e], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int readVersion(@androidx.annotation.NonNull android.bluetooth.BluetoothGatt r5, @androidx.annotation.Nullable android.bluetooth.BluetoothGattCharacteristic r6) throws no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r4 = this;
            boolean r0 = r4.mConnected
            if (r0 == 0) goto La1
            boolean r0 = r4.mAborted
            if (r0 != 0) goto L9b
            r0 = 0
            if (r6 != 0) goto Lc
            return r0
        Lc:
            r1 = 0
            r4.mReceivedData = r1
            r4.mError = r0
            java.lang.String r1 = "Reading DFU version number..."
            r4.logi(r1)
            no.nordicsemi.android.dfu.DfuBaseService r1 = r4.mService
            r2 = 1
            java.lang.String r3 = "Reading DFU version number..."
            r1.sendLogBroadcast(r2, r3)
            no.nordicsemi.android.dfu.DfuBaseService r1 = r4.mService
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "gatt.readCharacteristic("
            r2.append(r3)
            java.util.UUID r3 = r6.getUuid()
            r2.append(r3)
            java.lang.String r3 = ")"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.sendLogBroadcast(r0, r2)
            r5.readCharacteristic(r6)
            java.lang.Object r5 = r4.mLock     // Catch: java.lang.InterruptedException -> L6a
            monitor-enter(r5)     // Catch: java.lang.InterruptedException -> L6a
        L43:
            boolean r6 = r4.mRequestCompleted     // Catch: java.lang.Throwable -> L4c
            if (r6 == 0) goto L4e
            byte[] r6 = r4.mReceivedData     // Catch: java.lang.Throwable -> L4c
            if (r6 != 0) goto L5a
            goto L4e
        L4c:
            r6 = move-exception
            goto L68
        L4e:
            boolean r6 = r4.mConnected     // Catch: java.lang.Throwable -> L4c
            if (r6 == 0) goto L5a
            int r6 = r4.mError     // Catch: java.lang.Throwable -> L4c
            if (r6 != 0) goto L5a
            boolean r6 = r4.mAborted     // Catch: java.lang.Throwable -> L4c
            if (r6 == 0) goto L5e
        L5a:
            boolean r6 = r4.mPaused     // Catch: java.lang.Throwable -> L4c
            if (r6 == 0) goto L66
        L5e:
            r4.mRequestCompleted = r0     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r6 = r4.mLock     // Catch: java.lang.Throwable -> L4c
            r6.wait()     // Catch: java.lang.Throwable -> L4c
            goto L43
        L66:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L4c
            goto L70
        L68:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L4c
            throw r6     // Catch: java.lang.InterruptedException -> L6a
        L6a:
            r5 = move-exception
            java.lang.String r6 = "Sleeping interrupted"
            r4.loge(r6, r5)
        L70:
            boolean r5 = r4.mConnected
            if (r5 == 0) goto L91
            int r5 = r4.mError
            if (r5 != 0) goto L87
            byte[] r5 = r4.mReceivedData
            if (r5 == 0) goto L86
            int r6 = r5.length
            r1 = 2
            if (r6 >= r1) goto L81
            goto L86
        L81:
            int r5 = r4.getShort(r5, r0)
            return r5
        L86:
            return r0
        L87:
            no.nordicsemi.android.dfu.internal.exception.DfuException r5 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.String r6 = "Unable to read version number"
            int r0 = r4.mError
            r5.<init>(r6, r0)
            throw r5
        L91:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r5 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r6 = "Unable to read version number: device disconnected"
            int r0 = r4.mError
            r5.<init>(r6, r0)
            throw r5
        L9b:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r5 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r5.<init>()
            throw r5
        La1:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r5 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r6 = "Unable to read version number: device disconnected"
            int r0 = r4.mError
            r5.<init>(r6, r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.LegacyButtonlessDfuImpl.readVersion(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattCharacteristic):int");
    }

    @Override // no.nordicsemi.android.dfu.BaseDfuImpl
    @NonNull
    public UUID getDfuServiceUUID() {
        return LegacyDfuImpl.DFU_SERVICE_UUID;
    }

    public int getShort(@NonNull byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean isClientCompatible(@NonNull Intent intent, @NonNull BluetoothGatt bluetoothGatt) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        BluetoothGattCharacteristic characteristic;
        int i;
        boolean z;
        BluetoothGattService service = bluetoothGatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        this.mProgressInfo.setProgress(-2);
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_VERSION_UUID);
        if (characteristic2 != null) {
            i = readVersion(bluetoothGatt, characteristic2);
            this.mVersion = i;
            int i2 = i & 15;
            int i3 = i >> 8;
            logi("Version number read: " + i3 + FileUtils.FILE_EXTENSION_SEPARATOR + i2 + org.apache.commons.text.oIX0oI.f33048oxoX + getVersionFeatures(i));
            DfuBaseService dfuBaseService = this.mService;
            StringBuilder sb = new StringBuilder();
            sb.append("Version number read: ");
            sb.append(i3);
            sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            sb.append(i2);
            dfuBaseService.sendLogBroadcast(10, sb.toString());
        } else {
            logi("No DFU Version characteristic found -> " + getVersionFeatures(0));
            this.mService.sendLogBroadcast(10, "DFU Version characteristic not found");
            i = 0;
        }
        boolean z2 = PreferenceManager.getDefaultSharedPreferences(this.mService).getBoolean(DfuSettingsConstants.SETTINGS_ASSUME_DFU_NODE, false);
        if (intent.hasExtra(DfuBaseService.EXTRA_FORCE_DFU)) {
            z2 = intent.getBooleanExtra(DfuBaseService.EXTRA_FORCE_DFU, false);
        }
        if (bluetoothGatt.getServices().size() > 3) {
            z = true;
        } else {
            z = false;
        }
        if (i == 0 && z) {
            logi("Additional services found -> Bootloader from SDK 6.1. Updating SD and BL supported, extended init packet not supported");
        }
        if (i != 1 && (z2 || i != 0 || !z)) {
            return false;
        }
        return true;
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public void performDfu(@NonNull Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        logw("Application with legacy buttonless update found");
        this.mService.sendLogBroadcast(15, "Application with buttonless update found");
        boolean z = true;
        this.mService.sendLogBroadcast(1, "Jumping to the DFU Bootloader...");
        if (intent.hasExtra(DfuBaseService.EXTRA_MTU)) {
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_MTU, 517);
            logi("Requesting MTU = " + intExtra);
            requestMtu(intExtra);
        }
        enableCCCD(this.mControlPointCharacteristic, 1);
        this.mService.sendLogBroadcast(10, "Notifications enabled");
        this.mProgressInfo.setProgress(-3);
        logi("Sending Start DFU command (Op Code = 1, Upload Mode = 4)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_ENTER_BOOTLOADER, true);
        this.mService.sendLogBroadcast(10, "Jump to bootloader sent (Op Code = 1, Upload Mode = 4)");
        BluetoothGatt bluetoothGatt = this.mGatt;
        boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_FORCE_SCANNING_FOR_BOOTLOADER_IN_LEGACY_DFU, false);
        if (!booleanExtra && this.mVersion != 0) {
            this.mService.waitUntilDisconnected();
            this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        } else {
            this.mService.disconnect(bluetoothGatt);
        }
        logi("Device disconnected");
        if (!booleanExtra && this.mVersion != 0) {
            z = false;
        }
        finalize(intent, false, z);
    }
}
