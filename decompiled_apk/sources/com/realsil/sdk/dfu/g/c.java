package com.realsil.sdk.dfu.g;

import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import kotlin.OX00O0xII;

/* loaded from: classes11.dex */
public class c extends BaseBinInputStream {
    public c(InputStream inputStream, int i, int i2) throws IOException {
        super(inputStream, i, i2);
    }

    @Override // com.realsil.sdk.dfu.image.stream.BaseBinInputStream
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        this.icType = (byte) 3;
        if (this.otaVersion == 0) {
            this.o = byteBuffer.getShort() & OX00O0xII.f29066Oxx0xo;
            this.h = byteBuffer.getShort() & OX00O0xII.f29066Oxx0xo;
            this.imageVersion = byteBuffer.getShort() & OX00O0xII.f29066Oxx0xo;
            this.r = byteBuffer.getShort();
            this.j = byteBuffer.getShort() & OX00O0xII.f29066Oxx0xo;
            byte[] bArr = this.g;
            this.q = bArr[10];
            byte b = bArr[11];
            if (this.f19544a) {
                ZLogger.v(String.format(Locale.US, "flashAddr=0x%04X, imageId=0x%04X, imageVersion=0x%08X(%d), crc16=0x%04X, imageSize=0x%04X(%d), otaFlag=0x%02X", Integer.valueOf(this.o), Integer.valueOf(this.h), Integer.valueOf(this.imageVersion), Integer.valueOf(this.imageVersion), Short.valueOf(this.r), Integer.valueOf(this.j), Integer.valueOf(this.j), Byte.valueOf(this.q)));
                return;
            }
            return;
        }
        byteBuffer.getShort();
        if (!this.i) {
            this.h = byteBuffer.getShort() & OX00O0xII.f29066Oxx0xo;
        } else {
            byteBuffer.getShort();
        }
        byteBuffer.getShort();
        this.r = byteBuffer.getShort();
        byteBuffer.getShort();
        byte[] bArr2 = this.g;
        this.q = bArr2[10];
        byte b2 = bArr2[11];
        if (this.b) {
            ZLogger.v(String.format(Locale.US, "crc16=0x%04X,  otaFlag=0x%02X", Short.valueOf(this.r), Byte.valueOf(this.q)));
        }
    }

    @Override // com.realsil.sdk.dfu.image.stream.BaseBinInputStream
    public int remainSizeInBytes() {
        return (this.j * 4) - this.x;
    }
}
