package com.baidu.navisdk.ui.routeguide.subview.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f9097a = {R.drawable.nsdk_drawable_rg_ic_turn_back, R.drawable.nsdk_drawable_rg_ic_turn_ring, R.drawable.nsdk_drawable_rg_ic_turn_ring_out, R.drawable.nsdk_drawable_rg_ic_turn_ring_front, R.drawable.nsdk_drawable_rg_ic_turn_ring_left, R.drawable.nsdk_drawable_rg_ic_turn_ring_leftback, R.drawable.nsdk_drawable_rg_ic_turn_ring_leftfront, R.drawable.nsdk_drawable_rg_ic_turn_ring_right, R.drawable.nsdk_drawable_rg_ic_turn_ring_rightback, R.drawable.nsdk_drawable_rg_ic_turn_ring_rightfront, R.drawable.nsdk_drawable_rg_ic_turn_ring_turnback, R.drawable.nsdk_drawable_rg_hud_turn_back};

    public static boolean a() {
        return !b();
    }

    private static boolean b() {
        return a0.I().z();
    }

    private static final int c(int i) {
        int i2 = R.drawable.nsdk_drawable_rg_ic_turn_ring_right;
        if (i == i2) {
            return R.drawable.nsdk_drawable_rg_ic_turn_ring_left;
        }
        int i3 = R.drawable.nsdk_drawable_rg_ic_turn_ring_rightback;
        if (i == i3) {
            return R.drawable.nsdk_drawable_rg_ic_turn_ring_leftback;
        }
        int i4 = R.drawable.nsdk_drawable_rg_ic_turn_ring_rightfront;
        if (i == i4) {
            return R.drawable.nsdk_drawable_rg_ic_turn_ring_leftfront;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_ring_left) {
            return i2;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_ring_leftback) {
            return i3;
        }
        if (i == R.drawable.nsdk_drawable_rg_ic_turn_ring_leftfront) {
            return i4;
        }
        return i;
    }

    private static boolean d(int i) {
        for (int i2 : f9097a) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    public static final Drawable a(int i) {
        int b = b(i);
        Drawable drawable = JarUtils.getResources().getDrawable(b);
        return (drawable != null && b() && d(b)) ? a(drawable) : drawable;
    }

    private static final int b(int i) {
        return b() ? c(i) : i;
    }

    public static Drawable a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable != null) {
            try {
                if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && bitmap.getWidth() != 0 && bitmap.getHeight() != 0) {
                    Matrix matrix = new Matrix();
                    matrix.postScale(-1.0f, 1.0f);
                    return new BitmapDrawable(JarUtils.getResources(), Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false));
                }
                return drawable;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return drawable;
    }
}
