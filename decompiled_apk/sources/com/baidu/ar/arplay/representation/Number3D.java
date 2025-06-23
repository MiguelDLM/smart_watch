package com.baidu.ar.arplay.representation;

import XIXIX.OOXIXo;
import android.util.Log;

/* loaded from: classes7.dex */
public class Number3D {
    public static final int M00 = 0;
    public static final int M01 = 4;
    public static final int M02 = 8;
    public static final int M03 = 12;
    public static final int M10 = 1;
    public static final int M11 = 5;
    public static final int M12 = 9;
    public static final int M13 = 13;
    public static final int M20 = 2;
    public static final int M21 = 6;
    public static final int M22 = 10;
    public static final int M23 = 14;
    public static final int M30 = 3;
    public static final int M31 = 7;
    public static final int M32 = 11;
    public static final int M33 = 15;
    private static Number3D _temp = new Number3D();
    public float x;
    public float y;
    public float z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ar.arplay.representation.Number3D$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$ar$arplay$representation$Number3D$Axis;

        static {
            int[] iArr = new int[Axis.values().length];
            $SwitchMap$com$baidu$ar$arplay$representation$Number3D$Axis = iArr;
            try {
                iArr[Axis.X.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$ar$arplay$representation$Number3D$Axis[Axis.Y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$ar$arplay$representation$Number3D$Axis[Axis.Z.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public enum Axis {
        X,
        Y,
        Z
    }

    public Number3D() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
    }

    public static Number3D getAxisVector(Axis axis) {
        Number3D number3D = new Number3D();
        int i = AnonymousClass1.$SwitchMap$com$baidu$ar$arplay$representation$Number3D$Axis[axis.ordinal()];
        if (i == 1) {
            number3D.setAll(1.0f, 0.0f, 0.0f);
        } else if (i == 2) {
            number3D.setAll(0.0f, 1.0f, 0.0f);
        } else if (i == 3) {
            number3D.setAll(0.0f, 0.0f, 1.0f);
        }
        return number3D;
    }

    public static Number3D getUpVector() {
        return new Number3D(0.0f, 1.0f, 0.0f);
    }

    public static Number3D lerp(Number3D number3D, Number3D number3D2, float f) {
        Number3D number3D3 = new Number3D();
        float f2 = number3D.x;
        number3D3.x = f2 + ((number3D2.x - f2) * f);
        float f3 = number3D.y;
        number3D3.y = f3 + ((number3D2.y - f3) * f);
        float f4 = number3D.z;
        number3D3.z = f4 + ((number3D2.z - f4) * f);
        return number3D3;
    }

    public Number3D add(float f, float f2, float f3) {
        this.x += f;
        this.y += f2;
        this.z += f3;
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Number3D m45clone() {
        return new Number3D(this.x, this.y, this.z);
    }

    public Number3D cross(Number3D number3D) {
        _temp.setAllFrom(this);
        float f = number3D.y;
        Number3D number3D2 = _temp;
        float f2 = number3D2.z;
        float f3 = number3D.z;
        this.x = (f * f2) - (number3D2.y * f3);
        float f4 = number3D2.x;
        float f5 = number3D.x;
        this.y = (f3 * f4) - (f2 * f5);
        this.z = (f5 * number3D2.y) - (number3D.y * f4);
        return this;
    }

    public float distanceTo(Number3D number3D) {
        float f = this.x;
        float f2 = number3D.x;
        float f3 = (f - f2) * (f - f2);
        float f4 = this.y;
        float f5 = number3D.y;
        float f6 = f3 + ((f4 - f5) * (f4 - f5));
        float f7 = this.z;
        float f8 = number3D.z;
        return (float) Math.sqrt(f6 + ((f7 - f8) * (f7 - f8)));
    }

    public float dot(Number3D number3D) {
        return (this.x * number3D.x) + (this.y * number3D.y) + (this.z * number3D.z);
    }

    public boolean equals(Object obj) {
        Number3D number3D = obj instanceof Number3D ? (Number3D) obj : null;
        return number3D != null && number3D.x == this.x && number3D.y == this.y && number3D.z == this.z;
    }

    public String formatIntToString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((int) this.x);
        stringBuffer.append(", ");
        stringBuffer.append((int) this.y);
        stringBuffer.append(", ");
        stringBuffer.append((int) this.z);
        return stringBuffer.toString();
    }

    public Quaternion getRotationTo(Number3D number3D) {
        Quaternion quaternion = new Quaternion();
        normalize();
        number3D.normalize();
        float dot = dot(this, number3D);
        if (dot >= 1.0f) {
            quaternion.loadIdentityQuat();
        }
        if (dot < -0.999999f) {
            Number3D cross = cross(getAxisVector(Axis.X), this);
            if (cross.length() == 0.0f) {
                cross = cross(getAxisVector(Axis.Y), this);
            }
            cross.normalize();
            quaternion.setAxisAngle(new Vector3f(cross.x, cross.y, cross.z), (float) Math.toDegrees(3.141592653589793d));
        } else {
            double sqrt = Math.sqrt((dot + 1.0f) * 2.0f);
            double d = 1.0d / sqrt;
            Number3D cross2 = cross(this, number3D);
            float[] fArr = quaternion.points;
            fArr[0] = (float) (cross2.x * d);
            fArr[1] = (float) (cross2.y * d);
            fArr[2] = (float) (cross2.z * d);
            fArr[3] = (float) (sqrt * 0.5d);
            quaternion.normalize();
        }
        return quaternion;
    }

    public Number3D inverse() {
        return new Number3D(-this.x, -this.y, -this.z);
    }

    public float length() {
        float f = this.x;
        float f2 = this.y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.z;
        return (float) Math.sqrt(f3 + (f4 * f4));
    }

    public void lerpSelf(Number3D number3D, Number3D number3D2, float f) {
        float f2 = number3D.x;
        this.x = f2 + ((number3D2.x - f2) * f);
        float f3 = number3D.y;
        this.y = f3 + ((number3D2.y - f3) * f);
        float f4 = number3D.z;
        this.z = f4 + ((number3D2.z - f4) * f);
    }

    public Number3D multiply(float f) {
        this.x *= f;
        this.y *= f;
        this.z *= f;
        return this;
    }

    public float normalize() {
        float f = this.x;
        float f2 = this.y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.z;
        double sqrt = Math.sqrt(f3 + (f4 * f4));
        if (sqrt != OOXIXo.f3760XO && sqrt != 1.0d) {
            sqrt = 1.0d / sqrt;
            this.x = (float) (this.x * sqrt);
            this.y = (float) (this.y * sqrt);
            this.z = (float) (this.z * sqrt);
        }
        return (float) sqrt;
    }

    public void project(float[] fArr) {
        if (fArr == null || fArr.length <= 15) {
            return;
        }
        float f = this.x;
        float f2 = fArr[3] * f;
        float f3 = this.y;
        float f4 = f2 + (fArr[7] * f3);
        float f5 = this.z;
        float f6 = f4 + (fArr[11] * f5) + fArr[15];
        setAll(((((fArr[0] * f) + (fArr[4] * f3)) + (fArr[8] * f5)) + fArr[12]) / f6, ((((fArr[1] * f) + (fArr[5] * f3)) + (fArr[9] * f5)) + fArr[13]) / f6, ((((f * fArr[2]) + (f3 * fArr[6])) + (f5 * fArr[10])) + fArr[14]) / f6);
    }

    public void rotateX(float f) {
        double d = f;
        double cos = Math.cos(d);
        double sin = Math.sin(d);
        _temp.setAll(this.x, this.y, this.z);
        float f2 = _temp.z;
        this.y = (float) ((r10.y * cos) - (f2 * sin));
        this.z = (float) ((r10.y * sin) + (f2 * cos));
    }

    public void rotateY(float f) {
        double d = f;
        double cos = Math.cos(d);
        double sin = Math.sin(d);
        _temp.setAll(this.x, this.y, this.z);
        float f2 = _temp.z;
        this.x = (float) ((r10.x * cos) + (f2 * sin));
        this.z = (float) ((r10.x * (-sin)) + (f2 * cos));
    }

    public void rotateZ(float f) {
        double d = f;
        double cos = Math.cos(d);
        double sin = Math.sin(d);
        _temp.setAll(this.x, this.y, this.z);
        float f2 = _temp.y;
        this.x = (float) ((r10.x * cos) - (f2 * sin));
        this.y = (float) ((r10.x * sin) + (f2 * cos));
    }

    public void setAll(double d, double d2, double d3) {
        this.x = (float) d;
        this.y = (float) d2;
        this.z = (float) d3;
    }

    public void setAllFrom(Number3D number3D) {
        this.x = number3D.x;
        this.y = number3D.y;
        this.z = number3D.z;
    }

    public Number3D subtract(Number3D number3D) {
        this.x -= number3D.x;
        this.y -= number3D.y;
        this.z -= number3D.z;
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.x);
        stringBuffer.append(", ");
        stringBuffer.append(this.y);
        stringBuffer.append(", ");
        stringBuffer.append(this.z);
        return stringBuffer.toString();
    }

    public Number3D(double d, double d2, double d3) {
        this.x = (float) d;
        this.y = (float) d2;
        this.z = (float) d3;
    }

    public static Number3D cross(Number3D number3D, Number3D number3D2) {
        float f = number3D2.y;
        float f2 = number3D.z;
        float f3 = number3D2.z;
        float f4 = number3D.y;
        float f5 = number3D.x;
        float f6 = number3D2.x;
        return new Number3D((f * f2) - (f3 * f4), (f3 * f5) - (f2 * f6), (f6 * f4) - (f * f5));
    }

    public static float dot(Number3D number3D, Number3D number3D2) {
        return (number3D.x * number3D2.x) + (number3D.y * number3D2.y) + (number3D.z * number3D2.z);
    }

    public static Number3D multiply(Number3D number3D, float f) {
        return new Number3D(number3D.x * f, number3D.y * f, number3D.z * f);
    }

    public static Number3D subtract(Number3D number3D, Number3D number3D2) {
        return new Number3D(number3D.x - number3D2.x, number3D.y - number3D2.y, number3D.z - number3D2.z);
    }

    public Number3D add(Number3D number3D) {
        this.x += number3D.x;
        this.y += number3D.y;
        this.z += number3D.z;
        return this;
    }

    public void setAll(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public Number3D(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public static Number3D add(Number3D number3D, Number3D number3D2) {
        return new Number3D(number3D.x + number3D2.x, number3D.y + number3D2.y, number3D.z + number3D2.z);
    }

    public static Number3D multiply(Number3D number3D, Number3D number3D2) {
        return new Number3D(number3D.x * number3D2.x, number3D.y * number3D2.y, number3D.z * number3D2.z);
    }

    public Number3D(Number3D number3D) {
        this.x = number3D.x;
        this.y = number3D.y;
        this.z = number3D.z;
    }

    public void multiply(Number3D number3D) {
        this.x *= number3D.x;
        this.y *= number3D.y;
        this.z *= number3D.z;
    }

    public Number3D(String[] strArr) {
        if (strArr.length != 3) {
            Log.e(Number3D.class.getSimpleName(), "Number3D should be initialized with 3 values");
        }
        try {
            this.x = Float.parseFloat(strArr[0]);
            this.y = Float.parseFloat(strArr[1]);
            this.z = Float.parseFloat(strArr[2]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void multiply(float[] fArr) {
        float f = this.x;
        float f2 = this.y;
        float f3 = this.z;
        this.x = (fArr[0] * f) + (fArr[4] * f2) + (fArr[8] * f3) + fArr[12];
        this.y = (fArr[1] * f) + (fArr[5] * f2) + (fArr[9] * f3) + fArr[13];
        this.z = (f * fArr[2]) + (f2 * fArr[6]) + (f3 * fArr[10]) + fArr[14];
    }
}
