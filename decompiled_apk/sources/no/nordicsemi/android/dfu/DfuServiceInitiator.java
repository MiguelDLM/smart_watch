package no.nordicsemi.android.dfu;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelUuid;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import java.security.InvalidParameterException;
import java.util.UUID;

/* loaded from: classes6.dex */
public final class DfuServiceInitiator {
    public static final int DEFAULT_MBR_SIZE = 4096;
    public static final int DEFAULT_PRN_VALUE = 12;
    public static final long DEFAULT_SCAN_TIMEOUT = 5000;
    public static final int SCOPE_APPLICATION = 2;
    public static final int SCOPE_SYSTEM_COMPONENTS = 1;
    private Parcelable[] buttonlessDfuWithBondSharingUuids;
    private Parcelable[] buttonlessDfuWithoutBondSharingUuids;
    private final String deviceAddress;
    private String deviceName;
    private Parcelable[] experimentalButtonlessDfuUuids;
    private String filePath;
    private int fileResId;
    private Uri fileUri;
    private String initFilePath;
    private int initFileResId;
    private Uri initFileUri;
    private boolean keepBond;
    private Parcelable[] legacyDfuUuids;
    private String mimeType;
    private Boolean packetReceiptNotificationsEnabled;
    private boolean restoreBond;
    private Parcelable[] secureDfuUuids;
    private boolean disableNotification = false;
    private boolean startAsForegroundService = true;
    private int fileType = -1;
    private boolean forceDfu = false;
    private boolean forceScanningForNewAddressInLegacyDfu = false;
    private boolean enableUnsafeExperimentalButtonlessDfu = false;
    private boolean disableResume = false;
    private int numberOfRetries = 0;
    private int mbrSize = 4096;
    private long dataObjectDelay = 0;
    private long rebootTime = 0;
    private long scanTimeout = 5000;
    private int numberOfPackets = 12;
    private int mtu = 517;
    private int currentMtu = 23;

    public DfuServiceInitiator(@NonNull String str) {
        this.deviceAddress = str;
    }

    @RequiresApi(api = 26)
    public static void createDfuNotificationChannel(@NonNull Context context, @NonNull String str, @NonNull String str2, boolean z) {
        NotificationChannel oIX0oI2 = androidx.media2.session.Oxx0IOOO.oIX0oI(DfuBaseService.NOTIFICATION_CHANNEL_DFU, str, 2);
        oIX0oI2.setDescription(str2);
        oIX0oI2.setShowBadge(z);
        oIX0oI2.setLockscreenVisibility(1);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(oIX0oI2);
        }
    }

    private DfuServiceInitiator init(@Nullable Uri uri, @Nullable String str, @RawRes int i) {
        if (!DfuBaseService.MIME_TYPE_ZIP.equals(this.mimeType)) {
            this.initFileUri = uri;
            this.initFilePath = str;
            this.initFileResId = i;
            return this;
        }
        throw new InvalidParameterException("Init file must be located inside the ZIP");
    }

    public DfuServiceInitiator disableMtuRequest() {
        this.mtu = 0;
        return this;
    }

    public DfuServiceInitiator disableResume() {
        this.disableResume = true;
        return this;
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(int i, @NonNull Uri uri) {
        if (i != 0) {
            return init(uri, null, 0, i, "application/octet-stream");
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }

    public DfuServiceInitiator setCurrentMtu(@IntRange(from = 23, to = 517) int i) {
        this.currentMtu = i;
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForButtonlessDfuWithBondSharing(@Nullable UUID uuid, @Nullable UUID uuid2) {
        ParcelUuid parcelUuid;
        ParcelUuid parcelUuid2 = null;
        if (uuid != null) {
            parcelUuid = new ParcelUuid(uuid);
        } else {
            parcelUuid = null;
        }
        if (uuid2 != null) {
            parcelUuid2 = new ParcelUuid(uuid2);
        }
        this.buttonlessDfuWithBondSharingUuids = new ParcelUuid[]{parcelUuid, parcelUuid2};
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForButtonlessDfuWithoutBondSharing(@Nullable UUID uuid, @Nullable UUID uuid2) {
        ParcelUuid parcelUuid;
        ParcelUuid parcelUuid2 = null;
        if (uuid != null) {
            parcelUuid = new ParcelUuid(uuid);
        } else {
            parcelUuid = null;
        }
        if (uuid2 != null) {
            parcelUuid2 = new ParcelUuid(uuid2);
        }
        this.buttonlessDfuWithoutBondSharingUuids = new ParcelUuid[]{parcelUuid, parcelUuid2};
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForExperimentalButtonlessDfu(@Nullable UUID uuid, @Nullable UUID uuid2) {
        ParcelUuid parcelUuid;
        ParcelUuid parcelUuid2 = null;
        if (uuid != null) {
            parcelUuid = new ParcelUuid(uuid);
        } else {
            parcelUuid = null;
        }
        if (uuid2 != null) {
            parcelUuid2 = new ParcelUuid(uuid2);
        }
        this.experimentalButtonlessDfuUuids = new ParcelUuid[]{parcelUuid, parcelUuid2};
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForLegacyDfu(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable UUID uuid3, @Nullable UUID uuid4) {
        ParcelUuid parcelUuid;
        ParcelUuid parcelUuid2;
        ParcelUuid parcelUuid3;
        ParcelUuid parcelUuid4 = null;
        if (uuid != null) {
            parcelUuid = new ParcelUuid(uuid);
        } else {
            parcelUuid = null;
        }
        if (uuid2 != null) {
            parcelUuid2 = new ParcelUuid(uuid2);
        } else {
            parcelUuid2 = null;
        }
        if (uuid3 != null) {
            parcelUuid3 = new ParcelUuid(uuid3);
        } else {
            parcelUuid3 = null;
        }
        if (uuid4 != null) {
            parcelUuid4 = new ParcelUuid(uuid4);
        }
        this.legacyDfuUuids = new ParcelUuid[]{parcelUuid, parcelUuid2, parcelUuid3, parcelUuid4};
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForSecureDfu(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable UUID uuid3) {
        ParcelUuid parcelUuid;
        ParcelUuid parcelUuid2;
        ParcelUuid parcelUuid3 = null;
        if (uuid != null) {
            parcelUuid = new ParcelUuid(uuid);
        } else {
            parcelUuid = null;
        }
        if (uuid2 != null) {
            parcelUuid2 = new ParcelUuid(uuid2);
        } else {
            parcelUuid2 = null;
        }
        if (uuid3 != null) {
            parcelUuid3 = new ParcelUuid(uuid3);
        }
        this.secureDfuUuids = new ParcelUuid[]{parcelUuid, parcelUuid2, parcelUuid3};
        return this;
    }

    public DfuServiceInitiator setDeviceName(@Nullable String str) {
        this.deviceName = str;
        return this;
    }

    public DfuServiceInitiator setDisableNotification(boolean z) {
        this.disableNotification = z;
        return this;
    }

    public DfuServiceInitiator setForceDfu(boolean z) {
        this.forceDfu = z;
        return this;
    }

    public DfuServiceInitiator setForceScanningForNewAddressInLegacyDfu(boolean z) {
        this.forceScanningForNewAddressInLegacyDfu = z;
        return this;
    }

    public DfuServiceInitiator setForeground(boolean z) {
        this.startAsForegroundService = z;
        return this;
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(@NonNull Uri uri) {
        return init(uri, null, 0);
    }

    public DfuServiceInitiator setKeepBond(boolean z) {
        this.keepBond = z;
        return this;
    }

    public DfuServiceInitiator setMbrSize(@IntRange(from = 0) int i) {
        this.mbrSize = i;
        return this;
    }

    public DfuServiceInitiator setMtu(@IntRange(from = 23, to = 517) int i) {
        this.mtu = i;
        return this;
    }

    public DfuServiceInitiator setNumberOfRetries(@IntRange(from = 0) int i) {
        this.numberOfRetries = i;
        return this;
    }

    public DfuServiceInitiator setPacketsReceiptNotificationsEnabled(boolean z) {
        this.packetReceiptNotificationsEnabled = Boolean.valueOf(z);
        return this;
    }

    public DfuServiceInitiator setPacketsReceiptNotificationsValue(@IntRange(from = 0) int i) {
        if (i <= 0) {
            i = 12;
        }
        this.numberOfPackets = i;
        return this;
    }

    public DfuServiceInitiator setPrepareDataObjectDelay(long j) {
        this.dataObjectDelay = j;
        return this;
    }

    public DfuServiceInitiator setRebootTime(long j) {
        this.rebootTime = j;
        return this;
    }

    public DfuServiceInitiator setRestoreBond(boolean z) {
        this.restoreBond = z;
        return this;
    }

    public DfuServiceInitiator setScanTimeout(long j) {
        this.scanTimeout = j;
        return this;
    }

    public DfuServiceInitiator setScope(int i) {
        if (DfuBaseService.MIME_TYPE_ZIP.equals(this.mimeType)) {
            if (i == 2) {
                this.fileType = 4;
            } else if (i == 1) {
                this.fileType = 3;
            } else if (i == 3) {
                this.fileType = 0;
            } else {
                throw new UnsupportedOperationException("Unknown scope");
            }
            return this;
        }
        throw new UnsupportedOperationException("Scope can be set only for a ZIP file");
    }

    public DfuServiceInitiator setUnsafeExperimentalButtonlessServiceInSecureDfuEnabled(boolean z) {
        this.enableUnsafeExperimentalButtonlessDfu = z;
        return this;
    }

    public DfuServiceInitiator setZip(@NonNull Uri uri) {
        return init(uri, null, 0, 0, DfuBaseService.MIME_TYPE_ZIP);
    }

    public DfuServiceController start(@NonNull Context context, @NonNull Class<? extends DfuBaseService> cls) {
        if (this.fileType != -1) {
            Intent intent = new Intent(context, cls);
            intent.putExtra(DfuBaseService.EXTRA_DEVICE_ADDRESS, this.deviceAddress);
            intent.putExtra(DfuBaseService.EXTRA_DEVICE_NAME, this.deviceName);
            intent.putExtra(DfuBaseService.EXTRA_DISABLE_NOTIFICATION, this.disableNotification);
            intent.putExtra(DfuBaseService.EXTRA_FOREGROUND_SERVICE, this.startAsForegroundService);
            intent.putExtra(DfuBaseService.EXTRA_FILE_MIME_TYPE, this.mimeType);
            intent.putExtra(DfuBaseService.EXTRA_FILE_TYPE, this.fileType);
            intent.putExtra(DfuBaseService.EXTRA_FILE_URI, this.fileUri);
            intent.putExtra(DfuBaseService.EXTRA_FILE_PATH, this.filePath);
            intent.putExtra(DfuBaseService.EXTRA_FILE_RES_ID, this.fileResId);
            intent.putExtra(DfuBaseService.EXTRA_INIT_FILE_URI, this.initFileUri);
            intent.putExtra(DfuBaseService.EXTRA_INIT_FILE_PATH, this.initFilePath);
            intent.putExtra(DfuBaseService.EXTRA_INIT_FILE_RES_ID, this.initFileResId);
            intent.putExtra(DfuBaseService.EXTRA_KEEP_BOND, this.keepBond);
            intent.putExtra(DfuBaseService.EXTRA_RESTORE_BOND, this.restoreBond);
            intent.putExtra(DfuBaseService.EXTRA_FORCE_DFU, this.forceDfu);
            intent.putExtra(DfuBaseService.EXTRA_FORCE_SCANNING_FOR_BOOTLOADER_IN_LEGACY_DFU, this.forceScanningForNewAddressInLegacyDfu);
            intent.putExtra(DfuBaseService.EXTRA_DISABLE_RESUME, this.disableResume);
            intent.putExtra(DfuBaseService.EXTRA_MAX_DFU_ATTEMPTS, this.numberOfRetries);
            intent.putExtra(DfuBaseService.EXTRA_MBR_SIZE, this.mbrSize);
            intent.putExtra(DfuBaseService.EXTRA_DATA_OBJECT_DELAY, this.dataObjectDelay);
            intent.putExtra(DfuBaseService.EXTRA_SCAN_TIMEOUT, this.scanTimeout);
            intent.putExtra(DfuBaseService.EXTRA_SCAN_DELAY, this.rebootTime);
            int i = this.mtu;
            if (i > 0) {
                intent.putExtra(DfuBaseService.EXTRA_MTU, i);
            }
            intent.putExtra(DfuBaseService.EXTRA_CURRENT_MTU, this.currentMtu);
            intent.putExtra(DfuBaseService.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU, this.enableUnsafeExperimentalButtonlessDfu);
            Boolean bool = this.packetReceiptNotificationsEnabled;
            if (bool != null) {
                intent.putExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED, bool);
                intent.putExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_VALUE, this.numberOfPackets);
            }
            Parcelable[] parcelableArr = this.legacyDfuUuids;
            if (parcelableArr != null) {
                intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU, parcelableArr);
            }
            Parcelable[] parcelableArr2 = this.secureDfuUuids;
            if (parcelableArr2 != null) {
                intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU, parcelableArr2);
            }
            Parcelable[] parcelableArr3 = this.experimentalButtonlessDfuUuids;
            if (parcelableArr3 != null) {
                intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU, parcelableArr3);
            }
            Parcelable[] parcelableArr4 = this.buttonlessDfuWithoutBondSharingUuids;
            if (parcelableArr4 != null) {
                intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING, parcelableArr4);
            }
            Parcelable[] parcelableArr5 = this.buttonlessDfuWithBondSharingUuids;
            if (parcelableArr5 != null) {
                intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING, parcelableArr5);
            }
            if (Build.VERSION.SDK_INT >= 26 && this.startAsForegroundService) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
            return new DfuServiceController(context);
        }
        throw new UnsupportedOperationException("You must specify the firmware file before starting the service");
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(@Nullable String str) {
        return init(null, str, 0);
    }

    public DfuServiceInitiator setZip(@NonNull String str) {
        return init(null, str, 0, 0, DfuBaseService.MIME_TYPE_ZIP);
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(int i, @NonNull String str) {
        if (i != 0) {
            return init(null, str, 0, i, "application/octet-stream");
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(@RawRes int i) {
        return init(null, null, i);
    }

    public DfuServiceInitiator setZip(@RawRes int i) {
        return init(null, null, i, 0, DfuBaseService.MIME_TYPE_ZIP);
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(@Nullable Uri uri, @Nullable String str) {
        return init(uri, str, 0);
    }

    public DfuServiceInitiator setZip(@Nullable Uri uri, @Nullable String str) {
        return init(uri, str, 0, 0, DfuBaseService.MIME_TYPE_ZIP);
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(int i, @Nullable Uri uri, @Nullable String str) {
        if (i != 0) {
            return init(uri, str, 0, i, "application/octet-stream");
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }

    private DfuServiceInitiator init(@Nullable Uri uri, @Nullable String str, @RawRes int i, int i2, @NonNull String str2) {
        this.fileUri = uri;
        this.filePath = str;
        this.fileResId = i;
        this.fileType = i2;
        this.mimeType = str2;
        if (DfuBaseService.MIME_TYPE_ZIP.equals(str2)) {
            this.initFileUri = null;
            this.initFilePath = null;
            this.initFileResId = 0;
        }
        return this;
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(int i, @RawRes int i2) {
        if (i != 0) {
            return init(null, null, i2, i, "application/octet-stream");
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }

    @RequiresApi(api = 26)
    public static void createDfuNotificationChannel(@NonNull Context context) {
        createDfuNotificationChannel(context, context.getString(R.string.dfu_channel_name), context.getString(R.string.dfu_channel_description), false);
    }
}
