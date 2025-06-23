package com.github.appintro.internal;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import android.content.Context;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes9.dex */
public final class LayoutUtil {

    @OOXIXo
    public static final LayoutUtil INSTANCE = new LayoutUtil();

    private LayoutUtil() {
    }

    @x0XOIxOo
    public static final boolean isRtl(@OOXIXo Context ctx) {
        IIX0o.x0xO0oo(ctx, "ctx");
        if (ctx.getResources().getConfiguration().getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }
}
