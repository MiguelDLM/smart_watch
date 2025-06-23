package com.jieli.jl_rcsp.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes10.dex */
public class NotificationMsg implements Parcelable {
    public static final Parcelable.Creator<NotificationMsg> CREATOR = new Parcelable.Creator<NotificationMsg>() { // from class: com.jieli.jl_rcsp.model.NotificationMsg.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotificationMsg createFromParcel(Parcel parcel) {
            return new NotificationMsg(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotificationMsg[] newArray(int i) {
            return new NotificationMsg[i];
        }
    };
    public static final int OP_PUSH = 0;
    public static final int OP_REMOVE = 1;
    private String appName;
    private String content;
    private int flag;
    private int op;
    private long time;
    private String title;

    public NotificationMsg() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getContent() {
        return this.content;
    }

    public int getFlag() {
        return this.flag;
    }

    public int getOp() {
        return this.op;
    }

    public long getTime() {
        return this.time;
    }

    public String getTitle() {
        return this.title;
    }

    public NotificationMsg setAppName(String str) {
        this.appName = str;
        return this;
    }

    public NotificationMsg setContent(String str) {
        this.content = str;
        return this;
    }

    public NotificationMsg setFlag(int i) {
        this.flag = i;
        return this;
    }

    public NotificationMsg setOp(int i) {
        this.op = i;
        return this;
    }

    public NotificationMsg setTime(long j) {
        this.time = j;
        return this;
    }

    public NotificationMsg setTitle(String str) {
        this.title = str;
        return this;
    }

    public String toString() {
        return "NotificationMsg{appName='" + this.appName + "', title='" + this.title + "', content='" + this.content + "', time='" + this.time + "', flag=" + this.flag + ", op=" + this.op + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appName);
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeLong(this.time);
        parcel.writeInt(this.flag);
        parcel.writeInt(this.op);
    }

    public NotificationMsg(Parcel parcel) {
        this.appName = parcel.readString();
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.time = parcel.readLong();
        this.flag = parcel.readInt();
        this.op = parcel.readInt();
    }
}
