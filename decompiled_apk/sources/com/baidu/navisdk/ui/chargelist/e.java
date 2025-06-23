package com.baidu.navisdk.ui.chargelist;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    public static final e f8376a = new e();

    private e() {
    }

    @OOXIXo
    public final Resources a(boolean z) {
        if (z) {
            Resources a2 = com.baidu.navisdk.ui.util.b.a(com.baidu.navisdk.ui.util.b.b());
            IIX0o.oO(a2, "BNStyleManager.getResour…yleManager.getDayStyle())");
            return a2;
        }
        Resources a3 = com.baidu.navisdk.ui.util.b.a(true);
        IIX0o.oO(a3, "BNStyleManager.getResources(true)");
        return a3;
    }

    @oOoXoXO
    public final Drawable b(boolean z, int i) {
        return ResourcesCompat.getDrawable(a(z), i, null);
    }

    @oOoXoXO
    public final Integer a(boolean z, int i) {
        return Integer.valueOf(ResourcesCompat.getColor(a(z), i, null));
    }

    public final void a(@OOXIXo View view, boolean z, int i) {
        IIX0o.x0xO0oo(view, "view");
        view.setBackground(b(z, i));
    }

    public final void a(@OOXIXo TextView view, boolean z, int i) {
        IIX0o.x0xO0oo(view, "view");
        Integer a2 = a(z, i);
        if (a2 != null) {
            view.setTextColor(a2.intValue());
        }
    }
}
