package com.baidu.mshield.b.f;

import java.util.zip.CRC32;

/* loaded from: classes7.dex */
public class c {
    public static long a(String str) {
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }
}
