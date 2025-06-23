package com.sma.smartv3.ui.contactpicker;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes12.dex */
public class PhoneNumber implements Parcelable {
    public static final Parcelable.Creator<PhoneNumber> CREATOR = new Parcelable.Creator<PhoneNumber>() { // from class: com.sma.smartv3.ui.contactpicker.PhoneNumber.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhoneNumber createFromParcel(Parcel in) {
            return new PhoneNumber(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhoneNumber[] newArray(int size) {
            return new PhoneNumber[size];
        }
    };
    private String number;
    private String typeLabel;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getNumber() {
        return this.number;
    }

    public String getTypeLabel() {
        return this.typeLabel;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setTypeLabel(String typeLabel) {
        this.typeLabel = typeLabel;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.typeLabel);
        dest.writeString(this.number);
    }

    public PhoneNumber(String typeLabel, String number) {
        this.typeLabel = typeLabel;
        this.number = number;
    }

    private PhoneNumber(Parcel in) {
        this.typeLabel = in.readString();
        this.number = in.readString();
    }
}
