package com.alibaba.fastjson.asm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okio.Utf8;

public class ClassReader {
    public final byte[] b;
    public final int header;
    private final int[] items;
    private final int maxStringLength;
    private boolean readAnnotations;
    private final String[] strings;

    public ClassReader(InputStream inputStream, boolean z) throws IOException {
        int i;
        this.readAnnotations = z;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            i = 0;
            if (read == -1) {
                break;
            } else if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }
        inputStream.close();
        this.b = byteArrayOutputStream.toByteArray();
        int[] iArr = new int[readUnsignedShort(8)];
        this.items = iArr;
        int length = iArr.length;
        this.strings = new String[length];
        int i2 = 10;
        int i3 = 1;
        while (i3 < length) {
            int i4 = i2 + 1;
            this.items[i3] = i4;
            byte b2 = this.b[i2];
            int i5 = 3;
            if (b2 == 1) {
                i5 = 3 + readUnsignedShort(i4);
                if (i5 > i) {
                    i = i5;
                }
            } else if (b2 != 15) {
                if (!(b2 == 18 || b2 == 3 || b2 == 4)) {
                    if (b2 != 5 && b2 != 6) {
                        switch (b2) {
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                                break;
                        }
                    } else {
                        i3++;
                        i5 = 9;
                    }
                }
                i5 = 5;
            } else {
                i5 = 4;
            }
            i2 += i5;
            i3++;
        }
        this.maxStringLength = i;
        this.header = i2;
    }

    private int getAttributes() {
        int i = this.header;
        int readUnsignedShort = i + 8 + (readUnsignedShort(i + 6) * 2);
        for (int readUnsignedShort2 = readUnsignedShort(readUnsignedShort); readUnsignedShort2 > 0; readUnsignedShort2--) {
            for (int readUnsignedShort3 = readUnsignedShort(readUnsignedShort + 8); readUnsignedShort3 > 0; readUnsignedShort3--) {
                readUnsignedShort += readInt(readUnsignedShort + 12) + 6;
            }
            readUnsignedShort += 8;
        }
        int i2 = readUnsignedShort + 2;
        for (int readUnsignedShort4 = readUnsignedShort(i2); readUnsignedShort4 > 0; readUnsignedShort4--) {
            for (int readUnsignedShort5 = readUnsignedShort(i2 + 8); readUnsignedShort5 > 0; readUnsignedShort5--) {
                i2 += readInt(i2 + 12) + 6;
            }
            i2 += 8;
        }
        return i2 + 2;
    }

    private int readInt(int i) {
        byte[] bArr = this.b;
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    private int readMethod(TypeCollector typeCollector, char[] cArr, int i) {
        int readUnsignedShort = readUnsignedShort(i);
        String readUTF8 = readUTF8(i + 2, cArr);
        String readUTF82 = readUTF8(i + 4, cArr);
        int i2 = i + 8;
        int i3 = 0;
        int i4 = 0;
        for (int readUnsignedShort2 = readUnsignedShort(i + 6); readUnsignedShort2 > 0; readUnsignedShort2--) {
            String readUTF83 = readUTF8(i2, cArr);
            int readInt = readInt(i2 + 2);
            int i5 = i2 + 6;
            if (readUTF83.equals("Code")) {
                i4 = i5;
            }
            i2 = i5 + readInt;
        }
        MethodCollector visitMethod = typeCollector.visitMethod(readUnsignedShort, readUTF8, readUTF82);
        if (!(visitMethod == null || i4 == 0)) {
            int readInt2 = i4 + 8 + readInt(i4 + 4);
            int i6 = readInt2 + 2;
            for (int readUnsignedShort3 = readUnsignedShort(readInt2); readUnsignedShort3 > 0; readUnsignedShort3--) {
                i6 += 8;
            }
            int i7 = i6 + 2;
            int i8 = 0;
            for (int readUnsignedShort4 = readUnsignedShort(i6); readUnsignedShort4 > 0; readUnsignedShort4--) {
                String readUTF84 = readUTF8(i7, cArr);
                if (readUTF84.equals("LocalVariableTable")) {
                    i3 = i7 + 6;
                } else if (readUTF84.equals("LocalVariableTypeTable")) {
                    i8 = i7 + 6;
                }
                i7 += readInt(i7 + 2) + 6;
            }
            if (i3 != 0) {
                if (i8 != 0) {
                    int readUnsignedShort5 = readUnsignedShort(i8) * 3;
                    int i9 = i8 + 2;
                    int[] iArr = new int[readUnsignedShort5];
                    while (readUnsignedShort5 > 0) {
                        iArr[readUnsignedShort5 - 1] = i9 + 6;
                        iArr[readUnsignedShort5 - 2] = readUnsignedShort(i9 + 8);
                        readUnsignedShort5 -= 3;
                        iArr[readUnsignedShort5] = readUnsignedShort(i9);
                        i9 += 10;
                    }
                }
                int i10 = i3 + 2;
                for (int readUnsignedShort6 = readUnsignedShort(i3); readUnsignedShort6 > 0; readUnsignedShort6--) {
                    visitMethod.visitLocalVariable(readUTF8(i10 + 4, cArr), readUnsignedShort(i10 + 8));
                    i10 += 10;
                }
            }
        }
        return i2;
    }

    private String readUTF(int i, int i2, char[] cArr) {
        byte b2;
        int i3 = i2 + i;
        byte[] bArr = this.b;
        int i4 = 0;
        char c = 0;
        char c2 = 0;
        while (i < i3) {
            int i5 = i + 1;
            byte b3 = bArr[i];
            if (c != 0) {
                if (c == 1) {
                    cArr[i4] = (char) ((b3 & Utf8.REPLACEMENT_BYTE) | (c2 << 6));
                    i4++;
                    c = 0;
                } else if (c == 2) {
                    b2 = (b3 & Utf8.REPLACEMENT_BYTE) | (c2 << 6);
                }
                i = i5;
            } else {
                byte b4 = b3 & 255;
                if (b4 < 128) {
                    cArr[i4] = (char) b4;
                    i4++;
                } else if (b4 >= 224 || b4 <= 191) {
                    c2 = (char) (b3 & 15);
                    c = 2;
                } else {
                    b2 = b3 & 31;
                }
                i = i5;
            }
            c2 = (char) b2;
            c = 1;
            i = i5;
        }
        return new String(cArr, 0, i4);
    }

    private String readUTF8(int i, char[] cArr) {
        int readUnsignedShort = readUnsignedShort(i);
        String[] strArr = this.strings;
        String str = strArr[readUnsignedShort];
        if (str != null) {
            return str;
        }
        int i2 = this.items[readUnsignedShort];
        String readUTF = readUTF(i2 + 2, readUnsignedShort(i2), cArr);
        strArr[readUnsignedShort] = readUTF;
        return readUTF;
    }

    private int readUnsignedShort(int i) {
        byte[] bArr = this.b;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003d A[LOOP:1: B:10:0x003b->B:11:0x003d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008d A[LOOP:6: B:25:0x008b->B:26:0x008d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d4 A[LOOP:10: B:38:0x00d2->B:39:0x00d4, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void accept(com.alibaba.fastjson.asm.TypeCollector r9) {
        /*
            r8 = this;
            int r0 = r8.maxStringLength
            char[] r0 = new char[r0]
            boolean r1 = r8.readAnnotations
            r2 = 0
            if (r1 == 0) goto L_0x0030
            int r1 = r8.getAttributes()
            int r3 = r8.readUnsignedShort(r1)
        L_0x0011:
            if (r3 <= 0) goto L_0x0030
            int r4 = r1 + 2
            java.lang.String r4 = r8.readUTF8(r4, r0)
            java.lang.String r5 = "RuntimeVisibleAnnotations"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0024
            int r1 = r1 + 8
            goto L_0x0031
        L_0x0024:
            int r4 = r1 + 4
            int r4 = r8.readInt(r4)
            int r4 = r4 + 6
            int r1 = r1 + r4
            int r3 = r3 + -1
            goto L_0x0011
        L_0x0030:
            r1 = 0
        L_0x0031:
            int r3 = r8.header
            int r4 = r3 + 6
            int r4 = r8.readUnsignedShort(r4)
            int r3 = r3 + 8
        L_0x003b:
            if (r2 >= r4) goto L_0x0042
            int r3 = r3 + 2
            int r2 = r2 + 1
            goto L_0x003b
        L_0x0042:
            int r2 = r8.readUnsignedShort(r3)
            int r4 = r3 + 2
            r5 = r4
        L_0x0049:
            if (r2 <= 0) goto L_0x0064
            int r6 = r5 + 6
            int r6 = r8.readUnsignedShort(r6)
            int r5 = r5 + 8
        L_0x0053:
            if (r6 <= 0) goto L_0x0061
            int r7 = r5 + 2
            int r7 = r8.readInt(r7)
            int r7 = r7 + 6
            int r5 = r5 + r7
            int r6 = r6 + -1
            goto L_0x0053
        L_0x0061:
            int r2 = r2 + -1
            goto L_0x0049
        L_0x0064:
            int r2 = r8.readUnsignedShort(r5)
            int r5 = r5 + 2
        L_0x006a:
            if (r2 <= 0) goto L_0x0085
            int r6 = r5 + 6
            int r6 = r8.readUnsignedShort(r6)
            int r5 = r5 + 8
        L_0x0074:
            if (r6 <= 0) goto L_0x0082
            int r7 = r5 + 2
            int r7 = r8.readInt(r7)
            int r7 = r7 + 6
            int r5 = r5 + r7
            int r6 = r6 + -1
            goto L_0x0074
        L_0x0082:
            int r2 = r2 + -1
            goto L_0x006a
        L_0x0085:
            int r2 = r8.readUnsignedShort(r5)
            int r5 = r5 + 2
        L_0x008b:
            if (r2 <= 0) goto L_0x0099
            int r6 = r5 + 2
            int r6 = r8.readInt(r6)
            int r6 = r6 + 6
            int r5 = r5 + r6
            int r2 = r2 + -1
            goto L_0x008b
        L_0x0099:
            if (r1 == 0) goto L_0x00ad
            int r2 = r8.readUnsignedShort(r1)
            int r1 = r1 + 2
        L_0x00a1:
            if (r2 <= 0) goto L_0x00ad
            java.lang.String r5 = r8.readUTF8(r1, r0)
            r9.visitAnnotation(r5)
            int r2 = r2 + -1
            goto L_0x00a1
        L_0x00ad:
            int r1 = r8.readUnsignedShort(r3)
        L_0x00b1:
            if (r1 <= 0) goto L_0x00cc
            int r2 = r4 + 6
            int r2 = r8.readUnsignedShort(r2)
            int r4 = r4 + 8
        L_0x00bb:
            if (r2 <= 0) goto L_0x00c9
            int r3 = r4 + 2
            int r3 = r8.readInt(r3)
            int r3 = r3 + 6
            int r4 = r4 + r3
            int r2 = r2 + -1
            goto L_0x00bb
        L_0x00c9:
            int r1 = r1 + -1
            goto L_0x00b1
        L_0x00cc:
            int r1 = r8.readUnsignedShort(r4)
            int r4 = r4 + 2
        L_0x00d2:
            if (r1 <= 0) goto L_0x00db
            int r4 = r8.readMethod(r9, r0, r4)
            int r1 = r1 + -1
            goto L_0x00d2
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.asm.ClassReader.accept(com.alibaba.fastjson.asm.TypeCollector):void");
    }
}
