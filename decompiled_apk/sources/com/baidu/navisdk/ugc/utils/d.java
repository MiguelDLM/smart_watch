package com.baidu.navisdk.ugc.utils;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.navisdk.widget.naviimageloader.b;

/* loaded from: classes8.dex */
public class d {
    public static boolean a(int i, ImageView imageView) {
        Drawable f;
        if (imageView == null || (f = com.baidu.navisdk.ui.util.b.f(com.baidu.navisdk.ugc.report.data.datarepository.c.b(i))) == null) {
            return false;
        }
        imageView.setImageDrawable(f);
        return true;
    }

    public static boolean b(int i, ImageView imageView) {
        Drawable f;
        if (imageView == null || (f = com.baidu.navisdk.ui.util.b.f(com.baidu.navisdk.ugc.report.data.datarepository.c.d(i))) == null) {
            return false;
        }
        imageView.setImageDrawable(f);
        return true;
    }

    public static boolean c(int i, ImageView imageView) {
        Drawable f;
        if (imageView == null || (f = com.baidu.navisdk.ui.util.b.f(com.baidu.navisdk.ugc.report.data.datarepository.c.a(i))) == null) {
            return false;
        }
        imageView.setImageDrawable(f);
        return true;
    }

    private static void a(int i, ImageView imageView, com.baidu.navisdk.widget.naviimageloader.b bVar, com.baidu.navisdk.widget.naviimageloader.e eVar, String str) {
        if (imageView == null) {
            return;
        }
        if (bVar == null) {
            bVar = new b.C0513b().a(com.baidu.navisdk.ugc.report.data.datarepository.c.a(i)).a();
        }
        if (str == null) {
            str = com.baidu.navisdk.ugc.report.data.datarepository.c.e(i);
        }
        if (TextUtils.isEmpty(str)) {
            c(i, imageView);
            if (eVar != null) {
                eVar.a(str, imageView, null, 4);
                return;
            }
            return;
        }
        com.baidu.navisdk.widget.naviimageloader.c.d().a(str, imageView, bVar, eVar);
    }

    public static void a(int i, ImageView imageView, com.baidu.navisdk.widget.naviimageloader.e eVar) {
        a(i, imageView, null, eVar, null);
    }

    public static void a(int i, ImageView imageView, String str) {
        a(i, imageView, null, null, str);
    }
}
