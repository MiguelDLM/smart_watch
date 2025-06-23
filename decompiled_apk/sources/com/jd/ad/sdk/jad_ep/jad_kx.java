package com.jd.ad.sdk.jad_ep;

import com.jd.ad.sdk.jad_ep.jad_kx;

/* loaded from: classes10.dex */
public abstract class jad_kx<CHILD extends jad_kx<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    public Object clone() {
        try {
            return (jad_kx) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final CHILD jad_an() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
