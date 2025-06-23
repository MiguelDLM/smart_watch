package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes7.dex */
public final class BitmapDescriptor {

    /* renamed from: a, reason: collision with root package name */
    Bitmap f5792a;
    private Bundle b;

    public BitmapDescriptor(Bitmap bitmap) {
        if (bitmap != null) {
            this.f5792a = a(bitmap, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    private Bitmap a(Bitmap bitmap, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public Bundle b() {
        MessageDigest messageDigest;
        if (this.f5792a != null) {
            if (this.b == null) {
                Bundle bundle = new Bundle();
                bundle.putInt(RouteGuideParams.RGKey.ExpandMap.ImageWidth, this.f5792a.getWidth());
                bundle.putInt(RouteGuideParams.RGKey.ExpandMap.ImageHeight, this.f5792a.getHeight());
                byte[] a2 = a();
                bundle.putByteArray("image_data", a2);
                try {
                    messageDigest = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                    messageDigest = null;
                }
                if (messageDigest != null) {
                    messageDigest.update(a2, 0, a2.length);
                    byte[] digest = messageDigest.digest();
                    StringBuilder sb = new StringBuilder("");
                    for (byte b : digest) {
                        sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
                    }
                    bundle.putString("image_hashcode", sb.toString());
                }
                this.b = bundle;
            }
            return this.b;
        }
        throw new IllegalStateException("BDMapSDKException: the bitmap has been recycled! you can not use it again");
    }

    public void clearCache() {
        Bundle bundle = this.b;
        if (bundle != null) {
            bundle.clear();
            this.b = null;
        }
    }

    public Bitmap getBitmap() {
        return this.f5792a;
    }

    public void recycle() {
        Bitmap bitmap = this.f5792a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f5792a.recycle();
            this.f5792a = null;
        }
    }

    public byte[] a() {
        ByteBuffer allocate = ByteBuffer.allocate(this.f5792a.getWidth() * this.f5792a.getHeight() * 4);
        this.f5792a.copyPixelsToBuffer(allocate);
        return allocate.array();
    }
}
