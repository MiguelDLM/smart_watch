package com.baidu.navisdk.util.common;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes8.dex */
public class c0 {

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f9222a = null;
        public Bitmap b = null;

        public String toString() {
            return "PicProcessResInfo{filePath='" + this.f9222a + "'}";
        }
    }

    public static a a(ContentResolver contentResolver, Uri uri, String str, int i, int i2) throws Exception {
        a aVar = new a();
        Bitmap a2 = a(a(contentResolver, uri, i, i2), a(str));
        aVar.f9222a = a(a2);
        if (a2 != null && a2.isRecycled()) {
            a2.recycle();
        }
        return aVar;
    }

    public static a a(ContentResolver contentResolver, Uri uri, String str) throws Exception {
        a aVar = new a();
        Bitmap a2 = a(a(contentResolver, uri, ScreenUtil.SCREEN_SIZE_Y_LARGE, 800), a(str));
        String a3 = a(a2);
        aVar.b = a2;
        aVar.f9222a = a3;
        return aVar;
    }

    public static a a(ContentResolver contentResolver, Uri uri) throws Exception {
        a aVar = new a();
        Bitmap a2 = a(contentResolver, uri, ScreenUtil.SCREEN_SIZE_Y_LARGE, 800);
        String a3 = a(a2);
        aVar.b = a2;
        aVar.f9222a = a3;
        return aVar;
    }

    private static Bitmap a(ContentResolver contentResolver, Uri uri, int i, int i2) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream openInputStream = contentResolver.openInputStream(uri);
        BitmapFactory.decodeStream(openInputStream, null, options);
        options.inJustDecodeBounds = false;
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 > i4) {
            i4 = i3;
            i3 = i4;
        }
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        int min = (i3 <= i || i4 <= i2) ? 1 : Math.min((int) Math.round((i3 * 1.0d) / i), (int) Math.round((i4 * 1.0d) / i2));
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_PicDialog", "compressBitmap() be=" + min);
        }
        int i5 = min > 0 ? min : 1;
        if (openInputStream != null) {
            openInputStream.close();
        }
        options.inSampleSize = i5;
        InputStream openInputStream2 = contentResolver.openInputStream(uri);
        Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream2, null, options);
        if (openInputStream2 != null) {
            openInputStream2.close();
        }
        return decodeStream;
    }

    public static String a(Bitmap bitmap) throws IOException {
        if (bitmap == null) {
            return null;
        }
        String a2 = a();
        a(a2, bitmap);
        return a2;
    }

    private static boolean a(String str, Bitmap bitmap) throws IOException {
        Throwable th;
        FileOutputStream fileOutputStream;
        if (bitmap == null || TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            file.createNewFile();
        }
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return true;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static boolean a(Bitmap bitmap, String str, String str2) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        return a(str + "/" + str2, bitmap);
    }

    private static int a(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static Bitmap a(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        if (i == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            bitmap2 = null;
        }
        if (bitmap2 == null) {
            bitmap2 = bitmap;
        }
        if (bitmap != bitmap2) {
            bitmap.recycle();
        }
        return bitmap2;
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        float f;
        float f2;
        if (bitmap == null) {
            return null;
        }
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        if (height < i && width < i2) {
            return bitmap;
        }
        if (height > width) {
            f = i;
            f2 = height;
        } else {
            f = i2;
            f2 = width;
        }
        float f3 = f / f2;
        Matrix matrix = new Matrix();
        matrix.postScale(f3, f3);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    private static String a() {
        return m0.j().b() + "/" + new Object().hashCode();
    }
}
