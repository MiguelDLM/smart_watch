package com.baidu.ar;

import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class or extends ot {
    private String Jm;
    private int code;

    public or() {
        super(oc.CLOSING);
        cG("");
        setCode(1000);
    }

    private void b(ByteBuffer byteBuffer, int i) {
        try {
            try {
                byteBuffer.position(byteBuffer.position() + 2);
                this.Jm = pn.o(byteBuffer);
            } catch (IllegalArgumentException unused) {
                throw new oh(1007);
            }
        } finally {
            byteBuffer.position(i);
        }
    }

    private void jD() {
        byte[] cM = pn.cM(this.Jm);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(this.code);
        allocate.position(2);
        ByteBuffer allocate2 = ByteBuffer.allocate(cM.length + 2);
        allocate2.put(allocate);
        allocate2.put(cM);
        allocate2.rewind();
        super.n(allocate2);
    }

    public void cG(String str) {
        if (str == null) {
            str = "";
        }
        this.Jm = str;
        jD();
    }

    @Override // com.baidu.ar.ow
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        or orVar = (or) obj;
        if (this.code != orVar.code) {
            return false;
        }
        String str = this.Jm;
        String str2 = orVar.Jm;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public String getMessage() {
        return this.Jm;
    }

    @Override // com.baidu.ar.ow
    public int hashCode() {
        int hashCode = ((super.hashCode() * 31) + this.code) * 31;
        String str = this.Jm;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @Override // com.baidu.ar.ot, com.baidu.ar.ow
    public void jC() {
        super.jC();
        if (this.code == 1007 && this.Jm.isEmpty()) {
            throw new oh(1007, "Received text is no valid utf8 string!");
        }
        if (this.code == 1005 && this.Jm.length() > 0) {
            throw new oh(1002, "A close frame must have a closecode if it has a reason");
        }
        int i = this.code;
        if (i > 1015 && i < 3000) {
            throw new oh(1002, "Trying to send an illegal close code!");
        }
        if (i == 1006 || i == 1015 || i == 1005 || i > 4999 || i < 1000 || i == 1004) {
            throw new oj("closecode must not be sent over the wire: " + this.code);
        }
    }

    @Override // com.baidu.ar.ow, com.baidu.ar.ov
    public ByteBuffer jE() {
        return this.code == 1005 ? pm.jR() : super.jE();
    }

    public int jy() {
        return this.code;
    }

    @Override // com.baidu.ar.ow
    public void n(ByteBuffer byteBuffer) {
        int i;
        this.code = 1005;
        this.Jm = "";
        byteBuffer.mark();
        if (byteBuffer.remaining() == 0) {
            i = 1000;
        } else {
            if (byteBuffer.remaining() != 1) {
                if (byteBuffer.remaining() >= 2) {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    allocate.position(2);
                    allocate.putShort(byteBuffer.getShort());
                    allocate.position(0);
                    this.code = allocate.getInt();
                }
                byteBuffer.reset();
                try {
                    b(byteBuffer, byteBuffer.position());
                    return;
                } catch (oh unused) {
                    this.code = 1007;
                    this.Jm = null;
                    return;
                }
            }
            i = 1002;
        }
        this.code = i;
    }

    public void setCode(int i) {
        this.code = i;
        if (i == 1015) {
            this.code = 1005;
            this.Jm = "";
        }
        jD();
    }

    @Override // com.baidu.ar.ow
    public String toString() {
        return super.toString() + "code: " + this.code;
    }
}
