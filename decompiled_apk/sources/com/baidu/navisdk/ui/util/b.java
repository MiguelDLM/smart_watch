package com.baidu.navisdk.ui.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.jar.style.BNInflaterFactory;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f9196a = true;
    private static boolean b = true;
    private static final SparseIntArray e = new SparseIntArray();
    private static Resources c = JarUtils.getResources();
    private static Resources d = JarUtils.getNightResources();

    public static boolean a() {
        if (c == null) {
            c = JarUtils.getResources();
        }
        return c != null;
    }

    public static void b(boolean z) {
        e.clear();
        f9196a = z;
        b = z;
    }

    public static boolean c() {
        return b;
    }

    public static int d(int i) {
        if (!a()) {
            return 0;
        }
        try {
            return (int) c.getDimension(i);
        } catch (Resources.NotFoundException unused) {
            return 0;
        }
    }

    public static int e(int i) {
        if (!a()) {
            return 0;
        }
        try {
            return c.getDimensionPixelOffset(i);
        } catch (Resources.NotFoundException unused) {
            return 0;
        }
    }

    public static Drawable f(int i) {
        return c(i, f9196a);
    }

    public static Drawable g(int i) {
        return c(i, b);
    }

    public static String h(int i) {
        if (!a()) {
            return "";
        }
        try {
            return c.getString(i);
        } catch (Exception unused) {
            return "";
        }
    }

    public static Drawable c(int i, boolean z) {
        if (!a()) {
            return null;
        }
        try {
            return a(z).getDrawable(i);
        } catch (Resources.NotFoundException | OutOfMemoryError unused) {
            return null;
        }
    }

    public static Resources a(boolean z) {
        return z ? c : d;
    }

    public static boolean b() {
        return f9196a;
    }

    public static ColorStateList c(int i) {
        return b(i, b);
    }

    public static int a(int i, boolean z) {
        if (!a()) {
            return 0;
        }
        try {
            return a(z).getColor(i);
        } catch (Resources.NotFoundException unused) {
            return 0;
        }
    }

    public static int b(int i) {
        return a(i, b);
    }

    public static ColorStateList b(int i, boolean z) {
        if (!a()) {
            return null;
        }
        try {
            return a(z).getColorStateList(i);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static String a(int i, Object... objArr) {
        if (!a()) {
            return "";
        }
        try {
            return c.getString(i, objArr);
        } catch (Exception unused) {
            return "";
        }
    }

    public static Animation b(Context context, int i) {
        return JarUtils.loadAnimation(context, i);
    }

    public static Bitmap a(int i) {
        if (!a()) {
            return null;
        }
        try {
            return BitmapFactory.decodeResource(c, i);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static View a(Context context, int i) {
        if (com.baidu.navisdk.module.cloudconfig.f.c().c.C) {
            return JarUtils.inflate(context, i, null);
        }
        return JarUtils.inflateStyle(context, i, null);
    }

    public static View a(Context context, int i, ViewGroup viewGroup) {
        if (LogUtil.OUT_LOGGABLE) {
            com.baidu.navisdk.util.common.g.OPEN_SDK.f("BNStyleManager", "isDayNightOff = " + com.baidu.navisdk.module.cloudconfig.f.c().c.C);
        }
        if (com.baidu.navisdk.module.cloudconfig.f.c().c.C) {
            return JarUtils.inflate(context, i, viewGroup);
        }
        return JarUtils.inflateStyle(context, i, viewGroup);
    }

    public static View a(Context context, int i, ViewGroup viewGroup, boolean z) {
        if (com.baidu.navisdk.module.cloudconfig.f.c().c.C) {
            return JarUtils.inflate(context, i, viewGroup, z);
        }
        return JarUtils.inflateStyle(context, i, viewGroup, z);
    }

    public static View a(ViewStub viewStub) {
        if (!com.baidu.navisdk.module.cloudconfig.f.c().c.C) {
            LayoutInflater cloneInContext = LayoutInflater.from(viewStub.getContext()).cloneInContext(viewStub.getContext());
            cloneInContext.setFactory(BNInflaterFactory.getInstance());
            viewStub.setLayoutInflater(cloneInContext);
        }
        return viewStub.inflate();
    }

    public static void a(View view, int i) {
        if (i == 0) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNStyleManager", "setBackground id = 0");
            }
        } else {
            if (com.baidu.navisdk.module.cloudconfig.f.c().c.C) {
                String resourceTypeName = JarUtils.getResources().getResourceTypeName(i);
                if ("color".equals(resourceTypeName)) {
                    view.setBackgroundColor(b(i));
                    return;
                } else {
                    if ("drawable".equals(resourceTypeName)) {
                        view.setBackgroundDrawable(f(i));
                        return;
                    }
                    return;
                }
            }
            BNInflaterFactory.getInstance().setBackground(view, i);
        }
    }

    public static void a(TextView textView, int i) {
        if (i == 0) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNStyleManager", "setTextColor id = 0");
            }
        } else if (com.baidu.navisdk.module.cloudconfig.f.c().c.C) {
            textView.setTextColor(c(i));
        } else {
            BNInflaterFactory.getInstance().setTextColor(textView, i);
        }
    }

    public static void a(TextView textView, int i, int i2, int i3, int i4) {
        if (com.baidu.navisdk.module.cloudconfig.f.c().c.C) {
            textView.setCompoundDrawablesWithIntrinsicBounds(i > 0 ? f(i) : null, i2 > 0 ? f(i2) : null, i3 > 0 ? f(i3) : null, i4 > 0 ? f(i4) : null);
            return;
        }
        BNInflaterFactory.getInstance().setCompoundDrawables(textView, i, i2, i3, i4);
    }

    public static void a(ImageView imageView, int i) {
        if (com.baidu.navisdk.module.cloudconfig.f.c().c.C) {
            imageView.setBackgroundDrawable(f(i));
        } else {
            BNInflaterFactory.getInstance().setImageResource(imageView, i);
        }
    }

    public static void a(View view) {
        if (view == null || com.baidu.navisdk.module.cloudconfig.f.c().c.C) {
            return;
        }
        BNInflaterFactory.getInstance().removeFromCache(view);
    }
}
