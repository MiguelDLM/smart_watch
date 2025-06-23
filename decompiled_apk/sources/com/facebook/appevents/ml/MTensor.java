package com.facebook.appevents.ml;

import OXOo.OOXIXo;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class MTensor {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private int capacity;

    @OOXIXo
    private float[] data;

    @OOXIXo
    private int[] shape;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getCapacity(int[] iArr) {
            if (iArr.length != 0) {
                int i = iArr[0];
                int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(iArr);
                int i2 = 1;
                if (1 <= oOIoXOoI) {
                    while (true) {
                        i *= iArr[i2];
                        if (i2 == oOIoXOoI) {
                            break;
                        }
                        i2++;
                    }
                }
                return i;
            }
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }

        private Companion() {
        }
    }

    public MTensor(@OOXIXo int[] shape) {
        IIX0o.x0xO0oo(shape, "shape");
        this.shape = shape;
        int capacity = Companion.getCapacity(shape);
        this.capacity = capacity;
        this.data = new float[capacity];
    }

    @OOXIXo
    public final float[] getData() {
        return this.data;
    }

    public final int getShape(int i) {
        return this.shape[i];
    }

    public final int getShapeSize() {
        return this.shape.length;
    }

    public final void reshape(@OOXIXo int[] shape) {
        IIX0o.x0xO0oo(shape, "shape");
        this.shape = shape;
        int capacity = Companion.getCapacity(shape);
        float[] fArr = new float[capacity];
        System.arraycopy(this.data, 0, fArr, 0, Math.min(this.capacity, capacity));
        this.data = fArr;
        this.capacity = capacity;
    }
}
