package com.baidu.navisdk.module.routeresultbase.logic.longdistance;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.baidu.baidunavis.maplayer.e;
import com.baidu.baidunavis.maplayer.g;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.MeteorBubbleView;
import com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.CarPassWeatherView;
import com.baidu.navisdk.ui.util.j;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;

/* loaded from: classes7.dex */
public class c {
    public static float a(int i, boolean z) {
        if (i == 1) {
            return z ? 0.97f : 0.91f;
        }
        if (i == 2) {
            return z ? 0.96f : 0.95f;
        }
        if (i != 4) {
            return 0.0f;
        }
        return z ? 0.49f : 1.0f;
    }

    public static float b(int i, boolean z) {
        return i != 1 ? i != 2 ? i != 4 ? 0.0f : 1.0f : z ? 0.92f : 0.85f : z ? 0.97f : 0.87f;
    }

    public static float c(int i, boolean z) {
        return i != 1 ? i != 2 ? (i == 4 && z) ? 0.49f : 0.0f : z ? 0.04f : 0.05f : z ? 0.03f : 0.09f;
    }

    public static float d(int i, boolean z) {
        return i != 1 ? i != 2 ? i != 4 ? 0.0f : 1.0f : z ? 0.92f : 0.85f : z ? 0.97f : 0.87f;
    }

    public static g a(View view, com.baidu.nplatform.comapi.basestruct.c cVar, boolean z, float f, float f2) {
        Bundle bundle;
        if (view != null && cVar != null) {
            com.baidu.nplatform.comapi.basestruct.c a2 = e.k().a(cVar);
            com.baidu.nplatform.comapi.basestruct.c a3 = e.k().a(a2.c(), a2.d());
            String str = cVar.d() + "," + cVar.c();
            if (a3 == null) {
                return null;
            }
            g gVar = new g(a3, str, "");
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache = view.getDrawingCache();
            if (view instanceof com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.b) {
                com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.b bVar = (com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.b) view;
                bVar.a();
                bundle = bVar.a(z);
            } else if (view instanceof com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.c) {
                bundle = ((com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.c) view).b(z);
            } else if (view instanceof com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.e) {
                com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.e eVar = (com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.e) view;
                gVar.a(eVar.getLeftBundel());
                bundle = eVar.getContentSizeBundle();
            } else if (view instanceof CarPassWeatherView) {
                bundle = ((CarPassWeatherView) view).a(z);
            } else if (view instanceof MeteorBubbleView) {
                bundle = ((MeteorBubbleView) view).a(z);
            } else if (view instanceof com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.a) {
                com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.a aVar = (com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.a) view;
                gVar.a(aVar.getLeftBundel());
                bundle = aVar.getContentSizeBundle();
            } else {
                bundle = null;
            }
            gVar.a(bundle);
            gVar.b(!z ? 1 : 0);
            if (drawingCache != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(drawingCache);
                view.setDrawingCacheEnabled(false);
                gVar.a((Drawable) bitmapDrawable);
                gVar.a(f, f2);
                return gVar;
            }
        }
        return null;
    }

    private static Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt("l", 0);
        bundle.putInt("r", 18);
        bundle.putInt("t", 0);
        bundle.putInt("b", 26);
        return bundle;
    }

    public static String c(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("约");
        if (j >= 3600) {
            stringBuffer.append(j / 3600);
            stringBuffer.append("小时");
        }
        long j2 = j - ((j / 3600) * 3600);
        if (j2 >= 60) {
            stringBuffer.append(j2 / 60);
            stringBuffer.append("分钟");
        } else {
            stringBuffer.append("1分钟");
        }
        stringBuffer.append("到达");
        return stringBuffer.toString();
    }

    public static String d(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("约");
        if (j >= 3600) {
            stringBuffer.append(j / 3600);
            stringBuffer.append("小时");
        }
        long j2 = j - ((j / 3600) * 3600);
        if (j2 >= 60) {
            stringBuffer.append(j2 / 60);
            stringBuffer.append("分钟");
        } else {
            stringBuffer.append("1分钟");
        }
        return stringBuffer.toString();
    }

    public static String b(long j) {
        if (j >= 1000) {
            return (j / 1000) + "公里";
        }
        return j + "米";
    }

    public static String b(String str, boolean z) {
        int length;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!z || (length = str.length()) <= 6) {
            return str;
        }
        if (length > 6 && length <= 8) {
            return str.substring(0, length - 2);
        }
        StringBuffer stringBuffer = new StringBuffer(str.substring(0, 6));
        stringBuffer.append("...");
        return stringBuffer.toString();
    }

    public static String d(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("");
        return (split == null || split.length != 2 || (str2 = split[0]) == null || split[1] == null || !str2.trim().equals(split[1].trim())) ? str : split[0];
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.length() < 8) {
            return str;
        }
        return str.substring(0, 8) + "...";
    }

    public static com.baidu.nplatform.comapi.basestruct.c b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length != 2) {
            return null;
        }
        try {
            return new com.baidu.nplatform.comapi.basestruct.c(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt("l", 0);
        bundle.putInt("r", 0);
        bundle.putInt("t", 0);
        bundle.putInt("b", 0);
        return bundle;
    }

    public static g a(com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.d dVar, com.baidu.nplatform.comapi.basestruct.c cVar) {
        if (dVar != null && cVar != null) {
            com.baidu.nplatform.comapi.basestruct.c a2 = e.k().a(cVar);
            com.baidu.nplatform.comapi.basestruct.c a3 = e.k().a(a2.c(), a2.d());
            if (a3 == null) {
                return null;
            }
            g gVar = new g(a3, cVar.d() + "," + cVar.c(), "");
            dVar.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            dVar.layout(0, 0, dVar.getMeasuredWidth(), dVar.getMeasuredHeight());
            dVar.buildDrawingCache();
            Bitmap drawingCache = dVar.getDrawingCache();
            gVar.a(dVar.getContentSizeBundle());
            gVar.b(0);
            if (drawingCache != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(drawingCache);
                dVar.setDrawingCacheEnabled(false);
                gVar.a((Drawable) bitmapDrawable);
                gVar.a(0.17f, 1.0f);
                return gVar;
            }
        }
        return null;
    }

    public static g a(com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.d dVar, com.baidu.nplatform.comapi.basestruct.c cVar, boolean z) {
        Bitmap drawingCache;
        if (dVar != null && cVar != null) {
            com.baidu.nplatform.comapi.basestruct.c a2 = e.k().a(cVar);
            com.baidu.nplatform.comapi.basestruct.c a3 = e.k().a(a2.c(), a2.d());
            if (a3 == null) {
                return null;
            }
            g gVar = new g(a3, cVar.d() + "," + cVar.c(), NotificationCompat.CATEGORY_SERVICE);
            dVar.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            dVar.layout(0, 0, dVar.getMeasuredWidth(), dVar.getMeasuredHeight());
            gVar.a(dVar.getContentSizeBundle());
            gVar.b(1);
            if (z) {
                drawingCache = Bitmap.createBitmap(dVar.getMeasuredWidth(), dVar.getMeasuredHeight(), Bitmap.Config.ALPHA_8);
            } else {
                dVar.buildDrawingCache();
                drawingCache = dVar.getDrawingCache();
            }
            if (drawingCache != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(drawingCache);
                dVar.setDrawingCacheEnabled(false);
                gVar.a((Drawable) bitmapDrawable);
                gVar.a(0.18f, 1.0f);
                return gVar;
            }
        }
        return null;
    }

    public static g a(int i, com.baidu.nplatform.comapi.basestruct.c cVar) {
        String str;
        if (cVar == null) {
            return null;
        }
        com.baidu.nplatform.comapi.basestruct.c a2 = e.k().a(cVar);
        com.baidu.nplatform.comapi.basestruct.c a3 = e.k().a(a2.c(), a2.d());
        if (i == 3) {
            str = cVar.d() + "," + cVar.c();
        } else if (i == 5) {
            str = cVar.d() + "," + cVar.c();
        } else {
            str = "";
        }
        if (a3 == null) {
            return null;
        }
        g gVar = new g(a3, str, NotificationCompat.CATEGORY_SERVICE);
        if (i == 1) {
            gVar.a(0.5f, 0.5f);
            gVar.a(j.a(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_rr_pass_city_dot), 1.0f));
            gVar.a(a());
            return gVar;
        }
        if (i == 2) {
            gVar.a(0.5f, 0.5f);
            gVar.a(j.a(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_rr_navi_road_dot), 1.0f));
            gVar.a(a());
            return gVar;
        }
        if (i == 3) {
            gVar.a(0.5f, 1.0f);
            gVar.a(j.a(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_rr_service_dot_bg), 1.0f));
            gVar.a(b());
            return gVar;
        }
        if (i != 5) {
            return null;
        }
        gVar.a(0.5f, 1.0f);
        gVar.a(j.a(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_rr_checkpoint_dot_bg), 1.0f));
        gVar.a(b());
        return gVar;
    }

    public static String a(long j) {
        if (j >= 1000) {
            return (j / 1000) + "km";
        }
        return j + "m";
    }

    public static String a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!z || str.length() <= 6) {
            return str;
        }
        return new StringBuffer(str.substring(0, 6) + "...").toString();
    }

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(HelpFormatter.DEFAULT_OPT_PREFIX);
        return (split == null || split.length != 2 || (str2 = split[0]) == null || split[1] == null || !str2.trim().equals(split[1].trim())) ? str : split[0];
    }

    public static com.baidu.nplatform.comapi.basestruct.c a(com.baidu.baidunavis.maplayer.d dVar) {
        if (dVar == null) {
            return null;
        }
        return b(dVar.b());
    }
}
