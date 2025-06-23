package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message;

import kotlin.text.XIxXXX0x0;

/* loaded from: classes10.dex */
public class ParserCursor {
    private final int lowerBound;
    private int pos;
    private final int upperBound;

    public ParserCursor(int i, int i2) {
        if (i >= 0) {
            if (i <= i2) {
                this.lowerBound = i;
                this.upperBound = i2;
                this.pos = i;
                return;
            }
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        }
        throw new IndexOutOfBoundsException("Lower bound cannot be negative");
    }

    public boolean atEnd() {
        if (this.pos >= this.upperBound) {
            return true;
        }
        return false;
    }

    public int getLowerBound() {
        return this.lowerBound;
    }

    public int getPos() {
        return this.pos;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public String toString() {
        return '[' + Integer.toString(this.lowerBound) + XIxXXX0x0.f29545XO + Integer.toString(this.pos) + XIxXXX0x0.f29545XO + Integer.toString(this.upperBound) + ']';
    }

    public void updatePos(int i) {
        if (i >= this.lowerBound) {
            if (i <= this.upperBound) {
                this.pos = i;
                return;
            }
            throw new IndexOutOfBoundsException("pos: " + i + " > upperBound: " + this.upperBound);
        }
        throw new IndexOutOfBoundsException("pos: " + i + " < lowerBound: " + this.lowerBound);
    }
}
