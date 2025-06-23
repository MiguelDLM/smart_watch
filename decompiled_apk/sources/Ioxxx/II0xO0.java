package Ioxxx;

import android.animation.TimeInterpolator;
import androidx.annotation.RequiresApi;

@RequiresApi(11)
/* loaded from: classes9.dex */
public class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final float f922oIX0oI = 6.2831855f;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final xxX f905II0xO0 = new OOXIXo();

    /* renamed from: I0Io, reason: collision with root package name */
    public static final xxX f903I0Io = new IIXOooo();

    /* renamed from: oxoX, reason: collision with root package name */
    public static final xxX f926oxoX = new xoXoI();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final xxX f916X0o0xo = new o00();

    /* renamed from: XO, reason: collision with root package name */
    public static final xxX f919XO = new OxI();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final xxX f912Oxx0IOOO = new O0xOxO();

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final xxX f904II0XooXoX = new X0IIOO();

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final xxX f931xxIXOIIO = new XI0IXoo();

    /* renamed from: xoIox, reason: collision with root package name */
    public static final xxX f929xoIox = new XIxXXX0x0();

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final xxX f909OOXIXo = new oIX0oI();

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final xxX f924oOoXoXO = new C0026II0xO0();

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final xxX f925ooOOo0oXI = new I0Io();

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final xxX f927x0XOIxOo = new oxoX();

    /* renamed from: oO, reason: collision with root package name */
    public static final xxX f923oO = new X0o0xo();

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final xxX f928x0xO0oo = new XO();

    /* renamed from: Oo, reason: collision with root package name */
    public static final xxX f910Oo = new Oxx0IOOO();

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final xxX f907IXxxXO = new II0XooXoX();

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final xxX f913Oxx0xo = new xxIXOIIO();

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final xxX f921oI0IIXIo = new xoIox();

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final xxX f914OxxIIOOXO = new oOoXoXO();

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final xxX f906IIXOooo = new ooOOo0oXI();

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final xxX f930xoXoI = new x0XOIxOo();

    /* renamed from: o00, reason: collision with root package name */
    public static final xxX f920o00 = new oO();

    /* renamed from: OxI, reason: collision with root package name */
    public static final xxX f911OxI = new x0xO0oo();

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final xxX f908O0xOxO = new IXxxXO();

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final xxX f915X0IIOO = new Oxx0xo();

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final xxX f917XI0IXoo = new oI0IIXIo();

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final xxX f918XIxXXX0x0 = new OxxIIOOXO();

    /* loaded from: classes9.dex */
    public static class I0Io implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) Math.sin(f * 1.5707963267948966d);
        }
    }

    /* loaded from: classes9.dex */
    public static class II0XooXoX implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return -(((float) Math.sqrt(1.0f - (f * f))) - 1.0f);
        }
    }

    /* renamed from: Ioxxx.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0026II0xO0 implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (-((float) Math.cos(f * 1.5707963267948966d))) + 1.0f;
        }
    }

    /* loaded from: classes9.dex */
    public static class IIXOooo implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f * f;
        }
    }

    /* loaded from: classes9.dex */
    public static class IXxxXO implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f * 2.0f;
            if (f2 < 1.0f) {
                return f2 * f2 * ((3.5949094f * f2) - 2.5949094f) * 0.5f;
            }
            float f3 = f2 - 2.0f;
            return ((f3 * f3 * ((3.5949094f * f3) + 2.5949094f)) + 2.0f) * 0.5f;
        }
    }

    /* loaded from: classes9.dex */
    public static class O0xOxO implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return ((float) Math.pow(f - 1.0f, 3.0d)) + 1.0f;
        }
    }

    /* loaded from: classes9.dex */
    public static class OxI implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) Math.pow(f, 3.0d);
        }
    }

    /* loaded from: classes9.dex */
    public static class Oxx0IOOO implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2;
            if (f == 0.0f) {
                return 0.0f;
            }
            if (f == 1.0f) {
                return 1.0f;
            }
            if (f * 2.0f < 1.0f) {
                f2 = (float) Math.pow(2.0d, (r8 - 1.0f) * 10.0f);
            } else {
                f2 = (-((float) Math.pow(2.0d, (r8 - 1.0f) * (-10.0f)))) + 2.0f;
            }
            return f2 * 0.5f;
        }
    }

    /* loaded from: classes9.dex */
    public static class Oxx0xo implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return 1.0f - II0xO0.f917XI0IXoo.getInterpolation(1.0f - f);
        }
    }

    /* loaded from: classes9.dex */
    public static class OxxIIOOXO implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f < 0.5f) {
                return II0xO0.f915X0IIOO.getInterpolation(f * 2.0f) * 0.5f;
            }
            return (II0xO0.f917XI0IXoo.getInterpolation((f * 2.0f) - 1.0f) * 0.5f) + 0.5f;
        }
    }

    /* loaded from: classes9.dex */
    public static class X0IIOO implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float pow;
            float f2 = f * 2.0f;
            if (f2 < 1.0f) {
                pow = (float) Math.pow(f2, 3.0d);
            } else {
                pow = ((float) Math.pow(f2 - 2.0f, 3.0d)) + 2.0f;
            }
            return pow * 0.5f;
        }
    }

    /* loaded from: classes9.dex */
    public static class X0o0xo implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            return (float) Math.pow(2.0d, (f - 1.0f) * 10.0f);
        }
    }

    /* loaded from: classes9.dex */
    public static class XI0IXoo implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) Math.pow(f, 4.0d);
        }
    }

    /* loaded from: classes9.dex */
    public static class XIxXXX0x0 implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return -(((float) Math.pow(f - 1.0f, 4.0d)) - 1.0f);
        }
    }

    /* loaded from: classes9.dex */
    public static class XO implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f == 1.0f) {
                return 1.0f;
            }
            return -((float) Math.pow(2.0d, (f + 1.0f) * (-10.0f)));
        }
    }

    /* loaded from: classes9.dex */
    public static class o00 implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f * 2.0f;
            if (f2 < 1.0f) {
                return 0.5f * f2 * f2;
            }
            float f3 = f2 - 1.0f;
            return ((f3 * (f3 - 2.0f)) - 1.0f) * (-0.5f);
        }
    }

    /* loaded from: classes9.dex */
    public static class oI0IIXIo implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f < 0.36363637f) {
                return 7.5625f * f * f;
            }
            if (f < 0.72727275f) {
                float f2 = f - 0.54545456f;
                return (7.5625f * f2 * f2) + 0.75f;
            }
            if (f < 0.90909094f) {
                float f3 = f - 0.8181818f;
                return (7.5625f * f3 * f3) + 0.9375f;
            }
            float f4 = f - 0.95454544f;
            return (7.5625f * f4 * f4) + 0.984375f;
        }
    }

    /* loaded from: classes9.dex */
    public static class oIX0oI implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float pow;
            float f2;
            float f3 = f * 2.0f;
            if (f3 < 1.0f) {
                pow = (float) Math.pow(f3, 4.0d);
                f2 = 0.5f;
            } else {
                pow = ((float) Math.pow(f3 - 2.0f, 4.0d)) - 2.0f;
                f2 = -0.5f;
            }
            return pow * f2;
        }
    }

    /* loaded from: classes9.dex */
    public static class oO implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f * f * ((f * 2.70158f) - 1.70158f);
        }
    }

    /* loaded from: classes9.dex */
    public static class oOoXoXO implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            if (f == 1.0f) {
                return 1.0f;
            }
            float f2 = f - 1.0f;
            return -(((float) Math.pow(2.0d, 10.0f * f2)) * ((float) Math.sin(((f2 - (0.047746483f * ((float) Math.asin(1.0d)))) * 6.2831855f) / 0.3f)));
        }
    }

    /* loaded from: classes9.dex */
    public static class ooOOo0oXI implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            if (f == 1.0f) {
                return 1.0f;
            }
            return (((float) Math.pow(2.0d, (-10.0f) * f)) * ((float) Math.sin(((f - (0.047746483f * ((float) Math.asin(1.0d)))) * 6.2831855f) / 0.3f))) + 1.0f;
        }
    }

    /* loaded from: classes9.dex */
    public static class oxoX implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (((float) Math.cos(f * 3.141592653589793d)) - 1.0f) * (-0.5f);
        }
    }

    /* loaded from: classes9.dex */
    public static class x0XOIxOo implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            float f2 = f * 2.0f;
            if (f2 == 2.0f) {
                return 1.0f;
            }
            float asin = ((float) Math.asin(1.0d)) * 0.07161972f;
            if (f2 < 1.0f) {
                float f3 = f2 - 1.0f;
                return ((float) Math.pow(2.0d, 10.0f * f3)) * ((float) Math.sin(((f3 * 1.0f) - asin) * 6.2831855f * 2.2222223f)) * (-0.5f);
            }
            float f4 = f2 - 1.0f;
            return (((float) Math.pow(2.0d, (-10.0f) * f4)) * 0.5f * ((float) Math.sin(((f4 * 1.0f) - asin) * 6.2831855f * 2.2222223f))) + 1.0f;
        }
    }

    /* loaded from: classes9.dex */
    public static class x0xO0oo implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * ((f2 * 2.70158f) + 1.70158f)) + 1.0f;
        }
    }

    /* loaded from: classes9.dex */
    public static class xoIox implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float sqrt;
            float f2;
            float f3 = f * 2.0f;
            if (f3 < 1.0f) {
                sqrt = ((float) Math.sqrt(1.0f - (f3 * f3))) - 1.0f;
                f2 = -0.5f;
            } else {
                float f4 = f3 - 2.0f;
                sqrt = ((float) Math.sqrt(1.0f - (f4 * f4))) + 1.0f;
                f2 = 0.5f;
            }
            return sqrt * f2;
        }
    }

    /* loaded from: classes9.dex */
    public static class xoXoI implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (-f) * (f - 2.0f);
        }
    }

    /* loaded from: classes9.dex */
    public static class xxIXOIIO implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (float) Math.sqrt(1.0f - (f2 * f2));
        }
    }

    /* loaded from: classes9.dex */
    public interface xxX extends TimeInterpolator {
        @Override // android.animation.TimeInterpolator
        float getInterpolation(float f);
    }

    /* loaded from: classes9.dex */
    public static class OOXIXo implements xxX {
        @Override // Ioxxx.II0xO0.xxX, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f;
        }
    }
}
