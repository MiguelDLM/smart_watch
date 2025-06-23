package no.nordicsemi.android.dfu;

import android.content.Intent;
import android.os.ParcelUuid;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.UUID;

/* loaded from: classes6.dex */
class UuidHelper {
    public static void assignCustomUuids(@NonNull Intent intent) {
        UUID uuid;
        UUID uuid2;
        UUID uuid3;
        UUID uuid4;
        UUID uuid5;
        UUID uuid6;
        UUID uuid7;
        UUID uuid8;
        UUID uuid9;
        UUID uuid10;
        UUID uuid11;
        UUID uuid12;
        UUID uuid13;
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU);
        if (parcelableArrayExtra != null && parcelableArrayExtra.length == 4) {
            Parcelable parcelable = parcelableArrayExtra[0];
            if (parcelable != null) {
                uuid10 = ((ParcelUuid) parcelable).getUuid();
            } else {
                uuid10 = LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
            }
            LegacyDfuImpl.DFU_SERVICE_UUID = uuid10;
            Parcelable parcelable2 = parcelableArrayExtra[1];
            if (parcelable2 != null) {
                uuid11 = ((ParcelUuid) parcelable2).getUuid();
            } else {
                uuid11 = LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
            }
            LegacyDfuImpl.DFU_CONTROL_POINT_UUID = uuid11;
            Parcelable parcelable3 = parcelableArrayExtra[2];
            if (parcelable3 != null) {
                uuid12 = ((ParcelUuid) parcelable3).getUuid();
            } else {
                uuid12 = LegacyDfuImpl.DEFAULT_DFU_PACKET_UUID;
            }
            LegacyDfuImpl.DFU_PACKET_UUID = uuid12;
            Parcelable parcelable4 = parcelableArrayExtra[3];
            if (parcelable4 != null) {
                uuid13 = ((ParcelUuid) parcelable4).getUuid();
            } else {
                uuid13 = LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
            }
            LegacyDfuImpl.DFU_VERSION_UUID = uuid13;
            LegacyButtonlessDfuImpl.DFU_SERVICE_UUID = LegacyDfuImpl.DFU_SERVICE_UUID;
            LegacyButtonlessDfuImpl.DFU_CONTROL_POINT_UUID = LegacyDfuImpl.DFU_CONTROL_POINT_UUID;
            LegacyButtonlessDfuImpl.DFU_VERSION_UUID = LegacyDfuImpl.DFU_VERSION_UUID;
        } else {
            UUID uuid14 = LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
            LegacyDfuImpl.DFU_SERVICE_UUID = uuid14;
            UUID uuid15 = LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
            LegacyDfuImpl.DFU_CONTROL_POINT_UUID = uuid15;
            LegacyDfuImpl.DFU_PACKET_UUID = LegacyDfuImpl.DEFAULT_DFU_PACKET_UUID;
            UUID uuid16 = LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
            LegacyDfuImpl.DFU_VERSION_UUID = uuid16;
            LegacyButtonlessDfuImpl.DFU_SERVICE_UUID = uuid14;
            LegacyButtonlessDfuImpl.DFU_CONTROL_POINT_UUID = uuid15;
            LegacyButtonlessDfuImpl.DFU_VERSION_UUID = uuid16;
        }
        Parcelable[] parcelableArrayExtra2 = intent.getParcelableArrayExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU);
        if (parcelableArrayExtra2 != null && parcelableArrayExtra2.length == 3) {
            Parcelable parcelable5 = parcelableArrayExtra2[0];
            if (parcelable5 != null) {
                uuid7 = ((ParcelUuid) parcelable5).getUuid();
            } else {
                uuid7 = SecureDfuImpl.DEFAULT_DFU_SERVICE_UUID;
            }
            SecureDfuImpl.DFU_SERVICE_UUID = uuid7;
            Parcelable parcelable6 = parcelableArrayExtra2[1];
            if (parcelable6 != null) {
                uuid8 = ((ParcelUuid) parcelable6).getUuid();
            } else {
                uuid8 = SecureDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
            }
            SecureDfuImpl.DFU_CONTROL_POINT_UUID = uuid8;
            Parcelable parcelable7 = parcelableArrayExtra2[2];
            if (parcelable7 != null) {
                uuid9 = ((ParcelUuid) parcelable7).getUuid();
            } else {
                uuid9 = SecureDfuImpl.DEFAULT_DFU_PACKET_UUID;
            }
            SecureDfuImpl.DFU_PACKET_UUID = uuid9;
        } else {
            SecureDfuImpl.DFU_SERVICE_UUID = SecureDfuImpl.DEFAULT_DFU_SERVICE_UUID;
            SecureDfuImpl.DFU_CONTROL_POINT_UUID = SecureDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
            SecureDfuImpl.DFU_PACKET_UUID = SecureDfuImpl.DEFAULT_DFU_PACKET_UUID;
        }
        Parcelable[] parcelableArrayExtra3 = intent.getParcelableArrayExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU);
        if (parcelableArrayExtra3 != null && parcelableArrayExtra3.length == 2) {
            Parcelable parcelable8 = parcelableArrayExtra3[0];
            if (parcelable8 != null) {
                uuid5 = ((ParcelUuid) parcelable8).getUuid();
            } else {
                uuid5 = ExperimentalButtonlessDfuImpl.DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID;
            }
            ExperimentalButtonlessDfuImpl.EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID = uuid5;
            Parcelable parcelable9 = parcelableArrayExtra3[1];
            if (parcelable9 != null) {
                uuid6 = ((ParcelUuid) parcelable9).getUuid();
            } else {
                uuid6 = ExperimentalButtonlessDfuImpl.DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_UUID;
            }
            ExperimentalButtonlessDfuImpl.EXPERIMENTAL_BUTTONLESS_DFU_UUID = uuid6;
        } else {
            ExperimentalButtonlessDfuImpl.EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID = ExperimentalButtonlessDfuImpl.DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_SERVICE_UUID;
            ExperimentalButtonlessDfuImpl.EXPERIMENTAL_BUTTONLESS_DFU_UUID = ExperimentalButtonlessDfuImpl.DEFAULT_EXPERIMENTAL_BUTTONLESS_DFU_UUID;
        }
        Parcelable[] parcelableArrayExtra4 = intent.getParcelableArrayExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING);
        if (parcelableArrayExtra4 != null && parcelableArrayExtra4.length == 2) {
            Parcelable parcelable10 = parcelableArrayExtra4[0];
            if (parcelable10 != null) {
                uuid3 = ((ParcelUuid) parcelable10).getUuid();
            } else {
                uuid3 = ButtonlessDfuWithoutBondSharingImpl.DEFAULT_BUTTONLESS_DFU_SERVICE_UUID;
            }
            ButtonlessDfuWithoutBondSharingImpl.BUTTONLESS_DFU_SERVICE_UUID = uuid3;
            Parcelable parcelable11 = parcelableArrayExtra4[1];
            if (parcelable11 != null) {
                uuid4 = ((ParcelUuid) parcelable11).getUuid();
            } else {
                uuid4 = ButtonlessDfuWithoutBondSharingImpl.DEFAULT_BUTTONLESS_DFU_UUID;
            }
            ButtonlessDfuWithoutBondSharingImpl.BUTTONLESS_DFU_UUID = uuid4;
        } else {
            ButtonlessDfuWithoutBondSharingImpl.BUTTONLESS_DFU_SERVICE_UUID = ButtonlessDfuWithoutBondSharingImpl.DEFAULT_BUTTONLESS_DFU_SERVICE_UUID;
            ButtonlessDfuWithoutBondSharingImpl.BUTTONLESS_DFU_UUID = ButtonlessDfuWithoutBondSharingImpl.DEFAULT_BUTTONLESS_DFU_UUID;
        }
        Parcelable[] parcelableArrayExtra5 = intent.getParcelableArrayExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING);
        if (parcelableArrayExtra5 != null && parcelableArrayExtra5.length == 2) {
            Parcelable parcelable12 = parcelableArrayExtra5[0];
            if (parcelable12 != null) {
                uuid = ((ParcelUuid) parcelable12).getUuid();
            } else {
                uuid = ButtonlessDfuWithBondSharingImpl.DEFAULT_BUTTONLESS_DFU_SERVICE_UUID;
            }
            ButtonlessDfuWithBondSharingImpl.BUTTONLESS_DFU_SERVICE_UUID = uuid;
            Parcelable parcelable13 = parcelableArrayExtra5[1];
            if (parcelable13 != null) {
                uuid2 = ((ParcelUuid) parcelable13).getUuid();
            } else {
                uuid2 = ButtonlessDfuWithBondSharingImpl.DEFAULT_BUTTONLESS_DFU_UUID;
            }
            ButtonlessDfuWithBondSharingImpl.BUTTONLESS_DFU_UUID = uuid2;
            return;
        }
        ButtonlessDfuWithBondSharingImpl.BUTTONLESS_DFU_SERVICE_UUID = ButtonlessDfuWithBondSharingImpl.DEFAULT_BUTTONLESS_DFU_SERVICE_UUID;
        ButtonlessDfuWithBondSharingImpl.BUTTONLESS_DFU_UUID = ButtonlessDfuWithBondSharingImpl.DEFAULT_BUTTONLESS_DFU_UUID;
    }
}
