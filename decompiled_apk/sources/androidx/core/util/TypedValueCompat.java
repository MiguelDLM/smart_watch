package androidx.core.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class TypedValueCompat {
    private static final float INCHES_PER_MM = 0.03937008f;
    private static final float INCHES_PER_PT = 0.013888889f;

    @RequiresApi(34)
    /* loaded from: classes.dex */
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static float deriveDimension(int i, float f, DisplayMetrics displayMetrics) {
            return TypedValue.deriveDimension(i, f, displayMetrics);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface ComplexDimensionUnit {
    }

    private TypedValueCompat() {
    }

    public static float deriveDimension(int i, float f, @NonNull DisplayMetrics displayMetrics) {
        float f2;
        float f3;
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.deriveDimension(i, f, displayMetrics);
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                float f4 = displayMetrics.xdpi;
                                if (f4 == 0.0f) {
                                    return 0.0f;
                                }
                                f2 = f / f4;
                                f3 = INCHES_PER_MM;
                            } else {
                                throw new IllegalArgumentException("Invalid unitToConvertTo " + i);
                            }
                        } else {
                            float f5 = displayMetrics.xdpi;
                            if (f5 == 0.0f) {
                                return 0.0f;
                            }
                            return f / f5;
                        }
                    } else {
                        float f6 = displayMetrics.xdpi;
                        if (f6 == 0.0f) {
                            return 0.0f;
                        }
                        f2 = f / f6;
                        f3 = INCHES_PER_PT;
                    }
                    return f2 / f3;
                }
                float f7 = displayMetrics.scaledDensity;
                if (f7 == 0.0f) {
                    return 0.0f;
                }
                return f / f7;
            }
            float f8 = displayMetrics.density;
            if (f8 == 0.0f) {
                return 0.0f;
            }
            return f / f8;
        }
        return f;
    }

    public static float dpToPx(float f, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, f, displayMetrics);
    }

    @SuppressLint({"WrongConstant"})
    public static int getUnitFromComplexDimension(int i) {
        return i & 15;
    }

    public static float pxToDp(float f, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(1, f, displayMetrics);
    }

    public static float pxToSp(float f, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(2, f, displayMetrics);
    }

    public static float spToPx(float f, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(2, f, displayMetrics);
    }
}
