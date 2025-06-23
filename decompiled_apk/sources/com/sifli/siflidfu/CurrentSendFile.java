package com.sifli.siflidfu;

import java.util.ArrayList;

/* loaded from: classes11.dex */
public class CurrentSendFile {
    String fileName;
    int packetSize;
    ArrayList<byte[]> sendData;
    int totalCount;
    int totalSize;

    public CurrentSendFile(byte[] bArr, int i, String str) {
        byte[] bArr2;
        this.packetSize = 2048;
        int length = bArr.length;
        this.totalSize = length;
        this.fileName = str;
        if (length == 0) {
            this.totalCount = 0;
            this.sendData = null;
            return;
        }
        this.packetSize = i;
        if (bArr.length % i == 0) {
            this.totalCount = bArr.length / i;
        } else {
            this.totalCount = (bArr.length / i) + 1;
        }
        this.sendData = new ArrayList<>(this.totalCount);
        int i2 = 0;
        for (int i3 = 0; i3 < this.totalCount; i3++) {
            int i4 = i2 + i;
            if (i4 <= bArr.length) {
                bArr2 = new byte[i];
                System.arraycopy(bArr, i2, bArr2, 0, i);
                i2 = i4;
            } else {
                int length2 = bArr.length - i2;
                bArr2 = new byte[length2];
                System.arraycopy(bArr, i2, bArr2, 0, length2);
                i2 += length2;
            }
            this.sendData.add(i3, bArr2);
        }
    }

    public byte[] getData(int i) {
        return this.sendData.get(i);
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getPacketSize() {
        return this.packetSize;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public CurrentSendFile(int i, int i2, String str) {
        this.totalSize = i;
        this.fileName = str;
        this.packetSize = i2;
        if (i % i2 == 0) {
            this.totalCount = i / i2;
        } else {
            this.totalCount = (i / i2) + 1;
        }
    }
}
