package com.sifli.ezip;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public class sifliEzipUtil {
    private static final String TAG = "ezip-util";
    private static final int US_OF_S = 1000000;

    static {
        System.loadLibrary("ezip");
    }

    private static void jpgToPng(String str, String str2) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                if (decodeFile.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream)) {
                    bufferedOutputStream.flush();
                }
                bufferedOutputStream.close();
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mp4ToGif(String str, String str2, int i, int i2, int i3, int i4, int i5) {
        List<Bitmap> mp4ToGifGetBitmaps = mp4ToGifGetBitmaps(str, i, i2, i3, i4, i5);
        gifEncoder gifencoder = new gifEncoder();
        gifencoder.init(mp4ToGifGetBitmaps.get(0));
        gifencoder.start(str2);
        for (int i6 = 1; i6 < mp4ToGifGetBitmaps.size(); i6++) {
            gifencoder.addFrame(mp4ToGifGetBitmaps.get(i6));
        }
        gifencoder.finish();
    }

    private static List<Bitmap> mp4ToGifGetBitmaps(String str, int i, int i2, int i3, int i4, int i5) {
        int width;
        int height;
        ArrayList arrayList = new ArrayList();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        double d = 1000000 / i;
        for (double d2 = i2 * 1000000; d2 < i3 * 1000000; d2 += d) {
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime((long) d2, 3);
            if (frameAtTime != null) {
                if (i4 > 0) {
                    width = i4;
                } else {
                    width = frameAtTime.getWidth();
                }
                if (i5 > 0) {
                    height = i5;
                } else {
                    height = frameAtTime.getHeight();
                }
                arrayList.add(Bitmap.createScaledBitmap(frameAtTime, width, height, true));
            }
        }
        return arrayList;
    }

    private static native byte[] png2EzipNDK(byte[] bArr, long j, String str, int i, int i2);

    private static native byte[] png2EzipSequenceWithTypeNDK(byte[] bArr, int[] iArr, String str, int i, int i2, int i3);

    private static native byte[] png2EzipWithTypeNDK(byte[] bArr, long j, String str, int i, int i2, int i3);

    private static byte[] pngToEzip(byte[] bArr, String str, int i, int i2) {
        return png2EzipNDK(bArr, bArr.length, str, i, i2);
    }

    public static byte[] pngToEzipSequence(ArrayList<byte[]> arrayList, String str, int i, int i2, int i3) {
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        Log.d(TAG, "pic number " + size);
        int[] iArr = new int[size];
        Iterator<byte[]> it = arrayList.iterator();
        int i4 = 0;
        int i5 = 0;
        while (it.hasNext()) {
            byte[] next = it.next();
            iArr[i5] = next.length;
            i4 += next.length;
            i5++;
        }
        byte[] bArr = new byte[i4];
        Iterator<byte[]> it2 = arrayList.iterator();
        int i6 = 0;
        while (it2.hasNext()) {
            byte[] next2 = it2.next();
            System.arraycopy(next2, 0, bArr, i6, next2.length);
            i6 += next2.length;
        }
        return png2EzipSequenceWithTypeNDK(bArr, iArr, str, i, i2, i3);
    }

    public static byte[] pngToEzip(byte[] bArr, String str, int i, int i2, int i3) {
        return png2EzipWithTypeNDK(bArr, bArr.length, str, i, i2, i3);
    }
}
