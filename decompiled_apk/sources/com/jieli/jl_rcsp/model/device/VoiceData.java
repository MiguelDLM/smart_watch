package com.jieli.jl_rcsp.model.device;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class VoiceData implements Parcelable {
    public static final int CHANNEL_MONO = 1;
    public static final int CHANNEL_STEREO = 2;
    public static final Parcelable.Creator<VoiceData> CREATOR = new Parcelable.Creator<VoiceData>() { // from class: com.jieli.jl_rcsp.model.device.VoiceData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoiceData createFromParcel(Parcel parcel) {
            return new VoiceData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoiceData[] newArray(int i) {
            return new VoiceData[i];
        }
    };
    public static final int ENCODING_PCM_16BIT = 2;
    public static final int ENCODING_PCM_8BIT = 1;
    public static final int VOICE_TYPE_OPUS = 2;
    public static final int VOICE_TYPE_PCM = 0;
    public static final int VOICE_TYPE_SPEEX = 1;
    private int channel;
    private byte[] data;
    private int dataType;
    private int format;
    private int sampleRate;

    public VoiceData() {
        this.sampleRate = 16000;
        this.format = 2;
        this.channel = 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof VoiceData)) {
            return false;
        }
        VoiceData voiceData = (VoiceData) obj;
        if (this.dataType != voiceData.dataType || this.sampleRate != voiceData.sampleRate || this.format != voiceData.format || this.channel != voiceData.channel) {
            return false;
        }
        return true;
    }

    public int getChannel() {
        return this.channel;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getDataType() {
        return this.dataType;
    }

    public int getFormat() {
        return this.format;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public int hashCode() {
        return this.dataType + this.sampleRate + this.format + this.channel;
    }

    public VoiceData setChannel(int i) {
        this.channel = i;
        return this;
    }

    public VoiceData setData(byte[] bArr) {
        this.data = bArr;
        return this;
    }

    public VoiceData setDataType(int i) {
        this.dataType = i;
        return this;
    }

    public VoiceData setFormat(int i) {
        this.format = i;
        return this;
    }

    public VoiceData setSampleRate(int i) {
        this.sampleRate = i;
        return this;
    }

    public String toString() {
        return "VoiceData{dataType=" + this.dataType + ", data=" + CHexConver.byte2HexStr(this.data) + ", sampleRate=" + this.sampleRate + ", format=" + this.format + ", channel=" + this.channel + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.dataType);
        parcel.writeByteArray(this.data);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.format);
        parcel.writeInt(this.channel);
    }

    public VoiceData(Parcel parcel) {
        this.sampleRate = 16000;
        this.format = 2;
        this.channel = 1;
        this.dataType = parcel.readInt();
        this.data = parcel.createByteArray();
        this.sampleRate = parcel.readInt();
        this.format = parcel.readInt();
        this.channel = parcel.readInt();
    }
}
