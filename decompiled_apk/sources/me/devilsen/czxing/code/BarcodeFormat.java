package me.devilsen.czxing.code;

import java.util.HashMap;

/* loaded from: classes6.dex */
public enum BarcodeFormat {
    AZTEC(1),
    CODABAR(2),
    CODE_39(4),
    CODE_93(8),
    CODE_128(16),
    DATA_BAR(32),
    RSS_14(32),
    DATA_BAR_EXPANDED(64),
    RSS_EXPANDED(64),
    DATA_MATRIX(128),
    EAN_8(256),
    EAN_13(512),
    ITF(1024),
    MAXICODE(2048),
    PDF_417(4096),
    QR_CODE(8192),
    UPC_A(16384),
    UPC_E(32768);

    private static final HashMap<Integer, BarcodeFormat> FORMAT_CACHE = new HashMap<>(32);
    private final int value;

    static {
        for (BarcodeFormat barcodeFormat : values()) {
            FORMAT_CACHE.put(Integer.valueOf(barcodeFormat.value), barcodeFormat);
        }
    }

    BarcodeFormat(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static BarcodeFormat valueOf(int i) {
        return FORMAT_CACHE.get(Integer.valueOf(i));
    }
}
