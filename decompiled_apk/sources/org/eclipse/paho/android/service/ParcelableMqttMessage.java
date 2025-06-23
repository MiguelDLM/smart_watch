package org.eclipse.paho.android.service;

import OoOoXO0.Oxx0xo;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class ParcelableMqttMessage extends Oxx0xo implements Parcelable {
    public static final Parcelable.Creator<ParcelableMqttMessage> CREATOR = new Parcelable.Creator<ParcelableMqttMessage>() { // from class: org.eclipse.paho.android.service.ParcelableMqttMessage.1
        @Override // android.os.Parcelable.Creator
        public ParcelableMqttMessage createFromParcel(Parcel parcel) {
            return new ParcelableMqttMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ParcelableMqttMessage[] newArray(int i) {
            return new ParcelableMqttMessage[i];
        }
    };
    public String messageId;

    public ParcelableMqttMessage(Oxx0xo oxx0xo) {
        super(oxx0xo.getPayload());
        this.messageId = null;
        setQos(oxx0xo.getQos());
        setRetained(oxx0xo.isRetained());
        setDuplicate(oxx0xo.isDuplicate());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMessageId() {
        return this.messageId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(getPayload());
        parcel.writeInt(getQos());
        parcel.writeBooleanArray(new boolean[]{isRetained(), isDuplicate()});
        parcel.writeString(this.messageId);
    }

    public ParcelableMqttMessage(Parcel parcel) {
        super(parcel.createByteArray());
        this.messageId = null;
        setQos(parcel.readInt());
        boolean[] createBooleanArray = parcel.createBooleanArray();
        setRetained(createBooleanArray[0]);
        setDuplicate(createBooleanArray[1]);
        this.messageId = parcel.readString();
    }
}
