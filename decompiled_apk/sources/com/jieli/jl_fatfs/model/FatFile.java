package com.jieli.jl_fatfs.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_filebrowse.bean.FileStruct;

/* loaded from: classes10.dex */
public class FatFile implements Parcelable {
    public static final Parcelable.Creator<FatFile> CREATOR = new Parcelable.Creator<FatFile>() { // from class: com.jieli.jl_fatfs.model.FatFile.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FatFile createFromParcel(Parcel parcel) {
            return new FatFile(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FatFile[] newArray(int i) {
            return new FatFile[i];
        }
    };
    private int cluster;
    private byte devIndex;
    private boolean file;
    private short fileNum;
    private boolean isDir;
    private String modifyTime;
    private String name;
    private String path;
    private long size;
    private boolean unicode;

    public FatFile() {
    }

    public static FatFile create(FileStruct fileStruct) {
        if (fileStruct == null) {
            return null;
        }
        FatFile fatFile = new FatFile();
        fatFile.setName(fileStruct.getName());
        fatFile.setCluster(fileStruct.getCluster());
        fatFile.setDevIndex(fileStruct.getDevIndex());
        fatFile.setFileNum(fileStruct.getFileNum());
        fatFile.setFile(fileStruct.isFile());
        fatFile.setUnicode(fileStruct.isUnicode());
        fatFile.setPath("/" + fileStruct.getName());
        return fatFile;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCluster() {
        return this.cluster;
    }

    public byte getDevIndex() {
        return this.devIndex;
    }

    public short getFileNum() {
        return this.fileNum;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public long getSize() {
        return this.size;
    }

    public boolean isDir() {
        return this.isDir;
    }

    public boolean isFile() {
        return this.file;
    }

    public boolean isUnicode() {
        return this.unicode;
    }

    public void setCluster(int i) {
        this.cluster = i;
    }

    public void setDevIndex(byte b) {
        this.devIndex = b;
    }

    public void setDir(boolean z) {
        this.isDir = z;
    }

    public void setFile(boolean z) {
        this.file = z;
    }

    public void setFileNum(short s) {
        this.fileNum = s;
    }

    public void setModifyTime(String str) {
        this.modifyTime = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setUnicode(boolean z) {
        this.unicode = z;
    }

    public String toString() {
        return "FatFile{size=" + this.size + ", name='" + this.name + "', isDir=" + this.isDir + ", modifyTime='" + this.modifyTime + "', path='" + this.path + "', file=" + this.file + ", unicode=" + this.unicode + ", cluster=" + this.cluster + ", fileNum=" + ((int) this.fileNum) + ", devIndex=" + ((int) this.devIndex) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.size);
        parcel.writeString(this.name);
        parcel.writeByte(this.isDir ? (byte) 1 : (byte) 0);
        parcel.writeString(this.modifyTime);
        parcel.writeString(this.path);
        parcel.writeInt(this.cluster);
        parcel.writeInt(this.file ? 1 : 0);
        parcel.writeInt(this.unicode ? 1 : 0);
        parcel.writeInt(this.fileNum);
        parcel.writeByte(this.devIndex);
    }

    public FatFile(Parcel parcel) {
        this.size = parcel.readLong();
        this.name = parcel.readString();
        this.isDir = parcel.readByte() != 0;
        this.modifyTime = parcel.readString();
        this.path = parcel.readString();
        this.cluster = parcel.readInt();
        this.file = parcel.readInt() == 1;
        this.unicode = parcel.readInt() == 1;
        this.fileNum = (short) parcel.readInt();
        this.devIndex = parcel.readByte();
    }
}
