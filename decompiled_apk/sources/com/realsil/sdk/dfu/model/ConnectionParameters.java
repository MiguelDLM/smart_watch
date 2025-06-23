package com.realsil.sdk.dfu.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.realsil.sdk.core.logger.ZLogger;
import java.util.Locale;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes11.dex */
public class ConnectionParameters implements Parcelable {
    public static final Parcelable.Creator<ConnectionParameters> CREATOR = new Parcelable.Creator<ConnectionParameters>() { // from class: com.realsil.sdk.dfu.model.ConnectionParameters.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConnectionParameters createFromParcel(Parcel parcel) {
            return new ConnectionParameters(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConnectionParameters[] newArray(int i) {
            return new ConnectionParameters[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public int f19575a;
    public int b;
    public int c;
    public int d;

    /* loaded from: classes11.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public int f19576a = 17;
        public int b = 6;
        public int c = 0;
        public int d = 500;

        public ConnectionParameters build() {
            ZLogger.v(String.format(Locale.US, "\tmaxInterval=%d(0x%04X),minInterval=%d(0x%04X),latency=%d(0x%04X),timeout=%d(0x%04X),\n", Integer.valueOf(this.f19576a), Integer.valueOf(this.f19576a), Integer.valueOf(this.b), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.d)));
            return new ConnectionParameters(this.f19576a, this.b, this.c, this.d);
        }

        public Builder latency(int i) {
            this.c = i;
            return this;
        }

        public Builder maxInterval(int i) {
            this.f19576a = i;
            return this;
        }

        public Builder minInterval(int i) {
            this.b = i;
            return this;
        }

        public Builder timeout(int i) {
            this.d = i;
            return this;
        }
    }

    public ConnectionParameters(int i, int i2, int i3, int i4) {
        this.f19575a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getLatency() {
        return this.c;
    }

    public int getMaxInterval() {
        return this.f19575a;
    }

    public int getMinInterval() {
        return this.b;
    }

    public int getTimeout() {
        return this.d;
    }

    public void setLatency(int i) {
        this.c = i;
    }

    public void setMaxInterval(int i) {
        this.f19575a = i;
    }

    public void setMinInterval(int i) {
        this.b = i;
    }

    public void setTimeout(int i) {
        this.d = i;
    }

    public String toString() {
        return "ConnectionParameters{\n" + String.format(Locale.US, "\tmaxInterval=%d(0x%04X),minInterval=%d(0x%04X),latency=%d(0x%04X),timeout=%d(0x%04X),\n", Integer.valueOf(this.f19575a), Integer.valueOf(this.f19575a), Integer.valueOf(this.b), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.d)) + ooOOo0oXI.f33074oOoXoXO;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f19575a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }

    public ConnectionParameters(Parcel parcel) {
        this.f19575a = 17;
        this.b = 6;
        this.c = 0;
        this.d = 500;
        this.f19575a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
    }
}
