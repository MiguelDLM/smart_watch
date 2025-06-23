package com.iflytek.sparkchain.core.asr;

import java.util.List;

/* loaded from: classes10.dex */
public class Transcription {
    private int index;
    private List<Segment> segments;

    public int getIndex() {
        return this.index;
    }

    public List<Segment> getSegments() {
        return this.segments;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setSegments(List<Segment> list) {
        this.segments = list;
    }
}
