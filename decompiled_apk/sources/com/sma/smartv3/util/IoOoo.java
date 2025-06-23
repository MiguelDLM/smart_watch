package com.sma.smartv3.util;

import android.media.AudioRecord;
import android.util.Log;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes12.dex */
public class IoOoo {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f24253I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f24254II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f24255oIX0oI;

    public IoOoo(int sampleRate, int channel, int encoding) {
        this.f24254II0xO0 = sampleRate;
        this.f24253I0Io = channel;
        this.f24255oIX0oI = AudioRecord.getMinBufferSize(sampleRate, channel, encoding);
    }

    public final void II0xO0(FileOutputStream out, long totalAudioLen, long totalDataLen, long longSampleRate, int channels, long byteRate) throws IOException {
        Log.e("ddx", "writeWaveFileHeader()");
        out.write(new byte[]{82, 73, 70, 70, (byte) (totalDataLen & 255), (byte) ((totalDataLen >> 8) & 255), (byte) ((totalDataLen >> 16) & 255), (byte) ((totalDataLen >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) channels, 0, (byte) (longSampleRate & 255), (byte) ((longSampleRate >> 8) & 255), (byte) ((longSampleRate >> 16) & 255), (byte) ((longSampleRate >> 24) & 255), (byte) (byteRate & 255), (byte) ((byteRate >> 8) & 255), (byte) ((byteRate >> 16) & 255), (byte) ((byteRate >> 24) & 255), 4, 0, 16, 0, 100, 97, 116, 97, (byte) (totalAudioLen & 255), (byte) ((totalAudioLen >> 8) & 255), (byte) ((totalAudioLen >> 16) & 255), (byte) ((totalAudioLen >> 24) & 255)}, 0, 44);
    }

    public void oIX0oI(String inFilename, String outFilename) {
        int i;
        int i2 = this.f24254II0xO0;
        long j = i2;
        if (this.f24253I0Io == 16) {
            i = 1;
        } else {
            i = 2;
        }
        long j2 = ((i2 * 16) * i) / 8;
        byte[] bArr = new byte[this.f24255oIX0oI];
        Log.e("ddx", "pcmToWav()");
        try {
            FileInputStream fileInputStream = new FileInputStream(inFilename);
            FileOutputStream fileOutputStream = new FileOutputStream(outFilename);
            long size = fileInputStream.getChannel().size();
            II0xO0(fileOutputStream, size, size + 36, j, i, j2);
            while (fileInputStream.read(bArr) != -1) {
                fileOutputStream.write(bArr);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
