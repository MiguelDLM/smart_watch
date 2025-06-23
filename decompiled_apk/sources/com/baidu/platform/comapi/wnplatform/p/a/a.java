package com.baidu.platform.comapi.wnplatform.p.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.mapapi.VersionInfo;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9947a;
    private static final String b;
    private static final String c;
    private static String d;
    private static String e;
    private static AssetManager f;
    private static Resources g;
    private static Resources h;
    private static Resources.Theme i;
    private static Resources.Theme j;
    private static Field k;
    private static Field l;
    private static Field m;
    private static boolean n;
    private static Context o;

    /* renamed from: com.baidu.platform.comapi.wnplatform.p.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0543a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            String str2 = a.f9947a + ".jar";
            if (str.startsWith("BaiduBikeNavi_Resource_v") && !str.endsWith(str2)) {
                return true;
            }
            return false;
        }
    }

    static {
        String apiVersion = VersionInfo.getApiVersion();
        f9947a = apiVersion;
        String str = "BaiduBikeNavi_Resource_v" + apiVersion + ".jar";
        b = str;
        c = "BaiduBikeNavi_Resource_v" + apiVersion + ".png";
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory());
        sb.append("/");
        d = sb.toString();
        e = d + str;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = false;
    }

    public static boolean a(Context context) {
        if (context == null) {
            Log.d("context == null", "context == null");
            return false;
        }
        o = context;
        if (!com.baidu.platform.comapi.bikenavi.a.a.f9539a) {
            return true;
        }
        try {
            boolean b2 = b(context);
            Log.d("tryret", "tryret" + b2);
            return b2;
        } catch (Exception unused) {
            Log.d("catch", "catch");
            return false;
        }
    }

    public static Resources b() {
        if (g == null) {
            g = o.getResources();
        }
        return g;
    }

    private static void d() {
        File[] listFiles = new File(d).listFiles(new C0543a());
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        for (File file : listFiles) {
            file.delete();
        }
    }

    private static Resources.Theme e() {
        if (i == null) {
            if (f == null) {
                f = b(e);
            }
            i = g.newTheme();
            i.applyStyle(a("com.android.internal.R.style.Theme"), true);
        }
        return i;
    }

    private static Field f() {
        try {
            Field declaredField = Class.forName("android.view.ContextThemeWrapper").getDeclaredField("mTheme");
            k = declaredField;
            declaredField.setAccessible(true);
        } catch (Throwable th) {
            com.baidu.platform.comapi.wnplatform.d.a.a("", th.toString());
        }
        return k;
    }

    private static Field g() {
        try {
            Field declaredField = Class.forName("android.app.ContextImpl").getDeclaredField("mResources");
            m = declaredField;
            declaredField.setAccessible(true);
        } catch (Throwable th) {
            com.baidu.platform.comapi.wnplatform.d.a.a("", th.toString());
        }
        return m;
    }

    public static Animation c(Context context, int i2) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                xmlResourceParser = b().getAnimation(i2);
                return a(context, xmlResourceParser);
            } catch (IOException e2) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
                notFoundException.initCause(e2);
                throw notFoundException;
            } catch (XmlPullParserException e3) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
                notFoundException2.initCause(e3);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    public static String b(Context context, int i2) {
        if (n) {
            return b().getString(i2);
        }
        return context.getResources().getString(i2);
    }

    private static void d(Context context) {
        d = context.getFilesDir().getAbsolutePath();
        e = d + "/" + b;
    }

    private static AssetManager b(String str) {
        AssetManager assetManager = null;
        try {
            Class<?> cls = Class.forName("android.content.res.AssetManager");
            AssetManager assetManager2 = (AssetManager) cls.getConstructor(null).newInstance(null);
            try {
                cls.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager2, str);
                return assetManager2;
            } catch (Throwable th) {
                th = th;
                assetManager = assetManager2;
                com.baidu.platform.comapi.wnplatform.d.a.a("", th.toString());
                return assetManager;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a() {
        o = null;
    }

    public static Drawable a(Context context, int i2) {
        if (n) {
            return b().getDrawable(i2);
        }
        return context.getResources().getDrawable(i2);
    }

    public static View a(Activity activity, int i2, ViewGroup viewGroup) {
        if (!n) {
            return LayoutInflater.from(activity).inflate(b().getXml(i2), viewGroup);
        }
        XmlResourceParser xml = g.getXml(i2);
        View view = null;
        try {
            boolean a2 = a(activity);
            view = LayoutInflater.from(activity).inflate(xml, viewGroup);
            if (a2) {
                b(activity);
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                com.baidu.platform.comapi.wnplatform.d.a.a("ResUtils", "inflate", th);
            } finally {
                xml.close();
            }
        }
        return view;
    }

    public static void b(Activity activity) {
        if (h == null) {
            return;
        }
        try {
            m.set(activity.getBaseContext(), h);
            k.set(activity, j);
        } finally {
            try {
            } finally {
            }
        }
    }

    private static boolean c(Context context) {
        d(context);
        try {
            InputStream open = context.getResources().getAssets().open(c);
            File file = new File(e);
            long length = file.length();
            int available = open.available();
            if (file.exists() && length == available) {
                open.close();
                return true;
            }
            d();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(d, b));
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    open.close();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        if (!c(context)) {
            return false;
        }
        n = true;
        AssetManager b2 = b(e);
        f = b2;
        g = a(context, b2);
        return true;
    }

    private static Resources a(Context context, AssetManager assetManager) {
        return new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
    }

    public static int a(String str) {
        try {
            String substring = str.substring(0, str.indexOf(".R.") + 2);
            int lastIndexOf = str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR);
            String substring2 = str.substring(lastIndexOf + 1, str.length());
            String substring3 = str.substring(0, lastIndexOf);
            return Class.forName(substring + "$" + substring3.substring(substring3.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR) + 1, substring3.length())).getDeclaredField(substring2).getInt(null);
        } catch (Throwable th) {
            com.baidu.platform.comapi.wnplatform.d.a.a("", th.toString());
            return -1;
        }
    }

    public static boolean a(Activity activity) {
        if (h != null) {
            return false;
        }
        try {
            if (k == null) {
                k = f();
            }
            if (m == null) {
                m = g();
            }
            if (i == null) {
                i = e();
            }
            Context baseContext = activity.getBaseContext();
            h = (Resources) m.get(baseContext);
            j = (Resources.Theme) k.get(activity);
            m.set(baseContext, g);
            k.set(activity, i);
            return true;
        } catch (Throwable th) {
            com.baidu.platform.comapi.wnplatform.d.a.a("", th.toString());
            return false;
        }
    }

    private static Animation a(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return a(context, xmlPullParser, null, Xml.asAttributeSet(xmlPullParser));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0087, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.view.animation.Animation a(android.content.Context r4, org.xmlpull.v1.XmlPullParser r5, android.view.animation.AnimationSet r6, android.util.AttributeSet r7) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r5.getDepth()
            r1 = 0
        L5:
            int r2 = r5.next()
            r3 = 3
            if (r2 != r3) goto L12
            int r3 = r5.getDepth()
            if (r3 <= r0) goto L87
        L12:
            r3 = 1
            if (r2 == r3) goto L87
            r3 = 2
            if (r2 == r3) goto L19
            goto L5
        L19:
            java.lang.String r1 = r5.getName()
            java.lang.String r2 = "set"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L2e
            android.view.animation.AnimationSet r1 = new android.view.animation.AnimationSet
            r1.<init>(r4, r7)
            a(r4, r5, r1, r7)
            goto L66
        L2e:
            java.lang.String r2 = "alpha"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L3c
            android.view.animation.AlphaAnimation r1 = new android.view.animation.AlphaAnimation
            r1.<init>(r4, r7)
            goto L66
        L3c:
            java.lang.String r2 = "scale"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L4a
            android.view.animation.ScaleAnimation r1 = new android.view.animation.ScaleAnimation
            r1.<init>(r4, r7)
            goto L66
        L4a:
            java.lang.String r2 = "rotate"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L58
            android.view.animation.RotateAnimation r1 = new android.view.animation.RotateAnimation
            r1.<init>(r4, r7)
            goto L66
        L58:
            java.lang.String r2 = "translate"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L6c
            android.view.animation.TranslateAnimation r1 = new android.view.animation.TranslateAnimation
            r1.<init>(r4, r7)
        L66:
            if (r6 == 0) goto L5
            r6.addAnimation(r1)
            goto L5
        L6c:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Unknown animation name: "
            r6.append(r7)
            java.lang.String r5 = r5.getName()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r4.<init>(r5)
            throw r4
        L87:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.wnplatform.p.a.a.a(android.content.Context, org.xmlpull.v1.XmlPullParser, android.view.animation.AnimationSet, android.util.AttributeSet):android.view.animation.Animation");
    }
}
