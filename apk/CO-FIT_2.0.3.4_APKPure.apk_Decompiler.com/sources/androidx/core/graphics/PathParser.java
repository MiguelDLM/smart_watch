package androidx.core.graphics;

import XIXIX.OOXIXo;
import android.graphics.Path;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

public final class PathParser {
    private static final String LOGTAG = "PathParser";

    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArr) {
        arrayList.add(new PathDataNode(c, fArr));
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            if (pathDataNodeArr[i].mType != pathDataNodeArr2[i].mType || pathDataNodeArr[i].mParams.length != pathDataNodeArr2[i].mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i <= i2) {
            int length = fArr.length;
            if (i < 0 || i > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            float[] fArr2 = new float[i3];
            System.arraycopy(fArr, i, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static PathDataNode[] createNodesFromPathData(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int nextStart = nextStart(str, i);
            String trim = str.substring(i2, nextStart).trim();
            if (!trim.isEmpty()) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i2 = nextStart;
            i = nextStart + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            addNode(arrayList, str.charAt(i2), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[0]);
    }

    @NonNull
    public static Path createPathFromPathData(@NonNull String str) {
        Path path = new Path();
        try {
            PathDataNode.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing " + str, e);
        }
    }

    @NonNull
    public static PathDataNode[] deepCopyNodes(@NonNull PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        r2 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039 A[LOOP:0: B:1:0x0007->B:20:0x0039, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void extract(java.lang.String r8, int r9, androidx.core.graphics.PathParser.ExtractFloatResult r10) {
        /*
            r0 = 0
            r10.mEndWithNegOrDot = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0007:
            int r5 = r8.length()
            if (r1 >= r5) goto L_0x003c
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L_0x0029
            r6 = 69
            if (r5 == r6) goto L_0x0035
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L_0x0035
            switch(r5) {
                case 44: goto L_0x0029;
                case 45: goto L_0x002c;
                case 46: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x0033
        L_0x0022:
            if (r3 != 0) goto L_0x0027
            r2 = 0
            r3 = 1
            goto L_0x0036
        L_0x0027:
            r10.mEndWithNegOrDot = r7
        L_0x0029:
            r2 = 0
            r4 = 1
            goto L_0x0036
        L_0x002c:
            if (r1 == r9) goto L_0x0033
            if (r2 != 0) goto L_0x0033
            r10.mEndWithNegOrDot = r7
            goto L_0x0029
        L_0x0033:
            r2 = 0
            goto L_0x0036
        L_0x0035:
            r2 = 1
        L_0x0036:
            if (r4 == 0) goto L_0x0039
            goto L_0x003c
        L_0x0039:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x003c:
            r10.mEndPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.extract(java.lang.String, int, androidx.core.graphics.PathParser$ExtractFloatResult):void");
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                extract(str, i, extractFloatResult);
                int i3 = extractFloatResult.mEndPosition;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                if (extractFloatResult.mEndWithNegOrDot) {
                    i = i3;
                } else {
                    i = i3 + 1;
                }
            }
            return copyOfRange(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    public static void interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, float f, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3) {
        if (!interpolatePathDataNodes(pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, f)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
        float[] fArr = new float[6];
        char c = 'm';
        for (PathDataNode pathDataNode : pathDataNodeArr) {
            PathDataNode.addCommand(path, fArr, c, pathDataNode.mType, pathDataNode.mParams);
            c = pathDataNode.mType;
        }
    }

    public static void updateNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            char unused = pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            for (int i2 = 0; i2 < pathDataNodeArr2[i].mParams.length; i2++) {
                pathDataNodeArr[i].mParams[i2] = pathDataNodeArr2[i].mParams[i2];
            }
        }
    }

    public static class PathDataNode {
        /* access modifiers changed from: private */
        public final float[] mParams;
        /* access modifiers changed from: private */
        public char mType;

        public PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        /* access modifiers changed from: private */
        public static void addCommand(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            boolean z;
            boolean z2;
            float f;
            float f2;
            boolean z3;
            boolean z4;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            Path path2 = path;
            char c3 = c2;
            float[] fArr3 = fArr2;
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[2];
            float f14 = fArr[3];
            float f15 = fArr[4];
            float f16 = fArr[5];
            switch (c3) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path2.moveTo(f15, f16);
                    f11 = f15;
                    f13 = f11;
                    f12 = f16;
                    f14 = f12;
                    break;
            }
            i = 2;
            float f17 = f11;
            float f18 = f12;
            float f19 = f15;
            float f20 = f16;
            int i3 = 0;
            char c4 = c;
            while (i3 < fArr3.length) {
                if (c3 != 'A') {
                    if (c3 == 'C') {
                        i2 = i3;
                        int i4 = i2 + 2;
                        int i5 = i2 + 3;
                        int i6 = i2 + 4;
                        int i7 = i2 + 5;
                        Path path3 = path;
                        path3.cubicTo(fArr3[i2], fArr3[i2 + 1], fArr3[i4], fArr3[i5], fArr3[i6], fArr3[i7]);
                        f17 = fArr3[i6];
                        float f21 = fArr3[i7];
                        float f22 = fArr3[i4];
                        float f23 = fArr3[i5];
                        f18 = f21;
                        f14 = f23;
                        f13 = f22;
                    } else if (c3 == 'H') {
                        i2 = i3;
                        path2.lineTo(fArr3[i2], f18);
                        f17 = fArr3[i2];
                    } else if (c3 == 'Q') {
                        i2 = i3;
                        int i8 = i2 + 1;
                        int i9 = i2 + 2;
                        int i10 = i2 + 3;
                        path2.quadTo(fArr3[i2], fArr3[i8], fArr3[i9], fArr3[i10]);
                        float f24 = fArr3[i2];
                        float f25 = fArr3[i8];
                        f17 = fArr3[i9];
                        f18 = fArr3[i10];
                        f13 = f24;
                        f14 = f25;
                    } else if (c3 == 'V') {
                        i2 = i3;
                        path2.lineTo(f17, fArr3[i2]);
                        f18 = fArr3[i2];
                    } else if (c3 != 'a') {
                        if (c3 == 'c') {
                            int i11 = i3 + 2;
                            int i12 = i3 + 3;
                            int i13 = i3 + 4;
                            int i14 = i3 + 5;
                            path.rCubicTo(fArr3[i3], fArr3[i3 + 1], fArr3[i11], fArr3[i12], fArr3[i13], fArr3[i14]);
                            f3 = fArr3[i11] + f17;
                            f4 = fArr3[i12] + f18;
                            f17 += fArr3[i13];
                            f5 = fArr3[i14];
                            f18 += f5;
                            f13 = f3;
                            f14 = f4;
                        } else if (c3 != 'h') {
                            if (c3 != 'q') {
                                if (c3 == 'v') {
                                    path2.rLineTo(0.0f, fArr3[i3]);
                                    f6 = fArr3[i3];
                                } else if (c3 != 'L') {
                                    if (c3 == 'M') {
                                        f17 = fArr3[i3];
                                        f18 = fArr3[i3 + 1];
                                        if (i3 > 0) {
                                            path2.lineTo(f17, f18);
                                        } else {
                                            path2.moveTo(f17, f18);
                                        }
                                    } else if (c3 == 'S') {
                                        if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                            f17 = (f17 * 2.0f) - f13;
                                            f18 = (f18 * 2.0f) - f14;
                                        }
                                        float f26 = f18;
                                        float f27 = f17;
                                        int i15 = i3 + 1;
                                        int i16 = i3 + 2;
                                        int i17 = i3 + 3;
                                        path.cubicTo(f27, f26, fArr3[i3], fArr3[i15], fArr3[i16], fArr3[i17]);
                                        f3 = fArr3[i3];
                                        f4 = fArr3[i15];
                                        f17 = fArr3[i16];
                                        f18 = fArr3[i17];
                                        f13 = f3;
                                        f14 = f4;
                                    } else if (c3 == 'T') {
                                        if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                            f17 = (f17 * 2.0f) - f13;
                                            f18 = (f18 * 2.0f) - f14;
                                        }
                                        int i18 = i3 + 1;
                                        path2.quadTo(f17, f18, fArr3[i3], fArr3[i18]);
                                        i2 = i3;
                                        f14 = f18;
                                        f13 = f17;
                                        f17 = fArr3[i3];
                                        f18 = fArr3[i18];
                                    } else if (c3 == 'l') {
                                        int i19 = i3 + 1;
                                        path2.rLineTo(fArr3[i3], fArr3[i19]);
                                        f17 += fArr3[i3];
                                        f6 = fArr3[i19];
                                    } else if (c3 == 'm') {
                                        float f28 = fArr3[i3];
                                        f17 += f28;
                                        float f29 = fArr3[i3 + 1];
                                        f18 += f29;
                                        if (i3 > 0) {
                                            path2.rLineTo(f28, f29);
                                        } else {
                                            path2.rMoveTo(f28, f29);
                                        }
                                    } else if (c3 == 's') {
                                        if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                            float f30 = f17 - f13;
                                            f7 = f18 - f14;
                                            f8 = f30;
                                        } else {
                                            f8 = 0.0f;
                                            f7 = 0.0f;
                                        }
                                        int i20 = i3 + 1;
                                        int i21 = i3 + 2;
                                        int i22 = i3 + 3;
                                        path.rCubicTo(f8, f7, fArr3[i3], fArr3[i20], fArr3[i21], fArr3[i22]);
                                        f3 = fArr3[i3] + f17;
                                        f4 = fArr3[i20] + f18;
                                        f17 += fArr3[i21];
                                        f5 = fArr3[i22];
                                    } else if (c3 == 't') {
                                        if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                            f9 = f17 - f13;
                                            f10 = f18 - f14;
                                        } else {
                                            f10 = 0.0f;
                                            f9 = 0.0f;
                                        }
                                        int i23 = i3 + 1;
                                        path2.rQuadTo(f9, f10, fArr3[i3], fArr3[i23]);
                                        float f31 = f9 + f17;
                                        float f32 = f10 + f18;
                                        f17 += fArr3[i3];
                                        f18 += fArr3[i23];
                                        f14 = f32;
                                        f13 = f31;
                                    }
                                    i2 = i3;
                                    f20 = f18;
                                    f19 = f17;
                                } else {
                                    int i24 = i3 + 1;
                                    path2.lineTo(fArr3[i3], fArr3[i24]);
                                    f17 = fArr3[i3];
                                    f18 = fArr3[i24];
                                }
                                f18 += f6;
                            } else {
                                int i25 = i3 + 1;
                                int i26 = i3 + 2;
                                int i27 = i3 + 3;
                                path2.rQuadTo(fArr3[i3], fArr3[i25], fArr3[i26], fArr3[i27]);
                                f3 = fArr3[i3] + f17;
                                f4 = fArr3[i25] + f18;
                                f17 += fArr3[i26];
                                f5 = fArr3[i27];
                            }
                            f18 += f5;
                            f13 = f3;
                            f14 = f4;
                        } else {
                            path2.rLineTo(fArr3[i3], 0.0f);
                            f17 += fArr3[i3];
                        }
                        i2 = i3;
                    } else {
                        int i28 = i3 + 5;
                        float f33 = fArr3[i28] + f17;
                        int i29 = i3 + 6;
                        float f34 = fArr3[i29] + f18;
                        float f35 = fArr3[i3];
                        float f36 = fArr3[i3 + 1];
                        float f37 = fArr3[i3 + 2];
                        if (fArr3[i3 + 3] != 0.0f) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (fArr3[i3 + 4] != 0.0f) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        i2 = i3;
                        float f38 = f37;
                        drawArc(path, f17, f18, f33, f34, f35, f36, f38, z3, z4);
                        f = f17 + fArr3[i28];
                        f2 = f18 + fArr3[i29];
                    }
                    i3 = i2 + i;
                    c4 = c2;
                    c3 = c4;
                } else {
                    i2 = i3;
                    float f39 = f18;
                    float f40 = f17;
                    int i30 = i2 + 5;
                    float f41 = fArr3[i30];
                    int i31 = i2 + 6;
                    float f42 = fArr3[i31];
                    float f43 = fArr3[i2];
                    float f44 = fArr3[i2 + 1];
                    float f45 = fArr3[i2 + 2];
                    if (fArr3[i2 + 3] != 0.0f) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (fArr3[i2 + 4] != 0.0f) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    drawArc(path, f40, f39, f41, f42, f43, f44, f45, z, z2);
                    f = fArr3[i30];
                    f2 = fArr3[i31];
                }
                f14 = f18;
                f13 = f17;
                i3 = i2 + i;
                c4 = c2;
                c3 = c4;
            }
            fArr[0] = f17;
            fArr[1] = f18;
            fArr[2] = f13;
            fArr[3] = f14;
            fArr[4] = f19;
            fArr[5] = f20;
        }

        private static void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * cos;
            double d13 = d4 * sin;
            double d14 = (d12 * sin2) - (d13 * cos2);
            double d15 = d11 * sin;
            double d16 = d4 * cos;
            double d17 = (sin2 * d15) + (cos2 * d16);
            double d18 = d9 / ((double) ceil);
            double d19 = d8;
            double d20 = d17;
            double d21 = d14;
            int i = 0;
            double d22 = d5;
            double d23 = d6;
            while (i < ceil) {
                double d24 = d19 + d18;
                double sin3 = Math.sin(d24);
                double cos3 = Math.cos(d24);
                double d25 = (d + ((d10 * cos) * cos3)) - (d13 * sin3);
                double d26 = d2 + (d10 * sin * cos3) + (d16 * sin3);
                double d27 = (d12 * sin3) - (d13 * cos3);
                double d28 = (sin3 * d15) + (cos3 * d16);
                double d29 = d24 - d19;
                double tan = Math.tan(d29 / 2.0d);
                double sin4 = (Math.sin(d29) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d30 = d22 + (d21 * sin4);
                double d31 = cos;
                double d32 = sin;
                path.rLineTo(0.0f, 0.0f);
                float f = (float) (d25 - (sin4 * d27));
                float f2 = (float) (d26 - (sin4 * d28));
                path.cubicTo((float) d30, (float) (d23 + (d20 * sin4)), f, f2, (float) d25, (float) d26);
                i++;
                d18 = d18;
                sin = d32;
                d22 = d25;
                d15 = d15;
                cos = d31;
                d19 = d24;
                d20 = d28;
                d21 = d27;
                ceil = ceil;
                d23 = d26;
                d10 = d3;
            }
        }

        private static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            boolean z3;
            float f8 = f;
            float f9 = f3;
            float f10 = f5;
            boolean z4 = z2;
            double radians = Math.toRadians((double) f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = (double) f8;
            double d4 = d3 * cos;
            double d5 = d3;
            double d6 = (double) f2;
            double d7 = (double) f10;
            double d8 = (d4 + (d6 * sin)) / d7;
            double d9 = (((double) (-f8)) * sin) + (d6 * cos);
            double d10 = d6;
            double d11 = (double) f6;
            double d12 = d9 / d11;
            double d13 = (double) f4;
            double d14 = ((((double) f9) * cos) + (d13 * sin)) / d7;
            double d15 = d7;
            double d16 = ((((double) (-f9)) * sin) + (d13 * cos)) / d11;
            double d17 = d8 - d14;
            double d18 = d12 - d16;
            double d19 = (d8 + d14) / 2.0d;
            double d20 = (d12 + d16) / 2.0d;
            double d21 = sin;
            double d22 = (d17 * d17) + (d18 * d18);
            if (d22 == OOXIXo.f29376XO) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d23 = (1.0d / d22) - 0.25d;
            if (d23 < OOXIXo.f29376XO) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d22);
                float sqrt = (float) (Math.sqrt(d22) / 1.99999d);
                drawArc(path, f, f2, f3, f4, f10 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d23);
            double d24 = d17 * sqrt2;
            double d25 = sqrt2 * d18;
            boolean z5 = z2;
            if (z == z5) {
                d2 = d19 - d25;
                d = d20 + d24;
            } else {
                d2 = d19 + d25;
                d = d20 - d24;
            }
            double atan2 = Math.atan2(d12 - d, d8 - d2);
            double atan22 = Math.atan2(d16 - d, d14 - d2) - atan2;
            int i = (atan22 > OOXIXo.f29376XO ? 1 : (atan22 == OOXIXo.f29376XO ? 0 : -1));
            if (i >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z5 != z3) {
                if (i > 0) {
                    atan22 -= 6.283185307179586d;
                } else {
                    atan22 += 6.283185307179586d;
                }
            }
            double d26 = d2 * d15;
            double d27 = d * d11;
            arcToBezier(path, (d26 * cos) - (d27 * d21), (d26 * d21) + (d27 * cos), d15, d11, d5, d10, radians, atan2, atan22);
        }

        @Deprecated
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
            PathParser.nodesToPath(pathDataNodeArr, path);
        }

        @NonNull
        public float[] getParams() {
            return this.mParams;
        }

        public char getType() {
            return this.mType;
        }

        public void interpolatePathDataNode(@NonNull PathDataNode pathDataNode, @NonNull PathDataNode pathDataNode2, float f) {
            this.mType = pathDataNode.mType;
            int i = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i < fArr.length) {
                    this.mParams[i] = (fArr[i] * (1.0f - f)) + (pathDataNode2.mParams[i] * f);
                    i++;
                } else {
                    return;
                }
            }
        }

        public PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static boolean interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3, float f) {
        if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
            if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
                return false;
            }
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                pathDataNodeArr[i].interpolatePathDataNode(pathDataNodeArr2[i], pathDataNodeArr3[i], f);
            }
            return true;
        }
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    }
}
