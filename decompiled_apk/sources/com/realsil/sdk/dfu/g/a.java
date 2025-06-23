package com.realsil.sdk.dfu.g;

import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.dfu.image.stream.BaseBinInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import kotlin.OX00O0xII;

/* loaded from: classes11.dex */
public class a extends BaseBinInputStream {
    public a(InputStream inputStream, int i, int i2) throws IOException {
        super(inputStream, i, i2);
    }

    @Override // com.realsil.sdk.dfu.image.stream.BaseBinInputStream
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        if (this.otaVersion == 0) {
            this.icType = byteBuffer.get();
            this.q = byteBuffer.get();
            this.h = byteBuffer.getShort() & OX00O0xII.f29066Oxx0xo;
            this.imageVersion = byteBuffer.getShort() & OX00O0xII.f29066Oxx0xo;
            this.r = byteBuffer.getShort();
            if (this.k <= 0) {
                this.j = byteBuffer.getInt();
            }
            if (this.f19544a) {
                ZLogger.d(String.format(Locale.US, "binHeader: icType=0x%02X, otaFlag=0x%02X, imageId=0x%04X, imageVersion=0x%08X, crc16=0x%04X, imageSize(exclude image header)=0x%08X(%d)", Byte.valueOf(this.icType), Byte.valueOf(this.q), Integer.valueOf(this.h), Integer.valueOf(this.imageVersion), Short.valueOf(this.r), Integer.valueOf(this.j), Integer.valueOf(this.j)));
                return;
            }
            return;
        }
        this.icType = byteBuffer.get(2);
        this.q = byteBuffer.get();
        if (!this.i) {
            this.h = byteBuffer.getShort(6) & OX00O0xII.f29066Oxx0xo;
        }
        byteBuffer.getShort();
        this.r = byteBuffer.getShort();
        byteBuffer.getInt();
        if (this.f19544a) {
            if (!this.i) {
                ZLogger.d(String.format(Locale.US, "binHeader: icType=0x%02X, crc16=0x%04X", Byte.valueOf(this.icType), Short.valueOf(this.r)));
            } else {
                ZLogger.d(String.format(Locale.US, "binHeader: icType=0x%02X, imageId=0x%04X, crc16=0x%04X", Byte.valueOf(this.icType), Integer.valueOf(this.h), Short.valueOf(this.r)));
            }
        }
    }
}
