package com.jieli.jl_filebrowse.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.interfaces.cmd.IDataOp;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class PathData implements IDataOp, Parcelable {
    public static final Parcelable.Creator<PathData> CREATOR = new Parcelable.Creator<PathData>() { // from class: com.jieli.jl_filebrowse.bean.PathData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PathData createFromParcel(Parcel parcel) {
            return new PathData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PathData[] newArray(int i) {
            return new PathData[i];
        }
    };
    public static final byte PATH_TYPE_FILE = 1;
    public static final byte PATH_TYPE_FlODER = 0;
    private int devHandler;
    private final List<Integer> path;
    private byte readNum;
    private int repeatTimes;
    private short startIndex;
    private byte type;

    public PathData() {
        this.type = (byte) 0;
        this.readNum = (byte) 10;
        this.startIndex = (short) 1;
        this.devHandler = 0;
        this.repeatTimes = 3;
        ArrayList arrayList = new ArrayList();
        this.path = arrayList;
        arrayList.add(0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDevHandler() {
        return this.devHandler;
    }

    public List<Integer> getPath() {
        return this.path;
    }

    public byte getReadNum() {
        return this.readNum;
    }

    public int getRepeatTimes() {
        return this.repeatTimes;
    }

    public short getStartIndex() {
        return this.startIndex;
    }

    public byte getType() {
        return this.type;
    }

    @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public int parse(byte[] bArr) {
        int i;
        int i2 = 0;
        if (bArr == null || bArr.length < 10) {
            return 0;
        }
        this.type = bArr[0];
        this.readNum = bArr[1];
        this.startIndex = (short) CHexConver.bytesToInt(bArr, 2, 2);
        this.devHandler = CHexConver.bytesToInt(bArr, 4, 4);
        int bytesToInt = CHexConver.bytesToInt(bArr, 8, 2);
        this.path.clear();
        if (bytesToInt <= 0 || (i = bytesToInt + 10) > bArr.length) {
            return 10;
        }
        byte[] bArr2 = new byte[bytesToInt];
        System.arraycopy(bArr, 10, bArr2, 0, bytesToInt);
        while (true) {
            int i3 = i2 + 4;
            if (i3 <= bytesToInt) {
                this.path.add(Integer.valueOf(CHexConver.bytesToInt(bArr2, i2, 4)));
                i2 = i3;
            } else {
                return i;
            }
        }
    }

    public void setRepeatTimes(int i) {
        this.repeatTimes = i;
    }

    @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public byte[] toData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(this.type);
            byteArrayOutputStream.write(this.readNum);
            byteArrayOutputStream.write(CHexConver.shortToBigBytes(this.startIndex));
            byteArrayOutputStream.write(CHexConver.intToBigBytes(this.devHandler));
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            for (Integer num : this.path) {
                if (num != null) {
                    byteArrayOutputStream2.write(CHexConver.intToBigBytes(num.intValue()));
                }
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            byteArrayOutputStream.write(CHexConver.int2byte2(byteArray.length));
            byteArrayOutputStream.write(byteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String toString() {
        return "PathData{type=" + ((int) this.type) + ", readNum=" + ((int) this.readNum) + ", startIndex=" + ((int) this.startIndex) + ", devHandler=" + this.devHandler + ", path=" + this.path + ", repeatTimes=" + this.repeatTimes + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.type);
        parcel.writeByte(this.readNum);
        parcel.writeInt(this.startIndex);
        parcel.writeInt(this.devHandler);
        parcel.writeInt(this.repeatTimes);
        int[] iArr = new int[this.path.size()];
        for (int i2 = 0; i2 < this.path.size(); i2++) {
            iArr[i2] = this.path.get(i2).intValue();
        }
        parcel.writeIntArray(iArr);
    }

    public PathData(byte b, byte b2, short s, int i, List<Integer> list) {
        this.repeatTimes = 3;
        this.type = b;
        this.readNum = b2;
        this.startIndex = s;
        this.devHandler = i;
        this.path = list;
    }

    public PathData(Parcel parcel) {
        this.type = (byte) 0;
        this.readNum = (byte) 10;
        this.startIndex = (short) 1;
        this.devHandler = 0;
        this.repeatTimes = 3;
        this.type = parcel.readByte();
        this.readNum = parcel.readByte();
        this.startIndex = (short) parcel.readInt();
        this.devHandler = parcel.readInt();
        this.repeatTimes = parcel.readInt();
        int[] createIntArray = parcel.createIntArray();
        createIntArray = createIntArray == null ? new int[0] : createIntArray;
        this.path = new ArrayList();
        for (int i : createIntArray) {
            this.path.add(Integer.valueOf(i));
        }
    }
}
