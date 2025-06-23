package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;

/* loaded from: classes10.dex */
final class DecodedNumeric extends DecodedObject {
    static final int FNC1 = 10;
    private final int firstDigit;
    private final int secondDigit;

    public DecodedNumeric(int i, int i2, int i3) throws FormatException {
        super(i);
        if (i2 >= 0 && i2 <= 10 && i3 >= 0 && i3 <= 10) {
            this.firstDigit = i2;
            this.secondDigit = i3;
            return;
        }
        throw FormatException.getFormatInstance();
    }

    public int getFirstDigit() {
        return this.firstDigit;
    }

    public int getSecondDigit() {
        return this.secondDigit;
    }

    public int getValue() {
        return (this.firstDigit * 10) + this.secondDigit;
    }

    public boolean isAnyFNC1() {
        if (this.firstDigit != 10 && this.secondDigit != 10) {
            return false;
        }
        return true;
    }

    public boolean isFirstDigitFNC1() {
        if (this.firstDigit == 10) {
            return true;
        }
        return false;
    }

    public boolean isSecondDigitFNC1() {
        if (this.secondDigit == 10) {
            return true;
        }
        return false;
    }
}
