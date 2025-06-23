package com.goodix.ble.gr.libdfu.dfu.entity;

import com.goodix.ble.libcomx.util.HexReader;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes9.dex */
public class DfuFile {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f16091a;
    private ImgInfo b;
    private int d;
    private String c = "success";
    private boolean e = false;
    private boolean f = false;

    public int getFileChecksum() {
        return this.d;
    }

    public byte[] getFirmware() {
        if (this.f16091a == null) {
            this.f16091a = new byte[0];
        }
        return this.f16091a;
    }

    public ImgInfo getImgInfo() {
        return this.b;
    }

    public String getLastError() {
        return this.c;
    }

    public boolean isEncrypted() {
        return this.e;
    }

    public boolean isSigned() {
        return this.f;
    }

    public boolean isValidDfuFile() {
        if (this.b != null) {
            return true;
        }
        return false;
    }

    public boolean load(InputStream inputStream) {
        if (inputStream == null) {
            this.c = "Input is null";
            return false;
        }
        this.b = null;
        this.e = false;
        this.f = false;
        try {
            int available = inputStream.available();
            if (available > 0) {
                byte[] bArr = new byte[available];
                this.f16091a = bArr;
                if (inputStream.read(bArr) == available) {
                    this.d = 0;
                    for (int i = 0; i < available; i++) {
                        this.d += this.f16091a[i] & 255;
                    }
                    HexReader hexReader = new HexReader(this.f16091a);
                    int i2 = available - 48;
                    hexReader.setPos(i2);
                    if (hexReader.get(2) == 18244) {
                        hexReader.setPos(i2);
                    } else {
                        int i3 = available - 904;
                        hexReader.setPos(i3);
                        if (hexReader.get(2) == 18244) {
                            this.e = true;
                            this.f = true;
                            hexReader.setPos(available - 784);
                            if (hexReader.get(4) == 1313294675) {
                                this.e = false;
                            }
                            hexReader.setPos(i3);
                        } else {
                            this.c = "Can't find image information data";
                            return false;
                        }
                    }
                    ImgInfo imgInfo = new ImgInfo();
                    this.b = imgInfo;
                    imgInfo.deserialize(hexReader);
                    return true;
                }
                this.c = "Can't load all data from stream";
            } else {
                this.c = "Input size is zero";
            }
        } catch (IOException e) {
            this.c = e.getMessage();
            e.printStackTrace();
        }
        return false;
    }
}
