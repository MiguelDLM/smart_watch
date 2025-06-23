package com.bestmafen.androidbase.base;

import IIXOxIxOo.I0Io;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.SkinAppCompatDelegateImpl;
import com.bestmafen.androidbase.R;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.util.XoI0Ixx0;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import oIxOXo.oxoX;
import oOXoIIIo.II0XooXoX;

/* loaded from: classes8.dex */
public abstract class BaseActivity extends AppCompatActivity implements com.bestmafen.androidbase.base.oIX0oI {

    @OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    private static int DEFAULT_NAV_BAR_COLOR = 0;
    private static int DEFAULT_TOP_BAR_COLOR = 0;

    @OOXIXo
    public static final String SCREEN_ORIENTATION_PORTRAIT = "screen_orientation_portrait";
    public static final int STYLE_FULL_WITHOUT_STATUS = 2;
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_TRANSLUCENT_STATUS = 1;

    @oOoXoXO
    private String mArg0;

    @oOoXoXO
    private Parcelable mArg2;

    @oOoXoXO
    private Serializable mArg3;
    protected Activity mContext;
    private final int mStatusStyle;
    private final int mTitleId = -1;
    private int mArg1 = -1;

    /* loaded from: classes8.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public final void I0Io(int i) {
            BaseActivity.DEFAULT_NAV_BAR_COLOR = i;
        }

        public final int II0xO0() {
            return BaseActivity.DEFAULT_TOP_BAR_COLOR;
        }

        public final int oIX0oI() {
            return BaseActivity.DEFAULT_NAV_BAR_COLOR;
        }

        public final void oxoX(int i) {
            BaseActivity.DEFAULT_TOP_BAR_COLOR = i;
        }

        public oIX0oI() {
        }
    }

    public final void disableOrientation() {
        int i;
        if (getResources().getConfiguration().orientation == 2) {
            i = 0;
        } else {
            i = 1;
        }
        setRequestedOrientation(i);
    }

    public final void enableOrientation() {
        int i = 1;
        if (!SPUtils.getInstance().getBoolean(SCREEN_ORIENTATION_PORTRAIT, true)) {
            i = -1;
        }
        setRequestedOrientation(i);
    }

    public final int getColor() {
        int i = DEFAULT_TOP_BAR_COLOR;
        if (i != 0) {
            if (i != 1) {
                return R.color.navBarColor;
            }
            return R.color.elie_statusBarColor;
        }
        return R.color.navBarColor;
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    @OOXIXo
    public AppCompatDelegate getDelegate() {
        AppCompatDelegate appCompatDelegate = SkinAppCompatDelegateImpl.get(this, this);
        IIX0o.oO(appCompatDelegate, "get(...)");
        return appCompatDelegate;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @oOoXoXO
    public String getMArg0() {
        return this.mArg0;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int getMArg1() {
        return this.mArg1;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @oOoXoXO
    public Parcelable getMArg2() {
        return this.mArg2;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @oOoXoXO
    public Serializable getMArg3() {
        return this.mArg3;
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

    public int getMStatusStyle() {
        return this.mStatusStyle;
    }

    public int getMTitleId() {
        return this.mTitleId;
    }

    public final int getNavColor() {
        int i = DEFAULT_NAV_BAR_COLOR;
        if (i != 0) {
            if (i != 1) {
                return R.color.statusBarColor;
            }
            return R.color.elie_statusBarColor;
        }
        return R.color.statusBarColor;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return false;
    }

    public final boolean isLightColor(@ColorInt int i) {
        if ((Color.red(i) * 0.299d) + (Color.green(i) * 0.587d) + (Color.blue(i) * 0.114d) >= 127.5d) {
            return true;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getMStatusStyle() == 1) {
            Window window = getWindow();
            window.addFlags(67108864);
            ((ViewGroup) window.getDecorView().findViewById(android.R.id.content)).getChildAt(0).setFitsSystemWindows(false);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@oOoXoXO Bundle bundle) {
        View findViewById;
        super.onCreate(bundle);
        enableOrientation();
        setMContext(this);
        setMArg0(getIntent().getStringExtra("mArg0"));
        setMArg1(getIntent().getIntExtra("mArg1", -1));
        setMArg2(getIntent().getParcelableExtra("mArg2"));
        setMArg3(getIntent().getSerializableExtra("mArg3"));
        if (initEvent()) {
            XO0.II0xO0.oxoX().x0XOIxOo(this);
        }
        init(bundle);
        setTheme();
        setContentView(layoutId());
        if (getMTitleId() != -1 && (findViewById = findViewById(getMTitleId())) != null) {
            II0XooXoX.oIX0oI(findViewById);
        }
        initView();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (initEvent()) {
            XO0.II0xO0.oxoX().IIXOooo(this);
        }
        super.onDestroy();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void setMArg0(@oOoXoXO String str) {
        this.mArg0 = str;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void setMArg1(int i) {
        this.mArg1 = i;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void setMArg2(@oOoXoXO Parcelable parcelable) {
        this.mArg2 = parcelable;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void setMArg3(@oOoXoXO Serializable serializable) {
        this.mArg3 = serializable;
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

    public final void setStatusBarColor(@OOXIXo Activity activity, int i) {
        IIX0o.x0xO0oo(activity, "activity");
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

    public final void setTheme() {
        if (I0Io.IXxxXO() == null) {
            return;
        }
        Log.i(XoI0Ixx0.f24444oO, "" + SPUtils.getInstance().getInt(XoI0Ixx0.f24444oO, 0));
        int i = SPUtils.getInstance().getInt(XoI0Ixx0.f24444oO, 0);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        I0Io.IXxxXO().IIX0o("brown_black", null, 1);
                    }
                } else {
                    I0Io.IXxxXO().IIX0o(ToastUtils.MODE.LIGHT, null, 1);
                }
            } else {
                I0Io.IXxxXO().ooXIXxIX();
            }
        } else if (Build.VERSION.SDK_INT >= 28) {
            if (SPUtils.getInstance().getInt(XoI0Ixx0.f24444oO, 0) == 0) {
                int i2 = getResources().getConfiguration().uiMode & 48;
                if (i2 != 16) {
                    if (i2 == 32) {
                        I0Io.IXxxXO().ooXIXxIX();
                    }
                } else {
                    I0Io.IXxxXO().IIX0o(ToastUtils.MODE.LIGHT, null, 1);
                }
            }
        } else {
            I0Io.IXxxXO().ooXIXxIX();
        }
        setStatusBarColor(this, oxoX.I0Io(getMContext(), getColor()));
        setNavBarColor(this, oxoX.I0Io(getMContext(), getNavColor()));
    }
}
