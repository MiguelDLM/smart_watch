package com.realsil.sdk.dfu.params;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes11.dex */
public final class QcConfig implements Parcelable {
    public static final Parcelable.Creator<QcConfig> CREATOR = new Parcelable.Creator<QcConfig>() { // from class: com.realsil.sdk.dfu.params.QcConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QcConfig createFromParcel(Parcel parcel) {
            return new QcConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QcConfig[] newArray(int i) {
            return new QcConfig[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public int f19590a;

    /* loaded from: classes11.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public int f19591a;

        public Builder aes(boolean z) {
            if (z) {
                this.f19591a |= 1;
            } else {
                this.f19591a &= -2;
            }
            return this;
        }

        public Builder buffercheck(boolean z) {
            if (z) {
                this.f19591a &= -17;
            } else {
                this.f19591a |= 16;
            }
            return this;
        }

        public QcConfig build() {
            return new QcConfig(this.f19591a);
        }

        public Builder copyFail(boolean z) {
            if (z) {
                this.f19591a |= 4;
            } else {
                this.f19591a &= -5;
            }
            return this;
        }

        public Builder skipFail(boolean z) {
            if (z) {
                this.f19591a |= 8;
            } else {
                this.f19591a &= -9;
            }
            return this;
        }

        public Builder stress(boolean z) {
            if (z) {
                this.f19591a |= 2;
            } else {
                this.f19591a &= -3;
            }
            return this;
        }
    }

    public QcConfig(int i) {
        this.f19590a = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getIndicator() {
        return this.f19590a;
    }

    public String toString() {
        return String.format("indicator=%b", Integer.valueOf(this.f19590a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f19590a);
    }

    public QcConfig(Parcel parcel) {
        this.f19590a = parcel.readInt();
    }
}
