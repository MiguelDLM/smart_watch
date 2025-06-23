package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes10.dex */
final class DecodedChar extends DecodedObject {
    static final char FNC1 = '$';
    private final char value;

    public DecodedChar(int i, char c) {
        super(i);
        this.value = c;
    }

    public char getValue() {
        return this.value;
    }

    public boolean isFNC1() {
        if (this.value == '$') {
            return true;
        }
        return false;
    }
}
