package com.alibaba.fastjson.asm;

public class MethodWriter implements MethodVisitor {
    private int access;
    private ByteVector code = new ByteVector();
    final ClassWriter cw;
    private final int desc;
    int exceptionCount;
    int[] exceptions;
    private int maxLocals;
    private int maxStack;
    private final int name;
    MethodWriter next;

    public MethodWriter(ClassWriter classWriter, int i, String str, String str2, String str3, String[] strArr) {
        if (classWriter.firstMethod == null) {
            classWriter.firstMethod = this;
        } else {
            classWriter.lastMethod.next = this;
        }
        classWriter.lastMethod = this;
        this.cw = classWriter;
        this.access = i;
        this.name = classWriter.newUTF8(str);
        this.desc = classWriter.newUTF8(str2);
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.exceptionCount = length;
            this.exceptions = new int[length];
            for (int i2 = 0; i2 < this.exceptionCount; i2++) {
                this.exceptions[i2] = classWriter.newClassItem(strArr[i2]).index;
            }
        }
    }

    public final int getSize() {
        int i;
        if (this.code.length > 0) {
            this.cw.newUTF8("Code");
            i = this.code.length + 26;
        } else {
            i = 8;
        }
        if (this.exceptionCount <= 0) {
            return i;
        }
        this.cw.newUTF8("Exceptions");
        return i + (this.exceptionCount * 2) + 8;
    }

    public final void put(ByteVector byteVector) {
        int i;
        byteVector.putShort(this.access & -393217).putShort(this.name).putShort(this.desc);
        if (this.code.length > 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.exceptionCount > 0) {
            i++;
        }
        byteVector.putShort(i);
        int i2 = this.code.length;
        if (i2 > 0) {
            byteVector.putShort(this.cw.newUTF8("Code")).putInt(i2 + 12);
            byteVector.putShort(this.maxStack).putShort(this.maxLocals);
            ByteVector putInt = byteVector.putInt(this.code.length);
            ByteVector byteVector2 = this.code;
            putInt.putByteArray(byteVector2.data, 0, byteVector2.length);
            byteVector.putShort(0);
            byteVector.putShort(0);
        }
        if (this.exceptionCount > 0) {
            byteVector.putShort(this.cw.newUTF8("Exceptions")).putInt((this.exceptionCount * 2) + 2);
            byteVector.putShort(this.exceptionCount);
            for (int i3 = 0; i3 < this.exceptionCount; i3++) {
                byteVector.putShort(this.exceptions[i3]);
            }
        }
    }

    public void visitEnd() {
    }

    public void visitFieldInsn(int i, String str, String str2, String str3) {
        this.code.put12(i, this.cw.newFieldItem(str, str2, str3).index);
    }

    public void visitIincInsn(int i, int i2) {
        this.code.putByte(132).put11(i, i2);
    }

    public void visitInsn(int i) {
        this.code.putByte(i);
    }

    public void visitIntInsn(int i, int i2) {
        this.code.put11(i, i2);
    }

    public void visitJumpInsn(int i, Label label) {
        if ((label.status & 2) == 0 || label.position - this.code.length >= -32768) {
            this.code.putByte(i);
            ByteVector byteVector = this.code;
            boolean z = true;
            int i2 = byteVector.length - 1;
            if (i != 200) {
                z = false;
            }
            label.put(this, byteVector, i2, z);
            return;
        }
        throw new UnsupportedOperationException();
    }

    public void visitLabel(Label label) {
        ByteVector byteVector = this.code;
        label.resolve(this, byteVector.length, byteVector.data);
    }

    public void visitLdcInsn(Object obj) {
        Item newConstItem = this.cw.newConstItem(obj);
        int i = newConstItem.index;
        int i2 = newConstItem.type;
        if (i2 == 5 || i2 == 6) {
            this.code.put12(20, i);
        } else if (i >= 256) {
            this.code.put12(19, i);
        } else {
            this.code.put11(18, i);
        }
    }

    public void visitMaxs(int i, int i2) {
        this.maxStack = i;
        this.maxLocals = i2;
    }

    public void visitMethodInsn(int i, String str, String str2, String str3) {
        boolean z;
        if (i == 185) {
            z = true;
        } else {
            z = false;
        }
        Item newMethodItem = this.cw.newMethodItem(str, str2, str3, z);
        int i2 = newMethodItem.intVal;
        if (z) {
            if (i2 == 0) {
                i2 = Type.getArgumentsAndReturnSizes(str3);
                newMethodItem.intVal = i2;
            }
            this.code.put12(185, newMethodItem.index).put11(i2 >> 2, 0);
            return;
        }
        this.code.put12(i, newMethodItem.index);
    }

    public void visitTypeInsn(int i, String str) {
        this.code.put12(i, this.cw.newClassItem(str).index);
    }

    public void visitVarInsn(int i, int i2) {
        int i3;
        if (i2 < 4 && i != 169) {
            if (i < 54) {
                i3 = ((i - 21) << 2) + 26;
            } else {
                i3 = ((i - 54) << 2) + 59;
            }
            this.code.putByte(i3 + i2);
        } else if (i2 >= 256) {
            this.code.putByte(196).put12(i, i2);
        } else {
            this.code.put11(i, i2);
        }
    }
}
