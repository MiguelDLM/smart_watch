package com.sma.smartv3.model;

import OXOo.OOXIXo;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class RecordDetailSpeedData {
    private float mFastestSpeed;

    @OOXIXo
    private ArrayList<Integer> mPaceList = new ArrayList<>();

    public final float getMFastestSpeed() {
        return this.mFastestSpeed;
    }

    @OOXIXo
    public final ArrayList<Integer> getMPaceList() {
        return this.mPaceList;
    }

    public final void setMFastestSpeed(float f) {
        this.mFastestSpeed = f;
    }

    public final void setMPaceList(@OOXIXo ArrayList<Integer> arrayList) {
        IIX0o.x0xO0oo(arrayList, "<set-?>");
        this.mPaceList = arrayList;
    }
}
