package com.goodix.ble.gr.libdfu.dfu.entity;

import com.goodix.ble.libcomx.util.HexBuilder;
import com.goodix.ble.libcomx.util.HexReader;

/* loaded from: classes9.dex */
public class ImgInfo {
    public static final int VALID_PATTERN = 18244;
    private static final int e = 2;
    private static final int f = 2;
    private static final int g = 12;

    /* renamed from: a, reason: collision with root package name */
    String f16092a;
    BootInfo b = new BootInfo();
    int c;
    int d;

    public void deserialize(HexReader hexReader) {
        this.d = hexReader.get(2);
        this.c = hexReader.get(2);
        this.b.deserialize(hexReader);
        byte[] bArr = new byte[12];
        hexReader.get(bArr, 0, 12);
        StringBuilder sb = new StringBuilder(12);
        for (int i = 0; i < 12; i++) {
            int i2 = bArr[i] & 255;
            if (i2 != 0 && i2 != 255) {
                sb.append((char) i2);
            }
        }
        this.f16092a = sb.toString();
    }

    public BootInfo getBootInfo() {
        return this.b;
    }

    public String getComment() {
        return this.f16092a;
    }

    public int getPatern() {
        return this.d;
    }

    public int getSerializeSize() {
        return this.b.getSerializeSize() + 16;
    }

    public int getVersion() {
        return this.c;
    }

    public void serialize(HexBuilder hexBuilder) {
        hexBuilder.put(this.d, 2);
        hexBuilder.put(this.c, 2);
        this.b.serialize(hexBuilder);
        for (int i = 0; i < 12; i++) {
            if (i < this.f16092a.length()) {
                hexBuilder.put(this.f16092a.charAt(i), 1);
            } else {
                hexBuilder.put(0, 1);
            }
        }
    }

    public void setBootInfo(BootInfo bootInfo) {
        this.b = bootInfo;
    }

    public void setComment(String str) {
        this.f16092a = str;
    }

    public void setPatern(int i) {
        this.d = i;
    }

    public void setVersion(int i) {
        this.c = i;
    }
}
