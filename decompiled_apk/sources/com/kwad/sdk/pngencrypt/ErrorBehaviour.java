package com.kwad.sdk.pngencrypt;

/* loaded from: classes11.dex */
public enum ErrorBehaviour {
    STRICT(0),
    LENIENT1_CRC(1),
    LENIENT2_ANCILLARY(3),
    SUPER_LENIENT(5);

    final int c;

    ErrorBehaviour(int i) {
        this.c = i;
    }
}
