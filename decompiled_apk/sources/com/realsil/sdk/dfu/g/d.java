package com.realsil.sdk.dfu.g;

import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import kotlin.OX00O0xII;

/* loaded from: classes11.dex */
public class d extends BaseBinInputStream {
    public d(InputStream inputStream, int i, int i2) throws IOException {
        super(inputStream, i, i2);
    }

    @Override // com.realsil.sdk.dfu.image.stream.BaseBinInputStream
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        if (this.otaVersion == 0) {
            this.icType = byteBuffer.get();
            this.p = byteBuffer.get();
            byteBuffer.getShort();
            this.h = byteBuffer.getShort() & OX00O0xII.f29066Oxx0xo;
            this.r = byteBuffer.getShort();
            if (this.k <= 0) {
                this.j = byteBuffer.getInt() + 1012;
            }
            ZLogger.v(String.format(Locale.US, "icType=0x%02X, secure_version=0x%02x, otaFlag=0x%02x, imageId=0x%04x, imageVersion=0x%08X, crc16=0x%04x, imageSize=0x%08X(%d)", Byte.valueOf(this.icType), Integer.valueOf(this.p), Byte.valueOf(this.q), Integer.valueOf(this.h), Integer.valueOf(this.imageVersion), Short.valueOf(this.r), Integer.valueOf(this.j), Integer.valueOf(this.j)));
            return;
        }
        this.icType = byteBuffer.get();
        byteBuffer.get();
        byteBuffer.getShort();
        if (!this.i) {
            this.h = byteBuffer.getShort() & OX00O0xII.f29066Oxx0xo;
        } else {
            byteBuffer.getShort();
        }
        this.r = byteBuffer.getShort();
        byteBuffer.getInt();
        if (this.f19544a) {
            ZLogger.d(String.format(Locale.US, "binHeader: icType=0x%02X, otaFlag=0x%02X, crc16=0x%04X", Byte.valueOf(this.icType), Byte.valueOf(this.q), Short.valueOf(this.r)));
        }
    }
}
