package com.realsil.sdk.dfu.model;

import XIXIX.OOXIXo;
import android.os.Parcel;
import android.os.Parcelable;
import com.realsil.sdk.core.logger.ZLogger;
import java.util.Locale;

/* loaded from: classes11.dex */
public class DfuProgressInfo implements Parcelable {
    public static final Parcelable.Creator<DfuProgressInfo> CREATOR = new Parcelable.Creator<DfuProgressInfo>() { // from class: com.realsil.sdk.dfu.model.DfuProgressInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DfuProgressInfo createFromParcel(Parcel parcel) {
            return new DfuProgressInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DfuProgressInfo[] newArray(int i) {
            return new DfuProgressInfo[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public int f19580a;
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
    public long m;
    public long n;
    public long o;
    public long p;
    public Throughput q;
    public boolean r;

    public DfuProgressInfo() {
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.b = 0;
        this.r = false;
    }

    public final void a() {
        float f;
        long max = Math.max(0L, this.n - this.m);
        float f2 = 0.0f;
        if (max > 0) {
            f = (this.b * 1000.0f) / ((float) max);
        } else {
            f = 0.0f;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.b;
        long j2 = j - this.p;
        long j3 = currentTimeMillis - this.o;
        if (j3 > 0) {
            f2 = (((float) j2) * 1000.0f) / ((float) j3);
        }
        this.o = currentTimeMillis;
        this.p = j;
        Throughput throughput = this.q;
        if (throughput != null) {
            throughput.deltaTime = max;
            throughput.speed = f;
            throughput.realSpeed = f2;
        }
    }

    public void addBytesSent(int i) {
        setBytesSent(this.b + i);
        this.k += i;
    }

    public void addImageSizeInBytes(int i) {
        setImageSizeInBytes(this.f19580a + i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getActiveImageSize() {
        return this.l;
    }

    public int getBinId() {
        return this.h;
    }

    public int getBytesSent() {
        return this.b;
    }

    public int getCurImageId() {
        return this.i;
    }

    public int getCurImageVersion() {
        return this.j;
    }

    public int getCurrentFileIndex() {
        return this.e;
    }

    public int getImageSizeInBytes() {
        return this.f19580a;
    }

    public int getLastFileIndex() {
        return this.f;
    }

    public int getMaxFileCount() {
        return this.d;
    }

    public int getNextFileIndex() {
        return this.g;
    }

    public int getProgress() {
        return this.c;
    }

    public int getRemainSizeInBytes() {
        return this.f19580a - this.b;
    }

    public Throughput getThroughput() {
        return this.q;
    }

    public int getTotalBytesSent() {
        return this.k;
    }

    public int getTotalProgress() {
        double d;
        int i = this.d;
        if (i == 0) {
            return 0;
        }
        double d2 = 100.0f / i;
        int i2 = this.f19580a;
        if (i2 == 0) {
            d = OOXIXo.f3760XO;
        } else {
            d = (this.b * 1.0d) / i2;
        }
        double d3 = this.e + d;
        if (d3 < i) {
            return (int) (d3 * d2);
        }
        return 100;
    }

    public void initialize(int i, int i2, int i3, int i4, boolean z) {
        this.h = i;
        this.i = i2;
        this.j = i3;
        this.f19580a = i4;
        this.r = z;
        setBytesSent(0);
    }

    public boolean isFileSendOver() {
        if (this.b >= this.f19580a) {
            return true;
        }
        return false;
    }

    public boolean isLastImageFile() {
        if (this.g >= this.d) {
            return true;
        }
        return false;
    }

    public void sendOver() {
        this.m = System.currentTimeMillis();
        this.b = this.f19580a;
        int i = this.e;
        this.f = i;
        this.g = i + 1;
        ZLogger.v(toString());
    }

    public void setActiveImageSize(int i) {
        this.l = i;
    }

    public void setBytesSent(int i) {
        this.b = i;
        this.c = (int) ((i * 100.0f) / this.f19580a);
        this.n = System.currentTimeMillis();
        if (this.r) {
            a();
        }
    }

    public void setCurrentFileIndex(int i) {
        this.e = i;
    }

    public void setImageSizeInBytes(int i) {
        this.f19580a = i;
    }

    public void setLastFileIndex(int i) {
        this.f = i;
    }

    public void setMaxFileCount(int i) {
        this.d = i;
    }

    public void setNextFileIndex(int i) {
        this.g = i;
    }

    public void start() {
        long currentTimeMillis = System.currentTimeMillis();
        this.m = currentTimeMillis;
        this.n = currentTimeMillis;
        this.o = currentTimeMillis;
        this.p = 0L;
        if (this.r) {
            this.q = new Throughput(this.f19580a, this.b);
        } else {
            this.q = null;
        }
        ZLogger.v(toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Locale locale = Locale.US;
        sb.append(String.format(locale, "image: %d/%d", Integer.valueOf(this.e + 1), Integer.valueOf(this.d)));
        sb.append(String.format(locale, "\t{binId=0x%04X, imageId=0x%04X, version=0x%04X}", Integer.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.j)));
        sb.append(String.format(locale, "\tprogress: %d%%(%d/%d)--%d%%", Integer.valueOf(this.c), Integer.valueOf(this.b), Integer.valueOf(this.f19580a), Integer.valueOf(getTotalProgress())));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f19580a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeLong(this.m);
        parcel.writeLong(this.n);
        parcel.writeLong(this.o);
        parcel.writeLong(this.p);
        parcel.writeParcelable(this.q, i);
        parcel.writeByte(this.r ? (byte) 1 : (byte) 0);
    }

    public DfuProgressInfo(Parcel parcel) {
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.f19580a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readLong();
        this.n = parcel.readLong();
        this.o = parcel.readLong();
        this.p = parcel.readLong();
        this.q = (Throughput) parcel.readParcelable(Throughput.class.getClassLoader());
        this.r = parcel.readByte() != 0;
    }
}
