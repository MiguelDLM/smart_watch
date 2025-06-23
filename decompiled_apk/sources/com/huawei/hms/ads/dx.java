package com.huawei.hms.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes10.dex */
public class dx {
    private static final FloatBuffer B;
    private static final float[] I;
    private static final float[] V;
    private static final FloatBuffer Z;
    private final FloatBuffer C = Z;
    private final FloatBuffer S = B;
    private final int F = 2;
    private final int D = V.length / 2;

    static {
        float[] fArr = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        V = fArr;
        float[] fArr2 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        I = fArr2;
        Z = Code(fArr);
        B = Code(fArr2);
    }

    public int B() {
        return 8;
    }

    public int C() {
        return 2;
    }

    public FloatBuffer Code() {
        return this.C;
    }

    public int I() {
        return this.D;
    }

    public FloatBuffer V() {
        return this.S;
    }

    public int Z() {
        return 8;
    }

    private static FloatBuffer Code(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }
}
