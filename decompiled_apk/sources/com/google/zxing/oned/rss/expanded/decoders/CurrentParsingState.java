package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes10.dex */
final class CurrentParsingState {
    private int position = 0;
    private State encoding = State.NUMERIC;

    /* loaded from: classes10.dex */
    public enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    public int getPosition() {
        return this.position;
    }

    public void incrementPosition(int i) {
        this.position += i;
    }

    public boolean isAlpha() {
        if (this.encoding == State.ALPHA) {
            return true;
        }
        return false;
    }

    public boolean isIsoIec646() {
        if (this.encoding == State.ISO_IEC_646) {
            return true;
        }
        return false;
    }

    public boolean isNumeric() {
        if (this.encoding == State.NUMERIC) {
            return true;
        }
        return false;
    }

    public void setAlpha() {
        this.encoding = State.ALPHA;
    }

    public void setIsoIec646() {
        this.encoding = State.ISO_IEC_646;
    }

    public void setNumeric() {
        this.encoding = State.NUMERIC;
    }

    public void setPosition(int i) {
        this.position = i;
    }
}
