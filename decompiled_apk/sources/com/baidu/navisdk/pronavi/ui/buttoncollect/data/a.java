package com.baidu.navisdk.pronavi.ui.buttoncollect.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private String f7890a;

    @DrawableRes
    private int b;

    @ColorRes
    private int c;
    private int d;
    private boolean e;
    private int f;

    @DrawableRes
    private int g;
    private int h;

    @OOXIXo
    private String i;

    public a(@OOXIXo String tag) {
        IIX0o.x0xO0oo(tag, "tag");
        this.i = tag;
        this.f7890a = "";
        this.c = R.color.nsdk_cl_text_h;
        this.d = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_text_size_new);
        this.e = true;
    }

    public final void a(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.i = str;
    }

    public final void b(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f7890a = str;
    }

    public final void c(int i) {
        this.f = i;
    }

    public final void d(int i) {
        this.c = i;
    }

    @OOXIXo
    public final String e() {
        return this.i;
    }

    public boolean equals(@oOoXoXO Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!IIX0o.Oxx0IOOO(a.class, cls)) {
            return false;
        }
        if (obj != null) {
            a aVar = (a) obj;
            if (IIX0o.Oxx0IOOO(this.i, aVar.i) && IIX0o.Oxx0IOOO(this.f7890a, aVar.f7890a) && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && this.f == aVar.f && this.h == aVar.h) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.navisdk.pronavi.ui.buttoncollect.data.RGBtnData");
    }

    @OOXIXo
    public final String f() {
        return this.f7890a;
    }

    public final int g() {
        return this.c;
    }

    public int hashCode() {
        return (((((((((((((this.i.hashCode() * 31) + this.f7890a.hashCode()) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + Boolean.valueOf(this.e).hashCode()) * 31) + this.f) * 31) + this.h;
    }

    @OOXIXo
    public String toString() {
        return "RGBtnData(tag='" + this.i + "', title='" + this.f7890a + "', iconId=" + this.b + ", titleColor=" + this.c + ", titleSize=" + this.d + ", enable=" + this.e + ", iconTintColor=" + this.h + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.h;
    }

    public final int d() {
        return this.f;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final void b(int i) {
        this.h = i;
    }

    public final int a() {
        int i = this.g;
        return i != 0 ? i : R.drawable.transparent;
    }
}
