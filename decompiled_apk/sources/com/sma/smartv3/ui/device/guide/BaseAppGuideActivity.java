package com.sma.smartv3.ui.device.guide;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.SkinAppCompatDelegateImpl;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.github.appintro.AppIntro;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.XoI0Ixx0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public abstract class BaseAppGuideActivity extends AppIntro {
    private final int layoutId = R.layout.activity_app_guide;
    protected Activity mContext;

    private final void setStatusBarColor(Activity activity, int i) {
        int i2 = Build.VERSION.SDK_INT;
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i);
        if (i2 >= 23) {
            if (isLightColor(i)) {
                window.getDecorView().setSystemUiVisibility(8192);
            } else {
                window.getDecorView().setSystemUiVisibility(0);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    @OOXIXo
    public AppCompatDelegate getDelegate() {
        AppCompatDelegate appCompatDelegate = SkinAppCompatDelegateImpl.get(this, this);
        IIX0o.oO(appCompatDelegate, "get(...)");
        return appCompatDelegate;
    }

    @Override // com.github.appintro.AppIntro, com.github.appintro.AppIntroBase
    public int getLayoutId() {
        return this.layoutId;
    }

    @OOXIXo
    public final Activity getMContext() {
        Activity activity = this.mContext;
        if (activity != null) {
            return activity;
        }
        IIX0o.XOxIOxOx("mContext");
        return null;
    }

    public final boolean isLightColor(@ColorInt int i) {
        if ((Color.red(i) * 0.299d) + (Color.green(i) * 0.587d) + (Color.blue(i) * 0.114d) >= 127.5d) {
            return true;
        }
        return false;
    }

    @Override // com.github.appintro.AppIntroBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@oOoXoXO Bundle bundle) {
        super.onCreate(bundle);
        if (SPUtils.getInstance().getBoolean(BaseActivity.SCREEN_ORIENTATION_PORTRAIT, true)) {
            setRequestedOrientation(1);
        }
        setMContext(this);
        setTheme();
    }

    public final void setMContext(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "<set-?>");
        this.mContext = activity;
    }

    public final void setNavBarColor(@OOXIXo Activity activity, int i) {
        IIX0o.x0xO0oo(activity, "activity");
        BarUtils.setNavBarColor(activity, i);
        if (isLightColor(i)) {
            BarUtils.setNavBarLightMode(activity, true);
        } else {
            BarUtils.setNavBarLightMode(activity, false);
        }
    }

    public final void setSwipe(boolean z) {
        setSwipeLock(!z);
    }

    public final void setTheme() {
        if (IIXOxIxOo.I0Io.IXxxXO() == null) {
            return;
        }
        int i = SPUtils.getInstance().getInt(XoI0Ixx0.f24444oO, 0);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        IIXOxIxOo.I0Io.IXxxXO().IIX0o("brown_black", null, 1);
                    }
                } else {
                    IIXOxIxOo.I0Io.IXxxXO().IIX0o(ToastUtils.MODE.LIGHT, null, 1);
                }
            } else {
                IIXOxIxOo.I0Io.IXxxXO().ooXIXxIX();
            }
        } else if (Build.VERSION.SDK_INT >= 28) {
            if (SPUtils.getInstance().getInt(XoI0Ixx0.f24444oO, 0) == 0) {
                int i2 = getResources().getConfiguration().uiMode & 48;
                if (i2 != 16) {
                    if (i2 == 32) {
                        IIXOxIxOo.I0Io.IXxxXO().ooXIXxIX();
                    }
                } else {
                    IIXOxIxOo.I0Io.IXxxXO().IIX0o(ToastUtils.MODE.LIGHT, null, 1);
                }
            }
        } else {
            IIXOxIxOo.I0Io.IXxxXO().ooXIXxIX();
        }
        setStatusBarColor(this, oIxOXo.oxoX.I0Io(getMContext(), R.color.statusBarColor));
        setNavBarColor(this, oIxOXo.oxoX.I0Io(getMContext(), R.color.navBarColor));
    }
}
