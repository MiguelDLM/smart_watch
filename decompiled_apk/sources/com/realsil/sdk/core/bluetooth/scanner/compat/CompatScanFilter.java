package com.realsil.sdk.core.bluetooth.scanner.compat;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.Build;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.e.a;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes11.dex */
public final class CompatScanFilter implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f19504a;

    @Nullable
    public final String b;
    public final int c;

    @Nullable
    public final byte[] d;

    @Nullable
    public final ParcelUuid e;

    @Nullable
    public final ParcelUuid f;

    @Nullable
    public final ParcelUuid g;

    @Nullable
    public final ParcelUuid h;

    @Nullable
    public final ParcelUuid i;

    @Nullable
    public final byte[] j;

    @Nullable
    public final byte[] k;
    public final int l;

    @Nullable
    public final byte[] m;

    @Nullable
    public final byte[] n;
    public static final CompatScanFilter EMPTY = new Builder().build();

    @NonNull
    public static final Parcelable.Creator<CompatScanFilter> CREATOR = new Parcelable.Creator<CompatScanFilter>() { // from class: com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CompatScanFilter createFromParcel(Parcel parcel) {
            Builder builder = new Builder();
            if (parcel.readInt() == 1) {
                builder.setDeviceName(parcel.readString());
            }
            String readString = parcel.readInt() == 1 ? parcel.readString() : null;
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                builder.setServiceUuid(parcelUuid);
                if (parcel.readInt() == 1) {
                    builder.setServiceUuid(parcelUuid, (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader()));
                }
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid2 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                builder.setServiceSolicitationUuid(parcelUuid2);
                if (parcel.readInt() == 1) {
                    builder.setServiceSolicitationUuid(parcelUuid2, (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader()));
                }
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid3 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                if (parcel.readInt() == 1) {
                    byte[] bArr = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr);
                    if (parcel.readInt() == 0) {
                        builder.setServiceData(parcelUuid3, bArr);
                    } else {
                        byte[] bArr2 = new byte[parcel.readInt()];
                        parcel.readByteArray(bArr2);
                        builder.setServiceData(parcelUuid3, bArr, bArr2);
                    }
                }
            }
            int readInt = parcel.readInt();
            if (parcel.readInt() == 1) {
                byte[] bArr3 = new byte[parcel.readInt()];
                parcel.readByteArray(bArr3);
                if (parcel.readInt() == 0) {
                    builder.setManufacturerData(readInt, bArr3);
                } else {
                    byte[] bArr4 = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr4);
                    builder.setManufacturerData(readInt, bArr3, bArr4);
                }
            }
            if (readString != null) {
                int readInt2 = parcel.readInt();
                if (parcel.readInt() == 1) {
                    byte[] bArr5 = new byte[16];
                    parcel.readByteArray(bArr5);
                    builder.a(readString, readInt2, bArr5);
                } else {
                    builder.setDeviceAddress(readString, readInt2);
                }
            }
            return builder.build();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CompatScanFilter[] newArray(int i) {
            return new CompatScanFilter[i];
        }
    };

    public CompatScanFilter(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, ParcelUuid parcelUuid4, ParcelUuid parcelUuid5, byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, int i2, @Nullable byte[] bArr5) {
        this.f19504a = str;
        this.e = parcelUuid;
        this.f = parcelUuid2;
        this.g = parcelUuid3;
        this.h = parcelUuid4;
        this.b = str2;
        this.i = parcelUuid5;
        this.j = bArr;
        this.k = bArr2;
        this.l = i;
        this.m = bArr3;
        this.n = bArr4;
        this.c = i2;
        this.d = bArr5;
    }

    public static boolean matchesPartialData(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr3 == null || bArr3.length < bArr.length) {
            return false;
        }
        if (bArr2 == null) {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr3[i] != bArr[i]) {
                    return false;
                }
            }
            return true;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b = bArr2[i2];
            if ((bArr3[i2] & b) != (b & bArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public static boolean matchesServiceUuids(ParcelUuid parcelUuid, ParcelUuid parcelUuid2, List<ParcelUuid> list) {
        UUID uuid;
        if (parcelUuid == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        for (ParcelUuid parcelUuid3 : list) {
            if (parcelUuid2 == null) {
                uuid = null;
            } else {
                uuid = parcelUuid2.getUuid();
            }
            if (a.a(parcelUuid3.getUuid(), parcelUuid.getUuid(), uuid)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CompatScanFilter.class != obj.getClass()) {
            return false;
        }
        CompatScanFilter compatScanFilter = (CompatScanFilter) obj;
        if (Objects.equals(this.f19504a, compatScanFilter.f19504a) && Objects.equals(this.b, compatScanFilter.b) && this.l == compatScanFilter.l && Objects.deepEquals(this.m, compatScanFilter.m) && Objects.deepEquals(this.n, compatScanFilter.n) && Objects.equals(this.i, compatScanFilter.i) && Objects.deepEquals(this.j, compatScanFilter.j) && Objects.deepEquals(this.k, compatScanFilter.k) && Objects.equals(this.e, compatScanFilter.e) && Objects.equals(this.f, compatScanFilter.f) && Objects.equals(this.g, compatScanFilter.g) && Objects.equals(this.h, compatScanFilter.h)) {
            return true;
        }
        return false;
    }

    public int getAddressType() {
        return this.c;
    }

    @Nullable
    public String getDeviceAddress() {
        return this.b;
    }

    @Nullable
    public String getDeviceName() {
        return this.f19504a;
    }

    @Nullable
    public byte[] getIrk() {
        return this.d;
    }

    @Nullable
    public byte[] getManufacturerData() {
        return this.m;
    }

    @Nullable
    public byte[] getManufacturerDataMask() {
        return this.n;
    }

    public int getManufacturerId() {
        return this.l;
    }

    @Nullable
    public byte[] getServiceData() {
        return this.j;
    }

    @Nullable
    public byte[] getServiceDataMask() {
        return this.k;
    }

    @Nullable
    public ParcelUuid getServiceDataUuid() {
        return this.i;
    }

    @Nullable
    public ParcelUuid getServiceSolicitationUuid() {
        return this.g;
    }

    @Nullable
    public ParcelUuid getServiceSolicitationUuidMask() {
        return this.h;
    }

    @Nullable
    public ParcelUuid getServiceUuid() {
        return this.e;
    }

    @Nullable
    public ParcelUuid getServiceUuidMask() {
        return this.f;
    }

    public int hashCode() {
        return Objects.hash(this.f19504a, this.b, Integer.valueOf(this.l), Integer.valueOf(Arrays.hashCode(this.m)), Integer.valueOf(Arrays.hashCode(this.n)), this.i, Integer.valueOf(Arrays.hashCode(this.j)), Integer.valueOf(Arrays.hashCode(this.k)), this.e, this.f, this.g, this.h);
    }

    public boolean isAllFieldsEmpty() {
        return EMPTY.equals(this);
    }

    @RequiresApi(api = 21)
    public boolean matches(ScanResult scanResult) {
        boolean z;
        ParcelUuid parcelUuid;
        List<ParcelUuid> serviceSolicitationUuids;
        UUID uuid;
        if (scanResult == null) {
            return false;
        }
        BluetoothDevice device = scanResult.getDevice();
        String str = this.b;
        if (str != null && (device == null || !str.equals(device.getAddress()))) {
            return false;
        }
        ScanRecord scanRecord = scanResult.getScanRecord();
        String str2 = this.f19504a;
        if (str2 == null && this.e == null && this.m == null && this.j == null && this.g == null) {
            z = false;
        } else {
            z = true;
        }
        if (scanRecord == null) {
            return !z;
        }
        if (str2 != null && !str2.equals(scanRecord.getDeviceName())) {
            return false;
        }
        ParcelUuid parcelUuid2 = this.e;
        if (parcelUuid2 != null && !matchesServiceUuids(parcelUuid2, this.f, scanRecord.getServiceUuids())) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29 && (parcelUuid = this.g) != null) {
            ParcelUuid parcelUuid3 = this.h;
            serviceSolicitationUuids = scanRecord.getServiceSolicitationUuids();
            if (serviceSolicitationUuids != null) {
                for (ParcelUuid parcelUuid4 : serviceSolicitationUuids) {
                    if (parcelUuid3 == null) {
                        uuid = null;
                    } else {
                        uuid = parcelUuid3.getUuid();
                    }
                    if (a.a(parcelUuid4.getUuid(), parcelUuid.getUuid(), uuid)) {
                    }
                }
            }
            return false;
        }
        ParcelUuid parcelUuid5 = this.i;
        if (parcelUuid5 != null && !matchesPartialData(this.j, this.k, scanRecord.getServiceData(parcelUuid5))) {
            return false;
        }
        int i = this.l;
        if (i >= 0 && !matchesPartialData(this.m, this.n, scanRecord.getManufacturerSpecificData(i))) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder a2 = com.realsil.sdk.core.a.a.a("BluetoothLeScanFilter [mDeviceName=");
        a2.append(this.f19504a);
        a2.append(", mDeviceAddress=");
        a2.append(BluetoothHelper.formatAddress(this.b, true));
        a2.append(", mUuid=");
        a2.append(this.e);
        a2.append(", mUuidMask=");
        a2.append(this.f);
        a2.append(", mServiceSolicitationUuid=");
        a2.append(this.g);
        a2.append(", mServiceSolicitationUuidMask=");
        a2.append(this.h);
        a2.append(", mServiceDataUuid=");
        a2.append(Objects.toString(this.i));
        a2.append(", mServiceData=");
        a2.append(Arrays.toString(this.j));
        a2.append(", mServiceDataMask=");
        a2.append(Arrays.toString(this.k));
        a2.append(", mManufacturerId=");
        a2.append(this.l);
        a2.append(", mManufacturerData=");
        a2.append(Arrays.toString(this.m));
        a2.append(", mManufacturerDataMask=");
        a2.append(Arrays.toString(this.n));
        a2.append("]");
        return a2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13 = 1;
        if (this.f19504a == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        parcel.writeInt(i2);
        String str = this.f19504a;
        if (str != null) {
            parcel.writeString(str);
        }
        if (this.b == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        parcel.writeInt(i3);
        String str2 = this.b;
        if (str2 != null) {
            parcel.writeString(str2);
        }
        if (this.e == null) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        parcel.writeInt(i4);
        ParcelUuid parcelUuid = this.e;
        if (parcelUuid != null) {
            parcel.writeParcelable(parcelUuid, i);
            if (this.f == null) {
                i12 = 0;
            } else {
                i12 = 1;
            }
            parcel.writeInt(i12);
            ParcelUuid parcelUuid2 = this.f;
            if (parcelUuid2 != null) {
                parcel.writeParcelable(parcelUuid2, i);
            }
        }
        if (this.g == null) {
            i5 = 0;
        } else {
            i5 = 1;
        }
        parcel.writeInt(i5);
        ParcelUuid parcelUuid3 = this.g;
        if (parcelUuid3 != null) {
            parcel.writeParcelable(parcelUuid3, i);
            if (this.h == null) {
                i11 = 0;
            } else {
                i11 = 1;
            }
            parcel.writeInt(i11);
            ParcelUuid parcelUuid4 = this.h;
            if (parcelUuid4 != null) {
                parcel.writeParcelable(parcelUuid4, i);
            }
        }
        if (this.i == null) {
            i6 = 0;
        } else {
            i6 = 1;
        }
        parcel.writeInt(i6);
        ParcelUuid parcelUuid5 = this.i;
        if (parcelUuid5 != null) {
            parcel.writeParcelable(parcelUuid5, i);
            if (this.j == null) {
                i9 = 0;
            } else {
                i9 = 1;
            }
            parcel.writeInt(i9);
            byte[] bArr = this.j;
            if (bArr != null) {
                parcel.writeInt(bArr.length);
                parcel.writeByteArray(this.j);
                if (this.k == null) {
                    i10 = 0;
                } else {
                    i10 = 1;
                }
                parcel.writeInt(i10);
                byte[] bArr2 = this.k;
                if (bArr2 != null) {
                    parcel.writeInt(bArr2.length);
                    parcel.writeByteArray(this.k);
                }
            }
        }
        parcel.writeInt(this.l);
        if (this.m == null) {
            i7 = 0;
        } else {
            i7 = 1;
        }
        parcel.writeInt(i7);
        byte[] bArr3 = this.m;
        if (bArr3 != null) {
            parcel.writeInt(bArr3.length);
            parcel.writeByteArray(this.m);
            if (this.n == null) {
                i8 = 0;
            } else {
                i8 = 1;
            }
            parcel.writeInt(i8);
            byte[] bArr4 = this.n;
            if (bArr4 != null) {
                parcel.writeInt(bArr4.length);
                parcel.writeByteArray(this.n);
            }
        }
        if (this.b != null) {
            parcel.writeInt(this.c);
            if (this.d == null) {
                i13 = 0;
            }
            parcel.writeInt(i13);
            byte[] bArr5 = this.d;
            if (bArr5 != null) {
                parcel.writeByteArray(bArr5);
            }
        }
    }

    /* loaded from: classes11.dex */
    public static final class Builder {
        public static final int LEN_IRK_OCTETS = 16;

        /* renamed from: a, reason: collision with root package name */
        public String f19505a;
        public String b;
        public byte[] d;
        public ParcelUuid e;
        public ParcelUuid f;
        public ParcelUuid g;
        public ParcelUuid h;
        public ParcelUuid i;
        public byte[] j;
        public byte[] k;
        public byte[] m;
        public byte[] n;
        public int c = 0;
        public int l = -1;

        @NonNull
        public final Builder a(@NonNull String str, int i, @Nullable byte[] bArr) {
            if (BluetoothAdapter.checkBluetoothAddress(str)) {
                if (i >= 0 && i <= 1) {
                    if (i == 1 && bArr != null && !com.realsil.sdk.core.b.a.a(str)) {
                        throw new IllegalArgumentException("Invalid combination: IRK requires either a PUBLIC or RANDOM (STATIC) Address");
                    }
                    this.b = str;
                    this.c = i;
                    this.d = bArr;
                    return this;
                }
                throw new IllegalArgumentException("'addressType' is invalid!");
            }
            throw new IllegalArgumentException("invalid device address " + str);
        }

        public CompatScanFilter build() {
            return new CompatScanFilter(this.f19505a, this.b, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.c, this.d);
        }

        public Builder setDeviceAddress(String str) {
            if (str == null) {
                this.b = str;
                return this;
            }
            return setDeviceAddress(str, 0);
        }

        public Builder setDeviceName(String str) {
            this.f19505a = str;
            return this;
        }

        public Builder setManufacturerData(int i, byte[] bArr) {
            if (bArr != null && i < 0) {
                throw new IllegalArgumentException("invalid manufacture id");
            }
            this.l = i;
            this.m = bArr;
            this.n = null;
            return this;
        }

        public Builder setServiceData(ParcelUuid parcelUuid, byte[] bArr) {
            if (parcelUuid != null) {
                this.i = parcelUuid;
                this.j = bArr;
                this.k = null;
                return this;
            }
            throw new IllegalArgumentException("serviceDataUuid is null");
        }

        @NonNull
        public Builder setServiceSolicitationUuid(@Nullable ParcelUuid parcelUuid) {
            this.g = parcelUuid;
            if (parcelUuid == null) {
                this.h = null;
            }
            return this;
        }

        public Builder setServiceUuid(ParcelUuid parcelUuid) {
            this.e = parcelUuid;
            this.f = null;
            return this;
        }

        @NonNull
        public Builder setDeviceAddress(@NonNull String str, int i) {
            return a(str, i, null);
        }

        @NonNull
        public Builder setServiceSolicitationUuid(@Nullable ParcelUuid parcelUuid, @Nullable ParcelUuid parcelUuid2) {
            if (parcelUuid2 != null && parcelUuid == null) {
                throw new IllegalArgumentException("SolicitationUuid is null while SolicitationUuidMask is not null!");
            }
            this.g = parcelUuid;
            this.h = parcelUuid2;
            return this;
        }

        public Builder setServiceUuid(ParcelUuid parcelUuid, ParcelUuid parcelUuid2) {
            if (this.f != null && this.e == null) {
                throw new IllegalArgumentException("uuid is null while uuidMask is not null!");
            }
            this.e = parcelUuid;
            this.f = parcelUuid2;
            return this;
        }

        public Builder setManufacturerData(int i, byte[] bArr, byte[] bArr2) {
            if (bArr != null && i < 0) {
                throw new IllegalArgumentException("invalid manufacture id");
            }
            byte[] bArr3 = this.n;
            if (bArr3 != null) {
                byte[] bArr4 = this.m;
                if (bArr4 != null) {
                    if (bArr4.length != bArr3.length) {
                        throw new IllegalArgumentException("size mismatch for manufacturerData and manufacturerDataMask");
                    }
                } else {
                    throw new IllegalArgumentException("manufacturerData is null while manufacturerDataMask is not null");
                }
            }
            this.l = i;
            this.m = bArr;
            this.n = bArr2;
            return this;
        }

        public Builder setServiceData(ParcelUuid parcelUuid, byte[] bArr, byte[] bArr2) {
            if (parcelUuid != null) {
                byte[] bArr3 = this.k;
                if (bArr3 != null) {
                    byte[] bArr4 = this.j;
                    if (bArr4 != null) {
                        if (bArr4.length != bArr3.length) {
                            throw new IllegalArgumentException("size mismatch for service data and service data mask");
                        }
                    } else {
                        throw new IllegalArgumentException("serviceData is null while serviceDataMask is not null");
                    }
                }
                this.i = parcelUuid;
                this.j = bArr;
                this.k = bArr2;
                return this;
            }
            throw new IllegalArgumentException("serviceDataUuid is null");
        }
    }
}
