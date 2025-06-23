package Xx000oIo;

import OXOo.OOXIXo;

/* loaded from: classes8.dex */
public final class XO {
    public static final float I0Io(float f) {
        return f * 2.20462f;
    }

    @OOXIXo
    public static final int[] II0XooXoX(float f, int i) {
        if (i == 1) {
            f = I0Io(f);
        }
        return new int[]{(int) f, (int) Math.rint((f % 1) * 10)};
    }

    public static final float II0xO0(int i, int i2) {
        return (i * 30.48f) + (i2 * 2.54f);
    }

    public static final float Oxx0IOOO(int i, int i2, int i3) {
        float f = i + (i2 * 0.1f);
        if (i3 == 1) {
            return X0o0xo(f);
        }
        return f;
    }

    public static final float X0o0xo(float f) {
        return f * 0.4535924f;
    }

    public static final float XO(float f) {
        return f * 1.609334f;
    }

    @OOXIXo
    public static final int[] oIX0oI(float f) {
        return new int[]{(int) (f / 30.48f), oOIx.oxoX.xOoOIoI((f % 30.48f) / 2.54f)};
    }

    public static final float oxoX(float f) {
        return f * 0.6214f;
    }
}
