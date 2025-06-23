package com.facebook.appevents.ml;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class Operator {

    @OOXIXo
    public static final Operator INSTANCE = new Operator();

    private Operator() {
    }

    @x0XOIxOo
    public static final void addmv(@OOXIXo MTensor x, @OOXIXo MTensor b) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(x, "x");
            IIX0o.x0xO0oo(b, "b");
            int shape = x.getShape(0);
            int shape2 = x.getShape(1);
            int shape3 = x.getShape(2);
            float[] data = x.getData();
            float[] data2 = b.getData();
            if (shape > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (shape2 > 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            if (shape3 > 0) {
                                int i5 = 0;
                                while (true) {
                                    int i6 = i5 + 1;
                                    int i7 = (i * shape2 * shape3) + (i3 * shape3) + i5;
                                    data[i7] = data[i7] + data2[i5];
                                    if (i6 >= shape3) {
                                        break;
                                    } else {
                                        i5 = i6;
                                    }
                                }
                            }
                            if (i4 >= shape2) {
                                break;
                            } else {
                                i3 = i4;
                            }
                        }
                    }
                    if (i2 < shape) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final MTensor concatenate(@OOXIXo MTensor[] tensors) {
        int i;
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(tensors, "tensors");
            int shape = tensors[0].getShape(0);
            int length = tensors.length - 1;
            if (length >= 0) {
                int i2 = 0;
                i = 0;
                while (true) {
                    int i3 = i2 + 1;
                    i += tensors[i2].getShape(1);
                    if (i3 > length) {
                        break;
                    }
                    i2 = i3;
                }
            } else {
                i = 0;
            }
            MTensor mTensor = new MTensor(new int[]{shape, i});
            float[] data = mTensor.getData();
            if (shape > 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    int i6 = i4 * i;
                    int length2 = tensors.length - 1;
                    if (length2 >= 0) {
                        int i7 = 0;
                        while (true) {
                            int i8 = i7 + 1;
                            float[] data2 = tensors[i7].getData();
                            int shape2 = tensors[i7].getShape(1);
                            System.arraycopy(data2, i4 * shape2, data, i6, shape2);
                            i6 += shape2;
                            if (i8 > length2) {
                                break;
                            }
                            i7 = i8;
                        }
                    }
                    if (i5 >= shape) {
                        break;
                    }
                    i4 = i5;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final MTensor conv1D(@OOXIXo MTensor x, @OOXIXo MTensor w) {
        Class<Operator> cls;
        MTensor mTensor;
        Class<Operator> cls2 = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls2)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(x, "x");
            IIX0o.x0xO0oo(w, "w");
            int shape = x.getShape(0);
            int shape2 = x.getShape(1);
            int shape3 = x.getShape(2);
            int shape4 = w.getShape(0);
            int i = (shape2 - shape4) + 1;
            int shape5 = w.getShape(2);
            MTensor mTensor2 = new MTensor(new int[]{shape, i, shape5});
            float[] data = x.getData();
            float[] data2 = mTensor2.getData();
            float[] data3 = w.getData();
            if (shape > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (shape5 > 0) {
                        int i4 = 0;
                        while (true) {
                            int i5 = i4 + 1;
                            if (i > 0) {
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6 + 1;
                                    float f = 0.0f;
                                    if (shape4 > 0) {
                                        int i8 = 0;
                                        while (true) {
                                            cls = cls2;
                                            int i9 = i8 + 1;
                                            if (shape3 > 0) {
                                                int i10 = 0;
                                                while (true) {
                                                    mTensor = mTensor2;
                                                    int i11 = i10 + 1;
                                                    try {
                                                        f += data[(shape2 * shape3 * i2) + ((i8 + i6) * shape3) + i10] * data3[(((i8 * shape3) + i10) * shape5) + i4];
                                                        if (i11 >= shape3) {
                                                            break;
                                                        }
                                                        i10 = i11;
                                                        mTensor2 = mTensor;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        CrashShieldHandler.handleThrowable(th, cls);
                                                        return null;
                                                    }
                                                }
                                            } else {
                                                mTensor = mTensor2;
                                            }
                                            if (i9 >= shape4) {
                                                break;
                                            }
                                            i8 = i9;
                                            cls2 = cls;
                                            mTensor2 = mTensor;
                                        }
                                    } else {
                                        cls = cls2;
                                        mTensor = mTensor2;
                                    }
                                    data2[(i * shape5 * i2) + (i6 * shape5) + i4] = f;
                                    if (i7 >= i) {
                                        break;
                                    }
                                    i6 = i7;
                                    cls2 = cls;
                                    mTensor2 = mTensor;
                                }
                            } else {
                                cls = cls2;
                                mTensor = mTensor2;
                            }
                            if (i5 >= shape5) {
                                break;
                            }
                            i4 = i5;
                            cls2 = cls;
                            mTensor2 = mTensor;
                        }
                    } else {
                        cls = cls2;
                        mTensor = mTensor2;
                    }
                    if (i3 < shape) {
                        i2 = i3;
                        cls2 = cls;
                        mTensor2 = mTensor;
                    } else {
                        return mTensor;
                    }
                }
            } else {
                return mTensor2;
            }
        } catch (Throwable th2) {
            th = th2;
            cls = cls2;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final MTensor dense(@OOXIXo MTensor x, @OOXIXo MTensor w, @OOXIXo MTensor b) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(x, "x");
            IIX0o.x0xO0oo(w, "w");
            IIX0o.x0xO0oo(b, "b");
            int shape = x.getShape(0);
            int shape2 = b.getShape(0);
            MTensor mul = mul(x, w);
            float[] data = b.getData();
            float[] data2 = mul.getData();
            if (shape > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (shape2 > 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            int i5 = (i * shape2) + i3;
                            data2[i5] = data2[i5] + data[i3];
                            if (i4 >= shape2) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                    if (i2 >= shape) {
                        break;
                    }
                    i = i2;
                }
            }
            return mul;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final MTensor embedding(@OOXIXo String[] texts, int i, @OOXIXo MTensor w) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(texts, "texts");
            IIX0o.x0xO0oo(w, "w");
            int length = texts.length;
            int shape = w.getShape(1);
            MTensor mTensor = new MTensor(new int[]{length, i, shape});
            float[] data = mTensor.getData();
            float[] data2 = w.getData();
            if (length > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    int[] vectorize = Utils.INSTANCE.vectorize(texts[i2], i);
                    if (i > 0) {
                        int i4 = 0;
                        while (true) {
                            int i5 = i4 + 1;
                            System.arraycopy(data2, vectorize[i4] * shape, data, (shape * i * i2) + (i4 * shape), shape);
                            if (i5 >= i) {
                                break;
                            }
                            i4 = i5;
                        }
                    }
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    @x0XOIxOo
    public static final void flatten(@OOXIXo MTensor x, int i) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(x, "x");
            if (i >= x.getShapeSize()) {
                return;
            }
            int shapeSize = x.getShapeSize();
            int i2 = 1;
            if (i < shapeSize) {
                int i3 = i;
                while (true) {
                    int i4 = i3 + 1;
                    i2 *= x.getShape(i3);
                    if (i4 >= shapeSize) {
                        break;
                    } else {
                        i3 = i4;
                    }
                }
            }
            int[] iArr = new int[i + 1];
            if (i > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    iArr[i5] = x.getShape(i5);
                    if (i6 >= i) {
                        break;
                    } else {
                        i5 = i6;
                    }
                }
            }
            iArr[i] = i2;
            x.reshape(iArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final MTensor maxPool1D(@OOXIXo MTensor x, int i) {
        int i2;
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(x, "x");
            int shape = x.getShape(0);
            int shape2 = x.getShape(1);
            int shape3 = x.getShape(2);
            int i3 = (shape2 - i) + 1;
            MTensor mTensor = new MTensor(new int[]{shape, i3, shape3});
            float[] data = x.getData();
            float[] data2 = mTensor.getData();
            if (shape > 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (shape3 > 0) {
                        int i6 = 0;
                        while (true) {
                            int i7 = i6 + 1;
                            if (i3 > 0) {
                                int i8 = 0;
                                while (true) {
                                    int i9 = i8 + 1;
                                    int i10 = i8 * shape3;
                                    int i11 = (i4 * i3 * shape3) + i10 + i6;
                                    int i12 = (i4 * shape2 * shape3) + i10 + i6;
                                    data2[i11] = Float.MIN_VALUE;
                                    if (i > 0) {
                                        int i13 = 0;
                                        while (true) {
                                            int i14 = i13 + 1;
                                            i2 = shape2;
                                            data2[i11] = Math.max(data2[i11], data[i12 + (i13 * shape3)]);
                                            if (i14 >= i) {
                                                break;
                                            }
                                            i13 = i14;
                                            shape2 = i2;
                                        }
                                    } else {
                                        i2 = shape2;
                                    }
                                    if (i9 >= i3) {
                                        break;
                                    }
                                    i8 = i9;
                                    shape2 = i2;
                                }
                            } else {
                                i2 = shape2;
                            }
                            if (i7 >= shape3) {
                                break;
                            }
                            i6 = i7;
                            shape2 = i2;
                        }
                    } else {
                        i2 = shape2;
                    }
                    if (i5 >= shape) {
                        break;
                    }
                    i4 = i5;
                    shape2 = i2;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final MTensor mul(@OOXIXo MTensor x, @OOXIXo MTensor w) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(x, "x");
            IIX0o.x0xO0oo(w, "w");
            int shape = x.getShape(0);
            int shape2 = w.getShape(0);
            int shape3 = w.getShape(1);
            MTensor mTensor = new MTensor(new int[]{shape, shape3});
            float[] data = x.getData();
            float[] data2 = w.getData();
            float[] data3 = mTensor.getData();
            if (shape > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (shape3 > 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            int i5 = (i * shape3) + i3;
                            data3[i5] = 0.0f;
                            if (shape2 > 0) {
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6 + 1;
                                    data3[i5] = data3[i5] + (data[(i * shape2) + i6] * data2[(i6 * shape3) + i3]);
                                    if (i7 >= shape2) {
                                        break;
                                    }
                                    i6 = i7;
                                }
                            }
                            if (i4 >= shape3) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                    if (i2 >= shape) {
                        break;
                    }
                    i = i2;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    @x0XOIxOo
    public static final void relu(@OOXIXo MTensor x) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(x, "x");
            float[] data = x.getData();
            int length = data.length - 1;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (data[i] < 0.0f) {
                        data[i] = 0.0f;
                    }
                    if (i2 <= length) {
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    @x0XOIxOo
    public static final void softmax(@OOXIXo MTensor x) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(x, "x");
            int i = 0;
            int shape = x.getShape(0);
            int shape2 = x.getShape(1);
            float[] data = x.getData();
            if (shape <= 0) {
                return;
            }
            while (true) {
                int i2 = i + 1;
                int i3 = i * shape2;
                int i4 = i3 + shape2;
                float f = Float.MIN_VALUE;
                if (i3 < i4) {
                    int i5 = i3;
                    while (true) {
                        int i6 = i5 + 1;
                        float f2 = data[i5];
                        if (f2 > f) {
                            f = f2;
                        }
                        if (i6 >= i4) {
                            break;
                        } else {
                            i5 = i6;
                        }
                    }
                }
                float f3 = 0.0f;
                if (i3 < i4) {
                    int i7 = i3;
                    while (true) {
                        int i8 = i7 + 1;
                        float exp = (float) Math.exp(data[i7] - f);
                        data[i7] = exp;
                        f3 += exp;
                        if (i8 >= i4) {
                            break;
                        } else {
                            i7 = i8;
                        }
                    }
                }
                if (i3 < i4) {
                    while (true) {
                        int i9 = i3 + 1;
                        data[i3] = data[i3] / f3;
                        if (i9 >= i4) {
                            break;
                        } else {
                            i3 = i9;
                        }
                    }
                }
                if (i2 < shape) {
                    i = i2;
                } else {
                    return;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final MTensor transpose2D(@OOXIXo MTensor x) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(x, "x");
            int shape = x.getShape(0);
            int shape2 = x.getShape(1);
            MTensor mTensor = new MTensor(new int[]{shape2, shape});
            float[] data = x.getData();
            float[] data2 = mTensor.getData();
            if (shape > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (shape2 > 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            data2[(i3 * shape) + i] = data[(i * shape2) + i3];
                            if (i4 >= shape2) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                    if (i2 >= shape) {
                        break;
                    }
                    i = i2;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final MTensor transpose3D(@OOXIXo MTensor x) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(x, "x");
            int shape = x.getShape(0);
            int shape2 = x.getShape(1);
            int shape3 = x.getShape(2);
            MTensor mTensor = new MTensor(new int[]{shape3, shape2, shape});
            float[] data = x.getData();
            float[] data2 = mTensor.getData();
            if (shape > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (shape2 > 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            if (shape3 > 0) {
                                int i5 = 0;
                                while (true) {
                                    int i6 = i5 + 1;
                                    data2[(i5 * shape * shape2) + (i3 * shape) + i] = data[(i * shape2 * shape3) + (i3 * shape3) + i5];
                                    if (i6 >= shape3) {
                                        break;
                                    }
                                    i5 = i6;
                                }
                            }
                            if (i4 >= shape2) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                    if (i2 >= shape) {
                        break;
                    }
                    i = i2;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }
}
