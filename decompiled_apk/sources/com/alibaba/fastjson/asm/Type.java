package com.alibaba.fastjson.asm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import okhttp3.HttpUrl;

/* loaded from: classes.dex */
public class Type {
    private final char[] buf;
    private final int len;
    private final int off;
    protected final int sort;
    public static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);
    public static final Type BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
    public static final Type CHAR_TYPE = new Type(2, null, 1124075009, 1);
    public static final Type BYTE_TYPE = new Type(3, null, 1107297537, 1);
    public static final Type SHORT_TYPE = new Type(4, null, 1392510721, 1);
    public static final Type INT_TYPE = new Type(5, null, 1224736769, 1);
    public static final Type FLOAT_TYPE = new Type(6, null, 1174536705, 1);
    public static final Type LONG_TYPE = new Type(7, null, 1241579778, 1);
    public static final Type DOUBLE_TYPE = new Type(8, null, 1141048066, 1);

    private Type(int i, char[] cArr, int i2, int i3) {
        this.sort = i;
        this.buf = cArr;
        this.off = i2;
        this.len = i3;
    }

    public static Type[] getArgumentTypes(String str) {
        int i;
        char[] charArray = str.toCharArray();
        int i2 = 1;
        int i3 = 1;
        int i4 = 0;
        while (true) {
            int i5 = i3 + 1;
            char c = charArray[i3];
            if (c == ')') {
                break;
            }
            if (c == 'L') {
                while (true) {
                    i3 = i5 + 1;
                    if (charArray[i5] == ';') {
                        break;
                    }
                    i5 = i3;
                }
                i4++;
            } else {
                if (c != '[') {
                    i4++;
                }
                i3 = i5;
            }
        }
        Type[] typeArr = new Type[i4];
        int i6 = 0;
        while (charArray[i2] != ')') {
            Type type = getType(charArray, i2);
            typeArr[i6] = type;
            int i7 = type.len;
            if (type.sort == 10) {
                i = 2;
            } else {
                i = 0;
            }
            i2 += i7 + i;
            i6++;
        }
        return typeArr;
    }

    public static int getArgumentsAndReturnSizes(String str) {
        int i;
        int i2 = 1;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            i = i3 + 1;
            char charAt = str.charAt(i3);
            if (charAt == ')') {
                break;
            }
            if (charAt == 'L') {
                while (true) {
                    i3 = i + 1;
                    if (str.charAt(i) == ';') {
                        break;
                    }
                    i = i3;
                }
                i4++;
            } else {
                if (charAt != 'D' && charAt != 'J') {
                    i4++;
                } else {
                    i4 += 2;
                }
                i3 = i;
            }
        }
        char charAt2 = str.charAt(i);
        int i5 = i4 << 2;
        if (charAt2 == 'V') {
            i2 = 0;
        } else if (charAt2 == 'D' || charAt2 == 'J') {
            i2 = 2;
        }
        return i5 | i2;
    }

    private int getDimensions() {
        int i = 1;
        while (this.buf[this.off + i] == '[') {
            i++;
        }
        return i;
    }

    public static Type getType(String str) {
        return getType(str.toCharArray(), 0);
    }

    public String getClassName() {
        switch (this.sort) {
            case 0:
                return "void";
            case 1:
                return TypedValues.Custom.S_BOOLEAN;
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
            case 6:
                return TypedValues.Custom.S_FLOAT;
            case 7:
                return "long";
            case 8:
                return "double";
            case 9:
                StringBuilder sb = new StringBuilder(getType(this.buf, this.off + getDimensions()).getClassName());
                for (int dimensions = getDimensions(); dimensions > 0; dimensions--) {
                    sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                }
                return sb.toString();
            default:
                return new String(this.buf, this.off, this.len).replace(IOUtils.DIR_SEPARATOR_UNIX, '.');
        }
    }

    public String getDescriptor() {
        return new String(this.buf, this.off, this.len);
    }

    public String getInternalName() {
        return new String(this.buf, this.off, this.len);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x004d, code lost:
    
        if (r4 == 'L') goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x004f, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0055, code lost:
    
        if (r5[r6 + r0] == ';') goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0060, code lost:
    
        return new com.alibaba.fastjson.asm.Type(9, r5, r6, r0 + 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.alibaba.fastjson.asm.Type getType(char[] r5, int r6) {
        /*
            char r0 = r5[r6]
            r1 = 70
            if (r0 == r1) goto L70
            r1 = 83
            if (r0 == r1) goto L6d
            r1 = 86
            if (r0 == r1) goto L6a
            r1 = 73
            if (r0 == r1) goto L67
            r1 = 74
            if (r0 == r1) goto L64
            r1 = 90
            if (r0 == r1) goto L61
            r1 = 59
            r2 = 91
            r3 = 1
            if (r0 == r2) goto L41
            switch(r0) {
                case 66: goto L3e;
                case 67: goto L3b;
                case 68: goto L38;
                default: goto L24;
            }
        L24:
            r0 = 1
        L25:
            int r2 = r6 + r0
            char r2 = r5[r2]
            if (r2 == r1) goto L2e
            int r0 = r0 + 1
            goto L25
        L2e:
            com.alibaba.fastjson.asm.Type r1 = new com.alibaba.fastjson.asm.Type
            int r6 = r6 + r3
            int r0 = r0 - r3
            r2 = 10
            r1.<init>(r2, r5, r6, r0)
            return r1
        L38:
            com.alibaba.fastjson.asm.Type r5 = com.alibaba.fastjson.asm.Type.DOUBLE_TYPE
            return r5
        L3b:
            com.alibaba.fastjson.asm.Type r5 = com.alibaba.fastjson.asm.Type.CHAR_TYPE
            return r5
        L3e:
            com.alibaba.fastjson.asm.Type r5 = com.alibaba.fastjson.asm.Type.BYTE_TYPE
            return r5
        L41:
            r0 = 1
        L42:
            int r4 = r6 + r0
            char r4 = r5[r4]
            if (r4 != r2) goto L4b
            int r0 = r0 + 1
            goto L42
        L4b:
            r2 = 76
            if (r4 != r2) goto L58
        L4f:
            int r0 = r0 + 1
            int r2 = r6 + r0
            char r2 = r5[r2]
            if (r2 == r1) goto L58
            goto L4f
        L58:
            com.alibaba.fastjson.asm.Type r1 = new com.alibaba.fastjson.asm.Type
            r2 = 9
            int r0 = r0 + r3
            r1.<init>(r2, r5, r6, r0)
            return r1
        L61:
            com.alibaba.fastjson.asm.Type r5 = com.alibaba.fastjson.asm.Type.BOOLEAN_TYPE
            return r5
        L64:
            com.alibaba.fastjson.asm.Type r5 = com.alibaba.fastjson.asm.Type.LONG_TYPE
            return r5
        L67:
            com.alibaba.fastjson.asm.Type r5 = com.alibaba.fastjson.asm.Type.INT_TYPE
            return r5
        L6a:
            com.alibaba.fastjson.asm.Type r5 = com.alibaba.fastjson.asm.Type.VOID_TYPE
            return r5
        L6d:
            com.alibaba.fastjson.asm.Type r5 = com.alibaba.fastjson.asm.Type.SHORT_TYPE
            return r5
        L70:
            com.alibaba.fastjson.asm.Type r5 = com.alibaba.fastjson.asm.Type.FLOAT_TYPE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.asm.Type.getType(char[], int):com.alibaba.fastjson.asm.Type");
    }
}
