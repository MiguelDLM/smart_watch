package androidx.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.activity.SystemBarStyle;
import androidx.annotation.VisibleForTesting;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XO0OX.xxIXOIIO(name = "EdgeToEdge")
@XX({"SMAP\nEdgeToEdge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EdgeToEdge.kt\nandroidx/activity/EdgeToEdge\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,343:1\n1#2:344\n*E\n"})
/* loaded from: classes.dex */
public final class EdgeToEdge {

    @OXOo.oOoXoXO
    private static EdgeToEdgeImpl Impl;
    private static final int DefaultLightScrim = Color.argb(230, 255, 255, 255);
    private static final int DefaultDarkScrim = Color.argb(128, 27, 27, 27);

    @XO0OX.xxIXOIIO(name = "enable")
    @XO0OX.xoIox
    public static final void enable(@OXOo.OOXIXo ComponentActivity componentActivity) {
        IIX0o.x0xO0oo(componentActivity, "<this>");
        enable$default(componentActivity, null, null, 3, null);
    }

    public static /* synthetic */ void enable$default(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            systemBarStyle = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, 0, 0, null, 4, null);
        }
        if ((i & 2) != 0) {
            systemBarStyle2 = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, DefaultLightScrim, DefaultDarkScrim, null, 4, null);
        }
        enable(componentActivity, systemBarStyle, systemBarStyle2);
    }

    public static final int getDefaultDarkScrim() {
        return DefaultDarkScrim;
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultDarkScrim$annotations() {
    }

    public static final int getDefaultLightScrim() {
        return DefaultLightScrim;
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultLightScrim$annotations() {
    }

    @XO0OX.xxIXOIIO(name = "enable")
    @XO0OX.xoIox
    public static final void enable(@OXOo.OOXIXo ComponentActivity componentActivity, @OXOo.OOXIXo SystemBarStyle statusBarStyle) {
        IIX0o.x0xO0oo(componentActivity, "<this>");
        IIX0o.x0xO0oo(statusBarStyle, "statusBarStyle");
        enable$default(componentActivity, statusBarStyle, null, 2, null);
    }

    @XO0OX.xxIXOIIO(name = "enable")
    @XO0OX.xoIox
    public static final void enable(@OXOo.OOXIXo ComponentActivity componentActivity, @OXOo.OOXIXo SystemBarStyle statusBarStyle, @OXOo.OOXIXo SystemBarStyle navigationBarStyle) {
        IIX0o.x0xO0oo(componentActivity, "<this>");
        IIX0o.x0xO0oo(statusBarStyle, "statusBarStyle");
        IIX0o.x0xO0oo(navigationBarStyle, "navigationBarStyle");
        View decorView = componentActivity.getWindow().getDecorView();
        IIX0o.oO(decorView, "window.decorView");
        Oox.oOoXoXO<Resources, Boolean> detectDarkMode$activity_release = statusBarStyle.getDetectDarkMode$activity_release();
        Resources resources = decorView.getResources();
        IIX0o.oO(resources, "view.resources");
        boolean booleanValue = detectDarkMode$activity_release.invoke(resources).booleanValue();
        Oox.oOoXoXO<Resources, Boolean> detectDarkMode$activity_release2 = navigationBarStyle.getDetectDarkMode$activity_release();
        Resources resources2 = decorView.getResources();
        IIX0o.oO(resources2, "view.resources");
        boolean booleanValue2 = detectDarkMode$activity_release2.invoke(resources2).booleanValue();
        EdgeToEdgeImpl edgeToEdgeImpl = Impl;
        if (edgeToEdgeImpl == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                edgeToEdgeImpl = new EdgeToEdgeApi30();
            } else if (i >= 29) {
                edgeToEdgeImpl = new EdgeToEdgeApi29();
            } else if (i >= 28) {
                edgeToEdgeImpl = new EdgeToEdgeApi28();
            } else if (i >= 26) {
                edgeToEdgeImpl = new EdgeToEdgeApi26();
            } else if (i >= 23) {
                edgeToEdgeImpl = new EdgeToEdgeApi23();
            } else {
                edgeToEdgeImpl = new EdgeToEdgeApi21();
                Impl = edgeToEdgeImpl;
            }
        }
        Window window = componentActivity.getWindow();
        IIX0o.oO(window, "window");
        edgeToEdgeImpl.setUp(statusBarStyle, navigationBarStyle, window, decorView, booleanValue, booleanValue2);
        Window window2 = componentActivity.getWindow();
        IIX0o.oO(window2, "window");
        edgeToEdgeImpl.adjustLayoutInDisplayCutoutMode(window2);
    }
}
