package com.baidu.ar;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.Matrix;
import com.baidu.ar.arplay.core.engine.rotate.Orientation;
import com.baidu.ar.arplay.core.pixel.PixelRotation;
import com.baidu.ar.arplay.core.renderer.OutputFillMode;
import com.baidu.ar.bean.MirriorType;
import com.baidu.ar.bean.RotationType;
import com.baidu.ar.bean.ScaleType;
import com.baidu.ar.bean.Size;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class ba {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ar.ba$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation;
        static final /* synthetic */ int[] iS;
        static final /* synthetic */ int[] iT;

        static {
            int[] iArr = new int[ScaleType.values().length];
            iT = iArr;
            try {
                iArr[ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iT[ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iT[ScaleType.FIT_XY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Orientation.values().length];
            $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation = iArr2;
            try {
                iArr2[Orientation.PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[Orientation.LANDSCAPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[Orientation.LANDSCAPE_REVERSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[RotationType.values().length];
            iS = iArr3;
            try {
                iArr3[RotationType.ROTATE_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iS[RotationType.ROTATE_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iS[RotationType.ROTATE_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iS[RotationType.ROTATE_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static PixelRotation a(RotationType rotationType, MirriorType mirriorType) {
        PixelRotation pixelRotation = PixelRotation.NoRotation;
        int i = AnonymousClass1.iS[rotationType.ordinal()];
        if (i == 1) {
            if (mirriorType == MirriorType.NO_MIRRIOR) {
                return pixelRotation;
            }
            if (mirriorType != MirriorType.VERTICAL_MIRRIOR) {
                if (mirriorType != MirriorType.HORIZONTAL_MIRRIOR) {
                    return pixelRotation;
                }
                return PixelRotation.FlipHorizontal;
            }
            return PixelRotation.FlipVertical;
        }
        if (i == 2) {
            if (mirriorType == MirriorType.NO_MIRRIOR) {
                return PixelRotation.RotateRight;
            }
            if (mirriorType != MirriorType.VERTICAL_MIRRIOR) {
                if (mirriorType != MirriorType.HORIZONTAL_MIRRIOR) {
                    return pixelRotation;
                }
                return PixelRotation.RotateRightFlipHorizontal;
            }
            return PixelRotation.RotateRightFlipVertical;
        }
        if (i == 3) {
            if (mirriorType == MirriorType.NO_MIRRIOR) {
                return PixelRotation.Rotate180;
            }
            if (mirriorType != MirriorType.VERTICAL_MIRRIOR) {
                if (mirriorType != MirriorType.HORIZONTAL_MIRRIOR) {
                    return pixelRotation;
                }
                return PixelRotation.FlipVertical;
            }
            return PixelRotation.FlipHorizontal;
        }
        if (i != 4) {
            return pixelRotation;
        }
        if (mirriorType == MirriorType.NO_MIRRIOR) {
            return PixelRotation.RotateLeft;
        }
        if (mirriorType != MirriorType.VERTICAL_MIRRIOR) {
            if (mirriorType != MirriorType.HORIZONTAL_MIRRIOR) {
                return pixelRotation;
            }
            return PixelRotation.RotateRightFlipVertical;
        }
        return PixelRotation.RotateRightFlipHorizontal;
    }

    public static Size b(int i, int i2, int i3, int i4) {
        Size size = new Size(i, i2);
        if (i > 0 && i2 > 0 && i3 > 0 && i4 > 0) {
            float f = i;
            float f2 = i2;
            float f3 = f / f2;
            float f4 = i3 / i4;
            if (f3 < f4) {
                size.setWidth((int) (f2 * f4));
                size.setHeight(i2);
            } else if (f3 > f4) {
                size.setWidth(i);
                size.setHeight((int) (f / f4));
            }
        }
        return size;
    }

    public static PixelRotation a(boolean z, RotationType rotationType, MirriorType mirriorType) {
        return z ? PixelRotation.FlipVertical : a(rotationType, mirriorType);
    }

    public static OutputFillMode a(ScaleType scaleType) {
        int i = AnonymousClass1.iT[scaleType.ordinal()];
        if (i == 1) {
            return OutputFillMode.KeepRatioCrop;
        }
        if (i == 2 || i == 3) {
            return OutputFillMode.KeepRatioFill;
        }
        return null;
    }

    public static Size a(int i, int i2, int i3, int i4) {
        Size size = new Size(i, i2);
        if (i > 0 && i2 > 0 && i3 > 0 && i4 > 0) {
            float f = i;
            float f2 = i2;
            float f3 = f / f2;
            float f4 = i3 / i4;
            if (f3 > f4) {
                size.setWidth((int) (f2 * f4));
                size.setHeight(i2);
            } else if (f3 < f4) {
                size.setWidth(i);
                size.setHeight((int) (f / f4));
            }
        }
        return size;
    }

    public static HashMap a(Orientation orientation) {
        String str;
        HashMap hashMap = new HashMap();
        int i = AnonymousClass1.$SwitchMap$com$baidu$ar$arplay$core$engine$rotate$Orientation[orientation.ordinal()];
        if (i != 1) {
            if (i != 2) {
                str = i == 3 ? "landscape_left" : "landscape_right";
            }
            hashMap.put("orient", str);
            return hashMap;
        }
        hashMap.put("orient", "portrait");
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
    
        if (r2 != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
    
        r1 = com.baidu.ar.arplay.core.pixel.PixelRotation.Rotate180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        r1 = com.baidu.ar.arplay.core.pixel.PixelRotation.NoRotation;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
    
        if (r2 != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r1, boolean r2, com.baidu.ar.arplay.core.pixel.PixelReadParams r3) {
        /*
            boolean r0 = com.baidu.ar.ku.isNexus6P()
            if (r0 == 0) goto L1f
            boolean r1 = r3.getIsPortrait()
            if (r1 == 0) goto L17
            if (r2 == 0) goto L14
        Le:
            com.baidu.ar.arplay.core.pixel.PixelRotation r1 = com.baidu.ar.arplay.core.pixel.PixelRotation.RotateRightFlipVertical
        L10:
            r3.setPixelRotate(r1)
            goto L45
        L14:
            com.baidu.ar.arplay.core.pixel.PixelRotation r1 = com.baidu.ar.arplay.core.pixel.PixelRotation.RotateRight
            goto L10
        L17:
            if (r2 == 0) goto L1c
        L19:
            com.baidu.ar.arplay.core.pixel.PixelRotation r1 = com.baidu.ar.arplay.core.pixel.PixelRotation.Rotate180
            goto L10
        L1c:
            com.baidu.ar.arplay.core.pixel.PixelRotation r1 = com.baidu.ar.arplay.core.pixel.PixelRotation.NoRotation
            goto L10
        L1f:
            boolean r0 = com.baidu.ar.ku.hk()
            if (r0 == 0) goto L36
            boolean r1 = r3.getIsPortrait()
            if (r1 == 0) goto L33
            if (r2 == 0) goto L30
            com.baidu.ar.arplay.core.pixel.PixelRotation r1 = com.baidu.ar.arplay.core.pixel.PixelRotation.RotateRightFlipHorizontal
            goto L10
        L30:
            com.baidu.ar.arplay.core.pixel.PixelRotation r1 = com.baidu.ar.arplay.core.pixel.PixelRotation.RotateLeft
            goto L10
        L33:
            if (r2 == 0) goto L19
            goto L1c
        L36:
            boolean r1 = com.baidu.ar.ku.x(r1)
            if (r1 == 0) goto L45
            boolean r1 = r3.getIsPortrait()
            if (r1 == 0) goto L45
            if (r2 == 0) goto L45
            goto Le
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.ba.a(android.content.Context, boolean, com.baidu.ar.arplay.core.pixel.PixelReadParams):void");
    }

    public static void a(Context context, float[] fArr, boolean z) {
        Matrix.setIdentityM(fArr, 0);
        if (ku.isNexus6P() || ku.x(context)) {
            Matrix.rotateM(fArr, 0, 90.0f, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr, 0, 0.0f, -1.0f, 0.0f);
            if (z) {
                return;
            } else {
                Matrix.rotateM(fArr, 0, 180.0f, 0.0f, 1.0f, 0.0f);
            }
        } else if (ku.hk()) {
            Matrix.rotateM(fArr, 0, 270.0f, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr, 0, -1.0f, 0.0f, 0.0f);
            if (z) {
                return;
            } else {
                Matrix.rotateM(fArr, 0, 180.0f, 0.0f, 1.0f, 0.0f);
            }
        } else if (z) {
            Matrix.rotateM(fArr, 0, 270.0f, 0.0f, 0.0f, 1.0f);
        } else {
            Matrix.rotateM(fArr, 0, 90.0f, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr, 0, 0.0f, -1.0f, 0.0f);
            Matrix.rotateM(fArr, 0, 180.0f, 0.0f, 1.0f, 0.0f);
        }
        Matrix.translateM(fArr, 0, -1.0f, 0.0f, 0.0f);
    }

    public static void a(PointF pointF, boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput, boolean z2) {
        float inputWidth;
        int inputHeight;
        float outputWidth;
        int outputHeight;
        if (pointF == null || duMixInput == null || duMixOutput == null || duMixOutput.getScaleType() == ScaleType.FIT_XY) {
            return;
        }
        if (z) {
            inputWidth = duMixInput.getInputHeight();
            inputHeight = duMixInput.getInputWidth();
        } else {
            inputWidth = duMixInput.getInputWidth();
            inputHeight = duMixInput.getInputHeight();
        }
        float f = inputWidth / inputHeight;
        if (z2) {
            outputWidth = duMixOutput.getOutputHeight();
            outputHeight = duMixOutput.getOutputWidth();
        } else {
            outputWidth = duMixOutput.getOutputWidth();
            outputHeight = duMixOutput.getOutputHeight();
        }
        float f2 = outputWidth / outputHeight;
        if (f == f2) {
            return;
        }
        float f3 = pointF.x;
        float f4 = pointF.y;
        if (f < f2) {
            if (AnonymousClass1.iT[duMixOutput.getScaleType().ordinal()] == 1) {
                float f5 = 1.0f / f2;
                f4 = ((((f4 * 2.0f) - 1.0f) * (1.0f / f)) + f5) / (f5 * 2.0f);
            }
        } else if (AnonymousClass1.iT[duMixOutput.getScaleType().ordinal()] == 1) {
            f3 = ((((f3 * 2.0f) - 1.0f) * f) + f2) / (f2 * 2.0f);
        }
        pointF.set(f3, f4);
    }
}
