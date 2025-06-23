package com.szabh.smable3.component;

import OXOo.OOXIXo;

/* loaded from: classes13.dex */
public final class QrcodeStreamType {

    @OOXIXo
    public static final QrcodeStreamType INSTANCE = new QrcodeStreamType();
    public static final int MY_CARD_CODE = 2;
    public static final int NUCLEIC_ACID_CODE = 0;
    public static final int QRCODE_CODE = 3;
    public static final int RECEIPT_CODE = 1;

    private QrcodeStreamType() {
    }

    public final int getStreamType(boolean z, int i) {
        return z ? i | 128 : i;
    }
}
