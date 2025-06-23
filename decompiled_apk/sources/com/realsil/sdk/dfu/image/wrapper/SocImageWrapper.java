package com.realsil.sdk.dfu.image.wrapper;

import android.os.Parcel;
import android.os.Parcelable;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.b.e;
import com.realsil.sdk.dfu.h.a;
import com.realsil.sdk.dfu.image.BinIndicator;
import com.realsil.sdk.dfu.model.DeviceInfo;
import com.realsil.sdk.dfu.model.ImageVersionInfo;
import java.util.Locale;

/* loaded from: classes11.dex */
public final class SocImageWrapper extends a implements Parcelable {
    public static final Parcelable.Creator<SocImageWrapper> CREATOR = new Parcelable.Creator<SocImageWrapper>() { // from class: com.realsil.sdk.dfu.image.wrapper.SocImageWrapper.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SocImageWrapper createFromParcel(Parcel parcel) {
            return new SocImageWrapper(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SocImageWrapper[] newArray(int i) {
            return new SocImageWrapper[i];
        }
    };
    public static boolean VDBG = false;

    /* renamed from: a, reason: collision with root package name */
    public int f19547a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public String p;
    public String q;
    public String r;

    /* loaded from: classes11.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public int f19548a;
        public int b;
        public int c;
        public int e;
        public int f;
        public DeviceInfo h;
        public int i;
        public int j;
        public int d = -1;
        public int g = 15;
        public String k = "";

        public SocImageWrapper build() {
            DeviceInfo deviceInfo = this.h;
            if (deviceInfo != null) {
                this.f19548a = deviceInfo.getProtocolType();
                DeviceInfo deviceInfo2 = this.h;
                this.b = deviceInfo2.specVersion;
                this.c = deviceInfo2.icType;
                this.g = deviceInfo2.getActiveBank();
            }
            return new SocImageWrapper(this.f19548a, this.b, this.c, this.d, this.e, this.f, this.g, this.i, this.j, this.k);
        }

        public Builder imageFeature(String str) {
            this.k = str;
            return this;
        }

        public Builder imageVersionInfo(ImageVersionInfo imageVersionInfo) {
            this.f = imageVersionInfo.getImageId();
            this.d = imageVersionInfo.getVersion();
            this.e = imageVersionInfo.getBitNumber();
            this.i = imageVersionInfo.getIndication();
            this.j = imageVersionInfo.getSectionSize();
            return this;
        }

        public Builder setBankIndicator(int i) {
            this.g = i;
            return this;
        }

        public Builder setBitNumber(int i) {
            this.e = i;
            return this;
        }

        public Builder setDeviceInfo(DeviceInfo deviceInfo) {
            this.h = deviceInfo;
            return this;
        }

        public Builder setIcType(int i) {
            this.c = i;
            return this;
        }

        public Builder setImageId(int i) {
            this.f = i;
            return this;
        }

        public Builder setImageVersion(int i) {
            this.d = i;
            return this;
        }

        public Builder setProtocolType(int i) {
            this.f19548a = i;
            return this;
        }

        public Builder setSpecVersion(int i) {
            this.b = i;
            return this;
        }
    }

    public static int getImageVersionFormatWithBitNumber(int i, int i2) {
        if (i <= 3) {
            return 7;
        }
        if (i != 5 && i != 9 && i != 12) {
            switch (i2) {
                case 0:
                case 1:
                case 2:
                case 9:
                    break;
                case 3:
                case 4:
                    return 3;
                case 5:
                    return 5;
                case 6:
                case 7:
                    return 515;
                case 8:
                    return 514;
                default:
                    return 1;
            }
        } else if (i2 != 2) {
            return 3;
        }
        return 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x001a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005b A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getImageVersionFormatWithImageId(int r3, int r4, int r5, int r6, boolean r7) {
        /*
            r0 = 3
            if (r3 > r0) goto L6
            r0 = 7
            goto L5e
        L6:
            r1 = 5
            if (r3 == r1) goto L5d
            r2 = 9
            if (r3 == r2) goto L5d
            r2 = 12
            if (r3 != r2) goto L12
            goto L5d
        L12:
            r2 = 10145(0x27a1, float:1.4216E-41)
            if (r6 == r2) goto L5e
            r2 = 10148(0x27a4, float:1.422E-41)
            if (r6 == r2) goto L5d
            switch(r6) {
                case 10128: goto L3d;
                case 10129: goto L5e;
                case 10130: goto L5e;
                case 10131: goto L3b;
                case 10132: goto L38;
                case 10133: goto L38;
                case 10134: goto L5d;
                case 10135: goto L21;
                default: goto L1d;
            }
        L1d:
            switch(r6) {
                case 10140: goto L5e;
                case 10141: goto L5e;
                case 10142: goto L5e;
                default: goto L20;
            }
        L20:
            goto L5b
        L21:
            r4 = 11
            if (r3 == r4) goto L35
            r4 = 13
            if (r3 == r4) goto L35
            r4 = 10
            if (r3 == r4) goto L35
            r4 = 14
            if (r3 != r4) goto L32
            goto L35
        L32:
            r0 = 514(0x202, float:7.2E-43)
            goto L5e
        L35:
            r0 = 516(0x204, float:7.23E-43)
            goto L5e
        L38:
            r0 = 515(0x203, float:7.22E-43)
            goto L5e
        L3b:
            r0 = 5
            goto L5e
        L3d:
            r3 = 20
            if (r4 == r3) goto L59
            r3 = 21
            if (r4 != r3) goto L46
            goto L59
        L46:
            r3 = 16
            if (r4 != r3) goto L4f
            if (r5 < r0) goto L5d
            if (r7 == 0) goto L5d
            goto L5b
        L4f:
            r3 = 17
            if (r4 != r3) goto L5d
            r3 = 6
            if (r5 < r3) goto L5d
            if (r7 == 0) goto L5d
            goto L5b
        L59:
            if (r7 == 0) goto L5d
        L5b:
            r0 = 1
            goto L5e
        L5d:
            r0 = 2
        L5e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.image.wrapper.SocImageWrapper.getImageVersionFormatWithImageId(int, int, int, int, boolean):int");
    }

    public final void a() {
        int i = this.f19547a;
        if (i != 20 && i != 21) {
            b();
        } else {
            c();
        }
    }

    public final void b() {
        int i = this.k;
        if (i == 1) {
            if (this.b <= 0) {
                int i2 = this.d;
                this.l = i2;
                this.m = 0;
                this.n = 0;
                this.o = 0;
                this.p = String.valueOf(i2);
            } else {
                int i3 = this.d;
                int i4 = i3 & 255;
                this.l = i4;
                this.m = (i3 >> 8) & 255;
                this.n = (i3 >> 16) & 255;
                this.o = (i3 >> 24) & 255;
                this.p = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i4), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o));
            }
        } else if (i == 2) {
            if (this.b <= 0) {
                int i5 = this.d;
                this.l = i5;
                this.m = 0;
                this.n = 0;
                this.o = 0;
                this.p = String.valueOf(i5);
            } else {
                int i6 = this.d;
                int i7 = (i6 >> 24) & 255;
                this.l = i7;
                this.m = (i6 >> 16) & 255;
                this.n = (i6 >> 8) & 255;
                this.o = i6 & 255;
                this.p = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i7), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o));
            }
        } else if (i == 3) {
            if (this.b <= 0) {
                int i8 = this.d;
                this.l = i8;
                this.m = 0;
                this.n = 0;
                this.o = 0;
                this.p = String.valueOf(i8);
            } else {
                int i9 = this.d;
                int i10 = i9 & 15;
                this.l = i10;
                this.m = (i9 >> 4) & 255;
                this.n = (i9 >> 12) & 32767;
                this.o = (i9 >> 27) & 31;
                this.p = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i10), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o));
            }
        } else if (i == 5) {
            if (this.b <= 0) {
                int i11 = this.d;
                this.l = i11;
                this.m = 0;
                this.n = 0;
                this.o = 0;
                this.p = String.valueOf(i11);
            } else {
                int i12 = this.d;
                int i13 = i12 & 15;
                this.l = i13;
                this.m = (i12 >> 4) & 255;
                this.n = (i12 >> 12) & 511;
                this.o = (i12 >> 21) & 2047;
                this.p = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i13), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o));
            }
        } else if (i == 515) {
            if (this.b <= 0) {
                int i14 = this.d;
                this.l = i14;
                this.m = 0;
                this.n = 0;
                this.o = 0;
                this.p = String.valueOf(i14);
            } else {
                int i15 = this.d;
                int i16 = (i15 >> 24) & 255;
                this.l = i16;
                this.m = (i15 >> 16) & 255;
                this.n = (i15 >> 8) & 255;
                this.o = i15 & 255;
                this.p = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i16), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o));
            }
        } else if (i == 4) {
            int i17 = this.d;
            this.l = i17;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = String.valueOf(i17);
        } else if (i == 7) {
            int i18 = this.d;
            this.l = i18;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = String.valueOf(i18);
        } else if (i == 514) {
            if (this.b <= 0) {
                int i19 = this.d;
                this.l = i19;
                this.m = 0;
                this.n = 0;
                this.o = 0;
                this.p = String.valueOf(i19);
            } else {
                int i20 = this.d;
                int i21 = (i20 >> 8) & 255;
                this.l = i21;
                this.m = i20 & 255;
                this.n = (i20 >> 24) & 255;
                this.o = (i20 >> 16) & 255;
                this.p = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i21), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o));
            }
        } else if (i == 516) {
            int i22 = this.d;
            int i23 = (i22 >> 24) & 255;
            this.l = i23;
            this.m = (i22 >> 16) & 255;
            this.n = (i22 >> 8) & 255;
            this.o = i22 & 255;
            this.p = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i23), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o));
        } else {
            int i24 = this.d;
            this.l = i24;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = String.valueOf(i24);
        }
        if (this.d == -1) {
            this.p = "";
        }
    }

    public final void c() {
        int i = this.k;
        if (i == 1) {
            int i2 = this.d;
            int i3 = i2 & 255;
            this.l = i3;
            this.m = (i2 >> 8) & 255;
            this.n = (i2 >> 16) & 255;
            this.o = (i2 >> 24) & 255;
            this.p = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i3), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o));
        } else if (i == 2) {
            int i4 = this.d;
            int i5 = (i4 >> 24) & 255;
            this.l = i5;
            this.m = (i4 >> 16) & 255;
            this.n = (i4 >> 8) & 255;
            this.o = i4 & 255;
            this.p = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i5), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o));
        } else if (i == 3) {
            int i6 = this.d;
            int i7 = i6 & 15;
            this.l = i7;
            this.m = (i6 >> 4) & 255;
            this.n = (i6 >> 12) & 32767;
            this.o = (i6 >> 27) & 31;
            this.p = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i7), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o));
        } else if (i == 5) {
            int i8 = this.d;
            int i9 = i8 & 15;
            this.l = i9;
            this.m = (i8 >> 4) & 255;
            this.n = (i8 >> 12) & 511;
            this.o = (i8 >> 21) & 2047;
            this.p = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i9), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o));
        } else if (i == 515) {
            int i10 = this.d;
            int i11 = (i10 >> 24) & 255;
            this.l = i11;
            this.m = (i10 >> 16) & 255;
            this.n = (i10 >> 8) & 255;
            this.o = i10 & 255;
            this.p = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i11), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o));
        } else if (i == 4) {
            int i12 = this.d;
            this.l = i12;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = String.valueOf(i12);
        } else if (i == 7) {
            int i13 = this.d;
            this.l = i13;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = String.valueOf(i13);
        } else if (i == 514) {
            int i14 = this.d;
            int i15 = (i14 >> 8) & 255;
            this.l = i15;
            this.m = i14 & 255;
            this.n = (i14 >> 24) & 255;
            this.o = (i14 >> 16) & 255;
            this.p = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i15), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o));
        } else if (i == 516) {
            int i16 = this.d;
            int i17 = (i16 >> 24) & 255;
            this.l = i17;
            this.m = (i16 >> 16) & 255;
            this.n = (i16 >> 8) & 255;
            this.o = i16 & 255;
            this.p = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i17), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o));
        } else {
            int i18 = this.d;
            this.l = i18;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = String.valueOf(i18);
        }
        if (this.d == -1) {
            this.p = "";
        }
    }

    public int compare(SocImageWrapper socImageWrapper) {
        if (this.l > socImageWrapper.getMajor()) {
            return 1;
        }
        if (this.l == socImageWrapper.getMajor()) {
            if (this.m > socImageWrapper.getMinor()) {
                return 1;
            }
            if (this.m == socImageWrapper.getMinor()) {
                if (this.n > socImageWrapper.getRevision()) {
                    return 1;
                }
                if (this.n == socImageWrapper.getRevision()) {
                    if (this.o > socImageWrapper.getBuildnum()) {
                        return 1;
                    }
                    if (this.o == socImageWrapper.getBuildnum()) {
                        return 0;
                    }
                }
            }
        }
        return -1;
    }

    public final void d() {
        BinIndicator binIndicatorByBitNumber;
        boolean z = true;
        if (VDBG) {
            ZLogger.v(String.format("protocolType=%04X,specVersion=%02X, icType=%02X", Integer.valueOf(this.f19547a), Integer.valueOf(this.b), Integer.valueOf(this.c)));
        }
        int i = this.c;
        if (i == 14) {
            BinIndicator b = e.b(this.f);
            if (b != null) {
                this.k = b.versionFormat;
                this.q = b.flashLayoutName;
            } else {
                ZLogger.w(String.format("icType=0x%02X, imageId=0x%04X not supported", Integer.valueOf(this.c), Integer.valueOf(this.f)));
            }
        } else {
            int i2 = this.f19547a;
            if (i2 == 20) {
                int i3 = this.b;
                int i4 = this.f;
                if (this.g == 15) {
                    z = false;
                }
                this.k = getImageVersionFormatWithImageId(i, i2, i3, i4, z);
                binIndicatorByBitNumber = BinIndicator.getBinIndicatorByImageId(this.c, this.f, this.e);
            } else if (i2 == 16) {
                int i5 = this.b;
                if (i5 >= 3) {
                    int i6 = this.f;
                    if (this.g == 15) {
                        z = false;
                    }
                    this.k = getImageVersionFormatWithImageId(i, i2, i5, i6, z);
                    binIndicatorByBitNumber = BinIndicator.getBinIndicatorByImageId(this.c, this.f, this.e);
                } else {
                    this.k = getImageVersionFormatWithBitNumber(i, this.e);
                    binIndicatorByBitNumber = BinIndicator.getBinIndicatorByBitNumber(this.c, this.e);
                }
            } else if (i2 == 17) {
                int i7 = this.b;
                if (i7 >= 6) {
                    int i8 = this.f;
                    if (this.g == 15) {
                        z = false;
                    }
                    this.k = getImageVersionFormatWithImageId(i, i2, i7, i8, z);
                    binIndicatorByBitNumber = BinIndicator.getBinIndicatorByImageId(this.c, this.f, this.e);
                } else {
                    this.k = getImageVersionFormatWithBitNumber(i, this.e);
                    binIndicatorByBitNumber = BinIndicator.getBinIndicatorByBitNumber(this.c, this.e);
                }
            } else {
                this.k = getImageVersionFormatWithBitNumber(i, this.e);
                binIndicatorByBitNumber = BinIndicator.getBinIndicatorByBitNumber(this.c, this.e);
            }
            if (binIndicatorByBitNumber != null) {
                this.q = binIndicatorByBitNumber.flashLayoutName;
            }
        }
        if (-1 == this.d) {
            this.g = 0;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = "";
            return;
        }
        a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBankIndicator() {
        return this.g;
    }

    public int getBitNumber() {
        return this.e;
    }

    public int getBuildnum() {
        return this.o;
    }

    public String getFlashLayoutName() {
        return this.q;
    }

    public int getFormat() {
        return this.k;
    }

    public String getFormatedVersion() {
        return getFormattedVersion();
    }

    public String getFormattedVersion() {
        return this.p;
    }

    public int getIcType() {
        return this.c;
    }

    public String getImageFeature() {
        return this.r;
    }

    public int getImageId() {
        return this.f;
    }

    public int getImageVersion() {
        return this.d;
    }

    public int getIndication() {
        return this.h;
    }

    public int getMajor() {
        return this.l;
    }

    public int getMinor() {
        return this.m;
    }

    public int getProtocolType() {
        return this.f19547a;
    }

    public int getRevision() {
        return this.n;
    }

    public int getSectionSize() {
        return this.i;
    }

    public int getSpecVersion() {
        return this.b;
    }

    public String toString() {
        return String.format(Locale.US, "0x%04X(%s-%s), I%02XPT%04XSV%02X, imageVersion=[%08X], format=[%d]\nformatedVersion=(%d.%d.%d.%d)->[%s]", Integer.valueOf(this.f), this.q, this.r, Integer.valueOf(this.c), Integer.valueOf(this.f19547a), Integer.valueOf(this.b), Integer.valueOf(this.d), Integer.valueOf(this.k), Integer.valueOf(this.l), Integer.valueOf(this.m), Integer.valueOf(this.n), Integer.valueOf(this.o), this.p);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f19547a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
    }

    public SocImageWrapper(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str) {
        this.p = "";
        this.q = "";
        this.f19547a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = i8;
        this.i = i9;
        this.r = str;
        d();
    }

    public SocImageWrapper(Parcel parcel) {
        this.g = 15;
        this.p = "";
        this.q = "";
        this.r = "";
        this.f19547a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = parcel.readInt();
        this.o = parcel.readInt();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
    }
}
