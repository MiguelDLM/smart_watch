package com.baidu.navisdk.util.jar;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.GridLayoutAnimationController;
import android.view.animation.Interpolator;
import android.view.animation.LayoutAnimationController;
import com.baidu.navisdk.framework.a;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.style.BNInflaterFactory;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes8.dex */
public class JarUtils {
    private static final String TAG = "JarUtils";
    private static boolean mAsJar = false;
    private static AssetManager selfAsset;
    private static Resources selfDayResources;
    private static Resources selfNightResources;

    private static Animation createAnimationFromXml(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return createAnimationFromXml(context, xmlPullParser, null, Xml.asAttributeSet(xmlPullParser));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x00bb, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.view.animation.Interpolator createInterpolatorFromXml(android.content.Context r4, org.xmlpull.v1.XmlPullParser r5) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r5.getDepth()
            r1 = 0
        L5:
            int r2 = r5.next()
            r3 = 3
            if (r2 != r3) goto L12
            int r3 = r5.getDepth()
            if (r3 <= r0) goto Lbb
        L12:
            r3 = 1
            if (r2 == r3) goto Lbb
            r3 = 2
            if (r2 == r3) goto L19
            goto L5
        L19:
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r5)
            java.lang.String r2 = r5.getName()
            java.lang.String r3 = "linearInterpolator"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L30
            android.view.animation.LinearInterpolator r2 = new android.view.animation.LinearInterpolator
            r2.<init>(r4, r1)
        L2e:
            r1 = r2
            goto L5
        L30:
            java.lang.String r3 = "accelerateInterpolator"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L3e
            android.view.animation.AccelerateInterpolator r2 = new android.view.animation.AccelerateInterpolator
            r2.<init>(r4, r1)
            goto L2e
        L3e:
            java.lang.String r3 = "decelerateInterpolator"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L4c
            android.view.animation.DecelerateInterpolator r2 = new android.view.animation.DecelerateInterpolator
            r2.<init>(r4, r1)
            goto L2e
        L4c:
            java.lang.String r3 = "accelerateDecelerateInterpolator"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L5a
            android.view.animation.AccelerateDecelerateInterpolator r2 = new android.view.animation.AccelerateDecelerateInterpolator
            r2.<init>(r4, r1)
            goto L2e
        L5a:
            java.lang.String r3 = "cycleInterpolator"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L68
            android.view.animation.CycleInterpolator r2 = new android.view.animation.CycleInterpolator
            r2.<init>(r4, r1)
            goto L2e
        L68:
            java.lang.String r3 = "anticipateInterpolator"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L76
            android.view.animation.AnticipateInterpolator r2 = new android.view.animation.AnticipateInterpolator
            r2.<init>(r4, r1)
            goto L2e
        L76:
            java.lang.String r3 = "overshootInterpolator"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L84
            android.view.animation.OvershootInterpolator r2 = new android.view.animation.OvershootInterpolator
            r2.<init>(r4, r1)
            goto L2e
        L84:
            java.lang.String r3 = "anticipateOvershootInterpolator"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L92
            android.view.animation.AnticipateOvershootInterpolator r2 = new android.view.animation.AnticipateOvershootInterpolator
            r2.<init>(r4, r1)
            goto L2e
        L92:
            java.lang.String r3 = "bounceInterpolator"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto La0
            android.view.animation.BounceInterpolator r2 = new android.view.animation.BounceInterpolator
            r2.<init>(r4, r1)
            goto L2e
        La0:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown interpolator name: "
            r0.append(r1)
            java.lang.String r5 = r5.getName()
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r4.<init>(r5)
            throw r4
        Lbb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.jar.JarUtils.createInterpolatorFromXml(android.content.Context, org.xmlpull.v1.XmlPullParser):android.view.animation.Interpolator");
    }

    private static LayoutAnimationController createLayoutAnimationFromXml(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return createLayoutAnimationFromXml(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
    }

    public static boolean getAsJar() {
        return mAsJar;
    }

    public static Resources getNightResources() {
        if (selfNightResources == null && a.c().a() != null) {
            Configuration configuration = new Configuration();
            configuration.uiMode = (configuration.uiMode & (-49)) | 32;
            selfNightResources = a.c().a().createConfigurationContext(configuration).getResources();
        }
        return selfNightResources;
    }

    public static String getPackageName() {
        if (mAsJar) {
            return "com.baidu.navisdk";
        }
        Context a2 = a.c().a();
        if (a2 != null) {
            return a2.getPackageName();
        }
        return "com.baidu.BaiduMap";
    }

    private static LayoutInflater getPreloadLayoutInflater(Context context) {
        return LayoutInflater.from(context).cloneInContext(context.getApplicationContext());
    }

    public static Resources getResources() {
        if (selfDayResources == null && a.c().a() != null) {
            Configuration configuration = new Configuration();
            configuration.uiMode = (configuration.uiMode & (-49)) | 16;
            selfDayResources = a.c().a().createConfigurationContext(configuration).getResources();
        }
        return selfDayResources;
    }

    private static AssetManager getSelfAssets(Context context, String str) {
        AssetManager assetManager;
        Throwable th;
        if (mAsJar) {
            try {
                Class<?> cls = Class.forName("android.content.res.AssetManager");
                assetManager = (AssetManager) cls.getConstructor(null).newInstance(null);
                try {
                    cls.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager, str);
                    return assetManager;
                } catch (Throwable th2) {
                    th = th2;
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("", th.toString());
                        LogUtil.printException(TAG, th);
                        return assetManager;
                    }
                    return assetManager;
                }
            } catch (Throwable th3) {
                assetManager = null;
                th = th3;
            }
        } else {
            return context.getAssets();
        }
    }

    private static Resources getSelfRes(Context context, AssetManager assetManager) {
        if (mAsJar) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setToDefaults();
            return new Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
        }
        return getResources();
    }

    public static View inflate(Context context, int i, ViewGroup viewGroup) {
        return inflate(context, i, viewGroup, viewGroup != null);
    }

    @Deprecated
    public static View inflateStyle(Context context, int i, ViewGroup viewGroup) {
        if (context == null) {
            LogUtil.out(TAG, "context is null");
            if (!LogUtil.LOGGABLE) {
                return null;
            }
            LogUtil.e(TAG, "inflateStyle -> context = null!");
            return null;
        }
        try {
            LayoutInflater cloneInContext = LayoutInflater.from(context).cloneInContext(context);
            cloneInContext.setFactory2(BNInflaterFactory.getInstance());
            View inflate = cloneInContext.inflate(i, viewGroup);
            BNInflaterFactory.getInstance().releaseNullStyle();
            return inflate;
        } catch (Throwable th) {
            LogUtil.out(TAG, th.getMessage());
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("inflateStyle", th);
            }
            return inflate(context, i, viewGroup);
        }
    }

    public static Animation loadAnimation(Context context, int i) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                xmlResourceParser = getResources().getAnimation(i);
                return createAnimationFromXml(context, xmlResourceParser);
            } catch (IOException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            } catch (XmlPullParserException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    public static Interpolator loadInterpolator(Context context, int i) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                xmlResourceParser = getResources().getAnimation(i);
                return createInterpolatorFromXml(context, xmlResourceParser);
            } catch (IOException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            } catch (XmlPullParserException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    public static LayoutAnimationController loadLayoutAnimation(Context context, int i) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                xmlResourceParser = getResources().getAnimation(i);
                return createLayoutAnimationFromXml(context, xmlResourceParser);
            } catch (IOException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            } catch (XmlPullParserException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }

    @Deprecated
    public static View oldInflate(Activity activity, int i, ViewGroup viewGroup) {
        try {
            return LayoutInflater.from(activity).inflate(i, viewGroup);
        } catch (Throwable th) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("", th.toString());
                LogUtil.printException(TAG, th);
            }
            return null;
        }
    }

    public static View preloadInflate(Context context, int i, ViewGroup viewGroup, boolean z) {
        if (context == null) {
            LogUtil.out(TAG, "context is null");
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("inflate", new Throwable("context is null"));
            }
            return null;
        }
        try {
            return getPreloadLayoutInflater(context).inflate(i, viewGroup, z);
        } catch (Throwable th) {
            LogUtil.out(TAG, th.getMessage());
            if (!LogUtil.LOGGABLE) {
                return null;
            }
            LogUtil.printException("inflate", th);
            return null;
        }
    }

    public static boolean setAsJar(Context context, boolean z) {
        mAsJar = z;
        AssetManager selfAssets = getSelfAssets(context, null);
        selfAsset = selfAssets;
        selfDayResources = getSelfRes(context, selfAssets);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0087, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.view.animation.Animation createAnimationFromXml(android.content.Context r4, org.xmlpull.v1.XmlPullParser r5, android.view.animation.AnimationSet r6, android.util.AttributeSet r7) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
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
            createAnimationFromXml(r4, r5, r1, r7)
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.util.jar.JarUtils.createAnimationFromXml(android.content.Context, org.xmlpull.v1.XmlPullParser, android.view.animation.AnimationSet, android.util.AttributeSet):android.view.animation.Animation");
    }

    private static LayoutAnimationController createLayoutAnimationFromXml(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        LayoutAnimationController layoutAnimationController = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if ("layoutAnimation".equals(name)) {
                        layoutAnimationController = new LayoutAnimationController(context, attributeSet);
                    } else if ("gridLayoutAnimation".equals(name)) {
                        layoutAnimationController = new GridLayoutAnimationController(context, attributeSet);
                    } else {
                        throw new RuntimeException("Unknown layout animation name: " + name);
                    }
                }
            }
        }
        return layoutAnimationController;
    }

    public static View inflate(Context context, int i, ViewGroup viewGroup, boolean z) {
        if (context == null) {
            LogUtil.out(TAG, "context is null");
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("inflate", new Throwable("context is null"));
            }
            return null;
        }
        try {
            return LayoutInflater.from(context).inflate(i, viewGroup, z);
        } catch (Throwable th) {
            LogUtil.out(TAG, th.getMessage());
            if (!LogUtil.LOGGABLE) {
                return null;
            }
            LogUtil.printException("inflate", th);
            return null;
        }
    }

    @Deprecated
    public static View inflateStyle(Context context, int i, ViewGroup viewGroup, boolean z) {
        if (context == null) {
            if (!LogUtil.LOGGABLE) {
                return null;
            }
            LogUtil.e(TAG, "inflateStyle -> context = null!");
            return null;
        }
        try {
            LayoutInflater cloneInContext = LayoutInflater.from(context).cloneInContext(context);
            cloneInContext.setFactory2(BNInflaterFactory.getInstance());
            View inflate = cloneInContext.inflate(i, viewGroup, z);
            BNInflaterFactory.getInstance().releaseNullStyle();
            return inflate;
        } catch (Throwable th) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("inflateStyle", th);
            }
            return inflate(context, i, viewGroup);
        }
    }
}
