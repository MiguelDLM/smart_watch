package com.tenmeter.smlibrary.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes13.dex */
public class SMGameInfo implements Parcelable {
    public static final Parcelable.Creator<SMGameInfo> CREATOR = new Parcelable.Creator<SMGameInfo>() { // from class: com.tenmeter.smlibrary.entity.SMGameInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SMGameInfo createFromParcel(Parcel parcel) {
            return new SMGameInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SMGameInfo[] newArray(int i) {
            return new SMGameInfo[i];
        }
    };
    private String angleMark;
    private String background;
    private String details;
    private int gameType;
    private int gameVersion;
    private int gid;
    private String gname;
    private int keyboard;
    private String label;
    private long playNum;
    private String resourceUrl;
    private int tagId;
    private String title;
    private String urls;
    private int vertical;

    public SMGameInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAngleMark() {
        return this.angleMark;
    }

    public String getBackground() {
        return this.background;
    }

    public String getDetails() {
        return this.details;
    }

    public int getGameType() {
        return this.gameType;
    }

    public int getGameVersion() {
        return this.gameVersion;
    }

    public int getGid() {
        return this.gid;
    }

    public String getGname() {
        return this.gname;
    }

    public int getKeyboard() {
        return this.keyboard;
    }

    public String getLabel() {
        return this.label;
    }

    public long getPlayNum() {
        return this.playNum;
    }

    public String getResourceUrl() {
        return this.resourceUrl;
    }

    public int getTagId() {
        return this.tagId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrls() {
        return this.urls;
    }

    public int getVertical() {
        return this.vertical;
    }

    public void setAngleMark(String str) {
        this.angleMark = str;
    }

    public void setBackground(String str) {
        this.background = str;
    }

    public void setDetails(String str) {
        this.details = str;
    }

    public void setGameType(int i) {
        this.gameType = i;
    }

    public void setGameVersion(int i) {
        this.gameVersion = i;
    }

    public void setGid(int i) {
        this.gid = i;
    }

    public void setGname(String str) {
        this.gname = str;
    }

    public void setKeyboard(int i) {
        this.keyboard = i;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setPlayNum(long j) {
        this.playNum = j;
    }

    public void setResourceUrl(String str) {
        this.resourceUrl = str;
    }

    public void setTagId(int i) {
        this.tagId = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrls(String str) {
        this.urls = str;
    }

    public void setVertical(int i) {
        this.vertical = i;
    }

    public String toString() {
        return "SMGameInfo{details='" + this.details + "', gid=" + this.gid + ", label='" + this.label + "', title='" + this.title + "', gname='" + this.gname + "', background='" + this.background + "', gameVersion=" + this.gameVersion + ", vertical=" + this.vertical + ", resourceUrl='" + this.resourceUrl + "', gameType=" + this.gameType + ", keyboard=" + this.keyboard + ", urls='" + this.urls + "', tagId='" + this.tagId + "', angleMark='" + this.angleMark + "', playNum='" + this.playNum + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.details);
        parcel.writeInt(this.gid);
        parcel.writeString(this.label);
        parcel.writeString(this.title);
        parcel.writeString(this.gname);
        parcel.writeString(this.background);
        parcel.writeInt(this.gameVersion);
        parcel.writeInt(this.vertical);
        parcel.writeString(this.resourceUrl);
        parcel.writeInt(this.gameType);
        parcel.writeInt(this.keyboard);
        parcel.writeString(this.urls);
        parcel.writeInt(this.tagId);
        parcel.writeString(this.angleMark);
        parcel.writeLong(this.playNum);
    }

    public SMGameInfo(int i, String str) {
        this.gid = i;
        this.gname = str;
    }

    public SMGameInfo(int i, String str, int i2, int i3) {
        this.gid = i;
        this.resourceUrl = str;
        this.gameVersion = i2;
        this.vertical = i3;
    }

    public SMGameInfo(Parcel parcel) {
        this.details = parcel.readString();
        this.gid = parcel.readInt();
        this.label = parcel.readString();
        this.title = parcel.readString();
        this.gname = parcel.readString();
        this.background = parcel.readString();
        this.gameVersion = parcel.readInt();
        this.vertical = parcel.readInt();
        this.resourceUrl = parcel.readString();
        this.gameType = parcel.readInt();
        this.keyboard = parcel.readInt();
        this.urls = parcel.readString();
        this.tagId = parcel.readInt();
        this.angleMark = parcel.readString();
        this.playNum = parcel.readLong();
    }
}
