package com.bluetrum.fota.manager;

import java.io.IOException;

/* loaded from: classes8.dex */
final class OtaDataProvider {
    private final DataReader dataReader;
    private int dataSize;
    private boolean isCompressedData = false;
    private int blockSize = -1;
    private int blockOffset = 0;
    private int packetSize = 20;
    private int fileOffset = 0;

    public OtaDataProvider(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    private boolean checkHeaderIfCompressedData(byte[] bArr) {
        if (bArr.length < 3 || bArr[0] != 80 || bArr[1] != 79 || bArr[2] != 84) {
            return false;
        }
        return true;
    }

    private boolean checkIfCompressedData() throws IOException {
        byte[] bArr = new byte[4];
        if (this.dataReader.read(0, bArr, 0, 4) != 4) {
            return false;
        }
        return checkHeaderIfCompressedData(bArr);
    }

    private int getDataSize() {
        return this.dataSize;
    }

    public void close() throws IOException {
        this.fileOffset = 0;
        this.blockOffset = 0;
        this.packetSize = 20;
        this.blockSize = -1;
        this.dataReader.close();
    }

    public byte[] getDataToBeSent(int i) throws IOException {
        int i2 = this.blockSize;
        if (i2 == -1) {
            i2 = getDataSize();
        }
        int min = Math.min(i2, this.packetSize - i);
        int i3 = this.blockSize;
        if (i3 != -1) {
            int i4 = this.fileOffset;
            int i5 = this.blockOffset;
            if ((i4 - i5) + min > i3) {
                min = i3 - (i4 - i5);
            }
        }
        if (this.fileOffset + min > getDataSize()) {
            min = getDataSize() - this.fileOffset;
        }
        byte[] bArr = new byte[min];
        int read = this.dataReader.read(this.fileOffset, bArr, 0, min);
        if (read >= 0) {
            byte[] bArr2 = new byte[read];
            System.arraycopy(bArr, 0, bArr2, 0, read);
            this.fileOffset += read;
            return bArr2;
        }
        throw new IOException("read data failed");
    }

    public byte[] getHash() throws IOException {
        return this.dataReader.getHash();
    }

    public int getProgress() {
        return (this.fileOffset * 100) / getDataSize();
    }

    public int getStartAddress() {
        return this.fileOffset;
    }

    public byte[] getStartData(int i) throws IOException {
        int i2 = this.blockSize;
        if (i2 == -1) {
            i2 = getDataSize();
        }
        int min = Math.min(i2, this.packetSize - i);
        if (this.fileOffset + min > getDataSize()) {
            min = getDataSize() - this.fileOffset;
        }
        byte[] bArr = new byte[min];
        int read = this.dataReader.read(this.fileOffset, bArr, 0, min);
        if (read >= 0) {
            byte[] bArr2 = new byte[read];
            System.arraycopy(bArr, 0, bArr2, 0, read);
            this.fileOffset += read;
            return bArr2;
        }
        throw new IOException("read data failed");
    }

    public int getTotalLengthToBeSent() {
        if (this.blockSize == -1) {
            return getDataSize() - this.fileOffset;
        }
        int min = Math.min(getDataSize() - this.fileOffset, this.blockSize);
        this.blockOffset = this.fileOffset;
        return min;
    }

    public boolean isAllDataSent() {
        if (this.fileOffset == getDataSize()) {
            return true;
        }
        return false;
    }

    public boolean isBlockSendFinish() {
        int i = this.blockSize;
        if (i == -1) {
            return isAllDataSent();
        }
        if (this.fileOffset - this.blockOffset != i && !isAllDataSent()) {
            return false;
        }
        return true;
    }

    public boolean isCompressedData() {
        return this.isCompressedData;
    }

    public void open() throws IOException {
        this.dataReader.open();
        this.dataSize = this.dataReader.getSize();
        this.isCompressedData = checkIfCompressedData();
    }

    public void setBlockSize(int i) {
        this.blockSize = i;
    }

    public void setPacketSize(int i) {
        this.packetSize = i;
    }

    public void setStartAddress(int i) {
        this.fileOffset = i;
    }
}
