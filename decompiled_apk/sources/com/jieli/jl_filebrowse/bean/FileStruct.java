package com.jieli.jl_filebrowse.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.interfaces.cmd.IDataOp;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* loaded from: classes10.dex */
public class FileStruct implements IDataOp, Parcelable {
    public static final Parcelable.Creator<FileStruct> CREATOR = new Parcelable.Creator<FileStruct>() { // from class: com.jieli.jl_filebrowse.bean.FileStruct.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileStruct createFromParcel(Parcel parcel) {
            return new FileStruct(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileStruct[] newArray(int i) {
            return new FileStruct[i];
        }
    };
    private int cluster;
    private byte devIndex;
    private boolean file;
    private short fileNum;
    private String name;
    private boolean unicode;

    public FileStruct() {
        this.cluster = 0;
        this.fileNum = (short) 1;
        this.name = "";
    }

    public static int parseFileStruct(byte[] bArr, int i, List<FileStruct> list) {
        if (bArr == null || bArr.length - i < 8 || list == null) {
            return 0;
        }
        while (i < bArr.length) {
            int length = bArr.length - i;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, i, bArr2, 0, length);
            FileStruct fileStruct = new FileStruct();
            int parse = fileStruct.parse(bArr2);
            if (parse <= 0) {
                break;
            }
            list.add(fileStruct);
            i += parse;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FileStruct fileStruct = (FileStruct) obj;
        if (this.file == fileStruct.file && this.cluster == fileStruct.cluster && this.devIndex == fileStruct.devIndex) {
            return true;
        }
        return false;
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

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.file), Integer.valueOf(this.cluster), Byte.valueOf(this.devIndex));
    }

    public boolean isFile() {
        return this.file;
    }

    public boolean isUnicode() {
        return this.unicode;
    }

    @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public int parse(byte[] bArr) {
        String str;
        if (bArr == null || bArr.length < 8) {
            return 0;
        }
        byte b = bArr[0];
        this.file = CHexConver.checkBitValue(b, 0);
        this.unicode = !CHexConver.checkBitValue(b, 1);
        this.devIndex = (byte) ((b & 124) >> 2);
        this.cluster = CHexConver.bytesToInt(bArr, 1, 4);
        this.fileNum = (short) CHexConver.bytesToInt(bArr, 5, 2);
        byte b2 = bArr[7];
        int i = b2 + 8;
        if (i > bArr.length) {
            return 8;
        }
        try {
            if (this.unicode) {
                str = "utf-16le";
            } else {
                str = "gbk";
            }
            this.name = new String(bArr, 8, b2, str);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 8;
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public byte[] toData() {
        String str;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write((byte) (CHexConver.setBitValue(CHexConver.setBitValue((byte) 0, 0, this.file), 1, !this.unicode) | (this.devIndex << 2)));
            byteArrayOutputStream.write(CHexConver.intToBigBytes(this.cluster));
            byteArrayOutputStream.write(CHexConver.int2byte2(this.fileNum));
            String str2 = this.name;
            if (this.unicode) {
                str = "utf-16le";
            } else {
                str = "gbk";
            }
            byte[] bytes = str2.getBytes(str);
            byteArrayOutputStream.write(bytes.length);
            byteArrayOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String toString() {
        return "FileStruct{file=" + this.file + ", unicode=" + this.unicode + ", cluster=" + this.cluster + ", fileNum=" + ((int) this.fileNum) + ", devIndex=" + ((int) this.devIndex) + ", name='" + this.name + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.file ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.unicode ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.cluster);
        parcel.writeInt(this.fileNum);
        parcel.writeString(this.name);
        parcel.writeByte(this.devIndex);
    }

    public FileStruct(boolean z, boolean z2, int i, short s, String str, byte b) {
        this.file = z;
        this.unicode = z2;
        this.cluster = i;
        this.fileNum = s;
        this.name = str;
        this.devIndex = b;
    }

    public FileStruct(Parcel parcel) {
        this.cluster = 0;
        this.fileNum = (short) 1;
        this.name = "";
        this.file = parcel.readByte() != 0;
        this.unicode = parcel.readByte() != 0;
        this.cluster = parcel.readInt();
        this.fileNum = (short) parcel.readInt();
        this.name = parcel.readString();
        this.devIndex = parcel.readByte();
    }
}
