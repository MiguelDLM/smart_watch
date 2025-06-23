package com.baidu.ar;

import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public abstract class ow implements ov {
    private oc Jo;
    private ByteBuffer Jp = pm.jR();
    private boolean Jn = true;
    private boolean Jq = false;
    private boolean Jr = false;
    private boolean Js = false;
    private boolean Jt = false;

    /* renamed from: com.baidu.ar.ow$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Ju;

        static {
            int[] iArr = new int[oc.values().length];
            Ju = iArr;
            try {
                iArr[oc.PING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Ju[oc.PONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Ju[oc.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Ju[oc.BINARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Ju[oc.CLOSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Ju[oc.CONTINUOUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ow(oc ocVar) {
        this.Jo = ocVar;
    }

    public static ow b(oc ocVar) {
        if (ocVar == null) {
            throw new IllegalArgumentException("Supplied opcode cannot be null");
        }
        switch (AnonymousClass1.Ju[ocVar.ordinal()]) {
            case 1:
                return new ox();
            case 2:
                return new oy();
            case 3:
                return new oz();
            case 4:
                return new oq();
            case 5:
                return new or();
            case 6:
                return new os();
            default:
                throw new IllegalArgumentException("Supplied opcode is invalid");
        }
    }

    public void al(boolean z) {
        this.Jn = z;
    }

    public void am(boolean z) {
        this.Jr = z;
    }

    public void an(boolean z) {
        this.Js = z;
    }

    public void ao(boolean z) {
        this.Jt = z;
    }

    public void ap(boolean z) {
        this.Jq = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ow owVar = (ow) obj;
        if (this.Jn != owVar.Jn || this.Jq != owVar.Jq || this.Jr != owVar.Jr || this.Js != owVar.Js || this.Jt != owVar.Jt || this.Jo != owVar.Jo) {
            return false;
        }
        ByteBuffer byteBuffer = this.Jp;
        ByteBuffer byteBuffer2 = owVar.Jp;
        return byteBuffer != null ? byteBuffer.equals(byteBuffer2) : byteBuffer2 == null;
    }

    public int hashCode() {
        int hashCode = (((this.Jn ? 1 : 0) * 31) + this.Jo.hashCode()) * 31;
        ByteBuffer byteBuffer = this.Jp;
        return ((((((((hashCode + (byteBuffer != null ? byteBuffer.hashCode() : 0)) * 31) + (this.Jq ? 1 : 0)) * 31) + (this.Jr ? 1 : 0)) * 31) + (this.Js ? 1 : 0)) * 31) + (this.Jt ? 1 : 0);
    }

    public abstract void jC();

    @Override // com.baidu.ar.ov
    public ByteBuffer jE() {
        return this.Jp;
    }

    @Override // com.baidu.ar.ov
    public boolean jF() {
        return this.Jn;
    }

    @Override // com.baidu.ar.ov
    public boolean jG() {
        return this.Jr;
    }

    @Override // com.baidu.ar.ov
    public boolean jH() {
        return this.Js;
    }

    @Override // com.baidu.ar.ov
    public boolean jI() {
        return this.Jt;
    }

    @Override // com.baidu.ar.ov
    public oc jJ() {
        return this.Jo;
    }

    public void n(ByteBuffer byteBuffer) {
        this.Jp = byteBuffer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Framedata{ optcode:");
        sb.append(jJ());
        sb.append(", fin:");
        sb.append(jF());
        sb.append(", rsv1:");
        sb.append(jG());
        sb.append(", rsv2:");
        sb.append(jH());
        sb.append(", rsv3:");
        sb.append(jI());
        sb.append(", payloadlength:[pos:");
        sb.append(this.Jp.position());
        sb.append(", len:");
        sb.append(this.Jp.remaining());
        sb.append("], payload:");
        sb.append(this.Jp.remaining() > 1000 ? "(too big to display)" : new String(this.Jp.array()));
        sb.append('}');
        return sb.toString();
    }
}
