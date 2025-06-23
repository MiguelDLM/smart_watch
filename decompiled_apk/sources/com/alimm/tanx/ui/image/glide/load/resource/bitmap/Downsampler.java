package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.load.DecodeFormat;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser;
import com.alimm.tanx.ui.image.glide.util.ByteArrayPool;
import com.alimm.tanx.ui.image.glide.util.ExceptionCatchingInputStream;
import com.alimm.tanx.ui.image.glide.util.MarkEnforcingInputStream;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;
import oOxxXI.oIX0oI;

/* loaded from: classes.dex */
public abstract class Downsampler implements BitmapDecoder<InputStream> {
    private static final int MARK_POSITION = 5242880;
    private static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL = EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG);
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE = Util.createQueue(0);
    public static final Downsampler AT_LEAST = new Downsampler() { // from class: com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler.1
        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler, com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i, int i2, DecodeFormat decodeFormat) throws Exception {
            return super.decode(inputStream, bitmapPool, i, i2, decodeFormat);
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public String getId() {
            return "AT_LEAST.com.alimm.tanx.ui.image.glide.load.data.bitmap";
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler
        public int getSampleSize(int i, int i2, int i3, int i4) {
            return Math.min(i2 / i4, i / i3);
        }
    };
    public static final Downsampler AT_MOST = new Downsampler() { // from class: com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler.2
        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler, com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i, int i2, DecodeFormat decodeFormat) throws Exception {
            return super.decode(inputStream, bitmapPool, i, i2, decodeFormat);
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public String getId() {
            return "AT_MOST.com.alimm.tanx.ui.image.glide.load.data.bitmap";
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler
        public int getSampleSize(int i, int i2, int i3, int i4) {
            int ceil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            int i5 = 1;
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i5 = 0;
            }
            return max << i5;
        }
    };
    public static final Downsampler NONE = new Downsampler() { // from class: com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler.3
        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler, com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i, int i2, DecodeFormat decodeFormat) throws Exception {
            return super.decode(inputStream, bitmapPool, i, i2, decodeFormat);
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public String getId() {
            return "NONE.com.alimm.tanx.ui.image.glide.load.data.bitmap";
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler
        public int getSampleSize(int i, int i2, int i3, int i4) {
            return 0;
        }
    };

    private static Bitmap decodeStream(MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options) {
        if (options.inJustDecodeBounds) {
            markEnforcingInputStream.mark(5242880);
        } else {
            recyclableBufferedInputStream.fixMarkLimit();
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(markEnforcingInputStream, null, options);
        try {
            if (options.inJustDecodeBounds) {
                markEnforcingInputStream.reset();
            }
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 6)) {
                StringBuilder oIX0oI2 = oIX0oI.oIX0oI("Exception loading inDecodeBounds=");
                oIX0oI2.append(options.inJustDecodeBounds);
                oIX0oI2.append(" sample=");
                oIX0oI2.append(options.inSampleSize);
                Log.e(TAG, oIX0oI2.toString(), e);
            }
        }
        return decodeStream;
    }

    private Bitmap downsampleWithSize(MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options, BitmapPool bitmapPool, int i, int i2, int i3, DecodeFormat decodeFormat) {
        Bitmap.Config config = getConfig(markEnforcingInputStream, decodeFormat);
        options.inSampleSize = i3;
        options.inPreferredConfig = config;
        if (shouldUsePool(markEnforcingInputStream)) {
            double d = i3;
            setInBitmap(options, bitmapPool.getDirty((int) Math.ceil(i / d), (int) Math.ceil(i2 / d), config));
        }
        return decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, options);
    }

    private static Bitmap.Config getConfig(InputStream inputStream, DecodeFormat decodeFormat) {
        boolean z;
        if (decodeFormat != DecodeFormat.ALWAYS_ARGB_8888 && decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
            inputStream.mark(1024);
            try {
                try {
                    z = new ImageHeaderParser(inputStream).hasAlpha();
                    try {
                        inputStream.reset();
                    } catch (IOException e) {
                        if (Log.isLoggable(TAG, 5)) {
                            Log.w(TAG, "Cannot reset the input stream", e);
                        }
                    }
                } catch (Throwable th) {
                    try {
                        inputStream.reset();
                    } catch (IOException e2) {
                        if (Log.isLoggable(TAG, 5)) {
                            Log.w(TAG, "Cannot reset the input stream", e2);
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                if (Log.isLoggable(TAG, 5)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Cannot determine whether the image has alpha or not from header for format ");
                    sb.append(decodeFormat);
                    Log.w(TAG, sb.toString(), e3);
                }
                try {
                    inputStream.reset();
                } catch (IOException e4) {
                    if (Log.isLoggable(TAG, 5)) {
                        Log.w(TAG, "Cannot reset the input stream", e4);
                    }
                }
                z = false;
            }
            if (z) {
                return Bitmap.Config.ARGB_8888;
            }
            return Bitmap.Config.RGB_565;
        }
        return Bitmap.Config.ARGB_8888;
    }

    @TargetApi(11)
    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                resetOptions(poll);
            }
        }
        return poll;
    }

    private int getRoundedSampleSize(int i, int i2, int i3, int i4, int i5) {
        int sampleSize;
        int highestOneBit;
        if (i5 == Integer.MIN_VALUE) {
            i5 = i3;
        }
        if (i4 == Integer.MIN_VALUE) {
            i4 = i2;
        }
        if (i != 90 && i != 270) {
            sampleSize = getSampleSize(i2, i3, i4, i5);
        } else {
            sampleSize = getSampleSize(i3, i2, i4, i5);
        }
        if (sampleSize == 0) {
            highestOneBit = 0;
        } else {
            highestOneBit = Integer.highestOneBit(sampleSize);
        }
        return Math.max(1, highestOneBit);
    }

    private static void releaseOptions(BitmapFactory.Options options) {
        resetOptions(options);
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    @TargetApi(11)
    private static void resetOptions(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    @TargetApi(11)
    private static void setInBitmap(BitmapFactory.Options options, Bitmap bitmap) {
        options.inBitmap = bitmap;
    }

    private static boolean shouldUsePool(InputStream inputStream) {
        return true;
    }

    public int[] getDimensions(MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public abstract int getSampleSize(int i, int i2, int i3, int i4);

    @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
    public Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i, int i2, DecodeFormat decodeFormat) {
        int i3;
        Bitmap bitmap;
        ByteArrayPool byteArrayPool = ByteArrayPool.get();
        byte[] bytes = byteArrayPool.getBytes();
        byte[] bytes2 = byteArrayPool.getBytes();
        BitmapFactory.Options defaultOptions = getDefaultOptions();
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, bytes2);
        ExceptionCatchingInputStream obtain = ExceptionCatchingInputStream.obtain(recyclableBufferedInputStream);
        MarkEnforcingInputStream markEnforcingInputStream = new MarkEnforcingInputStream(obtain);
        try {
            obtain.mark(5242880);
            try {
                try {
                    int orientation = new ImageHeaderParser(obtain).getOrientation();
                    try {
                        obtain.reset();
                    } catch (IOException e) {
                        if (Log.isLoggable(TAG, 5)) {
                            Log.w(TAG, "Cannot reset the input stream", e);
                        }
                    }
                    i3 = orientation;
                } finally {
                }
            } catch (IOException e2) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Cannot determine the image orientation from header", e2);
                }
                try {
                    obtain.reset();
                } catch (IOException e3) {
                    if (Log.isLoggable(TAG, 5)) {
                        Log.w(TAG, "Cannot reset the input stream", e3);
                    }
                }
                i3 = 0;
            }
            defaultOptions.inTempStorage = bytes;
            int[] dimensions = getDimensions(markEnforcingInputStream, recyclableBufferedInputStream, defaultOptions);
            int i4 = dimensions[0];
            int i5 = dimensions[1];
            Bitmap downsampleWithSize = downsampleWithSize(markEnforcingInputStream, recyclableBufferedInputStream, defaultOptions, bitmapPool, i4, i5, getRoundedSampleSize(TransformationUtils.getExifOrientationDegrees(i3), i4, i5, i, i2), decodeFormat);
            IOException exception = obtain.getException();
            if (exception != null) {
                throw new RuntimeException(exception);
            }
            if (downsampleWithSize != null) {
                bitmap = TransformationUtils.rotateImageExif(downsampleWithSize, bitmapPool, i3);
                if (!downsampleWithSize.equals(bitmap) && !bitmapPool.put(downsampleWithSize)) {
                    downsampleWithSize.recycle();
                }
            } else {
                bitmap = null;
            }
            return bitmap;
        } finally {
            byteArrayPool.releaseBytes(bytes);
            byteArrayPool.releaseBytes(bytes2);
            obtain.release();
            releaseOptions(defaultOptions);
        }
    }
}
