package com.realsil.sdk.bbpro.core.transportlayer;

/* loaded from: classes11.dex */
public class Command {
    public static final short INVALID_OPCODE = 0;
    public static final int WRITE_TYPE_DEFAULT = 2;
    public static final int WRITE_TYPE_NO_RESPONSE = 1;
    public static final int WRITE_TYPE_WITH_RESPONSE = 2;

    /* renamed from: a, reason: collision with root package name */
    public String f19464a;
    public int b;
    public int c;
    public short d;
    public short e;
    public byte[] f;
    public int g;

    /* loaded from: classes11.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f19465a;
        public byte[] b;
        public short c = 0;
        public short d = 0;
        public int e = 2;
        public int f = 2;

        public Command build() {
            return new Command(this.f19465a, this.e, this.c, this.d, this.b, this.f);
        }

        public Builder commandId(short s) {
            this.c = s;
            return this;
        }

        public Builder dst(String str) {
            this.f19465a = str;
            return this;
        }

        public Builder eventId(short s) {
            this.d = s;
            return this;
        }

        public Builder packet(short s, byte[] bArr) {
            this.c = s;
            this.b = TransportLayerPacket.encodePayload(s, bArr);
            return this;
        }

        public Builder payload(byte[] bArr) {
            this.b = bArr;
            return this;
        }

        public Builder retransCount(int i) {
            this.f = i;
            return this;
        }

        public Builder writeType(int i) {
            this.e = i;
            return this;
        }
    }

    public Command(String str, int i, short s, short s2, byte[] bArr, int i2) {
        this.f19464a = str;
        this.c = i;
        this.d = s;
        this.e = s2;
        this.f = bArr;
        this.g = i2;
    }

    public byte[] encode() {
        return TransportLayerPacket.encode(this.b, this.f);
    }

    public short getCommandId() {
        return this.d;
    }

    public String getDst() {
        return this.f19464a;
    }

    public short getEventId() {
        return this.e;
    }

    public byte[] getPayload() {
        return this.f;
    }

    public int getPayloadLength() {
        byte[] bArr = this.f;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public int getRetransCount() {
        return this.g;
    }

    public int getWriteType() {
        return this.c;
    }

    public boolean isCommandIdAvailable() {
        if (this.d != 0) {
            return true;
        }
        return false;
    }

    public void setSn(int i) {
        this.b = i;
    }

    public byte[] encode(int i) {
        return TransportLayerPacket.encode(i, this.f);
    }
}
