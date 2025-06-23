package com.baidu.navisdk.pronavi.style;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.view.animation.Animation;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.baidu.navisdk.pronavi.style.d;
import java.util.HashMap;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class e {

    @OOXIXo
    public static final a b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, ? super d> f7828a;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public static /* synthetic */ e a(a aVar, int i, float f, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 8;
            }
            if ((i2 & 2) != 0) {
                f = 1.0f;
            }
            return aVar.a(i, f);
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final e a(int i, float f) {
            return new e(i, f);
        }
    }

    public e(int i, float f) {
        this.f7828a = new HashMap<>(i, f);
    }

    public static /* synthetic */ d.a.C0333a a(e eVar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "RGAllStyleResId";
        }
        return eVar.a(str);
    }

    public static /* synthetic */ e c(e eVar, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "RGTextView";
        }
        return eVar.e(i, str);
    }

    public static /* synthetic */ e d(e eVar, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "RGCommonBgView";
        }
        return eVar.f(i, str);
    }

    @OOXIXo
    public final e b(@ColorRes int i, @OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        this.f7828a.put(key, new d.e(key, i));
        return this;
    }

    @OOXIXo
    public final e e(@ColorRes int i, @OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        this.f7828a.put(key, new d.i(key, i));
        return this;
    }

    @OOXIXo
    public final e f(@DrawableRes int i, @OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        this.f7828a.put(key, new d.C0334d(key, i));
        return this;
    }

    public static /* synthetic */ e b(e eVar, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "RGImgTintColor";
        }
        return eVar.d(i, str);
    }

    @OOXIXo
    public final d.a.C0333a a(@OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        return new d.a.C0333a(key, this.f7828a, this);
    }

    @OOXIXo
    public final e c(@DrawableRes int i, @OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        this.f7828a.put(key, new d.f(key, i));
        return this;
    }

    @OOXIXo
    public final e d(@ColorInt int i, @OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        this.f7828a.put(key, new d.g(key, i, 2));
        return this;
    }

    public static /* synthetic */ e a(e eVar, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "RGBgAlpha";
        }
        return eVar.a(i, str);
    }

    @OOXIXo
    public final e a(@IntRange(from = 0, to = 255) int i, @OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        this.f7828a.put(key, new d.b(key, i, 1));
        return this;
    }

    @OOXIXo
    public final e a(@OOXIXo Animation animation, @OOXIXo String key) {
        IIX0o.x0xO0oo(animation, "animation");
        IIX0o.x0xO0oo(key, "key");
        this.f7828a.put(key, new d.c(key, animation));
        return this;
    }

    @Nullable
    @oOoXoXO
    public final HashMap<String, ? super d> a() {
        if (this.f7828a.isEmpty()) {
            return null;
        }
        return this.f7828a;
    }
}
