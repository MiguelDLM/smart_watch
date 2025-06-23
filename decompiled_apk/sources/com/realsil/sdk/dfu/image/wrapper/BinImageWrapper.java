package com.realsil.sdk.dfu.image.wrapper;

import android.os.Parcel;
import android.os.Parcelable;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.b.e;
import com.realsil.sdk.dfu.h.a;
import com.realsil.sdk.dfu.image.BinIndicator;
import com.realsil.sdk.dfu.utils.DfuUtils;
import java.util.Locale;

/* loaded from: classes11.dex */
public final class BinImageWrapper extends a implements Parcelable {
    public static final Parcelable.Creator<BinImageWrapper> CREATOR = new Parcelable.Creator<BinImageWrapper>() { // from class: com.realsil.sdk.dfu.image.wrapper.BinImageWrapper.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BinImageWrapper createFromParcel(Parcel parcel) {
            return new BinImageWrapper(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BinImageWrapper[] newArray(int i) {
            return new BinImageWrapper[i];
        }
    };
    public static final int OTA_VERSION_BASE = 0;
    public static final int OTA_VERSION_V1 = 1;

    /* renamed from: a, reason: collision with root package name */
    public int f19545a;
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
    public String m;
    public String n;
    public String o;

    /* loaded from: classes11.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public int f19546a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g = 0;
        public String h = "";

        public Builder binId(int i) {
            this.e = i;
            return this;
        }

        public Builder bitNumber(int i) {
            this.d = i;
            return this;
        }

        public BinImageWrapper build() {
            return new BinImageWrapper(this.f19546a, this.b, this.d, this.e, this.c, this.f, this.g, this.h);
        }

        public Builder icType(int i) {
            this.b = i;
            return this;
        }

        public Builder imageFeature(String str) {
            this.h = str;
            return this;
        }

        public Builder imageVersion(int i) {
            return imageVersion(i, 0);
        }

        public Builder setOtaVersion(int i) {
            this.f19546a = i;
            return this;
        }

        public Builder imageVersion(int i, int i2) {
            this.c = i;
            this.g = i2;
            return this;
        }

        public Builder imageVersion(int i, int i2, int i3) {
            this.c = i;
            this.g = 3;
            this.f = i3;
            return this;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x004c, code lost:
    
        if (r8 == 2048) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getImageVersionFormatWithBinId(int r7, int r8, int r9) {
        /*
            r0 = 1
            r1 = 2
            r2 = 3
            if (r7 > r2) goto L7
            r9 = 7
            goto L52
        L7:
            r3 = 1792(0x700, float:2.511E-42)
            r4 = 768(0x300, float:1.076E-42)
            r5 = 5
            if (r7 == r5) goto L42
            r6 = 9
            if (r7 == r6) goto L42
            r6 = 12
            if (r7 != r6) goto L17
            goto L42
        L17:
            r6 = 520(0x208, float:7.29E-43)
            if (r8 == r6) goto L40
            if (r8 == r4) goto L3e
            r4 = 1024(0x400, float:1.435E-42)
            if (r8 == r4) goto L40
            r4 = 1040(0x410, float:1.457E-42)
            if (r8 == r4) goto L36
            r9 = 1280(0x500, float:1.794E-42)
            if (r8 == r9) goto L33
            r9 = 1538(0x602, float:2.155E-42)
            if (r8 == r9) goto L33
            if (r8 == r3) goto L51
            switch(r8) {
                case 512: goto L51;
                case 513: goto L51;
                case 514: goto L51;
                case 515: goto L51;
                default: goto L32;
            }
        L32:
            goto L4f
        L33:
            r9 = 515(0x203, float:7.22E-43)
            goto L52
        L36:
            if (r9 != r1) goto L3b
            r9 = 516(0x204, float:7.23E-43)
            goto L52
        L3b:
            r9 = 514(0x202, float:7.2E-43)
            goto L52
        L3e:
            r9 = 5
            goto L52
        L40:
            r9 = 2
            goto L52
        L42:
            r9 = 512(0x200, float:7.17E-43)
            if (r8 == r9) goto L51
            if (r8 == r4) goto L51
            if (r8 == r3) goto L51
            r9 = 2048(0x800, float:2.87E-42)
            if (r8 == r9) goto L4f
            goto L51
        L4f:
            r9 = 1
            goto L52
        L51:
            r9 = 3
        L52:
            java.util.Locale r3 = java.util.Locale.US
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r5 = 0
            r2[r5] = r7
            r2[r0] = r8
            r2[r1] = r4
            java.lang.String r7 = "icType=0x%02X, binId=0x%04X, format=%d"
            java.lang.String r7 = java.lang.String.format(r3, r7, r2)
            com.realsil.sdk.core.logger.ZLogger.v(r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realsil.sdk.dfu.image.wrapper.BinImageWrapper.getImageVersionFormatWithBinId(int, int, int):int");
    }

    public final void a() {
        int i = this.g;
        if (i == 1) {
            if (this.f19545a <= 0) {
                int i2 = this.e;
                this.h = i2;
                this.i = 0;
                this.j = 0;
                this.k = 0;
                this.m = String.valueOf(i2);
            } else {
                int i3 = this.e;
                int i4 = i3 & 255;
                this.h = i4;
                this.i = (i3 >> 8) & 255;
                this.j = (i3 >> 16) & 255;
                this.k = (i3 >> 24) & 255;
                this.m = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i4), Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k));
            }
        } else if (i == 2) {
            if (this.f19545a <= 0) {
                int i5 = this.e;
                this.h = i5;
                this.i = 0;
                this.j = 0;
                this.k = 0;
                this.m = String.valueOf(i5);
            } else {
                int i6 = this.e;
                int i7 = (i6 >> 24) & 255;
                this.h = i7;
                this.i = (i6 >> 16) & 255;
                this.j = (i6 >> 8) & 255;
                this.k = i6 & 255;
                this.m = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i7), Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k));
            }
        } else if (i == 3) {
            if (this.f19545a <= 0) {
                int i8 = this.e;
                this.h = i8;
                this.i = 0;
                this.j = 0;
                this.k = 0;
                this.m = String.valueOf(i8);
            } else {
                int i9 = this.e;
                int i10 = i9 & 15;
                this.h = i10;
                this.i = (i9 >> 4) & 255;
                this.j = (i9 >> 12) & 32767;
                this.k = (i9 >> 27) & 31;
                this.m = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i10), Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k));
            }
        } else if (i == 5) {
            if (this.f19545a <= 0) {
                int i11 = this.e;
                this.h = i11;
                this.i = 0;
                this.j = 0;
                this.k = 0;
                this.m = String.valueOf(i11);
            } else {
                int i12 = this.e;
                int i13 = i12 & 15;
                this.h = i13;
                this.i = (i12 >> 4) & 255;
                this.j = (i12 >> 12) & 511;
                this.k = (i12 >> 21) & 2047;
                this.m = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i13), Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k));
            }
        } else if (i == 515) {
            if (this.f19545a <= 0) {
                int i14 = this.e;
                this.h = i14;
                this.i = 0;
                this.j = 0;
                this.k = 0;
                this.m = String.valueOf(i14);
            } else {
                int i15 = this.e;
                int i16 = (i15 >> 24) & 255;
                this.h = i16;
                this.i = (i15 >> 16) & 255;
                this.j = (i15 >> 8) & 255;
                this.k = i15 & 255;
                this.m = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i16), Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k));
            }
        } else if (i == 4) {
            int i17 = this.e;
            this.h = i17;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.m = String.valueOf(i17);
        } else if (i == 7) {
            int i18 = this.e;
            this.h = i18;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.m = String.valueOf(i18);
        } else if (i == 514) {
            if (this.f19545a <= 0) {
                int i19 = this.e;
                this.h = i19;
                this.i = 0;
                this.j = 0;
                this.k = 0;
                this.m = String.valueOf(i19);
            } else {
                int i20 = this.e;
                int i21 = (i20 >> 8) & 255;
                this.h = i21;
                this.i = i20 & 255;
                this.j = (i20 >> 24) & 255;
                this.k = (i20 >> 16) & 255;
                this.m = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i21), Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k));
            }
        } else if (i == 516) {
            int i22 = this.e;
            int i23 = (i22 >> 24) & 255;
            this.h = i23;
            this.i = (i22 >> 16) & 255;
            this.j = (i22 >> 8) & 255;
            this.k = i22 & 255;
            this.m = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i23), Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k));
        } else {
            int i24 = this.e;
            this.h = i24;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.m = String.valueOf(i24);
        }
        if (this.e == -1) {
            this.m = "";
        }
    }

    public final void b() {
        BinIndicator binIndicator;
        int i = this.b;
        if (i == 14) {
            BinIndicator a2 = e.a(this.d);
            if (a2 != null) {
                this.g = a2.versionFormat;
                this.n = a2.flashLayoutName;
            } else {
                ZLogger.w(String.format("icType=0x%02X, binId=0x%04X not supported", Integer.valueOf(this.b), Integer.valueOf(this.d)));
            }
        } else {
            int i2 = this.f;
            if (i2 == 1) {
                this.g = DfuUtils.getImageVersionFormatWithBitNumber(i, this.c);
                binIndicator = BinIndicator.getBinIndicatorByBitNumber(this.b, this.c);
            } else if (i2 == 2) {
                this.g = getImageVersionFormatWithBinId(i, this.d, this.f19545a);
                binIndicator = BinIndicator.getBinIndicatorByBinId(this.b, this.d, this.c);
            } else if (i2 == 0) {
                this.g = getImageVersionFormatWithBinId(i, this.d, this.f19545a);
                binIndicator = BinIndicator.getBinIndicatorByBinId(this.b, this.d, this.c);
            } else if (i2 == 3) {
                binIndicator = BinIndicator.getBinIndicatorByBinId(i, this.d, this.c);
            } else {
                binIndicator = null;
            }
            if (binIndicator != null) {
                this.n = binIndicator.flashLayoutName;
            }
        }
        if (-1 == this.e) {
            this.l = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.m = String.format(Locale.US, "%d.%d.%d.%d", 0, Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k));
            return;
        }
        this.l = 1;
        a();
    }

    public int compare(BinImageWrapper binImageWrapper) {
        if (this.h > binImageWrapper.getMajor()) {
            return 1;
        }
        if (this.h < binImageWrapper.getMajor()) {
            return -1;
        }
        if (this.i > binImageWrapper.getMinor()) {
            return 1;
        }
        if (this.i < binImageWrapper.getMinor()) {
            return -1;
        }
        if (this.j > binImageWrapper.getRevision()) {
            return 1;
        }
        if (this.j < binImageWrapper.getRevision()) {
            return -1;
        }
        if (this.k > binImageWrapper.getBuildnum()) {
            return 1;
        }
        if (this.k != binImageWrapper.getBuildnum()) {
            return -1;
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBuildnum() {
        return this.k;
    }

    public String getFlashLayoutName() {
        return this.n;
    }

    public int getFormat() {
        return this.g;
    }

    public String getFormatedVersion() {
        return this.m;
    }

    public String getFormattedVersion() {
        return this.m;
    }

    public int getIcType() {
        return this.b;
    }

    public String getImageFeature() {
        return this.o;
    }

    public int getImageVersion() {
        return this.e;
    }

    public int getMajor() {
        return this.h;
    }

    public int getMinor() {
        return this.i;
    }

    public int getOtaVersion() {
        return this.f19545a;
    }

    public int getRevision() {
        return this.j;
    }

    public String toString() {
        return String.format(Locale.US, "%s, otaVersion=[%d], icType=[%02X]imageVersion=[%08X], \nformat=[%d], formattedVersion=(%d.%d.%d.%d)->[%s]", this.n, Integer.valueOf(this.f19545a), Integer.valueOf(this.b), Integer.valueOf(this.e), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.j), Integer.valueOf(this.k), this.m);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f19545a);
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
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
    }

    public BinImageWrapper(int i, int i2, int i3, int i4, int i5, int i6, int i7, String str) {
        this.l = 0;
        this.n = "";
        this.f19545a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.g = i6;
        this.f = i7;
        this.o = str;
        b();
    }

    public BinImageWrapper(Parcel parcel) {
        this.l = 0;
        this.n = "";
        this.o = "";
        this.f19545a = parcel.readInt();
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
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
    }
}
