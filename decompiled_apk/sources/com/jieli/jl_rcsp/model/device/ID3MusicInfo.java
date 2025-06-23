package com.jieli.jl_rcsp.model.device;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes10.dex */
public class ID3MusicInfo implements Parcelable {
    public static final Parcelable.Creator<ID3MusicInfo> CREATOR = new Parcelable.Creator<ID3MusicInfo>() { // from class: com.jieli.jl_rcsp.model.device.ID3MusicInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ID3MusicInfo createFromParcel(Parcel parcel) {
            return new ID3MusicInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ID3MusicInfo[] newArray(int i) {
            return new ID3MusicInfo[i];
        }
    };
    private String album;
    private String artist;
    private int currentTime;
    private String genre;
    private int number;
    private boolean playStatus;
    private String title;
    private int total;
    private int totalTime;

    public ID3MusicInfo() {
        this.number = -1;
        this.currentTime = -1;
    }

    public static ID3MusicInfo cloneMySelf(ID3MusicInfo iD3MusicInfo) {
        ID3MusicInfo iD3MusicInfo2 = new ID3MusicInfo();
        iD3MusicInfo2.setTotal(iD3MusicInfo.getTotal());
        iD3MusicInfo2.setCurrentTime(iD3MusicInfo.getCurrentTime());
        iD3MusicInfo2.setPlayStatus(iD3MusicInfo.isPlayStatus());
        iD3MusicInfo2.setAlbum(iD3MusicInfo.getAlbum());
        iD3MusicInfo2.setArtist(iD3MusicInfo.getArtist());
        iD3MusicInfo2.setTitle(iD3MusicInfo.getTitle());
        iD3MusicInfo2.setGenre(iD3MusicInfo.getGenre());
        iD3MusicInfo2.setNumber(iD3MusicInfo.getNumber());
        iD3MusicInfo2.setTotalTime(iD3MusicInfo.getTotalTime());
        return iD3MusicInfo2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlbum() {
        return this.album;
    }

    public String getArtist() {
        return this.artist;
    }

    public int getCurrentTime() {
        return this.currentTime;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getNumber() {
        return this.number;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTotal() {
        return this.total;
    }

    public int getTotalTime() {
        return this.totalTime;
    }

    public boolean isPlayStatus() {
        return this.playStatus;
    }

    public void setAlbum(String str) {
        this.album = str;
    }

    public void setArtist(String str) {
        this.artist = str;
    }

    public void setCurrentTime(int i) {
        this.currentTime = i;
    }

    public void setGenre(String str) {
        this.genre = str;
    }

    public void setNumber(int i) {
        this.number = i;
    }

    public void setPlayStatus(boolean z) {
        this.playStatus = z;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTotal(int i) {
        this.total = i;
    }

    public void setTotalTime(int i) {
        this.totalTime = i;
    }

    public String toString() {
        return "ID3MusicInfo{title=" + this.title + ", artist='" + this.artist + "', album=" + this.album + ", number=" + this.number + ", total=" + this.total + ", totalTime=" + this.totalTime + ", genre='" + this.genre + "', currentTime='" + this.currentTime + "', playStatus='" + this.playStatus + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.artist);
        parcel.writeString(this.album);
        parcel.writeInt(this.number);
        parcel.writeInt(this.total);
        parcel.writeInt(this.totalTime);
        parcel.writeString(this.genre);
        parcel.writeInt(this.currentTime);
        parcel.writeByte(this.playStatus ? (byte) 1 : (byte) 0);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ID3MusicInfo m271clone() throws CloneNotSupportedException {
        return (ID3MusicInfo) super.clone();
    }

    public ID3MusicInfo(Parcel parcel) {
        this.number = -1;
        this.currentTime = -1;
        this.title = parcel.readString();
        this.artist = parcel.readString();
        this.album = parcel.readString();
        this.number = parcel.readInt();
        this.total = parcel.readInt();
        this.totalTime = parcel.readInt();
        this.genre = parcel.readString();
        this.currentTime = parcel.readInt();
        this.playStatus = parcel.readByte() != 0;
    }
}
